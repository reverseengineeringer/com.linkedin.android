package com.linkedin.android.publishing.sharing.linkpicker;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData;

public final class LinkPickerBundle
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public LinkPickerBundle() {}
  
  LinkPickerBundle(UrlPreviewData paramUrlPreviewData)
  {
    RecordParceler.quietParcel(paramUrlPreviewData, "URL_PREVIEW_DATA", bundle);
  }
  
  public static UrlPreviewData getUrlPreviewData(Bundle paramBundle)
  {
    return (UrlPreviewData)RecordParceler.quietUnparcel(UrlPreviewData.BUILDER, "URL_PREVIEW_DATA", paramBundle);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.linkpicker.LinkPickerBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */