package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchHistoryTrendingResult$Result
  implements FissileDataModel<Result>, UnionTemplate<Result>
{
  public static final SearchHistoryTrendingResultBuilder.ResultBuilder BUILDER = SearchHistoryTrendingResultBuilder.ResultBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasSearchHistoryArticleValue;
  public final boolean hasSearchHistoryCompanyValue;
  public final boolean hasSearchHistoryGroupValue;
  public final boolean hasSearchHistoryJobValue;
  public final boolean hasSearchHistoryProfileValue;
  public final boolean hasSearchHistorySchoolValue;
  public final SearchHistoryArticle searchHistoryArticleValue;
  public final SearchHistoryCompany searchHistoryCompanyValue;
  public final SearchHistoryGroup searchHistoryGroupValue;
  public final SearchHistoryJob searchHistoryJobValue;
  public final SearchHistoryProfile searchHistoryProfileValue;
  public final SearchHistorySchool searchHistorySchoolValue;
  
  SearchHistoryTrendingResult$Result(SearchHistoryProfile paramSearchHistoryProfile, SearchHistoryJob paramSearchHistoryJob, SearchHistoryCompany paramSearchHistoryCompany, SearchHistoryGroup paramSearchHistoryGroup, SearchHistorySchool paramSearchHistorySchool, SearchHistoryArticle paramSearchHistoryArticle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    searchHistoryProfileValue = paramSearchHistoryProfile;
    searchHistoryJobValue = paramSearchHistoryJob;
    searchHistoryCompanyValue = paramSearchHistoryCompany;
    searchHistoryGroupValue = paramSearchHistoryGroup;
    searchHistorySchoolValue = paramSearchHistorySchool;
    searchHistoryArticleValue = paramSearchHistoryArticle;
    hasSearchHistoryProfileValue = paramBoolean1;
    hasSearchHistoryJobValue = paramBoolean2;
    hasSearchHistoryCompanyValue = paramBoolean3;
    hasSearchHistoryGroupValue = paramBoolean4;
    hasSearchHistorySchoolValue = paramBoolean5;
    hasSearchHistoryArticleValue = paramBoolean6;
    _cachedId = null;
  }
  
  public final Result accept(DataProcessor paramDataProcessor)
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
    if (hasSearchHistoryProfileValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchHistoryProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = searchHistoryProfileValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label373;
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
          break label382;
        }
        localObject1 = searchHistoryJobValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label400;
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
          break label409;
        }
        localObject1 = searchHistoryCompanyValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label427;
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
          break label437;
        }
        localObject1 = searchHistoryGroupValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label455;
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
          break label465;
        }
        localObject1 = searchHistorySchoolValue.accept(paramDataProcessor);
        label250:
        if (localObject1 == null) {
          break label483;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      label262:
      localObject1 = null;
      bool6 = false;
      if (hasSearchHistoryArticleValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.SearchHistoryArticle");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label493;
        }
        localObject1 = searchHistoryArticleValue.accept(paramDataProcessor);
        label302:
        if (localObject1 == null) {
          break label511;
        }
      }
    }
    label373:
    label382:
    label400:
    label409:
    label427:
    label437:
    label455:
    label465:
    label483:
    label493:
    label511:
    for (boolean bool6 = true;; bool6 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label517;
      }
      return new Result((SearchHistoryProfile)localObject2, (SearchHistoryJob)localObject3, (SearchHistoryCompany)localObject4, (SearchHistoryGroup)localObject5, (SearchHistorySchool)localObject6, (SearchHistoryArticle)localObject1, bool1, bool2, bool3, bool4, bool5, bool6);
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
      localObject1 = (SearchHistoryArticle)paramDataProcessor.processDataTemplate(searchHistoryArticleValue);
      break label302;
    }
    label517:
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
      paramObject = (Result)paramObject;
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
      if (searchHistoryArticleValue == null) {
        break;
      }
    } while (searchHistoryArticleValue.equals(searchHistoryArticleValue));
    for (;;)
    {
      return false;
      if (searchHistoryArticleValue == null) {
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
          break label282;
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
          break label295;
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
          break label308;
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
          break label321;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchHistorySchoolValue._cachedId);
      }
      label219:
      j = i + 1;
      i = j;
      if (hasSearchHistoryArticleValue)
      {
        i = j + 1;
        if (searchHistoryArticleValue._cachedId == null) {
          break label334;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchHistoryArticleValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = searchHistoryProfileValue.getSerializedSize() + 7;
      break;
      label282:
      i += searchHistoryJobValue.getSerializedSize();
      break label93;
      label295:
      i += searchHistoryCompanyValue.getSerializedSize();
      break label135;
      label308:
      i += searchHistoryGroupValue.getSerializedSize();
      break label177;
      label321:
      i += searchHistorySchoolValue.getSerializedSize();
      break label219;
      label334:
      i += searchHistoryArticleValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (searchHistoryProfileValue != null)
    {
      i = searchHistoryProfileValue.hashCode();
      if (searchHistoryJobValue == null) {
        break label154;
      }
      j = searchHistoryJobValue.hashCode();
      if (searchHistoryCompanyValue == null) {
        break label159;
      }
      k = searchHistoryCompanyValue.hashCode();
      if (searchHistoryGroupValue == null) {
        break label164;
      }
      m = searchHistoryGroupValue.hashCode();
      label76:
      if (searchHistorySchoolValue == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = searchHistorySchoolValue.hashCode();; n = 0)
    {
      if (searchHistoryArticleValue != null) {
        i1 = searchHistoryArticleValue.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Result");
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
    label538:
    label563:
    label573:
    label598:
    label608:
    label633:
    label643:
    label668:
    label678:
    label703:
    label711:
    label713:
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
        localByteBuffer.putInt(996519568);
        if (hasSearchHistoryProfileValue)
        {
          localByteBuffer.put((byte)1);
          if (searchHistoryProfileValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchHistoryProfileValue._cachedId);
            searchHistoryProfileValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchHistoryJobValue) {
              break label563;
            }
            localByteBuffer.put((byte)1);
            if (searchHistoryJobValue._cachedId == null) {
              break label538;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchHistoryJobValue._cachedId);
            searchHistoryJobValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchHistoryCompanyValue) {
              break label598;
            }
            localByteBuffer.put((byte)1);
            if (searchHistoryCompanyValue._cachedId == null) {
              break label573;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchHistoryCompanyValue._cachedId);
            searchHistoryCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchHistoryGroupValue) {
              break label633;
            }
            localByteBuffer.put((byte)1);
            if (searchHistoryGroupValue._cachedId == null) {
              break label608;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchHistoryGroupValue._cachedId);
            searchHistoryGroupValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchHistorySchoolValue) {
              break label668;
            }
            localByteBuffer.put((byte)1);
            if (searchHistorySchoolValue._cachedId == null) {
              break label643;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchHistorySchoolValue._cachedId);
            searchHistorySchoolValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSearchHistoryArticleValue) {
              break label703;
            }
            localByteBuffer.put((byte)1);
            if (searchHistoryArticleValue._cachedId == null) {
              break label678;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, searchHistoryArticleValue._cachedId);
            searchHistoryArticleValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label711;
          }
          if (str != null) {
            break label713;
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
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          searchHistoryCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          searchHistoryGroupValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label350;
          localByteBuffer.put((byte)0);
          break label350;
          localByteBuffer.put((byte)1);
          searchHistorySchoolValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label410;
          localByteBuffer.put((byte)0);
          break label410;
          localByteBuffer.put((byte)1);
          searchHistoryArticleValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryTrendingResult.Result
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */