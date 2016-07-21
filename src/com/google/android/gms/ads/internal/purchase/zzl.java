package com.google.android.gms.ads.internal.purchase;

import android.util.Base64;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

@zzhb
public final class zzl
{
  public static boolean zza(PublicKey paramPublicKey, String paramString1, String paramString2)
  {
    try
    {
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(paramPublicKey);
      localSignature.update(paramString1.getBytes());
      if (!localSignature.verify(Base64.decode(paramString2, 0)))
      {
        zzin.e("Signature verification failed.");
        return false;
      }
      return true;
    }
    catch (NoSuchAlgorithmException paramPublicKey)
    {
      zzin.e("NoSuchAlgorithmException.");
      return false;
    }
    catch (InvalidKeyException paramPublicKey)
    {
      zzin.e("Invalid key specification.");
      return false;
    }
    catch (SignatureException paramPublicKey)
    {
      zzin.e("Signature exception.");
    }
    return false;
  }
  
  public static PublicKey zzas(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 0);
      paramString = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramString));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new RuntimeException(paramString);
    }
    catch (InvalidKeySpecException paramString)
    {
      zzin.e("Invalid key specification.");
      throw new IllegalArgumentException(paramString);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */