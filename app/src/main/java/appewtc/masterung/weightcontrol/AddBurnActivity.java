package appewtc.masterung.weightcontrol;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
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

        //Create ListView
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM exerciseTABLE", null);
        cursor.moveToFirst();
        String[] exerciseStrings = new String[cursor.getCount()];
        String[] burnStrings = new String[cursor.getCount()];

        for (int i=0;i<cursor.getCount();i+=1) {

            exerciseStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_exercise));
            burnStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_burn));
            cursor.moveToNext();

        }   // for
        cursor.close();
        MyAdapter myAdapter = new MyAdapter(this, exerciseStrings, burnStrings);
        ListView listView = (ListView) findViewById(R.id.livBurnAdd);
        listView.setAdapter(myAdapter);

        



    }   // Main Method

}   // Main Class
