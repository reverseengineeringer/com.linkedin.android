package com.google.android.exoplayer.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class H264Reader
  extends ElementaryStreamReader
{
  private boolean foundFirstSample;
  private boolean hasOutputFormat;
  private final IfrParserBuffer ifrParserBuffer;
  private boolean isKeyframe;
  private final NalUnitTargetBuffer pps;
  private final boolean[] prefixFlags;
  private long samplePosition;
  private long sampleTimeUs;
  private final NalUnitTargetBuffer sei;
  private final SeiReader seiReader;
  private final ParsableByteArray seiWrapper;
  private final NalUnitTargetBuffer sps;
  private long totalBytesWritten;
  
  public H264Reader(TrackOutput paramTrackOutput, SeiReader paramSeiReader, boolean paramBoolean)
  {
    super(paramTrackOutput);
    seiReader = paramSeiReader;
    prefixFlags = new boolean[3];
    if (paramBoolean) {}
    for (paramTrackOutput = null;; paramTrackOutput = new IfrParserBuffer())
    {
      ifrParserBuffer = paramTrackOutput;
      sps = new NalUnitTargetBuffer(7);
      pps = new NalUnitTargetBuffer(8);
      sei = new NalUnitTargetBuffer(6);
      seiWrapper = new ParsableByteArray();
      return;
    }
  }
  
  private void feedNalUnitTargetBuffersData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    IfrParserBuffer localIfrParserBuffer;
    int i;
    if (ifrParserBuffer != null)
    {
      localIfrParserBuffer = ifrParserBuffer;
      if (isFilling)
      {
        i = paramInt2 - paramInt1;
        if (ifrData.length < ifrLength + i) {
          ifrData = Arrays.copyOf(ifrData, (ifrLength + i) * 2);
        }
        System.arraycopy(paramArrayOfByte, paramInt1, ifrData, ifrLength, i);
        ifrLength = (i + ifrLength);
        scratchSliceType.reset(ifrData, ifrLength);
        i = scratchSliceType.peekExpGolombCodedNumLength();
        if ((i != -1) && (i <= scratchSliceType.bitsLeft())) {
          break label181;
        }
      }
    }
    for (;;)
    {
      if (!hasOutputFormat)
      {
        sps.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
        pps.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
      }
      sei.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
      return;
      label181:
      scratchSliceType.skipBits(i);
      i = scratchSliceType.peekExpGolombCodedNumLength();
      if ((i != -1) && (i <= scratchSliceType.bitsLeft()))
      {
        sliceType = scratchSliceType.readExpGolombCodeNum();
        isFilling = false;
      }
    }
  }
  
  private static void skipScalingList(ParsableBitArray paramParsableBitArray, int paramInt)
  {
    int k = 8;
    int m = 8;
    int j = 0;
    if (j < paramInt)
    {
      int i = m;
      if (m != 0) {
        i = (k + paramParsableBitArray.readSignedExpGolombCodedInt() + 256) % 256;
      }
      if (i == 0) {}
      for (;;)
      {
        j += 1;
        m = i;
        break;
        k = i;
      }
    }
  }
  
  public final void consume(ParsableByteArray paramParsableByteArray, long paramLong, boolean paramBoolean)
  {
    if (paramParsableByteArray.bytesLeft() > 0)
    {
      boolean bool1 = position;
      boolean bool2 = limit;
      byte[] arrayOfByte1 = data;
      totalBytesWritten += paramParsableByteArray.bytesLeft();
      output.sampleData(paramParsableByteArray, paramParsableByteArray.bytesLeft());
      while (bool1 < bool2)
      {
        boolean bool3 = NalUnitUtil.findNalUnit(arrayOfByte1, bool1, bool2, prefixFlags);
        if (bool3 < bool2)
        {
          int i2 = bool3 - bool1;
          if (i2 > 0) {
            feedNalUnitTargetBuffersData(arrayOfByte1, bool1, bool3);
          }
          int i1 = NalUnitUtil.getNalUnitType(arrayOfByte1, bool3);
          int i3 = bool2 - bool3;
          switch (i1)
          {
          default: 
            label148:
            if (i2 >= 0) {
              break;
            }
          }
          for (bool1 = -i2;; i = 0)
          {
            sps.endNalUnit(bool1);
            pps.endNalUnit(bool1);
            if (sei.endNalUnit(bool1))
            {
              bool1 = NalUnitUtil.unescapeStream(sei.nalData, sei.nalLength);
              seiWrapper.reset(sei.nalData, bool1);
              seiWrapper.setPosition(4);
              seiReader.consume(seiWrapper, paramLong, true);
            }
            Object localObject1;
            if (ifrParserBuffer != null)
            {
              localObject1 = ifrParserBuffer;
              if (i1 == 1)
              {
                ((IfrParserBuffer)localObject1).reset();
                isFilling = true;
              }
            }
            if (!hasOutputFormat)
            {
              sps.startNalUnit(i1);
              pps.startNalUnit(i1);
            }
            sei.startNalUnit(i1);
            bool1 = bool3 + true;
            break;
            isKeyframe = true;
            break label148;
            label391:
            int j;
            label722:
            label725:
            int k;
            label767:
            label773:
            label786:
            label793:
            long l;
            label824:
            label865:
            label965:
            float f1;
            if (foundFirstSample)
            {
              if (ifrParserBuffer != null)
              {
                if (ifrParserBuffer.sliceType == -1) {
                  break label767;
                }
                bool1 = true;
                if (bool1)
                {
                  bool1 = ifrParserBuffer.sliceType;
                  paramBoolean = isKeyframe;
                  if ((bool1 != true) && (bool1 != true)) {
                    break label773;
                  }
                  bool1 = true;
                  isKeyframe = (bool1 | paramBoolean);
                  ifrParserBuffer.reset();
                }
              }
              if ((isKeyframe) && (!hasOutputFormat) && (sps.isCompleted) && (pps.isCompleted))
              {
                localObject1 = sps;
                Object localObject2 = pps;
                byte[] arrayOfByte2 = new byte[nalLength];
                byte[] arrayOfByte3 = new byte[nalLength];
                System.arraycopy(nalData, 0, arrayOfByte2, 0, nalLength);
                System.arraycopy(nalData, 0, arrayOfByte3, 0, nalLength);
                localObject2 = new ArrayList();
                ((List)localObject2).add(arrayOfByte2);
                ((List)localObject2).add(arrayOfByte3);
                NalUnitUtil.unescapeStream(nalData, nalLength);
                localObject1 = new ParsableBitArray(nalData);
                ((ParsableBitArray)localObject1).skipBits(32);
                i = ((ParsableBitArray)localObject1).readBits(8);
                ((ParsableBitArray)localObject1).skipBits(16);
                ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                j = 1;
                if ((i == 100) || (i == 110) || (i == 122) || (i == 244) || (i == 44) || (i == 83) || (i == 86) || (i == 118) || (i == 128) || (i == 138))
                {
                  m = ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                  if (m == 3) {
                    ((ParsableBitArray)localObject1).skipBits(1);
                  }
                  ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                  ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                  ((ParsableBitArray)localObject1).skipBits(1);
                  if (((ParsableBitArray)localObject1).readBit())
                  {
                    if (m != 3)
                    {
                      i = 8;
                      j = 0;
                      if (j >= i) {
                        break label793;
                      }
                      if (((ParsableBitArray)localObject1).readBit()) {
                        if (j >= 6) {
                          break label786;
                        }
                      }
                    }
                    for (k = 16;; k = 64)
                    {
                      skipScalingList((ParsableBitArray)localObject1, k);
                      j += 1;
                      break label725;
                      i = 0;
                      break;
                      i = 0;
                      break label391;
                      i = 12;
                      break label722;
                    }
                  }
                  j = m;
                }
                ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                l = ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                if (l != 0L) {
                  break label1192;
                }
                ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                ((ParsableBitArray)localObject1).skipBits(1);
                int m = ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                k = ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                paramBoolean = ((ParsableBitArray)localObject1).readBit();
                if (!paramBoolean) {
                  break label1252;
                }
                i = 1;
                if (!paramBoolean) {
                  ((ParsableBitArray)localObject1).skipBits(1);
                }
                ((ParsableBitArray)localObject1).skipBits(1);
                m = (m + 1) * 16;
                int n = (2 - i) * (k + 1) * 16;
                k = m;
                i = n;
                if (((ParsableBitArray)localObject1).readBit())
                {
                  int i6 = ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                  int i7 = ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                  int i4 = ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                  int i5 = ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                  if (j != 0) {
                    break label1264;
                  }
                  j = 1;
                  if (!paramBoolean) {
                    break label1258;
                  }
                  i = 1;
                  k = 2 - i;
                  i = j;
                  j = k;
                  k = m - i * (i6 + i7);
                  i = n - j * (i4 + i5);
                }
                float f2 = 1.0F;
                if ((!((ParsableBitArray)localObject1).readBit()) || (!((ParsableBitArray)localObject1).readBit())) {
                  break label1363;
                }
                j = ((ParsableBitArray)localObject1).readBits(8);
                if (j != 255) {
                  break label1320;
                }
                j = ((ParsableBitArray)localObject1).readBits(16);
                m = ((ParsableBitArray)localObject1).readBits(16);
                f1 = f2;
                if (j != 0)
                {
                  f1 = f2;
                  if (m != 0) {
                    f1 = j / m;
                  }
                }
                label1086:
                output.format(MediaFormat.createVideoFormat("video/avc", -1, -1L, k, i, f1, (List)localObject2));
                hasOutputFormat = true;
              }
              if (!isKeyframe) {
                break label1369;
              }
            }
            label1192:
            label1252:
            label1258:
            label1264:
            label1273:
            label1282:
            label1308:
            label1314:
            label1320:
            label1363:
            label1369:
            for (i = 1;; i = 0)
            {
              j = (int)(totalBytesWritten - samplePosition);
              output.sampleMetadata(sampleTimeUs, i, j - i3, i3, null);
              foundFirstSample = true;
              samplePosition = (totalBytesWritten - i3);
              sampleTimeUs = paramLong;
              isKeyframe = false;
              break;
              if (l != 1L) {
                break label824;
              }
              ((ParsableBitArray)localObject1).skipBits(1);
              ((ParsableBitArray)localObject1).readSignedExpGolombCodedInt();
              ((ParsableBitArray)localObject1).readSignedExpGolombCodedInt();
              l = ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
              i = 0;
              while (i < l)
              {
                ((ParsableBitArray)localObject1).readUnsignedExpGolombCodedInt();
                i += 1;
              }
              break label824;
              i = 0;
              break label865;
              i = 0;
              break label965;
              if (j == 3)
              {
                i = 1;
                if (j != 1) {
                  break label1308;
                }
                j = 2;
                if (!paramBoolean) {
                  break label1314;
                }
              }
              for (k = 1;; k = 0)
              {
                j = (2 - k) * j;
                break;
                i = 2;
                break label1273;
                j = 1;
                break label1282;
              }
              if (j < NalUnitUtil.ASPECT_RATIO_IDC_VALUES.length)
              {
                f1 = NalUnitUtil.ASPECT_RATIO_IDC_VALUES[j];
                break label1086;
              }
              Log.w("H264Reader", "Unexpected aspect_ratio_idc value: " + j);
              f1 = 1.0F;
              break label1086;
            }
          }
        }
        feedNalUnitTargetBuffersData(arrayOfByte1, i, bool2);
        int i = bool2;
      }
    }
  }
  
  public final void packetFinished() {}
  
  public final void seek()
  {
    NalUnitUtil.clearPrefixFlags(prefixFlags);
    sps.reset();
    pps.reset();
    sei.reset();
    if (ifrParserBuffer != null) {
      ifrParserBuffer.reset();
    }
    foundFirstSample = false;
    totalBytesWritten = 0L;
  }
  
  private static final class IfrParserBuffer
  {
    byte[] ifrData = new byte[''];
    int ifrLength;
    boolean isFilling;
    final ParsableBitArray scratchSliceType = new ParsableBitArray(ifrData);
    int sliceType;
    
    public IfrParserBuffer()
    {
      reset();
    }
    
    public final void reset()
    {
      isFilling = false;
      ifrLength = 0;
      sliceType = -1;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.H264Reader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */