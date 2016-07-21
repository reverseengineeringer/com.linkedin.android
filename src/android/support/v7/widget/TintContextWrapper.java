package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.app.AppCompatDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class TintContextWrapper
  extends ContextWrapper
{
  private static final ArrayList<WeakReference<TintContextWrapper>> sCache = new ArrayList();
  private Resources mResources;
  private final Resources.Theme mTheme;
  
  private TintContextWrapper(Context paramContext)
  {
    super(paramContext);
    if (VectorEnabledTintResources.shouldBeUsed())
    {
      mTheme = getResources().newTheme();
      mTheme.setTo(paramContext.getTheme());
      return;
    }
    mTheme = null;
  }
  
  public static Context wrap(Context paramContext)
  {
    int j = 0;
    int i = j;
    if (!(paramContext instanceof TintContextWrapper))
    {
      i = j;
      if (!(paramContext.getResources() instanceof TintResources))
      {
        if (!(paramContext.getResources() instanceof VectorEnabledTintResources)) {
          break label90;
        }
        i = j;
      }
    }
    if (i != 0)
    {
      i = 0;
      j = sCache.size();
      for (;;)
      {
        if (i >= j) {
          break label123;
        }
        Object localObject = (WeakReference)sCache.get(i);
        if (localObject != null) {}
        for (localObject = (TintContextWrapper)((WeakReference)localObject).get();; localObject = null)
        {
          if ((localObject == null) || (((TintContextWrapper)localObject).getBaseContext() != paramContext)) {
            break label116;
          }
          return (Context)localObject;
          label90:
          if (AppCompatDelegate.isCompatVectorFromResourcesEnabled())
          {
            i = j;
            if (Build.VERSION.SDK_INT > 20) {
              break;
            }
          }
          i = 1;
          break;
        }
        label116:
        i += 1;
      }
      label123:
      paramContext = new TintContextWrapper(paramContext);
      sCache.add(new WeakReference(paramContext));
      return paramContext;
    }
    return paramContext;
  }
  
  public final Resources getResources()
  {
    if (mResources == null) {
      if (mTheme != null) {
        break label37;
      }
    }
    label37:
    for (Object localObject = new TintResources(this, super.getResources());; localObject = new VectorEnabledTintResources(this, super.getResources()))
    {
      mResources = ((Resources)localObject);
      return mResources;
    }
  }
  
  public final Resources.Theme getTheme()
  {
    if (mTheme == null) {
      return super.getTheme();
    }
    return mTheme;
  }
  
  public final void setTheme(int paramInt)
  {
    if (mTheme == null)
    {
      super.setTheme(paramInt);
      return;
    }
    mTheme.applyStyle(paramInt, true);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.TintContextWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */