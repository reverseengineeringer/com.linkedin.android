package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class GridPosition
  implements RecordTemplate<GridPosition>
{
  public static final GridPositionBuilder BUILDER = GridPositionBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final int column;
  public final boolean hasColumn;
  public final boolean hasRow;
  public final int row;
  
  GridPosition(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    row = paramInt1;
    column = paramInt2;
    hasRow = paramBoolean1;
    hasColumn = paramBoolean2;
    _cachedId = null;
  }
  
  public final GridPosition accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasRow)
    {
      paramDataProcessor.startRecordField$505cff1c("row");
      paramDataProcessor.processInt(row);
    }
    if (hasColumn)
    {
      paramDataProcessor.startRecordField$505cff1c("column");
      paramDataProcessor.processInt(column);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasRow) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.GridPosition", "row");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasColumn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.GridPosition", "column");
      }
      return new GridPosition(row, column, hasRow, hasColumn);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (GridPosition)paramObject;
      if (row != row) {
        return false;
      }
    } while (column == column);
    return false;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i = (row + 527) * 31 + column;
    _cachedHashCode = i;
    return i;
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.GridPosition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */