package com.google.android.gms.common;

import com.google.android.gms.common.internal.zzx;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Arrays;

final class zzd
{
  static abstract class zza
  {
    private int zzafG;
    
    protected zza(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte.length == 25) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "cert hash data has incorrect length");
        zzafG = Arrays.hashCode(paramArrayOfByte);
        return;
      }
    }
    
    protected static byte[] zzcs(String paramString)
    {
      try
      {
        paramString = paramString.getBytes("ISO-8859-1");
        return paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new AssertionError(paramString);
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof zza))) {
        return false;
      }
      paramObject = (zza)paramObject;
      return Arrays.equals(getBytes(), ((zza)paramObject).getBytes());
    }
    
    abstract byte[] getBytes();
    
    public int hashCode()
    {
      return zzafG;
    }
  }
  
  static final class zzb
    extends zzd.zza
  {
    private final byte[] zzafH;
    
    zzb(byte[] paramArrayOfByte)
    {
      super();
      zzafH = paramArrayOfByte;
    }
    
    final byte[] getBytes()
    {
      return zzafH;
    }
  }
  
  static abstract class zzc
    extends zzd.zza
  {
    private static final WeakReference<byte[]> zzafJ = new WeakReference(null);
    private WeakReference<byte[]> zzafI = zzafJ;
    
    zzc(byte[] paramArrayOfByte)
    {
      super();
    }
    
    final byte[] getBytes()
    {
      try
      {
        byte[] arrayOfByte2 = (byte[])zzafI.get();
        byte[] arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2 == null)
        {
          arrayOfByte1 = zzoL();
          zzafI = new WeakReference(arrayOfByte1);
        }
        return arrayOfByte1;
      }
      finally {}
    }
    
    protected abstract byte[] zzoL();
  }
  
  static final class zzd
  {
    static final zzd.zza[] zzafK = { new zzd.zzc(zzd.zza.zzcs("0\004C0\003+ \003\002\001\002\002\t\000ÂàFdJ00"))new zzd.zzc
    {
      protected final byte[] zzoL()
      {
        return zzd.zza.zzcs("0\004C0\003+ \003\002\001\002\002\t\000ÂàFdJ00\r\006\t*H÷\r\001\001\004\005\0000t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android0\036\027\r080821231334Z\027\r360107231334Z0t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android0\001 0\r\006\t*H÷\r\001\001\001\005\000\003\001\r\0000\001\b\002\001\001\000«V.\000Ø;¢\b®\no\022N)Ú\021ò«VÐXâÌ©\023\003é·TÓrö@§\033\035Ë\023\tgbNFV§wj\031=²å¿·$©\036w\030\016jG¤;3Ù`w\0301EÌß{.XftÉáV[\037LjYU¿òQ¦=«ùÅ\\'\"\"Rèuäø\025Jd_qhÀ±¿Æ\022ê¿xWi»4ªyÜ~.¢vL®\007ØÁqT×î_d¥\032D¦\002ÂI\005AWÜ\002Í_\\\016Uûï\031ûã'ð±Q\026Å o\031ÑõÄÛÂÖ¹?hÌ)yÇ\016\030«k;ÕÛU*\016;LßXûíÁº5à\003Á´±\rÒD¨î$ÿý38r«R!^Ú°ü\r\013\024[j¡y\002\001\003£Ù0Ö0\035\006\003U\035\016\004\026\004\024Ç}Â!\027V%Óßkãä×¥0¦\006\003U\035#\0040\024Ç}Â!\027V%Óßkãä×¥¡x¤v0t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android\t\000ÂàFdJ00\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\004\005\000\003\001\001\000mÒRÎï0,6\nªÎÏòÌ©\004»]z\026aø®F²B\004ÐÿJhÇí\032S\036ÄYZb<æ\007c±g)zzãW\022Ä\007ò\bðË\020)\022M{\020b\031ÀÊ>³ù­_¸qï&âñmDÈÙ l²ð\005»?âËD~s\020v­E³?`\tê\031Áaæ&Aª'\035ýR(ÅÅ]ÛE'XÖaöÌ\fÌ·5.BLÄ6\\R52÷2Q7Y<JãAôÛAíÚ\r\013\020q§Ä@ðþ \034¶'ÊgCiÐ½/Ù\021ÿ\006Í¿,ú\020Ü\017:ãWbHÇïÆLqD\027B÷\005ÉÞW:õ[9\r×ý¹A1]_u0\021&ÿb\024\020Ài0");
      }
    }, new zzd.zzc(zzd.zza.zzcs("0\004¨0\003 \003\002\001\002\002\t\000Õ¸l}ÓNõ0"))
    {
      protected final byte[] zzoL()
      {
        return zzd.zza.zzcs("0\004¨0\003 \003\002\001\002\002\t\000Õ¸l}ÓNõ0\r\006\t*H÷\r\001\001\004\005\00001\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\036\027\r080415233656Z\027\r350901233656Z01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\001 0\r\006\t*H÷\r\001\001\001\005\000\003\001\r\0000\001\b\002\001\001\000ÖÎ.\b\n¿â1MÑ³ÏÓ\030\\´=3ú\ftá½¶ÑÛ\023ö,\\9ßVøF=e¾ÀóÊBk\007Å¨íZ9ÁgçkÉ¹'K\013\"\000\031©)\025årÅm*0\033£oÅü\021:ÖËt5¡m#«}úîáeäß\037\n½§\nQlN\005\021Ê|\fU\027[ÃuùHÅj®\b¤O¦¤Ý}¿,\n5\"­\006¸Ì\030^±Uyîøm\b\013\035aÀù¯±ÂëÑ\007êE«Ûh£Ç^TÇlSÔ\013\022\035ç»Ó\016b\f\030áªaÛ¼Ý<d_/UóÔÃuì@p©?qQØ6pÁj\032¾^òÑ\030á¸®ó)ðf¿láD¬èm\034\033\017\002\001\003£ü0ù0\035\006\003U\035\016\004\026\004\024\034Å¾LC<a:\025°L¼\003òOà²0É\006\003U\035#\004Á0¾\024\034Å¾LC<a:\025°L¼\003òOà²¡¤01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com\t\000Õ¸l}ÓNõ0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\004\005\000\003\001\001\000\031Ó\fñ\005ûx?L\r}Ò##=@zÏÎ\000\b\035[×ÆéÖí k\016\021 \006Al¢D\023ÒkJ àõ$ÊÒ»\\nL¡\001j\025n¡ì]ÉZ^:\001\0006ôHÕ\020¿.\036ag:;åm¯\013w±Â)ãÂUãèL]#ïº\tËñ; +NZ\"É2cHJ#Òü)ú\0319u3¯Øª\026\017BÂÐ\026>fCéÁ/ Á33[Àÿk\"ÞÑ­DB)¥9©Nï­«ÐeÎÒK>QåÝ{fx{ï\022þû¤Ä#ûOøÌIL\002ðõ\005\026\022ÿe)9>FêÅ»!òwÁQª_*¦'Ñè§\n¶\0035iÞ;¿ÿ|©Ú>\022Cö\013");
      }
    } };
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */