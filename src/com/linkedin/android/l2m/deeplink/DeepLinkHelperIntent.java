package com.linkedin.android.l2m.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class DeepLinkHelperIntent
  extends IntentFactory<DeepLinkHelperBundleBuilder>
{
  public final Intent newIntent(Context paramContext, DeepLinkHelperBundleBuilder paramDeepLinkHelperBundleBuilder)
  {
    paramContext = super.newIntent(paramContext, paramDeepLinkHelperBundleBuilder);
    if (paramDeepLinkHelperBundleBuilder != null)
    {
      paramContext.setData((Uri)bundle.getParcelable("uri"));
      paramContext.setAction("android.intent.action.VIEW");
    }
    return paramContext;
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, DeepLinkHelperActivity.class).setFlags(536870912);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.deeplink.DeepLinkHelperIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */