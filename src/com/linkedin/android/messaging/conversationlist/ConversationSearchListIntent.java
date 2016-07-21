package com.linkedin.android.messaging.conversationlist;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class ConversationSearchListIntent
  extends IntentFactory<ConversationSearchListBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, ConversationSearchListActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.conversationlist.ConversationSearchListIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */