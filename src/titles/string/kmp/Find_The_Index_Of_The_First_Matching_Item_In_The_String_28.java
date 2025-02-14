package titles.string.kmp;

public class Find_The_Index_Of_The_First_Matching_Item_In_The_String_28 {
}
class Solution_28 {
    public int strStr(String haystack, String needle) {
        int l1=haystack.length();
        int l2=needle.length();
        char[] c1=haystack.toCharArray();
        char[] c2=needle.toCharArray();
        if(l2==0)return -1;
        int[] next=new int[l2];
        getNext(needle,next);
        int j=0;
        for(int i=0; i<l1; ++i){
            while(j>0 && c1[i]!=c2[j]){
                j=next[j-1];
            }
            if(c1[i]==c2[j])
                ++j;
            if(j==l2)
                return i-j+1;
        }
        return -1;
    }
    private void getNext(String s, int[] next){
        char[] chars = s.toCharArray();
        int j=0;
        for(int i=1; i<s.length(); ++i){
            while(j>0 && chars[i]!=chars[j])
                j=next[j-1];   //相同前后缀长度
            if(chars[i]==chars[j])
                ++j;
            next[i]=j;
        }
    }
}