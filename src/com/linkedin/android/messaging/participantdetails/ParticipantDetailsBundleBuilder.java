package com.linkedin.android.messaging.participantdetails;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class ParticipantDetailsBundleBuilder
  extends com.linkedin.messengerlib.ui.participantdetails.ParticipantDetailsBundleBuilder
  implements BundleBuilder
{
  public ParticipantDetailsBundleBuilder(boolean paramBoolean)
  {
    bundle.putBoolean("IS_GROUP_CONVERSATION", paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.participantdetails.ParticipantDetailsBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */