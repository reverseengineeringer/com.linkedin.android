package com.linkedin.android.pegasus.gen.voyager.relationships.invitation;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Invitation$Invitee
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
  
  Invitation$Invitee(ProfileInvitee paramProfileInvitee, EmailInvitee paramEmailInvitee, PhoneInvitee paramPhoneInvitee, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
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

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation.Invitee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */