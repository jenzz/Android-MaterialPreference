package com.jenzz.materialpreference;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;

import static android.os.Build.VERSION_CODES.LOLLIPOP;
import static android.support.v7.internal.VersionUtils.isAtLeastL;

final class ThemeUtils {

  // material_deep_teal_500
  static final int FALLBACK_COLOR = Color.parseColor("#009688");

  private ThemeUtils() {
    // no instances
  }

  @TargetApi(LOLLIPOP)
  static ThemeColors resolveColors(Context context) {
    Resources.Theme theme = context.getTheme();
    int accentColor = FALLBACK_COLOR;

    // on Lollipop, grab system colorAccent attribute
    if (isAtLeastL()) {
      TypedArray typedArray =
          theme.obtainStyledAttributes(new int[] { android.R.attr.colorAccent });
      accentColor = typedArray.getColor(0, accentColor);
      typedArray.recycle();
    } else {
      // pre-Lollipop, grab AppCompat colorAccent attribute
      TypedArray typedArray = theme.obtainStyledAttributes(new int[] { R.attr.colorAccent });
      accentColor = typedArray.getColor(0, accentColor);
      typedArray.recycle();
    }

    // finally, check for custom mp_colorAccent attribute
    TypedArray typedArray = theme.obtainStyledAttributes(new int[] { R.attr.mp_colorAccent });
    accentColor = typedArray.getColor(0, accentColor);
    typedArray.recycle();

    return new ThemeColors(accentColor);
  }

  static class ThemeColors {

    int accentColor;

    ThemeColors(int accentColor) {
      this.accentColor = accentColor;
    }
  }
}
