package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ImportedContacts$Builder
  implements RecordTemplateBuilder<ImportedContacts>
{
  public List<GuestContact> guestContacts = null;
  public boolean hasGuestContacts = false;
  public boolean hasMemberContacts = false;
  private boolean hasTrackingId = false;
  public List<MemberContact> memberContacts = null;
  private String trackingId = null;
  
  public final ImportedContacts build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ImportedContacts.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (memberContacts != null)
    {
      paramFlavor = memberContacts.iterator();
      do
      {
        if (!paramFlavor.hasNext()) {
          break;
        }
      } while ((MemberContact)paramFlavor.next() != null);
      throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts", "memberContacts");
      if (!hasMemberContacts) {
        memberContacts = Collections.emptyList();
      }
      if (!hasGuestContacts) {
        guestContacts = Collections.emptyList();
      }
    }
    if (guestContacts != null)
    {
      paramFlavor = guestContacts.iterator();
      while (paramFlavor.hasNext()) {
        if ((GuestContact)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts", "guestContacts");
        }
      }
    }
    return new ImportedContacts(memberContacts, guestContacts, trackingId, hasMemberContacts, hasGuestContacts, hasTrackingId);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */