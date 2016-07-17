package appewtc.masterung.weightcontrol;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
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

        //Create ListView
        createListView();

    }   // Main Method

    @Override
    protected void onRestart() {
        super.onRestart();
        createListView();
    }

    private void createListView() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM caloriesTABLE WHERE Date = " + "'" + dateString + "'", null);
        cursor.moveToFirst();
        String[] foodStrings = new String[cursor.getCount()];
        String[] caloriesStrings = new String[cursor.getCount()];

        for (int i=0;i<cursor.getCount();i += 1) {

            foodStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_food));
            caloriesStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_calories));
            cursor.moveToNext();

        }   // for
        cursor.close();
        ListView listView = (ListView) findViewById(R.id.listView);
        MyAdapter myAdapter = new MyAdapter(this, foodStrings, caloriesStrings);
        listView.setAdapter(myAdapter);

    }   // createListView

    public void clickAddCalories(View view) {
        Intent intent = new Intent(CaloriesListView.this, AddCaloriesActivity.class);
        intent.putExtra("Date", dateString);
        startActivity(intent);
    }

    public void clickBackCalories(View view) {
        finish();
    }

}   // Main Class
