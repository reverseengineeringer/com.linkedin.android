package com.linkedin.android.identity.profile;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.design.widget.EfficientCoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.google.android.gms.common.api.GoogleApiClient;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.android.axle.PromoListener;
import com.linkedin.android.axle.ToastPromoInflater;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequestException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.utils.FeedPageType;
import com.linkedin.android.growth.seo.appindexing.GoogleAppIndexingManager;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.identity.edit.ProfileEditFragmentUtils;
import com.linkedin.android.identity.edit.ProfileEditListener;
import com.linkedin.android.identity.edit.ProfileSkillsAddedEvent;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditIntent;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditSource;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.identity.profile.view.ProfileRecyclerViewScrollListener;
import com.linkedin.android.identity.profile.view.ProfileViewAdapter;
import com.linkedin.android.identity.profile.view.ProfileViewDismissCardEvent;
import com.linkedin.android.identity.profile.view.ProfileViewListener;
import com.linkedin.android.identity.profile.view.ProfileViewTransformer;
import com.linkedin.android.identity.profile.view.ProfileViewTransformer.ProfileCardType;
import com.linkedin.android.identity.profile.view.PublicProfileRecommendationCardViewModel;
import com.linkedin.android.identity.profile.view.PublicProfileRecyclerViewScrollListener;
import com.linkedin.android.identity.profile.view.PublicProfileSkillsTransformer;
import com.linkedin.android.identity.profile.view.RecommendationCardViewModel;
import com.linkedin.android.identity.profile.view.RecyclerViewVisibilityListener;
import com.linkedin.android.identity.profile.view.SkillsCardViewModel;
import com.linkedin.android.identity.profile.view.WorkWithUsCardViewModel;
import com.linkedin.android.identity.profile.view.background.BackgroundTransformer;
import com.linkedin.android.identity.profile.view.browsemap.BrowseMapTransformer;
import com.linkedin.android.identity.profile.view.contact.ContactCardEntryViewModel;
import com.linkedin.android.identity.profile.view.contact.ContactCardViewModel;
import com.linkedin.android.identity.profile.view.contact.ContactTransformer;
import com.linkedin.android.identity.profile.view.contact.ContactTransformer.1;
import com.linkedin.android.identity.profile.view.contact.ContactTransformer.2;
import com.linkedin.android.identity.profile.view.featuredskills.FeaturedSkillsCardViewModel;
import com.linkedin.android.identity.profile.view.featuredskills.FeaturedSkillsTransformer;
import com.linkedin.android.identity.profile.view.featuredskills.FeaturedSkillsTransformer.1;
import com.linkedin.android.identity.profile.view.featuredskills.FeaturedSkillsTransformer.4;
import com.linkedin.android.identity.profile.view.groups.ProfileViewGroupsCardViewModel;
import com.linkedin.android.identity.profile.view.groups.ProfileViewGroupsTransformer;
import com.linkedin.android.identity.profile.view.groups.ProfileViewGroupsTransformer.2;
import com.linkedin.android.identity.profile.view.guidededitentry.GuidedEditEntryPointViewModel;
import com.linkedin.android.identity.profile.view.guidededitentry.GuidedEditEntryTransformer;
import com.linkedin.android.identity.profile.view.highlights.HighlightsTransformer;
import com.linkedin.android.identity.profile.view.interests.InterestsTransformer;
import com.linkedin.android.identity.profile.view.promotion.PremiumPromoCardViewHolder;
import com.linkedin.android.identity.profile.view.promotion.PremiumPromoCardViewModel;
import com.linkedin.android.identity.profile.view.promotion.PremiumPromoDismissEvent;
import com.linkedin.android.identity.profile.view.promotion.ProfilePremiumUpsellUtils.1;
import com.linkedin.android.identity.profile.view.promotion.ProfilePromotionTransformer;
import com.linkedin.android.identity.profile.view.promotion.ProfilePromotionTransformer.2;
import com.linkedin.android.identity.profile.view.promotion.ProfilePromotionTransformer.3;
import com.linkedin.android.identity.profile.view.recentactivity.PostsCarouselViewModel;
import com.linkedin.android.identity.profile.view.recentactivity.RecentActivityCardViewModel;
import com.linkedin.android.identity.profile.view.recentactivity.RecentActivityTransformer;
import com.linkedin.android.identity.profile.view.recentactivity.RecentActivityTransformer.1;
import com.linkedin.android.identity.profile.view.recentactivity.RecentActivityTransformer.2;
import com.linkedin.android.identity.profile.view.recentactivity.RecentActivityTransformer.4;
import com.linkedin.android.identity.profile.view.recentactivity.RecentActivityTransformer.5;
import com.linkedin.android.identity.profile.view.recommendations.RecommendationsTransformer;
import com.linkedin.android.identity.profile.view.recommendations.RecommendationsTransformer.1;
import com.linkedin.android.identity.profile.view.recommendations.RecommendationsTransformer.2;
import com.linkedin.android.identity.profile.view.samename.SameNameTransformer;
import com.linkedin.android.identity.profile.view.skills.SkillsTransformer;
import com.linkedin.android.identity.profile.view.skills.SkillsTransformer.1;
import com.linkedin.android.identity.profile.view.skills.SkillsTransformer.4;
import com.linkedin.android.identity.profile.view.suggestedendorsement.SuggestedEndorsementCardDismissSkipListener;
import com.linkedin.android.identity.profile.view.suggestedendorsement.SuggestedEndorsementCardEndorseListener;
import com.linkedin.android.identity.profile.view.suggestedendorsement.SuggestedEndorsementCardSkipListener;
import com.linkedin.android.identity.profile.view.suggestedendorsement.SuggestedEndorsementCardViewModel;
import com.linkedin.android.identity.profile.view.suggestedendorsement.SuggestedEndorsementConfirmationCardViewModel;
import com.linkedin.android.identity.profile.view.suggestedendorsement.SuggestedEndorsementTransformer;
import com.linkedin.android.identity.profile.view.suggestedendorsement.SuggestedEndorsementTransformer.1;
import com.linkedin.android.identity.profile.view.suggestedendorsement.SuggestedEndorsementTransformer.2;
import com.linkedin.android.identity.profile.view.topcard.TopCardViewTransformer;
import com.linkedin.android.identity.profile.view.workwithus.WorkWithUsTransformer.1;
import com.linkedin.android.identity.profile.view.wvmp.WvmpCardTransformer2.1;
import com.linkedin.android.identity.profile.view.wvmp.WvmpCardTransformer2.2;
import com.linkedin.android.identity.profile.view.wvmp.WvmpViewModel2;
import com.linkedin.android.identity.shared.ProfilePictureSelectDialogFragment.OnUserSelectionListener;
import com.linkedin.android.identity.shared.ProfileUrnUtil;
import com.linkedin.android.identity.shared.ProfileViewUtils;
import com.linkedin.android.identity.shared.listeners.ToolbarFadeScrollListener;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.ExceptionUtils;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.JellyBeanUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.PhotoUtils;
import com.linkedin.android.infra.shared.PhotoUtils.UriListener;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.shared.VoyagerUserVisibleException;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.GraphDistance;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Header;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateType;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Education;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileNetworkInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Recommendation;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.SuggestedEndorsement;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.SuggestedEndorsement.Reason;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.SuggestedEndorsementReasonExpert;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.SuggestedEndorsementReasonStandard;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.SuggestedEndorsementsMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.WWUAd;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileAction;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileAction.Action;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileActions;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.ProfilePromotion;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.ProfilePromotion.Prompt;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.PremiumUpsellPrompt;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight.Detail;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.ProfileHighlight;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.ProfileHighlight.Detail;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedEducationInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedEducationsInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedExperienceInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedExperiencesInfo;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.messengerlib.ui.animation.ScrollAwareFABBehavior;
import com.linkedin.xmsg.Name;
import com.linkedin.xmsg.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class ProfileViewFragment
  extends ProfileActionHandlerFragment
  implements SwipeRefreshLayout.OnRefreshListener, FeedPageType, ProfilePictureSelectDialogFragment.OnUserSelectionListener, PhotoUtils.UriListener
{
  private com.google.android.gms.appindexing.Action action;
  @Inject
  Auth auth;
  private boolean crossPromoShowed;
  private int currentScrollPosition;
  private int currentToolbarAlpha;
  @Inject
  FlagshipDataManager dataManager;
  private ErrorPageViewModel errorPageViewModel;
  @InjectView(2131756773)
  ViewStub errorViewStub;
  @InjectView(2131757951)
  FloatingActionButton floatingActionButton;
  private GoogleApiClient googleApiClient;
  private boolean hasEnteredAtLeastOnce;
  private boolean ignoreFabUpdates;
  private boolean isMeTabProfile;
  boolean isRemoveFragmentTransactionCommitted;
  @Inject
  MemberUtil memberUtil;
  private int openSearchEntryType;
  @InjectView(2131757947)
  ImageButton overflowButton;
  private boolean pausedWhileProfileViewCallInProgress;
  private int pendingTrackingEvents;
  private Uri photoUri;
  @Inject
  PhotoUtils photoUtil;
  private View premiumUpsellFrameView;
  private String profileIdentifier;
  private ProfileViewAdapter profileViewAdapter;
  private ProfileViewListener profileViewListener;
  @InjectView(2131757943)
  EfficientCoordinatorLayout profileViewMainEfficientCoordinatorLayout;
  @InjectView(2131757949)
  LinearLayout publicProfileStickyBottomCTA;
  @InjectView(2131757950)
  Button publicProfileStickyBottomCTAButton;
  private PublicProfileRecyclerViewScrollListener publicProfilepublicProfileStickyBottomCTAScrollListener;
  @InjectView(2131757945)
  RecyclerView recyclerView;
  private ProfileRecyclerViewScrollListener scrollListener;
  @InjectView(2131758545)
  View searchBarDivider;
  @InjectView(2131755328)
  TextView searchBarText;
  @InjectView(2131757948)
  ImageButton searchButton;
  @InjectView(2131755145)
  ViewGroup searchOpenBar;
  @InjectView(2131757944)
  SwipeRefreshLayout swipeRefreshLayout;
  @InjectView(2131757946)
  Toolbar toolbar;
  @Inject
  ViewPortManager viewPortManager;
  
  private String crossPromoPageKey(String paramString)
  {
    return applicationComponent.tracker().trackingCodePrefix + "_" + paramString;
  }
  
  private void fetchDataForInitialLoad()
  {
    profileDataProvider.fetchData(profileIdentifier, busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), DataManager.DataStoreFilter.ALL);
  }
  
  private String getXpromoRoutePath()
  {
    return Routes.crossPromoPath(crossPromoPageKey("profile_self"));
  }
  
  public static ProfileViewFragment newInstance(ProfileBundleBuilder paramProfileBundleBuilder)
  {
    ProfileViewFragment localProfileViewFragment = new ProfileViewFragment();
    localProfileViewFragment.setArguments(paramProfileBundleBuilder.build());
    return localProfileViewFragment;
  }
  
  private void sendGuidedEditPageViewEvent()
  {
    if (profileViewAdapter.profileCardTypes == null) {}
    while (!profileViewAdapter.profileCardTypes.contains(ProfileViewTransformer.ProfileCardType.GUIDED_EDIT)) {
      return;
    }
    int i = profileViewAdapter.profileCardTypes.indexOf(ProfileViewTransformer.ProfileCardType.GUIDED_EDIT);
    ((GuidedEditEntryPointViewModel)profileViewAdapter.getValues().get(i)).sendPageViewEvent();
  }
  
  /* Error */
  private void sendProfileViewEvent()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 114	com/linkedin/android/identity/profile/ProfileViewFragment:profileDataProvider	Lcom/linkedin/android/identity/profile/ProfileDataProvider;
    //   4: invokevirtual 120	com/linkedin/android/identity/profile/ProfileDataProvider:isDataAvailable	()Z
    //   7: ifeq +13 -> 20
    //   10: aload_0
    //   11: getfield 114	com/linkedin/android/identity/profile/ProfileViewFragment:profileDataProvider	Lcom/linkedin/android/identity/profile/ProfileDataProvider;
    //   14: invokevirtual 124	com/linkedin/android/identity/profile/ProfileDataProvider:getProfileModel	()Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/Profile;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: aload_0
    //   22: getfield 114	com/linkedin/android/identity/profile/ProfileViewFragment:profileDataProvider	Lcom/linkedin/android/identity/profile/ProfileDataProvider;
    //   25: invokevirtual 124	com/linkedin/android/identity/profile/ProfileDataProvider:getProfileModel	()Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/Profile;
    //   28: getfield 130	com/linkedin/android/pegasus/gen/voyager/identity/profile/Profile:miniProfile	Lcom/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile;
    //   31: getfield 136	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile:entityUrn	Lcom/linkedin/android/pegasus/gen/common/Urn;
    //   34: invokevirtual 142	com/linkedin/android/pegasus/gen/common/Urn:getId	()Ljava/lang/String;
    //   37: astore 4
    //   39: aload_0
    //   40: getfield 114	com/linkedin/android/identity/profile/ProfileViewFragment:profileDataProvider	Lcom/linkedin/android/identity/profile/ProfileDataProvider;
    //   43: invokevirtual 124	com/linkedin/android/identity/profile/ProfileDataProvider:getProfileModel	()Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/Profile;
    //   46: getfield 130	com/linkedin/android/pegasus/gen/voyager/identity/profile/Profile:miniProfile	Lcom/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile;
    //   49: getfield 136	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile:entityUrn	Lcom/linkedin/android/pegasus/gen/common/Urn;
    //   52: invokevirtual 340	com/linkedin/android/pegasus/gen/common/Urn:getLastId	()Ljava/lang/String;
    //   55: invokestatic 346	com/linkedin/android/infra/shared/ProfileIdUtils:getMemberId	(Ljava/lang/String;)J
    //   58: lstore_1
    //   59: aload_0
    //   60: invokevirtual 350	com/linkedin/android/identity/profile/ProfileViewFragment:getContext	()Landroid/content/Context;
    //   63: pop
    //   64: aconst_null
    //   65: astore 5
    //   67: aconst_null
    //   68: astore 6
    //   70: aload 5
    //   72: astore 4
    //   74: aload 6
    //   76: astore_3
    //   77: aload_0
    //   78: getfield 144	com/linkedin/android/identity/profile/ProfileViewFragment:auth	Lcom/linkedin/android/infra/network/Auth;
    //   81: ifnull +104 -> 185
    //   84: aload 5
    //   86: astore 4
    //   88: aload 6
    //   90: astore_3
    //   91: aload_0
    //   92: getfield 144	com/linkedin/android/identity/profile/ProfileViewFragment:auth	Lcom/linkedin/android/infra/network/Auth;
    //   95: invokevirtual 149	com/linkedin/android/infra/network/Auth:isAuthenticated	()Z
    //   98: ifeq +87 -> 185
    //   101: aload_0
    //   102: getfield 114	com/linkedin/android/identity/profile/ProfileViewFragment:profileDataProvider	Lcom/linkedin/android/identity/profile/ProfileDataProvider;
    //   105: invokevirtual 354	com/linkedin/android/identity/profile/ProfileDataProvider:getNetworkInfoModel	()Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/ProfileNetworkInfo;
    //   108: astore 4
    //   110: getstatic 360	com/linkedin/android/pegasus/gen/voyager/common/GraphDistance:$UNKNOWN	Lcom/linkedin/android/pegasus/gen/voyager/common/GraphDistance;
    //   113: astore_3
    //   114: aload 4
    //   116: ifnull +12 -> 128
    //   119: aload 4
    //   121: getfield 366	com/linkedin/android/pegasus/gen/voyager/identity/profile/ProfileNetworkInfo:distance	Lcom/linkedin/android/pegasus/gen/voyager/common/MemberDistance;
    //   124: getfield 370	com/linkedin/android/pegasus/gen/voyager/common/MemberDistance:value	Lcom/linkedin/android/pegasus/gen/voyager/common/GraphDistance;
    //   127: astore_3
    //   128: aload_3
    //   129: invokestatic 376	com/linkedin/android/identity/shared/ProfileViewUtils:networkDistanceFromGraphDistance$d8bbb93	(Lcom/linkedin/android/pegasus/gen/voyager/common/GraphDistance;)Ljava/lang/Integer;
    //   132: astore 4
    //   134: aload_0
    //   135: getfield 114	com/linkedin/android/identity/profile/ProfileViewFragment:profileDataProvider	Lcom/linkedin/android/identity/profile/ProfileDataProvider;
    //   138: astore_3
    //   139: aload_3
    //   140: ldc_w 378
    //   143: invokevirtual 382	com/linkedin/android/identity/profile/ProfileDataProvider:verifyDataAvailable	(Ljava/lang/String;)V
    //   146: aload_3
    //   147: getfield 388	com/linkedin/android/infra/app/DataProvider:state	Lcom/linkedin/android/infra/app/DataProvider$State;
    //   150: checkcast 390	com/linkedin/android/identity/profile/ProfileState
    //   153: astore_3
    //   154: aload_3
    //   155: aload_3
    //   156: getfield 393	com/linkedin/android/identity/profile/ProfileState:mySettingsRoute	Ljava/lang/String;
    //   159: invokevirtual 397	com/linkedin/android/identity/profile/ProfileState:getModel	(Ljava/lang/String;)Ljava/lang/Object;
    //   162: checkcast 399	com/linkedin/android/pegasus/gen/voyager/common/MySettings
    //   165: astore_3
    //   166: aload_3
    //   167: ifnonnull +396 -> 563
    //   170: new 333	java/lang/IllegalArgumentException
    //   173: dup
    //   174: ldc_w 401
    //   177: invokespecial 403	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   180: invokestatic 409	com/linkedin/android/infra/shared/Util:safeThrow$7a8b4789	(Ljava/lang/RuntimeException;)V
    //   183: aconst_null
    //   184: astore_3
    //   185: ldc_w 411
    //   188: iconst_1
    //   189: anewarray 413	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: lload_1
    //   195: invokestatic 419	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   198: aastore
    //   199: invokestatic 423	com/linkedin/android/pegasus/gen/common/Urn:createFromTuple	(Ljava/lang/String;[Ljava/lang/Object;)Lcom/linkedin/android/pegasus/gen/common/Urn;
    //   202: astore 7
    //   204: aconst_null
    //   205: astore 5
    //   207: new 425	com/linkedin/gen/avro2pegasus/events/EntityView$Builder
    //   210: dup
    //   211: invokespecial 426	com/linkedin/gen/avro2pegasus/events/EntityView$Builder:<init>	()V
    //   214: astore 6
    //   216: aload 6
    //   218: iconst_1
    //   219: putfield 429	com/linkedin/gen/avro2pegasus/events/EntityView$Builder:hasViewType	Z
    //   222: aload 6
    //   224: ldc_w 431
    //   227: putfield 434	com/linkedin/gen/avro2pegasus/events/EntityView$Builder:viewType	Ljava/lang/String;
    //   230: lload_1
    //   231: l2i
    //   232: invokestatic 439	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: astore 8
    //   237: aload 8
    //   239: ifnonnull +385 -> 624
    //   242: aload 6
    //   244: iconst_0
    //   245: putfield 442	com/linkedin/gen/avro2pegasus/events/EntityView$Builder:hasTargetId	Z
    //   248: aload 6
    //   250: iconst_0
    //   251: putfield 445	com/linkedin/gen/avro2pegasus/events/EntityView$Builder:targetId	I
    //   254: aload_0
    //   255: getfield 151	com/linkedin/android/identity/profile/ProfileViewFragment:memberUtil	Lcom/linkedin/android/infra/shared/MemberUtil;
    //   258: invokevirtual 448	com/linkedin/android/infra/shared/MemberUtil:getMemberId	()J
    //   261: l2i
    //   262: invokestatic 439	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: astore 8
    //   267: aload 8
    //   269: ifnonnull +404 -> 673
    //   272: aload 6
    //   274: iconst_0
    //   275: putfield 451	com/linkedin/gen/avro2pegasus/events/EntityView$Builder:hasViewerId	Z
    //   278: aload 6
    //   280: iconst_0
    //   281: putfield 454	com/linkedin/gen/avro2pegasus/events/EntityView$Builder:viewerId	I
    //   284: aload 6
    //   286: getstatic 460	com/linkedin/data/lite/RecordTemplate$Flavor:RECORD	Lcom/linkedin/data/lite/RecordTemplate$Flavor;
    //   289: invokevirtual 463	com/linkedin/gen/avro2pegasus/events/EntityView$Builder:build	(Lcom/linkedin/data/lite/RecordTemplate$Flavor;)Lcom/linkedin/gen/avro2pegasus/events/EntityView;
    //   292: astore 6
    //   294: aload 6
    //   296: astore 5
    //   298: aload_0
    //   299: getfield 178	com/linkedin/android/infra/app/TrackableFragment:tracker	Lcom/linkedin/android/litrackinglib/metric/Tracker;
    //   302: astore 6
    //   304: new 465	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder
    //   307: dup
    //   308: invokespecial 466	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:<init>	()V
    //   311: astore 8
    //   313: aload 7
    //   315: invokevirtual 467	com/linkedin/android/pegasus/gen/common/Urn:toString	()Ljava/lang/String;
    //   318: astore 9
    //   320: aload 9
    //   322: ifnonnull +370 -> 692
    //   325: aload 8
    //   327: iconst_0
    //   328: putfield 470	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:hasVieweeMemberUrn	Z
    //   331: aload 8
    //   333: aconst_null
    //   334: putfield 473	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:vieweeMemberUrn	Ljava/lang/String;
    //   337: aload_3
    //   338: ifnonnull +370 -> 708
    //   341: aload 8
    //   343: iconst_0
    //   344: putfield 476	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:hasViewerPrivacySetting	Z
    //   347: aload 8
    //   349: aconst_null
    //   350: putfield 479	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:viewerPrivacySetting	Ljava/lang/String;
    //   353: aload 4
    //   355: ifnonnull +368 -> 723
    //   358: aload 8
    //   360: iconst_0
    //   361: putfield 482	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:hasNetworkDistance	Z
    //   364: aload 8
    //   366: iconst_0
    //   367: putfield 485	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:networkDistance	I
    //   370: aload 5
    //   372: ifnonnull +370 -> 742
    //   375: aload 8
    //   377: iconst_0
    //   378: putfield 488	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:hasEntityView	Z
    //   381: aload 8
    //   383: aconst_null
    //   384: putfield 492	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:entityView	Lcom/linkedin/gen/avro2pegasus/events/EntityView;
    //   387: aload 6
    //   389: aload 8
    //   391: invokevirtual 495	com/linkedin/android/litrackinglib/metric/Tracker:send	(Lcom/linkedin/android/tracking/v2/event/TrackingEventBuilder;)V
    //   394: aload_0
    //   395: invokevirtual 161	com/linkedin/android/identity/profile/ProfileViewFragment:getArguments	()Landroid/os/Bundle;
    //   398: ldc_w 497
    //   401: invokevirtual 500	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   404: astore 5
    //   406: aload 5
    //   408: invokestatic 505	com/linkedin/xmsg/util/StringUtils:isEmpty	(Ljava/lang/String;)Z
    //   411: ifne -391 -> 20
    //   414: new 507	com/linkedin/gen/avro2pegasus/events/common/TrackingObject$Builder
    //   417: dup
    //   418: invokespecial 508	com/linkedin/gen/avro2pegasus/events/common/TrackingObject$Builder:<init>	()V
    //   421: aload 7
    //   423: invokevirtual 467	com/linkedin/android/pegasus/gen/common/Urn:toString	()Ljava/lang/String;
    //   426: invokevirtual 512	com/linkedin/gen/avro2pegasus/events/common/TrackingObject$Builder:setObjectUrn	(Ljava/lang/String;)Lcom/linkedin/gen/avro2pegasus/events/common/TrackingObject$Builder;
    //   429: aload_0
    //   430: getfield 114	com/linkedin/android/identity/profile/ProfileViewFragment:profileDataProvider	Lcom/linkedin/android/identity/profile/ProfileDataProvider;
    //   433: invokevirtual 124	com/linkedin/android/identity/profile/ProfileDataProvider:getProfileModel	()Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/Profile;
    //   436: getfield 130	com/linkedin/android/pegasus/gen/voyager/identity/profile/Profile:miniProfile	Lcom/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile;
    //   439: getfield 515	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile:trackingId	Ljava/lang/String;
    //   442: invokevirtual 518	com/linkedin/gen/avro2pegasus/events/common/TrackingObject$Builder:setTrackingId	(Ljava/lang/String;)Lcom/linkedin/gen/avro2pegasus/events/common/TrackingObject$Builder;
    //   445: astore 4
    //   447: aconst_null
    //   448: astore_3
    //   449: aload 4
    //   451: getstatic 460	com/linkedin/data/lite/RecordTemplate$Flavor:RECORD	Lcom/linkedin/data/lite/RecordTemplate$Flavor;
    //   454: invokevirtual 521	com/linkedin/gen/avro2pegasus/events/common/TrackingObject$Builder:build	(Lcom/linkedin/data/lite/RecordTemplate$Flavor;)Lcom/linkedin/gen/avro2pegasus/events/common/TrackingObject;
    //   457: astore 4
    //   459: aload 4
    //   461: astore_3
    //   462: aload_0
    //   463: getfield 178	com/linkedin/android/infra/app/TrackableFragment:tracker	Lcom/linkedin/android/litrackinglib/metric/Tracker;
    //   466: astore 4
    //   468: new 523	com/linkedin/gen/avro2pegasus/events/mobilesdk/ThirdPartyMobileSdkProfileViewEvent$Builder
    //   471: dup
    //   472: invokespecial 524	com/linkedin/gen/avro2pegasus/events/mobilesdk/ThirdPartyMobileSdkProfileViewEvent$Builder:<init>	()V
    //   475: astore 6
    //   477: aload 5
    //   479: ifnonnull +309 -> 788
    //   482: aload 6
    //   484: iconst_0
    //   485: putfield 527	com/linkedin/gen/avro2pegasus/events/mobilesdk/ThirdPartyMobileSdkProfileViewEvent$Builder:hasThirdPartyApplicationIdentifier	Z
    //   488: aload 6
    //   490: aconst_null
    //   491: putfield 530	com/linkedin/gen/avro2pegasus/events/mobilesdk/ThirdPartyMobileSdkProfileViewEvent$Builder:thirdPartyApplicationIdentifier	Ljava/lang/String;
    //   494: aload_3
    //   495: ifnonnull +309 -> 804
    //   498: aload 6
    //   500: iconst_0
    //   501: putfield 533	com/linkedin/gen/avro2pegasus/events/mobilesdk/ThirdPartyMobileSdkProfileViewEvent$Builder:hasViewee	Z
    //   504: aload 6
    //   506: aconst_null
    //   507: putfield 537	com/linkedin/gen/avro2pegasus/events/mobilesdk/ThirdPartyMobileSdkProfileViewEvent$Builder:viewee	Lcom/linkedin/gen/avro2pegasus/events/common/TrackingObject;
    //   510: aload 4
    //   512: aload 6
    //   514: invokevirtual 495	com/linkedin/android/litrackinglib/metric/Tracker:send	(Lcom/linkedin/android/tracking/v2/event/TrackingEventBuilder;)V
    //   517: return
    //   518: astore_3
    //   519: aload_0
    //   520: invokevirtual 350	com/linkedin/android/identity/profile/ProfileViewFragment:getContext	()Landroid/content/Context;
    //   523: pop
    //   524: new 539	java/lang/RuntimeException
    //   527: dup
    //   528: new 227	java/lang/StringBuilder
    //   531: dup
    //   532: ldc_w 541
    //   535: invokespecial 542	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   538: aload 4
    //   540: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: ldc_w 544
    //   546: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload_3
    //   550: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokespecial 548	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   559: invokestatic 409	com/linkedin/android/infra/shared/Util:safeThrow$7a8b4789	(Ljava/lang/RuntimeException;)V
    //   562: return
    //   563: getstatic 554	com/linkedin/android/identity/shared/ProfileViewUtils$2:$SwitchMap$com$linkedin$android$pegasus$gen$voyager$common$DiscloseAsProfileViewerInfo	[I
    //   566: aload_3
    //   567: getfield 558	com/linkedin/android/pegasus/gen/voyager/common/MySettings:discloseAsProfileViewer	Lcom/linkedin/android/pegasus/gen/voyager/common/DiscloseAsProfileViewerInfo;
    //   570: invokevirtual 564	com/linkedin/android/pegasus/gen/voyager/common/DiscloseAsProfileViewerInfo:ordinal	()I
    //   573: iaload
    //   574: tableswitch	default:+26->600, 1:+29->603, 2:+36->610, 3:+43->617
    //   600: goto -417 -> 183
    //   603: ldc_w 566
    //   606: astore_3
    //   607: goto -422 -> 185
    //   610: ldc_w 568
    //   613: astore_3
    //   614: goto -429 -> 185
    //   617: ldc_w 570
    //   620: astore_3
    //   621: goto -436 -> 185
    //   624: aload 6
    //   626: iconst_1
    //   627: putfield 442	com/linkedin/gen/avro2pegasus/events/EntityView$Builder:hasTargetId	Z
    //   630: aload 6
    //   632: aload 8
    //   634: invokevirtual 573	java/lang/Integer:intValue	()I
    //   637: putfield 445	com/linkedin/gen/avro2pegasus/events/EntityView$Builder:targetId	I
    //   640: goto -386 -> 254
    //   643: astore 6
    //   645: aload_0
    //   646: getfield 577	com/linkedin/android/infra/app/BaseFragment:fragmentComponent	Lcom/linkedin/android/infra/components/FragmentComponent;
    //   649: invokeinterface 582 1 0
    //   654: pop
    //   655: new 539	java/lang/RuntimeException
    //   658: dup
    //   659: ldc_w 584
    //   662: aload 6
    //   664: invokespecial 587	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   667: invokestatic 409	com/linkedin/android/infra/shared/Util:safeThrow$7a8b4789	(Ljava/lang/RuntimeException;)V
    //   670: goto -372 -> 298
    //   673: aload 6
    //   675: iconst_1
    //   676: putfield 451	com/linkedin/gen/avro2pegasus/events/EntityView$Builder:hasViewerId	Z
    //   679: aload 6
    //   681: aload 8
    //   683: invokevirtual 573	java/lang/Integer:intValue	()I
    //   686: putfield 454	com/linkedin/gen/avro2pegasus/events/EntityView$Builder:viewerId	I
    //   689: goto -405 -> 284
    //   692: aload 8
    //   694: iconst_1
    //   695: putfield 470	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:hasVieweeMemberUrn	Z
    //   698: aload 8
    //   700: aload 9
    //   702: putfield 473	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:vieweeMemberUrn	Ljava/lang/String;
    //   705: goto -368 -> 337
    //   708: aload 8
    //   710: iconst_1
    //   711: putfield 476	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:hasViewerPrivacySetting	Z
    //   714: aload 8
    //   716: aload_3
    //   717: putfield 479	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:viewerPrivacySetting	Ljava/lang/String;
    //   720: goto -367 -> 353
    //   723: aload 8
    //   725: iconst_1
    //   726: putfield 482	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:hasNetworkDistance	Z
    //   729: aload 8
    //   731: aload 4
    //   733: invokevirtual 573	java/lang/Integer:intValue	()I
    //   736: putfield 485	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:networkDistance	I
    //   739: goto -369 -> 370
    //   742: aload 8
    //   744: iconst_1
    //   745: putfield 488	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:hasEntityView	Z
    //   748: aload 8
    //   750: aload 5
    //   752: putfield 492	com/linkedin/gen/avro2pegasus/events/ProfileViewEvent$Builder:entityView	Lcom/linkedin/gen/avro2pegasus/events/EntityView;
    //   755: goto -368 -> 387
    //   758: astore 4
    //   760: aload_0
    //   761: getfield 577	com/linkedin/android/infra/app/BaseFragment:fragmentComponent	Lcom/linkedin/android/infra/components/FragmentComponent;
    //   764: invokeinterface 582 1 0
    //   769: pop
    //   770: new 539	java/lang/RuntimeException
    //   773: dup
    //   774: ldc_w 589
    //   777: aload 4
    //   779: invokespecial 587	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   782: invokestatic 409	com/linkedin/android/infra/shared/Util:safeThrow$7a8b4789	(Ljava/lang/RuntimeException;)V
    //   785: goto -323 -> 462
    //   788: aload 6
    //   790: iconst_1
    //   791: putfield 527	com/linkedin/gen/avro2pegasus/events/mobilesdk/ThirdPartyMobileSdkProfileViewEvent$Builder:hasThirdPartyApplicationIdentifier	Z
    //   794: aload 6
    //   796: aload 5
    //   798: putfield 530	com/linkedin/gen/avro2pegasus/events/mobilesdk/ThirdPartyMobileSdkProfileViewEvent$Builder:thirdPartyApplicationIdentifier	Ljava/lang/String;
    //   801: goto -307 -> 494
    //   804: aload 6
    //   806: iconst_1
    //   807: putfield 533	com/linkedin/gen/avro2pegasus/events/mobilesdk/ThirdPartyMobileSdkProfileViewEvent$Builder:hasViewee	Z
    //   810: aload 6
    //   812: aload_3
    //   813: putfield 537	com/linkedin/gen/avro2pegasus/events/mobilesdk/ThirdPartyMobileSdkProfileViewEvent$Builder:viewee	Lcom/linkedin/gen/avro2pegasus/events/common/TrackingObject;
    //   816: goto -306 -> 510
    //   819: astore_3
    //   820: goto -301 -> 519
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	823	0	this	ProfileViewFragment
    //   58	173	1	l	long
    //   76	419	3	localObject1	Object
    //   518	49	3	localNullPointerException	NullPointerException
    //   606	207	3	str1	String
    //   819	1	3	localIllegalArgumentException	IllegalArgumentException
    //   37	695	4	localObject2	Object
    //   758	20	4	localBuilderException1	com.linkedin.data.lite.BuilderException
    //   65	732	5	localObject3	Object
    //   68	563	6	localObject4	Object
    //   643	168	6	localBuilderException2	com.linkedin.data.lite.BuilderException
    //   202	220	7	localUrn	Urn
    //   235	514	8	localObject5	Object
    //   318	383	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   39	59	518	java/lang/NullPointerException
    //   207	237	643	com/linkedin/data/lite/BuilderException
    //   242	254	643	com/linkedin/data/lite/BuilderException
    //   254	267	643	com/linkedin/data/lite/BuilderException
    //   272	284	643	com/linkedin/data/lite/BuilderException
    //   284	294	643	com/linkedin/data/lite/BuilderException
    //   624	640	643	com/linkedin/data/lite/BuilderException
    //   673	689	643	com/linkedin/data/lite/BuilderException
    //   449	459	758	com/linkedin/data/lite/BuilderException
    //   39	59	819	java/lang/IllegalArgumentException
  }
  
  private void sendTrackingEvents()
  {
    boolean bool = "enabled".equals(fragmentComponent.lixManager().getTreatment(Lix.PROFILE_VIEW_EVENT_NO_DELAYED_EXECUTION));
    if (bool) {
      sendProfileViewEvent();
    }
    delayedExecution.postExecution(new ProfileViewFragment.12(this, bool));
  }
  
  private void setupFloatingActionButton()
  {
    if (ignoreFabUpdates) {
      return;
    }
    Object localObject = getActivityactivityComponent.lixManager();
    if (((profileId != null) && (memberUtil.isSelf(profileId))) || ((getArguments() != null) && (getArguments().getBoolean("selfProfile")))) {}
    for (int i = 1; (i != 0) && (!"control".equals(((LixManager)localObject).getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS))); i = 0)
    {
      localObject = (CoordinatorLayout.LayoutParams)floatingActionButton.getLayoutParams();
      ((CoordinatorLayout.LayoutParams)localObject).setBehavior(new ScrollAwareFABBehavior());
      floatingActionButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      floatingActionButton.setVisibility(0);
      floatingActionButton.setOnClickListener(new ProfileViewFragment.2(this, tracker, "new_section_open", new TrackingEventBuilder[0]));
      return;
    }
    floatingActionButton.setVisibility(8);
  }
  
  private void setupOverflowButton()
  {
    if ((!isMeTabProfile) && (!"control".equals(fragmentComponent.lixManager().getTreatment(Lix.PROFILE_VIEW_OVERFLOW_ACTIONS))) && (profileId != null) && (profileDataProvider.getActions() != null) && (profileDataProvider.getActions().hasOverflowActions))
    {
      overflowButton.setVisibility(0);
      overflowButton.setOnClickListener(new ProfileViewFragment.4(this, tracker, "profile_view_overflow", new TrackingEventBuilder[0]));
      return;
    }
    overflowButton.setVisibility(8);
  }
  
  private void setupProfileViewCards(boolean paramBoolean)
  {
    Object localObject1 = ProfileViewTransformer.getFormattedFullName(profileDataProvider.getProfileModel().miniProfile, fragmentComponent.i18NManager());
    Object localObject4;
    ProfileViewAdapter localProfileViewAdapter;
    Object localObject12;
    FragmentComponent localFragmentComponent;
    boolean bool1;
    ProfileViewListener localProfileViewListener;
    Object localObject11;
    Object localObject13;
    ProfileNetworkInfo localProfileNetworkInfo;
    Object localObject10;
    Object localObject9;
    label251:
    Object localObject8;
    CollectionTemplate localCollectionTemplate16;
    CollectionTemplate localCollectionTemplate15;
    CollectionTemplate localCollectionTemplate13;
    CollectionTemplate localCollectionTemplate14;
    Object localObject7;
    Object localObject2;
    CollectionTemplate localCollectionTemplate1;
    label432:
    Object localObject3;
    label509:
    Object localObject5;
    Object localObject6;
    int j;
    label604:
    long l1;
    label612:
    String str;
    boolean bool3;
    Object localObject14;
    label702:
    Object localObject15;
    label881:
    long l2;
    label935:
    long l3;
    label962:
    int i;
    label1101:
    label1178:
    label1262:
    int k;
    if (openSearchEntryType == 2)
    {
      searchBarText.setText((CharSequence)localObject1);
      localObject4 = profileDataProvider;
      localProfileViewAdapter = profileViewAdapter;
      localObject12 = applicationComponent;
      fragmentComponent.activity();
      localFragmentComponent = fragmentComponent;
      bool1 = isMeTabProfile;
      localProfileViewListener = profileViewListener;
      Profile localProfile = ((ProfileDataProvider)localObject4).getProfileModel();
      localObject11 = ((ProfileDataProvider)localObject4).getActions();
      localObject13 = ((ProfileDataProvider)localObject4).getMemberBadges();
      localProfileNetworkInfo = ((ProfileDataProvider)localObject4).getNetworkInfoModel();
      ((ProfileDataProvider)localObject4).verifyDataAvailable("getPosts");
      localObject1 = (ProfileState)state;
      localObject10 = (CollectionTemplate)((ProfileState)localObject1).getModel(postsRoute);
      ((ProfileDataProvider)localObject4).verifyDataAvailable("getRecentActivityUpdates");
      localObject1 = (ProfileState)state;
      localObject9 = (CollectionTemplate)((ProfileState)localObject1).getModel(recentActivityRoute);
      ((ProfileDataProvider)localObject4).verifyDataAvailable("getHighlights");
      localObject1 = (ProfileState)state;
      CollectionTemplate localCollectionTemplate19 = (CollectionTemplate)((ProfileState)localObject1).getModel(highlightsRoute);
      if (!paramBoolean) {
        break label3227;
      }
      ((ProfileDataProvider)localObject4).verifyDataAvailable("getSuggestedEndorsements");
      localObject1 = (ProfileState)state;
      localObject1 = (CollectionTemplate)((ProfileState)localObject1).getModel(suggestedEndorsementsRoute);
      localObject8 = ((ProfileDataProvider)localObject4).getPositions();
      CollectionTemplate localCollectionTemplate17 = ((ProfileDataProvider)localObject4).getEducations();
      CollectionTemplate localCollectionTemplate18 = ((ProfileDataProvider)localObject4).getVolunteerExperiences();
      localCollectionTemplate16 = ((ProfileDataProvider)localObject4).getRecommendationsReceived();
      ((ProfileDataProvider)localObject4).getRecommendationsGiven();
      localCollectionTemplate15 = ((ProfileDataProvider)localObject4).getSkills();
      localCollectionTemplate13 = ((ProfileDataProvider)localObject4).getEndorsedSkills();
      localCollectionTemplate14 = ((ProfileDataProvider)localObject4).getFeaturedSkills();
      localObject7 = ((ProfileDataProvider)localObject4).getProjects();
      CollectionTemplate localCollectionTemplate6 = ((ProfileDataProvider)localObject4).getCourses();
      CollectionTemplate localCollectionTemplate7 = ((ProfileDataProvider)localObject4).getCertifications();
      CollectionTemplate localCollectionTemplate8 = ((ProfileDataProvider)localObject4).getHonors();
      CollectionTemplate localCollectionTemplate9 = ((ProfileDataProvider)localObject4).getPatents();
      CollectionTemplate localCollectionTemplate10 = ((ProfileDataProvider)localObject4).getPublications();
      CollectionTemplate localCollectionTemplate11 = ((ProfileDataProvider)localObject4).getTestScores();
      ((ProfileDataProvider)localObject4).verifyDataAvailable("getBrowseMap");
      localObject2 = (ProfileState)state;
      localCollectionTemplate1 = (CollectionTemplate)((ProfileState)localObject2).getModel(browseMapRoute);
      ((ProfileDataProvider)localObject4).verifyDataAvailable("getSameName");
      localObject2 = (ProfileState)state;
      CollectionTemplate localCollectionTemplate2 = (CollectionTemplate)((ProfileState)localObject2).getModel(sameNameRoute);
      if (!paramBoolean) {
        break label3233;
      }
      localObject2 = ((ProfileDataProvider)localObject4).getGuidedEditCategories();
      ((ProfileDataProvider)localObject4).verifyDataAvailable("getAllConnections");
      localObject3 = (ProfileState)state;
      CollectionTemplate localCollectionTemplate3 = (CollectionTemplate)((ProfileState)localObject3).getModel(allConnectionsRoute);
      ((ProfileDataProvider)localObject4).verifyDataAvailable("getCommonConnections");
      localObject3 = (ProfileState)state;
      CollectionTemplate localCollectionTemplate4 = (CollectionTemplate)((ProfileState)localObject3).getModel(commonConnectionsRoute);
      if (!paramBoolean) {
        break label3239;
      }
      localObject3 = ((ProfileDataProvider)localObject4).getProfilePromotions();
      CollectionTemplate localCollectionTemplate12 = ((ProfileDataProvider)localObject4).getGroups();
      ((ProfileDataProvider)localObject4).verifyDataAvailable("interests");
      localObject5 = (ProfileState)state;
      CollectionTemplate localCollectionTemplate5 = (CollectionTemplate)((ProfileState)localObject5).getModel(interestsRoute);
      ((ProfileDataProvider)localObject4).verifyDataAvailable("getWorkWithUsAd");
      localObject5 = (ProfileState)state;
      WWUAd localWWUAd = (WWUAd)((ProfileState)localObject5).getModel(workWithUsRoute);
      localObject6 = ((ProfileDataProvider)localObject4).getContactInfo();
      if (((ApplicationComponent)localObject12).auth().isAuthenticated()) {
        break label3245;
      }
      j = 1;
      if (localProfileNetworkInfo != null) {
        break label3250;
      }
      l1 = 0L;
      str = miniProfile.entityUrn.getId();
      localObject5 = new ArrayList();
      bool3 = ProfileViewUtils.isSelfView(miniProfile, localProfileNetworkInfo, localFragmentComponent);
      boolean bool2 = "enabled".equals(localFragmentComponent.lixManager().getTreatment(Lix.LIX_PROFILE_VIEW_ALL_CONNECTIONS_CARD_AFTER_GROUPS));
      localObject14 = ProfileViewTransformer.findPhotoGuidedEditCategory((CollectionTemplate)localObject2);
      if (!CollectionUtils.isNonEmpty(localCollectionTemplate17)) {
        break label3260;
      }
      localObject4 = (Education)elements.get(0);
      localObject15 = new ArrayList();
      ProfileViewTransformer.addIfNotNull((List)localObject5, new Pair(TopCardViewTransformer.toTopCard(miniProfile, headline, summary, locationName, pictureInfo, (MemberBadges)localObject13, localProfileNetworkInfo, (Education)localObject4, (List)localObject15, (ProfileActions)localObject11, localCollectionTemplate3, localCollectionTemplate4, localFragmentComponent, bool1, localProfileViewListener, (GuidedEditCategory)localObject14), ProfileViewTransformer.ProfileCardType.TOP));
      paramBoolean = "enabled".equals(localFragmentComponent.lixManager().getTreatment(Lix.PROFILE_ENABLE_PROMOTIONS));
      boolean bool4 = "enabled".equals(localFragmentComponent.lixManager().getTreatment(Lix.LIX_PROFILE_VIEW_SUGGESTED_ENDORSEMENT_CARD));
      if ((bool3) || (!CollectionUtils.isNonEmpty((CollectionTemplate)localObject1)) || (!bool4)) {
        break label4279;
      }
      localObject15 = miniProfile;
      localObject3 = new SuggestedEndorsementCardViewModel();
      if (!CollectionUtils.isEmpty(elements)) {
        break label3266;
      }
      localObject1 = new Pair(localObject3, ProfileViewTransformer.ProfileCardType.SUGGESTED_ENDORSEMENTS);
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      localObject1 = localFragmentComponent.profileDataProvider();
      if ((!bool3) || (localObject1 == null)) {
        break label4347;
      }
      localObject3 = ((ProfileDataProvider)localObject1).getMeHeader();
      if ((localObject3 == null) || (!hasNumProfileViews)) {
        break label4328;
      }
      l2 = numProfileViews;
      localObject3 = ((ProfileDataProvider)localObject1).getMeHeader();
      if ((localObject3 == null) || (!hasNumLastUpdateViews)) {
        break label4334;
      }
      l3 = numLastUpdateViews;
      localObject1 = ((ProfileDataProvider)localObject1).getMeHeader();
      localObject3 = localFragmentComponent.lixManager();
      localObject4 = localFragmentComponent.memberUtil();
      localObject12 = localFragmentComponent.i18NManager();
      localObject13 = localFragmentComponent.tracker();
      localObject14 = localFragmentComponent.appContext();
      localObject15 = new WvmpViewModel2();
      wvmsCountString = ((I18NManager)localObject12).getString(2131233744, new Object[] { Long.valueOf(l3) });
      wvmpCountString = ((I18NManager)localObject12).getString(2131233743, new Object[] { Long.valueOf(l2) });
      if ((localObject1 == null) || (!hasLastUpdateType) || (lastUpdateType != SocialUpdateType.POST)) {
        break label4340;
      }
      i = 2131233742;
      wvmsTitle = ((I18NManager)localObject12).getString(i);
      wvmpOnClickListener = new WvmpCardTransformer2.1((Tracker)localObject13, "profile_self_wvmp", new TrackingEventBuilder[0], (Context)localObject14);
      wvmsOnClickListener = new WvmpCardTransformer2.2((Tracker)localObject13, "profile_self_wvms", new TrackingEventBuilder[0], (LixManager)localObject3, (MemberUtil)localObject4, (Header)localObject1, (Context)localObject14);
      localObject1 = new Pair(localObject15, ProfileViewTransformer.ProfileCardType.WVMP);
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      if ((!bool3) || (!CollectionUtils.isNonEmpty((CollectionTemplate)localObject2))) {
        break label4353;
      }
      localObject1 = elements;
      localObject2 = new GuidedEditEntryPointViewModel();
      fragmentComponent = localFragmentComponent;
      guidedEditCategoryMap = GuidedEditEntryTransformer.toGuidedEditCategoryMapWithOnlyValidEntries((List)localObject1, localFragmentComponent);
      parentAdapter = localProfileViewAdapter;
      isMeTabProfile = bool1;
      localObject1 = new Pair(localObject2, ProfileViewTransformer.ProfileCardType.GUIDED_EDIT);
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      localObject1 = miniProfile;
      if ((("control".equals(localFragmentComponent.lixManager().getTreatment(Lix.PROFILE_VIEW_RECENT_ACTIVITY_CARD))) || (!CollectionUtils.isNonEmpty((CollectionTemplate)localObject9))) && (!CollectionUtils.isNonEmpty((CollectionTemplate)localObject10))) {
        break label4528;
      }
      localFragmentComponent.i18NManager();
      localObject3 = I18NManager.getName((MiniProfile)localObject1);
      k = 1;
      i = k;
      if (localObject11 != null)
      {
        if ((!hasPrimaryAction) || ((primaryAction.action.followValue == null) && (primaryAction.action.unfollowValue == null))) {
          break label4359;
        }
        i = 0;
      }
      label1381:
      if (CollectionUtils.isEmpty((CollectionTemplate)localObject10)) {
        break label4406;
      }
      paramBoolean = true;
      label1391:
      localObject4 = new RecentActivityCardViewModel();
      localObject11 = localFragmentComponent.i18NManager();
      if ((localProfileNetworkInfo != null) && (i != 0) && (followable) && (!bool3))
      {
        isFollowable = true;
        if (!hasFollowingInfo) {
          break label4411;
        }
        bool1 = followingInfo.following;
        label1455:
        isFollowing = bool1;
        if (!bool1) {
          break label4421;
        }
        localObject1 = new RecentActivityTransformer.1(localFragmentComponent.tracker(), "unfollow", localFragmentComponent);
        label1488:
        followButtonClicked = ((TrackingClosure)localObject1);
      }
      if (!paramBoolean) {
        break label4488;
      }
      if (!bool3) {
        break label4445;
      }
      localObject1 = ((I18NManager)localObject11).getString(2131233277);
      label1514:
      isPostPresent = true;
      localObject2 = elements;
      i = paging.total;
      localObject10 = new PostsCarouselViewModel();
      if (((List)localObject2).size() > 10) {
        break label4467;
      }
      label1557:
      posts = ((List)localObject2);
      name = ((Name)localObject3);
      fragmentComponent = localFragmentComponent;
      postCountClicked = new RecentActivityTransformer.5(localFragmentComponent.tracker(), "view_post_details", new TrackingEventBuilder[0], localFragmentComponent, str, localProfileViewListener);
      totalPostsCount = i;
      postCarouselViewModel = ((PostsCarouselViewModel)localObject10);
      label1623:
      cardTitle = ((String)localObject1);
      followerCount = ((I18NManager)localObject11).getString(2131233269, new Object[] { Long.valueOf(l1) });
      activitySectionViewModel = RecentActivityTransformer.toActivitySection((CollectionTemplate)localObject9, (Name)localObject3, bool3, paramBoolean, localFragmentComponent);
      viewAllButtonStringRes = 2131232264;
      viewAllClickListener = new RecentActivityTransformer.4(localFragmentComponent.tracker(), "recent_activity_details_all", new TrackingEventBuilder[0], localFragmentComponent, str, localProfileViewListener);
      localObject1 = new Pair(localObject4, ProfileViewTransformer.ProfileCardType.RECENT_ACTIVITY);
      label1726:
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      localObject1 = localFragmentComponent.memberUtil().getMiniProfile();
      localObject2 = miniProfile;
      if ((bool3) || (localWWUAd == null) || (!hasCompany) || ("control".equals(localFragmentComponent.lixManager().getTreatment(Lix.PROFILE_VIEW_WORK_WITH_US)))) {
        break label4558;
      }
      localObject3 = new WorkWithUsCardViewModel();
      localObject4 = localFragmentComponent.i18NManager();
      localObject9 = Util.retrieveRumSessionId(localFragmentComponent);
      if (localObject1 == null) {
        break label4534;
      }
      icon = new ImageModel(picture, GhostImageUtils.getPerson(2131492963, (MiniProfile)localObject1), (String)localObject9);
      label1852:
      title = ((I18NManager)localObject4).getString(2131233331, new Object[] { I18NManager.getName((MiniProfile)localObject2) });
      fragmentComponent = localFragmentComponent;
      impressionTrackingUrls = new ArrayList();
      if (hasCompany)
      {
        subTitle = ((I18NManager)localObject4).getString(2131233330, new Object[] { company.name });
        onClickClosure = new WorkWithUsTransformer.1(localFragmentComponent.tracker(), "work_with_us_clicked", localFragmentComponent, localWWUAd);
        if (hasInternalImpressionTrackingUrls) {
          impressionTrackingUrls.addAll(internalImpressionTrackingUrls);
        }
        if (hasExternalImpressionTrackingUrls) {
          impressionTrackingUrls.addAll(externalImpressionTrackingUrls);
        }
      }
      localObject1 = new Pair(localObject3, ProfileViewTransformer.ProfileCardType.WORK_WITH_US);
      label2020:
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      if ((bool3) || (!CollectionUtils.isNonEmpty(localCollectionTemplate19))) {
        break label4564;
      }
      localObject1 = new Pair(HighlightsTransformer.toHighlightsCard$328d0c98(localCollectionTemplate19, localCollectionTemplate3, miniProfile, localFragmentComponent, localProfileViewListener), ProfileViewTransformer.ProfileCardType.HIGHLIGHTS);
      label2069:
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      if (!bool2) {
        ProfileViewTransformer.addIfNotNull((List)localObject5, ProfileViewTransformer.getConnectionsCardViewModel(miniProfile, localProfileNetworkInfo, localCollectionTemplate3, localCollectionTemplate4, localFragmentComponent, localProfileViewListener));
      }
      if ((!CollectionUtils.isNonEmpty((CollectionTemplate)localObject8)) && (!CollectionUtils.isNonEmpty(localCollectionTemplate17)) && (!CollectionUtils.isNonEmpty(localCollectionTemplate18))) {
        break label4606;
      }
      if (!CollectionUtils.isNonEmpty((CollectionTemplate)localObject8)) {
        break label4570;
      }
      localObject1 = elements;
      label2145:
      if (!CollectionUtils.isNonEmpty(localCollectionTemplate17)) {
        break label4582;
      }
      localObject2 = elements;
      label2160:
      if (!CollectionUtils.isNonEmpty(localCollectionTemplate18)) {
        break label4594;
      }
      localObject3 = elements;
      label2175:
      localObject1 = new Pair(BackgroundTransformer.toBackgroundCard(str, (List)localObject1, (List)localObject2, (List)localObject3, CollectionUtils.getPagingTotal((CollectionTemplate)localObject8), CollectionUtils.getPagingTotal(localCollectionTemplate17), CollectionUtils.getPagingTotal(localCollectionTemplate18), bool3, localFragmentComponent, localProfileViewListener), ProfileViewTransformer.ProfileCardType.BACKGROUND);
      label2219:
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      if (!CollectionUtils.isNonEmpty(localCollectionTemplate16)) {
        break label5003;
      }
      if (j == 0) {
        break label4628;
      }
      localObject1 = new PublicProfileRecommendationCardViewModel();
      if ((elements == null) || (elements.isEmpty())) {
        break label4612;
      }
      firstRecommendationText = elements.get(0)).recommendationText;
      if (elements.size() > 1) {
        secondRecommendationText = elements.get(1)).recommendationText;
      }
      label2327:
      localObject1 = new Pair(localObject1, ProfileViewTransformer.ProfileCardType.PUBLIC_PROFILE_RECOMMENDATION);
      label2341:
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      if (!"enabled".equals(localFragmentComponent.lixManager().getTreatment(Lix.LIX_PROFILE_VIEW_FEATURED_SKILLS_CARD))) {
        break label5278;
      }
      if ((j == 0) || (!CollectionUtils.isNonEmpty(localCollectionTemplate15))) {
        break label5009;
      }
      localObject1 = new Pair(PublicProfileSkillsTransformer.toPublicProfileSkillsCard(localCollectionTemplate15), ProfileViewTransformer.ProfileCardType.PUBLIC_PROFILE_SKILLS);
      label2402:
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      if ((!CollectionUtils.isNonEmpty((CollectionTemplate)localObject7)) && (!CollectionUtils.isNonEmpty(localCollectionTemplate6)) && (!CollectionUtils.isNonEmpty(localCollectionTemplate7)) && (!CollectionUtils.isNonEmpty(localCollectionTemplate8)) && (!CollectionUtils.isNonEmpty(localCollectionTemplate9)) && (!CollectionUtils.isNonEmpty(localCollectionTemplate10)) && (!CollectionUtils.isNonEmpty(localCollectionTemplate11))) {
        break label5604;
      }
      localObject1 = new Pair(ProfileViewTransformer.toAccomplishmentsCard((CollectionTemplate)localObject7, localCollectionTemplate6, localCollectionTemplate7, localCollectionTemplate8, localCollectionTemplate9, localCollectionTemplate10, localCollectionTemplate11, str, bool3, localFragmentComponent, localProfileViewListener), ProfileViewTransformer.ProfileCardType.ACCOMPLISHMENTS);
      label2503:
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      if ((!CollectionUtils.isNonEmpty(localCollectionTemplate12)) || ("enabled".equals(localFragmentComponent.lixManager().getTreatment(Lix.LIX_PROFILE_VIEW_ENABLE_INTERESTS_CARD)))) {
        break label5615;
      }
      localObject1 = new ProfileViewGroupsCardViewModel();
      if ((hasPaging) && (paging.total > 3))
      {
        shouldShowViewMoreButton = true;
        i = paging.total;
        viewMoreLink = localFragmentComponent.i18NManager().getString(2131232265, new Object[] { Integer.valueOf(i - 3) });
        groupsViewMoreListener = new ProfileViewGroupsTransformer.2(localFragmentComponent.tracker(), "groups_details", new TrackingEventBuilder[0], str, localProfileViewListener, localFragmentComponent);
      }
      if (elements.size() >= 3) {
        break label5610;
      }
      i = elements.size();
      label2675:
      groupEntries = ProfileViewGroupsTransformer.toGroupsCardEntryViewModelList(elements, localFragmentComponent, i, true);
      localObject1 = new Pair(localObject1, ProfileViewTransformer.ProfileCardType.GROUPS);
      label2706:
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      localObject1 = miniProfile;
      if ((!localFragmentComponent.lixManager().getTreatment(Lix.LIX_PROFILE_VIEW_CONTACT_INFO).equals("enabled")) || (localObject6 == null)) {
        break label5715;
      }
      localObject2 = new ContactCardViewModel();
      entries = ContactTransformer.getContactCardEntries((ProfileContactInfo)localObject6, (MiniProfile)localObject1, bool3, false, localProfileViewListener, localFragmentComponent);
      if ((!bool3) || (!"enabled".equals(localFragmentComponent.lixManager().getTreatment(Lix.PROFILE_EDIT_CONTACT_INFO)))) {
        break label5621;
      }
      paramBoolean = true;
      label2809:
      showEditButton = paramBoolean;
      if (bool3) {
        editButtonOnClickListener = new ContactTransformer.1(localFragmentComponent.tracker(), "edit_contact_info", new TrackingEventBuilder[0], localProfileViewListener, (ProfileContactInfo)localObject6, localFragmentComponent);
      }
      i = entries.size();
      localObject3 = phoneNumbers;
      localObject4 = websites;
      localObject7 = ims;
      localObject6 = twitterHandles;
      if (i <= 3) {
        break label5626;
      }
      paramBoolean = true;
      label2898:
      showSeeMoreButton = paramBoolean;
      entries = entries.subList(0, Math.min(i, 3));
      if (entries.size() > 0) {
        entries.get(entries.size() - 1)).hideDivider = true;
      }
      seeMoreOnClickListener = new ContactTransformer.2(localFragmentComponent.tracker(), "contact_see_more", new TrackingEventBuilder[0], (MiniProfile)localObject1, localProfileViewListener, localFragmentComponent);
      localObject1 = new Pair(localObject2, ProfileViewTransformer.ProfileCardType.CONTACT);
      label3013:
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      if (bool2) {
        ProfileViewTransformer.addIfNotNull((List)localObject5, ProfileViewTransformer.getConnectionsCardViewModel(miniProfile, localProfileNetworkInfo, localCollectionTemplate3, localCollectionTemplate4, localFragmentComponent, localProfileViewListener));
      }
      localObject1 = miniProfile;
      if ((!CollectionUtils.isNonEmpty(localCollectionTemplate5)) || (!"enabled".equals(localFragmentComponent.lixManager().getTreatment(Lix.LIX_PROFILE_VIEW_ENABLE_INTERESTS_CARD)))) {
        break label5721;
      }
      localObject1 = new Pair(InterestsTransformer.getInterestsCard(localCollectionTemplate5, entityUrn.getLastId(), localFragmentComponent, localProfileViewListener), ProfileViewTransformer.ProfileCardType.INTERESTS);
      label3118:
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      if ((j == 0) || (!CollectionUtils.isNonEmpty(localCollectionTemplate2))) {
        break label5727;
      }
      localObject1 = new Pair(SameNameTransformer.toSameNameCard(miniProfile, localCollectionTemplate2, localFragmentComponent), ProfileViewTransformer.ProfileCardType.SAME_NAME);
      label3162:
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      if (!CollectionUtils.isNonEmpty(localCollectionTemplate1)) {
        break label5733;
      }
    }
    label3227:
    label3233:
    label3239:
    label3245:
    label3250:
    label3260:
    label3266:
    label3863:
    label4279:
    label4328:
    label4334:
    label4340:
    label4347:
    label4353:
    label4359:
    label4406:
    label4411:
    label4421:
    label4445:
    label4467:
    label4488:
    label4528:
    label4534:
    label4558:
    label4564:
    label4570:
    label4582:
    label4594:
    label4606:
    label4612:
    label4628:
    label4770:
    label4851:
    label4873:
    label4928:
    label4946:
    label5003:
    label5009:
    label5032:
    label5267:
    label5278:
    label5341:
    label5593:
    label5604:
    label5610:
    label5615:
    label5621:
    label5626:
    label5715:
    label5721:
    label5727:
    label5733:
    for (localObject1 = new Pair(BrowseMapTransformer.toBrowseMapCard(localCollectionTemplate1, localFragmentComponent), ProfileViewTransformer.ProfileCardType.BROWSE_MAP);; localObject1 = null)
    {
      ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
      profileViewAdapter.setProfileCards((List)localObject5);
      return;
      toolbar.setTitle((CharSequence)localObject1);
      break;
      localObject1 = null;
      break label251;
      localObject2 = null;
      break label432;
      localObject3 = null;
      break label509;
      j = 0;
      break label604;
      l1 = followersCount;
      break label612;
      localObject4 = null;
      break label702;
      localObject4 = (SuggestedEndorsement)elements.get(0);
      localObject13 = localFragmentComponent.i18NManager();
      localObject14 = endorsedSkillName;
      localObject15 = I18NManager.getName((MiniProfile)localObject15);
      Object localObject16 = I18NManager.getName(localFragmentComponent.memberUtil().getMiniProfile());
      entityLogo = new ImageModel(null, 2130838481, null, null);
      if ((hasReason) && (reason.suggestedEndorsementReasonExpertValue != null))
      {
        headerText = ((I18NManager)localObject13).getString(2131233306, new Object[] { localObject16, localObject14 });
        if ((reason.suggestedEndorsementReasonExpertValue.hasHighlight) && (reason.suggestedEndorsementReasonExpertValue.highlight.detail.profileHighlightValue != null))
        {
          localObject16 = reason.suggestedEndorsementReasonExpertValue.highlight.detail.profileHighlightValue;
          if (detail.sharedExperiencesInfoValue == null) {
            break label3863;
          }
          localObject16 = reason.suggestedEndorsementReasonExpertValue.highlight.detail.profileHighlightValue.detail.sharedExperiencesInfoValue.sharedExperiences.get(0)).company;
          if (hasLogo) {
            entityLogo = new ImageModel(logo, 2130838481, null);
          }
          reasonText = ((I18NManager)localObject13).getString(2131233298, new Object[] { name });
        }
      }
      for (;;)
      {
        localObject16 = new SuggestedEndorsementConfirmationCardViewModel();
        educationText = ((I18NManager)localObject13).getString(2131233300);
        closeButtonListener = new SuggestedEndorsementTransformer.1(localProfileViewAdapter, localFragmentComponent, (SuggestedEndorsementConfirmationCardViewModel)localObject16, "suggested_endorsement_dismiss");
        Object localObject17 = new SuggestedEndorsementConfirmationCardViewModel();
        thanksText = ((I18NManager)localObject13).getString(2131233304, new Object[] { localObject15 });
        educationText = ((I18NManager)localObject13).getString(2131233305);
        closeButtonListener = new SuggestedEndorsementTransformer.2(localProfileViewAdapter, localFragmentComponent, (SuggestedEndorsementConfirmationCardViewModel)localObject17, "suggested_endorsement_dismiss");
        Request.Builder localBuilder = SuggestedEndorsementTransformer.setupImpressionRequest((SuggestedEndorsement)localObject4, (ApplicationComponent)localObject12, (SuggestedEndorsementCardViewModel)localObject3);
        skipListener = new SuggestedEndorsementCardSkipListener(localProfileViewAdapter, localFragmentComponent, (ViewModel)localObject3, (SuggestedEndorsementConfirmationCardViewModel)localObject16, "suggested_endorsement_skip", signature, localFragmentComponent.legoTrackingDataProvider(), metadata).legoTrackingToken, (ApplicationComponent)localObject12, localBuilder);
        endorseListener = new SuggestedEndorsementCardEndorseListener(localProfileViewAdapter, localFragmentComponent, (ViewModel)localObject3, (SuggestedEndorsementConfirmationCardViewModel)localObject17, "suggested_endorsement_endorse", signature, localFragmentComponent.legoTrackingDataProvider(), metadata).legoTrackingToken, (ApplicationComponent)localObject12, localBuilder);
        closeButtonListener = new SuggestedEndorsementCardDismissSkipListener(localProfileViewAdapter, localFragmentComponent, (ViewModel)localObject3, "suggested_endorsement_dismiss", signature, localFragmentComponent.legoTrackingDataProvider(), metadata).legoTrackingToken, (ApplicationComponent)localObject12, localBuilder);
        questionText = ((I18NManager)localObject13).getString(2131233307, new Object[] { localObject15, localObject14 });
        localFragmentComponent.legoTrackingDataProvider().sendWidgetImpressionEvent$4bb724c7(metadata).legoTrackingToken, Visibility.SHOW);
        break;
        if (detail.sharedEducationsInfoValue != null)
        {
          localObject16 = reason.suggestedEndorsementReasonExpertValue.highlight.detail.profileHighlightValue.detail.sharedEducationsInfoValue.sharedEducations.get(0)).school;
          if (hasLogo) {
            entityLogo = new ImageModel(logo, 2130838481, null);
          }
          reasonText = ((I18NManager)localObject13).getString(2131233297, new Object[] { schoolName });
          continue;
          if ((hasReason) && (reason.suggestedEndorsementReasonStandardValue != null) && (reason.suggestedEndorsementReasonStandardValue.hasHighlight) && (reason.suggestedEndorsementReasonStandardValue.highlight.detail.profileHighlightValue != null))
          {
            localObject17 = reason.suggestedEndorsementReasonStandardValue.highlight.detail.profileHighlightValue;
            if (detail.sharedExperiencesInfoValue != null)
            {
              localObject17 = reason.suggestedEndorsementReasonStandardValue.highlight.detail.profileHighlightValue.detail.sharedExperiencesInfoValue.sharedExperiences.get(0)).company;
              if (hasLogo) {
                entityLogo = new ImageModel(logo, 2130838481, null);
              }
              headerText = ((I18NManager)localObject13).getString(2131233308, new Object[] { localObject16, localObject15, name });
            }
            else if (detail.sharedEducationsInfoValue != null)
            {
              localObject17 = reason.suggestedEndorsementReasonStandardValue.highlight.detail.profileHighlightValue.detail.sharedEducationsInfoValue.sharedEducations.get(0)).school;
              if (hasLogo) {
                entityLogo = new ImageModel(logo, 2130838481, null);
              }
              headerText = ((I18NManager)localObject13).getString(2131233303, new Object[] { localObject16, localObject15, schoolName });
            }
          }
        }
      }
      if ((paramBoolean) && (CollectionUtils.isNonEmpty((CollectionTemplate)localObject3)))
      {
        localObject1 = ProfilePromotionTransformer.toProfilePromotionCard((CollectionTemplate)localObject3, localFragmentComponent);
        if (localObject1 != null)
        {
          localObject1 = new Pair(localObject1, ProfileViewTransformer.ProfileCardType.PROMOTION);
          break label881;
        }
      }
      localObject1 = null;
      break label881;
      l2 = 0L;
      break label935;
      l3 = 0L;
      break label962;
      i = 2131233745;
      break label1101;
      localObject1 = null;
      break label1178;
      localObject1 = null;
      break label1262;
      i = k;
      if (!hasSecondaryAction) {
        break label1381;
      }
      if (secondaryAction.action.followValue == null)
      {
        i = k;
        if (secondaryAction.action.unfollowValue == null) {
          break label1381;
        }
      }
      i = 0;
      break label1381;
      paramBoolean = false;
      break label1391;
      bool1 = following;
      break label1455;
      localObject1 = new RecentActivityTransformer.2(localFragmentComponent.tracker(), "follow", localFragmentComponent);
      break label1488;
      localObject1 = ((I18NManager)localObject11).getString(2131233276, new Object[] { localObject3 });
      break label1514;
      hasPlaceholder = true;
      localObject2 = ((List)localObject2).subList(0, 10);
      break label1557;
      if (bool3)
      {
        localObject1 = ((I18NManager)localObject11).getString(2131233274);
        break label1623;
      }
      localObject1 = ((I18NManager)localObject11).getString(2131233273, new Object[] { localObject3 });
      break label1623;
      localObject1 = null;
      break label1726;
      icon = new ImageModel(null, GhostImageUtils.getAnonymousPerson(2131492963), (String)localObject9);
      break label1852;
      localObject1 = null;
      break label2020;
      localObject1 = null;
      break label2069;
      localObject1 = new ArrayList();
      break label2145;
      localObject2 = new ArrayList();
      break label2160;
      localObject3 = new ArrayList();
      break label2175;
      localObject1 = null;
      break label2219;
      Util.safeThrow(new RuntimeException("toRecommendationsDetailCard should not be called without a received recommendation element"));
      break label2327;
      localObject2 = new RecommendationCardViewModel();
      if ((elements != null) && (!elements.isEmpty()))
      {
        localObject3 = localFragmentComponent.i18NManager();
        localObject4 = (Recommendation)elements.get(0);
        localObject8 = recommender;
        recommendationText = recommendationText;
        recommenderImage = new ImageModel(picture, GhostImageUtils.getPerson(2131492963, (MiniProfile)localObject8), Util.retrieveRumSessionId(localFragmentComponent));
        recommenderName = ((I18NManager)localObject3).getString(2131233236, new Object[] { I18NManager.getName((MiniProfile)localObject8) });
        if (hasOccupation)
        {
          localObject1 = occupation;
          recommenderHeadline = ((String)localObject1);
          recommendationRelationship = RecommendationsTransformer.getRecommendationRelationshipText((Recommendation)localObject4, (I18NManager)localObject3);
          recommenderOnClickListener = new RecommendationsTransformer.1(localFragmentComponent.tracker(), "recommendation_details", new TrackingEventBuilder[0], (MiniProfile)localObject8, localFragmentComponent);
          if ((!hasPaging) || (!paging.hasTotal)) {
            break label4928;
          }
          recsReceived = paging.total;
          if (recsReceived > 1) {
            break label4946;
          }
          viewMoreLink = ((I18NManager)localObject3).getString(2131232264);
          detailViewClickListener = new RecommendationsTransformer.2(localFragmentComponent.tracker(), "recommendation_details", new TrackingEventBuilder[0], str, localProfileViewListener, localFragmentComponent);
        }
      }
      for (;;)
      {
        localObject1 = new Pair(localObject2, ProfileViewTransformer.ProfileCardType.RECOMMENDATION);
        break;
        localObject1 = null;
        break label4770;
        recsReceived = elements.size();
        break label4851;
        viewMoreLink = ((I18NManager)localObject3).getString(2131232265, new Object[] { Integer.valueOf(recsReceived - 1) });
        break label4873;
        localFragmentComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException("toRecommendationsDetailCard should not be called without a received recommendation element"));
      }
      localObject1 = null;
      break label2341;
      if (CollectionUtils.isNonEmpty(localCollectionTemplate14))
      {
        if (localProfileNetworkInfo != null)
        {
          localObject1 = distance.value;
          localObject2 = new FeaturedSkillsCardViewModel();
          if (localObject1 != GraphDistance.SELF) {
            break label5267;
          }
        }
        for (paramBoolean = true;; paramBoolean = false)
        {
          isEditButtonVisible = paramBoolean;
          if (isEditButtonVisible) {
            skillsEditClickListener = new FeaturedSkillsTransformer.1(localFragmentComponent.tracker(), "edit_skills", new TrackingEventBuilder[0], localProfileViewListener, localFragmentComponent);
          }
          shouldShowViewMoreButton = false;
          localObject3 = localFragmentComponent.i18NManager();
          if (CollectionUtils.isNonEmpty(localCollectionTemplate14))
          {
            skills = FeaturedSkillsTransformer.toSkillEntries(elements, str, (GraphDistance)localObject1, ProfileViewUtils.vieweeEndorsementsEnabled(localCollectionTemplate14), localFragmentComponent, false, localProfileViewListener, true);
            if (paging != null)
            {
              i = paging.total - elements.size();
              if (i > 0)
              {
                shouldShowViewMoreButton = true;
                viewMoreLink = ((I18NManager)localObject3).getString(2131232608, new Object[] { Integer.valueOf(i) });
                skillsDetailsClickListener = new FeaturedSkillsTransformer.4(localFragmentComponent.tracker(), "skills_details", new TrackingEventBuilder[0], str, (GraphDistance)localObject1, localProfileViewListener, localFragmentComponent);
              }
            }
          }
          localObject1 = new Pair(localObject2, ProfileViewTransformer.ProfileCardType.FEATURED_SKILLS);
          break;
          localObject1 = GraphDistance.$UNKNOWN;
          break label5032;
        }
      }
      localObject1 = null;
      break label2402;
      if ((j != 0) && (CollectionUtils.isNonEmpty(localCollectionTemplate15))) {
        localObject1 = new Pair(PublicProfileSkillsTransformer.toPublicProfileSkillsCard(localCollectionTemplate15), ProfileViewTransformer.ProfileCardType.PUBLIC_PROFILE_SKILLS);
      }
      for (;;)
      {
        ProfileViewTransformer.addIfNotNull((List)localObject5, localObject1);
        break;
        if (CollectionUtils.isNonEmpty(localCollectionTemplate13))
        {
          if (localProfileNetworkInfo != null)
          {
            localObject1 = distance.value;
            localObject2 = new SkillsCardViewModel();
            if (localObject1 != GraphDistance.SELF) {
              break label5593;
            }
          }
          for (paramBoolean = true;; paramBoolean = false)
          {
            isEditButtonVisible = paramBoolean;
            if (isEditButtonVisible) {
              skillsEditClickListener = new SkillsTransformer.1(localFragmentComponent.tracker(), "edit_skills", new TrackingEventBuilder[0], localProfileViewListener, localFragmentComponent);
            }
            shouldShowViewMoreButton = false;
            localObject3 = localFragmentComponent.i18NManager();
            if ((localCollectionTemplate13 != null) && (elements != null))
            {
              skills = SkillsTransformer.toSkillEntries(elements, str, (GraphDistance)localObject1, ProfileViewUtils.vieweeEndorsementsEnabled(localCollectionTemplate13), localFragmentComponent, false, localProfileViewListener);
              if ((!elements.isEmpty()) && (paging != null))
              {
                i = paging.total - elements.size();
                if (i > 0)
                {
                  shouldShowViewMoreButton = true;
                  viewMoreLink = ((I18NManager)localObject3).getString(2131232265, new Object[] { Integer.valueOf(i) });
                  skillsDetailsClickListener = new SkillsTransformer.4(localFragmentComponent.tracker(), "skills_details", new TrackingEventBuilder[0], str, (GraphDistance)localObject1, localProfileViewListener, localFragmentComponent);
                }
              }
            }
            localObject1 = new Pair(localObject2, ProfileViewTransformer.ProfileCardType.SKILLS);
            break;
            localObject1 = GraphDistance.$UNKNOWN;
            break label5341;
          }
        }
        localObject1 = null;
      }
      localObject1 = null;
      break label2503;
      i = 3;
      break label2675;
      localObject1 = null;
      break label2706;
      paramBoolean = false;
      break label2809;
      if ((localObject3 != null) && (((List)localObject3).size() > 1))
      {
        paramBoolean = true;
        break label2898;
      }
      if ((localObject4 != null) && (((List)localObject4).size() > 1))
      {
        paramBoolean = true;
        break label2898;
      }
      if ((localObject7 != null) && (((List)localObject7).size() > 1))
      {
        paramBoolean = true;
        break label2898;
      }
      if ((localObject6 != null) && (((List)localObject6).size() > 1))
      {
        paramBoolean = true;
        break label2898;
      }
      paramBoolean = false;
      break label2898;
      localObject1 = null;
      break label3013;
      localObject1 = null;
      break label3118;
      localObject1 = null;
      break label3162;
    }
  }
  
  private boolean shouldAppIndexing()
  {
    return ((getActivity() instanceof ProfileViewActivity)) && ((auth == null) || (!auth.isAuthenticated()));
  }
  
  private void showSelfViewCrossPromos()
  {
    int i;
    String str;
    Promo localPromo;
    ViewGroup localViewGroup;
    if (((profileId != null) && (memberUtil.isSelf(profileId))) || ((getArguments() != null) && (getArguments().getBoolean("selfProfile"))))
    {
      i = 1;
      if ((i != 0) && (profileDataProvider != null) && (fragmentComponent.lixManager().getTreatment(Lix.PROFILE_SELF_VIEW_ENABLE_CROSSPROMO).equals("enabled")))
      {
        str = crossPromoPageKey("profile_self");
        localPromo = ((ProfileState)profileDataProvider.state).getCrossPromo(str);
        localViewGroup = (ViewGroup)getActivity().findViewById(2131756510);
        if ((!crossPromoShowed) && (localPromo != null) && (localViewGroup != null))
        {
          crossPromoShowed = true;
          ignoreFabUpdates = true;
          localViewGroup.bringToFront();
          localViewGroup.setOnHierarchyChangeListener(new ProfileViewFragment.10(this));
          if ((floatingActionButton == null) || (floatingActionButton.getVisibility() != 0)) {
            break label219;
          }
          floatingActionButton.hide(new ProfileViewFragment.11(this, localViewGroup, str, localPromo));
        }
      }
    }
    for (;;)
    {
      fragmentComponent.eventBus();
      Bus.getAndClearStickyEvent(ProfileSkillsAddedEvent.class);
      return;
      i = 0;
      break;
      label219:
      new ToastPromoInflater(localViewGroup, fragmentComponent.eventBus()).renderPromoModel(str, null, new PromoModel(localPromo));
    }
  }
  
  public final void doEnter()
  {
    super.doEnter();
    if (!hasEnteredAtLeastOnce) {
      hasEnteredAtLeastOnce = true;
    }
    viewPortManager.trackAll(tracker);
  }
  
  public final void doLeave()
  {
    super.doLeave();
    viewPortManager.untrackAll();
  }
  
  public final void doPause()
  {
    super.doPause();
    if ((profileDataProvider != null) && (profileDataProvider.state).isProfileViewCallInProgress)) {
      pausedWhileProfileViewCallInProgress = true;
    }
  }
  
  public final void doResume()
  {
    super.doResume();
    isRemoveFragmentTransactionCommitted = false;
    if (pausedWhileProfileViewCallInProgress)
    {
      pausedWhileProfileViewCallInProgress = false;
      if (fragmentComponent.lixManager().getTreatment(Lix.LIX_PROFILE_VIEW_RELOAD_IF_PAUSED).equals("enabled")) {
        profileDataProvider.fetchData(profileIdentifier, busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), DataManager.DataStoreFilter.ALL);
      }
    }
    do
    {
      return;
      if (reloadProfileViewData)
      {
        reloadProfileViewData = false;
        profileDataProvider.fetchData(profileIdentifier, busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), DataManager.DataStoreFilter.NETWORK_ONLY);
        return;
      }
    } while ((!isMeTabProfile) || (!hasEnteredAtLeastOnce));
    profileDataProvider.fetchGuidedEditCategories(busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), memberUtil.getProfileId(), GuidedEditSource.ORGANIC);
  }
  
  public final int feedType()
  {
    return 5;
  }
  
  protected final void firePageViewEvent()
  {
    super.firePageViewEvent();
    if ((profileDataProvider != null) && (profileDataProvider.isDataAvailable()))
    {
      sendTrackingEvents();
      sendGuidedEditPageViewEvent();
      return;
    }
    pendingTrackingEvents += 1;
  }
  
  protected final DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.profileDataProvider();
  }
  
  public final int getTrackingMode()
  {
    if (isMeTabProfile) {
      return 1;
    }
    return 0;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    googleApiClient = GoogleAppIndexingManager.createGoogleApiClient(getContext());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if ((paramInt1 != 11) || (paramIntent == null)) {
        break label69;
      }
      photoUri = paramIntent.getData();
    }
    for (;;)
    {
      if ((photoUri != null) && (!photoUri.toString().isEmpty()))
      {
        if (profileViewListener == null) {
          break;
        }
        ProfileEditFragmentUtils.startEditPhoto(profileViewListener, photoUri);
      }
      return;
      label69:
      if ((paramInt1 == 12) && (photoUri != null)) {
        getActivity().getContentResolver().notifyChange(photoUri, null);
      }
    }
    ProfileEditFragmentUtils.startEditPhoto((ProfileEditListener)getActivity(), photoUri);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof HomeActivity)) {
      profileViewListener = new ProfileViewListenerImpl((BaseActivity)paramActivity);
    }
    while ((paramActivity instanceof ProfileEditListener)) {
      return;
    }
    fragmentComponent.context();
    Util.safeThrow$7a8b4789(new IllegalStateException("Activity that holds ProfileViewFragment must implement profileEditListener"));
  }
  
  public final void onCameraDestinationUri(Uri paramUri)
  {
    photoUri = paramUri;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    applicationComponent.crossPromoManager();
    isMeTabProfile = getArguments().getBoolean("meTabProfile");
    GuidedEditIntent.setIsMeTabProfile(isMeTabProfile);
    getContext();
    openSearchEntryType = SearchUtils.getOpenSearchEntryType$67eca9c3(fragmentComponent.lixManager(), Lix.LIX_PROFILE_VIEW_SHOW_TOOLBAR_SEARCH_ICON);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969262, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if ((paramSet != null) && (paramSet.contains(getXpromoRoutePath()))) {
      return;
    }
    if ((profileDataProvider != null) && (paramType == DataStore.Type.NETWORK))
    {
      profileDataProvider.state).isProfileViewCallInProgress = false;
      pausedWhileProfileViewCallInProgress = false;
    }
    if (paramType != DataStore.Type.LOCAL)
    {
      if (!StringUtils.isEmpty(getArguments().getString("thirdPartyApplicationPackageName")))
      {
        paramType = new Intent();
        paramType.putExtra("com.linkedin.thirdparty.deeplink.EXTRA_ERROR_CODE", errorResponse.code());
        paramSet = paramDataManagerException.getMessage();
        if (!TextUtils.isEmpty(paramSet)) {
          paramType.putExtra("com.linkedin.thirdparty.deeplink.EXTRA_ERROR_MESSAGE", paramSet);
        }
        getActivity().setResult(0, paramType);
      }
      paramType = paramDataManagerException;
      if ((paramDataManagerException instanceof MultiplexRequestException))
      {
        paramType = ProfileRoutes.buildProfileRoute(profileIdentifier).toString();
        paramSet = (DataManagerException)requiredRequestFailures.get(paramType);
        paramType = paramDataManagerException;
        if (paramSet != null) {
          paramType = paramSet;
        }
      }
      paramType = paramType.getCause();
      if (paramType != null) {
        break label250;
      }
      paramType = null;
      if (!(paramType instanceof DataManagerException)) {
        break label258;
      }
      paramType = ExceptionUtils.getUserVisibleException((DataManagerException)paramType);
      label198:
      if ((paramType == null) || (serviceErrorCode != 5)) {
        break label435;
      }
      recyclerView.setVisibility(8);
      if ((getView() == null) || (errorPageViewModel == null)) {
        break label263;
      }
      errorViewStub.setVisibility(0);
    }
    for (;;)
    {
      swipeRefreshLayout.setRefreshing(false);
      return;
      label250:
      paramType = paramType.getCause();
      break;
      label258:
      paramType = null;
      break label198;
      label263:
      if ((getView() != null) && (errorPageViewModel == null))
      {
        errorPageViewModel = new ErrorPageViewModel(errorViewStub);
        paramType = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(getView());
        errorPageViewModel.errorHeaderText = i18NManager.getString(2131230790);
        errorPageViewModel.errorDescriptionText = i18NManager.getString(2131230789);
        errorPageViewModel.errorImage = 2130838622;
        errorPageViewModel.errorButtonText = i18NManager.getString(2131230788);
        errorPageViewModel.onErrorButtonClick = new ProfileViewFragment.8(this, tracker, "aasaan_help_center");
        paramSet = errorPageViewModel;
        paramDataManagerException = getActivity().getLayoutInflater();
        applicationComponent.mediaCenter();
        paramSet.onBindViewHolderWithErrorTracking$18b8048(paramDataManagerException, paramType, tracker, getPageInstance());
        continue;
        label435:
        recyclerView.setVisibility(8);
        if ((getView() != null) && (errorPageViewModel != null))
        {
          errorViewStub.setVisibility(0);
        }
        else if (getView() != null)
        {
          errorPageViewModel = new ErrorPageViewModel(errorViewStub);
          paramType = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(getView());
          errorPageViewModel.errorDescriptionText = i18NManager.getString(2131233325);
          errorPageViewModel.errorImage = 2130838622;
          errorPageViewModel.errorButtonText = i18NManager.getString(2131233326);
          errorPageViewModel.onErrorButtonClick = new ProfileViewFragment.7(this, tracker, "error_retry");
          paramSet = errorPageViewModel;
          paramDataManagerException = getActivity().getLayoutInflater();
          applicationComponent.mediaCenter();
          paramSet.onBindViewHolderWithErrorTracking$18b8048(paramDataManagerException, paramType, tracker, getPageInstance());
        }
      }
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramSet == null) || (!paramSet.contains(getXpromoRoutePath())))
    {
      if ((profileDataProvider != null) && (paramType == DataStore.Type.NETWORK))
      {
        profileDataProvider.state).isProfileViewCallInProgress = false;
        pausedWhileProfileViewCallInProgress = false;
      }
      if ((profileDataProvider != null) && (profileDataProvider.isDataAvailable()))
      {
        profileId = profileDataProvider.getProfileModel().miniProfile.entityUrn.getId();
        if (paramType == DataStore.Type.NETWORK) {}
        for (bool = true;; bool = false)
        {
          setupProfileViewCards(bool);
          setupFloatingActionButton();
          if (!auth.isAuthenticated())
          {
            i = (int)getResources().getDimension(2131493441);
            j = (int)getResources().getDimension(2131493440);
            publicProfilepublicProfileStickyBottomCTAScrollListener = new PublicProfileRecyclerViewScrollListener(publicProfileStickyBottomCTA, i, j, currentScrollPosition, swipeRefreshLayout);
            recyclerView.addOnScrollListener(publicProfilepublicProfileStickyBottomCTAScrollListener);
            publicProfileStickyBottomCTAButton.setOnClickListener(new ProfileViewFragment.3(this, tracker, "sticky_bottom_cta", new TrackingEventBuilder[0]));
          }
          while (pendingTrackingEvents > 0)
          {
            sendTrackingEvents();
            if (isMeTabProfile) {
              sendGuidedEditPageViewEvent();
            }
            pendingTrackingEvents -= 1;
          }
        }
        if (!StringUtils.isEmpty(getArguments().getString("thirdPartyApplicationPackageName"))) {
          getActivity().setResult(-1);
        }
        if ((!crossPromoShowed) && (((ProfileState)profileDataProvider.state).getCrossPromo(crossPromoPageKey("profile_self")) != null)) {
          showSelfViewCrossPromos();
        }
        if (paramType == DataStore.Type.NETWORK)
        {
          paramMap = profileViewMainEfficientCoordinatorLayout;
          paramSet = fragmentComponent;
          paramType = profileDataProvider;
          if ((!"enabled".equals(paramSet.lixManager().getTreatment(Lix.PROFILE_PREMIUM_UPSELL_PROMO))) || (paramMap == null) || (!CollectionUtils.isNonEmpty(paramType.getProfilePromotions()))) {
            break label821;
          }
          paramType = getProfilePromotionselements.iterator();
          do
          {
            if (!paramType.hasNext()) {
              break;
            }
            localObject1 = (ProfilePromotion)paramType.next();
          } while ((!prompt.hasPremiumUpsellPromptValue) || (!hasPrimaryAction));
          paramType = LayoutInflater.from(paramMap.getContext()).inflate(2130969225, paramMap, false);
          paramMap.removeView(paramType);
          paramMap.addView(paramType, new FrameLayout.LayoutParams(-1, -1));
          paramMap = paramType.findViewById(2131757744);
          localContext = paramSet.context().getApplicationContext();
          localPremiumUpsellPrompt = prompt.premiumUpsellPromptValue;
          localObject2 = primaryAction;
          localObject3 = dismissAction;
          str = legoTrackingToken;
          localObject1 = new PremiumPromoCardViewModel();
          legoImpressionClosure = ProfilePromotionTransformer.getLegoWidgetImpressionClosure(paramSet, str);
          if (localObject3 != null)
          {
            localObject3 = ProfilePromotionTransformer.getLegoActionTrackingClosure(paramSet, str, legoActionCategory);
            dismissListener = new ProfilePromotionTransformer.2(paramSet.tracker(), "promotion_dismissed", new TrackingEventBuilder[0], (Closure)localObject3, paramSet);
          }
          localObject2 = ProfilePromotionTransformer.getLegoActionTrackingClosure(paramSet, str, legoActionCategory);
          premiumButtonListener = new ProfilePromotionTransformer.3(paramSet.tracker(), "premium_upsell_button_clicked", new TrackingEventBuilder[0], (Closure)localObject2, paramSet);
          upsellMessage = AttributedTextUtils.getAttributedString(reason, paramSet.context());
          if (paramMap != null)
          {
            paramMap.getViewTreeObserver().addOnGlobalLayoutListener(new ProfilePremiumUpsellUtils.1(paramMap, localContext));
            paramMap = (PremiumPromoCardViewHolder)PremiumPromoCardViewHolder.CREATOR.createViewHolder(paramMap);
            paramSet.activity().getLayoutInflater();
            paramSet.mediaCenter();
            ((PremiumPromoCardViewModel)localObject1).onBindViewHolder$1cace3e0(paramMap);
          }
          premiumUpsellFrameView = paramType;
        }
      }
      if (shouldAppIndexing())
      {
        paramType = profileDataProvider.getProfileModel().miniProfile;
        paramSet = new Uri.Builder().scheme("https").authority("www.linkedin.com").appendEncodedPath("in").appendEncodedPath(publicIdentifier).build();
        paramMap = fragmentComponent.i18NManager();
        action = GoogleAppIndexingManager.getAction(paramSet, paramMap.getString(2131231713, new Object[] { I18NManager.getName(paramType) }), paramMap.getString(2131231712, new Object[] { I18NManager.getName(paramType) }));
        GoogleAppIndexingManager.startAppIndexing(googleApiClient, action);
      }
      setupOverflowButton();
      swipeRefreshLayout.setRefreshing(false);
    }
    label821:
    while ((crossPromoShowed) || (profileDataProvider == null) || (((ProfileState)profileDataProvider.state).getCrossPromo(crossPromoPageKey("profile_self")) == null)) {
      for (;;)
      {
        boolean bool;
        int i;
        int j;
        Object localObject1;
        Context localContext;
        PremiumUpsellPrompt localPremiumUpsellPrompt;
        Object localObject2;
        Object localObject3;
        String str;
        return;
        paramType = null;
      }
    }
    showSelfViewCrossPromos();
  }
  
  public void onDestroyView()
  {
    currentScrollPosition = scrollListener.currentScrollPosition;
    currentToolbarAlpha = scrollListener.getCurrentToolbarAlpha();
    recyclerView.clearOnScrollListeners();
    scrollListener = null;
    floatingActionButton.setOnClickListener(null);
    viewPortManager.untrackAll();
    if (!"enabled".equals(fragmentComponent.lixManager().getTreatment(Lix.GUIDED_EDIT_VIEWPAGER_CRASH_REVERT))) {
      recyclerView.setAdapter(null);
    }
    super.onDestroyView();
  }
  
  @Subscribe
  public void onEvent(ProfileViewDismissCardEvent paramProfileViewDismissCardEvent)
  {
    if (profileViewAdapter != null)
    {
      int i = profileViewAdapter.getCardIndex(cardType);
      if (i != -1)
      {
        profileViewAdapter.removeBoundCard(cardType);
        profileViewAdapter.removeValueAtPosition(i);
      }
    }
  }
  
  @Subscribe
  public void onEvent(PremiumPromoDismissEvent paramPremiumPromoDismissEvent)
  {
    if ((profileViewMainEfficientCoordinatorLayout != null) && (premiumUpsellFrameView != null))
    {
      premiumUpsellFrameView.setVisibility(8);
      profileViewMainEfficientCoordinatorLayout.removeView(premiumUpsellFrameView);
    }
  }
  
  public final void onRefresh()
  {
    profileDataProvider.fetchData(profileIdentifier, busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), DataManager.DataStoreFilter.NETWORK_ONLY);
  }
  
  public void onStop()
  {
    if (shouldAppIndexing()) {
      GoogleAppIndexingManager.stopAppIndexing(googleApiClient, action);
    }
    super.onStop();
  }
  
  public final void onUserSelected(int paramInt)
  {
    String str = null;
    switch (paramInt)
    {
    default: 
      if (profileViewListener == null) {
        break;
      }
    }
    for (Object localObject = profileViewListener;; localObject = (ProfileEditListener)getActivity())
    {
      photoUtil.onUserSelection(paramInt, (ProfileEditListener)localObject, this, this, tracker, str);
      return;
      str = "profile_self_member_photo_view";
      break;
      str = "profile_self_member_photo_library";
      break;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    swipeRefreshLayout.setOnRefreshListener(this);
    swipeRefreshLayout.setColorSchemeResources(ViewUtils.SWIPE_REFRESH_LAYOUT_COLOR_SCHEME);
    Object localObject1;
    Object localObject2;
    boolean bool;
    if (openSearchEntryType == 1) {
      if (!isMeTabProfile)
      {
        searchButton.setVisibility(0);
        searchButton.setOnClickListener(new ProfileViewFragment.5(this, tracker, "search_icon", new TrackingEventBuilder[0]));
        i = (int)getResources().getDimension(2131493257);
        int j = getResources().getColor(2131624108);
        int k = getResources().getColor(2131624058);
        paramBundle = new ColorDrawable(ColorUtils.setAlphaComponent(j, currentToolbarAlpha));
        JellyBeanUtils.setBackground(toolbar, paramBundle);
        toolbar.setTitleTextColor(ColorUtils.setAlphaComponent(k, currentToolbarAlpha));
        toolbar.setNavigationOnClickListener(new ProfileViewFragment.1(this));
        viewPortManager.container = recyclerView;
        paramBundle = toolbar;
        localObject1 = searchOpenBar;
        localObject2 = searchBarDivider;
        int m = currentToolbarAlpha;
        int n = currentScrollPosition;
        if (openSearchEntryType != 2) {
          break label722;
        }
        bool = true;
        label216:
        scrollListener = new ProfileRecyclerViewScrollListener(paramBundle, (ViewGroup)localObject1, (View)localObject2, j, k, m, i, n, bool);
        recyclerView.clearOnScrollListeners();
        if (!isMeTabProfile) {
          break label728;
        }
        toolbar.setVisibility(8);
        label266:
        new RecyclerViewVisibilityListener(recyclerView, new RecyclerViewPortListener(viewPortManager));
        profileViewAdapter = new ProfileViewAdapter(getActivity(), applicationComponent.mediaCenter());
        profileViewAdapter.setViewPortManager(viewPortManager);
        paramView = new LinearLayoutManager(paramView.getContext());
        recyclerView.setLayoutManager(paramView);
        recyclerView.setAdapter(profileViewAdapter);
        if (profileId == null) {
          break label742;
        }
        profileIdentifier = profileId;
        label371:
        if (TextUtils.isEmpty(profileIdentifier)) {
          break label867;
        }
        if ((!profileDataProvider.isDataAvailable()) || (profileDataProvider.getProfileModel() == null)) {
          break label807;
        }
        i = 1;
        label403:
        if ((i != 0) && (!reloadProfileViewData)) {
          break label819;
        }
        reloadProfileViewData = false;
        if (profileId == null) {
          break label812;
        }
        paramView = new ProfileViewFragment.9(this);
        dataManager.submit(Request.get().cacheKey(ProfileUrnUtil.createMiniProfileUrn(profileId).toString()).builder(MiniProfile.BUILDER).listener(paramView).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
        label474:
        profileViewMainEfficientCoordinatorLayout.setShouldConsumeAndForwardScrollEvents(true);
        if (((profileId == null) || (!memberUtil.isSelf(profileId))) && ((getArguments() == null) || (!getArguments().getBoolean("selfProfile")))) {
          break label893;
        }
      }
    }
    label722:
    label728:
    label742:
    label807:
    label812:
    label819:
    label867:
    label893:
    for (int i = 1;; i = 0)
    {
      fragmentComponent.eventBus();
      if ((Bus.getStickyEvent(ProfileSkillsAddedEvent.class) != null) && (i != 0) && (fragmentComponent.lixManager().getTreatment(Lix.PROFILE_SELF_VIEW_ENABLE_CROSSPROMO).equals("enabled")))
      {
        paramView = profileDataProvider;
        paramBundle = crossPromoPageKey("profile_self");
        localObject2 = busSubscriberId;
        localObject1 = getRumSessionId();
        localObject2 = new PromoListener(paramView, (String)localObject2, (String)localObject1);
        paramBundle = Request.get().url(Routes.crossPromoPath(paramBundle)).builder(Promo.BUILDER).listener((RecordTemplateListener)localObject2).filter(DataManager.DataStoreFilter.NETWORK_ONLY).trackingSessionId((String)localObject1);
        activityComponent.dataManager().submit(paramBundle);
      }
      return;
      searchButton.setVisibility(8);
      break;
      if ((openSearchEntryType != 2) || (isMeTabProfile)) {
        break;
      }
      searchOpenBar.setVisibility(0);
      searchOpenBar.setOnClickListener(new ProfileViewFragment.6(this, tracker, "open_search_box", new TrackingEventBuilder[0]));
      break;
      bool = false;
      break label216;
      recyclerView.addOnScrollListener(scrollListener);
      break label266;
      if (publicIdentifier != null)
      {
        profileIdentifier = publicIdentifier;
        break label371;
      }
      if (externalIdentifier != null)
      {
        profileIdentifier = externalIdentifier;
        break label371;
      }
      if ((getArguments() == null) || (!getArguments().getBoolean("selfProfile"))) {
        break label371;
      }
      profileIdentifier = "me";
      break label371;
      i = 0;
      break label403;
      fetchDataForInitialLoad();
      break label474;
      profileDataProvider.fetchGuidedEditCategories(busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), memberUtil.getProfileId(), GuidedEditSource.ORGANIC);
      setupProfileViewCards(false);
      setupFloatingActionButton();
      setupOverflowButton();
      break label474;
      fragmentComponent.context();
      Util.safeThrow$7a8b4789(new IllegalStateException("Ended up with no profile identifier to query the server with"));
      break label474;
    }
  }
  
  public final String pageKey()
  {
    return "profile_view_base";
  }
  
  protected final boolean shouldInheritSubscriberId()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.ProfileViewFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */