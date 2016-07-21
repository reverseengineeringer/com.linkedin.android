package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.common.File;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.ShareContentCreate;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MessageCreate$Builder
  implements RecordTemplateBuilder<MessageCreate>
{
  private List<File> attachments = null;
  private AttributedText attributedBody = null;
  private String body = null;
  private MessageCreate.CustomContent customContent = null;
  private boolean hasAttachments = false;
  private boolean hasAttributedBody = false;
  private boolean hasBody = false;
  private boolean hasCustomContent = false;
  private boolean hasShareContent = false;
  private ShareContentCreate shareContent = null;
  
  public final MessageCreate build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MessageCreate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (attachments != null)
    {
      paramFlavor = attachments.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((File)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.create.MessageCreate", "attachments");
            if (!hasAttachments) {
              attachments = Collections.emptyList();
            }
            if (hasBody) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.MessageCreate", "body");
          }
        }
      }
    }
    return new MessageCreate(body, attachments, customContent, shareContent, attributedBody, hasBody, hasAttachments, hasCustomContent, hasShareContent, hasAttributedBody);
  }
  
  public final Builder setAttachments(List<File> paramList)
  {
    if ((paramList == null) || (paramList.equals(Collections.emptyList())))
    {
      hasAttachments = false;
      attachments = Collections.emptyList();
      return this;
    }
    hasAttachments = true;
    attachments = paramList;
    return this;
  }
  
  public final Builder setBody(String paramString)
  {
    if (paramString == null)
    {
      hasBody = false;
      body = null;
      return this;
    }
    hasBody = true;
    body = paramString;
    return this;
  }
  
  public final Builder setCustomContent(MessageCreate.CustomContent paramCustomContent)
  {
    if (paramCustomContent == null)
    {
      hasCustomContent = false;
      customContent = null;
      return this;
    }
    hasCustomContent = true;
    customContent = paramCustomContent;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.MessageCreate.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */