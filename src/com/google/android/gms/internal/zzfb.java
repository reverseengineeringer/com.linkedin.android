package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import java.util.ArrayList;
import java.util.List;

public abstract interface zzfb
  extends IInterface
{
  public abstract String getBody()
    throws RemoteException;
  
  public abstract String getCallToAction()
    throws RemoteException;
  
  public abstract Bundle getExtras()
    throws RemoteException;
  
  public abstract String getHeadline()
    throws RemoteException;
  
  public abstract List getImages()
    throws RemoteException;
  
  public abstract boolean getOverrideClickHandling()
    throws RemoteException;
  
  public abstract boolean getOverrideImpressionRecording()
    throws RemoteException;
  
  public abstract String getPrice()
    throws RemoteException;
  
  public abstract double getStarRating()
    throws RemoteException;
  
  public abstract String getStore()
    throws RemoteException;
  
  public abstract void recordImpression()
    throws RemoteException;
  
  public abstract void zzc(zzd paramzzd)
    throws RemoteException;
  
  public abstract void zzd(zzd paramzzd)
    throws RemoteException;
  
  public abstract zzch zzdK()
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzfb
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }
    
    public static zzfb zzI(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
      if ((localIInterface != null) && ((localIInterface instanceof zzfb))) {
        return (zzfb)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      int j = 0;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        paramParcel1 = getHeadline();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        paramParcel1 = getImages();
        paramParcel2.writeNoException();
        paramParcel2.writeList(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        paramParcel1 = getBody();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        paramParcel1 = zzdK();
        paramParcel2.writeNoException();
        if (paramParcel1 != null) {}
        for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
        }
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        paramParcel1 = getCallToAction();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        double d = getStarRating();
        paramParcel2.writeNoException();
        paramParcel2.writeDouble(d);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        paramParcel1 = getStore();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        paramParcel1 = getPrice();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        recordImpression();
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        zzc(zzd.zza.zzbs(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        zzd(zzd.zza.zzbs(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        bool = getOverrideImpressionRecording();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        bool = getOverrideClickHandling();
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
      paramParcel1 = getExtras();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }
    
    private static final class zza
      implements zzfb
    {
      private IBinder zzoz;
      
      zza(IBinder paramIBinder)
      {
        zzoz = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return zzoz;
      }
      
      public final String getBody()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
          zzoz.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final String getCallToAction()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
          zzoz.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public final Bundle getExtras()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 33
        //   11: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/internal/zzfb$zza$zza:zzoz	Landroid/os/IBinder;
        //   18: bipush 15
        //   20: aload_2
        //   21: aload_3
        //   22: iconst_0
        //   23: invokeinterface 43 5 0
        //   28: pop
        //   29: aload_3
        //   30: invokevirtual 46	android/os/Parcel:readException	()V
        //   33: aload_3
        //   34: invokevirtual 60	android/os/Parcel:readInt	()I
        //   37: ifeq +26 -> 63
        //   40: getstatic 66	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   43: aload_3
        //   44: invokeinterface 72 2 0
        //   49: checkcast 62	android/os/Bundle
        //   52: astore_1
        //   53: aload_3
        //   54: invokevirtual 52	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 52	android/os/Parcel:recycle	()V
        //   61: aload_1
        //   62: areturn
        //   63: aconst_null
        //   64: astore_1
        //   65: goto -12 -> 53
        //   68: astore_1
        //   69: aload_3
        //   70: invokevirtual 52	android/os/Parcel:recycle	()V
        //   73: aload_2
        //   74: invokevirtual 52	android/os/Parcel:recycle	()V
        //   77: aload_1
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	zza
        //   52	13	1	localBundle	Bundle
        //   68	10	1	localObject	Object
        //   3	71	2	localParcel1	Parcel
        //   7	63	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	53	68	finally
      }
      
      public final String getHeadline()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
          zzoz.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final List getImages()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
          zzoz.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          ArrayList localArrayList = localParcel2.readArrayList(getClass().getClassLoader());
          return localArrayList;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final boolean getOverrideClickHandling()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
          zzoz.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final boolean getOverrideImpressionRecording()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
          zzoz.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final String getPrice()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
          zzoz.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final double getStarRating()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
          zzoz.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          double d = localParcel2.readDouble();
          return d;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final String getStore()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
          zzoz.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void recordImpression()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
          zzoz.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public final void zzc(zzd paramzzd)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 33
        //   11: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 106 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 109	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/internal/zzfb$zza$zza:zzoz	Landroid/os/IBinder;
        //   34: bipush 11
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 43 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 46	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 52	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 52	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 52	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 52	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	zza
        //   0	74	1	paramzzd	zzd
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      /* Error */
      public final void zzd(zzd paramzzd)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 33
        //   11: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 106 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 109	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/internal/zzfb$zza$zza:zzoz	Landroid/os/IBinder;
        //   34: bipush 12
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 43 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 46	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 52	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 52	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 52	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 52	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	zza
        //   0	74	1	paramzzd	zzd
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      public final zzch zzdK()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
          zzoz.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzch localzzch = zzch.zza.zzt(localParcel2.readStrongBinder());
          return localzzch;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */