package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ContactsUploadContactsRequest
  implements FissileDataModel<ContactsUploadContactsRequest>, RecordTemplate<ContactsUploadContactsRequest>
{
  public static final ContactsUploadContactsRequestBuilder BUILDER = ContactsUploadContactsRequestBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String deviceCountryCode;
  public final boolean hasDeviceCountryCode;
  public final boolean hasRawContacts;
  public final boolean hasUploadTransactionId;
  public final List<RawContact> rawContacts;
  public final String uploadTransactionId;
  
  ContactsUploadContactsRequest(List<RawContact> paramList, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      rawContacts = paramList;
      uploadTransactionId = paramString1;
      deviceCountryCode = paramString2;
      hasRawContacts = paramBoolean1;
      hasUploadTransactionId = paramBoolean2;
      hasDeviceCountryCode = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  private ContactsUploadContactsRequest accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    RawContact localRawContact = null;
    boolean bool = false;
    if (hasRawContacts)
    {
      paramDataProcessor.startRecordField$505cff1c("rawContacts");
      rawContacts.size();
      paramDataProcessor.startArray$13462e();
      localObject = localRawContact;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = rawContacts.iterator();
      if (localIterator.hasNext())
      {
        localRawContact = (RawContact)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localRawContact = localRawContact.accept(paramDataProcessor);; localRawContact = (RawContact)paramDataProcessor.processDataTemplate(localRawContact))
        {
          if ((localObject != null) && (localRawContact != null)) {
            ((List)localObject).add(localRawContact);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label319;
      }
    }
    label319:
    for (bool = true;; bool = false)
    {
      if (hasUploadTransactionId)
      {
        paramDataProcessor.startRecordField$505cff1c("uploadTransactionId");
        paramDataProcessor.processString(uploadTransactionId);
      }
      if (hasDeviceCountryCode)
      {
        paramDataProcessor.startRecordField$505cff1c("deviceCountryCode");
        paramDataProcessor.processString(deviceCountryCode);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label351;
      }
      if (!hasRawContacts) {
        localObject = Collections.emptyList();
      }
      try
      {
        if (rawContacts == null) {
          break;
        }
        paramDataProcessor = rawContacts.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((RawContact)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.ContactsUploadContactsRequest", "rawContacts");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    return new ContactsUploadContactsRequest((List)localObject, uploadTransactionId, deviceCountryCode, bool, hasUploadTransactionId, hasDeviceCountryCode);
    label351:
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
      paramObject = (ContactsUploadContactsRequest)paramObject;
      if (rawContacts != null)
      {
        if (rawContacts.equals(rawContacts)) {}
      }
      else {
        while (rawContacts != null) {
          return false;
        }
      }
      if (uploadTransactionId != null)
      {
        if (uploadTransactionId.equals(uploadTransactionId)) {}
      }
      else {
        while (uploadTransactionId != null) {
          return false;
        }
      }
      if (deviceCountryCode == null) {
        break;
      }
    } while (deviceCountryCode.equals(deviceCountryCode));
    for (;;)
    {
      return false;
      if (deviceCountryCode == null) {
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
    int j = i;
    if (hasRawContacts)
    {
      i += 2;
      Iterator localIterator = rawContacts.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        RawContact localRawContact = (RawContact)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localRawContact.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasUploadTransactionId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(uploadTransactionId);
    }
    j = i + 1;
    i = j;
    if (hasDeviceCountryCode) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(deviceCountryCode);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (rawContacts != null)
    {
      i = rawContacts.hashCode();
      if (uploadTransactionId == null) {
        break label89;
      }
    }
    label89:
    for (int j = uploadTransactionId.hashCode();; j = 0)
    {
      if (deviceCountryCode != null) {
        k = deviceCountryCode.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ContactsUploadContactsRequest");
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
    label342:
    label350:
    label352:
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
        localByteBuffer.putInt(-524585634);
        if (hasRawContacts)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, rawContacts.size());
          Iterator localIterator = rawContacts.iterator();
          while (localIterator.hasNext())
          {
            RawContact localRawContact = (RawContact)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localRawContact.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localRawContact.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasUploadTransactionId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, uploadTransactionId);
          if (!hasDeviceCountryCode) {
            break label342;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, deviceCountryCode);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label350;
          }
          if (str != null) {
            break label352;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
    implements RecordTemplateBuilder<ContactsUploadContactsRequest>
  {
    private String deviceCountryCode = null;
    private boolean hasDeviceCountryCode = false;
    private boolean hasRawContacts = false;
    private boolean hasUploadTransactionId = false;
    private List<RawContact> rawContacts = null;
    private String uploadTransactionId = null;
    
    public final ContactsUploadContactsRequest build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ContactsUploadContactsRequest.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (rawContacts != null)
      {
        paramFlavor = rawContacts.iterator();
        do
        {
          if (!paramFlavor.hasNext()) {
            break;
          }
        } while ((RawContact)paramFlavor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.ContactsUploadContactsRequest", "rawContacts");
        if (!hasRawContacts) {
          rawContacts = Collections.emptyList();
        }
      }
      return new ContactsUploadContactsRequest(rawContacts, uploadTransactionId, deviceCountryCode, hasRawContacts, hasUploadTransactionId, hasDeviceCountryCode);
    }
    
    public final Builder setDeviceCountryCode(String paramString)
    {
      if (paramString == null)
      {
        hasDeviceCountryCode = false;
        deviceCountryCode = null;
        return this;
      }
      hasDeviceCountryCode = true;
      deviceCountryCode = paramString;
      return this;
    }
    
    public final Builder setRawContacts(List<RawContact> paramList)
    {
      if ((paramList == null) || (paramList.equals(Collections.emptyList())))
      {
        hasRawContacts = false;
        rawContacts = Collections.emptyList();
        return this;
      }
      hasRawContacts = true;
      rawContacts = paramList;
      return this;
    }
    
    public final Builder setUploadTransactionId(String paramString)
    {
      if (paramString == null)
      {
        hasUploadTransactionId = false;
        uploadTransactionId = null;
        return this;
      }
      hasUploadTransactionId = true;
      uploadTransactionId = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.ContactsUploadContactsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */