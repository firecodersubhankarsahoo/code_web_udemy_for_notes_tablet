package Questions;

import java.util.*;
public class _4_union_and_intersection_of_two_arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[]arr1={7,3,9};
        int[]arr2={6,3,9,2,9,4};



        // union of arr1 & arr2
        HashSet<Integer>set=new HashSet<>();     //as set only stores the distinct element(do not store the duplicate element)  so store the elements of both arrays in set and we get the union of both arrays
        for(int x:arr1){
            set.add(x);
        }
        for (int x:arr2) {
            set.add(x);
        }
        System.out.println("the no of elements in the union of arr1 and arr2 is = "+set.size());
        for(int unique:set){
            System.out.print(unique+" ");
        }



        // intersection of arr1 and arr2
        int count=0;
        HashSet<Integer>set1=new HashSet<>();  // to store the elements of arr1
        for(int i=0;i<arr1.length;i++){
            set1.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){        // to check the elements of arr2 in set1
            if(set1.contains(arr2[i])){
                System.out.print(arr2[i]+" ");
                count++;
            }
        }
        System.out.println("\nthe no of elements in the intersection of arr1 and arr2 is = "+count);


    }
}

















/* ----->>>> Steps for Union>>>>

                1. Create an empty HashSet → because a set stores only unique elements.

                2. Insert all elements of arr1 into the set.

                3. Insert all elements of arr2 into the set.

                4. Now the set contains only distinct elements from both arrays → this is the union.

                5. Print the size of the set (number of elements in the union).

                6. Print the elements of the set (union values).


---->>>Steps for Intersection>>>>>

                Create a new empty HashSet (set1).

                Add all elements of arr1 into set1.

                Traverse arr2 one by one.

                For each element of arr2, check if it exists in set1.

                If yes → print it (because it is part of the intersection).

                Increment the count (number of intersection elements).

                After the loop ends, print the count of intersection elements.*/