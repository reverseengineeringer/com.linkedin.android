package com.linkedin.android.feed.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.DiscussionSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.events.FeedCommentUpdateEvent;
import com.linkedin.android.feed.mentions.MentionsPresenter;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher.1;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher.2;
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
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
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

public final class FeedUpdateDetailSocialFooterManager
  extends BaseSocialFooterManager
{
  private UpdateDataModel updateDataModel;
  
  public FeedUpdateDetailSocialFooterManager(FragmentComponent paramFragmentComponent, MentionsPresenter paramMentionsPresenter, RecyclerView paramRecyclerView, SocialFooterViewHolder paramSocialFooterViewHolder, String paramString)
  {
    super(paramFragmentComponent, paramMentionsPresenter, paramRecyclerView, paramSocialFooterViewHolder, paramString);
  }
  
  private boolean isDiscussion()
  {
    return SingleUpdateDataModel.getContentDataModel(updateDataModel) instanceof GroupDiscussionContentDataModel;
  }
  
  protected final void setupMentionsPresenter()
  {
    MentionsPresenter localMentionsPresenter = (MentionsPresenter)mentionsPresenter.get();
    if ((localMentionsPresenter != null) && (isDiscussion())) {
      if (!isDiscussion()) {
        break label55;
      }
    }
    label55:
    for (String str = getContentDataModelupdateDataModel)).group.entityUrn.getLastId();; str = null)
    {
      localMentionsPresenter.setGroupDetails$2598ce09(str);
      return;
    }
  }
  
  protected final void setupReplyEditTextHint()
  {
    MentionsEditTextWithBackEvents localMentionsEditTextWithBackEvents = (MentionsEditTextWithBackEvents)replyEditText.get();
    if (localMentionsEditTextWithBackEvents != null) {
      if (!isDiscussion()) {
        break label31;
      }
    }
    label31:
    for (int i = 2131231246;; i = 2131231243)
    {
      localMentionsEditTextWithBackEvents.setHint(i);
      return;
    }
  }
  
  protected final void setupSendButton()
  {
    TrackingOnClickListener local1 = new TrackingOnClickListener(tracker, "comment_post", new TrackingEventBuilder[0])
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
        } while ((update == null) || (commentPublisher == null) || (TextUtils.isEmpty((CharSequence)localObject1)) || (memberMiniProfile == null));
        Object localObject2 = FeedTextUtils.getAnnotatedTextFromMentionsEditable((Editable)localObject1);
        Object localObject1 = commentPublisher;
        Update localUpdate = update;
        Object localObject4 = memberMiniProfile;
        Context localContext = paramAnonymousView.getContext();
        paramAnonymousView = socialDetail;
        if ((paramAnonymousView == null) || (threadId == null)) {
          Util.safeThrow$7a8b4789(new RuntimeException("Trying to publish a comment on update that cannot be commented on."));
        }
        for (;;)
        {
          setupSocialFooterState(0);
          localMentionsEditTextWithBackEvents.setText("");
          paramAnonymousView = (FragmentComponent)fragmentComponent.get();
          if ((update == null) || (update.tracking == null) || (paramAnonymousView == null)) {
            break;
          }
          FeedTracking.trackFAE(tracker, "comment_post", ActionCategory.COMMENT, "submitComment", update.tracking, update.urn, paramAnonymousView);
          FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(tracker.getCurrentPageInstance()), paramAnonymousView, update.tracking, "submitComment");
          return;
          paramAnonymousView = threadId;
          localObject3 = OptimisticWrite.generateTemporaryUrn("comment");
          try
          {
            localObject2 = new Comment.Builder().setUrn((Urn)localObject3).setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { ((Urn)localObject3).getId() })).setCommenter(CommentModelUtils.makeMeSocialActor((MiniProfile)localObject4)).setComment((AnnotatedText)localObject2).setCreatedTime(Long.valueOf(System.currentTimeMillis())).setSocialDetail(CommentModelUtils.generateEmptySocialDetail((Urn)localObject3, ((Urn)localObject3).getId())).setThreadId(paramAnonymousView).setCanDelete(Boolean.valueOf(true)).setActions(Collections.singletonList(CommentAction.DELETE)).setIndex(Integer.valueOf(1000000000)).build();
            paramAnonymousView = socialDetail;
            if (paramAnonymousView == null) {}
            for (paramAnonymousView = null;; paramAnonymousView = new Update.Builder(localUpdate).setSocialDetail(paramAnonymousView).build())
            {
              if (paramAnonymousView != null) {
                break label507;
              }
              Util.safeThrow$7a8b4789(new RuntimeException("Something went wrong generating the optimistic comment"));
              break;
              localObject4 = CommentModelUtils.addCommentToComments(comments, (Comment)localObject2);
              paramAnonymousView = new SocialDetail.Builder(paramAnonymousView).setComments((Comments)localObject4).setTotalSocialActivityCounts(new SocialActivityCounts.Builder(totalSocialActivityCounts).setNumComments(Long.valueOf(totalSocialActivityCounts.numComments + 1L)).build(RecordTemplate.Flavor.RECORD)).build(RecordTemplate.Flavor.RECORD);
            }
          }
          catch (BuilderException paramAnonymousView)
          {
            Util.safeThrow$7a8b4789(new RuntimeException("Something went wrong generating the optimistic comment"));
          }
        }
        label507:
        localObject4 = new FeedCommentUpdateEvent();
        updateEventType = 6;
        newUpdate = paramAnonymousView;
        changedComment = ((Comment)localObject2);
        Bus.publish(localObject4);
        localObject4 = dataManager.createOptimisticWrite();
        ((OptimisticWrite)localObject4).cacheReadModel$4b980c14(paramAnonymousView);
        Object localObject3 = new CommentPublisher.1((CommentPublisher)localObject1, localContext, paramAnonymousView, (Comment)localObject2, localUpdate, (Urn)localObject3);
        preWriteModelTransformer = new CommentPublisher.2((CommentPublisher)localObject1, localContext);
        if (tracking == null) {}
        for (paramAnonymousView = null;; paramAnonymousView = tracking.sponsoredTracking)
        {
          ((OptimisticWrite)localObject4).postWriteModel(FeedRouteUtils.getFeedCommentUrl(lixManager, paramAnonymousView), (RecordTemplate)localObject2, new Comment.Builder((Comment)localObject2), (RecordTemplateListener)localObject3);
          break;
        }
      }
    };
    SocialFooterViewHolder localSocialFooterViewHolder = (SocialFooterViewHolder)socialFooterViewHolder.get();
    if (localSocialFooterViewHolder != null) {
      send.setOnClickListener(local1);
    }
  }
  
  public final void setupSocialFooter(UpdateDataModel paramUpdateDataModel)
  {
    updateDataModel = paramUpdateDataModel;
    SocialFooterViewHolder localSocialFooterViewHolder = (SocialFooterViewHolder)socialFooterViewHolder.get();
    if (localSocialFooterViewHolder == null) {
      return;
    }
    if (DiscussionSingleUpdateDataModel.isClosedDiscussion(paramUpdateDataModel))
    {
      closeDiscussion.setVisibility(0);
      socialActionsView.setVisibility(8);
      return;
    }
    super.setupSocialFooter(pegasusUpdate);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailSocialFooterManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */