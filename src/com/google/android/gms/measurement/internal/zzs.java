package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpz.zzd;

final class zzs
{
  final boolean zzaWY;
  final int zzaWZ;
  long zzaXa;
  float zzaXb;
  long zzaXc;
  float zzaXd;
  long zzaXe;
  float zzaXf;
  final boolean zzaXg;
  
  public zzs(zzpz.zzd paramzzd)
  {
    zzx.zzz(paramzzd);
    boolean bool1;
    if ((zzaZF == null) || (zzaZF.intValue() == 0))
    {
      bool1 = false;
      if (!bool1) {
        break label220;
      }
      zzaWZ = zzaZF.intValue();
      if ((zzaZG == null) || (!zzaZG.booleanValue())) {
        break label155;
      }
      label62:
      zzaWY = bool2;
      if (zzaZF.intValue() != 4) {
        break label185;
      }
      if (!zzaWY) {
        break label160;
      }
      zzaXd = Float.parseFloat(zzaZI);
      zzaXf = Float.parseFloat(zzaZJ);
    }
    for (;;)
    {
      zzaXg = bool1;
      return;
      if (zzaZF.intValue() != 4)
      {
        if (zzaZH != null) {}
      }
      else {
        while ((zzaZI == null) || (zzaZJ == null))
        {
          bool1 = false;
          break;
        }
      }
      bool1 = true;
      break;
      label155:
      bool2 = false;
      break label62;
      label160:
      zzaXc = Long.parseLong(zzaZI);
      zzaXe = Long.parseLong(zzaZJ);
      continue;
      label185:
      if (zzaWY)
      {
        zzaXb = Float.parseFloat(zzaZH);
      }
      else
      {
        zzaXa = Long.parseLong(zzaZH);
        continue;
        label220:
        zzaWZ = 0;
        zzaWY = false;
      }
    }
  }
  
  public final Boolean zzac(long paramLong)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    if (!zzaXg) {
      return null;
    }
    if (zzaWY) {
      return null;
    }
    switch (zzaWZ)
    {
    default: 
      return null;
    case 1: 
      if (paramLong < zzaXa) {}
      for (;;)
      {
        return Boolean.valueOf(bool1);
        bool1 = false;
      }
    case 2: 
      if (paramLong > zzaXa) {}
      for (bool1 = bool2;; bool1 = false) {
        return Boolean.valueOf(bool1);
      }
    case 3: 
      if (paramLong == zzaXa) {}
      for (bool1 = bool3;; bool1 = false) {
        return Boolean.valueOf(bool1);
      }
    }
    if ((paramLong >= zzaXc) && (paramLong <= zzaXe)) {}
    for (bool1 = bool4;; bool1 = false) {
      return Boolean.valueOf(bool1);
    }
  }
  
  public final Boolean zzi(float paramFloat)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    if (!zzaXg) {
      return null;
    }
    if (!zzaWY) {
      return null;
    }
    switch (zzaWZ)
    {
    default: 
      return null;
    case 1: 
      if (paramFloat < zzaXb) {}
      for (;;)
      {
        return Boolean.valueOf(bool1);
        bool1 = false;
      }
    case 2: 
      if (paramFloat > zzaXb) {}
      for (bool1 = bool3;; bool1 = false) {
        return Boolean.valueOf(bool1);
      }
    case 3: 
      if (paramFloat != zzaXb)
      {
        bool1 = bool2;
        if (Math.abs(paramFloat - zzaXb) >= 2.0F * Math.max(Math.ulp(paramFloat), Math.ulp(zzaXb))) {}
      }
      else
      {
        bool1 = true;
      }
      return Boolean.valueOf(bool1);
    }
    if ((paramFloat >= zzaXd) && (paramFloat <= zzaXf)) {}
    for (bool1 = bool4;; bool1 = false) {
      return Boolean.valueOf(bool1);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */