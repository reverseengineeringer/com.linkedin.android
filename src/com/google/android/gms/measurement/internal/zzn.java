package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.measurement.zza;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public final class zzn
  extends zzz
{
  private static final X500Principal zzaWz = new X500Principal("CN=Android Debug,O=Android,C=US");
  private String zzSE;
  private String zzSF;
  private String zzaUa;
  private String zzaVd;
  private String zzaVi;
  private long zzaWA;
  
  zzn(zzw paramzzw)
  {
    super(paramzzw);
  }
  
  private boolean zzCD()
  {
    try
    {
      Object localObject = super.getContext().getPackageManager().getPackageInfo(super.getContext().getPackageName(), 64);
      if ((localObject != null) && (signatures != null) && (signatures.length > 0))
      {
        localObject = signatures[0];
        boolean bool = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(((Signature)localObject).toByteArray()))).getSubjectX500Principal().equals(zzaWz);
        return bool;
      }
    }
    catch (CertificateException localCertificateException)
    {
      zzAozzaWC.zzj("Error obtaining certificate", localCertificateException);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        zzAozzaWC.zzj("Package name not found", localNameNotFoundException);
      }
    }
  }
  
  final String zzBk()
  {
    zzjv();
    return zzaVd;
  }
  
  final AppMetadata zzfe(String paramString)
  {
    zzjv();
    String str1 = zzaUa;
    String str2 = zzBk();
    zzjv();
    String str3 = zzSF;
    zzjv();
    String str4 = zzaVi;
    long l1 = zzd.zzBp();
    zzjv();
    long l2 = zzaWA;
    boolean bool2 = super.zzCo().zzAr();
    if (!zzCozzaXx) {}
    for (boolean bool1 = true;; bool1 = false) {
      return new AppMetadata(str1, str2, str3, str4, l1, l2, paramString, bool2, bool1);
    }
  }
  
  protected final void zziJ()
  {
    String str2 = "Unknown";
    String str1 = "Unknown";
    PackageManager localPackageManager = super.getContext().getPackageManager();
    String str3 = super.getContext().getPackageName();
    Object localObject1 = localPackageManager.getInstallerPackageName(str3);
    Object localObject3;
    if (localObject1 == null) {
      localObject3 = "manual_install";
    }
    Object localObject4;
    for (;;)
    {
      localObject4 = str1;
      try
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo(super.getContext().getPackageName(), 0);
        localObject1 = str1;
        localObject4 = str2;
        if (localPackageInfo != null)
        {
          localObject4 = str1;
          CharSequence localCharSequence = localPackageManager.getApplicationLabel(applicationInfo);
          localObject1 = str1;
          localObject4 = str1;
          if (!TextUtils.isEmpty(localCharSequence))
          {
            localObject4 = str1;
            localObject1 = localCharSequence.toString();
          }
          localObject4 = localObject1;
          str1 = versionName;
          localObject4 = str1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        for (;;)
        {
          zzAozzaWC.zzj("Error retrieving package info: appName", localObject4);
          localObject2 = localObject4;
          localObject4 = str2;
          continue;
          zzaWA = 0L;
          try
          {
            if (zzCD()) {
              continue;
            }
            localObject3 = localPackageManager.getPackageInfo(super.getContext().getPackageName(), 64);
            if ((signatures == null) || (signatures.length <= 0)) {
              continue;
            }
            zzaWA = zzaj.zzq(((MessageDigest)localObject2).digest(signatures[0].toByteArray()));
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException2)
          {
            zzAozzaWC.zzj("Package name not found", localNameNotFoundException2);
          }
          continue;
          localStatus = zza.zzaR(super.getContext());
          continue;
          int i = 0;
          continue;
          zzAozzaWC.zze("GoogleService failed to initialize, status", Integer.valueOf(zzade), zzafC);
          continue;
          zzAozzaWI.zzfg("AppMeasurement disabled with google_app_measurement_enable=0");
          continue;
          boolean bool = false;
        }
      }
      zzaUa = str3;
      zzaVi = ((String)localObject3);
      zzSF = ((String)localObject4);
      zzSE = ((String)localObject1);
      localObject1 = zzaj.zzbv("MD5");
      if (localObject1 != null) {
        break;
      }
      zzAozzaWC.zzfg("Could not get MD5 instance");
      zzaWA = -1L;
      if (!zzd.zzkr()) {
        break label455;
      }
      localObject1 = zza.zzb$6a9fa3ad(super.getContext(), "-");
      if ((localObject1 == null) || (!((Status)localObject1).isSuccess())) {
        break label466;
      }
      i = 1;
      if (i == 0)
      {
        if (localObject1 != null) {
          break label471;
        }
        zzAozzaWC.zzfg("GoogleService failed to initialize (no status)");
      }
      if (i == 0) {
        break label514;
      }
      bool = zza.zzAr();
      if (!bool) {
        break label498;
      }
      zzAozzaWK.zzfg("AppMeasurement enabled");
      zzaVd = "";
      if (!zzd.zzkr()) {}
      try
      {
        localObject3 = zza.zzAp();
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = "";
        }
        zzaVd = ((String)localObject1);
        if (bool) {
          zzAozzaWK.zze("App package, google app id", zzaUa, zzaVd);
        }
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Object localObject2;
        Status localStatus;
        zzAozzaWC.zzj("getGoogleAppId or isMeasurementEnabled failed with exception", localIllegalStateException);
      }
      localObject3 = localObject1;
      if ("com.android.vending".equals(localObject1)) {
        localObject3 = "";
      }
    }
    label455:
    label466:
    label471:
    label498:
    label514:
    return;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */