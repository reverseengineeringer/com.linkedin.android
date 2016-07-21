package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;

final class zza
{
  private String zzSF;
  final zzw zzaTV;
  private final String zzaUa;
  private String zzaVc;
  private String zzaVd;
  private String zzaVe;
  long zzaVf;
  private long zzaVg;
  private long zzaVh;
  private String zzaVi;
  private long zzaVj;
  private long zzaVk;
  private boolean zzaVl;
  long zzaVm;
  long zzaVn;
  long zzaVo;
  long zzaVp;
  boolean zzaVq;
  long zzaVr;
  long zzaVs;
  
  zza(zzw paramzzw, String paramString)
  {
    zzx.zzz(paramzzw);
    zzx.zzcM(paramString);
    zzaTV = paramzzw;
    zzaUa = paramString;
    zzaTV.zzCn().zzjk();
  }
  
  public final void setAppVersion(String paramString)
  {
    zzaTV.zzCn().zzjk();
    zzaVq |= zzaj.zzQ(zzSF, paramString);
    zzSF = paramString;
  }
  
  public final void setMeasurementEnabled(boolean paramBoolean)
  {
    zzaTV.zzCn().zzjk();
    boolean bool2 = zzaVq;
    if (zzaVl != paramBoolean) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzaVq = (bool1 | bool2);
      zzaVl = paramBoolean;
      return;
    }
  }
  
  public final boolean zzAr()
  {
    zzaTV.zzCn().zzjk();
    return zzaVl;
  }
  
  public final String zzBj()
  {
    zzaTV.zzCn().zzjk();
    return zzaVc;
  }
  
  public final String zzBk()
  {
    zzaTV.zzCn().zzjk();
    return zzaVd;
  }
  
  public final String zzBl()
  {
    zzaTV.zzCn().zzjk();
    return zzaVe;
  }
  
  public final long zzBm()
  {
    zzaTV.zzCn().zzjk();
    return zzaVg;
  }
  
  public final long zzBn()
  {
    zzaTV.zzCn().zzjk();
    return zzaVh;
  }
  
  public final String zzBo()
  {
    zzaTV.zzCn().zzjk();
    return zzaVi;
  }
  
  public final long zzBp()
  {
    zzaTV.zzCn().zzjk();
    return zzaVj;
  }
  
  public final long zzBq()
  {
    zzaTV.zzCn().zzjk();
    return zzaVk;
  }
  
  public final long zzBr()
  {
    zzaTV.zzCn().zzjk();
    return zzaVf;
  }
  
  public final void zzO(long paramLong)
  {
    zzaTV.zzCn().zzjk();
    boolean bool2 = zzaVq;
    if (zzaVg != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzaVq = (bool1 | bool2);
      zzaVg = paramLong;
      return;
    }
  }
  
  public final void zzP(long paramLong)
  {
    zzaTV.zzCn().zzjk();
    boolean bool2 = zzaVq;
    if (zzaVh != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzaVq = (bool1 | bool2);
      zzaVh = paramLong;
      return;
    }
  }
  
  public final void zzQ(long paramLong)
  {
    zzaTV.zzCn().zzjk();
    boolean bool2 = zzaVq;
    if (zzaVj != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzaVq = (bool1 | bool2);
      zzaVj = paramLong;
      return;
    }
  }
  
  public final void zzR(long paramLong)
  {
    zzaTV.zzCn().zzjk();
    boolean bool2 = zzaVq;
    if (zzaVk != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzaVq = (bool1 | bool2);
      zzaVk = paramLong;
      return;
    }
  }
  
  public final void zzS(long paramLong)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramLong >= 0L)
    {
      bool2 = true;
      zzx.zzac(bool2);
      zzaTV.zzCn().zzjk();
      bool2 = zzaVq;
      if (zzaVf == paramLong) {
        break label61;
      }
    }
    for (;;)
    {
      zzaVq = (bool2 | bool1);
      zzaVf = paramLong;
      return;
      bool2 = false;
      break;
      label61:
      bool1 = false;
    }
  }
  
  public final void zzT(long paramLong)
  {
    zzaTV.zzCn().zzjk();
    boolean bool2 = zzaVq;
    if (zzaVr != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzaVq = (bool1 | bool2);
      zzaVr = paramLong;
      return;
    }
  }
  
  public final void zzU(long paramLong)
  {
    zzaTV.zzCn().zzjk();
    boolean bool2 = zzaVq;
    if (zzaVs != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzaVq = (bool1 | bool2);
      zzaVs = paramLong;
      return;
    }
  }
  
  public final void zzeM(String paramString)
  {
    zzaTV.zzCn().zzjk();
    zzaVq |= zzaj.zzQ(zzaVc, paramString);
    zzaVc = paramString;
  }
  
  public final void zzeN(String paramString)
  {
    zzaTV.zzCn().zzjk();
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    zzaVq |= zzaj.zzQ(zzaVd, str);
    zzaVd = str;
  }
  
  public final void zzeO(String paramString)
  {
    zzaTV.zzCn().zzjk();
    zzaVq |= zzaj.zzQ(zzaVe, paramString);
    zzaVe = paramString;
  }
  
  public final void zzeP(String paramString)
  {
    zzaTV.zzCn().zzjk();
    zzaVq |= zzaj.zzQ(zzaVi, paramString);
    zzaVi = paramString;
  }
  
  public final String zzli()
  {
    zzaTV.zzCn().zzjk();
    return zzSF;
  }
  
  public final String zzwK()
  {
    zzaTV.zzCn().zzjk();
    return zzaUa;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */