package com.google.android.exoplayer.extractor;

import android.media.MediaCodec.CryptoInfo;
import com.google.android.exoplayer.CryptoInfo;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.upstream.Allocation;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;

public class DefaultTrackOutput
  implements TrackOutput
{
  public volatile MediaFormat format;
  public volatile long largestParsedTimestampUs;
  public long lastReadTimeUs;
  private boolean needKeyframe;
  public final RollingSampleBuffer rollingBuffer;
  public final SampleHolder sampleInfoHolder;
  public long spliceOutTimeUs;
  
  public DefaultTrackOutput(Allocator paramAllocator)
  {
    rollingBuffer = new RollingSampleBuffer(paramAllocator);
    sampleInfoHolder = new SampleHolder(0);
    needKeyframe = true;
    lastReadTimeUs = Long.MIN_VALUE;
    spliceOutTimeUs = Long.MIN_VALUE;
    largestParsedTimestampUs = Long.MIN_VALUE;
  }
  
  private boolean advanceToEligibleSample()
  {
    boolean bool1 = rollingBuffer.peekSample(sampleInfoHolder);
    boolean bool2 = bool1;
    if (needKeyframe) {
      for (;;)
      {
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        bool2 = bool1;
        if (sampleInfoHolder.isSyncFrame()) {
          break;
        }
        rollingBuffer.skipSample();
        bool1 = rollingBuffer.peekSample(sampleInfoHolder);
      }
    }
    if (!bool2) {}
    while ((spliceOutTimeUs != Long.MIN_VALUE) && (sampleInfoHolder.timeUs >= spliceOutTimeUs)) {
      return false;
    }
    return true;
  }
  
  public final void clear()
  {
    RollingSampleBuffer localRollingSampleBuffer = rollingBuffer;
    RollingSampleBuffer.InfoQueue localInfoQueue = infoQueue;
    absoluteReadIndex = 0;
    relativeReadIndex = 0;
    relativeWriteIndex = 0;
    queueSize = 0;
    while (!dataQueue.isEmpty()) {
      allocator.release((Allocation)dataQueue.remove());
    }
    totalBytesDropped = 0L;
    totalBytesWritten = 0L;
    lastAllocation = null;
    lastAllocationOffset = allocationLength;
    needKeyframe = true;
    lastReadTimeUs = Long.MIN_VALUE;
    spliceOutTimeUs = Long.MIN_VALUE;
    largestParsedTimestampUs = Long.MIN_VALUE;
  }
  
  public final void discardUntil(long paramLong)
  {
    while ((rollingBuffer.peekSample(sampleInfoHolder)) && (sampleInfoHolder.timeUs < paramLong))
    {
      rollingBuffer.skipSample();
      needKeyframe = true;
    }
    lastReadTimeUs = Long.MIN_VALUE;
  }
  
  public final void format(MediaFormat paramMediaFormat)
  {
    format = paramMediaFormat;
  }
  
  public final boolean getSample(SampleHolder paramSampleHolder)
  {
    if (!advanceToEligibleSample()) {
      return false;
    }
    RollingSampleBuffer localRollingSampleBuffer = rollingBuffer;
    if (infoQueue.peekSample(paramSampleHolder, extrasHolder))
    {
      RollingSampleBuffer.SampleExtrasHolder localSampleExtrasHolder;
      long l1;
      int j;
      int i;
      Object localObject2;
      Object localObject1;
      if (paramSampleHolder.isEncrypted())
      {
        localSampleExtrasHolder = extrasHolder;
        l1 = offset;
        localRollingSampleBuffer.readData(l1, scratch.data, 1);
        l1 = 1L + l1;
        j = scratch.data[0];
        if ((j & 0x80) != 0)
        {
          i = 1;
          j &= 0x7F;
          if (cryptoInfo.iv == null) {
            cryptoInfo.iv = new byte[16];
          }
          localRollingSampleBuffer.readData(l1, cryptoInfo.iv, j);
          l1 += j;
          if (i == 0) {
            break label356;
          }
          localRollingSampleBuffer.readData(l1, scratch.data, 2);
          l1 += 2L;
          scratch.setPosition(0);
        }
        long l2;
        label356:
        for (j = scratch.readUnsignedShort();; j = 1)
        {
          localObject2 = cryptoInfo.numBytesOfClearData;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (localObject2.length >= j) {}
          }
          else
          {
            localObject1 = new int[j];
          }
          localObject3 = cryptoInfo.numBytesOfEncryptedData;
          if (localObject3 != null)
          {
            localObject2 = localObject3;
            if (localObject3.length >= j) {}
          }
          else
          {
            localObject2 = new int[j];
          }
          if (i == 0) {
            break label671;
          }
          i = j * 6;
          localObject3 = scratch;
          if (limit < i) {
            ((ParsableByteArray)localObject3).reset(new byte[i], i);
          }
          localRollingSampleBuffer.readData(l1, scratch.data, i);
          l2 = i;
          scratch.setPosition(0);
          i = 0;
          while (i < j)
          {
            localObject1[i] = scratch.readUnsignedShort();
            localObject2[i] = scratch.readUnsignedIntToInt();
            i += 1;
          }
          i = 0;
          break;
        }
        l1 += l2;
        Object localObject3 = cryptoInfo;
        byte[] arrayOfByte1 = encryptionKeyId;
        byte[] arrayOfByte2 = cryptoInfo.iv;
        numSubSamples = j;
        numBytesOfClearData = ((int[])localObject1);
        numBytesOfEncryptedData = ((int[])localObject2);
        key = arrayOfByte1;
        iv = arrayOfByte2;
        mode = 1;
        if (Util.SDK_INT >= 16) {
          frameworkCryptoInfo.set(numSubSamples, numBytesOfClearData, numBytesOfEncryptedData, key, iv, mode);
        }
        i = (int)(l1 - offset);
        offset += i;
        size -= i;
      }
      if ((data == null) || (data.capacity() < size))
      {
        i = size;
        switch (bufferReplacementMode)
        {
        }
      }
      for (;;)
      {
        if (data == null) {
          break label719;
        }
        l1 = extrasHolder.offset;
        localObject1 = data;
        i = size;
        while (i > 0)
        {
          localRollingSampleBuffer.dropDownstreamTo(l1);
          j = (int)(l1 - totalBytesDropped);
          int k = Math.min(i, allocationLength - j);
          localObject2 = (Allocation)dataQueue.peek();
          ((ByteBuffer)localObject1).put(data, offset + j, k);
          l1 += k;
          i -= k;
        }
        label671:
        localObject1[0] = 0;
        localObject2[0] = (size - (int)(l1 - offset));
        break;
        data = ByteBuffer.allocate(i);
        continue;
        data = ByteBuffer.allocateDirect(i);
      }
      label719:
      localRollingSampleBuffer.dropDownstreamTo(infoQueue.moveToNextSample());
    }
    needKeyframe = false;
    lastReadTimeUs = timeUs;
    return true;
  }
  
  public final boolean hasFormat()
  {
    return format != null;
  }
  
  public final boolean isEmpty()
  {
    return !advanceToEligibleSample();
  }
  
  public final int sampleData(ExtractorInput paramExtractorInput, int paramInt, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    RollingSampleBuffer localRollingSampleBuffer = rollingBuffer;
    paramInt = localRollingSampleBuffer.prepareForAppend(paramInt);
    byte[] arrayOfByte = lastAllocation.data;
    Allocation localAllocation = lastAllocation;
    int i = lastAllocationOffset;
    paramInt = paramExtractorInput.read(arrayOfByte, offset + i, paramInt);
    if (paramInt == -1)
    {
      if (paramBoolean) {
        return -1;
      }
      throw new EOFException();
    }
    lastAllocationOffset += paramInt;
    totalBytesWritten += paramInt;
    return paramInt;
  }
  
  public final void sampleData(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    RollingSampleBuffer localRollingSampleBuffer = rollingBuffer;
    while (paramInt > 0)
    {
      int i = localRollingSampleBuffer.prepareForAppend(paramInt);
      byte[] arrayOfByte = lastAllocation.data;
      Allocation localAllocation = lastAllocation;
      int j = lastAllocationOffset;
      paramParsableByteArray.readBytes(arrayOfByte, offset + j, i);
      lastAllocationOffset += i;
      totalBytesWritten += i;
      paramInt -= i;
    }
  }
  
  public void sampleMetadata(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    largestParsedTimestampUs = Math.max(largestParsedTimestampUs, paramLong);
    RollingSampleBuffer localRollingSampleBuffer = rollingBuffer;
    long l1 = rollingBuffer.totalBytesWritten;
    long l2 = paramInt2;
    long l3 = paramInt3;
    infoQueue.commitSample(paramLong, paramInt1, l1 - l2 - l3, paramInt2, paramArrayOfByte);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.DefaultTrackOutput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */