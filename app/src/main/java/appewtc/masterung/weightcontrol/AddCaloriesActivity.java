package appewtc.masterung.weightcontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class AddCaloriesActivity extends AppCompatActivity {

    //Explicit
    private TextView textView;
    private ListView listView;
    private String dateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_calories);

        //Bind Widget
        textView = (TextView) findViewById(R.id.textView15);
        listView = (ListView) findViewById(R.id.listView2);

        //Get & Show Date
        dateString = getIntent().getStringExtra("Date");
        textView.setText("Date = " + dateString);



    }   // Main Method

}   // Main Class
