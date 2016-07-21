package com.linkedin.android.infra.network;

import android.databinding.DataBindingComponent;
import android.net.Uri;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import java.io.File;

public abstract interface MediaCenter
  extends DataBindingComponent
{
  @Deprecated
  public abstract ImageRequest load(Uri paramUri);
  
  public abstract ImageRequest load(Uri paramUri, String paramString);
  
  @Deprecated
  public abstract ImageRequest load(ImageModel paramImageModel);
  
  public abstract ImageRequest load(ImageModel paramImageModel, String paramString);
  
  @Deprecated
  public abstract ImageRequest load(Image paramImage);
  
  @Deprecated
  public abstract ImageRequest load(Image paramImage, MediaFilter paramMediaFilter);
  
  public abstract ImageRequest load(Image paramImage, String paramString);
  
  @Deprecated
  public abstract ImageRequest load(File paramFile);
  
  @Deprecated
  public abstract ImageRequest load(String paramString);
  
  @Deprecated
  public abstract ImageRequest load(String paramString, MediaFilter paramMediaFilter);
  
  public abstract ImageRequest load(String paramString1, MediaFilter paramMediaFilter, String paramString2);
  
  public abstract DrawableRequest loadDrawable$569cbe8c(ImageModel paramImageModel);
  
  @Deprecated
  public abstract ImageRequest loadUrl(String paramString);
  
  public abstract ImageRequest loadUrl(String paramString1, String paramString2);
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.network.MediaCenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */