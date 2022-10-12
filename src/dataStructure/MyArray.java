package dataStructure;

public class MyArray {

    int[] intArr;
    int count;

    public int ARRAY_SIZE;
    public static final int ERROR_NUM = -999999999;

    public MyArray() {
        count = 0;
        ARRAY_SIZE = 10;
        intArr = new int[ARRAY_SIZE];
    }

    public MyArray(int size) {
        count = 0;
        ARRAY_SIZE = size;
        intArr = new int[ARRAY_SIZE];
    }

    public void addElement(int num) {
        if (count >= ARRAY_SIZE) {
            System.out.println("Not enough memory");
            return;
        }
        intArr[count++] = num;
    }

    public void insertElement(int position, int num) {
        if (position < 0 || position > count) {
            System.out.println("Invalid position");
            return;
        }
        if (count >= ARRAY_SIZE) {
            System.out.println("Not enough memory");
            return;
        }

        for (int index = count - 1; index >= position; index--) {
            intArr[index+1] = intArr[index];
        }
        intArr[position] = num;
        count++;
    }

    public int removeElement(int position) {
        int ret = ERROR_NUM;

        if (!isValid(position)) {
            return ret;
        }

        ret = intArr[position];

        for (int index = position; index < count - 1; index++) {
            intArr[index] = intArr[index + 1];
        }
        count--;
        return ret;
    }

    public int getElement(int position) {
        int ret = ERROR_NUM;

        if (!isValid(position)) {
            return ret;
        }

        ret = intArr[position];
        return ret;
    }

    public int getSize() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isValid(int position) {
        if (isEmpty()) {
            System.out.println("Array is empty");
            return false;
        }
        if (position < 0 || position > count - 1) {
            System.out.println("Invalid position");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < count; index++) {
            builder.append(index == 0 ? intArr[index] : ", " + intArr[index]);
        }
        return builder.toString();
    }
}
