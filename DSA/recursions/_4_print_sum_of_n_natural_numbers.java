public class _4_print_sum_of_n_natural_numbers {
    public static int print(int n){
        if(n==1){
            return 1;
        }
        int num=print(n-1);
         int sum=num+n;
         return sum;
    }
    public static void main(String[] args) {
        int n=10;
        System.out.println( print(n));
    }
}
