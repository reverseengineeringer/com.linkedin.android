package com.linkedin.android.publishing.reader;

import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import javax.inject.Inject;

public final class PublishingDataProvider
  extends DataProvider<PublishingDataProvider.ArticleState, DataProvider.DataProviderListener>
{
  @Inject
  public PublishingDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.reader.PublishingDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */