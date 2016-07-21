package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.R.string;

public final class GoogleApiAvailability
  extends zzc
{
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  private static final GoogleApiAvailability zzafE = new GoogleApiAvailability();
  
  public static GoogleApiAvailability getInstance()
  {
    return zzafE;
  }
  
  public static Dialog zza(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Object localObject2 = new ProgressBar(paramActivity, null, 16842874);
    ((ProgressBar)localObject2).setIndeterminate(true);
    ((ProgressBar)localObject2).setVisibility(0);
    Object localObject1 = new AlertDialog.Builder(paramActivity);
    ((AlertDialog.Builder)localObject1).setView((View)localObject2);
    localObject2 = GooglePlayServicesUtil.zzao(paramActivity);
    ((AlertDialog.Builder)localObject1).setMessage(paramActivity.getResources().getString(R.string.common_google_play_services_updating_text, new Object[] { localObject2 }));
    ((AlertDialog.Builder)localObject1).setTitle(R.string.common_google_play_services_updating_title);
    ((AlertDialog.Builder)localObject1).setPositiveButton("", null);
    localObject1 = ((AlertDialog.Builder)localObject1).create();
    GooglePlayServicesUtil.zza(paramActivity, paramOnCancelListener, "GooglePlayServicesUpdatingDialog", (Dialog)localObject1);
    return (Dialog)localObject1;
  }
  
  public final PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    return super.getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  public final int isGooglePlayServicesAvailable(Context paramContext)
  {
    return super.isGooglePlayServicesAvailable(paramContext);
  }
  
  public final boolean isUserResolvableError(int paramInt)
  {
    return super.isUserResolvableError(paramInt);
  }
  
  public final PendingIntent zza(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    return super.zza(paramContext, paramInt1, paramInt2, paramString);
  }
  
  public final Intent zza(Context paramContext, int paramInt, String paramString)
  {
    return super.zza(paramContext, paramInt, paramString);
  }
  
  @Deprecated
  public final Intent zzbu(int paramInt)
  {
    return super.zzbu(paramInt);
  }
  
  public final boolean zzd(Context paramContext, int paramInt)
  {
    return super.zzd(paramContext, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.GoogleApiAvailability
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */