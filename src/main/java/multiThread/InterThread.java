package multiThread;

//Inter Thread Communication, way for multiple threads to communicate each other.
class A {
    int num;
    boolean valueSet = false; //simple boolean variable to indicate whether num has been set by Producer

    public synchronized void put(int num) { //put() to be used by Producer thread to increment the num
        while(valueSet) {
            try { wait(); } catch (InterruptedException e) {} //producer thread will wait for consumer thread until
        }                                                       //consumer thread will notify() to producer that yeah,
        System.out.println("put: "+num);                      //I'm finished with my execution now its your turn.
        this.num = num;                                     //Note: wait() notify() notifyAll() all part of Object class not Thread class
        valueSet = true;                                //So no need to call Thread.wait/notify()
        notify(); // producer thread notify() the producer thread
    }
    public synchronized void get() { //get() to be used by Consumer thread get the incremented counter done by producer
        while(!valueSet) {
            try { wait(); } catch (InterruptedException e) {}
        }
        System.out.println("get: "+num);
        valueSet = false;
        notify(); // consumer thread notify() the producer thread
    }
}

class Producer implements Runnable {
    A a;

    public Producer(A a) {
        this.a  = a;
        Thread t = new Thread(this,"Producer");
        t.start();
    }
    @Override
    public void run() {
        int i=0;
        while(true) {
            a.put(i++);
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }
}

class Consumer implements Runnable {
    A a;

    public Consumer(A a) {
        this.a = a;
        Thread t = new Thread(this,"Consumer");
        t.start();
    }
    @Override
    public void run() {
        while(true) {
            a.get();
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }
}

public class InterThread {

    public static void main(String[] args) {
        A a = new A();
        new Producer(a);
        new Consumer(a);
    }

}
