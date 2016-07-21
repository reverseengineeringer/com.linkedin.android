package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;

public final class ResultScreenText
  implements RecordTemplate<ResultScreenText>
{
  public static final ResultScreenTextBuilder BUILDER = ResultScreenTextBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final String body;
  public final String doneAllCaps;
  public final String doneNormal;
  public final boolean hasBody;
  public final boolean hasDoneAllCaps;
  public final boolean hasDoneNormal;
  public final boolean hasTitle;
  public final String title;
  
  ResultScreenText(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    title = paramString1;
    body = paramString2;
    doneAllCaps = paramString3;
    doneNormal = paramString4;
    hasTitle = paramBoolean1;
    hasBody = paramBoolean2;
    hasDoneAllCaps = paramBoolean3;
    hasDoneNormal = paramBoolean4;
  }
  
  public final ResultScreenText accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasBody)
    {
      paramDataProcessor.startRecordField$505cff1c("body");
      paramDataProcessor.processString(body);
    }
    if (hasDoneAllCaps)
    {
      paramDataProcessor.startRecordField$505cff1c("doneAllCaps");
      paramDataProcessor.processString(doneAllCaps);
    }
    if (hasDoneNormal)
    {
      paramDataProcessor.startRecordField$505cff1c("doneNormal");
      paramDataProcessor.processString(doneNormal);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new ResultScreenText(title, body, doneAllCaps, doneNormal, hasTitle, hasBody, hasDoneAllCaps, hasDoneNormal);
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
      paramObject = (ResultScreenText)paramObject;
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (body != null)
      {
        if (body.equals(body)) {}
      }
      else {
        while (body != null) {
          return false;
        }
      }
      if (doneAllCaps != null)
      {
        if (doneAllCaps.equals(doneAllCaps)) {}
      }
      else {
        while (doneAllCaps != null) {
          return false;
        }
      }
      if (doneNormal == null) {
        break;
      }
    } while (doneNormal.equals(doneNormal));
    for (;;)
    {
      return false;
      if (doneNormal == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (title != null)
    {
      i = title.hashCode();
      if (body == null) {
        break label110;
      }
      j = body.hashCode();
      label45:
      if (doneAllCaps == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = doneAllCaps.hashCode();; k = 0)
    {
      if (doneNormal != null) {
        m = doneNormal.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
    }
  }
  
  public final String id()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.ResultScreenText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */