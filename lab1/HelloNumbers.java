public class HelloNumbers {
    public static void main(String[] args) {
        int index = 0;
        int sum = 0;
        while (index < 10) {
            System.out.print(sum + " ");
            index = index + 1;
            sum += index;
        }
    }
}