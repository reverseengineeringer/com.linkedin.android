package com.google.android.gms.internal;

import android.app.Activity;
import com.google.android.gms.common.internal.zzx;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class zzlg
  implements zzlf
{
  protected final Activity mActivity;
  private String zzWP;
  String zzXT;
  protected final Set<String> zzXf;
  zzlf.zza zzYe;
  
  protected zzlg(Activity paramActivity, List<String> paramList1, List<String> paramList2)
  {
    mActivity = ((Activity)zzx.zzz(paramActivity));
    paramActivity = new HashSet((Collection)zzx.zzz(paramList1));
    paramActivity.addAll((Collection)zzx.zzz(paramList2));
    zzXf = Collections.unmodifiableSet(paramActivity);
  }
  
  protected final void zzb(zzlf.zza paramzza)
  {
    zzYe = ((zzlf.zza)zzx.zzz(paramzza));
  }
  
  protected final void zzb(String paramString1, String paramString2, zzlf.zza paramzza)
  {
    zzWP = paramString1;
    zzXT = paramString2;
    zzb(paramzza);
  }
  
  protected final Set<String> zzns()
  {
    return zzXf;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */