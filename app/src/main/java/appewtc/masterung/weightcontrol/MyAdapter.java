package appewtc.masterung.weightcontrol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by masterUNG on 7/17/2016 AD.
 */
public class MyAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] titleStrings, valueStrings;

    public MyAdapter(Context context,
                     String[] titleStrings,
                     String[] valueStrings) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.valueStrings = valueStrings;
    }   // Constructor

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        //Bind Widget
        TextView titleTextView = (TextView) view1.findViewById(R.id.textView16);
        TextView valueTextView = (TextView) view1.findViewById(R.id.textView17);

        //Set text
        titleTextView.setText(titleStrings[i]);
        valueTextView.setText(valueStrings[i]);

        return view1;
    }
}   // Main Class
