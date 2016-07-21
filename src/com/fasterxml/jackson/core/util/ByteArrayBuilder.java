package com.fasterxml.jackson.core.util;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class ByteArrayBuilder
  extends OutputStream
{
  public static final byte[] NO_BYTES = new byte[0];
  private final BufferRecycler _bufferRecycler = null;
  public byte[] _currBlock = new byte['Ǵ'];
  public int _currBlockPtr;
  private final LinkedList<byte[]> _pastBlocks = new LinkedList();
  private int _pastLen;
  
  public ByteArrayBuilder()
  {
    this((byte)0);
  }
  
  public ByteArrayBuilder(byte paramByte)
  {
    this('\000');
  }
  
  private ByteArrayBuilder(char paramChar) {}
  
  private void _allocMore()
  {
    _pastLen += _currBlock.length;
    int j = Math.max(_pastLen >> 1, 1000);
    int i = j;
    if (j > 262144) {
      i = 262144;
    }
    _pastBlocks.add(_currBlock);
    _currBlock = new byte[i];
    _currBlockPtr = 0;
  }
  
  public final void close() {}
  
  public final byte[] finishCurrentSegment()
  {
    _allocMore();
    return _currBlock;
  }
  
  public final void flush() {}
  
  public final void reset()
  {
    _pastLen = 0;
    _currBlockPtr = 0;
    if (!_pastBlocks.isEmpty()) {
      _pastBlocks.clear();
    }
  }
  
  public final byte[] toByteArray()
  {
    int j = _pastLen + _currBlockPtr;
    Object localObject;
    if (j == 0) {
      localObject = NO_BYTES;
    }
    byte[] arrayOfByte1;
    do
    {
      return (byte[])localObject;
      arrayOfByte1 = new byte[j];
      int i = 0;
      localObject = _pastBlocks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        byte[] arrayOfByte2 = (byte[])((Iterator)localObject).next();
        int k = arrayOfByte2.length;
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, k);
        i += k;
      }
      System.arraycopy(_currBlock, 0, arrayOfByte1, i, _currBlockPtr);
      i += _currBlockPtr;
      if (i != j) {
        throw new RuntimeException("Internal error: total len assumed to be " + j + ", copied " + i + " bytes");
      }
      localObject = arrayOfByte1;
    } while (_pastBlocks.isEmpty());
    reset();
    return arrayOfByte1;
  }
  
  public final void write(int paramInt)
  {
    if (_currBlockPtr >= _currBlock.length) {
      _allocMore();
    }
    byte[] arrayOfByte = _currBlock;
    int i = _currBlockPtr;
    _currBlockPtr = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    for (;;)
    {
      int k = Math.min(_currBlock.length - _currBlockPtr, paramInt2);
      int j = i;
      paramInt1 = paramInt2;
      if (k > 0)
      {
        System.arraycopy(paramArrayOfByte, i, _currBlock, _currBlockPtr, k);
        j = i + k;
        _currBlockPtr += k;
        paramInt1 = paramInt2 - k;
      }
      if (paramInt1 <= 0) {
        break;
      }
      _allocMore();
      i = j;
      paramInt2 = paramInt1;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.util.ByteArrayBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */