package titles.technique;

public class Majority_Element_169 {
}
class Solution_169 {
    // 摩尔投票算法，利用count计数并抵消，如果count==0就换人
    // candidate用Integer可以表示null
    public int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }
}