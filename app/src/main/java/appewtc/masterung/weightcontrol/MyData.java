package appewtc.masterung.weightcontrol;

/**
 * Created by masterUNG on 7/16/2016 AD.
 */
public class MyData {

    //Explicit
    String[] foodStrings = new String[]{
            "กะเพาะปลา",
            "food2",
            "food3",
            "food4",
            "food5",
            "food6",
            "food7",
            "food8",
            "food9",
            "food10"};
    String[] unitStrings = new String[]{"จาน", "จาน", "ผล", "จาน", "จาน",
            "จาน", "จาน", "จาน", "ชาม", "จาน"};
    String[] caloriesStrings = new String[]{"100", "200", "300", "400", "500",
            "600", "100", "100", "100", "100"};

    String[] exerciseStrings = new String[]{"exercise0", "exercise1", "exercise2",
            "exercise3", "exercise4", "exercise5", "exercise6", "exercise7",
            "exercise8", "exercise9"};
    String[] burnStrings = new String[]{
            "100",
            "200",
            "300",
            "400",
            "500",
            "600",
            "100",
            "100",
            "100",
            "100"};

    public String[] getFoodStrings() {
        return foodStrings;
    }

    public String[] getUnitStrings() {
        return unitStrings;
    }

    public String[] getCaloriesStrings() {
        return caloriesStrings;
    }

    public String[] getExerciseStrings() {
        return exerciseStrings;
    }

    public String[] getBurnStrings() {
        return burnStrings;
    }
}   // MyData Class
