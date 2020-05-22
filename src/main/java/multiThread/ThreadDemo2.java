package multiThread;

//To make this class run as separate thread, implement Runnable.
//Since Runnable is functional interface, you can make use of lambda expression to implement run() method.
//with Lambda expression, you don't need to create outer class, just an inner anonymous class.
//Though this example makes use of outer class (Hi2 and Hello2).
//see ThreadDemo3 for lambda expression example.
class Hi2 implements Runnable {

    //run() method needs to be overriden
    public void run() {
        for(int i=0 ; i<5 ; i++) {
            System.out.println("Hi");
            try {Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

class Hello2 implements Runnable {

    public void run() {
        for(int i=0 ; i<5 ; i++) {
            System.out.println("Hello");
            try {Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

public class ThreadDemo2 {

    //main thread
    public static void main(String[] args) {
        Hi2 obj1 = new Hi2();
        Hello2 obj2 = new Hello2();

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

    }
}
