package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;

public final class HeadingsText
  implements RecordTemplate<HeadingsText>
{
  public static final HeadingsTextBuilder BUILDER = HeadingsTextBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final boolean hasHelpUnderstandThis;
  public final boolean hasWhatDoYouWantToDo;
  public final boolean hasWhyReportingThis;
  public final String helpUnderstandThis;
  public final String whatDoYouWantToDo;
  public final String whyReportingThis;
  
  HeadingsText(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    whyReportingThis = paramString1;
    helpUnderstandThis = paramString2;
    whatDoYouWantToDo = paramString3;
    hasWhyReportingThis = paramBoolean1;
    hasHelpUnderstandThis = paramBoolean2;
    hasWhatDoYouWantToDo = paramBoolean3;
  }
  
  public final HeadingsText accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasWhyReportingThis)
    {
      paramDataProcessor.startRecordField$505cff1c("whyReportingThis");
      paramDataProcessor.processString(whyReportingThis);
    }
    if (hasHelpUnderstandThis)
    {
      paramDataProcessor.startRecordField$505cff1c("helpUnderstandThis");
      paramDataProcessor.processString(helpUnderstandThis);
    }
    if (hasWhatDoYouWantToDo)
    {
      paramDataProcessor.startRecordField$505cff1c("whatDoYouWantToDo");
      paramDataProcessor.processString(whatDoYouWantToDo);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new HeadingsText(whyReportingThis, helpUnderstandThis, whatDoYouWantToDo, hasWhyReportingThis, hasHelpUnderstandThis, hasWhatDoYouWantToDo);
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
      paramObject = (HeadingsText)paramObject;
      if (whyReportingThis != null)
      {
        if (whyReportingThis.equals(whyReportingThis)) {}
      }
      else {
        while (whyReportingThis != null) {
          return false;
        }
      }
      if (helpUnderstandThis != null)
      {
        if (helpUnderstandThis.equals(helpUnderstandThis)) {}
      }
      else {
        while (helpUnderstandThis != null) {
          return false;
        }
      }
      if (whatDoYouWantToDo == null) {
        break;
      }
    } while (whatDoYouWantToDo.equals(whatDoYouWantToDo));
    for (;;)
    {
      return false;
      if (whatDoYouWantToDo == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (whyReportingThis != null)
    {
      i = whyReportingThis.hashCode();
      if (helpUnderstandThis == null) {
        break label87;
      }
    }
    label87:
    for (int j = helpUnderstandThis.hashCode();; j = 0)
    {
      if (whatDoYouWantToDo != null) {
        k = whatDoYouWantToDo.hashCode();
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public final String id()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.HeadingsText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */