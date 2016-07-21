package com.google.android.exoplayer.extractor.webm;

import android.util.Pair;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.MimeTypes;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class WebmExtractor$TrackFormat
{
  public int channelCount = -1;
  public long codecDelayNs = -1L;
  public String codecId;
  public byte[] codecPrivate;
  public int defaultSampleDurationNs = -1;
  public byte[] encryptionKeyId;
  public boolean hasContentEncryption;
  public int nalUnitLengthFieldLength = -1;
  public int number = -1;
  public int pixelHeight = -1;
  public int pixelWidth = -1;
  public int sampleRate = -1;
  public byte[] sampleStrippedBytes;
  public long seekPreRollNs = -1L;
  public TrackOutput trackOutput;
  public int type = -1;
  
  private static Pair<List<byte[]>, Integer> parseAvcCodecPrivate(ParsableByteArray paramParsableByteArray)
    throws ParserException
  {
    for (;;)
    {
      try
      {
        paramParsableByteArray.setPosition(4);
        int j = (paramParsableByteArray.readUnsignedByte() & 0x3) + 1;
        if (j != 3)
        {
          bool = true;
          Assertions.checkState(bool);
          ArrayList localArrayList = new ArrayList();
          int k = paramParsableByteArray.readUnsignedByte();
          int i = 0;
          if (i < (k & 0x1F))
          {
            localArrayList.add(NalUnitUtil.parseChildNalUnit(paramParsableByteArray));
            i += 1;
            continue;
          }
          k = paramParsableByteArray.readUnsignedByte();
          i = 0;
          if (i < k)
          {
            localArrayList.add(NalUnitUtil.parseChildNalUnit(paramParsableByteArray));
            i += 1;
            continue;
          }
          paramParsableByteArray = Pair.create(localArrayList, Integer.valueOf(j));
          return paramParsableByteArray;
        }
      }
      catch (ArrayIndexOutOfBoundsException paramParsableByteArray)
      {
        throw new ParserException("Error parsing AVC codec private");
      }
      boolean bool = false;
    }
  }
  
  private static Pair<List<byte[]>, Integer> parseHevcCodecPrivate(ParsableByteArray paramParsableByteArray)
    throws ParserException
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        paramParsableByteArray.setPosition(21);
        int n = paramParsableByteArray.readUnsignedByte();
        int i1 = paramParsableByteArray.readUnsignedByte();
        i = 0;
        int m = position;
        j = 0;
        if (j < i1)
        {
          paramParsableByteArray.skipBytes(1);
          i2 = paramParsableByteArray.readUnsignedShort();
          k = 0;
          if (k >= i2) {
            break label221;
          }
          i3 = paramParsableByteArray.readUnsignedShort();
          i += i3 + 4;
          paramParsableByteArray.skipBytes(i3);
          k += 1;
          continue;
        }
        paramParsableByteArray.setPosition(m);
        arrayOfByte = new byte[i];
        m = 0;
        j = 0;
        if (j >= i1) {
          break label235;
        }
        paramParsableByteArray.skipBytes(1);
        int i2 = paramParsableByteArray.readUnsignedShort();
        int k = 0;
        if (k >= i2) {
          break label228;
        }
        int i3 = paramParsableByteArray.readUnsignedShort();
        System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, arrayOfByte, m, NalUnitUtil.NAL_START_CODE.length);
        m += NalUnitUtil.NAL_START_CODE.length;
        System.arraycopy(data, position, arrayOfByte, m, i3);
        m += i3;
        paramParsableByteArray.skipBytes(i3);
        k += 1;
        continue;
        return Pair.create(paramParsableByteArray, Integer.valueOf((n & 0x3) + 1));
      }
      catch (ArrayIndexOutOfBoundsException paramParsableByteArray)
      {
        byte[] arrayOfByte;
        throw new ParserException("Error parsing HEVC codec private");
      }
      paramParsableByteArray = Collections.singletonList(arrayOfByte);
      continue;
      label221:
      j += 1;
      continue;
      label228:
      j += 1;
      continue;
      label235:
      if (i == 0) {
        paramParsableByteArray = null;
      }
    }
  }
  
  private static List<byte[]> parseVorbisCodecPrivate(byte[] paramArrayOfByte)
    throws ParserException
  {
    if (paramArrayOfByte[0] != 2) {
      try
      {
        throw new ParserException("Error parsing vorbis codec private");
      }
      catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
      {
        throw new ParserException("Error parsing vorbis codec private");
      }
    }
    int j = 0;
    int i = 1;
    while (paramArrayOfByte[i] == -1)
    {
      j += 255;
      i += 1;
    }
    for (;;)
    {
      int k = j + 1;
      j = paramArrayOfByte[j];
      if (paramArrayOfByte[k] != 1) {
        throw new ParserException("Error parsing vorbis codec private");
      }
      byte[] arrayOfByte1 = new byte[m];
      System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, m);
      k += m;
      if (paramArrayOfByte[k] != 3) {
        throw new ParserException("Error parsing vorbis codec private");
      }
      i = k + (i + j);
      if (paramArrayOfByte[i] != 5) {
        throw new ParserException("Error parsing vorbis codec private");
      }
      byte[] arrayOfByte2 = new byte[paramArrayOfByte.length - i];
      System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, paramArrayOfByte.length - i);
      paramArrayOfByte = new ArrayList(2);
      paramArrayOfByte.add(arrayOfByte1);
      paramArrayOfByte.add(arrayOfByte2);
      return paramArrayOfByte;
      int m = j + paramArrayOfByte[i];
      j = 0;
      k = i + 1;
      i = j;
      j = k;
      while (paramArrayOfByte[j] == -1)
      {
        i += 255;
        j += 1;
      }
    }
  }
  
  public final MediaFormat getMediaFormat(long paramLong)
    throws ParserException
  {
    Object localObject = null;
    int j = -1;
    String str = codecId;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new ParserException("Unrecognized codec identifier.");
        if (str.equals("V_VP8"))
        {
          i = 0;
          continue;
          if (str.equals("V_VP9"))
          {
            i = 1;
            continue;
            if (str.equals("V_MPEG4/ISO/SP"))
            {
              i = 2;
              continue;
              if (str.equals("V_MPEG4/ISO/ASP"))
              {
                i = 3;
                continue;
                if (str.equals("V_MPEG4/ISO/AP"))
                {
                  i = 4;
                  continue;
                  if (str.equals("V_MPEG4/ISO/AVC"))
                  {
                    i = 5;
                    continue;
                    if (str.equals("V_MPEGH/ISO/HEVC"))
                    {
                      i = 6;
                      continue;
                      if (str.equals("A_VORBIS"))
                      {
                        i = 7;
                        continue;
                        if (str.equals("A_OPUS"))
                        {
                          i = 8;
                          continue;
                          if (str.equals("A_AAC"))
                          {
                            i = 9;
                            continue;
                            if (str.equals("A_MPEG/L3"))
                            {
                              i = 10;
                              continue;
                              if (str.equals("A_AC3")) {
                                i = 11;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    str = "video/x-vnd.on2.vp8";
    i = j;
    while (MimeTypes.isAudio(str))
    {
      return MediaFormat.createAudioFormat(str, i, paramLong, channelCount, sampleRate, (List)localObject);
      str = "video/x-vnd.on2.vp9";
      i = j;
      continue;
      str = "video/mp4v-es";
      if (codecPrivate == null) {}
      for (localObject = null;; localObject = Collections.singletonList(codecPrivate))
      {
        i = j;
        break;
      }
      str = "video/avc";
      Pair localPair = parseAvcCodecPrivate(new ParsableByteArray(codecPrivate));
      localObject = (List)first;
      nalUnitLengthFieldLength = ((Integer)second).intValue();
      i = j;
      continue;
      str = "video/hevc";
      localPair = parseHevcCodecPrivate(new ParsableByteArray(codecPrivate));
      localObject = (List)first;
      nalUnitLengthFieldLength = ((Integer)second).intValue();
      i = j;
      continue;
      str = "audio/vorbis";
      i = 8192;
      localObject = parseVorbisCodecPrivate(codecPrivate);
      continue;
      str = "audio/opus";
      i = 5760;
      localObject = new ArrayList(3);
      ((List)localObject).add(codecPrivate);
      ((List)localObject).add(ByteBuffer.allocate(64).putLong(codecDelayNs).array());
      ((List)localObject).add(ByteBuffer.allocate(64).putLong(seekPreRollNs).array());
      continue;
      str = "audio/mp4a-latm";
      localObject = Collections.singletonList(codecPrivate);
      i = j;
      continue;
      i = 4096;
      str = "audio/mpeg";
      continue;
      str = "audio/ac3";
      i = j;
    }
    if (MimeTypes.isVideo(str)) {
      return MediaFormat.createVideoFormat(str, i, paramLong, pixelWidth, pixelHeight, 1.0F, (List)localObject);
    }
    throw new ParserException("Unexpected MIME type.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.webm.WebmExtractor.TrackFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */