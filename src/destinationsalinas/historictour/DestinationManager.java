package destinationsalinas.historictour;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

import android.content.res.Resources;
import destinationsalinas.historictour.R;


public class DestinationManager {
	
	private ArrayList<DestinationClass> dataList = new ArrayList<DestinationClass>();
	String str;

	public DestinationManager(Resources res){
    	InputStream in;
    	
    	int rID = R.raw.destinations; 
    	in = res.openRawResource(rID);
    	try {
			BufferedReader f = new BufferedReader(new InputStreamReader(
					in));
			while (f.readLine() != null) {
				str = f.readLine();
				System.out.println("str" + str);
				String[] strArray = str.split(":");
						dataList.add(new DestinationClass(strArray));
					}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DestinationClass getDestinationBySiteNumber(int i){
		for(int k = 0; k < dataList.size(); k++){
			if(dataList.get(k).getNumber() == i){
				return dataList.get(k);
			}
		}
		return null;
	}
	
	public DestinationClass getDestination(int i){
		return dataList.get(i);
	}
	
	public int getSize(){
		return dataList.size();
	}
	
	public static ArrayList<DestinationClass> getDestinationList() { 
		return dataList;
	}

}
