package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.text.AllCapsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class AppCompatTextHelper
{
  private static final int[] TEXT_APPEARANCE_ATTRS = { R.attr.textAllCaps };
  private static final int[] VIEW_ATTRS = { 16842804, 16843119, 16843117, 16843120, 16843118 };
  private TintInfo mDrawableBottomTint;
  private TintInfo mDrawableLeftTint;
  private TintInfo mDrawableRightTint;
  private TintInfo mDrawableTopTint;
  final TextView mView;
  
  AppCompatTextHelper(TextView paramTextView)
  {
    mView = paramTextView;
  }
  
  static AppCompatTextHelper create(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new AppCompatTextHelperV17(paramTextView);
    }
    return new AppCompatTextHelper(paramTextView);
  }
  
  protected static TintInfo createTintInfo(Context paramContext, AppCompatDrawableManager paramAppCompatDrawableManager, int paramInt)
  {
    paramContext = paramAppCompatDrawableManager.getTintList(paramContext, paramInt);
    if (paramContext != null)
    {
      paramAppCompatDrawableManager = new TintInfo();
      mHasTintList = true;
      mTintList = paramContext;
      return paramAppCompatDrawableManager;
    }
    return null;
  }
  
  final void applyCompoundDrawableTint(Drawable paramDrawable, TintInfo paramTintInfo)
  {
    if ((paramDrawable != null) && (paramTintInfo != null)) {
      AppCompatDrawableManager.tintDrawable(paramDrawable, paramTintInfo, mView.getDrawableState());
    }
  }
  
  void applyCompoundDrawablesTints()
  {
    if ((mDrawableLeftTint != null) || (mDrawableTopTint != null) || (mDrawableRightTint != null) || (mDrawableBottomTint != null))
    {
      Drawable[] arrayOfDrawable = mView.getCompoundDrawables();
      applyCompoundDrawableTint(arrayOfDrawable[0], mDrawableLeftTint);
      applyCompoundDrawableTint(arrayOfDrawable[1], mDrawableTopTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], mDrawableRightTint);
      applyCompoundDrawableTint(arrayOfDrawable[3], mDrawableBottomTint);
    }
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = mView.getContext();
    Object localObject = AppCompatDrawableManager.get();
    TypedArray localTypedArray = localContext.obtainStyledAttributes(paramAttributeSet, VIEW_ATTRS, paramInt, 0);
    int k = localTypedArray.getResourceId(0, -1);
    if (localTypedArray.hasValue(1)) {
      mDrawableLeftTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject, localTypedArray.getResourceId(1, 0));
    }
    if (localTypedArray.hasValue(2)) {
      mDrawableTopTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject, localTypedArray.getResourceId(2, 0));
    }
    if (localTypedArray.hasValue(3)) {
      mDrawableRightTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject, localTypedArray.getResourceId(3, 0));
    }
    if (localTypedArray.hasValue(4)) {
      mDrawableBottomTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject, localTypedArray.getResourceId(4, 0));
    }
    localTypedArray.recycle();
    if (!(mView.getTransformationMethod() instanceof PasswordTransformationMethod))
    {
      boolean bool1 = false;
      boolean bool2 = false;
      int i = 0;
      int j = 0;
      if (k != -1)
      {
        localObject = localContext.obtainStyledAttributes(k, R.styleable.TextAppearance);
        bool1 = bool2;
        i = j;
        if (((TypedArray)localObject).hasValue(R.styleable.TextAppearance_textAllCaps))
        {
          i = 1;
          bool1 = ((TypedArray)localObject).getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        }
        ((TypedArray)localObject).recycle();
      }
      paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, TEXT_APPEARANCE_ATTRS, paramInt, 0);
      if (paramAttributeSet.hasValue(0))
      {
        i = 1;
        bool1 = paramAttributeSet.getBoolean(0, false);
      }
      paramAttributeSet.recycle();
      if (i != 0) {
        setAllCaps(bool1);
      }
    }
  }
  
  final void onSetTextAppearance(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramInt, TEXT_APPEARANCE_ATTRS);
    if (paramContext.hasValue(0)) {
      setAllCaps(paramContext.getBoolean(0, false));
    }
    paramContext.recycle();
  }
  
  final void setAllCaps(boolean paramBoolean)
  {
    TextView localTextView = mView;
    if (paramBoolean) {}
    for (AllCapsTransformationMethod localAllCapsTransformationMethod = new AllCapsTransformationMethod(mView.getContext());; localAllCapsTransformationMethod = null)
    {
      localTextView.setTransformationMethod(localAllCapsTransformationMethod);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AppCompatTextHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */