package com.linkedin.android.publishing.sharing.linkpicker;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class LinkPickerIntent
  extends IntentFactory<LinkPickerBundle>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, LinkPickerActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.linkpicker.LinkPickerIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */