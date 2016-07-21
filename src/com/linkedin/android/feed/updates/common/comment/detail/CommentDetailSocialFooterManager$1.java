package com.linkedin.android.feed.updates.common.comment.detail;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.linkedin.android.feed.events.FeedReplyUpdateEvent;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher.3;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher.4;
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
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
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

final class CommentDetailSocialFooterManager$1
  extends TrackingOnClickListener
{
  CommentDetailSocialFooterManager$1(CommentDetailSocialFooterManager paramCommentDetailSocialFooterManager, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
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
    } while ((this$0.update == null) || (this$0.comment == null) || (this$0.commentPublisher == null) || (TextUtils.isEmpty((CharSequence)localObject1)) || (this$0.memberMiniProfile == null));
    Object localObject3 = FeedTextUtils.getAnnotatedTextFromMentionsEditable((Editable)localObject1);
    Object localObject1 = this$0.commentPublisher;
    Object localObject2 = this$0.comment;
    Object localObject4 = this$0.memberMiniProfile;
    Context localContext = paramView.getContext();
    paramView = socialDetail;
    if ((paramView == null) || (threadId == null)) {
      Util.safeThrow$7a8b4789(new RuntimeException("Trying to publish a reply on comment that cannot be commented on."));
    }
    for (;;)
    {
      this$0.setupSocialFooterState(0);
      localMentionsEditTextWithBackEvents.setText("");
      paramView = (FragmentComponent)this$0.fragmentComponent.get();
      if ((this$0.update == null) || (this$0.update.tracking == null) || (paramView == null)) {
        break;
      }
      this$0.trackFAE(paramView, "reply_post", ActionCategory.COMMENT, "submitReply");
      FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(this$0.tracker.getCurrentPageInstance()), paramView, this$0.update.tracking, "submitComment");
      return;
      String str = threadId;
      Urn localUrn = OptimisticWrite.generateTemporaryUrn("comment");
      for (;;)
      {
        try
        {
          paramView = urn;
          localObject3 = new Comment.Builder().setUrn(localUrn).setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { localUrn.getId() })).setCommenter(CommentModelUtils.makeMeSocialActor((MiniProfile)localObject4)).setComment((AnnotatedText)localObject3).setCreatedTime(Long.valueOf(System.currentTimeMillis())).setSocialDetail(CommentModelUtils.generateEmptySocialDetail(localUrn, localUrn.getId())).setThreadId(str);
          if (paramView == null)
          {
            hasParentCommentUrn = false;
            parentCommentUrn = null;
            localObject3 = ((Comment.Builder)localObject3).setCanDelete(Boolean.valueOf(true)).setActions(Collections.singletonList(CommentAction.DELETE)).setIndex(Integer.valueOf(1000000000)).build();
            paramView = socialDetail;
            if (paramView != null) {
              break label451;
            }
            paramView = null;
            if (paramView != null) {
              break label537;
            }
            Util.safeThrow$7a8b4789(new RuntimeException("Something went wrong generating the optimistic reply"));
            break;
          }
          hasParentCommentUrn = true;
          parentCommentUrn = paramView;
          continue;
        }
        catch (BuilderException paramView)
        {
          Util.safeThrow$7a8b4789(new RuntimeException("Something went wrong generating the optimistic reply"));
        }
        label451:
        localObject4 = CommentModelUtils.addCommentToComments(comments, (Comment)localObject3);
        paramView = new SocialDetail.Builder(paramView).setComments((Comments)localObject4).setTotalSocialActivityCounts(new SocialActivityCounts.Builder(totalSocialActivityCounts).setNumComments(Long.valueOf(totalSocialActivityCounts.numComments + 1L)).build(RecordTemplate.Flavor.RECORD)).build(RecordTemplate.Flavor.RECORD);
        paramView = new Comment.Builder((Comment)localObject2).setSocialDetail(paramView).build();
      }
      label537:
      localObject2 = new FeedReplyUpdateEvent();
      updateEventType = 6;
      newComment = paramView;
      changedReply = ((Comment)localObject3);
      Bus.publish(localObject2);
      localObject2 = dataManager.createOptimisticWrite();
      ((OptimisticWrite)localObject2).cacheReadModel$4b980c14(paramView);
      paramView = new CommentPublisher.3((CommentPublisher)localObject1, localContext, paramView, (Comment)localObject3, localUrn);
      preWriteModelTransformer = new CommentPublisher.4((CommentPublisher)localObject1, localContext);
      ((OptimisticWrite)localObject2).postWriteModel(FeedRouteUtils.getFeedCommentUrl(lixManager, null), (RecordTemplate)localObject3, new Comment.Builder((Comment)localObject3), paramView);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailSocialFooterManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */