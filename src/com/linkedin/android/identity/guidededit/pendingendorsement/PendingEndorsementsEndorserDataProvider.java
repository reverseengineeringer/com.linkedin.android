package com.linkedin.android.identity.guidededit.pendingendorsement;

import com.linkedin.android.identity.me.notifications.cards.dataproviders.MeCardBaseDataProvider;
import com.linkedin.android.identity.me.notifications.cards.dataproviders.MeCardBaseDataProvider.MeCardState;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card.Value;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Endorsement;
import com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public final class PendingEndorsementsEndorserDataProvider
  extends MeCardBaseDataProvider<MeCardBaseDataProvider.MeCardState>
{
  Map<String, String> trackingHeader;
  
  @Inject
  public PendingEndorsementsEndorserDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public final List<Endorsement> getPendingEndorsements()
  {
    Card localCard = ((MeCardBaseDataProvider.MeCardState)state).getMeCard();
    if ((localCard != null) && (value.endorsementCardValue != null)) {
      return value.endorsementCardValue.endorsements;
    }
    return Collections.emptyList();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementsEndorserDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */