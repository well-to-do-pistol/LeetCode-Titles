package year1.month1.week2.day3;

public class PPPFrame_C {
    public final static int FLAG=0x7E;
    public final static int ESC=0x7D;
    public final static int ENC=0x20;
    public static byte[] enCode(byte[] bytes){
        int len=bytes.length;
        int index=0;
        byte[] newBytes = new byte[len*2];
        for (byte b:bytes){
            if (b==FLAG || b==ESC || b<ENC){
                newBytes[index++]=ESC;
                newBytes[index++]= (byte) (b^ENC);
            }else
                newBytes[index++]=b;
        }
        byte[] res = new byte[index];
        System.arraycopy(newBytes,0,res,0,index);
        return res;
    }
}
