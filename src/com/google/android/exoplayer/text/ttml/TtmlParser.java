package com.google.android.exoplayer.text.ttml;

import android.util.Log;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.text.SubtitleParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class TtmlParser
  implements SubtitleParser
{
  private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
  private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
  private final boolean strictParsing = false;
  private final XmlPullParserFactory xmlParserFactory;
  
  public TtmlParser()
  {
    this((byte)0);
  }
  
  private TtmlParser(byte paramByte)
  {
    try
    {
      xmlParserFactory = XmlPullParserFactory.newInstance();
      return;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      throw new RuntimeException("Couldn't create XmlPullParserFactory instance", localXmlPullParserException);
    }
  }
  
  private static TtmlNode parseNode(XmlPullParser paramXmlPullParser, TtmlNode paramTtmlNode)
    throws ParserException
  {
    long l5 = 0L;
    long l1 = -1L;
    long l2 = -1L;
    int j = paramXmlPullParser.getAttributeCount();
    int i = 0;
    long l3;
    if (i < j)
    {
      String str1 = paramXmlPullParser.getAttributeName(i).replaceFirst("^.*:", "");
      String str2 = paramXmlPullParser.getAttributeValue(i);
      if (str1.equals("begin"))
      {
        l3 = parseTimeExpression$52f4b838(str2);
        l4 = l2;
      }
      for (;;)
      {
        i += 1;
        l1 = l3;
        l2 = l4;
        break;
        if (str1.equals("end"))
        {
          l4 = parseTimeExpression$52f4b838(str2);
          l3 = l1;
        }
        else
        {
          l3 = l1;
          l4 = l2;
          if (str1.equals("dur"))
          {
            l5 = parseTimeExpression$52f4b838(str2);
            l3 = l1;
            l4 = l2;
          }
        }
      }
    }
    long l6 = l1;
    long l4 = l2;
    if (paramTtmlNode != null)
    {
      l6 = l1;
      l4 = l2;
      if (startTimeUs != -1L)
      {
        l3 = l1;
        if (l1 != -1L) {
          l3 = l1 + startTimeUs;
        }
        l6 = l3;
        l4 = l2;
        if (l2 != -1L)
        {
          l4 = l2 + startTimeUs;
          l6 = l3;
        }
      }
    }
    l1 = l4;
    if (l4 == -1L)
    {
      if (l5 <= 0L) {
        break label277;
      }
      l1 = l6 + l5;
    }
    for (;;)
    {
      return new TtmlNode(paramXmlPullParser.getName(), null, l6, l1);
      label277:
      l1 = l4;
      if (paramTtmlNode != null)
      {
        l1 = l4;
        if (endTimeUs != -1L) {
          l1 = endTimeUs;
        }
      }
    }
  }
  
  private static long parseTimeExpression$52f4b838(String paramString)
    throws ParserException
  {
    Matcher localMatcher = CLOCK_TIME.matcher(paramString);
    double d1;
    double d2;
    if (localMatcher.matches())
    {
      double d4 = Long.parseLong(localMatcher.group(1)) * 3600L;
      double d5 = Long.parseLong(localMatcher.group(2)) * 60L;
      double d6 = Long.parseLong(localMatcher.group(3));
      paramString = localMatcher.group(4);
      if (paramString != null)
      {
        d1 = Double.parseDouble(paramString);
        paramString = localMatcher.group(5);
        if (paramString == null) {
          break label149;
        }
        d2 = Long.parseLong(paramString) / 30.0D;
        label98:
        paramString = localMatcher.group(6);
        if (paramString == null) {
          break label154;
        }
      }
      label149:
      label154:
      for (double d3 = Long.parseLong(paramString) / 1.0D / 30.0D;; d3 = 0.0D)
      {
        return ((d3 + (d4 + d5 + d6 + d1 + d2)) * 1000000.0D);
        d1 = 0.0D;
        break;
        d2 = 0.0D;
        break label98;
      }
    }
    localMatcher = OFFSET_TIME.matcher(paramString);
    if (localMatcher.matches())
    {
      d2 = Double.parseDouble(localMatcher.group(1));
      paramString = localMatcher.group(2);
      if (paramString.equals("h")) {
        d1 = d2 * 3600.0D;
      }
      for (;;)
      {
        return (1000000.0D * d1);
        if (paramString.equals("m"))
        {
          d1 = d2 * 60.0D;
        }
        else
        {
          d1 = d2;
          if (!paramString.equals("s")) {
            if (paramString.equals("ms"))
            {
              d1 = d2 / 1000.0D;
            }
            else if (paramString.equals("f"))
            {
              d1 = d2 / 30.0D;
            }
            else
            {
              d1 = d2;
              if (paramString.equals("t")) {
                d1 = d2 / 1.0D;
              }
            }
          }
        }
      }
    }
    throw new ParserException("Malformed time expression: " + paramString);
  }
  
  public final boolean canParse(String paramString)
  {
    return "application/ttml+xml".equals(paramString);
  }
  
  public final Subtitle parse$70e760a9(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    for (;;)
    {
      XmlPullParser localXmlPullParser;
      LinkedList localLinkedList;
      int j;
      int k;
      TtmlNode localTtmlNode1;
      try
      {
        localXmlPullParser = xmlParserFactory.newPullParser();
        localXmlPullParser.setInput(paramInputStream, null);
        paramInputStream = null;
        localLinkedList = new LinkedList();
        j = 0;
        k = localXmlPullParser.getEventType();
        if (k == 1) {
          break label580;
        }
        localTtmlNode1 = (TtmlNode)localLinkedList.peekLast();
        if (j != 0) {
          break label537;
        }
        Object localObject = localXmlPullParser.getName();
        if (k != 2) {
          break label398;
        }
        if ((((String)localObject).equals("tt")) || (((String)localObject).equals("head")) || (((String)localObject).equals("body")) || (((String)localObject).equals("div")) || (((String)localObject).equals("p")) || (((String)localObject).equals("span")) || (((String)localObject).equals("br")) || (((String)localObject).equals("style")) || (((String)localObject).equals("styling")) || (((String)localObject).equals("layout")) || (((String)localObject).equals("region")) || (((String)localObject).equals("metadata")) || (((String)localObject).equals("smpte:image")) || (((String)localObject).equals("smpte:data"))) {
          break label582;
        }
        if (((String)localObject).equals("smpte:information"))
        {
          break label582;
          if (i == 0)
          {
            Log.i("TtmlParser", "Ignoring unsupported tag: " + localXmlPullParser.getName());
            i = j + 1;
            localObject = paramInputStream;
            localXmlPullParser.next();
            k = localXmlPullParser.getEventType();
            paramInputStream = (InputStream)localObject;
            j = i;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        try
        {
          TtmlNode localTtmlNode2 = parseNode(localXmlPullParser, localTtmlNode1);
          localLinkedList.addLast(localTtmlNode2);
          localObject = paramInputStream;
          i = j;
          if (localTtmlNode1 == null) {
            continue;
          }
          localTtmlNode1.addChild(localTtmlNode2);
          localObject = paramInputStream;
          i = j;
        }
        catch (ParserException localParserException)
        {
          if (!strictParsing) {
            break label375;
          }
        }
        throw localParserException;
      }
      catch (XmlPullParserException paramInputStream)
      {
        throw new ParserException("Unable to parse source", paramInputStream);
      }
      label375:
      Log.e("TtmlParser", "Suppressing parser error", localParserException);
      int i = j + 1;
      InputStream localInputStream = paramInputStream;
      continue;
      label398:
      if (k == 4)
      {
        localTtmlNode1.addChild(new TtmlNode(null, localXmlPullParser.getText().replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -1L, -1L));
        localInputStream = paramInputStream;
        i = j;
      }
      else
      {
        localInputStream = paramInputStream;
        i = j;
        if (k == 3)
        {
          if (localXmlPullParser.getName().equals("tt")) {
            paramInputStream = new TtmlSubtitle((TtmlNode)localLinkedList.getLast(), paramLong);
          }
          localLinkedList.removeLast();
          localInputStream = paramInputStream;
          i = j;
          continue;
          label537:
          if (k == 2)
          {
            i = j + 1;
            localInputStream = paramInputStream;
          }
          else
          {
            localInputStream = paramInputStream;
            i = j;
            if (k == 3)
            {
              i = j - 1;
              localInputStream = paramInputStream;
              continue;
              label580:
              return paramInputStream;
              label582:
              i = 1;
            }
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.ttml.TtmlParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */