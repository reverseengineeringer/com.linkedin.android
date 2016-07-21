package com.linkedin.android.pegasus.gen.voyager.feed.actions;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class UnfollowMember
  implements FissileDataModel<UnfollowMember>, RecordTemplate<UnfollowMember>
{
  public static final UnfollowMemberBuilder BUILDER = UnfollowMemberBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String displayName;
  public final FollowingInfo followingInfo;
  public final boolean hasDisplayName;
  public final boolean hasFollowingInfo;
  public final boolean hasProfileUrn;
  public final Urn profileUrn;
  
  UnfollowMember(Urn paramUrn, String paramString, FollowingInfo paramFollowingInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    profileUrn = paramUrn;
    displayName = paramString;
    followingInfo = paramFollowingInfo;
    hasProfileUrn = paramBoolean1;
    hasDisplayName = paramBoolean2;
    hasFollowingInfo = paramBoolean3;
    _cachedId = null;
  }
  
  public final UnfollowMember accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasProfileUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("profileUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(profileUrn));
    }
    if (hasDisplayName)
    {
      paramDataProcessor.startRecordField$505cff1c("displayName");
      paramDataProcessor.processString(displayName);
    }
    Object localObject = null;
    boolean bool = false;
    if (hasFollowingInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("followingInfo");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label150;
      }
      localObject = followingInfo.accept(paramDataProcessor);
      if (localObject == null) {
        break label167;
      }
    }
    label150:
    label167:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label198;
      }
      try
      {
        if (hasProfileUrn) {
          break label172;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowMember", "profileUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (FollowingInfo)paramDataProcessor.processDataTemplate(followingInfo);
      break;
    }
    label172:
    return new UnfollowMember(profileUrn, displayName, (FollowingInfo)localObject, hasProfileUrn, hasDisplayName, bool);
    label198:
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
      paramObject = (UnfollowMember)paramObject;
      if (profileUrn != null)
      {
        if (profileUrn.equals(profileUrn)) {}
      }
      else {
        while (profileUrn != null) {
          return false;
        }
      }
      if (displayName != null)
      {
        if (displayName.equals(displayName)) {}
      }
      else {
        while (displayName != null) {
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
    if (hasProfileUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(profileUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasDisplayName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(displayName);
    }
    j = i + 1;
    i = j;
    if (hasFollowingInfo)
    {
      i = j + 1;
      if (followingInfo._cachedId == null) {
        break label119;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(followingInfo._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label119:
      i += followingInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (profileUrn != null)
    {
      i = profileUrn.hashCode();
      if (displayName == null) {
        break label87;
      }
    }
    label87:
    for (int j = displayName.hashCode();; j = 0)
    {
      if (followingInfo != null) {
        k = followingInfo.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building UnfollowMember");
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
    label273:
    label283:
    label308:
    label316:
    label318:
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
        localByteBuffer.putInt(400565099);
        if (hasProfileUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(profileUrn));
          if (!hasDisplayName) {
            break label273;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, displayName);
          if (!hasFollowingInfo) {
            break label308;
          }
          localByteBuffer.put((byte)1);
          if (followingInfo._cachedId == null) {
            break label283;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, followingInfo._cachedId);
          followingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label316;
          }
          if (str != null) {
            break label318;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowMember
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */