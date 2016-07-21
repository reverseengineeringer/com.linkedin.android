package com.google.android.exoplayer.util;

import android.text.TextUtils;

public final class Assertions
{
  public static void checkArgument(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException();
    }
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.valueOf(paramObject));
    }
  }
  
  public static String checkNotEmpty(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException();
    }
    return paramString;
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.Assertions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */