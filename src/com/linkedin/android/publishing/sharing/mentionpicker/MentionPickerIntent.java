package com.linkedin.android.publishing.sharing.mentionpicker;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class MentionPickerIntent
  extends IntentFactory<MentionPickerBundle>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, MentionPickerActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.mentionpicker.MentionPickerIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */