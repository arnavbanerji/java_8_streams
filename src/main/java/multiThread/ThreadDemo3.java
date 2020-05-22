package multiThread;

public class ThreadDemo3 {

    //main thread
    public static void main(String[] args) {
        //lambda expression implementing run() method from Runnable interface
        Runnable obj1 = () -> {
            for(int i=0 ; i<5 ; i++) {
                System.out.println("Hi");
                try {Thread.sleep(500); } catch (InterruptedException e) {}
            }
        };

        Runnable obj2 = () -> {
            for(int i=0 ; i<5 ; i++) {
                System.out.println("Hello");
                try {Thread.sleep(500); } catch (InterruptedException e) {}
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

        System.out.println("Is t1 thread alive?: "+t1.isAlive());//true

        //join() will make main thread to wait for t1 and t2 thread to finish and then join with main thread
        //to make t1 t2 and main thread as one thread.
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}

        System.out.println("Is t1 thread alive?: "+t1.isAlive());//false


        //I want this to show at last line, without join() method, bye will get printed anywhere middle of prints,
        //because of main thread coinciding with other threads t1 and t2.
        System.out.println("Bye");

    }
}
