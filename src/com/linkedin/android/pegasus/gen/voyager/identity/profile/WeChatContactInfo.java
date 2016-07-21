package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class WeChatContactInfo
  implements FissileDataModel<WeChatContactInfo>, RecordTemplate<WeChatContactInfo>
{
  public static final WeChatContactInfoBuilder BUILDER = WeChatContactInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasName;
  public final boolean hasQr;
  public final boolean hasWeChatHandle;
  public final String name;
  public final String qr;
  public final String weChatHandle;
  
  WeChatContactInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    name = paramString1;
    weChatHandle = paramString2;
    qr = paramString3;
    hasName = paramBoolean1;
    hasWeChatHandle = paramBoolean2;
    hasQr = paramBoolean3;
    _cachedId = null;
  }
  
  public final WeChatContactInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasName)
    {
      paramDataProcessor.startRecordField$505cff1c("name");
      paramDataProcessor.processString(name);
    }
    if (hasWeChatHandle)
    {
      paramDataProcessor.startRecordField$505cff1c("weChatHandle");
      paramDataProcessor.processString(weChatHandle);
    }
    if (hasQr)
    {
      paramDataProcessor.startRecordField$505cff1c("qr");
      paramDataProcessor.processString(qr);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasName) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.WeChatContactInfo", "name");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasQr) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.WeChatContactInfo", "qr");
      }
      return new WeChatContactInfo(name, weChatHandle, qr, hasName, hasWeChatHandle, hasQr);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (WeChatContactInfo)paramObject;
      if (name != null)
      {
        if (name.equals(name)) {}
      }
      else {
        while (name != null) {
          return false;
        }
      }
      if (weChatHandle != null)
      {
        if (weChatHandle.equals(weChatHandle)) {}
      }
      else {
        while (weChatHandle != null) {
          return false;
        }
      }
      if (qr == null) {
        break;
      }
    } while (qr.equals(qr));
    for (;;)
    {
      return false;
      if (qr == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasName) {
      i = PegasusBinaryUtils.getEncodedLength(name) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasWeChatHandle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(weChatHandle);
    }
    j = i + 1;
    i = j;
    if (hasQr) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(qr);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (name != null)
    {
      i = name.hashCode();
      if (weChatHandle == null) {
        break label87;
      }
    }
    label87:
    for (int j = weChatHandle.hashCode();; j = 0)
    {
      if (qr != null) {
        k = qr.hashCode();
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WeChatContactInfo");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label162:
    label231:
    label241:
    label249:
    label251:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-1182339523);
        if (hasName)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasWeChatHandle) {
            break label231;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, weChatHandle);
          if (!hasQr) {
            break label241;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, qr);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label249;
          }
          if (str != null) {
            break label251;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.WeChatContactInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */