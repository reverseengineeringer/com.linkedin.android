package com.linkedin.messengerlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.example.touch.TouchImageView;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.imageloader.LiImageView.ImageViewLoadListener;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialActor;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.messaging.Conversation;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.ConversationCreate;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreate;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreateResponse;
import com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight;
import com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipientList;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation;
import com.linkedin.messengerlib.api.ApiModelResponse;
import com.linkedin.messengerlib.api.ConversationListApiResponse;
import com.linkedin.messengerlib.api.MessageListApiResponse;
import com.linkedin.messengerlib.api.ParticipantDataResponse;
import com.linkedin.messengerlib.api.RecipientSearchResponse;
import com.linkedin.messengerlib.api.StickerListResponse;
import com.linkedin.messengerlib.api.StickerPackListResponse;
import com.linkedin.messengerlib.api.TypeaheadApiResponse;
import com.linkedin.messengerlib.attachment.AttachmentFileType;
import com.linkedin.messengerlib.ui.participantdetails.PanelActionItem;
import com.linkedin.messengerlib.utils.LongClickUtil;
import java.io.File;
import java.util.List;
import java.util.Map;

public abstract class MessengerLibApi
{
  public Context context;
  
  public MessengerLibApi(Context paramContext)
  {
    context = paramContext;
  }
  
  public abstract void compressImage(Bitmap paramBitmap, MessengerLibApi.CompressImageCallback paramCompressImageCallback);
  
  public abstract void createConversation(ConversationCreate paramConversationCreate, MessengerLibApi.CreateConversationResponse paramCreateConversationResponse);
  
  public abstract void deleteConversation(String paramString, MessengerLibApi.DeleteConversationResponse paramDeleteConversationResponse);
  
  public void detach()
  {
    context = null;
  }
  
  public abstract void fetchConversationInsights(List<MiniProfile> paramList, MessengerLibApi.ApiListener<List<Insight>> paramApiListener);
  
  public abstract void fetchInmailCredits(MessengerLibApi.InmailCreditsListener paramInmailCreditsListener);
  
  public abstract void fetchReconnectionSuggestions(MessengerLibApi.ReconnectionSuggestionsResponse paramReconnectionSuggestionsResponse, boolean paramBoolean);
  
  public abstract void fireTrackingPremiumUpsellImpressionEvent(String paramString);
  
  public abstract void getConversationById(String paramString, ApiModelResponse<Conversation> paramApiModelResponse);
  
  public abstract void getConversationList$573885c3(Long paramLong, String paramString1, ConversationListApiResponse paramConversationListApiResponse, String paramString2);
  
  public abstract void getConversationSearchList(Long paramLong, ConversationListApiResponse paramConversationListApiResponse, String paramString1, String paramString2);
  
  public abstract Map<String, String> getDownloadRequestHeaders(String paramString);
  
  public abstract void getFeedUpdateModel(String paramString, MessengerLibApi.FeedUpdateModelListener paramFeedUpdateModelListener);
  
  public abstract Drawable getGhostDrawable(MiniProfile paramMiniProfile, int paramInt);
  
  public abstract String getImageUrl(String paramString);
  
  public abstract String getImageUrl(String paramString, int paramInt1, int paramInt2);
  
  public abstract long[] getInstalledStickerPackIds();
  
  public abstract String getLoadMoreRumSessionId();
  
  public abstract void getMe(MessengerLibApi.MeResponse paramMeResponse);
  
  public abstract void getMessageList(String paramString1, String paramString2, String paramString3, MessageListApiResponse paramMessageListApiResponse);
  
  public abstract void getParticipantData(String paramString, ParticipantDataResponse paramParticipantDataResponse);
  
  public abstract void getPendingInvitation(String paramString, MessengerLibApi.ApiListener<Conversation> paramApiListener);
  
  public abstract void getProfileForMemberId(String paramString, MessengerLibApi.ProfileResponse paramProfileResponse);
  
  public abstract void getProfileForMiniProfileUrn(String paramString, MessengerLibApi.ProfileResponse paramProfileResponse);
  
  public abstract String getRefreshPageRumSessionId();
  
  public abstract String getRumSessionId();
  
  public abstract SocialActor getSocialActorForFeedUpdate(Update paramUpdate);
  
  public abstract void getStickerPack(long paramLong, MessengerLibApi.StickerPackResponse paramStickerPackResponse);
  
  public abstract void getStickerPacks(StickerPackListResponse paramStickerPackListResponse);
  
  public abstract void getStickers(long paramLong, StickerListResponse paramStickerListResponse);
  
  public abstract void getSuggestedConnections(MessengerLibApi.ApiListener<List<SuggestedRecipientList>> paramApiListener);
  
  public abstract void getVirusScanStatus(String paramString, MessengerLibApi.VirusScanResponse paramVirusScanResponse);
  
  public abstract void goToLandingPage(String paramString);
  
  public abstract boolean hasUsedConversationInsights();
  
  public abstract boolean isSafeToExecuteTransaction();
  
  public abstract void isUserConfirmed(MessengerLibApi.UserConfirmationListener paramUserConfirmationListener);
  
  public abstract void loadImage(Image paramImage, int paramInt, LiImageView paramLiImageView);
  
  public abstract void loadImage(Image paramImage, Drawable paramDrawable, LiImageView paramLiImageView);
  
  public abstract void loadImageFromFile(File paramFile, int paramInt, LiImageView paramLiImageView, LiImageView.ImageViewLoadListener paramImageViewLoadListener);
  
  public abstract void loadImageFromUri(Uri paramUri, int paramInt, LiImageView paramLiImageView, LiImageView.ImageViewLoadListener paramImageViewLoadListener);
  
  public abstract void loadImageFromUrl(String paramString, int paramInt, LiImageView paramLiImageView, LiImageView.ImageViewLoadListener paramImageViewLoadListener);
  
  public abstract void loadImageFromUrl(String paramString, Drawable paramDrawable, LiImageView paramLiImageView);
  
  public abstract void loadImageFromUrl(String paramString, TouchImageView paramTouchImageView);
  
  public abstract void loadImageFromUrl(String paramString, MessengerLibApi.BitmapResponse paramBitmapResponse);
  
  public abstract void loadImageFromUrl$734b4a4c(String paramString, LiImageView paramLiImageView);
  
  public abstract LongClickUtil longClickUtil();
  
  public abstract void markSponsoredInMailActioned(String paramString1, String paramString2);
  
  public abstract void onBackPressed$1385ff();
  
  public abstract void openAddParticipantActivity(long paramLong, String paramString);
  
  public abstract void openCompany(MiniCompany paramMiniCompany);
  
  public abstract void openCompose();
  
  public abstract void openCompose$6efb212c(String[] paramArrayOfString);
  
  public abstract void openComposeInReconnectMode(MiniProfile[] paramArrayOfMiniProfile, boolean paramBoolean);
  
  public abstract void openConversationDetails(long paramLong, String paramString, boolean paramBoolean);
  
  public abstract void openConversationList();
  
  public abstract void openFeedUpdateDetail(Update paramUpdate);
  
  public abstract void openFile(Uri paramUri, String paramString);
  
  public abstract void openImageViewer(String paramString1, String paramString2, String paramString3, String paramString4, AttachmentFileType paramAttachmentFileType);
  
  public abstract void openMessageList(long paramLong, String paramString, boolean paramBoolean);
  
  public abstract void openPremiumChooser(String paramString);
  
  public abstract void openProfile(Urn paramUrn);
  
  public abstract void openProfile(MiniProfile paramMiniProfile);
  
  public abstract void openReconnectActivity();
  
  public abstract void openSearch(int paramInt);
  
  public abstract void openSendEmailConfirmationDialog(MessengerLibApi.SendEmailConfirmationListener paramSendEmailConfirmationListener);
  
  public abstract void openStickerStore();
  
  public abstract void openUrlInWebViewer(String paramString, View paramView);
  
  public abstract void recipientSearch(String paramString, RecipientSearchResponse paramRecipientSearchResponse);
  
  public abstract void reportMessage(String paramString1, String paramString2, String paramString3, MessengerLibApi.ReportMessageResponse paramReportMessageResponse);
  
  public abstract void requestPermissions(String[] paramArrayOfString, int paramInt1, int paramInt2);
  
  public abstract void sendConversationTypingIndicator(String paramString, MessengerLibApi.SendConversationTypingIndicatorResponse paramSendConversationTypingIndicatorResponse);
  
  public abstract void sendLegoWidgetActionEvent$fd8052f(String paramString, ActionCategory paramActionCategory);
  
  public abstract void sendLegoWidgetImpressionEvent$16da05f7(String paramString);
  
  public abstract void sendMessage(String paramString, EventCreate paramEventCreate, SendMessageResponse paramSendMessageResponse);
  
  public abstract void setConversationMute(String paramString, boolean paramBoolean, MessengerLibApi.ConversationSetAttributeStateResponse paramConversationSetAttributeStateResponse);
  
  public abstract void setConversationName(String paramString1, String paramString2, MessengerLibApi.ConversationSetAttributeStateResponse paramConversationSetAttributeStateResponse);
  
  public abstract void setConversationReadState(String paramString, boolean paramBoolean, MessengerLibApi.ConversationSetAttributeStateResponse paramConversationSetAttributeStateResponse);
  
  public abstract void setInstalledStickerPackIds(long[] paramArrayOfLong);
  
  public abstract void setInvitationResponse(Invitation paramInvitation, int paramInt, MessengerLibApi.ApiListener<Void> paramApiListener);
  
  public abstract void showControlPanelOptions(List<PanelActionItem> paramList);
  
  public abstract void showSnackbar(String paramString);
  
  public abstract void trackConversationDetailAction(Tracker paramTracker, String paramString1, List<String> paramList, String paramString2, int paramInt);
  
  public abstract void trackConversationDetailImpression(Tracker paramTracker, String paramString, List<String> paramList1, List<String> paramList2);
  
  public abstract void trackConversationsImpression(Tracker paramTracker, List<String> paramList);
  
  public abstract void trackCspUrl(String paramString);
  
  public abstract void trackMessagingRecommendationActionEvent(Tracker paramTracker, int paramInt, String paramString1, String paramString2);
  
  public abstract void trackPropActionEvent(Tracker paramTracker, Bundle paramBundle);
  
  public abstract void trackStickerAction(Tracker paramTracker, String paramString1, String paramString2, long paramLong);
  
  public abstract void trackStickerImpression(Tracker paramTracker, String paramString1, String paramString2, long paramLong);
  
  public abstract void translateViewWithNav(View paramView);
  
  public abstract void typeaheadSearch(String paramString, TypeaheadApiResponse paramTypeaheadApiResponse);
  
  public abstract void uploadPhoto(String paramString, Uri paramUri);
  
  public abstract void usedConversationInsights();
  
  public static abstract interface SendMessageResponse
  {
    public abstract void onError(Exception paramException);
    
    public abstract void onResponse(EventCreateResponse paramEventCreateResponse);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.MessengerLibApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */