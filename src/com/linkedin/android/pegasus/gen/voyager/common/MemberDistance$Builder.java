package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class MemberDistance$Builder
  implements RecordTemplateBuilder<MemberDistance>
{
  public boolean hasValue = false;
  public GraphDistance value = null;
  
  public final MemberDistance build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MemberDistance.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MemberDistance(value, hasValue);
    } while (hasValue);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.MemberDistance", "value");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.MemberDistance.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */