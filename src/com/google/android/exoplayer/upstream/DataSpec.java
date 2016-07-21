package com.google.android.exoplayer.upstream;

import android.net.Uri;
import com.google.android.exoplayer.util.Assertions;
import java.util.Arrays;

public final class DataSpec
{
  public final long absoluteStreamPosition;
  public final int flags;
  public final String key;
  public final long length;
  public final long position;
  public final byte[] postBody;
  public final Uri uri;
  
  public DataSpec(Uri paramUri)
  {
    this(paramUri, 0L, -1L, null, 1);
  }
  
  public DataSpec(Uri paramUri, long paramLong1, long paramLong2)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, null, 0);
  }
  
  private DataSpec(Uri paramUri, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt)
  {
    this(paramUri, paramLong1, paramLong2, paramLong3, paramString, paramInt, (byte)0);
  }
  
  private DataSpec(Uri paramUri, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt, byte paramByte)
  {
    if (paramLong1 >= 0L)
    {
      bool = true;
      Assertions.checkArgument(bool);
      if (paramLong2 < 0L) {
        break label103;
      }
      bool = true;
      label28:
      Assertions.checkArgument(bool);
      if ((paramLong3 <= 0L) && (paramLong3 != -1L)) {
        break label109;
      }
    }
    label103:
    label109:
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      uri = paramUri;
      postBody = null;
      absoluteStreamPosition = paramLong1;
      position = paramLong2;
      length = paramLong3;
      key = paramString;
      flags = paramInt;
      return;
      bool = false;
      break;
      bool = false;
      break label28;
    }
  }
  
  public DataSpec(Uri paramUri, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, paramString, paramInt);
  }
  
  public final String toString()
  {
    return "DataSpec[" + uri + ", " + Arrays.toString(postBody) + ", " + absoluteStreamPosition + ", " + position + ", " + length + ", " + key + ", " + flags + "]";
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.DataSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */