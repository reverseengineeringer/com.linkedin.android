package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;

@zzhb
public final class AdOverlayInfoParcel
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  public final int orientation;
  public final String url;
  public final int versionCode;
  public final AdLauncherIntentInfoParcel zzEA;
  public final zza zzEB;
  public final zzg zzEC;
  public final zzjp zzED;
  public final zzdb zzEE;
  public final String zzEF;
  public final boolean zzEG;
  public final String zzEH;
  public final zzp zzEI;
  public final int zzEJ;
  public final zzdh zzEK;
  public final String zzEL;
  public final InterstitialAdParameterParcel zzEM;
  public final VersionInfoParcel zzrl;
  
  AdOverlayInfoParcel(int paramInt1, AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, VersionInfoParcel paramVersionInfoParcel, IBinder paramIBinder6, String paramString4, InterstitialAdParameterParcel paramInterstitialAdParameterParcel)
  {
    versionCode = paramInt1;
    zzEA = paramAdLauncherIntentInfoParcel;
    zzEB = ((zza)zze.zzp(zzd.zza.zzbs(paramIBinder1)));
    zzEC = ((zzg)zze.zzp(zzd.zza.zzbs(paramIBinder2)));
    zzED = ((zzjp)zze.zzp(zzd.zza.zzbs(paramIBinder3)));
    zzEE = ((zzdb)zze.zzp(zzd.zza.zzbs(paramIBinder4)));
    zzEF = paramString1;
    zzEG = paramBoolean;
    zzEH = paramString2;
    zzEI = ((zzp)zze.zzp(zzd.zza.zzbs(paramIBinder5)));
    orientation = paramInt2;
    zzEJ = paramInt3;
    url = paramString3;
    zzrl = paramVersionInfoParcel;
    zzEK = ((zzdh)zze.zzp(zzd.zza.zzbs(paramIBinder6)));
    zzEL = paramString4;
    zzEM = paramInterstitialAdParameterParcel;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzp paramzzp, zzjp paramzzjp, boolean paramBoolean, int paramInt, VersionInfoParcel paramVersionInfoParcel)
  {
    versionCode = 4;
    zzEA = null;
    zzEB = paramzza;
    zzEC = paramzzg;
    zzED = paramzzjp;
    zzEE = null;
    zzEF = null;
    zzEG = paramBoolean;
    zzEH = null;
    zzEI = paramzzp;
    orientation = paramInt;
    zzEJ = 2;
    url = null;
    zzrl = paramVersionInfoParcel;
    zzEK = null;
    zzEL = null;
    zzEM = null;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzdb paramzzdb, zzp paramzzp, zzjp paramzzjp, boolean paramBoolean, int paramInt, String paramString, VersionInfoParcel paramVersionInfoParcel, zzdh paramzzdh)
  {
    versionCode = 4;
    zzEA = null;
    zzEB = paramzza;
    zzEC = paramzzg;
    zzED = paramzzjp;
    zzEE = paramzzdb;
    zzEF = null;
    zzEG = paramBoolean;
    zzEH = null;
    zzEI = paramzzp;
    orientation = paramInt;
    zzEJ = 3;
    url = paramString;
    zzrl = paramVersionInfoParcel;
    zzEK = paramzzdh;
    zzEL = null;
    zzEM = null;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzdb paramzzdb, zzp paramzzp, zzjp paramzzjp, boolean paramBoolean, int paramInt, String paramString1, String paramString2, VersionInfoParcel paramVersionInfoParcel, zzdh paramzzdh)
  {
    versionCode = 4;
    zzEA = null;
    zzEB = paramzza;
    zzEC = paramzzg;
    zzED = paramzzjp;
    zzEE = paramzzdb;
    zzEF = paramString2;
    zzEG = paramBoolean;
    zzEH = paramString1;
    zzEI = paramzzp;
    orientation = paramInt;
    zzEJ = 3;
    url = null;
    zzrl = paramVersionInfoParcel;
    zzEK = paramzzdh;
    zzEL = null;
    zzEM = null;
  }
  
  public AdOverlayInfoParcel(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, zza paramzza, zzg paramzzg, zzp paramzzp, VersionInfoParcel paramVersionInfoParcel)
  {
    versionCode = 4;
    zzEA = paramAdLauncherIntentInfoParcel;
    zzEB = paramzza;
    zzEC = paramzzg;
    zzED = null;
    zzEE = null;
    zzEF = null;
    zzEG = false;
    zzEH = null;
    zzEI = paramzzp;
    orientation = -1;
    zzEJ = 4;
    url = null;
    zzrl = paramVersionInfoParcel;
    zzEK = null;
    zzEL = null;
    zzEM = null;
  }
  
  public static void zza(Intent paramIntent, AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramAdOverlayInfoParcel);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }
  
  public static AdOverlayInfoParcel zzb(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      paramIntent.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
      paramIntent = (AdOverlayInfoParcel)paramIntent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */