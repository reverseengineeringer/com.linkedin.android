package com.linkedin.CrossPromoLib.models;

import android.text.TextUtils;
import android.util.Log;
import com.linkedin.android.datamanager.DataManager;
import com.linkedin.crosspromo.common.android.RichText;
import com.linkedin.crosspromo.fe.api.android.Image;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateParser;
import com.linkedin.data.lite.DataTemplateParserFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PromoModel
{
  private static final String TAG = PromoModel.class.getSimpleName();
  public Promo promo;
  
  public PromoModel(Promo paramPromo)
  {
    promo = paramPromo;
  }
  
  public PromoModel(byte[] paramArrayOfByte)
  {
    this(jsonToPromo(paramArrayOfByte));
  }
  
  private static Promo jsonToPromo(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length <= 0) {
      return null;
    }
    Object localObject1 = DataManager.PARSER_FACTORY.createParser();
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    try
    {
      localObject1 = (Promo)((DataTemplateParser)localObject1).parseRecord(paramArrayOfByte, Promo.BUILDER);
      try
      {
        paramArrayOfByte.close();
        return (Promo)localObject1;
      }
      catch (IOException paramArrayOfByte)
      {
        Log.e(TAG, "Error closing parser:", paramArrayOfByte);
        return (Promo)localObject1;
      }
      try
      {
        paramArrayOfByte.close();
        throw ((Throwable)localObject2);
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          Log.e(TAG, "Error closing parser:", paramArrayOfByte);
        }
      }
    }
    catch (DataReaderException localDataReaderException)
    {
      localDataReaderException = localDataReaderException;
      Log.e(TAG, "Unable to convert response byte[] into Promo");
      try
      {
        paramArrayOfByte.close();
        return null;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          Log.e(TAG, "Error closing parser:", paramArrayOfByte);
        }
      }
    }
    finally {}
  }
  
  public final Image getImageFromModel(String paramString)
  {
    if (promo.images == null) {
      return null;
    }
    return (Image)promo.images.get(paramString);
  }
  
  /* Error */
  public final byte[] getPostBody(com.linkedin.crosspromo.fe.api.android.MetricsInfo paramMetricsInfo)
  {
    // Byte code:
    //   0: getstatic 104	com/linkedin/android/datamanager/DataManager:GENERATOR_FACTORY	Lcom/linkedin/data/lite/JsonGeneratorFactory;
    //   3: invokeinterface 110 1 0
    //   8: astore_3
    //   9: new 112	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 113	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore 4
    //   18: new 115	java/io/OutputStreamWriter
    //   21: dup
    //   22: aload 4
    //   24: invokespecial 118	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_2
    //   28: new 120	com/linkedin/crosspromo/fe/api/android/LegoTrackingEvent$Builder
    //   31: dup
    //   32: invokespecial 121	com/linkedin/crosspromo/fe/api/android/LegoTrackingEvent$Builder:<init>	()V
    //   35: astore 5
    //   37: aload_0
    //   38: getfield 25	com/linkedin/CrossPromoLib/models/PromoModel:promo	Lcom/linkedin/crosspromo/fe/api/android/Promo;
    //   41: getfield 124	com/linkedin/crosspromo/fe/api/android/Promo:legoTrackingToken	Ljava/lang/String;
    //   44: astore 6
    //   46: aload 6
    //   48: ifnonnull +83 -> 131
    //   51: aload 5
    //   53: iconst_0
    //   54: putfield 128	com/linkedin/crosspromo/fe/api/android/LegoTrackingEvent$Builder:hasLegoTrackingToken	Z
    //   57: aload 5
    //   59: aconst_null
    //   60: putfield 129	com/linkedin/crosspromo/fe/api/android/LegoTrackingEvent$Builder:legoTrackingToken	Ljava/lang/String;
    //   63: iconst_2
    //   64: anewarray 131	com/linkedin/crosspromo/fe/api/android/MetricsInfo
    //   67: dup
    //   68: iconst_0
    //   69: aload_1
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload_0
    //   74: getfield 25	com/linkedin/CrossPromoLib/models/PromoModel:promo	Lcom/linkedin/crosspromo/fe/api/android/Promo;
    //   77: getfield 135	com/linkedin/crosspromo/fe/api/android/Promo:metricsObject	Lcom/linkedin/crosspromo/fe/api/android/MetricsInfo;
    //   80: aastore
    //   81: invokestatic 141	com/linkedin/CrossPromoLib/utils/PromoUtils:firstNonNull	([Ljava/lang/Object;)Ljava/lang/Object;
    //   84: checkcast 131	com/linkedin/crosspromo/fe/api/android/MetricsInfo
    //   87: astore_1
    //   88: aload_1
    //   89: ifnonnull +75 -> 164
    //   92: aload 5
    //   94: iconst_0
    //   95: putfield 144	com/linkedin/crosspromo/fe/api/android/LegoTrackingEvent$Builder:hasMetricsObject	Z
    //   98: aload 5
    //   100: aconst_null
    //   101: putfield 145	com/linkedin/crosspromo/fe/api/android/LegoTrackingEvent$Builder:metricsObject	Lcom/linkedin/crosspromo/fe/api/android/MetricsInfo;
    //   104: aload_3
    //   105: aload 5
    //   107: getstatic 151	com/linkedin/data/lite/RecordTemplate$Flavor:RECORD	Lcom/linkedin/data/lite/RecordTemplate$Flavor;
    //   110: invokevirtual 155	com/linkedin/crosspromo/fe/api/android/LegoTrackingEvent$Builder:build	(Lcom/linkedin/data/lite/RecordTemplate$Flavor;)Lcom/linkedin/crosspromo/fe/api/android/LegoTrackingEvent;
    //   113: aload_2
    //   114: invokeinterface 161 3 0
    //   119: aload 4
    //   121: invokevirtual 165	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   124: astore_1
    //   125: aload_2
    //   126: invokevirtual 168	java/io/Writer:close	()V
    //   129: aload_1
    //   130: areturn
    //   131: aload 5
    //   133: iconst_1
    //   134: putfield 128	com/linkedin/crosspromo/fe/api/android/LegoTrackingEvent$Builder:hasLegoTrackingToken	Z
    //   137: aload 5
    //   139: aload 6
    //   141: putfield 129	com/linkedin/crosspromo/fe/api/android/LegoTrackingEvent$Builder:legoTrackingToken	Ljava/lang/String;
    //   144: goto -81 -> 63
    //   147: astore_1
    //   148: getstatic 18	com/linkedin/CrossPromoLib/models/PromoModel:TAG	Ljava/lang/String;
    //   151: ldc -86
    //   153: aload_1
    //   154: invokestatic 77	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   157: pop
    //   158: aload_2
    //   159: invokevirtual 168	java/io/Writer:close	()V
    //   162: aconst_null
    //   163: areturn
    //   164: aload 5
    //   166: iconst_1
    //   167: putfield 144	com/linkedin/crosspromo/fe/api/android/LegoTrackingEvent$Builder:hasMetricsObject	Z
    //   170: aload 5
    //   172: aload_1
    //   173: putfield 145	com/linkedin/crosspromo/fe/api/android/LegoTrackingEvent$Builder:metricsObject	Lcom/linkedin/crosspromo/fe/api/android/MetricsInfo;
    //   176: goto -72 -> 104
    //   179: astore_1
    //   180: aload_2
    //   181: invokevirtual 168	java/io/Writer:close	()V
    //   184: aload_1
    //   185: athrow
    //   186: astore_2
    //   187: getstatic 18	com/linkedin/CrossPromoLib/models/PromoModel:TAG	Ljava/lang/String;
    //   190: ldc -84
    //   192: aload_2
    //   193: invokestatic 77	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   196: pop
    //   197: aload_1
    //   198: areturn
    //   199: astore_1
    //   200: getstatic 18	com/linkedin/CrossPromoLib/models/PromoModel:TAG	Ljava/lang/String;
    //   203: ldc -84
    //   205: aload_1
    //   206: invokestatic 77	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   209: pop
    //   210: goto -48 -> 162
    //   213: astore_2
    //   214: getstatic 18	com/linkedin/CrossPromoLib/models/PromoModel:TAG	Ljava/lang/String;
    //   217: ldc -84
    //   219: aload_2
    //   220: invokestatic 77	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   223: pop
    //   224: goto -40 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	PromoModel
    //   0	227	1	paramMetricsInfo	com.linkedin.crosspromo.fe.api.android.MetricsInfo
    //   27	154	2	localOutputStreamWriter	java.io.OutputStreamWriter
    //   186	7	2	localIOException1	IOException
    //   213	7	2	localIOException2	IOException
    //   8	97	3	localJsonGenerator	com.linkedin.data.lite.JsonGenerator
    //   16	104	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   35	136	5	localBuilder	com.linkedin.crosspromo.fe.api.android.LegoTrackingEvent.Builder
    //   44	96	6	str	String
    // Exception table:
    //   from	to	target	type
    //   28	46	147	java/lang/Exception
    //   51	63	147	java/lang/Exception
    //   63	88	147	java/lang/Exception
    //   92	104	147	java/lang/Exception
    //   104	125	147	java/lang/Exception
    //   131	144	147	java/lang/Exception
    //   164	176	147	java/lang/Exception
    //   28	46	179	finally
    //   51	63	179	finally
    //   63	88	179	finally
    //   92	104	179	finally
    //   104	125	179	finally
    //   131	144	179	finally
    //   148	158	179	finally
    //   164	176	179	finally
    //   125	129	186	java/io/IOException
    //   158	162	199	java/io/IOException
    //   180	184	213	java/io/IOException
  }
  
  public final RichText getPromptTextDownload()
  {
    RichText localRichText2 = getRichTextFromModel("download");
    RichText localRichText1;
    if ((localRichText2 != null) && (hasRawText))
    {
      localRichText1 = localRichText2;
      if (!TextUtils.isEmpty(rawText)) {}
    }
    else
    {
      localRichText1 = getRichTextFromModel("open");
    }
    return localRichText1;
  }
  
  public final RichText getPromptTextOpen()
  {
    RichText localRichText2 = getRichTextFromModel("open");
    RichText localRichText1;
    if ((localRichText2 != null) && (hasRawText))
    {
      localRichText1 = localRichText2;
      if (!TextUtils.isEmpty(rawText)) {}
    }
    else
    {
      localRichText1 = getRichTextFromModel("download");
    }
    return localRichText1;
  }
  
  public final RichText getRichTextFromModel(String paramString)
  {
    if (promo.texts == null) {
      return null;
    }
    return (RichText)promo.texts.get(paramString);
  }
  
  public final List<Image> getRollupImages()
  {
    ArrayList localArrayList = new ArrayList(5);
    localArrayList.add(getImageFromModel("background0"));
    localArrayList.add(getImageFromModel("background1"));
    localArrayList.add(getImageFromModel("background2"));
    localArrayList.add(getImageFromModel("background3"));
    localArrayList.add(getImageFromModel("background4"));
    return localArrayList;
  }
  
  public final RichText getText()
  {
    RichText localRichText2 = getRichTextFromModel("main");
    RichText localRichText1 = localRichText2;
    if (localRichText2 == null) {
      localRichText1 = getRichTextFromModel("title");
    }
    return localRichText1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.models.PromoModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */