package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.util.AttributeSet;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;

final class AppCompatDrawableManager$AvdcInflateDelegate
  implements AppCompatDrawableManager.InflateDelegate
{
  public final Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    try
    {
      paramContext = AnimatedVectorDrawableCompat.createFromXmlInner(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", paramContext);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AppCompatDrawableManager.AvdcInflateDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */