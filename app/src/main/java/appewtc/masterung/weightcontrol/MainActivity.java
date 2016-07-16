package appewtc.masterung.weightcontrol;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private MyManage myManage;
    private MyData myData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myManage = new MyManage(this);

        //Test Add Value
        //testAddValue();

        //Add First Data
        addFirstData();

    }   // Main Method

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
        for (int i=0;i<foodStrings.length;i+=1) {

            myManage.addFood(foodStrings[i],
                    unitStrings[i],
                    caloriesStrings[i]);

        }   // for




    }   // addFirstData

    private void testAddValue() {

        myManage.addFood("food", "unit", "calories");
        myManage.addExercise("exercise", "burn");

    }   // testAddValue


}   // Main Class
