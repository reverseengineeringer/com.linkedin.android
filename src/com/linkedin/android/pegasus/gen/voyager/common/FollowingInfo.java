package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class FollowingInfo
  implements FissileDataModel<FollowingInfo>, RecordTemplate<FollowingInfo>
{
  public static final FollowingInfoBuilder BUILDER = FollowingInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Urn entityUrn;
  public final int followerCount;
  public final boolean following;
  public final boolean hasEntityUrn;
  public final boolean hasFollowerCount;
  public final boolean hasFollowing;
  
  FollowingInfo(Urn paramUrn, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    entityUrn = paramUrn;
    following = paramBoolean1;
    followerCount = paramInt;
    hasEntityUrn = paramBoolean2;
    hasFollowing = paramBoolean3;
    hasFollowerCount = paramBoolean4;
    UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  public final FollowingInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasFollowing)
    {
      paramDataProcessor.startRecordField$505cff1c("following");
      paramDataProcessor.processBoolean(following);
    }
    if (hasFollowerCount)
    {
      paramDataProcessor.startRecordField$505cff1c("followerCount");
      paramDataProcessor.processInt(followerCount);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasEntityUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo", "entityUrn");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasFollowing) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo", "following");
      }
      return new FollowingInfo(entityUrn, following, followerCount, hasEntityUrn, hasFollowing, hasFollowerCount);
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
      paramObject = (FollowingInfo)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (following != following) {
        return false;
      }
    } while (followerCount == followerCount);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasFollowing) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasFollowerCount) {
      i = j + 4;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (entityUrn != null) {}
    for (int i = entityUrn.hashCode();; i = 0)
    {
      if (following) {
        j = 1;
      }
      i = ((i + 527) * 31 + j) * 31 + followerCount;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building FollowingInfo");
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
    label177:
    label244:
    label250:
    label260:
    label268:
    label270:
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
        localByteBuffer.putInt(1816936490);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasFollowing) {
            break label250;
          }
          localByteBuffer.put((byte)1);
          if (!following) {
            break label244;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasFollowerCount) {
            break label260;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(followerCount);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label268;
          }
          if (str != null) {
            break label270;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          i = 0;
          break label168;
          localByteBuffer.put((byte)0);
          break label177;
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
    implements RecordTemplateBuilder<FollowingInfo>
  {
    private Urn entityUrn = null;
    private int followerCount = 0;
    private boolean following = false;
    private boolean hasEntityUrn = false;
    private boolean hasFollowerCount = false;
    private boolean hasFollowing = false;
    
    public final FollowingInfo build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (FollowingInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new FollowingInfo(entityUrn, following, followerCount, hasEntityUrn, hasFollowing, hasFollowerCount);
        if (!hasEntityUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo", "entityUrn");
        }
      } while (hasFollowing);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo", "following");
    }
    
    public final Builder setEntityUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasEntityUrn = false;
        entityUrn = null;
        return this;
      }
      hasEntityUrn = true;
      entityUrn = paramUrn;
      return this;
    }
    
    public final Builder setFollowerCount(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        hasFollowerCount = false;
        followerCount = 0;
        return this;
      }
      hasFollowerCount = true;
      followerCount = paramInteger.intValue();
      return this;
    }
    
    public final Builder setFollowing(Boolean paramBoolean)
    {
      if (paramBoolean == null)
      {
        hasFollowing = false;
        following = false;
        return this;
      }
      hasFollowing = true;
      following = paramBoolean.booleanValue();
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */