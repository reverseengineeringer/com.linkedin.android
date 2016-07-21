package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchHit$HitInfo
  implements FissileDataModel<HitInfo>, UnionTemplate<HitInfo>
{
  public static final SearchHitBuilder.HitInfoBuilder BUILDER = SearchHitBuilder.HitInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final BlurredHit blurredHitValue;
  public final FacetSuggestion facetSuggestionValue;
  public final boolean hasBlurredHitValue;
  public final boolean hasFacetSuggestionValue;
  public final boolean hasPaywallValue;
  public final boolean hasSearchArticleValue;
  public final boolean hasSearchCompanyValue;
  public final boolean hasSearchGroupValue;
  public final boolean hasSearchJobJserpValue;
  public final boolean hasSearchJobValue;
  public final boolean hasSearchProfileValue;
  public final boolean hasSearchSchoolValue;
  public final boolean hasSecondaryResultContainerValue;
  public final boolean hasUpdateValue;
  public final Paywall paywallValue;
  public final SearchArticle searchArticleValue;
  public final SearchCompany searchCompanyValue;
  public final SearchGroup searchGroupValue;
  public final SearchJobJserp searchJobJserpValue;
  public final SearchJob searchJobValue;
  public final SearchProfile searchProfileValue;
  public final SearchSchool searchSchoolValue;
  public final SecondaryResultContainer secondaryResultContainerValue;
  public final Update updateValue;
  
  SearchHit$HitInfo(SearchProfile paramSearchProfile, SearchJob paramSearchJob, SearchJobJserp paramSearchJobJserp, SearchCompany paramSearchCompany, SearchSchool paramSearchSchool, SearchGroup paramSearchGroup, SearchArticle paramSearchArticle, SecondaryResultContainer paramSecondaryResultContainer, FacetSuggestion paramFacetSuggestion, Paywall paramPaywall, Update paramUpdate, BlurredHit paramBlurredHit, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12)
  {
    searchProfileValue = paramSearchProfile;
    searchJobValue = paramSearchJob;
    searchJobJserpValue = paramSearchJobJserp;
    searchCompanyValue = paramSearchCompany;
    searchSchoolValue = paramSearchSchool;
    searchGroupValue = paramSearchGroup;
    searchArticleValue = paramSearchArticle;
    secondaryResultContainerValue = paramSecondaryResultContainer;
    facetSuggestionValue = paramFacetSuggestion;
    paywallValue = paramPaywall;
    updateValue = paramUpdate;
    blurredHitValue = paramBlurredHit;
    hasSearchProfileValue = paramBoolean1;
    hasSearchJobValue = paramBoolean2;
    hasSearchJobJserpValue = paramBoolean3;
    hasSearchCompanyValue = paramBoolean4;
    hasSearchSchoolValue = paramBoolean5;
    hasSearchGroupValue = paramBoolean6;
    hasSearchArticleValue = paramBoolean7;
    hasSecondaryResultContainerValue = paramBoolean8;
    hasFacetSuggestionValue = paramBoolean9;
    hasPaywallValue = paramBoolean10;
    hasUpdateValue = paramBoolean11;
    hasBlurredHitValue = paramBoolean12;
    _cachedId = null;
  }
  
  public final HitInfo accept(DataProcessor paramDataProcessor)
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
    if (hasSearchProfileValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = searchProfileValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label709;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasSearchJobValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchJob");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label718;
        }
        localObject1 = searchJobValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label736;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasSearchJobJserpValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchJobJserp");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label745;
        }
        localObject1 = searchJobJserpValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label763;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasSearchCompanyValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchCompany");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label773;
        }
        localObject1 = searchCompanyValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label791;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      localObject6 = null;
      bool5 = false;
      if (hasSearchSchoolValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchSchool");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label801;
        }
        localObject1 = searchSchoolValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label819;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      localObject7 = null;
      bool6 = false;
      if (hasSearchGroupValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchGroup");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label829;
        }
        localObject1 = searchGroupValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label847;
        }
        bool6 = true;
        localObject7 = localObject1;
      }
      localObject8 = null;
      bool7 = false;
      if (hasSearchArticleValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchArticle");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label857;
        }
        localObject1 = searchArticleValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label875;
        }
        bool7 = true;
        localObject8 = localObject1;
      }
      localObject9 = null;
      bool8 = false;
      if (hasSecondaryResultContainerValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SecondaryResultContainer");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label885;
        }
        localObject1 = secondaryResultContainerValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label903;
        }
        bool8 = true;
        localObject9 = localObject1;
      }
      localObject10 = null;
      bool9 = false;
      if (hasFacetSuggestionValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.FacetSuggestion");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label913;
        }
        localObject1 = facetSuggestionValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label931;
        }
        bool9 = true;
        localObject10 = localObject1;
      }
      localObject11 = null;
      bool10 = false;
      if (hasPaywallValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.Paywall");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label941;
        }
        localObject1 = paywallValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label959;
        }
        bool10 = true;
        localObject11 = localObject1;
      }
      localObject12 = null;
      bool11 = false;
      if (hasUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.Update");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label969;
        }
        localObject1 = updateValue.accept(paramDataProcessor);
        label562:
        if (localObject1 == null) {
          break label987;
        }
        bool11 = true;
        localObject12 = localObject1;
      }
      label574:
      localObject1 = null;
      bool12 = false;
      if (hasBlurredHitValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.BlurredHit");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label997;
        }
        localObject1 = blurredHitValue.accept(paramDataProcessor);
        label614:
        if (localObject1 == null) {
          break label1015;
        }
      }
    }
    label709:
    label718:
    label736:
    label745:
    label763:
    label773:
    label791:
    label801:
    label819:
    label829:
    label847:
    label857:
    label875:
    label885:
    label903:
    label913:
    label931:
    label941:
    label959:
    label969:
    label987:
    label997:
    label1015:
    for (boolean bool12 = true;; bool12 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1021;
      }
      return new HitInfo((SearchProfile)localObject2, (SearchJob)localObject3, (SearchJobJserp)localObject4, (SearchCompany)localObject5, (SearchSchool)localObject6, (SearchGroup)localObject7, (SearchArticle)localObject8, (SecondaryResultContainer)localObject9, (FacetSuggestion)localObject10, (Paywall)localObject11, (Update)localObject12, (BlurredHit)localObject1, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12);
      localObject1 = (SearchProfile)paramDataProcessor.processDataTemplate(searchProfileValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (SearchJob)paramDataProcessor.processDataTemplate(searchJobValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (SearchJobJserp)paramDataProcessor.processDataTemplate(searchJobJserpValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (SearchCompany)paramDataProcessor.processDataTemplate(searchCompanyValue);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (SearchSchool)paramDataProcessor.processDataTemplate(searchSchoolValue);
      break label250;
      bool5 = false;
      localObject6 = localObject1;
      break label262;
      localObject1 = (SearchGroup)paramDataProcessor.processDataTemplate(searchGroupValue);
      break label302;
      bool6 = false;
      localObject7 = localObject1;
      break label314;
      localObject1 = (SearchArticle)paramDataProcessor.processDataTemplate(searchArticleValue);
      break label354;
      bool7 = false;
      localObject8 = localObject1;
      break label366;
      localObject1 = (SecondaryResultContainer)paramDataProcessor.processDataTemplate(secondaryResultContainerValue);
      break label406;
      bool8 = false;
      localObject9 = localObject1;
      break label418;
      localObject1 = (FacetSuggestion)paramDataProcessor.processDataTemplate(facetSuggestionValue);
      break label458;
      bool9 = false;
      localObject10 = localObject1;
      break label470;
      localObject1 = (Paywall)paramDataProcessor.processDataTemplate(paywallValue);
      break label510;
      bool10 = false;
      localObject11 = localObject1;
      break label522;
      localObject1 = (Update)paramDataProcessor.processDataTemplate(updateValue);
      break label562;
      bool11 = false;
      localObject12 = localObject1;
      break label574;
      localObject1 = (BlurredHit)paramDataProcessor.processDataTemplate(blurredHitValue);
      break label614;
    }
    label1021:
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
      paramObject = (HitInfo)paramObject;
      if (searchProfileValue != null)
      {
        if (searchProfileValue.equals(searchProfileValue)) {}
      }
      else {
        while (searchProfileValue != null) {
          return false;
        }
      }
      if (searchJobValue != null)
      {
        if (searchJobValue.equals(searchJobValue)) {}
      }
      else {
        while (searchJobValue != null) {
          return false;
        }
      }
      if (searchJobJserpValue != null)
      {
        if (searchJobJserpValue.equals(searchJobJserpValue)) {}
      }
      else {
        while (searchJobJserpValue != null) {
          return false;
        }
      }
      if (searchCompanyValue != null)
      {
        if (searchCompanyValue.equals(searchCompanyValue)) {}
      }
      else {
        while (searchCompanyValue != null) {
          return false;
        }
      }
      if (searchSchoolValue != null)
      {
        if (searchSchoolValue.equals(searchSchoolValue)) {}
      }
      else {
        while (searchSchoolValue != null) {
          return false;
        }
      }
      if (searchGroupValue != null)
      {
        if (searchGroupValue.equals(searchGroupValue)) {}
      }
      else {
        while (searchGroupValue != null) {
          return false;
        }
      }
      if (searchArticleValue != null)
      {
        if (searchArticleValue.equals(searchArticleValue)) {}
      }
      else {
        while (searchArticleValue != null) {
          return false;
        }
      }
      if (secondaryResultContainerValue != null)
      {
        if (secondaryResultContainerValue.equals(secondaryResultContainerValue)) {}
      }
      else {
        while (secondaryResultContainerValue != null) {
          return false;
        }
      }
      if (facetSuggestionValue != null)
      {
        if (facetSuggestionValue.equals(facetSuggestionValue)) {}
      }
      else {
        while (facetSuggestionValue != null) {
          return false;
        }
      }
      if (paywallValue != null)
      {
        if (paywallValue.equals(paywallValue)) {}
      }
      else {
        while (paywallValue != null) {
          return false;
        }
      }
      if (updateValue != null)
      {
        if (updateValue.equals(updateValue)) {}
      }
      else {
        while (updateValue != null) {
          return false;
        }
      }
      if (blurredHitValue == null) {
        break;
      }
    } while (blurredHitValue.equals(blurredHitValue));
    for (;;)
    {
      return false;
      if (blurredHitValue == null) {
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
    if (hasSearchProfileValue)
    {
      if (searchProfileValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(searchProfileValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasSearchJobValue)
      {
        i = j + 1;
        if (searchJobValue._cachedId == null) {
          break label534;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchJobValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasSearchJobJserpValue)
      {
        i = j + 1;
        if (searchJobJserpValue._cachedId == null) {
          break label547;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchJobJserpValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasSearchCompanyValue)
      {
        i = j + 1;
        if (searchCompanyValue._cachedId == null) {
          break label560;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchCompanyValue._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasSearchSchoolValue)
      {
        i = j + 1;
        if (searchSchoolValue._cachedId == null) {
          break label573;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchSchoolValue._cachedId);
      }
      label219:
      j = i + 1;
      i = j;
      if (hasSearchGroupValue)
      {
        i = j + 1;
        if (searchGroupValue._cachedId == null) {
          break label586;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchGroupValue._cachedId);
      }
      label261:
      j = i + 1;
      i = j;
      if (hasSearchArticleValue)
      {
        i = j + 1;
        if (searchArticleValue._cachedId == null) {
          break label599;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchArticleValue._cachedId);
      }
      label303:
      j = i + 1;
      i = j;
      if (hasSecondaryResultContainerValue)
      {
        i = j + 1;
        if (secondaryResultContainerValue._cachedId == null) {
          break label612;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(secondaryResultContainerValue._cachedId);
      }
      label345:
      j = i + 1;
      i = j;
      if (hasFacetSuggestionValue)
      {
        i = j + 1;
        if (facetSuggestionValue._cachedId == null) {
          break label625;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(facetSuggestionValue._cachedId);
      }
      label387:
      j = i + 1;
      i = j;
      if (hasPaywallValue)
      {
        i = j + 1;
        if (paywallValue._cachedId == null) {
          break label638;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(paywallValue._cachedId);
      }
      label429:
      j = i + 1;
      i = j;
      if (hasUpdateValue)
      {
        i = j + 1;
        if (updateValue._cachedId == null) {
          break label651;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(updateValue._cachedId);
      }
      label471:
      j = i + 1;
      i = j;
      if (hasBlurredHitValue)
      {
        i = j + 1;
        if (blurredHitValue._cachedId == null) {
          break label664;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(blurredHitValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = searchProfileValue.getSerializedSize() + 7;
      break;
      label534:
      i += searchJobValue.getSerializedSize();
      break label93;
      label547:
      i += searchJobJserpValue.getSerializedSize();
      break label135;
      label560:
      i += searchCompanyValue.getSerializedSize();
      break label177;
      label573:
      i += searchSchoolValue.getSerializedSize();
      break label219;
      label586:
      i += searchGroupValue.getSerializedSize();
      break label261;
      label599:
      i += searchArticleValue.getSerializedSize();
      break label303;
      label612:
      i += secondaryResultContainerValue.getSerializedSize();
      break label345;
      label625:
      i += facetSuggestionValue.getSerializedSize();
      break label387;
      label638:
      i += paywallValue.getSerializedSize();
      break label429;
      label651:
      i += updateValue.getSerializedSize();
      break label471;
      label664:
      i += blurredHitValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i7 = 0;
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
    if (searchProfileValue != null)
    {
      i = searchProfileValue.hashCode();
      if (searchJobValue == null) {
        break label286;
      }
      j = searchJobValue.hashCode();
      if (searchJobJserpValue == null) {
        break label291;
      }
      k = searchJobJserpValue.hashCode();
      if (searchCompanyValue == null) {
        break label296;
      }
      m = searchCompanyValue.hashCode();
      if (searchSchoolValue == null) {
        break label302;
      }
      n = searchSchoolValue.hashCode();
      if (searchGroupValue == null) {
        break label308;
      }
      i1 = searchGroupValue.hashCode();
      if (searchArticleValue == null) {
        break label314;
      }
      i2 = searchArticleValue.hashCode();
      if (secondaryResultContainerValue == null) {
        break label320;
      }
      i3 = secondaryResultContainerValue.hashCode();
      if (facetSuggestionValue == null) {
        break label326;
      }
      i4 = facetSuggestionValue.hashCode();
      if (paywallValue == null) {
        break label332;
      }
      i5 = paywallValue.hashCode();
      label172:
      if (updateValue == null) {
        break label338;
      }
    }
    label286:
    label291:
    label296:
    label302:
    label308:
    label314:
    label320:
    label326:
    label332:
    label338:
    for (int i6 = updateValue.hashCode();; i6 = 0)
    {
      if (blurredHitValue != null) {
        i7 = blurredHitValue.hashCode();
      }
      i = (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i7;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building HitInfo");
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
    label900:
    label925:
    label935:
    label960:
    label970:
    label995:
    label1005:
    label1030:
    label1040:
    label1065:
    label1075:
    label1100:
    label1110:
    label1135:
    label1145:
    label1170:
    label1180:
    label1205:
    label1215:
    label1240:
    label1250:
    label1275:
    label1283:
    label1285:
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
        localByteBuffer.putInt(-525787340);
        if (hasSearchProfileValue)
        {
          localByteBuffer.put((byte)1);
          if (searchProfileValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchProfileValue._cachedId);
            searchProfileValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchJobValue) {
              break label925;
            }
            localByteBuffer.put((byte)1);
            if (searchJobValue._cachedId == null) {
              break label900;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchJobValue._cachedId);
            searchJobValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchJobJserpValue) {
              break label960;
            }
            localByteBuffer.put((byte)1);
            if (searchJobJserpValue._cachedId == null) {
              break label935;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchJobJserpValue._cachedId);
            searchJobJserpValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchCompanyValue) {
              break label995;
            }
            localByteBuffer.put((byte)1);
            if (searchCompanyValue._cachedId == null) {
              break label970;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchCompanyValue._cachedId);
            searchCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchSchoolValue) {
              break label1030;
            }
            localByteBuffer.put((byte)1);
            if (searchSchoolValue._cachedId == null) {
              break label1005;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchSchoolValue._cachedId);
            searchSchoolValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchGroupValue) {
              break label1065;
            }
            localByteBuffer.put((byte)1);
            if (searchGroupValue._cachedId == null) {
              break label1040;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchGroupValue._cachedId);
            searchGroupValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchArticleValue) {
              break label1100;
            }
            localByteBuffer.put((byte)1);
            if (searchArticleValue._cachedId == null) {
              break label1075;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchArticleValue._cachedId);
            searchArticleValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSecondaryResultContainerValue) {
              break label1135;
            }
            localByteBuffer.put((byte)1);
            if (secondaryResultContainerValue._cachedId == null) {
              break label1110;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, secondaryResultContainerValue._cachedId);
            secondaryResultContainerValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasFacetSuggestionValue) {
              break label1170;
            }
            localByteBuffer.put((byte)1);
            if (facetSuggestionValue._cachedId == null) {
              break label1145;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, facetSuggestionValue._cachedId);
            facetSuggestionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPaywallValue) {
              break label1205;
            }
            localByteBuffer.put((byte)1);
            if (paywallValue._cachedId == null) {
              break label1180;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, paywallValue._cachedId);
            paywallValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasUpdateValue) {
              break label1240;
            }
            localByteBuffer.put((byte)1);
            if (updateValue._cachedId == null) {
              break label1215;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, updateValue._cachedId);
            updateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasBlurredHitValue) {
              break label1275;
            }
            localByteBuffer.put((byte)1);
            if (blurredHitValue._cachedId == null) {
              break label1250;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, blurredHitValue._cachedId);
            blurredHitValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label1283;
          }
          if (str != null) {
            break label1285;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          searchProfileValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          searchJobValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label232;
          localByteBuffer.put((byte)0);
          break label232;
          localByteBuffer.put((byte)1);
          searchJobJserpValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label292;
          localByteBuffer.put((byte)0);
          break label292;
          localByteBuffer.put((byte)1);
          searchCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label352;
          localByteBuffer.put((byte)0);
          break label352;
          localByteBuffer.put((byte)1);
          searchSchoolValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label412;
          localByteBuffer.put((byte)0);
          break label412;
          localByteBuffer.put((byte)1);
          searchGroupValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label472;
          localByteBuffer.put((byte)0);
          break label472;
          localByteBuffer.put((byte)1);
          searchArticleValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label532;
          localByteBuffer.put((byte)0);
          break label532;
          localByteBuffer.put((byte)1);
          secondaryResultContainerValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label592;
          localByteBuffer.put((byte)0);
          break label592;
          localByteBuffer.put((byte)1);
          facetSuggestionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label652;
          localByteBuffer.put((byte)0);
          break label652;
          localByteBuffer.put((byte)1);
          paywallValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label712;
          localByteBuffer.put((byte)0);
          break label712;
          localByteBuffer.put((byte)1);
          updateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label772;
          localByteBuffer.put((byte)0);
          break label772;
          localByteBuffer.put((byte)1);
          blurredHitValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHit.HitInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */