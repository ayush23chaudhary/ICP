package Day_2;

import java.util.Arrays;

public class merge_sorted_array {
    public static void main(String[] args) {
//        Approach 1: insert arr2 in arr1 through index m+i and return the sorted array arr1
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3, n = 3;
        int[] nums2 = {2,5,6};
        for(int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);

//        Approach 2: 
    }
}
