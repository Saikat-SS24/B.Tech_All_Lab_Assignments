import java.rmi.*;
import java.rmi.registry.*;
public class MyServer
{
    public static void main(String[] args)
    {
        try
        {
            Calculator stub = new CalculatorIntf();
            Naming.rebind("rmi://localhost:5000/calculate", stub);
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
