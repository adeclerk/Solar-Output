import java.io.FileWriter;
import java.net.URL;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.io.*;

import com.csvreader.*;

public class TotalColumns {
	static String inputURL = "http://view2.fatspaniel.net/PV2Web/feed?feed=Dashboard/Commercial/NonRGDetailedViewFeed&eid=368149&format=table&style=csv";
	static String temp = "./solar_temp.csv";
	static String outputFile = "/Users/adeclerk/solar.html";

	public static void main(String[] args) throws IOException
	{	
	    URL website = new URL("http://www.website.com/information.asp");
	    
	    
		BufferedWriter outputStream;
		ArrayList<Record> records = new ArrayList<Record>();
		try
		{
			// get the data from the supplied url
			getSolarData(inputURL);
			/*
			CsvReader csvFile = new CsvReader(temp);
			//outputStream = new BufferedWriter(new FileWriter("/Users/adeclerk/solar.html"));
			csvFile.readHeaders();
			while(csvFile.readRecord())
			{
				Record currentRecord = new Record();
				currentRecord.month = csvFile.get("m");
				currentRecord.day = csvFile.get("d");
				currentRecord.year = csvFile.get("y");
				currentRecord.time = csvFile.get("t");
				currentRecord.averageGeneratedPower = csvFile.get("Average Generation Power (kW)");
				records.add(currentRecord);
			}
			
			// Generate HTML header
			outputStream.write("" +
					"<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"	+	"\n"	+
					"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"" + "\n" +
					"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">" + "\n" +
					"<html xmlns=\"http://www.w3.org/1999/xhtml\">" + "\n" + "\n");
			// Head tags
			outputStream.write("<head>" + "\n");
			// Title Tags
			outputStream.write("<title>");
				outputStream.write("Fatspaniel Output");
			outputStream.write("</title>" + "\n");
			
			outputStream.write("<style type=\"text/css\">\n");
			outputStream.write(
					"tr.oddDate { " + "\n" +
					"background-color: #585858;" + "\n" +
					"} "	+	"\n"	+
					"tr.evenDate {" + "\n" +
					"background-color: #D0D0D0;" + "\n" +
					"} \n");
			outputStream.write("</style>\n\n");
			outputStream.write("</head>" + "\n");
			outputStream.write("<body>" + "\n");
			
			int i;
			Double power;
			
			int current_day;
			// Get the current date, in this case first record's date
			current_day = Integer.parseInt(records.get(0).day);
			// Write the first table
			outputStream.write("<table border=\"1\" cols=\"25\">");
			// First Row
			outputStream.write("<tr>\n");
			// First Col
			outputStream.write("<td>Date: "+records.get(0).month+"/"+records.get(0).day+"/"+records.get(0).year+"</td>");
			// 2nd-25th cols
			outputStream.write("<td>00:00</td>\n<td>01:00</td>\n<td>02:00</td><td>03:00</td>\n<td>04:00</td><td>05:00</td>\n<td>06:00</td><td>07:00</td>\n<td>08:00</td>\n<td>09:00</td>");
			outputStream.write("<td>10:00</td>\n<td>11:00</td>\n<td>12:00</td><td>13:00</td>\n<td>14:00</td><td>15:00</td>\n<td>16:00</td><td>17:00</td>\n<td>18:00</td>\n<td>19:00</td>");
			outputStream.write("<td>20:00</td>\n<td>21:00</td>\n<td>22:00</td><td>23:00</td>\n");
			outputStream.write("</tr>\n");
			// Second Row
			outputStream.write("<tr>");
			// First col (empty)
			outputStream.write("<td></td>");
			
			// loop through each record, creating a new table if needed
			for(i=0;i<records.size();i++)
			{
	
				// get desired number from string 
				if(records.get(i).averageGeneratedPower.equalsIgnoreCase("null"))
				{
					power = 0.00;
				}
				else
				{
					power = Double.parseDouble(records.get(i).averageGeneratedPower);
				}
				// if the current day we are working with is the same as the last, add a cell to the table
				if(Integer.parseInt(records.get(i).day) == current_day)
				{
					outputStream.write("<td style=\"height: 800px;\" id=\""+records.get(i).month+"-"+records.get(i).day+"-"+records.get(i).time+"\">");
					
					// Determine color based on power generated
					if(power > 70)
					{
						outputStream.write("<div style=\"height: "+(800-(power*10))+"px; background-color: #FFFF33;\"> "+power+"</div><div style=\"height: "+(power*10)+"px; background-color: red;\"> </div></td>");
					}
					else if(power > 50)
					{
						outputStream.write("<div style=\"height: "+(800-(power*10))+"px; background-color: #FFFF19;\"> "+power+"</div><div style=\"height: "+(power*10)+"px; background-color: red;\"> </div></td>");
					}
					else if(power > 30)
					{
						outputStream.write("<div style=\"height: "+(800-(power*10))+"px; background-color: #FFFF00;\"> "+power+"</div><div style=\"height: "+(power*10)+"px; background-color: red;\"> </div></td>");
					}
					else if(power > 20)
					{
						outputStream.write("<div style=\"height: "+(800-(power*10))+"px; background-color: #E6E600;\"> "+power+"</div><div style=\"height: "+(power*10)+"px; background-color: red;\"> </div></td>");
					}
					else if(power > 10)
					{
						outputStream.write("<div style=\"height: "+(800-(power*10))+"px; background-color: #FFFF00;\"> "+power+"</div><div style=\"height: "+(power*10)+"px; background-color: red;\"> </div></td>");
					}
					else if(power > 6)
					{
						outputStream.write("<div style=\"height: "+(800-(power*10))+"px; background-color: #CCCC00;\"> "+power+"</div><div style=\"height: "+(power*10)+"px; background-color: red;\"> </div></td>");
					}
					else if(power > 3)
					{
						outputStream.write("<div style=\"height: "+(800-(power*10))+"px; background-color: #B2B200;\"> "+power+"</div><div style=\"height: "+(power*10)+"px; background-color: red;\"> </div></td>");
					}
					else if(power > 2)
					{
						outputStream.write("<div style=\"height: "+(800-(power*10))+"px; background-color: #999900;\"> "+power+"</div><div style=\"height: "+(power*10)+"px; background-color: red;\"> </div></td>");
					}
					else if(power > 0)
					{
						outputStream.write("<div style=\"height: "+(800-(power*10))+"px; background-color: #808000;\"> "+power+"</div><div style=\"height: "+(power*10)+"px; background-color: red;\"> </div></td>");
					}
					else
					{
						outputStream.write("<div style=\"position: relative; background-color: #000000; color: white; height: 400px; text-align: center;\">&nbsp;</div> <div style=\"position: relative; background-color: #000000; color: white; height: 400px; vertical-align: text-top;\">"+power+"</div></td>\n");
					}
				}
				else // start a new table for a new date
				{
					outputStream.write("</tr>\n</table>\n");
					outputStream.write("<table border=\"1\" cols=\"25\">\n\n");
					outputStream.write("<tr>\n");
					outputStream.write("<td>Date: "+records.get(i).month+"/"+records.get(i).day+"/"+records.get(i).year+"</td><td>00:00</td><td>01:00</td><td>02:00</td><td>03:00</td><td>04:00</td><td>05:00</td><td>06:00</td><td>07:00</td><td>08:00</td><td>09:00</td><td>10:00</td><td>11:00</td><td>12:00</td><td>13:00</td><td>14:00</td><td>15:00</td><td>16:00</td><td>17:00</td><td>18:00</td><td>19:00</td><td>20:00</td><td>21:00</td><td>22:00</td><td>23:00</td></tr><tr><td></td>");
					outputStream.write("<td style=\"height: 800px;\" id=\""+records.get(i).month+"-"+records.get(i).day+"-"+records.get(i).time+"\">\n");
					outputStream.write("<div style=\"position: relative; background-color: #000000; color: white; height: 400px; text-align: center;\">&nbsp;</div><div style=\"background-color: #000000; color: white; height: 400px; vertical-align: text-top;\">"+power+"</div></td>\n");
				}
				current_day = Integer.parseInt(records.get(i).day);
				
				
					
				
			}
		
	
			outputStream.write("</body>" + "\n");
			outputStream.write("</html>" + "\n");
			outputStream.close(); // close output
		*/
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	
	static public void getSolarData(String link) throws IOException
	{
		try
		{
			// establish the output stream 
			BufferedWriter outputStream = new BufferedWriter(new FileWriter(temp));
			
			// new url stream object
			URL url = new URL(link);
			InputStream response = url.openStream();
			// establish the input stream
			BufferedReader reader = new BufferedReader(new InputStreamReader(response));
			
			// read the file requested
			for (String line; (line = reader.readLine()) != null;)
			{
			    System.out.println(line);
			    outputStream.write(line);
			    outputStream.write('\n');
			}
			reader.close();
			//outputStream.write("\r\n");
			outputStream.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	static public Day[] getRecords(String path) throws IOException
	{
		ArrayList<Record> records = new ArrayList<Record>();
		ArrayList<Day> dayRecords = new ArrayList<Day>();
		try
		{
			CsvReader csvFile = new CsvReader(temp);
			csvFile.readHeaders();
			Day currentDay;
			Boolean first_run = true;
			// load all of the records
			while(csvFile.readRecord())
			{
				Record currentRecord = new Record();
				currentRecord.month = csvFile.get("m");
				currentRecord.day = csvFile.get("d");
				currentRecord.year = csvFile.get("y");
				currentRecord.time = csvFile.get("t");
				currentRecord.averageGeneratedPower = csvFile.get("Average Generation Power (kW)");
				records.add(currentRecord);
			}
			int i = 0;
			for(i=0;i<records.size();i++)
			{
				if(first_run)
				{
					
				}
				
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}


