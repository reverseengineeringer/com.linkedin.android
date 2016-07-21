package com.linkedin.android.pegasus.gen.voyager.entities.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class PagingInfo$Builder
  implements RecordTemplateBuilder<PagingInfo>
{
  public int count = 0;
  public boolean hasCount = false;
  public boolean hasStart = false;
  private boolean hasTotal = false;
  public int start = 0;
  private int total = 0;
  
  public final PagingInfo build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PagingInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new PagingInfo(start, count, total, hasStart, hasCount, hasTotal);
      if (!hasStart) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo", "start");
      }
    } while (hasCount);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo", "count");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */