package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class EntityView$Builder
  implements RecordTemplateBuilder<EntityView>
{
  public boolean hasTargetId = false;
  public boolean hasViewType = false;
  public boolean hasViewerId = false;
  public int targetId = 0;
  public String viewType = null;
  public int viewerId = 0;
  
  public final EntityView build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (EntityView.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new EntityView(viewType, viewerId, targetId, hasViewType, hasViewerId, hasTargetId);
      if (!hasViewType) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.EntityView", "viewType");
      }
    } while (hasTargetId);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.EntityView", "targetId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.EntityView.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */