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
	
	private String [] data = new String[5];
	private ArrayList<String[]> dataList = new ArrayList<String[]>();

	public DestinationManager(Resources res){
    	InputStream in;
    	
    	int rID = R.raw.destinations; 
    	in = res.openRawResource(rID);
    	try {
            byte[] buffer = new byte[in.available()];  
            in.read(buffer);  
            ByteArrayOutputStream oS = new ByteArrayOutputStream();  
            oS.write(buffer);
            
		    	StringTokenizer st;
				String line;
				line = oS.toString();
					st = new StringTokenizer(line, ":");
					while(st.hasMoreTokens()){

						for(int i = 0; i < 5; i++){
						data[i] = st.nextToken();
						}
						dataList.add(data);
					}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[] getDestination(int i){
		return dataList.get(i);
	}
}
