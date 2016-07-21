package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SchoolRanking
  implements FissileDataModel<SchoolRanking>, RecordTemplate<SchoolRanking>
{
  public static final SchoolRankingBuilder BUILDER = SchoolRankingBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String category;
  public final String degreeLevel;
  public final boolean hasCategory;
  public final boolean hasDegreeLevel;
  public final boolean hasRanking;
  public final int ranking;
  
  SchoolRanking(String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    category = paramString1;
    ranking = paramInt;
    degreeLevel = paramString2;
    hasCategory = paramBoolean1;
    hasRanking = paramBoolean2;
    hasDegreeLevel = paramBoolean3;
    _cachedId = null;
  }
  
  public final SchoolRanking accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasCategory)
    {
      paramDataProcessor.startRecordField$505cff1c("category");
      paramDataProcessor.processString(category);
    }
    if (hasRanking)
    {
      paramDataProcessor.startRecordField$505cff1c("ranking");
      paramDataProcessor.processInt(ranking);
    }
    if (hasDegreeLevel)
    {
      paramDataProcessor.startRecordField$505cff1c("degreeLevel");
      paramDataProcessor.processString(degreeLevel);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasCategory) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolRanking", "category");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasRanking) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolRanking", "ranking");
      }
      if (!hasDegreeLevel) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolRanking", "degreeLevel");
      }
      return new SchoolRanking(category, ranking, degreeLevel, hasCategory, hasRanking, hasDegreeLevel);
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
      paramObject = (SchoolRanking)paramObject;
      if (category != null)
      {
        if (category.equals(category)) {}
      }
      else {
        while (category != null) {
          return false;
        }
      }
      if (ranking != ranking) {
        return false;
      }
      if (degreeLevel == null) {
        break;
      }
    } while (degreeLevel.equals(degreeLevel));
    for (;;)
    {
      return false;
      if (degreeLevel == null) {
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
    if (hasCategory) {
      i = PegasusBinaryUtils.getEncodedLength(category) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasRanking) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasDegreeLevel) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(degreeLevel);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (category != null) {}
    for (int i = category.hashCode();; i = 0)
    {
      int k = ranking;
      if (degreeLevel != null) {
        j = degreeLevel.hashCode();
      }
      i = ((i + 527) * 31 + k) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SchoolRanking");
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
    label160:
    label229:
    label239:
    label247:
    label249:
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
        localByteBuffer.putInt(576084071);
        if (hasCategory)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, category);
          if (!hasRanking) {
            break label229;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(ranking);
          if (!hasDegreeLevel) {
            break label239;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, degreeLevel);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label247;
          }
          if (str != null) {
            break label249;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label160;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolRanking
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */