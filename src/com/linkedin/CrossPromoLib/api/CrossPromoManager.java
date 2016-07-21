package com.linkedin.CrossPromoLib.api;

import android.content.Context;
import android.widget.ImageView;
import com.linkedin.CrossPromoLib.utils.CrossPromoImageListener;
import com.linkedin.CrossPromoLib.utils.Network.AbstractCrossPromoImageLoader;
import com.linkedin.android.networking.AbstractNetworkClient;

public final class CrossPromoManager
{
  private static CrossPromoManager instance;
  private static final Object instanceLock = new Object();
  private Context applicationContext;
  private AbstractCrossPromoImageLoader imageLoader;
  private AbstractNetworkClient networkClient;
  
  private CrossPromoManager(Context paramContext, AbstractNetworkClient paramAbstractNetworkClient, AbstractCrossPromoImageLoader paramAbstractCrossPromoImageLoader)
  {
    applicationContext = paramContext.getApplicationContext();
    networkClient = paramAbstractNetworkClient;
    imageLoader = paramAbstractCrossPromoImageLoader;
  }
  
  public static CrossPromoManager create(Context paramContext, AbstractNetworkClient paramAbstractNetworkClient, AbstractCrossPromoImageLoader paramAbstractCrossPromoImageLoader)
  {
    synchronized (instanceLock)
    {
      if (instance == null) {
        instance = new CrossPromoManager(paramContext, paramAbstractNetworkClient, paramAbstractCrossPromoImageLoader);
      }
      return instance;
    }
  }
  
  public static Context getApplicationContext()
  {
    return instanceapplicationContext;
  }
  
  public static AbstractNetworkClient getNetworkClient()
  {
    return instancenetworkClient;
  }
  
  public static void loadImage(String paramString, ImageView paramImageView, CrossPromoImageListener paramCrossPromoImageListener)
  {
    if (paramImageView == null)
    {
      instanceimageLoader.loadImage(paramString, paramCrossPromoImageListener);
      return;
    }
    instanceimageLoader.loadImage(paramString, paramImageView, paramCrossPromoImageListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.CrossPromoManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */