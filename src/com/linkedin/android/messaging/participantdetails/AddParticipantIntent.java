package com.linkedin.android.messaging.participantdetails;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class AddParticipantIntent
  extends IntentFactory<AddParticipantBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, AddParticipantActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.participantdetails.AddParticipantIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */