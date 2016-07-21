package com.linkedin.android.pegasus.gen.voyager.messaging.create.message;

import com.linkedin.android.pegasus.gen.voyager.messaging.shared.ContactInfo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class InmailContentCreate$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.message.InmailContentCreate.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */