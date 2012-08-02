package destinationsalinas.historictour;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class GeneralInfoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_info);
    }
    
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.about, menu);
	        return true;
	    }
	    
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	            case R.id.about:	
	            	Toast.makeText(this, "Destination Salinas Self-Guided Tour App\n\tVersion 1.0\n\tCreated by:\n\t\tLyndon Curry\n\t\tCatrina Torda\n\t\tAlexander Kaufmann\n\t\tShalini Av", Toast.LENGTH_LONG).show();
	                break;
	        }
	        return true;
	    }
}