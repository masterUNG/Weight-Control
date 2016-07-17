package appewtc.masterung.weightcontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BurnListView extends AppCompatActivity {

    //Explicit
    private String dateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burn_list_view);

        dateString = getIntent().getStringExtra("Date");

        TextView textView = (TextView) findViewById(R.id.txtBurnList);
        textView.setText("Date = " + dateString);


    }   // Main Method

    public void clickAddBurn(View view) {

        Intent intent = new Intent(BurnListView.this, AddBurnActivity.class);
        intent.putExtra("Date", dateString);
        startActivity(intent);

    }

    public void clickBackBurn(View view) {
        finish();
    }

}   // Main Class
