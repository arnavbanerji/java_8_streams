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

        Thread t1 = new Thread(obj1, "HiThread");
        Thread t2 = new Thread(obj2, "HelloThread"); //assign names to thread in second argument
                                                            //similarly you can name in setName()
        //t1.setName("HiThread");
        //t2.setName("HelloThread");
        System.out.println("t1 thread name: "+t1.getName()); //get name of thread t1  - "HiThread" (Default name: Thread-0)
        System.out.println("t2 thread name: "+t2.getName()); //get name of thread t2 - "HelloThread" (Default name: Thread-1)

        System.out.println("priority of t1: "+t1.getPriority()); //get priority level of t1 and t2
        System.out.println("priority of t2: "+t2.getPriority());
        //priortiy levels are from 1 to 10:
        //1 - least priority
        //2 - most priority
        // 5 is the default priority
        //you can set the priority by using t1.setPriority(1 to 10).
        //for thread t1 with high priority, JVM will tell CPU to allocate more resources to thread t1 than t2, then
        //if your cpu is completely filled and it doesn't have the resources to run both of the threads at the same time.
        // It will first run the one with the highest priority.

        t1.start();
        try { Thread.sleep(10); } catch (InterruptedException e) {} //sequentially print Hi and Hello simultaneously
        t2.start();                                                     //instead of Hi Hello Hello Hi abruptly

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
