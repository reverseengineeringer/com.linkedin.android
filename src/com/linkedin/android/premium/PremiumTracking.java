package com.linkedin.android.premium;

import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumProductFamily;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition.Builder;
import com.linkedin.gen.avro2pegasus.events.premium.PremiumCheckoutImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.premium.PremiumOnboardingImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.premium.ProductSubsFamily;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PremiumTracking
{
  private static final Map<PremiumProductFamily, ProductSubsFamily> PREMIUM_PRODUCT_FAMILY_TO_PRODUCT_SUBS_FAMILY_MAP;
  private static final Map<com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel, com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellChannel> PREMIUM_UPSELL_CHANNEL_TO_TRACKING_PREMIUM_UPSELL_CHANNEL_MAP = new HashMap();
  
  static
  {
    PREMIUM_PRODUCT_FAMILY_TO_PRODUCT_SUBS_FAMILY_MAP = new HashMap();
    PREMIUM_UPSELL_CHANNEL_TO_TRACKING_PREMIUM_UPSELL_CHANNEL_MAP.put(com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel.AASAAN, com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellChannel.SEARCH);
    PREMIUM_UPSELL_CHANNEL_TO_TRACKING_PREMIUM_UPSELL_CHANNEL_MAP.put(com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel.EMAIL, com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellChannel.EMAIL);
    PREMIUM_UPSELL_CHANNEL_TO_TRACKING_PREMIUM_UPSELL_CHANNEL_MAP.put(com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel.HYR, com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellChannel.HYR);
    PREMIUM_UPSELL_CHANNEL_TO_TRACKING_PREMIUM_UPSELL_CHANNEL_MAP.put(com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel.INMAIL, com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellChannel.INMAIL);
    PREMIUM_UPSELL_CHANNEL_TO_TRACKING_PREMIUM_UPSELL_CHANNEL_MAP.put(com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel.JOBS, com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellChannel.JOBS);
    PREMIUM_UPSELL_CHANNEL_TO_TRACKING_PREMIUM_UPSELL_CHANNEL_MAP.put(com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel.NAVBAR, com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellChannel.NAVBAR);
    PREMIUM_UPSELL_CHANNEL_TO_TRACKING_PREMIUM_UPSELL_CHANNEL_MAP.put(com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel.PROFILE, com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellChannel.PROFILE);
    PREMIUM_UPSELL_CHANNEL_TO_TRACKING_PREMIUM_UPSELL_CHANNEL_MAP.put(com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel.SETTINGS, com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellChannel.SETTINGS);
    PREMIUM_UPSELL_CHANNEL_TO_TRACKING_PREMIUM_UPSELL_CHANNEL_MAP.put(com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel.WVMP, com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellChannel.WVMP);
    PREMIUM_UPSELL_CHANNEL_TO_TRACKING_PREMIUM_UPSELL_CHANNEL_MAP.put(com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel.SPONSORED_INMAIL, com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellChannel.SPONSORED_INMAIL);
    PREMIUM_UPSELL_CHANNEL_TO_TRACKING_PREMIUM_UPSELL_CHANNEL_MAP.put(com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel.APP_LAUNCHER, com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellChannel.APP_LAUNCHER);
    PREMIUM_UPSELL_CHANNEL_TO_TRACKING_PREMIUM_UPSELL_CHANNEL_MAP.put(com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel.ME, com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellChannel.ME);
    PREMIUM_PRODUCT_FAMILY_TO_PRODUCT_SUBS_FAMILY_MAP.put(PremiumProductFamily.JSS, ProductSubsFamily.JSS);
    PREMIUM_PRODUCT_FAMILY_TO_PRODUCT_SUBS_FAMILY_MAP.put(PremiumProductFamily.GENERAL, ProductSubsFamily.GENERAL);
    PREMIUM_PRODUCT_FAMILY_TO_PRODUCT_SUBS_FAMILY_MAP.put(PremiumProductFamily.SALES, ProductSubsFamily.SALES);
    PREMIUM_PRODUCT_FAMILY_TO_PRODUCT_SUBS_FAMILY_MAP.put(PremiumProductFamily.TALENT, ProductSubsFamily.TALENT);
  }
  
  public static void fireCheckoutImpressionEvent(Tracker paramTracker, String paramString1, String paramString2, PremiumChooserPageInstance paramPremiumChooserPageInstance, long paramLong)
  {
    PremiumCheckoutImpressionEvent.Builder localBuilder = new PremiumCheckoutImpressionEvent.Builder();
    paramString1 = "urn:li:product:" + paramString1;
    if (paramString1 == null)
    {
      hasProductUrn = false;
      productUrn = null;
      paramString1 = "urn:li:price:" + paramString2;
      if (paramString1 != null) {
        break label152;
      }
      hasPriceUrn = false;
      priceUrn = null;
      label75:
      paramString1 = paramPremiumChooserPageInstance.toPegasusGenPageInstance();
      if (paramString1 != null) {
        break label167;
      }
      hasChooserSessionStartPageInstance = false;
      chooserSessionStartPageInstance = null;
      label96:
      paramString1 = "urn:li:order:" + paramLong;
      if (paramString1 != null) {
        break label182;
      }
      hasOrderUrn = false;
    }
    for (orderUrn = null;; orderUrn = paramString1)
    {
      paramTracker.send(localBuilder);
      return;
      hasProductUrn = true;
      productUrn = paramString1;
      break;
      label152:
      hasPriceUrn = true;
      priceUrn = paramString1;
      break label75;
      label167:
      hasChooserSessionStartPageInstance = true;
      chooserSessionStartPageInstance = paramString1;
      break label96;
      label182:
      hasOrderUrn = true;
    }
  }
  
  public static void fireChooserImpressionEvent(Tracker paramTracker, String paramString1, List<String> paramList, com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel paramPremiumUpsellChannel, PremiumProductFamily paramPremiumProductFamily, int paramInt1, int paramInt2, PremiumChooserPageInstance paramPremiumChooserPageInstance, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add("urn:li:price:" + (String)paramList.get(i));
      i += 1;
    }
    paramList = null;
    for (;;)
    {
      try
      {
        localBuilder = new PremiumChooserImpressionEvent.Builder();
        paramString1 = "urn:li:product:" + paramString1;
        if (paramString1 != null) {
          continue;
        }
        hasProductUrn = false;
        productUrn = null;
        hasPriceUrns = true;
        priceUrns = localArrayList;
        paramString1 = (com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellChannel)PREMIUM_UPSELL_CHANNEL_TO_TRACKING_PREMIUM_UPSELL_CHANNEL_MAP.get(paramPremiumUpsellChannel);
        if (paramString1 != null) {
          continue;
        }
        hasChannel = false;
        channel = null;
      }
      catch (BuilderException paramString1)
      {
        PremiumChooserImpressionEvent.Builder localBuilder;
        Log.e(PremiumTracking.class.getSimpleName(), paramString1);
        paramString1 = paramList;
        continue;
        hasChannel = true;
        channel = paramString1;
        continue;
        hasSubsFamily = true;
        subsFamily = paramString1;
        continue;
        hasProductCount = true;
        productCount = paramString1.intValue();
        continue;
        hasChooserSessionStartPageInstance = true;
        chooserSessionStartPageInstance = paramString1;
        continue;
        hasUpsellControlUrn = true;
        upsellControlUrn = paramString1;
        continue;
        hasCampaignUrn = true;
        campaignUrn = paramList;
        continue;
      }
      paramString1 = toSubsFamily(paramPremiumProductFamily);
      if (paramString1 != null) {
        continue;
      }
      hasSubsFamily = false;
      subsFamily = null;
      paramString1 = new ListPosition.Builder().setIndex(Integer.valueOf(paramInt1)).build(RecordTemplate.Flavor.RECORD);
      hasProductPosition = true;
      productPosition = paramString1;
      paramString1 = Integer.valueOf(paramInt2);
      if (paramString1 != null) {
        continue;
      }
      hasProductCount = false;
      productCount = 0;
      paramString1 = paramPremiumChooserPageInstance.toPegasusGenPageInstance();
      if (paramString1 != null) {
        continue;
      }
      hasChooserSessionStartPageInstance = false;
      chooserSessionStartPageInstance = null;
      paramString1 = "urn:li:control:" + paramString2;
      if (paramString1 != null) {
        continue;
      }
      hasUpsellControlUrn = false;
      upsellControlUrn = null;
      paramString1 = localBuilder;
      if (paramString3 != null)
      {
        paramList = "urn:li:campaign:" + paramString3;
        if (paramList != null) {
          continue;
        }
        hasCampaignUrn = false;
        campaignUrn = null;
      }
      paramTracker.send(paramString1);
      return;
      hasProductUrn = true;
      productUrn = paramString1;
    }
  }
  
  public static void fireOnboardingImpressionEvent(Tracker paramTracker, long paramLong, PremiumProductFamily paramPremiumProductFamily, PremiumChooserPageInstance paramPremiumChooserPageInstance)
  {
    PremiumOnboardingImpressionEvent.Builder localBuilder = new PremiumOnboardingImpressionEvent.Builder();
    String str = "urn:li:order:" + paramLong;
    if (str == null)
    {
      hasOrderUrn = false;
      orderUrn = null;
      paramPremiumProductFamily = toSubsFamily(paramPremiumProductFamily);
      if (paramPremiumProductFamily != null) {
        break label110;
      }
      hasSubsFamily = false;
      subsFamily = null;
      label65:
      paramPremiumProductFamily = paramPremiumChooserPageInstance.toPegasusGenPageInstance();
      if (paramPremiumProductFamily != null) {
        break label125;
      }
      hasChooserSessionStartPageInstance = false;
    }
    for (chooserSessionStartPageInstance = null;; chooserSessionStartPageInstance = paramPremiumProductFamily)
    {
      paramTracker.send(localBuilder);
      return;
      hasOrderUrn = true;
      orderUrn = str;
      break;
      label110:
      hasSubsFamily = true;
      subsFamily = paramPremiumProductFamily;
      break label65;
      label125:
      hasChooserSessionStartPageInstance = true;
    }
  }
  
  private static ProductSubsFamily toSubsFamily(PremiumProductFamily paramPremiumProductFamily)
  {
    return (ProductSubsFamily)PREMIUM_PRODUCT_FAMILY_TO_PRODUCT_SUBS_FAMILY_MAP.get(paramPremiumProductFamily);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.PremiumTracking
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */