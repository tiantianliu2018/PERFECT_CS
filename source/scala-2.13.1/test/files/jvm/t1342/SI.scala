class SI extends JI {
   def varArgsMethod( args : String*): Unit = {
        for( arg <- args ) println( arg )
   }
}

object Test extends App {
  val x: JI = new SI
  x.varArgsMethod("one", "two")
}
