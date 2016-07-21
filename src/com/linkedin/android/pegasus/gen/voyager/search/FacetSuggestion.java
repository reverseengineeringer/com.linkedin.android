package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FacetSuggestion
  implements FissileDataModel<FacetSuggestion>, RecordTemplate<FacetSuggestion>
{
  public static final FacetSuggestionBuilder BUILDER = FacetSuggestionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String facetParameterName;
  public final SearchFacetType facetType;
  public final SearchFacetTypeV2 facetTypeV2;
  public final boolean hasFacetParameterName;
  public final boolean hasFacetType;
  public final boolean hasFacetTypeV2;
  public final boolean hasSuggestedText;
  public final boolean hasSuggestedValues;
  public final AnnotatedText suggestedText;
  public final List<FacetValue> suggestedValues;
  
  FacetSuggestion(String paramString, SearchFacetType paramSearchFacetType, SearchFacetTypeV2 paramSearchFacetTypeV2, AnnotatedText paramAnnotatedText, List<FacetValue> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    facetParameterName = paramString;
    facetType = paramSearchFacetType;
    facetTypeV2 = paramSearchFacetTypeV2;
    suggestedText = paramAnnotatedText;
    if (paramList == null) {}
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList))
    {
      suggestedValues = paramString;
      hasFacetParameterName = paramBoolean1;
      hasFacetType = paramBoolean2;
      hasFacetTypeV2 = paramBoolean3;
      hasSuggestedText = paramBoolean4;
      hasSuggestedValues = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  public final FacetSuggestion accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasFacetParameterName)
    {
      paramDataProcessor.startRecordField$505cff1c("facetParameterName");
      paramDataProcessor.processString(facetParameterName);
    }
    if (hasFacetType)
    {
      paramDataProcessor.startRecordField$505cff1c("facetType");
      paramDataProcessor.processEnum(facetType);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label106:
    Object localObject3;
    boolean bool2;
    label146:
    label158:
    int i;
    if (hasFacetTypeV2)
    {
      paramDataProcessor.startRecordField$505cff1c("facetTypeV2");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = facetTypeV2.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label324;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasSuggestedText)
      {
        paramDataProcessor.startRecordField$505cff1c("suggestedText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label333;
        }
        localObject1 = suggestedText.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label351;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject1 = null;
      localFacetValue = null;
      bool3 = false;
      if (!hasSuggestedValues) {
        break label391;
      }
      paramDataProcessor.startRecordField$505cff1c("suggestedValues");
      suggestedValues.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localFacetValue;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = suggestedValues.iterator();
      label233:
      if (!localIterator.hasNext()) {
        break label377;
      }
      localFacetValue = (FacetValue)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label361;
      }
    }
    label324:
    label333:
    label351:
    label361:
    for (FacetValue localFacetValue = localFacetValue.accept(paramDataProcessor);; localFacetValue = (FacetValue)paramDataProcessor.processDataTemplate(localFacetValue))
    {
      if ((localObject1 != null) && (localFacetValue != null)) {
        ((List)localObject1).add(localFacetValue);
      }
      i += 1;
      break label233;
      localObject1 = (SearchFacetTypeV2)paramDataProcessor.processDataTemplate(facetTypeV2);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label106;
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(suggestedText);
      break label146;
      bool2 = false;
      localObject3 = localObject1;
      break label158;
    }
    label377:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      label391:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label564;
      }
      try
      {
        if (hasFacetParameterName) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.FacetSuggestion", "facetParameterName");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasSuggestedText) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.FacetSuggestion", "suggestedText");
    }
    if (!hasSuggestedValues) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.FacetSuggestion", "suggestedValues");
    }
    if (suggestedValues != null)
    {
      paramDataProcessor = suggestedValues.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((FacetValue)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.search.FacetSuggestion", "suggestedValues");
        }
      }
    }
    return new FacetSuggestion(facetParameterName, facetType, (SearchFacetTypeV2)localObject2, (AnnotatedText)localObject3, (List)localObject1, hasFacetParameterName, hasFacetType, bool1, bool2, bool3);
    label564:
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (FacetSuggestion)paramObject;
      if (facetParameterName != null)
      {
        if (facetParameterName.equals(facetParameterName)) {}
      }
      else {
        while (facetParameterName != null) {
          return false;
        }
      }
      if (facetType != null)
      {
        if (facetType.equals(facetType)) {}
      }
      else {
        while (facetType != null) {
          return false;
        }
      }
      if (facetTypeV2 != null)
      {
        if (facetTypeV2.equals(facetTypeV2)) {}
      }
      else {
        while (facetTypeV2 != null) {
          return false;
        }
      }
      if (suggestedText != null)
      {
        if (suggestedText.equals(suggestedText)) {}
      }
      else {
        while (suggestedText != null) {
          return false;
        }
      }
      if (suggestedValues == null) {
        break;
      }
    } while (suggestedValues.equals(suggestedValues));
    for (;;)
    {
      return false;
      if (suggestedValues == null) {
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
    if (hasFacetParameterName) {
      i = PegasusBinaryUtils.getEncodedLength(facetParameterName) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasFacetType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    label139:
    Iterator localIterator;
    if (hasFacetTypeV2)
    {
      i = j + 1;
      if (facetTypeV2._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(facetTypeV2._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasSuggestedText)
      {
        i = j + 1;
        if (suggestedText._cachedId == null) {
          break label229;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(suggestedText._cachedId);
      }
      i += 1;
      j = i;
      if (!hasSuggestedValues) {
        break label253;
      }
      i += 2;
      localIterator = suggestedValues.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label253;
      }
      FacetValue localFacetValue = (FacetValue)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += facetTypeV2.getSerializedSize();
        break;
        label229:
        i += suggestedText.getSerializedSize();
        break label139;
      }
      i += localFacetValue.getSerializedSize();
    }
    label253:
    __sizeOfObject = j;
    return j;
  }
  
  public int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (facetParameterName != null)
    {
      i = facetParameterName.hashCode();
      if (facetType == null) {
        break label134;
      }
      j = facetType.hashCode();
      if (facetTypeV2 == null) {
        break label139;
      }
      k = facetTypeV2.hashCode();
      label60:
      if (suggestedText == null) {
        break label144;
      }
    }
    label134:
    label139:
    label144:
    for (int m = suggestedText.hashCode();; m = 0)
    {
      if (suggestedValues != null) {
        n = suggestedValues.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building FacetSuggestion");
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
    label166:
    label226:
    label286:
    label403:
    label413:
    label438:
    label448:
    label473:
    label506:
    label513:
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-1161593615);
        Iterator localIterator;
        if (hasFacetParameterName)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, facetParameterName);
          if (!hasFacetType) {
            break label403;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, facetType.ordinal());
          if (!hasFacetTypeV2) {
            break label438;
          }
          localByteBuffer.put((byte)1);
          if (facetTypeV2._cachedId == null) {
            break label413;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, facetTypeV2._cachedId);
          facetTypeV2.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSuggestedText) {
            break label473;
          }
          localByteBuffer.put((byte)1);
          if (suggestedText._cachedId == null) {
            break label448;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, suggestedText._cachedId);
          suggestedText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSuggestedValues) {
            break label506;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, suggestedValues.size());
          localIterator = suggestedValues.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label513;
          }
          FacetValue localFacetValue = (FacetValue)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localFacetValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label166;
            localByteBuffer.put((byte)1);
            facetTypeV2.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label226;
            localByteBuffer.put((byte)0);
            break label226;
            localByteBuffer.put((byte)1);
            suggestedText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label286;
            localByteBuffer.put((byte)0);
            break label286;
          }
          localByteBuffer.put((byte)1);
          localFacetValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.FacetSuggestion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */