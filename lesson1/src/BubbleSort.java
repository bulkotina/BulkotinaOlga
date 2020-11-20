import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{89, 7, 65, 48, 32, 11, 8, 13, 1, 97, 54};
        boolean flag = false;
        int var;
        while (!flag) {
            flag = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    var = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = var;
                    flag = false;
                }
            }
        }
        System.out.print(Arrays.toString(arr));
    }
}


