public class LinearSearch {
    public static void main(String args[]) {
        int[] arrayVar = { -22, -15, 1, 7, 20, 35, 55};
        System.out.println("The location of -15 is: " +findValue(arrayVar, -15));
        System.out.println("The location of 55 is: " +findValue(arrayVar, 55));
        System.out.println("The location of 5555 is: " +findValue(arrayVar, 5555));
        System.out.println("The location of -22 is: " +findValue(arrayVar, -22));
    }

    public static int findValue(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
