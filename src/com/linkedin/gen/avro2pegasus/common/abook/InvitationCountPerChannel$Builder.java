package com.linkedin.gen.avro2pegasus.common.abook;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class InvitationCountPerChannel$Builder
  implements RecordTemplateBuilder<InvitationCountPerChannel>
{
  public int emailCount = 0;
  public boolean hasEmailCount = false;
  public boolean hasSmsCount = false;
  public int smsCount = 0;
  
  public final InvitationCountPerChannel build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (InvitationCountPerChannel.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new InvitationCountPerChannel(emailCount, smsCount, hasEmailCount, hasSmsCount);
      if (!hasEmailCount) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannel", "emailCount");
      }
    } while (hasSmsCount);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannel", "smsCount");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannel.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */