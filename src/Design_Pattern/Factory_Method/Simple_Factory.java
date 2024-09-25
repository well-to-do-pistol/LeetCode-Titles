package Design_Pattern.Factory_Method;

public class Simple_Factory {
    //降低代码耦合, 但不能添加数据
    public static void main(String[] args) {
        Phone phone1=PhoneFactory.getPhone("华为");
        Phone phone2=PhoneFactory.getPhone("小米");
        assert phone1 != null;
        phone1.name();
        assert phone2 != null;
        phone2.name();
    }
}
interface Phone{
    void name();
}
class HuaWei implements Phone{

    @Override
    public void name() {
        System.out.println("华为手机");
    }
}
class Xiaomi implements Phone{

    @Override
    public void name() {
        System.out.println("小米手机");
    }
}
class PhoneFactory{
    public static Phone getPhone(String name){
        if (name.equals("华为")){
            return new HuaWei();
        }else if (name.equals("小米")){
            return new Xiaomi();
        }
        return null;
    }
}