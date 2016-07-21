package com.linkedin.android.identity.me.notifications.cards.dataproviders;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.shared.Routes;

public abstract class MeCardBaseDataProvider<STATE extends MeCardBaseDataProvider.MeCardState>
  extends DataProvider<STATE, DataProvider.DataProviderListener>
{
  public MeCardBaseDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public static String getMeCardRoute(String paramString)
  {
    return Routes.ME_FEED_CARDS.buildUponRoot().buildUpon().appendPath(paramString).toString();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.notifications.cards.dataproviders.MeCardBaseDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */