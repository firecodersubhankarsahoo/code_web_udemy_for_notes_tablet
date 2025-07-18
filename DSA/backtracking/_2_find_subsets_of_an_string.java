import java.util.*;

public class _2_find_subsets_of_an_string {
    public static void subset(String str,String ans,int idx){
        if(idx==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else {
                System.out.println(ans);
            }
                return;
        }
        //for yes
        subset(str,ans+str.charAt(idx),idx+1);
        //no choice
        subset(str,ans,idx+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str="abc";
        subset(str,"",0);

    }
}
