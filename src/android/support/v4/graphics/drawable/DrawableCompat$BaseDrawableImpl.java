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

class DrawableCompat$BaseDrawableImpl
  implements DrawableCompat.DrawableImpl
{
  public void applyTheme(Drawable paramDrawable, Resources.Theme paramTheme) {}
  
  public boolean canApplyTheme(Drawable paramDrawable)
  {
    return false;
  }
  
  public int getAlpha(Drawable paramDrawable)
  {
    return 0;
  }
  
  public ColorFilter getColorFilter(Drawable paramDrawable)
  {
    return null;
  }
  
  public int getLayoutDirection(Drawable paramDrawable)
  {
    return 0;
  }
  
  public void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws IOException, XmlPullParserException
  {
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }
  
  public boolean isAutoMirrored(Drawable paramDrawable)
  {
    return false;
  }
  
  public void jumpToCurrentState(Drawable paramDrawable) {}
  
  public void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean) {}
  
  public void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2) {}
  
  public void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setLayoutDirection(Drawable paramDrawable, int paramInt) {}
  
  public void setTint(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof TintAwareDrawable)) {
      ((TintAwareDrawable)paramDrawable).setTint(paramInt);
    }
  }
  
  public void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    if ((paramDrawable instanceof TintAwareDrawable)) {
      ((TintAwareDrawable)paramDrawable).setTintList(paramColorStateList);
    }
  }
  
  public void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    if ((paramDrawable instanceof TintAwareDrawable)) {
      ((TintAwareDrawable)paramDrawable).setTintMode(paramMode);
    }
  }
  
  public Drawable wrap(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (!(paramDrawable instanceof TintAwareDrawable)) {
      localObject = new DrawableWrapperDonut(paramDrawable);
    }
    return (Drawable)localObject;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat.BaseDrawableImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */