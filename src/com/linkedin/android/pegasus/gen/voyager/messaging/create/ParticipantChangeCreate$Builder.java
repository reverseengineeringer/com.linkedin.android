package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class ParticipantChangeCreate$Builder
  implements RecordTemplateBuilder<ParticipantChangeCreate>
{
  public List<String> addParticipants = null;
  public boolean hasAddParticipants = false;
  public boolean hasRemoveParticipants = false;
  public boolean hasShowHistory = false;
  public List<String> removeParticipants = null;
  public boolean showHistory = false;
  
  private ParticipantChangeCreate build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ParticipantChangeCreate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (addParticipants != null)
    {
      paramFlavor = addParticipants.iterator();
      do
      {
        if (!paramFlavor.hasNext()) {
          break;
        }
      } while ((String)paramFlavor.next() != null);
      throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ParticipantChangeCreate", "addParticipants");
      if (!hasShowHistory) {
        showHistory = false;
      }
    }
    if (removeParticipants != null)
    {
      paramFlavor = removeParticipants.iterator();
      while (paramFlavor.hasNext()) {
        if ((String)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ParticipantChangeCreate", "removeParticipants");
        }
      }
    }
    return new ParticipantChangeCreate(addParticipants, showHistory, removeParticipants, hasAddParticipants, hasShowHistory, hasRemoveParticipants);
  }
  
  public final ParticipantChangeCreate build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.ParticipantChangeCreate.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */