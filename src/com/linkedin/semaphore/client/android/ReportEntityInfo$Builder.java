package com.linkedin.semaphore.client.android;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ReportEntityInfo$Builder
  implements RecordTemplateBuilder<ReportEntityInfo>
{
  public String author = null;
  public String entity = null;
  public boolean hasAuthor = false;
  public boolean hasEntity = false;
  public boolean hasParent = false;
  public String parent = null;
  
  public final ReportEntityInfo build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ReportEntityInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ReportEntityInfo(entity, author, parent, hasEntity, hasAuthor, hasParent);
    } while (hasEntity);
    throw new MissingRecordFieldException("com.linkedin.semaphore.client.android.ReportEntityInfo", "entity");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.client.android.ReportEntityInfo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */