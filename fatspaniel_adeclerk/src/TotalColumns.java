import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


//import java.io.FileNotFoundException;
//import java.io.BufferedReader;
//import java.io.BufferedInputStream;
//import java.io.FileInputStream;
//import java.io.DataInputStream;
//import java.io.IOException;



public class TotalColumns {
	static String inputFile = "/Users/adeclerk/solar.csv";
	static String outputFile = "/Users/adeclerk/solar.html";

	public static void main(String[] args) throws IOException
	{	

		BufferedReader buffer;
		BufferedWriter outputBuffer;
		int i = 0;
		int j = 0;
		FSRecord[] records;
		String[] fileContents;
	
		
		String[][]tableContent;
		String currentLine;
	
		int numberOfLines;
		int fieldCount;
		int curRow = 0;
		int curCol = 0;
		int currentDay;
		String currentLineOutput;
		String[] tokens;
		//String[] currentTokens;
	
		try
		{
			numberOfLines = getLineCount(inputFile);
			// Prep input
			//buffer = new BufferedReader(new FileReader(inputFile));
			// Prep output
			outputBuffer = new BufferedWriter(new FileWriter(outputFile, false));
			fileContents = new String[numberOfLines];
			// Get line from file
			//currentLine = buffer.readLine();
			//tokens = currentLine.split(","); // tokenize line
			//fieldCount = tokens.length;
	
			//tableContent = new String[numberOfLines][fieldCount];// initialize a table
			//records = new FSRecord[(numberOfLines-1)];
			fileContents[0] = readCSV.getHeader(inputFile);
			
		//	buffer.close();
			
			
			
			
			
			/*
			
			
			// Generate HTML header
			outputBuffer.write("" +
					"<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"	+	"\n"	+
					"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"" + "\n" +
					"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">" + "\n" +
					"<html xmlns=\"http://www.w3.org/1999/xhtml\">" + "\n" + "\n");
			// Head tags
			outputBuffer.write("<head>" + "\n");
			// Title Tags
			outputBuffer.write("<title>");
				outputBuffer.write("Fatspaniel Output");
			outputBuffer.write("</title>" + "\n");
			
			outputBuffer.write("<style type=\"text/css\">\n");
			outputBuffer.write(
					"tr.oddDate { " + "\n" +
					"background-color: #585858;" + "\n" +
					"} "	+	"\n"	+
					"tr.evenDate {" + "\n" +
					"background-color: #D0D0D0;" + "\n" +
					"} \n");
			outputBuffer.write("</style>\n\n");
			outputBuffer.write("</head>" + "\n");
			outputBuffer.write("<body>" + "\n");
			outputBuffer.write("<table border=\"1\">\n\n");
			// --------------------
			// -----Table Header
			outputBuffer.write("<tr name=\"topheader\">" + "\n");
			outputBuffer.write("<th colspan=\"" + fieldCount + "\">" + " Record Ouput (" + (numberOfLines-1) + ") records</th>\n" + "\n");
			outputBuffer.write("</tr>" + "\n\n");
			currentLineOutput ="<tr name=\"header\">\n";
			for(j=0;j<fieldCount; j++)
			{
				currentLineOutput += "<th> " + tableContent[0][j] + "</th>\n";
			}
			currentLineOutput += "</tr>\n\n";
			outputBuffer.write(currentLineOutput);
			for(i=1;i<numberOfLines; i++)
			{
				currentLineOutput ="<tr class=\"evenDate\">\n";	
				for(j=0;j<fieldCount; j++)
				{
						switch(j)
						{
						case 0:
							currentLineOutput += "<td colspan=\"3\">" + tableContent[i][j];
							break;
						case 1:
							currentLineOutput += "/" + tableContent[i][j];
							break;
						case 2:
							currentLineOutput += "/" + tableContent[i][j] + " </td>\n";
							break;
						default:
							currentLineOutput += "<td>" + tableContent[i][j] + "</td>\n";
						//}
				}
				currentLineOutput += "</tr> \n\n";
				outputBuffer.write(currentLineOutput);
			}
				
			outputBuffer.write("\n</table>");
			outputBuffer.write("</body>" + "\n");
			outputBuffer.write("</html>" + "\n");
			outputBuffer.close();
		*/
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
		public static int getInt(String field)
		{
			return(Integer.parseInt(field));
		}
		
		public static float getFloat(String field)
		{
			return (Float.valueOf(field).floatValue());
		}
		public static int getHour(String field)
		{
			if(field.equals("00:00"))
			{
				return 0;
			}
			else if(field.equals("01:00"))
			{
				return 1;
			}
			else if(field.equals("02:00"))
			{
				return 2;
			}
			else if(field.equals("03:00"))
			{
				return 3;
			}
			else if(field.equals("04:00"))
			{
				return 4;
			}
			else if(field.equals("05:00"))
			{
				return 5;
			}
			else if(field.equals("06:00"))
			{
				return 6;
			}
			else if(field.equals("07:00"))
			{
				return 7;
			}
			else if(field.equals("08:00"))
			{
				return 8;
			}
			else if(field.equals("09:00"))
			{
				return 9;
			}
			else if(field.equals("10:00"))
			{
				return 10;
			}
			else if(field.equals("11:00"))
			{
				return 11;
			}
			else if(field.equals("12:00"))
			{
				return 12;
			}
			else if(field.equals("13:00"))
			{
				return 13;
			}
			else if(field.equals("14:00"))
			{
				return 14;
			}
			else if(field.equals("15:00"))
			{
				return 15;
			}
			else if(field.equals("16:00"))
			{
				return 16;
			}
			else if(field.equals("17:00"))
			{
				return 18;
			}
			else if(field.equals("18:00"))
			{
				return 18;
			}
			else if(field.equals("19:00"))
			{
				return 19;
			}
			else if(field.equals("20:00"))
			{
				return 20;
			}
			else if(field.equals("21:00"))
			{
				return 21;
			}
			else if(field.equals("22:00"))
			{
				return 22;
			}
			else if(field.equals("23:00"))
			{
				return 23;
			}
			else
			{
				return 999;
			}
		}
		
		public static FSRecord makeRecord(String[] token, int id)
		{
			FSRecord returnRecord = new FSRecord(id,getInt(token[0]),getInt(token[1]),getInt(token[2]),getHour(token[3]),getFloat(token[4]),getFloat(token[7]),getFloat(token[9]));
			return returnRecord;
		}
		public static int tokenCount(String line)
		{
			String[] tokens = line.split(",");
			return tokens.length;
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


