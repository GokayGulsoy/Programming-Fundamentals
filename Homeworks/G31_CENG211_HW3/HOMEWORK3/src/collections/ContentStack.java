package collections;

import java.util.Arrays;

/**
 *
 * @author Gökay Gülsoy
 */
public class ContentStack<T> implements StackInterface<T> {

    private T[] stack;
    private int topIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ContentStack() {
        this(DEFAULT_CAPACITY);
    }

    public ContentStack(int initialCapacity) {
        checkCapacity(initialCapacity);

        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        initialized = true;
    }

    public void push(T newEntry) {
        checkInitialization();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }

    public T peek() {
        checkInitialization();
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack[topIndex];
        }
    }

    public T pop() {
        checkInitialization();

        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }

    }

    public boolean isEmpty() {
        return (topIndex == -1);
    }

    private void ensureCapacity() {
        if (topIndex == stack.length - 1) {
            int newLength = 2 * stack.length;
            stack = Arrays.copyOf(stack, newLength);
        }
    }

    public void clear() {
        for (int i = 0; i < topIndex + 1; i++) {
            stack[i] = null;
        }

        topIndex = -1;
    }

    private void checkInitialization() {
        if (!initialized) {
            throw new EmptyStackException();
        }
    }

    private void checkCapacity(int initialCapacity) {

        if (!(initialCapacity > 0 && initialCapacity <= MAX_CAPACITY)) {
            throw new EmptyStackException();
        }
    }

}
