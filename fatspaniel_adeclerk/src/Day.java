
public class Day {
	int d;
	int m;
	int y;
	float[] value_array;
	
	public Day()
	{
		d = -1;
		m = -1;
		y = -1;
		value_array = new float[24];
	}
	
	public Boolean is_valid()
	{
		if(d == -1)
			return false;
		else
			return true;
	}

}
