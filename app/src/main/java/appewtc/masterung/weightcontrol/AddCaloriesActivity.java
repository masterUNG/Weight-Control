package appewtc.masterung.weightcontrol;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        //Read All foodTABLE ==> Create ListView
        readAnCreateListView();

    }   // Main Method

    private void readAnCreateListView() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM foodTABLE", null);
        cursor.moveToFirst();
        String[] foodStrings = new String[cursor.getCount()];
        String[] calStrings = new String[cursor.getCount()];
        String[] unitStrings = new String[cursor.getCount()];
        String[] valueStrings = new String[cursor.getCount()];

        for (int i = 0; i < cursor.getCount(); i += 1) {

            foodStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_food));
            calStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_calories));
            unitStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_unit));
            valueStrings[i] = calStrings[i] + " Kcal/" + unitStrings[i];

            cursor.moveToNext();
        }   // for
        cursor.close();

        MyAdapter myAdapter = new MyAdapter(this, foodStrings, valueStrings);
        listView.setAdapter(myAdapter);

    }   // read

}   // Main Class
