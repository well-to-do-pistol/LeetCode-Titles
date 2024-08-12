package year1.month1.week1.day1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Split_Palindrome_String_131{
    public static void main(String[] args) {
//            Solution solution = new Solution();
//            solution.climbStairs(5);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//class Solution {
//    //回溯
//    //首先a,然后递归ab；首先aa,然后递归b
//    List<List<String>> result = new ArrayList<List<String >>();
//    Deque<String> path = new LinkedList<String>();
//    public List<List<String>> partition(String s) {
//        traversal(s,0);
//        return result;
//    }
//
//    private void traversal(String s, int index) {
//        if (index>=s.length()){ //这里是s.length()
//            result.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = index; i<s.length(); i++){
//            if (isPalindrome(s,index,i)){  //不是回文串的会continue,甚至不递归
//                path.add(s.substring(index,i+1));
////                String str = s.substring(index,i+1);
////                path.addLast(str);
//            }else continue;
//            traversal(s,i+1);//递归
//            path.removeLast();//回溯
//        }
//    }
//
//    private boolean isPalindrome(String s, int index, int i) {
//        for (int start=index, end=i; start<end; start++, end--){
//            if (s.charAt(start)!=s.charAt(end))return false;
//        }
//        return true;
//    }
//}

class Solution8 {
    //最快
    public List<List<String>> partition(String s) {
        return null;
    }
}