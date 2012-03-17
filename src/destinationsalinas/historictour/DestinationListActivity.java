package destinationsalinas.historictour;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class DestinationListActivity extends Activity {

	private List<DestinationClass> destinationList;

	public List<DestinationClass> getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(List<DestinationClass> destinationList) {
		this.destinationList = destinationList;
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browsedestination);

		destinationList=new ArrayList<DestinationClass>();
		destinationList=DestinationManager.getDestinationList(this);
		for(int i=0;i<destinationList.size();i++){
			System.out.println("**"+destinationList.get(i).getAddress());
		}
		ListView browseDestinationList = (ListView) findViewById(R.id.destinationList);
		browseDestinationList.setAdapter(new DestinationAdapter(this,R.layout.destinationitem, destinationList));
		
	}

}