class Printer extends Thread
{
    int pages;
    Printer(int pages)
    {
        this.pages = pages;
    }
    public void run()
    {
        System.out.println("Printing "+this.pages+" page(s)...");
        try
        {
            Thread.sleep(this.pages*5000);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Printing finished!");
    }
    synchronized void print()
    {
        this.run();
    }
}

class UserRequest
{
    UserRequest(int pages)
    {
        Printer p1 = new Printer(pages);
        p1.print();
    };
}

public class Printing
{
    public static void main(String[] args)
    {
        UserRequest req1 = new UserRequest(1);
        UserRequest req2 = new UserRequest(3);
        UserRequest req3 = new UserRequest(2);
        req1.hashCode();
        req2.hashCode();
        req3.hashCode();
    }
}
