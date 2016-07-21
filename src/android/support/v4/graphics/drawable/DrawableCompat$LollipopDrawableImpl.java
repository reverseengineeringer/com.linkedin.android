package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class DrawableCompat$LollipopDrawableImpl
  extends DrawableCompat.KitKatDrawableImpl
{
  public final void applyTheme(Drawable paramDrawable, Resources.Theme paramTheme)
  {
    paramDrawable.applyTheme(paramTheme);
  }
  
  public final boolean canApplyTheme(Drawable paramDrawable)
  {
    return paramDrawable.canApplyTheme();
  }
  
  public final ColorFilter getColorFilter(Drawable paramDrawable)
  {
    return paramDrawable.getColorFilter();
  }
  
  public final void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws IOException, XmlPullParserException
  {
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  public final void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    paramDrawable.setHotspot(paramFloat1, paramFloat2);
  }
  
  public final void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void setTint(Drawable paramDrawable, int paramInt)
  {
    paramDrawable.setTint(paramInt);
  }
  
  public final void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    paramDrawable.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    paramDrawable.setTintMode(paramMode);
  }
  
  public Drawable wrap(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (!(paramDrawable instanceof TintAwareDrawable)) {
      localObject = new DrawableWrapperLollipop(paramDrawable);
    }
    return (Drawable)localObject;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat.LollipopDrawableImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */