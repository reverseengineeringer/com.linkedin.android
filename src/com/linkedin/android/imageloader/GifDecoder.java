package com.linkedin.android.imageloader;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import com.linkedin.android.imageloader.interfaces.IBitmapFactory;
import com.linkedin.android.networking.streams.PoolingByteArrayOutputStream;
import com.linkedin.android.networking.util.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class GifDecoder
{
  private static final String TAG = GifDecoder.class.getSimpleName();
  private int[] act;
  IBitmapFactory bitmapFactory;
  byte[] block;
  ByteArrayPool byteArrayPool;
  int byteSize;
  private int downsampledHeight;
  private int downsampledWidth;
  int framePointer;
  GifHeader header;
  IntArrayPool intArrayPool;
  boolean isFirstFrameTransparent;
  byte[] mainPixels;
  int[] mainScratch;
  private GifHeaderParser parser;
  private byte[] pixelStack;
  private short[] prefix;
  Bitmap previousImage;
  ByteBuffer rawData;
  private int sampleSize;
  private boolean savePrevious;
  boolean shouldLoop = true;
  private int status;
  private byte[] suffix;
  byte[] workBuffer;
  private int workBufferPosition = 0;
  private int workBufferSize = 0;
  
  GifDecoder(IBitmapFactory paramIBitmapFactory, ByteArrayPool paramByteArrayPool, IntArrayPool paramIntArrayPool)
  {
    bitmapFactory = paramIBitmapFactory;
    byteArrayPool = paramByteArrayPool;
    intArrayPool = paramIntArrayPool;
    header = new GifHeader();
  }
  
  private Bitmap getNextBitmap()
  {
    if (isFirstFrameTransparent) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = bitmapFactory.getBitmap(downsampledWidth, downsampledHeight, (Bitmap.Config)localObject);
      if (Build.VERSION.SDK_INT >= 12) {
        ((Bitmap)localObject).setHasAlpha(true);
      }
      return (Bitmap)localObject;
    }
  }
  
  private int readBlock()
  {
    int i = readByte();
    if (i > 0)
    {
      try
      {
        if (block == null) {
          block = byteArrayPool.getBuf(255);
        }
        int j = workBufferSize - workBufferPosition;
        if (j >= i)
        {
          System.arraycopy(workBuffer, workBufferPosition, block, 0, i);
          workBufferPosition += i;
          return i;
        }
        if (rawData.remaining() + j >= i)
        {
          System.arraycopy(workBuffer, workBufferPosition, block, 0, j);
          workBufferPosition = workBufferSize;
          readChunkIfNeeded();
          int k = i - j;
          System.arraycopy(workBuffer, 0, block, j, k);
          workBufferPosition += k;
          return i;
        }
      }
      catch (Exception localException)
      {
        Log.w(TAG, "Error Reading Block", localException);
        status = 1;
        return i;
      }
      status = 1;
    }
    return i;
  }
  
  private int readByte()
  {
    try
    {
      readChunkIfNeeded();
      byte[] arrayOfByte = workBuffer;
      int i = workBufferPosition;
      workBufferPosition = (i + 1);
      i = arrayOfByte[i];
      return i & 0xFF;
    }
    catch (Exception localException)
    {
      status = 1;
    }
    return 0;
  }
  
  private void readChunkIfNeeded()
  {
    if (workBufferSize > workBufferPosition) {
      return;
    }
    if (workBuffer == null) {
      workBuffer = byteArrayPool.getBuf(16384);
    }
    workBufferPosition = 0;
    workBufferSize = Math.min(rawData.remaining(), 16384);
    rawData.get(workBuffer, 0, workBufferSize);
  }
  
  private void setData(GifHeader paramGifHeader, ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt <= 0) {
      try
      {
        throw new IllegalArgumentException("Sample size must be >0, not: " + paramInt);
      }
      finally {}
    }
    paramInt = Integer.highestOneBit(paramInt);
    status = 0;
    header = paramGifHeader;
    isFirstFrameTransparent = false;
    framePointer = -1;
    rawData = paramByteBuffer.asReadOnlyBuffer();
    rawData.position(0);
    rawData.order(ByteOrder.LITTLE_ENDIAN);
    savePrevious = false;
    paramByteBuffer = frames.iterator();
    while (paramByteBuffer.hasNext()) {
      if (nextdispose == 3) {
        savePrevious = true;
      }
    }
    sampleSize = paramInt;
    mainPixels = byteArrayPool.getBuf(width * height);
    mainScratch = intArrayPool.getBuf(width / paramInt * (height / paramInt));
    downsampledWidth = (width / paramInt);
    downsampledHeight = (height / paramInt);
    byteSize = (rawData.limit() + mainPixels.length + mainScratch.length * 4);
  }
  
  private Bitmap setPixels(GifFrame paramGifFrame1, GifFrame paramGifFrame2)
  {
    int[] arrayOfInt = mainScratch;
    if ((paramGifFrame2 != null) && (dispose > 0))
    {
      if (dispose != 2) {
        break label259;
      }
      j = 0;
      if (!transparency)
      {
        i = header.bgColor;
        Arrays.fill(arrayOfInt, i);
      }
    }
    else
    {
      label49:
      workBufferSize = 0;
      workBufferPosition = 0;
      if (paramGifFrame1 != null) {
        rawData.position(bufferFrameStart);
      }
      if (paramGifFrame1 != null) {
        break label301;
      }
    }
    int i13;
    int i14;
    int i10;
    label259:
    label301:
    for (int i9 = header.width * header.height;; i9 = iw * ih)
    {
      if ((mainPixels == null) || (mainPixels.length < i9))
      {
        paramGifFrame2 = mainPixels;
        mainPixels = byteArrayPool.getBuf(i9);
        byteArrayPool.returnBuf(paramGifFrame2);
      }
      if (prefix == null) {
        prefix = new short['က'];
      }
      if (suffix == null) {
        suffix = new byte['က'];
      }
      if (pixelStack == null) {
        pixelStack = new byte['ခ'];
      }
      i13 = readByte();
      i14 = 1 << i13;
      i10 = -1;
      j = i13 + 1;
      i = 0;
      while (i < i14)
      {
        prefix[i] = 0;
        suffix[i] = ((byte)i);
        i += 1;
      }
      i = j;
      if (framePointer != 0) {
        break;
      }
      isFirstFrameTransparent = true;
      i = j;
      break;
      if ((dispose != 3) || (previousImage == null)) {
        break label49;
      }
      previousImage.getPixels(arrayOfInt, 0, downsampledWidth, 0, 0, downsampledWidth, downsampledHeight);
      break label49;
    }
    int i5 = 0;
    int i8 = 0;
    int i3 = 0;
    int n = 0;
    int i4 = 0;
    int m = j;
    int i2 = (1 << j) - 1;
    int i1 = i14 + 2;
    int j = 0;
    int k = 0;
    int i = 0;
    for (;;)
    {
      if (i8 < i9)
      {
        i6 = j;
        j = k;
        if (k != 0) {
          break label415;
        }
        j = readBlock();
        if (j <= 0) {
          status = 3;
        }
      }
      else
      {
        while (i < i9)
        {
          mainPixels[i] = 0;
          i += 1;
        }
      }
      int i6 = 0;
      label415:
      int i12 = block[i6];
      int i7 = i6 + 1;
      i6 = j - 1;
      k = m;
      int i11 = i2;
      m = n;
      i2 = i5 + ((i12 & 0xFF) << i4);
      j = i1;
      i5 = i4 + 8;
      n = i10;
      i1 = i;
      i = i11;
      for (;;)
      {
        if (i5 < k) {
          break label1856;
        }
        i4 = i2 & i;
        i2 >>= k;
        i5 -= k;
        if (i4 == i14)
        {
          k = i13 + 1;
          i = (1 << k) - 1;
          j = i14 + 2;
          n = -1;
        }
        else
        {
          if (i4 > j)
          {
            status = 3;
            i11 = m;
            i4 = i5;
            m = k;
            i12 = j;
            j = i7;
            i5 = i2;
            i2 = i;
            k = i6;
            i = i1;
            i10 = n;
            n = i11;
            i1 = i12;
            break;
          }
          if (i4 == i14 + 1) {
            break label1807;
          }
          if (n != -1) {
            break label649;
          }
          pixelStack[i3] = suffix[i4];
          i3 += 1;
          m = i4;
          n = i4;
        }
      }
      label649:
      if (i4 >= j)
      {
        pixelStack[i3] = ((byte)m);
        i3 += 1;
        m = n;
      }
      for (;;)
      {
        if (m >= i14)
        {
          pixelStack[i3] = suffix[m];
          m = prefix[m];
          i3 += 1;
        }
        else
        {
          i12 = suffix[m] & 0xFF;
          pixelStack[i3] = ((byte)i12);
          i11 = k;
          i10 = i;
          m = j;
          if (j < 4096)
          {
            prefix[j] = ((short)n);
            suffix[j] = ((byte)i12);
            j += 1;
            i11 = k;
            i10 = i;
            m = j;
            if ((j & i) == 0)
            {
              i11 = k;
              i10 = i;
              m = j;
              if (j < 4096)
              {
                i11 = k + 1;
                i10 = i + j;
                m = j;
              }
            }
          }
          i = i8;
          j = i3 + 1;
          while (j > 0)
          {
            paramGifFrame2 = mainPixels;
            byte[] arrayOfByte = pixelStack;
            j -= 1;
            paramGifFrame2[i1] = arrayOfByte[j];
            i += 1;
            i1 += 1;
            continue;
            int i15 = ih / sampleSize;
            int i16 = iy / sampleSize;
            int i17 = iw / sampleSize;
            int i18 = ix / sampleSize;
            n = 1;
            m = 8;
            i1 = 0;
            if (framePointer == 0)
            {
              i3 = 1;
              k = 0;
            }
            for (;;)
            {
              if (k >= i15) {
                break label1682;
              }
              i = k;
              i6 = i1;
              i5 = m;
              i4 = n;
              if (interlace)
              {
                i = i1;
                j = m;
                i2 = n;
                if (i1 >= i15)
                {
                  i2 = n + 1;
                  switch (i2)
                  {
                  default: 
                    j = m;
                    i = i1;
                  }
                }
              }
              int i19;
              int i20;
              int i21;
              for (;;)
              {
                m = i;
                i6 = i + j;
                i4 = i2;
                i = m;
                i5 = j;
                i += i16;
                if (i >= downsampledHeight) {
                  break label1661;
                }
                j = i * downsampledWidth;
                i8 = j + i18;
                i = i8 + i17;
                i7 = i;
                if (downsampledWidth + j < i) {
                  i7 = j + downsampledWidth;
                }
                i = sampleSize * k * iw;
                i19 = i + (i7 - i8) * sampleSize;
                if (i8 >= i7) {
                  break label1661;
                }
                i20 = iw;
                i2 = 0;
                i1 = 0;
                n = 0;
                m = 0;
                j = 0;
                i9 = i;
                while ((i9 < sampleSize + i) && (i9 < mainPixels.length) && (i9 < i19))
                {
                  i10 = mainPixels[i9];
                  i21 = act[(i10 & 0xFF)];
                  i14 = j;
                  i13 = m;
                  i12 = n;
                  i11 = i1;
                  i10 = i2;
                  if (i21 != 0)
                  {
                    i10 = i2 + (i21 >> 24 & 0xFF);
                    i11 = i1 + (i21 >> 16 & 0xFF);
                    i12 = n + (i21 >> 8 & 0xFF);
                    i13 = m + (i21 & 0xFF);
                    i14 = j + 1;
                  }
                  i9 += 1;
                  j = i14;
                  m = i13;
                  n = i12;
                  i1 = i11;
                  i2 = i10;
                }
                i3 = 0;
                break;
                i = 4;
                j = m;
                continue;
                i = 2;
                j = 4;
                continue;
                i = 1;
                j = 2;
              }
              i10 = i + i20;
              i9 = i2;
              i2 = i1;
              i1 = n;
              n = m;
              m = j;
              j = i10;
              while ((j < i + i20 + sampleSize) && (j < mainPixels.length) && (j < i19))
              {
                i10 = mainPixels[j];
                i21 = act[(i10 & 0xFF)];
                i14 = m;
                i13 = n;
                i12 = i1;
                i11 = i2;
                i10 = i9;
                if (i21 != 0)
                {
                  i10 = i9 + (i21 >> 24 & 0xFF);
                  i11 = i2 + (i21 >> 16 & 0xFF);
                  i12 = i1 + (i21 >> 8 & 0xFF);
                  i13 = n + (i21 & 0xFF);
                  i14 = m + 1;
                }
                j += 1;
                m = i14;
                n = i13;
                i1 = i12;
                i2 = i11;
                i9 = i10;
              }
              if (m == 0)
              {
                j = 0;
                label1576:
                if (j == 0) {
                  break label1641;
                }
                arrayOfInt[i8] = j;
              }
              for (;;)
              {
                i += sampleSize;
                i8 += 1;
                break;
                j = i9 / m << 24 | i2 / m << 16 | i1 / m << 8 | n / m;
                break label1576;
                label1641:
                if ((!isFirstFrameTransparent) && (i3 != 0)) {
                  isFirstFrameTransparent = true;
                }
              }
              label1661:
              k += 1;
              i1 = i6;
              m = i5;
              n = i4;
            }
            label1682:
            if ((savePrevious) && ((dispose == 0) || (dispose == 1)))
            {
              if (previousImage == null) {
                previousImage = getNextBitmap();
              }
              previousImage.setPixels(arrayOfInt, 0, downsampledWidth, 0, 0, downsampledWidth, downsampledHeight);
            }
            paramGifFrame1 = getNextBitmap();
            paramGifFrame1.setPixels(arrayOfInt, 0, downsampledWidth, 0, 0, downsampledWidth, downsampledHeight);
            return paramGifFrame1;
          }
          n = i4;
          i3 = j;
          i8 = i;
          k = i11;
          i = i10;
          j = m;
          m = i12;
          break;
          m = i4;
        }
      }
      label1807:
      i11 = m;
      i4 = i5;
      m = k;
      i12 = j;
      j = i7;
      i5 = i2;
      i2 = i;
      k = i6;
      i = i1;
      i10 = n;
      n = i11;
      i1 = i12;
      continue;
      label1856:
      i11 = m;
      i12 = i;
      i = i6;
      m = k;
      i6 = j;
      i4 = i5;
      j = i7;
      k = i;
      i = i1;
      i5 = i2;
      i10 = n;
      n = i11;
      i2 = i12;
      i1 = i6;
    }
  }
  
  final void advance()
  {
    if (shouldLoop)
    {
      framePointer = ((framePointer + 1) % header.frameCount);
      return;
    }
    framePointer = Math.max(framePointer + 1, header.frameCount - 1);
  }
  
  final Bitmap getNextFrame()
  {
    Object localObject4 = null;
    for (;;)
    {
      GifFrame localGifFrame;
      int i;
      int j;
      try
      {
        if ((header.frameCount <= 0) || (framePointer < 0))
        {
          if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "unable to decode frame, frameCount=" + header.frameCount + " framePointer=" + framePointer);
          }
          status = 1;
        }
        Object localObject1;
        if ((status == 1) || (status == 2))
        {
          localObject1 = localObject4;
          if (Log.isLoggable(TAG, 3))
          {
            Log.d(TAG, "Unable to decode frame, status=" + status);
            localObject1 = localObject4;
          }
          return (Bitmap)localObject1;
        }
        status = 0;
        localGifFrame = (GifFrame)header.frames.get(framePointer);
        i = framePointer - 1;
        if (i >= 0)
        {
          localObject1 = (GifFrame)header.frames.get(i);
          j = header.bgColor;
          if (lct != null) {
            break label327;
          }
          act = header.gct;
          i = 0;
          if (transparency)
          {
            i = act[transIndex];
            act[transIndex] = 0;
          }
          if (act != null) {
            break label362;
          }
          if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "No Valid Color Table");
          }
          status = 1;
          localObject1 = localObject4;
          continue;
        }
        localObject3 = (GifFrame)header.frames.get(header.frameCount - 1);
      }
      finally {}
      Object localObject3;
      continue;
      label327:
      act = lct;
      if (header.bgIndex == transIndex)
      {
        header.bgColor = 0;
        continue;
        label362:
        localObject3 = setPixels(localGifFrame, (GifFrame)localObject3);
        if (transparency) {
          act[transIndex] = i;
        }
        header.bgColor = j;
      }
    }
  }
  
  final byte[] read(InputStream paramInputStream)
    throws IOException
  {
    PoolingByteArrayOutputStream localPoolingByteArrayOutputStream;
    byte[] arrayOfByte;
    try
    {
      localPoolingByteArrayOutputStream = new PoolingByteArrayOutputStream(byteArrayPool);
      localObject = null;
      try
      {
        arrayOfByte = byteArrayPool.getBuf(16384);
        for (;;)
        {
          localObject = arrayOfByte;
          int i = paramInputStream.read(arrayOfByte, 0, 16384);
          if (i == -1) {
            break;
          }
          localObject = arrayOfByte;
          localPoolingByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        paramInputStream = finally;
      }
      finally
      {
        localPoolingByteArrayOutputStream.close();
        byteArrayPool.returnBuf((byte[])localObject);
      }
      localObject = arrayOfByte;
    }
    finally {}
    localPoolingByteArrayOutputStream.flush();
    Object localObject = arrayOfByte;
    paramInputStream = localPoolingByteArrayOutputStream.toByteArray();
    localPoolingByteArrayOutputStream.close();
    byteArrayPool.returnBuf(arrayOfByte);
    return paramInputStream;
  }
  
  final GifHeader readHeader(byte[] paramArrayOfByte)
  {
    GifHeaderParser localGifHeaderParser;
    for (;;)
    {
      try
      {
        if (parser == null) {
          parser = new GifHeaderParser((byte)0);
        }
        localGifHeaderParser = parser;
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
          rawData = null;
          Arrays.fill(block, (byte)0);
          header = new GifHeader();
          blockSize = 0;
          rawData = paramArrayOfByte.asReadOnlyBuffer();
          rawData.position(0);
          rawData.order(ByteOrder.LITTLE_ENDIAN);
          if (rawData != null) {
            break;
          }
          throw new IllegalStateException("You must call setData() before parseHeader()");
        }
      }
      finally {}
      rawData = null;
      header.status = 2;
    }
    if (!localGifHeaderParser.err())
    {
      localGifHeaderParser.readHeader();
      if (!localGifHeaderParser.err())
      {
        localGifHeaderParser.readContents$13462e();
        if (header.frameCount < 0) {
          header.status = 1;
        }
      }
    }
    paramArrayOfByte = header;
    return paramArrayOfByte;
  }
  
  final int setImageData(byte[] paramArrayOfByte, GifHeader paramGifHeader, int paramInt)
  {
    try
    {
      header = paramGifHeader;
      if (paramArrayOfByte != null) {
        setData(paramGifHeader, ByteBuffer.wrap(paramArrayOfByte), paramInt);
      }
      paramInt = status;
      return paramInt;
    }
    finally {}
  }
  
  private static final class GifFrame
  {
    int bufferFrameStart;
    int delay;
    int dispose;
    int ih;
    boolean interlace;
    int iw;
    int ix;
    int iy;
    int[] lct;
    int transIndex;
    boolean transparency;
  }
  
  static final class GifHeader
  {
    int bgColor;
    int bgIndex;
    GifDecoder.GifFrame currentFrame;
    int frameCount = 0;
    List<GifDecoder.GifFrame> frames = new ArrayList();
    int[] gct = null;
    boolean gctFlag;
    int gctSize;
    int height;
    int loopCount;
    int pixelAspect;
    int status = 0;
    int width;
  }
  
  private static final class GifHeaderParser
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.GifDecoder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */