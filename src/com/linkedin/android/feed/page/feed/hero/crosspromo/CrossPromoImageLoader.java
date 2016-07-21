package com.linkedin.android.feed.page.feed.hero.crosspromo;

import android.util.Pair;
import android.widget.ImageView;
import com.linkedin.CrossPromoLib.utils.CrossPromoImageListener;
import com.linkedin.CrossPromoLib.utils.Network.AbstractCrossPromoImageLoader;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.ImageRequest.ImageRequestListener;
import com.linkedin.android.infra.network.MediaCenter;

public final class CrossPromoImageLoader
  extends AbstractCrossPromoImageLoader
{
  private final MediaCenter media;
  
  public CrossPromoImageLoader(MediaCenter paramMediaCenter)
  {
    media = paramMediaCenter;
  }
  
  public final void loadImage(String paramString, ImageView paramImageView, CrossPromoImageListener paramCrossPromoImageListener)
  {
    paramString = media.loadUrl(paramString);
    requestListener = new RequestAdapter(paramCrossPromoImageListener, (byte)0);
    paramString.into(paramImageView);
  }
  
  public final void loadImage(String paramString, CrossPromoImageListener paramCrossPromoImageListener)
  {
    media.loadUrl(paramString).into(new Adapter(paramCrossPromoImageListener, (byte)0));
  }
  
  private static final class Adapter
    implements ImageListener
  {
    private final CrossPromoImageListener adaptee;
    
    private Adapter(CrossPromoImageListener paramCrossPromoImageListener)
    {
      adaptee = paramCrossPromoImageListener;
    }
    
    public final Pair<Integer, Integer> getTargetDimensions()
    {
      return null;
    }
    
    public final void onErrorResponse(String paramString, Exception paramException)
    {
      adaptee.onError(paramString, paramException);
    }
    
    public final void onResponse(String paramString, ManagedBitmap paramManagedBitmap, boolean paramBoolean)
    {
      adaptee.onSuccess(paramString, paramManagedBitmap);
    }
  }
  
  private static final class RequestAdapter
    implements ImageRequest.ImageRequestListener
  {
    private final CrossPromoImageListener adaptee;
    
    private RequestAdapter(CrossPromoImageListener paramCrossPromoImageListener)
    {
      adaptee = paramCrossPromoImageListener;
    }
    
    public final void onErrorResponse(Object paramObject, String paramString, Exception paramException)
    {
      adaptee.onError(paramString, paramException);
    }
    
    public final void onResponse(Object paramObject, String paramString, ManagedBitmap paramManagedBitmap, boolean paramBoolean)
    {
      adaptee.onSuccess(paramString, paramManagedBitmap);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.crosspromo.CrossPromoImageLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */