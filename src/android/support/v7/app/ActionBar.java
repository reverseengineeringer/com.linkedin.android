package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public abstract class ActionBar
{
  public boolean collapseActionView()
  {
    return false;
  }
  
  public void dispatchMenuVisibilityChanged(boolean paramBoolean) {}
  
  public abstract int getDisplayOptions();
  
  public float getElevation()
  {
    return 0.0F;
  }
  
  public Context getThemedContext()
  {
    return null;
  }
  
  public abstract void hide();
  
  public boolean invalidateOptionsMenu()
  {
    return false;
  }
  
  public abstract boolean isShowing();
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  void onDestroy() {}
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  boolean requestFocus()
  {
    return false;
  }
  
  public void setDefaultDisplayHomeAsUpEnabled(boolean paramBoolean) {}
  
  public abstract void setDisplayHomeAsUpEnabled(boolean paramBoolean);
  
  public abstract void setDisplayShowTitleEnabled(boolean paramBoolean);
  
  public void setElevation(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }
  }
  
  public void setHomeActionContentDescription(int paramInt) {}
  
  public void setHomeAsUpIndicator(Drawable paramDrawable) {}
  
  public abstract void setNavigationMode$13462e();
  
  public void setShowHideAnimationEnabled(boolean paramBoolean) {}
  
  public abstract void setTitle(CharSequence paramCharSequence);
  
  public void setWindowTitle(CharSequence paramCharSequence) {}
  
  public abstract void show();
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int gravity = 0;
    
    public LayoutParams()
    {
      super(-2);
      gravity = 8388627;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBarLayout);
      gravity = paramContext.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      gravity = gravity;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  public static abstract class Tab
  {
    public abstract CharSequence getContentDescription();
    
    public abstract View getCustomView();
    
    public abstract Drawable getIcon();
    
    public abstract int getPosition();
    
    public abstract CharSequence getText();
    
    public abstract void select();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.ActionBar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */