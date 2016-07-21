package com.linkedin.android.publishing.sharing.compose;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.events.MentionStartSuggestionTrackingEvent;
import com.linkedin.android.feed.mentions.MentionsPresenter;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.shared.UrlPreviewGetter;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.tracking.MentionsTracking;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedModelGenUtils;
import com.linkedin.android.feed.utils.FeedPageType;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.feed.utils.FeedTextUtils;
import com.linkedin.android.feed.utils.FeedUpdateUtils;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.OptimisticWrite;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.MeUpdatedEvent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.shared.IntentUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.Image.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.ArticleUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.ArticleUpdate.Content;
import com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.ProviderType;
import com.linkedin.android.pegasus.gen.voyager.feed.Reshare;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareAudience;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareImage;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareJob;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareText;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdateContent.Content;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.Subscribe;

public final class FeedShareComposeFragment
  extends BaseShareComposeFragment
  implements FeedPageType
{
  Update existingShare;
  private boolean isDisplayingResharePreview;
  private TrackingData resharedSponsoredUpdateTrackingData;
  
  private void fetchPreviewFromNetwork(String paramString)
  {
    FeedShareComposeFragment.2 local2 = new FeedShareComposeFragment.2(this);
    dataManager.submit(Request.get().url(FeedRouteUtils.getSingleUpdateUrl(fragmentComponent, paramString, 0, null)).customHeaders(Tracker.createPageInstanceHeader(getPageInstance())).builder(Update.BUILDER).listener(local2).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
  }
  
  private void previewExistingShare(String paramString1, String paramString2)
  {
    FeedShareComposeFragment.1 local1 = new FeedShareComposeFragment.1(this, paramString1);
    if (paramString2 != null)
    {
      FeedBundleBuilder.loadUpdateFromCache(dataManager, local1, paramString2);
      return;
    }
    fetchPreviewFromNetwork(paramString1);
  }
  
  private void setupWithUpdateHelper(Update paramUpdate)
  {
    if ((paramUpdate == null) || (!isAdded()) || (miniProfile == null)) {
      return;
    }
    boolean bool = ShareComposeBundle.isEditShare(getArguments());
    Object localObject = getOriginalPegasusUpdatevalue.shareUpdateValue;
    if ((localObject != null) && (content.shareJobValue != null))
    {
      paramUpdate = content.shareJobValue.jobUrl;
      localObject = Tracker.createPageInstanceHeader(getPageInstance());
      UrlPreviewGetter.get((Map)localObject, paramUpdate, new BaseShareComposeFragment.UrlPreviewListener((Map)localObject, fragmentComponent, paramUpdate, true), fragmentComponent.dataManager());
      return;
    }
    clearPreview.setVisibility(8);
    detailPreview.setVisibility(0);
    contentScrollView.setFillViewport(false);
    editorBar.setPostButtonEnabled(isValidShare(computeCharacterCount()));
    localObject = ShareComposePreviewTransformer.toViewModel(fragmentComponent, viewPool, miniProfile, paramUpdate, bool);
    detailPreview.renderComponents(((FeedUpdateViewModel)localObject).getComponents(), viewPool, applicationComponent.mediaCenter());
    if (enableFyiMentions) {
      showMentionBar(1);
    }
    isDisplayingResharePreview = true;
    if (bool)
    {
      if (value.reshareValue == null) {
        break label306;
      }
      localObject = value.reshareValue.text;
    }
    for (;;)
    {
      paramUpdate = FeedTextUtils.getSpannableTextFromAnnotatedText$6851e591((AnnotatedText)localObject, paramUpdate, fragmentComponent);
      textInput.setText(paramUpdate);
      textInput.setSelection(textInput.getText().length());
      editorBar.postButton.setText(2131233689);
      detailPreview.setAlpha(getResources().getFraction(2131689476, 1, 1));
      updateTextCharacterCount(getResources(), i18NManager);
      return;
      label306:
      if (value.shareUpdateValue != null)
      {
        localObject = value.shareUpdateValue.content;
        if (shareArticleValue != null)
        {
          localObject = shareArticleValue.text;
          continue;
        }
        if (shareTextValue != null)
        {
          localObject = shareTextValue.text;
          continue;
        }
        if (shareImageValue.text != null)
        {
          localObject = shareImageValue.text;
          continue;
        }
      }
      localObject = null;
    }
  }
  
  public final int feedType()
  {
    return 16;
  }
  
  protected final TrackingEventBuilder getAlertDialogTracking(ActionCategory paramActionCategory, String paramString1, String paramString2)
  {
    if ((existingShare != null) && (existingShare.urn != null) && (existingShare.tracking != null)) {
      return FeedTracking.createFeedActionEvent(paramActionCategory, paramString1, paramString2, existingShare.tracking, existingShare.urn, fragmentComponent);
    }
    return super.getAlertDialogTracking(paramActionCategory, paramString1, paramString2);
  }
  
  protected final int getMaximumCharacterCountResource()
  {
    return 2131558492;
  }
  
  protected final int getShareType()
  {
    Bundle localBundle = getArguments();
    if (ShareComposeBundle.isEditShare(localBundle)) {
      return 4;
    }
    if (ShareComposeBundle.isReshare(localBundle)) {
      return 1;
    }
    if (hasShareItem()) {
      return 3;
    }
    return 0;
  }
  
  public final int getTrackingMode()
  {
    if (ShareComposeBundle.isReshare(getArguments())) {
      return 1;
    }
    return 0;
  }
  
  protected final void handlePostTapped()
  {
    if (enableFyiMentions) {
      textInput.append(getFyiMentionsTextToAppend());
    }
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    int i;
    if (!isValidShare(computeCharacterCount()))
    {
      i = 0;
      if (i != 0) {
        break label678;
      }
    }
    for (;;)
    {
      return;
      AnnotatedText localAnnotatedText = FeedTextUtils.getAnnotatedTextFromMentionsEditable(textInput.getText());
      if (ShareComposeBundle.isEditShare(getArguments())) {
        sharePublisher.publishEditShare(this, existingShare, localAnnotatedText);
      }
      Object localObject2;
      for (;;)
      {
        i = 1;
        break;
        if (editorBar.isSharedWithTwitter())
        {
          localObject2 = Collections.singletonList(ProviderType.TWITTER);
          label104:
          switch (editorBar.getShareVisibility())
          {
          }
        }
        for (ShareAudience localShareAudience = ShareAudience.PUBLIC;; localShareAudience = ShareAudience.CONNECTIONS)
        {
          if (currentUrlPreview == null) {
            break label183;
          }
          sharePublisher.publishUrlPreviewArticle(localMap, currentUrlPreview, localAnnotatedText, miniProfile, (List)localObject2, localShareAudience);
          break;
          localObject2 = new ArrayList();
          break label104;
        }
        label183:
        Object localObject3;
        Object localObject4;
        MiniProfile localMiniProfile;
        if (selectedImageUri != null)
        {
          localObject3 = sharePublisher;
          localObject4 = selectedImageUri;
          localMiniProfile = miniProfile;
          String str = OptimisticWrite.generateTemporaryId();
          try
          {
            Image localImage = new Image.Builder().setUrlValue(((Uri)localObject4).toString()).build();
            ((FeedSharePublisher)localObject3).publishSlideShare(new FeedSharePublisher.PendingSlideShareUpload((FeedSharePublisher)localObject3, str, (Uri)localObject4, FeedModelGenUtils.generateShareUpdate(FeedModelGenUtils.generateShareImage(localAnnotatedText, localImage, "jpg", ""), localMiniProfile, localShareAudience), (List)localObject2), localMap);
          }
          catch (BuilderException localBuilderException)
          {
            Util.safeThrow$7a8b4789(new RuntimeException("Error publishing share image", localBuilderException));
          }
        }
        else if (existingShare != null)
        {
          if ((existingShare.value.channelUpdateValue != null) && (existingShare.value.channelUpdateValue.articleUpdate != null) && (existingShare.value.channelUpdateValue.articleUpdate.value.articleUpdateValue != null))
          {
            localObject3 = existingShare.value.channelUpdateValue.articleUpdate.value.articleUpdateValue.content.shareArticleValue;
            if (localObject3 != null)
            {
              localObject4 = sharePublisher;
              localMiniProfile = miniProfile;
              ((FeedSharePublisher)localObject4).publishUrlPreviewArticle(localMap, FeedModelGenUtils.convertArticleToUrlPreviewData((ShareArticle)localObject3), localAnnotatedText, localMiniProfile, (List)localObject2, localBuilderException);
            }
            else
            {
              getActivity();
              Util.safeThrow$7a8b4789(new RuntimeException("can't share a channel article with no share article value"));
            }
          }
          else if (existingShare.value.mentionedInNewsUpdateValue != null)
          {
            localObject3 = sharePublisher;
            localObject4 = existingShare.value.mentionedInNewsUpdateValue.article;
            localMiniProfile = miniProfile;
            ((FeedSharePublisher)localObject3).publishUrlPreviewArticle(localMap, FeedModelGenUtils.convertArticleToUrlPreviewData((ShareArticle)localObject4), localAnnotatedText, localMiniProfile, (List)localObject2, localBuilderException);
          }
          else
          {
            localObject3 = sharePublisher;
            localObject1 = existingShare;
            localObject4 = miniProfile;
            boolean bool = FeedLixHelper.isEnabled(app.getAppComponent().lixManager(), Lix.FEED_RESHARE_ON_RESHARE_WRITES);
            if (value.viralUpdateValue != null) {
              localObject1 = FeedModelGenUtils.generateReshareUpdate(value.viralUpdateValue.originalUpdate, localAnnotatedText, (MiniProfile)localObject4);
            }
            for (;;)
            {
              ((FeedSharePublisher)localObject3).addPendingShare((Update)localObject1);
              ((FeedSharePublisher)localObject3).publishNewShare(localMap, (Update)localObject1, (List)localObject2);
              break;
              if ((value.reshareValue != null) && (!bool)) {
                localObject1 = FeedModelGenUtils.generateReshareUpdate(value.reshareValue.originalUpdate, localAnnotatedText, (MiniProfile)localObject4);
              } else {
                localObject1 = FeedModelGenUtils.generateReshareUpdate((Update)localObject1, localAnnotatedText, (MiniProfile)localObject4);
              }
            }
          }
        }
        else
        {
          localObject3 = sharePublisher;
          localObject4 = miniProfile;
          localObject1 = FeedModelGenUtils.generateShareUpdate(FeedModelGenUtils.generateShareText(localAnnotatedText), (MiniProfile)localObject4, (ShareAudience)localObject1);
          ((FeedSharePublisher)localObject3).addPendingShare((Update)localObject1);
          ((FeedSharePublisher)localObject3).publishNewShare(localMap, (Update)localObject1, (List)localObject2);
        }
      }
      label678:
      Object localObject1 = (BaseActivity)getActivity();
      if (localObject1 != null)
      {
        if (!ShareComposeBundle.isEditShare(getArguments())) {
          break label733;
        }
        ((BaseActivity)localObject1).finish();
      }
      while (existingShare != null)
      {
        FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(getPageInstance()), fragmentComponent, resharedSponsoredUpdateTrackingData, "submitShare");
        return;
        label733:
        localObject2 = new HomeBundle();
        activeTab = HomeTabInfo.FEED;
        localObject2 = applicationComponent.intentRegistry().home.newIntent((Context)localObject1, (BundleBuilder)localObject2);
        ((Intent)localObject2).setFlags(603979776);
        IntentUtils.grantReadUriPermission((Intent)localObject2, getActivity());
        startActivity((Intent)localObject2);
        ((BaseActivity)localObject1).finish();
      }
    }
  }
  
  protected final boolean hasShareItem()
  {
    return (super.hasShareItem()) || (existingShare != null);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    resharedSponsoredUpdateTrackingData = ShareComposeBundle.getTrackingData(getArguments());
  }
  
  @Subscribe
  public final void onEvent(MentionStartSuggestionTrackingEvent paramMentionStartSuggestionTrackingEvent)
  {
    MentionsTracking.fireMentionSuggestionStartEvent(fragmentComponent, paramMentionStartSuggestionTrackingEvent, existingShare, mentionWorkFlowId, mentionsPresenter.query, "add_commentary");
  }
  
  @Subscribe
  public final void onEvent(MeUpdatedEvent paramMeUpdatedEvent)
  {
    super.onEvent(paramMeUpdatedEvent);
    if ((!isDisplayingResharePreview) && (existingShare != null)) {
      setupWithUpdateHelper(existingShare);
    }
  }
  
  public final void onShareVisibilityChanged(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      getActivity();
      Util.safeThrow$7a8b4789(new RuntimeException("Cannot track unknown share visibility change."));
      return;
    case 0: 
      trackClickAndCustomEvent("change_visibility_twitter", ActionCategory.SELECT, "selectVisibilityTwitter");
      return;
    case 1: 
      trackClickAndCustomEvent("change_visibility_public", ActionCategory.SELECT, "selectVisibilityPublic");
      return;
    }
    trackClickAndCustomEvent("change_visibility_connections_only", ActionCategory.SELECT, "selectVisibilityConnections");
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    Object localObject2 = null;
    super.onViewCreated(paramView, paramBundle);
    Object localObject1 = getArguments();
    boolean bool1 = ShareComposeBundle.isReshare((Bundle)localObject1);
    boolean bool2 = ShareComposeBundle.isEditShare((Bundle)localObject1);
    if (bool1)
    {
      paramView = ShareComposeBundle.getUpdateId((Bundle)localObject1);
      paramBundle = ShareComposeBundle.getUpdateEntityUrn((Bundle)localObject1);
      if (paramView != null) {
        previewExistingShare(paramView, paramBundle);
      }
    }
    do
    {
      return;
      if (!bool2) {
        break;
      }
      paramView = ShareComposeBundle.getUpdateId((Bundle)localObject1);
      paramBundle = ShareComposeBundle.getUpdateEntityUrn((Bundle)localObject1);
    } while (paramView == null);
    previewExistingShare(paramView, paramBundle);
    return;
    if ((localObject1 != null) && (((Bundle)localObject1).containsKey("url_preview")))
    {
      paramView = (UrlPreviewData)RecordParceler.quietUnparcel(UrlPreviewData.BUILDER, "url_preview", (Bundle)localObject1);
      if ((localObject1 == null) || (!((Bundle)localObject1).containsKey("article_url"))) {
        break label191;
      }
      paramBundle = ((Bundle)localObject1).getString("article_url");
      label139:
      if ((localObject1 == null) || (!((Bundle)localObject1).containsKey("initial_text"))) {
        break label196;
      }
      localObject1 = ((Bundle)localObject1).getString("initial_text");
      label165:
      if (paramView == null) {
        break label202;
      }
      previewUrl(paramView);
    }
    for (;;)
    {
      editorBar.setIconState(getShareType());
      return;
      paramView = null;
      break;
      label191:
      paramBundle = null;
      break label139;
      label196:
      localObject1 = null;
      break label165;
      label202:
      if (!TextUtils.isEmpty(paramBundle))
      {
        previewArticleUrl(paramBundle);
      }
      else if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        textInput.setText((CharSequence)localObject1);
        textInput.setSelection(((String)localObject1).length());
        parseLink((CharSequence)localObject1);
      }
      else
      {
        paramBundle = getArguments();
        paramView = (View)localObject2;
        if (paramBundle != null)
        {
          paramView = (View)localObject2;
          if (paramBundle.containsKey("image_uri")) {
            paramView = (Uri)paramBundle.getParcelable("image_uri");
          }
        }
        if (paramView != null) {
          previewOriginalImage(paramView);
        } else {
          listenForPastedLinks();
        }
      }
    }
  }
  
  public final String pageKey()
  {
    if (ShareComposeBundle.isReshare(getArguments())) {
      return "feed_reshare_share";
    }
    return "feed_share";
  }
  
  public final boolean shouldTrack()
  {
    if (ShareComposeBundle.isReshare(getArguments())) {
      return getUserVisibleHint();
    }
    return false;
  }
  
  protected final void trackClickAndCustomEvent(String paramString1, ActionCategory paramActionCategory, String paramString2)
  {
    super.trackClickAndCustomEvent(paramString1, paramActionCategory, paramString2);
    if ((existingShare != null) && (existingShare.urn != null) && (existingShare.tracking != null)) {
      FeedTracking.trackFAE(tracker, paramString1, paramActionCategory, paramString2, existingShare.tracking, existingShare.urn, fragmentComponent);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.compose.FeedShareComposeFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */