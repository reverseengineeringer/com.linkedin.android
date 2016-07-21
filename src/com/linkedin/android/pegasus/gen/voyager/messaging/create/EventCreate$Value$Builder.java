package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.UnionMemberCountException;

public final class EventCreate$Value$Builder
{
  private boolean hasMessageCreateValue = false;
  public boolean hasParticipantChangeCreateValue = false;
  private boolean hasStickerCreateValue = false;
  private MessageCreate messageCreateValue = null;
  public ParticipantChangeCreate participantChangeCreateValue = null;
  private StickerCreate stickerCreateValue = null;
  
  public final EventCreate.Value build()
    throws BuilderException
  {
    int j = 0;
    if (hasMessageCreateValue) {
      j = 0 + 1;
    }
    int i = j;
    if (hasParticipantChangeCreateValue) {
      i = j + 1;
    }
    j = i;
    if (hasStickerCreateValue) {
      j = i + 1;
    }
    if (j > 1) {
      throw new UnionMemberCountException("Value", j);
    }
    return new EventCreate.Value(messageCreateValue, participantChangeCreateValue, stickerCreateValue, hasMessageCreateValue, hasParticipantChangeCreateValue, hasStickerCreateValue);
  }
  
  public final Builder setMessageCreateValue(MessageCreate paramMessageCreate)
  {
    if (paramMessageCreate == null)
    {
      hasMessageCreateValue = false;
      messageCreateValue = null;
      return this;
    }
    hasMessageCreateValue = true;
    messageCreateValue = paramMessageCreate;
    return this;
  }
  
  public final Builder setStickerCreateValue(StickerCreate paramStickerCreate)
  {
    if (paramStickerCreate == null)
    {
      hasStickerCreateValue = false;
      stickerCreateValue = null;
      return this;
    }
    hasStickerCreateValue = true;
    stickerCreateValue = paramStickerCreate;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreate.Value.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */