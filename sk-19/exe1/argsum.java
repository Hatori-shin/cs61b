public class argsum {
    public static void main(String[] args) {
        int N = args.length;
        int sum = 0;
        for (int i = 0; i < N; i++){
            int index = Integer.parseInt(args[i]);
            sum += index;
        }
        System.out.println(sum);
    }

}