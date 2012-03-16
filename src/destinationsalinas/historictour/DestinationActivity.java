package destinationsalinas.historictour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DestinationActivity extends Activity{
	
	TextView title;
	TextView address;
	TextView number;
	TextView desc;
	
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination);
        title = (TextView) findViewById(R.id.title);
    	address = (TextView) findViewById(R.id.address);
    	number = (TextView) findViewById(R.id.number);
    	desc = (TextView) findViewById(R.id.desc);
    }


    public void setDestination(String[] data){
    	title.setText(data[1]);
    	address.setText(data[2]);
    	number.setText(data[3]);
    	desc.setText(data[4]);
    }
    
    public void callSite(View v){
    	try {
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number.getText())));
          } catch (Exception e) {
            e.printStackTrace();
            desc.setText("Damn it!");
          }
    }
    
    public void callTour(View v){
    	try {
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "8314019587")));
          } catch (Exception e) {
            e.printStackTrace();
            desc.setText("Damn it!");
          }
    	}
}

