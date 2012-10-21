import java.io.*;
public class readCSV {
	public static String header;
	public static String line;
	public static int lineCount;
	public static String getHeader(String fileName) throws IOException
	{
		FileReader input = null;
		BufferedReader buffer = null;
		//String line;
		try
		{	
			input = new FileReader(fileName);
			buffer = new BufferedReader(input);
			FileReader input = null;
			BufferedReader buffer = null;
			
			buffer.close();
			
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
			else
			{
			//	return "error";
			}
		}	
		return line;
		//return line;	
	}
	
	public static String readFile(String fileName)
	{
		FileReader input = null;
		BufferedReader buffer = null;
		
		buffer.close();
		
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
		else
		{
		//	return "error";
		}
	}	
	return line;
	}
}
