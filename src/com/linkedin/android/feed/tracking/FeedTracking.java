package com.linkedin.android.feed.tracking;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.entities.jymbii.JymbiiBundleBuilder;
import com.linkedin.android.entities.jymbii.JymbiiIntent;
import com.linkedin.android.entities.shared.ChannelOnClickListener;
import com.linkedin.android.entities.shared.MiniCompanyOnClickListener;
import com.linkedin.android.entities.shared.MiniGroupOnClickListener;
import com.linkedin.android.entities.shared.MiniJobOnClickListener;
import com.linkedin.android.entities.shared.MiniSchoolOnClickListener;
import com.linkedin.android.feed.actions.ControlMenuOnClickListener;
import com.linkedin.android.feed.actions.FeedToggleCommentOrderingDialogOnClickListener;
import com.linkedin.android.feed.actions.FeedToggleLikeOrderingDialogOnClickListener;
import com.linkedin.android.feed.actions.UndoRemovalClickableSpan;
import com.linkedin.android.feed.actions.UndoRemovalOnClickListener;
import com.linkedin.android.feed.actorlist.FeedActorListBundleBuilder;
import com.linkedin.android.feed.actorlist.FeedActorListIntent;
import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.ChannelActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.CompanyActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.MemberActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.SchoolActorDataModel;
import com.linkedin.android.feed.endor.datamodel.social.CommentDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.PymkUpdateDataModel.PymkRecommendationBuilder;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.events.LoadMoreEvent;
import com.linkedin.android.feed.events.UpdateActionEvent;
import com.linkedin.android.feed.followhub.FeedToFollowHubOnClickListener;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.page.feed.newupdatespill.FeedNewUpdatesPillEvent;
import com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesPillTrackingEvent;
import com.linkedin.android.feed.promptresponselist.PromptResponseUpdateClickListener;
import com.linkedin.android.feed.sharecreation.ReshareClickListener;
import com.linkedin.android.feed.shared.AggregateUpdateOnClickListener;
import com.linkedin.android.feed.shared.ConnectInvitationOnClickListener;
import com.linkedin.android.feed.shared.CrossPromoInFeedOnClickListener;
import com.linkedin.android.feed.shared.CrossPromoInFeedOnDismissListener;
import com.linkedin.android.feed.shared.FeedCommentButtonOnClickListener;
import com.linkedin.android.feed.shared.FeedCommentDetailOnClickListener;
import com.linkedin.android.feed.shared.FeedCommentViewRepliesOnClickListener;
import com.linkedin.android.feed.shared.FeedFollowEntityOnClickListener;
import com.linkedin.android.feed.shared.FeedLikeOnClickListener;
import com.linkedin.android.feed.shared.FeedReplyButtonOnClickListener;
import com.linkedin.android.feed.shared.FeedToRbmfOnClickListener;
import com.linkedin.android.feed.shared.FeedUpdateOnClickListener;
import com.linkedin.android.feed.shared.FeedViralUpdateOnClickListener;
import com.linkedin.android.feed.shared.articleviewer.ShareArticleOnClickListener;
import com.linkedin.android.feed.shared.imageviewer.ImageViewerOnClickListener;
import com.linkedin.android.feed.shared.videoviewer.ShareVideoOnClickListener;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDetailBundleBuilder;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDetailIntent;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.identity.shared.MiniProfileOnClickListener;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.TrackingUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.spans.ChannelClickableSpan;
import com.linkedin.android.infra.ui.spans.CompanyClickableSpan;
import com.linkedin.android.infra.ui.spans.EntityClickableSpan;
import com.linkedin.android.infra.ui.spans.GroupClickableSpan;
import com.linkedin.android.infra.ui.spans.HashtagSpan;
import com.linkedin.android.infra.ui.spans.ProfileClickableSpan;
import com.linkedin.android.infra.ui.spans.SchoolClickableSpan;
import com.linkedin.android.infra.ui.spans.TrackingClickableSpan;
import com.linkedin.android.infra.ui.spans.UrlSpan;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFeedModuleKey;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedConnectionUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedPymkUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;
import com.linkedin.android.pegasus.gen.voyager.feed.Prompt;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SortOrder;
import com.linkedin.android.pegasus.gen.voyager.feed.SponsoredMetadata;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.Page;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.MultipleTrackingEventSender;
import com.linkedin.android.tracking.v2.listeners.TrackingDialogOnDismissListener;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension.Builder;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition.Builder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition.Builder;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject.Builder;
import com.linkedin.gen.avro2pegasus.events.feed.Comment.Builder;
import com.linkedin.gen.avro2pegasus.events.feed.Entity;
import com.linkedin.gen.avro2pegasus.events.feed.Entity.Builder;
import com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent;
import com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent;
import com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.feed.FeedCommentImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.feed.FeedImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.feed.highlightedUpdateSource;
import com.linkedin.gen.avro2pegasus.events.messages.MessageId;
import com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.pymk.PymkRecommendation.Builder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FeedTracking
{
  static
  {
    if (!FeedTracking.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public static TrackingOnClickListener actorClickListener(ActorDataModel paramActorDataModel, FragmentComponent paramFragmentComponent, String paramString, TrackingData paramTrackingData, Urn paramUrn)
  {
    return actorClickListener(paramActorDataModel, paramFragmentComponent, paramString, paramTrackingData, paramUrn, null);
  }
  
  private static TrackingOnClickListener actorClickListener(ActorDataModel paramActorDataModel, final FragmentComponent paramFragmentComponent, final String paramString, final TrackingData paramTrackingData, Urn paramUrn, Comment paramComment)
  {
    if ((paramActorDataModel instanceof MemberActorDataModel))
    {
      paramActorDataModel = new MiniProfileOnClickListener((MiniProfile)metadata, paramFragmentComponent, paramString, new TrackingEventBuilder[0]);
      addActorCustomTrackingEvent(paramFragmentComponent, paramActorDataModel, paramTrackingData, paramUrn, ActionCategory.VIEW, paramString, "viewMember", paramComment);
      return paramActorDataModel;
    }
    if ((paramActorDataModel instanceof CompanyActorDataModel))
    {
      paramActorDataModel = new MiniCompanyOnClickListener((MiniCompany)metadata, activityactivityComponent, paramString, new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          if (paramString.equals("actor"))
          {
            FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance()), paramFragmentComponent, paramTrackingData, "viewCompany");
            return;
          }
          FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance()), paramFragmentComponent, paramTrackingData, "viewCompanyPic");
        }
      };
      addActorCustomTrackingEvent(paramFragmentComponent, paramActorDataModel, paramTrackingData, paramUrn, ActionCategory.VIEW, paramString, "viewCompany", paramComment);
      return paramActorDataModel;
    }
    if ((paramActorDataModel instanceof SchoolActorDataModel))
    {
      paramActorDataModel = new MiniSchoolOnClickListener((MiniSchool)metadata, activityactivityComponent, paramString, new TrackingEventBuilder[0]);
      addActorCustomTrackingEvent(paramFragmentComponent, paramActorDataModel, paramTrackingData, paramUrn, ActionCategory.VIEW, paramString, "viewSchool", paramComment);
      return paramActorDataModel;
    }
    if ((paramActorDataModel instanceof ChannelActorDataModel))
    {
      paramActorDataModel = new ChannelOnClickListener((Channel)metadata, activityactivityComponent, paramString, new TrackingEventBuilder[0]);
      addActorCustomTrackingEvent(paramFragmentComponent, paramActorDataModel, paramTrackingData, paramUrn, ActionCategory.VIEW, paramString, "viewChannel", paramComment);
      return paramActorDataModel;
    }
    return null;
  }
  
  @Deprecated
  public static TrackingOnClickListener actorClickListener(ActorDataModel paramActorDataModel, FragmentComponent paramFragmentComponent, String paramString, Update paramUpdate)
  {
    return actorClickListener(paramActorDataModel, paramFragmentComponent, paramString, paramUpdate, null);
  }
  
  @Deprecated
  public static TrackingOnClickListener actorClickListener(ActorDataModel paramActorDataModel, FragmentComponent paramFragmentComponent, String paramString, Update paramUpdate, Comment paramComment)
  {
    return actorClickListener(paramActorDataModel, paramFragmentComponent, paramString, tracking, urn, paramComment);
  }
  
  private static void addActorCustomTrackingEvent(FragmentComponent paramFragmentComponent, TrackingOnClickListener paramTrackingOnClickListener, TrackingData paramTrackingData, Urn paramUrn, ActionCategory paramActionCategory, String paramString1, String paramString2, Comment paramComment)
  {
    if (paramTrackingData != null)
    {
      if ((paramComment != null) && (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_COMMENTS_TRACKING)) && ((FeedViewTransformerHelpers.isCommentDetailPage(paramFragmentComponent)) || ((FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent)) && (parentCommentUrn != null)))) {
        paramTrackingOnClickListener.addCustomTrackingEventBuilder(new FeedCommentActionEventBuilder((byte)0).setControlName(paramFragmentComponent.tracker(), paramString1).setTrackableUpdateObject(getTrackableUpdateObject(paramTrackingData, paramUrn)).setTrackableCommentObject(getTrackableCommentObject(paramComment)).setThreadUrn(getCommentTrackingUrn(paramComment)).setActionCategory(paramActionCategory).setActionType(paramString2));
      }
      paramTrackingOnClickListener.addCustomTrackingEventBuilder(createFeedActionEvent(paramActionCategory, paramString1, paramString2, paramTrackingData, paramUrn, paramFragmentComponent));
    }
  }
  
  private static void addCustomTrackingFeedCommentActionEvent(TrackingClickableSpan paramTrackingClickableSpan, ActionCategory paramActionCategory, String paramString1, String paramString2, Update paramUpdate, Comment paramComment, FragmentComponent paramFragmentComponent)
  {
    if ((paramUpdate != null) && (tracking != null) && (urn != null))
    {
      if ((FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_COMMENTS_TRACKING)) && (paramComment != null) && (urn != null)) {
        paramTrackingClickableSpan.addCustomTrackingEventBuilderBuilder(createFeedCommentActionEvent(paramActionCategory, paramString1, paramString2, paramUpdate, paramComment, paramFragmentComponent));
      }
      paramTrackingClickableSpan.addCustomTrackingEventBuilderBuilder(createFeedActionEvent(paramActionCategory, paramString1, paramString2, tracking, urn, paramFragmentComponent));
    }
  }
  
  private static void addCustomTrackingFeedCommentActionEvent(TrackingOnClickListener paramTrackingOnClickListener, ActionCategory paramActionCategory, String paramString1, String paramString2, Update paramUpdate, Comment paramComment, FragmentComponent paramFragmentComponent)
  {
    if ((tracking != null) && (urn != null))
    {
      if (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_COMMENTS_TRACKING)) {
        paramTrackingOnClickListener.addCustomTrackingEventBuilder(createFeedCommentActionEvent(paramActionCategory, paramString1, paramString2, paramUpdate, paramComment, paramFragmentComponent));
      }
      paramTrackingOnClickListener.addCustomTrackingEventBuilder(createFeedActionEvent(paramActionCategory, paramString1, paramString2, tracking, urn, paramFragmentComponent));
    }
  }
  
  public static FeedActionEvent.Builder createFeedActionEvent(Tracker paramTracker, ActionCategory paramActionCategory, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramActionCategory = new FeedActionEventBuilder((byte)0).setControlName(paramTracker, paramString1).setActionCategory(paramActionCategory).setModuleKey(paramString6);
    paramTracker = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramTracker = "no_request_id";
    }
    return paramActionCategory.setRequestId(paramTracker).setUpdateUrn(paramString5).setTrackingId(paramString4).setActionType(paramString2);
  }
  
  public static FeedActionEvent.Builder createFeedActionEvent(ActionCategory paramActionCategory, String paramString1, String paramString2, TrackingData paramTrackingData, Urn paramUrn, FragmentComponent paramFragmentComponent)
  {
    return createFeedActionEvent(paramActionCategory, paramString1, paramString2, paramTrackingData, paramUrn.toString(), paramFragmentComponent);
  }
  
  public static FeedActionEvent.Builder createFeedActionEvent(ActionCategory paramActionCategory, String paramString1, String paramString2, TrackingData paramTrackingData, String paramString3, FragmentComponent paramFragmentComponent)
  {
    paramString1 = new FeedActionEventBuilder((byte)0).setControlName(paramFragmentComponent.tracker(), paramString1).setActionCategory(paramActionCategory).setModuleKey(getModuleKey(paramFragmentComponent));
    if (TextUtils.isEmpty(requestId))
    {
      paramActionCategory = "no_request_id";
      paramString1 = paramString1.setRequestId(paramActionCategory).setUpdateUrn(paramString3);
      if (paramTrackingData == null) {
        break label84;
      }
    }
    label84:
    for (paramActionCategory = trackingId;; paramActionCategory = null)
    {
      return paramString1.setTrackingId(paramActionCategory).setActionType(paramString2);
      paramActionCategory = requestId;
      break;
    }
  }
  
  private static TrackingEventBuilder createFeedCommentActionEvent(ActionCategory paramActionCategory, String paramString1, String paramString2, Update paramUpdate, Comment paramComment, FragmentComponent paramFragmentComponent)
  {
    return new FeedCommentActionEventBuilder((byte)0).setControlName(paramFragmentComponent.tracker(), paramString1).setTrackableUpdateObject(getTrackableUpdateObject(tracking, urn)).setTrackableCommentObject(getTrackableCommentObject(paramComment)).setThreadUrn(getCommentTrackingUrn(paramComment)).setActionCategory(paramActionCategory).setActionType(paramString2);
  }
  
  public static PymkClientImpressionEvent.Builder createPymkClientImpressionEvent(List<PymkUpdateDataModel.PymkRecommendationBuilder> paramList, String paramString, int paramInt1, int paramInt2)
  {
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          Object localObject = (PymkUpdateDataModel.PymkRecommendationBuilder)paramList.get(i);
          localObject = new PymkRecommendation.Builder().setRecommendationUrn(pymkUpdateUrn.toString()).setTrackingId(trackingId);
          GridPosition localGridPosition = new GridPosition.Builder().setRow(Integer.valueOf(paramInt1)).setColumn(Integer.valueOf(paramInt2)).build(RecordTemplate.Flavor.RECORD);
          hasGridPosition = true;
          gridPosition = localGridPosition;
          localArrayList.add(((PymkRecommendation.Builder)localObject).build(RecordTemplate.Flavor.RECORD));
          i += 1;
        }
        catch (BuilderException paramList)
        {
          Util.safeThrow$7a8b4789(new RuntimeException(paramList));
        }
      }
    }
    return new PymkClientImpressionEvent.Builder().setUsageContext(paramString).setRecommendations(localArrayList);
  }
  
  public static TrackingEventBuilder createTrackingComments(Comment.Builder paramBuilder, ImpressionData paramImpressionData, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if (paramBuilder != null) {
      if (!paramBoolean2) {
        break label268;
      }
    }
    for (;;)
    {
      try
      {
        hasAssociatedInputControlUrn = true;
        associatedInputControlUrn = "expand";
      }
      catch (BuilderException paramBuilder)
      {
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create FeedCommentImpressionEvent"));
      }
      Object localObject = Long.valueOf(timeViewed);
      if (localObject == null)
      {
        hasVisibleTime = false;
        visibleTime = 0L;
        localObject = Long.valueOf(duration);
        if (localObject == null)
        {
          hasDuration = false;
          duration = 0L;
          localObject = new ListPosition.Builder().setIndex(Integer.valueOf(i)).build(RecordTemplate.Flavor.RECORD);
          hasListPosition = true;
          listPosition = ((ListPosition)localObject);
          paramImpressionData = new EntityDimension.Builder().setHeight(Integer.valueOf(height)).setWidth(Integer.valueOf(width)).build(RecordTemplate.Flavor.RECORD);
          hasSize = true;
          size = paramImpressionData;
          paramBuilder.build(RecordTemplate.Flavor.RECORD);
          paramImpressionData = new FeedCommentImpressionEvent.Builder();
          paramBuilder = Collections.singletonList(paramBuilder.build(RecordTemplate.Flavor.RECORD));
          if (paramBuilder != null) {
            break label256;
          }
          hasComments = false;
          comments = null;
          return paramImpressionData;
          i = position + 1;
        }
      }
      else
      {
        hasVisibleTime = true;
        visibleTime = ((Long)localObject).longValue();
        continue;
        return null;
      }
      hasDuration = true;
      duration = ((Long)localObject).longValue();
      continue;
      label256:
      hasComments = true;
      comments = paramBuilder;
      return paramImpressionData;
      label268:
      if (!paramBoolean1) {}
    }
  }
  
  public static List<Entity> createTrackingEntitiesForUpdates(LixManager paramLixManager, List<Update> paramList, ImpressionData paramImpressionData, int paramInt)
  {
    return createTrackingEntitiesForUpdates(paramLixManager, paramList, paramImpressionData, paramInt, Integer.MAX_VALUE);
  }
  
  public static List<Entity> createTrackingEntitiesForUpdates(LixManager paramLixManager, List<Update> paramList, ImpressionData paramImpressionData, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramList == null)
    {
      localObject = null;
      return (List<Entity>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i = Math.min(paramList.size(), paramInt2);
    paramInt2 = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (paramInt2 >= i) {
        break;
      }
      localObject = createTrackingEntityForUpdate(paramLixManager, (Update)paramList.get(paramInt2), paramImpressionData, paramInt1);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      paramInt2 += 1;
    }
  }
  
  public static Entity createTrackingEntityForUpdate(LixManager paramLixManager, Update paramUpdate, ImpressionData paramImpressionData, int paramInt)
  {
    if ((paramUpdate == null) || (urn == null) || (tracking == null)) {
      return null;
    }
    return createTrackingEntityForUpdate(paramLixManager, urn.toString(), tracking, paramImpressionData, paramInt);
  }
  
  public static Entity createTrackingEntityForUpdate(LixManager paramLixManager, String paramString, TrackingData paramTrackingData, ImpressionData paramImpressionData, int paramInt)
  {
    return createTrackingEntityForUpdate(paramLixManager, paramString, paramTrackingData, paramImpressionData, paramInt, -1);
  }
  
  public static Entity createTrackingEntityForUpdate(LixManager paramLixManager, String paramString, TrackingData paramTrackingData, ImpressionData paramImpressionData, int paramInt1, int paramInt2)
  {
    if ((paramString != null) && (paramTrackingData != null)) {}
    for (;;)
    {
      try
      {
        paramString = new Entity.Builder().setUrn(paramString).setTrackingId(trackingId).setVisibleTime(Long.valueOf(timeViewed)).setDuration(Long.valueOf(duration));
        paramTrackingData = new EntityDimension.Builder().setHeight(Integer.valueOf(height)).setWidth(Integer.valueOf(width)).build(RecordTemplate.Flavor.RECORD);
        hasSize = true;
        size = paramTrackingData;
        if (paramInt2 <= 0)
        {
          paramString.setListPosition(new ListPosition.Builder().setIndex(Integer.valueOf(paramInt1)).build(RecordTemplate.Flavor.RECORD));
          if (FeedLixHelper.isEnabled(paramLixManager, Lix.FEED_FIE_VISIBLE_HEIGHT))
          {
            paramLixManager = Integer.valueOf(visibleHeight);
            if (paramLixManager == null)
            {
              hasVisibleHeight = false;
              visibleHeight = 0;
            }
          }
          else
          {
            return paramString.build(RecordTemplate.Flavor.RECORD);
          }
        }
        else
        {
          paramTrackingData = new GridPosition.Builder().setColumn(Integer.valueOf(paramInt2)).setRow(Integer.valueOf(paramInt1)).build(RecordTemplate.Flavor.RECORD);
          hasGridPosition = true;
          gridPosition = paramTrackingData;
          continue;
          return null;
        }
      }
      catch (BuilderException paramLixManager)
      {
        Util.safeThrow$7a8b4789(new RuntimeException(paramLixManager));
        CrashReporter.reportNonFatal(paramLixManager);
      }
      hasVisibleHeight = true;
      visibleHeight = paramLixManager.intValue();
    }
  }
  
  public static TrackingOnClickListener crossPromoUpdateClickListener$71752738(Update paramUpdate, FragmentComponent paramFragmentComponent, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new CrossPromoInFeedOnClickListener(paramUpdate, paramFragmentComponent, paramString1, paramString2, paramString3, new TrackingEventBuilder[0]);
    if (tracking != null) {
      paramString1.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, paramString3, "viewApp", tracking, urn, paramFragmentComponent));
    }
    return paramString1;
  }
  
  public static void fireFeedHighLightedUpdateEvent(FragmentComponent paramFragmentComponent, List<Update> paramList, highlightedUpdateSource paramhighlightedUpdateSource, MessageId paramMessageId)
  {
    Tracker localTracker = paramFragmentComponent.tracker();
    FeedHighlightedUpdateEvent.Builder localBuilder = new FeedHighlightedUpdateEvent.Builder();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add(getTrackableUpdateObject(gettracking, geturn));
      i += 1;
    }
    hasHighlightedUpdates = true;
    highlightedUpdates = localArrayList;
    paramFragmentComponent = getModuleKey(paramFragmentComponent);
    if (paramFragmentComponent == null)
    {
      hasModuleKey = false;
      moduleKey = null;
      if (paramhighlightedUpdateSource != null) {
        break label177;
      }
      hasHighlightedUpdateSource = false;
      highlightedUpdateSource = null;
      label138:
      if (paramMessageId != null) {
        break label192;
      }
      hasSourceTrackingId = false;
    }
    for (sourceTrackingId = null;; sourceTrackingId = paramMessageId)
    {
      localTracker.send(localBuilder);
      return;
      hasModuleKey = true;
      moduleKey = paramFragmentComponent;
      break;
      label177:
      hasHighlightedUpdateSource = true;
      highlightedUpdateSource = paramhighlightedUpdateSource;
      break label138;
      label192:
      hasSourceTrackingId = true;
    }
  }
  
  public static Comment.Builder generateTrackingCommentBuilder(Update paramUpdate, CommentDataModel paramCommentDataModel)
  {
    Comment.Builder localBuilder = new Comment.Builder();
    Object localObject = getTrackableCommentObject(pegasusComment);
    label58:
    label80:
    label102:
    label128:
    label142:
    int i;
    if (localObject == null)
    {
      hasTrackableCommentObject = false;
      trackableCommentObject = null;
      paramUpdate = getTrackableUpdateObject(tracking, urn);
      if (paramUpdate != null) {
        break label232;
      }
      hasTrackableUpdateObject = false;
      trackableUpdateObject = null;
      paramUpdate = getCommentTrackingUrn(pegasusComment);
      if (paramUpdate != null) {
        break label245;
      }
      hasThreadUrn = false;
      threadUrn = null;
      paramUpdate = actor.actorUrn;
      if (paramUpdate != null) {
        break label258;
      }
      hasCommenterUrn = false;
      commenterUrn = null;
      localObject = comment;
      if ((localObject != null) && (!CollectionUtils.isEmpty(values))) {
        break label271;
      }
      paramUpdate = "";
      if (paramUpdate != null) {
        break label345;
      }
      hasMessage = false;
      message = null;
      if (parentCommentUrn != null) {
        break label358;
      }
      i = 1;
      label151:
      paramUpdate = Integer.valueOf(i);
      if (paramUpdate != null) {
        break label363;
      }
      hasLevel = false;
      level = 0;
      label170:
      paramUpdate = Long.valueOf(paramCommentDataModel.getReplyCount());
      if (paramUpdate != null) {
        break label379;
      }
      hasTotalReplies = false;
    }
    for (totalReplies = 0L;; totalReplies = paramUpdate.longValue())
    {
      paramUpdate = Long.valueOf(paramCommentDataModel.getLikeCount());
      if (paramUpdate != null) {
        break label395;
      }
      hasTotalLikes = false;
      totalLikes = 0L;
      return localBuilder;
      hasTrackableCommentObject = true;
      trackableCommentObject = ((TrackingObject)localObject);
      break;
      label232:
      hasTrackableUpdateObject = true;
      trackableUpdateObject = paramUpdate;
      break label58;
      label245:
      hasThreadUrn = true;
      threadUrn = paramUpdate;
      break label80;
      label258:
      hasCommenterUrn = true;
      commenterUrn = paramUpdate;
      break label102;
      label271:
      paramUpdate = new StringBuilder();
      localObject = values;
      i = 0;
      while (i < ((List)localObject).size())
      {
        AnnotatedString localAnnotatedString = (AnnotatedString)((List)localObject).get(i);
        if (localAnnotatedString != null) {
          paramUpdate.append(value);
        }
        i += 1;
      }
      paramUpdate = paramUpdate.toString().trim();
      break label128;
      label345:
      hasMessage = true;
      message = paramUpdate;
      break label142;
      label358:
      i = 2;
      break label151;
      label363:
      hasLevel = true;
      level = paramUpdate.intValue();
      break label170;
      label379:
      hasTotalReplies = true;
    }
    label395:
    hasTotalLikes = true;
    totalLikes = paramUpdate.longValue();
    return localBuilder;
  }
  
  private static String getCommentTrackingUrn(Comment paramComment)
  {
    if (parentCommentUrn != null) {
      return parentCommentUrn.toString();
    }
    if (urn != null) {
      return urn.toString();
    }
    return null;
  }
  
  public static String getModuleKey(FragmentComponent paramFragmentComponent)
  {
    if (FeedViewTransformerHelpers.isFeedPage(paramFragmentComponent)) {
      return "home-feed:phone";
    }
    if ((FeedViewTransformerHelpers.isChannelFeedPage(paramFragmentComponent)) || (FeedViewTransformerHelpers.isAggregateFeedPage(paramFragmentComponent)) || (FeedViewTransformerHelpers.isPromptResponseListPage(paramFragmentComponent))) {
      return "mini-feed:phone";
    }
    if (FeedViewTransformerHelpers.getFeedType(paramFragmentComponent) == 5) {}
    for (int i = 1; i != 0; i = 0) {
      return "member-activity:phone";
    }
    if (FeedViewTransformerHelpers.isCompanyTab(paramFragmentComponent)) {
      return EntitiesFeedModuleKey.ENTITIES_COMPANY_PHONE.name();
    }
    if (FeedViewTransformerHelpers.isGroupTab(paramFragmentComponent)) {
      return EntitiesFeedModuleKey.ENTITIES_GROUP_PHONE.name();
    }
    if (FeedViewTransformerHelpers.isPropDetailPage(paramFragmentComponent)) {
      return "props-item:phone";
    }
    return "feed-item:phone";
  }
  
  public static NewUpdatesPillTrackingEvent getNUPTrackingEventForSwipeToRefresh(ApplicationComponent paramApplicationComponent)
  {
    return new NewUpdatesPillTrackingEvent(paramApplicationComponent, "feed_container", ControlType.GESTURE_AREA, InteractionType.SWIPE_DOWN);
  }
  
  public static NewUpdatesPillTrackingEvent getNUPTrackingEventForTappedEndOfFeedButton(ApplicationComponent paramApplicationComponent)
  {
    return new NewUpdatesPillTrackingEvent(paramApplicationComponent, "end_refresh", ControlType.BUTTON, InteractionType.SHORT_PRESS);
  }
  
  public static NewUpdatesPillTrackingEvent getNUPTrackingEventForTappedPill(ApplicationComponent paramApplicationComponent)
  {
    return new NewUpdatesPillTrackingEvent(paramApplicationComponent, "new_updates", ControlType.BUTTON, InteractionType.SHORT_PRESS);
  }
  
  public static NewUpdatesPillTrackingEvent getNUPTrackingEventForTappedTab(ApplicationComponent paramApplicationComponent)
  {
    return new NewUpdatesPillTrackingEvent(paramApplicationComponent, "nav_feed", ControlType.BUTTON, InteractionType.SHORT_PRESS);
  }
  
  public static String getPymkUsage(FragmentComponent paramFragmentComponent)
  {
    String str = "feed";
    Fragment localFragment = paramFragmentComponent.fragment();
    paramFragmentComponent = str;
    if ((localFragment instanceof Page)) {
      paramFragmentComponent = ((Page)localFragment).pageKey();
    }
    return TrackingUtils.getTrackKey(paramFragmentComponent);
  }
  
  public static String getSponsoredLandingPageUrl(TrackingData paramTrackingData)
  {
    if ((paramTrackingData != null) && (sponsoredTracking != null)) {
      return sponsoredTracking.landingUrl;
    }
    return null;
  }
  
  public static int getSponsoredRenderFormatInt(TrackingData paramTrackingData)
  {
    return getSponsoredRenderFormatInt(paramTrackingData, 2);
  }
  
  public static int getSponsoredRenderFormatInt(TrackingData paramTrackingData, int paramInt)
  {
    int i = -1;
    if (isSponsored(paramTrackingData))
    {
      assert (sponsoredTracking != null);
      if (sponsoredTracking.displayFormat != null)
      {
        paramTrackingData = sponsoredTracking.displayFormat;
        switch (paramTrackingData.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            Log.e("Sponsored Update Tracking", String.format("Unknown sponsored template type [%s] defaulting to [%s]", new Object[] { paramTrackingData, getSponsoredRenderFormatString(paramInt) }));
            return paramInt;
            if (paramTrackingData.equals("fssu_vmobile_sulabel_up"))
            {
              i = 0;
              continue;
              if (paramTrackingData.equals("fssu_vmobile_sulabel_down"))
              {
                i = 1;
                continue;
                if (paramTrackingData.equals("fssu_vmobile_sulabel_topbar")) {
                  i = 2;
                }
              }
            }
            break;
          }
        }
        return 1;
        return 2;
        return 3;
      }
    }
    return -1;
  }
  
  public static String getSponsoredRenderFormatString(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return "fssu_vmobile_sulabel_unknown";
    case -1: 
      return "fssu_vmobile_sulabel_none";
    case 1: 
      return "fssu_vmobile_sulabel_up";
    case 2: 
      return "fssu_vmobile_sulabel_down";
    }
    return "fssu_vmobile_sulabel_topbar";
  }
  
  private static TrackingObject getTrackableCommentObject(Comment paramComment)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (urn != null)
    {
      localObject1 = localObject2;
      if (entityUrn == null) {}
    }
    try
    {
      localObject1 = new TrackingObject.Builder().setObjectUrn(urn.toString()).setTrackingId(entityUrn.toString()).build(RecordTemplate.Flavor.RECORD);
      return (TrackingObject)localObject1;
    }
    catch (BuilderException paramComment)
    {
      Util.safeThrow$7a8b4789(new RuntimeException(paramComment));
    }
    return null;
  }
  
  private static TrackingObject getTrackableUpdateObject(TrackingData paramTrackingData, Urn paramUrn)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramUrn != null)
    {
      localObject1 = localObject2;
      if (paramTrackingData == null) {}
    }
    try
    {
      localObject1 = new TrackingObject.Builder().setObjectUrn(paramUrn.toString()).setTrackingId(trackingId).build(RecordTemplate.Flavor.RECORD);
      return (TrackingObject)localObject1;
    }
    catch (BuilderException paramTrackingData)
    {
      Util.safeThrow$7a8b4789(new RuntimeException(paramTrackingData));
    }
    return null;
  }
  
  public static boolean isSponsored(TrackingData paramTrackingData)
  {
    return (paramTrackingData != null) && (sponsoredTracking != null);
  }
  
  public static boolean isSponsored(Update paramUpdate, LixManager paramLixManager)
  {
    if (FeedLixHelper.isEnabled(paramLixManager, Lix.FEED_SU_ACTIVITY_TYPE)) {
      return isSponsored;
    }
    return isSponsored(tracking);
  }
  
  public static TrackingOnClickListener newAggregateUpdateClickListener(Update paramUpdate, FragmentComponent paramFragmentComponent)
  {
    AggregateUpdateOnClickListener localAggregateUpdateOnClickListener = new AggregateUpdateOnClickListener(paramUpdate, paramFragmentComponent, "view_aggregated_shares", new TrackingEventBuilder[0]);
    if (tracking != null) {
      localAggregateUpdateOnClickListener.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, "view_aggregated_shares", "viewAggregatedShares", tracking, urn, paramFragmentComponent));
    }
    return localAggregateUpdateOnClickListener;
  }
  
  public static TrackingOnClickListener newArticleClickListener(final Update paramUpdate, String paramString1, String paramString2, String paramString3, final FragmentComponent paramFragmentComponent)
  {
    String str = getSponsoredLandingPageUrl(tracking);
    if (str != null) {
      paramString1 = newSponsoredLandingPageClickListener(paramUpdate, "object", str, "viewContent", paramFragmentComponent);
    }
    do
    {
      return paramString1;
      paramString2 = new ShareArticleOnClickListener(urn.toString(), paramString1, paramString2, paramString3, paramUpdate, paramFragmentComponent, "object", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance()), paramFragmentComponent, paramUpdatetracking, "viewContent");
        }
      };
      paramString1 = paramString2;
    } while (tracking == null);
    paramString2.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, "object", "viewArticle", tracking, urn, paramFragmentComponent));
    return paramString2;
  }
  
  public static EntityClickableSpan newChannelSpan$5134f649(Channel paramChannel, FragmentComponent paramFragmentComponent, int paramInt, String paramString, Update paramUpdate, Comment paramComment)
  {
    paramChannel = new ChannelClickableSpan(paramChannel, paramFragmentComponent, paramInt, paramString, new TrackingEventBuilder[0]);
    addCustomTrackingFeedCommentActionEvent(paramChannel, ActionCategory.VIEW, paramString, "viewChannel", paramUpdate, paramComment, paramFragmentComponent);
    return paramChannel;
  }
  
  public static FeedLikeOnClickListener newCommentLikeClickListener(final Update paramUpdate, Comment paramComment, final SocialDetail paramSocialDetail, final FragmentComponent paramFragmentComponent)
  {
    boolean bool = totalSocialActivityCounts.liked;
    ActionCategory localActionCategory;
    if (bool)
    {
      localActionCategory = ActionCategory.UNLIKE;
      if (parentCommentUrn != null) {
        break label91;
      }
      if (!bool) {
        break label83;
      }
    }
    String str2;
    label83:
    for (String str1 = "unlikeComment";; str1 = "likeComment")
    {
      str2 = "comment_like_toggle";
      paramSocialDetail = new FeedLikeOnClickListener(paramSocialDetail, paramFragmentComponent, str2, new TrackingEventBuilder[0], paramSocialDetail)
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          if (paramSocialDetailtotalSocialActivityCounts.liked) {}
          for (paramAnonymousView = "unlikeComment";; paramAnonymousView = "likeComment")
          {
            FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance()), paramFragmentComponent, paramUpdatetracking, paramAnonymousView);
            return;
          }
        }
      };
      addCustomTrackingFeedCommentActionEvent(paramSocialDetail, localActionCategory, str2, str1, paramUpdate, paramComment, paramFragmentComponent);
      return paramSocialDetail;
      localActionCategory = ActionCategory.LIKE;
      break;
    }
    label91:
    if (bool) {}
    for (str1 = "unlikeReply";; str1 = "likeReply")
    {
      str2 = "reply_like_toggle";
      break;
    }
  }
  
  @Deprecated
  public static TrackingOnClickListener newCommentOnUpdateClickListener(Update paramUpdate, String paramString, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, FragmentComponent paramFragmentComponent)
  {
    if (FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent)) {
      paramString = new FeedCommentButtonOnClickListener(paramFragmentComponent, "comment");
    }
    for (;;)
    {
      if (tracking != null) {
        paramString.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.EXPAND, "comment", "expandCommentBox", tracking, urn, paramFragmentComponent));
      }
      return paramString;
      if (!TextUtils.isEmpty(paramString)) {
        paramString = new FeedViralUpdateOnClickListener(paramString, paramUpdate, paramFragmentComponent, 1, paramBoolean, paramArrayOfString1, paramArrayOfString2, "comment", new TrackingEventBuilder[0]);
      } else {
        paramString = new FeedUpdateOnClickListener(paramUpdate, paramFragmentComponent, 1, paramBoolean, paramArrayOfString1, paramArrayOfString2, "comment", new TrackingEventBuilder[0]);
      }
    }
  }
  
  public static TrackingOnClickListener newCommentOnUpdateClickListener(Update paramUpdate, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, FragmentComponent paramFragmentComponent)
  {
    if (FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent)) {}
    for (paramArrayOfString1 = new FeedCommentButtonOnClickListener(paramFragmentComponent, "comment");; paramArrayOfString1 = new FeedUpdateOnClickListener(paramUpdate, paramFragmentComponent, 1, paramBoolean, paramArrayOfString1, paramArrayOfString2, "comment", new TrackingEventBuilder[0]))
    {
      if (tracking != null) {
        paramArrayOfString1.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.EXPAND, "comment", "expandCommentBox", tracking, urn, paramFragmentComponent));
      }
      return paramArrayOfString1;
    }
  }
  
  public static TrackingOnClickListener newCommentOrderingClickListener(FragmentComponent paramFragmentComponent, TrackingData paramTrackingData, Urn paramUrn, SortOrder paramSortOrder)
  {
    paramSortOrder = new FeedToggleCommentOrderingDialogOnClickListener(paramFragmentComponent, paramTrackingData, paramUrn, paramSortOrder, "comment_sort_toggle", new TrackingEventBuilder[0]);
    if (paramTrackingData != null) {
      paramSortOrder.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.EXPAND, "comment_sort_toggle", "expandCommentSort", paramTrackingData, paramUrn, paramFragmentComponent));
    }
    return paramSortOrder;
  }
  
  public static TrackingOnClickListener newCommentReplyClickListener(Update paramUpdate, Comment paramComment1, Comment paramComment2, FragmentComponent paramFragmentComponent)
  {
    if (FeedViewTransformerHelpers.isCommentDetailPage(paramFragmentComponent)) {
      return new FeedReplyButtonOnClickListener(paramFragmentComponent, "reply", paramComment1);
    }
    if (parentCommentUrn != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramComment2 = new FeedCommentDetailOnClickListener(paramUpdate, paramComment1, paramComment2, 1, paramFragmentComponent, "reply", bool, new TrackingEventBuilder[0]);
      addCustomTrackingFeedCommentActionEvent(paramComment2, ActionCategory.VIEW, "reply", "viewCommentDetail", paramUpdate, paramComment1, paramFragmentComponent);
      return paramComment2;
    }
  }
  
  public static TrackingOnClickListener newCommentReplyTextClickListener(Update paramUpdate, Comment paramComment1, Comment paramComment2, FragmentComponent paramFragmentComponent)
  {
    paramComment2 = new FeedCommentDetailOnClickListener(paramUpdate, paramComment1, paramComment2, 0, paramFragmentComponent, "reply_text", false, new TrackingEventBuilder[0]);
    addCustomTrackingFeedCommentActionEvent(paramComment2, ActionCategory.VIEW, "reply_text", "viewCommentDetail", paramUpdate, paramComment1, paramFragmentComponent);
    return paramComment2;
  }
  
  public static TrackingOnClickListener newCommentTextClickListener(Update paramUpdate, Comment paramComment1, Comment paramComment2, FragmentComponent paramFragmentComponent)
  {
    paramComment2 = new FeedCommentDetailOnClickListener(paramUpdate, paramComment1, paramComment2, 0, paramFragmentComponent, "comment_text", false, new TrackingEventBuilder[0]);
    addCustomTrackingFeedCommentActionEvent(paramComment2, ActionCategory.VIEW, "comment_text", "viewCommentDetail", paramUpdate, paramComment1, paramFragmentComponent);
    return paramComment2;
  }
  
  public static TrackingOnClickListener newCommentViewLikesClickListener(final Update paramUpdate, Comment paramComment, final SocialDetail paramSocialDetail, final FragmentComponent paramFragmentComponent)
  {
    String str1;
    if (parentCommentUrn == null) {
      str1 = "comment_like_count";
    }
    for (String str2 = "viewCommentLikers";; str2 = "viewReplyLikers")
    {
      paramSocialDetail = new TrackingOnClickListener(paramFragmentComponent.tracker(), str1, new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          if (paramFragmentComponent.context() != null)
          {
            paramAnonymousView = paramUpdate;
            SocialDetail localSocialDetail = paramSocialDetail;
            Bundle localBundle = new Bundle();
            if (tracking != null) {
              RecordParceler.quietParcel(tracking, "trackingData", localBundle);
            }
            RecordParceler.quietParcel(localSocialDetail, "socialDetail", localBundle);
            localBundle.putString("updateUrn", urn.toString());
            if (entityUrn != null) {
              localBundle.putString("updateEntityUrn", entityUrn.toString());
            }
            localBundle.putInt("feedType", 13);
            paramAnonymousView = new LikesDetailBundleBuilder(localBundle);
            FeedBundleBuilder.saveUpdateToCache(paramFragmentComponent.dataManager(), paramUpdate);
            paramAnonymousView = paramFragmentComponentintentRegistrylikesDetailViewer.newIntent(paramFragmentComponent.context(), paramAnonymousView);
            paramFragmentComponent.context().startActivity(paramAnonymousView);
          }
          FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance()), paramFragmentComponent, paramUpdatetracking, "viewCommentLikers");
        }
      };
      addCustomTrackingFeedCommentActionEvent(paramSocialDetail, ActionCategory.VIEW, str1, str2, paramUpdate, paramComment, paramFragmentComponent);
      return paramSocialDetail;
      str1 = "reply_like_count";
    }
  }
  
  public static TrackingOnClickListener newCommentViewRepliesClickListener(Update paramUpdate, Comment paramComment, FragmentComponent paramFragmentComponent)
  {
    if (FeedViewTransformerHelpers.isCommentDetailPage(paramFragmentComponent)) {
      return new FeedCommentViewRepliesOnClickListener(paramFragmentComponent, "reply_count");
    }
    FeedCommentDetailOnClickListener localFeedCommentDetailOnClickListener = new FeedCommentDetailOnClickListener(paramUpdate, paramComment, paramFragmentComponent, "reply_count", new TrackingEventBuilder[0]);
    addCustomTrackingFeedCommentActionEvent(localFeedCommentDetailOnClickListener, ActionCategory.VIEW, "reply_count", "viewCommentDetail", paramUpdate, paramComment, paramFragmentComponent);
    return localFeedCommentDetailOnClickListener;
  }
  
  public static EntityClickableSpan newCompanySpan$604537c2(MiniCompany paramMiniCompany, FragmentComponent paramFragmentComponent, int paramInt, String paramString, Update paramUpdate, Comment paramComment)
  {
    paramMiniCompany = new CompanyClickableSpan(paramMiniCompany, paramFragmentComponent, paramInt, paramString, new TrackingEventBuilder[0]);
    addCustomTrackingFeedCommentActionEvent(paramMiniCompany, ActionCategory.VIEW, paramString, "viewCompany", paramUpdate, paramComment, paramFragmentComponent);
    return paramMiniCompany;
  }
  
  public static EntityClickableSpan newCompanySpan$6accea34(MiniCompany paramMiniCompany, FragmentComponent paramFragmentComponent, String paramString, Update paramUpdate)
  {
    return newCompanySpan$604537c2(paramMiniCompany, paramFragmentComponent, 2131623959, paramString, paramUpdate, null);
  }
  
  public static TrackingOnClickListener newConnectInvitationClickListener(FragmentComponent paramFragmentComponent, Update paramUpdate, MiniProfile paramMiniProfile)
  {
    paramMiniProfile = new ConnectInvitationOnClickListener(paramFragmentComponent, paramMiniProfile, "connect", new TrackingEventBuilder[0]);
    if (tracking != null) {
      paramMiniProfile.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.CONNECT, "connect", "connectMember", tracking, urn, paramFragmentComponent));
    }
    return paramMiniProfile;
  }
  
  public static ControlMenuOnClickListener newControlMenuClickListener(Update paramUpdate, List<UpdateActionModel> paramList, FragmentComponent paramFragmentComponent)
  {
    Object localObject1;
    if (FeedViewTransformerHelpers.isFeedPage(paramFragmentComponent))
    {
      localObject1 = "feed_container";
      if (value.crossPromoUpdateValue == null) {
        break label194;
      }
    }
    label194:
    for (Object localObject2 = new CrossPromoInFeedOnDismissListener(paramFragmentComponent.tracker(), (String)localObject1, value.crossPromoUpdateValue.legoTrackingId, value.crossPromoUpdateValue.legoTrackingToken, paramFragmentComponent, new TrackingEventBuilder[0]);; localObject2 = new TrackingDialogOnDismissListener(paramFragmentComponent.tracker(), (String)localObject1, new TrackingEventBuilder[0]))
    {
      paramList = new ControlMenuOnClickListener(paramUpdate, paramList, paramFragmentComponent, (DialogInterface.OnDismissListener)localObject2, "control_menu", new TrackingEventBuilder[0]);
      if (tracking != null)
      {
        localObject1 = createFeedActionEvent(ActionCategory.DISMISS, (String)localObject1, "dismissControl", tracking, urn, paramFragmentComponent);
        sender.addCustomTrackingEventBuilder((TrackingEventBuilder)localObject1);
        paramList.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.EXPAND, "control_menu", "expandControl", tracking, urn, paramFragmentComponent));
      }
      return paramList;
      if (FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent))
      {
        localObject1 = "feed_detail_container";
        break;
      }
      if (FeedViewTransformerHelpers.isChannelFeedPage(paramFragmentComponent))
      {
        localObject1 = "feed_channel_container";
        break;
      }
      if (FeedViewTransformerHelpers.isAggregateFeedPage(paramFragmentComponent))
      {
        localObject1 = "feed_aggregation_container";
        break;
      }
      localObject1 = "feed_unknown_container";
      break;
    }
  }
  
  public static View.OnClickListener newEllipsisTextListener(FragmentComponent paramFragmentComponent, final Update paramUpdate, final String paramString)
  {
    new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        new ControlInteractionEvent(val$fragmentComponent.tracker(), "expand", ControlType.TEXTFIELD, InteractionType.SHORT_PRESS).send();
        if ((paramUpdate != null) && (paramUpdatetracking != null))
        {
          if (FeedTracking.isSponsored(paramUpdatetracking)) {
            FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(val$fragmentComponent.tracker().getCurrentPageInstance()), val$fragmentComponent, paramUpdatetracking, paramString);
          }
          FeedTracking.trackFAE(val$fragmentComponent.tracker(), "expand", ActionCategory.EXPAND, paramString, paramUpdatetracking, paramUpdateurn, val$fragmentComponent);
        }
      }
    };
  }
  
  public static TrackingOnClickListener newEndOfFeedClickListener(Tracker paramTracker, final Bus paramBus)
  {
    new TrackingOnClickListener(paramTracker, "end_refresh", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        Bus.publish(new FeedNewUpdatesPillEvent(3));
      }
    };
  }
  
  public static TrackingOnClickListener newFollowCompanyClickListener(final FragmentComponent paramFragmentComponent, final Update paramUpdate, String paramString, FollowingInfo paramFollowingInfo)
  {
    paramString = new FeedFollowEntityOnClickListener(paramFragmentComponent, paramString, paramFollowingInfo, "follow", new TrackingEventBuilder[0], paramFragmentComponent)
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance()), paramFragmentComponent, paramUpdatetracking, "followCompany");
      }
    };
    if (tracking != null) {
      paramString.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.FOLLOW, "follow", "followCompany", tracking, urn, paramFragmentComponent));
    }
    return paramString;
  }
  
  public static TrackingOnClickListener newFollowMemberClickListener(FragmentComponent paramFragmentComponent, Update paramUpdate, String paramString, FollowingInfo paramFollowingInfo)
  {
    paramString = new FeedFollowEntityOnClickListener(paramFragmentComponent, 2, paramString, paramFollowingInfo, "follow", new TrackingEventBuilder[0]);
    if (tracking != null) {
      paramString.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.FOLLOW, "follow", "followMember", tracking, urn, paramFragmentComponent));
    }
    return paramString;
  }
  
  @Deprecated
  public static MiniGroupOnClickListener newGroupClickListener$260eace(MiniGroup paramMiniGroup, FragmentComponent paramFragmentComponent, String paramString, TrackingData paramTrackingData, Urn paramUrn)
  {
    paramMiniGroup = new MiniGroupOnClickListener(paramMiniGroup, activityactivityComponent, paramString, new TrackingEventBuilder[0]);
    if (paramTrackingData != null) {
      paramMiniGroup.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, paramString, "viewGroup", paramTrackingData, paramUrn, paramFragmentComponent));
    }
    return paramMiniGroup;
  }
  
  public static TrackingClickableSpan newGroupSpan(MiniGroup paramMiniGroup, FragmentComponent paramFragmentComponent, String paramString, Update paramUpdate)
  {
    paramMiniGroup = new GroupClickableSpan(paramMiniGroup, paramFragmentComponent, paramString, new TrackingEventBuilder[0]);
    if ((paramUpdate != null) && (tracking != null)) {
      paramMiniGroup.addCustomTrackingEventBuilderBuilder(createFeedActionEvent(ActionCategory.VIEW, paramString, "viewGroup", tracking, urn, paramFragmentComponent));
    }
    return paramMiniGroup;
  }
  
  public static HashtagSpan newHashtagSpan$6c4af0d(String paramString, FragmentComponent paramFragmentComponent, Update paramUpdate, Comment paramComment)
  {
    paramString = new HashtagSpan(paramString, paramFragmentComponent, "update_hashtag", new TrackingEventBuilder[0]);
    if (tracking != null)
    {
      paramString.addCustomTrackingEventBuilderBuilder(createFeedActionEvent(ActionCategory.VIEW, "update_hashtag", "viewSearchResults", tracking, urn, paramFragmentComponent));
      if (paramComment != null) {
        paramString.addCustomTrackingEventBuilderBuilder(createFeedCommentActionEvent(ActionCategory.VIEW, "update_hashtag", "viewSearchResults", paramUpdate, paramComment, paramFragmentComponent));
      }
    }
    return paramString;
  }
  
  public static TrackingOnClickListener newImageViewerClickListener(Update paramUpdate, boolean paramBoolean, FragmentComponent paramFragmentComponent, Image paramImage, String paramString)
  {
    Object localObject = getSponsoredLandingPageUrl(tracking);
    if (localObject != null) {
      paramImage = newSponsoredLandingPageClickListener(paramUpdate, paramString, (String)localObject, "viewContent", paramFragmentComponent);
    }
    do
    {
      return paramImage;
      localObject = new ImageViewerOnClickListener(paramUpdate, paramBoolean, paramFragmentComponent, paramImage, paramString, new TrackingEventBuilder[0]);
      paramImage = (Image)localObject;
    } while (tracking == null);
    ((ImageViewerOnClickListener)localObject).addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, paramString, "viewImage", tracking, urn, paramFragmentComponent));
    return (TrackingOnClickListener)localObject;
  }
  
  public static TrackingOnClickListener newImproveMyFeedClickListener(FragmentComponent paramFragmentComponent)
  {
    if (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_FOLLOW_HUB)) {
      return new FeedToFollowHubOnClickListener(paramFragmentComponent, "undocard_improvefeed", new TrackingEventBuilder[0]);
    }
    return new FeedToRbmfOnClickListener(paramFragmentComponent, "undocard_improvefeed", 3, new TrackingEventBuilder[0]);
  }
  
  public static TrackingOnClickListener newJobClickListener(MiniJob paramMiniJob, final FragmentComponent paramFragmentComponent, final Update paramUpdate)
  {
    paramMiniJob = new MiniJobOnClickListener(paramMiniJob, paramFragmentComponent, "object", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance()), paramFragmentComponent, paramUpdatetracking, "viewJob");
      }
    };
    if (value.crossPromoUpdateValue != null) {
      fromPromo = true;
    }
    if (tracking != null) {
      paramMiniJob.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, "object", "viewJob", tracking, urn, paramFragmentComponent));
    }
    return paramMiniJob;
  }
  
  public static TrackingOnClickListener newJymbiiSeeMoreClickListener(FragmentComponent paramFragmentComponent, Update paramUpdate, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "update_topbar";; str = "see_all_jymbii")
    {
      final Object localObject = paramFragmentComponent.intentRegistry();
      final WeakReference localWeakReference = new WeakReference(paramFragmentComponent.context());
      localObject = new TrackingOnClickListener(paramFragmentComponent.tracker(), str, new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          paramAnonymousView = (Context)localWeakReference.get();
          if (paramAnonymousView != null)
          {
            JymbiiBundleBuilder localJymbiiBundleBuilder = JymbiiBundleBuilder.create();
            paramAnonymousView.startActivity(localObjectjymbii.newIntent(paramAnonymousView, localJymbiiBundleBuilder));
          }
        }
      };
      if (tracking != null) {
        ((TrackingOnClickListener)localObject).addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, str, "viewMiniFeed", tracking, urn, paramFragmentComponent));
      }
      return (TrackingOnClickListener)localObject;
    }
  }
  
  public static FeedLikeOnClickListener newLikeClickListener(final Update paramUpdate, final FragmentComponent paramFragmentComponent)
  {
    Object localObject = null;
    if (socialDetail == null)
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Can't like an update with no social detail."));
      return null;
    }
    boolean bool = socialDetail.totalSocialActivityCounts.liked;
    ActionCategory localActionCategory;
    String str;
    if (bool)
    {
      localActionCategory = ActionCategory.UNLIKE;
      if (!bool) {
        break label132;
      }
      str = "unlikeUpdate";
      label60:
      if (tracking != null) {
        break label140;
      }
    }
    for (;;)
    {
      localObject = new FeedLikeOnClickListener(socialDetail, paramFragmentComponent, "like_toggle", (SponsoredMetadata)localObject, new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          if (paramUpdatesocialDetail.totalSocialActivityCounts.liked) {}
          for (paramAnonymousView = "unlikeUpdate";; paramAnonymousView = "likeUpdate")
          {
            FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance()), paramFragmentComponent, paramUpdatetracking, paramAnonymousView);
            return;
          }
        }
      };
      if (tracking != null) {
        ((FeedLikeOnClickListener)localObject).addCustomTrackingEventBuilder(createFeedActionEvent(localActionCategory, "like_toggle", str, tracking, urn, paramFragmentComponent));
      }
      return (FeedLikeOnClickListener)localObject;
      localActionCategory = ActionCategory.LIKE;
      break;
      label132:
      str = "likeUpdate";
      break label60;
      label140:
      localObject = tracking.sponsoredTracking;
    }
  }
  
  public static TrackingOnClickListener newLikeOrderingClickListener(FragmentComponent paramFragmentComponent, TrackingData paramTrackingData, Urn paramUrn, SortOrder paramSortOrder)
  {
    paramSortOrder = new FeedToggleLikeOrderingDialogOnClickListener(paramFragmentComponent, paramTrackingData, paramUrn, paramSortOrder, "likes_sort_toggle", new TrackingEventBuilder[0]);
    if (paramTrackingData != null) {
      paramSortOrder.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.EXPAND, "likes_sort_toggle", "expandLikesSort", paramTrackingData, paramUrn, paramFragmentComponent));
    }
    return paramSortOrder;
  }
  
  public static TrackingOnClickListener newLikesRollupClickListener(final Update paramUpdate, final FragmentComponent paramFragmentComponent, final Like paramLike)
  {
    paramLike = new TrackingOnClickListener(paramFragmentComponent.tracker(), "likes", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        ActivityComponent localActivityComponent = paramFragmentComponentactivityactivityComponent;
        Object localObject = paramUpdate;
        Bundle localBundle = new Bundle();
        if (tracking != null) {
          RecordParceler.quietParcel(tracking, "trackingData", localBundle);
        }
        RecordParceler.quietParcel(socialDetail, "socialDetail", localBundle);
        localBundle.putString("updateUrn", urn.toString());
        if (entityUrn != null) {
          localBundle.putString("updateEntityUrn", entityUrn.toString());
        }
        if (value.propUpdateValue != null) {
          localBundle.putInt("feedType", 8);
        }
        for (;;)
        {
          localObject = new LikesDetailBundleBuilder(localBundle);
          if (paramLike != null) {
            RecordParceler.quietParcel(paramLike, "highlightedLike", bundle);
          }
          FeedBundleBuilder.saveUpdateToCache(paramFragmentComponent.dataManager(), paramUpdate);
          paramAnonymousView = intentRegistrylikesDetailViewer.newIntent(paramAnonymousView.getContext(), (BundleBuilder)localObject);
          localActivityComponent.context().startActivity(paramAnonymousView);
          FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance()), paramFragmentComponent, paramUpdatetracking, "viewLikers");
          return;
          if (value.discussionUpdateValue != null) {
            localBundle.putInt("feedType", 9);
          } else {
            localBundle.putInt("feedType", 1);
          }
        }
      }
    };
    if (tracking != null) {
      paramLike.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, "likes", "viewLikers", tracking, urn, paramFragmentComponent));
    }
    return paramLike;
  }
  
  public static TrackingOnClickListener newLoadPreviousCommentsListener(final FragmentComponent paramFragmentComponent, final Update paramUpdate, final Comment paramComment)
  {
    if (FeedViewTransformerHelpers.isCommentDetailPage(paramFragmentComponent)) {}
    for (final String str = "more_replies";; str = "more_comments") {
      new TrackingOnClickListener(paramFragmentComponent.tracker(), str, new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          paramFragmentComponent.eventBus();
          Bus.publish(LoadMoreEvent.comments(0));
          FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance()), paramFragmentComponent, paramUpdatetracking, "expandMoreComments");
          FeedTracking.access$000(paramFragmentComponent, paramUpdate, str, paramComment);
        }
      };
    }
  }
  
  public static TrackingOnClickListener newLyndaVideoClickListener(Update paramUpdate, String paramString1, String paramString2, String paramString3, FragmentComponent paramFragmentComponent, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "object_description";; str = "object")
    {
      paramString1 = new ShareVideoOnClickListener(paramUpdate, paramString1, paramString2, paramString3, paramFragmentComponent, str, new TrackingEventBuilder[0]);
      if (tracking != null) {
        paramString1.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, str, "viewCourse", tracking, urn, paramFragmentComponent));
      }
      return paramString1;
    }
  }
  
  public static EntityClickableSpan newProfileSpan$627f6d3(MiniProfile paramMiniProfile, FragmentComponent paramFragmentComponent, int paramInt, String paramString, Update paramUpdate, Comment paramComment)
  {
    paramMiniProfile = new ProfileClickableSpan(paramMiniProfile, paramFragmentComponent, paramInt, paramString, new TrackingEventBuilder[0]);
    addCustomTrackingFeedCommentActionEvent(paramMiniProfile, ActionCategory.VIEW, paramString, "viewMember", paramUpdate, paramComment, paramFragmentComponent);
    return paramMiniProfile;
  }
  
  public static EntityClickableSpan newProfileSpan$6c198643(MiniProfile paramMiniProfile, FragmentComponent paramFragmentComponent, int paramInt, String paramString, Update paramUpdate)
  {
    return newProfileSpan$627f6d3(paramMiniProfile, paramFragmentComponent, paramInt, paramString, paramUpdate, null);
  }
  
  public static TrackingOnClickListener newPromptResponseUpdateClickListener(Update paramUpdate, Prompt paramPrompt, String paramString1, String paramString2, String paramString3, FragmentComponent paramFragmentComponent)
  {
    if (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_PROMPT_RESPONSE_LIST))
    {
      paramPrompt = new PromptResponseUpdateClickListener(paramPrompt, paramString1, paramFragmentComponent, paramString3, new TrackingEventBuilder[0]);
      if (tracking != null) {
        paramPrompt.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, paramString3, "viewMiniFeed", tracking, urn, paramFragmentComponent));
      }
      return paramPrompt;
    }
    return newVideoClickListener(paramUpdate, paramString2, AttributedTextUtils.getAttributedString(summary, paramFragmentComponent.context()).toString(), null, paramFragmentComponent);
  }
  
  public static TrackingOnClickListener newReshareClickListener(Update paramUpdate, FragmentComponent paramFragmentComponent)
  {
    boolean bool = FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.SHARE_HIDE_RESHARE_ACTION_SHEET);
    String str;
    if (bool)
    {
      str = "reshare";
      if (bool) {
        break label85;
      }
    }
    label85:
    for (bool = true;; bool = false)
    {
      ReshareClickListener localReshareClickListener = new ReshareClickListener(paramUpdate, paramFragmentComponent, bool, str, new TrackingEventBuilder[0]);
      if (tracking != null) {
        localReshareClickListener.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.EXPAND, str, "expandReshareBox", tracking, urn, paramFragmentComponent));
      }
      return localReshareClickListener;
      str = "reshare_actionsheet";
      break;
    }
  }
  
  public static EntityClickableSpan newSchoolSpan$14a11a9f(MiniSchool paramMiniSchool, FragmentComponent paramFragmentComponent, String paramString, Update paramUpdate)
  {
    return newSchoolSpan$16d05509(paramMiniSchool, paramFragmentComponent, 2131623959, paramString, paramUpdate, null);
  }
  
  public static EntityClickableSpan newSchoolSpan$16d05509(MiniSchool paramMiniSchool, FragmentComponent paramFragmentComponent, int paramInt, String paramString, Update paramUpdate, Comment paramComment)
  {
    paramMiniSchool = new SchoolClickableSpan(paramMiniSchool, paramFragmentComponent, paramInt, paramString, new TrackingEventBuilder[0]);
    addCustomTrackingFeedCommentActionEvent(paramMiniSchool, ActionCategory.VIEW, paramString, "viewSchool", paramUpdate, paramComment, paramFragmentComponent);
    return paramMiniSchool;
  }
  
  public static TrackingOnClickListener newSeeAllConnectionUpdatesClickListener(FragmentComponent paramFragmentComponent, Update paramUpdate, final AggregatedConnectionUpdate paramAggregatedConnectionUpdate, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "update_topbar";; str = "see_all_connection_update")
    {
      final IntentRegistry localIntentRegistry = paramFragmentComponent.intentRegistry();
      final WeakReference localWeakReference = new WeakReference(paramFragmentComponent.context());
      paramAggregatedConnectionUpdate = new TrackingOnClickListener(paramFragmentComponent.tracker(), str, new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          Context localContext = (Context)localWeakReference.get();
          if (localContext != null)
          {
            FeedActorListBundleBuilder localFeedActorListBundleBuilder = FeedActorListBundleBuilder.createConnectionUpdates(paramAggregatedConnectionUpdate);
            localContext.startActivity(localIntentRegistryfeedActorList.newIntent(paramAnonymousView.getContext(), localFeedActorListBundleBuilder));
          }
        }
      };
      if (tracking != null) {
        paramAggregatedConnectionUpdate.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, str, "viewMiniFeed", tracking, urn, paramFragmentComponent));
      }
      return paramAggregatedConnectionUpdate;
    }
  }
  
  public static TrackingOnClickListener newSeeAllPymkUpdatesClickListener(FragmentComponent paramFragmentComponent, Update paramUpdate, final AggregatedPymkUpdate paramAggregatedPymkUpdate, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "update_topbar";; str = "see_all_pymk")
    {
      final IntentRegistry localIntentRegistry = paramFragmentComponent.intentRegistry();
      final WeakReference localWeakReference = new WeakReference(paramFragmentComponent.context());
      paramAggregatedPymkUpdate = new TrackingOnClickListener(paramFragmentComponent.tracker(), str, new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          Context localContext = (Context)localWeakReference.get();
          if (localContext != null)
          {
            FeedActorListBundleBuilder localFeedActorListBundleBuilder = FeedActorListBundleBuilder.createPymkUpdates(paramAggregatedPymkUpdate);
            localContext.startActivity(localIntentRegistryfeedActorList.newIntent(paramAnonymousView.getContext(), localFeedActorListBundleBuilder));
          }
        }
      };
      if (tracking != null) {
        paramAggregatedPymkUpdate.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, str, "viewMiniFeed", tracking, urn, paramFragmentComponent));
      }
      return paramAggregatedPymkUpdate;
    }
  }
  
  public static TrackingOnClickListener newSeeAllRepliesClickListener(Update paramUpdate, Comment paramComment, FragmentComponent paramFragmentComponent)
  {
    FeedCommentDetailOnClickListener localFeedCommentDetailOnClickListener = new FeedCommentDetailOnClickListener(paramUpdate, paramComment, paramFragmentComponent, "reply_see_all", new TrackingEventBuilder[0]);
    addCustomTrackingFeedCommentActionEvent(localFeedCommentDetailOnClickListener, ActionCategory.VIEW, "reply_see_all", "viewCommentDetail", paramUpdate, paramComment, paramFragmentComponent);
    return localFeedCommentDetailOnClickListener;
  }
  
  public static TrackingOnClickListener newSeeMoreFollowRecommendationClickListener(FragmentComponent paramFragmentComponent, Update paramUpdate, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = "update_topbar";
      if (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_FOLLOW_HUB)) {
        break label79;
      }
    }
    label79:
    for (Object localObject = new FeedToFollowHubOnClickListener(paramFragmentComponent, str, new TrackingEventBuilder[0]);; localObject = new FeedToRbmfOnClickListener(paramFragmentComponent, str, 2, new TrackingEventBuilder[0]))
    {
      if (tracking != null) {
        ((TrackingOnClickListener)localObject).addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, str, "viewFollowRecommendations", tracking, urn, paramFragmentComponent));
      }
      return (TrackingOnClickListener)localObject;
      str = "see_more_people_follow_recs";
      break;
    }
  }
  
  public static TrackingOnClickListener newSponsoredLandingPageClickListener(final Update paramUpdate, String paramString1, String paramString2, final String paramString3, final FragmentComponent paramFragmentComponent)
  {
    paramString2 = new SponsoredLandingPageClickListener(paramFragmentComponent, paramUpdate, paramString1, paramString2, new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance()), paramFragmentComponent, paramUpdatetracking, paramString3);
      }
    };
    if (tracking != null) {
      paramString2.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, paramString1, "viewArticle", tracking, urn, paramFragmentComponent));
    }
    return paramString2;
  }
  
  public static UndoRemovalOnClickListener newUndoRemovalClickListener(FragmentComponent paramFragmentComponent, Update paramUpdate, UpdateActionModel paramUpdateActionModel)
  {
    UndoRemovalOnClickListener localUndoRemovalOnClickListener = new UndoRemovalOnClickListener(paramFragmentComponent, paramUpdate, paramUpdateActionModel, "control_undo", new TrackingEventBuilder[0]);
    if (tracking != null)
    {
      String str = "undoFeedback";
      if (UpdateActionModel.isUnfollowAction(type)) {
        str = "undoUnfollow";
      }
      localUndoRemovalOnClickListener.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.UNDO, "control_undo", str, tracking, urn, paramFragmentComponent));
    }
    return localUndoRemovalOnClickListener;
  }
  
  public static UndoRemovalClickableSpan newUndoSpan(FragmentComponent paramFragmentComponent, Update paramUpdate, UpdateActionModel paramUpdateActionModel)
  {
    UndoRemovalClickableSpan localUndoRemovalClickableSpan = new UndoRemovalClickableSpan(paramFragmentComponent, paramUpdate, paramUpdateActionModel, "control_undo", new TrackingEventBuilder[0]);
    if (tracking != null)
    {
      String str = "undoFeedback";
      if (UpdateActionModel.isUnfollowAction(type)) {
        str = "undoUnfollow";
      }
      localUndoRemovalClickableSpan.addCustomTrackingEventBuilderBuilder(createFeedActionEvent(ActionCategory.UNDO, "control_undo", str, tracking, urn, paramFragmentComponent));
    }
    return localUndoRemovalClickableSpan;
  }
  
  public static TrackingOnClickListener newUpdateClickListener(Update paramUpdate, FragmentComponent paramFragmentComponent, int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, final String paramString2)
  {
    paramArrayOfString1 = new FeedUpdateOnClickListener(paramUpdate, paramFragmentComponent, paramInt, paramBoolean, paramArrayOfString1, paramArrayOfString2, paramString1, new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(fragmentComponent.tracker().getCurrentPageInstance()), fragmentComponent, update.tracking, paramString2);
      }
    };
    if (tracking != null) {
      paramArrayOfString1.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, paramString1, "viewUpdateDetail", tracking, urn, paramFragmentComponent));
    }
    return paramArrayOfString1;
  }
  
  @Deprecated
  public static TrackingOnClickListener newUpdateClickListener(Update paramUpdate, String paramString1, final FragmentComponent paramFragmentComponent, int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString2, final String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1)) {}
    for (paramString1 = new FeedViralUpdateOnClickListener(paramString1, paramUpdate, paramFragmentComponent, paramInt, paramBoolean, paramArrayOfString1, paramArrayOfString2, paramString2, new TrackingEventBuilder[0])
        {
          public final void onClick(View paramAnonymousView)
          {
            super.onClick(paramAnonymousView);
            FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance()), paramFragmentComponent, update.tracking, paramString3);
          }
        };; paramString1 = new FeedUpdateOnClickListener(paramUpdate, paramFragmentComponent, paramInt, paramBoolean, paramArrayOfString1, paramArrayOfString2, paramString2, new TrackingEventBuilder[0])
        {
          public final void onClick(View paramAnonymousView)
          {
            super.onClick(paramAnonymousView);
            FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(fragmentComponent.tracker().getCurrentPageInstance()), fragmentComponent, update.tracking, paramString3);
          }
        })
    {
      if (tracking != null) {
        paramString1.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.VIEW, paramString2, "viewUpdateDetail", tracking, urn, paramFragmentComponent));
      }
      return paramString1;
    }
  }
  
  public static UrlSpan newUrlSpan(String paramString, FragmentComponent paramFragmentComponent, Update paramUpdate, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramUpdate != null) && (tracking != null)) {}
    for (paramString = new SponsoredUrlSpan(paramString, paramUpdate, paramFragmentComponent, new TrackingEventBuilder[0]);; paramString = new UrlSpan(paramString, paramFragmentComponent, new TrackingEventBuilder[0]))
    {
      if ((paramUpdate != null) && (tracking != null)) {
        paramString.addCustomTrackingEventBuilderBuilder(createFeedActionEvent(ActionCategory.VIEW, "link", "viewArticle", tracking, urn, paramFragmentComponent));
      }
      return paramString;
    }
  }
  
  public static TrackingOnClickListener newVideoClickListener(Update paramUpdate, String paramString1, String paramString2, String paramString3, FragmentComponent paramFragmentComponent)
  {
    String str = getSponsoredLandingPageUrl(tracking);
    if (str != null) {
      paramString1 = newSponsoredLandingPageClickListener(paramUpdate, "object", str, "viewContent", paramFragmentComponent);
    }
    do
    {
      return paramString1;
      paramString2 = new ShareVideoOnClickListener(paramUpdate, paramString1, paramString2, paramString3, paramFragmentComponent, "object", new TrackingEventBuilder[0]);
      paramString1 = paramString2;
    } while (tracking == null);
    paramString2.addCustomTrackingEventBuilder(createFeedActionEvent(ActionCategory.PLAY, "object", "playVideo", tracking, urn, paramFragmentComponent));
    return paramString2;
  }
  
  public static void trackCommentClick(FragmentComponent paramFragmentComponent, String paramString1, ActionCategory paramActionCategory, String paramString2, Update paramUpdate, Comment paramComment)
  {
    ControlType localControlType = ControlType.BUTTON;
    if ((paramUpdate != null) && (tracking != null))
    {
      new ControlInteractionEvent(paramFragmentComponent.tracker(), paramString1, localControlType, InteractionType.SHORT_PRESS).send();
      if (paramComment != null) {
        trackFCAE(paramFragmentComponent.tracker(), paramString1, paramActionCategory, paramString2, paramUpdate, paramComment, paramFragmentComponent);
      }
      trackFAE(paramFragmentComponent.tracker(), paramString1, paramActionCategory, paramString2, tracking, urn, paramFragmentComponent);
    }
  }
  
  public static void trackDetailFIE$5e2dcd44(Tracker paramTracker, Update paramUpdate, TrackingData paramTrackingData, long paramLong1, long paramLong2)
  {
    try
    {
      paramUpdate = new Entity.Builder().setUrn(urn.toString()).setTrackingId(trackingId).setVisibleTime(Long.valueOf(paramLong1)).setListPosition(new ListPosition.Builder().setIndex(Integer.valueOf(1)).build(RecordTemplate.Flavor.RECORD)).setDuration(Long.valueOf(paramLong2)).build(RecordTemplate.Flavor.RECORD);
      paramTracker.send(new FeedImpressionEvent.Builder().setEntities(Collections.singletonList(paramUpdate)));
      return;
    }
    catch (BuilderException paramTracker)
    {
      Util.safeThrow$7a8b4789(new RuntimeException(paramTracker));
      CrashReporter.reportNonFatal(paramTracker);
    }
  }
  
  public static void trackEntityUrnClick(FragmentComponent paramFragmentComponent, String paramString1, String paramString2, Update paramUpdate)
  {
    ActionCategory localActionCategory = ActionCategory.VIEW;
    ControlType localControlType = ControlType.LINK;
    if ((paramUpdate != null) && (tracking != null))
    {
      new ControlInteractionEvent(paramFragmentComponent.tracker(), paramString1, localControlType, InteractionType.SHORT_PRESS).send();
      trackFAE(paramFragmentComponent.tracker(), paramString1, localActionCategory, paramString2, tracking, urn, paramFragmentComponent);
    }
  }
  
  public static void trackFAE(Tracker paramTracker, String paramString1, ActionCategory paramActionCategory, String paramString2, TrackingData paramTrackingData, Urn paramUrn, FragmentComponent paramFragmentComponent)
  {
    paramTracker.send(createFeedActionEvent(paramActionCategory, paramString1, paramString2, paramTrackingData, paramUrn, paramFragmentComponent));
  }
  
  public static void trackFCAE(Tracker paramTracker, String paramString1, ActionCategory paramActionCategory, String paramString2, Update paramUpdate, Comment paramComment, FragmentComponent paramFragmentComponent)
  {
    if (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_COMMENTS_TRACKING)) {
      paramTracker.send(createFeedCommentActionEvent(paramActionCategory, paramString1, paramString2, paramUpdate, paramComment, paramFragmentComponent));
    }
  }
  
  public static void trackSponsoredAction(Map<String, String> paramMap, FragmentComponent paramFragmentComponent, TrackingData paramTrackingData, String paramString)
  {
    if ((isSponsored(paramTrackingData)) && (paramString != null))
    {
      assert (sponsoredTracking != null);
      paramFragmentComponent = paramFragmentComponent.sponsoredUpdateTracker();
      paramTrackingData = paramFragmentComponent.getTrackingInfo(paramTrackingData, sponsoredTracking);
      if (SponsoredUpdateTracker.TrackingInfo.access$200(paramTrackingData)) {
        paramFragmentComponent.actuallyTrackAction(paramMap, paramTrackingData, paramString);
      }
    }
    else
    {
      return;
    }
    pendingActionEvents.add(new SponsoredUpdateTracker.PendingActionEvent(paramTrackingData, paramString, (byte)0));
  }
  
  public static void trackUpdateActionEvent(UpdateActionEvent paramUpdateActionEvent, FragmentComponent paramFragmentComponent)
  {
    new ControlInteractionEvent(paramFragmentComponent.tracker(), updateAction.getControlName(), ControlType.BUTTON, InteractionType.SHORT_PRESS).send();
    Tracker localTracker;
    String str2;
    ActionCategory localActionCategory;
    String str1;
    if (update.tracking != null)
    {
      localTracker = paramFragmentComponent.tracker();
      str2 = updateAction.getControlName();
      switch (updateAction.type)
      {
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      default: 
        localActionCategory = ActionCategory.$UNKNOWN;
        switch (updateAction.type)
        {
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        default: 
          str1 = "";
        }
        break;
      }
    }
    for (;;)
    {
      trackFAE(localTracker, str2, localActionCategory, str1, update.tracking, update.urn, paramFragmentComponent);
      return;
      localActionCategory = ActionCategory.EXPAND;
      break;
      localActionCategory = ActionCategory.HIDE;
      break;
      localActionCategory = ActionCategory.UNFOLLOW;
      break;
      localActionCategory = ActionCategory.DELETE;
      break;
      localActionCategory = ActionCategory.LEAVE;
      break;
      localActionCategory = ActionCategory.SHARE;
      break;
      localActionCategory = ActionCategory.SHARE;
      break;
      str1 = "expandReasoning";
      continue;
      str1 = "hideSimilarUpdates";
      continue;
      str1 = "unfollowMember";
      continue;
      str1 = "unfollowCompany";
      continue;
      str1 = "unfollowChannel";
      continue;
      str1 = "unfollowSchool";
      continue;
      str1 = "unfollowGroup";
      continue;
      str1 = "expandReporting";
      continue;
      str1 = "expandSurvey";
      continue;
      str1 = "hideWrongEntity";
      continue;
      str1 = "leaveGroup";
      continue;
      str1 = "shareVia";
      continue;
      str1 = "editShare";
    }
  }
  
  private static final class FeedActionEventBuilder
    extends FeedActionEvent.Builder
  {
    private String controlName;
    private Tracker tracker;
    
    public final FeedActionEvent build()
      throws BuilderException
    {
      String str;
      if ((tracker != null) && (!TextUtils.isEmpty(controlName)))
      {
        str = TrackingUtils.makeControlUrnFromControlName(tracker, controlName);
        if (str != null) {
          break label48;
        }
        hasControlUrn = false;
      }
      for (controlUrn = null;; controlUrn = str)
      {
        return super.build();
        label48:
        hasControlUrn = true;
      }
    }
    
    public final FeedActionEventBuilder setControlName(Tracker paramTracker, String paramString)
    {
      tracker = paramTracker;
      controlName = paramString;
      return this;
    }
  }
  
  private static final class FeedCommentActionEventBuilder
    extends FeedCommentActionEvent.Builder
  {
    private String controlName;
    private Tracker tracker;
    
    public final FeedCommentActionEvent build()
      throws BuilderException
    {
      String str;
      if ((tracker != null) && (!TextUtils.isEmpty(controlName)))
      {
        str = TrackingUtils.makeControlUrnFromControlName(tracker, controlName);
        if (str != null) {
          break label48;
        }
        hasControlUrn = false;
      }
      for (controlUrn = null;; controlUrn = str)
      {
        return super.build();
        label48:
        hasControlUrn = true;
      }
    }
    
    public final FeedCommentActionEventBuilder setControlName(Tracker paramTracker, String paramString)
    {
      tracker = paramTracker;
      controlName = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */