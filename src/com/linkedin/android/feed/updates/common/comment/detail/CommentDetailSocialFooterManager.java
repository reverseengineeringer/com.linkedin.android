package com.linkedin.android.feed.updates.common.comment.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.linkedin.android.feed.detail.BaseSocialFooterManager;
import com.linkedin.android.feed.events.FeedReplyUpdateEvent;
import com.linkedin.android.feed.mentions.MentionsPresenter;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher.3;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher.4;
import com.linkedin.android.feed.updates.common.footer.SocialFooterViewHolder;
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

public final class CommentDetailSocialFooterManager
  extends BaseSocialFooterManager
{
  Comment comment;
  
  public CommentDetailSocialFooterManager(FragmentComponent paramFragmentComponent, MentionsPresenter paramMentionsPresenter, RecyclerView paramRecyclerView, SocialFooterViewHolder paramSocialFooterViewHolder, String paramString)
  {
    super(paramFragmentComponent, paramMentionsPresenter, paramRecyclerView, paramSocialFooterViewHolder, paramString);
  }
  
  public final void setupComment(Comment paramComment)
  {
    comment = paramComment;
    setupSendButton();
  }
  
  protected final void setupReplyEditTextHint()
  {
    MentionsEditTextWithBackEvents localMentionsEditTextWithBackEvents = (MentionsEditTextWithBackEvents)replyEditText.get();
    if (localMentionsEditTextWithBackEvents != null) {
      localMentionsEditTextWithBackEvents.setHint(2131231244);
    }
  }
  
  protected final void setupSendButton()
  {
    TrackingOnClickListener local1 = new TrackingOnClickListener(tracker, "reply_post", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        MentionsEditTextWithBackEvents localMentionsEditTextWithBackEvents = (MentionsEditTextWithBackEvents)replyEditText.get();
        if (localMentionsEditTextWithBackEvents == null) {}
        do
        {
          return;
          localObject1 = localMentionsEditTextWithBackEvents.getMentionsText().trim();
        } while ((update == null) || (comment == null) || (commentPublisher == null) || (TextUtils.isEmpty((CharSequence)localObject1)) || (memberMiniProfile == null));
        Object localObject3 = FeedTextUtils.getAnnotatedTextFromMentionsEditable((Editable)localObject1);
        Object localObject1 = commentPublisher;
        Object localObject2 = comment;
        Object localObject4 = memberMiniProfile;
        Context localContext = paramAnonymousView.getContext();
        paramAnonymousView = socialDetail;
        if ((paramAnonymousView == null) || (threadId == null)) {
          Util.safeThrow$7a8b4789(new RuntimeException("Trying to publish a reply on comment that cannot be commented on."));
        }
        for (;;)
        {
          setupSocialFooterState(0);
          localMentionsEditTextWithBackEvents.setText("");
          paramAnonymousView = (FragmentComponent)fragmentComponent.get();
          if ((update == null) || (update.tracking == null) || (paramAnonymousView == null)) {
            break;
          }
          trackFAE(paramAnonymousView, "reply_post", ActionCategory.COMMENT, "submitReply");
          FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(tracker.getCurrentPageInstance()), paramAnonymousView, update.tracking, "submitComment");
          return;
          String str = threadId;
          Urn localUrn = OptimisticWrite.generateTemporaryUrn("comment");
          for (;;)
          {
            try
            {
              paramAnonymousView = urn;
              localObject3 = new Comment.Builder().setUrn(localUrn).setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { localUrn.getId() })).setCommenter(CommentModelUtils.makeMeSocialActor((MiniProfile)localObject4)).setComment((AnnotatedText)localObject3).setCreatedTime(Long.valueOf(System.currentTimeMillis())).setSocialDetail(CommentModelUtils.generateEmptySocialDetail(localUrn, localUrn.getId())).setThreadId(str);
              if (paramAnonymousView == null)
              {
                hasParentCommentUrn = false;
                parentCommentUrn = null;
                localObject3 = ((Comment.Builder)localObject3).setCanDelete(Boolean.valueOf(true)).setActions(Collections.singletonList(CommentAction.DELETE)).setIndex(Integer.valueOf(1000000000)).build();
                paramAnonymousView = socialDetail;
                if (paramAnonymousView != null) {
                  break label451;
                }
                paramAnonymousView = null;
                if (paramAnonymousView != null) {
                  break label537;
                }
                Util.safeThrow$7a8b4789(new RuntimeException("Something went wrong generating the optimistic reply"));
                break;
              }
              hasParentCommentUrn = true;
              parentCommentUrn = paramAnonymousView;
              continue;
            }
            catch (BuilderException paramAnonymousView)
            {
              Util.safeThrow$7a8b4789(new RuntimeException("Something went wrong generating the optimistic reply"));
            }
            label451:
            localObject4 = CommentModelUtils.addCommentToComments(comments, (Comment)localObject3);
            paramAnonymousView = new SocialDetail.Builder(paramAnonymousView).setComments((Comments)localObject4).setTotalSocialActivityCounts(new SocialActivityCounts.Builder(totalSocialActivityCounts).setNumComments(Long.valueOf(totalSocialActivityCounts.numComments + 1L)).build(RecordTemplate.Flavor.RECORD)).build(RecordTemplate.Flavor.RECORD);
            paramAnonymousView = new Comment.Builder((Comment)localObject2).setSocialDetail(paramAnonymousView).build();
          }
          label537:
          localObject2 = new FeedReplyUpdateEvent();
          updateEventType = 6;
          newComment = paramAnonymousView;
          changedReply = ((Comment)localObject3);
          Bus.publish(localObject2);
          localObject2 = dataManager.createOptimisticWrite();
          ((OptimisticWrite)localObject2).cacheReadModel$4b980c14(paramAnonymousView);
          paramAnonymousView = new CommentPublisher.3((CommentPublisher)localObject1, localContext, paramAnonymousView, (Comment)localObject3, localUrn);
          preWriteModelTransformer = new CommentPublisher.4((CommentPublisher)localObject1, localContext);
          ((OptimisticWrite)localObject2).postWriteModel(FeedRouteUtils.getFeedCommentUrl(lixManager, null), (RecordTemplate)localObject3, new Comment.Builder((Comment)localObject3), paramAnonymousView);
        }
      }
    };
    SocialFooterViewHolder localSocialFooterViewHolder = (SocialFooterViewHolder)socialFooterViewHolder.get();
    if (localSocialFooterViewHolder != null) {
      send.setOnClickListener(local1);
    }
  }
  
  public final void trackFAE(FragmentComponent paramFragmentComponent, String paramString1, ActionCategory paramActionCategory, String paramString2)
  {
    super.trackFAE(paramFragmentComponent, paramString1, paramActionCategory, paramString2);
    if ((update != null) && (update.tracking != null) && (comment != null) && (paramFragmentComponent != null)) {
      FeedTracking.trackFCAE(tracker, paramString1, paramActionCategory, paramString2, update, comment, paramFragmentComponent);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailSocialFooterManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */