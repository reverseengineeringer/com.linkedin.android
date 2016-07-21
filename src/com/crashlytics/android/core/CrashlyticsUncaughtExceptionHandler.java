package com.crashlytics.android.core;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Environment;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.persistence.FileStore;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.Settings.LazyHolder;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CrashlyticsUncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  static final FilenameFilter ANY_SESSION_FILENAME_FILTER;
  private static final String[] INITIAL_SESSION_PART_TAGS = { "SessionUser", "SessionApp", "SessionOS", "SessionDevice" };
  static final Comparator<File> LARGEST_FILE_NAME_FIRST;
  private static final Map<String, String> SEND_AT_CRASHTIME_HEADER;
  static final FilenameFilter SESSION_FILE_FILTER = new FilenameFilter()
  {
    public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
    {
      return (paramAnonymousString.length() == 39) && (paramAnonymousString.endsWith(".cls"));
    }
  };
  private static final Pattern SESSION_FILE_PATTERN;
  static final Comparator<File> SMALLEST_FILE_NAME_FIRST;
  final CrashlyticsCore crashlyticsCore;
  private final Thread.UncaughtExceptionHandler defaultHandler;
  private final DevicePowerStateListener devicePowerStateListener;
  private final AtomicInteger eventCounter = new AtomicInteger(0);
  public final CrashlyticsExecutorServiceWrapper executorServiceWrapper;
  private final FileStore fileStore;
  private final IdManager idManager;
  final AtomicBoolean isHandlingException;
  private final LogFileManager logFileManager;
  private final String unityVersion;
  
  static
  {
    LARGEST_FILE_NAME_FIRST = new Comparator() {};
    SMALLEST_FILE_NAME_FIRST = new Comparator() {};
    ANY_SESSION_FILENAME_FILTER = new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return CrashlyticsUncaughtExceptionHandler.SESSION_FILE_PATTERN.matcher(paramAnonymousString).matches();
      }
    };
    SESSION_FILE_PATTERN = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    SEND_AT_CRASHTIME_HEADER = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
  }
  
  CrashlyticsUncaughtExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, CrashlyticsExecutorServiceWrapper paramCrashlyticsExecutorServiceWrapper, IdManager paramIdManager, UnityVersionProvider paramUnityVersionProvider, FileStore paramFileStore, CrashlyticsCore paramCrashlyticsCore)
  {
    defaultHandler = paramUncaughtExceptionHandler;
    executorServiceWrapper = paramCrashlyticsExecutorServiceWrapper;
    idManager = paramIdManager;
    crashlyticsCore = paramCrashlyticsCore;
    unityVersion = paramUnityVersionProvider.getUnityVersion();
    fileStore = paramFileStore;
    isHandlingException = new AtomicBoolean(false);
    paramUncaughtExceptionHandler = context;
    logFileManager = new LogFileManager(paramUncaughtExceptionHandler, paramFileStore);
    devicePowerStateListener = new DevicePowerStateListener(paramUncaughtExceptionHandler);
  }
  
  /* Error */
  private void closeOpenSessions(File[] paramArrayOfFile, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   3: ldc -44
    //   5: ldc_w 405
    //   8: invokeinterface 336 3 0
    //   13: iload_2
    //   14: aload_1
    //   15: arraylength
    //   16: if_icmpge +841 -> 857
    //   19: aload_1
    //   20: iload_2
    //   21: aaload
    //   22: astore 14
    //   24: aload 14
    //   26: invokestatic 379	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getSessionIdFromSessionFile	(Ljava/io/File;)Ljava/lang/String;
    //   29: astore 13
    //   31: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   34: ldc -44
    //   36: new 264	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 407
    //   43: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: aload 13
    //   48: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokeinterface 336 3 0
    //   59: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   62: ldc -44
    //   64: new 264	java/lang/StringBuilder
    //   67: dup
    //   68: ldc_w 409
    //   71: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: aload 13
    //   76: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokeinterface 336 3 0
    //   87: aload_0
    //   88: new 37	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$FileNameContainsFilter
    //   91: dup
    //   92: new 264	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   99: aload 13
    //   101: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 271
    //   107: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokespecial 410	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$FileNameContainsFilter:<init>	(Ljava/lang/String;)V
    //   116: invokevirtual 306	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:listFilesMatching	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   119: astore 6
    //   121: aload 6
    //   123: ifnull +558 -> 681
    //   126: aload 6
    //   128: arraylength
    //   129: ifle +552 -> 681
    //   132: iconst_1
    //   133: istore 4
    //   135: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   138: ldc -44
    //   140: getstatic 416	java/util/Locale:US	Ljava/util/Locale;
    //   143: ldc_w 418
    //   146: iconst_2
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload 13
    //   154: aastore
    //   155: dup
    //   156: iconst_1
    //   157: iload 4
    //   159: invokestatic 424	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   162: aastore
    //   163: invokestatic 428	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   166: invokeinterface 336 3 0
    //   171: aload_0
    //   172: new 37	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$FileNameContainsFilter
    //   175: dup
    //   176: new 264	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   183: aload 13
    //   185: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: ldc_w 346
    //   191: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokespecial 410	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$FileNameContainsFilter:<init>	(Ljava/lang/String;)V
    //   200: invokevirtual 306	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:listFilesMatching	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   203: astore 9
    //   205: aload 9
    //   207: ifnull +480 -> 687
    //   210: aload 9
    //   212: arraylength
    //   213: ifle +474 -> 687
    //   216: iconst_1
    //   217: istore 5
    //   219: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   222: ldc -44
    //   224: getstatic 416	java/util/Locale:US	Ljava/util/Locale;
    //   227: ldc_w 430
    //   230: iconst_2
    //   231: anewarray 4	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload 13
    //   238: aastore
    //   239: dup
    //   240: iconst_1
    //   241: iload 5
    //   243: invokestatic 424	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   246: aastore
    //   247: invokestatic 428	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   250: invokeinterface 336 3 0
    //   255: iload 4
    //   257: ifne +8 -> 265
    //   260: iload 5
    //   262: ifeq +564 -> 826
    //   265: aload 9
    //   267: arraylength
    //   268: iload_3
    //   269: if_icmple +602 -> 871
    //   272: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   275: ldc -44
    //   277: getstatic 416	java/util/Locale:US	Ljava/util/Locale;
    //   280: ldc_w 432
    //   283: iconst_1
    //   284: anewarray 4	java/lang/Object
    //   287: dup
    //   288: iconst_0
    //   289: iload_3
    //   290: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   293: aastore
    //   294: invokestatic 428	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   297: invokeinterface 336 3 0
    //   302: aload_0
    //   303: aload 13
    //   305: iload_3
    //   306: invokespecial 356	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:trimSessionEventFiles	(Ljava/lang/String;I)V
    //   309: aload_0
    //   310: new 37	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$FileNameContainsFilter
    //   313: dup
    //   314: new 264	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   321: aload 13
    //   323: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc_w 346
    //   329: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokespecial 410	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$FileNameContainsFilter:<init>	(Ljava/lang/String;)V
    //   338: invokevirtual 306	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:listFilesMatching	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   341: astore 9
    //   343: iload 4
    //   345: ifeq +348 -> 693
    //   348: aload 6
    //   350: iconst_0
    //   351: aaload
    //   352: astore 11
    //   354: aload 11
    //   356: ifnull +343 -> 699
    //   359: iconst_1
    //   360: istore 4
    //   362: aconst_null
    //   363: astore 6
    //   365: aconst_null
    //   366: astore 7
    //   368: aconst_null
    //   369: astore 12
    //   371: aconst_null
    //   372: astore 8
    //   374: new 262	com/crashlytics/android/core/ClsFileOutputStream
    //   377: dup
    //   378: aload_0
    //   379: invokespecial 244	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   382: aload 13
    //   384: invokespecial 277	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   387: astore 10
    //   389: aload 7
    //   391: astore 6
    //   393: aload 10
    //   395: astore 7
    //   397: aload 12
    //   399: astore 8
    //   401: aload 10
    //   403: invokestatic 283	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   406: astore 12
    //   408: aload 12
    //   410: astore 6
    //   412: aload 10
    //   414: astore 7
    //   416: aload 12
    //   418: astore 8
    //   420: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   423: ldc -44
    //   425: new 264	java/lang/StringBuilder
    //   428: dup
    //   429: ldc_w 439
    //   432: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   435: aload 13
    //   437: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokeinterface 336 3 0
    //   448: aload 12
    //   450: astore 6
    //   452: aload 10
    //   454: astore 7
    //   456: aload 12
    //   458: astore 8
    //   460: aload 12
    //   462: aload 14
    //   464: invokestatic 443	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:writeToCosFromFile	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/io/File;)V
    //   467: aload 12
    //   469: astore 6
    //   471: aload 10
    //   473: astore 7
    //   475: aload 12
    //   477: astore 8
    //   479: aload 12
    //   481: iconst_4
    //   482: new 445	java/util/Date
    //   485: dup
    //   486: invokespecial 446	java/util/Date:<init>	()V
    //   489: invokevirtual 450	java/util/Date:getTime	()J
    //   492: ldc2_w 451
    //   495: ldiv
    //   496: invokevirtual 456	com/crashlytics/android/core/CodedOutputStream:writeUInt64	(IJ)V
    //   499: aload 12
    //   501: astore 6
    //   503: aload 10
    //   505: astore 7
    //   507: aload 12
    //   509: astore 8
    //   511: aload 12
    //   513: iconst_5
    //   514: iload 4
    //   516: invokevirtual 460	com/crashlytics/android/core/CodedOutputStream:writeBool	(IZ)V
    //   519: aload 12
    //   521: astore 6
    //   523: aload 10
    //   525: astore 7
    //   527: aload 12
    //   529: astore 8
    //   531: aload_0
    //   532: aload 12
    //   534: aload 13
    //   536: invokespecial 464	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:writeInitialPartsTo	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/lang/String;)V
    //   539: aload 12
    //   541: astore 6
    //   543: aload 10
    //   545: astore 7
    //   547: aload 12
    //   549: astore 8
    //   551: aload 12
    //   553: aload 9
    //   555: aload 13
    //   557: invokestatic 468	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:writeNonFatalEventsTo	(Lcom/crashlytics/android/core/CodedOutputStream;[Ljava/io/File;Ljava/lang/String;)V
    //   560: iload 4
    //   562: ifeq +22 -> 584
    //   565: aload 12
    //   567: astore 6
    //   569: aload 10
    //   571: astore 7
    //   573: aload 12
    //   575: astore 8
    //   577: aload 12
    //   579: aload 11
    //   581: invokestatic 443	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:writeToCosFromFile	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/io/File;)V
    //   584: aload 12
    //   586: astore 6
    //   588: aload 10
    //   590: astore 7
    //   592: aload 12
    //   594: astore 8
    //   596: aload 12
    //   598: bipush 11
    //   600: iconst_1
    //   601: invokevirtual 472	com/crashlytics/android/core/CodedOutputStream:writeUInt32	(II)V
    //   604: aload 12
    //   606: astore 6
    //   608: aload 10
    //   610: astore 7
    //   612: aload 12
    //   614: astore 8
    //   616: aload 12
    //   618: bipush 12
    //   620: iconst_3
    //   621: invokevirtual 475	com/crashlytics/android/core/CodedOutputStream:writeEnum	(II)V
    //   624: aload 12
    //   626: ldc_w 477
    //   629: invokestatic 228	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   632: aload 10
    //   634: ldc_w 479
    //   637: invokestatic 234	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   640: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   643: ldc -44
    //   645: new 264	java/lang/StringBuilder
    //   648: dup
    //   649: ldc_w 481
    //   652: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   655: aload 13
    //   657: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokeinterface 336 3 0
    //   668: aload_0
    //   669: aload 13
    //   671: invokespecial 484	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:deleteSessionPartFilesFor	(Ljava/lang/String;)V
    //   674: iload_2
    //   675: iconst_1
    //   676: iadd
    //   677: istore_2
    //   678: goto -665 -> 13
    //   681: iconst_0
    //   682: istore 4
    //   684: goto -549 -> 135
    //   687: iconst_0
    //   688: istore 5
    //   690: goto -471 -> 219
    //   693: aconst_null
    //   694: astore 11
    //   696: goto -342 -> 354
    //   699: iconst_0
    //   700: istore 4
    //   702: goto -340 -> 362
    //   705: astore 11
    //   707: aconst_null
    //   708: astore 9
    //   710: aload 8
    //   712: astore 6
    //   714: aload 9
    //   716: astore 7
    //   718: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   721: ldc -44
    //   723: new 264	java/lang/StringBuilder
    //   726: dup
    //   727: ldc_w 486
    //   730: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   733: aload 13
    //   735: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: aload 11
    //   743: invokeinterface 220 4 0
    //   748: aload 8
    //   750: astore 6
    //   752: aload 9
    //   754: astore 7
    //   756: aload 11
    //   758: aload 9
    //   760: invokestatic 297	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   763: aload 8
    //   765: ldc_w 477
    //   768: invokestatic 228	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   771: aload 9
    //   773: ifnull -133 -> 640
    //   776: aload 9
    //   778: invokevirtual 489	com/crashlytics/android/core/ClsFileOutputStream:closeInProgressStream	()V
    //   781: goto -141 -> 640
    //   784: astore 6
    //   786: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   789: ldc -44
    //   791: ldc_w 491
    //   794: aload 6
    //   796: invokeinterface 220 4 0
    //   801: goto -161 -> 640
    //   804: astore_1
    //   805: aconst_null
    //   806: astore 7
    //   808: aload 6
    //   810: ldc_w 477
    //   813: invokestatic 228	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   816: aload 7
    //   818: ldc_w 479
    //   821: invokestatic 234	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   824: aload_1
    //   825: athrow
    //   826: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   829: ldc -44
    //   831: new 264	java/lang/StringBuilder
    //   834: dup
    //   835: ldc_w 493
    //   838: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   841: aload 13
    //   843: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokeinterface 336 3 0
    //   854: goto -214 -> 640
    //   857: return
    //   858: astore_1
    //   859: goto -51 -> 808
    //   862: astore 11
    //   864: aload 10
    //   866: astore 9
    //   868: goto -158 -> 710
    //   871: goto -528 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	874	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	874	1	paramArrayOfFile	File[]
    //   0	874	2	paramInt1	int
    //   0	874	3	paramInt2	int
    //   133	568	4	bool1	boolean
    //   217	472	5	bool2	boolean
    //   119	632	6	localObject1	Object
    //   784	25	6	localIOException	IOException
    //   366	451	7	localObject2	Object
    //   372	392	8	localCodedOutputStream1	CodedOutputStream
    //   203	664	9	localObject3	Object
    //   387	478	10	localClsFileOutputStream	ClsFileOutputStream
    //   352	343	11	localFile1	File
    //   705	52	11	localException1	Exception
    //   862	1	11	localException2	Exception
    //   369	256	12	localCodedOutputStream2	CodedOutputStream
    //   29	813	13	str	String
    //   22	441	14	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   374	389	705	java/lang/Exception
    //   776	781	784	java/io/IOException
    //   374	389	804	finally
    //   401	408	858	finally
    //   420	448	858	finally
    //   460	467	858	finally
    //   479	499	858	finally
    //   511	519	858	finally
    //   531	539	858	finally
    //   551	560	858	finally
    //   577	584	858	finally
    //   596	604	858	finally
    //   616	624	858	finally
    //   718	748	858	finally
    //   756	763	858	finally
    //   401	408	862	java/lang/Exception
    //   420	448	862	java/lang/Exception
    //   460	467	862	java/lang/Exception
    //   479	499	862	java/lang/Exception
    //   511	519	862	java/lang/Exception
    //   531	539	862	java/lang/Exception
    //   551	560	862	java/lang/Exception
    //   577	584	862	java/lang/Exception
    //   596	604	862	java/lang/Exception
    //   616	624	862	java/lang/Exception
  }
  
  private static void copyToCodedOutputStream(InputStream paramInputStream, CodedOutputStream paramCodedOutputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramInt = 0;
    while (paramInt < arrayOfByte.length)
    {
      i = paramInputStream.read(arrayOfByte, paramInt, arrayOfByte.length - paramInt);
      if (i < 0) {
        break;
      }
      paramInt += i;
    }
    int i = arrayOfByte.length;
    if (limit - position >= i)
    {
      System.arraycopy(arrayOfByte, 0, buffer, position, i);
      position = (i + position);
      return;
    }
    int j = limit - position;
    System.arraycopy(arrayOfByte, 0, buffer, position, j);
    paramInt = j + 0;
    i -= j;
    position = limit;
    paramCodedOutputStream.refreshBuffer();
    if (i <= limit)
    {
      System.arraycopy(arrayOfByte, paramInt, buffer, 0, i);
      position = i;
      return;
    }
    output.write(arrayOfByte, paramInt, i);
  }
  
  private void deleteSessionPartFilesFor(String paramString)
  {
    paramString = listFilesMatching(new SessionPartFileFilter(paramString));
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      paramString[i].delete();
      i += 1;
    }
  }
  
  /* Error */
  private void doCloseSessions(boolean paramBoolean)
    throws Exception
  {
    // Byte code:
    //   0: iload_1
    //   1: ifeq +62 -> 63
    //   4: iconst_1
    //   5: istore_2
    //   6: new 539	java/util/HashSet
    //   9: dup
    //   10: invokespecial 540	java/util/HashSet:<init>	()V
    //   13: astore 5
    //   15: aload_0
    //   16: invokespecial 375	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:listSortedSessionBeginFiles	()[Ljava/io/File;
    //   19: astore 6
    //   21: iload_2
    //   22: bipush 8
    //   24: iadd
    //   25: aload 6
    //   27: arraylength
    //   28: invokestatic 546	java/lang/Math:min	(II)I
    //   31: istore 4
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: iload 4
    //   38: if_icmpge +30 -> 68
    //   41: aload 5
    //   43: aload 6
    //   45: iload_3
    //   46: aaload
    //   47: invokestatic 379	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getSessionIdFromSessionFile	(Ljava/io/File;)Ljava/lang/String;
    //   50: invokeinterface 552 2 0
    //   55: pop
    //   56: iload_3
    //   57: iconst_1
    //   58: iadd
    //   59: istore_3
    //   60: goto -25 -> 35
    //   63: iconst_0
    //   64: istore_2
    //   65: goto -59 -> 6
    //   68: aload_0
    //   69: getfield 176	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:logFileManager	Lcom/crashlytics/android/core/LogFileManager;
    //   72: aload 5
    //   74: invokevirtual 556	com/crashlytics/android/core/LogFileManager:discardOldLogFiles	(Ljava/util/Set;)V
    //   77: aload_0
    //   78: new 34	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$AnySessionPartFileFilter
    //   81: dup
    //   82: iconst_0
    //   83: invokespecial 559	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$AnySessionPartFileFilter:<init>	(B)V
    //   86: invokevirtual 306	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:listFilesMatching	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   89: astore 6
    //   91: aload 6
    //   93: arraylength
    //   94: istore 4
    //   96: iconst_0
    //   97: istore_3
    //   98: iload_3
    //   99: iload 4
    //   101: if_icmpge +89 -> 190
    //   104: aload 6
    //   106: iload_3
    //   107: aaload
    //   108: astore 7
    //   110: aload 7
    //   112: invokevirtual 560	java/io/File:getName	()Ljava/lang/String;
    //   115: astore 8
    //   117: getstatic 104	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:SESSION_FILE_PATTERN	Ljava/util/regex/Pattern;
    //   120: aload 8
    //   122: invokevirtual 564	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   125: astore 9
    //   127: aload 9
    //   129: invokevirtual 569	java/util/regex/Matcher:matches	()Z
    //   132: pop
    //   133: aload 5
    //   135: aload 9
    //   137: iconst_1
    //   138: invokevirtual 572	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   141: invokeinterface 575 2 0
    //   146: ifne +37 -> 183
    //   149: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   152: ldc -44
    //   154: new 264	java/lang/StringBuilder
    //   157: dup
    //   158: ldc_w 577
    //   161: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   164: aload 8
    //   166: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokeinterface 336 3 0
    //   177: aload 7
    //   179: invokevirtual 537	java/io/File:delete	()Z
    //   182: pop
    //   183: iload_3
    //   184: iconst_1
    //   185: iadd
    //   186: istore_3
    //   187: goto -89 -> 98
    //   190: aload_0
    //   191: invokespecial 375	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:listSortedSessionBeginFiles	()[Ljava/io/File;
    //   194: astore 13
    //   196: aload 13
    //   198: arraylength
    //   199: iload_2
    //   200: if_icmpgt +17 -> 217
    //   203: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   206: ldc -44
    //   208: ldc_w 579
    //   211: invokeinterface 336 3 0
    //   216: return
    //   217: aload 13
    //   219: iload_2
    //   220: aaload
    //   221: invokestatic 379	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getSessionIdFromSessionFile	(Ljava/io/File;)Ljava/lang/String;
    //   224: astore 10
    //   226: aconst_null
    //   227: astore 5
    //   229: aconst_null
    //   230: astore 6
    //   232: aconst_null
    //   233: astore 9
    //   235: aconst_null
    //   236: astore 7
    //   238: new 262	com/crashlytics/android/core/ClsFileOutputStream
    //   241: dup
    //   242: aload_0
    //   243: invokespecial 244	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   246: new 264	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   253: aload 10
    //   255: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc 120
    //   260: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokespecial 277	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   269: astore 8
    //   271: aload 8
    //   273: astore 6
    //   275: aload 9
    //   277: astore 7
    //   279: aload 8
    //   281: invokestatic 283	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   284: astore 9
    //   286: aload 9
    //   288: astore 5
    //   290: aload 8
    //   292: astore 6
    //   294: aload 9
    //   296: astore 7
    //   298: aload_0
    //   299: getfield 163	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   302: invokevirtual 582	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   305: ifeq +338 -> 643
    //   308: aload 9
    //   310: astore 5
    //   312: aload 8
    //   314: astore 6
    //   316: aload 9
    //   318: astore 7
    //   320: aload_0
    //   321: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   324: astore 10
    //   326: aload 9
    //   328: astore 5
    //   330: aload 8
    //   332: astore 6
    //   334: aload 9
    //   336: astore 7
    //   338: aload 10
    //   340: getfield 583	io/fabric/sdk/android/Kit:idManager	Lio/fabric/sdk/android/services/common/IdManager;
    //   343: getfield 589	io/fabric/sdk/android/services/common/IdManager:collectUserIds	Z
    //   346: ifeq +279 -> 625
    //   349: aload 9
    //   351: astore 5
    //   353: aload 8
    //   355: astore 6
    //   357: aload 9
    //   359: astore 7
    //   361: aload 10
    //   363: getfield 592	com/crashlytics/android/core/CrashlyticsCore:userId	Ljava/lang/String;
    //   366: astore 10
    //   368: aload 9
    //   370: astore 5
    //   372: aload 8
    //   374: astore 6
    //   376: aload 9
    //   378: astore 7
    //   380: aload_0
    //   381: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   384: astore 11
    //   386: aload 9
    //   388: astore 5
    //   390: aload 8
    //   392: astore 6
    //   394: aload 9
    //   396: astore 7
    //   398: aload 11
    //   400: getfield 583	io/fabric/sdk/android/Kit:idManager	Lio/fabric/sdk/android/services/common/IdManager;
    //   403: getfield 589	io/fabric/sdk/android/services/common/IdManager:collectUserIds	Z
    //   406: ifeq +225 -> 631
    //   409: aload 9
    //   411: astore 5
    //   413: aload 8
    //   415: astore 6
    //   417: aload 9
    //   419: astore 7
    //   421: aload 11
    //   423: getfield 595	com/crashlytics/android/core/CrashlyticsCore:userName	Ljava/lang/String;
    //   426: astore 11
    //   428: aload 9
    //   430: astore 5
    //   432: aload 8
    //   434: astore 6
    //   436: aload 9
    //   438: astore 7
    //   440: aload_0
    //   441: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   444: astore 12
    //   446: aload 9
    //   448: astore 5
    //   450: aload 8
    //   452: astore 6
    //   454: aload 9
    //   456: astore 7
    //   458: aload 12
    //   460: getfield 583	io/fabric/sdk/android/Kit:idManager	Lio/fabric/sdk/android/services/common/IdManager;
    //   463: getfield 589	io/fabric/sdk/android/services/common/IdManager:collectUserIds	Z
    //   466: ifeq +171 -> 637
    //   469: aload 9
    //   471: astore 5
    //   473: aload 8
    //   475: astore 6
    //   477: aload 9
    //   479: astore 7
    //   481: aload 12
    //   483: getfield 598	com/crashlytics/android/core/CrashlyticsCore:userEmail	Ljava/lang/String;
    //   486: astore 12
    //   488: aload 9
    //   490: astore 5
    //   492: aload 8
    //   494: astore 6
    //   496: aload 9
    //   498: astore 7
    //   500: new 600	com/crashlytics/android/core/UserMetaData
    //   503: dup
    //   504: aload 10
    //   506: aload 11
    //   508: aload 12
    //   510: invokespecial 603	com/crashlytics/android/core/UserMetaData:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   513: astore 10
    //   515: aload 9
    //   517: astore 5
    //   519: aload 8
    //   521: astore 6
    //   523: aload 9
    //   525: astore 7
    //   527: aload 10
    //   529: getfield 606	com/crashlytics/android/core/UserMetaData:id	Ljava/lang/String;
    //   532: ifnonnull +285 -> 817
    //   535: aload 9
    //   537: astore 5
    //   539: aload 8
    //   541: astore 6
    //   543: aload 9
    //   545: astore 7
    //   547: aload 10
    //   549: getfield 609	com/crashlytics/android/core/UserMetaData:name	Ljava/lang/String;
    //   552: ifnonnull +265 -> 817
    //   555: aload 9
    //   557: astore 5
    //   559: aload 8
    //   561: astore 6
    //   563: aload 9
    //   565: astore 7
    //   567: aload 10
    //   569: getfield 612	com/crashlytics/android/core/UserMetaData:email	Ljava/lang/String;
    //   572: astore 11
    //   574: aload 11
    //   576: ifnonnull +241 -> 817
    //   579: iconst_1
    //   580: istore_3
    //   581: iload_3
    //   582: ifeq +94 -> 676
    //   585: aload 9
    //   587: ldc_w 614
    //   590: invokestatic 228	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   593: aload 8
    //   595: ldc_w 616
    //   598: invokestatic 234	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   601: invokestatic 620	com/crashlytics/android/core/CrashlyticsCore:getSessionSettingsData	()Lio/fabric/sdk/android/services/settings/SessionSettingsData;
    //   604: astore 5
    //   606: aload 5
    //   608: ifnonnull +183 -> 791
    //   611: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   614: ldc -44
    //   616: ldc_w 622
    //   619: invokeinterface 336 3 0
    //   624: return
    //   625: aconst_null
    //   626: astore 10
    //   628: goto -260 -> 368
    //   631: aconst_null
    //   632: astore 11
    //   634: goto -206 -> 428
    //   637: aconst_null
    //   638: astore 12
    //   640: goto -152 -> 488
    //   643: aload 9
    //   645: astore 5
    //   647: aload 8
    //   649: astore 6
    //   651: aload 9
    //   653: astore 7
    //   655: new 383	com/crashlytics/android/core/MetaDataStore
    //   658: dup
    //   659: aload_0
    //   660: invokespecial 244	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   663: invokespecial 386	com/crashlytics/android/core/MetaDataStore:<init>	(Ljava/io/File;)V
    //   666: aload 10
    //   668: invokevirtual 626	com/crashlytics/android/core/MetaDataStore:readUserData	(Ljava/lang/String;)Lcom/crashlytics/android/core/UserMetaData;
    //   671: astore 10
    //   673: goto -158 -> 515
    //   676: aload 9
    //   678: astore 5
    //   680: aload 8
    //   682: astore 6
    //   684: aload 9
    //   686: astore 7
    //   688: aload 9
    //   690: aload 10
    //   692: getfield 606	com/crashlytics/android/core/UserMetaData:id	Ljava/lang/String;
    //   695: aload 10
    //   697: getfield 609	com/crashlytics/android/core/UserMetaData:name	Ljava/lang/String;
    //   700: aload 10
    //   702: getfield 612	com/crashlytics/android/core/UserMetaData:email	Ljava/lang/String;
    //   705: invokestatic 632	com/crashlytics/android/core/SessionProtobufHelper:writeSessionUser	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   708: aload 9
    //   710: ldc_w 614
    //   713: invokestatic 228	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   716: aload 8
    //   718: ldc_w 616
    //   721: invokestatic 234	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   724: goto -123 -> 601
    //   727: astore 9
    //   729: aconst_null
    //   730: astore 8
    //   732: aload 7
    //   734: astore 5
    //   736: aload 8
    //   738: astore 6
    //   740: aload 9
    //   742: aload 8
    //   744: invokestatic 297	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   747: aload 7
    //   749: astore 5
    //   751: aload 8
    //   753: astore 6
    //   755: aload 9
    //   757: athrow
    //   758: astore 8
    //   760: aload 6
    //   762: astore 7
    //   764: aload 5
    //   766: astore 6
    //   768: aload 8
    //   770: astore 5
    //   772: aload 6
    //   774: ldc_w 614
    //   777: invokestatic 228	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   780: aload 7
    //   782: ldc_w 616
    //   785: invokestatic 234	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   788: aload 5
    //   790: athrow
    //   791: aload_0
    //   792: aload 13
    //   794: iload_2
    //   795: aload 5
    //   797: getfield 637	io/fabric/sdk/android/services/settings/SessionSettingsData:maxCustomExceptionEvents	I
    //   800: invokespecial 639	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:closeOpenSessions	([Ljava/io/File;II)V
    //   803: return
    //   804: astore 5
    //   806: aconst_null
    //   807: astore 7
    //   809: goto -37 -> 772
    //   812: astore 9
    //   814: goto -82 -> 732
    //   817: iconst_0
    //   818: istore_3
    //   819: goto -238 -> 581
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	822	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	822	1	paramBoolean	boolean
    //   5	790	2	i	int
    //   34	785	3	j	int
    //   31	71	4	k	int
    //   13	783	5	localObject1	Object
    //   804	1	5	localObject2	Object
    //   19	754	6	localObject3	Object
    //   108	700	7	localObject4	Object
    //   115	637	8	localObject5	Object
    //   758	11	8	localObject6	Object
    //   125	584	9	localObject7	Object
    //   727	29	9	localException1	Exception
    //   812	1	9	localException2	Exception
    //   224	477	10	localObject8	Object
    //   384	249	11	localObject9	Object
    //   444	195	12	localObject10	Object
    //   194	599	13	arrayOfFile	File[]
    // Exception table:
    //   from	to	target	type
    //   238	271	727	java/lang/Exception
    //   279	286	758	finally
    //   298	308	758	finally
    //   320	326	758	finally
    //   338	349	758	finally
    //   361	368	758	finally
    //   380	386	758	finally
    //   398	409	758	finally
    //   421	428	758	finally
    //   440	446	758	finally
    //   458	469	758	finally
    //   481	488	758	finally
    //   500	515	758	finally
    //   527	535	758	finally
    //   547	555	758	finally
    //   567	574	758	finally
    //   655	673	758	finally
    //   688	708	758	finally
    //   740	747	758	finally
    //   755	758	758	finally
    //   238	271	804	finally
    //   279	286	812	java/lang/Exception
    //   298	308	812	java/lang/Exception
    //   320	326	812	java/lang/Exception
    //   338	349	812	java/lang/Exception
    //   361	368	812	java/lang/Exception
    //   380	386	812	java/lang/Exception
    //   398	409	812	java/lang/Exception
    //   421	428	812	java/lang/Exception
    //   440	446	812	java/lang/Exception
    //   458	469	812	java/lang/Exception
    //   481	488	812	java/lang/Exception
    //   500	515	812	java/lang/Exception
    //   527	535	812	java/lang/Exception
    //   547	555	812	java/lang/Exception
    //   567	574	812	java/lang/Exception
    //   655	673	812	java/lang/Exception
    //   688	708	812	java/lang/Exception
  }
  
  /* Error */
  private void doOpenSession()
    throws Exception
  {
    // Byte code:
    //   0: new 445	java/util/Date
    //   3: dup
    //   4: invokespecial 446	java/util/Date:<init>	()V
    //   7: astore 16
    //   9: new 641	com/crashlytics/android/core/CLSUUID
    //   12: dup
    //   13: aload_0
    //   14: getfield 144	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:idManager	Lio/fabric/sdk/android/services/common/IdManager;
    //   17: invokespecial 644	com/crashlytics/android/core/CLSUUID:<init>	(Lio/fabric/sdk/android/services/common/IdManager;)V
    //   20: invokevirtual 645	com/crashlytics/android/core/CLSUUID:toString	()Ljava/lang/String;
    //   23: astore 17
    //   25: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   28: ldc -44
    //   30: new 264	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 647
    //   37: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload 17
    //   42: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokeinterface 336 3 0
    //   53: aconst_null
    //   54: astore 11
    //   56: aconst_null
    //   57: astore 12
    //   59: aconst_null
    //   60: astore 15
    //   62: aconst_null
    //   63: astore 13
    //   65: new 262	com/crashlytics/android/core/ClsFileOutputStream
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 244	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   73: new 264	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   80: aload 17
    //   82: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 649
    //   88: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokespecial 277	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   97: astore 14
    //   99: aload 14
    //   101: astore 12
    //   103: aload 15
    //   105: astore 13
    //   107: aload 14
    //   109: invokestatic 283	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   112: astore 15
    //   114: aload 15
    //   116: astore 11
    //   118: aload 14
    //   120: astore 12
    //   122: aload 15
    //   124: astore 13
    //   126: aload 15
    //   128: aload 17
    //   130: getstatic 416	java/util/Locale:US	Ljava/util/Locale;
    //   133: ldc_w 651
    //   136: iconst_1
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: ldc_w 653
    //   145: aastore
    //   146: invokestatic 428	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   149: aload 16
    //   151: invokevirtual 450	java/util/Date:getTime	()J
    //   154: ldc2_w 451
    //   157: ldiv
    //   158: invokestatic 657	com/crashlytics/android/core/SessionProtobufHelper:writeBeginSession	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/lang/String;Ljava/lang/String;J)V
    //   161: aload 15
    //   163: ldc -34
    //   165: invokestatic 228	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   168: aload 14
    //   170: ldc_w 659
    //   173: invokestatic 234	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   176: aconst_null
    //   177: astore 11
    //   179: aconst_null
    //   180: astore 13
    //   182: aconst_null
    //   183: astore 14
    //   185: new 262	com/crashlytics/android/core/ClsFileOutputStream
    //   188: dup
    //   189: aload_0
    //   190: invokespecial 244	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   193: new 264	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   200: aload 17
    //   202: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc 122
    //   207: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokespecial 277	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   216: astore 12
    //   218: aload 12
    //   220: invokestatic 283	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   223: astore 11
    //   225: aload 11
    //   227: aload_0
    //   228: getfield 144	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:idManager	Lio/fabric/sdk/android/services/common/IdManager;
    //   231: getfield 662	io/fabric/sdk/android/services/common/IdManager:appIdentifier	Ljava/lang/String;
    //   234: aload_0
    //   235: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   238: getfield 665	com/crashlytics/android/core/CrashlyticsCore:apiKey	Ljava/lang/String;
    //   241: aload_0
    //   242: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   245: getfield 668	com/crashlytics/android/core/CrashlyticsCore:versionCode	Ljava/lang/String;
    //   248: aload_0
    //   249: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   252: getfield 671	com/crashlytics/android/core/CrashlyticsCore:versionName	Ljava/lang/String;
    //   255: aload_0
    //   256: getfield 144	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:idManager	Lio/fabric/sdk/android/services/common/IdManager;
    //   259: invokevirtual 674	io/fabric/sdk/android/services/common/IdManager:getAppInstallIdentifier	()Ljava/lang/String;
    //   262: aload_0
    //   263: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   266: getfield 677	com/crashlytics/android/core/CrashlyticsCore:installerPackageName	Ljava/lang/String;
    //   269: invokestatic 683	io/fabric/sdk/android/services/common/DeliveryMechanism:determineFrom	(Ljava/lang/String;)Lio/fabric/sdk/android/services/common/DeliveryMechanism;
    //   272: getfield 685	io/fabric/sdk/android/services/common/DeliveryMechanism:id	I
    //   275: aload_0
    //   276: getfield 154	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:unityVersion	Ljava/lang/String;
    //   279: invokestatic 689	com/crashlytics/android/core/SessionProtobufHelper:writeSessionApp	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload 11
    //   284: ldc_w 691
    //   287: invokestatic 228	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   290: aload 12
    //   292: ldc_w 693
    //   295: invokestatic 234	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   298: aconst_null
    //   299: astore 13
    //   301: aconst_null
    //   302: astore 16
    //   304: aconst_null
    //   305: astore 12
    //   307: aconst_null
    //   308: astore 15
    //   310: aconst_null
    //   311: astore 11
    //   313: new 262	com/crashlytics/android/core/ClsFileOutputStream
    //   316: dup
    //   317: aload_0
    //   318: invokespecial 244	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   321: new 264	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   328: aload 17
    //   330: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc 124
    //   335: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokespecial 277	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   344: astore 14
    //   346: aload 16
    //   348: astore 11
    //   350: aload 14
    //   352: astore 12
    //   354: aload 15
    //   356: astore 13
    //   358: aload 14
    //   360: invokestatic 283	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   363: astore 15
    //   365: aload 15
    //   367: astore 11
    //   369: aload 14
    //   371: astore 12
    //   373: aload 15
    //   375: astore 13
    //   377: aload 15
    //   379: aload_0
    //   380: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   383: getfield 169	io/fabric/sdk/android/Kit:context	Landroid/content/Context;
    //   386: invokestatic 697	io/fabric/sdk/android/services/common/CommonUtils:isRooted	(Landroid/content/Context;)Z
    //   389: invokestatic 701	com/crashlytics/android/core/SessionProtobufHelper:writeSessionOS	(Lcom/crashlytics/android/core/CodedOutputStream;Z)V
    //   392: aload 15
    //   394: ldc_w 703
    //   397: invokestatic 228	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   400: aload 14
    //   402: ldc_w 705
    //   405: invokestatic 234	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   408: aconst_null
    //   409: astore 11
    //   411: aconst_null
    //   412: astore 12
    //   414: aconst_null
    //   415: astore 16
    //   417: aconst_null
    //   418: astore 15
    //   420: aconst_null
    //   421: astore 13
    //   423: new 262	com/crashlytics/android/core/ClsFileOutputStream
    //   426: dup
    //   427: aload_0
    //   428: invokespecial 244	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   431: new 264	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   438: aload 17
    //   440: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: ldc 126
    //   445: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokespecial 277	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   454: astore 14
    //   456: aload 16
    //   458: astore 12
    //   460: aload 15
    //   462: astore 13
    //   464: aload 14
    //   466: invokestatic 283	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   469: astore 15
    //   471: aload 15
    //   473: astore 12
    //   475: aload 15
    //   477: astore 13
    //   479: aload_0
    //   480: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   483: getfield 169	io/fabric/sdk/android/Kit:context	Landroid/content/Context;
    //   486: astore 18
    //   488: aload 15
    //   490: astore 12
    //   492: aload 15
    //   494: astore 13
    //   496: new 707	android/os/StatFs
    //   499: dup
    //   500: invokestatic 712	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   503: invokevirtual 715	java/io/File:getPath	()Ljava/lang/String;
    //   506: invokespecial 716	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   509: astore 19
    //   511: aload 15
    //   513: astore 12
    //   515: aload 15
    //   517: astore 13
    //   519: aload_0
    //   520: getfield 144	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:idManager	Lio/fabric/sdk/android/services/common/IdManager;
    //   523: astore 20
    //   525: ldc_w 718
    //   528: astore 11
    //   530: aload 15
    //   532: astore 12
    //   534: aload 15
    //   536: astore 13
    //   538: aload 20
    //   540: getfield 721	io/fabric/sdk/android/services/common/IdManager:collectHardwareIds	Z
    //   543: ifeq +92 -> 635
    //   546: aload 15
    //   548: astore 12
    //   550: aload 15
    //   552: astore 13
    //   554: aload 20
    //   556: invokevirtual 724	io/fabric/sdk/android/services/common/IdManager:getAndroidId	()Ljava/lang/String;
    //   559: astore 16
    //   561: aload 16
    //   563: astore 11
    //   565: aload 16
    //   567: ifnonnull +68 -> 635
    //   570: aload 15
    //   572: astore 12
    //   574: aload 15
    //   576: astore 13
    //   578: aload 20
    //   580: getfield 727	io/fabric/sdk/android/services/common/IdManager:appContext	Landroid/content/Context;
    //   583: invokestatic 731	io/fabric/sdk/android/services/common/CommonUtils:getSharedPrefs	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   586: astore 21
    //   588: aload 15
    //   590: astore 12
    //   592: aload 15
    //   594: astore 13
    //   596: aload 21
    //   598: ldc_w 733
    //   601: aconst_null
    //   602: invokeinterface 739 3 0
    //   607: astore 16
    //   609: aload 16
    //   611: astore 11
    //   613: aload 16
    //   615: ifnonnull +20 -> 635
    //   618: aload 15
    //   620: astore 12
    //   622: aload 15
    //   624: astore 13
    //   626: aload 20
    //   628: aload 21
    //   630: invokevirtual 743	io/fabric/sdk/android/services/common/IdManager:createInstallationUUID	(Landroid/content/SharedPreferences;)Ljava/lang/String;
    //   633: astore 11
    //   635: aload 15
    //   637: astore 12
    //   639: aload 15
    //   641: astore 13
    //   643: invokestatic 746	io/fabric/sdk/android/services/common/CommonUtils:getCpuArchitectureInt	()I
    //   646: istore_1
    //   647: aload 15
    //   649: astore 12
    //   651: aload 15
    //   653: astore 13
    //   655: invokestatic 752	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   658: invokevirtual 755	java/lang/Runtime:availableProcessors	()I
    //   661: istore_2
    //   662: aload 15
    //   664: astore 12
    //   666: aload 15
    //   668: astore 13
    //   670: invokestatic 758	io/fabric/sdk/android/services/common/CommonUtils:getTotalRamInBytes	()J
    //   673: lstore 4
    //   675: aload 15
    //   677: astore 12
    //   679: aload 15
    //   681: astore 13
    //   683: aload 19
    //   685: invokevirtual 761	android/os/StatFs:getBlockCount	()I
    //   688: i2l
    //   689: lstore 6
    //   691: aload 15
    //   693: astore 12
    //   695: aload 15
    //   697: astore 13
    //   699: aload 19
    //   701: invokevirtual 764	android/os/StatFs:getBlockSize	()I
    //   704: i2l
    //   705: lstore 8
    //   707: aload 15
    //   709: astore 12
    //   711: aload 15
    //   713: astore 13
    //   715: aload 18
    //   717: invokestatic 767	io/fabric/sdk/android/services/common/CommonUtils:isEmulator	(Landroid/content/Context;)Z
    //   720: istore 10
    //   722: aload 15
    //   724: astore 12
    //   726: aload 15
    //   728: astore 13
    //   730: aload_0
    //   731: getfield 144	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:idManager	Lio/fabric/sdk/android/services/common/IdManager;
    //   734: invokevirtual 770	io/fabric/sdk/android/services/common/IdManager:getDeviceIdentifiers	()Ljava/util/Map;
    //   737: astore 16
    //   739: aload 15
    //   741: astore 12
    //   743: aload 15
    //   745: astore 13
    //   747: aload 18
    //   749: invokestatic 774	io/fabric/sdk/android/services/common/CommonUtils:getDeviceState	(Landroid/content/Context;)I
    //   752: istore_3
    //   753: aload 15
    //   755: astore 12
    //   757: aload 15
    //   759: astore 13
    //   761: aload 15
    //   763: aload 11
    //   765: iload_1
    //   766: getstatic 779	android/os/Build:MODEL	Ljava/lang/String;
    //   769: iload_2
    //   770: lload 4
    //   772: lload 6
    //   774: lload 8
    //   776: lmul
    //   777: iload 10
    //   779: aload 16
    //   781: iload_3
    //   782: getstatic 782	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   785: getstatic 785	android/os/Build:PRODUCT	Ljava/lang/String;
    //   788: invokestatic 789	com/crashlytics/android/core/SessionProtobufHelper:writeSessionDevice	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/lang/String;ILjava/lang/String;IJJZLjava/util/Map;ILjava/lang/String;Ljava/lang/String;)V
    //   791: aload 15
    //   793: ldc_w 791
    //   796: invokestatic 228	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   799: aload 14
    //   801: ldc_w 793
    //   804: invokestatic 234	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   807: aload_0
    //   808: getfield 176	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:logFileManager	Lcom/crashlytics/android/core/LogFileManager;
    //   811: aload 17
    //   813: invokevirtual 796	com/crashlytics/android/core/LogFileManager:setCurrentSession	(Ljava/lang/String;)V
    //   816: return
    //   817: astore 15
    //   819: aconst_null
    //   820: astore 14
    //   822: aload 13
    //   824: astore 11
    //   826: aload 14
    //   828: astore 12
    //   830: aload 15
    //   832: aload 14
    //   834: invokestatic 297	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   837: aload 13
    //   839: astore 11
    //   841: aload 14
    //   843: astore 12
    //   845: aload 15
    //   847: athrow
    //   848: astore 14
    //   850: aload 12
    //   852: astore 13
    //   854: aload 11
    //   856: astore 12
    //   858: aload 14
    //   860: astore 11
    //   862: aload 12
    //   864: ldc -34
    //   866: invokestatic 228	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   869: aload 13
    //   871: ldc_w 659
    //   874: invokestatic 234	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   877: aload 11
    //   879: athrow
    //   880: astore 13
    //   882: aload 14
    //   884: astore 12
    //   886: aload 13
    //   888: aload 11
    //   890: invokestatic 297	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   893: aload 13
    //   895: athrow
    //   896: astore 15
    //   898: aload 11
    //   900: astore 14
    //   902: aload 12
    //   904: astore 13
    //   906: aload 15
    //   908: astore 11
    //   910: aload 13
    //   912: ldc_w 691
    //   915: invokestatic 228	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   918: aload 14
    //   920: ldc_w 693
    //   923: invokestatic 234	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   926: aload 11
    //   928: athrow
    //   929: astore 15
    //   931: aconst_null
    //   932: astore 14
    //   934: aload 11
    //   936: astore 13
    //   938: aload 13
    //   940: astore 11
    //   942: aload 14
    //   944: astore 12
    //   946: aload 15
    //   948: aload 14
    //   950: invokestatic 297	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   953: aload 13
    //   955: astore 11
    //   957: aload 14
    //   959: astore 12
    //   961: aload 15
    //   963: athrow
    //   964: astore 14
    //   966: aload 12
    //   968: astore 13
    //   970: aload 11
    //   972: astore 12
    //   974: aload 14
    //   976: astore 11
    //   978: aload 12
    //   980: ldc_w 703
    //   983: invokestatic 228	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   986: aload 13
    //   988: ldc_w 705
    //   991: invokestatic 234	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   994: aload 11
    //   996: athrow
    //   997: astore 12
    //   999: aload 12
    //   1001: aload 11
    //   1003: invokestatic 297	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   1006: aload 12
    //   1008: athrow
    //   1009: astore 15
    //   1011: aload 11
    //   1013: astore 14
    //   1015: aload 13
    //   1017: astore 12
    //   1019: aload 15
    //   1021: astore 11
    //   1023: aload 12
    //   1025: ldc_w 791
    //   1028: invokestatic 228	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   1031: aload 14
    //   1033: ldc_w 793
    //   1036: invokestatic 234	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   1039: aload 11
    //   1041: athrow
    //   1042: astore 11
    //   1044: aconst_null
    //   1045: astore 14
    //   1047: goto -24 -> 1023
    //   1050: astore 11
    //   1052: goto -29 -> 1023
    //   1055: astore 12
    //   1057: aload 14
    //   1059: astore 11
    //   1061: goto -62 -> 999
    //   1064: astore 11
    //   1066: goto -88 -> 978
    //   1069: astore 15
    //   1071: goto -133 -> 938
    //   1074: astore 11
    //   1076: aconst_null
    //   1077: astore 14
    //   1079: goto -169 -> 910
    //   1082: astore 11
    //   1084: aload 12
    //   1086: astore 14
    //   1088: goto -178 -> 910
    //   1091: astore 14
    //   1093: aload 11
    //   1095: astore 13
    //   1097: aload 14
    //   1099: astore 11
    //   1101: aload 12
    //   1103: astore 14
    //   1105: goto -195 -> 910
    //   1108: astore 13
    //   1110: aload 12
    //   1112: astore 11
    //   1114: aload 14
    //   1116: astore 12
    //   1118: goto -232 -> 886
    //   1121: astore 13
    //   1123: aload 12
    //   1125: astore 14
    //   1127: aload 11
    //   1129: astore 12
    //   1131: aload 14
    //   1133: astore 11
    //   1135: goto -249 -> 886
    //   1138: astore 11
    //   1140: aconst_null
    //   1141: astore 13
    //   1143: goto -281 -> 862
    //   1146: astore 15
    //   1148: goto -326 -> 822
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1151	0	this	CrashlyticsUncaughtExceptionHandler
    //   646	120	1	i	int
    //   661	109	2	j	int
    //   752	30	3	k	int
    //   673	98	4	l1	long
    //   689	84	6	l2	long
    //   705	70	8	l3	long
    //   720	58	10	bool	boolean
    //   54	986	11	localObject1	Object
    //   1042	1	11	localObject2	Object
    //   1050	1	11	localObject3	Object
    //   1059	1	11	localObject4	Object
    //   1064	1	11	localObject5	Object
    //   1074	1	11	localObject6	Object
    //   1082	12	11	localObject7	Object
    //   1099	35	11	localObject8	Object
    //   1138	1	11	localObject9	Object
    //   57	922	12	localObject10	Object
    //   997	10	12	localException1	Exception
    //   1017	7	12	localObject11	Object
    //   1055	56	12	localException2	Exception
    //   1116	14	12	localObject12	Object
    //   63	807	13	localObject13	Object
    //   880	14	13	localException3	Exception
    //   904	192	13	localObject14	Object
    //   1108	1	13	localException4	Exception
    //   1121	1	13	localException5	Exception
    //   1141	1	13	localObject15	Object
    //   97	745	14	localClsFileOutputStream	ClsFileOutputStream
    //   848	35	14	localObject16	Object
    //   900	58	14	localObject17	Object
    //   964	11	14	localObject18	Object
    //   1013	74	14	localObject19	Object
    //   1091	7	14	localObject20	Object
    //   1103	29	14	localObject21	Object
    //   60	732	15	localCodedOutputStream	CodedOutputStream
    //   817	29	15	localException6	Exception
    //   896	11	15	localObject22	Object
    //   929	33	15	localException7	Exception
    //   1009	11	15	localObject23	Object
    //   1069	1	15	localException8	Exception
    //   1146	1	15	localException9	Exception
    //   7	773	16	localObject24	Object
    //   23	789	17	str	String
    //   486	262	18	localContext	Context
    //   509	191	19	localStatFs	android.os.StatFs
    //   523	104	20	localIdManager	IdManager
    //   586	43	21	localSharedPreferences	android.content.SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   65	99	817	java/lang/Exception
    //   107	114	848	finally
    //   126	161	848	finally
    //   830	837	848	finally
    //   845	848	848	finally
    //   185	218	880	java/lang/Exception
    //   886	896	896	finally
    //   313	346	929	java/lang/Exception
    //   358	365	964	finally
    //   377	392	964	finally
    //   946	953	964	finally
    //   961	964	964	finally
    //   423	456	997	java/lang/Exception
    //   999	1009	1009	finally
    //   423	456	1042	finally
    //   464	471	1050	finally
    //   479	488	1050	finally
    //   496	511	1050	finally
    //   519	525	1050	finally
    //   538	546	1050	finally
    //   554	561	1050	finally
    //   578	588	1050	finally
    //   596	609	1050	finally
    //   626	635	1050	finally
    //   643	647	1050	finally
    //   655	662	1050	finally
    //   670	675	1050	finally
    //   683	691	1050	finally
    //   699	707	1050	finally
    //   715	722	1050	finally
    //   730	739	1050	finally
    //   747	753	1050	finally
    //   761	791	1050	finally
    //   464	471	1055	java/lang/Exception
    //   479	488	1055	java/lang/Exception
    //   496	511	1055	java/lang/Exception
    //   519	525	1055	java/lang/Exception
    //   538	546	1055	java/lang/Exception
    //   554	561	1055	java/lang/Exception
    //   578	588	1055	java/lang/Exception
    //   596	609	1055	java/lang/Exception
    //   626	635	1055	java/lang/Exception
    //   643	647	1055	java/lang/Exception
    //   655	662	1055	java/lang/Exception
    //   670	675	1055	java/lang/Exception
    //   683	691	1055	java/lang/Exception
    //   699	707	1055	java/lang/Exception
    //   715	722	1055	java/lang/Exception
    //   730	739	1055	java/lang/Exception
    //   747	753	1055	java/lang/Exception
    //   761	791	1055	java/lang/Exception
    //   313	346	1064	finally
    //   358	365	1069	java/lang/Exception
    //   377	392	1069	java/lang/Exception
    //   185	218	1074	finally
    //   218	225	1082	finally
    //   225	282	1091	finally
    //   218	225	1108	java/lang/Exception
    //   225	282	1121	java/lang/Exception
    //   65	99	1138	finally
    //   107	114	1146	java/lang/Exception
    //   126	161	1146	java/lang/Exception
  }
  
  private String getCurrentSessionId()
  {
    File[] arrayOfFile = listSortedSessionBeginFiles();
    if (arrayOfFile.length > 0) {
      return getSessionIdFromSessionFile(arrayOfFile[0]);
    }
    return null;
  }
  
  private File getFilesDir()
  {
    return fileStore.getFilesDir();
  }
  
  static String getSessionIdFromSessionFile(File paramFile)
  {
    return paramFile.getName().substring(0, 35);
  }
  
  private File[] listSortedSessionBeginFiles()
  {
    File[] arrayOfFile = listFilesMatching(new FileNameContainsFilter("BeginSession"));
    Arrays.sort(arrayOfFile, LARGEST_FILE_NAME_FIRST);
    return arrayOfFile;
  }
  
  private void sendSessionReports()
  {
    File[] arrayOfFile = listFilesMatching(SESSION_FILE_FILTER);
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      executorServiceWrapper.executeAsync(new SendSessionRunnable(crashlyticsCore, localFile));
      i += 1;
    }
  }
  
  private void trimSessionEventFiles(String paramString, int paramInt)
  {
    Utils.capFileCount(getFilesDir(), new FileNameContainsFilter(paramString + "SessionEvent"), paramInt, SMALLEST_FILE_NAME_FIRST);
  }
  
  private void writeInitialPartsTo(CodedOutputStream paramCodedOutputStream, String paramString)
    throws IOException
  {
    String[] arrayOfString = INITIAL_SESSION_PART_TAGS;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = arrayOfString[i];
      File[] arrayOfFile = listFilesMatching(new FileNameContainsFilter(paramString + str));
      if (arrayOfFile.length == 0) {
        Fabric.getLogger().e("CrashlyticsCore", "Can't find " + str + " data for session ID " + paramString, null);
      }
      for (;;)
      {
        i += 1;
        break;
        Fabric.getLogger().d("CrashlyticsCore", "Collecting " + str + " data for session ID " + paramString);
        writeToCosFromFile(paramCodedOutputStream, arrayOfFile[0]);
      }
    }
  }
  
  private static void writeNonFatalEventsTo(CodedOutputStream paramCodedOutputStream, File[] paramArrayOfFile, String paramString)
  {
    Arrays.sort(paramArrayOfFile, CommonUtils.FILE_MODIFIED_COMPARATOR);
    int j = paramArrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        File localFile = paramArrayOfFile[i];
        try
        {
          Fabric.getLogger().d("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[] { paramString, localFile.getName() }));
          writeToCosFromFile(paramCodedOutputStream, localFile);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Fabric.getLogger().e("CrashlyticsCore", "Error writting non-fatal to session.", localException);
          }
        }
      }
    }
  }
  
  private void writeSessionEvent(CodedOutputStream paramCodedOutputStream, Date paramDate, Thread paramThread, Throwable paramThrowable, String paramString, boolean paramBoolean)
    throws Exception
  {
    Object localObject2 = crashlyticsCore.context;
    long l1 = paramDate.getTime() / 1000L;
    float f = CommonUtils.getBatteryLevel((Context)localObject2);
    int j = CommonUtils.getBatteryVelocity((Context)localObject2, devicePowerStateListener.isPowerConnected);
    boolean bool = CommonUtils.getProximitySensorEnabled((Context)localObject2);
    int k = getResourcesgetConfigurationorientation;
    long l2 = CommonUtils.getTotalRamInBytes();
    long l3 = CommonUtils.calculateFreeRamInBytes((Context)localObject2);
    long l4 = CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath());
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = CommonUtils.getAppProcessInfo(((Context)localObject2).getPackageName(), (Context)localObject2);
    LinkedList localLinkedList = new LinkedList();
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    String str1 = crashlyticsCore.buildId;
    String str2 = idManager.appIdentifier;
    if (paramBoolean)
    {
      localObject1 = Thread.getAllStackTraces();
      paramDate = new Thread[((Map)localObject1).size()];
      int i = 0;
      Iterator localIterator = ((Map)localObject1).entrySet().iterator();
      for (;;)
      {
        localObject1 = paramDate;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)localIterator.next();
        paramDate[i] = ((Thread)((Map.Entry)localObject1).getKey());
        localLinkedList.add(((Map.Entry)localObject1).getValue());
        i += 1;
      }
    }
    Object localObject1 = new Thread[0];
    if (!CommonUtils.getBooleanResourceValue((Context)localObject2, "com.crashlytics.CollectCustomKeys", true)) {
      paramDate = new TreeMap();
    }
    for (;;)
    {
      SessionProtobufHelper.writeSessionEvent(paramCodedOutputStream, l1, paramString, paramThrowable, paramThread, arrayOfStackTraceElement, (Thread[])localObject1, localLinkedList, paramDate, logFileManager, localRunningAppProcessInfo, k, str2, str1, f, j, bool, l2 - l3, l4);
      return;
      localObject2 = Collections.unmodifiableMap(crashlyticsCore.attributes);
      paramDate = (Date)localObject2;
      if (localObject2 != null)
      {
        paramDate = (Date)localObject2;
        if (((Map)localObject2).size() > 1) {
          paramDate = new TreeMap((Map)localObject2);
        }
      }
    }
  }
  
  private static void writeToCosFromFile(CodedOutputStream paramCodedOutputStream, File paramFile)
    throws IOException
  {
    if (!paramFile.exists())
    {
      Fabric.getLogger().e("CrashlyticsCore", "Tried to include a file that doesn't exist: " + paramFile.getName(), null);
      return;
    }
    Object localObject = null;
    try
    {
      localFileInputStream = new FileInputStream(paramFile);
      CommonUtils.closeOrLog(paramCodedOutputStream, "Failed to close file input stream.");
    }
    finally
    {
      try
      {
        copyToCodedOutputStream(localFileInputStream, paramCodedOutputStream, (int)paramFile.length());
        CommonUtils.closeOrLog(localFileInputStream, "Failed to close file input stream.");
        return;
      }
      finally
      {
        FileInputStream localFileInputStream;
        paramCodedOutputStream = localFileInputStream;
      }
      paramFile = finally;
      paramCodedOutputStream = (CodedOutputStream)localObject;
    }
    throw paramFile;
  }
  
  final File[] listFilesMatching(FilenameFilter paramFilenameFilter)
  {
    File[] arrayOfFile = getFilesDir().listFiles(paramFilenameFilter);
    paramFilenameFilter = arrayOfFile;
    if (arrayOfFile == null) {
      paramFilenameFilter = new File[0];
    }
    return paramFilenameFilter;
  }
  
  /* Error */
  public final void uncaughtException(final Thread paramThread, final Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 163	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: iconst_1
    //   7: invokevirtual 971	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   10: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   13: ldc -44
    //   15: new 264	java/lang/StringBuilder
    //   18: dup
    //   19: ldc_w 973
    //   22: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: aload_2
    //   26: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: ldc_w 327
    //   32: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 332	java/lang/Thread:getName	()Ljava/lang/String;
    //   39: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokeinterface 336 3 0
    //   50: aload_0
    //   51: getfield 183	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:devicePowerStateListener	Lcom/crashlytics/android/core/DevicePowerStateListener;
    //   54: astore_3
    //   55: aload_3
    //   56: getfield 976	com/crashlytics/android/core/DevicePowerStateListener:receiversRegistered	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   59: iconst_0
    //   60: invokevirtual 980	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   63: ifeq +25 -> 88
    //   66: aload_3
    //   67: getfield 981	com/crashlytics/android/core/DevicePowerStateListener:context	Landroid/content/Context;
    //   70: aload_3
    //   71: getfield 985	com/crashlytics/android/core/DevicePowerStateListener:powerConnectedReceiver	Landroid/content/BroadcastReceiver;
    //   74: invokevirtual 989	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   77: aload_3
    //   78: getfield 981	com/crashlytics/android/core/DevicePowerStateListener:context	Landroid/content/Context;
    //   81: aload_3
    //   82: getfield 992	com/crashlytics/android/core/DevicePowerStateListener:powerDisconnectedReceiver	Landroid/content/BroadcastReceiver;
    //   85: invokevirtual 989	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   88: new 445	java/util/Date
    //   91: dup
    //   92: invokespecial 446	java/util/Date:<init>	()V
    //   95: astore_3
    //   96: aload_0
    //   97: getfield 142	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:executorServiceWrapper	Lcom/crashlytics/android/core/CrashlyticsExecutorServiceWrapper;
    //   100: new 24	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$5
    //   103: dup
    //   104: aload_0
    //   105: aload_3
    //   106: aload_1
    //   107: aload_2
    //   108: invokespecial 994	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$5:<init>	(Lcom/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler;Ljava/util/Date;Ljava/lang/Thread;Ljava/lang/Throwable;)V
    //   111: invokevirtual 998	com/crashlytics/android/core/CrashlyticsExecutorServiceWrapper:executeSyncLoggingException	(Ljava/util/concurrent/Callable;)Ljava/lang/Object;
    //   114: pop
    //   115: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   118: ldc -44
    //   120: ldc_w 1000
    //   123: invokeinterface 336 3 0
    //   128: aload_0
    //   129: getfield 140	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:defaultHandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   132: aload_1
    //   133: aload_2
    //   134: invokeinterface 1002 3 0
    //   139: aload_0
    //   140: getfield 163	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   143: iconst_0
    //   144: invokevirtual 971	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   147: aload_0
    //   148: monitorexit
    //   149: return
    //   150: astore_3
    //   151: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   154: ldc -44
    //   156: ldc_w 1004
    //   159: aload_3
    //   160: invokeinterface 220 4 0
    //   165: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   168: ldc -44
    //   170: ldc_w 1000
    //   173: invokeinterface 336 3 0
    //   178: aload_0
    //   179: getfield 140	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:defaultHandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   182: aload_1
    //   183: aload_2
    //   184: invokeinterface 1002 3 0
    //   189: aload_0
    //   190: getfield 163	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   193: iconst_0
    //   194: invokevirtual 971	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   197: goto -50 -> 147
    //   200: astore_1
    //   201: aload_0
    //   202: monitorexit
    //   203: aload_1
    //   204: athrow
    //   205: astore_3
    //   206: invokestatic 210	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   209: ldc -44
    //   211: ldc_w 1000
    //   214: invokeinterface 336 3 0
    //   219: aload_0
    //   220: getfield 140	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:defaultHandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   223: aload_1
    //   224: aload_2
    //   225: invokeinterface 1002 3 0
    //   230: aload_0
    //   231: getfield 163	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   234: iconst_0
    //   235: invokevirtual 971	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   238: aload_3
    //   239: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	240	1	paramThread	Thread
    //   0	240	2	paramThrowable	Throwable
    //   54	52	3	localObject1	Object
    //   150	10	3	localException	Exception
    //   205	34	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	88	150	java/lang/Exception
    //   88	115	150	java/lang/Exception
    //   2	10	200	finally
    //   115	147	200	finally
    //   165	197	200	finally
    //   206	240	200	finally
    //   10	88	205	finally
    //   88	115	205	finally
    //   151	165	205	finally
  }
  
  private static final class AnySessionPartFileFilter
    implements FilenameFilter
  {
    public final boolean accept(File paramFile, String paramString)
    {
      return (!CrashlyticsUncaughtExceptionHandler.SESSION_FILE_FILTER.accept(paramFile, paramString)) && (CrashlyticsUncaughtExceptionHandler.SESSION_FILE_PATTERN.matcher(paramString).matches());
    }
  }
  
  static final class FileNameContainsFilter
    implements FilenameFilter
  {
    private final String string;
    
    public FileNameContainsFilter(String paramString)
    {
      string = paramString;
    }
    
    public final boolean accept(File paramFile, String paramString)
    {
      return (paramString.contains(string)) && (!paramString.endsWith(".cls_temp"));
    }
  }
  
  private static final class SendSessionRunnable
    implements Runnable
  {
    private final CrashlyticsCore crashlyticsCore;
    private final File fileToSend;
    
    public SendSessionRunnable(CrashlyticsCore paramCrashlyticsCore, File paramFile)
    {
      crashlyticsCore = paramCrashlyticsCore;
      fileToSend = paramFile;
    }
    
    public final void run()
    {
      if (!CommonUtils.canTryConnection(crashlyticsCore.context)) {}
      Object localObject;
      do
      {
        return;
        Fabric.getLogger().d("CrashlyticsCore", "Attempting to send crash report at time of crash...");
        localObject = Settings.LazyHolder.access$100().awaitSettingsData();
        localObject = crashlyticsCore.getCreateReportSpiCall((SettingsData)localObject);
      } while (localObject == null);
      new ReportUploader((CreateReportSpiCall)localObject).forceUpload(new SessionReport(fileToSend, CrashlyticsUncaughtExceptionHandler.SEND_AT_CRASHTIME_HEADER));
    }
  }
  
  static final class SessionPartFileFilter
    implements FilenameFilter
  {
    private final String sessionId;
    
    public SessionPartFileFilter(String paramString)
    {
      sessionId = paramString;
    }
    
    public final boolean accept(File paramFile, String paramString)
    {
      if (paramString.equals(sessionId + ".cls")) {}
      while ((!paramString.contains(sessionId)) || (paramString.endsWith(".cls_temp"))) {
        return false;
      }
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */