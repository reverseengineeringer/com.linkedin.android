package com.linkedin.android.infra.network;

import android.content.Context;
import android.net.Uri;
import com.linkedin.android.imageloader.interfaces.ImageLoader;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorImage;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage;
import java.io.File;
import javax.inject.Inject;

public final class MediaCenterImpl
  implements MediaCenter
{
  private final Context context;
  private final ImageLoader imageLoader;
  private final ImageQualityManager imageQualityManager;
  private final PlaceholderImageCache placeholderImageCache;
  
  @Inject
  public MediaCenterImpl(Context paramContext, ImageLoader paramImageLoader, ImageQualityManager paramImageQualityManager, PlaceholderImageCache paramPlaceholderImageCache)
  {
    context = paramContext.getApplicationContext();
    imageLoader = paramImageLoader;
    imageQualityManager = paramImageQualityManager;
    placeholderImageCache = paramPlaceholderImageCache;
  }
  
  private ImageRequest load(Image paramImage, MediaFilter paramMediaFilter, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramImage == null) {
      return new ImageRequest(context, imageLoader, imageQualityManager, placeholderImageCache, null, paramString);
    }
    if (mediaProcessorImageValue != null)
    {
      paramImage = mediaProcessorImageValue;
      if (paramImage == null) {}
      for (paramImage = (Image)localObject1;; paramImage = id) {
        return load(paramImage, paramMediaFilter, paramString);
      }
    }
    if (mediaProxyImageValue != null)
    {
      paramImage = mediaProxyImageValue;
      if (paramImage == null) {}
      for (paramImage = (Image)localObject2;; paramImage = url) {
        return load(paramImage, MediaFilter.NONE, paramString);
      }
    }
    if (urlValue != null) {
      return load(urlValue, paramMediaFilter, paramString);
    }
    Util.safeThrow(new RuntimeException(String.format("Image type %s must be one of MediaProcessorImage, MediaProxyImage or URL.", new Object[] { Util.getCanonicalName(paramImage) })));
    return load(null, paramMediaFilter, paramString);
  }
  
  public final ImageRequest load(Uri paramUri)
  {
    return load(paramUri, null);
  }
  
  public final ImageRequest load(Uri paramUri, String paramString)
  {
    return new ImageRequest(context, imageLoader, imageQualityManager, placeholderImageCache, paramUri, paramString);
  }
  
  public final ImageRequest load(ImageModel paramImageModel)
  {
    return load(paramImageModel, null);
  }
  
  public final ImageRequest load(ImageModel paramImageModel, String paramString)
  {
    if ((paramImageModel == null) || (imageResourceId == null)) {
      return new ImageRequest(context, imageLoader, imageQualityManager, placeholderImageCache, null, paramString);
    }
    if (imageType == 1) {}
    for (MediaFilter localMediaFilter = MediaFilter.CONTAIN;; localMediaFilter = MediaFilter.NONE) {
      return load(imageResourceId, localMediaFilter, paramString);
    }
  }
  
  public final ImageRequest load(Image paramImage)
  {
    return load(paramImage, null);
  }
  
  public final ImageRequest load(Image paramImage, MediaFilter paramMediaFilter)
  {
    return load(paramImage, paramMediaFilter, null);
  }
  
  public final ImageRequest load(Image paramImage, String paramString)
  {
    if (paramImage == null) {
      return new ImageRequest(context, imageLoader, imageQualityManager, placeholderImageCache, null, paramString);
    }
    if (mediaProcessorImageValue != null) {}
    for (MediaFilter localMediaFilter = MediaFilter.CONTAIN;; localMediaFilter = MediaFilter.NONE) {
      return load(paramImage, localMediaFilter, paramString);
    }
  }
  
  public final ImageRequest load(File paramFile)
  {
    return new ImageRequest(context, imageLoader, imageQualityManager, placeholderImageCache, paramFile);
  }
  
  public final ImageRequest load(String paramString)
  {
    return load(paramString, MediaFilter.CONTAIN, null);
  }
  
  public final ImageRequest load(String paramString, MediaFilter paramMediaFilter)
  {
    return load(paramString, paramMediaFilter, null);
  }
  
  public final ImageRequest load(String paramString1, MediaFilter paramMediaFilter, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (paramString1 = null;; paramString1 = new MprMedia(paramString1, paramMediaFilter)) {
      return new ImageRequest(context, imageLoader, imageQualityManager, placeholderImageCache, paramString1, paramString2);
    }
  }
  
  public final DrawableRequest loadDrawable$569cbe8c(ImageModel paramImageModel)
  {
    return new DrawableRequest(context, this, paramImageModel);
  }
  
  public final ImageRequest loadUrl(String paramString)
  {
    return loadUrl(paramString, null);
  }
  
  public final ImageRequest loadUrl(String paramString1, String paramString2)
  {
    return new ImageRequest(context, imageLoader, imageQualityManager, placeholderImageCache, paramString1, paramString2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.network.MediaCenterImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */