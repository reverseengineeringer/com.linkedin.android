package com.linkedin.android.pegasus.gen.voyager.messaging.create.message;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.messaging.shared.ContactInfo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class InmailContentCreate
  implements FissileDataModel<InmailContentCreate>, RecordTemplate<InmailContentCreate>
{
  public static final InmailContentCreateBuilder BUILDER = InmailContentCreateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final InmailAction action;
  public final ContactInfo contactInfo;
  public final boolean hasAction;
  public final boolean hasContactInfo;
  
  InmailContentCreate(ContactInfo paramContactInfo, InmailAction paramInmailAction, boolean paramBoolean1, boolean paramBoolean2)
  {
    contactInfo = paramContactInfo;
    action = paramInmailAction;
    hasContactInfo = paramBoolean1;
    hasAction = paramBoolean2;
    _cachedId = null;
  }
  
  public final InmailContentCreate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    ContactInfo localContactInfo = null;
    boolean bool = false;
    if (hasContactInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("contactInfo");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label107;
      }
      localContactInfo = contactInfo.accept(paramDataProcessor);
      if (localContactInfo == null) {
        break label124;
      }
    }
    label107:
    label124:
    for (bool = true;; bool = false)
    {
      if (hasAction)
      {
        paramDataProcessor.startRecordField$505cff1c("action");
        paramDataProcessor.processEnum(action);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label129;
      }
      return new InmailContentCreate(localContactInfo, action, bool, hasAction);
      localContactInfo = (ContactInfo)paramDataProcessor.processDataTemplate(contactInfo);
      break;
    }
    label129:
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
      paramObject = (InmailContentCreate)paramObject;
      if (contactInfo != null)
      {
        if (contactInfo.equals(contactInfo)) {}
      }
      else {
        while (contactInfo != null) {
          return false;
        }
      }
      if (action == null) {
        break;
      }
    } while (action.equals(action));
    for (;;)
    {
      return false;
      if (action == null) {
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
    if (hasContactInfo) {
      if (contactInfo._cachedId == null) {
        break label75;
      }
    }
    label75:
    for (i = PegasusBinaryUtils.getEncodedLength(contactInfo._cachedId) + 9;; i = contactInfo.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasAction) {
        i = j + 2;
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (contactInfo != null) {}
    for (int i = contactInfo.hashCode();; i = 0)
    {
      if (action != null) {
        j = action.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building InmailContentCreate");
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
    label267:
    label275:
    label277:
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
        localByteBuffer.putInt(695026699);
        if (hasContactInfo)
        {
          localByteBuffer.put((byte)1);
          if (contactInfo._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, contactInfo._cachedId);
            contactInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAction) {
              break label267;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, action.ordinal());
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label275;
          }
          if (str != null) {
            break label277;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          contactInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
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
    implements RecordTemplateBuilder<InmailContentCreate>
  {
    public InmailAction action = null;
    private ContactInfo contactInfo = null;
    public boolean hasAction = false;
    private boolean hasContactInfo = false;
    
    public final InmailContentCreate build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      int[] arrayOfInt = InmailContentCreate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
      paramFlavor.ordinal();
      return new InmailContentCreate(contactInfo, action, hasContactInfo, hasAction);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.message.InmailContentCreate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */