🧠「栈队双全用 `Deque`，快狠准就选 `ArrayDeque`，插删频繁选 `LinkedList`，不要 `Stack` 旧习惯！」

1. ArrayDeque:
   1. pop(), push(), pollFirst(), offerLast()  // offer和poll等于offerLast和pollFirst
   2. peekFirst(), peekLast()                        // peek等于peekFirst







Deque<Integer> stack = new LinkedList<Integer>(); //既可以当栈也可以当队列

Deque<Integer> deque = new LinkedList<>();和Queue<Integer> deque = new LinkedList<>();会得到截然不同的数据结构
Deque有pop(), push(), pollFirst(), offerLast(), (还有offer(), poll())

注意!!! ArrayDeque不允许有null, LinkedList(offer, poll)、Stack允许我操了

        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
    
        queue.add(1);
        queue.add(2);
        queue.add(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("queue.peek() : "+queue.peek());
        System.out.println("stack.peek() : "+stack.peek());
        System.out.println("queue.poll() : "+queue.poll());
        System.out.println("stack.pop() : "+stack.pop());

Stack 类：Stack 类是 Java 早期版本就存在的类，它继承自 Vector 类。Vector 是线程安全的，其内部方法大多使用了 synchronized 关键字进行同步，这在单线程环境下会带来不必要的同步开销，因为同步操作需要加锁和解锁，会消耗额外的时间和资源。

Deque（双端队列）是一个接口，它继承自 Queue 接口; Deque 结合 LinkedList：Deque 是一个接口，LinkedList 是其实现类之一。LinkedList 本身不是线程安全的，在单线程环境下没有同步带来的额外开销，因此可以更高效地执行栈操作

LinkedList<int[]> res = new LinkedList<>();
Deque<int[]> res = new LinkedList<>();
LinkedList 本身就实现了 Deque 接口