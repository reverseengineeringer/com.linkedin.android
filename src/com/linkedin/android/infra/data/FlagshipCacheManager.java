package com.linkedin.android.infra.data;

import com.linkedin.android.fission.interfaces.FissileModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.infra.data.buffer.ByteBufferPool;
import com.linkedin.android.infra.data.buffer.CharArrayBufferPool;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection;
import com.linkedin.android.relationships.connections.ConnectionStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Inject;

public class FlagshipCacheManager
  implements FissionAdapter
{
  private static final String TAG = FlagshipCacheManager.class.getSimpleName();
  private final ByteBufferPool byteBufferPool;
  public final Cache<String, ByteBuffer> cache;
  private final CharArrayBufferPool charArrayBufferPool;
  private final ConnectionStore connectionStore;
  private final ExecutorService fissionExecutor = Executors.newSingleThreadExecutor();
  
  @Inject
  public FlagshipCacheManager(Cache<String, ByteBuffer> paramCache, ByteBufferPool paramByteBufferPool, ConnectionStore paramConnectionStore)
  {
    cache = paramCache;
    byteBufferPool = paramByteBufferPool;
    charArrayBufferPool = new CharArrayBufferPool();
    connectionStore = paramConnectionStore;
  }
  
  public final void clear()
  {
    if (cache.isClosed()) {
      return;
    }
    try
    {
      cache.clear();
      connectionStore.clear();
      return;
    }
    catch (CacheException localCacheException)
    {
      for (;;) {}
    }
  }
  
  public final FissionTransaction createTransaction(boolean paramBoolean)
    throws IOException
  {
    try
    {
      FissionTransaction localFissionTransaction = cache.createTransaction(paramBoolean);
      return localFissionTransaction;
    }
    catch (CacheException localCacheException) {}
    return null;
  }
  
  public final ByteBuffer getBuffer(int paramInt)
  {
    return (ByteBuffer)byteBufferPool.getBuf(paramInt);
  }
  
  public final ByteBuffer readFromCache(String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if (cache.isClosed()) {
      throw new IOException("Cache already closed.");
    }
    try
    {
      paramString = (ByteBuffer)cache.get(paramString, paramFissionTransaction);
      return paramString;
    }
    catch (CacheException paramString)
    {
      throw new IOException(paramString);
    }
  }
  
  public final String readString(ByteBuffer paramByteBuffer)
    throws IOException
  {
    int k = readUnsignedShort(paramByteBuffer);
    char[] arrayOfChar = (char[])charArrayBufferPool.getBuf(k);
    int j = 0;
    int i = 0;
    while (j < k)
    {
      arrayOfChar[i] = ((char)paramByteBuffer.get());
      if (arrayOfChar[i] < '')
      {
        j += 1;
        i += 1;
      }
      else
      {
        int m;
        int n;
        if ((arrayOfChar[i] & 0xE0) == 'À')
        {
          if (j >= k) {
            throw new IOException("bad second byte at " + j);
          }
          m = arrayOfChar[i];
          n = paramByteBuffer.get();
          j += 2;
          if ((n & 0xC0) != 128) {
            throw new IOException("bad second byte at " + (j - 1));
          }
          arrayOfChar[i] = ((char)((m & 0x1F) << 6 | n & 0x3F));
          i += 1;
        }
        else if ((arrayOfChar[i] & 0xF0) == 'à')
        {
          if (j + 1 >= k) {
            throw new IOException("bad third byte at " + (j + 1));
          }
          m = arrayOfChar[i];
          n = paramByteBuffer.get();
          int i1 = paramByteBuffer.get();
          j += 3;
          if (((n & 0xC0) != 128) || ((i1 & 0xC0) != 128)) {
            throw new IOException("bad second or third byte at " + (j - 2));
          }
          arrayOfChar[i] = ((char)((m & 0xF) << 12 | (n & 0x3F) << 6 | i1 & 0x3F));
          i += 1;
        }
        else
        {
          throw new IOException("bad byte at " + (j - 1));
        }
      }
    }
    paramByteBuffer = new String(arrayOfChar, 0, i);
    charArrayBufferPool.recycle(arrayOfChar);
    return paramByteBuffer;
  }
  
  public final int readUnsignedShort(ByteBuffer paramByteBuffer)
    throws IOException
  {
    int i = paramByteBuffer.get() & 0xFF;
    int j = paramByteBuffer.get() & 0xFF;
    if ((i | j) < 0) {
      throw new IOException("Failed to read unsigned short. Encountered EOF");
    }
    return (i << 8) + j;
  }
  
  public final void recycle(ByteBuffer paramByteBuffer)
  {
    byteBufferPool.recycle(paramByteBuffer);
  }
  
  public final void willWriteModel$30d0b508(FissileModel paramFissileModel, boolean paramBoolean)
  {
    if ((paramFissileModel instanceof Connection)) {
      connectionStore.writeConnection((Connection)paramFissileModel, paramBoolean);
    }
    while ((!(paramFissileModel instanceof MiniProfile)) || (paramBoolean)) {
      return;
    }
    connectionStore.updateMiniProfile((MiniProfile)paramFissileModel);
  }
  
  public final void writeString(ByteBuffer paramByteBuffer, String paramString)
    throws IOException
  {
    writeUnsignedShort(paramByteBuffer, PegasusBinaryUtils.getEncodedLength(paramString));
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      int k = paramString.charAt(i);
      if ((k != 0) && (k <= 127)) {
        paramByteBuffer.put((byte)k);
      }
      for (;;)
      {
        i += 1;
        break;
        if (k <= 2047)
        {
          paramByteBuffer.put((byte)(k >> 6 & 0x1F | 0xC0));
          paramByteBuffer.put((byte)(k & 0x3F | 0x80));
        }
        else
        {
          paramByteBuffer.put((byte)(k >> 12 & 0xF | 0xE0));
          paramByteBuffer.put((byte)(k >> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k & 0x3F | 0x80));
        }
      }
    }
  }
  
  public final void writeToCache(String paramString, ByteBuffer paramByteBuffer, int paramInt, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if (cache.isClosed()) {
      throw new IOException("Cache already closed.");
    }
    if (paramByteBuffer == null) {}
    try
    {
      cache.remove(paramString, paramFissionTransaction);
      return;
    }
    catch (CacheException paramString)
    {
      throw new IOException(paramString);
    }
    cache.put$7ec75917(paramString, paramByteBuffer, paramInt, paramFissionTransaction);
  }
  
  public final void writeUnsignedShort(ByteBuffer paramByteBuffer, int paramInt)
    throws IOException
  {
    if (paramInt > 65536) {
      throw new IOException("Cannot serialize unsigned short values longer than 65536");
    }
    byte b1 = (byte)(paramInt >>> 8);
    byte b2 = (byte)paramInt;
    paramByteBuffer.put(b1);
    paramByteBuffer.put(b2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.data.FlagshipCacheManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */