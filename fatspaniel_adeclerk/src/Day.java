import java.util.*;
public class Day {
	int d;
	int m;
	int y;
	float[] value_array;
	Date sunrise;
	Date sunset;
	
	public Day()
	{
		d = -1;
		m = -1;
		y = -1;
		value_array = new float[24];
		sunrise = new Date();
		sunset = new Date();
	}
	
	public Boolean is_valid()
	{
		if(d == -1)
			return false;
		else
			return true;
	}
	
	public void printDay()
	{
		System.out.println("Day: "+m+"/"+d+"/"+y+"\n");
		for(int i =0; i < 24; i++)
		{
			if( i < 10)
				System.out.println("0"+i+":00\t"+value_array[i]+"\n");
			else
				System.out.println(+i+":00\t"+value_array[i]+"\n");
		}
		System.out.println("\n");
	}
	public void setAstro()
	{
		Date time;
		Calendar past_date;
		int month;
		int day;
		int year;
		if( is_valid() )
		{
			month = m;
			day = d;
			year = y;
		
			past_date = new GregorianCalendar(year,month,day);
			time = new Date((past_date.getTimeInMillis()));
		
			SunriseSunset sunrise = new SunriseSunset(28.5381,81.3794,time,-4);
			this.sunrise = sunrise.getSunrise();
			this.sunset = sunrise.getSunset();
		}
	}

}
