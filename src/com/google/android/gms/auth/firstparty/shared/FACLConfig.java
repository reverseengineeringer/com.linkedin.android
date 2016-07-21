package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public class FACLConfig
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  final int version;
  boolean zzYm;
  String zzYn;
  boolean zzYo;
  boolean zzYp;
  boolean zzYq;
  boolean zzYr;
  
  FACLConfig(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    version = paramInt;
    zzYm = paramBoolean1;
    zzYn = paramString;
    zzYo = paramBoolean2;
    zzYp = paramBoolean3;
    zzYq = paramBoolean4;
    zzYr = paramBoolean5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof FACLConfig))
    {
      paramObject = (FACLConfig)paramObject;
      bool1 = bool2;
      if (zzYm == zzYm)
      {
        bool1 = bool2;
        if (TextUtils.equals(zzYn, zzYn))
        {
          bool1 = bool2;
          if (zzYo == zzYo)
          {
            bool1 = bool2;
            if (zzYp == zzYp)
            {
              bool1 = bool2;
              if (zzYq == zzYq)
              {
                bool1 = bool2;
                if (zzYr == zzYr) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Boolean.valueOf(zzYm), zzYn, Boolean.valueOf(zzYo), Boolean.valueOf(zzYp), Boolean.valueOf(zzYq), Boolean.valueOf(zzYr) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza$5331385a(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.FACLConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */