package com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class InvitationInfo
  implements FissileDataModel<InvitationInfo>, RecordTemplate<InvitationInfo>
{
  public static final InvitationInfoBuilder BUILDER = InvitationInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean customMessage;
  public final boolean hasCustomMessage;
  public final boolean hasInvitationUrn;
  public final boolean hasMailboxItemId;
  public final boolean hasMessage;
  public final boolean hasMiniProfile;
  public final boolean hasSharedSecret;
  public final Urn invitationUrn;
  public final String mailboxItemId;
  public final String message;
  public final MiniProfile miniProfile;
  public final String sharedSecret;
  
  InvitationInfo(MiniProfile paramMiniProfile, Urn paramUrn, String paramString1, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    miniProfile = paramMiniProfile;
    invitationUrn = paramUrn;
    sharedSecret = paramString1;
    customMessage = paramBoolean1;
    message = paramString2;
    mailboxItemId = paramString3;
    hasMiniProfile = paramBoolean2;
    hasInvitationUrn = paramBoolean3;
    hasSharedSecret = paramBoolean4;
    hasCustomMessage = paramBoolean5;
    hasMessage = paramBoolean6;
    hasMailboxItemId = paramBoolean7;
    _cachedId = null;
  }
  
  public final InvitationInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    MiniProfile localMiniProfile = null;
    boolean bool = false;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label226;
      }
      localMiniProfile = miniProfile.accept(paramDataProcessor);
      if (localMiniProfile == null) {
        break label243;
      }
    }
    label226:
    label243:
    for (bool = true;; bool = false)
    {
      if (hasInvitationUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("invitationUrn");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(invitationUrn));
      }
      if (hasSharedSecret)
      {
        paramDataProcessor.startRecordField$505cff1c("sharedSecret");
        paramDataProcessor.processString(sharedSecret);
      }
      if (hasCustomMessage)
      {
        paramDataProcessor.startRecordField$505cff1c("customMessage");
        paramDataProcessor.processBoolean(customMessage);
      }
      if (hasMessage)
      {
        paramDataProcessor.startRecordField$505cff1c("message");
        paramDataProcessor.processString(message);
      }
      if (hasMailboxItemId)
      {
        paramDataProcessor.startRecordField$505cff1c("mailboxItemId");
        paramDataProcessor.processString(mailboxItemId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label317;
      }
      try
      {
        if (hasMiniProfile) {
          break label248;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.InvitationInfo", "miniProfile");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localMiniProfile = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break;
    }
    label248:
    if (!hasInvitationUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.InvitationInfo", "invitationUrn");
    }
    return new InvitationInfo(localMiniProfile, invitationUrn, sharedSecret, customMessage, message, mailboxItemId, bool, hasInvitationUrn, hasSharedSecret, hasCustomMessage, hasMessage, hasMailboxItemId);
    label317:
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
      paramObject = (InvitationInfo)paramObject;
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
          return false;
        }
      }
      if (invitationUrn != null)
      {
        if (invitationUrn.equals(invitationUrn)) {}
      }
      else {
        while (invitationUrn != null) {
          return false;
        }
      }
      if (sharedSecret != null)
      {
        if (sharedSecret.equals(sharedSecret)) {}
      }
      else {
        while (sharedSecret != null) {
          return false;
        }
      }
      if (customMessage != customMessage) {
        return false;
      }
      if (message != null)
      {
        if (message.equals(message)) {}
      }
      else {
        while (message != null) {
          return false;
        }
      }
      if (mailboxItemId == null) {
        break;
      }
    } while (mailboxItemId.equals(mailboxItemId));
    for (;;)
    {
      return false;
      if (mailboxItemId == null) {
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
    if (hasMiniProfile) {
      if (miniProfile._cachedId == null) {
        break label182;
      }
    }
    label182:
    for (i = PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId) + 9;; i = miniProfile.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasInvitationUrn)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(invitationUrn));
      }
      j = i + 1;
      i = j;
      if (hasSharedSecret) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(sharedSecret);
      }
      j = i + 1;
      i = j;
      if (hasCustomMessage) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasMessage) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(message);
      }
      j = i + 1;
      i = j;
      if (hasMailboxItemId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(mailboxItemId);
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (miniProfile != null)
    {
      i = miniProfile.hashCode();
      if (invitationUrn == null) {
        break label148;
      }
      j = invitationUrn.hashCode();
      if (sharedSecret == null) {
        break label153;
      }
      k = sharedSecret.hashCode();
      if (!customMessage) {
        break label158;
      }
      m = 1;
      label70:
      if (message == null) {
        break label164;
      }
    }
    label148:
    label153:
    label158:
    label164:
    for (int n = message.hashCode();; n = 0)
    {
      if (mailboxItemId != null) {
        i1 = mailboxItemId.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label70;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building InvitationInfo");
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
    label230:
    label254:
    label263:
    label289:
    label383:
    label393:
    label403:
    label409:
    label419:
    label429:
    label437:
    label439:
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
        localByteBuffer.putInt(-159000046);
        if (hasMiniProfile)
        {
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
            miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasInvitationUrn) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(invitationUrn));
            if (!hasSharedSecret) {
              break label393;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, sharedSecret);
            if (!hasCustomMessage) {
              break label409;
            }
            localByteBuffer.put((byte)1);
            if (!customMessage) {
              break label403;
            }
            i = 1;
            localByteBuffer.put((byte)i);
            if (!hasMessage) {
              break label419;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, message);
            if (!hasMailboxItemId) {
              break label429;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, mailboxItemId);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label437;
          }
          if (str != null) {
            break label439;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)0);
          break label230;
          i = 0;
          break label254;
          localByteBuffer.put((byte)0);
          break label263;
          localByteBuffer.put((byte)0);
          break label289;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.InvitationInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */