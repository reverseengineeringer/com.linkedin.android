package android.support.v4.text;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

public final class TextUtilsCompat
{
  private static String ARAB_SCRIPT_SUBTAG;
  private static String HEBR_SCRIPT_SUBTAG;
  private static final TextUtilsCompatImpl IMPL;
  public static final Locale ROOT;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17) {}
    for (IMPL = new TextUtilsCompatJellybeanMr1Impl((byte)0);; IMPL = new TextUtilsCompatImpl((byte)0))
    {
      ROOT = new Locale("", "");
      ARAB_SCRIPT_SUBTAG = "Arab";
      HEBR_SCRIPT_SUBTAG = "Hebr";
      return;
    }
  }
  
  public static int getLayoutDirectionFromLocale(Locale paramLocale)
  {
    return IMPL.getLayoutDirectionFromLocale(paramLocale);
  }
  
  private static class TextUtilsCompatImpl
  {
    public int getLayoutDirectionFromLocale(Locale paramLocale)
    {
      int j = 1;
      if ((paramLocale != null) && (!paramLocale.equals(TextUtilsCompat.ROOT)))
      {
        String str = ICUCompat.maximizeAndGetScript(paramLocale);
        int i;
        if (str == null)
        {
          i = j;
          switch (Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0)))
          {
          default: 
            i = 0;
          }
        }
        do
        {
          do
          {
            return i;
            i = j;
          } while (str.equalsIgnoreCase(TextUtilsCompat.ARAB_SCRIPT_SUBTAG));
          i = j;
        } while (str.equalsIgnoreCase(TextUtilsCompat.HEBR_SCRIPT_SUBTAG));
      }
      return 0;
    }
  }
  
  private static final class TextUtilsCompatJellybeanMr1Impl
    extends TextUtilsCompat.TextUtilsCompatImpl
  {
    private TextUtilsCompatJellybeanMr1Impl()
    {
      super();
    }
    
    public final int getLayoutDirectionFromLocale(Locale paramLocale)
    {
      return TextUtils.getLayoutDirectionFromLocale(paramLocale);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.text.TextUtilsCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */