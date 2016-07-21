package com.google.android.gms.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

@zzhb
public final class zzfm
  extends zzfs
{
  final Context mContext;
  String zzCU;
  long zzCV;
  long zzCW;
  String zzCX;
  String zzCY;
  private final Map<String, String> zzxA;
  
  public zzfm(zzjp paramzzjp, Map<String, String> paramMap)
  {
    super(paramzzjp, "createCalendarEvent");
    zzxA = paramMap;
    mContext = paramzzjp.zzhP();
    zzCU = zzaj("description");
    zzCX = zzaj("summary");
    zzCV = zzak("start_ticks");
    zzCW = zzak("end_ticks");
    zzCY = zzaj("location");
  }
  
  private String zzaj(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)zzxA.get(paramString))) {
      return "";
    }
    return (String)zzxA.get(paramString);
  }
  
  private long zzak(String paramString)
  {
    paramString = (String)zzxA.get(paramString);
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */