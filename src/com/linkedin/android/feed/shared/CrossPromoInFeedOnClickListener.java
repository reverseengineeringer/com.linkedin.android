package com.linkedin.android.feed.shared;

import android.support.v7.app.AlertDialog.Builder;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public final class CrossPromoInFeedOnClickListener
  extends FeedUpdateOnClickListener
{
  String appId;
  String appStoreUrl;
  
  public CrossPromoInFeedOnClickListener(Update paramUpdate, FragmentComponent paramFragmentComponent, String paramString1, String paramString2, String paramString3, TrackingEventBuilder... paramVarArgs)
  {
    super(paramUpdate, paramFragmentComponent, 0, false, null, null, paramString3, paramVarArgs);
    appId = paramString2;
    appStoreUrl = paramString1;
  }
  
  private static void showAppUrlAlert(FragmentComponent paramFragmentComponent)
  {
    new AlertDialog.Builder(paramFragmentComponent.activity()).setMessage(2131231204).setNeutralButton$2cf0b439().show();
  }
  
  /* Error */
  public final void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 51	com/linkedin/android/feed/shared/FeedUpdateOnClickListener:onClick	(Landroid/view/View;)V
    //   5: aload_0
    //   6: getfield 55	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:fragmentComponent	Lcom/linkedin/android/infra/components/FragmentComponent;
    //   9: invokeinterface 59 1 0
    //   14: invokestatic 65	com/linkedin/android/deeplink/helper/CrosslinkHelper:create	(Landroid/content/Context;)Lcom/linkedin/android/deeplink/helper/CrosslinkHelper;
    //   17: pop
    //   18: aload_0
    //   19: getfield 55	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:fragmentComponent	Lcom/linkedin/android/infra/components/FragmentComponent;
    //   22: invokeinterface 59 1 0
    //   27: aload_0
    //   28: getfield 14	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:appId	Ljava/lang/String;
    //   31: invokestatic 71	com/linkedin/CrossPromoLib/utils/Utils:isAppInstalled	(Landroid/content/Context;Ljava/lang/String;)Z
    //   34: ifeq +171 -> 205
    //   37: aload_0
    //   38: getfield 55	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:fragmentComponent	Lcom/linkedin/android/infra/components/FragmentComponent;
    //   41: invokeinterface 59 1 0
    //   46: ifnull +159 -> 205
    //   49: aload_0
    //   50: getfield 55	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:fragmentComponent	Lcom/linkedin/android/infra/components/FragmentComponent;
    //   53: invokeinterface 59 1 0
    //   58: invokevirtual 77	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   61: ifnull +144 -> 205
    //   64: aload_0
    //   65: getfield 55	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:fragmentComponent	Lcom/linkedin/android/infra/components/FragmentComponent;
    //   68: invokeinterface 59 1 0
    //   73: astore_2
    //   74: aload_0
    //   75: getfield 14	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:appId	Ljava/lang/String;
    //   78: astore_3
    //   79: aload_2
    //   80: invokevirtual 77	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   83: aload_3
    //   84: invokevirtual 83	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   87: astore_1
    //   88: aload_1
    //   89: ifnull +85 -> 174
    //   92: aload_0
    //   93: getfield 55	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:fragmentComponent	Lcom/linkedin/android/infra/components/FragmentComponent;
    //   96: invokeinterface 86 1 0
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull +168 -> 271
    //   106: aload_0
    //   107: getfield 55	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:fragmentComponent	Lcom/linkedin/android/infra/components/FragmentComponent;
    //   110: invokeinterface 86 1 0
    //   115: aload_1
    //   116: invokevirtual 90	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   119: aload_0
    //   120: getfield 94	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:update	Lcom/linkedin/android/pegasus/gen/voyager/feed/Update;
    //   123: getfield 100	com/linkedin/android/pegasus/gen/voyager/feed/Update:value	Lcom/linkedin/android/pegasus/gen/voyager/feed/Update$Value;
    //   126: getfield 106	com/linkedin/android/pegasus/gen/voyager/feed/Update$Value:crossPromoUpdateValue	Lcom/linkedin/android/pegasus/gen/voyager/feed/CrossPromoUpdate;
    //   129: ifnull +44 -> 173
    //   132: aload_0
    //   133: getfield 55	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:fragmentComponent	Lcom/linkedin/android/infra/components/FragmentComponent;
    //   136: invokeinterface 110 1 0
    //   141: aload_0
    //   142: getfield 94	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:update	Lcom/linkedin/android/pegasus/gen/voyager/feed/Update;
    //   145: getfield 100	com/linkedin/android/pegasus/gen/voyager/feed/Update:value	Lcom/linkedin/android/pegasus/gen/voyager/feed/Update$Value;
    //   148: getfield 106	com/linkedin/android/pegasus/gen/voyager/feed/Update$Value:crossPromoUpdateValue	Lcom/linkedin/android/pegasus/gen/voyager/feed/CrossPromoUpdate;
    //   151: getfield 115	com/linkedin/android/pegasus/gen/voyager/feed/CrossPromoUpdate:legoTrackingId	Ljava/lang/String;
    //   154: aload_0
    //   155: getfield 94	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:update	Lcom/linkedin/android/pegasus/gen/voyager/feed/Update;
    //   158: getfield 100	com/linkedin/android/pegasus/gen/voyager/feed/Update:value	Lcom/linkedin/android/pegasus/gen/voyager/feed/Update$Value;
    //   161: getfield 106	com/linkedin/android/pegasus/gen/voyager/feed/Update$Value:crossPromoUpdateValue	Lcom/linkedin/android/pegasus/gen/voyager/feed/CrossPromoUpdate;
    //   164: getfield 118	com/linkedin/android/pegasus/gen/voyager/feed/CrossPromoUpdate:legoTrackingToken	Ljava/lang/String;
    //   167: getstatic 124	com/linkedin/android/pegasus/gen/voyager/common/lego/ActionCategory:PRIMARY_ACTION	Lcom/linkedin/android/pegasus/gen/voyager/common/lego/ActionCategory;
    //   170: invokestatic 130	com/linkedin/android/axle/tracking/LegoTrackingUtils:sendLegoWidgetActionEvent	(Lcom/linkedin/android/infra/data/FlagshipDataManager;Ljava/lang/String;Ljava/lang/String;Lcom/linkedin/android/pegasus/gen/voyager/common/lego/ActionCategory;)V
    //   173: return
    //   174: aload_2
    //   175: invokestatic 65	com/linkedin/android/deeplink/helper/CrosslinkHelper:create	(Landroid/content/Context;)Lcom/linkedin/android/deeplink/helper/CrosslinkHelper;
    //   178: pop
    //   179: new 132	java/lang/StringBuilder
    //   182: dup
    //   183: ldc -122
    //   185: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: aload_3
    //   189: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 151	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   198: invokestatic 155	com/linkedin/android/deeplink/helper/CrosslinkHelper:buildCrosslinkIntent$4b1ae7cf	(Landroid/net/Uri;)Landroid/content/Intent;
    //   201: astore_1
    //   202: goto -110 -> 92
    //   205: new 132	java/lang/StringBuilder
    //   208: dup
    //   209: ldc -122
    //   211: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: aload_0
    //   215: getfield 14	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:appId	Ljava/lang/String;
    //   218: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 151	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   227: invokestatic 155	com/linkedin/android/deeplink/helper/CrosslinkHelper:buildCrosslinkIntent$4b1ae7cf	(Landroid/net/Uri;)Landroid/content/Intent;
    //   230: astore_1
    //   231: goto -139 -> 92
    //   234: astore_1
    //   235: aload_0
    //   236: getfield 55	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:fragmentComponent	Lcom/linkedin/android/infra/components/FragmentComponent;
    //   239: invokeinterface 86 1 0
    //   244: aload_0
    //   245: getfield 16	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:appStoreUrl	Ljava/lang/String;
    //   248: invokestatic 151	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   251: invokestatic 155	com/linkedin/android/deeplink/helper/CrosslinkHelper:buildCrosslinkIntent$4b1ae7cf	(Landroid/net/Uri;)Landroid/content/Intent;
    //   254: invokevirtual 90	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   257: goto -138 -> 119
    //   260: astore_1
    //   261: aload_0
    //   262: getfield 55	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:fragmentComponent	Lcom/linkedin/android/infra/components/FragmentComponent;
    //   265: invokestatic 157	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:showAppUrlAlert	(Lcom/linkedin/android/infra/components/FragmentComponent;)V
    //   268: goto -149 -> 119
    //   271: aload_0
    //   272: getfield 55	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:fragmentComponent	Lcom/linkedin/android/infra/components/FragmentComponent;
    //   275: invokestatic 157	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:showAppUrlAlert	(Lcom/linkedin/android/infra/components/FragmentComponent;)V
    //   278: goto -159 -> 119
    //   281: astore_1
    //   282: aload_0
    //   283: getfield 55	com/linkedin/android/feed/shared/CrossPromoInFeedOnClickListener:fragmentComponent	Lcom/linkedin/android/infra/components/FragmentComponent;
    //   286: invokeinterface 86 1 0
    //   291: pop
    //   292: new 159	java/lang/IllegalArgumentException
    //   295: dup
    //   296: ldc -95
    //   298: invokespecial 162	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   301: invokestatic 168	com/linkedin/android/infra/shared/Util:safeThrow$7a8b4789	(Ljava/lang/RuntimeException;)V
    //   304: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	CrossPromoInFeedOnClickListener
    //   0	305	1	paramView	android.view.View
    //   73	102	2	localContext	android.content.Context
    //   78	111	3	str	String
    // Exception table:
    //   from	to	target	type
    //   106	119	234	android/content/ActivityNotFoundException
    //   92	102	260	android/content/ActivityNotFoundException
    //   235	257	260	android/content/ActivityNotFoundException
    //   271	278	260	android/content/ActivityNotFoundException
    //   132	173	281	com/linkedin/data/lite/BuilderException
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.CrossPromoInFeedOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */