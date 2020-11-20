public class SimpleNumber {
    public static void main(String[] args) {
        int a = 20, b = 101;
        for (int t = a; t < b; t++) {
            if (t % 2 != 0 && t % 3 != 0 && t % 5 != 0 && t % 7 != 0) {
                System.out.println(t + " - простое");
            }
        }
    }
}