package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  public static final PasswordSpecification zzWl = new zza().zzh$3e63f106().zzbG("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zze$6bc52feb("abcdefghijkmnopqrstxyz").zze$6bc52feb("ABCDEFGHJKLMNPQRSTXY").zze$6bc52feb("3456789").zzmA();
  public static final PasswordSpecification zzWm = new zza().zzh$3e63f106().zzbG("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zze$6bc52feb("abcdefghijklmnopqrstuvwxyz").zze$6bc52feb("ABCDEFGHIJKLMNOPQRSTUVWXYZ").zze$6bc52feb("1234567890").zzmA();
  final int mVersionCode;
  final String zzWn;
  final List<String> zzWo;
  final List<Integer> zzWp;
  final int zzWq;
  final int zzWr;
  private final int[] zzWs;
  private final Random zzuy;
  
  PasswordSpecification(int paramInt1, String paramString, List<String> paramList, List<Integer> paramList1, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    zzWn = paramString;
    zzWo = Collections.unmodifiableList(paramList);
    zzWp = Collections.unmodifiableList(paramList1);
    zzWq = paramInt2;
    zzWr = paramInt3;
    zzWs = zzmz();
    zzuy = new SecureRandom();
  }
  
  private int[] zzmz()
  {
    int[] arrayOfInt = new int[95];
    Arrays.fill(arrayOfInt, -1);
    Iterator localIterator = zzWo.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      char[] arrayOfChar = ((String)localIterator.next()).toCharArray();
      int k = arrayOfChar.length;
      int j = 0;
      while (j < k)
      {
        arrayOfInt[(arrayOfChar[j] - ' ')] = i;
        j += 1;
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza$18e098bf(this, paramParcel);
  }
  
  public static final class zza
  {
    private final List<String> zzWo = new ArrayList();
    private final List<Integer> zzWp = new ArrayList();
    private int zzWq = 12;
    private int zzWr = 16;
    private final TreeSet<Character> zzWt = new TreeSet();
    
    private static TreeSet<Character> zzq(String paramString1, String paramString2)
    {
      if (TextUtils.isEmpty(paramString1)) {
        throw new PasswordSpecification.zzb(paramString2 + " cannot be null or empty");
      }
      TreeSet localTreeSet = new TreeSet();
      paramString1 = paramString1.toCharArray();
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        char c = paramString1[i];
        if (PasswordSpecification.zzc$4868d312(c)) {
          throw new PasswordSpecification.zzb(paramString2 + " must only contain ASCII printable characters");
        }
        localTreeSet.add(Character.valueOf(c));
        i += 1;
      }
      return localTreeSet;
    }
    
    public final zza zzbG(String paramString)
    {
      zzWt.addAll(zzq(paramString, "allowedChars"));
      return this;
    }
    
    public final zza zze$6bc52feb(String paramString)
    {
      paramString = zzq(paramString, "requiredChars");
      zzWo.add(PasswordSpecification.zzc(paramString));
      zzWp.add(Integer.valueOf(1));
      return this;
    }
    
    public final zza zzh$3e63f106()
    {
      zzWq = 12;
      zzWr = 16;
      return this;
    }
    
    public final PasswordSpecification zzmA()
    {
      if (zzWt.isEmpty()) {
        throw new PasswordSpecification.zzb("no allowed characters specified");
      }
      Object localObject = zzWp.iterator();
      for (int i = 0; ((Iterator)localObject).hasNext(); i = ((Integer)((Iterator)localObject).next()).intValue() + i) {}
      if (i > zzWr) {
        throw new PasswordSpecification.zzb("required character count cannot be greater than the max password size");
      }
      localObject = new boolean[95];
      Iterator localIterator = zzWo.iterator();
      while (localIterator.hasNext())
      {
        char[] arrayOfChar = ((String)localIterator.next()).toCharArray();
        int j = arrayOfChar.length;
        i = 0;
        while (i < j)
        {
          char c = arrayOfChar[i];
          if (localObject[(c - ' ')] != 0) {
            throw new PasswordSpecification.zzb("character " + c + " occurs in more than one required character set");
          }
          localObject[(c - ' ')] = 1;
          i += 1;
        }
      }
      return new PasswordSpecification(1, PasswordSpecification.zzc(zzWt), zzWo, zzWp, zzWq, zzWr);
    }
  }
  
  public static final class zzb
    extends Error
  {
    public zzb(String paramString)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.PasswordSpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */