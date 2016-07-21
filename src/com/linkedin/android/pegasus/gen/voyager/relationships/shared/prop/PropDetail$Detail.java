package com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class PropDetail$Detail
  implements FissileDataModel<Detail>, UnionTemplate<Detail>
{
  public static final PropDetailBuilder.DetailBuilder BUILDER = PropDetailBuilder.DetailBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasInvitationInfoValue;
  public final boolean hasLegoTrackingInfoValue;
  public final boolean hasMeetingInfoValue;
  public final boolean hasSocialDetailInfoValue;
  public final InvitationInfo invitationInfoValue;
  public final LegoTrackingInfo legoTrackingInfoValue;
  public final MeetingInfo meetingInfoValue;
  public final SocialDetailInfo socialDetailInfoValue;
  
  PropDetail$Detail(InvitationInfo paramInvitationInfo, LegoTrackingInfo paramLegoTrackingInfo, MeetingInfo paramMeetingInfo, SocialDetailInfo paramSocialDetailInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    invitationInfoValue = paramInvitationInfo;
    legoTrackingInfoValue = paramLegoTrackingInfo;
    meetingInfoValue = paramMeetingInfo;
    socialDetailInfoValue = paramSocialDetailInfo;
    hasInvitationInfoValue = paramBoolean1;
    hasLegoTrackingInfoValue = paramBoolean2;
    hasMeetingInfoValue = paramBoolean3;
    hasSocialDetailInfoValue = paramBoolean4;
    _cachedId = null;
  }
  
  public final Detail accept(DataProcessor paramDataProcessor)
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
    if (hasInvitationInfoValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.relationships.shared.prop.InvitationInfo");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = invitationInfoValue.accept(paramDataProcessor);
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
      if (hasLegoTrackingInfoValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.relationships.shared.prop.LegoTrackingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label270;
        }
        localObject1 = legoTrackingInfoValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label288;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasMeetingInfoValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.relationships.shared.prop.MeetingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label297;
        }
        localObject1 = meetingInfoValue.accept(paramDataProcessor);
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
      if (hasSocialDetailInfoValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.relationships.shared.prop.SocialDetailInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label325;
        }
        localObject1 = socialDetailInfoValue.accept(paramDataProcessor);
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
      return new Detail((InvitationInfo)localObject2, (LegoTrackingInfo)localObject3, (MeetingInfo)localObject4, (SocialDetailInfo)localObject1, bool1, bool2, bool3, bool4);
      localObject1 = (InvitationInfo)paramDataProcessor.processDataTemplate(invitationInfoValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (LegoTrackingInfo)paramDataProcessor.processDataTemplate(legoTrackingInfoValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (MeetingInfo)paramDataProcessor.processDataTemplate(meetingInfoValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (SocialDetailInfo)paramDataProcessor.processDataTemplate(socialDetailInfoValue);
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
      paramObject = (Detail)paramObject;
      if (invitationInfoValue != null)
      {
        if (invitationInfoValue.equals(invitationInfoValue)) {}
      }
      else {
        while (invitationInfoValue != null) {
          return false;
        }
      }
      if (legoTrackingInfoValue != null)
      {
        if (legoTrackingInfoValue.equals(legoTrackingInfoValue)) {}
      }
      else {
        while (legoTrackingInfoValue != null) {
          return false;
        }
      }
      if (meetingInfoValue != null)
      {
        if (meetingInfoValue.equals(meetingInfoValue)) {}
      }
      else {
        while (meetingInfoValue != null) {
          return false;
        }
      }
      if (socialDetailInfoValue == null) {
        break;
      }
    } while (socialDetailInfoValue.equals(socialDetailInfoValue));
    for (;;)
    {
      return false;
      if (socialDetailInfoValue == null) {
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
    if (hasInvitationInfoValue)
    {
      if (invitationInfoValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(invitationInfoValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasLegoTrackingInfoValue)
      {
        i = j + 1;
        if (legoTrackingInfoValue._cachedId == null) {
          break label198;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(legoTrackingInfoValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasMeetingInfoValue)
      {
        i = j + 1;
        if (meetingInfoValue._cachedId == null) {
          break label211;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(meetingInfoValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasSocialDetailInfoValue)
      {
        i = j + 1;
        if (socialDetailInfoValue._cachedId == null) {
          break label224;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(socialDetailInfoValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = invitationInfoValue.getSerializedSize() + 7;
      break;
      label198:
      i += legoTrackingInfoValue.getSerializedSize();
      break label93;
      label211:
      i += meetingInfoValue.getSerializedSize();
      break label135;
      label224:
      i += socialDetailInfoValue.getSerializedSize();
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
    if (invitationInfoValue != null)
    {
      i = invitationInfoValue.hashCode();
      if (legoTrackingInfoValue == null) {
        break label110;
      }
      j = legoTrackingInfoValue.hashCode();
      label45:
      if (meetingInfoValue == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = meetingInfoValue.hashCode();; k = 0)
    {
      if (socialDetailInfoValue != null) {
        m = socialDetailInfoValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Detail");
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
        localByteBuffer.putInt(254642335);
        if (hasInvitationInfoValue)
        {
          localByteBuffer.put((byte)1);
          if (invitationInfoValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, invitationInfoValue._cachedId);
            invitationInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasLegoTrackingInfoValue) {
              break label443;
            }
            localByteBuffer.put((byte)1);
            if (legoTrackingInfoValue._cachedId == null) {
              break label418;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, legoTrackingInfoValue._cachedId);
            legoTrackingInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMeetingInfoValue) {
              break label478;
            }
            localByteBuffer.put((byte)1);
            if (meetingInfoValue._cachedId == null) {
              break label453;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, meetingInfoValue._cachedId);
            meetingInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSocialDetailInfoValue) {
              break label513;
            }
            localByteBuffer.put((byte)1);
            if (socialDetailInfoValue._cachedId == null) {
              break label488;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, socialDetailInfoValue._cachedId);
            socialDetailInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          invitationInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          legoTrackingInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          meetingInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          socialDetailInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropDetail.Detail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */