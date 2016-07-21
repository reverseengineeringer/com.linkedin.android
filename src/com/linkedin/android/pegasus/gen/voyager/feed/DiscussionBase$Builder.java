package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class DiscussionBase$Builder
  implements RecordTemplateBuilder<DiscussionBase>
{
  public AnnotatedText body = null;
  public boolean hasBody = false;
  public boolean hasTitle = false;
  public String title = null;
  
  public final DiscussionBase build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (DiscussionBase.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new DiscussionBase(title, body, hasTitle, hasBody);
    } while (hasTitle);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionBase", "title");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.DiscussionBase.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */