package com.linkedin.android.pegasus.gen.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Date$Builder
  implements RecordTemplateBuilder<Date>
{
  private int day = 0;
  private boolean hasDay = false;
  private boolean hasMonth = false;
  private boolean hasYear = false;
  private int month = 0;
  private int year = 0;
  
  public final Date build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    int[] arrayOfInt = Date.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
    paramFlavor.ordinal();
    return new Date(day, month, year, hasDay, hasMonth, hasYear);
  }
  
  public final Builder setDay(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasDay = false;
      day = 0;
      return this;
    }
    hasDay = true;
    day = paramInteger.intValue();
    return this;
  }
  
  public final Builder setMonth(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasMonth = false;
      month = 0;
      return this;
    }
    hasMonth = true;
    month = paramInteger.intValue();
    return this;
  }
  
  public final Builder setYear(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasYear = false;
      year = 0;
      return this;
    }
    hasYear = true;
    year = paramInteger.intValue();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.common.Date.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */