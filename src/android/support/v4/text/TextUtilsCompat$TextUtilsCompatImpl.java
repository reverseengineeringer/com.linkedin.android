package android.support.v4.text;

import java.util.Locale;

class TextUtilsCompat$TextUtilsCompatImpl
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
        } while (str.equalsIgnoreCase(TextUtilsCompat.access$000()));
        i = j;
      } while (str.equalsIgnoreCase(TextUtilsCompat.access$100()));
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.text.TextUtilsCompat.TextUtilsCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */