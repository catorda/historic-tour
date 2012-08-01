package destinationsalinas.historictour;

import java.util.ArrayList;
import java.util.List;

import destinationsalinas.historictour.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class DestinationListActivity extends Activity {

	private List<DestinationClass> destinationList;
	private ListView browseDestinationList;
	private ItemListener itemListener = new ItemListener();
	private boolean isHistoric = true;

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
		destinationList=GlobalVariables.destinationManager.getDestinationList();
		for(int i=0;i<destinationList.size();i++){
			System.out.println("**"+destinationList.get(i).getAddress());
		}
		browseDestinationList = (ListView) findViewById(R.id.destinationList); 
		
		browseDestinationList.setAdapter(new DestinationAdapter(this,R.layout.destinationitem, destinationList));
		browseDestinationList.setOnItemClickListener(itemListener);
	}
	
	private class ItemListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			DestinationClass clickedDest = destinationList.get(position);
			int destNum = clickedDest.getNumber(); 
			startDestinationActivity(destNum, view);
		}
		
	}
	
	protected void startDestinationActivity(int destNum, View v) {
		Intent i = new Intent(); 
		Log.i("DestinationListActivity", "" + destNum);
		i.putExtra("site.number", destNum);
		i.setClass(v.getContext(), DestinationActivity.class);
		this.startActivity(i);
	}
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.menu, menu);
	        return true;
	    }
	    
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	            case R.id.change:	
	            	if(isHistoric){
	            		Toast.makeText(this, "Changed to Eats & Sleeps", Toast.LENGTH_LONG).show();
	            		GlobalVariables.destinationManager.switchToHotel();
	            		isHistoric = false;
	            		item.setTitle("Change to Historic Sites");
	            	}else{
	            		Toast.makeText(this, "Changed to Historic Sites", Toast.LENGTH_LONG).show();
	            		GlobalVariables.destinationManager.switchToHistoric();
	            		isHistoric = true;
	            		item.setTitle("Change to Eats & Sleeps");
	            	}
	            	destinationList=GlobalVariables.destinationManager.getDestinationList();
	            	browseDestinationList = (ListView) findViewById(R.id.destinationList);
	        		browseDestinationList.setAdapter(new DestinationAdapter(this,R.layout.destinationitem, destinationList));
	        		browseDestinationList.setOnItemClickListener(itemListener);
	            	break;
	            case R.id.about:	
	            	Toast.makeText(this, "You pressed the icon and text!", Toast.LENGTH_LONG).show();
	                break;
	        }
	        return true;
	    }

}