import java.rmi.*;
import java.rmi.server.*;
public class CalculatorIntf extends UnicastRemoteObject implements Calculator
{
    public CalculatorIntf() throws RemoteException
    {
        super();
    }
    public int add(int x, int y)
    {
        return x + y;
    }
    public int subtract(int x, int y)
    {
        return x - y;
    }
    public int multiply(int x, int y)
    {
        return x * y;
    }
    public int divide(int x, int y)
    {
        if(y != 0)
        {
            return x / y;
        }
        else
        {
            return -1;
        }
    }
}
