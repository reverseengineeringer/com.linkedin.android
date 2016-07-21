package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.IM;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class RawContact$Builder
  implements RecordTemplateBuilder<RawContact>
{
  public List<Address> addresses = null;
  public boolean bookmarked = false;
  private Date bornOn = null;
  public List<Email> emails = null;
  public String firstName = null;
  public String fullName = null;
  public boolean hasAddresses = false;
  public boolean hasBookmarked = false;
  private boolean hasBornOn = false;
  public boolean hasEmails = false;
  public boolean hasFirstName = false;
  public boolean hasFullName = false;
  public boolean hasInstantMessageHandles = false;
  public boolean hasLastName = false;
  public boolean hasMiddleName = false;
  public boolean hasNotes = false;
  public boolean hasPhoneNumbers = false;
  public boolean hasSites = false;
  public boolean hasTitle = false;
  public List<IM> instantMessageHandles = null;
  public String lastName = null;
  public String middleName = null;
  public String notes = null;
  public List<PhoneNumber> phoneNumbers = null;
  public List<Site> sites = null;
  public String title = null;
  
  public final RawContact build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (RawContact.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (emails != null)
    {
      paramFlavor = emails.iterator();
      do
      {
        if (!paramFlavor.hasNext()) {
          break;
        }
      } while ((Email)paramFlavor.next() != null);
      throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "emails");
      if (!hasEmails) {
        emails = Collections.emptyList();
      }
      if (!hasPhoneNumbers) {
        phoneNumbers = Collections.emptyList();
      }
      if (!hasInstantMessageHandles) {
        instantMessageHandles = Collections.emptyList();
      }
      if (!hasAddresses) {
        addresses = Collections.emptyList();
      }
      if (!hasSites) {
        sites = Collections.emptyList();
      }
      if (!hasBookmarked) {
        bookmarked = false;
      }
    }
    if (phoneNumbers != null)
    {
      paramFlavor = phoneNumbers.iterator();
      while (paramFlavor.hasNext()) {
        if ((PhoneNumber)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "phoneNumbers");
        }
      }
    }
    if (instantMessageHandles != null)
    {
      paramFlavor = instantMessageHandles.iterator();
      while (paramFlavor.hasNext()) {
        if ((IM)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "instantMessageHandles");
        }
      }
    }
    if (addresses != null)
    {
      paramFlavor = addresses.iterator();
      while (paramFlavor.hasNext()) {
        if ((Address)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "addresses");
        }
      }
    }
    if (sites != null)
    {
      paramFlavor = sites.iterator();
      while (paramFlavor.hasNext()) {
        if ((Site)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "sites");
        }
      }
    }
    return new RawContact(fullName, firstName, lastName, middleName, title, emails, phoneNumbers, instantMessageHandles, addresses, bornOn, sites, bookmarked, notes, hasFullName, hasFirstName, hasLastName, hasMiddleName, hasTitle, hasEmails, hasPhoneNumbers, hasInstantMessageHandles, hasAddresses, hasBornOn, hasSites, hasBookmarked, hasNotes);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */