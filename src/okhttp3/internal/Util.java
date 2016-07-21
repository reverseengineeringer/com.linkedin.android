package okhttp3.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class Util
{
  public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final TimeZone UTC = TimeZone.getTimeZone("GMT");
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  
  public static void checkOffsetAndCount$487762af(long paramLong1, long paramLong2)
  {
    if (((0L | paramLong2) < 0L) || (0L > paramLong1) || (paramLong1 - 0L < paramLong2)) {
      throw new ArrayIndexOutOfBoundsException();
    }
  }
  
  public static void closeAll(Closeable paramCloseable1, Closeable paramCloseable2)
    throws IOException
  {
    Object localObject = null;
    try
    {
      paramCloseable1.close();
      paramCloseable1 = (Closeable)localObject;
    }
    catch (Throwable paramCloseable1)
    {
      label18:
      for (;;) {}
    }
    try
    {
      paramCloseable2.close();
      paramCloseable2 = paramCloseable1;
    }
    catch (Throwable localThrowable)
    {
      paramCloseable2 = paramCloseable1;
      if (paramCloseable1 != null) {
        break label18;
      }
      paramCloseable2 = localThrowable;
      break label18;
      if (!(paramCloseable2 instanceof IOException)) {
        break label51;
      }
      throw ((IOException)paramCloseable2);
      if (!(paramCloseable2 instanceof RuntimeException)) {
        break label63;
      }
      throw ((RuntimeException)paramCloseable2);
      if (!(paramCloseable2 instanceof Error)) {
        break label75;
      }
      throw ((Error)paramCloseable2);
      throw new AssertionError(paramCloseable2);
    }
    if (paramCloseable2 == null) {
      return;
    }
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static void closeQuietly(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.close();
      return;
    }
    catch (AssertionError paramSocket)
    {
      while (isAndroidGetsocknameError(paramSocket)) {}
      throw paramSocket;
    }
    catch (RuntimeException paramSocket)
    {
      throw paramSocket;
    }
    catch (Exception paramSocket) {}
  }
  
  public static String[] concat(String[] paramArrayOfString, String paramString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    arrayOfString[(arrayOfString.length - 1)] = paramString;
    return arrayOfString;
  }
  
  public static boolean contains(String[] paramArrayOfString, String paramString)
  {
    return Arrays.asList(paramArrayOfString).contains(paramString);
  }
  
  public static int delimiterOffset(String paramString, int paramInt1, int paramInt2, char paramChar)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString.charAt(paramInt1) == paramChar) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static int delimiterOffset(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static boolean discard$1a4e8ddd(Source paramSource, TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool = skipAll(paramSource, 100, paramTimeUnit);
      return bool;
    }
    catch (IOException paramSource) {}
    return false;
  }
  
  public static String domainToAscii(String paramString)
  {
    int k = 1;
    int i;
    int j;
    for (;;)
    {
      try
      {
        paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
        if (!paramString.isEmpty()) {
          break;
        }
        return null;
      }
      catch (IllegalArgumentException paramString)
      {
        int m;
        paramString = null;
      }
      if (i < paramString.length())
      {
        m = paramString.charAt(i);
        j = k;
        if (m <= 31) {
          break label97;
        }
        if (m >= 127)
        {
          j = k;
          break label97;
        }
        m = " #%/:?@[\\]".indexOf(m);
        j = k;
        if (m != -1) {
          break label97;
        }
        i += 1;
      }
      else
      {
        j = 0;
      }
    }
    label97:
    while (j == 0)
    {
      return paramString;
      i = 0;
      break;
    }
    return null;
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static String hostHeader(HttpUrl paramHttpUrl, boolean paramBoolean)
  {
    if (host.contains(":")) {}
    for (String str1 = "[" + host + "]";; str1 = host)
    {
      String str2;
      if (!paramBoolean)
      {
        str2 = str1;
        if (port == HttpUrl.defaultPort(scheme)) {}
      }
      else
      {
        str2 = str1 + ":" + port;
      }
      return str2;
    }
  }
  
  public static <T> List<T> immutableList(List<T> paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public static <T> List<T> immutableList(T... paramVarArgs)
  {
    return Collections.unmodifiableList(Arrays.asList((Object[])paramVarArgs.clone()));
  }
  
  public static <T> T[] intersect(Class<T> paramClass, T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfT1.length;
    int i = 0;
    if (i < k)
    {
      T ? = paramArrayOfT1[i];
      int m = paramArrayOfT2.length;
      int j = 0;
      for (;;)
      {
        if (j < m)
        {
          T ? = paramArrayOfT2[j];
          if (?.equals(?)) {
            localArrayList.add(?);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    return localArrayList.toArray((Object[])Array.newInstance(paramClass, localArrayList.size()));
  }
  
  public static boolean isAndroidGetsocknameError(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static String md5Hex(String paramString)
  {
    try
    {
      paramString = ByteString.of(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"))).hex();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
  }
  
  public static ByteString sha1(ByteString paramByteString)
  {
    try
    {
      paramByteString = ByteString.of(MessageDigest.getInstance("SHA-1").digest(paramByteString.toByteArray()));
      return paramByteString;
    }
    catch (NoSuchAlgorithmException paramByteString)
    {
      throw new AssertionError(paramByteString);
    }
  }
  
  public static ByteString sha256(ByteString paramByteString)
  {
    try
    {
      paramByteString = ByteString.of(MessageDigest.getInstance("SHA-256").digest(paramByteString.toByteArray()));
      return paramByteString;
    }
    catch (NoSuchAlgorithmException paramByteString)
    {
      throw new AssertionError(paramByteString);
    }
  }
  
  public static boolean skipAll(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
    throws IOException
  {
    long l2 = System.nanoTime();
    long l1;
    if (paramSource.timeout().hasDeadline()) {
      l1 = paramSource.timeout().deadlineNanoTime() - l2;
    }
    for (;;)
    {
      paramSource.timeout().deadlineNanoTime(Math.min(l1, paramTimeUnit.toNanos(paramInt)) + l2);
      try
      {
        paramTimeUnit = new Buffer();
        while (paramSource.read(paramTimeUnit, 2048L) != -1L) {
          paramTimeUnit.clear();
        }
      }
      catch (InterruptedIOException paramTimeUnit)
      {
        if (l1 == Long.MAX_VALUE) {
          paramSource.timeout().clearDeadline();
        }
        for (;;)
        {
          return false;
          l1 = Long.MAX_VALUE;
          break;
          if (l1 == Long.MAX_VALUE) {
            paramSource.timeout().clearDeadline();
          }
          for (;;)
          {
            return true;
            paramSource.timeout().deadlineNanoTime(l2 + l1);
          }
          paramSource.timeout().deadlineNanoTime(l2 + l1);
        }
      }
      finally
      {
        if (l1 != Long.MAX_VALUE) {
          break label188;
        }
      }
    }
    paramSource.timeout().clearDeadline();
    for (;;)
    {
      throw paramTimeUnit;
      label188:
      paramSource.timeout().deadlineNanoTime(l2 + l1);
    }
  }
  
  public static int skipLeadingAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      switch (paramString.charAt(paramInt1))
      {
      default: 
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static int skipTrailingAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    for (;;)
    {
      int i = paramInt1;
      if (paramInt2 >= paramInt1) {}
      switch (paramString.charAt(paramInt2))
      {
      default: 
        i = paramInt2 + 1;
        return i;
      }
      paramInt2 -= 1;
    }
  }
  
  public static ThreadFactory threadFactory(String paramString, final boolean paramBoolean)
  {
    new ThreadFactory()
    {
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, val$name);
        paramAnonymousRunnable.setDaemon(paramBoolean);
        return paramAnonymousRunnable;
      }
    };
  }
  
  public static String trimSubstring(String paramString, int paramInt1, int paramInt2)
  {
    paramInt1 = skipLeadingAsciiWhitespace(paramString, paramInt1, paramInt2);
    return paramString.substring(paramInt1, skipTrailingAsciiWhitespace(paramString, paramInt1, paramInt2));
  }
  
  public static boolean verifyAsIpAddress(String paramString)
  {
    return VERIFY_AS_IP_ADDRESS.matcher(paramString).matches();
  }
}

/* Location:
 * Qualified Name:     okhttp3.internal.Util
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */