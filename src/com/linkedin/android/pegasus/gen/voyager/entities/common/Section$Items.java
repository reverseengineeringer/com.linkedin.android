package com.linkedin.android.pegasus.gen.voyager.entities.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItem;
import com.linkedin.android.pegasus.gen.voyager.entities.company.ShowcaseItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.group.GroupItem;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobItem;
import com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItem;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Section$Items
  implements FissileDataModel<Items>, UnionTemplate<Items>
{
  public static final SectionBuilder.ItemsBuilder BUILDER = SectionBuilder.ItemsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final CompanyItem companyItemValue;
  public final GroupItem groupItemValue;
  public final boolean hasCompanyItemValue;
  public final boolean hasGroupItemValue;
  public final boolean hasJobItemValue;
  public final boolean hasSchoolItemValue;
  public final boolean hasShowcaseItemTypeValue;
  public final JobItem jobItemValue;
  public final SchoolItem schoolItemValue;
  public final ShowcaseItemType showcaseItemTypeValue;
  
  Section$Items(CompanyItem paramCompanyItem, ShowcaseItemType paramShowcaseItemType, SchoolItem paramSchoolItem, JobItem paramJobItem, GroupItem paramGroupItem, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    companyItemValue = paramCompanyItem;
    showcaseItemTypeValue = paramShowcaseItemType;
    schoolItemValue = paramSchoolItem;
    jobItemValue = paramJobItem;
    groupItemValue = paramGroupItem;
    hasCompanyItemValue = paramBoolean1;
    hasShowcaseItemTypeValue = paramBoolean2;
    hasSchoolItemValue = paramBoolean3;
    hasJobItemValue = paramBoolean4;
    hasGroupItemValue = paramBoolean5;
    _cachedId = null;
  }
  
  public final Items accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label120:
    label131:
    Object localObject4;
    boolean bool3;
    if (hasCompanyItemValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.CompanyItem");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = companyItemValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label294;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasShowcaseItemTypeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.ShowcaseItemType");
        paramDataProcessor.processEnum(showcaseItemTypeValue);
      }
      localObject3 = null;
      bool2 = false;
      if (hasSchoolItemValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.school.SchoolItem");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label303;
        }
        localObject1 = schoolItemValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label321;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasJobItemValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.JobItem");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label330;
        }
        localObject1 = jobItemValue.accept(paramDataProcessor);
        label171:
        if (localObject1 == null) {
          break label348;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label183:
      localObject1 = null;
      bool4 = false;
      if (hasGroupItemValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.group.GroupItem");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label358;
        }
        localObject1 = groupItemValue.accept(paramDataProcessor);
        label223:
        if (localObject1 == null) {
          break label376;
        }
      }
    }
    label294:
    label303:
    label321:
    label330:
    label348:
    label358:
    label376:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label382;
      }
      return new Items((CompanyItem)localObject2, showcaseItemTypeValue, (SchoolItem)localObject3, (JobItem)localObject4, (GroupItem)localObject1, bool1, hasShowcaseItemTypeValue, bool2, bool3, bool4);
      localObject1 = (CompanyItem)paramDataProcessor.processDataTemplate(companyItemValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (SchoolItem)paramDataProcessor.processDataTemplate(schoolItemValue);
      break label120;
      bool2 = false;
      localObject3 = localObject1;
      break label131;
      localObject1 = (JobItem)paramDataProcessor.processDataTemplate(jobItemValue);
      break label171;
      bool3 = false;
      localObject4 = localObject1;
      break label183;
      localObject1 = (GroupItem)paramDataProcessor.processDataTemplate(groupItemValue);
      break label223;
    }
    label382:
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
      paramObject = (Items)paramObject;
      if (companyItemValue != null)
      {
        if (companyItemValue.equals(companyItemValue)) {}
      }
      else {
        while (companyItemValue != null) {
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
      if (schoolItemValue != null)
      {
        if (schoolItemValue.equals(schoolItemValue)) {}
      }
      else {
        while (schoolItemValue != null) {
          return false;
        }
      }
      if (jobItemValue != null)
      {
        if (jobItemValue.equals(jobItemValue)) {}
      }
      else {
        while (jobItemValue != null) {
          return false;
        }
      }
      if (groupItemValue == null) {
        break;
      }
    } while (groupItemValue.equals(groupItemValue));
    for (;;)
    {
      return false;
      if (groupItemValue == null) {
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
    if (hasCompanyItemValue)
    {
      if (companyItemValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(companyItemValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasShowcaseItemTypeValue) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasSchoolItemValue)
      {
        i = j + 1;
        if (schoolItemValue._cachedId == null) {
          break label215;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(schoolItemValue._cachedId);
      }
      label110:
      j = i + 1;
      i = j;
      if (hasJobItemValue)
      {
        i = j + 1;
        if (jobItemValue._cachedId == null) {
          break label228;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(jobItemValue._cachedId);
      }
      label152:
      j = i + 1;
      i = j;
      if (hasGroupItemValue)
      {
        i = j + 1;
        if (groupItemValue._cachedId == null) {
          break label241;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(groupItemValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = companyItemValue.getSerializedSize() + 7;
      break;
      label215:
      i += schoolItemValue.getSerializedSize();
      break label110;
      label228:
      i += jobItemValue.getSerializedSize();
      break label152;
      label241:
      i += groupItemValue.getSerializedSize();
    }
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
    if (companyItemValue != null)
    {
      i = companyItemValue.hashCode();
      if (showcaseItemTypeValue == null) {
        break label132;
      }
      j = showcaseItemTypeValue.hashCode();
      if (schoolItemValue == null) {
        break label137;
      }
      k = schoolItemValue.hashCode();
      label60:
      if (jobItemValue == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = jobItemValue.hashCode();; m = 0)
    {
      if (groupItemValue != null) {
        n = groupItemValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Items");
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
    label199:
    label259:
    label319:
    label447:
    label457:
    label482:
    label492:
    label517:
    label527:
    label552:
    label560:
    label562:
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
        localByteBuffer.putInt(-559321510);
        if (hasCompanyItemValue)
        {
          localByteBuffer.put((byte)1);
          if (companyItemValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, companyItemValue._cachedId);
            companyItemValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasShowcaseItemTypeValue) {
              break label447;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, showcaseItemTypeValue.ordinal());
            if (!hasSchoolItemValue) {
              break label482;
            }
            localByteBuffer.put((byte)1);
            if (schoolItemValue._cachedId == null) {
              break label457;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, schoolItemValue._cachedId);
            schoolItemValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasJobItemValue) {
              break label517;
            }
            localByteBuffer.put((byte)1);
            if (jobItemValue._cachedId == null) {
              break label492;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, jobItemValue._cachedId);
            jobItemValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasGroupItemValue) {
              break label552;
            }
            localByteBuffer.put((byte)1);
            if (groupItemValue._cachedId == null) {
              break label527;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, groupItemValue._cachedId);
            groupItemValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label560;
          }
          if (str != null) {
            break label562;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          companyItemValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label199;
          localByteBuffer.put((byte)1);
          schoolItemValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label259;
          localByteBuffer.put((byte)0);
          break label259;
          localByteBuffer.put((byte)1);
          jobItemValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label319;
          localByteBuffer.put((byte)0);
          break label319;
          localByteBuffer.put((byte)1);
          groupItemValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.common.Section.Items
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */