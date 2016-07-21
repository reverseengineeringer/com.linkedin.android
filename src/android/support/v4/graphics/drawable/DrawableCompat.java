package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat
{
  static final DrawableImpl IMPL = new BaseDrawableImpl();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      IMPL = new MDrawableImpl();
      return;
    }
    if (i >= 21)
    {
      IMPL = new LollipopDrawableImpl();
      return;
    }
    if (i >= 19)
    {
      IMPL = new KitKatDrawableImpl();
      return;
    }
    if (i >= 17)
    {
      IMPL = new JellybeanMr1DrawableImpl();
      return;
    }
    if (i >= 11)
    {
      IMPL = new HoneycombDrawableImpl();
      return;
    }
    if (i >= 5)
    {
      IMPL = new EclairDrawableImpl();
      return;
    }
  }
  
  public static void applyTheme(Drawable paramDrawable, Resources.Theme paramTheme)
  {
    IMPL.applyTheme(paramDrawable, paramTheme);
  }
  
  public static boolean canApplyTheme(Drawable paramDrawable)
  {
    return IMPL.canApplyTheme(paramDrawable);
  }
  
  public static int getAlpha(Drawable paramDrawable)
  {
    return IMPL.getAlpha(paramDrawable);
  }
  
  public static ColorFilter getColorFilter(Drawable paramDrawable)
  {
    return IMPL.getColorFilter(paramDrawable);
  }
  
  public static int getLayoutDirection(Drawable paramDrawable)
  {
    return IMPL.getLayoutDirection(paramDrawable);
  }
  
  public static void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    IMPL.inflate(paramDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  public static boolean isAutoMirrored(Drawable paramDrawable)
  {
    return IMPL.isAutoMirrored(paramDrawable);
  }
  
  public static void jumpToCurrentState(Drawable paramDrawable)
  {
    IMPL.jumpToCurrentState(paramDrawable);
  }
  
  public static void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean)
  {
    IMPL.setAutoMirrored(paramDrawable, paramBoolean);
  }
  
  public static void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    IMPL.setHotspot(paramDrawable, paramFloat1, paramFloat2);
  }
  
  public static void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.setHotspotBounds(paramDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setLayoutDirection(Drawable paramDrawable, int paramInt)
  {
    IMPL.setLayoutDirection(paramDrawable, paramInt);
  }
  
  public static void setTint(Drawable paramDrawable, int paramInt)
  {
    IMPL.setTint(paramDrawable, paramInt);
  }
  
  public static void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    IMPL.setTintList(paramDrawable, paramColorStateList);
  }
  
  public static void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    IMPL.setTintMode(paramDrawable, paramMode);
  }
  
  public static <T extends Drawable> T unwrap(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if ((paramDrawable instanceof DrawableWrapper)) {
      localDrawable = ((DrawableWrapper)paramDrawable).getWrappedDrawable();
    }
    return localDrawable;
  }
  
  public static Drawable wrap(Drawable paramDrawable)
  {
    return IMPL.wrap(paramDrawable);
  }
  
  static class BaseDrawableImpl
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
  
  static abstract interface DrawableImpl
  {
    public abstract void applyTheme(Drawable paramDrawable, Resources.Theme paramTheme);
    
    public abstract boolean canApplyTheme(Drawable paramDrawable);
    
    public abstract int getAlpha(Drawable paramDrawable);
    
    public abstract ColorFilter getColorFilter(Drawable paramDrawable);
    
    public abstract int getLayoutDirection(Drawable paramDrawable);
    
    public abstract void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
      throws IOException, XmlPullParserException;
    
    public abstract boolean isAutoMirrored(Drawable paramDrawable);
    
    public abstract void jumpToCurrentState(Drawable paramDrawable);
    
    public abstract void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean);
    
    public abstract void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2);
    
    public abstract void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void setLayoutDirection(Drawable paramDrawable, int paramInt);
    
    public abstract void setTint(Drawable paramDrawable, int paramInt);
    
    public abstract void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList);
    
    public abstract void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode);
    
    public abstract Drawable wrap(Drawable paramDrawable);
  }
  
  static class EclairDrawableImpl
    extends DrawableCompat.BaseDrawableImpl
  {
    public Drawable wrap(Drawable paramDrawable)
    {
      Object localObject = paramDrawable;
      if (!(paramDrawable instanceof TintAwareDrawable)) {
        localObject = new DrawableWrapperEclair(paramDrawable);
      }
      return (Drawable)localObject;
    }
  }
  
  static class HoneycombDrawableImpl
    extends DrawableCompat.EclairDrawableImpl
  {
    public final void jumpToCurrentState(Drawable paramDrawable)
    {
      paramDrawable.jumpToCurrentState();
    }
    
    public Drawable wrap(Drawable paramDrawable)
    {
      Object localObject = paramDrawable;
      if (!(paramDrawable instanceof TintAwareDrawable)) {
        localObject = new DrawableWrapperHoneycomb(paramDrawable);
      }
      return (Drawable)localObject;
    }
  }
  
  static class JellybeanMr1DrawableImpl
    extends DrawableCompat.HoneycombDrawableImpl
  {
    public int getLayoutDirection(Drawable paramDrawable)
    {
      int i = DrawableCompatJellybeanMr1.getLayoutDirection(paramDrawable);
      if (i >= 0) {
        return i;
      }
      return 0;
    }
    
    public void setLayoutDirection(Drawable paramDrawable, int paramInt)
    {
      if (!DrawableCompatJellybeanMr1.sSetLayoutDirectionMethodFetched) {}
      try
      {
        Method localMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[] { Integer.TYPE });
        DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod = localMethod;
        localMethod.setAccessible(true);
        DrawableCompatJellybeanMr1.sSetLayoutDirectionMethodFetched = true;
        if (DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod == null) {}
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;)
        {
          try
          {
            DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod.invoke(paramDrawable, new Object[] { Integer.valueOf(paramInt) });
            return;
          }
          catch (Exception paramDrawable)
          {
            Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", paramDrawable);
            DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod = null;
          }
          localNoSuchMethodException = localNoSuchMethodException;
          Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", localNoSuchMethodException);
        }
      }
    }
  }
  
  static class KitKatDrawableImpl
    extends DrawableCompat.JellybeanMr1DrawableImpl
  {
    public final int getAlpha(Drawable paramDrawable)
    {
      return paramDrawable.getAlpha();
    }
    
    public final boolean isAutoMirrored(Drawable paramDrawable)
    {
      return paramDrawable.isAutoMirrored();
    }
    
    public final void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean)
    {
      paramDrawable.setAutoMirrored(paramBoolean);
    }
    
    public Drawable wrap(Drawable paramDrawable)
    {
      Object localObject = paramDrawable;
      if (!(paramDrawable instanceof TintAwareDrawable)) {
        localObject = new DrawableWrapperKitKat(paramDrawable);
      }
      return (Drawable)localObject;
    }
  }
  
  static class LollipopDrawableImpl
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
  
  static final class MDrawableImpl
    extends DrawableCompat.LollipopDrawableImpl
  {
    public final int getLayoutDirection(Drawable paramDrawable)
    {
      return paramDrawable.getLayoutDirection();
    }
    
    public final void setLayoutDirection(Drawable paramDrawable, int paramInt)
    {
      paramDrawable.setLayoutDirection(paramInt);
    }
    
    public final Drawable wrap(Drawable paramDrawable)
    {
      return paramDrawable;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */