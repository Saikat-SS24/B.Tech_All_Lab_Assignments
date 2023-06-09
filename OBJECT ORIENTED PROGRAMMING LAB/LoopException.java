import java.util.Random;

class ArithmeticException extends Exception
{
	private int iter;
	ArithmeticException(int iter)
	{
		this.iter = iter;
	}
	public String toString()
	{
		return "ArithmeticException occured for iteration"+this.iter;
	}
}

class Loop
{
	int range;
	Loop(int range)
	{
		this.range = range;
	}
	void execute()
	{
		try
		{
			Random rn = new Random();
			int randInt = rn.nextInt(this.range);
			for(int i = 0; i<this.range; i++)
			{
				if(i == randInt)
				{
					throw new ArithmeticException(i);
				}
			}
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);
		}
	}
}

class LoopException
{
	public static void main(String args[])
	{
		Loop l1 = new Loop(100);
		l1.execute();
	}
}