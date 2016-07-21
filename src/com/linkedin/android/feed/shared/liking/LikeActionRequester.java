package com.linkedin.android.feed.shared.liking;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.entities.utils.FollowingInfoUtils;
import com.linkedin.android.feed.events.FeedLikeUpdateSucceededEvent;
import com.linkedin.android.feed.shared.ToggleActionRequestQueue;
import com.linkedin.android.feed.utils.FeedUpdateUtils;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.DeleteModelListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.OptimisticWrite;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Routes.QueryBuilder;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata.Builder;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;
import com.linkedin.android.pegasus.gen.voyager.feed.Like.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Likes;
import com.linkedin.android.pegasus.gen.voyager.feed.Likes.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.MemberActor.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialActor;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialActor.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SponsoredMetadata;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.VoidRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LikeActionRequester
  extends ToggleActionRequestQueue
{
  private static final String TAG = LikeActionRequester.class.getSimpleName();
  private final ConsistencyManager consistencyManager;
  private final FlagshipDataManager dataManager;
  private Like deletedLike;
  private final Bus eventBus;
  private final int likeSource;
  private final LixManager lixManager;
  private final SocialActor me;
  private Like myLike;
  private final String myMemberId;
  private SocialDetail socialDetail;
  private SponsoredMetadata sponsoredMetadata;
  SocialDetail waitingSocialDetail;
  private OptimisticWrite write;
  
  public LikeActionRequester(FlagshipApplication paramFlagshipApplication, FlagshipDataManager paramFlagshipDataManager, ConsistencyManager paramConsistencyManager, LixManager paramLixManager, Bus paramBus, MiniProfile paramMiniProfile, SocialDetail paramSocialDetail, int paramInt, SponsoredMetadata paramSponsoredMetadata)
  {
    super(paramFlagshipApplication);
    dataManager = paramFlagshipDataManager;
    consistencyManager = paramConsistencyManager;
    lixManager = paramLixManager;
    eventBus = paramBus;
    myMemberId = entityUrn.getId();
    me = makeMeSocialActor(paramMiniProfile);
    socialDetail = setupWithSocialDetail(paramSocialDetail);
    likeSource = paramInt;
    sponsoredMetadata = paramSponsoredMetadata;
  }
  
  private void displaySnackbarError(int paramInt)
  {
    Snackbar localSnackbar = app.getAppComponent().snackbarUtil().make(paramInt, 0);
    if (localSnackbar != null) {
      localSnackbar.show();
    }
  }
  
  private Like findMyLike()
  {
    Iterator localIterator = socialDetail.likes.elements.iterator();
    while (localIterator.hasNext())
    {
      Like localLike = (Like)localIterator.next();
      if ((localLike != null) && (myMemberId.equals(FeedUpdateUtils.getSocialActorId(actor)))) {}
      for (int i = 1; i != 0; i = 0)
      {
        myLike = localLike;
        return myLike;
      }
    }
    return null;
  }
  
  /* Error */
  private Like likeSocialDetail(Urn paramUrn)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 82	com/linkedin/android/feed/shared/liking/LikeActionRequester:socialDetail	Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail;
    //   4: getfield 179	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail:totalSocialActivityCounts	Lcom/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts;
    //   7: getfield 185	com/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts:liked	Z
    //   10: ifeq +67 -> 77
    //   13: aload_0
    //   14: getfield 171	com/linkedin/android/feed/shared/liking/LikeActionRequester:myLike	Lcom/linkedin/android/pegasus/gen/voyager/feed/Like;
    //   17: ifnull +33 -> 50
    //   20: aload_0
    //   21: getfield 171	com/linkedin/android/feed/shared/liking/LikeActionRequester:myLike	Lcom/linkedin/android/pegasus/gen/voyager/feed/Like;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +51 -> 77
    //   29: new 187	com/linkedin/android/pegasus/gen/voyager/feed/Like$Builder
    //   32: dup
    //   33: aload_2
    //   34: invokespecial 190	com/linkedin/android/pegasus/gen/voyager/feed/Like$Builder:<init>	(Lcom/linkedin/android/pegasus/gen/voyager/feed/Like;)V
    //   37: aload_1
    //   38: invokevirtual 194	com/linkedin/android/pegasus/gen/voyager/feed/Like$Builder:setUrn	(Lcom/linkedin/android/pegasus/gen/common/Urn;)Lcom/linkedin/android/pegasus/gen/voyager/feed/Like$Builder;
    //   41: getstatic 200	com/linkedin/data/lite/RecordTemplate$Flavor:RECORD	Lcom/linkedin/data/lite/RecordTemplate$Flavor;
    //   44: invokevirtual 204	com/linkedin/android/pegasus/gen/voyager/feed/Like$Builder:build	(Lcom/linkedin/data/lite/RecordTemplate$Flavor;)Lcom/linkedin/android/pegasus/gen/voyager/feed/Like;
    //   47: astore_1
    //   48: aload_1
    //   49: areturn
    //   50: aload_0
    //   51: invokespecial 206	com/linkedin/android/feed/shared/liking/LikeActionRequester:findMyLike	()Lcom/linkedin/android/pegasus/gen/voyager/feed/Like;
    //   54: astore_2
    //   55: goto -30 -> 25
    //   58: astore_1
    //   59: aload_0
    //   60: ldc -48
    //   62: new 210	java/lang/RuntimeException
    //   65: dup
    //   66: ldc -48
    //   68: aload_1
    //   69: invokespecial 213	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: invokevirtual 217	com/linkedin/android/feed/shared/liking/LikeActionRequester:die	(Ljava/lang/String;Ljava/lang/RuntimeException;)V
    //   75: aload_2
    //   76: areturn
    //   77: new 187	com/linkedin/android/pegasus/gen/voyager/feed/Like$Builder
    //   80: dup
    //   81: invokespecial 219	com/linkedin/android/pegasus/gen/voyager/feed/Like$Builder:<init>	()V
    //   84: aload_1
    //   85: invokevirtual 194	com/linkedin/android/pegasus/gen/voyager/feed/Like$Builder:setUrn	(Lcom/linkedin/android/pegasus/gen/common/Urn;)Lcom/linkedin/android/pegasus/gen/voyager/feed/Like$Builder;
    //   88: ldc -35
    //   90: iconst_1
    //   91: anewarray 223	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_1
    //   97: invokevirtual 68	com/linkedin/android/pegasus/gen/common/Urn:getId	()Ljava/lang/String;
    //   100: aastore
    //   101: invokestatic 227	com/linkedin/android/pegasus/gen/common/Urn:createFromTuple	(Ljava/lang/String;[Ljava/lang/Object;)Lcom/linkedin/android/pegasus/gen/common/Urn;
    //   104: invokevirtual 230	com/linkedin/android/pegasus/gen/voyager/feed/Like$Builder:setEntityUrn	(Lcom/linkedin/android/pegasus/gen/common/Urn;)Lcom/linkedin/android/pegasus/gen/voyager/feed/Like$Builder;
    //   107: aload_0
    //   108: getfield 76	com/linkedin/android/feed/shared/liking/LikeActionRequester:me	Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialActor;
    //   111: invokevirtual 234	com/linkedin/android/pegasus/gen/voyager/feed/Like$Builder:setActor	(Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialActor;)Lcom/linkedin/android/pegasus/gen/voyager/feed/Like$Builder;
    //   114: astore_1
    //   115: aload_0
    //   116: getfield 82	com/linkedin/android/feed/shared/liking/LikeActionRequester:socialDetail	Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail;
    //   119: getfield 237	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail:threadId	Ljava/lang/String;
    //   122: astore_2
    //   123: aload_2
    //   124: ifnonnull +223 -> 347
    //   127: aload_1
    //   128: iconst_0
    //   129: putfield 240	com/linkedin/android/pegasus/gen/voyager/feed/Like$Builder:hasThreadId	Z
    //   132: aload_1
    //   133: aconst_null
    //   134: putfield 241	com/linkedin/android/pegasus/gen/voyager/feed/Like$Builder:threadId	Ljava/lang/String;
    //   137: aload_0
    //   138: aload_1
    //   139: getstatic 200	com/linkedin/data/lite/RecordTemplate$Flavor:RECORD	Lcom/linkedin/data/lite/RecordTemplate$Flavor;
    //   142: invokevirtual 204	com/linkedin/android/pegasus/gen/voyager/feed/Like$Builder:build	(Lcom/linkedin/data/lite/RecordTemplate$Flavor;)Lcom/linkedin/android/pegasus/gen/voyager/feed/Like;
    //   145: putfield 171	com/linkedin/android/feed/shared/liking/LikeActionRequester:myLike	Lcom/linkedin/android/pegasus/gen/voyager/feed/Like;
    //   148: new 243	java/util/ArrayList
    //   151: dup
    //   152: aload_0
    //   153: getfield 82	com/linkedin/android/feed/shared/liking/LikeActionRequester:socialDetail	Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail;
    //   156: getfield 130	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail:likes	Lcom/linkedin/android/pegasus/gen/voyager/feed/Likes;
    //   159: getfield 136	com/linkedin/android/pegasus/gen/voyager/feed/Likes:elements	Ljava/util/List;
    //   162: invokespecial 246	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   165: astore_1
    //   166: aload_1
    //   167: iconst_0
    //   168: aload_0
    //   169: getfield 171	com/linkedin/android/feed/shared/liking/LikeActionRequester:myLike	Lcom/linkedin/android/pegasus/gen/voyager/feed/Like;
    //   172: invokeinterface 250 3 0
    //   177: aload_0
    //   178: new 252	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail$Builder
    //   181: dup
    //   182: aload_0
    //   183: getfield 82	com/linkedin/android/feed/shared/liking/LikeActionRequester:socialDetail	Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail;
    //   186: invokespecial 255	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail$Builder:<init>	(Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail;)V
    //   189: iconst_1
    //   190: invokestatic 261	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   193: invokevirtual 265	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail$Builder:setLiked	(Ljava/lang/Boolean;)Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail$Builder;
    //   196: new 267	com/linkedin/android/pegasus/gen/voyager/feed/Likes$Builder
    //   199: dup
    //   200: aload_0
    //   201: getfield 82	com/linkedin/android/feed/shared/liking/LikeActionRequester:socialDetail	Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail;
    //   204: getfield 130	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail:likes	Lcom/linkedin/android/pegasus/gen/voyager/feed/Likes;
    //   207: invokespecial 270	com/linkedin/android/pegasus/gen/voyager/feed/Likes$Builder:<init>	(Lcom/linkedin/android/pegasus/gen/voyager/feed/Likes;)V
    //   210: aload_1
    //   211: invokevirtual 274	com/linkedin/android/pegasus/gen/voyager/feed/Likes$Builder:setElements	(Ljava/util/List;)Lcom/linkedin/android/pegasus/gen/voyager/feed/Likes$Builder;
    //   214: new 276	com/linkedin/android/pegasus/gen/restli/common/CollectionMetadata$Builder
    //   217: dup
    //   218: aload_0
    //   219: getfield 82	com/linkedin/android/feed/shared/liking/LikeActionRequester:socialDetail	Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail;
    //   222: getfield 130	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail:likes	Lcom/linkedin/android/pegasus/gen/voyager/feed/Likes;
    //   225: getfield 280	com/linkedin/android/pegasus/gen/voyager/feed/Likes:paging	Lcom/linkedin/android/pegasus/gen/restli/common/CollectionMetadata;
    //   228: invokespecial 283	com/linkedin/android/pegasus/gen/restli/common/CollectionMetadata$Builder:<init>	(Lcom/linkedin/android/pegasus/gen/restli/common/CollectionMetadata;)V
    //   231: aload_0
    //   232: getfield 82	com/linkedin/android/feed/shared/liking/LikeActionRequester:socialDetail	Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail;
    //   235: getfield 130	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail:likes	Lcom/linkedin/android/pegasus/gen/voyager/feed/Likes;
    //   238: getfield 280	com/linkedin/android/pegasus/gen/voyager/feed/Likes:paging	Lcom/linkedin/android/pegasus/gen/restli/common/CollectionMetadata;
    //   241: getfield 288	com/linkedin/android/pegasus/gen/restli/common/CollectionMetadata:count	I
    //   244: iconst_1
    //   245: iadd
    //   246: invokestatic 293	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   249: invokevirtual 297	com/linkedin/android/pegasus/gen/restli/common/CollectionMetadata$Builder:setCount	(Ljava/lang/Integer;)Lcom/linkedin/android/pegasus/gen/restli/common/CollectionMetadata$Builder;
    //   252: aload_0
    //   253: getfield 82	com/linkedin/android/feed/shared/liking/LikeActionRequester:socialDetail	Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail;
    //   256: getfield 130	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail:likes	Lcom/linkedin/android/pegasus/gen/voyager/feed/Likes;
    //   259: getfield 280	com/linkedin/android/pegasus/gen/voyager/feed/Likes:paging	Lcom/linkedin/android/pegasus/gen/restli/common/CollectionMetadata;
    //   262: getfield 300	com/linkedin/android/pegasus/gen/restli/common/CollectionMetadata:total	I
    //   265: iconst_1
    //   266: iadd
    //   267: invokestatic 293	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: invokevirtual 303	com/linkedin/android/pegasus/gen/restli/common/CollectionMetadata$Builder:setTotal	(Ljava/lang/Integer;)Lcom/linkedin/android/pegasus/gen/restli/common/CollectionMetadata$Builder;
    //   273: invokevirtual 306	com/linkedin/android/pegasus/gen/restli/common/CollectionMetadata$Builder:build	()Lcom/linkedin/android/pegasus/gen/restli/common/CollectionMetadata;
    //   276: invokevirtual 310	com/linkedin/android/pegasus/gen/voyager/feed/Likes$Builder:setPaging	(Lcom/linkedin/android/pegasus/gen/restli/common/CollectionMetadata;)Lcom/linkedin/android/pegasus/gen/voyager/feed/Likes$Builder;
    //   279: invokevirtual 313	com/linkedin/android/pegasus/gen/voyager/feed/Likes$Builder:build	()Lcom/linkedin/android/pegasus/gen/voyager/feed/Likes;
    //   282: invokevirtual 317	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail$Builder:setLikes	(Lcom/linkedin/android/pegasus/gen/voyager/feed/Likes;)Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail$Builder;
    //   285: new 319	com/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts$Builder
    //   288: dup
    //   289: aload_0
    //   290: getfield 82	com/linkedin/android/feed/shared/liking/LikeActionRequester:socialDetail	Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail;
    //   293: getfield 179	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail:totalSocialActivityCounts	Lcom/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts;
    //   296: invokespecial 322	com/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts$Builder:<init>	(Lcom/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts;)V
    //   299: aload_0
    //   300: getfield 82	com/linkedin/android/feed/shared/liking/LikeActionRequester:socialDetail	Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail;
    //   303: getfield 179	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail:totalSocialActivityCounts	Lcom/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts;
    //   306: getfield 326	com/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts:numLikes	J
    //   309: lconst_1
    //   310: ladd
    //   311: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   314: invokevirtual 335	com/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts$Builder:setNumLikes	(Ljava/lang/Long;)Lcom/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts$Builder;
    //   317: iconst_1
    //   318: invokestatic 261	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   321: invokevirtual 338	com/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts$Builder:setLiked	(Ljava/lang/Boolean;)Lcom/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts$Builder;
    //   324: getstatic 200	com/linkedin/data/lite/RecordTemplate$Flavor:RECORD	Lcom/linkedin/data/lite/RecordTemplate$Flavor;
    //   327: invokevirtual 341	com/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts$Builder:build	(Lcom/linkedin/data/lite/RecordTemplate$Flavor;)Lcom/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts;
    //   330: invokevirtual 345	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail$Builder:setTotalSocialActivityCounts	(Lcom/linkedin/android/pegasus/gen/voyager/feed/shared/SocialActivityCounts;)Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail$Builder;
    //   333: getstatic 200	com/linkedin/data/lite/RecordTemplate$Flavor:RECORD	Lcom/linkedin/data/lite/RecordTemplate$Flavor;
    //   336: invokevirtual 348	com/linkedin/android/pegasus/gen/voyager/feed/SocialDetail$Builder:build	(Lcom/linkedin/data/lite/RecordTemplate$Flavor;)Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail;
    //   339: putfield 82	com/linkedin/android/feed/shared/liking/LikeActionRequester:socialDetail	Lcom/linkedin/android/pegasus/gen/voyager/feed/SocialDetail;
    //   342: aload_0
    //   343: getfield 171	com/linkedin/android/feed/shared/liking/LikeActionRequester:myLike	Lcom/linkedin/android/pegasus/gen/voyager/feed/Like;
    //   346: areturn
    //   347: aload_1
    //   348: iconst_1
    //   349: putfield 240	com/linkedin/android/pegasus/gen/voyager/feed/Like$Builder:hasThreadId	Z
    //   352: aload_1
    //   353: aload_2
    //   354: putfield 241	com/linkedin/android/pegasus/gen/voyager/feed/Like$Builder:threadId	Ljava/lang/String;
    //   357: goto -220 -> 137
    //   360: astore_1
    //   361: aconst_null
    //   362: areturn
    //   363: astore_1
    //   364: aload_0
    //   365: ldc_w 350
    //   368: new 210	java/lang/RuntimeException
    //   371: dup
    //   372: ldc_w 350
    //   375: aload_1
    //   376: invokespecial 213	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   379: invokevirtual 217	com/linkedin/android/feed/shared/liking/LikeActionRequester:die	(Ljava/lang/String;Ljava/lang/RuntimeException;)V
    //   382: goto -40 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	this	LikeActionRequester
    //   0	385	1	paramUrn	Urn
    //   24	330	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	48	58	com/linkedin/data/lite/BuilderException
    //   77	123	360	com/linkedin/data/lite/BuilderException
    //   127	137	360	com/linkedin/data/lite/BuilderException
    //   137	148	360	com/linkedin/data/lite/BuilderException
    //   347	357	360	com/linkedin/data/lite/BuilderException
    //   177	342	363	com/linkedin/data/lite/BuilderException
  }
  
  private static SocialActor makeMeSocialActor(MiniProfile paramMiniProfile)
  {
    try
    {
      Object localObject = FollowingInfoUtils.createFollowingMemberInfoUrn(new Object[] { entityUrn.getId() });
      localObject = new FollowingInfo.Builder().setEntityUrn((Urn)localObject).setFollowing(Boolean.valueOf(false)).setFollowerCount(Integer.valueOf(0)).build(RecordTemplate.Flavor.RECORD);
      Urn localUrn = Urn.createFromTuple("member", new Object[] { entityUrn.getId() });
      paramMiniProfile = new MemberActor.Builder().setUrn(localUrn).setMiniProfile(paramMiniProfile).setFollowingInfo((FollowingInfo)localObject).setShowFollowAction(Boolean.valueOf(false)).build(RecordTemplate.Flavor.RECORD);
      paramMiniProfile = new SocialActor.Builder().setMemberActorValue(paramMiniProfile).build();
      return paramMiniProfile;
    }
    catch (BuilderException paramMiniProfile)
    {
      Util.safeThrow$7a8b4789(new RuntimeException(paramMiniProfile));
    }
    return null;
  }
  
  private Like unlikeSocialDetail()
  {
    int i = 0;
    localLike = findMyLike();
    myLike = null;
    ArrayList localArrayList = new ArrayList(socialDetail.likes.elements);
    boolean bool = localArrayList.remove(localLike);
    try
    {
      Object localObject = new SocialActivityCounts.Builder(socialDetail.totalSocialActivityCounts);
      long l = socialDetail.totalSocialActivityCounts.numLikes;
      if (bool) {
        i = 1;
      }
      SocialActivityCounts localSocialActivityCounts = ((SocialActivityCounts.Builder)localObject).setNumLikes(Long.valueOf(l - i)).setLiked(Boolean.valueOf(false)).build(RecordTemplate.Flavor.RECORD);
      if (bool) {}
      for (localObject = new CollectionMetadata.Builder(socialDetail.likes.paging).setCount(Integer.valueOf(socialDetail.likes.paging.count - 1)).setTotal(Integer.valueOf(socialDetail.likes.paging.total - 1)).build();; localObject = socialDetail.likes.paging)
      {
        localObject = new Likes.Builder(socialDetail.likes).setElements(localArrayList).setPaging((CollectionMetadata)localObject).build();
        socialDetail = new SocialDetail.Builder(socialDetail).setLiked(Boolean.valueOf(false)).setLikes((Likes)localObject).setTotalSocialActivityCounts(localSocialActivityCounts).build(RecordTemplate.Flavor.RECORD);
        return localLike;
      }
      return localLike;
    }
    catch (BuilderException localBuilderException)
    {
      die("this social detail is so broken", new RuntimeException("this social detail is so broken", localBuilderException));
    }
  }
  
  public final void onErrorState(int paramInt)
  {
    if ((paramInt == 404) || (paramInt == 500))
    {
      overrideState(false);
      if (!networkState) {
        break label80;
      }
      toggleUiOn();
      switch (likeSource)
      {
      }
    }
    for (paramInt = 2131231309;; paramInt = 2131231153)
    {
      displaySnackbarError(paramInt);
      return;
      overrideState(networkState);
      break;
    }
    label80:
    toggleUiOff();
    switch (likeSource)
    {
    }
    for (paramInt = 2131231254;; paramInt = 2131231136)
    {
      displaySnackbarError(paramInt);
      return;
    }
  }
  
  public final void onStableState()
  {
    if (waitingSocialDetail != null)
    {
      setupWithSocialDetail(waitingSocialDetail);
      waitingSocialDetail = null;
      if (socialDetail.totalSocialActivityCounts.liked) {
        Bus.publish(new FeedLikeUpdateSucceededEvent());
      }
    }
  }
  
  final SocialDetail setupWithSocialDetail(SocialDetail paramSocialDetail)
  {
    socialDetail = paramSocialDetail;
    if (TextUtils.isEmpty(threadId))
    {
      die("This social detail is not likeable since it has no thread ID!", new RuntimeException("This social detail is not likeable since it has no thread ID!"));
      return paramSocialDetail;
    }
    myLike = findMyLike();
    overrideState(totalSocialActivityCounts.liked);
    return paramSocialDetail;
  }
  
  public final String tag()
  {
    return TAG;
  }
  
  public final void toggleNetworkOff(final Map<String, String> paramMap)
  {
    if (deletedLike == null) {
      Util.safeThrow$7a8b4789(new RuntimeException("toggleNetworkOff was called but there was no deleted like!"));
    }
    DeleteModelListener local2 = new DeleteModelListener(deletedLike, dataManager)
    {
      public final void onResponse(DataStoreResponse<VoidRecord> paramAnonymousDataStoreResponse)
      {
        super.onResponse(paramAnonymousDataStoreResponse);
        int i;
        LikeActionRequester localLikeActionRequester;
        if (type == DataStore.Type.NETWORK)
        {
          int j = statusCode;
          i = j;
          if (error != null)
          {
            i = j;
            if (error.errorResponse != null) {
              i = error.errorResponse.code();
            }
          }
          localLikeActionRequester = LikeActionRequester.this;
          if (error != null) {
            break label83;
          }
        }
        label83:
        for (boolean bool = true;; bool = false)
        {
          localLikeActionRequester.requestFinished(bool, i, paramMap);
          return;
        }
      }
    };
    FlagshipDataManager localFlagshipDataManager = dataManager;
    paramMap = Request.delete().customHeaders(paramMap);
    String str = socialDetail.threadId;
    localFlagshipDataManager.submit(paramMap.url(Routes.FEED_LIKES.buildRouteForId(str).toString()).listener(local2));
  }
  
  public final void toggleNetworkOn(final Map<String, String> paramMap)
  {
    if (write == null) {
      Util.safeThrow$7a8b4789(new RuntimeException("toggleNetworkOn was called but there is no optimistic write!"));
    }
    if (myLike == null) {
      Util.safeThrow$7a8b4789(new RuntimeException("toggleNetworkOn was called but there is myLike!"));
    }
    RecordTemplateListener local1 = new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<Like> paramAnonymousDataStoreResponse)
      {
        int j = statusCode;
        int i = j;
        if (error != null)
        {
          i = j;
          if (error.errorResponse != null) {
            i = error.errorResponse.code();
          }
        }
        LikeActionRequester localLikeActionRequester = LikeActionRequester.this;
        if (error == null) {}
        for (boolean bool = true;; bool = false)
        {
          localLikeActionRequester.requestFinished(bool, i, paramMap);
          return;
        }
      }
    };
    OptimisticWrite localOptimisticWrite = write;
    Object localObject2 = lixManager;
    Object localObject1 = sponsoredMetadata;
    paramMap = Routes.FEED_LIKES.buildUponRoot().buildUpon();
    localObject2 = ((LixManager)localObject2).getTreatment(Lix.FEED_SU_CSP_LIKE);
    if ((localObject1 != null) && ("su-csp-1".equals(localObject2))) {
      localObject1 = Routes.toRestiUriQueryParam((RecordTemplate)localObject1);
    }
    for (paramMap = paramMap.build().toString() + "?sponsoredMetadata=" + (String)localObject1;; paramMap = paramMap.build().toString())
    {
      localOptimisticWrite.postWriteModel(paramMap, myLike, new Like.Builder(myLike), local1);
      return;
      if ((localObject1 != null) && ("su-csp-2".equals(localObject2)))
      {
        localObject2 = new Routes.QueryBuilder();
        isURLEncoded = true;
        localObject2 = ((Routes.QueryBuilder)localObject2).addQueryParam("tscpUrl", tscpUrl);
        if (displayFormat != null) {
          ((Routes.QueryBuilder)localObject2).addQueryParam("displayFormat", displayFormat);
        }
        paramMap.encodedQuery(((Routes.QueryBuilder)localObject2).build());
      }
    }
  }
  
  public final void toggleUiOff()
  {
    write = null;
    deletedLike = unlikeSocialDetail();
    consistencyManager.updateModel(socialDetail);
    if (deletedLike == null) {}
    ConsistencyManager localConsistencyManager;
    Like localLike;
    do
    {
      return;
      localConsistencyManager = consistencyManager;
      localLike = deletedLike;
    } while (localLike == null);
    localConsistencyManager.deleteModel(localLike.id());
  }
  
  public final void toggleUiOn()
  {
    deletedLike = null;
    write = dataManager.createOptimisticWrite();
    likeSocialDetail(OptimisticWrite.generateTemporaryUrn("like"));
    write.cacheReadModel$4b980c14(socialDetail);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.liking.LikeActionRequester
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */