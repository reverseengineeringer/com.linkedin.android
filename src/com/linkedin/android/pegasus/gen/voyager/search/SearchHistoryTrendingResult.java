package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchHistoryTrendingResult
  implements FissileDataModel<SearchHistoryTrendingResult>, RecordTemplate<SearchHistoryTrendingResult>
{
  public static final SearchHistoryTrendingResultBuilder BUILDER = SearchHistoryTrendingResultBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AttributedText context;
  public final ContextEntity contextEntity;
  public final boolean hasContext;
  public final boolean hasContextEntity;
  public final boolean hasResult;
  public final Result result;
  
  SearchHistoryTrendingResult(AttributedText paramAttributedText, ContextEntity paramContextEntity, Result paramResult, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    context = paramAttributedText;
    contextEntity = paramContextEntity;
    result = paramResult;
    hasContext = paramBoolean1;
    hasContextEntity = paramBoolean2;
    hasResult = paramBoolean3;
    _cachedId = null;
  }
  
  public final SearchHistoryTrendingResult accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasContext)
    {
      paramDataProcessor.startRecordField$505cff1c("context");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = context.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label216;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasContextEntity)
      {
        paramDataProcessor.startRecordField$505cff1c("contextEntity");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label225;
        }
        localObject1 = contextEntity.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label243;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label106:
      localObject1 = null;
      bool3 = false;
      if (hasResult)
      {
        paramDataProcessor.startRecordField$505cff1c("result");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label252;
        }
        localObject1 = result.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label270;
        }
      }
    }
    label216:
    label225:
    label243:
    label252:
    label270:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label313;
      }
      try
      {
        if (hasContext) {
          break label276;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryTrendingResult", "context");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(context);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (ContextEntity)paramDataProcessor.processDataTemplate(contextEntity);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (Result)paramDataProcessor.processDataTemplate(result);
      break label146;
    }
    label276:
    if (!hasResult) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryTrendingResult", "result");
    }
    return new SearchHistoryTrendingResult((AttributedText)localObject2, (ContextEntity)localObject3, (Result)localObject1, bool1, bool2, bool3);
    label313:
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
      paramObject = (SearchHistoryTrendingResult)paramObject;
      if (context != null)
      {
        if (context.equals(context)) {}
      }
      else {
        while (context != null) {
          return false;
        }
      }
      if (contextEntity != null)
      {
        if (contextEntity.equals(contextEntity)) {}
      }
      else {
        while (contextEntity != null) {
          return false;
        }
      }
      if (result == null) {
        break;
      }
    } while (result.equals(result));
    for (;;)
    {
      return false;
      if (result == null) {
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
    if (hasContext)
    {
      if (context._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(context._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasContextEntity)
      {
        i = j + 1;
        if (contextEntity._cachedId == null) {
          break label156;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(contextEntity._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasResult)
      {
        i = j + 1;
        if (result._cachedId == null) {
          break label169;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(result._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = context.getSerializedSize() + 7;
      break;
      label156:
      i += contextEntity.getSerializedSize();
      break label93;
      label169:
      i += result.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (context != null)
    {
      i = context.hashCode();
      if (contextEntity == null) {
        break label87;
      }
    }
    label87:
    for (int j = contextEntity.hashCode();; j = 0)
    {
      if (result != null) {
        k = result.hashCode();
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchHistoryTrendingResult");
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
    label358:
    label383:
    label393:
    label418:
    label426:
    label428:
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
        localByteBuffer.putInt(-2144144418);
        if (hasContext)
        {
          localByteBuffer.put((byte)1);
          if (context._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, context._cachedId);
            context.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasContextEntity) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            if (contextEntity._cachedId == null) {
              break label358;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, contextEntity._cachedId);
            contextEntity.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasResult) {
              break label418;
            }
            localByteBuffer.put((byte)1);
            if (result._cachedId == null) {
              break label393;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, result._cachedId);
            result.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label426;
          }
          if (str != null) {
            break label428;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          context.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          contextEntity.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          result.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class ContextEntity
    implements FissileDataModel<ContextEntity>, UnionTemplate<ContextEntity>
  {
    public static final SearchHistoryTrendingResultBuilder.ContextEntityBuilder BUILDER = SearchHistoryTrendingResultBuilder.ContextEntityBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasMiniCompanyUrnValue;
    public final Urn miniCompanyUrnValue;
    
    ContextEntity(Urn paramUrn, boolean paramBoolean)
    {
      miniCompanyUrnValue = paramUrn;
      hasMiniCompanyUrnValue = paramBoolean;
      _cachedId = null;
    }
    
    public final ContextEntity accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      if (hasMiniCompanyUrnValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("string");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(miniCompanyUrnValue));
      }
      paramDataProcessor.endUnion();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        return new ContextEntity(miniCompanyUrnValue, hasMiniCompanyUrnValue);
      }
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
        paramObject = (ContextEntity)paramObject;
        if (miniCompanyUrnValue == null) {
          break;
        }
      } while (miniCompanyUrnValue.equals(miniCompanyUrnValue));
      for (;;)
      {
        return false;
        if (miniCompanyUrnValue == null) {
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
      if (hasMiniCompanyUrnValue)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(miniCompanyUrnValue)) + 8;
      }
      __sizeOfObject = i;
      return i;
    }
    
    public final int hashCode()
    {
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (miniCompanyUrnValue != null) {}
      for (int i = miniCompanyUrnValue.hashCode();; i = 0)
      {
        i += 527;
        _cachedHashCode = i;
        return i;
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ContextEntity");
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
      label187:
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
          localByteBuffer.putInt(-17675516);
          if (hasMiniCompanyUrnValue)
          {
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(miniCompanyUrnValue));
          }
          while (paramByteBuffer == null)
          {
            if (str != null) {
              break label187;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
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
  
  public static final class Result
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
    
    Result(SearchHistoryProfile paramSearchHistoryProfile, SearchHistoryJob paramSearchHistoryJob, SearchHistoryCompany paramSearchHistoryCompany, SearchHistoryGroup paramSearchHistoryGroup, SearchHistorySchool paramSearchHistorySchool, SearchHistoryArticle paramSearchHistoryArticle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryTrendingResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */