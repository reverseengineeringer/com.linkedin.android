package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class RTAFeedback$Builder
  implements RecordTemplateBuilder<RTAFeedback>
{
  public String feedback = null;
  public boolean hasFeedback = false;
  
  public final RTAFeedback build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (RTAFeedback.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new RTAFeedback(feedback, hasFeedback);
    } while (hasFeedback);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.RTAFeedback", "feedback");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.RTAFeedback.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */