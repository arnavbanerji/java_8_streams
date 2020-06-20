package multiThread;

class Counter {
    int count; //default = 0;

    public synchronized void increment() { //with synchronized, no 2 threads t1 and t2 can execute the same method making it thread safe
        count++; //count = count + 1;     so when t1 thread increment the counter to x+1, without synchronized
                                        //t2 thread will also increment the counter to x+1, so it wouldnt make x+2
    }                                   //with synchronized, t1 will execute followed by t2, hence counter will increment to x+2
}                                      //hence, we would get 2000 output, instead of any random number less than 2000.

public class SynchronizedDemo {

    public static void main(String[] args) throws InterruptedException {

        Counter c = new Counter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1 ; i<=1000 ; i++) {
                    c.increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1 ; i<=1000 ; i++) {
                    c.increment();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join(); //make sure we print 2000 (after finishing 1000 by 1st thread + 1000 by 2nd thread)
        t2.join();

        System.out.println(c.count); //2000 (with synchronized), 1400-1900 (without synchronized)
    }
}
