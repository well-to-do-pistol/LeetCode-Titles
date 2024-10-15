package year1.month1.week2.day3;

public class Find_The_Index_Of_The_First_Matching_Item_In_The_String_28 {
}
class Solution {
    public int strStr(String haystack, String needle) {
        int len1=haystack.length();
        int len2=needle.length();
        if (len2==0)return 0;
        int[] next = new int[len2];
        getNext(next,needle);

        int j=0;
        for (int i=0; i<len1; i++){ //这里从0开始
            while (j>0 && needle.charAt(j)!=haystack.charAt(i)){
                j=next[j-1];
            }
            if (haystack.charAt(i)==needle.charAt(j))j++;
            if (j==len2)return i-len2+1;
        }
        return -1;
    }

    private void getNext(int[] next, String needle) {
        int j=0; //后缀
        next[0]=0;
        for (int i=1; i<needle.length(); i++){
            while (j>0 && needle.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if (needle.charAt(i)==needle.charAt(j))j++;
            next[i]=j;
        }
    }
}