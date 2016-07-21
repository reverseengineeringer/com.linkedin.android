package com.linkedin.CrossPromoLib.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.api.Promos.BannerPromoWithIcon;
import com.linkedin.CrossPromoLib.api.Promos.BannerPromoWithImage;
import com.linkedin.CrossPromoLib.api.Promos.BannerPromoWithPanelIcon;
import com.linkedin.CrossPromoLib.api.Promos.BannerPromoWithText;
import com.linkedin.CrossPromoLib.api.Promos.BoxPromo;
import com.linkedin.CrossPromoLib.api.Promos.ImageRollupPromo;
import com.linkedin.CrossPromoLib.api.Promos.LightboxPromo;
import com.linkedin.CrossPromoLib.api.Promos.TallHeroPromo;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.CrossPromoLib.models.types.PromoType;
import com.linkedin.CrossPromoLib.utils.Network.ActionEventFireRequest;
import com.linkedin.CrossPromoLib.utils.Network.ImpressionEventFireRequest;
import com.linkedin.CrossPromoLib.utils.Network.PromoModelFetchRequest;
import com.linkedin.CrossPromoLib.utils.Utils;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.crosspromo.fe.api.android.MetricsInfo;
import com.linkedin.crosspromo.fe.api.android.Promo;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PromoInflater
{
  public static final PromoTracker STANDARD_PROMO_TRACKER;
  private static final String TAG = PromoInflater.class.getName();
  public static volatile PromoTracker currentPromoTracker;
  public final ViewGroup container;
  public final Context context;
  
  static
  {
    StandardPromoTracker localStandardPromoTracker = new StandardPromoTracker();
    STANDARD_PROMO_TRACKER = localStandardPromoTracker;
    currentPromoTracker = localStandardPromoTracker;
  }
  
  private PromoInflater(Context paramContext, ViewGroup paramViewGroup)
  {
    context = paramContext;
    container = paramViewGroup;
  }
  
  public PromoInflater(ViewGroup paramViewGroup)
  {
    this(paramViewGroup.getContext(), paramViewGroup);
  }
  
  public static PromoTracker getPromoTracker()
  {
    return currentPromoTracker;
  }
  
  public static PromoType getPromoType(PromoModel paramPromoModel)
  {
    Promo localPromo = promo;
    int i;
    if (localPromo != null)
    {
      if ((TextUtils.isEmpty(promo.tType)) || ((!promo.hasTexts) && (!promo.hasImages) && (!promo.hasSubPromos))) {
        break label60;
      }
      i = 1;
      if (i != 0) {
        break label65;
      }
    }
    label60:
    label65:
    while (TextUtils.isEmpty(tType))
    {
      return null;
      i = 0;
      break;
    }
    return new PromoType(tType);
  }
  
  public final void fetchPromo(final String paramString, final Map<String, String> paramMap)
  {
    PromoModelFetchRequest.sendRequest$313b03d7(paramString, new ResponseListener()
    {
      public final void onFailure(int paramAnonymousInt, Object paramAnonymousObject, Map<String, List<String>> paramAnonymousMap, IOException paramAnonymousIOException)
      {
        Log.e(PromoInflater.TAG, "Failed to render promo", paramAnonymousIOException);
      }
      
      public final Object parseErrorResponse(RawResponse paramAnonymousRawResponse)
        throws IOException
      {
        return null;
      }
    });
  }
  
  public BasePromo getPromo(PromoSource paramPromoSource)
  {
    PromoType localPromoType = getPromoType(paramPromoSource.getPromoModel());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localPromoType != null)
    {
      if (!PromoType.BOX_PROMO.equals(localPromoType)) {
        break label42;
      }
      localObject1 = new BoxPromo(paramPromoSource);
    }
    label42:
    do
    {
      return (BasePromo)localObject1;
      if (PromoType.BANNER_PROMO_ICON.equals(localPromoType)) {
        return new BannerPromoWithIcon(paramPromoSource);
      }
      if (PromoType.BANNER_PROMO_IMAGE.equals(localPromoType)) {
        return new BannerPromoWithImage(paramPromoSource);
      }
      if (PromoType.BANNER_PROMO_PANEL_ICON.equals(localPromoType)) {
        return new BannerPromoWithPanelIcon(paramPromoSource);
      }
      if (PromoType.BANNER_PROMO_TEXT.equals(localPromoType)) {
        return new BannerPromoWithText(paramPromoSource);
      }
      if (PromoType.IMAGE_ROLLUP_PROMO.equals(localPromoType)) {
        return new ImageRollupPromo(paramPromoSource);
      }
      if (PromoType.TALL_HERO_PROMO.equals(localPromoType)) {
        return new TallHeroPromo(paramPromoSource);
      }
      localObject1 = localObject2;
    } while (!PromoType.LIGHTBOX_PROMO_MASTER.equals(localPromoType));
    return new LightboxPromo(paramPromoSource);
  }
  
  public void renderPromoModel(String paramString, Map<String, String> paramMap, PromoModel paramPromoModel)
  {
    paramMap = getPromo(new Source(this, paramString, paramMap, paramPromoModel));
    if (paramMap == null)
    {
      Log.e(TAG, "Failed to inflate Promo");
      return;
    }
    if (paramPromoModel == null)
    {
      paramString = null;
      if ((paramString == null) || (!Utils.isAppInstalled(context, appId))) {
        break label130;
      }
      Log.w(TAG, appId + " is already installed");
      if (!hasMetricsMap) {
        break label125;
      }
    }
    label125:
    for (paramString = (MetricsInfo)metricsMap.get("skip");; paramString = null)
    {
      currentPromoTracker.trackAction(paramPromoModel, paramString, null);
      return;
      paramString = promo;
      break;
    }
    label130:
    paramMap.onDataReady();
  }
  
  private static final class Source
    implements PromoSource
  {
    private final String pageKey;
    private final PromoInflater promoInflater;
    private final PromoModel promoModel;
    private final Map<String, String> queryParams;
    
    Source(PromoInflater paramPromoInflater, String paramString, Map<String, String> paramMap, PromoModel paramPromoModel)
    {
      promoInflater = paramPromoInflater;
      pageKey = paramString;
      queryParams = paramMap;
      promoModel = paramPromoModel;
    }
    
    public final String getPageKey()
    {
      return pageKey;
    }
    
    public final PromoInflater getPromoInflater()
    {
      return promoInflater;
    }
    
    public final PromoModel getPromoModel()
    {
      return promoModel;
    }
    
    public final Map<String, String> getQueryParameters()
    {
      return queryParams;
    }
  }
  
  public static final class StandardPromoTracker
    implements PromoTracker
  {
    public final void trackAction(PromoModel paramPromoModel, MetricsInfo paramMetricsInfo, final Runnable paramRunnable)
    {
      if (paramRunnable == null) {}
      for (paramRunnable = null;; paramRunnable = new ResponseListener()
          {
            public final void onFailure(int paramAnonymousInt, Object paramAnonymousObject, Map paramAnonymousMap, IOException paramAnonymousIOException) {}
            
            public final void onSuccess(int paramAnonymousInt, Object paramAnonymousObject, Map paramAnonymousMap)
            {
              paramRunnable.run();
            }
            
            public final Object parseErrorResponse(RawResponse paramAnonymousRawResponse)
              throws IOException
            {
              return null;
            }
            
            public final Object parseSuccessResponse(RawResponse paramAnonymousRawResponse)
              throws IOException
            {
              return null;
            }
          })
      {
        ActionEventFireRequest.fire(paramPromoModel, paramRunnable, paramMetricsInfo);
        return;
      }
    }
    
    public final void trackImpression(PromoModel paramPromoModel, MetricsInfo paramMetricsInfo, final Runnable paramRunnable)
    {
      if (paramRunnable == null) {}
      for (paramRunnable = null;; paramRunnable = new ResponseListener()
          {
            public final void onFailure(int paramAnonymousInt, Object paramAnonymousObject, Map paramAnonymousMap, IOException paramAnonymousIOException) {}
            
            public final void onSuccess(int paramAnonymousInt, Object paramAnonymousObject, Map paramAnonymousMap)
            {
              paramRunnable.run();
            }
            
            public final Object parseErrorResponse(RawResponse paramAnonymousRawResponse)
              throws IOException
            {
              return null;
            }
            
            public final Object parseSuccessResponse(RawResponse paramAnonymousRawResponse)
              throws IOException
            {
              return null;
            }
          })
      {
        ImpressionEventFireRequest.fire(paramPromoModel, paramRunnable, paramMetricsInfo);
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoInflater
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */