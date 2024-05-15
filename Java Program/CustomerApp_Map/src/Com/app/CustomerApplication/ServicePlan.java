package Com.app.CustomerApplication;

public enum ServicePlan {
	
	SILVER(10000),GOLD(3000),DIAMOND(5000),PLATINUM(2000);
	
	private double plancost;
	
	ServicePlan(int plancost)
	{
		this.setPlancost(plancost);
		
		
	}

	public double getPlancost() {
		return plancost;
	}

	public void setPlancost(double plancost) {
		this.plancost = plancost;
	}

}
