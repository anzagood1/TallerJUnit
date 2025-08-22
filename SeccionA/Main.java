public class Main {
    public static int findMax(int[] arr) {
        if (arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        int maxVal = arr[0];
      
        for (int num : arr) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        return maxVal;
    }
}
