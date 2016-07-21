package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class FollowableEntity
  implements FissileDataModel<FollowableEntity>, RecordTemplate<FollowableEntity>
{
  public static final FollowableEntityBuilder BUILDER = FollowableEntityBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Entity entity;
  public final FollowingInfo followingInfo;
  public final boolean hasEntity;
  public final boolean hasFollowingInfo;
  
  FollowableEntity(Entity paramEntity, FollowingInfo paramFollowingInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    entity = paramEntity;
    followingInfo = paramFollowingInfo;
    hasEntity = paramBoolean1;
    hasFollowingInfo = paramBoolean2;
    _cachedId = null;
  }
  
  private FollowableEntity accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasEntity)
    {
      paramDataProcessor.startRecordField$505cff1c("entity");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = entity.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label164;
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
      if (hasFollowingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("followingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label173;
        }
        localObject1 = followingInfo.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label191;
        }
      }
    }
    label164:
    label173:
    label191:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label210;
      }
      try
      {
        if (hasEntity) {
          break label196;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.FollowableEntity", "entity");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (Entity)paramDataProcessor.processDataTemplate(entity);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (FollowingInfo)paramDataProcessor.processDataTemplate(followingInfo);
      break label95;
    }
    label196:
    return new FollowableEntity((Entity)localObject2, (FollowingInfo)localObject1, bool1, bool2);
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
      paramObject = (FollowableEntity)paramObject;
      if (entity != null)
      {
        if (entity.equals(entity)) {}
      }
      else {
        while (entity != null) {
          return false;
        }
      }
      if (followingInfo == null) {
        break;
      }
    } while (followingInfo.equals(followingInfo));
    for (;;)
    {
      return false;
      if (followingInfo == null) {
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
    if (hasEntity)
    {
      if (entity._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(entity._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasFollowingInfo)
      {
        i = j + 1;
        if (followingInfo._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(followingInfo._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = entity.getSerializedSize() + 7;
      break;
      label114:
      i += followingInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (entity != null) {}
    for (int i = entity.hashCode();; i = 0)
    {
      if (followingInfo != null) {
        j = followingInfo.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building FollowableEntity");
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
        localByteBuffer.putInt(-1485622329);
        if (hasEntity)
        {
          localByteBuffer.put((byte)1);
          if (entity._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, entity._cachedId);
            entity.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasFollowingInfo) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (followingInfo._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, followingInfo._cachedId);
            followingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          entity.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          followingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<FollowableEntity>
  {
    private FollowableEntity.Entity entity = null;
    private FollowingInfo followingInfo = null;
    private boolean hasEntity = false;
    private boolean hasFollowingInfo = false;
    
    public final FollowableEntity build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (FollowableEntity.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new FollowableEntity(entity, followingInfo, hasEntity, hasFollowingInfo);
      } while (hasEntity);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.FollowableEntity", "entity");
    }
    
    public final Builder setEntity(FollowableEntity.Entity paramEntity)
    {
      if (paramEntity == null)
      {
        hasEntity = false;
        entity = null;
        return this;
      }
      hasEntity = true;
      entity = paramEntity;
      return this;
    }
    
    public final Builder setFollowingInfo(FollowingInfo paramFollowingInfo)
    {
      if (paramFollowingInfo == null)
      {
        hasFollowingInfo = false;
        followingInfo = null;
        return this;
      }
      hasFollowingInfo = true;
      followingInfo = paramFollowingInfo;
      return this;
    }
  }
  
  public static final class Entity
    implements FissileDataModel<Entity>, UnionTemplate<Entity>
  {
    public static final FollowableEntityBuilder.EntityBuilder BUILDER = FollowableEntityBuilder.EntityBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final Channel channelValue;
    public final boolean hasChannelValue;
    public final boolean hasMiniCompanyValue;
    public final boolean hasMiniGroupValue;
    public final boolean hasMiniProfileValue;
    public final boolean hasMiniSchoolValue;
    public final MiniCompany miniCompanyValue;
    public final MiniGroup miniGroupValue;
    public final MiniProfile miniProfileValue;
    public final MiniSchool miniSchoolValue;
    
    Entity(MiniProfile paramMiniProfile, MiniCompany paramMiniCompany, MiniSchool paramMiniSchool, MiniGroup paramMiniGroup, Channel paramChannel, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
    {
      miniProfileValue = paramMiniProfile;
      miniCompanyValue = paramMiniCompany;
      miniSchoolValue = paramMiniSchool;
      miniGroupValue = paramMiniGroup;
      channelValue = paramChannel;
      hasMiniProfileValue = paramBoolean1;
      hasMiniCompanyValue = paramBoolean2;
      hasMiniSchoolValue = paramBoolean3;
      hasMiniGroupValue = paramBoolean4;
      hasChannelValue = paramBoolean5;
      _cachedId = null;
    }
    
    public final Entity accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      label56:
      Object localObject3;
      boolean bool2;
      label95:
      label106:
      Object localObject4;
      boolean bool3;
      label146:
      label158:
      Object localObject5;
      boolean bool4;
      if (hasMiniProfileValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.MiniProfile");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = miniProfileValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label317;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasMiniCompanyValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.shared.MiniCompany");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label326;
          }
          localObject1 = miniCompanyValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label344;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        localObject4 = null;
        bool3 = false;
        if (hasMiniSchoolValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.shared.MiniSchool");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label353;
          }
          localObject1 = miniSchoolValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label371;
          }
          bool3 = true;
          localObject4 = localObject1;
        }
        localObject5 = null;
        bool4 = false;
        if (hasMiniGroupValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.shared.MiniGroup");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label381;
          }
          localObject1 = miniGroupValue.accept(paramDataProcessor);
          label198:
          if (localObject1 == null) {
            break label399;
          }
          bool4 = true;
          localObject5 = localObject1;
        }
        label210:
        localObject1 = null;
        bool5 = false;
        if (hasChannelValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.growth.interests.Channel");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label409;
          }
          localObject1 = channelValue.accept(paramDataProcessor);
          label250:
          if (localObject1 == null) {
            break label427;
          }
        }
      }
      label317:
      label326:
      label344:
      label353:
      label371:
      label381:
      label399:
      label409:
      label427:
      for (boolean bool5 = true;; bool5 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label433;
        }
        return new Entity((MiniProfile)localObject2, (MiniCompany)localObject3, (MiniSchool)localObject4, (MiniGroup)localObject5, (Channel)localObject1, bool1, bool2, bool3, bool4, bool5);
        localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfileValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompanyValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (MiniSchool)paramDataProcessor.processDataTemplate(miniSchoolValue);
        break label146;
        bool3 = false;
        localObject4 = localObject1;
        break label158;
        localObject1 = (MiniGroup)paramDataProcessor.processDataTemplate(miniGroupValue);
        break label198;
        bool4 = false;
        localObject5 = localObject1;
        break label210;
        localObject1 = (Channel)paramDataProcessor.processDataTemplate(channelValue);
        break label250;
      }
      label433:
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
        if (miniCompanyValue != null)
        {
          if (miniCompanyValue.equals(miniCompanyValue)) {}
        }
        else {
          while (miniCompanyValue != null) {
            return false;
          }
        }
        if (miniSchoolValue != null)
        {
          if (miniSchoolValue.equals(miniSchoolValue)) {}
        }
        else {
          while (miniSchoolValue != null) {
            return false;
          }
        }
        if (miniGroupValue != null)
        {
          if (miniGroupValue.equals(miniGroupValue)) {}
        }
        else {
          while (miniGroupValue != null) {
            return false;
          }
        }
        if (channelValue == null) {
          break;
        }
      } while (channelValue.equals(channelValue));
      for (;;)
      {
        return false;
        if (channelValue == null) {
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
        if (hasMiniCompanyValue)
        {
          i = j + 1;
          if (miniCompanyValue._cachedId == null) {
            break label240;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniCompanyValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasMiniSchoolValue)
        {
          i = j + 1;
          if (miniSchoolValue._cachedId == null) {
            break label253;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniSchoolValue._cachedId);
        }
        label135:
        j = i + 1;
        i = j;
        if (hasMiniGroupValue)
        {
          i = j + 1;
          if (miniGroupValue._cachedId == null) {
            break label266;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniGroupValue._cachedId);
        }
        label177:
        j = i + 1;
        i = j;
        if (hasChannelValue)
        {
          i = j + 1;
          if (channelValue._cachedId == null) {
            break label279;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(channelValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = miniProfileValue.getSerializedSize() + 7;
        break;
        label240:
        i += miniCompanyValue.getSerializedSize();
        break label93;
        label253:
        i += miniSchoolValue.getSerializedSize();
        break label135;
        label266:
        i += miniGroupValue.getSerializedSize();
        break label177;
        label279:
        i += channelValue.getSerializedSize();
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
      if (miniProfileValue != null)
      {
        i = miniProfileValue.hashCode();
        if (miniCompanyValue == null) {
          break label132;
        }
        j = miniCompanyValue.hashCode();
        if (miniSchoolValue == null) {
          break label137;
        }
        k = miniSchoolValue.hashCode();
        label60:
        if (miniGroupValue == null) {
          break label142;
        }
      }
      label132:
      label137:
      label142:
      for (int m = miniGroupValue.hashCode();; m = 0)
      {
        if (channelValue != null) {
          n = channelValue.hashCode();
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
      label230:
      label290:
      label350:
      label478:
      label503:
      label513:
      label538:
      label548:
      label573:
      label583:
      label608:
      label616:
      label618:
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
          localByteBuffer.putInt(1829020713);
          if (hasMiniProfileValue)
          {
            localByteBuffer.put((byte)1);
            if (miniProfileValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, miniProfileValue._cachedId);
              miniProfileValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasMiniCompanyValue) {
                break label503;
              }
              localByteBuffer.put((byte)1);
              if (miniCompanyValue._cachedId == null) {
                break label478;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, miniCompanyValue._cachedId);
              miniCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasMiniSchoolValue) {
                break label538;
              }
              localByteBuffer.put((byte)1);
              if (miniSchoolValue._cachedId == null) {
                break label513;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, miniSchoolValue._cachedId);
              miniSchoolValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasMiniGroupValue) {
                break label573;
              }
              localByteBuffer.put((byte)1);
              if (miniGroupValue._cachedId == null) {
                break label548;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, miniGroupValue._cachedId);
              miniGroupValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasChannelValue) {
                break label608;
              }
              localByteBuffer.put((byte)1);
              if (channelValue._cachedId == null) {
                break label583;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, channelValue._cachedId);
              channelValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label616;
            }
            if (str != null) {
              break label618;
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
            miniCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            miniSchoolValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label290;
            localByteBuffer.put((byte)0);
            break label290;
            localByteBuffer.put((byte)1);
            miniGroupValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label350;
            localByteBuffer.put((byte)0);
            break label350;
            localByteBuffer.put((byte)1);
            channelValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.FollowableEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */