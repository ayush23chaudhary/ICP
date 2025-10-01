class Solution {
    public int numRescueBoats(int[] people, int limit) {
// simple two pointer approach decreasing right an icreasing count  if sum exceeds limits else increasing left, right pointer if sum <= limit
      
        int Count = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            int sum = people[left] + people[right];
            if(sum <= limit){
                Count++;
                left++;
                right--;
            }
            else{
                Count++;
                right--;
            }
        }
        return Count;
    }
}
