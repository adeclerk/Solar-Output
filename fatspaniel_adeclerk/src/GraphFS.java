import java.io.FileWriter;
import java.net.*;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.*;

import com.csvreader.*;
// Alex DeClerk
// Program to show fatspaniel output via graphs 
public class GraphFS {
	static String inputURL = "http://view2.fatspaniel.net/PV2Web/feed?feed=Dashboard/Commercial/NonRGDetailedViewFeed&eid=368149&format=table&style=csv";
	static String temp = "./solar_temp.csv";
	static String outputFile = "./solar.html";

	public static void main(String[] args) throws IOException
	{	
		ArrayList<Day> dayRecords = new ArrayList<Day>();
		try
		{
			// get the data from the supplied url
			getSolarData(inputURL);
			dayRecords = getRecords(temp);
			int i=0;
			while(i < dayRecords.size())
			{
				dayRecords.get(i).printDay();	
				i++;
			}
			htmlOutput(outputFile, dayRecords);			
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
	
	@SuppressWarnings("finally")
	static public ArrayList<Day> getRecords(String path) throws IOException
	{
		ArrayList<Record> records = new ArrayList<Record>();
		ArrayList<Day> dayRecords = new ArrayList<Day>();
		try
		{
			CsvReader csvFile = new CsvReader(temp);
			csvFile.readHeaders();
			Day currentDay = new Day();
			Boolean first_run = true;
			int value_counter = 0;
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
			for(i=0;i<records.size();)
			{
				value_counter = 0;
				if(first_run)
				{
					currentDay.d = Integer.parseInt( records.get(i).day );
					currentDay.m = Integer.parseInt( records.get(i).month);
					currentDay.y = Integer.parseInt( records.get(i).year);
					while(value_counter < 24)
					{
						currentDay.value_array[value_counter] = Float.parseFloat( records.get(i).averageGeneratedPower);
						i++;
						value_counter++;
					}
					dayRecords.add(currentDay);
					first_run = false;
				}
				else
				{
					currentDay = new Day();
					currentDay.d = Integer.parseInt( records.get(i).day );
					currentDay.m = Integer.parseInt( records.get(i).month);
					currentDay.y = Integer.parseInt( records.get(i).year);
					while(value_counter < 24 && i < records.size())
					{
						currentDay.value_array[value_counter] = Float.parseFloat( records.get(i).averageGeneratedPower);
						i++;
						value_counter++;
					}
					currentDay.setAstro();
					dayRecords.add(currentDay);
				}
			}
			/*
			i=0;
			while(i < dayRecords.size())
			{
				dayRecords.get(i).printDay();	
				i++;
			}
			*/
			return dayRecords;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			return dayRecords;
		}
	}
	static public void htmlOutput(String path, ArrayList<Day> dayRecords) throws IOException
	{
		ArrayList<String> dates = new ArrayList<String>();
		Day currentRecord = new Day();
		try
		{
			int record_count = dayRecords.size();
			// establish the output stream 
			BufferedWriter outputStream = new BufferedWriter(new FileWriter(outputFile));
			// Start html document
			outputStream.write("" +
								"<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"	+	"\n"	+
								"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"" + "\n" +
								"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">" + "\n" +
								"<html xmlns=\"http://www.w3.org/1999/xhtml\">" + "\n" + "\n");
			// Head tags
			outputStream.write("<head>" + "\n");
			// Title Tags
			outputStream.write("<title>Fatspaniel Output</title>" + "\n");
			outputStream.write("<style type=\"text/css\">\n"
					+"div { background: #c0c0c0; padding: 10px; } \n" +
					"table { background-color: white; border: 1px solid; padding-right: 20px; padding-top: 10px; padding-left: 20px;} \n" +
					".even { background-color: #E6E6E6; } \n" +
					"th.values{ border: 1px solid; } \n" +
					"td.left { -webkit-transform: rotate(270deg); -moz-transform: rotate(270deg); -o-transform: rotate(270deg); writing-mode: lr-tb; }\n" +
					"td.footer { text-align: center; }\n" +
					"</style>\n\n");
			outputStream.write("</head>" + "\n\n");
			// body
			outputStream.write("<body>\n<h1>Fatspaniel Output</h1>\n\n");
			int i = 0;
			int k = 0;
			while(i < record_count)
			{
				// new day, write a div
				dates.add(getMonth(dayRecords.get(i).m)+dayRecords.get(i).d);
				if(i%2 == 0) // if even, different bg color
				{
					outputStream.write("<div id=\""+getMonth(dayRecords.get(i).m)+dayRecords.get(i).d+dayRecords.get(i).y+"\">\n");	
				}
				else
				{
					outputStream.write("<div class=\"even\" id=\""+getMonth(dayRecords.get(i).m)+dayRecords.get(i).d+dayRecords.get(i).y+"\">\n");
				}
				// write outside table
				outputStream.write("\t<table width=\"150\">\n");
				outputStream.write("\t\t" +
				"<tr>" + "\n\t\t\t" +
				"<th colspan=\"2\" class=\"values\">" + dayRecords.get(i).m + "/"+dayRecords.get(i).d + "/" + dayRecords.get(i).y + "</th>\n\t\t\t<th class=\"values\">Average Generated Power</th>\n\t\t" +
				"</tr>\n");
				outputStream.write("\t\t"+
				"<tr>" + "\n\t\t\t" +
						"<th class=\"values\">Time</th>" + "\n\t\t\t" +
				"<th class=\"values\">Value</th>" + "\n\t\t");//<th>Sunrise: "+dayRecords.get(i).sunrise.toString()+" Sunset: "+dayRecords.get(i).sunset.toString()+"</tr>");
				// loop through each value
				while(k < 24)
				{
					if(k%2 == 0 || k == 0)
					{
						if(k < 10)
						{
							outputStream.write("\n\t\t"+
						"<tr  class=\"even\">" + "\n\t\t\t" +
									"<td>0"+k+":00</td>" + "\n\t\t\t" +
									"<td>"+dayRecords.get(i).value_array[k]+"</td>\n\t\t"+
						"</tr>\n");
						}
						else
						{
							outputStream.write("\n\t\t"+
						"<tr  class=\"even\">\n\t\t\t"+
									"<td>"+k+":00</td>\n\t\t\t" +
									"<td>"+dayRecords.get(i).value_array[k]+"</td>\n\t\t" +
						"</tr>");
						}
						k++;
					}
					else if (k == 1) // add the third column at the second row
					{
						outputStream.write("\n\t\t"+
					"<tr>\n\t\t\t"+
								"<td>0"+k+":00</td>\n\t\t\t"+
								"<td>"+dayRecords.get(i).value_array[k]+"</td>\n\t\t" +
					"");
					    outputStream.write("\n\t\t<td rowspan=\"23\">\n\t\t\t<table>\n\t\t\t<tr>\n\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t<th>Fs output "+ dayRecords.get(i).m + "/"+dayRecords.get(i).d + "/" + dayRecords.get(i).y +"</th>\n\t\t\t</tr>" +
					"\n\t\t\t<tr>\n\t\t\t\t<td class=\"left\">kw/h</td>\n\t\t\t\t<td><canvas id=\""+getMonth(dayRecords.get(i).m)+dayRecords.get(i).d+"\" width=\"520\" height=\"420\"> </canvas></td>" +
					"\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"footer\">Time (24hr)\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t</td></tr>");
					    k++;
					}
					else
					{
						if(k < 10)
						{
							outputStream.write("\n\t\t"+
						"<tr>" + "\n\t\t\t" +
									"<td>0"+k+":00</td>\n\t\t\t"+
									"<td>"+dayRecords.get(i).value_array[k]+"</td>\n\t\t"+
						"</tr>");
						}
						else
						{
							outputStream.write("\n\t\t<tr>\n\t\t\t<td>"+k+":00</td>\n\t\t\t<td>"+dayRecords.get(i).value_array[k]+"</td>\n\t\t</tr>");
						}
						k++;
					}
				}
				outputStream.write("\n\t</table>\n</div>\n");
				i++;
				k=0;
			}
			
			outputStream.write("<script src=\"./fs_canvas.js\"></script><script>");
			i=0;
			k = 0;
			while(i < dates.size())
				{
				outputStream.write("\n\tinit_graph(\""+dates.get(i)+"\");");
				currentRecord = dayRecords.get(i);
				while( k < 24)
				{
					if(k > 0)
					{
						outputStream.write("\n\t\tplot_point(\""+dates.get(i)+"\","+k+","+currentRecord.value_array[k]+");\t // "+k+":00");
						outputStream.write("\n\t\t\tconnect_point(\""+dates.get(i)+"\","+(k-1)+","+currentRecord.value_array[(k-1)]+","+k+","+currentRecord.value_array[k]+");");
					}
					else
					{
						outputStream.write("\n\t\tplot_point(\""+dates.get(i)+"\","+k+","+currentRecord.value_array[k]+");\t // "+k+":00");
					}
						k++;
				}
				i++;
				k=0;
				}
			outputStream.write("</script></body>\n");
				
			outputStream.write("</html>\n");
			outputStream.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	static public String getMonth(int month)
	{
		switch(month)
		{
		case 1:
			return "jan";
		case 2:
			return "feb";
		case 3:
			return "mar";
		case 4:
			return "apr";
		case 5:
			return "may";
		case 6:
			return "jun";
		case 7:
			return "jul";
		case 8: 
			return "aug";
		case 9:
			return "sep";
		case 10:
			return "oct";
		case 11:
			return "nov";
		case 12:
			return "dec";
			default:
				return "err";
		}
	}
}


