import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.FileNotFoundException;

public class LineCounter extends Thread
{
	private static final String FOLDER_PATH = "D:\\Saikat Sheet\\Java Programs\\myfiles";
	private File file;
	public void run()
	{
		FileReader fr = null;
		try
		{
			fr = new FileReader(file);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(fr != null)
		{
			LineNumberReader lnr = new LineNumberReader(fr);
			try
			{
				lnr.skip(Long.MAX_VALUE);
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			System.out.println(file.getName()+ " " + lnr.getLineNumber());
		}
	}
	public LineCounter(File file)
	{
		super();
		this.file = file;
	}
	public static void main(String args[])
	{
		long start = System.currentTimeMillis();
		File folder = new File("D:\\Saikat Sheet\\Java Programs\\myfiles");
		LineCounter lc;
		for(File file : folder.listFiles())
		{
			if(file.isFile())
			{
				lc = new LineCounter(file);
				lc.start();
			}
		}
		System.out.println("Laps = "+(System.currentTimeMillis()- start)+ "miliseconds");
	}
}
	