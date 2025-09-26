package Day_1;

public class sliding_window_maximum {
    public static void main(String[] args) {
        int[] nums= {1,3,-1,-3,5,3,6,7};
        int t=3;
        int [] arr= new int[nums.length-t+1];

//        Brute force approach 

        int idx=0;
        int lo=0, hi=t-1;
        int max= Integer.MIN_VALUE;
        for(int k=lo;k<=hi;k++){
            if(arr[k]>max){
                max=arr[k];
            }
        }
        arr[idx]=max;
        idx++;
        lo++;
        hi++;
        while(hi<=nums.length-1){
            if(nums[hi]>max){
                arr[idx]= nums[hi];
                max= nums[hi];
            }
            else{
                arr[idx]=max;
            }
            lo++;
            hi++;
            idx++;

        }
//        return arr;

    }
    // public int Max(int[] arr, int i, int j){
    //     int max= Integer.MIN_VALUE;
    //     for(int k=i;k<=j;k++){
    //         if(arr[k]>max){
    //             max=arr[k];
    //         }
    //     }
    //     return max;
    // }
    }
}
