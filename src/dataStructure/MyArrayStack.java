package dataStructure;

public class MyArrayStack {

    MyArray arrayStack;
    int top;

    public MyArrayStack() {
        this.top = 0;
        this.arrayStack = new MyArray();
    }

    public MyArrayStack(int size) {
        this.top = 0;
        arrayStack = new MyArray(size);
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        this.arrayStack.addElement(data);
        this.top++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return MyArray.ERROR_NUM;
        }
        return this.arrayStack.removeElement(--this.top);
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return MyArray.ERROR_NUM;
        }

        return this.arrayStack.getElement(--this.top);
    }

    public boolean isFull() {
        return this.top == this.arrayStack.ARRAY_SIZE;
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    @Override
    public String toString() {
        return this.arrayStack.toString();
    }
}
