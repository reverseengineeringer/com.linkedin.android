package com.linkedin.gen.avro2pegasus.events.me;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class WvmpProfileViewImpression$Builder
  implements RecordTemplateBuilder<WvmpProfileViewImpression>
{
  public long duration = 0L;
  public boolean hasDuration = false;
  public boolean hasInsight = false;
  public boolean hasListPosition = false;
  public boolean hasProfileView = false;
  public boolean hasRenderedTime = false;
  public boolean hasSize = false;
  public TrackingObject insight = null;
  public ListPosition listPosition = null;
  public TrackingObject profileView = null;
  public long renderedTime = 0L;
  public EntityDimension size = null;
  
  public final WvmpProfileViewImpression build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (WvmpProfileViewImpression.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new WvmpProfileViewImpression(profileView, listPosition, renderedTime, duration, size, insight, hasProfileView, hasListPosition, hasRenderedTime, hasDuration, hasSize, hasInsight);
      if (!hasProfileView) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewImpression", "profileView");
      }
      if (!hasRenderedTime) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewImpression", "renderedTime");
      }
      if (!hasDuration) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewImpression", "duration");
      }
    } while (hasSize);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewImpression", "size");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewImpression.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */