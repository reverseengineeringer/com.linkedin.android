package com.linkedin.gen.avro2pegasus.events.mentions;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;

public final class MentionResultHit$Builder
  implements RecordTemplateBuilder<MentionResultHit>
{
  public String entityUrn = null;
  public boolean hasEntityUrn = false;
  public boolean hasIsCacheHit = false;
  public boolean hasPosition = false;
  public boolean isCacheHit = false;
  public ListPosition position = null;
  
  public final MentionResultHit build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MentionResultHit.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MentionResultHit(entityUrn, position, isCacheHit, hasEntityUrn, hasPosition, hasIsCacheHit);
      if (!hasIsCacheHit) {
        isCacheHit = false;
      }
      if (!hasEntityUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionResultHit", "entityUrn");
      }
    } while (hasPosition);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionResultHit", "position");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mentions.MentionResultHit.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */