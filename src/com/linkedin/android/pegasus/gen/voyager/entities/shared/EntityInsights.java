package com.linkedin.android.pegasus.gen.voyager.entities.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
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

public final class EntityInsights
  implements FissileDataModel<EntityInsights>, RecordTemplate<EntityInsights>
{
  public static final EntityInsightsBuilder BUILDER = EntityInsightsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Entity entity;
  public final String entityInfo;
  public final boolean hasEntity;
  public final boolean hasEntityInfo;
  public final boolean hasInsights;
  public final List<EntitiesFlavor> insights;
  
  EntityInsights(Entity paramEntity, List<EntitiesFlavor> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    entity = paramEntity;
    if (paramList == null) {}
    for (paramEntity = null;; paramEntity = Collections.unmodifiableList(paramList))
    {
      insights = paramEntity;
      entityInfo = paramString;
      hasEntity = paramBoolean1;
      hasInsights = paramBoolean2;
      hasEntityInfo = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final EntityInsights accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    int i;
    if (hasEntity)
    {
      paramDataProcessor.startRecordField$505cff1c("entity");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = entity.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localEntitiesFlavor = null;
      bool2 = false;
      if (!hasInsights) {
        break label261;
      }
      paramDataProcessor.startRecordField$505cff1c("insights");
      insights.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localEntitiesFlavor;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = insights.iterator();
      label131:
      if (!localIterator.hasNext()) {
        break label247;
      }
      localEntitiesFlavor = (EntitiesFlavor)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label231;
      }
    }
    label222:
    label231:
    for (EntitiesFlavor localEntitiesFlavor = localEntitiesFlavor.accept(paramDataProcessor);; localEntitiesFlavor = (EntitiesFlavor)paramDataProcessor.processDataTemplate(localEntitiesFlavor))
    {
      if ((localObject1 != null) && (localEntitiesFlavor != null)) {
        ((List)localObject1).add(localEntitiesFlavor);
      }
      i += 1;
      break label131;
      localObject1 = (Entity)paramDataProcessor.processDataTemplate(entity);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
    }
    label247:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label261:
      if (hasEntityInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("entityInfo");
        paramDataProcessor.processString(entityInfo);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label421;
      }
      if (!hasInsights) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasEntity) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.EntityInsights", "entity");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (insights != null)
    {
      paramDataProcessor = insights.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((EntitiesFlavor)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.shared.EntityInsights", "insights");
        }
      }
    }
    return new EntityInsights((Entity)localObject2, (List)localObject1, entityInfo, bool1, bool2, hasEntityInfo);
    label421:
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
      paramObject = (EntityInsights)paramObject;
      if (entity != null)
      {
        if (entity.equals(entity)) {}
      }
      else {
        while (entity != null) {
          return false;
        }
      }
      if (insights != null)
      {
        if (insights.equals(insights)) {}
      }
      else {
        while (insights != null) {
          return false;
        }
      }
      if (entityInfo == null) {
        break;
      }
    } while (entityInfo.equals(entityInfo));
    for (;;)
    {
      return false;
      if (entityInfo == null) {
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
    int j;
    Iterator localIterator;
    if (hasEntity)
    {
      if (entity._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(entity._cachedId) + 9;
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasInsights) {
        break label153;
      }
      i += 2;
      localIterator = insights.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label153;
      }
      EntitiesFlavor localEntitiesFlavor = (EntitiesFlavor)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = entity.getSerializedSize() + 7;
        break;
      }
      i += localEntitiesFlavor.getSerializedSize();
    }
    label153:
    j += 1;
    i = j;
    if (hasEntityInfo) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(entityInfo);
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
    if (entity != null)
    {
      i = entity.hashCode();
      if (insights == null) {
        break label89;
      }
    }
    label89:
    for (int j = insights.hashCode();; j = 0)
    {
      if (entityInfo != null) {
        k = entityInfo.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EntityInsights");
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
    label335:
    label342:
    label411:
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
        localByteBuffer.putInt(-900565388);
        Iterator localIterator;
        if (hasEntity)
        {
          localByteBuffer.put((byte)1);
          if (entity._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, entity._cachedId);
            entity.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasInsights) {
              break label335;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, insights.size());
            localIterator = insights.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label342;
          }
          EntitiesFlavor localEntitiesFlavor = (EntitiesFlavor)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localEntitiesFlavor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            entity.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
          }
          localByteBuffer.put((byte)1);
          localEntitiesFlavor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasEntityInfo)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, entityInfo);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label411;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
  
  public static final class Entity
    implements FissileDataModel<Entity>, UnionTemplate<Entity>
  {
    public static final EntityInsightsBuilder.EntityBuilder BUILDER = EntityInsightsBuilder.EntityBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasMiniCompanyValue;
    public final MiniCompany miniCompanyValue;
    
    Entity(MiniCompany paramMiniCompany, boolean paramBoolean)
    {
      miniCompanyValue = paramMiniCompany;
      hasMiniCompanyValue = paramBoolean;
      _cachedId = null;
    }
    
    public final Entity accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      MiniCompany localMiniCompany = null;
      boolean bool = false;
      if (hasMiniCompanyValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.shared.MiniCompany");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label74;
        }
        localMiniCompany = miniCompanyValue.accept(paramDataProcessor);
        if (localMiniCompany == null) {
          break label91;
        }
      }
      label74:
      label91:
      for (bool = true;; bool = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label96;
        }
        return new Entity(localMiniCompany, bool);
        localMiniCompany = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompanyValue);
        break;
      }
      label96:
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
        paramObject = (Entity)paramObject;
        if (miniCompanyValue == null) {
          break;
        }
      } while (miniCompanyValue.equals(miniCompanyValue));
      for (;;)
      {
        return false;
        if (miniCompanyValue == null) {
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
      if (hasMiniCompanyValue) {
        if (miniCompanyValue._cachedId == null) {
          break label58;
        }
      }
      label58:
      for (i = PegasusBinaryUtils.getEncodedLength(miniCompanyValue._cachedId) + 9;; i = miniCompanyValue.getSerializedSize() + 7)
      {
        __sizeOfObject = i;
        return i;
      }
    }
    
    public final int hashCode()
    {
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (miniCompanyValue != null) {}
      for (int i = miniCompanyValue.hashCode();; i = 0)
      {
        i += 527;
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Entity");
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
      label238:
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
          localByteBuffer.putInt(-1245610594);
          if (hasMiniCompanyValue)
          {
            localByteBuffer.put((byte)1);
            if (miniCompanyValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, miniCompanyValue._cachedId);
              miniCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          while (paramByteBuffer == null)
          {
            if (str != null) {
              break label238;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            miniCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.EntityInsights
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */