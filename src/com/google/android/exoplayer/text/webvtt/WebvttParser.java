package com.google.android.exoplayer.text.webvtt;

import android.text.Html;
import android.text.Layout.Alignment;
import android.util.Log;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.text.SubtitleParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebvttParser
  implements SubtitleParser
{
  private static final Pattern MEDIA_TIMESTAMP = Pattern.compile("MPEGTS:\\d+");
  private static final Pattern MEDIA_TIMESTAMP_OFFSET;
  private static final Pattern WEBVTT_CUE_IDENTIFIER;
  private static final Pattern WEBVTT_CUE_SETTING;
  private static final Pattern WEBVTT_FILE_HEADER = Pattern.compile("^﻿?WEBVTT((\\u0020|\t).*)?$");
  private static final Pattern WEBVTT_METADATA_HEADER = Pattern.compile("\\S*[:=]\\S*");
  private static final Pattern WEBVTT_TIMESTAMP;
  private final boolean strictParsing = false;
  private final StringBuilder textBuilder = new StringBuilder();
  
  static
  {
    WEBVTT_CUE_IDENTIFIER = Pattern.compile("^(?!.*(-->)).*$");
    WEBVTT_TIMESTAMP = Pattern.compile("(\\d+:)?[0-5]\\d:[0-5]\\d\\.\\d{3}");
    WEBVTT_CUE_SETTING = Pattern.compile("\\S*:\\S*");
    MEDIA_TIMESTAMP_OFFSET = Pattern.compile("OFFSET:\\-?\\d+");
  }
  
  public WebvttParser()
  {
    this((byte)0);
  }
  
  private WebvttParser(byte paramByte) {}
  
  private WebvttSubtitle parse$be82ed2(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    long l1 = paramLong;
    long l2 = 0L;
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
    Object localObject1 = localBufferedReader.readLine();
    if (localObject1 == null) {
      throw new ParserException("Expected WEBVTT or EXO-HEADER. Got null");
    }
    paramInputStream = (InputStream)localObject1;
    paramLong = l2;
    if (((String)localObject1).startsWith("EXO-HEADER"))
    {
      paramInputStream = MEDIA_TIMESTAMP_OFFSET.matcher((CharSequence)localObject1);
      paramLong = l2;
      if (paramInputStream.find()) {
        paramLong = Long.parseLong(paramInputStream.group().substring(7));
      }
      localObject1 = localBufferedReader.readLine();
      paramInputStream = (InputStream)localObject1;
      if (localObject1 == null) {
        throw new ParserException("Expected WEBVTT. Got null");
      }
    }
    if (!WEBVTT_FILE_HEADER.matcher(paramInputStream).matches()) {
      throw new ParserException("Expected WEBVTT. Got " + paramInputStream);
    }
    do
    {
      l1 = Long.parseLong(((Matcher)localObject1).group().substring(7)) * 1000L / 90L + paramLong;
      do
      {
        paramInputStream = localBufferedReader.readLine();
        if (paramInputStream == null) {
          throw new ParserException("Expected an empty line after webvtt header");
        }
        if (paramInputStream.isEmpty()) {
          break;
        }
        if ((!WEBVTT_METADATA_HEADER.matcher(paramInputStream).find()) && (strictParsing)) {
          throw new ParserException("Unexpected line: " + paramInputStream);
        }
      } while (!paramInputStream.startsWith("X-TIMESTAMP-MAP"));
      localObject1 = MEDIA_TIMESTAMP.matcher(paramInputStream);
    } while (((Matcher)localObject1).find());
    throw new ParserException("X-TIMESTAMP-MAP doesn't contain media timestamp: " + paramInputStream);
    int i;
    int j;
    int k;
    localArrayList.add(new WebvttCue(paramLong + l1, l2 + l1, Html.fromHtml(textBuilder.toString()), i, j, paramInputStream, k));
    localObject1 = localBufferedReader.readLine();
    if (localObject1 != null)
    {
      paramInputStream = (InputStream)localObject1;
      if (WEBVTT_CUE_IDENTIFIER.matcher((CharSequence)localObject1).find()) {
        paramInputStream = localBufferedReader.readLine();
      }
      i = -1;
      j = -1;
      localObject1 = null;
      k = -1;
      Object localObject3 = WEBVTT_TIMESTAMP.matcher(paramInputStream);
      if (!((Matcher)localObject3).find()) {
        throw new ParserException("Expected cue start time: " + paramInputStream);
      }
      paramLong = parseTimestampUs(((Matcher)localObject3).group());
      if (!((Matcher)localObject3).find()) {
        throw new ParserException("Expected cue end time: " + paramInputStream);
      }
      localObject3 = ((Matcher)localObject3).group();
      l2 = parseTimestampUs((String)localObject3);
      paramInputStream = paramInputStream.substring(paramInputStream.indexOf((String)localObject3) + ((String)localObject3).length());
      localObject3 = WEBVTT_CUE_SETTING.matcher(paramInputStream);
      paramInputStream = (InputStream)localObject1;
      label664:
      label678:
      Object localObject2;
      while (((Matcher)localObject3).find())
      {
        localObject1 = ((Matcher)localObject3).group().split(":", 2);
        Object localObject4 = localObject1[0];
        String str = localObject1[1];
        try
        {
          if (!"line".equals(localObject4)) {
            break label678;
          }
          if (str.endsWith("%"))
          {
            m = parseIntPercentage(str);
            i = m;
            continue;
          }
          if (!str.matches(".*[^0-9].*")) {
            break label664;
          }
          Log.w("WebvttParser", "Invalid line value: " + str);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          Log.w("WebvttParser", (String)localObject4 + " contains an invalid value " + str, localNumberFormatException);
        }
        continue;
        int m = Integer.parseInt(str);
        i = m;
        continue;
        if ("align".equals(localObject4))
        {
          if ("start".equals(str))
          {
            localObject2 = Layout.Alignment.ALIGN_NORMAL;
            paramInputStream = (InputStream)localObject2;
          }
          else if ("middle".equals(str))
          {
            localObject2 = Layout.Alignment.ALIGN_CENTER;
            paramInputStream = (InputStream)localObject2;
          }
          else if ("end".equals(str))
          {
            localObject2 = Layout.Alignment.ALIGN_OPPOSITE;
            paramInputStream = (InputStream)localObject2;
          }
          else if ("left".equals(str))
          {
            localObject2 = Layout.Alignment.ALIGN_NORMAL;
            paramInputStream = (InputStream)localObject2;
          }
          else if ("right".equals(str))
          {
            localObject2 = Layout.Alignment.ALIGN_OPPOSITE;
            paramInputStream = (InputStream)localObject2;
          }
          else
          {
            Log.w("WebvttParser", "Invalid align value: " + str);
          }
        }
        else if ("position".equals(localObject4))
        {
          m = parseIntPercentage(str);
          j = m;
        }
        else if ("size".equals(localObject4))
        {
          m = parseIntPercentage(str);
          k = m;
        }
        else
        {
          Log.w("WebvttParser", "Unknown cue setting " + (String)localObject4 + ":" + str);
        }
      }
      textBuilder.setLength(0);
      for (;;)
      {
        localObject2 = localBufferedReader.readLine();
        if ((localObject2 == null) || (((String)localObject2).isEmpty())) {
          break;
        }
        if (textBuilder.length() > 0) {
          textBuilder.append("<br>");
        }
        textBuilder.append(((String)localObject2).trim());
      }
    }
    return new WebvttSubtitle(localArrayList, l1);
  }
  
  private static int parseIntPercentage(String paramString)
    throws NumberFormatException
  {
    if (!paramString.endsWith("%")) {
      throw new NumberFormatException(paramString + " doesn't end with '%'");
    }
    paramString = paramString.substring(0, paramString.length() - 1);
    if (paramString.matches(".*[^0-9].*")) {
      throw new NumberFormatException(paramString + " contains an invalid character");
    }
    int i = Integer.parseInt(paramString);
    if ((i < 0) || (i > 100)) {
      throw new NumberFormatException(i + " is out of range [0-100]");
    }
    return i;
  }
  
  private static long parseTimestampUs(String paramString)
    throws NumberFormatException
  {
    if (!paramString.matches("(\\d+:)?[0-5]\\d:[0-5]\\d\\.\\d{3}")) {
      throw new NumberFormatException("has invalid format");
    }
    paramString = paramString.split("\\.", 2);
    long l = 0L;
    String[] arrayOfString = paramString[0].split(":");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      l = 60L * l + Long.parseLong(arrayOfString[i]);
      i += 1;
    }
    return (l * 1000L + Long.parseLong(paramString[1])) * 1000L;
  }
  
  public final boolean canParse(String paramString)
  {
    return "text/vtt".equals(paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.webvtt.WebvttParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */