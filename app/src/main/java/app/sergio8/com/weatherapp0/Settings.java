package app.sergio8.com.weatherapp0;

import android.content.Context;
import android.content.SharedPreferences;

public class Settings
{

    private final static String KEY_CHANGE_TOWN = "ChangeTown";
    //private final static String KEY_SOME_PREF = "SomePref";

    public static String getChangeTown(Context cntx)
    {
        return getPrefs(cntx).getString(KEY_CHANGE_TOWN, "Moskov");
    }



    public static void setChangeTown(Context cntx, String changeTown)
    {
        getPrefs(cntx)
                .edit()
                .putString(KEY_CHANGE_TOWN, changeTown)
                .apply();
    }
    private static SharedPreferences getPrefs(Context cntx)
    {
        return cntx.getSharedPreferences("weathePrefs", Context.MODE_PRIVATE);

    }

    public static void setChangeTown(MainActivity mainActivity, String selectedItem) {
    }
}
