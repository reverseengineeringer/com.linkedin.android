package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class AppCompatPopupWindow
  extends PopupWindow
{
  private static final boolean COMPAT_OVERLAP_ANCHOR;
  private boolean mOverlapAnchor;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      COMPAT_OVERLAP_ANCHOR = bool;
      return;
    }
  }
  
  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = TintTypedArray.obtainStyledAttributes$89ace2b(paramContext, paramAttributeSet, R.styleable.PopupWindow, paramInt);
    boolean bool;
    if (paramContext.hasValue(R.styleable.PopupWindow_overlapAnchor))
    {
      bool = paramContext.getBoolean(R.styleable.PopupWindow_overlapAnchor, false);
      if (!COMPAT_OVERLAP_ANCHOR) {
        break label124;
      }
      mOverlapAnchor = bool;
    }
    for (;;)
    {
      setBackgroundDrawable(paramContext.getDrawable(R.styleable.PopupWindow_android_popupBackground));
      mWrapped.recycle();
      if (Build.VERSION.SDK_INT < 14) {}
      try
      {
        paramContext = PopupWindow.class.getDeclaredField("mAnchor");
        paramContext.setAccessible(true);
        paramAttributeSet = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
        paramAttributeSet.setAccessible(true);
        paramAttributeSet.set(this, new ViewTreeObserver.OnScrollChangedListener()
        {
          public final void onScrollChanged()
          {
            try
            {
              WeakReference localWeakReference = (WeakReference)val$fieldAnchor.get(jdField_this);
              if (localWeakReference != null)
              {
                if (localWeakReference.get() == null) {
                  return;
                }
                val$originalListener.onScrollChanged();
                return;
              }
            }
            catch (IllegalAccessException localIllegalAccessException) {}
          }
        });
        return;
      }
      catch (Exception paramContext)
      {
        label124:
        Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", paramContext);
      }
      PopupWindowCompat.setOverlapAnchor(this, bool);
    }
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (COMPAT_OVERLAP_ANCHOR)
    {
      i = paramInt2;
      if (mOverlapAnchor) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.showAsDropDown(paramView, paramInt1, i);
  }
  
  @TargetApi(19)
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    if (COMPAT_OVERLAP_ANCHOR)
    {
      i = paramInt2;
      if (mOverlapAnchor) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.showAsDropDown(paramView, paramInt1, i, paramInt3);
  }
  
  public void update(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt2;
    if (COMPAT_OVERLAP_ANCHOR)
    {
      i = paramInt2;
      if (mOverlapAnchor) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.update(paramView, paramInt1, i, paramInt3, paramInt4);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AppCompatPopupWindow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */