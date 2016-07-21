package com.linkedin.android.pegasus.gen.voyager.relationships.invitation;

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
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Invitation
  implements FissileDataModel<Invitation>, RecordTemplate<Invitation>
{
  public static final InvitationBuilder BUILDER = InvitationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean customMessage;
  public final Urn entityUrn;
  public final MiniProfile fromMember;
  public final String fromMemberId;
  public final boolean hasCustomMessage;
  public final boolean hasEntityUrn;
  public final boolean hasFromMember;
  public final boolean hasFromMemberId;
  public final boolean hasInvitationType;
  public final boolean hasInvitee;
  public final boolean hasMailboxItemId;
  public final boolean hasMessage;
  public final boolean hasSentTime;
  public final boolean hasSharedSecret;
  public final boolean hasToMember;
  public final boolean hasToMemberId;
  public final InvitationType invitationType;
  public final Invitee invitee;
  public final String mailboxItemId;
  public final String message;
  public final long sentTime;
  public final String sharedSecret;
  public final MiniProfile toMember;
  public final String toMemberId;
  
  Invitation(String paramString1, String paramString2, Urn paramUrn, String paramString3, String paramString4, MiniProfile paramMiniProfile1, MiniProfile paramMiniProfile2, Invitee paramInvitee, long paramLong, InvitationType paramInvitationType, boolean paramBoolean1, String paramString5, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13)
  {
    toMemberId = paramString1;
    message = paramString2;
    entityUrn = paramUrn;
    sharedSecret = paramString3;
    fromMemberId = paramString4;
    fromMember = paramMiniProfile1;
    toMember = paramMiniProfile2;
    invitee = paramInvitee;
    sentTime = paramLong;
    invitationType = paramInvitationType;
    customMessage = paramBoolean1;
    mailboxItemId = paramString5;
    hasToMemberId = paramBoolean2;
    hasMessage = paramBoolean3;
    hasEntityUrn = paramBoolean4;
    hasSharedSecret = paramBoolean5;
    hasFromMemberId = paramBoolean6;
    hasFromMember = paramBoolean7;
    hasToMember = paramBoolean8;
    hasInvitee = paramBoolean9;
    hasSentTime = paramBoolean10;
    hasInvitationType = paramBoolean11;
    hasCustomMessage = paramBoolean12;
    hasMailboxItemId = paramBoolean13;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  public final Invitation accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasToMemberId)
    {
      paramDataProcessor.startRecordField$505cff1c("toMemberId");
      paramDataProcessor.processString(toMemberId);
    }
    if (hasMessage)
    {
      paramDataProcessor.startRecordField$505cff1c("message");
      paramDataProcessor.processString(message);
    }
    Object localObject1;
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasSharedSecret)
    {
      paramDataProcessor.startRecordField$505cff1c("sharedSecret");
      paramDataProcessor.processString(sharedSecret);
    }
    if (hasFromMemberId)
    {
      paramDataProcessor.startRecordField$505cff1c("fromMemberId");
      paramDataProcessor.processString(fromMemberId);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label189:
    Object localObject3;
    boolean bool2;
    if (hasFromMember)
    {
      paramDataProcessor.startRecordField$505cff1c("fromMember");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = fromMember.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label449;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasToMember)
      {
        paramDataProcessor.startRecordField$505cff1c("toMember");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label458;
        }
        localObject1 = toMember.accept(paramDataProcessor);
        label228:
        if (localObject1 == null) {
          break label476;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label239:
      localObject1 = null;
      bool3 = false;
      if (hasInvitee)
      {
        paramDataProcessor.startRecordField$505cff1c("invitee");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label485;
        }
        localObject1 = invitee.accept(paramDataProcessor);
        label279:
        if (localObject1 == null) {
          break label503;
        }
      }
    }
    label449:
    label458:
    label476:
    label485:
    label503:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasSentTime)
      {
        paramDataProcessor.startRecordField$505cff1c("sentTime");
        paramDataProcessor.processLong(sentTime);
      }
      if (hasInvitationType)
      {
        paramDataProcessor.startRecordField$505cff1c("invitationType");
        paramDataProcessor.processEnum(invitationType);
      }
      if (hasCustomMessage)
      {
        paramDataProcessor.startRecordField$505cff1c("customMessage");
        paramDataProcessor.processBoolean(customMessage);
      }
      if (hasMailboxItemId)
      {
        paramDataProcessor.startRecordField$505cff1c("mailboxItemId");
        paramDataProcessor.processString(mailboxItemId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label656;
      }
      try
      {
        if (hasToMemberId) {
          break label509;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation", "toMemberId");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(fromMember);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label189;
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(toMember);
      break label228;
      bool2 = false;
      localObject3 = localObject1;
      break label239;
      localObject1 = (Invitee)paramDataProcessor.processDataTemplate(invitee);
      break label279;
    }
    label509:
    if (!hasEntityUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation", "entityUrn");
    }
    if (!hasSharedSecret) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation", "sharedSecret");
    }
    if (!hasCustomMessage) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation", "customMessage");
    }
    return new Invitation(toMemberId, message, entityUrn, sharedSecret, fromMemberId, (MiniProfile)localObject2, (MiniProfile)localObject3, (Invitee)localObject1, sentTime, invitationType, customMessage, mailboxItemId, hasToMemberId, hasMessage, hasEntityUrn, hasSharedSecret, hasFromMemberId, bool1, bool2, bool3, hasSentTime, hasInvitationType, hasCustomMessage, hasMailboxItemId);
    label656:
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
      paramObject = (Invitation)paramObject;
      if (toMemberId != null)
      {
        if (toMemberId.equals(toMemberId)) {}
      }
      else {
        while (toMemberId != null) {
          return false;
        }
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
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
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
      if (fromMemberId != null)
      {
        if (fromMemberId.equals(fromMemberId)) {}
      }
      else {
        while (fromMemberId != null) {
          return false;
        }
      }
      if (fromMember != null)
      {
        if (fromMember.equals(fromMember)) {}
      }
      else {
        while (fromMember != null) {
          return false;
        }
      }
      if (toMember != null)
      {
        if (toMember.equals(toMember)) {}
      }
      else {
        while (toMember != null) {
          return false;
        }
      }
      if (invitee != null)
      {
        if (invitee.equals(invitee)) {}
      }
      else {
        while (invitee != null) {
          return false;
        }
      }
      if (sentTime != sentTime) {
        return false;
      }
      if (invitationType != null)
      {
        if (invitationType.equals(invitationType)) {}
      }
      else {
        while (invitationType != null) {
          return false;
        }
      }
      if (customMessage != customMessage) {
        return false;
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
    if (hasToMemberId) {
      i = PegasusBinaryUtils.getEncodedLength(toMemberId) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasMessage) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(message);
    }
    j = i + 1;
    i = j;
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    j = i + 1;
    i = j;
    if (hasSharedSecret) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(sharedSecret);
    }
    j = i + 1;
    i = j;
    if (hasFromMemberId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(fromMemberId);
    }
    j = i + 1;
    i = j;
    if (hasFromMember)
    {
      i = j + 1;
      if (fromMember._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(fromMember._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasToMember)
      {
        i = j + 1;
        if (toMember._cachedId == null) {
          break label368;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(toMember._cachedId);
      }
      label229:
      j = i + 1;
      i = j;
      if (hasInvitee)
      {
        i = j + 1;
        if (invitee._cachedId == null) {
          break label381;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(invitee._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasSentTime) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasInvitationType) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasCustomMessage) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasMailboxItemId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(mailboxItemId);
      }
      __sizeOfObject = i;
      return i;
      i += fromMember.getSerializedSize();
      break;
      label368:
      i += toMember.getSerializedSize();
      break label229;
      label381:
      i += invitee.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i6 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    label92:
    int i1;
    label108:
    int i2;
    label124:
    int i3;
    label140:
    int i7;
    int i4;
    if (toMemberId != null)
    {
      i = toMemberId.hashCode();
      if (message == null) {
        break label279;
      }
      j = message.hashCode();
      if (entityUrn == null) {
        break label284;
      }
      k = entityUrn.hashCode();
      if (sharedSecret == null) {
        break label289;
      }
      m = sharedSecret.hashCode();
      if (fromMemberId == null) {
        break label295;
      }
      n = fromMemberId.hashCode();
      if (fromMember == null) {
        break label301;
      }
      i1 = fromMember.hashCode();
      if (toMember == null) {
        break label307;
      }
      i2 = toMember.hashCode();
      if (invitee == null) {
        break label313;
      }
      i3 = invitee.hashCode();
      i7 = (int)(sentTime ^ sentTime >>> 32);
      if (invitationType == null) {
        break label319;
      }
      i4 = invitationType.hashCode();
      label171:
      if (!customMessage) {
        break label325;
      }
    }
    label279:
    label284:
    label289:
    label295:
    label301:
    label307:
    label313:
    label319:
    label325:
    for (int i5 = 1;; i5 = 0)
    {
      if (mailboxItemId != null) {
        i6 = mailboxItemId.hashCode();
      }
      i = (i5 + (i4 + ((i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i7) * 31) * 31) * 31 + i6;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label92;
      i1 = 0;
      break label108;
      i2 = 0;
      break label124;
      i3 = 0;
      break label140;
      i4 = 0;
      break label171;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Invitation");
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
    label164:
    label198:
    label224:
    label250:
    label310:
    label370:
    label430:
    label454:
    label483:
    label507:
    label516:
    label585:
    label595:
    label605:
    label615:
    label625:
    label650:
    label660:
    label685:
    label695:
    label720:
    label730:
    label740:
    label750:
    label756:
    label766:
    label774:
    label776:
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
        localByteBuffer.putInt(1351128300);
        if (hasToMemberId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, toMemberId);
          if (!hasMessage) {
            break label585;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, message);
          if (!hasEntityUrn) {
            break label595;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasSharedSecret) {
            break label605;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, sharedSecret);
          if (!hasFromMemberId) {
            break label615;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, fromMemberId);
          if (!hasFromMember) {
            break label650;
          }
          localByteBuffer.put((byte)1);
          if (fromMember._cachedId == null) {
            break label625;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, fromMember._cachedId);
          fromMember.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasToMember) {
            break label685;
          }
          localByteBuffer.put((byte)1);
          if (toMember._cachedId == null) {
            break label660;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, toMember._cachedId);
          toMember.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasInvitee) {
            break label720;
          }
          localByteBuffer.put((byte)1);
          if (invitee._cachedId == null) {
            break label695;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, invitee._cachedId);
          invitee.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSentTime) {
            break label730;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(sentTime);
          if (!hasInvitationType) {
            break label740;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, invitationType.ordinal());
          if (!hasCustomMessage) {
            break label756;
          }
          localByteBuffer.put((byte)1);
          if (!customMessage) {
            break label750;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasMailboxItemId) {
            break label766;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, mailboxItemId);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label774;
          }
          if (str != null) {
            break label776;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label164;
          localByteBuffer.put((byte)0);
          break label198;
          localByteBuffer.put((byte)0);
          break label224;
          localByteBuffer.put((byte)0);
          break label250;
          localByteBuffer.put((byte)1);
          fromMember.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label310;
          localByteBuffer.put((byte)0);
          break label310;
          localByteBuffer.put((byte)1);
          toMember.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label370;
          localByteBuffer.put((byte)0);
          break label370;
          localByteBuffer.put((byte)1);
          invitee.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label430;
          localByteBuffer.put((byte)0);
          break label430;
          localByteBuffer.put((byte)0);
          break label454;
          localByteBuffer.put((byte)0);
          break label483;
          i = 0;
          break label507;
          localByteBuffer.put((byte)0);
          break label516;
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
  
  public static final class Invitee
    implements FissileDataModel<Invitee>, UnionTemplate<Invitee>
  {
    public static final InvitationBuilder.InviteeBuilder BUILDER = InvitationBuilder.InviteeBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final EmailInvitee emailInviteeValue;
    public final boolean hasEmailInviteeValue;
    public final boolean hasPhoneInviteeValue;
    public final boolean hasProfileInviteeValue;
    public final PhoneInvitee phoneInviteeValue;
    public final ProfileInvitee profileInviteeValue;
    
    Invitee(ProfileInvitee paramProfileInvitee, EmailInvitee paramEmailInvitee, PhoneInvitee paramPhoneInvitee, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      profileInviteeValue = paramProfileInvitee;
      emailInviteeValue = paramEmailInvitee;
      phoneInviteeValue = paramPhoneInvitee;
      hasProfileInviteeValue = paramBoolean1;
      hasEmailInviteeValue = paramBoolean2;
      hasPhoneInviteeValue = paramBoolean3;
      _cachedId = null;
    }
    
    public final Invitee accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      label56:
      Object localObject3;
      boolean bool2;
      if (hasProfileInviteeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.relationships.invitation.ProfileInvitee");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = profileInviteeValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label205;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasEmailInviteeValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.relationships.invitation.EmailInvitee");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label214;
          }
          localObject1 = emailInviteeValue.accept(paramDataProcessor);
          label95:
          if (localObject1 == null) {
            break label232;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        label106:
        localObject1 = null;
        bool3 = false;
        if (hasPhoneInviteeValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.relationships.invitation.PhoneInvitee");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label241;
          }
          localObject1 = phoneInviteeValue.accept(paramDataProcessor);
          label146:
          if (localObject1 == null) {
            break label259;
          }
        }
      }
      label205:
      label214:
      label232:
      label241:
      label259:
      for (boolean bool3 = true;; bool3 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label265;
        }
        return new Invitee((ProfileInvitee)localObject2, (EmailInvitee)localObject3, (PhoneInvitee)localObject1, bool1, bool2, bool3);
        localObject1 = (ProfileInvitee)paramDataProcessor.processDataTemplate(profileInviteeValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (EmailInvitee)paramDataProcessor.processDataTemplate(emailInviteeValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (PhoneInvitee)paramDataProcessor.processDataTemplate(phoneInviteeValue);
        break label146;
      }
      label265:
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
        paramObject = (Invitee)paramObject;
        if (profileInviteeValue != null)
        {
          if (profileInviteeValue.equals(profileInviteeValue)) {}
        }
        else {
          while (profileInviteeValue != null) {
            return false;
          }
        }
        if (emailInviteeValue != null)
        {
          if (emailInviteeValue.equals(emailInviteeValue)) {}
        }
        else {
          while (emailInviteeValue != null) {
            return false;
          }
        }
        if (phoneInviteeValue == null) {
          break;
        }
      } while (phoneInviteeValue.equals(phoneInviteeValue));
      for (;;)
      {
        return false;
        if (phoneInviteeValue == null) {
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
      if (hasProfileInviteeValue)
      {
        if (profileInviteeValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(profileInviteeValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasEmailInviteeValue)
        {
          i = j + 1;
          if (emailInviteeValue._cachedId == null) {
            break label156;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(emailInviteeValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasPhoneInviteeValue)
        {
          i = j + 1;
          if (phoneInviteeValue._cachedId == null) {
            break label169;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(phoneInviteeValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = profileInviteeValue.getSerializedSize() + 7;
        break;
        label156:
        i += emailInviteeValue.getSerializedSize();
        break label93;
        label169:
        i += phoneInviteeValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int k = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      int i;
      if (profileInviteeValue != null)
      {
        i = profileInviteeValue.hashCode();
        if (emailInviteeValue == null) {
          break label87;
        }
      }
      label87:
      for (int j = emailInviteeValue.hashCode();; j = 0)
      {
        if (phoneInviteeValue != null) {
          k = phoneInviteeValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Invitee");
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
      label358:
      label383:
      label393:
      label418:
      label426:
      label428:
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
          localByteBuffer.putInt(998487244);
          if (hasProfileInviteeValue)
          {
            localByteBuffer.put((byte)1);
            if (profileInviteeValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, profileInviteeValue._cachedId);
              profileInviteeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasEmailInviteeValue) {
                break label383;
              }
              localByteBuffer.put((byte)1);
              if (emailInviteeValue._cachedId == null) {
                break label358;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, emailInviteeValue._cachedId);
              emailInviteeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasPhoneInviteeValue) {
                break label418;
              }
              localByteBuffer.put((byte)1);
              if (phoneInviteeValue._cachedId == null) {
                break label393;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, phoneInviteeValue._cachedId);
              phoneInviteeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label426;
            }
            if (str != null) {
              break label428;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            profileInviteeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            emailInviteeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            phoneInviteeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */