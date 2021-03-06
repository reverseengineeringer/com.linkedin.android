package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;
import javax.crypto.CipherInputStream;

final class Aes128DataSource
  implements DataSource
{
  private CipherInputStream cipherInputStream;
  private final byte[] encryptionIv;
  private final byte[] encryptionKey;
  private final DataSource upstream;
  
  public Aes128DataSource(DataSource paramDataSource, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    upstream = paramDataSource;
    encryptionKey = paramArrayOfByte1;
    encryptionIv = paramArrayOfByte2;
  }
  
  public final void close()
    throws IOException
  {
    cipherInputStream = null;
    upstream.close();
  }
  
  /* Error */
  public final long open(com.google.android.exoplayer.upstream.DataSpec paramDataSpec)
    throws IOException
  {
    // Byte code:
    //   0: ldc 45
    //   2: invokestatic 51	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   5: astore_2
    //   6: new 53	javax/crypto/spec/SecretKeySpec
    //   9: dup
    //   10: aload_0
    //   11: getfield 22	com/google/android/exoplayer/hls/Aes128DataSource:encryptionKey	[B
    //   14: ldc 55
    //   16: invokespecial 58	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   19: astore_3
    //   20: new 60	javax/crypto/spec/IvParameterSpec
    //   23: dup
    //   24: aload_0
    //   25: getfield 24	com/google/android/exoplayer/hls/Aes128DataSource:encryptionIv	[B
    //   28: invokespecial 63	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   31: astore 4
    //   33: aload_2
    //   34: iconst_2
    //   35: aload_3
    //   36: aload 4
    //   38: invokevirtual 67	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   41: aload_0
    //   42: new 69	javax/crypto/CipherInputStream
    //   45: dup
    //   46: new 71	com/google/android/exoplayer/upstream/DataSourceInputStream
    //   49: dup
    //   50: aload_0
    //   51: getfield 20	com/google/android/exoplayer/hls/Aes128DataSource:upstream	Lcom/google/android/exoplayer/upstream/DataSource;
    //   54: aload_1
    //   55: invokespecial 74	com/google/android/exoplayer/upstream/DataSourceInputStream:<init>	(Lcom/google/android/exoplayer/upstream/DataSource;Lcom/google/android/exoplayer/upstream/DataSpec;)V
    //   58: aload_2
    //   59: invokespecial 77	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   62: putfield 30	com/google/android/exoplayer/hls/Aes128DataSource:cipherInputStream	Ljavax/crypto/CipherInputStream;
    //   65: ldc2_w 78
    //   68: lreturn
    //   69: astore_1
    //   70: new 81	java/lang/RuntimeException
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 84	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   78: athrow
    //   79: astore_1
    //   80: new 81	java/lang/RuntimeException
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 84	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   88: athrow
    //   89: astore_1
    //   90: new 81	java/lang/RuntimeException
    //   93: dup
    //   94: aload_1
    //   95: invokespecial 84	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   98: athrow
    //   99: astore_1
    //   100: new 81	java/lang/RuntimeException
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 84	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	Aes128DataSource
    //   0	109	1	paramDataSpec	com.google.android.exoplayer.upstream.DataSpec
    //   5	54	2	localCipher	javax.crypto.Cipher
    //   19	17	3	localSecretKeySpec	javax.crypto.spec.SecretKeySpec
    //   31	6	4	localIvParameterSpec	javax.crypto.spec.IvParameterSpec
    // Exception table:
    //   from	to	target	type
    //   0	6	69	java/security/NoSuchAlgorithmException
    //   0	6	79	javax/crypto/NoSuchPaddingException
    //   33	41	89	java/security/InvalidKeyException
    //   33	41	99	java/security/InvalidAlgorithmParameterException
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (cipherInputStream != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      paramInt2 = cipherInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = -1;
      }
      return paramInt1;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.Aes128DataSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */