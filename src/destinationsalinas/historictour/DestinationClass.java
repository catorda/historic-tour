package destinationsalinas.historictour;

public class DestinationClass {
	private int number;
	private String name;
	private String address;
	private String phone;
	private String desc;
	private String image;
	private Double latitude;
	private Double longitude;
	private Double other;
	
	public DestinationClass(String [] data){
		number = Integer.parseInt(data[0]);
		name = data[1];
		address = data[2];
		phone = data[3];
		desc = data[4];
		image = data[5];	
		longitude = Double.parseDouble(data[6]);
		latitude = Double.parseDouble(data[7]);
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
	
	public Double getLatitude(){
		return latitude;
	}
	
	public Double getLongitdude(){
		return longitude;
	}
	
	public Double getOther(){
		return other;
	}
	
}
