package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlf;
import com.google.android.gms.internal.zzlf.zza;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

@KeepName
public class SignInHubActivity
  extends FragmentActivity
{
  private zzq zzXP;
  private zzk zzXQ;
  private SignInConfiguration zzXR;
  private boolean zzXS;
  private String zzXT;
  private String zzXU;
  private boolean zzXV;
  private int zzXW;
  private Intent zzXX;
  
  private void zza(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = zzXQ.zzXD.values().iterator();
    while ((localIterator.hasNext()) && (!((zzlf)localIterator.next()).zza(paramInt1, paramInt2, paramIntent, zzbO(zzXU)))) {}
    if (paramInt2 == 0) {
      finish();
    }
  }
  
  private void zzaR(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("errorCode", paramInt);
    setResult(0, localIntent);
    finish();
  }
  
  private void zzaS(int paramInt)
  {
    Status localStatus = new Status(paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("googleSignInStatus", localStatus);
    setResult(0, localIntent);
    finish();
  }
  
  private zzlf.zza zzbO(final String paramString)
  {
    new zzlf.zza()
    {
      public final void zzk(Intent paramAnonymousIntent)
      {
        if (paramAnonymousIntent != null)
        {
          if (!TextUtils.isEmpty(paramString)) {
            paramAnonymousIntent.putExtra("scopes", paramString);
          }
          SignInHubActivity.zza(SignInHubActivity.this, paramAnonymousIntent);
          return;
        }
        Log.w("AuthSignInClient", "Idp signin failed!");
        SignInHubActivity.zza$7bc45402(SignInHubActivity.this);
      }
    };
  }
  
  private void zzd$10b55c15()
  {
    getSupportLoaderManager().initLoader$71be8de6(new zza((byte)0));
  }
  
  private void zzj(Intent paramIntent)
  {
    paramIntent.setPackage("com.google.android.gms");
    paramIntent.putExtra("config", zzXR);
    if (zzXS) {}
    for (int i = 40962;; i = 40961) {
      try
      {
        startActivityForResult(paramIntent, i);
        return;
      }
      catch (ActivityNotFoundException paramIntent)
      {
        Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
        if (!zzXS) {
          break;
        }
        zzaS(8);
        return;
        zzaR(2);
      }
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    setResult(0);
    switch (paramInt1)
    {
    default: 
      zza(paramInt1, paramInt2, paramIntent);
      return;
    case 40962: 
      if (paramIntent != null)
      {
        localObject1 = (SignInAccount)paramIntent.getParcelableExtra("signInAccount");
        if ((localObject1 != null) && (zzXm != null))
        {
          localObject1 = zzXm;
          zzXP.zzb((GoogleSignInAccount)localObject1, zzXR.zzXN);
          paramIntent.removeExtra("signInAccount");
          paramIntent.putExtra("googleSignInAccount", (Parcelable)localObject1);
          zzXV = true;
          zzXW = paramInt2;
          zzXX = paramIntent;
          zzd$10b55c15();
          return;
        }
        if (paramIntent.hasExtra("errorCode"))
        {
          zzaS(paramIntent.getIntExtra("errorCode", 8));
          return;
        }
      }
      zzaS(8);
      return;
    case 40961: 
      if (paramInt2 == -1)
      {
        localObject1 = (SignInAccount)paramIntent.getParcelableExtra("signInAccount");
        if (localObject1 != null)
        {
          localObject2 = zzXP;
          localObject3 = zzXR;
          zzx.zzz(localObject1);
          zzx.zzz(localObject3);
          ((zzq)localObject2).zznq();
          ((zzq)localObject2).zzr("defaultSignInAccount", zzrG);
          if (zzXm != null) {
            ((zzq)localObject2).zzr("defaultGoogleSignInAccount", zzXm.zzWU);
          }
          zzx.zzz(localObject1);
          zzx.zzz(localObject3);
          String str = zzrG;
          SignInAccount localSignInAccount = ((zzq)localObject2).zzbP(str);
          if ((localSignInAccount != null) && (zzXm != null)) {
            ((zzq)localObject2).zzbU(zzXm.zzWU);
          }
          ((zzq)localObject2).zzr(zzq.zzs("signInConfiguration", str), ((SignInConfiguration)localObject3).zzmJ().toString());
          ((zzq)localObject2).zzr(zzq.zzs("signInAccount", str), ((SignInAccount)localObject1).zzmJ().toString());
          if (zzXm != null) {
            ((zzq)localObject2).zza(zzXm, zzXN);
          }
          localObject2 = paramIntent.getStringExtra("accessToken");
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(zzXU)))
          {
            localObject3 = new HashSet(Arrays.asList(TextUtils.split(zzXU, " ")));
            zzm.zzbN(zzrG).zza((Set)localObject3, new zzm.zza((String)localObject2, paramIntent.getLongExtra("accessTokenExpiresAtSecs", 0L)));
            paramIntent.removeExtra("accessTokenExpiresAtSecs");
          }
          setResult(-1, paramIntent);
          finish();
          return;
        }
        Log.w("AuthSignInClient", "[SignInHubActivity] SignInAccount is null.");
        zzaR(2);
        return;
      }
      if (paramIntent == null)
      {
        finish();
        return;
      }
      localObject1 = paramIntent.getStringExtra("email");
      Object localObject2 = zzd.zzbL(paramIntent.getStringExtra("idProvider"));
      if (localObject2 == null)
      {
        setResult(paramInt2, paramIntent);
        finish();
        return;
      }
      zzXT = paramIntent.getStringExtra("pendingToken");
      Object localObject3 = zzXQ;
      zzx.zzz(localObject2);
      localObject3 = (zzlf)zzXD.get(localObject2);
      if (localObject3 == null)
      {
        paramIntent = getResources().getString(zzXk);
        Log.w("AuthSignInClient", paramIntent + " is not supported. Please check your configuration");
        zzaR(1);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("idpAction", -1);
      if (paramInt1 == 0)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          ((zzlf)localObject3).zza(zzbO(zzXU));
          return;
        }
        ((zzlf)localObject3).zza((String)localObject1, zzbO(zzXU));
        return;
      }
      if ((paramInt1 == 1) && (!TextUtils.isEmpty(zzXT)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        ((zzlf)localObject3).zza((String)localObject1, zzXT, zzbO(zzXU));
        return;
      }
      Log.w("AuthSignInClient", "Internal error!");
      zzaR(2);
      return;
    }
    if (paramInt2 == 0)
    {
      setResult(0, paramIntent);
      finish();
      return;
    }
    Object localObject1 = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
    ((Intent)localObject1).putExtra("idpTokenType", IdpTokenType.zzXA);
    ((Intent)localObject1).putExtra("idpToken", paramIntent.getStringExtra("idpToken"));
    ((Intent)localObject1).putExtra("pendingToken", zzXT);
    ((Intent)localObject1).putExtra("idProvider", zzXizzXj);
    zzj((Intent)localObject1);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    zzXP = zzq.zzaf(this);
    Intent localIntent = getIntent();
    zzXR = ((SignInConfiguration)localIntent.getParcelableExtra("config"));
    zzXS = "com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(localIntent.getAction());
    zzXU = localIntent.getStringExtra("scopes");
    if (zzXR == null)
    {
      Log.e("AuthSignInClient", "Activity started with invalid configuration.");
      setResult(0);
      finish();
    }
    do
    {
      return;
      LinkedList localLinkedList = new LinkedList();
      Object localObject = new HashMap();
      zzi.zza(zzXR, localLinkedList, (Map)localObject);
      zzXQ = new zzk(this, localLinkedList, (Map)localObject);
      if (paramBundle == null)
      {
        if (zzXS)
        {
          localObject = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
          paramBundle = null;
        }
        while ((paramBundle != null) && (zzd.zzbL(zzXj) == zzd.zzXi))
        {
          zzbO(zzXU);
          throw new NullPointerException();
          localObject = new Intent("com.google.android.gms.auth.LOGIN_PICKER");
          if ("com.google.android.gms.auth.RESOLVE_CREDENTIAL".equals(localIntent.getAction()))
          {
            ((Intent)localObject).fillIn(localIntent, 3);
            paramBundle = (SignInAccount)localIntent.getParcelableExtra("signInAccount");
          }
          else
          {
            zzXP.zznq();
            paramBundle = null;
          }
        }
        zzj((Intent)localObject);
        return;
      }
      zzXT = paramBundle.getString("pendingToken");
      zzXV = paramBundle.getBoolean("signingInGoogleApiClients");
    } while (!zzXV);
    zzXW = paramBundle.getInt("signInResultCode");
    zzXX = ((Intent)paramBundle.getParcelable("signInResultData"));
    zzd$10b55c15();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("pendingToken", zzXT);
    paramBundle.putBoolean("signingInGoogleApiClients", zzXV);
    if (zzXV)
    {
      paramBundle.putInt("signInResultCode", zzXW);
      paramBundle.putParcelable("signInResultData", zzXX);
    }
  }
  
  private final class zza
    implements LoaderManager.LoaderCallbacks<Void>
  {
    private zza() {}
    
    public final Loader<Void> onCreateLoader$e57f803(int paramInt)
    {
      return new zzb(SignInHubActivity.this, GoogleApiClient.zzoV());
    }
    
    public final void onLoaderReset$5dda1f52() {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.SignInHubActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */