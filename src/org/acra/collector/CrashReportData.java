package org.acra.collector;

import java.util.EnumMap;
import org.acra.ReportField;

public final class CrashReportData
  extends EnumMap<ReportField, String>
{
  public CrashReportData()
  {
    super(ReportField.class);
  }
  
  public final String getProperty(ReportField paramReportField)
  {
    return (String)super.get(paramReportField);
  }
}

/* Location:
 * Qualified Name:     org.acra.collector.CrashReportData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */