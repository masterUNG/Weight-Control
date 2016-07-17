package appewtc.masterung.weightcontrol;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private MyManage myManage;
    private MyData myData;
    private TextView dateTextView, nameTextView, bmrTextView,
            caloriesTextView, burnTextView, myBMRTextView;
    private String dateString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        dateTextView = (TextView) findViewById(R.id.textView8);
        nameTextView = (TextView) findViewById(R.id.textView9);
        bmrTextView = (TextView) findViewById(R.id.textView10);
        caloriesTextView = (TextView) findViewById(R.id.textView11);
        burnTextView = (TextView) findViewById(R.id.textView12);
        myBMRTextView = (TextView) findViewById(R.id.textView13);

        myManage = new MyManage(this);

        //Test Add Value
        //testAddValue();

        //Add First Data
        addFirstData();

        //CheckUserTABLE
        checkUserTABLE();

        //Show Date
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateString = dateFormat.format(calendar.getTime());
        dateTextView.setText("Date = " + dateString);

        //Show Name
        showName();

        //Show Calories
        showCalories();


    }   // Main Method

    public void clickCalories(View view) {
        Intent intent = new Intent(MainActivity.this, CaloriesListView.class);
        intent.putExtra("Date", dateString);
        startActivity(intent);
    }


    private void showCalories() {

        try {

            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                    MODE_PRIVATE, null);
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM caloriesTABLE WHERE Date = " + "'" + dateString + "'", null);
            cursor.moveToFirst();

            if (cursor.getCount() == 0) {
                caloriesTextView.setText("Calories ==> " + "?");
            } else {
            }


        } catch (Exception e) {
            Log.d("WeightV1", "e showCalories ==> " + e.toString());
            caloriesTextView.setText("Calories ==> " + "?");
        }

    }   // showCalories

    private void showName() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE", null);
        cursor.moveToFirst();
        String strName = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
        String strSurname = cursor.getString(cursor.getColumnIndex(MyManage.column_Surname));
        String strBMR = cursor.getString(cursor.getColumnIndex(MyManage.column_BMR));
        nameTextView.setText(strName + " " + strSurname);
        bmrTextView.setText("BMR = " + String.format("%.2f", Double.parseDouble(strBMR)));
        cursor.close();

    }   // showName

    private void checkUserTABLE() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE", null);
        cursor.moveToFirst();

        if (cursor.getCount() == 0) {
            startActivity(new Intent(MainActivity.this, SignUpActivity.class));
        }   // if
        cursor.close();


    }   // checkUser

    private void addFirstData() {

        //Delete All Data
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        sqLiteDatabase.delete(MyManage.food_table, null, null);
        sqLiteDatabase.delete(MyManage.exercise_table, null, null);

        //For foodTABLE
        myData = new MyData();
        String[] foodStrings = myData.getFoodStrings();
        String[] unitStrings = myData.getUnitStrings();
        String[] caloriesStrings = myData.getCaloriesStrings();
        for (int i = 0; i < foodStrings.length; i += 1) {

            myManage.addFood(foodStrings[i],
                    unitStrings[i],
                    caloriesStrings[i]);

        }   // for

        //For exerciseTABLE
        String[] exerciseStrings = myData.getExerciseStrings();
        String[] burnStrings = myData.getBurnStrings();
        for (int i = 0; i < exerciseStrings.length; i += 1) {
            myManage.addExercise(exerciseStrings[i], burnStrings[i]);
        }


    }   // addFirstData

    private void testAddValue() {

        myManage.addFood("food", "unit", "calories");
        myManage.addExercise("exercise", "burn");

    }   // testAddValue


}   // Main Class
