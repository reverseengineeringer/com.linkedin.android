package com.linkedin.android.l2m.deeplink;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import com.linkedin.android.deeplink.helper.DeeplinkHelper;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.growth.takeover.NewToVoyagerTransactionalLaunchManager;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.performance.CrashReporter;
import java.util.ArrayList;
import javax.inject.Inject;

public class DeepLinkHelperActivity
  extends BaseActivity
{
  private static final String TAG = DeepLinkHelperActivity.class.getSimpleName();
  private CommTracker commTracker;
  @Inject
  DeepLinkManager deepLinkManager;
  @Inject
  DeeplinkHelper deeplinkHelper;
  private boolean deeplinkOnResume;
  @Inject
  LixManager lixManager;
  @Inject
  NewToVoyagerTransactionalLaunchManager newToVoyagerTransactionalLaunchManager;
  
  /* Error */
  private void deeplink()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 46	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:getIntent	()Landroid/content/Intent;
    //   4: astore 6
    //   6: aload_0
    //   7: getfield 50	com/linkedin/android/infra/app/BaseActivity:activityComponent	Lcom/linkedin/android/infra/components/ActivityComponent;
    //   10: aload_0
    //   11: invokeinterface 56 2 0
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 60	com/linkedin/android/infra/app/BaseActivity:applicationComponent	Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   21: invokeinterface 65 1 0
    //   26: putfield 67	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:commTracker	Lcom/linkedin/android/l2m/deeplink/CommTracker;
    //   29: getstatic 73	com/linkedin/android/perftimer/RUMBuilder$FOREGROUNDING_MODE:DEEP_LINKED	Lcom/linkedin/android/perftimer/RUMBuilder$FOREGROUNDING_MODE;
    //   32: invokestatic 79	com/linkedin/android/perftimer/RUMTiming:setForegroundingMode	(Lcom/linkedin/android/perftimer/RUMBuilder$FOREGROUNDING_MODE;)V
    //   35: aload 6
    //   37: ldc 81
    //   39: iconst_0
    //   40: invokevirtual 87	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   43: ifeq +759 -> 802
    //   46: new 89	java/lang/Throwable
    //   49: dup
    //   50: ldc 91
    //   52: invokespecial 94	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   55: invokestatic 100	com/linkedin/android/infra/performance/CrashReporter:reportNonFatal	(Ljava/lang/Throwable;)V
    //   58: ldc 102
    //   60: invokestatic 105	com/linkedin/android/infra/performance/CrashReporter:leaveBreadcrumb	(Ljava/lang/String;)V
    //   63: aload_0
    //   64: invokevirtual 109	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:getApplication	()Landroid/app/Application;
    //   67: checkcast 111	com/linkedin/android/infra/app/FlagshipApplication
    //   70: invokevirtual 115	com/linkedin/android/infra/app/FlagshipApplication:getAppComponent	()Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   73: astore 5
    //   75: aload 5
    //   77: invokeinterface 119 1 0
    //   82: astore 4
    //   84: aload 5
    //   86: invokeinterface 123 1 0
    //   91: astore 5
    //   93: aload 4
    //   95: new 125	com/linkedin/gen/avro2pegasus/events/messages/MessageActionEvent$Builder
    //   98: dup
    //   99: invokespecial 126	com/linkedin/gen/avro2pegasus/events/messages/MessageActionEvent$Builder:<init>	()V
    //   102: getstatic 132	com/linkedin/gen/avro2pegasus/events/messages/actionType:TAP	Lcom/linkedin/gen/avro2pegasus/events/messages/actionType;
    //   105: invokevirtual 136	com/linkedin/gen/avro2pegasus/events/messages/MessageActionEvent$Builder:setActionType	(Lcom/linkedin/gen/avro2pegasus/events/messages/actionType;)Lcom/linkedin/gen/avro2pegasus/events/messages/MessageActionEvent$Builder;
    //   108: getstatic 142	com/linkedin/gen/avro2pegasus/events/MessageType:PUSHNOTIFICATION	Lcom/linkedin/gen/avro2pegasus/events/MessageType;
    //   111: invokevirtual 146	com/linkedin/gen/avro2pegasus/events/messages/MessageActionEvent$Builder:setMessageType	(Lcom/linkedin/gen/avro2pegasus/events/MessageType;)Lcom/linkedin/gen/avro2pegasus/events/messages/MessageActionEvent$Builder;
    //   114: new 148	com/linkedin/gen/avro2pegasus/events/messages/MessageId$Builder
    //   117: dup
    //   118: invokespecial 149	com/linkedin/gen/avro2pegasus/events/messages/MessageId$Builder:<init>	()V
    //   121: aload 6
    //   123: ldc -105
    //   125: invokevirtual 155	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   128: invokevirtual 159	com/linkedin/gen/avro2pegasus/events/messages/MessageId$Builder:setFlockMessageUrn	(Ljava/lang/String;)Lcom/linkedin/gen/avro2pegasus/events/messages/MessageId$Builder;
    //   131: aload 5
    //   133: invokevirtual 164	com/linkedin/android/infra/data/FlagshipSharedPreferences:getNotificationToken	()Ljava/lang/String;
    //   136: invokevirtual 167	com/linkedin/gen/avro2pegasus/events/messages/MessageId$Builder:setDeliveryId	(Ljava/lang/String;)Lcom/linkedin/gen/avro2pegasus/events/messages/MessageId$Builder;
    //   139: new 169	java/util/ArrayList
    //   142: dup
    //   143: invokespecial 170	java/util/ArrayList:<init>	()V
    //   146: invokevirtual 174	com/linkedin/gen/avro2pegasus/events/messages/MessageId$Builder:setExternalIds	(Ljava/util/List;)Lcom/linkedin/gen/avro2pegasus/events/messages/MessageId$Builder;
    //   149: invokevirtual 178	com/linkedin/gen/avro2pegasus/events/messages/MessageId$Builder:build	()Lcom/linkedin/gen/avro2pegasus/events/messages/MessageId;
    //   152: invokevirtual 182	com/linkedin/gen/avro2pegasus/events/messages/MessageActionEvent$Builder:setMessageId	(Lcom/linkedin/gen/avro2pegasus/events/messages/MessageId;)Lcom/linkedin/gen/avro2pegasus/events/messages/MessageActionEvent$Builder;
    //   155: invokevirtual 188	com/linkedin/android/litrackinglib/metric/Tracker:send	(Lcom/linkedin/android/tracking/v2/event/TrackingEventBuilder;)V
    //   158: ldc -66
    //   160: aload_0
    //   161: getfield 192	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:lixManager	Lcom/linkedin/android/infra/lix/LixManager;
    //   164: getstatic 198	com/linkedin/android/infra/lix/Lix:GROWTH_DEEPLINK_REFACTOR	Lcom/linkedin/android/infra/lix/Lix;
    //   167: invokeinterface 204 2 0
    //   172: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   175: ifeq +636 -> 811
    //   178: aload_0
    //   179: getfield 212	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:deepLinkManager	Lcom/linkedin/android/l2m/deeplink/DeepLinkManager;
    //   182: aload_0
    //   183: aload_0
    //   184: aload 6
    //   186: invokevirtual 218	com/linkedin/android/l2m/deeplink/DeepLinkManager:getOutboundIntents	(Landroid/content/Context;Landroid/app/Activity;Landroid/content/Intent;)Ljava/util/ArrayList;
    //   189: astore 5
    //   191: aload 5
    //   193: invokevirtual 222	java/util/ArrayList:isEmpty	()Z
    //   196: ifne +516 -> 712
    //   199: aload 6
    //   201: invokevirtual 226	android/content/Intent:getData	()Landroid/net/Uri;
    //   204: astore 8
    //   206: aload 5
    //   208: aload 5
    //   210: invokevirtual 230	java/util/ArrayList:size	()I
    //   213: iconst_1
    //   214: isub
    //   215: invokevirtual 234	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   218: checkcast 83	android/content/Intent
    //   221: astore 9
    //   223: aload_0
    //   224: invokevirtual 46	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:getIntent	()Landroid/content/Intent;
    //   227: astore 10
    //   229: aload 10
    //   231: ldc -20
    //   233: invokevirtual 240	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   236: checkcast 242	android/net/Uri
    //   239: astore 4
    //   241: aload 4
    //   243: ifnull +1515 -> 1758
    //   246: aload 4
    //   248: invokevirtual 245	android/net/Uri:toString	()Ljava/lang/String;
    //   251: astore 4
    //   253: aload 9
    //   255: ldc -9
    //   257: aload 4
    //   259: invokevirtual 251	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   262: pop
    //   263: aload 9
    //   265: ldc -3
    //   267: aload 6
    //   269: invokevirtual 256	android/content/Intent:getDataString	()Ljava/lang/String;
    //   272: invokevirtual 251	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   275: pop
    //   276: aload 9
    //   278: ldc_w 258
    //   281: iconst_1
    //   282: invokevirtual 261	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   285: pop
    //   286: aload 8
    //   288: ifnull +31 -> 319
    //   291: aload 8
    //   293: ldc_w 263
    //   296: invokevirtual 266	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   299: ifnull +20 -> 319
    //   302: aload 9
    //   304: ldc_w 263
    //   307: aload 8
    //   309: ldc_w 263
    //   312: invokevirtual 266	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   315: invokevirtual 251	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   318: pop
    //   319: aload 6
    //   321: invokestatic 270	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:isInboundIntentViaThirdPartySdk	(Landroid/content/Intent;)Z
    //   324: istore_3
    //   325: aload 6
    //   327: invokevirtual 273	android/content/Intent:getType	()Ljava/lang/String;
    //   330: astore 4
    //   332: ldc_w 275
    //   335: aload 6
    //   337: invokevirtual 278	android/content/Intent:getAction	()Ljava/lang/String;
    //   340: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   343: ifeq +1576 -> 1919
    //   346: aload 4
    //   348: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   351: ifne +1568 -> 1919
    //   354: aload 4
    //   356: ldc_w 285
    //   359: invokevirtual 289	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   362: ifne +1522 -> 1884
    //   365: aload 4
    //   367: ldc_w 291
    //   370: invokevirtual 289	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   373: ifeq +1546 -> 1919
    //   376: goto +1508 -> 1884
    //   379: aload_0
    //   380: getfield 60	com/linkedin/android/infra/app/BaseActivity:applicationComponent	Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   383: invokeinterface 294 1 0
    //   388: getstatic 297	com/linkedin/android/infra/lix/Lix:FEED_CHERRY	Lcom/linkedin/android/infra/lix/Lix;
    //   391: invokeinterface 204 2 0
    //   396: astore 4
    //   398: aload 9
    //   400: invokevirtual 301	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   403: astore 7
    //   405: aload 4
    //   407: ldc -66
    //   409: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   412: ifeq +1517 -> 1929
    //   415: aload 7
    //   417: ifnull +1512 -> 1929
    //   420: aload 7
    //   422: invokevirtual 306	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   425: ldc_w 308
    //   428: invokevirtual 311	java/lang/Class:getName	()Ljava/lang/String;
    //   431: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   434: ifeq +1495 -> 1929
    //   437: aload 9
    //   439: invokevirtual 315	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   442: invokestatic 321	com/linkedin/android/home/HomeBundle:getActiveTabBundle	(Landroid/os/Bundle;)Landroid/os/Bundle;
    //   445: astore 4
    //   447: aload 4
    //   449: ifnull +1480 -> 1929
    //   452: aload 4
    //   454: invokestatic 327	com/linkedin/android/feed/page/feed/FeedBundleBuilder:getHighlightedTypes	(Landroid/os/Bundle;)[Ljava/lang/String;
    //   457: ifnull +1467 -> 1924
    //   460: aload 4
    //   462: invokestatic 330	com/linkedin/android/feed/page/feed/FeedBundleBuilder:getHighlightedUrns	(Landroid/os/Bundle;)[Ljava/lang/String;
    //   465: ifnull +1459 -> 1924
    //   468: iconst_1
    //   469: istore_1
    //   470: iload_3
    //   471: ifne +1333 -> 1804
    //   474: iload_2
    //   475: ifne +1329 -> 1804
    //   478: iload_1
    //   479: ifne +1325 -> 1804
    //   482: aload_0
    //   483: aload 9
    //   485: aload 5
    //   487: aload 8
    //   489: invokespecial 334	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:deeplinkToIntentsWithBackstack	(Landroid/content/Intent;Ljava/util/ArrayList;Landroid/net/Uri;)V
    //   492: aload 8
    //   494: ifnull +55 -> 549
    //   497: iload_3
    //   498: ifne +51 -> 549
    //   501: aload 8
    //   503: invokevirtual 338	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   506: astore 4
    //   508: aload 4
    //   510: invokeinterface 341 1 0
    //   515: ifne +34 -> 549
    //   518: aload 4
    //   520: iconst_0
    //   521: invokeinterface 342 2 0
    //   526: checkcast 206	java/lang/String
    //   529: ldc_w 344
    //   532: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   535: ifeq +14 -> 549
    //   538: aload_0
    //   539: getfield 67	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:commTracker	Lcom/linkedin/android/l2m/deeplink/CommTracker;
    //   542: aload 8
    //   544: invokeinterface 350 2 0
    //   549: aload_0
    //   550: getfield 352	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:newToVoyagerTransactionalLaunchManager	Lcom/linkedin/android/growth/takeover/NewToVoyagerTransactionalLaunchManager;
    //   553: astore 4
    //   555: aload 4
    //   557: getfield 358	com/linkedin/android/growth/takeover/NewToVoyagerTransactionalLaunchManager:dataManager	Lcom/linkedin/android/infra/data/FlagshipDataManager;
    //   560: invokestatic 363	com/linkedin/android/infra/data/Request:get	()Lcom/linkedin/android/infra/data/Request$Builder;
    //   563: getstatic 369	com/linkedin/android/infra/shared/Routes:TAKEOVERS	Lcom/linkedin/android/infra/shared/Routes;
    //   566: invokevirtual 372	com/linkedin/android/infra/shared/Routes:buildUponRoot	()Landroid/net/Uri;
    //   569: invokevirtual 245	android/net/Uri:toString	()Ljava/lang/String;
    //   572: invokevirtual 378	com/linkedin/android/infra/data/Request$Builder:url	(Ljava/lang/String;)Lcom/linkedin/android/infra/data/Request$Builder;
    //   575: getstatic 384	com/linkedin/android/pegasus/gen/voyager/common/Takeover:BUILDER	Lcom/linkedin/android/pegasus/gen/voyager/common/TakeoverBuilder;
    //   578: invokestatic 390	com/linkedin/android/pegasus/gen/collection/CollectionTemplate:of	(Lcom/linkedin/android/fission/interfaces/FissileDataModelBuilder;)Lcom/linkedin/android/pegasus/gen/collection/CollectionTemplate$CollectionTemplateJsonParser;
    //   581: invokevirtual 394	com/linkedin/android/infra/data/Request$Builder:builder	(Lcom/linkedin/data/lite/DataTemplateBuilder;)Lcom/linkedin/android/infra/data/Request$Builder;
    //   584: new 396	com/linkedin/android/growth/takeover/NewToVoyagerTransactionalLaunchManager$1
    //   587: dup
    //   588: aload 4
    //   590: invokespecial 399	com/linkedin/android/growth/takeover/NewToVoyagerTransactionalLaunchManager$1:<init>	(Lcom/linkedin/android/growth/takeover/NewToVoyagerTransactionalLaunchManager;)V
    //   593: invokevirtual 403	com/linkedin/android/infra/data/Request$Builder:listener	(Lcom/linkedin/android/datamanager/interfaces/RecordTemplateListener;)Lcom/linkedin/android/infra/data/Request$Builder;
    //   596: getstatic 409	com/linkedin/android/datamanager/DataManager$DataStoreFilter:NETWORK_ONLY	Lcom/linkedin/android/datamanager/DataManager$DataStoreFilter;
    //   599: invokevirtual 413	com/linkedin/android/infra/data/Request$Builder:filter	(Lcom/linkedin/android/datamanager/DataManager$DataStoreFilter;)Lcom/linkedin/android/infra/data/Request$Builder;
    //   602: invokevirtual 419	com/linkedin/android/infra/data/FlagshipDataManager:submit	(Lcom/linkedin/android/infra/data/Request$Builder;)V
    //   605: aload_0
    //   606: getfield 50	com/linkedin/android/infra/app/BaseActivity:activityComponent	Lcom/linkedin/android/infra/components/ActivityComponent;
    //   609: astore 5
    //   611: aload 6
    //   613: invokevirtual 315	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   616: astore 4
    //   618: aload 4
    //   620: ifnonnull +1193 -> 1813
    //   623: aconst_null
    //   624: astore 4
    //   626: aload 4
    //   628: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   631: istore_3
    //   632: iload_3
    //   633: ifne +79 -> 712
    //   636: aload 4
    //   638: invokestatic 425	com/linkedin/android/pegasus/gen/common/Urn:createFromString	(Ljava/lang/String;)Lcom/linkedin/android/pegasus/gen/common/Urn;
    //   641: pop
    //   642: aload 5
    //   644: invokeinterface 428 1 0
    //   649: invokestatic 431	com/linkedin/android/infra/data/Request:post	()Lcom/linkedin/android/infra/data/Request$Builder;
    //   652: getstatic 437	com/linkedin/android/home/HomeTabInfo:NOTIFICATIONS	Lcom/linkedin/android/home/HomeTabInfo;
    //   655: invokestatic 443	com/linkedin/android/home/HomeFragmentDataProvider:getClearSomeRoute	(Lcom/linkedin/android/home/HomeTabInfo;)Ljava/lang/String;
    //   658: invokevirtual 378	com/linkedin/android/infra/data/Request$Builder:url	(Ljava/lang/String;)Lcom/linkedin/android/infra/data/Request$Builder;
    //   661: new 445	com/linkedin/android/pegasus/gen/common/JsonModel
    //   664: dup
    //   665: new 447	org/json/JSONObject
    //   668: dup
    //   669: invokespecial 448	org/json/JSONObject:<init>	()V
    //   672: ldc_w 450
    //   675: new 452	org/json/JSONArray
    //   678: dup
    //   679: iconst_1
    //   680: anewarray 206	java/lang/String
    //   683: dup
    //   684: iconst_0
    //   685: aload 4
    //   687: aastore
    //   688: invokestatic 458	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   691: invokespecial 461	org/json/JSONArray:<init>	(Ljava/util/Collection;)V
    //   694: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   697: invokespecial 468	com/linkedin/android/pegasus/gen/common/JsonModel:<init>	(Lorg/json/JSONObject;)V
    //   700: invokevirtual 472	com/linkedin/android/infra/data/Request$Builder:model	(Lcom/linkedin/data/lite/RecordTemplate;)Lcom/linkedin/android/infra/data/Request$Builder;
    //   703: getstatic 409	com/linkedin/android/datamanager/DataManager$DataStoreFilter:NETWORK_ONLY	Lcom/linkedin/android/datamanager/DataManager$DataStoreFilter;
    //   706: invokevirtual 413	com/linkedin/android/infra/data/Request$Builder:filter	(Lcom/linkedin/android/datamanager/DataManager$DataStoreFilter;)Lcom/linkedin/android/infra/data/Request$Builder;
    //   709: invokevirtual 419	com/linkedin/android/infra/data/FlagshipDataManager:submit	(Lcom/linkedin/android/infra/data/Request$Builder;)V
    //   712: aload 6
    //   714: ldc_w 474
    //   717: invokevirtual 477	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   720: ifeq +44 -> 764
    //   723: aload 6
    //   725: ldc_w 474
    //   728: iconst_m1
    //   729: invokevirtual 481	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   732: istore_1
    //   733: iload_1
    //   734: iconst_m1
    //   735: if_icmpeq +29 -> 764
    //   738: aload_0
    //   739: getfield 60	com/linkedin/android/infra/app/BaseActivity:applicationComponent	Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   742: invokeinterface 485 1 0
    //   747: iload_1
    //   748: invokevirtual 491	com/linkedin/android/l2m/notification/NotificationDisplayUtils:cancel	(I)V
    //   751: aload_0
    //   752: getfield 50	com/linkedin/android/infra/app/BaseActivity:activityComponent	Lcom/linkedin/android/infra/components/ActivityComponent;
    //   755: invokeinterface 495 1 0
    //   760: iload_1
    //   761: invokestatic 501	com/linkedin/android/l2m/notification/NotificationCacheUtils:deleteNotificationFromCache	(Lcom/linkedin/android/infra/data/FlagshipCacheManager;I)V
    //   764: aload_0
    //   765: invokevirtual 504	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:finish	()V
    //   768: return
    //   769: astore 4
    //   771: getstatic 29	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:TAG	Ljava/lang/String;
    //   774: new 506	java/lang/StringBuilder
    //   777: dup
    //   778: ldc_w 508
    //   781: invokespecial 509	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   784: aload 6
    //   786: invokevirtual 510	android/content/Intent:toString	()Ljava/lang/String;
    //   789: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: invokestatic 521	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   798: pop
    //   799: goto -641 -> 158
    //   802: ldc_w 523
    //   805: invokestatic 105	com/linkedin/android/infra/performance/CrashReporter:leaveBreadcrumb	(Ljava/lang/String;)V
    //   808: goto -650 -> 158
    //   811: new 169	java/util/ArrayList
    //   814: dup
    //   815: invokespecial 170	java/util/ArrayList:<init>	()V
    //   818: astore 7
    //   820: aload 6
    //   822: invokevirtual 278	android/content/Intent:getAction	()Ljava/lang/String;
    //   825: astore 5
    //   827: new 525	android/os/Bundle
    //   830: dup
    //   831: invokespecial 526	android/os/Bundle:<init>	()V
    //   834: pop
    //   835: ldc_w 528
    //   838: aload 5
    //   840: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   843: ifeq +732 -> 1575
    //   846: aload 6
    //   848: invokestatic 270	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:isInboundIntentViaThirdPartySdk	(Landroid/content/Intent;)Z
    //   851: ifeq +426 -> 1277
    //   854: aload_0
    //   855: invokevirtual 109	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:getApplication	()Landroid/app/Application;
    //   858: checkcast 111	com/linkedin/android/infra/app/FlagshipApplication
    //   861: invokevirtual 115	com/linkedin/android/infra/app/FlagshipApplication:getAppComponent	()Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   864: invokeinterface 119 1 0
    //   869: astore 4
    //   871: aload 6
    //   873: invokevirtual 226	android/content/Intent:getData	()Landroid/net/Uri;
    //   876: invokevirtual 531	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   879: astore 5
    //   881: new 83	android/content/Intent
    //   884: dup
    //   885: aload_0
    //   886: ldc_w 533
    //   889: invokespecial 536	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   892: astore 8
    //   894: ldc_w 538
    //   897: aload 5
    //   899: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   902: ifeq +134 -> 1036
    //   905: invokestatic 544	com/linkedin/android/identity/profile/ProfileBundleBuilder:createSelfProfile	()Lcom/linkedin/android/identity/profile/ProfileBundleBuilder;
    //   908: astore 4
    //   910: new 169	java/util/ArrayList
    //   913: dup
    //   914: invokespecial 170	java/util/ArrayList:<init>	()V
    //   917: astore 5
    //   919: aload 4
    //   921: aload_0
    //   922: invokevirtual 547	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:getCallingPackage	()Ljava/lang/String;
    //   925: invokevirtual 550	com/linkedin/android/identity/profile/ProfileBundleBuilder:setThirdPartyPackageName	(Ljava/lang/String;)V
    //   928: aload 8
    //   930: aload 4
    //   932: invokevirtual 552	com/linkedin/android/identity/profile/ProfileBundleBuilder:build	()Landroid/os/Bundle;
    //   935: invokevirtual 556	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   938: pop
    //   939: aload 8
    //   941: ldc_w 557
    //   944: invokevirtual 561	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   947: pop
    //   948: aload 5
    //   950: aload 8
    //   952: invokeinterface 564 2 0
    //   957: pop
    //   958: aload 7
    //   960: astore 4
    //   962: aload 5
    //   964: ifnull +15 -> 979
    //   967: aload 7
    //   969: aload 5
    //   971: invokevirtual 568	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   974: pop
    //   975: aload 7
    //   977: astore 4
    //   979: aload 4
    //   981: invokevirtual 222	java/util/ArrayList:isEmpty	()Z
    //   984: ifeq +905 -> 1889
    //   987: new 317	com/linkedin/android/home/HomeBundle
    //   990: dup
    //   991: invokespecial 569	com/linkedin/android/home/HomeBundle:<init>	()V
    //   994: astore 5
    //   996: aload 5
    //   998: getstatic 572	com/linkedin/android/home/HomeTabInfo:FEED	Lcom/linkedin/android/home/HomeTabInfo;
    //   1001: putfield 575	com/linkedin/android/home/HomeBundle:activeTab	Lcom/linkedin/android/home/HomeTabInfo;
    //   1004: aload_0
    //   1005: getfield 579	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:intentRegistry	Lcom/linkedin/android/infra/IntentRegistry;
    //   1008: getfield 585	com/linkedin/android/infra/IntentRegistry:home	Lcom/linkedin/android/home/HomeIntent;
    //   1011: aload_0
    //   1012: aload 5
    //   1014: invokevirtual 591	com/linkedin/android/home/HomeIntent:newIntent	(Landroid/content/Context;Lcom/linkedin/android/infra/BundleBuilder;)Landroid/content/Intent;
    //   1017: astore 5
    //   1019: aload 5
    //   1021: invokestatic 597	com/linkedin/android/deeplink/helper/LaunchHelper:appendValuesToIntent	(Landroid/content/Intent;)Landroid/content/Intent;
    //   1024: pop
    //   1025: aload 4
    //   1027: aload 5
    //   1029: invokevirtual 598	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1032: pop
    //   1033: goto +856 -> 1889
    //   1036: ldc_w 600
    //   1039: aload 5
    //   1041: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1044: ifeq +185 -> 1229
    //   1047: aload 6
    //   1049: invokevirtual 226	android/content/Intent:getData	()Landroid/net/Uri;
    //   1052: invokevirtual 603	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1055: astore 5
    //   1057: aload 6
    //   1059: invokevirtual 226	android/content/Intent:getData	()Landroid/net/Uri;
    //   1062: ldc_w 605
    //   1065: invokevirtual 266	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   1068: astore 9
    //   1070: aload 5
    //   1072: invokestatic 609	com/linkedin/xmsg/util/StringUtils:isEmpty	(Ljava/lang/String;)Z
    //   1075: ifne +54 -> 1129
    //   1078: aload 9
    //   1080: invokestatic 609	com/linkedin/xmsg/util/StringUtils:isEmpty	(Ljava/lang/String;)Z
    //   1083: ifne +46 -> 1129
    //   1086: new 506	java/lang/StringBuilder
    //   1089: dup
    //   1090: ldc_w 611
    //   1093: invokespecial 509	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1096: aload 5
    //   1098: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: ldc_w 613
    //   1104: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: aload 9
    //   1109: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: ldc_w 615
    //   1115: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: invokestatic 619	com/linkedin/android/identity/profile/ProfileBundleBuilder:createFromExternalIdentifier	(Ljava/lang/String;)Lcom/linkedin/android/identity/profile/ProfileBundleBuilder;
    //   1124: astore 4
    //   1126: goto -216 -> 910
    //   1129: aload 4
    //   1131: aload 6
    //   1133: invokevirtual 226	android/content/Intent:getData	()Landroid/net/Uri;
    //   1136: invokevirtual 245	android/net/Uri:toString	()Ljava/lang/String;
    //   1139: getstatic 625	com/linkedin/gen/avro2pegasus/events/mobile/LinkFailureType:URL_ROUTE_VERIFICATION_FAILURE	Lcom/linkedin/gen/avro2pegasus/events/mobile/LinkFailureType;
    //   1142: invokestatic 629	com/linkedin/android/deeplink/helper/LaunchHelper:sendInboundExternalLinkFailureEvent	(Lcom/linkedin/android/litrackinglib/metric/Tracker;Ljava/lang/String;Lcom/linkedin/gen/avro2pegasus/events/mobile/LinkFailureType;)V
    //   1145: new 38	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1148: dup
    //   1149: new 506	java/lang/StringBuilder
    //   1152: dup
    //   1153: ldc_w 631
    //   1156: invokespecial 509	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1159: aload 6
    //   1161: invokevirtual 226	android/content/Intent:getData	()Landroid/net/Uri;
    //   1164: invokevirtual 245	android/net/Uri:toString	()Ljava/lang/String;
    //   1167: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1173: invokespecial 632	com/linkedin/android/deeplink/exceptions/DeeplinkException:<init>	(Ljava/lang/String;)V
    //   1176: athrow
    //   1177: astore 4
    //   1179: new 634	java/lang/RuntimeException
    //   1182: dup
    //   1183: aload 4
    //   1185: invokevirtual 637	com/linkedin/android/deeplink/exceptions/DeeplinkException:getMessage	()Ljava/lang/String;
    //   1188: aload 4
    //   1190: invokevirtual 641	com/linkedin/android/deeplink/exceptions/DeeplinkException:getCause	()Ljava/lang/Throwable;
    //   1193: invokespecial 644	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1196: invokestatic 650	com/linkedin/android/infra/shared/Util:safeThrow$7a8b4789	(Ljava/lang/RuntimeException;)V
    //   1199: new 89	java/lang/Throwable
    //   1202: dup
    //   1203: ldc_w 652
    //   1206: aload 4
    //   1208: invokespecial 653	java/lang/Throwable:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1211: invokestatic 100	com/linkedin/android/infra/performance/CrashReporter:reportNonFatal	(Ljava/lang/Throwable;)V
    //   1214: getstatic 29	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:TAG	Ljava/lang/String;
    //   1217: ldc_w 652
    //   1220: aload 4
    //   1222: invokestatic 656	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1225: pop
    //   1226: goto -514 -> 712
    //   1229: aload 4
    //   1231: aload 6
    //   1233: invokevirtual 226	android/content/Intent:getData	()Landroid/net/Uri;
    //   1236: invokevirtual 245	android/net/Uri:toString	()Ljava/lang/String;
    //   1239: getstatic 625	com/linkedin/gen/avro2pegasus/events/mobile/LinkFailureType:URL_ROUTE_VERIFICATION_FAILURE	Lcom/linkedin/gen/avro2pegasus/events/mobile/LinkFailureType;
    //   1242: invokestatic 629	com/linkedin/android/deeplink/helper/LaunchHelper:sendInboundExternalLinkFailureEvent	(Lcom/linkedin/android/litrackinglib/metric/Tracker;Ljava/lang/String;Lcom/linkedin/gen/avro2pegasus/events/mobile/LinkFailureType;)V
    //   1245: new 38	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1248: dup
    //   1249: new 506	java/lang/StringBuilder
    //   1252: dup
    //   1253: ldc_w 631
    //   1256: invokespecial 509	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1259: aload 6
    //   1261: invokevirtual 226	android/content/Intent:getData	()Landroid/net/Uri;
    //   1264: invokevirtual 245	android/net/Uri:toString	()Ljava/lang/String;
    //   1267: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1273: invokespecial 632	com/linkedin/android/deeplink/exceptions/DeeplinkException:<init>	(Ljava/lang/String;)V
    //   1276: athrow
    //   1277: aload 6
    //   1279: invokevirtual 226	android/content/Intent:getData	()Landroid/net/Uri;
    //   1282: astore 8
    //   1284: aload 8
    //   1286: ifnull +615 -> 1901
    //   1289: aload 8
    //   1291: invokevirtual 659	android/net/Uri:getScheme	()Ljava/lang/String;
    //   1294: astore 4
    //   1296: aload 8
    //   1298: invokevirtual 531	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   1301: astore 5
    //   1303: aload 8
    //   1305: ldc_w 661
    //   1308: invokevirtual 266	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   1311: astore 8
    //   1313: ldc_w 663
    //   1316: aload 4
    //   1318: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1321: ifeq +575 -> 1896
    //   1324: ldc_w 600
    //   1327: aload 5
    //   1329: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1332: ifeq +564 -> 1896
    //   1335: aload 8
    //   1337: ifnull +559 -> 1896
    //   1340: aload 8
    //   1342: ldc_w 665
    //   1345: invokevirtual 289	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1348: ifeq +548 -> 1896
    //   1351: iconst_1
    //   1352: istore_1
    //   1353: iload_1
    //   1354: ifeq +171 -> 1525
    //   1357: aload_0
    //   1358: invokevirtual 109	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:getApplication	()Landroid/app/Application;
    //   1361: checkcast 111	com/linkedin/android/infra/app/FlagshipApplication
    //   1364: invokevirtual 115	com/linkedin/android/infra/app/FlagshipApplication:getAppComponent	()Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   1367: invokeinterface 119 1 0
    //   1372: astore 5
    //   1374: aload 6
    //   1376: invokevirtual 226	android/content/Intent:getData	()Landroid/net/Uri;
    //   1379: astore 4
    //   1381: aload 4
    //   1383: invokevirtual 338	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   1386: invokeinterface 341 1 0
    //   1391: ifne +515 -> 1906
    //   1394: aload 4
    //   1396: invokevirtual 338	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   1399: iconst_0
    //   1400: invokeinterface 342 2 0
    //   1405: checkcast 206	java/lang/String
    //   1408: astore 4
    //   1410: aload 4
    //   1412: ifnull +65 -> 1477
    //   1415: new 169	java/util/ArrayList
    //   1418: dup
    //   1419: invokespecial 170	java/util/ArrayList:<init>	()V
    //   1422: astore 5
    //   1424: aload 4
    //   1426: invokestatic 668	com/linkedin/android/identity/profile/ProfileBundleBuilder:createFromMemberId	(Ljava/lang/String;)Lcom/linkedin/android/identity/profile/ProfileBundleBuilder;
    //   1429: astore 4
    //   1431: new 83	android/content/Intent
    //   1434: dup
    //   1435: aload_0
    //   1436: ldc_w 533
    //   1439: invokespecial 536	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1442: astore 8
    //   1444: aload 8
    //   1446: aload 4
    //   1448: invokevirtual 552	com/linkedin/android/identity/profile/ProfileBundleBuilder:build	()Landroid/os/Bundle;
    //   1451: invokevirtual 556	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   1454: pop
    //   1455: aload 8
    //   1457: ldc_w 557
    //   1460: invokevirtual 561	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1463: pop
    //   1464: aload 5
    //   1466: aload 8
    //   1468: invokeinterface 564 2 0
    //   1473: pop
    //   1474: goto -516 -> 958
    //   1477: aload 5
    //   1479: aload 6
    //   1481: invokevirtual 226	android/content/Intent:getData	()Landroid/net/Uri;
    //   1484: invokevirtual 245	android/net/Uri:toString	()Ljava/lang/String;
    //   1487: getstatic 625	com/linkedin/gen/avro2pegasus/events/mobile/LinkFailureType:URL_ROUTE_VERIFICATION_FAILURE	Lcom/linkedin/gen/avro2pegasus/events/mobile/LinkFailureType;
    //   1490: invokestatic 629	com/linkedin/android/deeplink/helper/LaunchHelper:sendInboundExternalLinkFailureEvent	(Lcom/linkedin/android/litrackinglib/metric/Tracker;Ljava/lang/String;Lcom/linkedin/gen/avro2pegasus/events/mobile/LinkFailureType;)V
    //   1493: new 38	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1496: dup
    //   1497: new 506	java/lang/StringBuilder
    //   1500: dup
    //   1501: ldc_w 670
    //   1504: invokespecial 509	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1507: aload 6
    //   1509: invokevirtual 226	android/content/Intent:getData	()Landroid/net/Uri;
    //   1512: invokevirtual 245	android/net/Uri:toString	()Ljava/lang/String;
    //   1515: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1518: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1521: invokespecial 632	com/linkedin/android/deeplink/exceptions/DeeplinkException:<init>	(Ljava/lang/String;)V
    //   1524: athrow
    //   1525: aload 6
    //   1527: invokevirtual 226	android/content/Intent:getData	()Landroid/net/Uri;
    //   1530: astore 4
    //   1532: aload 4
    //   1534: ifnull +30 -> 1564
    //   1537: new 506	java/lang/StringBuilder
    //   1540: dup
    //   1541: ldc_w 672
    //   1544: invokespecial 509	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1547: aload 4
    //   1549: invokestatic 678	com/linkedin/android/deeplink/routes/LinkingRoutes:getMatchingRoute	(Landroid/net/Uri;)Lcom/linkedin/android/deeplink/routes/LinkingRoutes;
    //   1552: invokevirtual 681	com/linkedin/android/deeplink/routes/LinkingRoutes:name	()Ljava/lang/String;
    //   1555: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1561: invokestatic 105	com/linkedin/android/infra/performance/CrashReporter:leaveBreadcrumb	(Ljava/lang/String;)V
    //   1564: aload_0
    //   1565: aload 6
    //   1567: invokestatic 687	com/linkedin/android/deeplink/helper/DeeplinkHelper:getIntentForUrl$53956ba3	(Landroid/content/Context;Landroid/content/Intent;)Ljava/util/List;
    //   1570: astore 5
    //   1572: goto -614 -> 958
    //   1575: aload 7
    //   1577: astore 4
    //   1579: ldc_w 275
    //   1582: aload 5
    //   1584: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1587: ifeq -608 -> 979
    //   1590: aload 6
    //   1592: invokevirtual 273	android/content/Intent:getType	()Ljava/lang/String;
    //   1595: astore 4
    //   1597: aload 4
    //   1599: ifnull +313 -> 1912
    //   1602: aload 4
    //   1604: ldc_w 285
    //   1607: invokevirtual 289	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1610: ifeq +79 -> 1689
    //   1613: aload 6
    //   1615: ldc_w 689
    //   1618: invokevirtual 155	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1621: invokestatic 695	com/linkedin/android/publishing/sharing/compose/ShareComposeBundle:createOriginalShareWithInitialText	(Ljava/lang/String;)Lcom/linkedin/android/publishing/sharing/compose/ShareComposeBundle;
    //   1624: invokestatic 701	com/linkedin/android/publishing/sharing/ShareBundle:createFeedShare	(Lcom/linkedin/android/publishing/sharing/compose/ShareComposeBundle;)Lcom/linkedin/android/publishing/sharing/ShareBundle;
    //   1627: astore 4
    //   1629: aload_0
    //   1630: getfield 60	com/linkedin/android/infra/app/BaseActivity:applicationComponent	Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   1633: invokeinterface 704 1 0
    //   1638: getfield 708	com/linkedin/android/infra/IntentRegistry:share	Lcom/linkedin/android/publishing/sharing/ShareIntent;
    //   1641: aload_0
    //   1642: aload 4
    //   1644: invokevirtual 711	com/linkedin/android/publishing/sharing/ShareIntent:newIntent	(Landroid/content/Context;Lcom/linkedin/android/infra/BundleBuilder;)Landroid/content/Intent;
    //   1647: astore 5
    //   1649: aload 5
    //   1651: ldc_w 712
    //   1654: invokevirtual 715	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   1657: pop
    //   1658: aload 7
    //   1660: astore 4
    //   1662: aload 5
    //   1664: aload 6
    //   1666: if_acmpeq -687 -> 979
    //   1669: new 169	java/util/ArrayList
    //   1672: dup
    //   1673: invokespecial 170	java/util/ArrayList:<init>	()V
    //   1676: astore 4
    //   1678: aload 4
    //   1680: aload 5
    //   1682: invokevirtual 598	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1685: pop
    //   1686: goto -707 -> 979
    //   1689: aload 4
    //   1691: ldc_w 291
    //   1694: invokevirtual 289	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1697: ifeq +215 -> 1912
    //   1700: aload 6
    //   1702: ldc_w 717
    //   1705: invokevirtual 240	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1708: checkcast 242	android/net/Uri
    //   1711: invokestatic 721	com/linkedin/android/publishing/sharing/compose/ShareComposeBundle:createOriginalShareWithImage	(Landroid/net/Uri;)Lcom/linkedin/android/publishing/sharing/compose/ShareComposeBundle;
    //   1714: invokestatic 701	com/linkedin/android/publishing/sharing/ShareBundle:createFeedShare	(Lcom/linkedin/android/publishing/sharing/compose/ShareComposeBundle;)Lcom/linkedin/android/publishing/sharing/ShareBundle;
    //   1717: astore 4
    //   1719: aload_0
    //   1720: getfield 60	com/linkedin/android/infra/app/BaseActivity:applicationComponent	Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   1723: invokeinterface 704 1 0
    //   1728: getfield 708	com/linkedin/android/infra/IntentRegistry:share	Lcom/linkedin/android/publishing/sharing/ShareIntent;
    //   1731: aload_0
    //   1732: aload 4
    //   1734: invokevirtual 711	com/linkedin/android/publishing/sharing/ShareIntent:newIntent	(Landroid/content/Context;Lcom/linkedin/android/infra/BundleBuilder;)Landroid/content/Intent;
    //   1737: astore 5
    //   1739: aload 5
    //   1741: ldc_w 712
    //   1744: invokevirtual 715	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   1747: pop
    //   1748: aload 5
    //   1750: aload 6
    //   1752: invokestatic 727	com/linkedin/android/infra/shared/IntentUtils:grantReadUriPermission	(Landroid/content/Intent;Landroid/content/Intent;)V
    //   1755: goto -97 -> 1658
    //   1758: aload 10
    //   1760: ldc_w 729
    //   1763: invokevirtual 155	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1766: astore 7
    //   1768: aload 7
    //   1770: astore 4
    //   1772: aload 7
    //   1774: ifnonnull -1521 -> 253
    //   1777: aload 10
    //   1779: ldc_w 731
    //   1782: invokevirtual 155	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1785: astore 7
    //   1787: aload 7
    //   1789: astore 4
    //   1791: aload 7
    //   1793: ifnonnull -1540 -> 253
    //   1796: ldc_w 733
    //   1799: astore 4
    //   1801: goto -1548 -> 253
    //   1804: aload_0
    //   1805: aload 9
    //   1807: invokevirtual 737	com/linkedin/android/l2m/deeplink/DeepLinkHelperActivity:startActivity	(Landroid/content/Intent;)V
    //   1810: goto -1318 -> 492
    //   1813: aload 4
    //   1815: ldc_w 739
    //   1818: invokevirtual 742	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1821: astore 4
    //   1823: goto -1197 -> 626
    //   1826: astore 4
    //   1828: new 634	java/lang/RuntimeException
    //   1831: dup
    //   1832: new 506	java/lang/StringBuilder
    //   1835: dup
    //   1836: ldc_w 744
    //   1839: invokespecial 509	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1842: aload 8
    //   1844: invokevirtual 747	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1847: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1850: invokespecial 748	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1853: invokestatic 100	com/linkedin/android/infra/performance/CrashReporter:reportNonFatal	(Ljava/lang/Throwable;)V
    //   1856: goto -1144 -> 712
    //   1859: astore 4
    //   1861: aload 5
    //   1863: invokeinterface 752 1 0
    //   1868: pop
    //   1869: new 634	java/lang/RuntimeException
    //   1872: dup
    //   1873: aload 4
    //   1875: invokespecial 754	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   1878: invokestatic 650	com/linkedin/android/infra/shared/Util:safeThrow$7a8b4789	(Ljava/lang/RuntimeException;)V
    //   1881: goto -1169 -> 712
    //   1884: iconst_1
    //   1885: istore_2
    //   1886: goto -1507 -> 379
    //   1889: aload 4
    //   1891: astore 5
    //   1893: goto -1702 -> 191
    //   1896: iconst_0
    //   1897: istore_1
    //   1898: goto -545 -> 1353
    //   1901: iconst_0
    //   1902: istore_1
    //   1903: goto -550 -> 1353
    //   1906: aconst_null
    //   1907: astore 4
    //   1909: goto -499 -> 1410
    //   1912: aload 6
    //   1914: astore 5
    //   1916: goto -258 -> 1658
    //   1919: iconst_0
    //   1920: istore_2
    //   1921: goto -1542 -> 379
    //   1924: iconst_0
    //   1925: istore_1
    //   1926: goto -1456 -> 470
    //   1929: iconst_0
    //   1930: istore_1
    //   1931: goto -1461 -> 470
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1934	0	this	DeepLinkHelperActivity
    //   469	1462	1	i	int
    //   474	1447	2	j	int
    //   324	309	3	bool	boolean
    //   82	604	4	localObject1	Object
    //   769	1	4	localBuilderException	com.linkedin.data.lite.BuilderException
    //   869	261	4	localObject2	Object
    //   1177	53	4	localDeeplinkException	com.linkedin.android.deeplink.exceptions.DeeplinkException
    //   1294	528	4	localObject3	Object
    //   1826	1	4	localURISyntaxException	java.net.URISyntaxException
    //   1859	31	4	localJSONException	org.json.JSONException
    //   1907	1	4	localObject4	Object
    //   73	1842	5	localObject5	Object
    //   4	1909	6	localIntent1	Intent
    //   403	1389	7	localObject6	Object
    //   204	1639	8	localObject7	Object
    //   221	1585	9	localObject8	Object
    //   227	1551	10	localIntent2	Intent
    // Exception table:
    //   from	to	target	type
    //   93	158	769	com/linkedin/data/lite/BuilderException
    //   158	191	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   191	241	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   246	253	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   253	286	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   291	319	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   319	376	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   379	415	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   420	447	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   452	468	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   482	492	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   501	549	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   549	618	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   626	632	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   636	642	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   642	712	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   811	910	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   910	958	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   967	975	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   979	1033	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1036	1126	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1129	1177	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1229	1277	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1277	1284	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1289	1335	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1340	1351	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1357	1410	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1415	1474	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1477	1525	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1525	1532	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1537	1564	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1564	1572	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1579	1597	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1602	1658	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1669	1686	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1689	1755	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1758	1768	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1777	1787	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1804	1810	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1813	1823	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1828	1856	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   1861	1881	1177	com/linkedin/android/deeplink/exceptions/DeeplinkException
    //   636	642	1826	java/net/URISyntaxException
    //   642	712	1859	org/json/JSONException
  }
  
  private void deeplinkToIntentsWithBackstack(Intent paramIntent, ArrayList<Intent> paramArrayList, Uri paramUri)
  {
    if ((paramIntent.getFlags() & 0x10000000) != 0)
    {
      int i = 1;
      while (i < paramArrayList.size())
      {
        paramIntent = (Intent)paramArrayList.get(i);
        paramIntent.setFlags(paramIntent.getFlags() & 0xEFFFFFFF);
        paramIntent.setFlags(paramIntent.getFlags() & 0xFFFF7FFF);
        paramIntent.setFlags(paramIntent.getFlags() & 0xFBFFFFFF);
        i += 1;
      }
      ((Intent)paramArrayList.get(0)).addFlags(268435456);
      ((Intent)paramArrayList.get(0)).addFlags(32768);
    }
    try
    {
      ContextCompat.startActivities$5b3ef247(this, (Intent[])paramArrayList.toArray(new Intent[paramArrayList.size()]));
      return;
    }
    catch (NullPointerException paramIntent)
    {
      CrashReporter.reportNonFatal(new Throwable("Error starting deeplink activities: " + LinkingRoutes.getMatchingRoute(paramUri).name()));
    }
  }
  
  private static boolean isInboundIntentViaThirdPartySdk(Intent paramIntent)
  {
    boolean bool2 = false;
    Object localObject = paramIntent.getData();
    boolean bool1 = bool2;
    if (localObject != null)
    {
      paramIntent = ((Uri)localObject).getScheme();
      localObject = ((Uri)localObject).getQueryParameter("src");
      bool1 = bool2;
      if ("linkedin".equals(paramIntent))
      {
        bool1 = bool2;
        if ("sdk".equals(localObject)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    deeplinkOnResume = "enabled".equals(applicationComponent.lixManager().getTreatment(Lix.AXLE_DEEPLINK_ON_RESUME));
    if (!deeplinkOnResume)
    {
      CrashReporter.reportNonFatal(new Throwable("onCreate called in DeepLinkHelperActivity"));
      deeplink();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    CrashReporter.reportNonFatal(new Throwable("onNewIntent called in DeepLinkHelperActivity"));
    setIntent(paramIntent);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (deeplinkOnResume)
    {
      CrashReporter.reportNonFatal(new Throwable("onResume called in DeepLinkHelperActivity"));
      deeplink();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.deeplink.DeepLinkHelperActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */