package com.linkedin.semaphore.client.android;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class ReportEntityClientAction$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.semaphore.client.android.ReportEntityClientAction.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */