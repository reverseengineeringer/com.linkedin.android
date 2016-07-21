package com.linkedin.android.identity.me.notifications.cards.dataproviders;

import com.linkedin.android.infra.components.ActivityComponent;
import javax.inject.Inject;

public final class MeCardDataProvider
  extends MeCardBaseDataProvider<MeCardBaseDataProvider.MeCardState>
{
  @Inject
  public MeCardDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.notifications.cards.dataproviders.MeCardDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */