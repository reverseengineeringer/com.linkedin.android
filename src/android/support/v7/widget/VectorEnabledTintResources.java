package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.AppCompatDelegate;
import java.lang.ref.WeakReference;

public final class VectorEnabledTintResources
  extends Resources
{
  private final WeakReference<Context> mContextRef;
  
  public VectorEnabledTintResources(Context paramContext, Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    mContextRef = new WeakReference(paramContext);
  }
  
  public static boolean shouldBeUsed()
  {
    return (AppCompatDelegate.isCompatVectorFromResourcesEnabled()) && (Build.VERSION.SDK_INT <= 20);
  }
  
  public final Drawable getDrawable(int paramInt)
    throws Resources.NotFoundException
  {
    Context localContext = (Context)mContextRef.get();
    if (localContext != null)
    {
      AppCompatDrawableManager localAppCompatDrawableManager = AppCompatDrawableManager.get();
      Drawable localDrawable2 = localAppCompatDrawableManager.loadDrawableFromDelegates(localContext, paramInt);
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null) {
        localDrawable1 = super.getDrawable(paramInt);
      }
      if (localDrawable1 != null) {
        return localAppCompatDrawableManager.tintDrawable(localContext, paramInt, false, localDrawable1);
      }
      return null;
    }
    return super.getDrawable(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.VectorEnabledTintResources
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */