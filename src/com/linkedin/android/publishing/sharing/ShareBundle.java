package com.linkedin.android.publishing.sharing;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.publishing.sharing.compose.ShareComposeBundle;

public final class ShareBundle
  implements BundleBuilder
{
  private final Bundle bundle;
  
  public ShareBundle(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static ShareBundle createFeedShare(ShareComposeBundle paramShareComposeBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBundle("shareCreatorBundle", paramShareComposeBundle.build());
    localBundle.putInt("usage", 0);
    return new ShareBundle(localBundle);
  }
  
  public static ShareComposeBundle getShareCreatorBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return null;
      paramBundle = paramBundle.getBundle("shareCreatorBundle");
    } while ((paramBundle == null) || (paramBundle == null));
    return new ShareComposeBundle(paramBundle);
  }
  
  public static String getTitle(Bundle paramBundle, I18NManager paramI18NManager)
  {
    String str = paramI18NManager.getString(2131233683);
    paramI18NManager = str;
    if (paramBundle != null) {
      paramI18NManager = paramBundle.getString("shareTitle", str);
    }
    return paramI18NManager;
  }
  
  public static boolean isReshare(Bundle paramBundle)
  {
    paramBundle = getShareCreatorBundle(paramBundle);
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.build();; paramBundle = null) {
      return ShareComposeBundle.isReshare(paramBundle);
    }
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.ShareBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */