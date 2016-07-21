package com.google.android.exoplayer.text.subrip;

import android.text.Html;
import android.text.TextUtils;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.SubtitleParser;
import com.google.android.exoplayer.util.LongArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SubripParser
  implements SubtitleParser
{
  private static final Pattern SUBRIP_TIMESTAMP = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+),(\\d+)");
  private static final Pattern SUBRIP_TIMING_LINE = Pattern.compile("(.*)\\s+-->\\s+(.*)");
  private final StringBuilder textBuilder = new StringBuilder();
  
  private SubripSubtitle parse$18a9710e(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    LongArray localLongArray = new LongArray();
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      try
      {
        Integer.parseInt(str);
        str = paramInputStream.readLine();
        Matcher localMatcher = SUBRIP_TIMING_LINE.matcher(str);
        if (localMatcher.find())
        {
          localLongArray.add(parseTimestampUs(localMatcher.group(1)) + paramLong);
          localLongArray.add(parseTimestampUs(localMatcher.group(2)) + paramLong);
          textBuilder.setLength(0);
          for (;;)
          {
            str = paramInputStream.readLine();
            if (TextUtils.isEmpty(str)) {
              break;
            }
            if (textBuilder.length() > 0) {
              textBuilder.append("<br>");
            }
            textBuilder.append(str.trim());
          }
        }
        throw new ParserException("Expected timing line: " + str);
      }
      catch (NumberFormatException paramInputStream)
      {
        throw new ParserException("Expected numeric counter: " + str);
      }
      localArrayList.add(new Cue(Html.fromHtml(textBuilder.toString())));
    }
    paramInputStream = new Cue[localArrayList.size()];
    localArrayList.toArray(paramInputStream);
    return new SubripSubtitle(paramLong, paramInputStream, Arrays.copyOf(values, size));
  }
  
  private static long parseTimestampUs(String paramString)
    throws NumberFormatException
  {
    paramString = SUBRIP_TIMESTAMP.matcher(paramString);
    if (!paramString.matches()) {
      throw new NumberFormatException("has invalid format");
    }
    return (Long.parseLong(paramString.group(1)) * 60L * 60L * 1000L + Long.parseLong(paramString.group(2)) * 60L * 1000L + Long.parseLong(paramString.group(3)) * 1000L + Long.parseLong(paramString.group(4))) * 1000L;
  }
  
  public final boolean canParse(String paramString)
  {
    return "application/x-subrip".equals(paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.subrip.SubripParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */