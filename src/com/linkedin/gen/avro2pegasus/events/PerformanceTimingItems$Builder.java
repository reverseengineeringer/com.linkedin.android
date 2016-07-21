package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class PerformanceTimingItems$Builder
  implements RecordTemplateBuilder<PerformanceTimingItems>
{
  public long functionDuration = 0L;
  public String functionName = null;
  public long functionStartTime = 0L;
  public boolean hasFunctionDuration = false;
  public boolean hasFunctionName = false;
  public boolean hasFunctionStartTime = false;
  
  public final PerformanceTimingItems build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PerformanceTimingItems.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new PerformanceTimingItems(functionName, functionStartTime, functionDuration, hasFunctionName, hasFunctionStartTime, hasFunctionDuration);
    } while (hasFunctionName);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.PerformanceTimingItems", "functionName");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.PerformanceTimingItems.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */