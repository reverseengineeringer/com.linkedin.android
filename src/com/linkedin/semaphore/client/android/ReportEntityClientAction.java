package com.linkedin.semaphore.client.android;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ReportEntityClientAction
  implements RecordTemplate<ReportEntityClientAction>
{
  public static final ReportEntityClientActionBuilder BUILDER = ReportEntityClientActionBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final String body;
  public final boolean hasBody;
  public final boolean hasHelpCenterLink;
  public final boolean hasReportAction;
  public final boolean hasTitle;
  public final String helpCenterLink;
  public final List<ReportEntityResponseCode> reportAction;
  public final String title;
  
  ReportEntityClientAction(String paramString1, String paramString2, String paramString3, List<ReportEntityResponseCode> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    title = paramString1;
    body = paramString2;
    helpCenterLink = paramString3;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      reportAction = paramString1;
      hasTitle = paramBoolean1;
      hasBody = paramBoolean2;
      hasHelpCenterLink = paramBoolean3;
      hasReportAction = paramBoolean4;
      return;
    }
  }
  
  public final ReportEntityClientAction accept(DataProcessor paramDataProcessor)
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
    if (hasHelpCenterLink)
    {
      paramDataProcessor.startRecordField$505cff1c("helpCenterLink");
      paramDataProcessor.processString(helpCenterLink);
    }
    Object localObject = null;
    Iterator localIterator = null;
    boolean bool = false;
    if (hasReportAction)
    {
      paramDataProcessor.startRecordField$505cff1c("reportAction");
      reportAction.size();
      paramDataProcessor.startArray$13462e();
      localObject = localIterator;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      localIterator = reportAction.iterator();
      while (localIterator.hasNext())
      {
        ReportEntityResponseCode localReportEntityResponseCode = (ReportEntityResponseCode)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processEnum(localReportEntityResponseCode);
        if (localObject != null) {
          ((List)localObject).add(localReportEntityResponseCode);
        }
        i += 1;
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label277;
      }
    }
    label277:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break;
      }
      return new ReportEntityClientAction(title, body, helpCenterLink, (List)localObject, hasTitle, hasBody, hasHelpCenterLink, bool);
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
      paramObject = (ReportEntityClientAction)paramObject;
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
      if (helpCenterLink != null)
      {
        if (helpCenterLink.equals(helpCenterLink)) {}
      }
      else {
        while (helpCenterLink != null) {
          return false;
        }
      }
      if (reportAction == null) {
        break;
      }
    } while (reportAction.equals(reportAction));
    for (;;)
    {
      return false;
      if (reportAction == null) {
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
      if (helpCenterLink == null) {
        break label117;
      }
    }
    label112:
    label117:
    for (int k = helpCenterLink.hashCode();; k = 0)
    {
      if (reportAction != null) {
        m = reportAction.hashCode();
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
  
  public static final class Builder
    implements RecordTemplateBuilder<ReportEntityClientAction>
  {
    private String body = null;
    private boolean hasBody = false;
    public boolean hasHelpCenterLink = false;
    public boolean hasReportAction = false;
    private boolean hasTitle = false;
    public String helpCenterLink = null;
    public List<ReportEntityResponseCode> reportAction = null;
    private String title = null;
    
    public final ReportEntityClientAction build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      int[] arrayOfInt = ReportEntityClientAction.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
      paramFlavor.ordinal();
      if (reportAction != null)
      {
        paramFlavor = reportAction.iterator();
        while (paramFlavor.hasNext()) {
          if ((ReportEntityResponseCode)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.semaphore.client.android.ReportEntityClientAction", "reportAction");
          }
        }
      }
      return new ReportEntityClientAction(title, body, helpCenterLink, reportAction, hasTitle, hasBody, hasHelpCenterLink, hasReportAction);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.client.android.ReportEntityClientAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */