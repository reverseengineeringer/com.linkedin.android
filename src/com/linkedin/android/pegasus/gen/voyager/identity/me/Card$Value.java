package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Card$Value
  implements FissileDataModel<Value>, UnionTemplate<Value>
{
  public static final CardBuilder.ValueBuilder BUILDER = CardBuilder.ValueBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AggregateFollowCard aggregateFollowCardValue;
  public final AggregateProfileViewCard aggregateProfileViewCardValue;
  public final AggregatePropCard aggregatePropCardValue;
  public final EndorsementCard endorsementCardValue;
  public final FollowCard followCardValue;
  public final boolean hasAggregateFollowCardValue;
  public final boolean hasAggregateProfileViewCardValue;
  public final boolean hasAggregatePropCardValue;
  public final boolean hasEndorsementCardValue;
  public final boolean hasFollowCardValue;
  public final boolean hasJobUpdateActivityCardValue;
  public final boolean hasJymbiiNotificationCardValue;
  public final boolean hasNewToVoyagerCardValue;
  public final boolean hasProfileViewCardValue;
  public final boolean hasProfinderServiceProposalNotificationCardValue;
  public final boolean hasPropCardValue;
  public final boolean hasSocialActivityCardValue;
  public final boolean hasSocialUpdateAnalyticsCardValue;
  public final boolean hasSuggestedActionCardValue;
  public final boolean hasSuggestedEditCardValue;
  public final boolean hasWvmpAnonymousProfileViewCardValue;
  public final boolean hasWvmpPremiumUpsellCardValue;
  public final boolean hasWvmpProfileViewCardValue;
  public final JobUpdateActivityCard jobUpdateActivityCardValue;
  public final JymbiiNotificationCard jymbiiNotificationCardValue;
  public final NewToVoyagerCard newToVoyagerCardValue;
  public final ProfileViewCard profileViewCardValue;
  public final ProfinderServiceProposalNotificationCard profinderServiceProposalNotificationCardValue;
  public final PropCard propCardValue;
  public final SocialActivityCard socialActivityCardValue;
  public final SocialUpdateAnalyticsCard socialUpdateAnalyticsCardValue;
  public final SuggestedActionCard suggestedActionCardValue;
  public final SuggestedEditCard suggestedEditCardValue;
  public final WvmpAnonymousProfileViewCard wvmpAnonymousProfileViewCardValue;
  public final WvmpPremiumUpsellCard wvmpPremiumUpsellCardValue;
  public final WvmpProfileViewCard wvmpProfileViewCardValue;
  
  public Card$Value(ProfileViewCard paramProfileViewCard, AggregateProfileViewCard paramAggregateProfileViewCard, EndorsementCard paramEndorsementCard, FollowCard paramFollowCard, AggregateFollowCard paramAggregateFollowCard, SuggestedActionCard paramSuggestedActionCard, SocialActivityCard paramSocialActivityCard, WvmpProfileViewCard paramWvmpProfileViewCard, WvmpAnonymousProfileViewCard paramWvmpAnonymousProfileViewCard, WvmpPremiumUpsellCard paramWvmpPremiumUpsellCard, NewToVoyagerCard paramNewToVoyagerCard, JobUpdateActivityCard paramJobUpdateActivityCard, SuggestedEditCard paramSuggestedEditCard, JymbiiNotificationCard paramJymbiiNotificationCard, ProfinderServiceProposalNotificationCard paramProfinderServiceProposalNotificationCard, PropCard paramPropCard, AggregatePropCard paramAggregatePropCard, SocialUpdateAnalyticsCard paramSocialUpdateAnalyticsCard, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, boolean paramBoolean18)
  {
    profileViewCardValue = paramProfileViewCard;
    aggregateProfileViewCardValue = paramAggregateProfileViewCard;
    endorsementCardValue = paramEndorsementCard;
    followCardValue = paramFollowCard;
    aggregateFollowCardValue = paramAggregateFollowCard;
    suggestedActionCardValue = paramSuggestedActionCard;
    socialActivityCardValue = paramSocialActivityCard;
    wvmpProfileViewCardValue = paramWvmpProfileViewCard;
    wvmpAnonymousProfileViewCardValue = paramWvmpAnonymousProfileViewCard;
    wvmpPremiumUpsellCardValue = paramWvmpPremiumUpsellCard;
    newToVoyagerCardValue = paramNewToVoyagerCard;
    jobUpdateActivityCardValue = paramJobUpdateActivityCard;
    suggestedEditCardValue = paramSuggestedEditCard;
    jymbiiNotificationCardValue = paramJymbiiNotificationCard;
    profinderServiceProposalNotificationCardValue = paramProfinderServiceProposalNotificationCard;
    propCardValue = paramPropCard;
    aggregatePropCardValue = paramAggregatePropCard;
    socialUpdateAnalyticsCardValue = paramSocialUpdateAnalyticsCard;
    hasProfileViewCardValue = paramBoolean1;
    hasAggregateProfileViewCardValue = paramBoolean2;
    hasEndorsementCardValue = paramBoolean3;
    hasFollowCardValue = paramBoolean4;
    hasAggregateFollowCardValue = paramBoolean5;
    hasSuggestedActionCardValue = paramBoolean6;
    hasSocialActivityCardValue = paramBoolean7;
    hasWvmpProfileViewCardValue = paramBoolean8;
    hasWvmpAnonymousProfileViewCardValue = paramBoolean9;
    hasWvmpPremiumUpsellCardValue = paramBoolean10;
    hasNewToVoyagerCardValue = paramBoolean11;
    hasJobUpdateActivityCardValue = paramBoolean12;
    hasSuggestedEditCardValue = paramBoolean13;
    hasJymbiiNotificationCardValue = paramBoolean14;
    hasProfinderServiceProposalNotificationCardValue = paramBoolean15;
    hasPropCardValue = paramBoolean16;
    hasAggregatePropCardValue = paramBoolean17;
    hasSocialUpdateAnalyticsCardValue = paramBoolean18;
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
    label406:
    label418:
    Object localObject10;
    boolean bool9;
    label458:
    label470:
    Object localObject11;
    boolean bool10;
    label510:
    label522:
    Object localObject12;
    boolean bool11;
    label563:
    label575:
    Object localObject13;
    boolean bool12;
    label616:
    label628:
    Object localObject14;
    boolean bool13;
    label669:
    label681:
    Object localObject15;
    boolean bool14;
    label722:
    label734:
    Object localObject16;
    boolean bool15;
    label775:
    label787:
    Object localObject17;
    boolean bool16;
    label828:
    label840:
    Object localObject18;
    boolean bool17;
    if (hasProfileViewCardValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.ProfileViewCard");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = profileViewCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1053;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasAggregateProfileViewCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.AggregateProfileViewCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1062;
        }
        localObject1 = aggregateProfileViewCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1080;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasEndorsementCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.EndorsementCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1089;
        }
        localObject1 = endorsementCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1107;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasFollowCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.FollowCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1117;
        }
        localObject1 = followCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1135;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      localObject6 = null;
      bool5 = false;
      if (hasAggregateFollowCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.AggregateFollowCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1145;
        }
        localObject1 = aggregateFollowCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1163;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      localObject7 = null;
      bool6 = false;
      if (hasSuggestedActionCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.SuggestedActionCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1173;
        }
        localObject1 = suggestedActionCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1191;
        }
        bool6 = true;
        localObject7 = localObject1;
      }
      localObject8 = null;
      bool7 = false;
      if (hasSocialActivityCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.SocialActivityCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1201;
        }
        localObject1 = socialActivityCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1219;
        }
        bool7 = true;
        localObject8 = localObject1;
      }
      localObject9 = null;
      bool8 = false;
      if (hasWvmpProfileViewCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.WvmpProfileViewCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1229;
        }
        localObject1 = wvmpProfileViewCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1247;
        }
        bool8 = true;
        localObject9 = localObject1;
      }
      localObject10 = null;
      bool9 = false;
      if (hasWvmpAnonymousProfileViewCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.WvmpAnonymousProfileViewCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1257;
        }
        localObject1 = wvmpAnonymousProfileViewCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1275;
        }
        bool9 = true;
        localObject10 = localObject1;
      }
      localObject11 = null;
      bool10 = false;
      if (hasWvmpPremiumUpsellCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.WvmpPremiumUpsellCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1285;
        }
        localObject1 = wvmpPremiumUpsellCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1303;
        }
        bool10 = true;
        localObject11 = localObject1;
      }
      localObject12 = null;
      bool11 = false;
      if (hasNewToVoyagerCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.NewToVoyagerCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1313;
        }
        localObject1 = newToVoyagerCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1331;
        }
        bool11 = true;
        localObject12 = localObject1;
      }
      localObject13 = null;
      bool12 = false;
      if (hasJobUpdateActivityCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.JobUpdateActivityCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1341;
        }
        localObject1 = jobUpdateActivityCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1359;
        }
        bool12 = true;
        localObject13 = localObject1;
      }
      localObject14 = null;
      bool13 = false;
      if (hasSuggestedEditCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.SuggestedEditCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1369;
        }
        localObject1 = suggestedEditCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1387;
        }
        bool13 = true;
        localObject14 = localObject1;
      }
      localObject15 = null;
      bool14 = false;
      if (hasJymbiiNotificationCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.JymbiiNotificationCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1397;
        }
        localObject1 = jymbiiNotificationCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1415;
        }
        bool14 = true;
        localObject15 = localObject1;
      }
      localObject16 = null;
      bool15 = false;
      if (hasProfinderServiceProposalNotificationCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.ProfinderServiceProposalNotificationCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1425;
        }
        localObject1 = profinderServiceProposalNotificationCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1443;
        }
        bool15 = true;
        localObject16 = localObject1;
      }
      localObject17 = null;
      bool16 = false;
      if (hasPropCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.PropCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1453;
        }
        localObject1 = propCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1471;
        }
        bool16 = true;
        localObject17 = localObject1;
      }
      localObject18 = null;
      bool17 = false;
      if (hasAggregatePropCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.AggregatePropCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1481;
        }
        localObject1 = aggregatePropCardValue.accept(paramDataProcessor);
        label881:
        if (localObject1 == null) {
          break label1499;
        }
        bool17 = true;
        localObject18 = localObject1;
      }
      label893:
      localObject1 = null;
      bool18 = false;
      if (hasSocialUpdateAnalyticsCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.SocialUpdateAnalyticsCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1509;
        }
        localObject1 = socialUpdateAnalyticsCardValue.accept(paramDataProcessor);
        label934:
        if (localObject1 == null) {
          break label1527;
        }
      }
    }
    label1053:
    label1062:
    label1080:
    label1089:
    label1107:
    label1117:
    label1135:
    label1145:
    label1163:
    label1173:
    label1191:
    label1201:
    label1219:
    label1229:
    label1247:
    label1257:
    label1275:
    label1285:
    label1303:
    label1313:
    label1331:
    label1341:
    label1359:
    label1369:
    label1387:
    label1397:
    label1415:
    label1425:
    label1443:
    label1453:
    label1471:
    label1481:
    label1499:
    label1509:
    label1527:
    for (boolean bool18 = true;; bool18 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1533;
      }
      return new Value((ProfileViewCard)localObject2, (AggregateProfileViewCard)localObject3, (EndorsementCard)localObject4, (FollowCard)localObject5, (AggregateFollowCard)localObject6, (SuggestedActionCard)localObject7, (SocialActivityCard)localObject8, (WvmpProfileViewCard)localObject9, (WvmpAnonymousProfileViewCard)localObject10, (WvmpPremiumUpsellCard)localObject11, (NewToVoyagerCard)localObject12, (JobUpdateActivityCard)localObject13, (SuggestedEditCard)localObject14, (JymbiiNotificationCard)localObject15, (ProfinderServiceProposalNotificationCard)localObject16, (PropCard)localObject17, (AggregatePropCard)localObject18, (SocialUpdateAnalyticsCard)localObject1, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool15, bool16, bool17, bool18);
      localObject1 = (ProfileViewCard)paramDataProcessor.processDataTemplate(profileViewCardValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (AggregateProfileViewCard)paramDataProcessor.processDataTemplate(aggregateProfileViewCardValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (EndorsementCard)paramDataProcessor.processDataTemplate(endorsementCardValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (FollowCard)paramDataProcessor.processDataTemplate(followCardValue);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (AggregateFollowCard)paramDataProcessor.processDataTemplate(aggregateFollowCardValue);
      break label250;
      bool5 = false;
      localObject6 = localObject1;
      break label262;
      localObject1 = (SuggestedActionCard)paramDataProcessor.processDataTemplate(suggestedActionCardValue);
      break label302;
      bool6 = false;
      localObject7 = localObject1;
      break label314;
      localObject1 = (SocialActivityCard)paramDataProcessor.processDataTemplate(socialActivityCardValue);
      break label354;
      bool7 = false;
      localObject8 = localObject1;
      break label366;
      localObject1 = (WvmpProfileViewCard)paramDataProcessor.processDataTemplate(wvmpProfileViewCardValue);
      break label406;
      bool8 = false;
      localObject9 = localObject1;
      break label418;
      localObject1 = (WvmpAnonymousProfileViewCard)paramDataProcessor.processDataTemplate(wvmpAnonymousProfileViewCardValue);
      break label458;
      bool9 = false;
      localObject10 = localObject1;
      break label470;
      localObject1 = (WvmpPremiumUpsellCard)paramDataProcessor.processDataTemplate(wvmpPremiumUpsellCardValue);
      break label510;
      bool10 = false;
      localObject11 = localObject1;
      break label522;
      localObject1 = (NewToVoyagerCard)paramDataProcessor.processDataTemplate(newToVoyagerCardValue);
      break label563;
      bool11 = false;
      localObject12 = localObject1;
      break label575;
      localObject1 = (JobUpdateActivityCard)paramDataProcessor.processDataTemplate(jobUpdateActivityCardValue);
      break label616;
      bool12 = false;
      localObject13 = localObject1;
      break label628;
      localObject1 = (SuggestedEditCard)paramDataProcessor.processDataTemplate(suggestedEditCardValue);
      break label669;
      bool13 = false;
      localObject14 = localObject1;
      break label681;
      localObject1 = (JymbiiNotificationCard)paramDataProcessor.processDataTemplate(jymbiiNotificationCardValue);
      break label722;
      bool14 = false;
      localObject15 = localObject1;
      break label734;
      localObject1 = (ProfinderServiceProposalNotificationCard)paramDataProcessor.processDataTemplate(profinderServiceProposalNotificationCardValue);
      break label775;
      bool15 = false;
      localObject16 = localObject1;
      break label787;
      localObject1 = (PropCard)paramDataProcessor.processDataTemplate(propCardValue);
      break label828;
      bool16 = false;
      localObject17 = localObject1;
      break label840;
      localObject1 = (AggregatePropCard)paramDataProcessor.processDataTemplate(aggregatePropCardValue);
      break label881;
      bool17 = false;
      localObject18 = localObject1;
      break label893;
      localObject1 = (SocialUpdateAnalyticsCard)paramDataProcessor.processDataTemplate(socialUpdateAnalyticsCardValue);
      break label934;
    }
    label1533:
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
      if (profileViewCardValue != null)
      {
        if (profileViewCardValue.equals(profileViewCardValue)) {}
      }
      else {
        while (profileViewCardValue != null) {
          return false;
        }
      }
      if (aggregateProfileViewCardValue != null)
      {
        if (aggregateProfileViewCardValue.equals(aggregateProfileViewCardValue)) {}
      }
      else {
        while (aggregateProfileViewCardValue != null) {
          return false;
        }
      }
      if (endorsementCardValue != null)
      {
        if (endorsementCardValue.equals(endorsementCardValue)) {}
      }
      else {
        while (endorsementCardValue != null) {
          return false;
        }
      }
      if (followCardValue != null)
      {
        if (followCardValue.equals(followCardValue)) {}
      }
      else {
        while (followCardValue != null) {
          return false;
        }
      }
      if (aggregateFollowCardValue != null)
      {
        if (aggregateFollowCardValue.equals(aggregateFollowCardValue)) {}
      }
      else {
        while (aggregateFollowCardValue != null) {
          return false;
        }
      }
      if (suggestedActionCardValue != null)
      {
        if (suggestedActionCardValue.equals(suggestedActionCardValue)) {}
      }
      else {
        while (suggestedActionCardValue != null) {
          return false;
        }
      }
      if (socialActivityCardValue != null)
      {
        if (socialActivityCardValue.equals(socialActivityCardValue)) {}
      }
      else {
        while (socialActivityCardValue != null) {
          return false;
        }
      }
      if (wvmpProfileViewCardValue != null)
      {
        if (wvmpProfileViewCardValue.equals(wvmpProfileViewCardValue)) {}
      }
      else {
        while (wvmpProfileViewCardValue != null) {
          return false;
        }
      }
      if (wvmpAnonymousProfileViewCardValue != null)
      {
        if (wvmpAnonymousProfileViewCardValue.equals(wvmpAnonymousProfileViewCardValue)) {}
      }
      else {
        while (wvmpAnonymousProfileViewCardValue != null) {
          return false;
        }
      }
      if (wvmpPremiumUpsellCardValue != null)
      {
        if (wvmpPremiumUpsellCardValue.equals(wvmpPremiumUpsellCardValue)) {}
      }
      else {
        while (wvmpPremiumUpsellCardValue != null) {
          return false;
        }
      }
      if (newToVoyagerCardValue != null)
      {
        if (newToVoyagerCardValue.equals(newToVoyagerCardValue)) {}
      }
      else {
        while (newToVoyagerCardValue != null) {
          return false;
        }
      }
      if (jobUpdateActivityCardValue != null)
      {
        if (jobUpdateActivityCardValue.equals(jobUpdateActivityCardValue)) {}
      }
      else {
        while (jobUpdateActivityCardValue != null) {
          return false;
        }
      }
      if (suggestedEditCardValue != null)
      {
        if (suggestedEditCardValue.equals(suggestedEditCardValue)) {}
      }
      else {
        while (suggestedEditCardValue != null) {
          return false;
        }
      }
      if (jymbiiNotificationCardValue != null)
      {
        if (jymbiiNotificationCardValue.equals(jymbiiNotificationCardValue)) {}
      }
      else {
        while (jymbiiNotificationCardValue != null) {
          return false;
        }
      }
      if (profinderServiceProposalNotificationCardValue != null)
      {
        if (profinderServiceProposalNotificationCardValue.equals(profinderServiceProposalNotificationCardValue)) {}
      }
      else {
        while (profinderServiceProposalNotificationCardValue != null) {
          return false;
        }
      }
      if (propCardValue != null)
      {
        if (propCardValue.equals(propCardValue)) {}
      }
      else {
        while (propCardValue != null) {
          return false;
        }
      }
      if (aggregatePropCardValue != null)
      {
        if (aggregatePropCardValue.equals(aggregatePropCardValue)) {}
      }
      else {
        while (aggregatePropCardValue != null) {
          return false;
        }
      }
      if (socialUpdateAnalyticsCardValue == null) {
        break;
      }
    } while (socialUpdateAnalyticsCardValue.equals(socialUpdateAnalyticsCardValue));
    for (;;)
    {
      return false;
      if (socialUpdateAnalyticsCardValue == null) {
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
    if (hasProfileViewCardValue)
    {
      if (profileViewCardValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(profileViewCardValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasAggregateProfileViewCardValue)
      {
        i = j + 1;
        if (aggregateProfileViewCardValue._cachedId == null) {
          break label786;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(aggregateProfileViewCardValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasEndorsementCardValue)
      {
        i = j + 1;
        if (endorsementCardValue._cachedId == null) {
          break label799;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(endorsementCardValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasFollowCardValue)
      {
        i = j + 1;
        if (followCardValue._cachedId == null) {
          break label812;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(followCardValue._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasAggregateFollowCardValue)
      {
        i = j + 1;
        if (aggregateFollowCardValue._cachedId == null) {
          break label825;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(aggregateFollowCardValue._cachedId);
      }
      label219:
      j = i + 1;
      i = j;
      if (hasSuggestedActionCardValue)
      {
        i = j + 1;
        if (suggestedActionCardValue._cachedId == null) {
          break label838;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(suggestedActionCardValue._cachedId);
      }
      label261:
      j = i + 1;
      i = j;
      if (hasSocialActivityCardValue)
      {
        i = j + 1;
        if (socialActivityCardValue._cachedId == null) {
          break label851;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(socialActivityCardValue._cachedId);
      }
      label303:
      j = i + 1;
      i = j;
      if (hasWvmpProfileViewCardValue)
      {
        i = j + 1;
        if (wvmpProfileViewCardValue._cachedId == null) {
          break label864;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(wvmpProfileViewCardValue._cachedId);
      }
      label345:
      j = i + 1;
      i = j;
      if (hasWvmpAnonymousProfileViewCardValue)
      {
        i = j + 1;
        if (wvmpAnonymousProfileViewCardValue._cachedId == null) {
          break label877;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(wvmpAnonymousProfileViewCardValue._cachedId);
      }
      label387:
      j = i + 1;
      i = j;
      if (hasWvmpPremiumUpsellCardValue)
      {
        i = j + 1;
        if (wvmpPremiumUpsellCardValue._cachedId == null) {
          break label890;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(wvmpPremiumUpsellCardValue._cachedId);
      }
      label429:
      j = i + 1;
      i = j;
      if (hasNewToVoyagerCardValue)
      {
        i = j + 1;
        if (newToVoyagerCardValue._cachedId == null) {
          break label903;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(newToVoyagerCardValue._cachedId);
      }
      label471:
      j = i + 1;
      i = j;
      if (hasJobUpdateActivityCardValue)
      {
        i = j + 1;
        if (jobUpdateActivityCardValue._cachedId == null) {
          break label916;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(jobUpdateActivityCardValue._cachedId);
      }
      label513:
      j = i + 1;
      i = j;
      if (hasSuggestedEditCardValue)
      {
        i = j + 1;
        if (suggestedEditCardValue._cachedId == null) {
          break label929;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(suggestedEditCardValue._cachedId);
      }
      label555:
      j = i + 1;
      i = j;
      if (hasJymbiiNotificationCardValue)
      {
        i = j + 1;
        if (jymbiiNotificationCardValue._cachedId == null) {
          break label942;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(jymbiiNotificationCardValue._cachedId);
      }
      label597:
      j = i + 1;
      i = j;
      if (hasProfinderServiceProposalNotificationCardValue)
      {
        i = j + 1;
        if (profinderServiceProposalNotificationCardValue._cachedId == null) {
          break label955;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(profinderServiceProposalNotificationCardValue._cachedId);
      }
      label639:
      j = i + 1;
      i = j;
      if (hasPropCardValue)
      {
        i = j + 1;
        if (propCardValue._cachedId == null) {
          break label968;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(propCardValue._cachedId);
      }
      label681:
      j = i + 1;
      i = j;
      if (hasAggregatePropCardValue)
      {
        i = j + 1;
        if (aggregatePropCardValue._cachedId == null) {
          break label981;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(aggregatePropCardValue._cachedId);
      }
      label723:
      j = i + 1;
      i = j;
      if (hasSocialUpdateAnalyticsCardValue)
      {
        i = j + 1;
        if (socialUpdateAnalyticsCardValue._cachedId == null) {
          break label994;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(socialUpdateAnalyticsCardValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = profileViewCardValue.getSerializedSize() + 7;
      break;
      label786:
      i += aggregateProfileViewCardValue.getSerializedSize();
      break label93;
      label799:
      i += endorsementCardValue.getSerializedSize();
      break label135;
      label812:
      i += followCardValue.getSerializedSize();
      break label177;
      label825:
      i += aggregateFollowCardValue.getSerializedSize();
      break label219;
      label838:
      i += suggestedActionCardValue.getSerializedSize();
      break label261;
      label851:
      i += socialActivityCardValue.getSerializedSize();
      break label303;
      label864:
      i += wvmpProfileViewCardValue.getSerializedSize();
      break label345;
      label877:
      i += wvmpAnonymousProfileViewCardValue.getSerializedSize();
      break label387;
      label890:
      i += wvmpPremiumUpsellCardValue.getSerializedSize();
      break label429;
      label903:
      i += newToVoyagerCardValue.getSerializedSize();
      break label471;
      label916:
      i += jobUpdateActivityCardValue.getSerializedSize();
      break label513;
      label929:
      i += suggestedEditCardValue.getSerializedSize();
      break label555;
      label942:
      i += jymbiiNotificationCardValue.getSerializedSize();
      break label597;
      label955:
      i += profinderServiceProposalNotificationCardValue.getSerializedSize();
      break label639;
      label968:
      i += propCardValue.getSerializedSize();
      break label681;
      label981:
      i += aggregatePropCardValue.getSerializedSize();
      break label723;
      label994:
      i += socialUpdateAnalyticsCardValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i13 = 0;
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
    if (profileViewCardValue != null)
    {
      i = profileViewCardValue.hashCode();
      if (aggregateProfileViewCardValue == null) {
        break label418;
      }
      j = aggregateProfileViewCardValue.hashCode();
      if (endorsementCardValue == null) {
        break label423;
      }
      k = endorsementCardValue.hashCode();
      if (followCardValue == null) {
        break label428;
      }
      m = followCardValue.hashCode();
      if (aggregateFollowCardValue == null) {
        break label434;
      }
      n = aggregateFollowCardValue.hashCode();
      if (suggestedActionCardValue == null) {
        break label440;
      }
      i1 = suggestedActionCardValue.hashCode();
      if (socialActivityCardValue == null) {
        break label446;
      }
      i2 = socialActivityCardValue.hashCode();
      if (wvmpProfileViewCardValue == null) {
        break label452;
      }
      i3 = wvmpProfileViewCardValue.hashCode();
      if (wvmpAnonymousProfileViewCardValue == null) {
        break label458;
      }
      i4 = wvmpAnonymousProfileViewCardValue.hashCode();
      if (wvmpPremiumUpsellCardValue == null) {
        break label464;
      }
      i5 = wvmpPremiumUpsellCardValue.hashCode();
      if (newToVoyagerCardValue == null) {
        break label470;
      }
      i6 = newToVoyagerCardValue.hashCode();
      if (jobUpdateActivityCardValue == null) {
        break label476;
      }
      i7 = jobUpdateActivityCardValue.hashCode();
      if (suggestedEditCardValue == null) {
        break label482;
      }
      i8 = suggestedEditCardValue.hashCode();
      if (jymbiiNotificationCardValue == null) {
        break label488;
      }
      i9 = jymbiiNotificationCardValue.hashCode();
      if (profinderServiceProposalNotificationCardValue == null) {
        break label494;
      }
      i10 = profinderServiceProposalNotificationCardValue.hashCode();
      if (propCardValue == null) {
        break label500;
      }
      i11 = propCardValue.hashCode();
      label268:
      if (aggregatePropCardValue == null) {
        break label506;
      }
    }
    label418:
    label423:
    label428:
    label434:
    label440:
    label446:
    label452:
    label458:
    label464:
    label470:
    label476:
    label482:
    label488:
    label494:
    label500:
    label506:
    for (int i12 = aggregatePropCardValue.hashCode();; i12 = 0)
    {
      if (socialUpdateAnalyticsCardValue != null) {
        i13 = socialUpdateAnalyticsCardValue.hashCode();
      }
      i = (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i13;
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
    label1260:
    label1285:
    label1295:
    label1320:
    label1330:
    label1355:
    label1365:
    label1390:
    label1400:
    label1425:
    label1435:
    label1460:
    label1470:
    label1495:
    label1505:
    label1530:
    label1540:
    label1565:
    label1575:
    label1600:
    label1610:
    label1635:
    label1645:
    label1670:
    label1680:
    label1705:
    label1715:
    label1740:
    label1750:
    label1775:
    label1785:
    label1810:
    label1820:
    label1845:
    label1853:
    label1855:
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
        localByteBuffer.putInt(-1165812572);
        if (hasProfileViewCardValue)
        {
          localByteBuffer.put((byte)1);
          if (profileViewCardValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, profileViewCardValue._cachedId);
            profileViewCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAggregateProfileViewCardValue) {
              break label1285;
            }
            localByteBuffer.put((byte)1);
            if (aggregateProfileViewCardValue._cachedId == null) {
              break label1260;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, aggregateProfileViewCardValue._cachedId);
            aggregateProfileViewCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasEndorsementCardValue) {
              break label1320;
            }
            localByteBuffer.put((byte)1);
            if (endorsementCardValue._cachedId == null) {
              break label1295;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, endorsementCardValue._cachedId);
            endorsementCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasFollowCardValue) {
              break label1355;
            }
            localByteBuffer.put((byte)1);
            if (followCardValue._cachedId == null) {
              break label1330;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, followCardValue._cachedId);
            followCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAggregateFollowCardValue) {
              break label1390;
            }
            localByteBuffer.put((byte)1);
            if (aggregateFollowCardValue._cachedId == null) {
              break label1365;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, aggregateFollowCardValue._cachedId);
            aggregateFollowCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSuggestedActionCardValue) {
              break label1425;
            }
            localByteBuffer.put((byte)1);
            if (suggestedActionCardValue._cachedId == null) {
              break label1400;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, suggestedActionCardValue._cachedId);
            suggestedActionCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSocialActivityCardValue) {
              break label1460;
            }
            localByteBuffer.put((byte)1);
            if (socialActivityCardValue._cachedId == null) {
              break label1435;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, socialActivityCardValue._cachedId);
            socialActivityCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasWvmpProfileViewCardValue) {
              break label1495;
            }
            localByteBuffer.put((byte)1);
            if (wvmpProfileViewCardValue._cachedId == null) {
              break label1470;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, wvmpProfileViewCardValue._cachedId);
            wvmpProfileViewCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasWvmpAnonymousProfileViewCardValue) {
              break label1530;
            }
            localByteBuffer.put((byte)1);
            if (wvmpAnonymousProfileViewCardValue._cachedId == null) {
              break label1505;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, wvmpAnonymousProfileViewCardValue._cachedId);
            wvmpAnonymousProfileViewCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasWvmpPremiumUpsellCardValue) {
              break label1565;
            }
            localByteBuffer.put((byte)1);
            if (wvmpPremiumUpsellCardValue._cachedId == null) {
              break label1540;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, wvmpPremiumUpsellCardValue._cachedId);
            wvmpPremiumUpsellCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasNewToVoyagerCardValue) {
              break label1600;
            }
            localByteBuffer.put((byte)1);
            if (newToVoyagerCardValue._cachedId == null) {
              break label1575;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, newToVoyagerCardValue._cachedId);
            newToVoyagerCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasJobUpdateActivityCardValue) {
              break label1635;
            }
            localByteBuffer.put((byte)1);
            if (jobUpdateActivityCardValue._cachedId == null) {
              break label1610;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, jobUpdateActivityCardValue._cachedId);
            jobUpdateActivityCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSuggestedEditCardValue) {
              break label1670;
            }
            localByteBuffer.put((byte)1);
            if (suggestedEditCardValue._cachedId == null) {
              break label1645;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, suggestedEditCardValue._cachedId);
            suggestedEditCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasJymbiiNotificationCardValue) {
              break label1705;
            }
            localByteBuffer.put((byte)1);
            if (jymbiiNotificationCardValue._cachedId == null) {
              break label1680;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, jymbiiNotificationCardValue._cachedId);
            jymbiiNotificationCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasProfinderServiceProposalNotificationCardValue) {
              break label1740;
            }
            localByteBuffer.put((byte)1);
            if (profinderServiceProposalNotificationCardValue._cachedId == null) {
              break label1715;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, profinderServiceProposalNotificationCardValue._cachedId);
            profinderServiceProposalNotificationCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPropCardValue) {
              break label1775;
            }
            localByteBuffer.put((byte)1);
            if (propCardValue._cachedId == null) {
              break label1750;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, propCardValue._cachedId);
            propCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAggregatePropCardValue) {
              break label1810;
            }
            localByteBuffer.put((byte)1);
            if (aggregatePropCardValue._cachedId == null) {
              break label1785;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, aggregatePropCardValue._cachedId);
            aggregatePropCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSocialUpdateAnalyticsCardValue) {
              break label1845;
            }
            localByteBuffer.put((byte)1);
            if (socialUpdateAnalyticsCardValue._cachedId == null) {
              break label1820;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, socialUpdateAnalyticsCardValue._cachedId);
            socialUpdateAnalyticsCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label1853;
          }
          if (str != null) {
            break label1855;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          profileViewCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          aggregateProfileViewCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label232;
          localByteBuffer.put((byte)0);
          break label232;
          localByteBuffer.put((byte)1);
          endorsementCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label292;
          localByteBuffer.put((byte)0);
          break label292;
          localByteBuffer.put((byte)1);
          followCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label352;
          localByteBuffer.put((byte)0);
          break label352;
          localByteBuffer.put((byte)1);
          aggregateFollowCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label412;
          localByteBuffer.put((byte)0);
          break label412;
          localByteBuffer.put((byte)1);
          suggestedActionCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label472;
          localByteBuffer.put((byte)0);
          break label472;
          localByteBuffer.put((byte)1);
          socialActivityCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label532;
          localByteBuffer.put((byte)0);
          break label532;
          localByteBuffer.put((byte)1);
          wvmpProfileViewCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label592;
          localByteBuffer.put((byte)0);
          break label592;
          localByteBuffer.put((byte)1);
          wvmpAnonymousProfileViewCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label652;
          localByteBuffer.put((byte)0);
          break label652;
          localByteBuffer.put((byte)1);
          wvmpPremiumUpsellCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label712;
          localByteBuffer.put((byte)0);
          break label712;
          localByteBuffer.put((byte)1);
          newToVoyagerCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label772;
          localByteBuffer.put((byte)0);
          break label772;
          localByteBuffer.put((byte)1);
          jobUpdateActivityCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label832;
          localByteBuffer.put((byte)0);
          break label832;
          localByteBuffer.put((byte)1);
          suggestedEditCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label892;
          localByteBuffer.put((byte)0);
          break label892;
          localByteBuffer.put((byte)1);
          jymbiiNotificationCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label952;
          localByteBuffer.put((byte)0);
          break label952;
          localByteBuffer.put((byte)1);
          profinderServiceProposalNotificationCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1012;
          localByteBuffer.put((byte)0);
          break label1012;
          localByteBuffer.put((byte)1);
          propCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1072;
          localByteBuffer.put((byte)0);
          break label1072;
          localByteBuffer.put((byte)1);
          aggregatePropCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1132;
          localByteBuffer.put((byte)0);
          break label1132;
          localByteBuffer.put((byte)1);
          socialUpdateAnalyticsCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    public AggregateFollowCard aggregateFollowCardValue = null;
    public AggregateProfileViewCard aggregateProfileViewCardValue = null;
    public AggregatePropCard aggregatePropCardValue = null;
    public EndorsementCard endorsementCardValue = null;
    public FollowCard followCardValue = null;
    public boolean hasAggregateFollowCardValue = false;
    public boolean hasAggregateProfileViewCardValue = false;
    public boolean hasAggregatePropCardValue = false;
    public boolean hasEndorsementCardValue = false;
    public boolean hasFollowCardValue = false;
    public boolean hasJobUpdateActivityCardValue = false;
    public boolean hasJymbiiNotificationCardValue = false;
    public boolean hasNewToVoyagerCardValue = false;
    public boolean hasProfileViewCardValue = false;
    public boolean hasProfinderServiceProposalNotificationCardValue = false;
    public boolean hasPropCardValue = false;
    public boolean hasSocialActivityCardValue = false;
    public boolean hasSocialUpdateAnalyticsCardValue = false;
    public boolean hasSuggestedActionCardValue = false;
    public boolean hasSuggestedEditCardValue = false;
    public boolean hasWvmpAnonymousProfileViewCardValue = false;
    public boolean hasWvmpPremiumUpsellCardValue = false;
    public boolean hasWvmpProfileViewCardValue = false;
    public JobUpdateActivityCard jobUpdateActivityCardValue = null;
    public JymbiiNotificationCard jymbiiNotificationCardValue = null;
    public NewToVoyagerCard newToVoyagerCardValue = null;
    public ProfileViewCard profileViewCardValue = null;
    public ProfinderServiceProposalNotificationCard profinderServiceProposalNotificationCardValue = null;
    public PropCard propCardValue = null;
    public SocialActivityCard socialActivityCardValue = null;
    public SocialUpdateAnalyticsCard socialUpdateAnalyticsCardValue = null;
    public SuggestedActionCard suggestedActionCardValue = null;
    public SuggestedEditCard suggestedEditCardValue = null;
    public WvmpAnonymousProfileViewCard wvmpAnonymousProfileViewCardValue = null;
    public WvmpPremiumUpsellCard wvmpPremiumUpsellCardValue = null;
    public WvmpProfileViewCard wvmpProfileViewCardValue = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.Card.Value
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */