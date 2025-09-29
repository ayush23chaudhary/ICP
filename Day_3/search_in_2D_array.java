package Day_3;

public class search_in_2D_array {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
//        First Approach-using two loops traversal of each element of matrix and return true if element in found
//        Time -complexity- O(n*m)

//        Second and best approach Finding the row in which element is present and applying binary search in it
        int row=matrix.length;
        int col= matrix[0].length;
        int r=0;
        for(int i=0;i<row;i++){
            if(target<=matrix[i][col-1]){
                r=i;
                break;
            }
        }
        int lo=0;
        int hi=col-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;;
            if(matrix[r][mid]>target){
                hi=mid-1;
            }
            else if(matrix[r][mid]==target){
//                return true;

            }


            else{
                lo=mid+1;
            }
        }
//        return false;
    }

}
