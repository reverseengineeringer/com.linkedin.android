package com.linkedin.android.growth;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.shared.Util;

public final class SendInviteBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle;
  
  public SendInviteBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
    if ((!paramBundle.containsKey("signatureUrl")) || (!paramBundle.containsKey("nid"))) {
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Invalid bundle"));
    }
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.SendInviteBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */