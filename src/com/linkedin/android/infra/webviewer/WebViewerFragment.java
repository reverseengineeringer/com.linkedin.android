package com.linkedin.android.infra.webviewer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import com.linkedin.CrossPromoLib.utils.Network.PromoModelFetchRequest;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.transformer.UpdateDataModelTransformer;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.tracking.SponsoredUpdateTracker;
import com.linkedin.android.identity.profile.ProfileBundleBuilder;
import com.linkedin.android.identity.profile.ProfileViewIntent;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.perftimer.RUMTiming;
import com.linkedin.android.publishing.reader.ArticleBundle;
import com.linkedin.android.publishing.reader.ArticleIntent;
import com.linkedin.android.publishing.sharing.ShareBundle;
import com.linkedin.android.publishing.sharing.ShareIntent;
import com.linkedin.android.publishing.sharing.compose.ShareComposeBundle;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import javax.inject.Inject;

public class WebViewerFragment
  extends WebViewerBaseFragment
{
  private static final String TAG = WebViewerFragment.class.getSimpleName();
  @InjectView(2131756584)
  ImageView backButton;
  private long displayedTime;
  @InjectView(2131756580)
  ViewStub errorPageViewStub;
  ErrorPageViewModel errorViewModel;
  @Inject
  Bus eventBus;
  @InjectView(2131756578)
  View footerView;
  @InjectView(2131756585)
  ImageView forwardButton;
  private boolean isPromoToDisplay;
  @InjectView(2131756590)
  ImageView overflowButton;
  protected String pageKeySuffix;
  private boolean pageLoadErrorDetected;
  @InjectView(2131756577)
  ProgressBar progressBar;
  private String rumSessionId;
  @InjectView(2131756587)
  ImageView shareButton;
  protected String subTitle;
  @InjectView(2131756589)
  TextView subtitleView;
  protected String title;
  @InjectView(2131756588)
  TextView titleView;
  @InjectView(2131756575)
  Toolbar toolbar;
  protected Update update;
  protected UpdateDataModel updateDataModel;
  protected int usage = -1;
  @InjectView(2131756579)
  FrameLayout webViewContainer;
  
  private String crossPromoPageKey()
  {
    return applicationComponent.tracker().trackingCodePrefix + "_" + pageKey();
  }
  
  private void hideErrorView()
  {
    if (!pageLoadErrorDetected)
    {
      if (webView != null) {
        webView.setVisibility(0);
      }
      if (errorViewModel != null)
      {
        errorViewModel.remove();
        errorViewModel = null;
      }
    }
  }
  
  private void setupFooter(WebView paramWebView)
  {
    boolean bool1 = paramWebView.canGoBack();
    boolean bool2 = paramWebView.canGoForward();
    if ((bool1) && (bool2))
    {
      footerView.setVisibility(0);
      backButton.setVisibility(0);
      forwardButton.setVisibility(0);
      return;
    }
    if (bool1)
    {
      footerView.setVisibility(0);
      backButton.setVisibility(0);
      forwardButton.setVisibility(4);
      return;
    }
    if (bool2)
    {
      footerView.setVisibility(0);
      backButton.setVisibility(4);
      forwardButton.setVisibility(0);
      return;
    }
    footerView.setVisibility(8);
  }
  
  public final void doPause()
  {
    super.doPause();
    if ((update != null) && (update.tracking != null) && (usage != 2))
    {
      long l1 = System.currentTimeMillis();
      long l2 = displayedTime;
      getContext();
      FeedTracking.trackDetailFIE$5e2dcd44(tracker, update, update.tracking, displayedTime, l1 - l2);
    }
  }
  
  public final void doResume()
  {
    super.doResume();
    displayedTime = System.currentTimeMillis();
    if ((update != null) && (FeedTracking.isSponsored(update.tracking))) {
      fragmentComponent.sponsoredUpdateTracker().trackDetailImpression(Tracker.createPageInstanceHeader(getPageInstance()), update.tracking, update.tracking.sponsoredTracking);
    }
  }
  
  protected final FrameLayout getWebViewContainer()
  {
    return webViewContainer;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final boolean isBackButtonHandled()
  {
    if ((webView != null) && (webView.canGoBack()))
    {
      webView.goBack();
      return true;
    }
    return false;
  }
  
  public final void loadUrl(String paramString)
  {
    if ((fragmentComponent != null) && (webView != null))
    {
      fragmentComponent.webViewLoadProxy();
      WebViewLoadProxy.loadUrl(webView, paramString);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    usage = WebViewerBundle.getUsage(getArguments());
    pageKeySuffix = WebViewerBundle.getPageKeySuffix(getArguments());
    Context localContext = getActivity().getApplicationContext();
    switch (usage)
    {
    default: 
      paramActivity = "web_viewer";
    }
    for (;;)
    {
      rumSessionId = RUMTiming.initialize(localContext, "p_flagship3_" + paramActivity);
      return;
      paramActivity = "feed_web_viewer";
      continue;
      paramActivity = constructSettingsPageKey(pageKeySuffix);
      continue;
      paramActivity = "job_apply_website";
      continue;
      paramActivity = "profile_view_web_viewer";
      continue;
      paramActivity = "groups_web_viewer";
      continue;
      paramActivity = "messaging_web_viewer";
      continue;
      paramActivity = "profinder_service_proposal";
    }
  }
  
  @OnClick({2131756584})
  public void onBackButtonClicked()
  {
    trackButtonShortPress("hardware-back");
    if (webView.canGoBack()) {
      webView.goBack();
    }
  }
  
  @OnClick({2131756586})
  public void onCloseButtonClicked()
  {
    trackButtonShortPress("close");
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRetainInstance(true);
    fragmentComponent.inject(this);
    subTitle = WebViewerBundle.getSubtitle(getArguments());
    title = WebViewerBundle.getTitle(getArguments());
    update = WebViewerBundle.getUpdate(getArguments());
    if (update != null) {
      updateDataModel = UpdateDataModelTransformer.toDataModel(fragmentComponent, update, FeedDataModelMetadata.DEFAULT);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    return paramLayoutInflater.inflate(2130968954, paramViewGroup, false);
  }
  
  @OnClick({2131756585})
  public void onForwardButtonClicked()
  {
    trackButtonShortPress("forward");
    if (webView.canGoForward()) {
      webView.goForward();
    }
  }
  
  protected final void onPageCommitVisible$49a27f1e()
  {
    if (!isResumed()) {
      return;
    }
    hideErrorView();
  }
  
  protected final void onPageFinished(WebView paramWebView, String paramString)
  {
    RUMTiming.renderEnd(rumSessionId, false);
    if (WebViewerUtils.isLinkedInArticleUrl(paramString)) {
      RUMTiming.customMarkerEnd(rumSessionId, "feed_web_viewer_pulse_article");
    }
    if (!isResumed()) {
      return;
    }
    hideErrorView();
    if (paramWebView.canGoBack())
    {
      ViewUtils.setTextAndUpdateVisibility(titleView, paramWebView.getTitle());
      ViewUtils.setTextAndUpdateVisibility(subtitleView, "");
    }
    for (;;)
    {
      setupFooter(paramWebView);
      return;
      ViewUtils.setTextAndUpdateVisibility(titleView, title);
      ViewUtils.setTextAndUpdateVisibility(subtitleView, subTitle);
    }
  }
  
  protected final void onPageStarted$49a27f1e(String paramString)
  {
    RUMTiming.httpMetricEnd$379e7088(rumSessionId, paramString, 200);
    RUMTiming.renderStart(rumSessionId, false);
    pageLoadErrorDetected = false;
    if (WebViewerUtils.isLinkedInArticleUrl(paramString)) {
      RUMTiming.customMarkerStart(rumSessionId, "feed_web_viewer_pulse_article");
    }
  }
  
  protected final void onProgressChanged$5ff25715(int paramInt)
  {
    if (progressBar == null) {}
    do
    {
      return;
      progressBar.setProgress(paramInt);
      if ((progressBar.getVisibility() == 8) && (paramInt < 100))
      {
        progressBar.setVisibility(0);
        return;
      }
    } while ((progressBar.getVisibility() != 0) || (paramInt != 100));
    progressBar.setVisibility(8);
  }
  
  protected final void onReceivedError$15530e61(String paramString, int paramInt)
  {
    RUMTiming.httpMetricEnd$379e7088(rumSessionId, url, getHttpStatusCode(paramInt));
    if ((paramInt == -6) || (paramInt == -11)) {
      RUMTiming.connectionDropped(rumSessionId, paramString);
    }
    RUMTiming.renderStart(rumSessionId, false);
    pageLoadErrorDetected = true;
    if (!isResumed()) {}
    do
    {
      return;
      paramString = getView();
    } while (paramString == null);
    webView.setVisibility(8);
    Object localObject1 = errorPageViewStub.getContext();
    Object localObject2 = new ErrorPageViewModel(errorPageViewStub);
    if (((ErrorPageViewModel)localObject2).setupDefaultErrorConfiguration((Context)localObject1, null) == 1)
    {
      errorHeaderText = null;
      errorDescriptionText = ((Context)localObject1).getString(2131233732);
    }
    errorButtonText = ((Context)localObject1).getString(2131233733);
    onErrorButtonClick = new WebViewerFragment.5(this, fragmentComponent.tracker(), "retry");
    errorViewModel = ((ErrorPageViewModel)localObject2);
    paramString = (ErrorPageViewHolder)errorViewModel.getCreator().createViewHolder(paramString);
    localObject1 = errorViewModel;
    localObject2 = getActivity().getLayoutInflater();
    applicationComponent.mediaCenter();
    ((ErrorPageViewModel)localObject1).onBindViewHolderWithErrorTracking$18b8048((LayoutInflater)localObject2, paramString, tracker, getPageInstance());
  }
  
  @OnClick({2131756587})
  public void onShareButtonClicked()
  {
    trackButtonShortPress("reshare");
    fragmentComponent.webViewLoadProxy();
    Object localObject = WebViewLoadProxy.getUrl(webView);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((((String)localObject).equals(url)) && (update != null) && (update.tracking != null)) {
        fragmentComponent.tracker().send(FeedTracking.createFeedActionEvent(ActionCategory.EXPAND, "reshare", "expandReshareBox", update.tracking, update.urn, fragmentComponent));
      }
      FragmentActivity localFragmentActivity = getActivity();
      localObject = ShareBundle.createFeedShare(ShareComposeBundle.createOriginalShareWithArticleUrl((String)localObject));
      localFragmentActivity.startActivity(fragmentComponent.intentRegistry().share.newIntent(localFragmentActivity, (BundleBuilder)localObject));
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    getActivity();
    toolbar.hideOverflowMenu();
    overflowButton.setOnClickListener(new WebViewerFragment.2(this));
    ViewUtils.setTextAndUpdateVisibility(titleView, title);
    ViewUtils.setTextAndUpdateVisibility(subtitleView, subTitle);
    setupFooter(webView);
    RUMTiming.httpMetricStart(rumSessionId, url);
    if (WebViewerUtils.isLinkedinUrl(url))
    {
      loadWebViewWithCookies();
      if ((usage == 0) && (getView() != null))
      {
        applicationComponent.crossPromoManager();
        PromoModelFetchRequest.sendRequest$313b03d7(crossPromoPageKey(), new WebViewerFragment.4(this));
      }
      if (updateDataModel != null)
      {
        if (!updateDataModel.isReshareable()) {
          break label227;
        }
        shareButton.setVisibility(0);
      }
    }
    for (;;)
    {
      if (!"control".equals(applicationComponent.lixManager().getTreatment(Lix.SHARING_NEW_SHARE_ICON))) {
        shareButton.setImageResource(2130838335);
      }
      paramView = (WebViewerBaseFragment.ScrollableWebView)paramView.findViewById(2131755021);
      if (paramView != null) {
        paramView.setOnScrollChangedCallback(new WebViewerFragment.1(this));
      }
      return;
      loadUrl(url);
      break;
      label227:
      shareButton.setVisibility(8);
    }
  }
  
  public final String pageKey()
  {
    switch (usage)
    {
    case 6: 
    case 7: 
    default: 
      return "feed_web_viewer";
    case 0: 
    case 1: 
    case 2: 
      return "feed_web_viewer";
    case 3: 
      return constructSettingsPageKey(pageKeySuffix);
    case 4: 
      return "job_apply_website";
    case 5: 
      return "profile_view_web_viewer";
    }
    return "profinder_service_proposal";
  }
  
  public final String provideDebugData()
  {
    String str2 = super.provideDebugData();
    String str1 = str2;
    StringBuilder localStringBuilder;
    if (update != null)
    {
      str1 = str2;
      if (update.urn != null)
      {
        localStringBuilder = new StringBuilder();
        if (str2 == null) {
          break label89;
        }
      }
    }
    label89:
    for (str1 = str2 + "\n";; str1 = "")
    {
      str1 = str1 + "update urn: " + update.urn.toString();
      return str1;
    }
  }
  
  protected final boolean shouldOverrideUrlLoading$49a27f1a(String paramString)
  {
    Object localObject = WebViewerUtils.parsePublicProfileId(paramString);
    if (localObject != null)
    {
      paramString = fragmentComponent.activity();
      localObject = ProfileBundleBuilder.createFromPublicIdentifier((String)localObject);
      paramString.startActivity(fragmentComponent.intentRegistry().profileView.newIntent(paramString, (BundleBuilder)localObject));
      return true;
    }
    if (WebViewerUtils.isLinkedInArticleUrl(paramString))
    {
      localObject = fragmentComponent.activity();
      paramString = ArticleBundle.createFeedViewer(null, paramString, "", "", null);
      ((Context)localObject).startActivity(fragmentComponent.intentRegistry().article.newIntent((Context)localObject, paramString));
      return true;
    }
    return false;
  }
  
  public final boolean shouldTrack()
  {
    switch (usage)
    {
    default: 
      getActivity();
      Util.safeThrow$7a8b4789(new RuntimeException("Unable to determine tracking enabled for web view usage " + usage));
    case -1: 
    case 6: 
    case 7: 
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.webviewer.WebViewerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */