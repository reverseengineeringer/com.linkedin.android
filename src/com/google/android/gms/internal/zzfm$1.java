package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import com.google.android.gms.ads.internal.zzr;

final class zzfm$1
  implements DialogInterface.OnClickListener
{
  zzfm$1(zzfm paramzzfm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = zzCZ;
    Intent localIntent = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
    localIntent.putExtra("title", zzCU);
    localIntent.putExtra("eventLocation", zzCY);
    localIntent.putExtra("description", zzCX);
    if (zzCV > -1L) {
      localIntent.putExtra("beginTime", zzCV);
    }
    if (zzCW > -1L) {
      localIntent.putExtra("endTime", zzCW);
    }
    localIntent.setFlags(268435456);
    zzr.zzbC();
    zzir.zzb(zzCZ.mContext, localIntent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfm.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */