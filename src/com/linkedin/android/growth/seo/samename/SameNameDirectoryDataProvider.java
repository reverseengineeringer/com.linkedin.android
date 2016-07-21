package com.linkedin.android.growth.seo.samename;

import android.net.Uri;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.growth.seo.SameNameProfileResult;
import javax.inject.Inject;

public final class SameNameDirectoryDataProvider
  extends DataProvider<SameNameDirectoryDataProvider.SameNameState, DataProvider.DataProviderListener>
{
  @Inject
  public SameNameDirectoryDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public final void fetchData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    state).sameNameDirectoryRoute = SameNameDirectoryRoutes.buildSameNameDirectoryRoute(paramString3, paramString4, paramString5).toString();
    performFetch(CollectionTemplate.of(SameNameProfileResult.BUILDER), state).sameNameDirectoryRoute, paramString1, paramString2, null);
  }
  
  public final boolean isDataAvailable()
  {
    return (state).sameNameDirectoryRoute != null) && (SameNameDirectoryDataProvider.SameNameState.access$100((SameNameDirectoryDataProvider.SameNameState)state) != null);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.seo.samename.SameNameDirectoryDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */