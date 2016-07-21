package com.linkedin.android.feed.shared;

import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData;

public abstract interface UrlPreviewGetter$Listener
{
  public abstract void onError();
  
  public abstract void onUrlPreview(UrlPreviewData paramUrlPreviewData);
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.UrlPreviewGetter.Listener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */