package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Metadata
  implements FissileDataModel<Metadata>, RecordTemplate<Metadata>
{
  public static final MetadataBuilder BUILDER = MetadataBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasId;
  public final boolean hasNewRelevanceFeed;
  public final boolean hasPaginationToken;
  public final boolean hasQueryAfterTime;
  public final boolean hasSort;
  public final boolean hasType;
  public final String id;
  public final boolean newRelevanceFeed;
  public final String paginationToken;
  public final long queryAfterTime;
  public final SortOrder sort;
  public final String type;
  
  Metadata(String paramString1, String paramString2, long paramLong, String paramString3, SortOrder paramSortOrder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    id = paramString1;
    type = paramString2;
    queryAfterTime = paramLong;
    paginationToken = paramString3;
    sort = paramSortOrder;
    newRelevanceFeed = paramBoolean1;
    hasId = paramBoolean2;
    hasType = paramBoolean3;
    hasQueryAfterTime = paramBoolean4;
    hasPaginationToken = paramBoolean5;
    hasSort = paramBoolean6;
    hasNewRelevanceFeed = paramBoolean7;
    _cachedId = null;
  }
  
  public final Metadata accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasId)
    {
      paramDataProcessor.startRecordField$505cff1c("id");
      paramDataProcessor.processString(id);
    }
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processString(type);
    }
    if (hasQueryAfterTime)
    {
      paramDataProcessor.startRecordField$505cff1c("queryAfterTime");
      paramDataProcessor.processLong(queryAfterTime);
    }
    if (hasPaginationToken)
    {
      paramDataProcessor.startRecordField$505cff1c("paginationToken");
      paramDataProcessor.processString(paginationToken);
    }
    if (hasSort)
    {
      paramDataProcessor.startRecordField$505cff1c("sort");
      paramDataProcessor.processEnum(sort);
    }
    if (hasNewRelevanceFeed)
    {
      paramDataProcessor.startRecordField$505cff1c("newRelevanceFeed");
      paramDataProcessor.processBoolean(newRelevanceFeed);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new Metadata(id, type, queryAfterTime, paginationToken, sort, newRelevanceFeed, hasId, hasType, hasQueryAfterTime, hasPaginationToken, hasSort, hasNewRelevanceFeed);
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
      paramObject = (Metadata)paramObject;
      if (id != null)
      {
        if (id.equals(id)) {}
      }
      else {
        while (id != null) {
          return false;
        }
      }
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (queryAfterTime != queryAfterTime) {
        return false;
      }
      if (paginationToken != null)
      {
        if (paginationToken.equals(paginationToken)) {}
      }
      else {
        while (paginationToken != null) {
          return false;
        }
      }
      if (sort != null)
      {
        if (sort.equals(sort)) {}
      }
      else {
        while (sort != null) {
          return false;
        }
      }
    } while (newRelevanceFeed == newRelevanceFeed);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasId) {
      i = PegasusBinaryUtils.getEncodedLength(id) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasType) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(type);
    }
    j = i + 1;
    i = j;
    if (hasQueryAfterTime) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasPaginationToken) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(paginationToken);
    }
    j = i + 1;
    i = j;
    if (hasSort) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasNewRelevanceFeed) {
      i = j + 1;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int i1;
    int k;
    if (id != null)
    {
      i = id.hashCode();
      if (type == null) {
        break label147;
      }
      j = type.hashCode();
      i1 = (int)(queryAfterTime ^ queryAfterTime >>> 32);
      if (paginationToken == null) {
        break label152;
      }
      k = paginationToken.hashCode();
      label75:
      if (sort == null) {
        break label157;
      }
    }
    label147:
    label152:
    label157:
    for (int m = sort.hashCode();; m = 0)
    {
      if (newRelevanceFeed) {
        n = 1;
      }
      i = (m + (k + ((j + (i + 527) * 31) * 31 + i1) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label75;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    int i = 1;
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Metadata");
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
    label165:
    label189:
    label215:
    label244:
    label265:
    label317:
    label327:
    label337:
    label347:
    label357:
    label363:
    label371:
    label373:
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
        localByteBuffer.putInt(-653134427);
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, id);
          if (!hasType) {
            break label317;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, type);
          if (!hasQueryAfterTime) {
            break label327;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(queryAfterTime);
          if (!hasPaginationToken) {
            break label337;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, paginationToken);
          if (!hasSort) {
            break label347;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, sort.ordinal());
          if (!hasNewRelevanceFeed) {
            break label363;
          }
          localByteBuffer.put((byte)1);
          if (!newRelevanceFeed) {
            break label357;
          }
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label371;
          }
          if (str != null) {
            break label373;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label165;
          localByteBuffer.put((byte)0);
          break label189;
          localByteBuffer.put((byte)0);
          break label215;
          localByteBuffer.put((byte)0);
          break label244;
          i = 0;
          break label265;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<Metadata>
  {
    private boolean hasId = false;
    private boolean hasNewRelevanceFeed = false;
    private boolean hasPaginationToken = false;
    private boolean hasQueryAfterTime = false;
    private boolean hasSort = false;
    private boolean hasType = false;
    private String id = null;
    private boolean newRelevanceFeed = false;
    private String paginationToken = null;
    private long queryAfterTime = 0L;
    private SortOrder sort = null;
    private String type = null;
    
    public Builder() {}
    
    public Builder(Metadata paramMetadata)
    {
      id = id;
      type = type;
      queryAfterTime = queryAfterTime;
      paginationToken = paginationToken;
      sort = sort;
      newRelevanceFeed = newRelevanceFeed;
      hasId = hasId;
      hasType = hasType;
      hasQueryAfterTime = hasQueryAfterTime;
      hasPaginationToken = hasPaginationToken;
      hasSort = hasSort;
      hasNewRelevanceFeed = hasNewRelevanceFeed;
    }
    
    public final Metadata build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      int[] arrayOfInt = Metadata.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
      paramFlavor.ordinal();
      return new Metadata(id, type, queryAfterTime, paginationToken, sort, newRelevanceFeed, hasId, hasType, hasQueryAfterTime, hasPaginationToken, hasSort, hasNewRelevanceFeed);
    }
    
    public final Builder setSort(SortOrder paramSortOrder)
    {
      if (paramSortOrder == null)
      {
        hasSort = false;
        sort = null;
        return this;
      }
      hasSort = true;
      sort = paramSortOrder;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.Metadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */