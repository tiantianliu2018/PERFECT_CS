/*
 * Scala (https://www.scala-lang.org)
 *
 * Copyright EPFL and Lightbend, Inc.
 *
 * Licensed under Apache License 2.0
 * (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package scala.tools.testkit

import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import AssertUtil.{assertThrown, assertThrows}

@RunWith(classOf[JUnit4])
class AssertThrowsTest {
  class Foo extends Exception
  class SubFoo extends Foo
  class Bar extends Exception

  @Test
  def catchFoo = assertThrows[Foo] { throw new Foo }

  @Test
  def catchSubclass = assertThrows[Foo] { throw new SubFoo }

  @Test
  def rethrowBar =
    assertTrue("exception wasn't rethrown", {
      try {
        assertThrows[Foo] { throw new Bar }
        false
      } catch {
        case bar: Bar => true
        case e: Throwable => fail(s"expected Bar but got $e"); false
      }
    })

  @Test
  def errorIfNoThrow: Unit = {
    try {
      assertThrows[Foo] { () }
    } catch {
      case e: AssertionError => return
    }
    fail("assertThrows should error if the tested expression does not throw anything")
  }

  @Test
  def helpful(): Unit =
    try {
      assertThrown[Foo]((foo: Foo) => false)(throw new Foo)
    } catch {
      case ae: AssertionError =>
        assertEquals(1, ae.getSuppressed.length)
        assertEquals("Exception failed check: scala.tools.testkit.AssertThrowsTest$Foo", ae.getMessage)
        assertEquals(classOf[Foo], ae.getSuppressed.head.getClass)
      case t: Throwable => fail("Expected an AssertionError: $t")
    }

  @Test
  def discriminating(): Unit =
    try {
      assertThrown[Foo]((foo: Foo) => true)(throw new Bar)
    } catch {
      case ae: AssertionError =>
        assertEquals(1, ae.getSuppressed.length)
        assertEquals("Exception not a scala.tools.testkit.AssertThrowsTest$Foo: scala.tools.testkit.AssertThrowsTest$Bar", ae.getMessage)
        assertEquals(classOf[Bar], ae.getSuppressed.head.getClass)
      case t: Throwable => fail("Expected an AssertionError: $t")
    }
}
