package com.linkedin.CrossPromoLib.api.PromoBase;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.linkedin.CrossPromoLib.api.CrossPromoManager;
import com.linkedin.CrossPromoLib.api.PromoInflater;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.api.PromoTracker;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.CrossPromoLib.models.types.ImageType;
import com.linkedin.CrossPromoLib.utils.CallbackAfterBatch;
import com.linkedin.CrossPromoLib.utils.CrossPromoImageListener;
import com.linkedin.CrossPromoLib.utils.EventTypes;
import com.linkedin.CrossPromoLib.utils.NonMarketUrlRunnable;
import com.linkedin.CrossPromoLib.utils.PromoUtils;
import com.linkedin.CrossPromoLib.utils.Utils;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.crosspromo.fe.api.android.Image;
import com.linkedin.crosspromo.fe.api.android.MetricsInfo;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.crosspromo.fe.api.android.SubPromo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BasePromo
  extends PromoUtils
{
  private static final String TAG = BasePromo.class.getName();
  private final CallbackAfterBatch callbackAfterImageLoading;
  private long loadingImages = 0L;
  private boolean onImagesReadyFired = false;
  private boolean onViewReadyFired = false;
  public final PromoSource source;
  
  public BasePromo(PromoSource paramPromoSource)
  {
    source = paramPromoSource;
    callbackAfterImageLoading = new CallbackAfterBatch()
    {
      public final void callback()
      {
        BasePromo.access$000(BasePromo.this);
      }
    };
  }
  
  private void addImageToPromoView(ImageView paramImageView, ImageType paramImageType)
  {
    attachImageToImageViewWithFixedWidth(paramImageView, paramImageType.getImage(getPromoModel()), 0);
  }
  
  private void fetchRegisteredImage(Image paramImage, ImageView paramImageView, final CrossPromoImageListener paramCrossPromoImageListener)
  {
    if (TextUtils.isEmpty(url))
    {
      Log.e(TAG, "Invalid image URL when fetching Promo image");
      callbackAfterImageLoading.complete();
      return;
    }
    CrossPromoManager.loadImage(url, paramImageView, new CrossPromoImageListener()
    {
      public final void onError(String paramAnonymousString, Exception paramAnonymousException)
      {
        BasePromo.access$100(BasePromo.this);
        if (paramCrossPromoImageListener != null) {
          paramCrossPromoImageListener.onError(paramAnonymousString, paramAnonymousException);
        }
        super.onError(paramAnonymousString, paramAnonymousException);
      }
      
      public final void onSuccess(String paramAnonymousString, ManagedBitmap paramAnonymousManagedBitmap)
      {
        BasePromo.access$100(BasePromo.this);
        if (paramCrossPromoImageListener != null) {
          paramCrossPromoImageListener.onSuccess(paramAnonymousString, paramAnonymousManagedBitmap);
        }
      }
    });
  }
  
  private void onEverythingReady()
  {
    if ((onViewReadyFired) && (onImagesReadyFired)) {
      Log.i(TAG, "onEverythingReady Fired");
    }
    while ((onViewReadyFired) || (onImagesReadyFired)) {
      return;
    }
    Log.e(TAG, "onEverythingReady was fired when no events occurred.  Did you try to call an onReady method rather than its onReadyEntryPoint?");
  }
  
  private void registerNewImages(int paramInt)
  {
    callbackAfterImageLoading.register(paramInt);
  }
  
  public void OverridableOnViewReady$3c7ec8c3()
  {
    PromoInflater.getPromoTracker().trackImpression(getPromoModel(), null, null);
  }
  
  public final void addBackgroundImage(ImageView paramImageView)
  {
    addImageToPromoView(paramImageView, ImageType.BACKGROUND);
  }
  
  public final void addImageToSubPromoView(ImageView paramImageView, SubPromo paramSubPromo, ImageType paramImageType)
  {
    if (images != null) {}
    switch (com.linkedin.CrossPromoLib.models.types.ImageType.1.$SwitchMap$com$linkedin$CrossPromoLib$models$types$ImageType[paramImageType.ordinal()])
    {
    default: 
      paramSubPromo = null;
    }
    for (;;)
    {
      attachImageToImageViewWithFixedWidth(paramImageView, paramSubPromo, 0);
      return;
      paramSubPromo = (Image)images.get("main");
      continue;
      paramSubPromo = (Image)images.get("logo");
    }
  }
  
  public final void addLogoImage(ImageView paramImageView)
  {
    addImageToPromoView(paramImageView, ImageType.LOGO);
  }
  
  public final void attachImageToImageViewWithFixedWidth(final ImageView paramImageView, final Image paramImage, final int paramInt)
  {
    fetchImage(paramImage, paramImageView, new CrossPromoImageListener()
    {
      public final void onSuccess(String paramAnonymousString, ManagedBitmap paramAnonymousManagedBitmap)
      {
        if (paramInt > 0)
        {
          paramAnonymousString = paramAnonymousManagedBitmap.getBitmap();
          i = (int)(paramAnonymousString.getHeight() / paramAnonymousString.getWidth() * paramInt);
          paramAnonymousString = paramImageView.getLayoutParams();
          height = i;
          paramImageView.setLayoutParams(paramAnonymousString);
        }
        while ((paramImage == null) || (!paramImagehasAspectRatio) || (paramImageaspectRatio == 1.0F))
        {
          int i;
          return;
        }
        paramAnonymousString = paramImageView.getLayoutParams();
        height = ((int)(height * paramImageaspectRatio));
        paramImageView.setLayoutParams(paramAnonymousString);
      }
    });
  }
  
  public View.OnClickListener createOnClickDismissListener(View paramView, Runnable paramRunnable)
  {
    return Utils.createOnClickDismissListener(paramView, paramRunnable);
  }
  
  public final View.OnClickListener createOnClickListener(Context paramContext, Runnable paramRunnable, NonMarketUrlRunnable paramNonMarketUrlRunnable)
  {
    Promo localPromo = getPromoModelpromo;
    return createOnClickListener(paramContext, appId, actionUrl, storeUrl, paramRunnable, paramNonMarketUrlRunnable);
  }
  
  public View.OnClickListener createOnClickListener(Context paramContext, String paramString1, String paramString2, String paramString3, Runnable paramRunnable, NonMarketUrlRunnable paramNonMarketUrlRunnable)
  {
    return Utils.createOnClickListener(paramContext, paramString1, paramString2, paramString3, paramRunnable, paramNonMarketUrlRunnable);
  }
  
  public final void doneLoadingImages()
  {
    long l = loadingImages - 1L;
    loadingImages = l;
    if (l == 0L)
    {
      Log.i(TAG, "Lock released for completing image loading");
      callbackAfterImageLoading.doneRegisteringItems();
    }
    while (loadingImages >= 0L) {
      return;
    }
    loadingImages += 1L;
    Log.e(TAG, "doneLoadingImages() was called when there were no image loading locks set");
  }
  
  public final void fetchImage(Image paramImage, ImageView paramImageView, CrossPromoImageListener paramCrossPromoImageListener)
  {
    registerNewImages(1);
    fetchRegisteredImage(paramImage, paramImageView, paramCrossPromoImageListener);
  }
  
  public final Runnable getDefaultRunnable()
  {
    return newEventTracker(EventTypes.FIRE_ACTION_AND_FETCH_PROMO, null);
  }
  
  public final PromoModel getPromoModel()
  {
    return source.getPromoModel();
  }
  
  public abstract View initView(Context paramContext, ViewGroup paramViewGroup);
  
  public final void lockLoadingImages()
  {
    loadingImages += 1L;
    Log.i(TAG, "Lock acquired for completing image loading");
  }
  
  public final Runnable newEventTracker(EventTypes paramEventTypes, MetricsInfo paramMetricsInfo)
  {
    return new EventTracker(paramEventTypes, paramMetricsInfo);
  }
  
  public final void onDataReady()
  {
    Log.i(TAG, "onDataReady Fired");
    onViewReadyFired = false;
    onImagesReadyFired = false;
    lockLoadingImages();
    Object localObject1 = getPromoModelpromo;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      if ((images != null) && (images.size() > 0)) {
        registerNewImages(images.size());
      }
      if (subPromos != null)
      {
        localObject2 = subPromos.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SubPromo)((Iterator)localObject2).next();
          if ((images != null) && (images.size() > 0)) {
            registerNewImages(images.size());
          }
        }
      }
      if (images != null)
      {
        localObject2 = images.values().iterator();
        while (((Iterator)localObject2).hasNext()) {
          fetchRegisteredImage((Image)((Iterator)localObject2).next(), null, null);
        }
      }
      if (subPromos != null)
      {
        localObject1 = subPromos.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SubPromo)((Iterator)localObject1).next();
          if (images != null)
          {
            localObject2 = images.values().iterator();
            while (((Iterator)localObject2).hasNext()) {
              fetchRegisteredImage((Image)((Iterator)localObject2).next(), null, null);
            }
          }
        }
      }
    }
    localObject1 = source.getPromoInflater();
    if (PromoInflater.getPromoType(getPromoModel()) == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label363;
      }
      Log.e(TAG, "Promo view was NULL.  Something went wrong inflating the Promo view.");
    }
    for (;;)
    {
      doneLoadingImages();
      return;
      localObject2 = initView(context, container);
      localObject1 = localObject2;
      if (localObject2 == null) {
        break;
      }
      localObject3 = getPromoModelpromo.widgetId;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break;
      }
      ((View)localObject2).setContentDescription((CharSequence)localObject3);
      localObject1 = localObject2;
      break;
      label363:
      Log.i(TAG, "onViewReady Fired");
      OverridableOnViewReady$3c7ec8c3();
      onViewReadyFired = true;
      onEverythingReady();
    }
  }
  
  private final class EventTracker
    implements Runnable
  {
    private final MetricsInfo metrics;
    private final EventTypes type;
    
    EventTracker(EventTypes paramEventTypes, MetricsInfo paramMetricsInfo)
    {
      type = paramEventTypes;
      metrics = paramMetricsInfo;
    }
    
    public final void run()
    {
      final PromoInflater localPromoInflater = source.getPromoInflater();
      switch (BasePromo.5.$SwitchMap$com$linkedin$CrossPromoLib$utils$EventTypes[type.ordinal()])
      {
      default: 
        return;
      case 1: 
        PromoInflater.getPromoTracker().trackAction(getPromoModel(), metrics, null);
        return;
      case 2: 
        PromoInflater.getPromoTracker().trackAction(getPromoModel(), metrics, new Runnable()
        {
          public final void run()
          {
            localPromoInflater.fetchPromo(source.getPageKey(), source.getQueryParameters());
          }
        });
        return;
      case 3: 
        PromoInflater.getPromoTracker().trackImpression(getPromoModel(), metrics, null);
        return;
      }
      PromoInflater.getPromoTracker().trackImpression(getPromoModel(), metrics, new Runnable()
      {
        public final void run()
        {
          localPromoInflater.fetchPromo(source.getPageKey(), source.getQueryParameters());
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoBase.BasePromo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */