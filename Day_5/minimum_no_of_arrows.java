class Solution {
    public int findMinArrowShots(int[][] points) {
// sorting the array on basis of Xend and check if xstart of next element is less than equal to Xend of current the it will be shot by one arrow and 
//if not we need another arrow so increase the value by one
        Arrays.sort(points, (a,b)-> Integer.compare(a[1],b[1]));
        int count=1;
        int prev=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]>prev){
                count++;
                prev=points[i][1];
            }
        }
        return count;
        
    }
}
