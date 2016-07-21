package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class DateRange$Builder
  implements RecordTemplateBuilder<DateRange>
{
  private Date endDate = null;
  private boolean hasEndDate = false;
  private boolean hasStartDate = false;
  private Date startDate = null;
  
  public final DateRange build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    int[] arrayOfInt = DateRange.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
    paramFlavor.ordinal();
    return new DateRange(startDate, endDate, hasStartDate, hasEndDate);
  }
  
  public final Builder setEndDate(Date paramDate)
  {
    if (paramDate == null)
    {
      hasEndDate = false;
      endDate = null;
      return this;
    }
    hasEndDate = true;
    endDate = paramDate;
    return this;
  }
  
  public final Builder setStartDate(Date paramDate)
  {
    if (paramDate == null)
    {
      hasStartDate = false;
      startDate = null;
      return this;
    }
    hasStartDate = true;
    startDate = paramDate;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.DateRange.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */