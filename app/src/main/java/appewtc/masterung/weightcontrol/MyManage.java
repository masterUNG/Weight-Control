package appewtc.masterung.weightcontrol;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 7/16/2016 AD.
 */
public class MyManage {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    //For foodTABLE
    public static final String food_table = "foodTABLE";
    public static final String column_food = "Food";
    public static final String column_unit = "Unit";
    public static final String column_calories = "Calories";

    //For exerciseTABLE
    public static final String exercise_table = "exerciseTABLE";
    public static final String column_exercise = "Exercise";
    public static final String column_burn = "Burn";


    public MyManage(Context context) {

        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

    }   // Constructor

    //Add Exercise
    public long addExercise(String strExercise,
                            String strBurn) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_exercise, strExercise);
        contentValues.put(column_burn, strBurn);

        return sqLiteDatabase.insert(exercise_table, null, contentValues);
    }


    //Add Food
    public long addFood(String strFood,
                        String strUnit,
                        String strCalories) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_food, strFood);
        contentValues.put(column_unit, strUnit);
        contentValues.put(column_calories, strCalories);

        return sqLiteDatabase.insert(food_table, null, contentValues);
    }

}   // Main Class
