import java.util.*;

public class tapping_rain_water {

    public static int water(int[] barHeight){
        int n=barHeight.length;


        int[] leftMax=new  int[n];
        //calculate left max of a bar
        leftMax[0]=barHeight[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],barHeight[i]);
        }

//   calculate right max of a bar
        int [] rightMax=new int[n];
        rightMax[n-1]=barHeight[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],barHeight[i]);
        }

// calculate trapped water
        int trapperdWater=0;
        for(int i=0;i<n;i++){
            int waterLevel= Math.min(rightMax[i],leftMax[i]);
            int waterHight=waterLevel-barHeight[i];
            int waterarea=waterHight*1;  // 1 is the width of water
            trapperdWater+=waterarea;
        }
            return  trapperdWater;

    }

    public static void main(String[] args) {
        int[] height={4,2,0,6,3,2,5};

        System.out.println("total trapped water = "+water(height));
    }
}
