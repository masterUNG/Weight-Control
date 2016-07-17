package appewtc.masterung.weightcontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CaloriesListView extends AppCompatActivity {

    //Explicit
    private String dateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_list_view);

        //Get Value from Intent
        dateString = getIntent().getStringExtra("Date");

        //Show Date
        TextView textView = (TextView) findViewById(R.id.textView14);
        textView.setText("Date = " + dateString);


    }   // Main Method

    public void clickAddCalories(View view) {
        Intent intent = new Intent(CaloriesListView.this, AddCaloriesActivity.class);
        intent.putExtra("Date", dateString);
        startActivity(intent);
    }

    public void clickBackCalories(View view) {
        finish();
    }

}   // Main Class
