package com.linkedin.android.artdeco;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.widget.TextView;
import java.util.Locale;

public final class ArtDeco
{
  public static boolean isCJK()
  {
    String str = Locale.getDefault().getLanguage();
    return (str.equalsIgnoreCase("ja")) || (str.equalsIgnoreCase("ko")) || (str.equalsIgnoreCase("zh"));
  }
  
  public static void setTextViewAppearance(TextView paramTextView, int paramInt, Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      paramTextView.setTextAppearance(paramContext, paramInt);
    }
    for (;;)
    {
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, new int[] { R.attr.fontPath });
      try
      {
        String str = localTypedArray.getString(0);
        if (str != null)
        {
          boolean bool = str.isEmpty();
          if (!bool) {}
        }
        else
        {
          return;
          paramTextView.setTextAppearance(paramInt);
          continue;
        }
        paramContext = ArtDecoTypefaceLoader.typefaceForFontPath(paramContext.getAssets(), str);
        if (paramContext != null) {
          paramTextView.setTypeface(paramContext);
        }
        return;
      }
      finally
      {
        localTypedArray.recycle();
      }
    }
  }
  
  public static boolean shouldFallback()
  {
    String str = Locale.getDefault().getLanguage();
    return (str.equalsIgnoreCase("ar")) || (str.equalsIgnoreCase("ja")) || (str.equalsIgnoreCase("ko")) || (str.equalsIgnoreCase("th")) || (str.equalsIgnoreCase("zh"));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.artdeco.ArtDeco
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */