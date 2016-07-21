package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.upstream.UriLoadable.Parser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

public final class HlsPlaylistParser
  implements UriLoadable.Parser<HlsPlaylist>
{
  private static final Pattern AUTOSELECT_ATTR_REGEX = HlsParserUtil.compileBooleanAttrPattern("AUTOSELECT");
  private static final Pattern BANDWIDTH_ATTR_REGEX = Pattern.compile("BANDWIDTH=(\\d+)\\b");
  private static final Pattern BYTERANGE_REGEX;
  private static final Pattern CODECS_ATTR_REGEX = Pattern.compile("CODECS=\"(.+?)\"");
  private static final Pattern DEFAULT_ATTR_REGEX = HlsParserUtil.compileBooleanAttrPattern("DEFAULT");
  private static final Pattern IV_ATTR_REGEX;
  private static final Pattern LANGUAGE_ATTR_REGEX;
  private static final Pattern MEDIA_DURATION_REGEX;
  private static final Pattern MEDIA_SEQUENCE_REGEX;
  private static final Pattern METHOD_ATTR_REGEX;
  private static final Pattern NAME_ATTR_REGEX;
  private static final Pattern RESOLUTION_ATTR_REGEX = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
  private static final Pattern TARGET_DURATION_REGEX;
  private static final Pattern TYPE_ATTR_REGEX;
  private static final Pattern URI_ATTR_REGEX;
  private static final Pattern VERSION_REGEX;
  
  static
  {
    MEDIA_DURATION_REGEX = Pattern.compile("#EXTINF:([\\d.]+)\\b");
    MEDIA_SEQUENCE_REGEX = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    TARGET_DURATION_REGEX = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    VERSION_REGEX = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    BYTERANGE_REGEX = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    METHOD_ATTR_REGEX = Pattern.compile("METHOD=(NONE|AES-128)");
    URI_ATTR_REGEX = Pattern.compile("URI=\"(.+)\"");
    IV_ATTR_REGEX = Pattern.compile("IV=([^,.*]+)");
    TYPE_ATTR_REGEX = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    LANGUAGE_ATTR_REGEX = Pattern.compile("LANGUAGE=\"(.+?)\"");
    NAME_ATTR_REGEX = Pattern.compile("NAME=\"(.+?)\"");
  }
  
  public static HlsPlaylist parse(String paramString, InputStream paramInputStream)
    throws IOException, ParserException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    LinkedList localLinkedList = new LinkedList();
    try
    {
      for (;;)
      {
        String str = paramInputStream.readLine();
        if (str == null) {
          break;
        }
        str = str.trim();
        if (!str.isEmpty())
        {
          if (str.startsWith("#EXT-X-STREAM-INF"))
          {
            localLinkedList.add(str);
            paramString = parseMasterPlaylist(new LineIterator(localLinkedList, paramInputStream), paramString);
            return paramString;
          }
          if ((str.startsWith("#EXT-X-TARGETDURATION")) || (str.startsWith("#EXT-X-MEDIA-SEQUENCE")) || (str.startsWith("#EXTINF")) || (str.startsWith("#EXT-X-KEY")) || (str.startsWith("#EXT-X-BYTERANGE")) || (str.equals("#EXT-X-DISCONTINUITY")) || (str.equals("#EXT-X-ENDLIST")))
          {
            localLinkedList.add(str);
            paramString = parseMediaPlaylist(new LineIterator(localLinkedList, paramInputStream), paramString);
            return paramString;
          }
          localLinkedList.add(str);
        }
      }
    }
    finally
    {
      paramInputStream.close();
    }
    throw new ParserException("Failed to parse the playlist, could not identify any tags.");
  }
  
  private static HlsMasterPlaylist parseMasterPlaylist(LineIterator paramLineIterator, String paramString)
    throws IOException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = 0;
    String str = null;
    int k = -1;
    int i = -1;
    int m = 0;
    while (paramLineIterator.hasNext())
    {
      Object localObject = paramLineIterator.next();
      if (((String)localObject).startsWith("#EXT-X-MEDIA"))
      {
        if ("SUBTITLES".equals(HlsParserUtil.parseStringAttr((String)localObject, TYPE_ATTR_REGEX, "TYPE"))) {
          localArrayList2.add(new Subtitle(HlsParserUtil.parseStringAttr((String)localObject, NAME_ATTR_REGEX, "NAME"), HlsParserUtil.parseStringAttr((String)localObject, URI_ATTR_REGEX, "URI"), HlsParserUtil.parseOptionalStringAttr((String)localObject, LANGUAGE_ATTR_REGEX), HlsParserUtil.parseOptionalBooleanAttr((String)localObject, DEFAULT_ATTR_REGEX), HlsParserUtil.parseOptionalBooleanAttr((String)localObject, AUTOSELECT_ATTR_REGEX)));
        }
      }
      else
      {
        if (((String)localObject).startsWith("#EXT-X-STREAM-INF"))
        {
          m = HlsParserUtil.parseIntAttr((String)localObject, BANDWIDTH_ATTR_REGEX, "BANDWIDTH");
          str = HlsParserUtil.parseOptionalStringAttr((String)localObject, CODECS_ATTR_REGEX);
          localObject = HlsParserUtil.parseOptionalStringAttr((String)localObject, RESOLUTION_ATTR_REGEX);
          int n;
          if (localObject != null)
          {
            localObject = ((String)localObject).split("x");
            i = Integer.parseInt(localObject[0]);
            j = i;
            if (i <= 0) {
              j = -1;
            }
            n = Integer.parseInt(localObject[1]);
            k = j;
            i = n;
            if (n <= 0)
            {
              i = -1;
              k = j;
            }
          }
          for (;;)
          {
            n = 1;
            j = m;
            m = n;
            break;
            k = -1;
            i = -1;
          }
        }
        if ((!((String)localObject).startsWith("#")) && (m != 0))
        {
          localArrayList1.add(new Variant(localArrayList1.size(), (String)localObject, j, str, k, i));
          j = 0;
          str = null;
          k = -1;
          i = -1;
          m = 0;
        }
      }
    }
    return new HlsMasterPlaylist(paramString, Collections.unmodifiableList(localArrayList1), Collections.unmodifiableList(localArrayList2));
  }
  
  private static HlsMediaPlaylist parseMediaPlaylist(LineIterator paramLineIterator, String paramString)
    throws IOException
  {
    int i1 = 0;
    int n = 0;
    int m = 1;
    boolean bool4 = true;
    ArrayList localArrayList = new ArrayList();
    double d = 0.0D;
    boolean bool1 = false;
    long l = 0L;
    int i = 0;
    int j = -1;
    int k = 0;
    boolean bool2 = false;
    String str2 = null;
    String str1 = null;
    String str3;
    do
    {
      Object localObject;
      int i2;
      for (;;)
      {
        bool3 = bool4;
        if (!paramLineIterator.hasNext()) {
          break label467;
        }
        str3 = paramLineIterator.next();
        if (str3.startsWith("#EXT-X-TARGETDURATION"))
        {
          n = HlsParserUtil.parseIntAttr(str3, TARGET_DURATION_REGEX, "#EXT-X-TARGETDURATION");
        }
        else if (str3.startsWith("#EXT-X-MEDIA-SEQUENCE"))
        {
          i1 = HlsParserUtil.parseIntAttr(str3, MEDIA_SEQUENCE_REGEX, "#EXT-X-MEDIA-SEQUENCE");
          k = i1;
        }
        else if (str3.startsWith("#EXT-X-VERSION"))
        {
          m = HlsParserUtil.parseIntAttr(str3, VERSION_REGEX, "#EXT-X-VERSION");
        }
        else if (str3.startsWith("#EXTINF"))
        {
          d = Double.parseDouble(HlsParserUtil.parseStringAttr(str3, MEDIA_DURATION_REGEX, "#EXTINF"));
        }
        else if (str3.startsWith("#EXT-X-KEY"))
        {
          bool2 = "AES-128".equals(HlsParserUtil.parseStringAttr(str3, METHOD_ATTR_REGEX, "METHOD"));
          if (bool2)
          {
            str2 = HlsParserUtil.parseStringAttr(str3, URI_ATTR_REGEX, "URI");
            str1 = HlsParserUtil.parseOptionalStringAttr(str3, IV_ATTR_REGEX);
          }
          else
          {
            str2 = null;
            str1 = null;
          }
        }
        else if (str3.startsWith("#EXT-X-BYTERANGE"))
        {
          localObject = HlsParserUtil.parseStringAttr(str3, BYTERANGE_REGEX, "#EXT-X-BYTERANGE").split("@");
          i2 = Integer.parseInt(localObject[0]);
          j = i2;
          if (localObject.length > 1)
          {
            i = Integer.parseInt(localObject[1]);
            j = i2;
          }
        }
        else
        {
          if (!str3.equals("#EXT-X-DISCONTINUITY")) {
            break;
          }
          bool1 = true;
        }
      }
      if (!str3.startsWith("#"))
      {
        if (!bool2) {
          localObject = null;
        }
        for (;;)
        {
          i2 = k + 1;
          k = i;
          if (j == -1) {
            k = 0;
          }
          localArrayList.add(new HlsMediaPlaylist.Segment(str3, d, bool1, l, bool2, str2, (String)localObject, k, j));
          l += (1000000.0D * d);
          bool1 = false;
          d = 0.0D;
          i = k;
          if (j != -1) {
            i = k + j;
          }
          j = -1;
          k = i2;
          break;
          if (str1 != null) {
            localObject = str1;
          } else {
            localObject = Integer.toHexString(k);
          }
        }
      }
    } while (!str3.equals("#EXT-X-ENDLIST"));
    boolean bool3 = false;
    label467:
    return new HlsMediaPlaylist(paramString, i1, n, m, bool3, Collections.unmodifiableList(localArrayList));
  }
  
  private static final class LineIterator
  {
    private final Queue<String> extraLines;
    private String next;
    private final BufferedReader reader;
    
    public LineIterator(Queue<String> paramQueue, BufferedReader paramBufferedReader)
    {
      extraLines = paramQueue;
      reader = paramBufferedReader;
    }
    
    public final boolean hasNext()
      throws IOException
    {
      if (next != null) {
        return true;
      }
      if (!extraLines.isEmpty())
      {
        next = ((String)extraLines.poll());
        return true;
      }
      do
      {
        String str = reader.readLine();
        next = str;
        if (str == null) {
          break;
        }
        next = next.trim();
      } while (next.isEmpty());
      return true;
      return false;
    }
    
    public final String next()
      throws IOException
    {
      String str = null;
      if (hasNext())
      {
        str = next;
        next = null;
      }
      return str;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsPlaylistParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */