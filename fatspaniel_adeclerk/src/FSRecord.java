public class FSRecord {
	private int day;
	private int year;
	private int month;
	private int time;
	private int id;
	private float incrementalGenerationEnergy;
	private String incrementalBuildingDemand;
	private String incrementalInsolation;
	private float lastGenerationEnergy;
	private String lastInsolation;
	private float averageGenerationPower;
	private String averageIrradiance;
	private String averageAmbientTemperature;
	
	public FSRecord(int id, int year, int month, int day, int time,float IGE, float LGE, float AGP) {
		this.id = id;
	    this.day = day;
	    this.month = month;
	    this.year = year;
	    this.time = time;
	    this.incrementalGenerationEnergy = IGE;
	    //this.incrementalBuildingDemand = IBD;
		//this.incrementalInsolation = f;
		this.lastGenerationEnergy = LGE;
		//this.lastInsolation = g;
		this.averageGenerationPower = AGP;
		//this.averageIrradiance = AI;
		//this.averageAmbientTemperature = AAT;
	    
	  }
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return this.id;
	}
	public int getDay()
	{
		return this.day;
	}
	
	public int getMonth()
	{
		return this.month;
	}
	
	public int getYear()
	{
		return this.year;
	}
	
	public int getTime()
	{
		return this.time;
	}
	
	public void setTime(int nTime)
	{
		this.time = nTime;
	}
	
	public float getIGE()
	{
		return this.incrementalGenerationEnergy;
	}
	
	public String getIBD()
	{
		return this.incrementalBuildingDemand;
	}
	
	public String getII()
	{
		return this.incrementalInsolation;
	}
	
	public float getLGE()
	{
		return this.lastGenerationEnergy;
	}
	
	public String getLI()
	{
		return this.lastInsolation;
	}
	
	public float getAGP()
	{
		return this.averageGenerationPower;
	}
	
	public String getAI()
	{
		return this.averageIrradiance;
	}
	
	public String getAAT()
	{
		return this.averageAmbientTemperature;
	}
	
	public void setDay(int nDay)
	{
		this.day = nDay;
	}
	
	public void setMonth(int nMonth)
	{
		this.month = nMonth;
	}
	
	public void setYear(int nYear)
	{
		this.month = nYear;
	}
	
	public void setIGE(float nIGE)
	{
		this.incrementalGenerationEnergy = nIGE;
	}
	
	public void setIBD(String nIBD)
	{
		this.incrementalBuildingDemand = nIBD;
	}
	
	public void setII(String nII)
	{
		this.incrementalInsolation = nII;
	}
	
	public void setLGE(float nLGE)
	{
		this.lastGenerationEnergy = nLGE;
	}
	
	public void setLI(String nLI)
	{
		this.lastInsolation = nLI;
	}
	
	public void setAGP(float nAGP)
	{
		this.averageGenerationPower = nAGP;
	}
	
	public void setAI(String nAI)
	{
		this.averageIrradiance = nAI;
	}
	
	public void setAAT(String nAAT)
	{
		this.averageAmbientTemperature = nAAT;
	}
}
