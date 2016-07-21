package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ProfileNetworkInfo
  implements FissileDataModel<ProfileNetworkInfo>, RecordTemplate<ProfileNetworkInfo>
{
  public static final ProfileNetworkInfoBuilder BUILDER = ProfileNetworkInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final int connectionsCount;
  public final MemberDistance distance;
  public final Urn entityUrn;
  public final boolean followable;
  public final long followersCount;
  public final boolean following;
  public final FollowingInfo followingInfo;
  public final boolean hasConnectionsCount;
  public final boolean hasDistance;
  public final boolean hasEntityUrn;
  public final boolean hasFollowable;
  public final boolean hasFollowersCount;
  public final boolean hasFollowing;
  public final boolean hasFollowingInfo;
  
  ProfileNetworkInfo(Urn paramUrn, MemberDistance paramMemberDistance, int paramInt, FollowingInfo paramFollowingInfo, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    entityUrn = paramUrn;
    distance = paramMemberDistance;
    connectionsCount = paramInt;
    followingInfo = paramFollowingInfo;
    followersCount = paramLong;
    following = paramBoolean1;
    followable = paramBoolean2;
    hasEntityUrn = paramBoolean3;
    hasDistance = paramBoolean4;
    hasConnectionsCount = paramBoolean5;
    hasFollowingInfo = paramBoolean6;
    hasFollowersCount = paramBoolean7;
    hasFollowing = paramBoolean8;
    hasFollowable = paramBoolean9;
    paramMemberDistance = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  private ProfileNetworkInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasDistance)
    {
      paramDataProcessor.startRecordField$505cff1c("distance");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = distance.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label297;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label89:
      if (hasConnectionsCount)
      {
        paramDataProcessor.startRecordField$505cff1c("connectionsCount");
        paramDataProcessor.processInt(connectionsCount);
      }
      localObject1 = null;
      bool2 = false;
      if (hasFollowingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("followingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label306;
        }
        localObject1 = followingInfo.accept(paramDataProcessor);
        label153:
        if (localObject1 == null) {
          break label324;
        }
      }
    }
    label297:
    label306:
    label324:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasFollowersCount)
      {
        paramDataProcessor.startRecordField$505cff1c("followersCount");
        paramDataProcessor.processLong(followersCount);
      }
      if (hasFollowing)
      {
        paramDataProcessor.startRecordField$505cff1c("following");
        paramDataProcessor.processBoolean(following);
      }
      if (hasFollowable)
      {
        paramDataProcessor.startRecordField$505cff1c("followable");
        paramDataProcessor.processBoolean(followable);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label402;
      }
      try
      {
        if (hasDistance) {
          break label329;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileNetworkInfo", "distance");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MemberDistance)paramDataProcessor.processDataTemplate(distance);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label89;
      localObject1 = (FollowingInfo)paramDataProcessor.processDataTemplate(followingInfo);
      break label153;
    }
    label329:
    if (!hasConnectionsCount) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileNetworkInfo", "connectionsCount");
    }
    return new ProfileNetworkInfo(entityUrn, (MemberDistance)localObject2, connectionsCount, (FollowingInfo)localObject1, followersCount, following, followable, hasEntityUrn, bool1, hasConnectionsCount, bool2, hasFollowersCount, hasFollowing, hasFollowable);
    label402:
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
      paramObject = (ProfileNetworkInfo)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (distance != null)
      {
        if (distance.equals(distance)) {}
      }
      else {
        while (distance != null) {
          return false;
        }
      }
      if (connectionsCount != connectionsCount) {
        return false;
      }
      if (followingInfo != null)
      {
        if (followingInfo.equals(followingInfo)) {}
      }
      else {
        while (followingInfo != null) {
          return false;
        }
      }
      if (followersCount != followersCount) {
        return false;
      }
      if (following != following) {
        return false;
      }
    } while (followable == followable);
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
    if (hasDistance)
    {
      i = j + 1;
      if (distance._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(distance._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasConnectionsCount) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasFollowingInfo)
      {
        i = j + 1;
        if (followingInfo._cachedId == null) {
          break label218;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(followingInfo._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasFollowersCount) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasFollowing) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasFollowable) {
        i = j + 1;
      }
      __sizeOfObject = i;
      return i;
      i += distance.getSerializedSize();
      break;
      label218:
      i += followingInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 1;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int i1;
    int k;
    label66:
    int i2;
    int m;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (distance == null) {
        break label150;
      }
      j = distance.hashCode();
      i1 = connectionsCount;
      if (followingInfo == null) {
        break label155;
      }
      k = followingInfo.hashCode();
      i2 = (int)(followersCount ^ followersCount >>> 32);
      if (!following) {
        break label160;
      }
      m = 1;
      label91:
      if (!followable) {
        break label166;
      }
    }
    for (;;)
    {
      i = (m + ((k + ((j + (i + 527) * 31) * 31 + i1) * 31) * 31 + i2) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      label150:
      j = 0;
      break label45;
      label155:
      k = 0;
      break label66;
      label160:
      m = 0;
      break label91;
      label166:
      n = 0;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfileNetworkInfo");
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
    label204:
    label228:
    label288:
    label312:
    label336:
    label345:
    label369:
    label421:
    label446:
    label456:
    label466:
    label491:
    label501:
    label511:
    label517:
    label527:
    label533:
    label541:
    label543:
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
        localByteBuffer.putInt(1534702660);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasDistance) {
            break label446;
          }
          localByteBuffer.put((byte)1);
          if (distance._cachedId == null) {
            break label421;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, distance._cachedId);
          distance.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasConnectionsCount) {
            break label456;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(connectionsCount);
          if (!hasFollowingInfo) {
            break label491;
          }
          localByteBuffer.put((byte)1);
          if (followingInfo._cachedId == null) {
            break label466;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, followingInfo._cachedId);
          followingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasFollowersCount) {
            break label501;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(followersCount);
          if (!hasFollowing) {
            break label517;
          }
          localByteBuffer.put((byte)1);
          if (!following) {
            break label511;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasFollowable) {
            break label533;
          }
          localByteBuffer.put((byte)1);
          if (!followable) {
            break label527;
          }
          i = 1;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label541;
          }
          if (str != null) {
            break label543;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          distance.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label204;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)0);
          break label228;
          localByteBuffer.put((byte)1);
          followingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label288;
          localByteBuffer.put((byte)0);
          break label288;
          localByteBuffer.put((byte)0);
          break label312;
          i = 0;
          break label336;
          localByteBuffer.put((byte)0);
          break label345;
          i = 0;
          break label369;
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
    implements RecordTemplateBuilder<ProfileNetworkInfo>
  {
    public int connectionsCount = 0;
    public MemberDistance distance = null;
    private Urn entityUrn = null;
    public boolean followable = false;
    public long followersCount = 0L;
    private boolean following = false;
    public FollowingInfo followingInfo = null;
    public boolean hasConnectionsCount = false;
    public boolean hasDistance = false;
    private boolean hasEntityUrn = false;
    public boolean hasFollowable = false;
    public boolean hasFollowersCount = false;
    private boolean hasFollowing = false;
    public boolean hasFollowingInfo = false;
    
    public final ProfileNetworkInfo build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ProfileNetworkInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new ProfileNetworkInfo(entityUrn, distance, connectionsCount, followingInfo, followersCount, following, followable, hasEntityUrn, hasDistance, hasConnectionsCount, hasFollowingInfo, hasFollowersCount, hasFollowing, hasFollowable);
        if (!hasDistance) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileNetworkInfo", "distance");
        }
      } while (hasConnectionsCount);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileNetworkInfo", "connectionsCount");
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
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileNetworkInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */