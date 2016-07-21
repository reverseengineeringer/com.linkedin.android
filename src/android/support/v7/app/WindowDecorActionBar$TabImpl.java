package android.support.v7.app;

import android.graphics.drawable.Drawable;
import android.view.View;

public final class WindowDecorActionBar$TabImpl
  extends ActionBar.Tab
{
  private CharSequence mContentDesc;
  private View mCustomView;
  private Drawable mIcon;
  int mPosition;
  private CharSequence mText;
  
  public final CharSequence getContentDescription()
  {
    return mContentDesc;
  }
  
  public final View getCustomView()
  {
    return mCustomView;
  }
  
  public final Drawable getIcon()
  {
    return mIcon;
  }
  
  public final int getPosition()
  {
    return mPosition;
  }
  
  public final CharSequence getText()
  {
    return mText;
  }
  
  public final void select()
  {
    this$0.selectTab(this);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.WindowDecorActionBar.TabImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */