package com.linkedin.android.messaging.integration;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.touch.TouchImageView;
import com.linkedin.android.ConfirmEmailAddress.EmailManagementController;
import com.linkedin.android.axle.tracking.LegoTrackingUtils;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.entities.company.CompanyBundleBuilder;
import com.linkedin.android.entities.company.CompanyIntent;
import com.linkedin.android.feed.actions.PanelDialog;
import com.linkedin.android.feed.actions.PanelDialog.PanelDialogItem;
import com.linkedin.android.feed.detail.FeedUpdateDetailBundleBuilder;
import com.linkedin.android.feed.detail.FeedUpdateDetailIntent;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider.OnboardingState;
import com.linkedin.android.home.RegisterForNavUpdatesEvent;
import com.linkedin.android.identity.profile.ProfileBundleBuilder;
import com.linkedin.android.identity.profile.ProfileViewIntent;
import com.linkedin.android.identity.shared.asyncTasks.CreateCroppedImageFileAsyncTaskInputs;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.imageloader.LiImageView.ImageViewLoadListener;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.mediaupload.MediaUploader;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.ImageQualityManager;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.MediaFilter;
import com.linkedin.android.infra.network.MprMedia;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.semaphore.ReportEntityInvokerHelper;
import com.linkedin.android.infra.shared.GhostImage;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.PhotoUtils;
import com.linkedin.android.infra.shared.ProfileIdUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Routes.QueryBuilder;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.TrackingUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.messaging.ReportMessageResponseHandler;
import com.linkedin.android.messaging.participantdetails.AddParticipantIntent;
import com.linkedin.android.messaging.reconnect.ReconnectIntent;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponseBuilder;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FileUploadTokenType;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Reshare;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialActor;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate;
import com.linkedin.android.pegasus.gen.voyager.growth.confirmation.EmailConfirmationTask;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.messaging.Conversation;
import com.linkedin.android.pegasus.gen.voyager.messaging.ConversationsMetadata;
import com.linkedin.android.pegasus.gen.voyager.messaging.Credits;
import com.linkedin.android.pegasus.gen.voyager.messaging.Event;
import com.linkedin.android.pegasus.gen.voyager.messaging.EventsMetadata;
import com.linkedin.android.pegasus.gen.voyager.messaging.TopCard;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.ConversationCreate;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreate;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreateResponse;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.Sticker;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.StickerPack;
import com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight;
import com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipientList;
import com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionSuggestions;
import com.linkedin.android.pegasus.gen.voyager.messaging.typeahead.MessagingTypeaheadResult;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadMetadata;
import com.linkedin.android.publishing.sharing.compose.ShareComposeBundle;
import com.linkedin.android.relationships.invitations.InvitationActionListener.Action;
import com.linkedin.android.relationships.invitations.InvitationsDataProvider;
import com.linkedin.android.relationships.shared.RelationshipsTracking;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject.Builder;
import com.linkedin.gen.avro2pegasus.events.messaging.ConversationActionType;
import com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.messaging.ConversationsImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionType;
import com.linkedin.gen.avro2pegasus.events.messaging.StickerAction;
import com.linkedin.gen.avro2pegasus.events.messaging.StickerActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.messaging.StickerObject.Builder;
import com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent.Builder;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.MessengerLibApi.ApiListener;
import com.linkedin.messengerlib.MessengerLibApi.BitmapResponse;
import com.linkedin.messengerlib.MessengerLibApi.CompressImageCallback;
import com.linkedin.messengerlib.MessengerLibApi.ConversationSetAttributeStateResponse;
import com.linkedin.messengerlib.MessengerLibApi.CreateConversationResponse;
import com.linkedin.messengerlib.MessengerLibApi.DeleteConversationResponse;
import com.linkedin.messengerlib.MessengerLibApi.FeedUpdateModelListener;
import com.linkedin.messengerlib.MessengerLibApi.InmailCreditsListener;
import com.linkedin.messengerlib.MessengerLibApi.MeResponse;
import com.linkedin.messengerlib.MessengerLibApi.ProfileResponse;
import com.linkedin.messengerlib.MessengerLibApi.ReconnectionSuggestionsResponse;
import com.linkedin.messengerlib.MessengerLibApi.ReportMessageResponse;
import com.linkedin.messengerlib.MessengerLibApi.SendConversationTypingIndicatorResponse;
import com.linkedin.messengerlib.MessengerLibApi.SendEmailConfirmationListener;
import com.linkedin.messengerlib.MessengerLibApi.SendMessageResponse;
import com.linkedin.messengerlib.MessengerLibApi.StickerPackResponse;
import com.linkedin.messengerlib.MessengerLibApi.UserConfirmationListener;
import com.linkedin.messengerlib.MessengerLibApi.VirusScanResponse;
import com.linkedin.messengerlib.MessengerRecordTemplateListener;
import com.linkedin.messengerlib.api.ApiModelResponse;
import com.linkedin.messengerlib.api.ConversationListApiResponse;
import com.linkedin.messengerlib.api.MessageListApiResponse;
import com.linkedin.messengerlib.api.ParticipantDataResponse;
import com.linkedin.messengerlib.api.RecipientSearchResponse;
import com.linkedin.messengerlib.api.StickerListResponse;
import com.linkedin.messengerlib.api.StickerPackListResponse;
import com.linkedin.messengerlib.api.TypeaheadApiResponse;
import com.linkedin.messengerlib.attachment.AttachmentFileType;
import com.linkedin.messengerlib.tracking.MessengerTrackingUtils;
import com.linkedin.messengerlib.ui.participantdetails.PanelActionItem;
import com.linkedin.messengerlib.utils.LongClickUtil;
import com.linkedin.messengerlib.utils.UrnParser;
import com.linkedin.security.android.ContentSource;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class MessagingLibProvider
  extends MessengerLibApi
{
  private static final String TAG = MessagingLibProvider.class.getSimpleName();
  private ActivityComponent activityComponent;
  private ApplicationComponent applicationComponent;
  private final ConversationFetcher conversationFetcher;
  private FlagshipDataManager dataManager;
  private EmailManagementController emailSender;
  private FragmentComponent fragmentComponent;
  private boolean isDetached;
  public long lastConversationListUpdateTime;
  private MemberUtil memberUtil;
  private MessagingImageFetcher messagingImageFetcher;
  private NetworkClient networkClient;
  private final PermissionsHelper permissionsHelper;
  private PhotoUtils photoUtils;
  private MessagingRequestTracking requestTracking;
  private SnackbarUtil snackbarUtil;
  private final SpInMailClickHelper spInMailClickHelper;
  private final StickersHelper stickersHelper;
  private final VirusScanHelper virusScanHelper;
  
  public MessagingLibProvider(FragmentComponent paramFragmentComponent, ApplicationComponent paramApplicationComponent, FlagshipDataManager paramFlagshipDataManager, MediaCenter paramMediaCenter, NetworkClient paramNetworkClient, EmailManagementController paramEmailManagementController, MediaUploader paramMediaUploader, MemberUtil paramMemberUtil, PhotoUtils paramPhotoUtils, MessagingRequestTracking paramMessagingRequestTracking, SnackbarUtil paramSnackbarUtil)
  {
    super(paramFragmentComponent.activity());
    fragmentComponent = paramFragmentComponent;
    applicationComponent = paramApplicationComponent;
    dataManager = paramFlagshipDataManager;
    emailSender = paramEmailManagementController;
    memberUtil = paramMemberUtil;
    photoUtils = paramPhotoUtils;
    networkClient = paramNetworkClient;
    requestTracking = paramMessagingRequestTracking;
    snackbarUtil = paramSnackbarUtil;
    spInMailClickHelper = new SpInMailClickHelper(paramMessagingRequestTracking);
    conversationFetcher = new ConversationFetcher(paramMessagingRequestTracking);
    virusScanHelper = new VirusScanHelper(paramMessagingRequestTracking);
    stickersHelper = new StickersHelper(paramMessagingRequestTracking);
    permissionsHelper = new PermissionsHelper();
    messagingImageFetcher = new MessagingImageFetcher(paramFragmentComponent, paramMediaUploader, paramMediaCenter);
  }
  
  private void fetchUpdateFromNetwork(String paramString1, String paramString2, MessengerLibApi.FeedUpdateModelListener paramFeedUpdateModelListener)
  {
    paramFeedUpdateModelListener = new MessagingLibProvider.8(this, paramFeedUpdateModelListener);
    Fragment localFragment = fragmentComponent.fragment();
    if (fragmentComponent.fragment() != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramFeedUpdateModelListener = new MessengerRecordTemplateListener(paramFeedUpdateModelListener, localFragment, bool);
      dataManager.submit(Request.get().url(FeedRouteUtils.getSingleUpdateUrl(fragmentComponent, paramString1, 0, null)).customHeaders(Tracker.createPageInstanceHeader(fragmentComponent.tracker().getCurrentPageInstance())).cacheKey(paramString2).builder(Update.BUILDER).listener(paramFeedUpdateModelListener).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
      return;
    }
  }
  
  private void getProfileForProfileId(String paramString, MessengerLibApi.ProfileResponse paramProfileResponse)
  {
    paramString = Routes.MINIPROFILE.buildUponRoot().buildUpon().appendPath(paramString).build().toString();
    paramProfileResponse = new MessagingLibProvider.2(this, paramProfileResponse);
    Fragment localFragment = fragmentComponent.fragment();
    if (fragmentComponent.fragment() != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramProfileResponse = new MessengerRecordTemplateListener(paramProfileResponse, localFragment, bool);
      dataManager.submit(Request.get().url(paramString).builder(MiniProfile.BUILDER).listener(paramProfileResponse).filter(DataManager.DataStoreFilter.ALL));
      return;
    }
  }
  
  private static String nameToUrn(Tracker paramTracker, String paramString)
  {
    return "urn:li:control:".concat(getCurrentPageInstancepageKey).concat("-").concat(paramString);
  }
  
  private void openProfile(ProfileBundleBuilder paramProfileBundleBuilder)
  {
    if (isDetached) {}
    do
    {
      return;
      if (fragmentComponent != null)
      {
        localBaseActivity = fragmentComponent.activity();
        localBaseActivity.startActivity(fragmentComponent.intentRegistry().profileView.newIntent(localBaseActivity, paramProfileBundleBuilder));
        return;
      }
    } while (activityComponent == null);
    BaseActivity localBaseActivity = activityComponent.activity();
    localBaseActivity.startActivity(activityComponent.intentRegistry().profileView.newIntent(localBaseActivity, paramProfileBundleBuilder));
  }
  
  public final void compressImage(Bitmap paramBitmap, MessengerLibApi.CompressImageCallback paramCompressImageCallback)
  {
    if (isDetached) {}
    for (;;)
    {
      return;
      BaseActivity localBaseActivity = null;
      if (fragmentComponent != null) {
        localBaseActivity = fragmentComponent.activity();
      }
      while ((localBaseActivity != null) && (photoUtils != null))
      {
        new MessagingLibProvider.1(this, photoUtils, paramCompressImageCallback).execute(new CreateCroppedImageFileAsyncTaskInputs[] { new CreateCroppedImageFileAsyncTaskInputs(localBaseActivity, paramBitmap) });
        return;
        if (activityComponent != null) {
          localBaseActivity = activityComponent.activity();
        }
      }
    }
  }
  
  public final void createConversation(ConversationCreate paramConversationCreate, MessengerLibApi.CreateConversationResponse paramCreateConversationResponse)
  {
    if (isDetached) {
      return;
    }
    ConversationFetcher localConversationFetcher = conversationFetcher;
    FragmentComponent localFragmentComponent = fragmentComponent;
    String str = Routes.MESSAGING.buildUponRoot().buildUpon().appendQueryParameter("action", "create").toString();
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("conversationCreate", PegasusPatchGenerator.modelToJSON(paramConversationCreate));
        paramCreateConversationResponse = new ConversationFetcher.3(localConversationFetcher, paramCreateConversationResponse);
        Fragment localFragment = localFragmentComponent.fragment();
        paramConversationCreate = RUMHelper.pageInit(requestTracking.pageKey);
        if (localFragment != null)
        {
          bool = true;
          paramCreateConversationResponse = new MessagingModelRumListenerWrapper(paramConversationCreate, new MessengerRecordTemplateListener(paramCreateConversationResponse, localFragment, bool));
          paramCreateConversationResponse = Request.post().url(str).model(new JsonModel(localJSONObject)).builder(new ActionResponseBuilder(EventCreateResponse.BUILDER)).listener(paramCreateConversationResponse).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
          paramCreateConversationResponse.trackingSessionId(paramConversationCreate);
          paramCreateConversationResponse.customHeaders(requestTracking.pageInstanceHeader);
          localFragmentComponent.dataManager().submit(paramCreateConversationResponse);
          return;
        }
      }
      catch (JSONException paramConversationCreate)
      {
        paramConversationCreate.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
  
  public final void deleteConversation(String paramString, MessengerLibApi.DeleteConversationResponse paramDeleteConversationResponse)
  {
    if (isDetached) {
      return;
    }
    ConversationFetcher localConversationFetcher = conversationFetcher;
    FragmentComponent localFragmentComponent = fragmentComponent;
    paramString = Routes.MESSAGING_ROOT.buildUponRoot().buildUpon().appendPath("conversations").appendPath(paramString).build().toString();
    Object localObject = new ConversationFetcher.5(localConversationFetcher, paramDeleteConversationResponse);
    Fragment localFragment = localFragmentComponent.fragment();
    paramDeleteConversationResponse = RUMHelper.pageInit(requestTracking.pageKey);
    if (localFragment != null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new MessagingModelRumListenerWrapper(paramDeleteConversationResponse, new MessengerRecordTemplateListener((RecordTemplateListener)localObject, localFragment, bool));
      paramString = Request.delete().url(paramString).model(new JsonModel(new JSONObject())).listener((RecordTemplateListener)localObject).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      paramString.trackingSessionId(paramDeleteConversationResponse);
      paramString.customHeaders(requestTracking.pageInstanceHeader);
      localFragmentComponent.dataManager().submit(paramString);
      return;
    }
  }
  
  public final void detach()
  {
    super.detach();
    activityComponent = null;
    fragmentComponent = null;
    dataManager = null;
    memberUtil = null;
    messagingImageFetcher = null;
    emailSender = null;
    photoUtils = null;
    snackbarUtil = null;
    isDetached = true;
  }
  
  public final void fetchConversationInsights(List<MiniProfile> paramList, MessengerLibApi.ApiListener<List<Insight>> paramApiListener)
  {
    ConversationFetcher localConversationFetcher = conversationFetcher;
    FragmentComponent localFragmentComponent = fragmentComponent;
    Object localObject = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((List)localObject).add(nextentityUrn.toString());
    }
    paramList = Routes.MESSAGING_CONVERSATION_INSIGHTS.buildUponRoot().buildUpon().appendQueryParameter("q", "recipients").appendQueryParameter("recipients", TextUtils.join(",", (Iterable)localObject)).toString();
    localObject = new ConversationFetcher.7(localConversationFetcher, paramApiListener);
    Fragment localFragment = localFragmentComponent.fragment();
    paramApiListener = RUMHelper.pageInit(requestTracking.pageKey);
    localObject = new MessagingModelRumListenerWrapper(paramApiListener, new MessengerRecordTemplateListener((RecordTemplateListener)localObject, localFragment, true));
    paramList = Request.get().url(paramList).builder(new CollectionTemplate.CollectionTemplateJsonParser(Insight.BUILDER, com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata.BUILDER)).listener((RecordTemplateListener)localObject).filter(DataManager.DataStoreFilter.NETWORK_ONLY).shouldUpdateCache(false);
    paramList.trackingSessionId(paramApiListener);
    paramList.customHeaders(requestTracking.pageInstanceHeader);
    localFragmentComponent.dataManager().submit(paramList);
  }
  
  public final void fetchInmailCredits(MessengerLibApi.InmailCreditsListener paramInmailCreditsListener)
  {
    if (isDetached) {
      return;
    }
    ConversationFetcher localConversationFetcher = conversationFetcher;
    FragmentComponent localFragmentComponent = fragmentComponent;
    Object localObject1 = Routes.MESSAGING_INMAIL_CREDITS.buildUponRoot().buildUpon().toString();
    Object localObject2 = new ConversationFetcher.1(localConversationFetcher, paramInmailCreditsListener);
    Fragment localFragment = localFragmentComponent.fragment();
    paramInmailCreditsListener = RUMHelper.pageInit(requestTracking.pageKey);
    if (localFragment != null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = new MessagingModelRumListenerWrapper(paramInmailCreditsListener, new MessengerRecordTemplateListener((RecordTemplateListener)localObject2, localFragment, bool));
      localObject1 = Request.get().url((String)localObject1).builder(Credits.BUILDER).listener((RecordTemplateListener)localObject2).filter(DataManager.DataStoreFilter.NETWORK_ONLY).shouldUpdateCache(false);
      ((Request.Builder)localObject1).trackingSessionId(paramInmailCreditsListener);
      ((Request.Builder)localObject1).customHeaders(requestTracking.pageInstanceHeader);
      localFragmentComponent.dataManager().submit((Request.Builder)localObject1);
      return;
    }
  }
  
  public final void fetchReconnectionSuggestions(MessengerLibApi.ReconnectionSuggestionsResponse paramReconnectionSuggestionsResponse, boolean paramBoolean)
  {
    ConversationFetcher localConversationFetcher = conversationFetcher;
    FragmentComponent localFragmentComponent = fragmentComponent;
    String str = Routes.MESSAGING_RECONNECT_BANNER.buildUponRoot().buildUpon().toString();
    Object localObject = new ConversationFetcher.8(localConversationFetcher, paramReconnectionSuggestionsResponse);
    Fragment localFragment = localFragmentComponent.fragment();
    paramReconnectionSuggestionsResponse = RUMHelper.pageInit(requestTracking.pageKey);
    boolean bool;
    if (localFragment != null)
    {
      bool = true;
      localObject = new MessagingModelRumListenerWrapper(paramReconnectionSuggestionsResponse, new MessengerRecordTemplateListener((RecordTemplateListener)localObject, localFragment, bool));
      paramReconnectionSuggestionsResponse = Request.get().url(str).builder(ReconnectionSuggestions.BUILDER).listener((RecordTemplateListener)localObject).trackingSessionId(paramReconnectionSuggestionsResponse).customHeaders(requestTracking.pageInstanceHeader);
      if (!paramBoolean) {
        break label152;
      }
      paramReconnectionSuggestionsResponse.filter(DataManager.DataStoreFilter.LOCAL_ONLY);
    }
    for (;;)
    {
      localFragmentComponent.dataManager().submit(paramReconnectionSuggestionsResponse);
      return;
      bool = false;
      break;
      label152:
      paramReconnectionSuggestionsResponse.filter(DataManager.DataStoreFilter.NETWORK_ONLY).shouldUpdateCache(true);
    }
  }
  
  public final void fireTrackingPremiumUpsellImpressionEvent(String paramString)
  {
    if (isDetached) {
      return;
    }
    SpInMailClickHelper.fireTrackingPremiumUpsellImpressionEvent(fragmentComponent, paramString);
  }
  
  public final void getConversationById(String paramString, ApiModelResponse<Conversation> paramApiModelResponse)
  {
    if (isDetached) {
      return;
    }
    paramApiModelResponse = new MessagingLibProvider.6(this, paramApiModelResponse);
    conversationFetcher.getConversation(fragmentComponent, paramApiModelResponse, paramString);
  }
  
  public final void getConversationList$573885c3(Long paramLong, String paramString1, ConversationListApiResponse paramConversationListApiResponse, String paramString2)
  {
    if (isDetached) {
      return;
    }
    ConversationFetcher localConversationFetcher = conversationFetcher;
    FragmentComponent localFragmentComponent = fragmentComponent;
    Uri.Builder localBuilder = Routes.MESSAGING.buildUponRoot().buildUpon();
    Routes.QueryBuilder localQueryBuilder = new Routes.QueryBuilder();
    if (paramLong != null) {
      localQueryBuilder.addQueryParam("createdBefore", Long.toString(paramLong.longValue()));
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!"NOFILTER".equals(paramString1)))
    {
      localQueryBuilder.addQueryParam("q", "search");
      paramLong = new ArrayList();
      paramLong.add(paramString1);
      localQueryBuilder.addBatchQueryParam("filters", paramLong);
    }
    localBuilder.encodedQuery(localQueryBuilder.build());
    paramLong = localBuilder.build().toString();
    paramString1 = new ConversationFetcher.10(localConversationFetcher, paramConversationListApiResponse, localFragmentComponent, paramLong, this);
    paramConversationListApiResponse = localFragmentComponent.fragment();
    if (paramConversationListApiResponse != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1 = new MessagingModelRumListenerWrapper(paramString2, new MessengerRecordTemplateListener(paramString1, paramConversationListApiResponse, bool));
      paramLong = Request.get().url(paramLong).builder(new CollectionTemplate.CollectionTemplateJsonParser(Conversation.BUILDER, ConversationsMetadata.BUILDER)).listener(paramString1).filter(DataManager.DataStoreFilter.NETWORK_ONLY).shouldUpdateCache(false);
      paramLong.trackingSessionId(paramString2);
      paramLong.customHeaders(requestTracking.pageInstanceHeader);
      localFragmentComponent.dataManager().submit(paramLong);
      return;
    }
  }
  
  public final void getConversationSearchList(Long paramLong, ConversationListApiResponse paramConversationListApiResponse, String paramString1, String paramString2)
  {
    if (isDetached) {
      return;
    }
    ConversationFetcher localConversationFetcher = conversationFetcher;
    FragmentComponent localFragmentComponent = fragmentComponent;
    Uri.Builder localBuilder = Routes.MESSAGING.buildUponRoot().buildUpon();
    Routes.QueryBuilder localQueryBuilder = new Routes.QueryBuilder();
    if (!TextUtils.isEmpty(paramString1))
    {
      localQueryBuilder.addQueryParam("q", "search");
      localQueryBuilder.addQueryParam("keywords", paramString1);
    }
    if (paramLong != null) {
      localQueryBuilder.addQueryParam("createdBefore", Long.toString(paramLong.longValue()));
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!"NOFILTER".equals(paramString2)))
    {
      paramLong = new ArrayList();
      paramLong.add(paramString2);
      localQueryBuilder.addBatchQueryParam("filters", paramLong);
    }
    localBuilder.encodedQuery(localQueryBuilder.build());
    paramLong = localBuilder.build().toString();
    paramString1 = new ConversationFetcher.11(localConversationFetcher, paramConversationListApiResponse, localFragmentComponent, paramLong);
    paramString2 = localFragmentComponent.fragment();
    paramConversationListApiResponse = RUMHelper.pageInit(requestTracking.pageKey);
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1 = new MessagingModelRumListenerWrapper(paramConversationListApiResponse, new MessengerRecordTemplateListener(paramString1, paramString2, bool));
      paramLong = Request.get().url(paramLong).builder(new CollectionTemplate.CollectionTemplateJsonParser(Conversation.BUILDER, ConversationsMetadata.BUILDER)).listener(paramString1).filter(DataManager.DataStoreFilter.NETWORK_ONLY).shouldUpdateCache(false);
      paramLong.trackingSessionId(paramConversationListApiResponse);
      paramLong.customHeaders(requestTracking.pageInstanceHeader);
      localFragmentComponent.dataManager().submit(paramLong);
      return;
    }
  }
  
  public final Map<String, String> getDownloadRequestHeaders(String paramString)
  {
    Map localMap = null;
    BaseActivity localBaseActivity = null;
    if (fragmentComponent != null) {
      localBaseActivity = fragmentComponent.activity();
    }
    for (;;)
    {
      if (localBaseActivity != null) {
        localMap = MessagingRequestUtils.getRequestHeaders(applicationComponent.cookieUtil(), paramString);
      }
      return localMap;
      if (activityComponent != null) {
        localBaseActivity = activityComponent.activity();
      }
    }
  }
  
  public final void getFeedUpdateModel(String paramString, MessengerLibApi.FeedUpdateModelListener paramFeedUpdateModelListener)
  {
    if (isDetached) {
      return;
    }
    String str = ShareComposeBundle.getUpdateEntityUrn(fragmentComponent.fragment().getArguments());
    MessagingLibProvider.5 local5 = new MessagingLibProvider.5(this, paramString, str, paramFeedUpdateModelListener);
    if (str != null)
    {
      FeedBundleBuilder.loadUpdateFromCache(dataManager, local5, str);
      return;
    }
    fetchUpdateFromNetwork(paramString, str, paramFeedUpdateModelListener);
  }
  
  public final Drawable getGhostDrawable(MiniProfile paramMiniProfile, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 2131492962;
    }
    while (paramMiniProfile == null)
    {
      return GhostImageUtils.getAnonymousPerson(paramInt).getDrawable(context);
      paramInt = 2131492960;
      continue;
      paramInt = 2131492961;
      continue;
      paramInt = 2131492962;
      continue;
      paramInt = 2131492963;
      continue;
      paramInt = 2131492964;
      continue;
      paramInt = 2131492967;
      continue;
      paramInt = 2131492968;
      continue;
      paramInt = 2131492969;
    }
    return GhostImageUtils.getPerson(paramInt, paramMiniProfile).getDrawable(context);
  }
  
  public final String getImageUrl(String paramString)
  {
    if (isDetached) {}
    MessagingImageFetcher localMessagingImageFetcher;
    do
    {
      return null;
      localMessagingImageFetcher = messagingImageFetcher;
    } while (TextUtils.isEmpty(paramString));
    return imageQualityManager.buildOriginalUri(paramString);
  }
  
  public final String getImageUrl(String paramString, int paramInt1, int paramInt2)
  {
    if (isDetached) {}
    MessagingImageFetcher localMessagingImageFetcher;
    do
    {
      do
      {
        return null;
        localMessagingImageFetcher = messagingImageFetcher;
      } while (TextUtils.isEmpty(paramString));
      if (fragmentComponent != null) {
        return ImageRequest.buildMprUrl(fragmentComponent.imageQualityManager(), new MprMedia(paramString, MediaFilter.CONTAIN), paramInt1, paramInt2);
      }
    } while (activityComponent == null);
    return ImageRequest.buildMprUrl(activityComponent.imageQualityManager(), new MprMedia(paramString, MediaFilter.CONTAIN), paramInt1, paramInt2);
  }
  
  public final long[] getInstalledStickerPackIds()
  {
    return applicationComponent.flagshipSharedPreferences().getInstalledStickerPackIds();
  }
  
  public final String getLoadMoreRumSessionId()
  {
    return RUMHelper.pageInit(requestTracking.loadMorePageKey);
  }
  
  public final void getMe(MessengerLibApi.MeResponse paramMeResponse)
  {
    if (isDetached) {}
    MiniProfile localMiniProfile;
    do
    {
      do
      {
        return;
      } while (memberUtil == null);
      localMiniProfile = memberUtil.getMiniProfile();
    } while (localMiniProfile == null);
    paramMeResponse.onResponse(localMiniProfile);
  }
  
  public final void getMessageList(String paramString1, String paramString2, String paramString3, MessageListApiResponse paramMessageListApiResponse)
  {
    if (isDetached) {
      return;
    }
    ConversationFetcher localConversationFetcher = conversationFetcher;
    FragmentComponent localFragmentComponent = fragmentComponent;
    String str = localFragmentComponent.flagshipSharedPreferences().getBaseUrl();
    paramString1 = Routes.MESSAGING.buildUponRoot().buildUpon().appendPath(paramString1).appendPath("events");
    if (paramString2 != null) {
      paramString1.appendQueryParameter("createdBefore", paramString2);
    }
    if (paramString3 != null) {
      paramString1.appendQueryParameter("createdAfter", paramString3);
    }
    paramString3 = new ConversationFetcher.12(localConversationFetcher, paramMessageListApiResponse, str + paramString1.toString());
    paramMessageListApiResponse = localFragmentComponent.fragment();
    paramString2 = RUMHelper.pageInit(requestTracking.pageKey);
    if (paramMessageListApiResponse != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramString3 = new MessagingModelRumListenerWrapper(paramString2, new MessengerRecordTemplateListener(paramString3, paramMessageListApiResponse, bool));
      paramString1 = Request.get().url(paramString1.toString()).builder(new CollectionTemplate.CollectionTemplateJsonParser(Event.BUILDER, EventsMetadata.BUILDER)).listener(paramString3).filter(DataManager.DataStoreFilter.NETWORK_ONLY).shouldUpdateCache(false);
      paramString1.trackingSessionId(paramString2);
      paramString1.customHeaders(requestTracking.pageInstanceHeader);
      localFragmentComponent.dataManager().submit(paramString1);
      return;
    }
  }
  
  public final void getParticipantData(String paramString, ParticipantDataResponse paramParticipantDataResponse)
  {
    if (isDetached) {
      return;
    }
    ConversationFetcher localConversationFetcher = conversationFetcher;
    FragmentComponent localFragmentComponent = fragmentComponent;
    paramString = Routes.MESSAGING.buildUponRoot().buildUpon().appendPath(paramString).appendPath("participants").toString();
    Object localObject = new ConversationFetcher.2(localConversationFetcher, paramParticipantDataResponse, localFragmentComponent, paramString);
    Fragment localFragment = localFragmentComponent.fragment();
    paramParticipantDataResponse = RUMHelper.pageInit(requestTracking.pageKey);
    if (localFragment != null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new MessagingModelRumListenerWrapper(paramParticipantDataResponse, new MessengerRecordTemplateListener((RecordTemplateListener)localObject, localFragment, bool));
      paramString = Request.get().url(paramString).builder(new CollectionTemplate.CollectionTemplateJsonParser(TopCard.BUILDER, com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata.BUILDER)).listener((RecordTemplateListener)localObject).filter(DataManager.DataStoreFilter.NETWORK_ONLY).shouldUpdateCache(false);
      paramString.trackingSessionId(paramParticipantDataResponse);
      paramString.customHeaders(requestTracking.pageInstanceHeader);
      localFragmentComponent.dataManager().submit(paramString);
      return;
    }
  }
  
  public final void getPendingInvitation(String paramString, MessengerLibApi.ApiListener<Conversation> paramApiListener)
  {
    if (isDetached) {
      return;
    }
    paramApiListener = new MessagingLibProvider.7(this, paramApiListener);
    conversationFetcher.getConversation(fragmentComponent, paramApiListener, paramString);
  }
  
  public final void getProfileForMemberId(String paramString, MessengerLibApi.ProfileResponse paramProfileResponse)
  {
    if (isDetached) {
      return;
    }
    getProfileForProfileId(paramString, paramProfileResponse);
  }
  
  public final void getProfileForMiniProfileUrn(String paramString, MessengerLibApi.ProfileResponse paramProfileResponse)
  {
    if (isDetached) {
      return;
    }
    if (UrnParser.hasSecondId(paramString)) {
      if (UrnParser.hasSecondId(paramString)) {
        paramString = paramString.substring(paramString.lastIndexOf("(") + 1, paramString.lastIndexOf(")")).split(",")[1].trim();
      }
    }
    for (;;)
    {
      getProfileForProfileId(paramString, paramProfileResponse);
      return;
      paramString = "";
      continue;
      if (UrnParser.hasSecondId(paramString)) {
        paramString = paramString.substring(paramString.lastIndexOf("("), paramString.lastIndexOf(")")).split(",")[0].trim();
      } else {
        paramString = paramString.substring(paramString.lastIndexOf(':') + 1);
      }
    }
  }
  
  public final String getRefreshPageRumSessionId()
  {
    return RUMHelper.pageInit(requestTracking.refreshPageKey);
  }
  
  public final String getRumSessionId()
  {
    return RUMHelper.pageInit(requestTracking.pageKey);
  }
  
  public final SocialActor getSocialActorForFeedUpdate(Update paramUpdate)
  {
    if (value.reshareValue != null) {
      paramUpdate = value.reshareValue.originalUpdate;
    }
    label133:
    for (;;)
    {
      SocialActor localSocialActor = null;
      if (value.discussionUpdateValue != null) {
        localSocialActor = value.discussionUpdateValue.actor;
      }
      do
      {
        return localSocialActor;
        if (value.viralUpdateValue == null) {
          break label133;
        }
        paramUpdate = value.viralUpdateValue.originalUpdate;
        break;
        if (value.reshareValue != null) {
          return value.reshareValue.actor;
        }
        if (value.shareUpdateValue != null) {
          return value.shareUpdateValue.actor;
        }
      } while (value.viralUpdateValue == null);
      return value.viralUpdateValue.actor;
    }
  }
  
  public final void getStickerPack(long paramLong, MessengerLibApi.StickerPackResponse paramStickerPackResponse)
  {
    if (isDetached) {
      return;
    }
    StickersHelper localStickersHelper = stickersHelper;
    FragmentComponent localFragmentComponent = fragmentComponent;
    Object localObject1 = Routes.MESSAGING_STICKER_PACKS.buildUponRoot().buildUpon().appendEncodedPath(String.valueOf(paramLong)).build().toString();
    Object localObject2 = new StickersHelper.2(localStickersHelper, paramStickerPackResponse);
    paramStickerPackResponse = null;
    if (requestTracking != null) {
      paramStickerPackResponse = RUMHelper.pageInit(requestTracking.pageKey);
    }
    Fragment localFragment = localFragmentComponent.fragment();
    if (localFragment != null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = new MessagingModelRumListenerWrapper(paramStickerPackResponse, new MessengerRecordTemplateListener((RecordTemplateListener)localObject2, localFragment, bool));
      localObject1 = Request.get().url((String)localObject1).builder(StickerPack.BUILDER).listener((RecordTemplateListener)localObject2).filter(DataManager.DataStoreFilter.NETWORK_ONLY).shouldUpdateCache(false);
      ((Request.Builder)localObject1).trackingSessionId(paramStickerPackResponse);
      ((Request.Builder)localObject1).customHeaders(requestTracking.pageInstanceHeader);
      localFragmentComponent.dataManager().submit((Request.Builder)localObject1);
      return;
    }
  }
  
  public final void getStickerPacks(StickerPackListResponse paramStickerPackListResponse)
  {
    if (isDetached) {
      return;
    }
    StickersHelper localStickersHelper = stickersHelper;
    FragmentComponent localFragmentComponent = fragmentComponent;
    Object localObject1 = Routes.MESSAGING_STICKER_PACKS.buildUponRoot().toString();
    Object localObject2 = new StickersHelper.1(localStickersHelper, paramStickerPackListResponse, localFragmentComponent, (String)localObject1);
    paramStickerPackListResponse = null;
    if (requestTracking != null) {
      paramStickerPackListResponse = RUMHelper.pageInit(requestTracking.pageKey);
    }
    Fragment localFragment = localFragmentComponent.fragment();
    if (localFragment != null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = new MessagingModelRumListenerWrapper(paramStickerPackListResponse, new MessengerRecordTemplateListener((RecordTemplateListener)localObject2, localFragment, bool));
      localObject1 = Request.get().url((String)localObject1).builder(new CollectionTemplate.CollectionTemplateJsonParser(StickerPack.BUILDER, com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata.BUILDER)).listener((RecordTemplateListener)localObject2).filter(DataManager.DataStoreFilter.NETWORK_ONLY).shouldUpdateCache(false);
      ((Request.Builder)localObject1).trackingSessionId(paramStickerPackListResponse);
      ((Request.Builder)localObject1).customHeaders(requestTracking.pageInstanceHeader);
      localFragmentComponent.dataManager().submit((Request.Builder)localObject1);
      return;
    }
  }
  
  public final void getStickers(long paramLong, StickerListResponse paramStickerListResponse)
  {
    if (isDetached) {
      return;
    }
    StickersHelper localStickersHelper = stickersHelper;
    FragmentComponent localFragmentComponent = fragmentComponent;
    Object localObject1 = Routes.MESSAGING_STICKER_PACKS.buildUponRoot().buildUpon().appendPath(String.valueOf(paramLong)).appendPath("stickers").build().toString();
    Object localObject2 = new StickersHelper.3(localStickersHelper, paramStickerListResponse, localFragmentComponent, (String)localObject1);
    paramStickerListResponse = null;
    if (requestTracking != null) {
      paramStickerListResponse = RUMHelper.pageInit(requestTracking.pageKey);
    }
    Fragment localFragment = localFragmentComponent.fragment();
    if (localFragment != null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = new MessagingModelRumListenerWrapper(paramStickerListResponse, new MessengerRecordTemplateListener((RecordTemplateListener)localObject2, localFragment, bool));
      localObject1 = Request.get().url((String)localObject1).builder(new CollectionTemplate.CollectionTemplateJsonParser(Sticker.BUILDER, com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata.BUILDER)).listener((RecordTemplateListener)localObject2).filter(DataManager.DataStoreFilter.NETWORK_ONLY).shouldUpdateCache(false);
      ((Request.Builder)localObject1).trackingSessionId(paramStickerListResponse);
      ((Request.Builder)localObject1).customHeaders(requestTracking.pageInstanceHeader);
      localFragmentComponent.dataManager().submit((Request.Builder)localObject1);
      return;
    }
  }
  
  public final void getSuggestedConnections(MessengerLibApi.ApiListener<List<SuggestedRecipientList>> paramApiListener)
  {
    ConversationFetcher localConversationFetcher = conversationFetcher;
    FragmentComponent localFragmentComponent = fragmentComponent;
    Object localObject1 = Routes.MESSAGING_SUGGESTED_RECIPIENTS.buildUponRoot().buildUpon().toString();
    Object localObject2 = new ConversationFetcher.9(localConversationFetcher, paramApiListener);
    Fragment localFragment = localFragmentComponent.fragment();
    paramApiListener = RUMHelper.pageInit(requestTracking.pageKey);
    localObject2 = new MessagingModelRumListenerWrapper(paramApiListener, new MessengerRecordTemplateListener((RecordTemplateListener)localObject2, localFragment, true));
    localObject1 = Request.get().url((String)localObject1).builder(new CollectionTemplate.CollectionTemplateJsonParser(SuggestedRecipientList.BUILDER, com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata.BUILDER)).listener((RecordTemplateListener)localObject2).filter(DataManager.DataStoreFilter.NETWORK_ONLY).shouldUpdateCache(false);
    ((Request.Builder)localObject1).trackingSessionId(paramApiListener);
    ((Request.Builder)localObject1).customHeaders(requestTracking.pageInstanceHeader);
    localFragmentComponent.dataManager().submit((Request.Builder)localObject1);
  }
  
  public final void getVirusScanStatus(String paramString, MessengerLibApi.VirusScanResponse paramVirusScanResponse)
  {
    if (isDetached) {
      return;
    }
    VirusScanHelper localVirusScanHelper = virusScanHelper;
    FragmentComponent localFragmentComponent = fragmentComponent;
    String str = Routes.MESSAGING_ATTACHMENTS.buildUponRoot().buildUpon().appendQueryParameter("action", "scan").toString();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject("{\"mediaId\": \"" + paramString + "\"}");
        paramVirusScanResponse = new VirusScanHelper.1(localVirusScanHelper, paramVirusScanResponse);
        paramString = null;
        if (requestTracking != null) {
          paramString = RUMHelper.pageInit(requestTracking.pageKey);
        }
        Fragment localFragment = localFragmentComponent.fragment();
        if (localFragment != null)
        {
          bool = true;
          paramVirusScanResponse = new MessagingModelRumListenerWrapper(paramString, new MessengerRecordTemplateListener(paramVirusScanResponse, localFragment, bool));
          paramVirusScanResponse = Request.post().url(str).model(new JsonModel(localJSONObject)).builder(JsonModel.BUILDER).listener(paramVirusScanResponse).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
          paramVirusScanResponse.trackingSessionId(paramString);
          paramVirusScanResponse.customHeaders(requestTracking.pageInstanceHeader);
          localFragmentComponent.dataManager().submit(paramVirusScanResponse);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
  
  public final void goToLandingPage(String paramString)
  {
    if (isDetached) {
      return;
    }
    SpInMailClickHelper.goToLandingPage(paramString, fragmentComponent.activity(), fragmentComponent.snackbarUtil(), fragmentComponent.tracker(), fragmentComponent);
  }
  
  public final boolean hasUsedConversationInsights()
  {
    return applicationComponent.flagshipSharedPreferences().getPreferences().getBoolean("hasUsedConversationInsights", false);
  }
  
  public final boolean isSafeToExecuteTransaction()
  {
    return (fragmentComponent.activity() != null) && (fragmentComponent.activity().isSafeToExecuteTransaction());
  }
  
  public final void isUserConfirmed(MessengerLibApi.UserConfirmationListener paramUserConfirmationListener)
  {
    if (isDetached) {
      return;
    }
    OnboardingDataProvider localOnboardingDataProvider = fragmentComponent.activity().activityComponent.onboardingDataProvider();
    EmailConfirmationTask localEmailConfirmationTask = localOnboardingDataProvider.getEmailConfirmationTask();
    if (localEmailConfirmationTask != null)
    {
      MessageUserConfirmationUtils.handleEmailConfirmResponse(hasEmail, paramUserConfirmationListener);
      return;
    }
    paramUserConfirmationListener = new MessageUserConfirmationUtils.1(localOnboardingDataProvider, paramUserConfirmationListener);
    activityComponent.dataManager().submit(Request.get().url(state).emailConfirmationTaskRoute).builder(EmailConfirmationTask.BUILDER).listener(paramUserConfirmationListener).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
  }
  
  public final void loadImage(Image paramImage, int paramInt, LiImageView paramLiImageView)
  {
    if (isDetached) {
      return;
    }
    paramImage = messagingImageFetcher.mediaCenter.load(paramImage);
    animateImageLoad = false;
    paramImage.placeholder(paramInt).into(paramLiImageView);
  }
  
  public final void loadImage(Image paramImage, Drawable paramDrawable, LiImageView paramLiImageView)
  {
    if (isDetached) {
      return;
    }
    paramImage = messagingImageFetcher.mediaCenter.load(paramImage);
    animateImageLoad = false;
    placeholderDrawable = paramDrawable;
    paramImage.into(paramLiImageView);
  }
  
  public final void loadImageFromFile(File paramFile, int paramInt, LiImageView paramLiImageView, LiImageView.ImageViewLoadListener paramImageViewLoadListener)
  {
    if (isDetached) {
      return;
    }
    MessagingImageFetcher localMessagingImageFetcher = messagingImageFetcher;
    paramFile = mediaCenter.load(paramFile);
    animateImageLoad = false;
    paramFile = paramFile.error(paramInt).placeholder(paramInt);
    requestListener = new MessagingImageFetcher.9(localMessagingImageFetcher, paramImageViewLoadListener);
    paramFile.into(paramLiImageView);
  }
  
  public final void loadImageFromUri(Uri paramUri, int paramInt, LiImageView paramLiImageView, LiImageView.ImageViewLoadListener paramImageViewLoadListener)
  {
    if (isDetached) {
      return;
    }
    MessagingImageFetcher localMessagingImageFetcher = messagingImageFetcher;
    paramUri = mediaCenter.load(paramUri);
    animateImageLoad = false;
    paramUri = paramUri.error(paramInt).placeholder(paramInt);
    requestListener = new MessagingImageFetcher.7(localMessagingImageFetcher, paramImageViewLoadListener);
    paramUri.into(paramLiImageView);
  }
  
  public final void loadImageFromUrl(String paramString, int paramInt, LiImageView paramLiImageView, LiImageView.ImageViewLoadListener paramImageViewLoadListener)
  {
    if (isDetached) {
      return;
    }
    MessagingImageFetcher localMessagingImageFetcher = messagingImageFetcher;
    paramString = mediaCenter.loadUrl(paramString);
    animateImageLoad = false;
    paramString = paramString.error(paramInt).placeholder(paramInt);
    requestListener = new MessagingImageFetcher.2(localMessagingImageFetcher, paramImageViewLoadListener);
    paramString.into(paramLiImageView);
  }
  
  public final void loadImageFromUrl(String paramString, Drawable paramDrawable, LiImageView paramLiImageView)
  {
    if (isDetached) {
      return;
    }
    paramString = messagingImageFetcher.mediaCenter.loadUrl(paramString);
    animateImageLoad = false;
    placeholderDrawable = paramDrawable;
    paramString.into(paramLiImageView);
  }
  
  public final void loadImageFromUrl(String paramString, TouchImageView paramTouchImageView)
  {
    if (isDetached) {
      return;
    }
    MessagingImageFetcher localMessagingImageFetcher = messagingImageFetcher;
    paramTouchImageView.setTag(paramString);
    mediaCenter.loadUrl(paramString).into(new MessagingImageFetcher.4(localMessagingImageFetcher, paramTouchImageView, paramString));
  }
  
  public final void loadImageFromUrl(String paramString, MessengerLibApi.BitmapResponse paramBitmapResponse)
  {
    if (isDetached) {
      return;
    }
    MessagingImageFetcher localMessagingImageFetcher = messagingImageFetcher;
    ImageRequest localImageRequest = mediaCenter.loadUrl(paramString);
    animateImageLoad = false;
    localImageRequest.into(new MessagingImageFetcher.3(localMessagingImageFetcher, paramString, paramBitmapResponse));
  }
  
  public final void loadImageFromUrl$734b4a4c(String paramString, LiImageView paramLiImageView)
  {
    if (isDetached) {
      return;
    }
    paramString = messagingImageFetcher.mediaCenter.loadUrl(paramString);
    animateImageLoad = false;
    paramString.placeholder(2130838697).into(paramLiImageView);
  }
  
  public final LongClickUtil longClickUtil()
  {
    return fragmentComponent.messengerLongClickUtil();
  }
  
  public final void markSponsoredInMailActioned(String paramString1, String paramString2)
  {
    if (isDetached) {
      return;
    }
    SpInMailClickHelper localSpInMailClickHelper = spInMailClickHelper;
    FragmentComponent localFragmentComponent = fragmentComponent;
    paramString2 = Routes.MESSAGING.buildUponRoot().buildUpon().appendPath(paramString1).appendPath("events").appendPath(paramString2).appendQueryParameter("action", "markActioned").toString();
    Object localObject = new SpInMailClickHelper.2(localSpInMailClickHelper);
    paramString1 = null;
    if (requestTracking != null) {
      paramString1 = RUMHelper.pageInit(requestTracking.pageKey);
    }
    Fragment localFragment = localFragmentComponent.fragment();
    if (localFragment != null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new MessagingModelRumListenerWrapper(paramString1, new MessengerRecordTemplateListener((RecordTemplateListener)localObject, localFragment, bool));
      paramString2 = Request.post().url(paramString2).model(new JsonModel(new JSONObject())).listener((RecordTemplateListener)localObject).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      paramString2.trackingSessionId(paramString1);
      paramString2.customHeaders(requestTracking.pageInstanceHeader);
      localFragmentComponent.dataManager().submit(paramString2);
      return;
    }
  }
  
  public final void onBackPressed$1385ff()
  {
    fragmentComponent.activity().isSoftwareBack = true;
    fragmentComponent.activity().onBackPressed();
  }
  
  public final void openAddParticipantActivity(long paramLong, String paramString)
  {
    if (isDetached) {}
    com.linkedin.android.messaging.participantdetails.AddParticipantBundleBuilder localAddParticipantBundleBuilder;
    do
    {
      return;
      localAddParticipantBundleBuilder = new com.linkedin.android.messaging.participantdetails.AddParticipantBundleBuilder();
      bundle.putLong("CONVERSATION_ID", paramLong);
      bundle.putString("CONVERSATION_REMOTE_ID", paramString);
      if (fragmentComponent != null)
      {
        paramString = fragmentComponent.activity();
        paramString = fragmentComponent.intentRegistry().addParticipantIntent.newIntent(paramString, localAddParticipantBundleBuilder);
        fragmentComponent.activity().startActivityForResult(paramString, 1000);
        return;
      }
    } while (activityComponent == null);
    paramString = activityComponent.activity();
    paramString = activityComponent.intentRegistry().addParticipantIntent.newIntent(paramString, localAddParticipantBundleBuilder);
    activityComponent.activity().startActivityForResult(paramString, 1000);
  }
  
  public final void openCompany(MiniCompany paramMiniCompany)
  {
    if ((isDetached) || (fragmentComponent == null)) {
      return;
    }
    BaseActivity localBaseActivity = fragmentComponent.activity();
    paramMiniCompany = CompanyBundleBuilder.create(paramMiniCompany, false);
    localBaseActivity.startActivity(fragmentComponent.intentRegistry().company.newIntent(fragmentComponent.activity(), paramMiniCompany));
  }
  
  public final void openCompose()
  {
    if (isDetached) {}
    do
    {
      return;
      if (fragmentComponent != null)
      {
        MessagingOpenerUtils.openCompose(fragmentComponent.activity(), fragmentComponent.intentRegistry());
        return;
      }
    } while (activityComponent == null);
    MessagingOpenerUtils.openCompose(activityComponent.activity(), activityComponent.intentRegistry());
  }
  
  public final void openCompose$6efb212c(String[] paramArrayOfString)
  {
    if (isDetached) {}
    do
    {
      return;
      if (fragmentComponent != null)
      {
        MessagingOpenerUtils.openCompose(fragmentComponent.activity(), fragmentComponent.intentRegistry(), paramArrayOfString, null);
        return;
      }
    } while (activityComponent == null);
    MessagingOpenerUtils.openCompose(activityComponent.activity(), activityComponent.intentRegistry(), paramArrayOfString, null);
  }
  
  public final void openComposeInReconnectMode(MiniProfile[] paramArrayOfMiniProfile, boolean paramBoolean)
  {
    if (isDetached) {}
    do
    {
      return;
      if (fragmentComponent != null)
      {
        MessagingOpenerUtils.openComposeInReconnectMode(fragmentComponent.activity(), fragmentComponent.intentRegistry(), paramArrayOfMiniProfile, paramBoolean);
        return;
      }
    } while (activityComponent == null);
    MessagingOpenerUtils.openComposeInReconnectMode(activityComponent.activity(), activityComponent.intentRegistry(), paramArrayOfMiniProfile, paramBoolean);
  }
  
  public final void openConversationDetails(long paramLong, String paramString, boolean paramBoolean)
  {
    if (isDetached) {}
    do
    {
      return;
      if (fragmentComponent != null)
      {
        MessagingOpenerUtils.openConversationDetails(fragmentComponent.activity(), fragmentComponent.intentRegistry(), paramLong, paramString, fragmentComponent.i18NManager().getString(2131232817), paramBoolean);
        return;
      }
    } while (activityComponent == null);
    MessagingOpenerUtils.openConversationDetails(activityComponent.activity(), activityComponent.intentRegistry(), paramLong, paramString, activityComponent.i18NManager().getString(2131232817), paramBoolean);
  }
  
  public final void openConversationList()
  {
    if (isDetached) {}
    do
    {
      return;
      if (fragmentComponent != null)
      {
        MessagingOpenerUtils.openConversationList(fragmentComponent.activity(), fragmentComponent.intentRegistry());
        return;
      }
    } while (activityComponent == null);
    MessagingOpenerUtils.openConversationList(activityComponent.activity(), activityComponent.intentRegistry());
  }
  
  public final void openFeedUpdateDetail(Update paramUpdate)
  {
    if ((isDetached) || (urn == null)) {
      return;
    }
    String str = urn.toString();
    if (hasEntityUrn) {}
    for (paramUpdate = entityUrn;; paramUpdate = null)
    {
      paramUpdate = FeedUpdateDetailBundleBuilder.create(str, paramUpdate);
      fragmentComponent.fragment().startActivity(fragmentComponent.intentRegistry().feedUpdateDetail.newIntent(fragmentComponent.fragment().getActivity(), paramUpdate));
      return;
    }
  }
  
  public final void openFile(Uri paramUri, String paramString)
  {
    if (isDetached) {}
    do
    {
      return;
      if (fragmentComponent != null)
      {
        MessagingOpenerUtils.openFile(fragmentComponent.activity(), paramUri, paramString);
        return;
      }
    } while (activityComponent == null);
    MessagingOpenerUtils.openFile(activityComponent.activity(), paramUri, paramString);
  }
  
  public final void openImageViewer(String paramString1, String paramString2, String paramString3, String paramString4, AttachmentFileType paramAttachmentFileType)
  {
    if (isDetached) {}
    MessagingImageFetcher localMessagingImageFetcher;
    do
    {
      return;
      localMessagingImageFetcher = messagingImageFetcher;
      if (fragmentComponent != null)
      {
        MessagingOpenerUtils.openImageViewer(fragmentComponent.activity(), fragmentComponent.intentRegistry(), paramString1, paramString2, paramString3, paramString4, paramAttachmentFileType);
        return;
      }
    } while (activityComponent == null);
    MessagingOpenerUtils.openImageViewer(activityComponent.activity(), activityComponent.intentRegistry(), paramString1, paramString2, paramString3, paramString4, paramAttachmentFileType);
  }
  
  public final void openMessageList(long paramLong, String paramString, boolean paramBoolean)
  {
    if (isDetached) {}
    do
    {
      return;
      if (fragmentComponent != null)
      {
        MessagingOpenerUtils.openMessageList(fragmentComponent.activity(), fragmentComponent.intentRegistry(), paramLong, paramString, paramBoolean);
        return;
      }
    } while (activityComponent == null);
    MessagingOpenerUtils.openMessageList(activityComponent.activity(), activityComponent.intentRegistry(), paramLong, paramString, paramBoolean);
  }
  
  public final void openPremiumChooser(String paramString)
  {
    if (isDetached) {
      return;
    }
    SpInMailClickHelper.openPremiumChooser(fragmentComponent, paramString);
  }
  
  public final void openProfile(Urn paramUrn)
  {
    openProfile(ProfileBundleBuilder.createFromProfileId(paramUrn.getId()));
  }
  
  public final void openProfile(MiniProfile paramMiniProfile)
  {
    openProfile(ProfileBundleBuilder.create(paramMiniProfile));
  }
  
  public final void openReconnectActivity()
  {
    context.startActivity(fragmentComponent.intentRegistry().reconnectIntent.newIntent(context, null));
  }
  
  public final void openSearch(int paramInt)
  {
    if (fragmentComponent != null) {
      MessagingOpenerUtils.openConversationSearch(fragmentComponent.activity(), fragmentComponent.intentRegistry(), paramInt);
    }
    while (activityComponent == null) {
      return;
    }
    MessagingOpenerUtils.openConversationSearch(activityComponent.activity(), fragmentComponent.intentRegistry(), paramInt);
  }
  
  public final void openSendEmailConfirmationDialog(MessengerLibApi.SendEmailConfirmationListener paramSendEmailConfirmationListener)
  {
    if (isDetached) {}
    FragmentComponent localFragmentComponent;
    do
    {
      return;
      localObject1 = emailSender;
      localFragmentComponent = fragmentComponent;
      localObject2 = activityactivityComponent.onboardingDataProvider().getEmailConfirmationTask();
    } while ((localObject2 == null) || (!hasEmail));
    Object localObject2 = email;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(localFragmentComponent.activity());
    localBuilder.setTitle(localFragmentComponent.i18NManager().getString(2131230827));
    localBuilder.setMessage(localFragmentComponent.i18NManager().getString(2131230828));
    localBuilder.setPositiveButton(localFragmentComponent.i18NManager().getString(2131230826), new MessageUserConfirmationUtils.2((EmailManagementController)localObject1, (String)localObject2, paramSendEmailConfirmationListener));
    localBuilder.setNegativeButton(localFragmentComponent.i18NManager().getString(2131230824), new MessageUserConfirmationUtils.3());
    localObject2 = localBuilder.show();
    paramSendEmailConfirmationListener = (TextView)((AlertDialog)localObject2).findViewById(16908299);
    Object localObject1 = ((AlertDialog)localObject2).getButton(-1);
    localObject2 = ((AlertDialog)localObject2).getButton(-2);
    paramSendEmailConfirmationListener.setTextAppearance(localFragmentComponent.activity(), 2131362374);
    ((Button)localObject1).setTextAppearance(localFragmentComponent.activity(), 2131362088);
    ((Button)localObject2).setTextAppearance(localFragmentComponent.activity(), 2131362088);
  }
  
  public final void openStickerStore()
  {
    if (fragmentComponent != null) {
      MessagingOpenerUtils.openStickerStore(fragmentComponent.activity(), fragmentComponent.intentRegistry());
    }
    while (activityComponent == null) {
      return;
    }
    MessagingOpenerUtils.openStickerStore(activityComponent.activity(), fragmentComponent.intentRegistry());
  }
  
  public final void openUrlInWebViewer(String paramString, View paramView)
  {
    if (isDetached) {
      return;
    }
    Object localObject = Uri.parse(paramString);
    if ((((Uri)localObject).getHost() != null) && (((Uri)localObject).getEncodedPath() != null) && (((Uri)localObject).getHost().contains("linkedin.com"))) {}
    for (int i = 1; (!Patterns.WEB_URL.matcher(paramString).matches()) || (i != 0); i = 0) {
      try
      {
        localObject = new Intent("android.intent.action.VIEW");
        ((Intent)localObject).setData(Uri.parse(paramString));
        fragmentComponent.activity().startActivity((Intent)localObject);
        return;
      }
      catch (ActivityNotFoundException paramString)
      {
        Snackbar.make(paramView, fragmentComponent.i18NManager().getString(2131230823), 0).show();
        return;
      }
    }
    MessengerTrackingUtils.sendPageViewEvent(fragmentComponent.tracker(), "messaging_web_viewer", false);
    paramView = WebViewerBundle.create(paramString, paramString, null, 6);
    fragmentComponent.webRouterUtil().launchWebViewer(paramView, fragmentComponent, WebRouterUtil.shouldForceIgnoreDeeplink(paramString));
  }
  
  public final void recipientSearch(String paramString, RecipientSearchResponse paramRecipientSearchResponse)
  {
    if (isDetached) {}
    while ((paramString == null) || (paramString.isEmpty())) {
      return;
    }
    paramString = Routes.TYPEAHEAD.buildUponRoot().buildUpon().appendQueryParameter("q", "federated").appendQueryParameter("query", paramString).appendQueryParameter("types", "CONNECTIONS");
    paramRecipientSearchResponse = new MessagingLibProvider.3(this, paramRecipientSearchResponse, paramString);
    Fragment localFragment = fragmentComponent.fragment();
    if (fragmentComponent.fragment() != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramRecipientSearchResponse = new MessengerRecordTemplateListener(paramRecipientSearchResponse, localFragment, bool);
      dataManager.submit(Request.get().url(paramString.build().toString()).builder(new CollectionTemplate.CollectionTemplateJsonParser(TypeaheadHit.BUILDER, TypeaheadMetadata.BUILDER)).listener(paramRecipientSearchResponse).filter(DataManager.DataStoreFilter.NETWORK_ONLY).shouldUpdateCache(false));
      return;
    }
  }
  
  public final void reportMessage(String paramString1, String paramString2, String paramString3, MessengerLibApi.ReportMessageResponse paramReportMessageResponse)
  {
    if (isDetached) {
      return;
    }
    try
    {
      localObject = Urn.createFromString(paramString1);
    }
    catch (URISyntaxException paramString2)
    {
      long l;
      label98:
      fragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("couldn't parse the urn from the miniprofile entity urn! [" + paramString1 + "]"));
      return;
    }
    try
    {
      l = ProfileIdUtils.getMemberId(((Urn)localObject).getLastId());
      localObject = Urn.createFromTuple("member", new Object[] { Long.valueOf(l) }).toString();
      str = null;
      if ((paramString3 == null) || (paramString2 == null)) {
        break label209;
      }
      str = Urn.createFromTuple("mail", new Object[] { paramString3 }).toString();
      paramString3 = Urn.createFromTuple("thread", new Object[] { paramString2 }).toString();
      paramString2 = str;
    }
    catch (NullPointerException paramString2)
    {
      com.linkedin.android.logger.Log.e(TAG, "Unable to report user because the ID is unrecognized");
      new ReportMessageResponseHandler(fragmentComponent, paramReportMessageResponse).processErrorResponse$3a729177(null);
      return;
      paramString2 = (String)localObject;
      paramString3 = str;
      break label98;
    }
    catch (IllegalArgumentException paramString2)
    {
      for (;;) {}
    }
    fragmentComponent.reportEntityInvokerHelper().invokeFlow(fragmentComponent, new ReportMessageResponseHandler(fragmentComponent, paramReportMessageResponse), ContentSource.INBOX_REPORT_SPAM, paramString2, paramString3, (String)localObject);
  }
  
  public final void requestPermissions(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if (isDetached) {}
    Fragment localFragment;
    do
    {
      return;
      localFragment = fragmentComponent.fragment();
    } while (!(localFragment instanceof BaseFragment));
    ((BaseFragment)localFragment).requestPermissions(paramArrayOfString, paramInt1, paramInt2);
  }
  
  public final void sendConversationTypingIndicator(String paramString, MessengerLibApi.SendConversationTypingIndicatorResponse paramSendConversationTypingIndicatorResponse)
  {
    if (isDetached) {
      return;
    }
    ConversationFetcher localConversationFetcher = conversationFetcher;
    FragmentComponent localFragmentComponent = fragmentComponent;
    String str = Routes.MESSAGING_ROOT.buildUponRoot().buildUpon().appendPath("conversations").appendQueryParameter("action", "typing").build().toString();
    for (;;)
    {
      try
      {
        paramString = new JSONObject().put("conversationId", paramString);
        Object localObject = new ConversationFetcher.4(localConversationFetcher, paramSendConversationTypingIndicatorResponse);
        Fragment localFragment = localFragmentComponent.fragment();
        paramSendConversationTypingIndicatorResponse = RUMHelper.pageInit(requestTracking.pageKey);
        if (localFragment != null)
        {
          bool = true;
          localObject = new MessagingModelRumListenerWrapper(paramSendConversationTypingIndicatorResponse, new MessengerRecordTemplateListener((RecordTemplateListener)localObject, localFragment, bool));
          paramString = Request.post().url(str).model(new JsonModel(paramString)).listener((RecordTemplateListener)localObject).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
          paramString.trackingSessionId(paramSendConversationTypingIndicatorResponse);
          paramString.customHeaders(requestTracking.pageInstanceHeader);
          localFragmentComponent.dataManager().submit(paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        android.util.Log.e(ConversationFetcher.TAG, "JSONException when naming conversation", paramString);
        paramSendConversationTypingIndicatorResponse.onError$698b7e31();
        return;
      }
      boolean bool = false;
    }
  }
  
  public final void sendLegoWidgetActionEvent$fd8052f(String paramString, com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory paramActionCategory)
  {
    try
    {
      LegoTrackingUtils.sendLegoWidgetActionEvent(dataManager, null, paramString, paramActionCategory);
      return;
    }
    catch (BuilderException paramString)
    {
      fragmentComponent.context();
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create lego action event", paramString));
    }
  }
  
  public final void sendLegoWidgetImpressionEvent$16da05f7(String paramString)
  {
    try
    {
      LegoTrackingUtils.sendLegoTrackingImpressionEvent(dataManager, null, paramString);
      return;
    }
    catch (BuilderException paramString)
    {
      fragmentComponent.context();
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create lego impression event", paramString));
    }
  }
  
  public final void sendMessage(String paramString, EventCreate paramEventCreate, MessengerLibApi.SendMessageResponse paramSendMessageResponse)
  {
    if (isDetached) {
      return;
    }
    conversationFetcher.sendMessageGeneral(fragmentComponent, dataManager, paramString, paramEventCreate, paramSendMessageResponse, getRumSessionId());
  }
  
  public final void setConversationMute(String paramString, boolean paramBoolean, MessengerLibApi.ConversationSetAttributeStateResponse paramConversationSetAttributeStateResponse)
  {
    if (isDetached) {
      return;
    }
    ConversationFetcher localConversationFetcher = conversationFetcher;
    FragmentComponent localFragmentComponent = fragmentComponent;
    try
    {
      localConversationFetcher.performPartialUpdateOnConversation(localFragmentComponent, paramString, PegasusPatchGenerator.INSTANCE.diffEmpty(new JSONObject().put("muted", paramBoolean)), paramConversationSetAttributeStateResponse);
      return;
    }
    catch (JSONException paramString)
    {
      android.util.Log.e(ConversationFetcher.TAG, "JSONException when mute conversation");
    }
  }
  
  public final void setConversationName(String paramString1, String paramString2, MessengerLibApi.ConversationSetAttributeStateResponse paramConversationSetAttributeStateResponse)
  {
    if (isDetached) {
      return;
    }
    ConversationFetcher localConversationFetcher = conversationFetcher;
    FragmentComponent localFragmentComponent = fragmentComponent;
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    try
    {
      localConversationFetcher.performPartialUpdateOnConversation(localFragmentComponent, paramString1, PegasusPatchGenerator.INSTANCE.diffEmpty(new JSONObject().put("name", str)), paramConversationSetAttributeStateResponse);
      return;
    }
    catch (JSONException paramString1)
    {
      android.util.Log.e(ConversationFetcher.TAG, "JSONException when naming conversation");
      paramConversationSetAttributeStateResponse.onError$698b7e31();
    }
  }
  
  public final void setConversationReadState(String paramString, boolean paramBoolean, MessengerLibApi.ConversationSetAttributeStateResponse paramConversationSetAttributeStateResponse)
  {
    if (isDetached) {
      return;
    }
    ConversationFetcher localConversationFetcher = conversationFetcher;
    FragmentComponent localFragmentComponent = fragmentComponent;
    try
    {
      localConversationFetcher.performPartialUpdateOnConversation(localFragmentComponent, paramString, PegasusPatchGenerator.INSTANCE.diffEmpty(new JSONObject().put("read", paramBoolean)), paramConversationSetAttributeStateResponse);
      return;
    }
    catch (JSONException paramString)
    {
      android.util.Log.e(ConversationFetcher.TAG, "JSONException when setting read state of a conversation");
    }
  }
  
  public final void setInstalledStickerPackIds(long[] paramArrayOfLong)
  {
    FlagshipSharedPreferences localFlagshipSharedPreferences = applicationComponent.flagshipSharedPreferences();
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfLong[i]);
      localStringBuilder.append(",");
      i += 1;
    }
    localStringBuilder.setLength(localStringBuilder.length() - 1);
    localFlagshipSharedPreferences.getPreferences().edit().putString("stickerPacks", localStringBuilder.toString()).apply();
  }
  
  public final void setInvitationResponse(Invitation paramInvitation, int paramInt, MessengerLibApi.ApiListener<Void> paramApiListener)
  {
    if (paramInt == 0) {
      fragmentComponent.invitationsDataProvider().acceptInvite(paramInvitation, new MessagingLibProvider.9(this, fragmentComponent, InvitationActionListener.Action.ACCEPT, paramApiListener));
    }
    while (paramInt != 1) {
      return;
    }
    fragmentComponent.invitationsDataProvider().ignoreInvite(paramInvitation, new MessagingLibProvider.10(this, fragmentComponent, InvitationActionListener.Action.DELETE, paramApiListener));
  }
  
  public final void showControlPanelOptions(List<PanelActionItem> paramList)
  {
    if (isDetached) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PanelActionItem localPanelActionItem = (PanelActionItem)paramList.next();
      switch (type)
      {
      default: 
        break;
      case 0: 
        localArrayList.add(new PanelDialog.PanelDialogItem(fragmentComponent.context().getString(2131232824), null, 2130838348, listener));
        break;
      case 1: 
        localArrayList.add(new PanelDialog.PanelDialogItem(fragmentComponent.context().getString(2131232822), null, 2130838012, listener));
      }
    }
    new PanelDialog(fragmentComponent).setPanelItems(localArrayList).show();
  }
  
  public final void showSnackbar(String paramString)
  {
    if (snackbarUtil == null) {}
    do
    {
      return;
      paramString = snackbarUtil.make(paramString, 0);
    } while (paramString == null);
    paramString.show();
  }
  
  public final void trackConversationDetailAction(Tracker paramTracker, String paramString1, List<String> paramList, String paramString2, int paramInt)
  {
    ConversationActionType localConversationActionType;
    switch (paramInt)
    {
    default: 
      Util.safeThrow$7a8b4789(new RuntimeException("Unrecognized conversation detail action " + paramInt + " in " + TAG));
      return;
    case 0: 
      localConversationActionType = ConversationActionType.DELETE;
    }
    for (;;)
    {
      ConversationDetailActionEvent.Builder localBuilder;
      try
      {
        localBuilder = new ConversationDetailActionEvent.Builder();
        paramString1 = new TrackingObject.Builder().setObjectUrn(paramString1).setTrackingId(TrackingUtils.generateBase64EncodedTrackingId()).build(RecordTemplate.Flavor.RECORD);
        hasConversation = true;
        conversation = paramString1;
        if (localConversationActionType != null) {
          break label331;
        }
        hasActionType = false;
        actionType = null;
        paramString1 = nameToUrn(paramTracker, paramString2);
        if (paramString1 != null) {
          break label347;
        }
        hasControlUrn = false;
        controlUrn = null;
        if (paramList != null) {
          break label362;
        }
        hasParticipantUrns = false;
        participantUrns = null;
        paramTracker.send(localBuilder);
        return;
      }
      catch (BuilderException paramTracker)
      {
        com.linkedin.android.logger.Log.e(TAG, "Unable to send ConversationDetailActionEvent", paramTracker);
        return;
      }
      localConversationActionType = ConversationActionType.FORWARD;
      continue;
      localConversationActionType = ConversationActionType.REPORT_SPAM;
      continue;
      localConversationActionType = ConversationActionType.ADD;
      continue;
      localConversationActionType = ConversationActionType.MUTE;
      continue;
      localConversationActionType = ConversationActionType.UNMUTE;
      continue;
      localConversationActionType = ConversationActionType.SEND_MESSAGE;
      continue;
      localConversationActionType = ConversationActionType.SEND_STICKER;
      continue;
      localConversationActionType = ConversationActionType.ATTACH;
      continue;
      localConversationActionType = ConversationActionType.QUICK_REPLY;
      continue;
      localConversationActionType = ConversationActionType.VIEW_PROFILE;
      continue;
      localConversationActionType = ConversationActionType.RENAME;
      continue;
      localConversationActionType = ConversationActionType.LEAVE;
      continue;
      label331:
      hasActionType = true;
      actionType = localConversationActionType;
      continue;
      label347:
      hasControlUrn = true;
      controlUrn = paramString1;
      continue;
      label362:
      hasParticipantUrns = true;
      participantUrns = paramList;
    }
  }
  
  public final void trackConversationDetailImpression(Tracker paramTracker, String paramString, List<String> paramList1, List<String> paramList2)
  {
    String str1 = TrackingUtils.generateBase64EncodedTrackingId();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str2 = (String)paramList1.next();
        localArrayList.add(new TrackingObject.Builder().setObjectUrn(str2).setTrackingId(str1).build(RecordTemplate.Flavor.RECORD));
      }
      paramList1 = new ConversationDetailImpressionEvent.Builder();
    }
    catch (BuilderException paramTracker)
    {
      com.linkedin.android.logger.Log.e(TAG, "Unable to send ConversationDetailImpressionEvent", paramTracker);
      return;
    }
    paramString = new TrackingObject.Builder().setObjectUrn(paramString).setTrackingId(str1).build(RecordTemplate.Flavor.RECORD);
    hasConversation = true;
    conversation = paramString;
    if (paramList2 == null) {
      hasParticipantUrns = false;
    }
    for (participantUrns = null;; participantUrns = paramList2)
    {
      hasMessages = true;
      messages = localArrayList;
      paramTracker.send(paramList1);
      return;
      hasParticipantUrns = true;
    }
  }
  
  public final void trackConversationsImpression(Tracker paramTracker, List<String> paramList)
  {
    String str1 = TrackingUtils.generateBase64EncodedTrackingId();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str2 = (String)paramList.next();
        localArrayList.add(new TrackingObject.Builder().setObjectUrn(str2).setTrackingId(str1).build(RecordTemplate.Flavor.RECORD));
      }
      paramList = new ConversationsImpressionEvent.Builder();
    }
    catch (BuilderException paramTracker)
    {
      com.linkedin.android.logger.Log.e(TAG, "Unable to send ConversationsImpressionEvent", paramTracker);
      return;
    }
    hasConversations = true;
    conversations = localArrayList;
    paramTracker.send(paramList);
  }
  
  public final void trackCspUrl(String paramString)
  {
    if (isDetached) {
      return;
    }
    Object localObject = spInMailClickHelper;
    NetworkClient localNetworkClient = networkClient;
    fragmentComponent.activity();
    localObject = new SpInMailClickHelper.1((SpInMailClickHelper)localObject, paramString);
    com.linkedin.android.logger.Log.d(SpInMailClickHelper.TAG, "Hitting csp tracking url: ".concat(paramString));
    localNetworkClient.add(factory.getAbsoluteRequest$3868be9b(0, paramString, (ResponseListener)localObject, null));
  }
  
  public final void trackMessagingRecommendationActionEvent(Tracker paramTracker, int paramInt, String paramString1, String paramString2)
  {
    MessagingRecommendationActionType localMessagingRecommendationActionType = MessagingRecommendationActionType.$UNKNOWN;
    MessagingRecommendationActionEvent.Builder localBuilder;
    if (paramInt == 0)
    {
      localMessagingRecommendationActionType = MessagingRecommendationActionType.EXPAND;
      localBuilder = new MessagingRecommendationActionEvent.Builder();
      if (localMessagingRecommendationActionType != null) {
        break label112;
      }
      hasActionCategory = false;
      actionCategory = null;
      label40:
      paramString1 = nameToUrn(paramTracker, paramString1);
      if (paramString1 != null) {
        break label128;
      }
      hasControlUrn = false;
      controlUrn = null;
      label62:
      if (paramString2 != null) {
        break label143;
      }
      hasRecommendationTrackingId = false;
    }
    for (recommendationTrackingId = null;; recommendationTrackingId = paramString2)
    {
      paramTracker.send(localBuilder);
      return;
      if (paramInt == 2)
      {
        localMessagingRecommendationActionType = MessagingRecommendationActionType.MESSAGE;
        break;
      }
      if (paramInt != 1) {
        break;
      }
      localMessagingRecommendationActionType = MessagingRecommendationActionType.SKIP;
      break;
      label112:
      hasActionCategory = true;
      actionCategory = localMessagingRecommendationActionType;
      break label40;
      label128:
      hasControlUrn = true;
      controlUrn = paramString1;
      break label62;
      label143:
      hasRecommendationTrackingId = true;
    }
  }
  
  public final void trackPropActionEvent(Tracker paramTracker, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (paramBundle = null; paramBundle != null; paramBundle = (Prop)RecordParceler.unparcel(Prop.BUILDER, "PROP_PARCEL", paramBundle)) {
      try
      {
        paramTracker.send(new PropActionEvent.Builder().setModuleKey("p-flagship3-people").setTrackingId(trackingId).setPropUrn(entityUrn.toString()).setActionCategory(com.linkedin.gen.avro2pegasus.events.common.ActionCategory.MESSAGE).setControlUrn(RelationshipsTracking.nameToUrn(paramTracker, "prop_action")).setActionType("message"));
        return;
      }
      catch (DataReaderException paramTracker)
      {
        com.linkedin.android.logger.Log.e(TAG, "error on trackPropActionEvent", paramTracker);
      }
    }
  }
  
  public final void trackStickerAction(Tracker paramTracker, String paramString1, String paramString2, long paramLong)
  {
    try
    {
      StickerActionEvent.Builder localBuilder = new StickerActionEvent.Builder();
      paramString1 = new TrackingObject.Builder().setObjectUrn(paramString1).setTrackingId(TrackingUtils.generateBase64EncodedTrackingId()).build(RecordTemplate.Flavor.RECORD);
      hasConversation = true;
      conversation = paramString1;
      paramString1 = StickerAction.SELECT;
      if (paramString1 == null) {
        hasActionCategory = false;
      }
      for (actionCategory = null;; actionCategory = paramString1)
      {
        paramString1 = new StickerObject.Builder().setStickerNumber(Long.valueOf(paramLong)).setStickerPackName(paramString2).build(RecordTemplate.Flavor.RECORD);
        hasSticker = true;
        sticker = paramString1;
        paramTracker.send(localBuilder);
        return;
        hasActionCategory = true;
      }
      return;
    }
    catch (BuilderException paramTracker)
    {
      com.linkedin.android.logger.Log.e(TAG, "Unable to send StickerActionEvent", paramTracker);
    }
  }
  
  public final void trackStickerImpression(Tracker paramTracker, String paramString1, String paramString2, long paramLong)
  {
    try
    {
      StickerImpressionEvent.Builder localBuilder = new StickerImpressionEvent.Builder();
      paramString1 = new TrackingObject.Builder().setObjectUrn(paramString1).setTrackingId(TrackingUtils.generateBase64EncodedTrackingId()).build(RecordTemplate.Flavor.RECORD);
      hasConversation = true;
      conversation = paramString1;
      paramString1 = new StickerObject.Builder().setStickerNumber(Long.valueOf(paramLong)).setStickerPackName(paramString2).build(RecordTemplate.Flavor.RECORD);
      hasSticker = true;
      sticker = paramString1;
      paramTracker.send(localBuilder);
      return;
    }
    catch (BuilderException paramTracker)
    {
      com.linkedin.android.logger.Log.e(TAG, "Unable to send StickerImpressionEvent", paramTracker);
    }
  }
  
  public final void translateViewWithNav(View paramView)
  {
    applicationComponent.eventBus().publishInMainThread(new RegisterForNavUpdatesEvent(new WeakReference(paramView)));
  }
  
  public final void typeaheadSearch(String paramString, TypeaheadApiResponse paramTypeaheadApiResponse)
  {
    if ((isDetached) || (paramString.isEmpty())) {
      return;
    }
    paramString = Routes.buildMessagingTypeahead(paramString);
    paramTypeaheadApiResponse = new MessagingLibProvider.4(this, paramTypeaheadApiResponse, paramString);
    Fragment localFragment = fragmentComponent.fragment();
    if (fragmentComponent.fragment() != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramTypeaheadApiResponse = new MessengerRecordTemplateListener(paramTypeaheadApiResponse, localFragment, bool);
      dataManager.submit(Request.get().url(paramString.toString()).builder(new CollectionTemplate.CollectionTemplateJsonParser(MessagingTypeaheadResult.BUILDER, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata.BUILDER)).listener(paramTypeaheadApiResponse).filter(DataManager.DataStoreFilter.NETWORK_ONLY).shouldUpdateCache(false));
      return;
    }
  }
  
  public final void uploadPhoto(String paramString, Uri paramUri)
  {
    if (isDetached) {}
    MessagingImageFetcher localMessagingImageFetcher;
    do
    {
      return;
      localMessagingImageFetcher = messagingImageFetcher;
    } while (mediaUploader == null);
    mediaUploader.submitMediaUpload(paramString, paramUri, FileUploadTokenType.ATTACHMENT);
  }
  
  public final void usedConversationInsights()
  {
    applicationComponent.flagshipSharedPreferences().getPreferences().edit().putBoolean("hasUsedConversationInsights", true).apply();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.integration.MessagingLibProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */