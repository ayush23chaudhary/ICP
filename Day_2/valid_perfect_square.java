package Day_2;

public class valid_perfect_square {
    public static void main(String[] args) {
        // Best Approach using binary search kepping hi=n/2 because square will always be less than n/2 of te number
        int n= 808201;
        boolean c=false;
        if(n==1) c= true;
        long lo=0;
        long hi=n/2;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(mid*mid==(long)n){
//                return true;
                c=true;
            }
            else if(mid*mid<(long)n){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        System.out.println(c);
//        return c;
    }
}
