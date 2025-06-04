package titles.stacks_and_queues.stacks;
import java.util.*;
public class Decode_String_394 {
}
class Solution_394 {
    private  String repeat(String s, int count){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<count; ++i){
            sb.append(s);
        }
        return sb.toString();
    }
    // 1. 利用递归parse
    // 用count(count*10+c-'0')计算重复次数
    // 遇到[计算后，需要重置count
    // int p;
    // int n;
    // public String decodeString(String s) {
    //     char[] chars = s.toCharArray();
    //     p = 0;
    //     n = s.length();
    //     return parse(chars);
    // }

    // private String parse(char[] chars){
    //     StringBuilder sb = new StringBuilder();
    //     int count = 0;
    //     while(p<n){
    //         char c = chars[p++];
    //         if (c>='0' && c<='9'){
    //             count = count*10 + c - '0';
    //         }else if (c=='['){
    //             String tmp = parse(chars);
    //             sb.append(repeat(tmp,count));
    //             count = 0;
    //         }else if (c==']'){
    //             break;
    //         }else {
    //             sb.append(c);
    //         }
    //     }
    //     return sb.toString();
    // }

    // 2. 迭代（较难）
    // 一个数栈一个str栈，遇到[加两个栈(将前面的先保存)，更新count和sb；遇到 ]弹两个栈计算，更新sb.
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = s.length(),i=0,count=0;
        char[] chars = s.toCharArray();
        while(i<n){
            char c = chars[i++];
            if (c>='0' && c<='9'){
                count = count*10 + c -'0';
            }else if (c=='['){
                countStack.push(count);
                strStack.push(sb.toString());
                sb = new StringBuilder();
                count = 0;
            }else if (c==']'){
                StringBuilder tsb = new StringBuilder(strStack.pop());
                tsb.append(repeat(sb.toString(),countStack.pop()));
                sb = tsb;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}