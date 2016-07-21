package com.linkedin.gen.avro2pegasus.events.rbmf;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class RecommendedEntity$Builder
  implements RecordTemplateBuilder<RecommendedEntity>
{
  public TrackingObject entity = null;
  public int entityPosition = 0;
  public boolean hasEntity = false;
  public boolean hasEntityPosition = false;
  private boolean hasIsFollowing = false;
  private boolean isFollowing = false;
  
  public final RecommendedEntity build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (RecommendedEntity.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new RecommendedEntity(entity, entityPosition, isFollowing, hasEntity, hasEntityPosition, hasIsFollowing);
      if (!hasEntity) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.RecommendedEntity", "entity");
      }
    } while (hasEntityPosition);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.RecommendedEntity", "entityPosition");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.rbmf.RecommendedEntity.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */