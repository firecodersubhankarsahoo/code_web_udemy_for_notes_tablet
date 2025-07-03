import java.util.*;

public class print_number_in_decreasing_order {

    public static void print(int n){
        if(n==0){
            return;
        }
        System.out.println(n+" ");
        print(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        print(n);


    }
}
