public class _5_nth_fibonachi_number {
    public static int fibo(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int fibn1=fibo(n-1);   //f(n-1)
        int fibn2=fibo(n-2);   //f(n-2)
        int fibsum=fibn1+fibn2;
        return fibsum;
    }
    public static void main(String[] args) {
    int n=50;
        System.out.println(fibo(n));
    }
}
