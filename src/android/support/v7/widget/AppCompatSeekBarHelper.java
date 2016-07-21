package android.support.v7.widget;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

final class AppCompatSeekBarHelper
  extends AppCompatProgressBarHelper
{
  private static final int[] TINT_ATTRS = { 16843074 };
  private final SeekBar mView;
  
  AppCompatSeekBarHelper(SeekBar paramSeekBar, AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    super(paramSeekBar, paramAppCompatDrawableManager);
    mView = paramSeekBar;
  }
  
  final void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    super.loadFromAttributes(paramAttributeSet, paramInt);
    paramAttributeSet = TintTypedArray.obtainStyledAttributes$89ace2b(mView.getContext(), paramAttributeSet, TINT_ATTRS, paramInt);
    Drawable localDrawable = paramAttributeSet.getDrawableIfKnown(0);
    if (localDrawable != null) {
      mView.setThumb(localDrawable);
    }
    mWrapped.recycle();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AppCompatSeekBarHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */