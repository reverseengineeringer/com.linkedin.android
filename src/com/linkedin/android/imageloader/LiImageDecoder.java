package com.linkedin.android.imageloader;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.linkedin.android.imageloader.interfaces.IBitmapFactory;
import com.linkedin.android.imageloader.interfaces.ImageDecoder;
import com.linkedin.android.imageloader.interfaces.ImageTransformer;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.imageloader.interfaces.PerfEventListener;
import com.linkedin.android.logger.Log;
import com.linkedin.android.networking.util.ByteArrayPool;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class LiImageDecoder
  implements ImageDecoder
{
  private static final Paint DEFAULT_PAINT = new Paint(6);
  private static final String TAG;
  public static final Object sDecodeLock = new Object();
  private final IBitmapFactory mBitmapFactory;
  private final ByteArrayPool mByteArrayPool;
  private final Context mContext;
  private final IntArrayPool mIntArrayPool;
  
  static
  {
    TAG = LiImageDecoder.class.getSimpleName();
  }
  
  public LiImageDecoder(Context paramContext, ByteArrayPool paramByteArrayPool)
  {
    mContext = paramContext.getApplicationContext();
    mByteArrayPool = paramByteArrayPool;
    mIntArrayPool = new IntArrayPool();
    if (Build.VERSION.SDK_INT >= 21)
    {
      mBitmapFactory = new PoolingBitmapFactory();
      return;
    }
    mBitmapFactory = new PurgeableBitmapFactory();
  }
  
  private static void closeInputStream(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream)
    {
      Log.e(TAG, "Error closing input stream", paramInputStream);
    }
  }
  
  /* Error */
  private ManagedBitmap doDecode(InputStream paramInputStream, Pair<Integer, Integer> paramPair, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 94	android/graphics/BitmapFactory$Options
    //   5: dup
    //   6: invokespecial 95	android/graphics/BitmapFactory$Options:<init>	()V
    //   9: astore 23
    //   11: iconst_0
    //   12: istore 8
    //   14: iconst_0
    //   15: istore 9
    //   17: iconst_0
    //   18: istore 10
    //   20: aconst_null
    //   21: astore 21
    //   23: aconst_null
    //   24: astore 20
    //   26: aload 4
    //   28: ifnull +32 -> 60
    //   31: aload 20
    //   33: astore 17
    //   35: iload 8
    //   37: istore 7
    //   39: aload_1
    //   40: astore 18
    //   42: aload 21
    //   44: astore 15
    //   46: iload 9
    //   48: istore 6
    //   50: aload_1
    //   51: astore 16
    //   53: aload 4
    //   55: invokeinterface 100 1 0
    //   60: aload 20
    //   62: astore 17
    //   64: iload 8
    //   66: istore 7
    //   68: aload_1
    //   69: astore 18
    //   71: aload 21
    //   73: astore 15
    //   75: iload 9
    //   77: istore 6
    //   79: aload_1
    //   80: astore 16
    //   82: new 102	com/linkedin/android/networking/streams/MarkableInputStream
    //   85: dup
    //   86: aload_1
    //   87: aload_0
    //   88: getfield 54	com/linkedin/android/imageloader/LiImageDecoder:mByteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   91: invokespecial 105	com/linkedin/android/networking/streams/MarkableInputStream:<init>	(Ljava/io/InputStream;Lcom/linkedin/android/networking/util/ByteArrayPool;)V
    //   94: astore 22
    //   96: aload 22
    //   98: astore_1
    //   99: aload 20
    //   101: astore 17
    //   103: iload 8
    //   105: istore 7
    //   107: aload_1
    //   108: astore 18
    //   110: aload 21
    //   112: astore 15
    //   114: iload 9
    //   116: istore 6
    //   118: aload_1
    //   119: astore 16
    //   121: aload 22
    //   123: iconst_0
    //   124: putfield 109	com/linkedin/android/networking/streams/MarkableInputStream:allowExpire	Z
    //   127: aload 20
    //   129: astore 17
    //   131: iload 8
    //   133: istore 7
    //   135: aload_1
    //   136: astore 18
    //   138: aload 21
    //   140: astore 15
    //   142: iload 9
    //   144: istore 6
    //   146: aload_1
    //   147: astore 16
    //   149: aload 22
    //   151: sipush 1024
    //   154: invokevirtual 113	com/linkedin/android/networking/streams/MarkableInputStream:savePosition	(I)J
    //   157: lstore 13
    //   159: aload 20
    //   161: astore 17
    //   163: iload 8
    //   165: istore 7
    //   167: aload_1
    //   168: astore 18
    //   170: aload 21
    //   172: astore 15
    //   174: iload 9
    //   176: istore 6
    //   178: aload_1
    //   179: astore 16
    //   181: aload_0
    //   182: aload_1
    //   183: invokespecial 117	com/linkedin/android/imageloader/LiImageDecoder:getImageType	(Ljava/io/InputStream;)Lcom/linkedin/android/imageloader/LiImageHeaderParser$ImageType;
    //   186: astore 24
    //   188: aload 20
    //   190: astore 17
    //   192: iload 8
    //   194: istore 7
    //   196: aload_1
    //   197: astore 18
    //   199: aload 21
    //   201: astore 15
    //   203: iload 9
    //   205: istore 6
    //   207: aload_1
    //   208: astore 16
    //   210: aload 24
    //   212: getstatic 123	com/linkedin/android/imageloader/LiImageHeaderParser$ImageType:UNKNOWN	Lcom/linkedin/android/imageloader/LiImageHeaderParser$ImageType;
    //   215: if_acmpne +420 -> 635
    //   218: aload 20
    //   220: astore 17
    //   222: iload 8
    //   224: istore 7
    //   226: aload_1
    //   227: astore 18
    //   229: aload 21
    //   231: astore 15
    //   233: iload 9
    //   235: istore 6
    //   237: aload_1
    //   238: astore 16
    //   240: getstatic 35	com/linkedin/android/imageloader/LiImageDecoder:TAG	Ljava/lang/String;
    //   243: ldc 125
    //   245: invokestatic 128	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   248: pop
    //   249: aload 20
    //   251: astore 17
    //   253: iload 8
    //   255: istore 7
    //   257: aload_1
    //   258: astore 18
    //   260: aload 21
    //   262: astore 15
    //   264: iload 9
    //   266: istore 6
    //   268: aload_1
    //   269: astore 16
    //   271: getstatic 134	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   274: astore 19
    //   276: aload 20
    //   278: astore 17
    //   280: iload 8
    //   282: istore 7
    //   284: aload_1
    //   285: astore 18
    //   287: aload 21
    //   289: astore 15
    //   291: iload 9
    //   293: istore 6
    //   295: aload_1
    //   296: astore 16
    //   298: aload 23
    //   300: aload 19
    //   302: putfield 137	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   305: iconst_0
    //   306: istore 5
    //   308: aload 20
    //   310: astore 17
    //   312: iload 8
    //   314: istore 7
    //   316: aload_1
    //   317: astore 18
    //   319: aload 21
    //   321: astore 15
    //   323: iload 9
    //   325: istore 6
    //   327: aload_1
    //   328: astore 16
    //   330: aload 24
    //   332: getstatic 140	com/linkedin/android/imageloader/LiImageHeaderParser$ImageType:JPEG	Lcom/linkedin/android/imageloader/LiImageHeaderParser$ImageType;
    //   335: if_acmpne +61 -> 396
    //   338: aload 20
    //   340: astore 17
    //   342: iload 8
    //   344: istore 7
    //   346: aload_1
    //   347: astore 18
    //   349: aload 21
    //   351: astore 15
    //   353: iload 9
    //   355: istore 6
    //   357: aload_1
    //   358: astore 16
    //   360: aload 22
    //   362: lload 13
    //   364: invokevirtual 144	com/linkedin/android/networking/streams/MarkableInputStream:reset	(J)V
    //   367: aload 20
    //   369: astore 17
    //   371: iload 8
    //   373: istore 7
    //   375: aload_1
    //   376: astore 18
    //   378: aload 21
    //   380: astore 15
    //   382: iload 9
    //   384: istore 6
    //   386: aload_1
    //   387: astore 16
    //   389: aload_0
    //   390: aload_1
    //   391: invokespecial 148	com/linkedin/android/imageloader/LiImageDecoder:getOrientation	(Ljava/io/InputStream;)I
    //   394: istore 5
    //   396: aload 20
    //   398: astore 17
    //   400: iload 8
    //   402: istore 7
    //   404: aload_1
    //   405: astore 18
    //   407: aload 21
    //   409: astore 15
    //   411: iload 9
    //   413: istore 6
    //   415: aload_1
    //   416: astore 16
    //   418: aload 24
    //   420: getstatic 151	com/linkedin/android/imageloader/LiImageHeaderParser$ImageType:GIF	Lcom/linkedin/android/imageloader/LiImageHeaderParser$ImageType;
    //   423: if_acmpne +629 -> 1052
    //   426: aload 20
    //   428: astore 17
    //   430: iload 8
    //   432: istore 7
    //   434: aload_1
    //   435: astore 18
    //   437: aload 21
    //   439: astore 15
    //   441: iload 9
    //   443: istore 6
    //   445: aload_1
    //   446: astore 16
    //   448: new 153	com/linkedin/android/imageloader/GifDecoder
    //   451: dup
    //   452: aload_0
    //   453: getfield 70	com/linkedin/android/imageloader/LiImageDecoder:mBitmapFactory	Lcom/linkedin/android/imageloader/interfaces/IBitmapFactory;
    //   456: aload_0
    //   457: getfield 54	com/linkedin/android/imageloader/LiImageDecoder:mByteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   460: aload_0
    //   461: getfield 59	com/linkedin/android/imageloader/LiImageDecoder:mIntArrayPool	Lcom/linkedin/android/imageloader/IntArrayPool;
    //   464: invokespecial 156	com/linkedin/android/imageloader/GifDecoder:<init>	(Lcom/linkedin/android/imageloader/interfaces/IBitmapFactory;Lcom/linkedin/android/networking/util/ByteArrayPool;Lcom/linkedin/android/imageloader/IntArrayPool;)V
    //   467: astore_3
    //   468: aload 21
    //   470: astore 15
    //   472: iload 9
    //   474: istore 6
    //   476: aload_1
    //   477: astore 16
    //   479: aload 22
    //   481: lload 13
    //   483: invokevirtual 144	com/linkedin/android/networking/streams/MarkableInputStream:reset	(J)V
    //   486: aload 21
    //   488: astore 15
    //   490: iload 9
    //   492: istore 6
    //   494: aload_1
    //   495: astore 16
    //   497: aload 22
    //   499: iconst_1
    //   500: putfield 109	com/linkedin/android/networking/streams/MarkableInputStream:allowExpire	Z
    //   503: aload 21
    //   505: astore 15
    //   507: iload 9
    //   509: istore 6
    //   511: aload_1
    //   512: astore 16
    //   514: aload_3
    //   515: aload_1
    //   516: invokevirtual 160	com/linkedin/android/imageloader/GifDecoder:read	(Ljava/io/InputStream;)[B
    //   519: astore 17
    //   521: aload 21
    //   523: astore 15
    //   525: iload 9
    //   527: istore 6
    //   529: aload_1
    //   530: astore 16
    //   532: aload_3
    //   533: aload 17
    //   535: invokevirtual 164	com/linkedin/android/imageloader/GifDecoder:readHeader	([B)Lcom/linkedin/android/imageloader/GifDecoder$GifHeader;
    //   538: astore 18
    //   540: aload 18
    //   542: ifnull +43 -> 585
    //   545: aload 21
    //   547: astore 15
    //   549: iload 9
    //   551: istore 6
    //   553: aload_1
    //   554: astore 16
    //   556: aload 18
    //   558: getfield 169	com/linkedin/android/imageloader/GifDecoder$GifHeader:status	I
    //   561: iconst_1
    //   562: if_icmpeq +23 -> 585
    //   565: aload 21
    //   567: astore 15
    //   569: iload 9
    //   571: istore 6
    //   573: aload_1
    //   574: astore 16
    //   576: aload 18
    //   578: getfield 169	com/linkedin/android/imageloader/GifDecoder$GifHeader:status	I
    //   581: iconst_2
    //   582: if_icmpne +143 -> 725
    //   585: aload 21
    //   587: astore 15
    //   589: iload 9
    //   591: istore 6
    //   593: aload_1
    //   594: astore 16
    //   596: getstatic 35	com/linkedin/android/imageloader/LiImageDecoder:TAG	Ljava/lang/String;
    //   599: ldc -85
    //   601: invokestatic 128	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   604: pop
    //   605: aload 4
    //   607: ifnull +10 -> 617
    //   610: aload 4
    //   612: invokeinterface 174 1 0
    //   617: aload_0
    //   618: getfield 54	com/linkedin/android/imageloader/LiImageDecoder:mByteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   621: aconst_null
    //   622: invokevirtual 180	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   625: aload_1
    //   626: invokestatic 182	com/linkedin/android/imageloader/LiImageDecoder:closeInputStream	(Ljava/io/InputStream;)V
    //   629: aconst_null
    //   630: astore_1
    //   631: aload_0
    //   632: monitorexit
    //   633: aload_1
    //   634: areturn
    //   635: aload 20
    //   637: astore 17
    //   639: iload 8
    //   641: istore 7
    //   643: aload_1
    //   644: astore 18
    //   646: aload 21
    //   648: astore 15
    //   650: iload 9
    //   652: istore 6
    //   654: aload_1
    //   655: astore 16
    //   657: aload 24
    //   659: getfield 185	com/linkedin/android/imageloader/LiImageHeaderParser$ImageType:hasAlpha	Z
    //   662: ifeq +33 -> 695
    //   665: aload 20
    //   667: astore 17
    //   669: iload 8
    //   671: istore 7
    //   673: aload_1
    //   674: astore 18
    //   676: aload 21
    //   678: astore 15
    //   680: iload 9
    //   682: istore 6
    //   684: aload_1
    //   685: astore 16
    //   687: getstatic 134	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   690: astore 19
    //   692: goto -416 -> 276
    //   695: aload 20
    //   697: astore 17
    //   699: iload 8
    //   701: istore 7
    //   703: aload_1
    //   704: astore 18
    //   706: aload 21
    //   708: astore 15
    //   710: iload 9
    //   712: istore 6
    //   714: aload_1
    //   715: astore 16
    //   717: getstatic 188	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   720: astore 19
    //   722: goto -446 -> 276
    //   725: aload 21
    //   727: astore 15
    //   729: iload 9
    //   731: istore 6
    //   733: aload_1
    //   734: astore 16
    //   736: aload 18
    //   738: getfield 191	com/linkedin/android/imageloader/GifDecoder$GifHeader:width	I
    //   741: istore 5
    //   743: aload 21
    //   745: astore 15
    //   747: iload 9
    //   749: istore 6
    //   751: aload_1
    //   752: astore 16
    //   754: aload 18
    //   756: getfield 194	com/linkedin/android/imageloader/GifDecoder$GifHeader:height	I
    //   759: istore 7
    //   761: aload 21
    //   763: astore 15
    //   765: iload 9
    //   767: istore 6
    //   769: aload_1
    //   770: astore 16
    //   772: aload_3
    //   773: aload 17
    //   775: aload 18
    //   777: aload_0
    //   778: getfield 52	com/linkedin/android/imageloader/LiImageDecoder:mContext	Landroid/content/Context;
    //   781: iload 5
    //   783: iload 7
    //   785: aload_2
    //   786: invokestatic 198	com/linkedin/android/imageloader/LiImageDecoder:findBestSampleSize	(Landroid/content/Context;IILandroid/util/Pair;)I
    //   789: invokevirtual 202	com/linkedin/android/imageloader/GifDecoder:setImageData	([BLcom/linkedin/android/imageloader/GifDecoder$GifHeader;I)I
    //   792: ifne +150 -> 942
    //   795: aload 21
    //   797: astore 15
    //   799: iload 9
    //   801: istore 6
    //   803: aload_1
    //   804: astore 16
    //   806: aload_3
    //   807: getfield 206	com/linkedin/android/imageloader/GifDecoder:header	Lcom/linkedin/android/imageloader/GifDecoder$GifHeader;
    //   810: getfield 209	com/linkedin/android/imageloader/GifDecoder$GifHeader:frameCount	I
    //   813: ifne +52 -> 865
    //   816: aload 21
    //   818: astore 15
    //   820: iload 9
    //   822: istore 6
    //   824: aload_1
    //   825: astore 16
    //   827: getstatic 35	com/linkedin/android/imageloader/LiImageDecoder:TAG	Ljava/lang/String;
    //   830: ldc -45
    //   832: invokestatic 128	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   835: pop
    //   836: aload 4
    //   838: ifnull +10 -> 848
    //   841: aload 4
    //   843: invokeinterface 174 1 0
    //   848: aload_0
    //   849: getfield 54	com/linkedin/android/imageloader/LiImageDecoder:mByteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   852: aconst_null
    //   853: invokevirtual 180	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   856: aload_1
    //   857: invokestatic 182	com/linkedin/android/imageloader/LiImageDecoder:closeInputStream	(Ljava/io/InputStream;)V
    //   860: aconst_null
    //   861: astore_1
    //   862: goto -231 -> 631
    //   865: aload 21
    //   867: astore 15
    //   869: iload 9
    //   871: istore 6
    //   873: aload_1
    //   874: astore 16
    //   876: aload_3
    //   877: invokevirtual 214	com/linkedin/android/imageloader/GifDecoder:advance	()V
    //   880: aload 21
    //   882: astore 15
    //   884: iload 9
    //   886: istore 6
    //   888: aload_1
    //   889: astore 16
    //   891: new 216	com/linkedin/android/imageloader/LiGifManagedBitmap
    //   894: dup
    //   895: aload_3
    //   896: aload_3
    //   897: invokevirtual 220	com/linkedin/android/imageloader/GifDecoder:getNextFrame	()Landroid/graphics/Bitmap;
    //   900: aload_0
    //   901: getfield 70	com/linkedin/android/imageloader/LiImageDecoder:mBitmapFactory	Lcom/linkedin/android/imageloader/interfaces/IBitmapFactory;
    //   904: invokespecial 223	com/linkedin/android/imageloader/LiGifManagedBitmap:<init>	(Lcom/linkedin/android/imageloader/GifDecoder;Landroid/graphics/Bitmap;Lcom/linkedin/android/imageloader/interfaces/IBitmapFactory;)V
    //   907: astore_2
    //   908: aload 4
    //   910: ifnull +10 -> 920
    //   913: aload 4
    //   915: invokeinterface 174 1 0
    //   920: aload_0
    //   921: getfield 54	com/linkedin/android/imageloader/LiImageDecoder:mByteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   924: aconst_null
    //   925: invokevirtual 180	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   928: aload_1
    //   929: invokestatic 182	com/linkedin/android/imageloader/LiImageDecoder:closeInputStream	(Ljava/io/InputStream;)V
    //   932: aload_2
    //   933: astore_1
    //   934: goto -303 -> 631
    //   937: astore_1
    //   938: aload_0
    //   939: monitorexit
    //   940: aload_1
    //   941: athrow
    //   942: aload 21
    //   944: astore 15
    //   946: iload 9
    //   948: istore 6
    //   950: aload_1
    //   951: astore 16
    //   953: getstatic 35	com/linkedin/android/imageloader/LiImageDecoder:TAG	Ljava/lang/String;
    //   956: ldc -31
    //   958: invokestatic 128	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   961: pop
    //   962: aload 4
    //   964: ifnull +10 -> 974
    //   967: aload 4
    //   969: invokeinterface 174 1 0
    //   974: aload_0
    //   975: getfield 54	com/linkedin/android/imageloader/LiImageDecoder:mByteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   978: aconst_null
    //   979: invokevirtual 180	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   982: aload_1
    //   983: invokestatic 182	com/linkedin/android/imageloader/LiImageDecoder:closeInputStream	(Ljava/io/InputStream;)V
    //   986: aconst_null
    //   987: astore_1
    //   988: goto -357 -> 631
    //   991: astore_2
    //   992: aload 20
    //   994: astore 17
    //   996: iload 8
    //   998: istore 7
    //   1000: aload_1
    //   1001: astore 18
    //   1003: aload 21
    //   1005: astore 15
    //   1007: iload 9
    //   1009: istore 6
    //   1011: aload_1
    //   1012: astore 16
    //   1014: getstatic 35	com/linkedin/android/imageloader/LiImageDecoder:TAG	Ljava/lang/String;
    //   1017: ldc -29
    //   1019: invokestatic 128	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1022: pop
    //   1023: aload 4
    //   1025: ifnull +10 -> 1035
    //   1028: aload 4
    //   1030: invokeinterface 174 1 0
    //   1035: aload_0
    //   1036: getfield 54	com/linkedin/android/imageloader/LiImageDecoder:mByteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   1039: aconst_null
    //   1040: invokevirtual 180	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   1043: aload_1
    //   1044: invokestatic 182	com/linkedin/android/imageloader/LiImageDecoder:closeInputStream	(Ljava/io/InputStream;)V
    //   1047: aconst_null
    //   1048: astore_1
    //   1049: goto -418 -> 631
    //   1052: aload 20
    //   1054: astore 17
    //   1056: iload 8
    //   1058: istore 7
    //   1060: aload_1
    //   1061: astore 18
    //   1063: aload 21
    //   1065: astore 15
    //   1067: iload 9
    //   1069: istore 6
    //   1071: aload_1
    //   1072: astore 16
    //   1074: aload 23
    //   1076: iconst_1
    //   1077: putfield 230	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1080: aload 20
    //   1082: astore 17
    //   1084: iload 8
    //   1086: istore 7
    //   1088: aload_1
    //   1089: astore 18
    //   1091: aload 21
    //   1093: astore 15
    //   1095: iload 9
    //   1097: istore 6
    //   1099: aload_1
    //   1100: astore 16
    //   1102: aload 22
    //   1104: lload 13
    //   1106: invokevirtual 144	com/linkedin/android/networking/streams/MarkableInputStream:reset	(J)V
    //   1109: aload 20
    //   1111: astore 17
    //   1113: iload 8
    //   1115: istore 7
    //   1117: aload_1
    //   1118: astore 18
    //   1120: aload 21
    //   1122: astore 15
    //   1124: iload 9
    //   1126: istore 6
    //   1128: aload_1
    //   1129: astore 16
    //   1131: aload_1
    //   1132: aconst_null
    //   1133: aload 23
    //   1135: invokestatic 236	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1138: pop
    //   1139: aload 20
    //   1141: astore 17
    //   1143: iload 8
    //   1145: istore 7
    //   1147: aload_1
    //   1148: astore 18
    //   1150: aload 21
    //   1152: astore 15
    //   1154: iload 9
    //   1156: istore 6
    //   1158: aload_1
    //   1159: astore 16
    //   1161: aload 23
    //   1163: getfield 239	android/graphics/BitmapFactory$Options:outWidth	I
    //   1166: istore 11
    //   1168: aload 20
    //   1170: astore 17
    //   1172: iload 8
    //   1174: istore 7
    //   1176: aload_1
    //   1177: astore 18
    //   1179: aload 21
    //   1181: astore 15
    //   1183: iload 9
    //   1185: istore 6
    //   1187: aload_1
    //   1188: astore 16
    //   1190: aload 23
    //   1192: getfield 242	android/graphics/BitmapFactory$Options:outHeight	I
    //   1195: istore 12
    //   1197: aload 20
    //   1199: astore 17
    //   1201: iload 8
    //   1203: istore 7
    //   1205: aload_1
    //   1206: astore 18
    //   1208: aload 21
    //   1210: astore 15
    //   1212: iload 9
    //   1214: istore 6
    //   1216: aload_1
    //   1217: astore 16
    //   1219: aload 23
    //   1221: iconst_0
    //   1222: putfield 230	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1225: aload 20
    //   1227: astore 17
    //   1229: iload 8
    //   1231: istore 7
    //   1233: aload_1
    //   1234: astore 18
    //   1236: aload 21
    //   1238: astore 15
    //   1240: iload 9
    //   1242: istore 6
    //   1244: aload_1
    //   1245: astore 16
    //   1247: aload_0
    //   1248: getfield 54	com/linkedin/android/imageloader/LiImageDecoder:mByteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   1251: sipush 16384
    //   1254: invokevirtual 246	com/linkedin/android/networking/util/ByteArrayPool:getBuf	(I)[B
    //   1257: astore 19
    //   1259: aload 19
    //   1261: astore 17
    //   1263: iload 8
    //   1265: istore 7
    //   1267: aload_1
    //   1268: astore 18
    //   1270: aload 19
    //   1272: astore 15
    //   1274: iload 9
    //   1276: istore 6
    //   1278: aload_1
    //   1279: astore 16
    //   1281: aload 23
    //   1283: aload 19
    //   1285: putfield 250	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   1288: aload 19
    //   1290: astore 17
    //   1292: iload 8
    //   1294: istore 7
    //   1296: aload_1
    //   1297: astore 18
    //   1299: aload 19
    //   1301: astore 15
    //   1303: iload 9
    //   1305: istore 6
    //   1307: aload_1
    //   1308: astore 16
    //   1310: getstatic 65	android/os/Build$VERSION:SDK_INT	I
    //   1313: bipush 10
    //   1315: if_icmplt +31 -> 1346
    //   1318: aload 19
    //   1320: astore 17
    //   1322: iload 8
    //   1324: istore 7
    //   1326: aload_1
    //   1327: astore 18
    //   1329: aload 19
    //   1331: astore 15
    //   1333: iload 9
    //   1335: istore 6
    //   1337: aload_1
    //   1338: astore 16
    //   1340: aload 23
    //   1342: iconst_0
    //   1343: putfield 253	android/graphics/BitmapFactory$Options:inPreferQualityOverSpeed	Z
    //   1346: aload 19
    //   1348: astore 17
    //   1350: iload 8
    //   1352: istore 7
    //   1354: aload_1
    //   1355: astore 18
    //   1357: aload 19
    //   1359: astore 15
    //   1361: iload 9
    //   1363: istore 6
    //   1365: aload_1
    //   1366: astore 16
    //   1368: getstatic 65	android/os/Build$VERSION:SDK_INT	I
    //   1371: bipush 11
    //   1373: if_icmplt +31 -> 1404
    //   1376: aload 19
    //   1378: astore 17
    //   1380: iload 8
    //   1382: istore 7
    //   1384: aload_1
    //   1385: astore 18
    //   1387: aload 19
    //   1389: astore 15
    //   1391: iload 9
    //   1393: istore 6
    //   1395: aload_1
    //   1396: astore 16
    //   1398: aload 23
    //   1400: iconst_1
    //   1401: putfield 256	android/graphics/BitmapFactory$Options:inMutable	Z
    //   1404: aload 19
    //   1406: astore 17
    //   1408: iload 8
    //   1410: istore 7
    //   1412: aload_1
    //   1413: astore 18
    //   1415: aload 19
    //   1417: astore 15
    //   1419: iload 9
    //   1421: istore 6
    //   1423: aload_1
    //   1424: astore 16
    //   1426: aload 23
    //   1428: getfield 137	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   1431: getstatic 134	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1434: if_acmpeq +31 -> 1465
    //   1437: aload 19
    //   1439: astore 17
    //   1441: iload 8
    //   1443: istore 7
    //   1445: aload_1
    //   1446: astore 18
    //   1448: aload 19
    //   1450: astore 15
    //   1452: iload 9
    //   1454: istore 6
    //   1456: aload_1
    //   1457: astore 16
    //   1459: aload 23
    //   1461: iconst_1
    //   1462: putfield 259	android/graphics/BitmapFactory$Options:inDither	Z
    //   1465: aload 19
    //   1467: astore 17
    //   1469: iload 8
    //   1471: istore 7
    //   1473: aload_1
    //   1474: astore 18
    //   1476: aload 19
    //   1478: astore 15
    //   1480: iload 9
    //   1482: istore 6
    //   1484: aload_1
    //   1485: astore 16
    //   1487: aload 23
    //   1489: aload_0
    //   1490: getfield 52	com/linkedin/android/imageloader/LiImageDecoder:mContext	Landroid/content/Context;
    //   1493: iload 11
    //   1495: iload 12
    //   1497: aload_2
    //   1498: invokestatic 198	com/linkedin/android/imageloader/LiImageDecoder:findBestSampleSize	(Landroid/content/Context;IILandroid/util/Pair;)I
    //   1501: putfield 262	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1504: aload 19
    //   1506: astore 17
    //   1508: iload 8
    //   1510: istore 7
    //   1512: aload_1
    //   1513: astore 18
    //   1515: aload 19
    //   1517: astore 15
    //   1519: iload 9
    //   1521: istore 6
    //   1523: aload_1
    //   1524: astore 16
    //   1526: aload 22
    //   1528: lload 13
    //   1530: invokevirtual 144	com/linkedin/android/networking/streams/MarkableInputStream:reset	(J)V
    //   1533: aload 19
    //   1535: astore 17
    //   1537: iload 8
    //   1539: istore 7
    //   1541: aload_1
    //   1542: astore 18
    //   1544: aload 19
    //   1546: astore 15
    //   1548: iload 9
    //   1550: istore 6
    //   1552: aload_1
    //   1553: astore 16
    //   1555: aload 22
    //   1557: iconst_1
    //   1558: putfield 109	com/linkedin/android/networking/streams/MarkableInputStream:allowExpire	Z
    //   1561: aload 19
    //   1563: astore 17
    //   1565: iload 8
    //   1567: istore 7
    //   1569: aload_1
    //   1570: astore 18
    //   1572: aload 19
    //   1574: astore 15
    //   1576: iload 9
    //   1578: istore 6
    //   1580: aload_1
    //   1581: astore 16
    //   1583: aload_0
    //   1584: getfield 70	com/linkedin/android/imageloader/LiImageDecoder:mBitmapFactory	Lcom/linkedin/android/imageloader/interfaces/IBitmapFactory;
    //   1587: aload_1
    //   1588: aload 23
    //   1590: invokeinterface 268 3 0
    //   1595: astore 20
    //   1597: aload 20
    //   1599: astore_2
    //   1600: aload 20
    //   1602: ifnull +442 -> 2044
    //   1605: aload 20
    //   1607: astore_2
    //   1608: iload 5
    //   1610: iconst_1
    //   1611: if_icmpeq +433 -> 2044
    //   1614: aload 20
    //   1616: astore_2
    //   1617: iload 5
    //   1619: ifeq +425 -> 2044
    //   1622: aload 19
    //   1624: astore 17
    //   1626: iload 8
    //   1628: istore 7
    //   1630: aload_1
    //   1631: astore 18
    //   1633: aload 19
    //   1635: astore 15
    //   1637: iload 9
    //   1639: istore 6
    //   1641: aload_1
    //   1642: astore 16
    //   1644: iload 5
    //   1646: invokestatic 274	com/linkedin/android/imageloader/Utils:getTransformationMatrix	(I)Landroid/graphics/Matrix;
    //   1649: astore 21
    //   1651: aload 20
    //   1653: astore_2
    //   1654: aload 19
    //   1656: astore 17
    //   1658: iload 8
    //   1660: istore 7
    //   1662: aload_1
    //   1663: astore 18
    //   1665: aload 19
    //   1667: astore 15
    //   1669: iload 9
    //   1671: istore 6
    //   1673: aload_1
    //   1674: astore 16
    //   1676: aload 21
    //   1678: invokevirtual 280	android/graphics/Matrix:isIdentity	()Z
    //   1681: ifne +363 -> 2044
    //   1684: aload 19
    //   1686: astore 17
    //   1688: iload 8
    //   1690: istore 7
    //   1692: aload_1
    //   1693: astore 18
    //   1695: aload 19
    //   1697: astore 15
    //   1699: iload 9
    //   1701: istore 6
    //   1703: aload_1
    //   1704: astore 16
    //   1706: new 282	android/graphics/RectF
    //   1709: dup
    //   1710: fconst_0
    //   1711: fconst_0
    //   1712: aload 20
    //   1714: invokevirtual 288	android/graphics/Bitmap:getWidth	()I
    //   1717: i2f
    //   1718: aload 20
    //   1720: invokevirtual 291	android/graphics/Bitmap:getHeight	()I
    //   1723: i2f
    //   1724: invokespecial 294	android/graphics/RectF:<init>	(FFFF)V
    //   1727: astore 22
    //   1729: aload 19
    //   1731: astore 17
    //   1733: iload 8
    //   1735: istore 7
    //   1737: aload_1
    //   1738: astore 18
    //   1740: aload 19
    //   1742: astore 15
    //   1744: iload 9
    //   1746: istore 6
    //   1748: aload_1
    //   1749: astore 16
    //   1751: aload 21
    //   1753: aload 22
    //   1755: invokevirtual 298	android/graphics/Matrix:mapRect	(Landroid/graphics/RectF;)Z
    //   1758: pop
    //   1759: aload 19
    //   1761: astore 17
    //   1763: iload 8
    //   1765: istore 7
    //   1767: aload_1
    //   1768: astore 18
    //   1770: aload 19
    //   1772: astore 15
    //   1774: iload 9
    //   1776: istore 6
    //   1778: aload_1
    //   1779: astore 16
    //   1781: aload 22
    //   1783: invokevirtual 301	android/graphics/RectF:width	()F
    //   1786: invokestatic 307	java/lang/Math:round	(F)I
    //   1789: istore 5
    //   1791: aload 19
    //   1793: astore 17
    //   1795: iload 8
    //   1797: istore 7
    //   1799: aload_1
    //   1800: astore 18
    //   1802: aload 19
    //   1804: astore 15
    //   1806: iload 9
    //   1808: istore 6
    //   1810: aload_1
    //   1811: astore 16
    //   1813: aload 22
    //   1815: invokevirtual 309	android/graphics/RectF:height	()F
    //   1818: invokestatic 307	java/lang/Math:round	(F)I
    //   1821: istore 11
    //   1823: aload 19
    //   1825: astore 17
    //   1827: iload 8
    //   1829: istore 7
    //   1831: aload_1
    //   1832: astore 18
    //   1834: aload 19
    //   1836: astore 15
    //   1838: iload 9
    //   1840: istore 6
    //   1842: aload_1
    //   1843: astore 16
    //   1845: aload_0
    //   1846: getfield 70	com/linkedin/android/imageloader/LiImageDecoder:mBitmapFactory	Lcom/linkedin/android/imageloader/interfaces/IBitmapFactory;
    //   1849: iload 5
    //   1851: iload 11
    //   1853: aload 20
    //   1855: invokevirtual 313	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   1858: invokeinterface 316 4 0
    //   1863: astore_2
    //   1864: aload 19
    //   1866: astore 17
    //   1868: iload 8
    //   1870: istore 7
    //   1872: aload_1
    //   1873: astore 18
    //   1875: aload 19
    //   1877: astore 15
    //   1879: iload 9
    //   1881: istore 6
    //   1883: aload_1
    //   1884: astore 16
    //   1886: aload 21
    //   1888: aload 22
    //   1890: getfield 320	android/graphics/RectF:left	F
    //   1893: fneg
    //   1894: aload 22
    //   1896: getfield 323	android/graphics/RectF:top	F
    //   1899: fneg
    //   1900: invokevirtual 327	android/graphics/Matrix:postTranslate	(FF)Z
    //   1903: pop
    //   1904: aload_2
    //   1905: ifnull +97 -> 2002
    //   1908: aload 19
    //   1910: astore 17
    //   1912: iload 8
    //   1914: istore 7
    //   1916: aload_1
    //   1917: astore 18
    //   1919: aload 19
    //   1921: astore 15
    //   1923: iload 9
    //   1925: istore 6
    //   1927: aload_1
    //   1928: astore 16
    //   1930: new 329	android/graphics/Canvas
    //   1933: dup
    //   1934: aload_2
    //   1935: invokespecial 332	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   1938: astore 22
    //   1940: aload 19
    //   1942: astore 17
    //   1944: iload 8
    //   1946: istore 7
    //   1948: aload_1
    //   1949: astore 18
    //   1951: aload 19
    //   1953: astore 15
    //   1955: iload 9
    //   1957: istore 6
    //   1959: aload_1
    //   1960: astore 16
    //   1962: aload 22
    //   1964: aload 20
    //   1966: aload 21
    //   1968: getstatic 42	com/linkedin/android/imageloader/LiImageDecoder:DEFAULT_PAINT	Landroid/graphics/Paint;
    //   1971: invokevirtual 336	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   1974: aload 19
    //   1976: astore 17
    //   1978: iload 8
    //   1980: istore 7
    //   1982: aload_1
    //   1983: astore 18
    //   1985: aload 19
    //   1987: astore 15
    //   1989: iload 9
    //   1991: istore 6
    //   1993: aload_1
    //   1994: astore 16
    //   1996: aload 22
    //   1998: aconst_null
    //   1999: invokevirtual 339	android/graphics/Canvas:setBitmap	(Landroid/graphics/Bitmap;)V
    //   2002: aload_2
    //   2003: aload 20
    //   2005: if_acmpeq +435 -> 2440
    //   2008: aload 19
    //   2010: astore 17
    //   2012: iload 8
    //   2014: istore 7
    //   2016: aload_1
    //   2017: astore 18
    //   2019: aload 19
    //   2021: astore 15
    //   2023: iload 9
    //   2025: istore 6
    //   2027: aload_1
    //   2028: astore 16
    //   2030: aload_0
    //   2031: getfield 70	com/linkedin/android/imageloader/LiImageDecoder:mBitmapFactory	Lcom/linkedin/android/imageloader/interfaces/IBitmapFactory;
    //   2034: aload 20
    //   2036: invokeinterface 342 2 0
    //   2041: goto +399 -> 2440
    //   2044: iload 10
    //   2046: istore 5
    //   2048: aload 4
    //   2050: ifnull +35 -> 2085
    //   2053: aload 19
    //   2055: astore 17
    //   2057: iload 8
    //   2059: istore 7
    //   2061: aload_1
    //   2062: astore 18
    //   2064: aload 19
    //   2066: astore 15
    //   2068: iload 9
    //   2070: istore 6
    //   2072: aload_1
    //   2073: astore 16
    //   2075: aload 4
    //   2077: invokeinterface 174 1 0
    //   2082: iconst_1
    //   2083: istore 5
    //   2085: aload_2
    //   2086: astore 20
    //   2088: aload_3
    //   2089: ifnull +91 -> 2180
    //   2092: aload_2
    //   2093: astore 20
    //   2095: aload_2
    //   2096: ifnull +84 -> 2180
    //   2099: aload 4
    //   2101: ifnull +32 -> 2133
    //   2104: aload 19
    //   2106: astore 17
    //   2108: iload 5
    //   2110: istore 7
    //   2112: aload_1
    //   2113: astore 18
    //   2115: aload 19
    //   2117: astore 15
    //   2119: iload 5
    //   2121: istore 6
    //   2123: aload_1
    //   2124: astore 16
    //   2126: aload 4
    //   2128: invokeinterface 345 1 0
    //   2133: aload_3
    //   2134: invokeinterface 350 1 0
    //   2139: astore_2
    //   2140: aload_2
    //   2141: astore 20
    //   2143: aload 4
    //   2145: ifnull +35 -> 2180
    //   2148: aload 19
    //   2150: astore 17
    //   2152: iload 5
    //   2154: istore 7
    //   2156: aload_1
    //   2157: astore 18
    //   2159: aload 19
    //   2161: astore 15
    //   2163: iload 5
    //   2165: istore 6
    //   2167: aload_1
    //   2168: astore 16
    //   2170: aload 4
    //   2172: invokeinterface 353 1 0
    //   2177: aload_2
    //   2178: astore 20
    //   2180: aload 20
    //   2182: ifnull +191 -> 2373
    //   2185: aload 19
    //   2187: astore 17
    //   2189: iload 5
    //   2191: istore 7
    //   2193: aload_1
    //   2194: astore 18
    //   2196: aload 19
    //   2198: astore 15
    //   2200: iload 5
    //   2202: istore 6
    //   2204: aload_1
    //   2205: astore 16
    //   2207: new 355	com/linkedin/android/imageloader/LiManagedBitmap
    //   2210: dup
    //   2211: aload 20
    //   2213: aload_0
    //   2214: getfield 70	com/linkedin/android/imageloader/LiImageDecoder:mBitmapFactory	Lcom/linkedin/android/imageloader/interfaces/IBitmapFactory;
    //   2217: invokespecial 358	com/linkedin/android/imageloader/LiManagedBitmap:<init>	(Landroid/graphics/Bitmap;Lcom/linkedin/android/imageloader/interfaces/IBitmapFactory;)V
    //   2220: astore_2
    //   2221: aload 4
    //   2223: ifnull +15 -> 2238
    //   2226: iload 5
    //   2228: ifne +10 -> 2238
    //   2231: aload 4
    //   2233: invokeinterface 174 1 0
    //   2238: aload_0
    //   2239: getfield 54	com/linkedin/android/imageloader/LiImageDecoder:mByteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   2242: aload 19
    //   2244: invokevirtual 180	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   2247: aload_1
    //   2248: invokestatic 182	com/linkedin/android/imageloader/LiImageDecoder:closeInputStream	(Ljava/io/InputStream;)V
    //   2251: aload_2
    //   2252: astore_1
    //   2253: goto -1622 -> 631
    //   2256: astore_2
    //   2257: aload 4
    //   2259: ifnull +32 -> 2291
    //   2262: aload 19
    //   2264: astore 17
    //   2266: iload 5
    //   2268: istore 7
    //   2270: aload_1
    //   2271: astore 18
    //   2273: aload 19
    //   2275: astore 15
    //   2277: iload 5
    //   2279: istore 6
    //   2281: aload_1
    //   2282: astore 16
    //   2284: aload 4
    //   2286: invokeinterface 353 1 0
    //   2291: aload 19
    //   2293: astore 17
    //   2295: iload 5
    //   2297: istore 7
    //   2299: aload_1
    //   2300: astore 18
    //   2302: aload 19
    //   2304: astore 15
    //   2306: iload 5
    //   2308: istore 6
    //   2310: aload_1
    //   2311: astore 16
    //   2313: aload_2
    //   2314: athrow
    //   2315: astore_1
    //   2316: aload 17
    //   2318: astore 15
    //   2320: iload 7
    //   2322: istore 6
    //   2324: aload 18
    //   2326: astore 16
    //   2328: getstatic 35	com/linkedin/android/imageloader/LiImageDecoder:TAG	Ljava/lang/String;
    //   2331: ldc_w 360
    //   2334: aload_1
    //   2335: invokestatic 90	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   2338: pop
    //   2339: aload 4
    //   2341: ifnull +15 -> 2356
    //   2344: iload 7
    //   2346: ifne +10 -> 2356
    //   2349: aload 4
    //   2351: invokeinterface 174 1 0
    //   2356: aload_0
    //   2357: getfield 54	com/linkedin/android/imageloader/LiImageDecoder:mByteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   2360: aload 17
    //   2362: invokevirtual 180	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   2365: aload 18
    //   2367: invokestatic 182	com/linkedin/android/imageloader/LiImageDecoder:closeInputStream	(Ljava/io/InputStream;)V
    //   2370: goto +73 -> 2443
    //   2373: aload 4
    //   2375: ifnull +15 -> 2390
    //   2378: iload 5
    //   2380: ifne +10 -> 2390
    //   2383: aload 4
    //   2385: invokeinterface 174 1 0
    //   2390: aload_0
    //   2391: getfield 54	com/linkedin/android/imageloader/LiImageDecoder:mByteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   2394: aload 19
    //   2396: invokevirtual 180	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   2399: aload_1
    //   2400: invokestatic 182	com/linkedin/android/imageloader/LiImageDecoder:closeInputStream	(Ljava/io/InputStream;)V
    //   2403: goto +40 -> 2443
    //   2406: astore_1
    //   2407: aload 4
    //   2409: ifnull +15 -> 2424
    //   2412: iload 6
    //   2414: ifne +10 -> 2424
    //   2417: aload 4
    //   2419: invokeinterface 174 1 0
    //   2424: aload_0
    //   2425: getfield 54	com/linkedin/android/imageloader/LiImageDecoder:mByteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   2428: aload 15
    //   2430: invokevirtual 180	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   2433: aload 16
    //   2435: invokestatic 182	com/linkedin/android/imageloader/LiImageDecoder:closeInputStream	(Ljava/io/InputStream;)V
    //   2438: aload_1
    //   2439: athrow
    //   2440: goto -396 -> 2044
    //   2443: aconst_null
    //   2444: astore_1
    //   2445: goto -1814 -> 631
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2448	0	this	LiImageDecoder
    //   0	2448	1	paramInputStream	InputStream
    //   0	2448	2	paramPair	Pair<Integer, Integer>
    //   0	2448	3	paramImageTransformer	ImageTransformer
    //   0	2448	4	paramPerfEventListener	PerfEventListener
    //   306	2073	5	i	int
    //   48	2365	6	j	int
    //   37	2308	7	k	int
    //   12	2046	8	m	int
    //   15	2054	9	n	int
    //   18	2027	10	i1	int
    //   1166	686	11	i2	int
    //   1195	301	12	i3	int
    //   157	1372	13	l	long
    //   44	2385	15	localObject1	Object
    //   51	2383	16	localObject2	Object
    //   33	2328	17	localObject3	Object
    //   40	2326	18	localObject4	Object
    //   274	2121	19	localObject5	Object
    //   24	2188	20	localObject6	Object
    //   21	1946	21	localMatrix	android.graphics.Matrix
    //   94	1903	22	localObject7	Object
    //   9	1580	23	localOptions	android.graphics.BitmapFactory.Options
    //   186	472	24	localImageType	LiImageHeaderParser.ImageType
    // Exception table:
    //   from	to	target	type
    //   2	11	937	finally
    //   610	617	937	finally
    //   617	629	937	finally
    //   841	848	937	finally
    //   848	860	937	finally
    //   913	920	937	finally
    //   920	932	937	finally
    //   967	974	937	finally
    //   974	986	937	finally
    //   1028	1035	937	finally
    //   1035	1047	937	finally
    //   2231	2238	937	finally
    //   2238	2251	937	finally
    //   2349	2356	937	finally
    //   2356	2370	937	finally
    //   2383	2390	937	finally
    //   2390	2403	937	finally
    //   2417	2424	937	finally
    //   2424	2440	937	finally
    //   479	486	991	java/io/IOException
    //   497	503	991	java/io/IOException
    //   514	521	991	java/io/IOException
    //   532	540	991	java/io/IOException
    //   556	565	991	java/io/IOException
    //   576	585	991	java/io/IOException
    //   596	605	991	java/io/IOException
    //   736	743	991	java/io/IOException
    //   754	761	991	java/io/IOException
    //   772	795	991	java/io/IOException
    //   806	816	991	java/io/IOException
    //   827	836	991	java/io/IOException
    //   876	880	991	java/io/IOException
    //   891	908	991	java/io/IOException
    //   953	962	991	java/io/IOException
    //   2133	2140	2256	finally
    //   53	60	2315	java/io/IOException
    //   82	96	2315	java/io/IOException
    //   121	127	2315	java/io/IOException
    //   149	159	2315	java/io/IOException
    //   181	188	2315	java/io/IOException
    //   210	218	2315	java/io/IOException
    //   240	249	2315	java/io/IOException
    //   271	276	2315	java/io/IOException
    //   298	305	2315	java/io/IOException
    //   330	338	2315	java/io/IOException
    //   360	367	2315	java/io/IOException
    //   389	396	2315	java/io/IOException
    //   418	426	2315	java/io/IOException
    //   448	468	2315	java/io/IOException
    //   657	665	2315	java/io/IOException
    //   687	692	2315	java/io/IOException
    //   717	722	2315	java/io/IOException
    //   1014	1023	2315	java/io/IOException
    //   1074	1080	2315	java/io/IOException
    //   1102	1109	2315	java/io/IOException
    //   1131	1139	2315	java/io/IOException
    //   1161	1168	2315	java/io/IOException
    //   1190	1197	2315	java/io/IOException
    //   1219	1225	2315	java/io/IOException
    //   1247	1259	2315	java/io/IOException
    //   1281	1288	2315	java/io/IOException
    //   1310	1318	2315	java/io/IOException
    //   1340	1346	2315	java/io/IOException
    //   1368	1376	2315	java/io/IOException
    //   1398	1404	2315	java/io/IOException
    //   1426	1437	2315	java/io/IOException
    //   1459	1465	2315	java/io/IOException
    //   1487	1504	2315	java/io/IOException
    //   1526	1533	2315	java/io/IOException
    //   1555	1561	2315	java/io/IOException
    //   1583	1597	2315	java/io/IOException
    //   1644	1651	2315	java/io/IOException
    //   1676	1684	2315	java/io/IOException
    //   1706	1729	2315	java/io/IOException
    //   1751	1759	2315	java/io/IOException
    //   1781	1791	2315	java/io/IOException
    //   1813	1823	2315	java/io/IOException
    //   1845	1864	2315	java/io/IOException
    //   1886	1904	2315	java/io/IOException
    //   1930	1940	2315	java/io/IOException
    //   1962	1974	2315	java/io/IOException
    //   1996	2002	2315	java/io/IOException
    //   2030	2041	2315	java/io/IOException
    //   2075	2082	2315	java/io/IOException
    //   2126	2133	2315	java/io/IOException
    //   2170	2177	2315	java/io/IOException
    //   2207	2221	2315	java/io/IOException
    //   2284	2291	2315	java/io/IOException
    //   2313	2315	2315	java/io/IOException
    //   53	60	2406	finally
    //   82	96	2406	finally
    //   121	127	2406	finally
    //   149	159	2406	finally
    //   181	188	2406	finally
    //   210	218	2406	finally
    //   240	249	2406	finally
    //   271	276	2406	finally
    //   298	305	2406	finally
    //   330	338	2406	finally
    //   360	367	2406	finally
    //   389	396	2406	finally
    //   418	426	2406	finally
    //   448	468	2406	finally
    //   479	486	2406	finally
    //   497	503	2406	finally
    //   514	521	2406	finally
    //   532	540	2406	finally
    //   556	565	2406	finally
    //   576	585	2406	finally
    //   596	605	2406	finally
    //   657	665	2406	finally
    //   687	692	2406	finally
    //   717	722	2406	finally
    //   736	743	2406	finally
    //   754	761	2406	finally
    //   772	795	2406	finally
    //   806	816	2406	finally
    //   827	836	2406	finally
    //   876	880	2406	finally
    //   891	908	2406	finally
    //   953	962	2406	finally
    //   1014	1023	2406	finally
    //   1074	1080	2406	finally
    //   1102	1109	2406	finally
    //   1131	1139	2406	finally
    //   1161	1168	2406	finally
    //   1190	1197	2406	finally
    //   1219	1225	2406	finally
    //   1247	1259	2406	finally
    //   1281	1288	2406	finally
    //   1310	1318	2406	finally
    //   1340	1346	2406	finally
    //   1368	1376	2406	finally
    //   1398	1404	2406	finally
    //   1426	1437	2406	finally
    //   1459	1465	2406	finally
    //   1487	1504	2406	finally
    //   1526	1533	2406	finally
    //   1555	1561	2406	finally
    //   1583	1597	2406	finally
    //   1644	1651	2406	finally
    //   1676	1684	2406	finally
    //   1706	1729	2406	finally
    //   1751	1759	2406	finally
    //   1781	1791	2406	finally
    //   1813	1823	2406	finally
    //   1845	1864	2406	finally
    //   1886	1904	2406	finally
    //   1930	1940	2406	finally
    //   1962	1974	2406	finally
    //   1996	2002	2406	finally
    //   2030	2041	2406	finally
    //   2075	2082	2406	finally
    //   2126	2133	2406	finally
    //   2170	2177	2406	finally
    //   2207	2221	2406	finally
    //   2284	2291	2406	finally
    //   2313	2315	2406	finally
    //   2328	2339	2406	finally
  }
  
  private static int findBestSampleSize(Context paramContext, int paramInt1, int paramInt2, Pair<Integer, Integer> paramPair)
  {
    int j;
    if (paramPair != null) {
      j = ((Integer)first).intValue();
    }
    float f;
    int k;
    for (int i = ((Integer)second).intValue();; i = getResizedDimension(k, i, paramInt2, paramInt1))
    {
      double d = Math.min(paramInt1 / j, paramInt2 / i);
      for (f = 1.0F; 2.0F * f <= d; f *= 2.0F) {}
      paramContext = paramContext.getResources().getDisplayMetrics();
      i = Math.max(heightPixels, widthPixels);
      k = Math.max(heightPixels, widthPixels);
      j = getResizedDimension(i, k, paramInt1, paramInt2);
    }
    return (int)f;
  }
  
  private LiImageHeaderParser.ImageType getImageType(InputStream paramInputStream)
  {
    LiImageHeaderParser.ImageType localImageType = LiImageHeaderParser.ImageType.UNKNOWN;
    try
    {
      paramInputStream = new LiImageHeaderParser(paramInputStream, mByteArrayPool);
      int i = reader.getUInt16();
      if (i == 65496) {
        return LiImageHeaderParser.ImageType.JPEG;
      }
      i = i << 16 & 0xFFFF0000 | reader.getUInt16() & 0xFFFF;
      if (i == -1991225785)
      {
        reader.skip(21L);
        if (reader.is.read() >= 3) {
          return LiImageHeaderParser.ImageType.PNG_A;
        }
        return LiImageHeaderParser.ImageType.PNG;
      }
      if (i >> 8 == 4671814) {
        return LiImageHeaderParser.ImageType.GIF;
      }
      paramInputStream = LiImageHeaderParser.ImageType.UNKNOWN;
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      Log.e(TAG, paramInputStream.getMessage(), paramInputStream);
    }
    return localImageType;
  }
  
  private int getOrientation(InputStream paramInputStream)
  {
    try
    {
      int i = new LiImageHeaderParser(paramInputStream, mByteArrayPool).getOrientation();
      return i;
    }
    catch (IOException paramInputStream)
    {
      Log.e(TAG, paramInputStream.getMessage(), paramInputStream);
    }
    return 0;
  }
  
  private static int getResizedDimension(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return paramInt3;
    }
    if (paramInt1 == 0)
    {
      d = paramInt2 / paramInt4;
      return (int)(paramInt3 * d);
    }
    if (paramInt2 == 0) {
      return paramInt1;
    }
    double d = paramInt4 / paramInt3;
    paramInt3 = paramInt1;
    if (paramInt1 * d > paramInt2) {
      paramInt3 = (int)(paramInt2 / d);
    }
    return paramInt3;
  }
  
  public final ManagedBitmap decode(int paramInt, Pair<Integer, Integer> paramPair, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
  {
    return doDecode(mContext.getResources().openRawResource(paramInt), paramPair, paramImageTransformer, paramPerfEventListener);
  }
  
  public final ManagedBitmap decode(Uri paramUri, Pair<Integer, Integer> paramPair, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
  {
    try
    {
      InputStream localInputStream = mContext.getContentResolver().openInputStream(paramUri);
      if (localInputStream == null)
      {
        Log.e(TAG, "Failed to read bitmap; Could not resolve " + paramUri);
        return null;
      }
      paramPair = doDecode(localInputStream, paramPair, paramImageTransformer, paramPerfEventListener);
      return paramPair;
    }
    catch (FileNotFoundException paramPair)
    {
      Log.e(TAG, "Failed to read bitmap; Could not resolve " + paramUri, paramPair);
    }
    return null;
  }
  
  public final ManagedBitmap decode(InputStream paramInputStream, Pair<Integer, Integer> paramPair, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
  {
    return doDecode(paramInputStream, paramPair, paramImageTransformer, paramPerfEventListener);
  }
  
  public final ManagedBitmap decode(String paramString, Pair<Integer, Integer> paramPair, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
  {
    try
    {
      paramString = doDecode(new FileInputStream(paramString), paramPair, paramImageTransformer, paramPerfEventListener);
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      Log.e(TAG, "Failed to read bitmap; file not found", paramString);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.LiImageDecoder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */