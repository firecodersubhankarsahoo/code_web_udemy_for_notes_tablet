public class _7_first_occerance_of_an_elements_in_an_array {
    public static int findIdx(int[]arr,int tar,int i){
        if(i==arr.length-1){
            return -1;
        }
        if(tar==arr[i]){
            return i;
        }
      return   findIdx(arr,tar,i+1);
    }
    public static void main(String[] args) {
        int[]arr={1,3,2,4,5,6,9,4};
        int target=4;
        int st=0;
        System.out.println(findIdx(arr,target,st));
    }
}
