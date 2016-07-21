package com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.HighlightsMiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ViewerSharedEntityInfo
  implements FissileDataModel<ViewerSharedEntityInfo>, RecordTemplate<ViewerSharedEntityInfo>
{
  public static final ViewerSharedEntityInfoBuilder BUILDER = ViewerSharedEntityInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<HighlightsMiniProfile> endorsers;
  public final boolean hasEndorsers;
  public final boolean hasSharedEntity;
  public final boolean hasTotalCount;
  public final SharedEntity sharedEntity;
  public final int totalCount;
  
  ViewerSharedEntityInfo(List<HighlightsMiniProfile> paramList, int paramInt, SharedEntity paramSharedEntity, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      endorsers = paramList;
      totalCount = paramInt;
      sharedEntity = paramSharedEntity;
      hasEndorsers = paramBoolean1;
      hasTotalCount = paramBoolean2;
      hasSharedEntity = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final ViewerSharedEntityInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    if (hasEndorsers)
    {
      paramDataProcessor.startRecordField$505cff1c("endorsers");
      endorsers.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = endorsers.iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (HighlightsMiniProfile)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((HighlightsMiniProfile)localObject2).accept(paramDataProcessor);; localObject2 = (HighlightsMiniProfile)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
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
      if (hasTotalCount)
      {
        paramDataProcessor.startRecordField$505cff1c("totalCount");
        paramDataProcessor.processInt(totalCount);
      }
      localObject1 = null;
      bool2 = false;
      if (hasSharedEntity)
      {
        paramDataProcessor.startRecordField$505cff1c("sharedEntity");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label308;
        }
        localObject1 = sharedEntity.accept(paramDataProcessor);
        label247:
        if (localObject1 == null) {
          break label326;
        }
      }
    }
    label308:
    label326:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label443;
      }
      try
      {
        if (hasEndorsers) {
          break label332;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.ViewerSharedEntityInfo", "endorsers");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      localObject2 = localObject1;
      break;
      localObject1 = (SharedEntity)paramDataProcessor.processDataTemplate(sharedEntity);
      break label247;
    }
    label332:
    if (!hasTotalCount) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.ViewerSharedEntityInfo", "totalCount");
    }
    if (!hasSharedEntity) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.ViewerSharedEntityInfo", "sharedEntity");
    }
    if (endorsers != null)
    {
      paramDataProcessor = endorsers.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((HighlightsMiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.ViewerSharedEntityInfo", "endorsers");
        }
      }
    }
    return new ViewerSharedEntityInfo((List)localObject2, totalCount, (SharedEntity)localObject1, bool1, hasTotalCount, bool2);
    label443:
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
      paramObject = (ViewerSharedEntityInfo)paramObject;
      if (endorsers != null)
      {
        if (endorsers.equals(endorsers)) {}
      }
      else {
        while (endorsers != null) {
          return false;
        }
      }
      if (totalCount != totalCount) {
        return false;
      }
      if (sharedEntity == null) {
        break;
      }
    } while (sharedEntity.equals(sharedEntity));
    for (;;)
    {
      return false;
      if (sharedEntity == null) {
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
    int j = i;
    if (hasEndorsers)
    {
      i += 2;
      Iterator localIterator = endorsers.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        HighlightsMiniProfile localHighlightsMiniProfile = (HighlightsMiniProfile)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localHighlightsMiniProfile.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasTotalCount) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasSharedEntity)
    {
      i = j + 1;
      if (sharedEntity._cachedId == null) {
        break label170;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(sharedEntity._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label170:
      i += sharedEntity.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (endorsers != null) {}
    for (int i = endorsers.hashCode();; i = 0)
    {
      int k = totalCount;
      if (sharedEntity != null) {
        j = sharedEntity.hashCode();
      }
      i = ((i + 527) * 31 + k) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ViewerSharedEntityInfo");
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
    label374:
    label399:
    label407:
    label409:
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
        localByteBuffer.putInt(2041122961);
        if (hasEndorsers)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, endorsers.size());
          Iterator localIterator = endorsers.iterator();
          while (localIterator.hasNext())
          {
            HighlightsMiniProfile localHighlightsMiniProfile = (HighlightsMiniProfile)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localHighlightsMiniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localHighlightsMiniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasTotalCount)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(totalCount);
          if (!hasSharedEntity) {
            break label399;
          }
          localByteBuffer.put((byte)1);
          if (sharedEntity._cachedId == null) {
            break label374;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, sharedEntity._cachedId);
          sharedEntity.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label407;
          }
          if (str != null) {
            break label409;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          sharedEntity.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class SharedEntity
    implements FissileDataModel<SharedEntity>, UnionTemplate<SharedEntity>
  {
    public static final ViewerSharedEntityInfoBuilder.SharedEntityBuilder BUILDER = ViewerSharedEntityInfoBuilder.SharedEntityBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasMiniCompanyValue;
    public final boolean hasMiniSchoolValue;
    public final MiniCompany miniCompanyValue;
    public final MiniSchool miniSchoolValue;
    
    SharedEntity(MiniCompany paramMiniCompany, MiniSchool paramMiniSchool, boolean paramBoolean1, boolean paramBoolean2)
    {
      miniCompanyValue = paramMiniCompany;
      miniSchoolValue = paramMiniSchool;
      hasMiniCompanyValue = paramBoolean1;
      hasMiniSchoolValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final SharedEntity accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasMiniCompanyValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.shared.MiniCompany");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = miniCompanyValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label149;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        label56:
        localObject1 = null;
        bool2 = false;
        if (hasMiniSchoolValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.shared.MiniSchool");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label158;
          }
          localObject1 = miniSchoolValue.accept(paramDataProcessor);
          label95:
          if (localObject1 == null) {
            break label176;
          }
        }
      }
      label149:
      label158:
      label176:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label181;
        }
        return new SharedEntity((MiniCompany)localObject2, (MiniSchool)localObject1, bool1, bool2);
        localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompanyValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (MiniSchool)paramDataProcessor.processDataTemplate(miniSchoolValue);
        break label95;
      }
      label181:
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
        paramObject = (SharedEntity)paramObject;
        if (miniCompanyValue != null)
        {
          if (miniCompanyValue.equals(miniCompanyValue)) {}
        }
        else {
          while (miniCompanyValue != null) {
            return false;
          }
        }
        if (miniSchoolValue == null) {
          break;
        }
      } while (miniSchoolValue.equals(miniSchoolValue));
      for (;;)
      {
        return false;
        if (miniSchoolValue == null) {
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
      if (hasMiniCompanyValue)
      {
        if (miniCompanyValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(miniCompanyValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasMiniSchoolValue)
        {
          i = j + 1;
          if (miniSchoolValue._cachedId == null) {
            break label114;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniSchoolValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = miniCompanyValue.getSerializedSize() + 7;
        break;
        label114:
        i += miniSchoolValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (miniCompanyValue != null) {}
      for (int i = miniCompanyValue.hashCode();; i = 0)
      {
        if (miniSchoolValue != null) {
          j = miniSchoolValue.hashCode();
        }
        i = (i + 527) * 31 + j;
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SharedEntity");
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
      label298:
      label323:
      label331:
      label333:
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
          localByteBuffer.putInt(418351561);
          if (hasMiniCompanyValue)
          {
            localByteBuffer.put((byte)1);
            if (miniCompanyValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, miniCompanyValue._cachedId);
              miniCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasMiniSchoolValue) {
                break label323;
              }
              localByteBuffer.put((byte)1);
              if (miniSchoolValue._cachedId == null) {
                break label298;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, miniSchoolValue._cachedId);
              miniSchoolValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label331;
            }
            if (str != null) {
              break label333;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            miniCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            miniSchoolValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.ViewerSharedEntityInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */