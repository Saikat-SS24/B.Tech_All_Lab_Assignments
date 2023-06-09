class MyClass implements Runnable
{
    Thread t;
    boolean running;
    int count, incrPriority, defPriority;
    MyClass(int defPriority, int incrPriority)
    {
        this.t = new Thread(this);
        this.defPriority = defPriority;
        this.incrPriority = incrPriority;
        this.running = false;
    }

    public void run()
    {
        while(this.running)
        {
            count++;
            try
            {
                Thread.sleep(10);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }

    public void stop()
    {
        running = false;
    }

    public void start()
    {
        this.running = true;
        t.start();
        this.t.setPriority(this.defPriority);
    }
}

public class MultiThreading
{
    public static void main(String[] args)
    {
        MyClass thread1 = new MyClass(1, 1);
        MyClass thread2 = new MyClass(4, 2);
        MyClass thread3 = new MyClass(3, 2);
        MyClass thread4 = new MyClass(2, 1);
        int lim = 50;
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        while(lim>0)
        {
            lim -= 1;
            try
            {
                if(thread1.t.getPriority() < 10)
                {
                    thread1.t.setPriority(thread1.t.getPriority()+thread1.incrPriority);
                }

                if(thread2.t.getPriority() < 9)
                {
                    thread2.t.setPriority(thread2.t.getPriority()+thread2.incrPriority);
                }
                
                if(thread3.t.getPriority() < 9)
                {
                    thread3.t.setPriority(thread3.t.getPriority()+thread3.incrPriority);
                }
                
                if(thread4.t.getPriority() < 10)
                {
                    thread4.t.setPriority(thread4.t.getPriority()+thread4.incrPriority);
                }
                Thread.sleep(30);
                System.out.println("Priority of thread "+thread1.t.getName()+": "+thread1.t.getPriority()+", Value of counter: "+thread1.count);
                System.out.println("Priority of thread "+thread2.t.getName()+": "+thread2.t.getPriority()+", Value of counter: "+thread2.count);
                System.out.println("Priority of thread "+thread3.t.getName()+": "+thread3.t.getPriority()+", Value of counter: "+thread3.count);
                System.out.println("Priority of thread "+thread4.t.getName()+": "+thread4.t.getPriority()+", Value of counter: "+thread4.count);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        thread1.stop();
        thread2.stop();
        thread3.stop();
        thread4.stop();
    }
}