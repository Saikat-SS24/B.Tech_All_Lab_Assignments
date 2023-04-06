import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class WordCountFile
{
	public static void main(String args[])
	{
		BufferedReader reader = null;
		int charCount = 0;
		int wordCount = 0;
		int lineCount = 0;
		try
		{
			reader = new BufferedReader(new FileReader("D:\\Saikat Sheet\\Java Programs\\sample.txt"));
			String currentLine = reader.readLine();
			while(currentLine != null)
			{
				lineCount++;
				String[] words = currentLine.split(" ");
				wordCount = wordCount + words.length;
				for(String word : words)
				{
					charCount = charCount + word  .length();
				}
				currentLine = reader.readLine();
			}
			System.out.println("Number of Chars: "+ charCount);
			System.out.println("Number of Words: "+ wordCount);
			System.out.println("Number of Lines: "+ lineCount);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				reader.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	 }
}

	