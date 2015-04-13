Android - MaterialPreference
============================
* A simple backward-compatible implementation of a Material Design Preference aka settings item
* XML layouts are taken from [Android Platform Framework Base](https://github.com/android/platform_frameworks_base)

Screenshots
-----------
* Here's a side-by-side comparison with a native Lollipop preference:

![alt text](https://raw.github.com/jenzz/Android-MaterialPreference/master/assets/Screenshot1.png "Material Preference Screenshot")

Usage
-----
In your settings XML file that describes your preferences (must be located in `res/xml/` folder)
just use the custom implementations like this:

```xml
<com.jenzz.materialpreference.PreferenceCategory
  android:title="Material Category">

  <com.jenzz.materialpreference.Preference
    android:title="Material Preference"
    android:summary="Material Summary" />

  <com.jenzz.materialpreference.CheckBoxPreference
    android:title="Material CheckBoxPreference"
    android:summaryOn="Material CheckBox Summary On"
    android:summaryOff="Material CheckBox Summary Off" />

</com.jenzz.materialpreference.PreferenceCategory>
```

That's it. You can use all the attributes you know from the original preferences.

You're probably wondering why there are only Material Design versions
of [`Preference`](http://developer.android.com/reference/android/preference/Preference.html),
[`PreferenceCategory`](http://developer.android.com/reference/android/preference/PreferenceCategory.html)
and [`CheckBoxPreference`](http://developer.android.com/reference/android/preference/CheckBoxPreference.html).
Where are [`ListPreference`](http://developer.android.com/reference/android/preference/ListPreference.html),
[`EditTextPreference`](http://developer.android.com/reference/android/preference/EditTextPreference.html), etc?
I don't use them. Instead I just show a simple [`Preference`](http://developer.android.com/reference/android/preference/Preference.html)
and display a Material Design dialog when the user selects it.
I highly recommend using the [material-dialogs](https://github.com/afollestad/material-dialogs) library for that.

Theming
-------
* On Lollipop, the preference color is derived from the `android:colorAccent` attribute of your app theme.
* If you're using AppCompat, it is inherited from the `colorAccent` attribute.
* If you want a totally different color for your preferences (why would you?), you can still override it in your app theme like this:

```xml
<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
  <item name="mp_colorAccent">#bada55</item>
</style>
```

Also note that the `Activity` hosting your preferences screen **must** extend `ActionBarActivity` in order for the `CheckBox` tinting to work.
The easiest solution to accomplish that is to delegate all your preferences logic (including the inflation) to a `PreferenceFragment`
just like it is done in the [sample project](https://github.com/jenzz/Android-MaterialPreference/tree/master/sample).

Example
-------
Check out the [sample project](https://github.com/jenzz/Android-MaterialPreference/tree/master/sample) for an example implementation.

Download
--------

Grab it via Gradle:

```groovy
compile 'com.jenzz:materialpreference:1.3'
```

License
-------
This project is licensed under the [MIT License](https://raw.githubusercontent.com/jenzz/Android-MaterialPreference/master/LICENSE).