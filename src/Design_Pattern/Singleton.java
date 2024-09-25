package Design_Pattern;

public class Singleton {
    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            new Thread(LazyMan::getInstance).start();
        }
    }
}


class LazyMan{
    //synchronized保证有序性
    //volatile可以禁止指令重排
    public static volatile LazyMan lazyMan;
    private LazyMan(){ //打印创建实例的那个线程
        System.out.println(Thread.currentThread().getName()+"");
    }
    public static LazyMan getInstance(){
        if (lazyMan==null){ //设置第二次检查是防止多个线程同时进入这层
            synchronized (LazyMan.class){ //则应用同步以确保一次只有一个线程可以进入此块
                if (lazyMan==null){
                    lazyMan=new LazyMan();
                }
            }
        }
        return lazyMan;
    }
}
//- **内存可见性**：确保一个线程对变量所做的更改对其他线程可见。
//- **初始化安全性**：保证共享对象在其他线程可见之前已正确构造。
//- **非阻塞算法**：精确的操作顺序对于避免死锁和确保正确性至关重要。