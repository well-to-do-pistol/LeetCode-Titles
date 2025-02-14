package titles.greedy;

import java.util.*;

public class Sum_Of_The_Largest_Subarrays_53 {
}

class Solution_53 {

    // 1. 贪心: 得到负数重新开始
    // public int maxSubArray(int[] nums) {
    //     int sum=0, max=Integer.MIN_VALUE;
    //     for(int x:nums){
    //         sum+=x;
    //         max=Math.max(sum,max);
    //         if(sum<0){
    //             sum=0;
    //         }
    //     }
    //     return max;
    // }

    // 2. 动态规划: dp[i]=max(dp[i-1]+nums[i],nums[i])
    // dp[i]表示一定包含nums[i]的连续数组的最大和
    // [-2,1,-3], max每次都要和dp[i]比才行
    // public int maxSubArray(int[] nums) {
    //     int max=nums[0], n=nums.length;
    //     int[] dp = new int[n];
    //     dp[0]=nums[0];
    //     for(int i=1; i<n; ++i){
    //         dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
    //         max=Math.max(max,dp[i]);
    //     }
    //     return max;
    // }


    // 3. 动态规划(第2点的滚动数组版)
    // public int maxSubArray(int[] nums) {
    //     int max=nums[0], n=nums.length, pre=nums[0];
    //     for(int i=1; i<n; ++i){
    //         pre=Math.max(pre+nums[i],nums[i]);
    //         max=Math.max(max,pre);
    //     }
    //     return max;
    // }

    // 4. 分治, 像归并一样分解问题l到r的最大和要通过l到m的信息和m+1到r的信息合并得到
    // 维护4个量(都是连续的线段的和):
    // (1) lSum: 包含左端点的最大和,  等于max(左子区间的lSum, 左子区间的iSum+右子区间的lSum)
    // (2) rSum: 包含右端点的最大和,  等于max(右子区间的rSum, 右子区间的iSum+左子区间的rSum)
    // (3) mSum: 最大和,             等于max(max(左子区间的mSum,右子区间的mSum),左子区间rSum+右子区间的lSum)
    // (4) iSum: 所有元素总和,        等于左右子区间的iSum之和
    // 长度为1时, 4个量都为num[i]

    // 因为有任意子区间[l,r]的信息, 可以建成线段树; 可以在 O(logn) 的时间内求到任意区间内的答案
    public int maxSubArray(int[] nums) {
        return getInfo(nums,0,nums.length-1).mSum;
    }

    private Status getInfo(int[] nums, int l, int r){
        if(l==r)return new Status(nums[l],nums[l],nums[l],nums[l]);
        int m=l+((r-l)>>1);
        Status lInfo = getInfo(nums,l,m);
        Status rInfo = getInfo(nums,m+1,r);
        return pushUp(lInfo,rInfo);
    }

    class Status{
        int lSum;
        int rSum;
        int mSum;
        int iSum;
        public Status(int lSum, int rSum, int mSum, int iSum){
            this.lSum=lSum;
            this.rSum=rSum;
            this.mSum=mSum;
            this.iSum=iSum;
        }
    }

    private Status pushUp(Status lInfo, Status rInfo){
        int lSum = Math.max(lInfo.lSum, lInfo.iSum+rInfo.lSum);
        int rSum = Math.max(rInfo.rSum, rInfo.iSum+lInfo.rSum);
        int mSum = Math.max(Math.max(lInfo.mSum,rInfo.mSum), lInfo.rSum+rInfo.lSum);
        int iSum = lInfo.iSum+rInfo.iSum;
        return new Status(lSum,rSum,mSum,iSum);
    }
}
