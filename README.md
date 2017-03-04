DEPRECATED
==========
Android-MaterialPreference is deprecated. No more development will be taking place.

Use Google's official support libraries instead [com.android.support:preference-v7](https://developer.android.com/topic/libraries/support-library/packages.html#v7-preference) and [com.android.support:preference-v14](https://developer.android.com/topic/libraries/support-library/packages.html#v14-preference).

If you need some assistance in building a fully **Material Design** settings screen, here is a great series of blog articles on this topic:  
[Building an Android Settings Screen (Part 1) - How to Create and Fix the Overview Screen](https://medium.com/@JakobUlbrich/building-a-settings-screen-for-android-part-1-5959aa49337c)  
[Building an Android Settings Screen (Part 2) - How to Create and Fix the Dialogs](https://medium.com/@JakobUlbrich/building-a-settings-screen-for-android-part-2-2ba63e2d7d1d)  
[Building an Android Settings Screen (Part 3) - How to Create Custom Preferences](https://medium.com/@JakobUlbrich/building-a-settings-screen-for-android-part-3-ae9793fd31ec)  
[Building an Android Settings Screen (Part 4) - How to Use a Custom Layout for the Preference Fragment](https://medium.com/@JakobUlbrich/building-an-android-settings-screen-part-4-9558029827b7)

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