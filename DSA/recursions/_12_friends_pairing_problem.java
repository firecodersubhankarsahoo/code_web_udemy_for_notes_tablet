import java.util.*;

/*Given n friends, each one can remain single or can be paired up with some other friend.
Each friend can be paired only once.
Find out the total number of ways in which friends can remain single or can be paired up.

so there are two choices for each friend:
1. The friend can remain single.
2. The friend can pair up with any of the remaining n-1 friends.

*/

public class _12_friends_pairing_problem {
    public static int pairing(int n){
        if(n==1|| n==2){
            return n;
        }
        int ways_for_single= pairing(n - 1);

        int ways_or_pairing=(n-1)*pairing(n-2);
        int ways=ways_for_single+ways_or_pairing;
        return ways;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(pairing(n));
    }
}
