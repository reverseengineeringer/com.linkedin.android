package com.linkedin.android.growth.boost;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.telephony.TelephonyManager;
import com.linkedin.android.datamanager.DataManager;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponseBuilder;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostEligibility;
import com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData;
import com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostUpgradeResult;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateParser;
import com.linkedin.data.lite.DataTemplateParserFactory;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.common.messages.flock.PhoneNumberInfo;
import com.linkedin.gen.avro2pegasus.common.messages.flock.PhoneNumberInfo.Builder;
import java.io.ByteArrayInputStream;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class BoostUtil
{
  private static final String TAG = BoostUtil.class.getSimpleName();
  
  public static BoostEligibility getBoostEligibilityModelFromPreferences(FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    paramFlagshipSharedPreferences = paramFlagshipSharedPreferences.getBoostEligibilityModelString();
    if (paramFlagshipSharedPreferences != null) {
      try
      {
        paramFlagshipSharedPreferences = (BoostEligibility)DataManager.PARSER_FACTORY.createParser().parseRecord(new ByteArrayInputStream(paramFlagshipSharedPreferences.getBytes()), BoostEligibility.BUILDER);
        return paramFlagshipSharedPreferences;
      }
      catch (DataReaderException paramFlagshipSharedPreferences)
      {
        Log.e(TAG, "Error parsing BoostEligibilityStatus model string from SharedPreferences", paramFlagshipSharedPreferences);
      }
    }
    return null;
  }
  
  public static void getEligibility(FlagshipSharedPreferences paramFlagshipSharedPreferences, FlagshipDataManager paramFlagshipDataManager, final Bus paramBus, Context paramContext)
  {
    paramFlagshipSharedPreferences.getPreferences().edit().remove("boostEligibilityModel").apply();
    paramFlagshipSharedPreferences.getPreferences().edit().remove("boostUpgradeStatus").apply();
    paramContext = getSimOperator(paramContext);
    if (paramContext != null)
    {
      paramFlagshipDataManager.submit(Request.get().url(Routes.BOOST.buildUponRoot().buildUpon().appendQueryParameter("simOperatorIdentifier", paramContext).appendQueryParameter("timeZone", Integer.toString(TimeZone.getDefault().getRawOffset() / 1000)).build().toString()).builder(BoostEligibility.BUILDER).listener(new RecordTemplateListener()
      {
        public final void onResponse(DataStoreResponse<BoostEligibility> paramAnonymousDataStoreResponse)
        {
          if (model != null)
          {
            paramAnonymousDataStoreResponse = (BoostEligibility)model;
            val$flagshipSharedPreferences.setBoostEligibilityModelString(PegasusPatchGenerator.modelToJSONString(paramAnonymousDataStoreResponse));
            Bus.publish(new BoostEligibilityFetchedEvent());
            return;
          }
          Log.e(BoostUtil.TAG, "Error getting BoostEligibilityStatus model string from voyager api");
        }
      }).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
      return;
    }
    Log.e(TAG, "Error fetching boost eligibility as sim info cannot be retrieved.");
  }
  
  public static PhoneNumberInfo getPhoneNumberInfo(Context paramContext)
  {
    String str1 = getSimOperator(paramContext);
    if (str1 != null)
    {
      paramContext = new PhoneNumberInfo.Builder();
      String str2 = str1.substring(0, 3);
      if (str2 == null)
      {
        hasMobileCountryCode = false;
        mobileCountryCode = null;
        str1 = str1.substring(3);
        if (str1 != null) {
          break label81;
        }
        hasMobileNetworkCode = false;
      }
      for (mobileNetworkCode = null;; mobileNetworkCode = str1)
      {
        try
        {
          paramContext = paramContext.build(RecordTemplate.Flavor.RECORD);
          return paramContext;
        }
        catch (BuilderException paramContext)
        {
          label81:
          Util.safeThrow$7a8b4789(new RuntimeException(paramContext));
          return null;
        }
        hasMobileCountryCode = true;
        mobileCountryCode = str2;
        break;
        hasMobileNetworkCode = true;
      }
    }
    Log.e(TAG, "Error reading sim operator info; Unable to build PhoneNumberInfo.");
    return null;
  }
  
  public static String getProductUrn$63ab225c(FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    paramFlagshipSharedPreferences = getBoostEligibilityModelFromPreferences(paramFlagshipSharedPreferences);
    if ((paramFlagshipSharedPreferences != null) && (promotionData != null)) {
      return Urn.createFromTuple("premiumProduct", new Object[] { Integer.valueOf(promotionData.productId) }).toString();
    }
    Util.safeThrow$7a8b4789(new RuntimeException("Error reading productId from shared preferences"));
    return "";
  }
  
  private static String getSimOperator(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext.getSimState() == 5) {
      return paramContext.getSimOperator();
    }
    return null;
  }
  
  public static void verifyAndUpgradeAccount(FlagshipDataManager paramFlagshipDataManager, FlagshipSharedPreferences paramFlagshipSharedPreferences, Context paramContext)
  {
    BoostEligibility localBoostEligibility = getBoostEligibilityModelFromPreferences(paramFlagshipSharedPreferences);
    if ((localBoostEligibility != null) && (userEligible))
    {
      paramContext = getSimOperator(paramContext);
      if (paramContext == null) {}
    }
    else
    {
      try
      {
        paramContext = new JSONObject().put("simOperatorIdentifier", paramContext).put("timeZone", TimeZone.getDefault().getRawOffset() / 1000);
        paramFlagshipDataManager.submit(Request.post().url(Routes.BOOST.buildUponRoot().buildUpon().appendQueryParameter("action", "upgradeAccount").build().toString()).builder(new ActionResponseBuilder(BoostUpgradeResult.BUILDER)).model(new JsonModel(paramContext)).listener(new RecordTemplateListener()
        {
          public final void onResponse(DataStoreResponse<ActionResponse<BoostUpgradeResult>> paramAnonymousDataStoreResponse)
          {
            paramAnonymousDataStoreResponse = (ActionResponse)model;
            if ((paramAnonymousDataStoreResponse != null) && (value != null))
            {
              FlagshipSharedPreferences localFlagshipSharedPreferences = val$preferences;
              boolean bool = value).upgradeFulfilled;
              localFlagshipSharedPreferences.getPreferences().edit().putBoolean("boostUpgradeStatus", bool).apply();
              return;
            }
            Log.e(BoostUtil.TAG, "Error getting BoostUpgradeStatus from voyager api");
          }
        }).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
        return;
      }
      catch (JSONException paramFlagshipDataManager)
      {
        Util.safeThrow$7a8b4789(new IllegalStateException("Error creating json payload for boost upgrade account request"));
        return;
      }
    }
    Log.e(TAG, "Error reading sim operator info; Unable to upgrade account to premium");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.BoostUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */