package Day_3;

import java.util.ArrayList;
import java.util.List;

public class spiral_order {
    public static void main(String[] args) {
//        Simple and best approach:- Using 4 pass , we take 4variables namely minrow, maxrow,mincol and maxcol
//        these four variables used to keep track order in direction right->bottom -> left -> up

        int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
        int minr=0;
        int maxr=matrix.length-1;
        int minc=0;
        int maxc=matrix[0].length-1;
        int tot=matrix.length*matrix[0].length;
        int c=0;
        List<Integer> list = new ArrayList<>();
        while(c<tot){
            for(int i=minc;i<=maxc && c<tot;i++){
                list.add(matrix[minr][i]);
                c++;
            }
            minr++;

            for(int i=minr;i<=maxr && c<tot;i++){
                list.add(matrix[i][maxc]);
                c++;
            }
            maxc--;

            for(int i=maxc;i>=minc && c<tot;i--){
                list.add(matrix[maxr][i]);
                c++;
            }
            maxr--;

            for(int i=maxr;i>=minr && c<tot;i--){
                list.add(matrix[i][minc]);
                c++;
            }
            minc++;
        }
        for(int i:list){
            System.out.print(i+" ");
        }
    }
}

