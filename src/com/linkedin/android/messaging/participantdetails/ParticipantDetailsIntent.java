package com.linkedin.android.messaging.participantdetails;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class ParticipantDetailsIntent
  extends IntentFactory<ParticipantDetailsBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, ParticipantDetailsActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.participantdetails.ParticipantDetailsIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */