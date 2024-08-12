package year1.month1.week1.day1;

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Address_93 {
}

class Solution7 {
    //长度不超过3
    //添加num计算.的数目
    //第一个不能为0
    List<String> result = new ArrayList<String>();
    StringBuffer path;
    public List<String> restoreIpAddresses(String s) {
        path = new StringBuffer();
        traversal(s,0,0);
        return result;
    }

    private void traversal(String s, int index, int num) { //加入数字是为了计算“.”的数目
        if (num==4 && index==s.length()){
            result.add(path.toString());
            return;
        }
        if (num==4 || index==s.length())return; //剪枝

        for (int i = index; i<s.length()&& i-index<3 ; i++){ //必须限制path的长度不超过3,提前剪枝
            if (s.charAt(index)=='0' && i+1-index>1)return; //如果不是单数，第一个数字不能为0

            String str = s.substring(index,i+1);
            if (isValidNum(str)){
                path.append(str);
                if (num<3)path.append(".");
            }else continue;

            traversal(s,i+1,num+1); //num直接加一吧，不想回溯了
            path.delete(index+num, i+num+2); //起点是index+num，终点+2是因为自己本来会加一个点回溯的时候删没了，而且删除是左闭右开的（s.subString（0，1））
        }
    }

    private boolean isValidNum(String s) {
        int num = Integer.parseInt(s);
        return num>=0 && num<=255;
    }
}