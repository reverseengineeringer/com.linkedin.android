package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.nio.BufferOverflowException;

final class BufferingInput
{
  final ParsableByteArray buffer = new ParsableByteArray(24576);
  private final int capacity = 12288;
  private int markPosition;
  int readPosition;
  int writePosition;
  
  final boolean ensureLoaded(ExtractorInput paramExtractorInput, int paramInt)
    throws InterruptedException, IOException
  {
    boolean bool = true;
    if (readPosition + paramInt - markPosition > capacity) {
      throw new BufferOverflowException();
    }
    paramInt -= writePosition - readPosition;
    if (paramInt > 0)
    {
      if (!paramExtractorInput.readFully(buffer.data, writePosition, paramInt, true)) {
        bool = false;
      }
    }
    else {
      return bool;
    }
    writePosition += paramInt;
    return true;
  }
  
  public final void mark()
  {
    if (readPosition > capacity)
    {
      System.arraycopy(buffer.data, readPosition, buffer.data, 0, writePosition - readPosition);
      writePosition -= readPosition;
      readPosition = 0;
    }
    markPosition = readPosition;
  }
  
  public final void read$35bcd88(ExtractorInput paramExtractorInput, byte[] paramArrayOfByte, int paramInt)
    throws IOException, InterruptedException
  {
    if (!readInternal$35bcd8c(paramExtractorInput, paramArrayOfByte, paramInt)) {
      throw new EOFException();
    }
  }
  
  final boolean readInternal$35bcd8c(ExtractorInput paramExtractorInput, byte[] paramArrayOfByte, int paramInt)
    throws InterruptedException, IOException
  {
    if (!ensureLoaded(paramExtractorInput, paramInt)) {
      return false;
    }
    if (paramArrayOfByte != null) {
      System.arraycopy(buffer.data, readPosition, paramArrayOfByte, 0, paramInt);
    }
    readPosition += paramInt;
    return true;
  }
  
  public final void reset()
  {
    readPosition = 0;
    writePosition = 0;
    markPosition = 0;
  }
  
  public final void returnToMark()
  {
    readPosition = markPosition;
  }
  
  public final void skip(ExtractorInput paramExtractorInput, int paramInt)
    throws IOException, InterruptedException
  {
    if (!readInternal$35bcd8c(paramExtractorInput, null, paramInt)) {
      throw new EOFException();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp3.BufferingInput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */