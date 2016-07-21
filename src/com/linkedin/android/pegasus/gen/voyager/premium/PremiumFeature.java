package com.linkedin.android.pegasus.gen.voyager.premium;

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

public final class PremiumFeature
  implements FissileDataModel<PremiumFeature>, RecordTemplate<PremiumFeature>
{
  public static final PremiumFeatureBuilder BUILDER = PremiumFeatureBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String desc;
  public final boolean hasDesc;
  public final boolean hasSummarized;
  public final boolean hasTitle;
  public final boolean hasType;
  public final boolean summarized;
  public final String title;
  public final PremiumFeatureType type;
  
  PremiumFeature(String paramString1, String paramString2, boolean paramBoolean1, PremiumFeatureType paramPremiumFeatureType, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    title = paramString1;
    desc = paramString2;
    summarized = paramBoolean1;
    type = paramPremiumFeatureType;
    hasTitle = paramBoolean2;
    hasDesc = paramBoolean3;
    hasSummarized = paramBoolean4;
    hasType = paramBoolean5;
    _cachedId = null;
  }
  
  public final PremiumFeature accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasDesc)
    {
      paramDataProcessor.startRecordField$505cff1c("desc");
      paramDataProcessor.processString(desc);
    }
    if (hasSummarized)
    {
      paramDataProcessor.startRecordField$505cff1c("summarized");
      paramDataProcessor.processBoolean(summarized);
    }
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processEnum(type);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasSummarized) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumFeature", "summarized");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new PremiumFeature(title, desc, summarized, type, hasTitle, hasDesc, hasSummarized, hasType);
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
      paramObject = (PremiumFeature)paramObject;
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (desc != null)
      {
        if (desc.equals(desc)) {}
      }
      else {
        while (desc != null) {
          return false;
        }
      }
      if (summarized != summarized) {
        return false;
      }
      if (type == null) {
        break;
      }
    } while (type.equals(type));
    for (;;)
    {
      return false;
      if (type == null) {
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
    if (hasTitle) {
      i = PegasusBinaryUtils.getEncodedLength(title) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasDesc) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(desc);
    }
    j = i + 1;
    i = j;
    if (hasSummarized) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasType) {
      i = j + 2;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (title != null)
    {
      i = title.hashCode();
      if (desc == null) {
        break label104;
      }
      j = desc.hashCode();
      label45:
      if (!summarized) {
        break label109;
      }
    }
    label104:
    label109:
    for (int k = 1;; k = 0)
    {
      if (type != null) {
        m = type.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PremiumFeature");
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
    label186:
    label195:
    label267:
    label277:
    label283:
    label293:
    label301:
    label303:
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
        localByteBuffer.putInt(1407406593);
        if (hasTitle)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasDesc) {
            break label267;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, desc);
          if (!hasSummarized) {
            break label283;
          }
          localByteBuffer.put((byte)1);
          if (!summarized) {
            break label277;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasType) {
            break label293;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label301;
          }
          if (str != null) {
            break label303;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          i = 0;
          break label186;
          localByteBuffer.put((byte)0);
          break label195;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PremiumFeature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */