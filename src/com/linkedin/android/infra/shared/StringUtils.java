package com.linkedin.android.infra.shared;

import android.text.TextUtils;
import javax.inject.Inject;

public final class StringUtils
{
  public static boolean isEmptyTrimmed(CharSequence paramCharSequence)
  {
    return TextUtils.getTrimmedLength(paramCharSequence) == 0;
  }
  
  public static boolean isHiraganaOrKatakana(String paramString)
  {
    boolean bool = false;
    char[] arrayOfChar = paramString.toCharArray();
    int j = arrayOfChar.length;
    int i = 0;
    if (i < j) {
      if (Character.UnicodeBlock.of(arrayOfChar[i]) != Character.UnicodeBlock.HIRAGANA)
      {
        i = 0;
        label35:
        if (i == 0)
        {
          paramString = paramString.toCharArray();
          j = paramString.length;
          i = 0;
          label49:
          if (i >= j) {
            break label109;
          }
          char c = paramString[i];
          if ((Character.UnicodeBlock.of(c) == Character.UnicodeBlock.KATAKANA) || (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS)) {
            break label102;
          }
        }
      }
    }
    label102:
    label109:
    for (i = 0;; i = 1)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
      i += 1;
      break;
      i = 1;
      break label35;
      i += 1;
      break label49;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.StringUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */