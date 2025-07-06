public class _2_print_numbers_in_increasing_order {
    public static void print(int n){
        if(n==0){
            return;
        }
        print(n-1);
        System.out.println(n+"  ");
    }
    public static void main(String[] args) {
        int n=10;
        print(n);
    }
}
