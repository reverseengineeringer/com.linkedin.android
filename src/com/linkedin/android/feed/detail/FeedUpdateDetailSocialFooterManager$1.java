package com.linkedin.android.feed.detail;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.events.FeedCommentUpdateEvent;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher.1;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher.2;
import com.linkedin.android.feed.utils.CommentModelUtils;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.feed.utils.FeedTextUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.OptimisticWrite;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.MentionsEditTextWithBackEvents;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.CommentAction;
import com.linkedin.android.pegasus.gen.voyager.feed.Comments;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.spyglass.mentions.MentionsEditable;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import java.lang.ref.WeakReference;
import java.util.Collections;

final class FeedUpdateDetailSocialFooterManager$1
  extends TrackingOnClickListener
{
  FeedUpdateDetailSocialFooterManager$1(FeedUpdateDetailSocialFooterManager paramFeedUpdateDetailSocialFooterManager, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    MentionsEditTextWithBackEvents localMentionsEditTextWithBackEvents = (MentionsEditTextWithBackEvents)this$0.replyEditText.get();
    if (localMentionsEditTextWithBackEvents == null) {}
    do
    {
      return;
      localObject1 = localMentionsEditTextWithBackEvents.getMentionsText().trim();
    } while ((this$0.update == null) || (this$0.commentPublisher == null) || (TextUtils.isEmpty((CharSequence)localObject1)) || (this$0.memberMiniProfile == null));
    Object localObject2 = FeedTextUtils.getAnnotatedTextFromMentionsEditable((Editable)localObject1);
    Object localObject1 = this$0.commentPublisher;
    Update localUpdate = this$0.update;
    Object localObject4 = this$0.memberMiniProfile;
    Context localContext = paramView.getContext();
    paramView = socialDetail;
    if ((paramView == null) || (threadId == null)) {
      Util.safeThrow$7a8b4789(new RuntimeException("Trying to publish a comment on update that cannot be commented on."));
    }
    for (;;)
    {
      this$0.setupSocialFooterState(0);
      localMentionsEditTextWithBackEvents.setText("");
      paramView = (FragmentComponent)this$0.fragmentComponent.get();
      if ((this$0.update == null) || (this$0.update.tracking == null) || (paramView == null)) {
        break;
      }
      FeedTracking.trackFAE(this$0.tracker, "comment_post", ActionCategory.COMMENT, "submitComment", this$0.update.tracking, this$0.update.urn, paramView);
      FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(this$0.tracker.getCurrentPageInstance()), paramView, this$0.update.tracking, "submitComment");
      return;
      paramView = threadId;
      localObject3 = OptimisticWrite.generateTemporaryUrn("comment");
      try
      {
        localObject2 = new Comment.Builder().setUrn((Urn)localObject3).setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { ((Urn)localObject3).getId() })).setCommenter(CommentModelUtils.makeMeSocialActor((MiniProfile)localObject4)).setComment((AnnotatedText)localObject2).setCreatedTime(Long.valueOf(System.currentTimeMillis())).setSocialDetail(CommentModelUtils.generateEmptySocialDetail((Urn)localObject3, ((Urn)localObject3).getId())).setThreadId(paramView).setCanDelete(Boolean.valueOf(true)).setActions(Collections.singletonList(CommentAction.DELETE)).setIndex(Integer.valueOf(1000000000)).build();
        paramView = socialDetail;
        if (paramView == null) {}
        for (paramView = null;; paramView = new Update.Builder(localUpdate).setSocialDetail(paramView).build())
        {
          if (paramView != null) {
            break label507;
          }
          Util.safeThrow$7a8b4789(new RuntimeException("Something went wrong generating the optimistic comment"));
          break;
          localObject4 = CommentModelUtils.addCommentToComments(comments, (Comment)localObject2);
          paramView = new SocialDetail.Builder(paramView).setComments((Comments)localObject4).setTotalSocialActivityCounts(new SocialActivityCounts.Builder(totalSocialActivityCounts).setNumComments(Long.valueOf(totalSocialActivityCounts.numComments + 1L)).build(RecordTemplate.Flavor.RECORD)).build(RecordTemplate.Flavor.RECORD);
        }
      }
      catch (BuilderException paramView)
      {
        Util.safeThrow$7a8b4789(new RuntimeException("Something went wrong generating the optimistic comment"));
      }
    }
    label507:
    localObject4 = new FeedCommentUpdateEvent();
    updateEventType = 6;
    newUpdate = paramView;
    changedComment = ((Comment)localObject2);
    Bus.publish(localObject4);
    localObject4 = dataManager.createOptimisticWrite();
    ((OptimisticWrite)localObject4).cacheReadModel$4b980c14(paramView);
    Object localObject3 = new CommentPublisher.1((CommentPublisher)localObject1, localContext, paramView, (Comment)localObject2, localUpdate, (Urn)localObject3);
    preWriteModelTransformer = new CommentPublisher.2((CommentPublisher)localObject1, localContext);
    if (tracking == null) {}
    for (paramView = null;; paramView = tracking.sponsoredTracking)
    {
      ((OptimisticWrite)localObject4).postWriteModel(FeedRouteUtils.getFeedCommentUrl(lixManager, paramView), (RecordTemplate)localObject2, new Comment.Builder((Comment)localObject2), (RecordTemplateListener)localObject3);
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailSocialFooterManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */