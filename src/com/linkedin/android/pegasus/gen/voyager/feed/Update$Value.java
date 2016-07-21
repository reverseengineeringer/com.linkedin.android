package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionMemberCountException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Update$Value
  implements FissileDataModel<Value>, UnionTemplate<Value>
{
  public static final UpdateBuilder.ValueBuilder BUILDER = UpdateBuilder.ValueBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AggregatedConnectionUpdate aggregatedConnectionUpdateValue;
  public final AggregatedFollowRecommendationUpdate aggregatedFollowRecommendationUpdateValue;
  public final AggregatedJymbiiUpdate aggregatedJymbiiUpdateValue;
  public final AggregatedPymkUpdate aggregatedPymkUpdateValue;
  public final AggregatedShareContentUpdate aggregatedShareContentUpdateValue;
  public final ArticleUpdate articleUpdateValue;
  public final ChannelUpdate channelUpdateValue;
  public final ConnectionUpdate connectionUpdateValue;
  public final CrossPromoUpdate crossPromoUpdateValue;
  public final DiscussionUpdate discussionUpdateValue;
  public final FollowRecommendationUpdate followRecommendationUpdateValue;
  public final GenericPromoUpdate genericPromoUpdateValue;
  public final boolean hasAggregatedConnectionUpdateValue;
  public final boolean hasAggregatedFollowRecommendationUpdateValue;
  public final boolean hasAggregatedJymbiiUpdateValue;
  public final boolean hasAggregatedPymkUpdateValue;
  public final boolean hasAggregatedShareContentUpdateValue;
  public final boolean hasArticleUpdateValue;
  public final boolean hasChannelUpdateValue;
  public final boolean hasConnectionUpdateValue;
  public final boolean hasCrossPromoUpdateValue;
  public final boolean hasDiscussionUpdateValue;
  public final boolean hasFollowRecommendationUpdateValue;
  public final boolean hasGenericPromoUpdateValue;
  public final boolean hasJymbiiUpdateValue;
  public final boolean hasLyndaUpdateValue;
  public final boolean hasMentionedInNewsUpdateValue;
  public final boolean hasPromptResponseUpdateValue;
  public final boolean hasPropUpdateValue;
  public final boolean hasPymkUpdateValue;
  public final boolean hasReshareValue;
  public final boolean hasShareUpdateValue;
  public final boolean hasViralUpdateValue;
  public final JymbiiUpdate jymbiiUpdateValue;
  public final LyndaUpdate lyndaUpdateValue;
  public final MentionedInNewsUpdate mentionedInNewsUpdateValue;
  public final PromptResponseUpdate promptResponseUpdateValue;
  public final PropUpdate propUpdateValue;
  public final PymkUpdate pymkUpdateValue;
  public final Reshare reshareValue;
  public final ShareUpdate shareUpdateValue;
  public final ViralUpdate viralUpdateValue;
  
  Update$Value(AggregatedFollowRecommendationUpdate paramAggregatedFollowRecommendationUpdate, AggregatedConnectionUpdate paramAggregatedConnectionUpdate, AggregatedJymbiiUpdate paramAggregatedJymbiiUpdate, AggregatedPymkUpdate paramAggregatedPymkUpdate, AggregatedShareContentUpdate paramAggregatedShareContentUpdate, ArticleUpdate paramArticleUpdate, ChannelUpdate paramChannelUpdate, ConnectionUpdate paramConnectionUpdate, CrossPromoUpdate paramCrossPromoUpdate, DiscussionUpdate paramDiscussionUpdate, FollowRecommendationUpdate paramFollowRecommendationUpdate, GenericPromoUpdate paramGenericPromoUpdate, JymbiiUpdate paramJymbiiUpdate, LyndaUpdate paramLyndaUpdate, MentionedInNewsUpdate paramMentionedInNewsUpdate, PromptResponseUpdate paramPromptResponseUpdate, PropUpdate paramPropUpdate, PymkUpdate paramPymkUpdate, Reshare paramReshare, ShareUpdate paramShareUpdate, ViralUpdate paramViralUpdate, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, boolean paramBoolean18, boolean paramBoolean19, boolean paramBoolean20, boolean paramBoolean21)
  {
    aggregatedFollowRecommendationUpdateValue = paramAggregatedFollowRecommendationUpdate;
    aggregatedConnectionUpdateValue = paramAggregatedConnectionUpdate;
    aggregatedJymbiiUpdateValue = paramAggregatedJymbiiUpdate;
    aggregatedPymkUpdateValue = paramAggregatedPymkUpdate;
    aggregatedShareContentUpdateValue = paramAggregatedShareContentUpdate;
    articleUpdateValue = paramArticleUpdate;
    channelUpdateValue = paramChannelUpdate;
    connectionUpdateValue = paramConnectionUpdate;
    crossPromoUpdateValue = paramCrossPromoUpdate;
    discussionUpdateValue = paramDiscussionUpdate;
    followRecommendationUpdateValue = paramFollowRecommendationUpdate;
    genericPromoUpdateValue = paramGenericPromoUpdate;
    jymbiiUpdateValue = paramJymbiiUpdate;
    lyndaUpdateValue = paramLyndaUpdate;
    mentionedInNewsUpdateValue = paramMentionedInNewsUpdate;
    promptResponseUpdateValue = paramPromptResponseUpdate;
    propUpdateValue = paramPropUpdate;
    pymkUpdateValue = paramPymkUpdate;
    reshareValue = paramReshare;
    shareUpdateValue = paramShareUpdate;
    viralUpdateValue = paramViralUpdate;
    hasAggregatedFollowRecommendationUpdateValue = paramBoolean1;
    hasAggregatedConnectionUpdateValue = paramBoolean2;
    hasAggregatedJymbiiUpdateValue = paramBoolean3;
    hasAggregatedPymkUpdateValue = paramBoolean4;
    hasAggregatedShareContentUpdateValue = paramBoolean5;
    hasArticleUpdateValue = paramBoolean6;
    hasChannelUpdateValue = paramBoolean7;
    hasConnectionUpdateValue = paramBoolean8;
    hasCrossPromoUpdateValue = paramBoolean9;
    hasDiscussionUpdateValue = paramBoolean10;
    hasFollowRecommendationUpdateValue = paramBoolean11;
    hasGenericPromoUpdateValue = paramBoolean12;
    hasJymbiiUpdateValue = paramBoolean13;
    hasLyndaUpdateValue = paramBoolean14;
    hasMentionedInNewsUpdateValue = paramBoolean15;
    hasPromptResponseUpdateValue = paramBoolean16;
    hasPropUpdateValue = paramBoolean17;
    hasPymkUpdateValue = paramBoolean18;
    hasReshareValue = paramBoolean19;
    hasShareUpdateValue = paramBoolean20;
    hasViralUpdateValue = paramBoolean21;
    _cachedId = null;
  }
  
  public final Value accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    label146:
    label158:
    Object localObject5;
    boolean bool4;
    label198:
    label210:
    Object localObject6;
    boolean bool5;
    label250:
    label262:
    Object localObject7;
    boolean bool6;
    label302:
    label314:
    Object localObject8;
    boolean bool7;
    label354:
    label366:
    Object localObject9;
    boolean bool8;
    label407:
    label419:
    Object localObject10;
    boolean bool9;
    label460:
    label472:
    Object localObject11;
    boolean bool10;
    label513:
    label525:
    Object localObject12;
    boolean bool11;
    label566:
    label578:
    Object localObject13;
    boolean bool12;
    label619:
    label631:
    Object localObject14;
    boolean bool13;
    label672:
    label684:
    Object localObject15;
    boolean bool14;
    label725:
    label737:
    Object localObject16;
    boolean bool15;
    label778:
    label790:
    Object localObject17;
    boolean bool16;
    label831:
    label843:
    Object localObject18;
    boolean bool17;
    label884:
    label896:
    Object localObject19;
    boolean bool18;
    label937:
    label949:
    Object localObject20;
    boolean bool19;
    label990:
    label1002:
    Object localObject21;
    boolean bool20;
    if (hasAggregatedFollowRecommendationUpdateValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.AggregatedFollowRecommendationUpdate");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = aggregatedFollowRecommendationUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1227;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasAggregatedConnectionUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.AggregatedConnectionUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1236;
        }
        localObject1 = aggregatedConnectionUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1254;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasAggregatedJymbiiUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.AggregatedJymbiiUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1263;
        }
        localObject1 = aggregatedJymbiiUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1281;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasAggregatedPymkUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.AggregatedPymkUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1291;
        }
        localObject1 = aggregatedPymkUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1309;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      localObject6 = null;
      bool5 = false;
      if (hasAggregatedShareContentUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.AggregatedShareContentUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1319;
        }
        localObject1 = aggregatedShareContentUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1337;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      localObject7 = null;
      bool6 = false;
      if (hasArticleUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ArticleUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1347;
        }
        localObject1 = articleUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1365;
        }
        bool6 = true;
        localObject7 = localObject1;
      }
      localObject8 = null;
      bool7 = false;
      if (hasChannelUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ChannelUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1375;
        }
        localObject1 = channelUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1393;
        }
        bool7 = true;
        localObject8 = localObject1;
      }
      localObject9 = null;
      bool8 = false;
      if (hasConnectionUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ConnectionUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1403;
        }
        localObject1 = connectionUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1421;
        }
        bool8 = true;
        localObject9 = localObject1;
      }
      localObject10 = null;
      bool9 = false;
      if (hasCrossPromoUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.CrossPromoUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1431;
        }
        localObject1 = crossPromoUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1449;
        }
        bool9 = true;
        localObject10 = localObject1;
      }
      localObject11 = null;
      bool10 = false;
      if (hasDiscussionUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.DiscussionUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1459;
        }
        localObject1 = discussionUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1477;
        }
        bool10 = true;
        localObject11 = localObject1;
      }
      localObject12 = null;
      bool11 = false;
      if (hasFollowRecommendationUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.FollowRecommendationUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1487;
        }
        localObject1 = followRecommendationUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1505;
        }
        bool11 = true;
        localObject12 = localObject1;
      }
      localObject13 = null;
      bool12 = false;
      if (hasGenericPromoUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.GenericPromoUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1515;
        }
        localObject1 = genericPromoUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1533;
        }
        bool12 = true;
        localObject13 = localObject1;
      }
      localObject14 = null;
      bool13 = false;
      if (hasJymbiiUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.shared.JymbiiUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1543;
        }
        localObject1 = jymbiiUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1561;
        }
        bool13 = true;
        localObject14 = localObject1;
      }
      localObject15 = null;
      bool14 = false;
      if (hasLyndaUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.LyndaUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1571;
        }
        localObject1 = lyndaUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1589;
        }
        bool14 = true;
        localObject15 = localObject1;
      }
      localObject16 = null;
      bool15 = false;
      if (hasMentionedInNewsUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.MentionedInNewsUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1599;
        }
        localObject1 = mentionedInNewsUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1617;
        }
        bool15 = true;
        localObject16 = localObject1;
      }
      localObject17 = null;
      bool16 = false;
      if (hasPromptResponseUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.PromptResponseUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1627;
        }
        localObject1 = promptResponseUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1645;
        }
        bool16 = true;
        localObject17 = localObject1;
      }
      localObject18 = null;
      bool17 = false;
      if (hasPropUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.PropUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1655;
        }
        localObject1 = propUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1673;
        }
        bool17 = true;
        localObject18 = localObject1;
      }
      localObject19 = null;
      bool18 = false;
      if (hasPymkUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.PymkUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1683;
        }
        localObject1 = pymkUpdateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1701;
        }
        bool18 = true;
        localObject19 = localObject1;
      }
      localObject20 = null;
      bool19 = false;
      if (hasReshareValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.Reshare");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1711;
        }
        localObject1 = reshareValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1729;
        }
        bool19 = true;
        localObject20 = localObject1;
      }
      localObject21 = null;
      bool20 = false;
      if (hasShareUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ShareUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1739;
        }
        localObject1 = shareUpdateValue.accept(paramDataProcessor);
        label1043:
        if (localObject1 == null) {
          break label1757;
        }
        bool20 = true;
        localObject21 = localObject1;
      }
      label1055:
      localObject1 = null;
      bool21 = false;
      if (hasViralUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ViralUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1767;
        }
        localObject1 = viralUpdateValue.accept(paramDataProcessor);
        label1096:
        if (localObject1 == null) {
          break label1785;
        }
      }
    }
    label1227:
    label1236:
    label1254:
    label1263:
    label1281:
    label1291:
    label1309:
    label1319:
    label1337:
    label1347:
    label1365:
    label1375:
    label1393:
    label1403:
    label1421:
    label1431:
    label1449:
    label1459:
    label1477:
    label1487:
    label1505:
    label1515:
    label1533:
    label1543:
    label1561:
    label1571:
    label1589:
    label1599:
    label1617:
    label1627:
    label1645:
    label1655:
    label1673:
    label1683:
    label1701:
    label1711:
    label1729:
    label1739:
    label1757:
    label1767:
    label1785:
    for (boolean bool21 = true;; bool21 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1791;
      }
      return new Value((AggregatedFollowRecommendationUpdate)localObject2, (AggregatedConnectionUpdate)localObject3, (AggregatedJymbiiUpdate)localObject4, (AggregatedPymkUpdate)localObject5, (AggregatedShareContentUpdate)localObject6, (ArticleUpdate)localObject7, (ChannelUpdate)localObject8, (ConnectionUpdate)localObject9, (CrossPromoUpdate)localObject10, (DiscussionUpdate)localObject11, (FollowRecommendationUpdate)localObject12, (GenericPromoUpdate)localObject13, (JymbiiUpdate)localObject14, (LyndaUpdate)localObject15, (MentionedInNewsUpdate)localObject16, (PromptResponseUpdate)localObject17, (PropUpdate)localObject18, (PymkUpdate)localObject19, (Reshare)localObject20, (ShareUpdate)localObject21, (ViralUpdate)localObject1, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool15, bool16, bool17, bool18, bool19, bool20, bool21);
      localObject1 = (AggregatedFollowRecommendationUpdate)paramDataProcessor.processDataTemplate(aggregatedFollowRecommendationUpdateValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (AggregatedConnectionUpdate)paramDataProcessor.processDataTemplate(aggregatedConnectionUpdateValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (AggregatedJymbiiUpdate)paramDataProcessor.processDataTemplate(aggregatedJymbiiUpdateValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (AggregatedPymkUpdate)paramDataProcessor.processDataTemplate(aggregatedPymkUpdateValue);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (AggregatedShareContentUpdate)paramDataProcessor.processDataTemplate(aggregatedShareContentUpdateValue);
      break label250;
      bool5 = false;
      localObject6 = localObject1;
      break label262;
      localObject1 = (ArticleUpdate)paramDataProcessor.processDataTemplate(articleUpdateValue);
      break label302;
      bool6 = false;
      localObject7 = localObject1;
      break label314;
      localObject1 = (ChannelUpdate)paramDataProcessor.processDataTemplate(channelUpdateValue);
      break label354;
      bool7 = false;
      localObject8 = localObject1;
      break label366;
      localObject1 = (ConnectionUpdate)paramDataProcessor.processDataTemplate(connectionUpdateValue);
      break label407;
      bool8 = false;
      localObject9 = localObject1;
      break label419;
      localObject1 = (CrossPromoUpdate)paramDataProcessor.processDataTemplate(crossPromoUpdateValue);
      break label460;
      bool9 = false;
      localObject10 = localObject1;
      break label472;
      localObject1 = (DiscussionUpdate)paramDataProcessor.processDataTemplate(discussionUpdateValue);
      break label513;
      bool10 = false;
      localObject11 = localObject1;
      break label525;
      localObject1 = (FollowRecommendationUpdate)paramDataProcessor.processDataTemplate(followRecommendationUpdateValue);
      break label566;
      bool11 = false;
      localObject12 = localObject1;
      break label578;
      localObject1 = (GenericPromoUpdate)paramDataProcessor.processDataTemplate(genericPromoUpdateValue);
      break label619;
      bool12 = false;
      localObject13 = localObject1;
      break label631;
      localObject1 = (JymbiiUpdate)paramDataProcessor.processDataTemplate(jymbiiUpdateValue);
      break label672;
      bool13 = false;
      localObject14 = localObject1;
      break label684;
      localObject1 = (LyndaUpdate)paramDataProcessor.processDataTemplate(lyndaUpdateValue);
      break label725;
      bool14 = false;
      localObject15 = localObject1;
      break label737;
      localObject1 = (MentionedInNewsUpdate)paramDataProcessor.processDataTemplate(mentionedInNewsUpdateValue);
      break label778;
      bool15 = false;
      localObject16 = localObject1;
      break label790;
      localObject1 = (PromptResponseUpdate)paramDataProcessor.processDataTemplate(promptResponseUpdateValue);
      break label831;
      bool16 = false;
      localObject17 = localObject1;
      break label843;
      localObject1 = (PropUpdate)paramDataProcessor.processDataTemplate(propUpdateValue);
      break label884;
      bool17 = false;
      localObject18 = localObject1;
      break label896;
      localObject1 = (PymkUpdate)paramDataProcessor.processDataTemplate(pymkUpdateValue);
      break label937;
      bool18 = false;
      localObject19 = localObject1;
      break label949;
      localObject1 = (Reshare)paramDataProcessor.processDataTemplate(reshareValue);
      break label990;
      bool19 = false;
      localObject20 = localObject1;
      break label1002;
      localObject1 = (ShareUpdate)paramDataProcessor.processDataTemplate(shareUpdateValue);
      break label1043;
      bool20 = false;
      localObject21 = localObject1;
      break label1055;
      localObject1 = (ViralUpdate)paramDataProcessor.processDataTemplate(viralUpdateValue);
      break label1096;
    }
    label1791:
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Value)paramObject;
      if (aggregatedFollowRecommendationUpdateValue != null)
      {
        if (aggregatedFollowRecommendationUpdateValue.equals(aggregatedFollowRecommendationUpdateValue)) {}
      }
      else {
        while (aggregatedFollowRecommendationUpdateValue != null) {
          return false;
        }
      }
      if (aggregatedConnectionUpdateValue != null)
      {
        if (aggregatedConnectionUpdateValue.equals(aggregatedConnectionUpdateValue)) {}
      }
      else {
        while (aggregatedConnectionUpdateValue != null) {
          return false;
        }
      }
      if (aggregatedJymbiiUpdateValue != null)
      {
        if (aggregatedJymbiiUpdateValue.equals(aggregatedJymbiiUpdateValue)) {}
      }
      else {
        while (aggregatedJymbiiUpdateValue != null) {
          return false;
        }
      }
      if (aggregatedPymkUpdateValue != null)
      {
        if (aggregatedPymkUpdateValue.equals(aggregatedPymkUpdateValue)) {}
      }
      else {
        while (aggregatedPymkUpdateValue != null) {
          return false;
        }
      }
      if (aggregatedShareContentUpdateValue != null)
      {
        if (aggregatedShareContentUpdateValue.equals(aggregatedShareContentUpdateValue)) {}
      }
      else {
        while (aggregatedShareContentUpdateValue != null) {
          return false;
        }
      }
      if (articleUpdateValue != null)
      {
        if (articleUpdateValue.equals(articleUpdateValue)) {}
      }
      else {
        while (articleUpdateValue != null) {
          return false;
        }
      }
      if (channelUpdateValue != null)
      {
        if (channelUpdateValue.equals(channelUpdateValue)) {}
      }
      else {
        while (channelUpdateValue != null) {
          return false;
        }
      }
      if (connectionUpdateValue != null)
      {
        if (connectionUpdateValue.equals(connectionUpdateValue)) {}
      }
      else {
        while (connectionUpdateValue != null) {
          return false;
        }
      }
      if (crossPromoUpdateValue != null)
      {
        if (crossPromoUpdateValue.equals(crossPromoUpdateValue)) {}
      }
      else {
        while (crossPromoUpdateValue != null) {
          return false;
        }
      }
      if (discussionUpdateValue != null)
      {
        if (discussionUpdateValue.equals(discussionUpdateValue)) {}
      }
      else {
        while (discussionUpdateValue != null) {
          return false;
        }
      }
      if (followRecommendationUpdateValue != null)
      {
        if (followRecommendationUpdateValue.equals(followRecommendationUpdateValue)) {}
      }
      else {
        while (followRecommendationUpdateValue != null) {
          return false;
        }
      }
      if (genericPromoUpdateValue != null)
      {
        if (genericPromoUpdateValue.equals(genericPromoUpdateValue)) {}
      }
      else {
        while (genericPromoUpdateValue != null) {
          return false;
        }
      }
      if (jymbiiUpdateValue != null)
      {
        if (jymbiiUpdateValue.equals(jymbiiUpdateValue)) {}
      }
      else {
        while (jymbiiUpdateValue != null) {
          return false;
        }
      }
      if (lyndaUpdateValue != null)
      {
        if (lyndaUpdateValue.equals(lyndaUpdateValue)) {}
      }
      else {
        while (lyndaUpdateValue != null) {
          return false;
        }
      }
      if (mentionedInNewsUpdateValue != null)
      {
        if (mentionedInNewsUpdateValue.equals(mentionedInNewsUpdateValue)) {}
      }
      else {
        while (mentionedInNewsUpdateValue != null) {
          return false;
        }
      }
      if (promptResponseUpdateValue != null)
      {
        if (promptResponseUpdateValue.equals(promptResponseUpdateValue)) {}
      }
      else {
        while (promptResponseUpdateValue != null) {
          return false;
        }
      }
      if (propUpdateValue != null)
      {
        if (propUpdateValue.equals(propUpdateValue)) {}
      }
      else {
        while (propUpdateValue != null) {
          return false;
        }
      }
      if (pymkUpdateValue != null)
      {
        if (pymkUpdateValue.equals(pymkUpdateValue)) {}
      }
      else {
        while (pymkUpdateValue != null) {
          return false;
        }
      }
      if (reshareValue != null)
      {
        if (reshareValue.equals(reshareValue)) {}
      }
      else {
        while (reshareValue != null) {
          return false;
        }
      }
      if (shareUpdateValue != null)
      {
        if (shareUpdateValue.equals(shareUpdateValue)) {}
      }
      else {
        while (shareUpdateValue != null) {
          return false;
        }
      }
      if (viralUpdateValue == null) {
        break;
      }
    } while (viralUpdateValue.equals(viralUpdateValue));
    for (;;)
    {
      return false;
      if (viralUpdateValue == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasAggregatedFollowRecommendationUpdateValue)
    {
      if (aggregatedFollowRecommendationUpdateValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(aggregatedFollowRecommendationUpdateValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasAggregatedConnectionUpdateValue)
      {
        i = j + 1;
        if (aggregatedConnectionUpdateValue._cachedId == null) {
          break label912;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(aggregatedConnectionUpdateValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasAggregatedJymbiiUpdateValue)
      {
        i = j + 1;
        if (aggregatedJymbiiUpdateValue._cachedId == null) {
          break label925;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(aggregatedJymbiiUpdateValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasAggregatedPymkUpdateValue)
      {
        i = j + 1;
        if (aggregatedPymkUpdateValue._cachedId == null) {
          break label938;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(aggregatedPymkUpdateValue._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasAggregatedShareContentUpdateValue)
      {
        i = j + 1;
        if (aggregatedShareContentUpdateValue._cachedId == null) {
          break label951;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(aggregatedShareContentUpdateValue._cachedId);
      }
      label219:
      j = i + 1;
      i = j;
      if (hasArticleUpdateValue)
      {
        i = j + 1;
        if (articleUpdateValue._cachedId == null) {
          break label964;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(articleUpdateValue._cachedId);
      }
      label261:
      j = i + 1;
      i = j;
      if (hasChannelUpdateValue)
      {
        i = j + 1;
        if (channelUpdateValue._cachedId == null) {
          break label977;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(channelUpdateValue._cachedId);
      }
      label303:
      j = i + 1;
      i = j;
      if (hasConnectionUpdateValue)
      {
        i = j + 1;
        if (connectionUpdateValue._cachedId == null) {
          break label990;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(connectionUpdateValue._cachedId);
      }
      label345:
      j = i + 1;
      i = j;
      if (hasCrossPromoUpdateValue)
      {
        i = j + 1;
        if (crossPromoUpdateValue._cachedId == null) {
          break label1003;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(crossPromoUpdateValue._cachedId);
      }
      label387:
      j = i + 1;
      i = j;
      if (hasDiscussionUpdateValue)
      {
        i = j + 1;
        if (discussionUpdateValue._cachedId == null) {
          break label1016;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(discussionUpdateValue._cachedId);
      }
      label429:
      j = i + 1;
      i = j;
      if (hasFollowRecommendationUpdateValue)
      {
        i = j + 1;
        if (followRecommendationUpdateValue._cachedId == null) {
          break label1029;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(followRecommendationUpdateValue._cachedId);
      }
      label471:
      j = i + 1;
      i = j;
      if (hasGenericPromoUpdateValue)
      {
        i = j + 1;
        if (genericPromoUpdateValue._cachedId == null) {
          break label1042;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(genericPromoUpdateValue._cachedId);
      }
      label513:
      j = i + 1;
      i = j;
      if (hasJymbiiUpdateValue)
      {
        i = j + 1;
        if (jymbiiUpdateValue._cachedId == null) {
          break label1055;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(jymbiiUpdateValue._cachedId);
      }
      label555:
      j = i + 1;
      i = j;
      if (hasLyndaUpdateValue)
      {
        i = j + 1;
        if (lyndaUpdateValue._cachedId == null) {
          break label1068;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(lyndaUpdateValue._cachedId);
      }
      label597:
      j = i + 1;
      i = j;
      if (hasMentionedInNewsUpdateValue)
      {
        i = j + 1;
        if (mentionedInNewsUpdateValue._cachedId == null) {
          break label1081;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(mentionedInNewsUpdateValue._cachedId);
      }
      label639:
      j = i + 1;
      i = j;
      if (hasPromptResponseUpdateValue)
      {
        i = j + 1;
        if (promptResponseUpdateValue._cachedId == null) {
          break label1094;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(promptResponseUpdateValue._cachedId);
      }
      label681:
      j = i + 1;
      i = j;
      if (hasPropUpdateValue)
      {
        i = j + 1;
        if (propUpdateValue._cachedId == null) {
          break label1107;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(propUpdateValue._cachedId);
      }
      label723:
      j = i + 1;
      i = j;
      if (hasPymkUpdateValue)
      {
        i = j + 1;
        if (pymkUpdateValue._cachedId == null) {
          break label1120;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(pymkUpdateValue._cachedId);
      }
      label765:
      j = i + 1;
      i = j;
      if (hasReshareValue)
      {
        i = j + 1;
        if (reshareValue._cachedId == null) {
          break label1133;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(reshareValue._cachedId);
      }
      label807:
      j = i + 1;
      i = j;
      if (hasShareUpdateValue)
      {
        i = j + 1;
        if (shareUpdateValue._cachedId == null) {
          break label1146;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareUpdateValue._cachedId);
      }
      label849:
      j = i + 1;
      i = j;
      if (hasViralUpdateValue)
      {
        i = j + 1;
        if (viralUpdateValue._cachedId == null) {
          break label1159;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(viralUpdateValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = aggregatedFollowRecommendationUpdateValue.getSerializedSize() + 7;
      break;
      label912:
      i += aggregatedConnectionUpdateValue.getSerializedSize();
      break label93;
      label925:
      i += aggregatedJymbiiUpdateValue.getSerializedSize();
      break label135;
      label938:
      i += aggregatedPymkUpdateValue.getSerializedSize();
      break label177;
      label951:
      i += aggregatedShareContentUpdateValue.getSerializedSize();
      break label219;
      label964:
      i += articleUpdateValue.getSerializedSize();
      break label261;
      label977:
      i += channelUpdateValue.getSerializedSize();
      break label303;
      label990:
      i += connectionUpdateValue.getSerializedSize();
      break label345;
      label1003:
      i += crossPromoUpdateValue.getSerializedSize();
      break label387;
      label1016:
      i += discussionUpdateValue.getSerializedSize();
      break label429;
      label1029:
      i += followRecommendationUpdateValue.getSerializedSize();
      break label471;
      label1042:
      i += genericPromoUpdateValue.getSerializedSize();
      break label513;
      label1055:
      i += jymbiiUpdateValue.getSerializedSize();
      break label555;
      label1068:
      i += lyndaUpdateValue.getSerializedSize();
      break label597;
      label1081:
      i += mentionedInNewsUpdateValue.getSerializedSize();
      break label639;
      label1094:
      i += promptResponseUpdateValue.getSerializedSize();
      break label681;
      label1107:
      i += propUpdateValue.getSerializedSize();
      break label723;
      label1120:
      i += pymkUpdateValue.getSerializedSize();
      break label765;
      label1133:
      i += reshareValue.getSerializedSize();
      break label807;
      label1146:
      i += shareUpdateValue.getSerializedSize();
      break label849;
      label1159:
      i += viralUpdateValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i16 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    label92:
    int i1;
    label108:
    int i2;
    label124:
    int i3;
    label140:
    int i4;
    label156:
    int i5;
    label172:
    int i6;
    label188:
    int i7;
    label204:
    int i8;
    label220:
    int i9;
    label236:
    int i10;
    label252:
    int i11;
    label268:
    int i12;
    label284:
    int i13;
    label300:
    int i14;
    if (aggregatedFollowRecommendationUpdateValue != null)
    {
      i = aggregatedFollowRecommendationUpdateValue.hashCode();
      if (aggregatedConnectionUpdateValue == null) {
        break label484;
      }
      j = aggregatedConnectionUpdateValue.hashCode();
      if (aggregatedJymbiiUpdateValue == null) {
        break label489;
      }
      k = aggregatedJymbiiUpdateValue.hashCode();
      if (aggregatedPymkUpdateValue == null) {
        break label494;
      }
      m = aggregatedPymkUpdateValue.hashCode();
      if (aggregatedShareContentUpdateValue == null) {
        break label500;
      }
      n = aggregatedShareContentUpdateValue.hashCode();
      if (articleUpdateValue == null) {
        break label506;
      }
      i1 = articleUpdateValue.hashCode();
      if (channelUpdateValue == null) {
        break label512;
      }
      i2 = channelUpdateValue.hashCode();
      if (connectionUpdateValue == null) {
        break label518;
      }
      i3 = connectionUpdateValue.hashCode();
      if (crossPromoUpdateValue == null) {
        break label524;
      }
      i4 = crossPromoUpdateValue.hashCode();
      if (discussionUpdateValue == null) {
        break label530;
      }
      i5 = discussionUpdateValue.hashCode();
      if (followRecommendationUpdateValue == null) {
        break label536;
      }
      i6 = followRecommendationUpdateValue.hashCode();
      if (genericPromoUpdateValue == null) {
        break label542;
      }
      i7 = genericPromoUpdateValue.hashCode();
      if (jymbiiUpdateValue == null) {
        break label548;
      }
      i8 = jymbiiUpdateValue.hashCode();
      if (lyndaUpdateValue == null) {
        break label554;
      }
      i9 = lyndaUpdateValue.hashCode();
      if (mentionedInNewsUpdateValue == null) {
        break label560;
      }
      i10 = mentionedInNewsUpdateValue.hashCode();
      if (promptResponseUpdateValue == null) {
        break label566;
      }
      i11 = promptResponseUpdateValue.hashCode();
      if (propUpdateValue == null) {
        break label572;
      }
      i12 = propUpdateValue.hashCode();
      if (pymkUpdateValue == null) {
        break label578;
      }
      i13 = pymkUpdateValue.hashCode();
      if (reshareValue == null) {
        break label584;
      }
      i14 = reshareValue.hashCode();
      label316:
      if (shareUpdateValue == null) {
        break label590;
      }
    }
    label484:
    label489:
    label494:
    label500:
    label506:
    label512:
    label518:
    label524:
    label530:
    label536:
    label542:
    label548:
    label554:
    label560:
    label566:
    label572:
    label578:
    label584:
    label590:
    for (int i15 = shareUpdateValue.hashCode();; i15 = 0)
    {
      if (viralUpdateValue != null) {
        i16 = viralUpdateValue.hashCode();
      }
      i = (i15 + (i14 + (i13 + (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i16;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label92;
      i1 = 0;
      break label108;
      i2 = 0;
      break label124;
      i3 = 0;
      break label140;
      i4 = 0;
      break label156;
      i5 = 0;
      break label172;
      i6 = 0;
      break label188;
      i7 = 0;
      break label204;
      i8 = 0;
      break label220;
      i9 = 0;
      break label236;
      i10 = 0;
      break label252;
      i11 = 0;
      break label268;
      i12 = 0;
      break label284;
      i13 = 0;
      break label300;
      i14 = 0;
      break label316;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Value");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label232:
    label292:
    label352:
    label412:
    label472:
    label532:
    label592:
    label652:
    label712:
    label772:
    label832:
    label892:
    label952:
    label1012:
    label1072:
    label1132:
    label1192:
    label1252:
    label1312:
    label1440:
    label1465:
    label1475:
    label1500:
    label1510:
    label1535:
    label1545:
    label1570:
    label1580:
    label1605:
    label1615:
    label1640:
    label1650:
    label1675:
    label1685:
    label1710:
    label1720:
    label1745:
    label1755:
    label1780:
    label1790:
    label1815:
    label1825:
    label1850:
    label1860:
    label1885:
    label1895:
    label1920:
    label1930:
    label1955:
    label1965:
    label1990:
    label2000:
    label2025:
    label2035:
    label2060:
    label2070:
    label2095:
    label2105:
    label2130:
    label2138:
    label2140:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-1527693339);
        if (hasAggregatedFollowRecommendationUpdateValue)
        {
          localByteBuffer.put((byte)1);
          if (aggregatedFollowRecommendationUpdateValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, aggregatedFollowRecommendationUpdateValue._cachedId);
            aggregatedFollowRecommendationUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAggregatedConnectionUpdateValue) {
              break label1465;
            }
            localByteBuffer.put((byte)1);
            if (aggregatedConnectionUpdateValue._cachedId == null) {
              break label1440;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, aggregatedConnectionUpdateValue._cachedId);
            aggregatedConnectionUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAggregatedJymbiiUpdateValue) {
              break label1500;
            }
            localByteBuffer.put((byte)1);
            if (aggregatedJymbiiUpdateValue._cachedId == null) {
              break label1475;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, aggregatedJymbiiUpdateValue._cachedId);
            aggregatedJymbiiUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAggregatedPymkUpdateValue) {
              break label1535;
            }
            localByteBuffer.put((byte)1);
            if (aggregatedPymkUpdateValue._cachedId == null) {
              break label1510;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, aggregatedPymkUpdateValue._cachedId);
            aggregatedPymkUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAggregatedShareContentUpdateValue) {
              break label1570;
            }
            localByteBuffer.put((byte)1);
            if (aggregatedShareContentUpdateValue._cachedId == null) {
              break label1545;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, aggregatedShareContentUpdateValue._cachedId);
            aggregatedShareContentUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasArticleUpdateValue) {
              break label1605;
            }
            localByteBuffer.put((byte)1);
            if (articleUpdateValue._cachedId == null) {
              break label1580;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, articleUpdateValue._cachedId);
            articleUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasChannelUpdateValue) {
              break label1640;
            }
            localByteBuffer.put((byte)1);
            if (channelUpdateValue._cachedId == null) {
              break label1615;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, channelUpdateValue._cachedId);
            channelUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasConnectionUpdateValue) {
              break label1675;
            }
            localByteBuffer.put((byte)1);
            if (connectionUpdateValue._cachedId == null) {
              break label1650;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, connectionUpdateValue._cachedId);
            connectionUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCrossPromoUpdateValue) {
              break label1710;
            }
            localByteBuffer.put((byte)1);
            if (crossPromoUpdateValue._cachedId == null) {
              break label1685;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, crossPromoUpdateValue._cachedId);
            crossPromoUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasDiscussionUpdateValue) {
              break label1745;
            }
            localByteBuffer.put((byte)1);
            if (discussionUpdateValue._cachedId == null) {
              break label1720;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, discussionUpdateValue._cachedId);
            discussionUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasFollowRecommendationUpdateValue) {
              break label1780;
            }
            localByteBuffer.put((byte)1);
            if (followRecommendationUpdateValue._cachedId == null) {
              break label1755;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, followRecommendationUpdateValue._cachedId);
            followRecommendationUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasGenericPromoUpdateValue) {
              break label1815;
            }
            localByteBuffer.put((byte)1);
            if (genericPromoUpdateValue._cachedId == null) {
              break label1790;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, genericPromoUpdateValue._cachedId);
            genericPromoUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasJymbiiUpdateValue) {
              break label1850;
            }
            localByteBuffer.put((byte)1);
            if (jymbiiUpdateValue._cachedId == null) {
              break label1825;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, jymbiiUpdateValue._cachedId);
            jymbiiUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasLyndaUpdateValue) {
              break label1885;
            }
            localByteBuffer.put((byte)1);
            if (lyndaUpdateValue._cachedId == null) {
              break label1860;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, lyndaUpdateValue._cachedId);
            lyndaUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMentionedInNewsUpdateValue) {
              break label1920;
            }
            localByteBuffer.put((byte)1);
            if (mentionedInNewsUpdateValue._cachedId == null) {
              break label1895;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, mentionedInNewsUpdateValue._cachedId);
            mentionedInNewsUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPromptResponseUpdateValue) {
              break label1955;
            }
            localByteBuffer.put((byte)1);
            if (promptResponseUpdateValue._cachedId == null) {
              break label1930;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, promptResponseUpdateValue._cachedId);
            promptResponseUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPropUpdateValue) {
              break label1990;
            }
            localByteBuffer.put((byte)1);
            if (propUpdateValue._cachedId == null) {
              break label1965;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, propUpdateValue._cachedId);
            propUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPymkUpdateValue) {
              break label2025;
            }
            localByteBuffer.put((byte)1);
            if (pymkUpdateValue._cachedId == null) {
              break label2000;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, pymkUpdateValue._cachedId);
            pymkUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasReshareValue) {
              break label2060;
            }
            localByteBuffer.put((byte)1);
            if (reshareValue._cachedId == null) {
              break label2035;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, reshareValue._cachedId);
            reshareValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasShareUpdateValue) {
              break label2095;
            }
            localByteBuffer.put((byte)1);
            if (shareUpdateValue._cachedId == null) {
              break label2070;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, shareUpdateValue._cachedId);
            shareUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasViralUpdateValue) {
              break label2130;
            }
            localByteBuffer.put((byte)1);
            if (viralUpdateValue._cachedId == null) {
              break label2105;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, viralUpdateValue._cachedId);
            viralUpdateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label2138;
          }
          if (str != null) {
            break label2140;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          aggregatedFollowRecommendationUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          aggregatedConnectionUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label232;
          localByteBuffer.put((byte)0);
          break label232;
          localByteBuffer.put((byte)1);
          aggregatedJymbiiUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label292;
          localByteBuffer.put((byte)0);
          break label292;
          localByteBuffer.put((byte)1);
          aggregatedPymkUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label352;
          localByteBuffer.put((byte)0);
          break label352;
          localByteBuffer.put((byte)1);
          aggregatedShareContentUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label412;
          localByteBuffer.put((byte)0);
          break label412;
          localByteBuffer.put((byte)1);
          articleUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label472;
          localByteBuffer.put((byte)0);
          break label472;
          localByteBuffer.put((byte)1);
          channelUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label532;
          localByteBuffer.put((byte)0);
          break label532;
          localByteBuffer.put((byte)1);
          connectionUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label592;
          localByteBuffer.put((byte)0);
          break label592;
          localByteBuffer.put((byte)1);
          crossPromoUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label652;
          localByteBuffer.put((byte)0);
          break label652;
          localByteBuffer.put((byte)1);
          discussionUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label712;
          localByteBuffer.put((byte)0);
          break label712;
          localByteBuffer.put((byte)1);
          followRecommendationUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label772;
          localByteBuffer.put((byte)0);
          break label772;
          localByteBuffer.put((byte)1);
          genericPromoUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label832;
          localByteBuffer.put((byte)0);
          break label832;
          localByteBuffer.put((byte)1);
          jymbiiUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label892;
          localByteBuffer.put((byte)0);
          break label892;
          localByteBuffer.put((byte)1);
          lyndaUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label952;
          localByteBuffer.put((byte)0);
          break label952;
          localByteBuffer.put((byte)1);
          mentionedInNewsUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1012;
          localByteBuffer.put((byte)0);
          break label1012;
          localByteBuffer.put((byte)1);
          promptResponseUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1072;
          localByteBuffer.put((byte)0);
          break label1072;
          localByteBuffer.put((byte)1);
          propUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1132;
          localByteBuffer.put((byte)0);
          break label1132;
          localByteBuffer.put((byte)1);
          pymkUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1192;
          localByteBuffer.put((byte)0);
          break label1192;
          localByteBuffer.put((byte)1);
          reshareValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1252;
          localByteBuffer.put((byte)0);
          break label1252;
          localByteBuffer.put((byte)1);
          shareUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1312;
          localByteBuffer.put((byte)0);
          break label1312;
          localByteBuffer.put((byte)1);
          viralUpdateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
  
  public static final class Builder
  {
    private AggregatedConnectionUpdate aggregatedConnectionUpdateValue = null;
    private AggregatedFollowRecommendationUpdate aggregatedFollowRecommendationUpdateValue = null;
    private AggregatedJymbiiUpdate aggregatedJymbiiUpdateValue = null;
    private AggregatedPymkUpdate aggregatedPymkUpdateValue = null;
    private AggregatedShareContentUpdate aggregatedShareContentUpdateValue = null;
    private ArticleUpdate articleUpdateValue = null;
    private ChannelUpdate channelUpdateValue = null;
    private ConnectionUpdate connectionUpdateValue = null;
    private CrossPromoUpdate crossPromoUpdateValue = null;
    private DiscussionUpdate discussionUpdateValue = null;
    private FollowRecommendationUpdate followRecommendationUpdateValue = null;
    private GenericPromoUpdate genericPromoUpdateValue = null;
    private boolean hasAggregatedConnectionUpdateValue = false;
    private boolean hasAggregatedFollowRecommendationUpdateValue = false;
    private boolean hasAggregatedJymbiiUpdateValue = false;
    private boolean hasAggregatedPymkUpdateValue = false;
    private boolean hasAggregatedShareContentUpdateValue = false;
    private boolean hasArticleUpdateValue = false;
    private boolean hasChannelUpdateValue = false;
    private boolean hasConnectionUpdateValue = false;
    private boolean hasCrossPromoUpdateValue = false;
    private boolean hasDiscussionUpdateValue = false;
    private boolean hasFollowRecommendationUpdateValue = false;
    private boolean hasGenericPromoUpdateValue = false;
    private boolean hasJymbiiUpdateValue = false;
    private boolean hasLyndaUpdateValue = false;
    private boolean hasMentionedInNewsUpdateValue = false;
    private boolean hasPromptResponseUpdateValue = false;
    private boolean hasPropUpdateValue = false;
    private boolean hasPymkUpdateValue = false;
    private boolean hasReshareValue = false;
    private boolean hasShareUpdateValue = false;
    private boolean hasViralUpdateValue = false;
    private JymbiiUpdate jymbiiUpdateValue = null;
    private LyndaUpdate lyndaUpdateValue = null;
    private MentionedInNewsUpdate mentionedInNewsUpdateValue = null;
    private PromptResponseUpdate promptResponseUpdateValue = null;
    private PropUpdate propUpdateValue = null;
    private PymkUpdate pymkUpdateValue = null;
    private Reshare reshareValue = null;
    private ShareUpdate shareUpdateValue = null;
    private ViralUpdate viralUpdateValue = null;
    
    public final Update.Value build()
      throws BuilderException
    {
      int j = 0;
      if (hasAggregatedFollowRecommendationUpdateValue) {
        j = 0 + 1;
      }
      int i = j;
      if (hasAggregatedConnectionUpdateValue) {
        i = j + 1;
      }
      j = i;
      if (hasAggregatedJymbiiUpdateValue) {
        j = i + 1;
      }
      i = j;
      if (hasAggregatedPymkUpdateValue) {
        i = j + 1;
      }
      j = i;
      if (hasAggregatedShareContentUpdateValue) {
        j = i + 1;
      }
      i = j;
      if (hasArticleUpdateValue) {
        i = j + 1;
      }
      j = i;
      if (hasChannelUpdateValue) {
        j = i + 1;
      }
      i = j;
      if (hasConnectionUpdateValue) {
        i = j + 1;
      }
      j = i;
      if (hasCrossPromoUpdateValue) {
        j = i + 1;
      }
      i = j;
      if (hasDiscussionUpdateValue) {
        i = j + 1;
      }
      j = i;
      if (hasFollowRecommendationUpdateValue) {
        j = i + 1;
      }
      i = j;
      if (hasGenericPromoUpdateValue) {
        i = j + 1;
      }
      j = i;
      if (hasJymbiiUpdateValue) {
        j = i + 1;
      }
      i = j;
      if (hasLyndaUpdateValue) {
        i = j + 1;
      }
      j = i;
      if (hasMentionedInNewsUpdateValue) {
        j = i + 1;
      }
      i = j;
      if (hasPromptResponseUpdateValue) {
        i = j + 1;
      }
      j = i;
      if (hasPropUpdateValue) {
        j = i + 1;
      }
      i = j;
      if (hasPymkUpdateValue) {
        i = j + 1;
      }
      j = i;
      if (hasReshareValue) {
        j = i + 1;
      }
      i = j;
      if (hasShareUpdateValue) {
        i = j + 1;
      }
      j = i;
      if (hasViralUpdateValue) {
        j = i + 1;
      }
      if (j > 1) {
        throw new UnionMemberCountException("Value", j);
      }
      return new Update.Value(aggregatedFollowRecommendationUpdateValue, aggregatedConnectionUpdateValue, aggregatedJymbiiUpdateValue, aggregatedPymkUpdateValue, aggregatedShareContentUpdateValue, articleUpdateValue, channelUpdateValue, connectionUpdateValue, crossPromoUpdateValue, discussionUpdateValue, followRecommendationUpdateValue, genericPromoUpdateValue, jymbiiUpdateValue, lyndaUpdateValue, mentionedInNewsUpdateValue, promptResponseUpdateValue, propUpdateValue, pymkUpdateValue, reshareValue, shareUpdateValue, viralUpdateValue, hasAggregatedFollowRecommendationUpdateValue, hasAggregatedConnectionUpdateValue, hasAggregatedJymbiiUpdateValue, hasAggregatedPymkUpdateValue, hasAggregatedShareContentUpdateValue, hasArticleUpdateValue, hasChannelUpdateValue, hasConnectionUpdateValue, hasCrossPromoUpdateValue, hasDiscussionUpdateValue, hasFollowRecommendationUpdateValue, hasGenericPromoUpdateValue, hasJymbiiUpdateValue, hasLyndaUpdateValue, hasMentionedInNewsUpdateValue, hasPromptResponseUpdateValue, hasPropUpdateValue, hasPymkUpdateValue, hasReshareValue, hasShareUpdateValue, hasViralUpdateValue);
    }
    
    public final Builder setDiscussionUpdateValue(DiscussionUpdate paramDiscussionUpdate)
    {
      if (paramDiscussionUpdate == null)
      {
        hasDiscussionUpdateValue = false;
        discussionUpdateValue = null;
        return this;
      }
      hasDiscussionUpdateValue = true;
      discussionUpdateValue = paramDiscussionUpdate;
      return this;
    }
    
    public final Builder setReshareValue(Reshare paramReshare)
    {
      if (paramReshare == null)
      {
        hasReshareValue = false;
        reshareValue = null;
        return this;
      }
      hasReshareValue = true;
      reshareValue = paramReshare;
      return this;
    }
    
    public final Builder setShareUpdateValue(ShareUpdate paramShareUpdate)
    {
      if (paramShareUpdate == null)
      {
        hasShareUpdateValue = false;
        shareUpdateValue = null;
        return this;
      }
      hasShareUpdateValue = true;
      shareUpdateValue = paramShareUpdate;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.Update.Value
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */