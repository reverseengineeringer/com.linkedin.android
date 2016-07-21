package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class GridPosition$Builder
  implements RecordTemplateBuilder<GridPosition>
{
  private int column = 0;
  private boolean hasColumn = false;
  private boolean hasRow = false;
  private int row = 0;
  
  public final GridPosition build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (GridPosition.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new GridPosition(row, column, hasRow, hasColumn);
      if (!hasRow) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.GridPosition", "row");
      }
    } while (hasColumn);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.GridPosition", "column");
  }
  
  public final Builder setColumn(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasColumn = false;
      column = 0;
      return this;
    }
    hasColumn = true;
    column = paramInteger.intValue();
    return this;
  }
  
  public final Builder setRow(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasRow = false;
      row = 0;
      return this;
    }
    hasRow = true;
    row = paramInteger.intValue();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.GridPosition.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */