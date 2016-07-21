package com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.Insight;
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

public final class PeopleYouMayKnow
  implements FissileDataModel<PeopleYouMayKnow>, RecordTemplate<PeopleYouMayKnow>
{
  public static final PeopleYouMayKnowBuilder BUILDER = PeopleYouMayKnowBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Entity entity;
  public final Urn entityUrn;
  public final boolean hasEntity;
  public final boolean hasEntityUrn;
  public final boolean hasInsights;
  public final boolean hasTrackingId;
  public final List<Insight> insights;
  public final String trackingId;
  
  PeopleYouMayKnow(String paramString, Urn paramUrn, Entity paramEntity, List<Insight> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    trackingId = paramString;
    entityUrn = paramUrn;
    entity = paramEntity;
    if (paramList == null) {}
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList))
    {
      insights = paramString;
      hasTrackingId = paramBoolean1;
      hasEntityUrn = paramBoolean2;
      hasEntity = paramBoolean3;
      hasInsights = paramBoolean4;
      paramString = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
    }
  }
  
  public final PeopleYouMayKnow accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      paramDataProcessor.processString(trackingId);
    }
    Object localObject1;
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label114:
    int i;
    if (hasEntity)
    {
      paramDataProcessor.startRecordField$505cff1c("entity");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = entity.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label280;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localInsight = null;
      bool2 = false;
      if (!hasInsights) {
        break label319;
      }
      paramDataProcessor.startRecordField$505cff1c("insights");
      insights.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localInsight;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = insights.iterator();
      label189:
      if (!localIterator.hasNext()) {
        break label305;
      }
      localInsight = (Insight)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label289;
      }
    }
    label280:
    label289:
    for (Insight localInsight = localInsight.accept(paramDataProcessor);; localInsight = (Insight)paramDataProcessor.processDataTemplate(localInsight))
    {
      if ((localObject1 != null) && (localInsight != null)) {
        ((List)localObject1).add(localInsight);
      }
      i += 1;
      break label189;
      localObject1 = (Entity)paramDataProcessor.processDataTemplate(entity);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label114;
    }
    label305:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label319:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label500;
      }
      if (!hasInsights) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasTrackingId) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow", "trackingId");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasEntityUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow", "entityUrn");
    }
    if (!hasEntity) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow", "entity");
    }
    if (insights != null)
    {
      paramDataProcessor = insights.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Insight)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow", "insights");
        }
      }
    }
    return new PeopleYouMayKnow(trackingId, entityUrn, (Entity)localObject2, (List)localObject1, hasTrackingId, hasEntityUrn, bool1, bool2);
    label500:
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
      paramObject = (PeopleYouMayKnow)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (entity != null)
      {
        if (entity.equals(entity)) {}
      }
      else {
        while (entity != null) {
          return false;
        }
      }
      if (insights == null) {
        break;
      }
    } while (insights.equals(insights));
    for (;;)
    {
      return false;
      if (insights == null) {
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
    if (hasTrackingId) {
      i = PegasusBinaryUtils.getEncodedLength(trackingId) + 8;
    }
    int j = i + 1;
    i = j;
    Object localObject;
    if (hasEntityUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    j = i + 1;
    i = j;
    if (hasEntity)
    {
      i = j + 1;
      if (entity._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(entity._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasInsights) {
        break label213;
      }
      i += 2;
      localObject = insights.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label213;
      }
      Insight localInsight = (Insight)((Iterator)localObject).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += entity.getSerializedSize();
        break;
      }
      i += localInsight.getSerializedSize();
    }
    label213:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (entity == null) {
        break label89;
      }
    }
    label89:
    for (int j = entity.hashCode();; j = 0)
    {
      if (insights != null) {
        k = insights.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PeopleYouMayKnow");
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
    label170:
    label230:
    label347:
    label357:
    label382:
    label415:
    label422:
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-1374691118);
        Object localObject;
        if (hasTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasEntityUrn) {
            break label347;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasEntity) {
            break label382;
          }
          localByteBuffer.put((byte)1);
          if (entity._cachedId == null) {
            break label357;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, entity._cachedId);
          entity.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasInsights) {
            break label415;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, insights.size());
          localObject = insights.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label422;
          }
          Insight localInsight = (Insight)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localInsight.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label170;
            localByteBuffer.put((byte)1);
            entity.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
          }
          localByteBuffer.put((byte)1);
          localInsight.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
    public static final PeopleYouMayKnowBuilder.EntityBuilder BUILDER = PeopleYouMayKnowBuilder.EntityBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final GuestContact guestContactValue;
    public final boolean hasGuestContactValue;
    public final boolean hasMiniProfileValue;
    public final MiniProfile miniProfileValue;
    
    Entity(MiniProfile paramMiniProfile, GuestContact paramGuestContact, boolean paramBoolean1, boolean paramBoolean2)
    {
      miniProfileValue = paramMiniProfile;
      guestContactValue = paramGuestContact;
      hasMiniProfileValue = paramBoolean1;
      hasGuestContactValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final Entity accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasMiniProfileValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.MiniProfile");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = miniProfileValue.accept(paramDataProcessor);
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
        if (hasGuestContactValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.growth.abi.GuestContact");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label158;
          }
          localObject1 = guestContactValue.accept(paramDataProcessor);
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
        return new Entity((MiniProfile)localObject2, (GuestContact)localObject1, bool1, bool2);
        localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfileValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (GuestContact)paramDataProcessor.processDataTemplate(guestContactValue);
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
        paramObject = (Entity)paramObject;
        if (miniProfileValue != null)
        {
          if (miniProfileValue.equals(miniProfileValue)) {}
        }
        else {
          while (miniProfileValue != null) {
            return false;
          }
        }
        if (guestContactValue == null) {
          break;
        }
      } while (guestContactValue.equals(guestContactValue));
      for (;;)
      {
        return false;
        if (guestContactValue == null) {
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
      if (hasMiniProfileValue)
      {
        if (miniProfileValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(miniProfileValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasGuestContactValue)
        {
          i = j + 1;
          if (guestContactValue._cachedId == null) {
            break label114;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(guestContactValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = miniProfileValue.getSerializedSize() + 7;
        break;
        label114:
        i += guestContactValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (miniProfileValue != null) {}
      for (int i = miniProfileValue.hashCode();; i = 0)
      {
        if (guestContactValue != null) {
          j = guestContactValue.hashCode();
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
          localByteBuffer.putInt(161958986);
          if (hasMiniProfileValue)
          {
            localByteBuffer.put((byte)1);
            if (miniProfileValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, miniProfileValue._cachedId);
              miniProfileValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasGuestContactValue) {
                break label323;
              }
              localByteBuffer.put((byte)1);
              if (guestContactValue._cachedId == null) {
                break label298;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, guestContactValue._cachedId);
              guestContactValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            miniProfileValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            guestContactValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */