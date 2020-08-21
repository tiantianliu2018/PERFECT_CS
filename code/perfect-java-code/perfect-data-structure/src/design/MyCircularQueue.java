package design;

import java.util.Arrays;
import java.util.Objects;

public class MyCircularQueue<T> {
    private final static int DEFAULT_SIZE = 1024;
    private Object[] buffer;
    private int head;
    private int tail;
    private int bufferSize;

    public MyCircularQueue() {
        this.bufferSize = DEFAULT_SIZE;
        this.buffer = new Object[bufferSize];
    }

    public MyCircularQueue(int initSize) {
        this.bufferSize = initSize;
        this.buffer = new Object[bufferSize];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean ifFull() {
        return (tail + 1) % bufferSize == head;
    }

    public void clear() {
        Arrays.fill(buffer, null);
        this.head = 0;
        this.tail = 0;
    }

    public boolean put(String v) {
        if (ifFull()) return false;
        buffer[tail] = v;
        tail = (tail + 1) % bufferSize;
        return true;
    }
    public Object get() {
        if (isEmpty()) {
            return null;
        }
        Object result = buffer[head];
        head = (head + 1) % bufferSize;
        return result;
    }
    public Object[] getAll() {
        if (isEmpty()) {
            return new Object[0];
        }
        int copyTail = tail;
        int cnt = head < copyTail ? copyTail - head : bufferSize;
        Object[] result = new String[cnt];
        if (head < copyTail) {
            for (int i = head; i < copyTail; i++) {
                result[i - head] = buffer[i];
            }
        } else {
            for (int i = head; i < bufferSize; i++) {
                result[i - head] = buffer[i];
            }
            for (int i = 0; i < copyTail; i++) {
                result[bufferSize - head  + i] = buffer[i];
            }
        }
        head = copyTail;
        return result;
    }
}
