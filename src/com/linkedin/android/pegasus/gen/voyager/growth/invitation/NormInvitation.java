package com.linkedin.android.pegasus.gen.voyager.growth.invitation;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
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

public final class NormInvitation
  implements FissileDataModel<NormInvitation>, RecordTemplate<NormInvitation>
{
  public static final NormInvitationBuilder BUILDER = NormInvitationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasInvitee;
  public final boolean hasMessage;
  public final boolean hasTrackingId;
  public final boolean hasUploadTransactionId;
  public final Invitee invitee;
  public final String message;
  public final String trackingId;
  public final String uploadTransactionId;
  
  NormInvitation(String paramString1, Invitee paramInvitee, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    trackingId = paramString1;
    invitee = paramInvitee;
    message = paramString2;
    uploadTransactionId = paramString3;
    hasTrackingId = paramBoolean1;
    hasInvitee = paramBoolean2;
    hasMessage = paramBoolean3;
    hasUploadTransactionId = paramBoolean4;
    _cachedId = null;
  }
  
  private NormInvitation accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      paramDataProcessor.processString(trackingId);
    }
    Invitee localInvitee = null;
    boolean bool = false;
    if (hasInvitee)
    {
      paramDataProcessor.startRecordField$505cff1c("invitee");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label168;
      }
      localInvitee = invitee.accept(paramDataProcessor);
      if (localInvitee == null) {
        break label185;
      }
    }
    label168:
    label185:
    for (bool = true;; bool = false)
    {
      if (hasMessage)
      {
        paramDataProcessor.startRecordField$505cff1c("message");
        paramDataProcessor.processString(message);
      }
      if (hasUploadTransactionId)
      {
        paramDataProcessor.startRecordField$505cff1c("uploadTransactionId");
        paramDataProcessor.processString(uploadTransactionId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label243;
      }
      try
      {
        if (hasTrackingId) {
          break label190;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation", "trackingId");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localInvitee = (Invitee)paramDataProcessor.processDataTemplate(invitee);
      break;
    }
    label190:
    if (!hasInvitee) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation", "invitee");
    }
    return new NormInvitation(trackingId, localInvitee, message, uploadTransactionId, hasTrackingId, bool, hasMessage, hasUploadTransactionId);
    label243:
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
      paramObject = (NormInvitation)paramObject;
      if (invitee != null)
      {
        if (invitee.equals(invitee)) {}
      }
      else {
        while (invitee != null) {
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
      if (uploadTransactionId == null) {
        break;
      }
    } while (uploadTransactionId.equals(uploadTransactionId));
    for (;;)
    {
      return false;
      if (uploadTransactionId == null) {
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
    if (hasInvitee)
    {
      i = j + 1;
      if (invitee._cachedId == null) {
        break label137;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(invitee._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasMessage) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(message);
      }
      j = i + 1;
      i = j;
      if (hasUploadTransactionId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(uploadTransactionId);
      }
      __sizeOfObject = i;
      return i;
      label137:
      i += invitee.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (invitee != null)
    {
      i = invitee.hashCode();
      if (message == null) {
        break label87;
      }
    }
    label87:
    for (int j = message.hashCode();; j = 0)
    {
      if (uploadTransactionId != null) {
        k = uploadTransactionId.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NormInvitation");
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
    label196:
    label222:
    label291:
    label316:
    label326:
    label336:
    label344:
    label346:
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
        localByteBuffer.putInt(-846357442);
        if (hasTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasInvitee) {
            break label316;
          }
          localByteBuffer.put((byte)1);
          if (invitee._cachedId == null) {
            break label291;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, invitee._cachedId);
          invitee.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasMessage) {
            break label326;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, message);
          if (!hasUploadTransactionId) {
            break label336;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, uploadTransactionId);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label344;
          }
          if (str != null) {
            break label346;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          invitee.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label196;
          localByteBuffer.put((byte)0);
          break label196;
          localByteBuffer.put((byte)0);
          break label222;
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
    implements RecordTemplateBuilder<NormInvitation>
  {
    private boolean hasInvitee = false;
    private boolean hasMessage = false;
    private boolean hasTrackingId = false;
    private boolean hasUploadTransactionId = false;
    private NormInvitation.Invitee invitee = null;
    private String message = null;
    private String trackingId = null;
    private String uploadTransactionId = null;
    
    public final NormInvitation build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (NormInvitation.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new NormInvitation(trackingId, invitee, message, uploadTransactionId, hasTrackingId, hasInvitee, hasMessage, hasUploadTransactionId);
        if (!hasTrackingId) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation", "trackingId");
        }
      } while (hasInvitee);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation", "invitee");
    }
    
    public final Builder setInvitee(NormInvitation.Invitee paramInvitee)
    {
      if (paramInvitee == null)
      {
        hasInvitee = false;
        invitee = null;
        return this;
      }
      hasInvitee = true;
      invitee = paramInvitee;
      return this;
    }
    
    public final Builder setMessage(String paramString)
    {
      if (paramString == null)
      {
        hasMessage = false;
        message = null;
        return this;
      }
      hasMessage = true;
      message = paramString;
      return this;
    }
    
    public final Builder setTrackingId(String paramString)
    {
      if (paramString == null)
      {
        hasTrackingId = false;
        trackingId = null;
        return this;
      }
      hasTrackingId = true;
      trackingId = paramString;
      return this;
    }
  }
  
  public static final class Invitee
    implements FissileDataModel<Invitee>, UnionTemplate<Invitee>
  {
    public static final NormInvitationBuilder.InviteeBuilder BUILDER = NormInvitationBuilder.InviteeBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasInviteeEmailValue;
    public final boolean hasInviteePhoneValue;
    public final boolean hasInviteeProfileValue;
    public final InviteeEmail inviteeEmailValue;
    public final InviteePhone inviteePhoneValue;
    public final InviteeProfile inviteeProfileValue;
    
    Invitee(InviteeProfile paramInviteeProfile, InviteeEmail paramInviteeEmail, InviteePhone paramInviteePhone, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      inviteeProfileValue = paramInviteeProfile;
      inviteeEmailValue = paramInviteeEmail;
      inviteePhoneValue = paramInviteePhone;
      hasInviteeProfileValue = paramBoolean1;
      hasInviteeEmailValue = paramBoolean2;
      hasInviteePhoneValue = paramBoolean3;
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
      if (hasInviteeProfileValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.growth.invitation.InviteeProfile");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = inviteeProfileValue.accept(paramDataProcessor);
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
        if (hasInviteeEmailValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.growth.invitation.InviteeEmail");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label214;
          }
          localObject1 = inviteeEmailValue.accept(paramDataProcessor);
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
        if (hasInviteePhoneValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.growth.invitation.InviteePhone");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label241;
          }
          localObject1 = inviteePhoneValue.accept(paramDataProcessor);
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
        return new Invitee((InviteeProfile)localObject2, (InviteeEmail)localObject3, (InviteePhone)localObject1, bool1, bool2, bool3);
        localObject1 = (InviteeProfile)paramDataProcessor.processDataTemplate(inviteeProfileValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (InviteeEmail)paramDataProcessor.processDataTemplate(inviteeEmailValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (InviteePhone)paramDataProcessor.processDataTemplate(inviteePhoneValue);
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
        if (inviteeProfileValue != null)
        {
          if (inviteeProfileValue.equals(inviteeProfileValue)) {}
        }
        else {
          while (inviteeProfileValue != null) {
            return false;
          }
        }
        if (inviteeEmailValue != null)
        {
          if (inviteeEmailValue.equals(inviteeEmailValue)) {}
        }
        else {
          while (inviteeEmailValue != null) {
            return false;
          }
        }
        if (inviteePhoneValue == null) {
          break;
        }
      } while (inviteePhoneValue.equals(inviteePhoneValue));
      for (;;)
      {
        return false;
        if (inviteePhoneValue == null) {
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
      if (hasInviteeProfileValue)
      {
        if (inviteeProfileValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(inviteeProfileValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasInviteeEmailValue)
        {
          i = j + 1;
          if (inviteeEmailValue._cachedId == null) {
            break label156;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(inviteeEmailValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasInviteePhoneValue)
        {
          i = j + 1;
          if (inviteePhoneValue._cachedId == null) {
            break label169;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(inviteePhoneValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = inviteeProfileValue.getSerializedSize() + 7;
        break;
        label156:
        i += inviteeEmailValue.getSerializedSize();
        break label93;
        label169:
        i += inviteePhoneValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int k = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      int i;
      if (inviteeProfileValue != null)
      {
        i = inviteeProfileValue.hashCode();
        if (inviteeEmailValue == null) {
          break label87;
        }
      }
      label87:
      for (int j = inviteeEmailValue.hashCode();; j = 0)
      {
        if (inviteePhoneValue != null) {
          k = inviteePhoneValue.hashCode();
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
          localByteBuffer.putInt(-1043732677);
          if (hasInviteeProfileValue)
          {
            localByteBuffer.put((byte)1);
            if (inviteeProfileValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, inviteeProfileValue._cachedId);
              inviteeProfileValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasInviteeEmailValue) {
                break label383;
              }
              localByteBuffer.put((byte)1);
              if (inviteeEmailValue._cachedId == null) {
                break label358;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, inviteeEmailValue._cachedId);
              inviteeEmailValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasInviteePhoneValue) {
                break label418;
              }
              localByteBuffer.put((byte)1);
              if (inviteePhoneValue._cachedId == null) {
                break label393;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, inviteePhoneValue._cachedId);
              inviteePhoneValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            inviteeProfileValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            inviteeEmailValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            inviteePhoneValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
      private boolean hasInviteeEmailValue = false;
      private boolean hasInviteePhoneValue = false;
      private boolean hasInviteeProfileValue = false;
      private InviteeEmail inviteeEmailValue = null;
      private InviteePhone inviteePhoneValue = null;
      private InviteeProfile inviteeProfileValue = null;
      
      public final NormInvitation.Invitee build()
        throws BuilderException
      {
        int j = 0;
        if (hasInviteeProfileValue) {
          j = 0 + 1;
        }
        int i = j;
        if (hasInviteeEmailValue) {
          i = j + 1;
        }
        j = i;
        if (hasInviteePhoneValue) {
          j = i + 1;
        }
        if (j > 1) {
          throw new UnionMemberCountException("Invitee", j);
        }
        return new NormInvitation.Invitee(inviteeProfileValue, inviteeEmailValue, inviteePhoneValue, hasInviteeProfileValue, hasInviteeEmailValue, hasInviteePhoneValue);
      }
      
      public final Builder setInviteeEmailValue(InviteeEmail paramInviteeEmail)
      {
        if (paramInviteeEmail == null)
        {
          hasInviteeEmailValue = false;
          inviteeEmailValue = null;
          return this;
        }
        hasInviteeEmailValue = true;
        inviteeEmailValue = paramInviteeEmail;
        return this;
      }
      
      public final Builder setInviteePhoneValue(InviteePhone paramInviteePhone)
      {
        if (paramInviteePhone == null)
        {
          hasInviteePhoneValue = false;
          inviteePhoneValue = null;
          return this;
        }
        hasInviteePhoneValue = true;
        inviteePhoneValue = paramInviteePhone;
        return this;
      }
      
      public final Builder setInviteeProfileValue(InviteeProfile paramInviteeProfile)
      {
        if (paramInviteeProfile == null)
        {
          hasInviteeProfileValue = false;
          inviteeProfileValue = null;
          return this;
        }
        hasInviteeProfileValue = true;
        inviteeProfileValue = paramInviteeProfile;
        return this;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */