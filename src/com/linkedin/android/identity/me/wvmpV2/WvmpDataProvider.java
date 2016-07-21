package com.linkedin.android.identity.me.wvmpV2;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.RestliUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.MySettings;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCard;
import java.net.URLEncoder;
import java.util.Map;
import javax.inject.Inject;

public class WvmpDataProvider
  extends DataProvider<WvmpDataProvider.MeWvmpOverviewState, DataProvider.DataProviderListener>
{
  protected static final Uri SETTINGS_ROUTE = Routes.SETTINGS.buildUponRoot();
  public static final String TAG = WvmpDataProvider.class.getSimpleName();
  public static final Uri WVMP_OVERVIEW_CARDS_ROUTE = Routes.ME_WVMP_CARDS.buildUponRoot();
  public static final Uri WVMP_PROFILE_LIST_ROUTE = Routes.ME_FEED_CARDS.buildUponRoot().buildUpon().appendQueryParameter("q", "profileViewCards").build();
  
  @Inject
  public WvmpDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public static String getCompanyInsightViewersRoute(Urn paramUrn)
  {
    return WVMP_PROFILE_LIST_ROUTE.toString() + "&companyUrns=" + RestliUtils.getListParameterValue(new String[] { URLEncoder.encode(paramUrn.toString()) });
  }
  
  public static String getJobTitleInsightViewersRoute(Urn paramUrn)
  {
    return WVMP_PROFILE_LIST_ROUTE.toString() + "&occupationUrns=" + RestliUtils.getListParameterValue(new String[] { URLEncoder.encode(paramUrn.toString()) });
  }
  
  public static String getViewerSourceInsightViewersRoute(Urn paramUrn)
  {
    return WVMP_PROFILE_LIST_ROUTE.toString() + "&referrerSources=" + RestliUtils.getListParameterValue(new String[] { paramUrn.getId() });
  }
  
  public final void fetchAllData$294d6e3a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    DataManager.DataStoreFilter localDataStoreFilter = DataManager.DataStoreFilter.NETWORK_ONLY;
    MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    performMultiplexedFetch(paramString1, paramString2, paramMap, localBuilder.filter(localDataStoreFilter).required(Request.get().url(WVMP_OVERVIEW_CARDS_ROUTE.toString()).builder(new CollectionTemplate.CollectionTemplateJsonParser(WvmpCard.BUILDER, CollectionMetadata.BUILDER))).required(Request.get().url(SETTINGS_ROUTE.toString()).builder(MySettings.BUILDER)));
  }
  
  public final CollectionTemplate<WvmpCard, CollectionMetadata> getCards()
  {
    return ((WvmpDataProvider.MeWvmpOverviewState)state).cards();
  }
  
  public final MySettings getSettings()
  {
    return ((WvmpDataProvider.MeWvmpOverviewState)state).settings();
  }
  
  public final boolean isDataAvailable()
  {
    return (getCards() != null) && (getSettings() != null);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.wvmpV2.WvmpDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */