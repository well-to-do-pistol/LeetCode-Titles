package Design_Pattern;

import java.util.ArrayList;

public class Observer_Pattern {
    //降低目标与观察者的耦合, 建立触发机制
    public static void main(String[] args) {
        Subject1 subject1 = new Subject1();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        subject1.add(observer1);
        subject1.add(observer2);
        subject1.notifyAllObservers();
    }
}
interface Observer{
    void response();
}

class Observer1 implements Observer{


    @Override
    public void response() {
        System.out.println("Observer1 action!");
    }
}

class Observer2 implements Observer{


    @Override
    public void response() {
        System.out.println("Observer2 action!");
    }
}

abstract class Subject{
    protected ArrayList<Observer> array = new ArrayList<>();
    public void add(Observer observer){
        array.add(observer);
    }
    public void delete(Observer observer){
        array.remove(observer);
    }
    abstract void notifyAllObservers();
}

class Subject1 extends Subject{

    @Override
    void notifyAllObservers() {
        for (Observer observer:array){
            observer.response();
        }
    }
}
