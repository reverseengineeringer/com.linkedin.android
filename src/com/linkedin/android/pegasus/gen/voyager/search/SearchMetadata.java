package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.search.shared.SearchSpellingCorrection;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SearchMetadata
  implements FissileDataModel<SearchMetadata>, RecordTemplate<SearchMetadata>
{
  public static final SearchMetadataBuilder BUILDER = SearchMetadataBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final List<SearchFacet> facets;
  public final List<Guide> guides;
  public final boolean hasFacets;
  public final boolean hasGuides;
  public final boolean hasId;
  public final boolean hasKeywords;
  public final boolean hasLocation;
  public final boolean hasOrigin;
  public final boolean hasSpellCorrection;
  public final boolean hasType;
  public final boolean hasWarnings;
  public final String id;
  public final String keywords;
  public final String location;
  public final String origin;
  public final SearchSpellingCorrection spellCorrection;
  public final SearchType type;
  public final List<SearchWarning> warnings;
  
  SearchMetadata(String paramString1, SearchType paramSearchType, String paramString2, List<SearchWarning> paramList, String paramString3, String paramString4, List<Guide> paramList1, List<SearchFacet> paramList2, SearchSpellingCorrection paramSearchSpellingCorrection, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    id = paramString1;
    type = paramSearchType;
    origin = paramString2;
    if (paramList == null)
    {
      paramString1 = null;
      warnings = paramString1;
      keywords = paramString3;
      location = paramString4;
      if (paramList1 != null) {
        break label152;
      }
      paramString1 = null;
      label60:
      guides = paramString1;
      if (paramList2 != null) {
        break label161;
      }
    }
    label152:
    label161:
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList2))
    {
      facets = paramString1;
      spellCorrection = paramSearchSpellingCorrection;
      hasId = paramBoolean1;
      hasType = paramBoolean2;
      hasOrigin = paramBoolean3;
      hasWarnings = paramBoolean4;
      hasKeywords = paramBoolean5;
      hasLocation = paramBoolean6;
      hasGuides = paramBoolean7;
      hasFacets = paramBoolean8;
      hasSpellCorrection = paramBoolean9;
      _cachedId = null;
      return;
      paramString1 = Collections.unmodifiableList(paramList);
      break;
      paramString1 = Collections.unmodifiableList(paramList1);
      break label60;
    }
  }
  
  private SearchMetadata accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasId)
    {
      paramDataProcessor.startRecordField$505cff1c("id");
      paramDataProcessor.processString(id);
    }
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processEnum(type);
    }
    if (hasOrigin)
    {
      paramDataProcessor.startRecordField$505cff1c("origin");
      paramDataProcessor.processString(origin);
    }
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    int i;
    boolean bool2;
    if (hasWarnings)
    {
      paramDataProcessor.startRecordField$505cff1c("warnings");
      warnings.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject2 = warnings.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SearchWarning)((Iterator)localObject2).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processEnum((Enum)localObject3);
        if (localObject1 != null) {
          ((List)localObject1).add(localObject3);
        }
        i += 1;
      }
      paramDataProcessor.endArray();
      if (localObject1 != null) {
        bool1 = true;
      }
    }
    else
    {
      if (hasKeywords)
      {
        paramDataProcessor.startRecordField$505cff1c("keywords");
        paramDataProcessor.processString(keywords);
      }
      if (hasLocation)
      {
        paramDataProcessor.startRecordField$505cff1c("location");
        paramDataProcessor.processString(location);
      }
      localObject3 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasGuides) {
        break label460;
      }
      paramDataProcessor.startRecordField$505cff1c("guides");
      guides.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      localObject4 = guides.iterator();
      label348:
      if (!((Iterator)localObject4).hasNext()) {
        break label442;
      }
      localObject3 = (Guide)((Iterator)localObject4).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label426;
      }
    }
    label426:
    for (Object localObject3 = ((Guide)localObject3).accept(paramDataProcessor);; localObject3 = (Guide)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject2 != null) && (localObject3 != null)) {
        ((List)localObject2).add(localObject3);
      }
      i += 1;
      break label348;
      bool1 = false;
      break;
    }
    label442:
    paramDataProcessor.endArray();
    label460:
    boolean bool3;
    if (localObject2 != null)
    {
      bool2 = true;
      localObject3 = localObject2;
      localObject4 = null;
      localObject2 = null;
      bool3 = false;
      if (!hasFacets) {
        break label648;
      }
      paramDataProcessor.startRecordField$505cff1c("facets");
      facets.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = facets.iterator();
      label531:
      if (!localIterator.hasNext()) {
        break label630;
      }
      localObject4 = (SearchFacet)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label614;
      }
    }
    label614:
    for (Object localObject4 = ((SearchFacet)localObject4).accept(paramDataProcessor);; localObject4 = (SearchFacet)paramDataProcessor.processDataTemplate((DataTemplate)localObject4))
    {
      if ((localObject2 != null) && (localObject4 != null)) {
        ((List)localObject2).add(localObject4);
      }
      i += 1;
      break label531;
      bool2 = false;
      localObject3 = localObject2;
      break;
    }
    label630:
    paramDataProcessor.endArray();
    if (localObject2 != null)
    {
      bool3 = true;
      localObject4 = localObject2;
      label648:
      localObject2 = null;
      bool4 = false;
      if (hasSpellCorrection)
      {
        paramDataProcessor.startRecordField$505cff1c("spellCorrection");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label762;
        }
        localObject2 = spellCorrection.accept(paramDataProcessor);
        label688:
        if (localObject2 == null) {
          break label780;
        }
      }
    }
    label762:
    label780:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label999;
      }
      if (!hasWarnings) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasOrigin) {
          break label786;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchMetadata", "origin");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool3 = false;
      localObject4 = localObject2;
      break;
      localObject2 = (SearchSpellingCorrection)paramDataProcessor.processDataTemplate(spellCorrection);
      break label688;
    }
    label786:
    if (warnings != null)
    {
      paramDataProcessor = warnings.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SearchWarning)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.search.SearchMetadata", "warnings");
        }
      }
    }
    if (guides != null)
    {
      paramDataProcessor = guides.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Guide)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.search.SearchMetadata", "guides");
        }
      }
    }
    if (facets != null)
    {
      paramDataProcessor = facets.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SearchFacet)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.search.SearchMetadata", "facets");
        }
      }
    }
    return new SearchMetadata(id, type, origin, (List)localObject1, keywords, location, (List)localObject3, (List)localObject4, (SearchSpellingCorrection)localObject2, hasId, hasType, hasOrigin, bool1, hasKeywords, hasLocation, bool2, bool3, bool4);
    label999:
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
      paramObject = (SearchMetadata)paramObject;
      if (id != null)
      {
        if (id.equals(id)) {}
      }
      else {
        while (id != null) {
          return false;
        }
      }
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (origin != null)
      {
        if (origin.equals(origin)) {}
      }
      else {
        while (origin != null) {
          return false;
        }
      }
      if (warnings != null)
      {
        if (warnings.equals(warnings)) {}
      }
      else {
        while (warnings != null) {
          return false;
        }
      }
      if (keywords != null)
      {
        if (keywords.equals(keywords)) {}
      }
      else {
        while (keywords != null) {
          return false;
        }
      }
      if (location != null)
      {
        if (location.equals(location)) {}
      }
      else {
        while (location != null) {
          return false;
        }
      }
      if (guides != null)
      {
        if (guides.equals(guides)) {}
      }
      else {
        while (guides != null) {
          return false;
        }
      }
      if (facets != null)
      {
        if (facets.equals(facets)) {}
      }
      else {
        while (facets != null) {
          return false;
        }
      }
      if (spellCorrection == null) {
        break;
      }
    } while (spellCorrection.equals(spellCorrection));
    for (;;)
    {
      return false;
      if (spellCorrection == null) {
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
    if (hasId) {
      i = PegasusBinaryUtils.getEncodedLength(id) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasOrigin) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(origin);
    }
    i += 1;
    j = i;
    Iterator localIterator;
    if (hasWarnings)
    {
      i += 2;
      localIterator = warnings.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localIterator.next();
        i += 2;
      }
    }
    j += 1;
    i = j;
    if (hasKeywords) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(keywords);
    }
    j = i + 1;
    i = j;
    if (hasLocation) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(location);
    }
    i += 1;
    j = i;
    Object localObject;
    if (hasGuides)
    {
      i += 2;
      localIterator = guides.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Guide)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((Guide)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasFacets)
    {
      i += 2;
      localIterator = facets.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (SearchFacet)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((SearchFacet)localObject).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasSpellCorrection)
    {
      i = j + 1;
      if (spellCorrection._cachedId == null) {
        break label407;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(spellCorrection._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label407:
      i += spellCorrection.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i4 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label78:
    int n;
    label94:
    int i1;
    label110:
    int i2;
    if (id != null)
    {
      i = id.hashCode();
      if (type == null) {
        break label226;
      }
      j = type.hashCode();
      if (origin == null) {
        break label231;
      }
      k = origin.hashCode();
      if (warnings == null) {
        break label236;
      }
      m = warnings.hashCode();
      if (keywords == null) {
        break label242;
      }
      n = keywords.hashCode();
      if (location == null) {
        break label248;
      }
      i1 = location.hashCode();
      if (guides == null) {
        break label254;
      }
      i2 = guides.hashCode();
      label128:
      if (facets == null) {
        break label260;
      }
    }
    label226:
    label231:
    label236:
    label242:
    label248:
    label254:
    label260:
    for (int i3 = facets.hashCode();; i3 = 0)
    {
      if (spellCorrection != null) {
        i4 = spellCorrection.hashCode();
      }
      i = (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label78;
      n = 0;
      break label94;
      i1 = 0;
      break label110;
      i2 = 0;
      break label128;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchMetadata");
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
    label167:
    label279:
    label289:
    label299:
    label358:
    label475:
    label508:
    label515:
    label780:
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
        localByteBuffer.putInt(1237482255);
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, id);
          if (!hasType) {
            break label279;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
          if (!hasOrigin) {
            break label289;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, origin);
        }
        Iterator localIterator;
        for (;;)
        {
          if (!hasWarnings) {
            break label299;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, warnings.size());
          localIterator = warnings.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, ((SearchWarning)localIterator.next()).ordinal());
          }
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label167;
          localByteBuffer.put((byte)0);
        }
        localByteBuffer.put((byte)0);
        if (hasKeywords)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, keywords);
          if (!hasLocation) {
            break label475;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, location);
          if (!hasGuides) {
            break label508;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, guides.size());
          localIterator = guides.iterator();
        }
        Object localObject;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label515;
          }
          localObject = (Guide)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((Guide)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label358;
          }
          localByteBuffer.put((byte)1);
          ((Guide)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasFacets)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, facets.size());
          localIterator = facets.iterator();
          while (localIterator.hasNext())
          {
            localObject = (SearchFacet)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((SearchFacet)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((SearchFacet)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasSpellCorrection)
        {
          localByteBuffer.put((byte)1);
          if (spellCorrection._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, spellCorrection._cachedId);
            spellCorrection.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label780;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          spellCorrection.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */