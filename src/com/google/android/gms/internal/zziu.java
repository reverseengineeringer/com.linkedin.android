package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzr;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@zzhb
public final class zziu
{
  final Context mContext;
  private int mState = 0;
  private final float zzDB;
  private String zzMh;
  private float zzMi;
  private float zzMj;
  private float zzMk;
  
  private zziu(Context paramContext)
  {
    mContext = paramContext;
    zzDB = getResourcesgetDisplayMetricsdensity;
  }
  
  public zziu(Context paramContext, String paramString)
  {
    this(paramContext);
    zzMh = paramString;
  }
  
  public final void zza(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramInt == 0)
    {
      mState = 0;
      zzMi = paramFloat1;
      zzMj = paramFloat2;
      zzMk = paramFloat2;
    }
    label24:
    label224:
    do
    {
      do
      {
        break label24;
        do
        {
          return;
        } while (mState == -1);
        if (paramInt != 2) {
          break;
        }
        if (paramFloat2 > zzMj) {
          zzMj = paramFloat2;
        }
        while (zzMj - zzMk > 30.0F * zzDB)
        {
          mState = -1;
          return;
          if (paramFloat2 < zzMk) {
            zzMk = paramFloat2;
          }
        }
        if ((mState == 0) || (mState == 2)) {
          if (paramFloat1 - zzMi >= 50.0F * zzDB) {
            zzMi = paramFloat1;
          }
        }
        for (mState += 1;; mState += 1)
        {
          do
          {
            if ((mState != 1) && (mState != 3)) {
              break label224;
            }
            if (paramFloat1 <= zzMi) {
              break;
            }
            zzMi = paramFloat1;
            return;
          } while (((mState != 1) && (mState != 3)) || (paramFloat1 - zzMi > -50.0F * zzDB));
          zzMi = paramFloat1;
        }
      } while ((mState != 2) || (paramFloat1 >= zzMi));
      zzMi = paramFloat1;
      return;
    } while ((paramInt != 1) || (mState != 4));
    if (!(mContext instanceof Activity))
    {
      zzin.zzaJ("Can not create dialog without Activity Context");
      return;
    }
    final Object localObject1 = zzMh;
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).replaceAll("\\+", "%20");
      localObject2 = new Uri.Builder().encodedQuery((String)localObject1).build();
      localObject1 = new StringBuilder();
      zzr.zzbC();
      localObject2 = zzir.zze((Uri)localObject2);
      Iterator localIterator = ((Map)localObject2).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((StringBuilder)localObject1).append(str).append(" = ").append((String)((Map)localObject2).get(str)).append("\n\n");
      }
      localObject1 = ((StringBuilder)localObject1).toString().trim();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    for (;;)
    {
      localObject2 = new AlertDialog.Builder(mContext);
      ((AlertDialog.Builder)localObject2).setMessage((CharSequence)localObject1);
      ((AlertDialog.Builder)localObject2).setTitle("Ad Information");
      ((AlertDialog.Builder)localObject2).setPositiveButton("Share", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          zzr.zzbC();
          zzir.zzb(mContext, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", localObject1), "Share via"));
        }
      });
      ((AlertDialog.Builder)localObject2).setNegativeButton("Close", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      ((AlertDialog.Builder)localObject2).create().show();
      return;
      localObject1 = "No debug information";
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */