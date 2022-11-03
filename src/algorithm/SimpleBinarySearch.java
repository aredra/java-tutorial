package algorithm;

public class SimpleBinarySearch {
    public static void main(String[] args) {
        int[] inputs = {12, 25, 31, 48, 54, 66, 70, 83, 95, 100};

        int target = 88;
        int left = 0;
        int right = inputs.length - 1;
        int mid = (left + right) / 2;
        boolean isFind = false;
        System.out.println(mid);
        while (left <= right) {
            if (target == inputs[mid]) {
                isFind = true;
                break;
            }
            else if (target > inputs[mid]) {
                left = mid + 1;
            }
            else if (target < inputs[mid]) {
                right = mid - 1;
            } else {
                break;
            }
            mid = (left + right) / 2;
        }


        System.out.println(isFind ? "" + mid : "404");
    }
}
