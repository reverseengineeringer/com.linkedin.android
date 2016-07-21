package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchJobJserp
  implements FissileDataModel<SearchJobJserp>, RecordTemplate<SearchJobJserp>
{
  public static final SearchJobJserpBuilder BUILDER = SearchJobJserpBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String descriptionSnippet;
  public final String explanation;
  public final boolean hasDescriptionSnippet;
  public final boolean hasExplanation;
  public final boolean hasJobPosting;
  public final boolean hasScore;
  public final Urn jobPosting;
  public final float score;
  
  SearchJobJserp(Urn paramUrn, String paramString1, String paramString2, float paramFloat, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    jobPosting = paramUrn;
    descriptionSnippet = paramString1;
    explanation = paramString2;
    score = paramFloat;
    hasJobPosting = paramBoolean1;
    hasDescriptionSnippet = paramBoolean2;
    hasExplanation = paramBoolean3;
    hasScore = paramBoolean4;
    _cachedId = null;
  }
  
  public final SearchJobJserp accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasJobPosting)
    {
      paramDataProcessor.startRecordField$505cff1c("jobPosting");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(jobPosting));
    }
    if (hasDescriptionSnippet)
    {
      paramDataProcessor.startRecordField$505cff1c("descriptionSnippet");
      paramDataProcessor.processString(descriptionSnippet);
    }
    if (hasExplanation)
    {
      paramDataProcessor.startRecordField$505cff1c("explanation");
      paramDataProcessor.processString(explanation);
    }
    if (hasScore)
    {
      paramDataProcessor.startRecordField$505cff1c("score");
      paramDataProcessor.processFloat(score);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasJobPosting) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchJobJserp", "jobPosting");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasDescriptionSnippet) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchJobJserp", "descriptionSnippet");
      }
      return new SearchJobJserp(jobPosting, descriptionSnippet, explanation, score, hasJobPosting, hasDescriptionSnippet, hasExplanation, hasScore);
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
      paramObject = (SearchJobJserp)paramObject;
      if (jobPosting != null)
      {
        if (jobPosting.equals(jobPosting)) {}
      }
      else {
        while (jobPosting != null) {
          return false;
        }
      }
      if (descriptionSnippet != null)
      {
        if (descriptionSnippet.equals(descriptionSnippet)) {}
      }
      else {
        while (descriptionSnippet != null) {
          return false;
        }
      }
      if (explanation != null)
      {
        if (explanation.equals(explanation)) {}
      }
      else {
        while (explanation != null) {
          return false;
        }
      }
    } while (score == score);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasJobPosting)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(jobPosting)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasDescriptionSnippet) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(descriptionSnippet);
    }
    j = i + 1;
    i = j;
    if (hasExplanation) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(explanation);
    }
    j = i + 1;
    i = j;
    if (hasScore) {
      i = j + 4;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (jobPosting != null)
    {
      i = jobPosting.hashCode();
      if (descriptionSnippet == null) {
        break label112;
      }
      j = descriptionSnippet.hashCode();
      label45:
      if (explanation == null) {
        break label117;
      }
    }
    label112:
    label117:
    for (int k = explanation.hashCode();; k = 0)
    {
      if (score != 0.0F) {
        m = Float.floatToIntBits(score);
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchJobJserp");
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
    label170:
    label196:
    label263:
    label273:
    label283:
    label291:
    label293:
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
        localByteBuffer.putInt(1802708830);
        if (hasJobPosting)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(jobPosting));
          if (!hasDescriptionSnippet) {
            break label263;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, descriptionSnippet);
          if (!hasExplanation) {
            break label273;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, explanation);
          if (!hasScore) {
            break label283;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putFloat(score);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label291;
          }
          if (str != null) {
            break label293;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)0);
          break label196;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchJobJserp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */