package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public final class VersionUtil
{
  private static final Pattern V_SEP = Pattern.compile("[-_./;:]");
  private final Version _v;
  
  protected VersionUtil()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = versionFor(getClass());
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        System.err.println("ERROR: Failed to load Version information from " + getClass());
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = Version.unknownVersion();
    }
    _v = ((Version)localObject2);
  }
  
  private static final void _close(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  private static Version doReadVersion(Reader paramReader)
  {
    localObject1 = null;
    localObject4 = null;
    Object localObject6 = null;
    localObject5 = null;
    String str = null;
    localBufferedReader = new BufferedReader(paramReader);
    paramReader = (Reader)localObject4;
    try
    {
      localObject2 = localBufferedReader.readLine();
      paramReader = str;
      localObject1 = localObject6;
      if (localObject2 != null)
      {
        paramReader = (Reader)localObject4;
        localObject1 = localObject2;
        localObject4 = localBufferedReader.readLine();
        paramReader = str;
        localObject1 = localObject4;
        if (localObject4 != null)
        {
          paramReader = (Reader)localObject4;
          localObject1 = localObject2;
          str = localBufferedReader.readLine();
          paramReader = str;
          localObject1 = localObject4;
        }
      }
      _close(localBufferedReader);
      localObject5 = localObject2;
      localObject4 = localObject1;
      localObject2 = paramReader;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject2;
        _close(localBufferedReader);
        Object localObject3 = localObject5;
        localObject4 = paramReader;
        localObject5 = localObject1;
      }
    }
    finally
    {
      _close(localBufferedReader);
    }
    paramReader = (Reader)localObject4;
    if (localObject4 != null) {
      paramReader = ((String)localObject4).trim();
    }
    localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).trim();
    }
    return parseVersion((String)localObject5, paramReader, (String)localObject1);
  }
  
  private static Version packageVersionFor(Class<?> paramClass)
  {
    try
    {
      paramClass = Class.forName(paramClass.getPackage().getName() + ".PackageVersion", true, paramClass.getClassLoader());
      try
      {
        Version localVersion = ((Versioned)paramClass.newInstance()).version();
        return localVersion;
      }
      catch (Exception localException)
      {
        throw new IllegalArgumentException("Failed to get Versioned out of " + paramClass);
      }
      return null;
    }
    catch (Exception paramClass) {}
  }
  
  public static Version parseVersion(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = null;
    int j = 0;
    if (paramString1 != null)
    {
      paramString1 = paramString1.trim();
      if (paramString1.length() > 0)
      {
        String[] arrayOfString = V_SEP.split(paramString1);
        int k = parseVersionPart(arrayOfString[0]);
        if (arrayOfString.length > 1) {}
        for (int i = parseVersionPart(arrayOfString[1]);; i = 0)
        {
          if (arrayOfString.length > 2) {
            j = parseVersionPart(arrayOfString[2]);
          }
          paramString1 = (String)localObject;
          if (arrayOfString.length > 3) {
            paramString1 = arrayOfString[3];
          }
          return new Version(k, i, j, paramString1, paramString2, paramString3);
        }
      }
    }
    return null;
  }
  
  private static int parseVersionPart(String paramString)
  {
    int j = 0;
    int i = 0;
    int k = paramString.length();
    while (i < k)
    {
      int m = paramString.charAt(i);
      if ((m > 57) || (m < 48)) {
        break;
      }
      j = j * 10 + (m - 48);
      i += 1;
    }
    return j;
  }
  
  public static final void throwInternal()
  {
    throw new RuntimeException("Internal error: this code path should never get executed");
  }
  
  public static Version versionFor(Class<?> paramClass)
  {
    Version localVersion1 = packageVersionFor(paramClass);
    if (localVersion1 != null) {
      return localVersion1;
    }
    paramClass = paramClass.getResourceAsStream("VERSION.txt");
    if (paramClass == null) {
      return Version.unknownVersion();
    }
    try
    {
      localVersion1 = doReadVersion(new InputStreamReader(paramClass, "UTF-8"));
      return localVersion1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Version localVersion2 = Version.unknownVersion();
      return localVersion2;
    }
    finally
    {
      _close(paramClass);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.util.VersionUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */