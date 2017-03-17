package com.example.valentinkajdan.firstappli;


import android.app.NotificationManager;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPref extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preference);

        findPreference("notif").setOnPreferenceClickListener(
                new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        final NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.cancelAll();
                        return true;
                    }
                }
        );
    }

}
