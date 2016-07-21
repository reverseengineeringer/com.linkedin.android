package com.fasterxml.jackson.core.io;

import java.util.Arrays;

public final class CharTypes
{
  private static final byte[] HB;
  private static final char[] HC;
  static final int[] sHexValues;
  static final int[] sInputCodes;
  static final int[] sInputCodesComment;
  static final int[] sInputCodesJsNames;
  static final int[] sInputCodesUTF8;
  static final int[] sInputCodesUtf8JsNames;
  static final int[] sInputCodesWS;
  static final int[] sOutputEscapes128;
  
  static
  {
    Object localObject = "0123456789ABCDEF".toCharArray();
    HC = (char[])localObject;
    int j = localObject.length;
    HB = new byte[j];
    int i = 0;
    while (i < j)
    {
      HB[i] = ((byte)HC[i]);
      i += 1;
    }
    localObject = new int['Ā'];
    i = 0;
    while (i < 32)
    {
      localObject[i] = -1;
      i += 1;
    }
    localObject[34] = 1;
    localObject[92] = 1;
    sInputCodes = (int[])localObject;
    localObject = new int['Ā'];
    System.arraycopy(sInputCodes, 0, localObject, 0, 256);
    j = 128;
    if (j < 256)
    {
      if ((j & 0xE0) == 192) {
        i = 2;
      }
      for (;;)
      {
        localObject[j] = i;
        j += 1;
        break;
        if ((j & 0xF0) == 224) {
          i = 3;
        } else if ((j & 0xF8) == 240) {
          i = 4;
        } else {
          i = -1;
        }
      }
    }
    sInputCodesUTF8 = (int[])localObject;
    localObject = new int['Ā'];
    Arrays.fill((int[])localObject, -1);
    i = 33;
    while (i < 256)
    {
      if (Character.isJavaIdentifierPart((char)i)) {
        localObject[i] = 0;
      }
      i += 1;
    }
    localObject[64] = 0;
    localObject[35] = 0;
    localObject[42] = 0;
    localObject[45] = 0;
    localObject[43] = 0;
    sInputCodesJsNames = (int[])localObject;
    localObject = new int['Ā'];
    System.arraycopy(sInputCodesJsNames, 0, localObject, 0, 256);
    Arrays.fill((int[])localObject, 128, 128, 0);
    sInputCodesUtf8JsNames = (int[])localObject;
    localObject = new int['Ā'];
    System.arraycopy(sInputCodesUTF8, 128, localObject, 128, 128);
    Arrays.fill((int[])localObject, 0, 32, -1);
    localObject[9] = 0;
    localObject[10] = 10;
    localObject[13] = 13;
    localObject[42] = 42;
    sInputCodesComment = (int[])localObject;
    localObject = new int['Ā'];
    System.arraycopy(sInputCodesUTF8, 128, localObject, 128, 128);
    Arrays.fill((int[])localObject, 0, 32, -1);
    localObject[32] = 1;
    localObject[9] = 1;
    localObject[10] = 10;
    localObject[13] = 13;
    localObject[47] = 47;
    localObject[35] = 35;
    sInputCodesWS = (int[])localObject;
    localObject = new int[''];
    i = 0;
    while (i < 32)
    {
      localObject[i] = -1;
      i += 1;
    }
    localObject[34] = 34;
    localObject[92] = 92;
    localObject[8] = 98;
    localObject[9] = 116;
    localObject[12] = 102;
    localObject[10] = 110;
    localObject[13] = 114;
    sOutputEscapes128 = (int[])localObject;
    localObject = new int[''];
    sHexValues = (int[])localObject;
    Arrays.fill((int[])localObject, -1);
    i = 0;
    while (i < 10)
    {
      sHexValues[(i + 48)] = i;
      i += 1;
    }
    i = 0;
    while (i < 6)
    {
      sHexValues[(i + 97)] = (i + 10);
      sHexValues[(i + 65)] = (i + 10);
      i += 1;
    }
  }
  
  public static void appendQuoted(StringBuilder paramStringBuilder, String paramString)
  {
    int[] arrayOfInt = sOutputEscapes128;
    int k = arrayOfInt.length;
    int j = 0;
    int m = paramString.length();
    if (j < m)
    {
      int i = paramString.charAt(j);
      if ((i >= k) || (arrayOfInt[i] == 0)) {
        paramStringBuilder.append(i);
      }
      for (;;)
      {
        j += 1;
        break;
        paramStringBuilder.append('\\');
        int n = arrayOfInt[i];
        if (n < 0)
        {
          paramStringBuilder.append('u');
          paramStringBuilder.append('0');
          paramStringBuilder.append('0');
          paramStringBuilder.append(HC[(i >> 4)]);
          paramStringBuilder.append(HC[(i & 0xF)]);
        }
        else
        {
          paramStringBuilder.append((char)n);
        }
      }
    }
  }
  
  public static int charToHex(int paramInt)
  {
    if (paramInt > 127) {
      return -1;
    }
    return sHexValues[paramInt];
  }
  
  public static byte[] copyHexBytes()
  {
    return (byte[])HB.clone();
  }
  
  public static char[] copyHexChars()
  {
    return (char[])HC.clone();
  }
  
  public static int[] get7BitOutputEscapes()
  {
    return sOutputEscapes128;
  }
  
  public static int[] getInputCodeComment()
  {
    return sInputCodesComment;
  }
  
  public static int[] getInputCodeLatin1()
  {
    return sInputCodes;
  }
  
  public static int[] getInputCodeLatin1JsNames()
  {
    return sInputCodesJsNames;
  }
  
  public static int[] getInputCodeUtf8()
  {
    return sInputCodesUTF8;
  }
  
  public static int[] getInputCodeUtf8JsNames()
  {
    return sInputCodesUtf8JsNames;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.io.CharTypes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */