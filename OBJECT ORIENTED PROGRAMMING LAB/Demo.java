import java.util.Random;

class ThreadDemo implements Runnable
{
	Thread t;
	boolean c = false;
	int count = 0,inc,n;

	ThreadDemo(int m, int i)
	{
		Random rand = new Random();
		int p = rand.nextInt(5);
		t = new Thread(this);
		t.setPriority(1+p);
		inc = i;
		n = m;
	}
	public void run()
	{
		while(c)
		{
			try
			{
				t.sleep(30);
				count++;
				if(count%3 == 0)
				{
					if(t.getPriority()+inc <= 10)
					{
						t.setPriority(t.getPriority()+inc);
					}
					else
					{
						t.setPriority(10);
					}
				}
				System.out.println("Thread Priority"+n+":\t"+t.getPriority()+"\ncount:\t"+count);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
	}
	public void stop()
	{
		c = false;
	}
	public void start()
	{
		c = true;
		t.start();
	}
}
class Demo
{
	public static void main(String args[])
	{
		ThreadDemo t1 = new ThreadDemo(1,1);
		ThreadDemo t2 = new ThreadDemo(2,2);
		ThreadDemo t3 = new ThreadDemo(3,2);
		ThreadDemo t4 = new ThreadDemo(4,1);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		try
		{
			Thread.currentThread().sleep(30);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		t1.stop();
		t2.stop();
		t3.stop();
		t4.stop();

		try
		{
			t1.t.join();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		try
		{
			t2.t.join();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		try
		{
			t3.t.join();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		try
		{
			t4.t.join();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}		

			
	

	