package year1.month1.week1.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bellman_Ford_C {
    //动态规划
    //对所有边进行n-1次松弛(就是更新minList数组)
    //专用于单源最短有负数的情况
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        List<int[]> edges = new ArrayList<>();
        for (int i=0; i<m; i++){
            int s=scanner.nextInt();
            int t=scanner.nextInt();
            int val=scanner.nextInt();
            edges.add(new int[]{s,t,val});
        }

        int[] minList = new int[n+1];
        Arrays.fill(minList, Integer.MAX_VALUE);
        minList[1]=0; //初始化

        for (int i=0; i<n-1; i++){
            for (int[] edge:edges){
                int s=edge[0];
                int t=edge[1];
                int val=edge[2];
                if (minList[s]!=Integer.MAX_VALUE && minList[s]+val<minList[t]){ //起源不能等于最大值, 等于最大值证明它还没和源点连起来
                    minList[t]=minList[s]+val;
                }
            }
        }

        if (minList[n]!=Integer.MAX_VALUE){
            System.out.println(minList[n]);
        }else {
            System.out.println(-1);
        }
        scanner.close();
    }
}
