package com.linkedin.android.pegasus.gen.voyager.premium.onboarding;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class PremiumOnboardingCard$Card
  implements FissileDataModel<Card>, UnionTemplate<Card>
{
  public static final PremiumOnboardingCardBuilder.CardBuilder BUILDER = PremiumOnboardingCardBuilder.CardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final FeaturedApplicantCard featuredApplicantCardValue;
  public final boolean hasFeaturedApplicantCardValue;
  public final boolean hasInMailCardValue;
  public final boolean hasJobCardValue;
  public final boolean hasLaunchCardValue;
  public final boolean hasSearchCardValue;
  public final boolean hasWelcomeCardValue;
  public final boolean hasWvmpCardValue;
  public final InMailCard inMailCardValue;
  public final JobCard jobCardValue;
  public final LaunchCard launchCardValue;
  public final SearchCard searchCardValue;
  public final WelcomeCard welcomeCardValue;
  public final WvmpCard wvmpCardValue;
  
  PremiumOnboardingCard$Card(WelcomeCard paramWelcomeCard, JobCard paramJobCard, InMailCard paramInMailCard, FeaturedApplicantCard paramFeaturedApplicantCard, WvmpCard paramWvmpCard, SearchCard paramSearchCard, LaunchCard paramLaunchCard, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    welcomeCardValue = paramWelcomeCard;
    jobCardValue = paramJobCard;
    inMailCardValue = paramInMailCard;
    featuredApplicantCardValue = paramFeaturedApplicantCard;
    wvmpCardValue = paramWvmpCard;
    searchCardValue = paramSearchCard;
    launchCardValue = paramLaunchCard;
    hasWelcomeCardValue = paramBoolean1;
    hasJobCardValue = paramBoolean2;
    hasInMailCardValue = paramBoolean3;
    hasFeaturedApplicantCardValue = paramBoolean4;
    hasWvmpCardValue = paramBoolean5;
    hasSearchCardValue = paramBoolean6;
    hasLaunchCardValue = paramBoolean7;
    _cachedId = null;
  }
  
  public final Card accept(DataProcessor paramDataProcessor)
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
    if (hasWelcomeCardValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.premium.onboarding.WelcomeCard");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = welcomeCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label429;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasJobCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.premium.onboarding.JobCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label438;
        }
        localObject1 = jobCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label456;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasInMailCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.premium.onboarding.InMailCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label465;
        }
        localObject1 = inMailCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label483;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasFeaturedApplicantCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.premium.onboarding.FeaturedApplicantCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label493;
        }
        localObject1 = featuredApplicantCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label511;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      localObject6 = null;
      bool5 = false;
      if (hasWvmpCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.premium.onboarding.WvmpCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label521;
        }
        localObject1 = wvmpCardValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label539;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      localObject7 = null;
      bool6 = false;
      if (hasSearchCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.premium.onboarding.SearchCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label549;
        }
        localObject1 = searchCardValue.accept(paramDataProcessor);
        label302:
        if (localObject1 == null) {
          break label567;
        }
        bool6 = true;
        localObject7 = localObject1;
      }
      label314:
      localObject1 = null;
      bool7 = false;
      if (hasLaunchCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.premium.onboarding.LaunchCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label577;
        }
        localObject1 = launchCardValue.accept(paramDataProcessor);
        label354:
        if (localObject1 == null) {
          break label595;
        }
      }
    }
    label429:
    label438:
    label456:
    label465:
    label483:
    label493:
    label511:
    label521:
    label539:
    label549:
    label567:
    label577:
    label595:
    for (boolean bool7 = true;; bool7 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label601;
      }
      return new Card((WelcomeCard)localObject2, (JobCard)localObject3, (InMailCard)localObject4, (FeaturedApplicantCard)localObject5, (WvmpCard)localObject6, (SearchCard)localObject7, (LaunchCard)localObject1, bool1, bool2, bool3, bool4, bool5, bool6, bool7);
      localObject1 = (WelcomeCard)paramDataProcessor.processDataTemplate(welcomeCardValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (JobCard)paramDataProcessor.processDataTemplate(jobCardValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (InMailCard)paramDataProcessor.processDataTemplate(inMailCardValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (FeaturedApplicantCard)paramDataProcessor.processDataTemplate(featuredApplicantCardValue);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (WvmpCard)paramDataProcessor.processDataTemplate(wvmpCardValue);
      break label250;
      bool5 = false;
      localObject6 = localObject1;
      break label262;
      localObject1 = (SearchCard)paramDataProcessor.processDataTemplate(searchCardValue);
      break label302;
      bool6 = false;
      localObject7 = localObject1;
      break label314;
      localObject1 = (LaunchCard)paramDataProcessor.processDataTemplate(launchCardValue);
      break label354;
    }
    label601:
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
      paramObject = (Card)paramObject;
      if (welcomeCardValue != null)
      {
        if (welcomeCardValue.equals(welcomeCardValue)) {}
      }
      else {
        while (welcomeCardValue != null) {
          return false;
        }
      }
      if (jobCardValue != null)
      {
        if (jobCardValue.equals(jobCardValue)) {}
      }
      else {
        while (jobCardValue != null) {
          return false;
        }
      }
      if (inMailCardValue != null)
      {
        if (inMailCardValue.equals(inMailCardValue)) {}
      }
      else {
        while (inMailCardValue != null) {
          return false;
        }
      }
      if (featuredApplicantCardValue != null)
      {
        if (featuredApplicantCardValue.equals(featuredApplicantCardValue)) {}
      }
      else {
        while (featuredApplicantCardValue != null) {
          return false;
        }
      }
      if (wvmpCardValue != null)
      {
        if (wvmpCardValue.equals(wvmpCardValue)) {}
      }
      else {
        while (wvmpCardValue != null) {
          return false;
        }
      }
      if (searchCardValue != null)
      {
        if (searchCardValue.equals(searchCardValue)) {}
      }
      else {
        while (searchCardValue != null) {
          return false;
        }
      }
      if (launchCardValue == null) {
        break;
      }
    } while (launchCardValue.equals(launchCardValue));
    for (;;)
    {
      return false;
      if (launchCardValue == null) {
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
    if (hasWelcomeCardValue)
    {
      if (welcomeCardValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(welcomeCardValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasJobCardValue)
      {
        i = j + 1;
        if (jobCardValue._cachedId == null) {
          break label324;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(jobCardValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasInMailCardValue)
      {
        i = j + 1;
        if (inMailCardValue._cachedId == null) {
          break label337;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(inMailCardValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasFeaturedApplicantCardValue)
      {
        i = j + 1;
        if (featuredApplicantCardValue._cachedId == null) {
          break label350;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(featuredApplicantCardValue._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasWvmpCardValue)
      {
        i = j + 1;
        if (wvmpCardValue._cachedId == null) {
          break label363;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(wvmpCardValue._cachedId);
      }
      label219:
      j = i + 1;
      i = j;
      if (hasSearchCardValue)
      {
        i = j + 1;
        if (searchCardValue._cachedId == null) {
          break label376;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchCardValue._cachedId);
      }
      label261:
      j = i + 1;
      i = j;
      if (hasLaunchCardValue)
      {
        i = j + 1;
        if (launchCardValue._cachedId == null) {
          break label389;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(launchCardValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = welcomeCardValue.getSerializedSize() + 7;
      break;
      label324:
      i += jobCardValue.getSerializedSize();
      break label93;
      label337:
      i += inMailCardValue.getSerializedSize();
      break label135;
      label350:
      i += featuredApplicantCardValue.getSerializedSize();
      break label177;
      label363:
      i += wvmpCardValue.getSerializedSize();
      break label219;
      label376:
      i += searchCardValue.getSerializedSize();
      break label261;
      label389:
      i += launchCardValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i2 = 0;
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
    if (welcomeCardValue != null)
    {
      i = welcomeCardValue.hashCode();
      if (jobCardValue == null) {
        break label176;
      }
      j = jobCardValue.hashCode();
      if (inMailCardValue == null) {
        break label181;
      }
      k = inMailCardValue.hashCode();
      if (featuredApplicantCardValue == null) {
        break label186;
      }
      m = featuredApplicantCardValue.hashCode();
      if (wvmpCardValue == null) {
        break label192;
      }
      n = wvmpCardValue.hashCode();
      label92:
      if (searchCardValue == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = searchCardValue.hashCode();; i1 = 0)
    {
      if (launchCardValue != null) {
        i2 = launchCardValue.hashCode();
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Card");
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
    label230:
    label290:
    label350:
    label410:
    label470:
    label598:
    label623:
    label633:
    label658:
    label668:
    label693:
    label703:
    label728:
    label738:
    label763:
    label773:
    label798:
    label806:
    label808:
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
        localByteBuffer.putInt(1015118541);
        if (hasWelcomeCardValue)
        {
          localByteBuffer.put((byte)1);
          if (welcomeCardValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, welcomeCardValue._cachedId);
            welcomeCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasJobCardValue) {
              break label623;
            }
            localByteBuffer.put((byte)1);
            if (jobCardValue._cachedId == null) {
              break label598;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, jobCardValue._cachedId);
            jobCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasInMailCardValue) {
              break label658;
            }
            localByteBuffer.put((byte)1);
            if (inMailCardValue._cachedId == null) {
              break label633;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, inMailCardValue._cachedId);
            inMailCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasFeaturedApplicantCardValue) {
              break label693;
            }
            localByteBuffer.put((byte)1);
            if (featuredApplicantCardValue._cachedId == null) {
              break label668;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, featuredApplicantCardValue._cachedId);
            featuredApplicantCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasWvmpCardValue) {
              break label728;
            }
            localByteBuffer.put((byte)1);
            if (wvmpCardValue._cachedId == null) {
              break label703;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, wvmpCardValue._cachedId);
            wvmpCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchCardValue) {
              break label763;
            }
            localByteBuffer.put((byte)1);
            if (searchCardValue._cachedId == null) {
              break label738;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchCardValue._cachedId);
            searchCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasLaunchCardValue) {
              break label798;
            }
            localByteBuffer.put((byte)1);
            if (launchCardValue._cachedId == null) {
              break label773;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, launchCardValue._cachedId);
            launchCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label806;
          }
          if (str != null) {
            break label808;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          welcomeCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          jobCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          inMailCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          featuredApplicantCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label350;
          localByteBuffer.put((byte)0);
          break label350;
          localByteBuffer.put((byte)1);
          wvmpCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label410;
          localByteBuffer.put((byte)0);
          break label410;
          localByteBuffer.put((byte)1);
          searchCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label470;
          localByteBuffer.put((byte)0);
          break label470;
          localByteBuffer.put((byte)1);
          launchCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.onboarding.PremiumOnboardingCard.Card
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */