public class _3_factorial_of_a_number {
    public static int fact(int n){
        if(n==0){
            return 1;
        }
        int trackno=fact(n-1);
        int factorial=trackno*n;
        return factorial;
    }
    public static void main(String[] args) {
        int n=5;
        System.out.println(fact(n));

    }
}
