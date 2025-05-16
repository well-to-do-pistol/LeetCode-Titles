package titles.dynamic_programming.variants_normal;

public class Fibonacci_Numbers_509 {
    
}

class Solution_509 {
    // 迭代法，用a和b代表第一、二个数并更新
    public int fib(int n) {
        if(n<=1){
            return n;
        }
        int a = 0, b =1;
        for (int i=2; i<=n; ++i){
            int tmp = a + b;
            a = b;     // 更新a为b
            b = tmp;   // 更新b为tmp
        }
        return b;      // 最后只需要返回b, 因为b已更新为tmp
    }
}
