package Day_1;

public class first_and_last_position_of_element_sorted_array {
    public static void main(String[] args) {
        int[] nums= {5,7,7,8,8,10};
        int target= 8;
        // using the two pass -> time complexity O(n)
//        int[] arr= {-1,-1};
        //loop for finding first position of element
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]==target){
//                arr[0]=i;
//                break;
//            }
//        }
//        if(arr[0]==-1){
//            return arr;
//        }
        //loop for finding last position of element
//        for(int i=arr[0];i<nums.length;i++){
//            if(nums[i]==target){
//                arr[1]=i;
//            }
//        }
//        return arr;

        // Using Binary Search


        int[] arr= {-1,-1};
        int left= binarySearch(nums,target,true);
        int right= binarySearch(nums,target,false);
        arr[0]=left;
        arr[1]=right;
//        return arr;


    }
    public static int binarySearch(int[] nums,int target,boolean isLeft){
        int lo=0,hi=nums.length-1;
        int idx=-1;
        while(lo<=hi){
            int mid= lo+ (hi-lo)/2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                idx = mid;
                if (isLeft) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return idx;
    }
}
