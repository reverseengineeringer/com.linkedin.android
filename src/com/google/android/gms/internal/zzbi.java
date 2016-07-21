package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@zzhb
public final class zzbi
{
  public static int zzx(String paramString)
  {
    int k = 0;
    int m = 0;
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
      j = m;
      switch (n & 0x3)
      {
      }
    }
    int n = paramString.length;
    int i1 = (n & 0xFFFFFFFC) + 0;
    int j = 0;
    for (int i = 0; j < i1; i = -430675100 + (i >>> 19 | i << 13) * 5)
    {
      int i2 = (paramString[j] & 0xFF | (paramString[(j + 1)] & 0xFF) << 8 | (paramString[(j + 2)] & 0xFF) << 16 | paramString[(j + 3)] << 24) * -862048943;
      i ^= (i2 >>> 17 | i2 << 15) * 461845907;
      j += 4;
    }
    for (;;)
    {
      i ^= n;
      i = (i ^ i >>> 16) * -2048144789;
      i = (i ^ i >>> 13) * -1028477387;
      return i ^ i >>> 16;
      j = (paramString[(i1 + 2)] & 0xFF) << 16;
      k = j | (paramString[(i1 + 1)] & 0xFF) << 8;
      j = (paramString[i1] & 0xFF | k) * -862048943;
      i = (j >>> 17 | j << 15) * 461845907 ^ i;
    }
  }
  
  public static String[] zzy(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    char[] arrayOfChar = paramString.toCharArray();
    int n = paramString.length();
    int j = 0;
    int i = 0;
    int k = 0;
    int i2;
    int i1;
    int m;
    if (k < n)
    {
      i2 = Character.codePointAt(arrayOfChar, k);
      i1 = Character.charCount(i2);
      if (Character.isLetter(i2))
      {
        paramString = Character.UnicodeBlock.of(i2);
        if ((paramString == Character.UnicodeBlock.BOPOMOFO) || (paramString == Character.UnicodeBlock.BOPOMOFO_EXTENDED) || (paramString == Character.UnicodeBlock.CJK_COMPATIBILITY) || (paramString == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (paramString == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT) || (paramString == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (paramString == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (paramString == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || (paramString == Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS) || (paramString == Character.UnicodeBlock.HANGUL_JAMO) || (paramString == Character.UnicodeBlock.HANGUL_SYLLABLES) || (paramString == Character.UnicodeBlock.HIRAGANA) || (paramString == Character.UnicodeBlock.KATAKANA) || (paramString == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS))
        {
          m = 1;
          label169:
          if (m == 0)
          {
            if (((i2 < 65382) || (i2 > 65437)) && ((i2 < 65441) || (i2 > 65500))) {
              break label291;
            }
            m = 1;
            label205:
            if (m == 0) {
              break label297;
            }
          }
          m = 1;
          label213:
          if (m == 0) {
            break label303;
          }
          if (j != 0) {
            localArrayList.add(new String(arrayOfChar, i, k - i));
          }
          localArrayList.add(new String(arrayOfChar, k, i1));
          m = 0;
          j = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      m = k + i1;
      k = j;
      j = i;
      i = k;
      k = m;
      break;
      m = 0;
      break label169;
      label291:
      m = 0;
      break label205;
      label297:
      m = 0;
      break label213;
      label303:
      if ((Character.isLetterOrDigit(i2)) || (Character.getType(i2) == 6) || (Character.getType(i2) == 8))
      {
        if (j == 0) {
          i = k;
        }
        j = i;
        i = 1;
      }
      else if (j != 0)
      {
        localArrayList.add(new String(arrayOfChar, i, k - i));
        j = i;
        i = 0;
        continue;
        if (j != 0) {
          localArrayList.add(new String(arrayOfChar, i, k - i));
        }
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
      else
      {
        m = i;
        i = j;
        j = m;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */