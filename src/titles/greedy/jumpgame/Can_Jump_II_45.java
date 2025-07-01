package titles.greedy.jumpgame;

public class Can_Jump_II_45 {
}
/**
 最快，BFS贪心，目前用这种！！！
 */
class Solution_45 {
    // 用end来决定循环层数，每层step+1
    // 用curMax>=n-1来判断退出
    // 用curMax来更新end
    public int jump(int[] nums) {
        if (nums.length<2)return 0;
        int i = 0;
        int end = 0;
        int steps = 0;
        while(i<=end){
            ++steps;
            int curMax = 0;
            for (; i<=end; ++i){
                curMax = Math.max(curMax,i+nums[i]);
                if (curMax>=nums.length-1)
                    return steps;
            }
            end = curMax;
        }
        return steps;
    }
}

/**
 最简单
 */
// class Solution {
//     // 每次走到边界就加1步，最终返回步数
//     public int jump(int[] nums) {
//         int length = nums.length;
//         int end = 0;
//         int maxPosition = 0;
//         int steps = 0;
//         for (int i = 0; i < length - 1; i++) {
//             maxPosition = Math.max(maxPosition, i + nums[i]);
//             if (i == end) {
//                 end = maxPosition;
//                 steps++;
//             }
//         }
//         return steps;
//     }
// }


/**
 自己想的，非常非常慢
 */
// class Solution {
//     // 最小步数, dp[i]为跳到i索引的最小步数
//     // 遍历，dp[num[i]+i]=dp[i]+1;
//     public int jump(int[] nums) {
//         int n = nums.length;
//         if (n<2) return 0;
//         int[] dp = new int[n];
//         for (int i=0; i<n; ++i){
//             if (nums[i]+i>=n-1) return dp[i]+1;
//             for (int j=nums[i]+i; j>i; --j){
//                 if (dp[j]==0)
//                     dp[j]=dp[i]+1;
//             }
//         }
//         return dp[n-1];
//     }
// }