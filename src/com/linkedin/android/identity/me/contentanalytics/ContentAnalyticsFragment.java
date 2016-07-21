package com.linkedin.android.identity.me.contentanalytics;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.MultiplexRequestException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.shared.FeedUpdateOnClickListener;
import com.linkedin.android.identity.me.contentanalytics.transformers.ContentAnalyticsTransformer;
import com.linkedin.android.identity.shared.IdentityLoadingAdapter;
import com.linkedin.android.identity.shared.listeners.ToolbarFadeScrollListener;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.mergeAdapter.MergeAdapter;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.JellyBeanUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateType;
import com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.Header;
import com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialUpdateAnalytics;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ContentAnalyticsFragment
  extends PageFragment
{
  private int currentScrollPosition;
  private int currentToolbarAlpha;
  @InjectView(2131755336)
  ImageView headerImage;
  IdentityLoadingAdapter loadingAdapter;
  MergeAdapter mergeAdapter;
  @InjectView(2131755337)
  View overlay;
  @InjectView(2131755338)
  RecyclerView recyclerView;
  private ToolbarFadeScrollListener scrollListener;
  private SocialUpdateType socialUpdateType;
  private Urn socialUpdateUrn;
  @InjectView(2131755335)
  Toolbar toolbar;
  ViewModelArrayAdapter<ViewModel> viewModelAdapter;
  
  public static ContentAnalyticsFragment newInstance(Bundle paramBundle)
  {
    ContentAnalyticsFragment localContentAnalyticsFragment = new ContentAnalyticsFragment();
    localContentAnalyticsFragment.setArguments(paramBundle);
    return localContentAnalyticsFragment;
  }
  
  protected final DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.contentAnalyticsDataProvider();
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (paramBundle == null) {
      socialUpdateUrn = ContentAnalyticsBundleBuilder.getSocialUpdateUrn(getArguments());
    }
    for (socialUpdateType = ContentAnalyticsBundleBuilder.getSocialUpdateType(getArguments());; socialUpdateType = ContentAnalyticsBundleBuilder.getSocialUpdateType(paramBundle))
    {
      super.onCreate(paramBundle);
      return;
      socialUpdateUrn = ContentAnalyticsBundleBuilder.getSocialUpdateUrn(paramBundle);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968631, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    super.onDataError(paramType, paramSet, paramDataManagerException);
    if (paramType == DataStore.Type.NETWORK)
    {
      Log.e(ContentAnalyticsDataProvider.TAG, "Error loading Content Analytics", paramDataManagerException);
      if ((paramDataManagerException instanceof MultiplexRequestException))
      {
        paramType = requiredRequestFailures.entrySet().iterator();
        while (paramType.hasNext())
        {
          paramSet = (Map.Entry)paramType.next();
          Log.e(ContentAnalyticsDataProvider.TAG, (String)paramSet.getKey() + ": " + ((DataManagerException)paramSet.getValue()).toString());
        }
      }
      loadingAdapter.setLoading(false);
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    paramMap = getActivityactivityComponent.contentAnalyticsDataProvider();
    if ((paramSet == null) || (!paramSet.contains(state).headerRoute)) || (!paramSet.contains(state).highlightsRoute))) {}
    int i;
    label112:
    do
    {
      return;
      loadingAdapter.setLoading(false);
      if ((((ContentAnalyticsDataProvider.ContentAnalyticsState)state).header() == null) || (((ContentAnalyticsDataProvider.ContentAnalyticsState)state).highlights() == null) || (state).highlights().elements == null)) {
        break;
      }
      i = 1;
      if (i == 0) {
        break label497;
      }
      paramType = ((ContentAnalyticsDataProvider.ContentAnalyticsState)state).header();
      paramSet = ((ContentAnalyticsDataProvider.ContentAnalyticsState)state).highlights();
    } while ((paramType == null) || (paramSet == null));
    paramMap = new ArrayList(elements.size() + 1);
    FragmentComponent localFragmentComponent = fragmentComponent;
    ContentAnalyticsHeaderViewModel localContentAnalyticsHeaderViewModel = new ContentAnalyticsHeaderViewModel();
    I18NManager localI18NManager = localFragmentComponent.i18NManager();
    if (hasTitle) {
      titleText = title;
    }
    if ((hasTotalSocialActivityCounts) && (totalSocialActivityCounts.hasNumViews) && (totalSocialActivityCounts.numViews > 0L)) {}
    for (boolean bool = true;; bool = false)
    {
      showCounts = bool;
      if (hasTotalSocialActivityCounts)
      {
        if (totalSocialActivityCounts.hasNumViews) {
          viewText = localI18NManager.getString(2131233020, new Object[] { Long.valueOf(totalSocialActivityCounts.numViews) });
        }
        if (totalSocialActivityCounts.hasNumComments) {
          commentText = localI18NManager.getString(2131233020, new Object[] { Long.valueOf(totalSocialActivityCounts.numComments) });
        }
        if (totalSocialActivityCounts.hasNumLikes) {
          likeText = localI18NManager.getString(2131233020, new Object[] { Long.valueOf(totalSocialActivityCounts.numLikes) });
        }
      }
      headerClickListener = new FeedUpdateOnClickListener(objectUrn.toString(), localFragmentComponent, 0, true, null, null, "", new TrackingEventBuilder[0]);
      paramMap.add(localContentAnalyticsHeaderViewModel);
      paramMap.addAll(ContentAnalyticsTransformer.toViewModels(fragmentComponent, elements, socialUpdateType));
      socialUpdateType = socialUpdateType;
      viewModelAdapter.setValues(paramMap);
      if (!hasImage) {
        break;
      }
      new ImageModel(image, 2130838697, getRumSessionId()).setImageView(fragmentComponent.mediaCenter(), headerImage);
      return;
      i = 0;
      break label112;
      label497:
      break;
    }
  }
  
  public void onDestroyView()
  {
    currentScrollPosition = scrollListener.currentScrollPosition;
    currentToolbarAlpha = scrollListener.getCurrentToolbarAlpha();
    recyclerView.clearOnScrollListeners();
    scrollListener = null;
    super.onDestroyView();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    ContentAnalyticsBundleBuilder.putSocialUpdateUrn(paramBundle, socialUpdateUrn);
    ContentAnalyticsBundleBuilder.putSocialUpdateType(paramBundle, socialUpdateType);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    mergeAdapter = new MergeAdapter();
    loadingAdapter = new IdentityLoadingAdapter();
    viewModelAdapter = new ViewModelArrayAdapter(fragmentComponent.activity(), fragmentComponent.mediaCenter(), null);
    mergeAdapter.addAdapter(viewModelAdapter);
    mergeAdapter.addAdapter(loadingAdapter);
    recyclerView.setAdapter(mergeAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    loadingAdapter.setLoading(true);
    int i = (int)getResources().getDimension(2131493257);
    int j = getResources().getColor(2131624108);
    int k = getResources().getColor(2131624058);
    paramView = new ColorDrawable(ColorUtils.setAlphaComponent(j, currentToolbarAlpha));
    JellyBeanUtils.setBackground(toolbar, paramView);
    paramView = fragmentComponent.activity();
    boolean bool1 = "enabled".equals(fragmentComponent.lixManager().getTreatment(Lix.LIX_PROFILE_VIEW_ENABLE_INTERESTS_CARD));
    boolean bool2 = "enabled".equals(fragmentComponent.lixManager().getTreatment(Lix.PROFILE_ENABLE_RECENT_ACTIVITY_SHARES_TAB));
    paramBundle = fragmentComponent.memberUtil();
    toolbar.setNavigationOnClickListener(new ContentAnalyticsFragment.1(this, paramBundle, bool1, bool2, paramView));
    scrollListener = new ContentAnalyticsFragment.2(this, toolbar, j, k, currentToolbarAlpha, i, currentScrollPosition);
    recyclerView.addOnScrollListener(scrollListener);
    getActivity();
    if ((BaseActivity)getActivity() != null)
    {
      paramView = getActivityactivityComponent.contentAnalyticsDataProvider();
      Object localObject = socialUpdateUrn;
      paramBundle = busSubscriberId;
      String str = getRumSessionId();
      Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
      DataManager.DataStoreFilter localDataStoreFilter = DataManager.DataStoreFilter.NETWORK_ONLY;
      state).headerRoute = ContentAnalyticsDataProvider.CONTENT_ANALYTICS_HEADER_ROUTE.buildUpon().appendPath(((Urn)localObject).toString()).build().toString();
      state).highlightsRoute = ContentAnalyticsDataProvider.CONTENT_ANALYTICS_HIGHLIGHTS_ROUTE.buildUpon().appendQueryParameter("urn", ((Urn)localObject).toString()).build().toString();
      localObject = MultiplexRequest.Builder.parallel();
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      paramView.performMultiplexedFetch(paramBundle, str, localMap, ((MultiplexRequest.Builder)localObject).filter(localDataStoreFilter).required(Request.get().url(state).headerRoute).builder(Header.BUILDER)).required(Request.get().url(state).highlightsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(SocialUpdateAnalytics.BUILDER, CollectionMetadata.BUILDER))));
      return;
    }
    Util.safeThrow$7a8b4789(new RuntimeException("WVMP fetched without activity"));
  }
  
  public final String pageKey()
  {
    if (SocialUpdateType.POST.equals(socialUpdateType)) {
      return "me_post_analytics";
    }
    return "me_share_analytics";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.contentanalytics.ContentAnalyticsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */