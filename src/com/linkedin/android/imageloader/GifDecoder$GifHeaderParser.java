package com.linkedin.android.imageloader;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.List;

final class GifDecoder$GifHeaderParser
{
  final byte[] block = new byte['Ā'];
  int blockSize = 0;
  GifDecoder.GifHeader header;
  ByteBuffer rawData;
  
  private int read()
  {
    try
    {
      int i = rawData.get();
      return i & 0xFF;
    }
    catch (Exception localException)
    {
      header.status = 1;
    }
    return 0;
  }
  
  private int readBlock()
  {
    blockSize = read();
    int m = 0;
    int i = 0;
    if (blockSize > 0)
    {
      int j = 0;
      for (;;)
      {
        int k = j;
        m = i;
        try
        {
          if (i < blockSize)
          {
            k = j;
            j = blockSize - i;
            k = j;
            rawData.get(block, i, j);
            i += j;
          }
        }
        catch (Exception localException)
        {
          if (Log.isLoggable("GifHeaderParser", 3)) {
            Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + k + " blockSize: " + blockSize, localException);
          }
          header.status = 1;
          m = i;
        }
      }
    }
    return m;
  }
  
  private int[] readColorTable(int paramInt)
  {
    localObject = null;
    byte[] arrayOfByte = new byte[paramInt * 3];
    try
    {
      rawData.get(arrayOfByte);
      int[] arrayOfInt = new int['Ā'];
      int j = 0;
      int i = 0;
      for (;;)
      {
        localObject = arrayOfInt;
        if (i >= paramInt) {
          break;
        }
        int k = j + 1;
        j = arrayOfByte[j];
        int m = k + 1;
        arrayOfInt[i] = (0xFF000000 | (j & 0xFF) << 16 | (arrayOfByte[k] & 0xFF) << 8 | arrayOfByte[m] & 0xFF);
        j = m + 1;
        i += 1;
      }
      return (int[])localObject;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      if (Log.isLoggable("GifHeaderParser", 3)) {
        Log.d("GifHeaderParser", "Format Error Reading Color Table", localBufferUnderflowException);
      }
      header.status = 1;
    }
  }
  
  private void readNetscapeExt()
  {
    do
    {
      readBlock();
      if (block[0] == 1)
      {
        int i = block[1];
        int j = block[2];
        header.loopCount = ((j & 0xFF) << 8 | i & 0xFF);
      }
    } while ((blockSize > 0) && (!err()));
  }
  
  private void skip()
  {
    int i;
    do
    {
      i = read();
      rawData.position(rawData.position() + i);
    } while (i > 0);
  }
  
  final boolean err()
  {
    return header.status != 0;
  }
  
  final void readContents$13462e()
  {
    int i = 0;
    while ((i == 0) && (!err()) && (header.frameCount <= Integer.MAX_VALUE))
    {
      int k;
      int j;
      label183:
      Object localObject;
      boolean bool;
      switch (read())
      {
      default: 
        header.status = 1;
        break;
      case 44: 
        if (header.currentFrame == null) {
          header.currentFrame = new GifDecoder.GifFrame((byte)0);
        }
        header.currentFrame.ix = rawData.getShort();
        header.currentFrame.iy = rawData.getShort();
        header.currentFrame.iw = rawData.getShort();
        header.currentFrame.ih = rawData.getShort();
        k = read();
        int m;
        if ((k & 0x80) != 0)
        {
          j = 1;
          m = (int)Math.pow(2.0D, (k & 0x7) + 1);
          localObject = header.currentFrame;
          if ((k & 0x40) == 0) {
            break label324;
          }
          bool = true;
          interlace = bool;
          if (j == 0) {
            break label330;
          }
        }
        for (header.currentFrame.lct = readColorTable(m);; header.currentFrame.lct = null)
        {
          header.currentFrame.bufferFrameStart = rawData.position();
          read();
          skip();
          if (err()) {
            break;
          }
          localObject = header;
          frameCount += 1;
          header.frames.add(header.currentFrame);
          break;
          j = 0;
          break label183;
          bool = false;
          break label218;
        }
      case 33: 
        switch (read())
        {
        default: 
          skip();
          break;
        case 249: 
          header.currentFrame = new GifDecoder.GifFrame((byte)0);
          read();
          j = read();
          header.currentFrame.dispose = ((j & 0x1C) >> 2);
          if (header.currentFrame.dispose == 0) {
            header.currentFrame.dispose = 1;
          }
          localObject = header.currentFrame;
          if ((j & 0x1) != 0) {}
          for (bool = true;; bool = false)
          {
            transparency = bool;
            k = rawData.getShort();
            j = k;
            if (k < 2) {
              j = 10;
            }
            header.currentFrame.delay = (j * 10);
            header.currentFrame.transIndex = read();
            read();
            break;
          }
        case 255: 
          readBlock();
          localObject = "";
          j = 0;
          while (j < 11)
          {
            localObject = (String)localObject + (char)block[j];
            j += 1;
          }
          if (((String)localObject).equals("NETSCAPE2.0")) {
            readNetscapeExt();
          } else {
            skip();
          }
          break;
        case 254: 
          skip();
          break;
        case 1: 
          skip();
        }
        break;
      case 59: 
        label218:
        label324:
        label330:
        i = 1;
      }
    }
  }
  
  final void readHeader()
  {
    boolean bool = true;
    Object localObject = "";
    int i = 0;
    while (i < 6)
    {
      localObject = (String)localObject + (char)read();
      i += 1;
    }
    if (!((String)localObject).startsWith("GIF"))
    {
      header.status = 1;
      return;
    }
    header.width = rawData.getShort();
    header.height = rawData.getShort();
    i = read();
    localObject = header;
    if ((i & 0x80) != 0) {}
    for (;;)
    {
      gctFlag = bool;
      header.gctSize = (2 << (i & 0x7));
      header.bgIndex = read();
      header.pixelAspect = read();
      if ((!header.gctFlag) || (err())) {
        break;
      }
      header.gct = readColorTable(header.gctSize);
      header.bgColor = header.gct[header.bgIndex];
      return;
      bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.GifDecoder.GifHeaderParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */