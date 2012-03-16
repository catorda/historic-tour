package destinationsalinas.historictour;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.BaseKeyListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.android.*;
import com.facebook.android.AsyncFacebookRunner.RequestListener;
import com.facebook.android.Facebook.DialogListener;

public class PostcardActivity extends Activity implements OnClickListener{

	private final String FACEBOOK_APP_ID = "266208693459714";
	private final String POSTCARD_PIC_KEY = "postcard-picture";
	private final int PICTURE_RESULT = 2387;
	Button signOn; 
	ImageView pictureHolder;
	Button takePicture;
	Facebook facebook = new Facebook(FACEBOOK_APP_ID);
	Bitmap pic; 

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.postcard);

		takePicture = (Button) findViewById(R.id.takepicture_button);
		takePicture.setOnClickListener(this);
		pictureHolder = (ImageView) findViewById(R.id.picturetaken_imageview);
		signOn = (Button) findViewById(R.id.signon);
		signOn.setOnClickListener(this);
		
		if(savedInstanceState != null && savedInstanceState.containsKey(POSTCARD_PIC_KEY)) {
			byte[] data = savedInstanceState.getByteArray(POSTCARD_PIC_KEY); 
			pic = BitmapFactory.decodeByteArray(data, 0, data.length); 
			pictureHolder.setImageBitmap(pic);
		}
	}

	@Override 
	protected void onSaveInstanceState(Bundle outState) {
		byte[] data = null;       
		if(pic != null) {
			Bitmap bi = pic;                   
			ByteArrayOutputStream baos = new ByteArrayOutputStream();                       
			bi.compress(Bitmap.CompressFormat.JPEG, 100, baos);                       
			data = baos.toByteArray();   
			outState.putByteArray(POSTCARD_PIC_KEY, data);
		}
		super.onSaveInstanceState(outState);
	}
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.signon) {
			if(!facebook.isSessionValid()) {
				
				String[] permissions = {"publish_stream","photo_upload" };
				
				Log.i("Facebook-Example", "not logged in");
				facebook.authorize(this, permissions, Facebook.FORCE_DIALOG_AUTH, new DialogListener() {
					@Override
					public void onComplete(Bundle values) {}

					@Override
					public void onFacebookError(FacebookError error) {}

					@Override
					public void onError(DialogError e) {}

					@Override
					public void onCancel() {}
				});
			}else {
				Log.i("Facebook-Example", "logged in");
				postImage();
			}

		} else if(v.getId() == R.id.takepicture_button) {
			Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);            
			this.startActivityForResult(camera, PICTURE_RESULT); 
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		facebook.authorizeCallback(requestCode, resultCode, data);
		if(requestCode == PICTURE_RESULT) {
			if (resultCode == Activity.RESULT_OK) {                 
				// Display image received on the view                  
				Bundle b = data.getExtras(); // Kept as a Bundle to check for other things in my actual code                  
				pic = (Bitmap) b.get("data");                   
				if (pic != null) { 
					// Display your image in an ImageView in your layout (if you want to test it)                      
					pictureHolder.setImageBitmap(pic);                      
					pictureHolder.invalidate();                  
				}              
			} else if (resultCode == Activity.RESULT_CANCELED) {
			} 
		}
	}

	public void postImage(){      
		byte[] data = null;                         
		Bitmap bi = pic;                   
		ByteArrayOutputStream baos = new ByteArrayOutputStream();                       
		bi.compress(Bitmap.CompressFormat.JPEG, 100, baos);                       
		data = baos.toByteArray();                         
		final Bundle params = new Bundle();                       
		params.putString(Facebook.TOKEN, facebook.getAccessToken());                       
		params.putString("method", "photos.upload");                       
		params.putByteArray("picture", data);
		//params.putString("caption", value)
		final AsyncFacebookRunner mAsyncRunner = new AsyncFacebookRunner(facebook);
		facebook.dialog(this, "photos.upload", new DialogListener() {

			@Override
			public void onComplete(Bundle values) {
				mAsyncRunner.request(null, params, "POST", new SampleUploadListener(), null);  
				Log.i("Facebook-Example", "image posted");
				
			}

			@Override
			public void onFacebookError(FacebookError e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onError(DialogError e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public class SampleUploadListener extends BaseKeyListener implements RequestListener {      
		public void onComplete(final String response, final Object state) {         
			try {             // process the response here: (executed in background thread)             
				Log.d("Facebook-Example", "Response: " + response.toString());             
				JSONObject json = Util.parseJson(response);             
				final String src = json.getString("src");              
				// then post the processed result back to the UI thread             
				// if we do not do this, an runtime exception will be generated             
				// e.g. "CalledFromWrongThreadException: Only the original             
				// thread that created a view hierarchy can touch its views."          
			} catch (JSONException e) {             
				Log.w("Facebook-Example", "JSON Error in response");         
			} catch (FacebookError e) {             
				Log.w("Facebook-Example", "Facebook Error: " + e.getMessage());         
			}     
		}      
		
		public void onFacebookError(FacebookError e, Object state) {         
			// TODO Auto-generated method stub      
		}      
		
		public Bitmap getInputType(Bitmap img) {         
			// TODO Auto-generated method stub         
			return img;     
		}      
		
		@Override     
		public int getInputType() {         
			// TODO Auto-generated method stub         
			return 0;     
		}      
		
		@Override     
		public void onIOException(IOException e, Object state) {         
			// TODO Auto-generated method stub      
		}      
		
		@Override     
		public void onFileNotFoundException(FileNotFoundException e, Object state) {         
			// TODO Auto-generated method stub      
		}      
		
		@Override     
		public void onMalformedURLException(MalformedURLException e, Object state) {         
			// TODO Auto-generated method stub      
		} 
	}  
		
	
	}



