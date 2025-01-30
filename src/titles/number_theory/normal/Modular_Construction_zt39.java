package titles.number_theory.normal;
import java.util.Scanner;
public class Modular_Construction_zt39 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        long a,b,x,y;
        while(t-->0){
            a=in.nextLong();
            b=in.nextLong();
            x=-1;
            y=-1;
            if(a>0&&b>0){
                if(a>b){
                    x=a;
                    y=a+b;
                }else if(b>a){
                    y=b;
                    x=a+b;
                }
            }else if(a==0 && b==0){
                x=1;
                y=1;
            }else if(a==0){
                x=2*b;
                y=b;
            }else if(b==0){
                y=2*a;
                x=a;
            }
            System.out.println(x+" "+y);
        }
    }
}
