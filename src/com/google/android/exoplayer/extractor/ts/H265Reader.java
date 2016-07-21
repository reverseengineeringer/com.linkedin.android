package com.google.android.exoplayer.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.util.Collections;

final class H265Reader
  extends ElementaryStreamReader
{
  private boolean foundFirstSample;
  private boolean hasOutputFormat;
  private boolean isKeyframe;
  private final NalUnitTargetBuffer pps;
  private final boolean[] prefixFlags;
  private final NalUnitTargetBuffer prefixSei;
  private long samplePosition;
  private long sampleTimeUs;
  private final SeiReader seiReader;
  private final ParsableByteArray seiWrapper;
  private final NalUnitTargetBuffer sps;
  private final NalUnitTargetBuffer suffixSei;
  private long totalBytesWritten;
  private final NalUnitTargetBuffer vps;
  
  public H265Reader(TrackOutput paramTrackOutput, SeiReader paramSeiReader)
  {
    super(paramTrackOutput);
    seiReader = paramSeiReader;
    prefixFlags = new boolean[3];
    vps = new NalUnitTargetBuffer(32);
    sps = new NalUnitTargetBuffer(33);
    pps = new NalUnitTargetBuffer(34);
    prefixSei = new NalUnitTargetBuffer(39);
    suffixSei = new NalUnitTargetBuffer(40);
    seiWrapper = new ParsableByteArray();
  }
  
  private void feedNalUnitTargetBuffersData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!hasOutputFormat)
    {
      vps.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
      sps.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
      pps.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
    }
    prefixSei.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
    suffixSei.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final void consume(ParsableByteArray paramParsableByteArray, long paramLong, boolean paramBoolean)
  {
    int i;
    int i2;
    byte[] arrayOfByte1;
    int i3;
    int i5;
    int i4;
    int i6;
    Object localObject;
    byte[] arrayOfByte2;
    int m;
    int k;
    int j;
    int i1;
    int n;
    int i9;
    int i7;
    for (;;)
    {
      if (paramParsableByteArray.bytesLeft() > 0)
      {
        i = position;
        i2 = limit;
        arrayOfByte1 = data;
        totalBytesWritten += paramParsableByteArray.bytesLeft();
        output.sampleData(paramParsableByteArray, paramParsableByteArray.bytesLeft());
        if (i < i2)
        {
          i3 = NalUnitUtil.findNalUnit(arrayOfByte1, i, i2, prefixFlags);
          if (i3 < i2)
          {
            i5 = i3 - i;
            if (i5 > 0) {
              feedNalUnitTargetBuffersData(arrayOfByte1, i, i3);
            }
            i4 = NalUnitUtil.getH265NalUnitType(arrayOfByte1, i3);
            i6 = i2 - i3;
            i = NalUnitUtil.getH265NalUnitType(arrayOfByte1, i3);
            if ((i <= 9) || ((i >= 16) && (i <= 21))) {
              if ((arrayOfByte1[(i3 + 5)] & 0x80) != 0) {
                i = 1;
              }
            }
            for (;;)
            {
              if (i != 0) {
                if (foundFirstSample) {
                  if ((isKeyframe) && (!hasOutputFormat) && (vps.isCompleted) && (sps.isCompleted) && (pps.isCompleted))
                  {
                    localObject = vps;
                    NalUnitTargetBuffer localNalUnitTargetBuffer1 = sps;
                    NalUnitTargetBuffer localNalUnitTargetBuffer2 = pps;
                    arrayOfByte2 = new byte[nalLength + nalLength + nalLength];
                    System.arraycopy(nalData, 0, arrayOfByte2, 0, nalLength);
                    System.arraycopy(nalData, 0, arrayOfByte2, nalLength, nalLength);
                    System.arraycopy(nalData, 0, arrayOfByte2, nalLength + nalLength, nalLength);
                    NalUnitUtil.unescapeStream(nalData, nalLength);
                    localObject = new ParsableBitArray(nalData);
                    ((ParsableBitArray)localObject).skipBits(44);
                    m = ((ParsableBitArray)localObject).readBits(3);
                    ((ParsableBitArray)localObject).skipBits(1);
                    ((ParsableBitArray)localObject).skipBits(88);
                    ((ParsableBitArray)localObject).skipBits(8);
                    i = 0;
                    k = 0;
                    for (;;)
                    {
                      if (k < m)
                      {
                        j = i;
                        if (((ParsableBitArray)localObject).readBits(1) == 1) {
                          j = i + 89;
                        }
                        i = j;
                        if (((ParsableBitArray)localObject).readBits(1) == 1) {
                          i = j + 8;
                        }
                        k += 1;
                        continue;
                        i = 0;
                        break;
                        i = 0;
                        break;
                      }
                    }
                    ((ParsableBitArray)localObject).skipBits(i);
                    if (m > 0) {
                      ((ParsableBitArray)localObject).skipBits((8 - m) * 2);
                    }
                    ((ParsableBitArray)localObject).readExpGolombCodeNum();
                    int i10 = ((ParsableBitArray)localObject).readExpGolombCodeNum();
                    if (i10 == 3) {
                      ((ParsableBitArray)localObject).skipBits(1);
                    }
                    i1 = ((ParsableBitArray)localObject).readExpGolombCodeNum();
                    n = ((ParsableBitArray)localObject).readExpGolombCodeNum();
                    k = i1;
                    j = n;
                    if (((ParsableBitArray)localObject).readBit())
                    {
                      k = ((ParsableBitArray)localObject).readExpGolombCodeNum();
                      i9 = ((ParsableBitArray)localObject).readExpGolombCodeNum();
                      i7 = ((ParsableBitArray)localObject).readExpGolombCodeNum();
                      i8 = ((ParsableBitArray)localObject).readExpGolombCodeNum();
                      if ((i10 == 1) || (i10 == 2))
                      {
                        i = 2;
                        if (i10 != 1) {
                          break label693;
                        }
                        j = 2;
                        label597:
                        k = i1 - i * (k + i9);
                        j = n - j * (i7 + i8);
                      }
                    }
                    else
                    {
                      ((ParsableBitArray)localObject).readExpGolombCodeNum();
                      ((ParsableBitArray)localObject).readExpGolombCodeNum();
                      i7 = ((ParsableBitArray)localObject).readExpGolombCodeNum();
                      if (!((ParsableBitArray)localObject).readBit()) {
                        break label699;
                      }
                      i = 0;
                    }
                    for (;;)
                    {
                      if (i > m) {
                        break label706;
                      }
                      ((ParsableBitArray)localObject).readExpGolombCodeNum();
                      ((ParsableBitArray)localObject).readExpGolombCodeNum();
                      ((ParsableBitArray)localObject).readExpGolombCodeNum();
                      i += 1;
                      continue;
                      i = 1;
                      break;
                      label693:
                      j = 1;
                      break label597;
                      label699:
                      i = m;
                    }
                    label706:
                    ((ParsableBitArray)localObject).readExpGolombCodeNum();
                    ((ParsableBitArray)localObject).readExpGolombCodeNum();
                    ((ParsableBitArray)localObject).readExpGolombCodeNum();
                    ((ParsableBitArray)localObject).readExpGolombCodeNum();
                    ((ParsableBitArray)localObject).readExpGolombCodeNum();
                    ((ParsableBitArray)localObject).readExpGolombCodeNum();
                    if ((((ParsableBitArray)localObject).readBit()) && (((ParsableBitArray)localObject).readBit()))
                    {
                      i = 0;
                      while (i < 4)
                      {
                        m = 0;
                        if (m < 6)
                        {
                          if (!((ParsableBitArray)localObject).readBit())
                          {
                            ((ParsableBitArray)localObject).readExpGolombCodeNum();
                            label791:
                            if (i != 3) {
                              break label862;
                            }
                          }
                          label862:
                          for (n = 3;; n = 1)
                          {
                            m = n + m;
                            break;
                            i1 = Math.min(64, 1 << (i + 4 << 1));
                            if (i > 1) {
                              ((ParsableBitArray)localObject).readSignedExpGolombCodedInt();
                            }
                            n = 0;
                            while (n < i1)
                            {
                              ((ParsableBitArray)localObject).readSignedExpGolombCodedInt();
                              n += 1;
                            }
                            break label791;
                          }
                        }
                        i += 1;
                      }
                    }
                    ((ParsableBitArray)localObject).skipBits(2);
                    if (((ParsableBitArray)localObject).readBit())
                    {
                      ((ParsableBitArray)localObject).skipBits(4);
                      ((ParsableBitArray)localObject).readExpGolombCodeNum();
                      ((ParsableBitArray)localObject).readExpGolombCodeNum();
                      ((ParsableBitArray)localObject).skipBits(1);
                    }
                    int i8 = ((ParsableBitArray)localObject).readExpGolombCodeNum();
                    i = 0;
                    n = 0;
                    paramBoolean = false;
                    label931:
                    if (i < i8)
                    {
                      if (i == 0) {
                        break label1706;
                      }
                      paramBoolean = ((ParsableBitArray)localObject).readBit();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1232:
    label1276:
    label1378:
    label1670:
    label1676:
    label1682:
    label1706:
    for (;;)
    {
      if (paramBoolean)
      {
        ((ParsableBitArray)localObject).skipBits(1);
        ((ParsableBitArray)localObject).readExpGolombCodeNum();
        i1 = 0;
        for (;;)
        {
          m = n;
          if (i1 > n) {
            break;
          }
          if (((ParsableBitArray)localObject).readBit()) {
            ((ParsableBitArray)localObject).skipBits(1);
          }
          i1 += 1;
        }
      }
      n = ((ParsableBitArray)localObject).readExpGolombCodeNum();
      i9 = ((ParsableBitArray)localObject).readExpGolombCodeNum();
      i1 = n + i9;
      m = 0;
      while (m < n)
      {
        ((ParsableBitArray)localObject).readExpGolombCodeNum();
        ((ParsableBitArray)localObject).skipBits(1);
        m += 1;
      }
      n = 0;
      for (;;)
      {
        m = i1;
        if (n >= i9) {
          break;
        }
        ((ParsableBitArray)localObject).readExpGolombCodeNum();
        ((ParsableBitArray)localObject).skipBits(1);
        n += 1;
      }
      i += 1;
      n = m;
      break label931;
      if (((ParsableBitArray)localObject).readBit())
      {
        i = 0;
        while (i < ((ParsableBitArray)localObject).readExpGolombCodeNum())
        {
          ((ParsableBitArray)localObject).skipBits(i7 + 4 + 1);
          i += 1;
        }
      }
      ((ParsableBitArray)localObject).skipBits(2);
      float f2 = 1.0F;
      float f1;
      if ((((ParsableBitArray)localObject).readBit()) && (((ParsableBitArray)localObject).readBit()))
      {
        i = ((ParsableBitArray)localObject).readBits(8);
        if (i == 255)
        {
          i = ((ParsableBitArray)localObject).readBits(16);
          m = ((ParsableBitArray)localObject).readBits(16);
          f1 = f2;
          if (i != 0)
          {
            f1 = f2;
            if (m != 0) {
              f1 = i / m;
            }
          }
          output.format(MediaFormat.createVideoFormat("video/hevc", -1, -1L, k, j, f1, Collections.singletonList(arrayOfByte2)));
          hasOutputFormat = true;
          if (!isKeyframe) {
            break label1670;
          }
          i = 1;
          j = (int)(totalBytesWritten - samplePosition);
          output.sampleMetadata(sampleTimeUs, i, j - i6, i6, null);
          foundFirstSample = true;
          samplePosition = (totalBytesWritten - i6);
          sampleTimeUs = paramLong;
          if ((i4 != 16) && (i4 != 17) && (i4 != 18) && (i4 != 19) && (i4 != 20) && (i4 != 21)) {
            break label1676;
          }
          paramBoolean = true;
          isKeyframe = paramBoolean;
          if (i5 >= 0) {
            break label1682;
          }
        }
      }
      for (i = -i5;; i = 0)
      {
        vps.endNalUnit(i);
        sps.endNalUnit(i);
        pps.endNalUnit(i);
        if (prefixSei.endNalUnit(i))
        {
          j = NalUnitUtil.unescapeStream(prefixSei.nalData, prefixSei.nalLength);
          seiWrapper.reset(prefixSei.nalData, j);
          seiWrapper.skipBytes(5);
          seiReader.consume(seiWrapper, paramLong, true);
        }
        if (suffixSei.endNalUnit(i))
        {
          i = NalUnitUtil.unescapeStream(suffixSei.nalData, suffixSei.nalLength);
          seiWrapper.reset(suffixSei.nalData, i);
          seiWrapper.skipBytes(5);
          seiReader.consume(seiWrapper, paramLong, true);
        }
        if (!hasOutputFormat)
        {
          vps.startNalUnit(i4);
          sps.startNalUnit(i4);
          pps.startNalUnit(i4);
        }
        prefixSei.startNalUnit(i4);
        suffixSei.startNalUnit(i4);
        i = i3 + 3;
        break;
        if (i < NalUnitUtil.ASPECT_RATIO_IDC_VALUES.length)
        {
          f1 = NalUnitUtil.ASPECT_RATIO_IDC_VALUES[i];
          break label1232;
        }
        Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + i);
        f1 = 1.0F;
        break label1232;
        i = 0;
        break label1276;
        paramBoolean = false;
        break label1378;
      }
      feedNalUnitTargetBuffersData(arrayOfByte1, i, i2);
      i = i2;
      break;
      return;
    }
  }
  
  public final void packetFinished() {}
  
  public final void seek()
  {
    NalUnitUtil.clearPrefixFlags(prefixFlags);
    vps.reset();
    sps.reset();
    pps.reset();
    prefixSei.reset();
    suffixSei.reset();
    foundFirstSample = false;
    totalBytesWritten = 0L;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.H265Reader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */