package com.linkedin.android.feed.shared.imageviewer;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.data.UnionParceler;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class ImageViewerBundle
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  private ImageViewerBundle(Update paramUpdate, boolean paramBoolean)
  {
    RecordParceler.quietParcel(paramUpdate, "update", bundle);
    bundle.putString("updateUrn", urn.toString());
    if (entityUrn != null) {
      bundle.putString("updateEntityUrn", entityUrn.toString());
    }
    bundle.putBoolean("backWhenReply", paramBoolean);
  }
  
  private ImageViewerBundle(String paramString1, String paramString2, boolean paramBoolean)
  {
    bundle.putString("updateUrn", paramString1);
    bundle.putString("updateEntityUrn", paramString2);
    bundle.putBoolean("backWhenReply", paramBoolean);
  }
  
  public static ImageViewerBundle create(Update paramUpdate, boolean paramBoolean)
  {
    return new ImageViewerBundle(paramUpdate, paramBoolean);
  }
  
  public static ImageViewerBundle create(String paramString1, String paramString2, boolean paramBoolean)
  {
    return new ImageViewerBundle(paramString1, paramString2, paramBoolean);
  }
  
  public static Image getPlaceholderImage(Bundle paramBundle)
  {
    return (Image)UnionParceler.quietUnparcel(Image.BUILDER, "placeholderImage", paramBundle);
  }
  
  public static Update getUpdate(Bundle paramBundle)
  {
    return (Update)RecordParceler.quietUnparcel(Update.BUILDER, "update", paramBundle);
  }
  
  public static String getUpdateUrn(Bundle paramBundle)
  {
    return paramBundle.getString("updateUrn", "");
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final ImageViewerBundle setPlaceholderImage(Image paramImage)
  {
    UnionParceler.quietParcel(paramImage, "placeholderImage", bundle);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */