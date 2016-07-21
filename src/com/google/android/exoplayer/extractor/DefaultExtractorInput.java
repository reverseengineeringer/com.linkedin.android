package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.upstream.DataSource;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class DefaultExtractorInput
  implements ExtractorInput
{
  private static final byte[] SCRATCH_SPACE = new byte['က'];
  private final DataSource dataSource;
  private byte[] peekBuffer;
  private int peekBufferLength;
  private int peekBufferPosition;
  private long position;
  private final long streamLength;
  
  public DefaultExtractorInput(DataSource paramDataSource, long paramLong1, long paramLong2)
  {
    dataSource = paramDataSource;
    position = paramLong1;
    streamLength = paramLong2;
    peekBuffer = new byte[' '];
  }
  
  private void ensureSpaceForPeek(int paramInt)
  {
    paramInt = peekBufferPosition + paramInt;
    if (paramInt > peekBuffer.length) {
      peekBuffer = Arrays.copyOf(peekBuffer, Math.max(peekBuffer.length * 2, paramInt));
    }
  }
  
  private void updatePeekBuffer(int paramInt)
  {
    peekBufferLength -= paramInt;
    peekBufferPosition = 0;
    System.arraycopy(peekBuffer, paramInt, peekBuffer, 0, peekBufferLength);
  }
  
  public final void advancePeekPosition(int paramInt)
    throws IOException, InterruptedException
  {
    ensureSpaceForPeek(paramInt);
    int k = paramInt - Math.min(peekBufferLength - peekBufferPosition, paramInt);
    int j = k;
    int i = peekBufferLength;
    while (j > 0)
    {
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
      int m = dataSource.read(peekBuffer, i, j);
      if (m == -1) {
        throw new EOFException();
      }
      j -= m;
      i += m;
    }
    peekBufferPosition += paramInt;
    peekBufferLength += k;
  }
  
  public final long getLength()
  {
    return streamLength;
  }
  
  public final long getPosition()
  {
    return position;
  }
  
  public final void peekFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, InterruptedException
  {
    ensureSpaceForPeek(paramInt2);
    int i = Math.min(peekBufferLength - peekBufferPosition, paramInt2);
    System.arraycopy(peekBuffer, peekBufferPosition, paramArrayOfByte, paramInt1, i);
    paramInt1 += i;
    int k = paramInt2 - i;
    int j = k;
    i = peekBufferLength;
    while (j > 0)
    {
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
      int m = dataSource.read(peekBuffer, i, j);
      if (m == -1) {
        throw new EOFException();
      }
      System.arraycopy(peekBuffer, i, paramArrayOfByte, paramInt1, m);
      j -= m;
      i += m;
      paramInt1 += m;
    }
    peekBufferPosition += paramInt2;
    peekBufferLength += k;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, InterruptedException
  {
    int i = 0;
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    int j = Math.min(peekBufferLength, paramInt2);
    System.arraycopy(peekBuffer, 0, paramArrayOfByte, paramInt1, j);
    int k = paramInt2 - j;
    paramInt2 = i;
    if (k != 0) {
      paramInt2 = dataSource.read(paramArrayOfByte, paramInt1 + j, k);
    }
    if (paramInt2 == -1) {
      return -1;
    }
    updatePeekBuffer(j);
    paramInt1 = paramInt2 + j;
    position += paramInt1;
    return paramInt1;
  }
  
  public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, InterruptedException
  {
    readFully(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public final boolean readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    int j = Math.min(peekBufferLength, paramInt2);
    System.arraycopy(peekBuffer, 0, paramArrayOfByte, paramInt1, j);
    int i = paramInt1 + j;
    paramInt1 = paramInt2 - j;
    while (paramInt1 > 0)
    {
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
      int k = dataSource.read(paramArrayOfByte, i, paramInt1);
      if (k == -1)
      {
        if ((paramBoolean) && (paramInt1 == paramInt2)) {
          return false;
        }
        throw new EOFException();
      }
      i += k;
      paramInt1 -= k;
    }
    updatePeekBuffer(j);
    position += paramInt2;
    return true;
  }
  
  public final void resetPeekPosition()
  {
    peekBufferPosition = 0;
  }
  
  public final void skipFully(int paramInt)
    throws IOException, InterruptedException
  {
    int j = Math.min(peekBufferLength, paramInt);
    int i = paramInt - j;
    while (i > 0)
    {
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
      int k = dataSource.read(SCRATCH_SPACE, 0, Math.min(SCRATCH_SPACE.length, i));
      if (k == -1) {
        throw new EOFException();
      }
      i -= k;
    }
    updatePeekBuffer(j);
    position += paramInt;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.DefaultExtractorInput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */