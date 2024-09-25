package Design_Pattern.Factory_Method;

public class Factory_Method {
    //一个工厂等级负责多个产品的创建
    public static void main(String[] args) {
        Phone phone = new HuaWeiFactory().getPhone();
        phone.name();
    }
}
interface PhoneMFactory{
    Phone getPhone();
}
class HuaWeiFactory implements PhoneMFactory{

    @Override
    public Phone getPhone() {
        return new HuaWei();
    }
}