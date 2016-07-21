package com.linkedin.gen.avro2pegasus.events.feed;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class Comment$Builder
  implements RecordTemplateBuilder<Comment>
{
  public String associatedInputControlUrn = null;
  public String commenterUrn = null;
  public long duration = 0L;
  public boolean hasAssociatedInputControlUrn = false;
  public boolean hasCommenterUrn = false;
  public boolean hasDuration = false;
  public boolean hasLevel = false;
  public boolean hasListPosition = false;
  public boolean hasMessage = false;
  public boolean hasSize = false;
  public boolean hasThreadUrn = false;
  public boolean hasTotalLikes = false;
  public boolean hasTotalReplies = false;
  public boolean hasTrackableCommentObject = false;
  public boolean hasTrackableUpdateObject = false;
  public boolean hasVisibleTime = false;
  public int level = 0;
  public ListPosition listPosition = null;
  public String message = null;
  public EntityDimension size = null;
  public String threadUrn = null;
  public long totalLikes = 0L;
  public long totalReplies = 0L;
  public TrackingObject trackableCommentObject = null;
  public TrackingObject trackableUpdateObject = null;
  public long visibleTime = 0L;
  
  public final Comment build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Comment.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new Comment(trackableCommentObject, trackableUpdateObject, threadUrn, commenterUrn, message, level, visibleTime, duration, associatedInputControlUrn, totalReplies, totalLikes, listPosition, size, hasTrackableCommentObject, hasTrackableUpdateObject, hasThreadUrn, hasCommenterUrn, hasMessage, hasLevel, hasVisibleTime, hasDuration, hasAssociatedInputControlUrn, hasTotalReplies, hasTotalLikes, hasListPosition, hasSize);
      if (!hasTrackableCommentObject) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "trackableCommentObject");
      }
      if (!hasTrackableUpdateObject) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "trackableUpdateObject");
      }
      if (!hasThreadUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "threadUrn");
      }
      if (!hasCommenterUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "commenterUrn");
      }
      if (!hasMessage) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "message");
      }
      if (!hasLevel) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "level");
      }
      if (!hasVisibleTime) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "visibleTime");
      }
      if (!hasDuration) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "duration");
      }
      if (!hasTotalReplies) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "totalReplies");
      }
      if (!hasTotalLikes) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "totalLikes");
      }
      if (!hasListPosition) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "listPosition");
      }
    } while (hasSize);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "size");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.feed.Comment.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */