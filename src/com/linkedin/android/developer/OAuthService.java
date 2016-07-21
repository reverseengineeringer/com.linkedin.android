package com.linkedin.android.developer;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.linkedin.android.growth.login.LoginIntent;
import com.linkedin.android.growth.login.LoginIntentBundle;
import com.linkedin.android.growth.samsung.SamsungSyncConsentIntent;
import com.linkedin.android.growth.samsung.SamsungSyncConsentIntentBundle;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.network.Auth;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class OAuthService
  extends Service
{
  private static final String TAG = OAuthService.class.getSimpleName();
  private static final List<String> approvedSignatures;
  private final IOAuthService.Stub binder = new IOAuthService.Stub()
  {
    public final void getToken$628af682(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, final IOAuthServiceResultCallback paramAnonymousIOAuthServiceResultCallback)
      throws RemoteException
    {
      FlagshipApplication localFlagshipApplication = (FlagshipApplication)getApplication();
      ApplicationComponent localApplicationComponent = localFlagshipApplication.getAppComponent();
      int i = getCallingUid();
      String str = OAuthService.access$000$51afb15f(localFlagshipApplication, i);
      final LocalBroadcastManager localLocalBroadcastManager = LocalBroadcastManager.getInstance(getApplicationContext());
      BroadcastReceiver local1;
      if ((str != null) && (OAuthService.access$100$4b0eacd0(localFlagshipApplication, str)))
      {
        final CountDownLatch localCountDownLatch = new CountDownLatch(1);
        local1 = new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymous2Context, Intent paramAnonymous2Intent)
          {
            OAuthService.access$200(paramAnonymousIOAuthServiceResultCallback, paramAnonymous2Intent.getBundleExtra("ouath_result_bundle"));
            localCountDownLatch.countDown();
          }
        };
        localLocalBroadcastManager.registerReceiver(local1, new IntentFilter("com.linkedin.android.OAUTH_RESULT_ACTION"));
        OAuthNetworkHelper localOAuthNetworkHelper = localApplicationComponent.oAuthNetworkHelper();
        if (!localApplicationComponent.auth().isAuthenticated())
        {
          paramAnonymousString1 = OAuthService.access$300$354d2d2d(localFlagshipApplication, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
          paramAnonymousString2 = new LoginIntentBundle();
          paramAnonymousString2.setThirdPartyApplicationPackageName(str);
          paramAnonymousString2.setRedirectIntent(paramAnonymousString1);
          paramAnonymousString1 = intentRegistrylogin.newIntent(localFlagshipApplication, paramAnonymousString2);
          paramAnonymousString1.addFlags(335544320);
          localFlagshipApplication.startActivity(paramAnonymousString1);
        }
        for (;;)
        {
          try
          {
            if (!localCountDownLatch.await(5L, TimeUnit.SECONDS)) {
              paramAnonymousIOAuthServiceResultCallback.onError("Service timed out: " + i + "(" + str + ")");
            }
            return;
          }
          catch (InterruptedException paramAnonymousString1)
          {
            paramAnonymousIOAuthServiceResultCallback.onError("Service interrupted: " + i + "(" + str + ")");
            return;
          }
          finally
          {
            localLocalBroadcastManager.unregisterReceiver(local1);
          }
          if (localApplicationComponent.flagshipSharedPreferences().getDevTokenUserSelection())
          {
            localOAuthNetworkHelper.getToken(paramAnonymousString1, paramAnonymousString3, paramAnonymousString2, new OAuthNetworkHelper.OAuthResponseListener()
            {
              public final void onFailure()
              {
                Bundle localBundle = new Bundle();
                localBundle.putString("error_msg", "Could not get user token");
                Intent localIntent = new Intent("com.linkedin.android.OAUTH_RESULT_ACTION");
                localIntent.putExtra("ouath_result_bundle", localBundle);
                localLocalBroadcastManager.sendBroadcast(localIntent);
              }
              
              public final void onSuccess(Bundle paramAnonymous2Bundle)
              {
                Intent localIntent = new Intent("com.linkedin.android.OAUTH_RESULT_ACTION");
                localIntent.putExtra("ouath_result_bundle", paramAnonymous2Bundle);
                localLocalBroadcastManager.sendBroadcast(localIntent);
              }
            });
          }
          else if (localFlagshipApplication.getAppComponent().flagshipSharedPreferences().getPreferences().getBoolean("homeActivityResumedAtLeastOnce", false))
          {
            paramAnonymousString1 = OAuthService.access$300$354d2d2d(localFlagshipApplication, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
            paramAnonymousString2 = new SamsungSyncConsentIntentBundle();
            bundle.putParcelable("redirect", paramAnonymousString1);
            paramAnonymousString1 = intentRegistrysamsungSyncConsentIntent.newIntent(localFlagshipApplication, paramAnonymousString2);
            paramAnonymousString1.addFlags(268435456);
            localFlagshipApplication.startActivity(paramAnonymousString1);
          }
          else
          {
            paramAnonymousIOAuthServiceResultCallback.onError("App not ready yet: " + i + "(" + str + ")");
            return;
          }
        }
      }
      paramAnonymousIOAuthServiceResultCallback.onError("Unauthorized caller: " + i + "(" + str + ")");
    }
  };
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    approvedSignatures = localArrayList;
    localArrayList.add("308204a830820390a003020102020900b3998086d056cffa300d06092a864886f70d0101040500308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d301e170d3038303431353232343035305a170d3335303930313232343035305a308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d30820120300d06092a864886f70d01010105000382010d003082010802820101009c780592ac0d5d381cdeaa65ecc8a6006e36480c6d7207b12011be50863aabe2b55d009adf7146d6f2202280c7cd4d7bdb26243b8a806c26b34b137523a49268224904dc01493e7c0acf1a05c874f69b037b60309d9074d24280e16bad2a8734361951eaf72a482d09b204b1875e12ac98c1aa773d6800b9eafde56d58bed8e8da16f9a360099c37a834a6dfedb7b6b44a049e07a269fccf2c5496f2cf36d64df90a3b8d8f34a3baab4cf53371ab27719b3ba58754ad0c53fc14e1db45d51e234fbbe93c9ba4edf9ce54261350ec535607bf69a2ff4aa07db5f7ea200d09a6c1b49e21402f89ed1190893aab5a9180f152e82f85a45753cf5fc19071c5eec827020103a381fc3081f9301d0603551d0e041604144fe4a0b3dd9cba29f71d7287c4e7c38f2086c2993081c90603551d230481c13081be80144fe4a0b3dd9cba29f71d7287c4e7c38f2086c299a1819aa48197308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d820900b3998086d056cffa300c0603551d13040530030101ff300d06092a864886f70d01010405000382010100572551b8d93a1f73de0f6d469f86dad6701400293c88a0cd7cd778b73dafcc197fab76e6212e56c1c761cfc42fd733de52c50ae08814cefc0a3b5a1a4346054d829f1d82b42b2048bf88b5d14929ef85f60edd12d72d55657e22e3e85d04c831d613d19938bb8982247fa321256ba12d1d6a8f92ea1db1c373317ba0c037f0d1aff645aef224979fba6e7a14bc025c71b98138cef3ddfc059617cf24845cf7b40d6382f7275ed738495ab6e5931b9421765c491b72fb68e080dbdb58c2029d347c8b328ce43ef6a8b15533edfbe989bd6a48dd4b202eda94c6ab8dd5b8399203daae2ed446232e4fe9bd961394c6300e5138e3cfd285e6e4e483538cb8b1b357");
    approvedSignatures.add("3082036c30820254a00302010202044f42f000300d06092a864886f70d01010505003078310b3009060355040613024b523111300f060355040813084779656f6e676769310e300c060355040713055375776f6e311b3019060355040a1312416e64726f696420535720322047726f7570310c300a060355040b1303534543311b301906035504031312536f6369616c4d6167617a696e652e536563301e170d3132303232313031313434305a170d3339303730393031313434305a3078310b3009060355040613024b523111300f060355040813084779656f6e676769310e300c060355040713055375776f6e311b3019060355040a1312416e64726f696420535720322047726f7570310c300a060355040b1303534543311b301906035504031312536f6369616c4d6167617a696e652e53656330820122300d06092a864886f70d01010105000382010f003082010a0282010100803a32edb3c74971bbc12b84aaf4b4a4ff75bf8c2ef6ac5c41bf79d56e9468a52155e5a8e315418bdf18d0c3fcd1b0d7d1beffa6b8c5b378dcd4a73a4e6b43b83d12d179e4d91349eb8b9a46218d311f843fe0bb61dd89b417508c4dc1afaaee26662ab311dbcf85ad738d83d5eec27fee06e65407626419bd4a93f2059cc55ff5b912be9e354fc9bf94bdbf8c58ed565a7cd81550e8e5ce824973ffe559269b73f68aad05ed946a2fed1aee42fabf4108a546df230d77535149429e9c279ce87a9ad570f19857ed2508f74373a52ffff3a4826154399dd5a8c120944ec653b2cb4f1bcda8ce236e660c03f7c24c2feb4ef28f7050702f2b8c0c979c70a964870203010001300d06092a864886f70d010105050003820101001ee84e8c9afa034bda4df8a7be8cedb512eafc1db4ef45b2d688977bc7514a5853caca2e661abc554fd24e1686b35a4aeb93d6d8dc13259aa259302693e7ef02ffb5a8284835ea7cfc1e96da4c1a7adcedd59a1e2c8dff19860c26bd761771009c63f452e9174c3001ba213c7509f1b8cc359d5548e66d6c1a5785871664d61bd1efc1938904183b0bd9ca3bd4fc9c5728834694288a2f7ca3a59a84870ac9e5c0d67066bcfd86dbcc0bcd727a9c2302c84d99f9510d7a6890860194e637dc7b8e3b28a7dea19259fa06b36aa43da665692f8b2a727208a1a7917dbaba6c16b122dc1bc620219b96f75865752f5b3e5fc92ab7b0d412e40b16f4d857decdb811");
    approvedSignatures.add("30820257308201c0a003020102020450807382300d06092a864886f70d0101050500306f310b3009060355040613025553310b3009060355040813024341311630140603550407130d4d6f756e7461696e20566965773111300f060355040a13084c696e6b6564496e3110300e060355040b1307416e64726f6964311630140603550403130d416e64726f69642044656275673020170d3132313031383231323431385a180f32313132313031383231323431385a306f310b3009060355040613025553310b3009060355040813024341311630140603550407130d4d6f756e7461696e20566965773111300f060355040a13084c696e6b6564496e3110300e060355040b1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d00308189028181008012fb1baed8317345c05016f91e8e7552678c2dbab6a54a20fb9c75a540683ecedeff1954c503717f4de4a1c2e94291cbc8bed351345adc06273ab563b61bcf0d2c519f5d00f5b745c479f4e96d515a137ec802d680805d1d91e700030218f3e1e5055d4cc00ce7b32c0f8a02eb61382027136a233da27f8bde2f3c2e6deb3f0203010001300d06092a864886f70d01010505000381810009f7c97515a8d456f62de22af4a61e89bde1f7fb493f4597859f5cc3ba738309463a1e282cd09a2ab33350e3f36a280bb42eba0e17d6a64a06cd0a11a126bb71506d34e8ba800bad2b69f63e8b8c2a8a71bae9ecad4f621c2b32ba99d47399b1933a5b4b72911f469c149731aed47a5d7fe036ceee4552e0a84f1629633d936f");
    approvedSignatures.add("308201e53082014ea00302010202045227d3f0300d06092a864886f70d01010505003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3133303930353030343433325a170d3433303832393030343433325a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d0030818902818100c86bfa538c10f264804622dc9db35804e048ea9bf848f0aef4240476f440c32738da37e4aeb1dbabd2af825eefcfc09ff70a46dd9f38dbc71c2b7af55e8aa929e98338b20d3dbb14fc42ac3d99387e67051207850701c33a2877cd5d03aff9c2f7c92efc1e116e63260302cc11d9898627f8e2b19445da925cd930d764822eef0203010001300d06092a864886f70d010105050003818100a56ed62f96b740ce78a759e1baf1457db1fa84845226469ef1f3a9053676fdab6e384175e0ceb78823409a1562bea00960bc2e2078107515ba559386d24669e1947f79ba9741f9da97f275550acd9e38e8b0281ebdf1cf49508dcb233ce4c72632b117033162d51e279d6edf8a62434b35120e7697501793ceea4908a2d84ae6");
  }
  
  @SuppressLint({"PackageManagerGetSignatures"})
  private static boolean verifyCallerSignature(Context paramContext, String paramString)
  {
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    boolean bool2 = bool5;
    boolean bool3 = bool6;
    try
    {
      paramContext = getPackageManagergetPackageInfo64signatures[0].toCharsString();
      bool2 = bool5;
      bool3 = bool6;
      Iterator localIterator = approvedSignatures.iterator();
      do
      {
        bool1 = bool4;
        bool2 = bool5;
        bool3 = bool6;
        if (!localIterator.hasNext()) {
          break;
        }
        bool2 = bool5;
        bool3 = bool6;
      } while (!((String)localIterator.next()).equalsIgnoreCase(paramContext));
      bool2 = true;
      bool3 = true;
      boolean bool1 = true;
      Log.i(TAG, "Verified Caller");
      if (!bool1)
      {
        bool2 = bool1;
        bool3 = bool1;
        Log.e(TAG, "caller" + paramString + " signature " + paramContext + " not verified");
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.e(TAG, "package name not found", paramContext);
      return bool2;
    }
    catch (Throwable paramContext)
    {
      Log.e(TAG, "other exception", paramContext);
    }
    return bool3;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return binder;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.developer.OAuthService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */