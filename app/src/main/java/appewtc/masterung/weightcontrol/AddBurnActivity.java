package appewtc.masterung.weightcontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AddBurnActivity extends AppCompatActivity {

    //Explicit
    private String dateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_burn);

        dateString = getIntent().getStringExtra("Date");
        TextView textView = (TextView) findViewById(R.id.txtBurnAdd);
        textView.setText("Date = " + dateString);


    }   // Main Method

}   // Main Class
