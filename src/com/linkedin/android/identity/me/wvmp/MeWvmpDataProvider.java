package com.linkedin.android.identity.me.wvmp;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.identity.me.shared.paging.MeWvmpPagingHelper;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.MySettings;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Panel;
import com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpMetadata;
import java.util.Map;
import javax.inject.Inject;

public class MeWvmpDataProvider
  extends DataProvider<MeWvmpDataProvider.MeWvmpState, DataProvider.DataProviderListener>
{
  protected static final Uri ANALYTICS_PANELS_ROUTE = Routes.ME_FEED_PANELS.buildUponRoot();
  protected static final Uri SETTINGS_ROUTE = Routes.SETTINGS.buildUponRoot();
  public static final String TAG = MeWvmpDataProvider.class.getSimpleName();
  public static final Uri WVMP_CARDS_ROUTE = Routes.ME_FEED_CARDS.buildUponRoot().buildUpon().appendQueryParameter("q", "profileViews").build();
  
  @Inject
  public MeWvmpDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public final void fetchAllData(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap)
  {
    if (paramBoolean) {}
    for (DataManager.DataStoreFilter localDataStoreFilter = DataManager.DataStoreFilter.NETWORK_ONLY;; localDataStoreFilter = DataManager.DataStoreFilter.ALL)
    {
      MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.parallel();
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      performMultiplexedFetch(paramString1, paramString2, paramMap, localBuilder.filter(localDataStoreFilter).required(Request.get().url(WVMP_CARDS_ROUTE.toString()).builder(new CollectionTemplate.CollectionTemplateJsonParser(Card.BUILDER, WvmpMetadata.BUILDER))).required(Request.get().url(ANALYTICS_PANELS_ROUTE.toString()).builder(new CollectionTemplate.CollectionTemplateJsonParser(Panel.BUILDER, CollectionMetadata.BUILDER))).required(Request.get().url(SETTINGS_ROUTE.toString()).builder(MySettings.BUILDER)));
      return;
    }
  }
  
  public final CollectionTemplate<Card, WvmpMetadata> getWvmpCards()
  {
    if (((MeWvmpDataProvider.MeWvmpState)state).wvmp() == null) {
      Util.safeThrow(new RuntimeException("getWvmpCards should not be called when data is not available"));
    }
    return ((MeWvmpDataProvider.MeWvmpState)state).wvmp();
  }
  
  public final boolean hasMoreData()
  {
    return (state).wvmpHelper != null) && (state).wvmpHelper.hasMoreData());
  }
  
  public final boolean isDataAvailable()
  {
    return (((MeWvmpDataProvider.MeWvmpState)state).wvmp() != null) && (((MeWvmpDataProvider.MeWvmpState)state).analyticsPanels() != null) && (((MeWvmpDataProvider.MeWvmpState)state).settings() != null);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.wvmp.MeWvmpDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */