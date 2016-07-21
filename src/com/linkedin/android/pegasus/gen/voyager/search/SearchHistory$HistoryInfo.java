package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionMemberCountException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchHistory$HistoryInfo
  implements FissileDataModel<HistoryInfo>, UnionTemplate<HistoryInfo>
{
  public static final SearchHistoryBuilder.HistoryInfoBuilder BUILDER = SearchHistoryBuilder.HistoryInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final EntityAwareSearchQuery entityAwareSearchQueryValue;
  public final boolean hasEntityAwareSearchQueryValue;
  public final boolean hasSearchHistoryCompanyValue;
  public final boolean hasSearchHistoryGroupValue;
  public final boolean hasSearchHistoryJobValue;
  public final boolean hasSearchHistoryProfileValue;
  public final boolean hasSearchHistorySchoolValue;
  public final boolean hasSearchHistoryTrendingResultContainerValue;
  public final boolean hasSearchQueryValue;
  public final SearchHistoryCompany searchHistoryCompanyValue;
  public final SearchHistoryGroup searchHistoryGroupValue;
  public final SearchHistoryJob searchHistoryJobValue;
  public final SearchHistoryProfile searchHistoryProfileValue;
  public final SearchHistorySchool searchHistorySchoolValue;
  public final SearchHistoryTrendingResultContainer searchHistoryTrendingResultContainerValue;
  public final SearchQuery searchQueryValue;
  
  SearchHistory$HistoryInfo(SearchHistoryProfile paramSearchHistoryProfile, SearchHistoryJob paramSearchHistoryJob, SearchHistoryCompany paramSearchHistoryCompany, SearchHistoryGroup paramSearchHistoryGroup, SearchHistorySchool paramSearchHistorySchool, SearchQuery paramSearchQuery, EntityAwareSearchQuery paramEntityAwareSearchQuery, SearchHistoryTrendingResultContainer paramSearchHistoryTrendingResultContainer, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    searchHistoryProfileValue = paramSearchHistoryProfile;
    searchHistoryJobValue = paramSearchHistoryJob;
    searchHistoryCompanyValue = paramSearchHistoryCompany;
    searchHistoryGroupValue = paramSearchHistoryGroup;
    searchHistorySchoolValue = paramSearchHistorySchool;
    searchQueryValue = paramSearchQuery;
    entityAwareSearchQueryValue = paramEntityAwareSearchQuery;
    searchHistoryTrendingResultContainerValue = paramSearchHistoryTrendingResultContainer;
    hasSearchHistoryProfileValue = paramBoolean1;
    hasSearchHistoryJobValue = paramBoolean2;
    hasSearchHistoryCompanyValue = paramBoolean3;
    hasSearchHistoryGroupValue = paramBoolean4;
    hasSearchHistorySchoolValue = paramBoolean5;
    hasSearchQueryValue = paramBoolean6;
    hasEntityAwareSearchQueryValue = paramBoolean7;
    hasSearchHistoryTrendingResultContainerValue = paramBoolean8;
    _cachedId = null;
  }
  
  public final HistoryInfo accept(DataProcessor paramDataProcessor)
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
    if (hasSearchHistoryProfileValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchHistoryProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = searchHistoryProfileValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label485;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasSearchHistoryJobValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchHistoryJob");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label494;
        }
        localObject1 = searchHistoryJobValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label512;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasSearchHistoryCompanyValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchHistoryCompany");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label521;
        }
        localObject1 = searchHistoryCompanyValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label539;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasSearchHistoryGroupValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchHistoryGroup");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label549;
        }
        localObject1 = searchHistoryGroupValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label567;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      localObject6 = null;
      bool5 = false;
      if (hasSearchHistorySchoolValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchHistorySchool");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label577;
        }
        localObject1 = searchHistorySchoolValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label595;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      localObject7 = null;
      bool6 = false;
      if (hasSearchQueryValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchQuery");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label605;
        }
        localObject1 = searchQueryValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label623;
        }
        bool6 = true;
        localObject7 = localObject1;
      }
      localObject8 = null;
      bool7 = false;
      if (hasEntityAwareSearchQueryValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.EntityAwareSearchQuery");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label633;
        }
        localObject1 = entityAwareSearchQueryValue.accept(paramDataProcessor);
        label354:
        if (localObject1 == null) {
          break label651;
        }
        bool7 = true;
        localObject8 = localObject1;
      }
      label366:
      localObject1 = null;
      bool8 = false;
      if (hasSearchHistoryTrendingResultContainerValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchHistoryTrendingResultContainer");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label661;
        }
        localObject1 = searchHistoryTrendingResultContainerValue.accept(paramDataProcessor);
        label406:
        if (localObject1 == null) {
          break label679;
        }
      }
    }
    label485:
    label494:
    label512:
    label521:
    label539:
    label549:
    label567:
    label577:
    label595:
    label605:
    label623:
    label633:
    label651:
    label661:
    label679:
    for (boolean bool8 = true;; bool8 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label685;
      }
      return new HistoryInfo((SearchHistoryProfile)localObject2, (SearchHistoryJob)localObject3, (SearchHistoryCompany)localObject4, (SearchHistoryGroup)localObject5, (SearchHistorySchool)localObject6, (SearchQuery)localObject7, (EntityAwareSearchQuery)localObject8, (SearchHistoryTrendingResultContainer)localObject1, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8);
      localObject1 = (SearchHistoryProfile)paramDataProcessor.processDataTemplate(searchHistoryProfileValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (SearchHistoryJob)paramDataProcessor.processDataTemplate(searchHistoryJobValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (SearchHistoryCompany)paramDataProcessor.processDataTemplate(searchHistoryCompanyValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (SearchHistoryGroup)paramDataProcessor.processDataTemplate(searchHistoryGroupValue);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (SearchHistorySchool)paramDataProcessor.processDataTemplate(searchHistorySchoolValue);
      break label250;
      bool5 = false;
      localObject6 = localObject1;
      break label262;
      localObject1 = (SearchQuery)paramDataProcessor.processDataTemplate(searchQueryValue);
      break label302;
      bool6 = false;
      localObject7 = localObject1;
      break label314;
      localObject1 = (EntityAwareSearchQuery)paramDataProcessor.processDataTemplate(entityAwareSearchQueryValue);
      break label354;
      bool7 = false;
      localObject8 = localObject1;
      break label366;
      localObject1 = (SearchHistoryTrendingResultContainer)paramDataProcessor.processDataTemplate(searchHistoryTrendingResultContainerValue);
      break label406;
    }
    label685:
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
      paramObject = (HistoryInfo)paramObject;
      if (searchHistoryProfileValue != null)
      {
        if (searchHistoryProfileValue.equals(searchHistoryProfileValue)) {}
      }
      else {
        while (searchHistoryProfileValue != null) {
          return false;
        }
      }
      if (searchHistoryJobValue != null)
      {
        if (searchHistoryJobValue.equals(searchHistoryJobValue)) {}
      }
      else {
        while (searchHistoryJobValue != null) {
          return false;
        }
      }
      if (searchHistoryCompanyValue != null)
      {
        if (searchHistoryCompanyValue.equals(searchHistoryCompanyValue)) {}
      }
      else {
        while (searchHistoryCompanyValue != null) {
          return false;
        }
      }
      if (searchHistoryGroupValue != null)
      {
        if (searchHistoryGroupValue.equals(searchHistoryGroupValue)) {}
      }
      else {
        while (searchHistoryGroupValue != null) {
          return false;
        }
      }
      if (searchHistorySchoolValue != null)
      {
        if (searchHistorySchoolValue.equals(searchHistorySchoolValue)) {}
      }
      else {
        while (searchHistorySchoolValue != null) {
          return false;
        }
      }
      if (searchQueryValue != null)
      {
        if (searchQueryValue.equals(searchQueryValue)) {}
      }
      else {
        while (searchQueryValue != null) {
          return false;
        }
      }
      if (entityAwareSearchQueryValue != null)
      {
        if (entityAwareSearchQueryValue.equals(entityAwareSearchQueryValue)) {}
      }
      else {
        while (entityAwareSearchQueryValue != null) {
          return false;
        }
      }
      if (searchHistoryTrendingResultContainerValue == null) {
        break;
      }
    } while (searchHistoryTrendingResultContainerValue.equals(searchHistoryTrendingResultContainerValue));
    for (;;)
    {
      return false;
      if (searchHistoryTrendingResultContainerValue == null) {
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
    if (hasSearchHistoryProfileValue)
    {
      if (searchHistoryProfileValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(searchHistoryProfileValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasSearchHistoryJobValue)
      {
        i = j + 1;
        if (searchHistoryJobValue._cachedId == null) {
          break label366;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchHistoryJobValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasSearchHistoryCompanyValue)
      {
        i = j + 1;
        if (searchHistoryCompanyValue._cachedId == null) {
          break label379;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchHistoryCompanyValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasSearchHistoryGroupValue)
      {
        i = j + 1;
        if (searchHistoryGroupValue._cachedId == null) {
          break label392;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchHistoryGroupValue._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasSearchHistorySchoolValue)
      {
        i = j + 1;
        if (searchHistorySchoolValue._cachedId == null) {
          break label405;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchHistorySchoolValue._cachedId);
      }
      label219:
      j = i + 1;
      i = j;
      if (hasSearchQueryValue)
      {
        i = j + 1;
        if (searchQueryValue._cachedId == null) {
          break label418;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchQueryValue._cachedId);
      }
      label261:
      j = i + 1;
      i = j;
      if (hasEntityAwareSearchQueryValue)
      {
        i = j + 1;
        if (entityAwareSearchQueryValue._cachedId == null) {
          break label431;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(entityAwareSearchQueryValue._cachedId);
      }
      label303:
      j = i + 1;
      i = j;
      if (hasSearchHistoryTrendingResultContainerValue)
      {
        i = j + 1;
        if (searchHistoryTrendingResultContainerValue._cachedId == null) {
          break label444;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchHistoryTrendingResultContainerValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = searchHistoryProfileValue.getSerializedSize() + 7;
      break;
      label366:
      i += searchHistoryJobValue.getSerializedSize();
      break label93;
      label379:
      i += searchHistoryCompanyValue.getSerializedSize();
      break label135;
      label392:
      i += searchHistoryGroupValue.getSerializedSize();
      break label177;
      label405:
      i += searchHistorySchoolValue.getSerializedSize();
      break label219;
      label418:
      i += searchQueryValue.getSerializedSize();
      break label261;
      label431:
      i += entityAwareSearchQueryValue.getSerializedSize();
      break label303;
      label444:
      i += searchHistoryTrendingResultContainerValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i3 = 0;
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
    if (searchHistoryProfileValue != null)
    {
      i = searchHistoryProfileValue.hashCode();
      if (searchHistoryJobValue == null) {
        break label198;
      }
      j = searchHistoryJobValue.hashCode();
      if (searchHistoryCompanyValue == null) {
        break label203;
      }
      k = searchHistoryCompanyValue.hashCode();
      if (searchHistoryGroupValue == null) {
        break label208;
      }
      m = searchHistoryGroupValue.hashCode();
      if (searchHistorySchoolValue == null) {
        break label214;
      }
      n = searchHistorySchoolValue.hashCode();
      if (searchQueryValue == null) {
        break label220;
      }
      i1 = searchQueryValue.hashCode();
      label108:
      if (entityAwareSearchQueryValue == null) {
        break label226;
      }
    }
    label198:
    label203:
    label208:
    label214:
    label220:
    label226:
    for (int i2 = entityAwareSearchQueryValue.hashCode();; i2 = 0)
    {
      if (searchHistoryTrendingResultContainerValue != null) {
        i3 = searchHistoryTrendingResultContainerValue.hashCode();
      }
      i = (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building HistoryInfo");
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
    label231:
    label291:
    label351:
    label411:
    label471:
    label531:
    label659:
    label684:
    label694:
    label719:
    label729:
    label754:
    label764:
    label789:
    label799:
    label824:
    label834:
    label859:
    label869:
    label894:
    label902:
    label904:
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
        localByteBuffer.putInt(1922954092);
        if (hasSearchHistoryProfileValue)
        {
          localByteBuffer.put((byte)1);
          if (searchHistoryProfileValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchHistoryProfileValue._cachedId);
            searchHistoryProfileValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchHistoryJobValue) {
              break label684;
            }
            localByteBuffer.put((byte)1);
            if (searchHistoryJobValue._cachedId == null) {
              break label659;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchHistoryJobValue._cachedId);
            searchHistoryJobValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchHistoryCompanyValue) {
              break label719;
            }
            localByteBuffer.put((byte)1);
            if (searchHistoryCompanyValue._cachedId == null) {
              break label694;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchHistoryCompanyValue._cachedId);
            searchHistoryCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchHistoryGroupValue) {
              break label754;
            }
            localByteBuffer.put((byte)1);
            if (searchHistoryGroupValue._cachedId == null) {
              break label729;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchHistoryGroupValue._cachedId);
            searchHistoryGroupValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchHistorySchoolValue) {
              break label789;
            }
            localByteBuffer.put((byte)1);
            if (searchHistorySchoolValue._cachedId == null) {
              break label764;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchHistorySchoolValue._cachedId);
            searchHistorySchoolValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchQueryValue) {
              break label824;
            }
            localByteBuffer.put((byte)1);
            if (searchQueryValue._cachedId == null) {
              break label799;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchQueryValue._cachedId);
            searchQueryValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasEntityAwareSearchQueryValue) {
              break label859;
            }
            localByteBuffer.put((byte)1);
            if (entityAwareSearchQueryValue._cachedId == null) {
              break label834;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, entityAwareSearchQueryValue._cachedId);
            entityAwareSearchQueryValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchHistoryTrendingResultContainerValue) {
              break label894;
            }
            localByteBuffer.put((byte)1);
            if (searchHistoryTrendingResultContainerValue._cachedId == null) {
              break label869;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchHistoryTrendingResultContainerValue._cachedId);
            searchHistoryTrendingResultContainerValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label902;
          }
          if (str != null) {
            break label904;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          searchHistoryProfileValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          searchHistoryJobValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label231;
          localByteBuffer.put((byte)0);
          break label231;
          localByteBuffer.put((byte)1);
          searchHistoryCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label291;
          localByteBuffer.put((byte)0);
          break label291;
          localByteBuffer.put((byte)1);
          searchHistoryGroupValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label351;
          localByteBuffer.put((byte)0);
          break label351;
          localByteBuffer.put((byte)1);
          searchHistorySchoolValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label411;
          localByteBuffer.put((byte)0);
          break label411;
          localByteBuffer.put((byte)1);
          searchQueryValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label471;
          localByteBuffer.put((byte)0);
          break label471;
          localByteBuffer.put((byte)1);
          entityAwareSearchQueryValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label531;
          localByteBuffer.put((byte)0);
          break label531;
          localByteBuffer.put((byte)1);
          searchHistoryTrendingResultContainerValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    public EntityAwareSearchQuery entityAwareSearchQueryValue = null;
    public boolean hasEntityAwareSearchQueryValue = false;
    private boolean hasSearchHistoryCompanyValue = false;
    private boolean hasSearchHistoryGroupValue = false;
    public boolean hasSearchHistoryJobValue = false;
    private boolean hasSearchHistoryProfileValue = false;
    private boolean hasSearchHistorySchoolValue = false;
    private boolean hasSearchHistoryTrendingResultContainerValue = false;
    public boolean hasSearchQueryValue = false;
    private SearchHistoryCompany searchHistoryCompanyValue = null;
    private SearchHistoryGroup searchHistoryGroupValue = null;
    public SearchHistoryJob searchHistoryJobValue = null;
    private SearchHistoryProfile searchHistoryProfileValue = null;
    private SearchHistorySchool searchHistorySchoolValue = null;
    private SearchHistoryTrendingResultContainer searchHistoryTrendingResultContainerValue = null;
    public SearchQuery searchQueryValue = null;
    
    public final SearchHistory.HistoryInfo build()
      throws BuilderException
    {
      int j = 0;
      if (hasSearchHistoryProfileValue) {
        j = 0 + 1;
      }
      int i = j;
      if (hasSearchHistoryJobValue) {
        i = j + 1;
      }
      j = i;
      if (hasSearchHistoryCompanyValue) {
        j = i + 1;
      }
      i = j;
      if (hasSearchHistoryGroupValue) {
        i = j + 1;
      }
      j = i;
      if (hasSearchHistorySchoolValue) {
        j = i + 1;
      }
      i = j;
      if (hasSearchQueryValue) {
        i = j + 1;
      }
      j = i;
      if (hasEntityAwareSearchQueryValue) {
        j = i + 1;
      }
      i = j;
      if (hasSearchHistoryTrendingResultContainerValue) {
        i = j + 1;
      }
      if (i > 1) {
        throw new UnionMemberCountException("HistoryInfo", i);
      }
      return new SearchHistory.HistoryInfo(searchHistoryProfileValue, searchHistoryJobValue, searchHistoryCompanyValue, searchHistoryGroupValue, searchHistorySchoolValue, searchQueryValue, entityAwareSearchQueryValue, searchHistoryTrendingResultContainerValue, hasSearchHistoryProfileValue, hasSearchHistoryJobValue, hasSearchHistoryCompanyValue, hasSearchHistoryGroupValue, hasSearchHistorySchoolValue, hasSearchQueryValue, hasEntityAwareSearchQueryValue, hasSearchHistoryTrendingResultContainerValue);
    }
    
    public final Builder setSearchHistoryCompanyValue(SearchHistoryCompany paramSearchHistoryCompany)
    {
      if (paramSearchHistoryCompany == null)
      {
        hasSearchHistoryCompanyValue = false;
        searchHistoryCompanyValue = null;
        return this;
      }
      hasSearchHistoryCompanyValue = true;
      searchHistoryCompanyValue = paramSearchHistoryCompany;
      return this;
    }
    
    public final Builder setSearchHistoryGroupValue(SearchHistoryGroup paramSearchHistoryGroup)
    {
      if (paramSearchHistoryGroup == null)
      {
        hasSearchHistoryGroupValue = false;
        searchHistoryGroupValue = null;
        return this;
      }
      hasSearchHistoryGroupValue = true;
      searchHistoryGroupValue = paramSearchHistoryGroup;
      return this;
    }
    
    public final Builder setSearchHistoryProfileValue(SearchHistoryProfile paramSearchHistoryProfile)
    {
      if (paramSearchHistoryProfile == null)
      {
        hasSearchHistoryProfileValue = false;
        searchHistoryProfileValue = null;
        return this;
      }
      hasSearchHistoryProfileValue = true;
      searchHistoryProfileValue = paramSearchHistoryProfile;
      return this;
    }
    
    public final Builder setSearchHistorySchoolValue(SearchHistorySchool paramSearchHistorySchool)
    {
      if (paramSearchHistorySchool == null)
      {
        hasSearchHistorySchoolValue = false;
        searchHistorySchoolValue = null;
        return this;
      }
      hasSearchHistorySchoolValue = true;
      searchHistorySchoolValue = paramSearchHistorySchool;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistory.HistoryInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */