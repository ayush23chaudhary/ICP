package Day_1;

import java.util.Arrays;

public class mini_no_of_arrows_to_burst_balloons {
    public static void main(String[] args) {

        int[][] points= {{10,16},{2,8},{1,6},{7,12}};
        Arrays.sort(points,(a, b) -> Integer.compare(a[1],b[1]));
        int count=1;
        int re= points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]>re){
                count++;
                re=points[i][1];
            }
        }
//        return count;
        System.out.println(count);
    }
}
