package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public final class ResourcesCompat
{
  public static int getColor(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramResources.getColor(paramInt, paramTheme);
    }
    return paramResources.getColor(paramInt);
  }
  
  public static Drawable getDrawable(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramResources.getDrawable(paramInt, paramTheme);
    }
    return paramResources.getDrawable(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.res.ResourcesCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */