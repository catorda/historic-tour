package destinationsalinas.historictour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
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
	ImageView image;
	
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination);
        title = (TextView) findViewById(R.id.title);
    	address = (TextView) findViewById(R.id.address);
    	number = (TextView) findViewById(R.id.number);
    	desc = (TextView) findViewById(R.id.desc);
    	image = (ImageView) findViewById(R.id.image);
    }


    public void setDestination(DestinationClass data){
    	title.setText(data.getName());
    	address.setText(data.getAddress());
    	number.setText(data.getPhone());
    	desc.setText(data.getDesc());
    	image.setImageLevel(data.getNumber());
    }
    
    public void callSite(View v){
    	try {
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number.getText())));
          } catch (Exception e) {
            e.printStackTrace();
          }
    }
    
    public void callTour(View v){
    	try {
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "8314019587")));
          } catch (Exception e) {
            e.printStackTrace();
          }
    	}
}

