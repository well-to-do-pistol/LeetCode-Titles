package Design_Pattern.Proxy_Pattern;

public class Static_Proxy {
    //使真实角色不用关注公共业务, 交给代理解决
    public static void main(String[] args) {
        Master master = new Master();
        Proxy proxy = new Proxy(master);
        proxy.rent();
    }
}

interface Rent{
    void rent();
}

class Master implements Rent{

    @Override
    public void rent() {
        System.out.println("Master rent");
    }
}

class Proxy implements Rent{
    Master master;
    public Proxy(Master master){
        this.master = master;
    }

    @Override
    public void rent() {
        see();
        master.rent();
        fare();
    }

    private void see(){
        System.out.println("Proxy see");
    }
    private void fare(){
        System.out.println("Proxy fare");
    }
}