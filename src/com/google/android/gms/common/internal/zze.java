package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class zze
{
  public static final zze zzakF = zza("\t\n\013\f\r     　 ᠎ ").zza(zza(' ', ' '));
  public static final zze zzakG = zza("\t\n\013\f\r     　").zza(zza(' ', ' ')).zza(zza(' ', ' '));
  public static final zze zzakH = zza('\000', '');
  public static final zze zzakI;
  public static final zze zzakJ = zza('\t', '\r').zza(zza('\034', ' ')).zza(zzc(' ')).zza(zzc('᠎')).zza(zza(' ', ' ')).zza(zza(' ', '​')).zza(zza(' ', ' ')).zza(zzc(' ')).zza(zzc('　'));
  public static final zze zzakK = new zze()
  {
    public final boolean zzd(char paramAnonymousChar)
    {
      return Character.isDigit(paramAnonymousChar);
    }
  };
  public static final zze zzakL = new zze()
  {
    public final boolean zzd(char paramAnonymousChar)
    {
      return Character.isLetter(paramAnonymousChar);
    }
  };
  public static final zze zzakM = new zze()
  {
    public final boolean zzd(char paramAnonymousChar)
    {
      return Character.isLetterOrDigit(paramAnonymousChar);
    }
  };
  public static final zze zzakN = new zze()
  {
    public final boolean zzd(char paramAnonymousChar)
    {
      return Character.isUpperCase(paramAnonymousChar);
    }
  };
  public static final zze zzakO = new zze()
  {
    public final boolean zzd(char paramAnonymousChar)
    {
      return Character.isLowerCase(paramAnonymousChar);
    }
  };
  public static final zze zzakP = zza('\000', '\037').zza(zza('', ''));
  public static final zze zzakQ = zza('\000', ' ').zza(zza('', ' ')).zza(zzc('­')).zza(zza('؀', '؃')).zza(zza("۝܏ ឴឵᠎")).zza(zza(' ', '‏')).zza(zza(' ', ' ')).zza(zza(' ', '⁤')).zza(zza('⁪', '⁯')).zza(zzc('　')).zza(zza(55296, 63743)).zza(zza("﻿￹￺￻"));
  public static final zze zzakR = zza('\000', 'ӹ').zza(zzc('־')).zza(zza('א', 'ת')).zza(zzc('׳')).zza(zzc('״')).zza(zza('؀', 'ۿ')).zza(zza('ݐ', 'ݿ')).zza(zza('฀', '๿')).zza(zza('Ḁ', '₯')).zza(zza('℀', '℺')).zza(zza(64336, 65023)).zza(zza(65136, 65279)).zza(zza(65377, 65500));
  public static final zze zzakS = new zze()
  {
    public final zze zza(zze paramAnonymouszze)
    {
      zzx.zzz(paramAnonymouszze);
      return this;
    }
    
    public final boolean zzb(CharSequence paramAnonymousCharSequence)
    {
      zzx.zzz(paramAnonymousCharSequence);
      return true;
    }
    
    public final boolean zzd(char paramAnonymousChar)
    {
      return true;
    }
  };
  public static final zze zzakT = new zze()
  {
    public final zze zza(zze paramAnonymouszze)
    {
      return (zze)zzx.zzz(paramAnonymouszze);
    }
    
    public final boolean zzb(CharSequence paramAnonymousCharSequence)
    {
      return paramAnonymousCharSequence.length() == 0;
    }
    
    public final boolean zzd(char paramAnonymousChar)
    {
      return false;
    }
  };
  
  static
  {
    zze localzze = zza('0', '9');
    char[] arrayOfChar = "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
    int j = arrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = arrayOfChar[i];
      localzze = localzze.zza(zza(c, (char)(c + '\t')));
      i += 1;
    }
    zzakI = localzze;
  }
  
  private static zze zza(char paramChar1, final char paramChar2)
  {
    if (paramChar2 >= paramChar1) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzac(bool);
      new zze()
      {
        public final boolean zzd(char paramAnonymousChar)
        {
          return (zzakX <= paramAnonymousChar) && (paramAnonymousChar <= paramChar2);
        }
      };
    }
  }
  
  private static zze zza(CharSequence paramCharSequence)
  {
    switch (paramCharSequence.length())
    {
    default: 
      paramCharSequence = paramCharSequence.toString().toCharArray();
      Arrays.sort(paramCharSequence);
      new zze()
      {
        public final boolean zzd(char paramAnonymousChar)
        {
          return Arrays.binarySearch(zzakW, paramAnonymousChar) >= 0;
        }
      };
    case 0: 
      return zzakT;
    case 1: 
      return zzc(paramCharSequence.charAt(0));
    }
    new zze()
    {
      public final boolean zzd(char paramAnonymousChar)
      {
        return (paramAnonymousChar == zzakU) || (paramAnonymousChar == zzakV);
      }
    };
  }
  
  private static zze zzc(char paramChar)
  {
    new zze()
    {
      public final zze zza(zze paramAnonymouszze)
      {
        if (paramAnonymouszze.zzd(zzakZ)) {
          return paramAnonymouszze;
        }
        return super.zza(paramAnonymouszze);
      }
      
      public final boolean zzd(char paramAnonymousChar)
      {
        return paramAnonymousChar == zzakZ;
      }
    };
  }
  
  public zze zza(zze paramzze)
  {
    return new zza(Arrays.asList(new zze[] { this, (zze)zzx.zzz(paramzze) }));
  }
  
  public boolean zzb(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length() - 1;
    while (i >= 0)
    {
      if (!zzd(paramCharSequence.charAt(i))) {
        return false;
      }
      i -= 1;
    }
    return true;
  }
  
  public abstract boolean zzd(char paramChar);
  
  private static final class zza
    extends zze
  {
    List<zze> zzala;
    
    zza(List<zze> paramList)
    {
      zzala = paramList;
    }
    
    public final zze zza(zze paramzze)
    {
      ArrayList localArrayList = new ArrayList(zzala);
      localArrayList.add(zzx.zzz(paramzze));
      return new zza(localArrayList);
    }
    
    public final boolean zzd(char paramChar)
    {
      Iterator localIterator = zzala.iterator();
      while (localIterator.hasNext()) {
        if (((zze)localIterator.next()).zzd(paramChar)) {
          return true;
        }
      }
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */