package Design_Pattern.Abstract_Factory;

public class Abstract_Factory {
    //抽象工厂: 定义抽象方法
    //抽象产品
    public static void main(String[] args) {
        HuaWeiFactory_ huaWeiFactory_ = new HuaWeiFactory_();
        Phone_ phone_ = huaWeiFactory_.getPhone();
        Computer computer = huaWeiFactory_.getComputer();
        phone_.send();
        phone_.call();
        computer.play();
        computer.watch();
    }
}
interface Computer{
    void play();
    void watch();
}
class HuaWeiComputer implements Computer{

    @Override
    public void play() {
        System.out.println("HuaWeiComputer's play!");
    }

    @Override
    public void watch() {
        System.out.println("HuaWeiComputer's watch!");
    }
}

interface Phone_{
    void send();
    void call();
}

class HuaWeiPhone implements Phone_{

    @Override
    public void send() {
        System.out.println("HuaWeiPhone's send!");
    }

    @Override
    public void call() {
        System.out.println("HuaWeiPhone's call!");
    }
}

interface IFactory{
    Phone_ getPhone();
    Computer getComputer();
}

class HuaWeiFactory_ implements IFactory{

    @Override
    public Phone_ getPhone() {
        return new HuaWeiPhone();
    }

    @Override
    public Computer getComputer() {
        return new HuaWeiComputer();
    }
}