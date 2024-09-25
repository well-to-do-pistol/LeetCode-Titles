package Design_Pattern.Proxy_Pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Dynamic_Proxy {
    //静态代理每有一个真实角色就要创建一个代理
    //一个动态代理类管理一个接口,(多个类)
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        handler.setTarget(userService);
        IUserService proxy = (IUserService) handler.getProxy();
        proxy.add();
        proxy.delete();
    }
}
interface IUserService{
    void add();
    void delete();
    void update();
    void query();
}
class UserServiceImpl implements IUserService{

    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void query() {
        System.out.println("query");
    }
}

class ProxyInvocationHandler implements InvocationHandler{
    //setTarget, getProxy, method.invoke
    private Object target;
    public void setTarget(Object target){
        this.target=target;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public void log(String arg){
        System.out.println("[debug]:"+arg);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object result = method.invoke(target,args);
        return result;
    }
}
