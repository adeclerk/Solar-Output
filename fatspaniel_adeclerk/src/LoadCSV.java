import java.io.*;

public class LoadCSV
{
	int lineCount;
	int fieldCount;
	public static void main(String[] args)
	{
		FileReader input = null;
		buffer = new BufferedReader(new FileReader(input));
		BufferedReader buffer = null;
		lineCount = getLineCount();
		
	}
	
	public static void import(String inputFile) throws IOException
	{
		BufferedReader buffer;
		try
		{
			buffer = new BufferedReader(new FileReader(inputFile));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
		
		}
	}
	public static int getLineCount(String n_input) throws IOException
	{
		FileReader input = null;
		BufferedReader buffer = null;
		String line;
		int count = 1;
		try
		{	
			input = new FileReader(n_input);
			buffer = new BufferedReader(input);
			
			
			line = buffer.readLine();
			while(line != null)
			{
				line = buffer.readLine();
				count++;
			}
			
			buffer.close();
		}
		catch(FileNotFoundException e)
		{
		e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(buffer != null)
			{
				buffer.close();
			}
		}
		return count;
	}
}
