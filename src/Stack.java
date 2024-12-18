public class Stack {
    private int[] stackArray;
    private int top;
    private int capacity;

    public Stack(int size) {
        capacity = size;
        stackArray = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack overflow! Cannot push " + value);
            return;
        }
        stackArray[++top] = value;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow! Cannot pop");
            return;
        }
        top--;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot peek");
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public int size() {
        return top + 1;
    }

}