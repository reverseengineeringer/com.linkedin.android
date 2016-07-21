package com.linkedin.android.pegasus.gen.voyager.growth.goal;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Goal$Builder
  implements RecordTemplateBuilder<Goal>
{
  private Urn entityUrn = null;
  public GoalType goalType = null;
  private boolean hasEntityUrn = false;
  public boolean hasGoalType = false;
  
  public final Goal build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Goal.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new Goal(entityUrn, goalType, hasEntityUrn, hasGoalType);
      if (!hasEntityUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.goal.Goal", "entityUrn");
      }
    } while (hasGoalType);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.goal.Goal", "goalType");
  }
  
  public final Builder setEntityUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasEntityUrn = false;
      entityUrn = null;
      return this;
    }
    hasEntityUrn = true;
    entityUrn = paramUrn;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.goal.Goal.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */