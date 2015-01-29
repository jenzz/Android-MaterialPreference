package com.jenzz.materialpreference;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Extension of ImageView that correctly applies maxWidth and maxHeight.
 */
public class PreferenceImageView extends ImageView {

  private int maxWidth = Integer.MAX_VALUE;
  private int maxHeight = Integer.MAX_VALUE;

  public PreferenceImageView(Context context) {
    super(context);
  }

  public PreferenceImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public PreferenceImageView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public PreferenceImageView(Context context, AttributeSet attrs, int defStyleAttr,
      int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  @Override
  public void setMaxWidth(int maxWidth) {
    super.setMaxWidth(maxWidth);
    this.maxWidth = maxWidth;
  }

  @Override
  public void setMaxHeight(int maxHeight) {
    super.setMaxHeight(maxHeight);
    this.maxHeight = maxHeight;
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int widthMode = MeasureSpec.getMode(widthMeasureSpec);
    if (widthMode == MeasureSpec.AT_MOST || widthMode == MeasureSpec.UNSPECIFIED) {
      int widthSize = MeasureSpec.getSize(widthMeasureSpec);
      if (maxWidth != Integer.MAX_VALUE && (maxWidth < widthSize
          || widthMode == MeasureSpec.UNSPECIFIED)) {
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(maxWidth, MeasureSpec.AT_MOST);
      }
    }

    int heightMode = MeasureSpec.getMode(heightMeasureSpec);
    if (heightMode == MeasureSpec.AT_MOST || heightMode == MeasureSpec.UNSPECIFIED) {
      int heightSize = MeasureSpec.getSize(heightMeasureSpec);
      if (maxHeight != Integer.MAX_VALUE && (maxHeight < heightSize
          || heightMode == MeasureSpec.UNSPECIFIED)) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST);
      }
    }

    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
  }
}