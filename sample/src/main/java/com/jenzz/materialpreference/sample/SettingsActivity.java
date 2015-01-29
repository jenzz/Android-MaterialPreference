package com.jenzz.materialpreference.sample;

import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by jenzz on 28/01/15.
 */
public class SettingsActivity extends ActionBarActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // workaround for https://code.google.com/p/android/issues/detail?id=78701
    new Handler().post(new Runnable() {
      @Override public void run() {
        getFragmentManager().beginTransaction()
            .replace(android.R.id.content, new SettingsFragment())
            .commit();
      }
    });
  }

  public static class SettingsFragment extends PreferenceFragment {

    @Override public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      addPreferencesFromResource(R.xml.prefs);
    }
  }
}
