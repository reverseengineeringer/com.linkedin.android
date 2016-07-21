package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SuggestedEditCard$Builder
  implements RecordTemplateBuilder<SuggestedEditCard>
{
  private boolean hasPublishedAt = false;
  public boolean hasRead = false;
  private boolean hasSuggestion = false;
  private long publishedAt = 0L;
  public boolean read = false;
  private Suggestion suggestion = null;
  
  public SuggestedEditCard$Builder() {}
  
  public SuggestedEditCard$Builder(SuggestedEditCard paramSuggestedEditCard)
  {
    publishedAt = publishedAt;
    read = read;
    suggestion = suggestion;
    hasPublishedAt = hasPublishedAt;
    hasRead = hasRead;
    hasSuggestion = hasSuggestion;
  }
  
  public final SuggestedEditCard build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SuggestedEditCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SuggestedEditCard(publishedAt, read, suggestion, hasPublishedAt, hasRead, hasSuggestion);
      if (!hasPublishedAt) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard", "publishedAt");
      }
      if (!hasRead) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard", "read");
      }
    } while (hasSuggestion);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard", "suggestion");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */