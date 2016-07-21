package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Section
  implements RecordTemplate<Section>
{
  public static final SectionBuilder BUILDER = SectionBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final String body;
  public final boolean hasBody;
  public final boolean hasOptions;
  public final boolean hasTitle;
  public final boolean hasTrackingId;
  public final List<Option> options;
  public final String title;
  public final String trackingId;
  
  Section(String paramString1, String paramString2, String paramString3, List<Option> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    title = paramString1;
    body = paramString2;
    trackingId = paramString3;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      options = paramString1;
      hasTitle = paramBoolean1;
      hasBody = paramBoolean2;
      hasTrackingId = paramBoolean3;
      hasOptions = paramBoolean4;
      return;
    }
  }
  
  public final Section accept(DataProcessor paramDataProcessor)
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
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      paramDataProcessor.processString(trackingId);
    }
    Object localObject = null;
    Option localOption = null;
    boolean bool = false;
    if (hasOptions)
    {
      paramDataProcessor.startRecordField$505cff1c("options");
      options.size();
      paramDataProcessor.startArray$13462e();
      localObject = localOption;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = options.iterator();
      if (localIterator.hasNext())
      {
        localOption = (Option)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localOption = localOption.accept(paramDataProcessor);; localOption = (Option)paramDataProcessor.processDataTemplate(localOption))
        {
          if ((localObject != null) && (localOption != null)) {
            ((List)localObject).add(localOption);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label307;
      }
    }
    label307:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break;
      }
      return new Section(title, body, trackingId, (List)localObject, hasTitle, hasBody, hasTrackingId, bool);
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
      paramObject = (Section)paramObject;
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
      if (trackingId != null)
      {
        if (trackingId.equals(trackingId)) {}
      }
      else {
        while (trackingId != null) {
          return false;
        }
      }
      if (options == null) {
        break;
      }
    } while (options.equals(options));
    for (;;)
    {
      return false;
      if (options == null) {
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
        break label112;
      }
      j = body.hashCode();
      label45:
      if (trackingId == null) {
        break label117;
      }
    }
    label112:
    label117:
    for (int k = trackingId.hashCode();; k = 0)
    {
      if (options != null) {
        m = options.hashCode();
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
 * Qualified Name:     com.linkedin.semaphore.models.android.Section
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */