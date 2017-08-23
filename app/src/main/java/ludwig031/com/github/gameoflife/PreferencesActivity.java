package ludwig031.com.github.gameoflife;

import android.content.Context;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceFragment;
import android.os.Bundle;

public class PreferencesActivity extends PreferenceActivity {

    private static final String OPTION_MINIMUM = "UNDERPOPULATION_VARIABLE";
    private static final String OPTION_MINIMUM_DEFAULT = "2";
    private static final String OPTION_MAXIMUM = "OVERPOPULATION_VARIABLE";
    private static final String OPTION_MAXIMUM_DEFAULT = "3";
    private static final String OPTION_SPAWN = "SPAWN_VARIABLE";
    private static final String OPTION_SPAWN_DEFAULT = "3";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }

    public static class MyPreferenceFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings);
        }
    }

    public static String getMinimumVariable(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).
                getString(OPTION_MINIMUM, OPTION_MINIMUM_DEFAULT);
    }

    public static String getMaximumVariable(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).
                getString(OPTION_MAXIMUM, OPTION_MAXIMUM_DEFAULT);
    }

    public static String getSpawnVariable(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).
                getString(OPTION_SPAWN, OPTION_SPAWN_DEFAULT);
    }
}