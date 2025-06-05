package titles.numerical.binary_numbers;

public class Max_Word_Length_318 {
}
class Solution_318 {
    // 1.最优算法，用整数来表示字符是否出现
    // 每次该数 |= 1<<(c-'a') // 最右边位表示a是否出现、右边倒数第二表示b是否出现
    // 最终只需判断&两个数是否等于0就能知道是否有重复
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] nums = new int[n];
        for (int i=0; i<n; ++i){
            for (char c : words[i].toCharArray()){
                nums[i] |= 1<<(c-'a');
            }
        }
        int max = 0;
        for (int i=0; i<n; ++i){
            for (int j=i+1; j<n; ++j){
                if ((nums[i] & nums[j]) == 0){ // ==比&优先级高？？
                    max = Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }

    // 这个算法比较差，但是是优化成位运算的基础：用[n][26]的boolean数组模拟map来记录每个单词字符的出现
    // 两层for循环，遍历两个单词的数组26次，如果完全遍历完，证明无重合，更新max
    // public int maxProduct(String[] words) {
    //     int n = words.length;
    //     boolean[][] map = new boolean[n][26];
    //     for (int i=0; i<n; ++i){
    //         for (char c : words[i].toCharArray()){
    //             map[i][c-'a']=true;
    //         }
    //     }
    //     int max = 0;
    //     for (int i=0; i<n; ++i){
    //         for (int j=i+1; j<n; ++j){
    //             int k = 0;
    //             for(;k<26;++k){
    //                 if (map[i][k] && map[j][k]){
    //                     break;
    //                 }
    //             }
    //             if (k==26){
    //                 max = Math.max(max,words[i].length() * words[j].length());
    //             }
    //         }
    //     }
    //     return max;
    // }
}