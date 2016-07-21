package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.support.v7.appcompat.R.style;
import android.view.LayoutInflater;

public final class ContextThemeWrapper
  extends ContextWrapper
{
  private LayoutInflater mInflater;
  private Resources.Theme mTheme;
  public int mThemeResource;
  
  public ContextThemeWrapper(Context paramContext, int paramInt)
  {
    super(paramContext);
    mThemeResource = paramInt;
  }
  
  public ContextThemeWrapper(Context paramContext, Resources.Theme paramTheme)
  {
    super(paramContext);
    mTheme = paramTheme;
  }
  
  private void initializeTheme()
  {
    if (mTheme == null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        mTheme = getResources().newTheme();
        Resources.Theme localTheme = getBaseContext().getTheme();
        if (localTheme != null) {
          mTheme.setTo(localTheme);
        }
      }
      mTheme.applyStyle(mThemeResource, true);
      return;
    }
  }
  
  public final Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (mInflater == null) {
        mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      return mInflater;
    }
    return getBaseContext().getSystemService(paramString);
  }
  
  public final Resources.Theme getTheme()
  {
    if (mTheme != null) {
      return mTheme;
    }
    if (mThemeResource == 0) {
      mThemeResource = R.style.Theme_AppCompat_Light;
    }
    initializeTheme();
    return mTheme;
  }
  
  public final void setTheme(int paramInt)
  {
    if (mThemeResource != paramInt)
    {
      mThemeResource = paramInt;
      initializeTheme();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.ContextThemeWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */