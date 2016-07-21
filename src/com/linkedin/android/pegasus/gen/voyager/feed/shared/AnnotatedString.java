package com.linkedin.android.pegasus.gen.voyager.feed.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
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
import com.linkedin.data.lite.UnionMemberCountException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class AnnotatedString
  implements FissileDataModel<AnnotatedString>, RecordTemplate<AnnotatedString>
{
  public static final AnnotatedStringBuilder BUILDER = AnnotatedStringBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Entity entity;
  public final boolean hasEntity;
  public final boolean hasValue;
  public final String value;
  
  AnnotatedString(String paramString, Entity paramEntity, boolean paramBoolean1, boolean paramBoolean2)
  {
    value = paramString;
    entity = paramEntity;
    hasValue = paramBoolean1;
    hasEntity = paramBoolean2;
    _cachedId = null;
  }
  
  public final AnnotatedString accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasValue)
    {
      paramDataProcessor.startRecordField$505cff1c("value");
      paramDataProcessor.processString(value);
    }
    Entity localEntity = null;
    boolean bool = false;
    if (hasEntity)
    {
      paramDataProcessor.startRecordField$505cff1c("entity");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label118;
      }
      localEntity = entity.accept(paramDataProcessor);
      if (localEntity == null) {
        break label135;
      }
    }
    label118:
    label135:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label158;
      }
      try
      {
        if (hasValue) {
          break label140;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString", "value");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localEntity = (Entity)paramDataProcessor.processDataTemplate(entity);
      break;
    }
    label140:
    return new AnnotatedString(value, localEntity, hasValue, bool);
    label158:
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
      paramObject = (AnnotatedString)paramObject;
      if (value != null)
      {
        if (value.equals(value)) {}
      }
      else {
        while (value != null) {
          return false;
        }
      }
      if (entity == null) {
        break;
      }
    } while (entity.equals(entity));
    for (;;)
    {
      return false;
      if (entity == null) {
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
    if (hasValue) {
      i = PegasusBinaryUtils.getEncodedLength(value) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasEntity)
    {
      i = j + 1;
      if (entity._cachedId == null) {
        break label87;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(entity._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label87:
      i += entity.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (value != null) {}
    for (int i = value.hashCode();; i = 0)
    {
      if (entity != null) {
        j = entity.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AnnotatedString");
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
    label239:
    label264:
    label272:
    label274:
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
        localByteBuffer.putInt(-1204830484);
        if (hasValue)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, value);
          if (!hasEntity) {
            break label264;
          }
          localByteBuffer.put((byte)1);
          if (entity._cachedId == null) {
            break label239;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, entity._cachedId);
          entity.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label272;
          }
          if (str != null) {
            break label274;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          entity.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    implements RecordTemplateBuilder<AnnotatedString>
  {
    public AnnotatedString.Entity entity = null;
    public boolean hasEntity = false;
    private boolean hasValue = false;
    private String value = null;
    
    public final AnnotatedString build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (AnnotatedString.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new AnnotatedString(value, entity, hasValue, hasEntity);
      } while (hasValue);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString", "value");
    }
    
    public final Builder setValue(String paramString)
    {
      if (paramString == null)
      {
        hasValue = false;
        value = null;
        return this;
      }
      hasValue = true;
      value = paramString;
      return this;
    }
  }
  
  public static final class Entity
    implements FissileDataModel<Entity>, UnionTemplate<Entity>
  {
    public static final AnnotatedStringBuilder.EntityBuilder BUILDER = AnnotatedStringBuilder.EntityBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final Channel channelValue;
    public final boolean hasChannelValue;
    public final boolean hasMiniCompanyValue;
    public final boolean hasMiniProfileValue;
    public final boolean hasMiniSchoolValue;
    public final MiniCompany miniCompanyValue;
    public final MiniProfile miniProfileValue;
    public final MiniSchool miniSchoolValue;
    
    Entity(MiniProfile paramMiniProfile, MiniCompany paramMiniCompany, MiniSchool paramMiniSchool, Channel paramChannel, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      miniProfileValue = paramMiniProfile;
      miniCompanyValue = paramMiniCompany;
      miniSchoolValue = paramMiniSchool;
      channelValue = paramChannel;
      hasMiniProfileValue = paramBoolean1;
      hasMiniCompanyValue = paramBoolean2;
      hasMiniSchoolValue = paramBoolean3;
      hasChannelValue = paramBoolean4;
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
      if (hasMiniProfileValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.MiniProfile");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = miniProfileValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label261;
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
            break label270;
          }
          localObject1 = miniCompanyValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label288;
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
            break label297;
          }
          localObject1 = miniSchoolValue.accept(paramDataProcessor);
          label146:
          if (localObject1 == null) {
            break label315;
          }
          bool3 = true;
          localObject4 = localObject1;
        }
        label158:
        localObject1 = null;
        bool4 = false;
        if (hasChannelValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.growth.interests.Channel");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label325;
          }
          localObject1 = channelValue.accept(paramDataProcessor);
          label198:
          if (localObject1 == null) {
            break label343;
          }
        }
      }
      label261:
      label270:
      label288:
      label297:
      label315:
      label325:
      label343:
      for (boolean bool4 = true;; bool4 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label349;
        }
        return new Entity((MiniProfile)localObject2, (MiniCompany)localObject3, (MiniSchool)localObject4, (Channel)localObject1, bool1, bool2, bool3, bool4);
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
        localObject1 = (Channel)paramDataProcessor.processDataTemplate(channelValue);
        break label198;
      }
      label349:
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
            break label198;
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
            break label211;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniSchoolValue._cachedId);
        }
        label135:
        j = i + 1;
        i = j;
        if (hasChannelValue)
        {
          i = j + 1;
          if (channelValue._cachedId == null) {
            break label224;
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
        label198:
        i += miniCompanyValue.getSerializedSize();
        break label93;
        label211:
        i += miniSchoolValue.getSerializedSize();
        break label135;
        label224:
        i += channelValue.getSerializedSize();
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
      if (miniProfileValue != null)
      {
        i = miniProfileValue.hashCode();
        if (miniCompanyValue == null) {
          break label110;
        }
        j = miniCompanyValue.hashCode();
        label45:
        if (miniSchoolValue == null) {
          break label115;
        }
      }
      label110:
      label115:
      for (int k = miniSchoolValue.hashCode();; k = 0)
      {
        if (channelValue != null) {
          m = channelValue.hashCode();
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
      label418:
      label443:
      label453:
      label478:
      label488:
      label513:
      label521:
      label523:
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
          localByteBuffer.putInt(-532307972);
          if (hasMiniProfileValue)
          {
            localByteBuffer.put((byte)1);
            if (miniProfileValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, miniProfileValue._cachedId);
              miniProfileValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasMiniCompanyValue) {
                break label443;
              }
              localByteBuffer.put((byte)1);
              if (miniCompanyValue._cachedId == null) {
                break label418;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, miniCompanyValue._cachedId);
              miniCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasMiniSchoolValue) {
                break label478;
              }
              localByteBuffer.put((byte)1);
              if (miniSchoolValue._cachedId == null) {
                break label453;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, miniSchoolValue._cachedId);
              miniSchoolValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasChannelValue) {
                break label513;
              }
              localByteBuffer.put((byte)1);
              if (channelValue._cachedId == null) {
                break label488;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, channelValue._cachedId);
              channelValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label521;
            }
            if (str != null) {
              break label523;
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
    
    public static final class Builder
    {
      private Channel channelValue = null;
      private boolean hasChannelValue = false;
      public boolean hasMiniCompanyValue = false;
      public boolean hasMiniProfileValue = false;
      public boolean hasMiniSchoolValue = false;
      public MiniCompany miniCompanyValue = null;
      public MiniProfile miniProfileValue = null;
      public MiniSchool miniSchoolValue = null;
      
      public final AnnotatedString.Entity build()
        throws BuilderException
      {
        int j = 0;
        if (hasMiniProfileValue) {
          j = 0 + 1;
        }
        int i = j;
        if (hasMiniCompanyValue) {
          i = j + 1;
        }
        j = i;
        if (hasMiniSchoolValue) {
          j = i + 1;
        }
        i = j;
        if (hasChannelValue) {
          i = j + 1;
        }
        if (i > 1) {
          throw new UnionMemberCountException("Entity", i);
        }
        return new AnnotatedString.Entity(miniProfileValue, miniCompanyValue, miniSchoolValue, channelValue, hasMiniProfileValue, hasMiniCompanyValue, hasMiniSchoolValue, hasChannelValue);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */