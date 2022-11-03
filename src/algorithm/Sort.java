package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Sort {

    private static int ASD = 1;
    private static int DESC = -1;

    public static void selectionSort(int[] inputs, int order) {
        int temp;
        int i, j;
        int inputsCount = inputs.length;
        int[] result;

        for (i = 0; i < inputsCount; i++) {
            temp = inputs[i];
            for (j = i + 1; j < inputsCount; j++) {
                if (temp > inputs[j]) {
                    temp = inputs[j];
                    inputs[j] = inputs[i];
                    inputs[i] = temp;
                }
            }
        }

        result = inputs;
        if (order == -1) {
            result = IntStream.of(inputs).boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(v -> v)
                    .toArray();
        }
        System.out.println(Arrays.toString(result));
    }

    public static void bubbleSort(int[] inputs) {
        int temp;
        int i, j;
        int inputsCount = inputs.length;

        for (i = 0; i < inputsCount - i; i++) {
            temp = inputs[0];
            for (j = 1; j < inputsCount - i; j++) {
                if (temp > inputs[j]) {
                    temp = inputs[j];
                    inputs[j] = inputs[i];
                    inputs[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(inputs));
    }

    public static void insertSelection(int[] inputs) {
        int temp;
        int i, j;
        int inputsCount = inputs.length;

        for (i = 1; i < inputsCount; i++) {
            temp = inputs[i];
            for (j = i - 1; j > -1; j--) {
                if (temp < inputs[j]) {
                    temp = inputs[j];
                    inputs[j] = inputs[i];
                    inputs[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(inputs));
    }

    public static void main(String[] args) {

        int[] inputs = {100, 398, 23, 48, 2, 2, 10, 321, 103, 14, 800, 1};

        selectionSort(inputs, DESC);
        bubbleSort(inputs);
        insertSelection(inputs);
    }
}
