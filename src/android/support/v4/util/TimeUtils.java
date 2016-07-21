package android.support.v4.util;

import java.io.PrintWriter;

public final class TimeUtils
{
  private static char[] sFormatStr = new char[24];
  private static final Object sFormatSync = new Object();
  
  public static void formatDuration(long paramLong1, long paramLong2, PrintWriter paramPrintWriter)
  {
    if (paramLong1 == 0L)
    {
      paramPrintWriter.print("--");
      return;
    }
    formatDuration$112769eb(paramLong1 - paramLong2, paramPrintWriter);
  }
  
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter)
  {
    formatDuration$112769eb(paramLong, paramPrintWriter);
  }
  
  private static void formatDuration$112769eb(long paramLong, PrintWriter paramPrintWriter)
  {
    boolean bool2 = true;
    int j = 1;
    for (;;)
    {
      int i;
      boolean bool1;
      synchronized (sFormatSync)
      {
        if (sFormatStr.length < 0) {
          sFormatStr = new char[0];
        }
        char[] arrayOfChar = sFormatStr;
        if (paramLong != 0L) {
          break label301;
        }
        arrayOfChar[0] = '0';
        paramPrintWriter.print(new String(sFormatStr, 0, j));
        return;
        int i1 = (int)(paramLong % 1000L);
        j = (int)Math.floor(paramLong / 1000L);
        if (j <= 86400) {
          break label295;
        }
        k = j / 86400;
        j -= 86400 * k;
        if (j <= 3600) {
          break label289;
        }
        m = j / 3600;
        j -= m * 3600;
        if (j > 60)
        {
          n = j / 60;
          j -= n * 60;
          arrayOfChar[0] = i;
          k = printField$6419d3d2(arrayOfChar, k, 'd', 1, false);
          if (k == 1) {
            break label322;
          }
          bool1 = true;
          k = printField$6419d3d2(arrayOfChar, m, 'h', k, bool1);
          if (k == 1) {
            break label328;
          }
          bool1 = true;
          k = printField$6419d3d2(arrayOfChar, n, 'm', k, bool1);
          if (k == 1) {
            break label334;
          }
          bool1 = bool2;
          j = printField$6419d3d2(arrayOfChar, i1, 'm', printField$6419d3d2(arrayOfChar, j, 's', k, bool1), true);
          arrayOfChar[j] = 's';
          j += 1;
        }
      }
      int n = 0;
      continue;
      label289:
      int m = 0;
      continue;
      label295:
      int k = 0;
      continue;
      label301:
      if (paramLong > 0L)
      {
        i = 43;
      }
      else
      {
        paramLong = -paramLong;
        i = 45;
        continue;
        label322:
        bool1 = false;
        continue;
        label328:
        bool1 = false;
        continue;
        label334:
        bool1 = false;
      }
    }
  }
  
  private static int printField$6419d3d2(char[] paramArrayOfChar, int paramInt1, char paramChar, int paramInt2, boolean paramBoolean)
  {
    int i;
    if (!paramBoolean)
    {
      i = paramInt2;
      if (paramInt1 <= 0) {}
    }
    else
    {
      i = paramInt1;
      int j = paramInt2;
      if (paramInt1 > 99)
      {
        i = paramInt1 / 100;
        paramArrayOfChar[paramInt2] = ((char)(i + 48));
        j = paramInt2 + 1;
        i = paramInt1 - i * 100;
      }
      int k;
      if (i <= 9)
      {
        k = i;
        paramInt1 = j;
        if (paramInt2 == j) {}
      }
      else
      {
        paramInt2 = i / 10;
        paramArrayOfChar[j] = ((char)(paramInt2 + 48));
        paramInt1 = j + 1;
        k = i - paramInt2 * 10;
      }
      paramArrayOfChar[paramInt1] = ((char)(k + 48));
      paramInt1 += 1;
      paramArrayOfChar[paramInt1] = paramChar;
      i = paramInt1 + 1;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.util.TimeUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */