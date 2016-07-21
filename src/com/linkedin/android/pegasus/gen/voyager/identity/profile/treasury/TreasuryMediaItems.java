package com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class TreasuryMediaItems
  implements FissileDataModel<TreasuryMediaItems>, RecordTemplate<TreasuryMediaItems>
{
  public static final TreasuryMediaItemsBuilder BUILDER = TreasuryMediaItemsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasMediaList;
  public final boolean hasPagingInfo;
  public final boolean hasSectionType;
  public final boolean hasSectionUrn;
  public final List<TreasuryMedia> mediaList;
  public final CollectionMetadata pagingInfo;
  public final TreasurySectionType sectionType;
  public final Urn sectionUrn;
  
  TreasuryMediaItems(Urn paramUrn, TreasurySectionType paramTreasurySectionType, List<TreasuryMedia> paramList, CollectionMetadata paramCollectionMetadata, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    sectionUrn = paramUrn;
    sectionType = paramTreasurySectionType;
    if (paramList == null) {}
    for (paramUrn = null;; paramUrn = Collections.unmodifiableList(paramList))
    {
      mediaList = paramUrn;
      pagingInfo = paramCollectionMetadata;
      hasSectionUrn = paramBoolean1;
      hasSectionType = paramBoolean2;
      hasMediaList = paramBoolean3;
      hasPagingInfo = paramBoolean4;
      _cachedId = null;
      return;
    }
  }
  
  private TreasuryMediaItems accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasSectionUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("sectionUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(sectionUrn));
    }
    if (hasSectionType)
    {
      paramDataProcessor.startRecordField$505cff1c("sectionType");
      paramDataProcessor.processEnum(sectionType);
    }
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    if (hasMediaList)
    {
      paramDataProcessor.startRecordField$505cff1c("mediaList");
      mediaList.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = mediaList.iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (TreasuryMedia)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((TreasuryMedia)localObject2).accept(paramDataProcessor);; localObject2 = (TreasuryMedia)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null)
      {
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      bool2 = false;
      if (hasPagingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("pagingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label341;
        }
        localObject1 = pagingInfo.accept(paramDataProcessor);
        label280:
        if (localObject1 == null) {
          break label359;
        }
      }
    }
    label341:
    label359:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label484;
      }
      try
      {
        if (hasSectionUrn) {
          break label365;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMediaItems", "sectionUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      localObject2 = localObject1;
      break;
      localObject1 = (CollectionMetadata)paramDataProcessor.processDataTemplate(pagingInfo);
      break label280;
    }
    label365:
    if (!hasSectionType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMediaItems", "sectionType");
    }
    if (!hasMediaList) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMediaItems", "mediaList");
    }
    if (mediaList != null)
    {
      paramDataProcessor = mediaList.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((TreasuryMedia)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMediaItems", "mediaList");
        }
      }
    }
    return new TreasuryMediaItems(sectionUrn, sectionType, (List)localObject2, (CollectionMetadata)localObject1, hasSectionUrn, hasSectionType, bool1, bool2);
    label484:
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
      paramObject = (TreasuryMediaItems)paramObject;
      if (sectionUrn != null)
      {
        if (sectionUrn.equals(sectionUrn)) {}
      }
      else {
        while (sectionUrn != null) {
          return false;
        }
      }
      if (sectionType != null)
      {
        if (sectionType.equals(sectionType)) {}
      }
      else {
        while (sectionType != null) {
          return false;
        }
      }
      if (mediaList != null)
      {
        if (mediaList.equals(mediaList)) {}
      }
      else {
        while (mediaList != null) {
          return false;
        }
      }
      if (pagingInfo == null) {
        break;
      }
    } while (pagingInfo.equals(pagingInfo));
    for (;;)
    {
      return false;
      if (pagingInfo == null) {
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
    Object localObject;
    if (hasSectionUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(sectionUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasSectionType) {
      i = j + 2;
    }
    i += 1;
    j = i;
    if (hasMediaList)
    {
      i += 2;
      localObject = mediaList.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        TreasuryMedia localTreasuryMedia = (TreasuryMedia)((Iterator)localObject).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localTreasuryMedia.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasPagingInfo)
    {
      i = j + 1;
      if (pagingInfo._cachedId == null) {
        break label199;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(pagingInfo._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label199:
      i += pagingInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (sectionUrn != null)
    {
      i = sectionUrn.hashCode();
      if (sectionType == null) {
        break label112;
      }
      j = sectionType.hashCode();
      label45:
      if (mediaList == null) {
        break label117;
      }
    }
    label112:
    label117:
    for (int k = mediaList.hashCode();; k = 0)
    {
      if (pagingInfo != null) {
        m = pagingInfo.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building TreasuryMediaItems");
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
    label173:
    label290:
    label323:
    label330:
    label458:
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
        localByteBuffer.putInt(-815790565);
        Object localObject;
        if (hasSectionUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(sectionUrn));
          if (!hasSectionType) {
            break label290;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, sectionType.ordinal());
          if (!hasMediaList) {
            break label323;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, mediaList.size());
          localObject = mediaList.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label330;
          }
          TreasuryMedia localTreasuryMedia = (TreasuryMedia)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localTreasuryMedia.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label173;
          }
          localByteBuffer.put((byte)1);
          localTreasuryMedia.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasPagingInfo)
        {
          localByteBuffer.put((byte)1);
          if (pagingInfo._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, pagingInfo._cachedId);
            pagingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label458;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          pagingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMediaItems
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */