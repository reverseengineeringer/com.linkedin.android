package com.linkedin.android.messaging.stickers;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class StickerStoreIntent
  extends IntentFactory<StickerStoreBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, StickerStoreActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.stickers.StickerStoreIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */