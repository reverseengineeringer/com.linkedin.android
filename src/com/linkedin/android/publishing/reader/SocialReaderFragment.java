package com.linkedin.android.publishing.reader;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequestWrapper.Builder;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.shared.FeedFollowEntityOnClickListener;
import com.linkedin.android.feed.shared.FeedLikeOnClickListener;
import com.linkedin.android.feed.shared.FeedUpdateOnClickListener;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.identity.shared.ProfileViewUtils;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle;
import com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyAuthor;
import com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyContent;
import com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyContent.Content;
import com.linkedin.android.pegasus.gen.voyager.publishing.MemberAuthor;
import com.linkedin.android.publishing.reader.views.ArticleReadingView;
import com.linkedin.android.publishing.reader.views.SocialArticleReadingView;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class SocialReaderFragment
  extends PageFragment
{
  private static final String TAG = SocialReaderFragment.class.getSimpleName();
  @Inject
  ActivityComponent activityComponent;
  private PublishingDataProvider articleDataProvider;
  @Inject
  FragmentComponent fragmentComponent;
  @Inject
  FragmentRegistry fragmentRegistry;
  private boolean fromDeepLink;
  @Inject
  MediaCenter mediaCenter;
  @InjectView(2131758269)
  SocialArticleReadingView socialArticleReadingView;
  private String subTitle;
  private String title;
  private Update update;
  private String url;
  private String urn;
  
  public final void doPause()
  {
    super.doPause();
    if (articleDataProvider != null) {
      articleDataProvider.unregister(this);
    }
  }
  
  public final void doResume()
  {
    super.doResume();
    if (articleDataProvider != null) {
      articleDataProvider.register(this);
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    if (paramBundle == null)
    {
      url = ArticleBundle.getUrl(getArguments());
      subTitle = getArguments().getString("subtitle");
      title = ArticleBundle.getTitle(getArguments());
    }
    for (update = ArticleBundle.getUpdate(getArguments());; update = ((Update)RecordParceler.quietUnparcel(Update.BUILDER, "update", paramBundle)))
    {
      fromDeepLink = TextUtils.isEmpty(urn);
      articleDataProvider = activityComponent.articleDataProvider();
      return;
      url = paramBundle.getString("url");
      subTitle = paramBundle.getString("subtitle");
      title = paramBundle.getString("title");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969336, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    super.onDataError(paramType, paramSet, paramDataManagerException);
    socialArticleReadingView.hideLoading();
    socialArticleReadingView.showError();
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    super.onDataReady(paramType, paramSet, paramMap);
    if (paramSet == null) {
      return;
    }
    boolean bool = paramSet.contains(articleDataProvider.state).articleRoute);
    if (paramSet.contains(articleDataProvider.state).socialDetailRoute))
    {
      paramType = (PublishingDataProvider.ArticleState)articleDataProvider.state;
      paramType = (SocialDetail)paramType.getModel(socialDetailRoute);
      if (paramType != null)
      {
        socialArticleReadingView.loadSocialDetail(paramType);
        socialArticleReadingView.setOnLikeClickListener(new FeedLikeOnClickListener(paramType, fragmentComponent, "like_article", new TrackingEventBuilder[0]));
      }
    }
    else
    {
      label116:
      if (!bool) {
        break label673;
      }
      paramType = (PublishingDataProvider.ArticleState)articleDataProvider.state;
      paramType = (CollectionTemplate)paramType.getModel(articleRoute);
      if ((paramType == null) || (CollectionUtils.isEmpty(elements))) {
        break label732;
      }
    }
    for (;;)
    {
      try
      {
        paramType = (FirstPartyContent)elements.get(0);
        paramSet = content.firstPartyArticleValue;
        bool = ProfileViewUtils.isSelfView(authors.get(0)).memberAuthorValue.miniProfile, null, fragmentComponent);
        socialArticleReadingView.loadArticle(paramSet, bool);
        urn = linkedInArticleUrn.toString();
        if (fromDeepLink)
        {
          paramSet = getRumSessionId();
          if (!TextUtils.isEmpty(paramSet))
          {
            paramMap = articleDataProvider;
            localObject1 = busSubscriberId;
            Object localObject2 = urn;
            localObject2 = FeedRouteUtils.getSocialDetailUrl(activityComponent, (String)localObject2, null);
            state).socialDetailRoute = ((String)localObject2);
            Object localObject3 = paramMap.newModelListener((String)localObject1, paramSet);
            localObject2 = Request.get().url((String)localObject2).customHeaders(null).builder(SocialDetail.BUILDER).listener((RecordTemplateListener)localObject3).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
            localObject3 = MultiplexRequest.Builder.parallel();
            multiplexerUrl = Routes.MUX.buildUponRoot().toString();
            paramMap.performMultiplexedFetch((String)localObject1, paramSet, null, ((MultiplexRequest.Builder)localObject3).filter(DataManager.DataStoreFilter.NETWORK_ONLY).required((DataRequestWrapper.Builder)localObject2));
          }
        }
        socialArticleReadingView.setShowHideListener(new SocialReaderFragment.1(this));
        paramMap = content.firstPartyArticleValue;
        Object localObject1 = (FirstPartyAuthor)authors.get(0);
        socialArticleReadingView.setReadingViewListener(new SocialReaderFragment.2(this, (FirstPartyAuthor)localObject1));
        socialArticleReadingView.setOnLinkClickedListener(new SocialReaderFragment.8(this));
        socialArticleReadingView.setOnFollowClickListener(new FeedFollowEntityOnClickListener(fragmentComponent, 2, memberAuthorValue.miniProfile.entityUrn.toString(), memberAuthorValue.followingInfo, "follow_author", new TrackingEventBuilder[0]));
        if (update == null) {
          break label675;
        }
        paramType = new FeedUpdateOnClickListener(update, fragmentComponent, 1, true, null, null, "click_comment", new TrackingEventBuilder[0]);
        paramSet = new FeedUpdateOnClickListener(update, fragmentComponent, 0, true, null, null, "view_likers", new TrackingEventBuilder[0]);
        socialArticleReadingView.setOnCommentClickListener(paramType);
        socialArticleReadingView.setOnSocialStatsClickListener(paramSet);
        socialArticleReadingView.setOnShareClickListener(new SocialReaderFragment.3(this));
        socialArticleReadingView.setCloseButtonListener(new SocialReaderFragment.4(this));
        socialArticleReadingView.setOverflowClickListener(new SocialReaderFragment.5(this, (FirstPartyAuthor)localObject1));
        socialArticleReadingView.setErrorButtonClickListener(new SocialReaderFragment.6(this, paramMap));
        return;
      }
      catch (BuilderException paramType)
      {
        Log.e(TAG, "exception: " + paramType.getMessage());
        return;
      }
      socialArticleReadingView.hideLoading();
      socialArticleReadingView.showError();
      break label116;
      label673:
      break;
      label675:
      paramType = new FeedUpdateOnClickListener(urn, fragmentComponent, 1, true, null, null, "click_comment", new TrackingEventBuilder[0]);
      paramSet = new FeedUpdateOnClickListener(urn, fragmentComponent, 0, true, null, null, "view_likers", new TrackingEventBuilder[0]);
    }
    label732:
    socialArticleReadingView.hideLoading();
    socialArticleReadingView.showError();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putString("urn", urn);
    paramBundle.putString("url", url);
    paramBundle.putString("subtitle", subTitle);
    paramBundle.putString("title", title);
    if (update != null) {
      RecordParceler.quietParcel(update, "update", paramBundle);
    }
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    socialArticleReadingView.setMediaCenter(applicationComponent.mediaCenter());
    socialArticleReadingView.setI18NManager(fragmentComponent.i18NManager());
    paramView = getRumSessionId();
    if (!TextUtils.isEmpty(paramView))
    {
      paramBundle = articleDataProvider;
      String str1 = busSubscriberId;
      Object localObject1 = url;
      String str2 = urn;
      localObject1 = Routes.PUBLISHING_CONTENT.buildUponRoot().buildUpon().appendQueryParameter("q", "url").appendQueryParameter("url", (String)localObject1).build().toString();
      Object localObject2 = paramBundle.newModelListener(str1, paramView);
      localObject2 = Request.get().url((String)localObject1).builder(new CollectionTemplate.CollectionTemplateJsonParser(FirstPartyContent.BUILDER, CollectionMetadata.BUILDER)).listener((RecordTemplateListener)localObject2).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      state).articleRoute = ((String)localObject1);
      localObject1 = MultiplexRequest.Builder.parallel();
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      localObject1 = ((MultiplexRequest.Builder)localObject1).filter(DataManager.DataStoreFilter.NETWORK_ONLY).required((DataRequestWrapper.Builder)localObject2);
      if (!TextUtils.isEmpty(str2))
      {
        str2 = FeedRouteUtils.getSocialDetailUrl(activityComponent, str2, null);
        state).socialDetailRoute = str2;
        ((MultiplexRequest.Builder)localObject1).optional(Request.get().url(str2).customHeaders(null).builder(SocialDetail.BUILDER).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
      }
      paramBundle.performMultiplexedFetch(str1, paramView, null, (MultiplexRequest.Builder)localObject1);
    }
  }
  
  public final String pageKey()
  {
    return "pulse_read";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.reader.SocialReaderFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */