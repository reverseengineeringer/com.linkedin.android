package com.linkedin.android.feed.page.feed.highlightedupdates;

import com.linkedin.gen.avro2pegasus.events.feed.highlightedUpdateSource;
import com.linkedin.gen.avro2pegasus.events.messages.MessageId;

public final class HighlightedUpdateHelper
{
  public HighlightedUpdateInfo[] highlightedUpdateInfos;
  highlightedUpdateSource highlightedUpdateSource;
  MessageId sourceTrackingId;
  
  public HighlightedUpdateHelper(HighlightedUpdateInfo[] paramArrayOfHighlightedUpdateInfo, highlightedUpdateSource paramhighlightedUpdateSource, MessageId paramMessageId)
  {
    highlightedUpdateInfos = paramArrayOfHighlightedUpdateInfo;
    highlightedUpdateSource = paramhighlightedUpdateSource;
    sourceTrackingId = paramMessageId;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdateHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */