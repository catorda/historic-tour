package destinationsalinas.historictour;

import com.google.android.maps.GeoPoint;

public class DestinationClass {
	private int number;
	private String name;
	private String address;
	private String phone;
	private String desc;
	private String image;
	private GeoPoint location;
	private Double other;
	
	public DestinationClass(String [] data){
		number = Integer.parseInt(data[0]);
		name = data[1];
		address = data[2];
		phone = data[3];
		desc = data[4];
		image = data[5];
		location = new GeoPoint((int)(Double.parseDouble(data[7])*1000000), (int)(Double.parseDouble(data[6])*1000000));
		other = Double.parseDouble(data[8]);
	}
	
	public int getNumber(){
		return number;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public String getImage(){
		return image;
	}
	
	public GeoPoint getLocation()
	{
		return location;
	}
	
	public Double getOther(){
		return other;
	}
	
}
