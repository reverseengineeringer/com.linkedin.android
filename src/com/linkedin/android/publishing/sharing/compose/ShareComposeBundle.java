package com.linkedin.android.publishing.sharing.compose;

import android.net.Uri;
import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData;

public final class ShareComposeBundle
  implements BundleBuilder
{
  public final Bundle bundle;
  
  public ShareComposeBundle(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public ShareComposeBundle(boolean paramBoolean)
  {
    bundle = new Bundle();
    bundle.putBoolean("is_reshare", paramBoolean);
  }
  
  private ShareComposeBundle(boolean paramBoolean, byte paramByte)
  {
    this(true);
    bundle.putBoolean("open_message", paramBoolean);
  }
  
  public static ShareComposeBundle createOriginalShare()
  {
    return new ShareComposeBundle(false);
  }
  
  public static ShareComposeBundle createOriginalShareWithArticleUrl(String paramString)
  {
    if (paramString == null) {
      return createOriginalShare();
    }
    ShareComposeBundle localShareComposeBundle = new ShareComposeBundle(false);
    bundle.putString("article_url", paramString);
    return localShareComposeBundle;
  }
  
  public static ShareComposeBundle createOriginalShareWithImage(Uri paramUri)
  {
    if (paramUri == null) {
      return createOriginalShare();
    }
    ShareComposeBundle localShareComposeBundle = new ShareComposeBundle(false);
    bundle.putParcelable("image_uri", paramUri);
    return localShareComposeBundle;
  }
  
  public static ShareComposeBundle createOriginalShareWithInitialText(String paramString)
  {
    if (paramString == null) {
      return createOriginalShare();
    }
    ShareComposeBundle localShareComposeBundle = new ShareComposeBundle(false);
    bundle.putString("initial_text", paramString);
    return localShareComposeBundle;
  }
  
  public static ShareComposeBundle createOriginalShareWithLink(UrlPreviewData paramUrlPreviewData)
  {
    if (paramUrlPreviewData == null) {
      return createOriginalShare();
    }
    ShareComposeBundle localShareComposeBundle = new ShareComposeBundle(false);
    RecordParceler.quietParcel(paramUrlPreviewData, "url_preview", bundle);
    return localShareComposeBundle;
  }
  
  public static ShareComposeBundle createReshare(String paramString, Urn paramUrn, TrackingData paramTrackingData, boolean paramBoolean)
  {
    ShareComposeBundle localShareComposeBundle = new ShareComposeBundle(paramBoolean, (byte)0);
    bundle.putString("update_urn", paramString);
    if (paramUrn != null) {
      bundle.putString("update_entity_urn", paramUrn.toString());
    }
    if (paramTrackingData != null) {
      RecordParceler.quietParcel(paramTrackingData, "trackingData", bundle);
    }
    return localShareComposeBundle;
  }
  
  public static String getGroupId(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("group_id");
  }
  
  public static TrackingData getTrackingData(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return (TrackingData)RecordParceler.quietUnparcel(TrackingData.BUILDER, "trackingData", paramBundle);
    }
    return null;
  }
  
  public static String getUpdateEntityUrn(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("update_entity_urn");
    }
    return null;
  }
  
  public static String getUpdateId(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("update_urn");
    }
    return null;
  }
  
  public static boolean isEditShare(Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBundle != null)
    {
      bool1 = bool2;
      if (paramBundle.getBoolean("is_edit_share", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isReshare(Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBundle != null)
    {
      bool1 = bool2;
      if (paramBundle.getBoolean("is_reshare", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.compose.ShareComposeBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */