package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

public abstract class zzso<M extends zzso<M>>
  extends zzsu
{
  protected zzsq zzbuj;
  
  private M zzJp()
    throws CloneNotSupportedException
  {
    zzso localzzso = (zzso)super.clone();
    zzss.zza(this, localzzso);
    return localzzso;
  }
  
  public void writeTo(zzsn paramzzsn)
    throws IOException
  {
    if (zzbuj == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < zzbuj.size())
      {
        zzbuj.zzmG(i).writeTo(paramzzsn);
        i += 1;
      }
    }
  }
  
  protected final boolean zza(zzsm paramzzsm, int paramInt)
    throws IOException
  {
    int i = paramzzsm.getPosition();
    if (!paramzzsm.zzmo(paramInt)) {
      return false;
    }
    int j = zzsx.zzmJ(paramInt);
    int k = paramzzsm.getPosition() - i;
    zzsw localzzsw;
    label69:
    Object localObject;
    if (k == 0)
    {
      paramzzsm = zzsx.zzbuD;
      localzzsw = new zzsw(paramInt, paramzzsm);
      if (zzbuj != null) {
        break label162;
      }
      zzbuj = new zzsq();
      paramzzsm = null;
      localObject = paramzzsm;
      if (paramzzsm == null)
      {
        paramzzsm = new zzsr();
        localObject = zzbuj;
        paramInt = ((zzsq)localObject).zzmH(j);
        if (paramInt < 0) {
          break label205;
        }
        zzbup[paramInt] = paramzzsm;
        localObject = paramzzsm;
      }
    }
    for (;;)
    {
      zzbus.add(localzzsw);
      return true;
      localObject = new byte[k];
      int m = zzbtZ;
      System.arraycopy(buffer, i + m, localObject, 0, k);
      paramzzsm = (zzsm)localObject;
      break;
      label162:
      paramzzsm = zzbuj;
      paramInt = paramzzsm.zzmH(j);
      if ((paramInt < 0) || (zzbup[paramInt] == zzsq.zzbum))
      {
        paramzzsm = null;
        break label69;
      }
      paramzzsm = zzbup[paramInt];
      break label69;
      label205:
      i = paramInt ^ 0xFFFFFFFF;
      if ((i < mSize) && (zzbup[i] == zzsq.zzbum))
      {
        zzbuo[i] = j;
        zzbup[i] = paramzzsm;
        localObject = paramzzsm;
      }
      else
      {
        paramInt = i;
        if (zzbun)
        {
          paramInt = i;
          if (mSize >= zzbuo.length)
          {
            ((zzsq)localObject).gc();
            paramInt = ((zzsq)localObject).zzmH(j) ^ 0xFFFFFFFF;
          }
        }
        if (mSize >= zzbuo.length)
        {
          i = zzsq.idealIntArraySize(mSize + 1);
          int[] arrayOfInt = new int[i];
          zzsr[] arrayOfzzsr = new zzsr[i];
          System.arraycopy(zzbuo, 0, arrayOfInt, 0, zzbuo.length);
          System.arraycopy(zzbup, 0, arrayOfzzsr, 0, zzbup.length);
          zzbuo = arrayOfInt;
          zzbup = arrayOfzzsr;
        }
        if (mSize - paramInt != 0)
        {
          System.arraycopy(zzbuo, paramInt, zzbuo, paramInt + 1, mSize - paramInt);
          System.arraycopy(zzbup, paramInt, zzbup, paramInt + 1, mSize - paramInt);
        }
        zzbuo[paramInt] = j;
        zzbup[paramInt] = paramzzsm;
        mSize += 1;
        localObject = paramzzsm;
      }
    }
  }
  
  protected int zzz()
  {
    int j = 0;
    if (zzbuj != null)
    {
      int i = 0;
      for (;;)
      {
        k = i;
        if (j >= zzbuj.size()) {
          break;
        }
        i += zzbuj.zzmG(j).zzz();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzso
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */