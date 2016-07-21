package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;

public final class OpenLink
  implements RecordTemplate<OpenLink>
{
  public static final OpenLinkBuilder BUILDER = OpenLinkBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final String body;
  public final boolean hasBody;
  public final boolean hasTitle;
  public final boolean hasTrackingId;
  public final boolean hasUrl;
  public final String title;
  public final String trackingId;
  public final String url;
  
  OpenLink(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    title = paramString1;
    body = paramString2;
    trackingId = paramString3;
    url = paramString4;
    hasTitle = paramBoolean1;
    hasBody = paramBoolean2;
    hasTrackingId = paramBoolean3;
    hasUrl = paramBoolean4;
  }
  
  public final OpenLink accept(DataProcessor paramDataProcessor)
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
    if (hasUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("url");
      paramDataProcessor.processString(url);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new OpenLink(title, body, trackingId, url, hasTitle, hasBody, hasTrackingId, hasUrl);
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
      paramObject = (OpenLink)paramObject;
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
      if (url == null) {
        break;
      }
    } while (url.equals(url));
    for (;;)
    {
      return false;
      if (url == null) {
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
      if (trackingId == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = trackingId.hashCode();; k = 0)
    {
      if (url != null) {
        m = url.hashCode();
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
 * Qualified Name:     com.linkedin.semaphore.models.android.OpenLink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */