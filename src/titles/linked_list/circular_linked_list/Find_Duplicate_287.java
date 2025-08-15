package titles.linked_list.circular_linked_list;

public class Find_Duplicate_287 {
}
class Solution_287 {
    //[1,3,4,2,2]
    // 0,1,2,3,4
    // 值和索引之间会连成环
    // 利用快慢指针知道相交
    // 然后慢指针变为0，一次走一步知道相遇找到入口点
    public int findDuplicate(int[] nums) {
        int slow=0,fast=0;
        do{    // 需要用do while是因为一开始都是0开始，需要至少走一次
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;   // return slow是因为fast会走一步，无论如何都不会是0，所以slow也会至少走一步，不是索引是值
    }
}