package com.linkedin.android.feed.shared;

import android.content.Context;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import java.util.List;

public final class StackedImagesDrawable$Builder
{
  public int borderWidthRes = 2131493145;
  private final Context context;
  public boolean hasRoundedImages = true;
  public int imageSizeRes = 2131492962;
  private final List<ImageModel> images;
  private final MediaCenter mediaCenter;
  public int rollupCount = -1;
  
  public StackedImagesDrawable$Builder(Context paramContext, MediaCenter paramMediaCenter, List<ImageModel> paramList)
  {
    context = paramContext;
    mediaCenter = paramMediaCenter;
    images = paramList;
  }
  
  public final StackedImagesDrawable build()
  {
    return new StackedImagesDrawable(context, mediaCenter, images, rollupCount, imageSizeRes, borderWidthRes, hasRoundedImages, (byte)0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.StackedImagesDrawable.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */