public class fib2 {
/** 我的答案 */
//    public static int fib2(int n, int k, int f0, int f1) {
//        if (n == 1){
//            return 0;
//        }else if (n == 2){
//            return 1;
//        }else{
//            return fib(n - 1) + fib(n - 2);
//        }
//    }

    public static int fib2(int n, int k, int f0, int f1) {
        if (n == k) {
             return f0;
        } else {
            return fib2(n, k + 1, f1, f0 + f1);
        }
    }
    public static void main(String[] args) {
        int a = fib2(1);
        int b = fib2(2);
        int c = fib2(3);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}