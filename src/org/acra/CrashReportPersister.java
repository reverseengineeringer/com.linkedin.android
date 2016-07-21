package org.acra;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.acra.collector.CollectorUtil;
import org.acra.collector.CrashReportData;

final class CrashReportPersister
{
  private final Context context;
  
  CrashReportPersister(Context paramContext)
  {
    context = paramContext;
  }
  
  private static void dumpString(StringBuilder paramStringBuilder, String paramString, boolean paramBoolean)
  {
    int j = 0;
    int i = j;
    if (!paramBoolean)
    {
      i = j;
      if (paramString.length() > 0)
      {
        i = j;
        if (paramString.charAt(0) == ' ')
        {
          paramStringBuilder.append("\\ ");
          i = 0 + 1;
        }
      }
    }
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      case '\013': 
      default: 
        if (("\\#!=:".indexOf(c) >= 0) || ((paramBoolean) && (c == ' '))) {
          paramStringBuilder.append('\\');
        }
        if ((c >= ' ') && (c <= '~')) {
          paramStringBuilder.append(c);
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        paramStringBuilder.append("\\t");
        continue;
        paramStringBuilder.append("\\n");
        continue;
        paramStringBuilder.append("\\f");
        continue;
        paramStringBuilder.append("\\r");
        continue;
        String str = Integer.toHexString(c);
        paramStringBuilder.append("\\u");
        j = 0;
        while (j < 4 - str.length())
        {
          paramStringBuilder.append("0");
          j += 1;
        }
        paramStringBuilder.append(str);
      }
    }
  }
  
  private CrashReportData load(Reader paramReader)
    throws IOException
  {
    int j = 0;
    int i2 = 0;
    int i1 = 0;
    int k;
    int i5;
    CrashReportData localCrashReportData;
    Object localObject3;
    int n;
    int m;
    char c;
    Object localObject2;
    int i7;
    int i3;
    int i6;
    int i;
    label295:
    label372:
    int i4;
    for (;;)
    {
      try
      {
        localObject1 = new char[40];
        k = -1;
        i5 = 1;
        localCrashReportData = new CrashReportData();
        localObject3 = new BufferedReader(paramReader, 8192);
        n = 0;
        m = ((BufferedReader)localObject3).read();
        if (m == -1) {
          break;
        }
        c = (char)m;
        localObject2 = localObject1;
        if (n == localObject1.length)
        {
          localObject2 = new char[localObject1.length * 2];
          System.arraycopy(localObject1, 0, localObject2, 0, n);
        }
        i7 = i1;
        i3 = j;
        m = n;
        i6 = i2;
        if (j != 2) {
          break label744;
        }
        m = Character.digit(c, 16);
        if (m >= 0)
        {
          m = (i2 << 4) + m;
          i3 = i1 + 1;
          localObject1 = localObject2;
          i1 = i3;
          i2 = m;
          if (i3 < 4) {
            continue;
          }
          j = i3;
          i2 = m;
          break label703;
        }
        j = i1;
        if (i1 > 4) {
          break label703;
        }
        throw new IllegalArgumentException("luni.09");
      }
      finally {}
      j = 3;
      localObject1 = localObject2;
      i1 = i7;
      n = m;
      i2 = i6;
      continue;
      j = 5;
      localObject1 = localObject2;
      i1 = i7;
      n = m;
      i2 = i6;
      continue;
      i = 8;
      break label838;
      i = 12;
      break label838;
      i = 10;
      break label838;
      i = 13;
      break label838;
      i = 9;
      break label838;
      j = 2;
      i1 = 0;
      i2 = 0;
      localObject1 = localObject2;
      n = m;
      continue;
      switch (c)
      {
      default: 
        i4 = i3;
        if (!Character.isWhitespace(c)) {
          break label1166;
        }
        i4 = i3;
        if (i3 != 3) {
          break label893;
        }
        i4 = 5;
        break label893;
        label399:
        do
        {
          i4 = ((BufferedReader)localObject3).read();
          localObject1 = localObject2;
          i1 = i7;
          j = i3;
          n = m;
          i2 = i6;
          if (i4 == -1) {
            break;
          }
          i4 = (char)i4;
          localObject1 = localObject2;
          i1 = i7;
          j = i3;
          n = m;
          i2 = i6;
          if (i4 == 13) {
            break;
          }
          localObject1 = localObject2;
          i1 = i7;
          j = i3;
          n = m;
          i2 = i6;
          if (i4 == 10) {
            break;
          }
        } while (i4 != 133);
        localObject1 = localObject2;
        i1 = i7;
        j = i3;
        n = m;
        i2 = i6;
      }
    }
    label522:
    Object localObject1 = new String((char[])localObject2, 0, m);
    localCrashReportData.put(Enum.valueOf(ReportField.class, ((String)localObject1).substring(0, j)), ((String)localObject1).substring(j));
    break label1073;
    if ((j == 2) && (i1 <= 4)) {
      throw new IllegalArgumentException("luni.08");
    }
    for (;;)
    {
      if (m >= 0)
      {
        localObject1 = new String((char[])localObject1, 0, n);
        localObject3 = (ReportField)Enum.valueOf(ReportField.class, ((String)localObject1).substring(0, m));
        localObject2 = ((String)localObject1).substring(m);
        localObject1 = localObject2;
        if (j == 1) {
          localObject1 = (String)localObject2 + "\000";
        }
        localCrashReportData.put((Enum)localObject3, localObject1);
      }
      CollectorUtil.safeClose(paramReader);
      return localCrashReportData;
      label703:
      do
      {
        n = m;
        localObject1 = localObject2;
        i1 = j;
        j = i4;
        break;
        i3 = 0;
        i4 = 0;
        m = n + 1;
        localObject2[n] = ((char)i2);
      } while ((c != '\n') && (c != ''));
      i6 = i2;
      i7 = j;
      label744:
      if (i3 != 1) {
        break label295;
      }
      j = 0;
      switch (c)
      {
      }
      i = c;
      for (;;)
      {
        label838:
        i5 = 0;
        n = j;
        if (j == 4)
        {
          k = m;
          n = 0;
        }
        localObject2[m] = i;
        m += 1;
        localObject1 = localObject2;
        i1 = i7;
        j = n;
        n = m;
        i2 = i6;
        break;
        label893:
        localObject1 = localObject2;
        i1 = i7;
        j = i4;
        n = m;
        i2 = i6;
        if (m == 0) {
          break;
        }
        localObject1 = localObject2;
        i1 = i7;
        j = i4;
        n = m;
        i2 = i6;
        if (m == k) {
          break;
        }
        localObject1 = localObject2;
        i1 = i7;
        j = i4;
        n = m;
        i2 = i6;
        if (i4 == 5) {
          break;
        }
        if (k == -1)
        {
          j = 4;
          localObject1 = localObject2;
          i1 = i7;
          n = m;
          i2 = i6;
          break;
          if (i5 == 0) {
            break label372;
          }
          break label399;
          if (i3 == 3)
          {
            j = 5;
            localObject1 = localObject2;
            i1 = i7;
            n = m;
            i2 = i6;
            break;
          }
          n = 0;
          i5 = 1;
          if ((m > 0) || ((m == 0) && (k == 0)))
          {
            j = k;
            if (k != -1) {
              break label522;
            }
            j = m;
            break label522;
          }
          label1073:
          k = -1;
          m = 0;
          localObject1 = localObject2;
          i1 = i7;
          j = n;
          n = m;
          i2 = i6;
          break;
          if (i3 == 4) {
            k = m;
          }
          j = 1;
          localObject1 = localObject2;
          i1 = i7;
          n = m;
          i2 = i6;
          break;
          if (k != -1) {
            break label372;
          }
          j = 0;
          k = m;
          localObject1 = localObject2;
          i1 = i7;
          n = m;
          i2 = i6;
          break;
        }
        label1166:
        if (i4 != 5)
        {
          j = i4;
          i = c;
          if (i4 != 3) {}
        }
        else
        {
          j = 0;
          i = c;
        }
      }
      m = k;
      if (k == -1)
      {
        m = k;
        if (n > 0) {
          m = n;
        }
      }
    }
  }
  
  public final CrashReportData load(String paramString)
    throws IOException
  {
    FileInputStream localFileInputStream = context.openFileInput(paramString);
    if (localFileInputStream == null) {
      throw new IllegalArgumentException("Invalid crash report fileName : " + paramString);
    }
    try
    {
      paramString = load(new InputStreamReader(new BufferedInputStream(localFileInputStream, 8192), "ISO8859-1"));
      return paramString;
    }
    finally
    {
      localFileInputStream.close();
    }
  }
  
  public final void store(CrashReportData paramCrashReportData, String paramString)
    throws IOException
  {
    paramString = context.openFileOutput(paramString, 0);
    OutputStreamWriter localOutputStreamWriter;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(200);
      localOutputStreamWriter = new OutputStreamWriter(paramString, "ISO8859_1");
      paramCrashReportData = paramCrashReportData.entrySet().iterator();
      while (paramCrashReportData.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCrashReportData.next();
        dumpString(localStringBuilder, ((ReportField)localEntry.getKey()).toString(), true);
        localStringBuilder.append('=');
        dumpString(localStringBuilder, (String)localEntry.getValue(), false);
        localStringBuilder.append("\n");
        localOutputStreamWriter.write(localStringBuilder.toString());
        localStringBuilder.setLength(0);
      }
    }
    finally
    {
      paramString.close();
    }
    paramString.close();
  }
}

/* Location:
 * Qualified Name:     org.acra.CrashReportPersister
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */