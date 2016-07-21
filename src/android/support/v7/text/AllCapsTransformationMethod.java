package android.support.v7.text;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public final class AllCapsTransformationMethod
  implements TransformationMethod
{
  private Locale mLocale;
  
  public AllCapsTransformationMethod(Context paramContext)
  {
    mLocale = getResourcesgetConfigurationlocale;
  }
  
  public final CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    if (paramCharSequence != null) {
      return paramCharSequence.toString().toUpperCase(mLocale);
    }
    return null;
  }
  
  public final void onFocusChanged(View paramView, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, Rect paramRect) {}
}

/* Location:
 * Qualified Name:     android.support.v7.text.AllCapsTransformationMethod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */