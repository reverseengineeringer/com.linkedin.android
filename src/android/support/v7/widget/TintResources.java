package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

final class TintResources
  extends ResourcesWrapper
{
  private final WeakReference<Context> mContextRef;
  
  public TintResources(Context paramContext, Resources paramResources)
  {
    super(paramResources);
    mContextRef = new WeakReference(paramContext);
  }
  
  public final Drawable getDrawable(int paramInt)
    throws Resources.NotFoundException
  {
    Drawable localDrawable = super.getDrawable(paramInt);
    Context localContext = (Context)mContextRef.get();
    if ((localDrawable != null) && (localContext != null))
    {
      AppCompatDrawableManager.get();
      AppCompatDrawableManager.tintDrawableUsingColorFilter(localContext, paramInt, localDrawable);
    }
    return localDrawable;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.TintResources
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */