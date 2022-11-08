package algorithm;

public class MinMax {
    public static void main(String[] args) {
        int[] inputs = {10, 55, 23, 2, 79, 101, 16, 82, 30, 45};
        int minPos, maxPos;
        int min = inputs[0];
        int max = inputs[0];
        int inputLength = inputs.length;

        for (int i = 0; i < inputLength; i++) {
            if (min > inputs[i]) {
                min = inputs[i];
                minPos = i;
            }
            if (max < inputs[i]) {
                max = inputs[i];
                maxPos = i;
            }
        }

        System.out.println("Min : " + min + ", Max : " + max);
    }
}
