package multiThread;

//To make this class run as separate thread, extend this class to Thread
class Hi extends Thread {

    //run() method needs to be overriden
    public void run() {
        for(int i=0 ; i<5 ; i++) {
            System.out.println("Hi");
            try {Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

class Hello extends Thread {

    public void run() {
        for(int i=0 ; i<5 ; i++) {
            System.out.println("Hello");
            try {Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

public class ThreadDemo {

    //main thread
    public static void main(String[] args) {
        Hi obj1 = new Hi();
        Hello obj2 = new Hello();

        //start() method internally executes run() method, so we need to override run() method in Thread extended class
        obj1.start();
        obj2.start();

    }
}
