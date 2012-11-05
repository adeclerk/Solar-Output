import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.io.*;

import com.csvreader.*;

public class TotalColumns {
	static String inputFile = "/Users/adeclerk/solar.csv";
	static String outputFile = "/Users/adeclerk/solar.html";

	public static void main(String[] args) throws IOException
	{	
		Record lastRecord = new Record();
		BufferedWriter outputStream;
		String currentLineOutput;
		ArrayList<Record> records = new ArrayList<Record>();
		try
		{
			CsvReader csvFile = new CsvReader("/Users/adeclerk/solar.csv");
			outputStream = new BufferedWriter(new FileWriter("/Users/adeclerk/solar.html"));
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
			
			// --------------------
			// -----Table Header
			//outputStream.write("<tr><th colspan=\"6\"> Record Ouput (" + records.size() + ") records</th>\n" + "\n");
			//outputStream.write("</tr>" + "\n\n");
			//outputStream.write("<tr>\n\t<th>num</th>\n\t<th>m</th>\n\t<th>d</th>\n\t<th>y</th>\n\t<th>t</th>\n\t<th>Average Generation Power (W)</th>\n</tr>");
			int i;
			Double power;
			boolean firstrun = true;
			Integer current_day;
			for(i=0;i<records.size();)
			{
				current_day = Integer.parseInt(records.get(i).day);
				outputStream.write("<table border=\"1\">\n\n");
				outputStream.write("<tr>\n");
				outputStream.write("<td>Date:</td><td>"+records.get(i).month+"/"+records.get(i).day+"/"+records.get(i).year+"</td>\n\n</tr>\n");
				while(Integer.parseInt((records.get(i).day)) == current_day)
				{
					outputStream.write("<tr>\n");
					outputStream.write("<td>"+records.get(i).time+"</td>\n");
					if(records.get(i).averageGeneratedPower.equalsIgnoreCase("null"))
					{
						power = 0.00;
					}
					else
					{
						power = Double.parseDouble(records.get(i).averageGeneratedPower);
					}
					outputStream.write("<td>"+power+"</td>\n<tr>\n");
					i++;
				}
				i++;
				outputStream.write("</table>\n");
				
					
	
				//	outputStream.write("<tr style=\"background-color: #00000;\">\n");
				//	outputStream.write("\t<td>" + i + "</td>\n");
				//	outputStream.write("\t<td>" + records.get(i).month + "</td>\n");
				//	outputStream.write("\t<td>" + records.get(i).day + "</td>\n");
				//	outputStream.write("\t<td>" + records.get(i).year + "</td>\n");
				//	outputStream.write("\t<td>" + records.get(i).time + "</td>\n");
				//	outputStream.write("\t<td>" + power*1000 + "</td>\n");
				//	outputStream.write("</tr>\n");
				
			}
			
			outputStream.write("\n</table>");
			outputStream.write("\n<table>");
			outputStream.write("\n</table>");
			outputStream.write("</body>" + "\n");
			outputStream.write("</html>" + "\n");
			outputStream.close();
		
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}


