package com.google.android.gms.auth.api.credentials;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class PasswordSpecification$zza
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

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.PasswordSpecification.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */