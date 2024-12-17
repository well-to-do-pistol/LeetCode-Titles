package titles.a6_stacks_and_queues;

public class Verify_The_Order_Of_Book_Retrieval_lcr148 {
}
class Solution_lcr148 {
    //栈模拟法
    // public boolean validateBookSequences(int[] putIn, int[] takeOut) {
    //     Stack<Integer> stack = new Stack<>();
    //     int index=0;
    //     for(int i=0; i<putIn.length; i++){
    //         stack.push(putIn[i]);
    //         while(!stack.isEmpty()  && stack.peek()==takeOut[index]){
    //             stack.pop();
    //             index++;
    //         }
    //     }
    //     return stack.isEmpty();
    // }

    //数组模拟栈方法
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        int index1=0, index2=0;
        for(int num : putIn){
            putIn[index1]=num;
            while(index1>=0 && putIn[index1]==takeOut[index2]){
                index2++;
                index1--;
            }
            index1++;
        }
        return index1==0;
    }
}