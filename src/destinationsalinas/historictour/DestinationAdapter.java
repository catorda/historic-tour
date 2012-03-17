package destinationsalinas.historictour;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DestinationAdapter extends ArrayAdapter<DestinationClass>{
	
	private List<DestinationClass> destinationList;
	
	private Context context;

	public DestinationAdapter(Context context, int textViewResourceId,
			List<DestinationClass> objects) {
		super(context, textViewResourceId, objects);
		this.destinationList= objects;
		this.context=context;
		
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view=convertView;
		if(view==null){
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.destinationitem, null);
		}
		
		DestinationClass d=destinationList.get(position);
		TextView tv1=(TextView) view.findViewById(R.id.textView1);
		tv1.setText(d.getName());
		TextView tv2=(TextView) view.findViewById(R.id.textView2);
		tv2.setText(d.getAddress());
		TextView tv3=(TextView) view.findViewById(R.id.textView3);
		tv3.setText(d.getPhone());
		return view;
	}

}

