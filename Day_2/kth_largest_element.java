package Day_2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kth_largest_element {
    public static void main(String[] args) {
        int[] nums= {3,2,1,5,6,4};
        int k=4;
        // Approach 1: sort the array and return the kth element from the last
//        Arrays.sort(nums);
//        System.out.println(nums[nums.length-k]);

//        Approach 2: take the priority queue and add k element in it
//        from k to array last check if the current element is greater than priority queue element
//        if yes replace the element and at the last return the pq.peek element
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]>pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
        }
//        return pq.peek();
        System.out.println(pq.peek());

    }
}
