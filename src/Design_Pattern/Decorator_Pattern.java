package Design_Pattern;

public class Decorator_Pattern {
    //比继承更有弹性,开闭原则
    //抽象装饰器继承抽象类(因为具体实现类会转化成具体装饰器类), 具体装饰器拥有具体实现类
    //具体构件,具体装饰
    public static void main(String[] args) {
        Drink milk = new Milk();
        milk = new Chocolate(milk); //milk变成Chocolate类
        milk = new Pudding(milk);   //milk又变成了Pudding类
        System.out.println(milk.cost());

    }
}
abstract class Drink{
    public abstract double cost();
}

class Juice extends Drink{
    @Override
    public double cost() {
        System.out.println("Juice:"+14);
        return 14;
    }
}

class Milk extends Drink{
    @Override
    public double cost() {
        System.out.println("Milk:"+12);
        return 12;
    }
}

abstract class Decorator extends Drink{
    public abstract double cost();
}

class Chocolate extends Decorator{
    Drink drink;
    public Chocolate(Drink drink){
        this.drink=drink;
    }

    @Override
    public double cost() {
        System.out.println("Chocolate:"+4);
        return drink.cost()+4;
    }
}

class Pudding extends Decorator{
    Drink drink;
    public Pudding(Drink drink){
        this.drink=drink;
    }

    @Override
    public double cost() {
        System.out.println("Pudding:"+5);
        return drink.cost()+5;
    }
}