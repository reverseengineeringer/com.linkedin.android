package com.linkedin.android.datamanager.multiplex;

import com.linkedin.android.datamanager.interfaces.EventListener;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import com.linkedin.data.lite.json.CharArrayReader;
import com.linkedin.data.lite.json.FastJsonParser;
import com.linkedin.data.lite.json.FastJsonStreamReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public final class IndividualResponseBuilder
  implements DataTemplateBuilder<IndividualResponse>
{
  private static final JsonKeyStore JSON_KEY_STORE;
  private final DataTemplateBuilder dataTemplateBuilder;
  private final EventListener eventListener;
  private final String requestUrl;
  private final String trackingSessionId;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("status");
    JSON_KEY_STORE.put("headers");
    JSON_KEY_STORE.put("body");
  }
  
  IndividualResponseBuilder(DataTemplateBuilder paramDataTemplateBuilder, String paramString1, EventListener paramEventListener, String paramString2)
  {
    dataTemplateBuilder = paramDataTemplateBuilder;
    trackingSessionId = paramString1;
    eventListener = paramEventListener;
    requestUrl = paramString2;
  }
  
  /* Error */
  public final IndividualResponse build(com.linkedin.data.lite.DataReader paramDataReader)
    throws com.linkedin.data.lite.DataReaderException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 15
    //   5: aconst_null
    //   6: astore 20
    //   8: aconst_null
    //   9: astore 16
    //   11: aconst_null
    //   12: astore 13
    //   14: aconst_null
    //   15: astore 14
    //   17: lconst_0
    //   18: lstore 5
    //   20: aconst_null
    //   21: astore 19
    //   23: iconst_0
    //   24: istore 10
    //   26: iconst_0
    //   27: istore 9
    //   29: iconst_0
    //   30: istore 12
    //   32: aload_1
    //   33: invokeinterface 68 1 0
    //   38: aload_1
    //   39: invokeinterface 72 1 0
    //   44: ifeq +369 -> 413
    //   47: aload_1
    //   48: ldc 38
    //   50: getstatic 36	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:JSON_KEY_STORE	Lcom/linkedin/data/lite/JsonKeyStore;
    //   53: invokeinterface 76 3 0
    //   58: ifeq +22 -> 80
    //   61: aload_1
    //   62: invokeinterface 79 1 0
    //   67: aload_1
    //   68: invokeinterface 83 1 0
    //   73: istore_2
    //   74: iconst_1
    //   75: istore 10
    //   77: goto -39 -> 38
    //   80: aload_1
    //   81: ldc 46
    //   83: getstatic 36	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:JSON_KEY_STORE	Lcom/linkedin/data/lite/JsonKeyStore;
    //   86: invokeinterface 76 3 0
    //   91: ifeq +78 -> 169
    //   94: aload_1
    //   95: invokeinterface 79 1 0
    //   100: new 85	android/support/v4/util/ArrayMap
    //   103: dup
    //   104: invokespecial 86	android/support/v4/util/ArrayMap:<init>	()V
    //   107: astore 15
    //   109: aload_1
    //   110: invokeinterface 89 1 0
    //   115: ifeq +48 -> 163
    //   118: aload_1
    //   119: invokeinterface 92 1 0
    //   124: ifeq +39 -> 163
    //   127: aload_1
    //   128: invokeinterface 96 1 0
    //   133: astore 17
    //   135: aload_1
    //   136: invokeinterface 99 1 0
    //   141: astore 18
    //   143: aload 18
    //   145: ifnull -27 -> 118
    //   148: aload 15
    //   150: aload 17
    //   152: aload 18
    //   154: invokeinterface 104 3 0
    //   159: pop
    //   160: goto -42 -> 118
    //   163: iconst_1
    //   164: istore 9
    //   166: goto -128 -> 38
    //   169: aload_0
    //   170: getfield 53	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:dataTemplateBuilder	Lcom/linkedin/data/lite/DataTemplateBuilder;
    //   173: ifnull +231 -> 404
    //   176: aload_1
    //   177: ldc 48
    //   179: getstatic 36	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:JSON_KEY_STORE	Lcom/linkedin/data/lite/JsonKeyStore;
    //   182: invokeinterface 76 3 0
    //   187: ifeq +217 -> 404
    //   190: aload_1
    //   191: instanceof 106
    //   194: ifeq +50 -> 244
    //   197: aload_1
    //   198: checkcast 106	com/linkedin/data/lite/json/FastJsonParser
    //   201: astore 14
    //   203: aload 14
    //   205: invokevirtual 107	com/linkedin/data/lite/json/FastJsonParser:startField	()V
    //   208: aload 14
    //   210: invokevirtual 111	com/linkedin/data/lite/json/FastJsonParser:getCharOffset	()J
    //   213: l2i
    //   214: istore_3
    //   215: aload 14
    //   217: aconst_null
    //   218: invokevirtual 115	com/linkedin/data/lite/json/FastJsonParser:skipJsonAndAppend	(Ljava/lang/StringBuilder;)V
    //   221: new 14	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$CharArraySection
    //   224: dup
    //   225: aload 14
    //   227: iload_3
    //   228: aload 14
    //   230: invokevirtual 111	com/linkedin/data/lite/json/FastJsonParser:getCharOffset	()J
    //   233: l2i
    //   234: iload_3
    //   235: isub
    //   236: invokespecial 118	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$CharArraySection:<init>	(Lcom/linkedin/data/lite/json/FastJsonParser;II)V
    //   239: astore 14
    //   241: goto -203 -> 38
    //   244: aload_1
    //   245: invokeinterface 121 1 0
    //   250: l2i
    //   251: iconst_1
    //   252: isub
    //   253: istore_3
    //   254: aload_1
    //   255: invokeinterface 124 1 0
    //   260: aload_1
    //   261: invokeinterface 121 1 0
    //   266: l2i
    //   267: istore 4
    //   269: aload_1
    //   270: invokeinterface 128 1 0
    //   275: astore 13
    //   277: aload 13
    //   279: instanceof 130
    //   282: ifeq +30 -> 312
    //   285: new 11	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$ByteArraySection
    //   288: dup
    //   289: aload 13
    //   291: checkcast 130	[B
    //   294: checkcast 130	[B
    //   297: iload_3
    //   298: iload 4
    //   300: iload_3
    //   301: isub
    //   302: iconst_1
    //   303: iadd
    //   304: invokespecial 133	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$ByteArraySection:<init>	([BII)V
    //   307: astore 13
    //   309: goto -271 -> 38
    //   312: aload 13
    //   314: instanceof 135
    //   317: ifeq +40 -> 357
    //   320: new 11	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$ByteArraySection
    //   323: dup
    //   324: aload 13
    //   326: checkcast 135	com/linkedin/android/networking/streams/CachingInputStream
    //   329: getfield 139	com/linkedin/android/networking/streams/CachingInputStream:outputStream	Lcom/linkedin/android/networking/streams/ChunkableByteArrayOutputStream;
    //   332: iload_3
    //   333: iload 4
    //   335: iload_3
    //   336: isub
    //   337: iconst_1
    //   338: iadd
    //   339: invokevirtual 145	com/linkedin/android/networking/streams/ChunkableByteArrayOutputStream:getBuf	(II)[B
    //   342: iconst_0
    //   343: iload 4
    //   345: iload_3
    //   346: isub
    //   347: iconst_1
    //   348: iadd
    //   349: invokespecial 133	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$ByteArraySection:<init>	([BII)V
    //   352: astore 13
    //   354: goto -45 -> 309
    //   357: new 147	java/lang/StringBuilder
    //   360: dup
    //   361: ldc -107
    //   363: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   366: astore 14
    //   368: aload 13
    //   370: ifnonnull +22 -> 392
    //   373: aconst_null
    //   374: astore_1
    //   375: new 153	java/lang/UnsupportedOperationException
    //   378: dup
    //   379: aload 14
    //   381: aload_1
    //   382: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokespecial 161	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   391: athrow
    //   392: aload 13
    //   394: invokevirtual 165	java/lang/Object:getClass	()Ljava/lang/Class;
    //   397: invokevirtual 170	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   400: astore_1
    //   401: goto -26 -> 375
    //   404: aload_1
    //   405: invokeinterface 124 1 0
    //   410: goto -372 -> 38
    //   413: aload 15
    //   415: astore 17
    //   417: iload 9
    //   419: ifne +8 -> 427
    //   422: invokestatic 176	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   425: astore 17
    //   427: iload 10
    //   429: ifne +13 -> 442
    //   432: new 63	com/linkedin/data/lite/DataReaderException
    //   435: dup
    //   436: ldc -78
    //   438: invokespecial 179	com/linkedin/data/lite/DataReaderException:<init>	(Ljava/lang/String;)V
    //   441: athrow
    //   442: aload 13
    //   444: ifnonnull +20 -> 464
    //   447: iload 12
    //   449: istore 11
    //   451: lload 5
    //   453: lstore 7
    //   455: aload 19
    //   457: astore 18
    //   459: aload 14
    //   461: ifnull +229 -> 690
    //   464: aload_0
    //   465: getfield 55	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:trackingSessionId	Ljava/lang/String;
    //   468: ifnull +27 -> 495
    //   471: aload_0
    //   472: getfield 57	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:eventListener	Lcom/linkedin/android/datamanager/interfaces/EventListener;
    //   475: ifnull +20 -> 495
    //   478: aload_0
    //   479: getfield 57	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:eventListener	Lcom/linkedin/android/datamanager/interfaces/EventListener;
    //   482: aload_0
    //   483: getfield 55	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:trackingSessionId	Ljava/lang/String;
    //   486: aload_0
    //   487: getfield 59	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:requestUrl	Ljava/lang/String;
    //   490: invokeinterface 185 3 0
    //   495: aload 13
    //   497: ifnull +216 -> 713
    //   500: new 187	java/io/ByteArrayInputStream
    //   503: dup
    //   504: aload 13
    //   506: getfield 190	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$ByteArraySection:sourceArray	[B
    //   509: aload 13
    //   511: getfield 194	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$ByteArraySection:start	I
    //   514: aload 13
    //   516: getfield 197	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$ByteArraySection:length	I
    //   519: invokespecial 198	java/io/ByteArrayInputStream:<init>	([BII)V
    //   522: astore 15
    //   524: new 200	com/linkedin/android/datamanager/multiplex/IndividualBody
    //   527: dup
    //   528: getstatic 206	com/linkedin/android/datamanager/DataManager:PARSER_FACTORY	Lcom/linkedin/data/lite/DataTemplateParserFactory;
    //   531: invokeinterface 212 1 0
    //   536: aload 15
    //   538: aload_0
    //   539: getfield 53	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:dataTemplateBuilder	Lcom/linkedin/data/lite/DataTemplateBuilder;
    //   542: invokeinterface 218 3 0
    //   547: invokespecial 221	com/linkedin/android/datamanager/multiplex/IndividualBody:<init>	(Lcom/linkedin/data/lite/RecordTemplate;)V
    //   550: astore 15
    //   552: aload 15
    //   554: astore 16
    //   556: aload 15
    //   558: astore 16
    //   560: aload 13
    //   562: getfield 197	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$ByteArraySection:length	I
    //   565: istore_3
    //   566: iload_3
    //   567: i2l
    //   568: lstore 5
    //   570: aload 15
    //   572: astore 14
    //   574: iconst_1
    //   575: istore 12
    //   577: aload 13
    //   579: ifnull +32 -> 611
    //   582: aload_1
    //   583: invokeinterface 128 1 0
    //   588: instanceof 135
    //   591: ifeq +20 -> 611
    //   594: aload_1
    //   595: invokeinterface 128 1 0
    //   600: checkcast 135	com/linkedin/android/networking/streams/CachingInputStream
    //   603: aload 13
    //   605: getfield 190	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$ByteArraySection:sourceArray	[B
    //   608: invokevirtual 225	com/linkedin/android/networking/streams/CachingInputStream:returnBuf	([B)V
    //   611: aload 14
    //   613: astore 16
    //   615: iload 12
    //   617: istore 11
    //   619: lload 5
    //   621: lstore 7
    //   623: aload 19
    //   625: astore 18
    //   627: aload_0
    //   628: getfield 55	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:trackingSessionId	Ljava/lang/String;
    //   631: ifnull +59 -> 690
    //   634: aload 14
    //   636: astore 16
    //   638: iload 12
    //   640: istore 11
    //   642: lload 5
    //   644: lstore 7
    //   646: aload 19
    //   648: astore 18
    //   650: aload_0
    //   651: getfield 57	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:eventListener	Lcom/linkedin/android/datamanager/interfaces/EventListener;
    //   654: ifnull +36 -> 690
    //   657: aload_0
    //   658: getfield 57	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:eventListener	Lcom/linkedin/android/datamanager/interfaces/EventListener;
    //   661: aload_0
    //   662: getfield 55	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:trackingSessionId	Ljava/lang/String;
    //   665: aload_0
    //   666: getfield 59	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:requestUrl	Ljava/lang/String;
    //   669: invokeinterface 228 3 0
    //   674: aload 19
    //   676: astore 18
    //   678: lload 5
    //   680: lstore 7
    //   682: iload 12
    //   684: istore 11
    //   686: aload 14
    //   688: astore 16
    //   690: new 230	com/linkedin/android/datamanager/multiplex/IndividualResponse
    //   693: dup
    //   694: iload_2
    //   695: aload 17
    //   697: aload 16
    //   699: iload 10
    //   701: iload 9
    //   703: iload 11
    //   705: lload 7
    //   707: aload 18
    //   709: invokespecial 233	com/linkedin/android/datamanager/multiplex/IndividualResponse:<init>	(ILjava/util/Map;Lcom/linkedin/android/datamanager/multiplex/IndividualBody;ZZZJLcom/linkedin/android/datamanager/DataManagerException;)V
    //   712: areturn
    //   713: new 200	com/linkedin/android/datamanager/multiplex/IndividualBody
    //   716: dup
    //   717: getstatic 206	com/linkedin/android/datamanager/DataManager:PARSER_FACTORY	Lcom/linkedin/data/lite/DataTemplateParserFactory;
    //   720: invokeinterface 212 1 0
    //   725: aload 14
    //   727: invokevirtual 237	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$CharArraySection:reader	()Ljava/io/Reader;
    //   730: aload_0
    //   731: getfield 53	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:dataTemplateBuilder	Lcom/linkedin/data/lite/DataTemplateBuilder;
    //   734: invokeinterface 240 3 0
    //   739: invokespecial 221	com/linkedin/android/datamanager/multiplex/IndividualBody:<init>	(Lcom/linkedin/data/lite/RecordTemplate;)V
    //   742: astore 15
    //   744: aload 15
    //   746: astore 16
    //   748: aload 15
    //   750: astore 16
    //   752: aload 14
    //   754: getfield 241	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$CharArraySection:length	I
    //   757: istore_3
    //   758: iload_3
    //   759: i2l
    //   760: lstore 5
    //   762: aload 15
    //   764: astore 14
    //   766: goto -192 -> 574
    //   769: astore 16
    //   771: aload 20
    //   773: astore 15
    //   775: new 85	android/support/v4/util/ArrayMap
    //   778: dup
    //   779: invokespecial 86	android/support/v4/util/ArrayMap:<init>	()V
    //   782: astore 18
    //   784: aload 17
    //   786: invokeinterface 245 1 0
    //   791: invokeinterface 251 1 0
    //   796: astore 19
    //   798: aload 19
    //   800: invokeinterface 256 1 0
    //   805: ifeq +113 -> 918
    //   808: aload 19
    //   810: invokeinterface 259 1 0
    //   815: checkcast 261	java/util/Map$Entry
    //   818: astore 20
    //   820: aload 18
    //   822: aload 20
    //   824: invokeinterface 264 1 0
    //   829: aload 20
    //   831: invokeinterface 267 1 0
    //   836: invokestatic 271	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   839: invokeinterface 104 3 0
    //   844: pop
    //   845: goto -47 -> 798
    //   848: astore 14
    //   850: aload 13
    //   852: ifnull +32 -> 884
    //   855: aload_1
    //   856: invokeinterface 128 1 0
    //   861: instanceof 135
    //   864: ifeq +20 -> 884
    //   867: aload_1
    //   868: invokeinterface 128 1 0
    //   873: checkcast 135	com/linkedin/android/networking/streams/CachingInputStream
    //   876: aload 13
    //   878: getfield 190	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$ByteArraySection:sourceArray	[B
    //   881: invokevirtual 225	com/linkedin/android/networking/streams/CachingInputStream:returnBuf	([B)V
    //   884: aload_0
    //   885: getfield 55	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:trackingSessionId	Ljava/lang/String;
    //   888: ifnull +27 -> 915
    //   891: aload_0
    //   892: getfield 57	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:eventListener	Lcom/linkedin/android/datamanager/interfaces/EventListener;
    //   895: ifnull +20 -> 915
    //   898: aload_0
    //   899: getfield 57	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:eventListener	Lcom/linkedin/android/datamanager/interfaces/EventListener;
    //   902: aload_0
    //   903: getfield 55	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:trackingSessionId	Ljava/lang/String;
    //   906: aload_0
    //   907: getfield 59	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:requestUrl	Ljava/lang/String;
    //   910: invokeinterface 228 3 0
    //   915: aload 14
    //   917: athrow
    //   918: aload 13
    //   920: ifnull +7 -> 927
    //   923: aload 13
    //   925: astore 14
    //   927: new 273	com/linkedin/android/datamanager/DataManagerException
    //   930: dup
    //   931: aload 16
    //   933: new 9	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$1
    //   936: dup
    //   937: aload_0
    //   938: iload_2
    //   939: aload 18
    //   941: aload 14
    //   943: invokespecial 276	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$1:<init>	(Lcom/linkedin/android/datamanager/multiplex/IndividualResponseBuilder;ILjava/util/Map;Lcom/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$Section;)V
    //   946: invokespecial 279	com/linkedin/android/datamanager/DataManagerException:<init>	(Ljava/lang/Throwable;Lcom/linkedin/android/networking/interfaces/RawResponse;)V
    //   949: astore 14
    //   951: aload 13
    //   953: ifnull +32 -> 985
    //   956: aload_1
    //   957: invokeinterface 128 1 0
    //   962: instanceof 135
    //   965: ifeq +20 -> 985
    //   968: aload_1
    //   969: invokeinterface 128 1 0
    //   974: checkcast 135	com/linkedin/android/networking/streams/CachingInputStream
    //   977: aload 13
    //   979: getfield 190	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder$ByteArraySection:sourceArray	[B
    //   982: invokevirtual 225	com/linkedin/android/networking/streams/CachingInputStream:returnBuf	([B)V
    //   985: aload 15
    //   987: astore 16
    //   989: iload 12
    //   991: istore 11
    //   993: lload 5
    //   995: lstore 7
    //   997: aload 14
    //   999: astore 18
    //   1001: aload_0
    //   1002: getfield 55	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:trackingSessionId	Ljava/lang/String;
    //   1005: ifnull -315 -> 690
    //   1008: aload 15
    //   1010: astore 16
    //   1012: iload 12
    //   1014: istore 11
    //   1016: lload 5
    //   1018: lstore 7
    //   1020: aload 14
    //   1022: astore 18
    //   1024: aload_0
    //   1025: getfield 57	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:eventListener	Lcom/linkedin/android/datamanager/interfaces/EventListener;
    //   1028: ifnull -338 -> 690
    //   1031: aload_0
    //   1032: getfield 57	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:eventListener	Lcom/linkedin/android/datamanager/interfaces/EventListener;
    //   1035: aload_0
    //   1036: getfield 55	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:trackingSessionId	Ljava/lang/String;
    //   1039: aload_0
    //   1040: getfield 59	com/linkedin/android/datamanager/multiplex/IndividualResponseBuilder:requestUrl	Ljava/lang/String;
    //   1043: invokeinterface 228 3 0
    //   1048: aload 15
    //   1050: astore 16
    //   1052: iload 12
    //   1054: istore 11
    //   1056: lload 5
    //   1058: lstore 7
    //   1060: aload 14
    //   1062: astore 18
    //   1064: goto -374 -> 690
    //   1067: astore 14
    //   1069: goto -219 -> 850
    //   1072: astore 18
    //   1074: aload 16
    //   1076: astore 15
    //   1078: aload 18
    //   1080: astore 16
    //   1082: goto -307 -> 775
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1085	0	this	IndividualResponseBuilder
    //   0	1085	1	paramDataReader	com.linkedin.data.lite.DataReader
    //   1	938	2	i	int
    //   214	545	3	j	int
    //   267	80	4	k	int
    //   18	1039	5	l1	long
    //   453	606	7	l2	long
    //   27	675	9	bool1	boolean
    //   24	676	10	bool2	boolean
    //   449	606	11	bool3	boolean
    //   30	1023	12	bool4	boolean
    //   12	966	13	localObject1	Object
    //   15	750	14	localObject2	Object
    //   848	68	14	localObject3	Object
    //   925	136	14	localObject4	Object
    //   1067	1	14	localObject5	Object
    //   3	1074	15	localObject6	Object
    //   9	742	16	localObject7	Object
    //   769	163	16	localDataReaderException1	com.linkedin.data.lite.DataReaderException
    //   987	94	16	localObject8	Object
    //   133	652	17	localObject9	Object
    //   141	922	18	localObject10	Object
    //   1072	7	18	localDataReaderException2	com.linkedin.data.lite.DataReaderException
    //   21	788	19	localIterator	java.util.Iterator
    //   6	824	20	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   464	495	769	com/linkedin/data/lite/DataReaderException
    //   500	552	769	com/linkedin/data/lite/DataReaderException
    //   713	744	769	com/linkedin/data/lite/DataReaderException
    //   464	495	848	finally
    //   500	552	848	finally
    //   713	744	848	finally
    //   775	798	848	finally
    //   798	845	848	finally
    //   927	951	848	finally
    //   560	566	1067	finally
    //   752	758	1067	finally
    //   560	566	1072	com/linkedin/data/lite/DataReaderException
    //   752	758	1072	com/linkedin/data/lite/DataReaderException
  }
  
  private static final class ByteArraySection
    implements IndividualResponseBuilder.Section
  {
    public final int end;
    public final int length;
    public final byte[] sourceArray;
    public final int start;
    
    public ByteArraySection(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      sourceArray = paramArrayOfByte;
      start = paramInt1;
      length = paramInt2;
      end = (paramInt1 + paramInt2);
    }
    
    public final InputStream inputStream()
      throws IOException
    {
      return new ByteArrayInputStream(sourceArray, start, length);
    }
    
    public final int length()
    {
      return length;
    }
  }
  
  private static final class CharArraySection
    implements IndividualResponseBuilder.Section
  {
    public final int length;
    private final FastJsonParser parser;
    public final int start;
    
    public CharArraySection(FastJsonParser paramFastJsonParser, int paramInt1, int paramInt2)
    {
      parser = paramFastJsonParser;
      start = paramInt1;
      length = paramInt2;
    }
    
    public final InputStream inputStream()
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Reader localReader = reader();
      for (;;)
      {
        int i = localReader.read();
        if (i == -1) {
          break;
        }
        localStringBuilder.append((char)i);
      }
      return new ByteArrayInputStream(localStringBuilder.toString().getBytes());
    }
    
    public final int length()
    {
      return length;
    }
    
    public final Reader reader()
    {
      FastJsonParser localFastJsonParser = parser;
      int i = start;
      int j = length;
      return new CharArrayReader(_fastJsonStreamReader._data, i, j);
    }
  }
  
  private static abstract interface Section
  {
    public abstract InputStream inputStream()
      throws IOException;
    
    public abstract int length();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.multiplex.IndividualResponseBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */