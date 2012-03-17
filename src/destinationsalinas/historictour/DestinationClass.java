package destinationsalinas.historictour;

public class DestinationClass {
	private int number;
	private String name;
	private String address;
	private String phone;
	private String desc;
	private String image;
	
	public DestinationClass(String [] data){
		number = Integer.parseInt(data[0]);
		name = data[1];
		address = data[2];
		phone = data[3];
		desc = data[4];
		image = data[5];	
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
	
	
}
