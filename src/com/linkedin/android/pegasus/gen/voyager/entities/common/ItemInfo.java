package com.linkedin.android.pegasus.gen.voyager.entities.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.company.ShowcaseItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.group.GroupItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItemType;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ItemInfo
  implements FissileDataModel<ItemInfo>, RecordTemplate<ItemInfo>
{
  public static final ItemInfoBuilder BUILDER = ItemInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasItemType;
  public final boolean hasRank;
  public final boolean hasTrackingId;
  public final ItemType itemType;
  public final int rank;
  public final String trackingId;
  
  ItemInfo(ItemType paramItemType, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    itemType = paramItemType;
    rank = paramInt;
    trackingId = paramString;
    hasItemType = paramBoolean1;
    hasRank = paramBoolean2;
    hasTrackingId = paramBoolean3;
    _cachedId = null;
  }
  
  public final ItemInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    ItemType localItemType = null;
    boolean bool = false;
    if (hasItemType)
    {
      paramDataProcessor.startRecordField$505cff1c("itemType");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label143;
      }
      localItemType = itemType.accept(paramDataProcessor);
      if (localItemType == null) {
        break label160;
      }
    }
    label143:
    label160:
    for (bool = true;; bool = false)
    {
      if (hasRank)
      {
        paramDataProcessor.startRecordField$505cff1c("rank");
        paramDataProcessor.processInt(rank);
      }
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        paramDataProcessor.processString(trackingId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label210;
      }
      try
      {
        if (hasItemType) {
          break label165;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo", "itemType");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localItemType = (ItemType)paramDataProcessor.processDataTemplate(itemType);
      break;
    }
    label165:
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo", "trackingId");
    }
    return new ItemInfo(localItemType, rank, trackingId, bool, hasRank, hasTrackingId);
    label210:
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
      paramObject = (ItemInfo)paramObject;
      if (itemType != null)
      {
        if (itemType.equals(itemType)) {}
      }
      else {
        while (itemType != null) {
          return false;
        }
      }
    } while (rank == rank);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasItemType) {
      if (itemType._cachedId == null) {
        break label100;
      }
    }
    label100:
    for (i = PegasusBinaryUtils.getEncodedLength(itemType._cachedId) + 9;; i = itemType.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasRank) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasTrackingId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingId);
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (itemType != null) {}
    for (int i = itemType.hashCode();; i = 0)
    {
      i = (i + 527) * 31 + rank;
      _cachedHashCode = i;
      return i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ItemInfo");
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
    label194:
    label288:
    label298:
    label306:
    label308:
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
        localByteBuffer.putInt(-872974866);
        if (hasItemType)
        {
          localByteBuffer.put((byte)1);
          if (itemType._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, itemType._cachedId);
            itemType.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasRank) {
              break label288;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(rank);
            if (!hasTrackingId) {
              break label298;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, trackingId);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label306;
          }
          if (str != null) {
            break label308;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          itemType.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label194;
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
  
  public static final class ItemType
    implements FissileDataModel<ItemType>, UnionTemplate<ItemType>
  {
    public static final ItemInfoBuilder.ItemTypeBuilder BUILDER = ItemInfoBuilder.ItemTypeBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final CompanyItemType companyItemTypeValue;
    public final GroupItemType groupItemTypeValue;
    public final boolean hasCompanyItemTypeValue;
    public final boolean hasGroupItemTypeValue;
    public final boolean hasJobItemTypeValue;
    public final boolean hasSchoolItemTypeValue;
    public final boolean hasShowcaseItemTypeValue;
    public final JobItemType jobItemTypeValue;
    public final SchoolItemType schoolItemTypeValue;
    public final ShowcaseItemType showcaseItemTypeValue;
    
    ItemType(CompanyItemType paramCompanyItemType, ShowcaseItemType paramShowcaseItemType, SchoolItemType paramSchoolItemType, GroupItemType paramGroupItemType, JobItemType paramJobItemType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
    {
      companyItemTypeValue = paramCompanyItemType;
      showcaseItemTypeValue = paramShowcaseItemType;
      schoolItemTypeValue = paramSchoolItemType;
      groupItemTypeValue = paramGroupItemType;
      jobItemTypeValue = paramJobItemType;
      hasCompanyItemTypeValue = paramBoolean1;
      hasShowcaseItemTypeValue = paramBoolean2;
      hasSchoolItemTypeValue = paramBoolean3;
      hasGroupItemTypeValue = paramBoolean4;
      hasJobItemTypeValue = paramBoolean5;
      _cachedId = null;
    }
    
    public final ItemType accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      if (hasCompanyItemTypeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.CompanyItemType");
        paramDataProcessor.processEnum(companyItemTypeValue);
      }
      if (hasShowcaseItemTypeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.ShowcaseItemType");
        paramDataProcessor.processEnum(showcaseItemTypeValue);
      }
      if (hasSchoolItemTypeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.school.SchoolItemType");
        paramDataProcessor.processEnum(schoolItemTypeValue);
      }
      if (hasGroupItemTypeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.group.GroupItemType");
        paramDataProcessor.processEnum(groupItemTypeValue);
      }
      if (hasJobItemTypeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.JobItemType");
        paramDataProcessor.processEnum(jobItemTypeValue);
      }
      paramDataProcessor.endUnion();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        return new ItemType(companyItemTypeValue, showcaseItemTypeValue, schoolItemTypeValue, groupItemTypeValue, jobItemTypeValue, hasCompanyItemTypeValue, hasShowcaseItemTypeValue, hasSchoolItemTypeValue, hasGroupItemTypeValue, hasJobItemTypeValue);
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
        paramObject = (ItemType)paramObject;
        if (companyItemTypeValue != null)
        {
          if (companyItemTypeValue.equals(companyItemTypeValue)) {}
        }
        else {
          while (companyItemTypeValue != null) {
            return false;
          }
        }
        if (showcaseItemTypeValue != null)
        {
          if (showcaseItemTypeValue.equals(showcaseItemTypeValue)) {}
        }
        else {
          while (showcaseItemTypeValue != null) {
            return false;
          }
        }
        if (schoolItemTypeValue != null)
        {
          if (schoolItemTypeValue.equals(schoolItemTypeValue)) {}
        }
        else {
          while (schoolItemTypeValue != null) {
            return false;
          }
        }
        if (groupItemTypeValue != null)
        {
          if (groupItemTypeValue.equals(groupItemTypeValue)) {}
        }
        else {
          while (groupItemTypeValue != null) {
            return false;
          }
        }
        if (jobItemTypeValue == null) {
          break;
        }
      } while (jobItemTypeValue.equals(jobItemTypeValue));
      for (;;)
      {
        return false;
        if (jobItemTypeValue == null) {
          break;
        }
      }
    }
    
    public final int getSerializedSize()
    {
      if (__sizeOfObject > 0) {
        return __sizeOfObject;
      }
      int j = 0 + 1 + 4 + 1;
      int i = j;
      if (hasCompanyItemTypeValue) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasShowcaseItemTypeValue) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasSchoolItemTypeValue) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasGroupItemTypeValue) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasJobItemTypeValue) {
        i = j + 2;
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
      int k;
      if (companyItemTypeValue != null)
      {
        i = companyItemTypeValue.hashCode();
        if (showcaseItemTypeValue == null) {
          break label132;
        }
        j = showcaseItemTypeValue.hashCode();
        if (schoolItemTypeValue == null) {
          break label137;
        }
        k = schoolItemTypeValue.hashCode();
        label60:
        if (groupItemTypeValue == null) {
          break label142;
        }
      }
      label132:
      label137:
      label142:
      for (int m = groupItemTypeValue.hashCode();; m = 0)
      {
        if (jobItemTypeValue != null) {
          n = jobItemTypeValue.hashCode();
        }
        i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
        _cachedHashCode = i;
        return i;
        i = 0;
        break;
        j = 0;
        break label45;
        k = 0;
        break label60;
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ItemType");
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
      label168:
      label197:
      label226:
      label298:
      label308:
      label318:
      label328:
      label336:
      label338:
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
          localByteBuffer.putInt(-540795029);
          if (hasCompanyItemTypeValue)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, companyItemTypeValue.ordinal());
            if (!hasShowcaseItemTypeValue) {
              break label298;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, showcaseItemTypeValue.ordinal());
            if (!hasSchoolItemTypeValue) {
              break label308;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, schoolItemTypeValue.ordinal());
            if (!hasGroupItemTypeValue) {
              break label318;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, groupItemTypeValue.ordinal());
            if (!hasJobItemTypeValue) {
              break label328;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, jobItemTypeValue.ordinal());
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label336;
            }
            if (str != null) {
              break label338;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label168;
            localByteBuffer.put((byte)0);
            break label197;
            localByteBuffer.put((byte)0);
            break label226;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */