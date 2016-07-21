package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ContactsUploadContactsRequest$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.ContactsUploadContactsRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */