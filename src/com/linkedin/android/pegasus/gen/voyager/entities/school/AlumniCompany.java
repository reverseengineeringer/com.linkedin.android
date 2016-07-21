package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class AlumniCompany
  implements FissileDataModel<AlumniCompany>, RecordTemplate<AlumniCompany>
{
  public static final AlumniCompanyBuilder BUILDER = AlumniCompanyBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final int alumniCount;
  public final boolean hasAlumniCount;
  public final boolean hasIndustry;
  public final boolean hasMiniCompany;
  public final String industry;
  public final MiniCompany miniCompany;
  
  AlumniCompany(MiniCompany paramMiniCompany, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    miniCompany = paramMiniCompany;
    alumniCount = paramInt;
    industry = paramString;
    hasMiniCompany = paramBoolean1;
    hasAlumniCount = paramBoolean2;
    hasIndustry = paramBoolean3;
    _cachedId = null;
  }
  
  public final AlumniCompany accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    MiniCompany localMiniCompany = null;
    boolean bool = false;
    if (hasMiniCompany)
    {
      paramDataProcessor.startRecordField$505cff1c("miniCompany");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label143;
      }
      localMiniCompany = miniCompany.accept(paramDataProcessor);
      if (localMiniCompany == null) {
        break label160;
      }
    }
    label143:
    label160:
    for (bool = true;; bool = false)
    {
      if (hasAlumniCount)
      {
        paramDataProcessor.startRecordField$505cff1c("alumniCount");
        paramDataProcessor.processInt(alumniCount);
      }
      if (hasIndustry)
      {
        paramDataProcessor.startRecordField$505cff1c("industry");
        paramDataProcessor.processString(industry);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label210;
      }
      try
      {
        if (hasMiniCompany) {
          break label165;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.school.AlumniCompany", "miniCompany");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localMiniCompany = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompany);
      break;
    }
    label165:
    if (!hasAlumniCount) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.school.AlumniCompany", "alumniCount");
    }
    return new AlumniCompany(localMiniCompany, alumniCount, industry, bool, hasAlumniCount, hasIndustry);
    label210:
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
      paramObject = (AlumniCompany)paramObject;
      if (miniCompany != null)
      {
        if (miniCompany.equals(miniCompany)) {}
      }
      else {
        while (miniCompany != null) {
          return false;
        }
      }
      if (alumniCount != alumniCount) {
        return false;
      }
      if (industry == null) {
        break;
      }
    } while (industry.equals(industry));
    for (;;)
    {
      return false;
      if (industry == null) {
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
    if (hasMiniCompany) {
      if (miniCompany._cachedId == null) {
        break label100;
      }
    }
    label100:
    for (i = PegasusBinaryUtils.getEncodedLength(miniCompany._cachedId) + 9;; i = miniCompany.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasAlumniCount) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasIndustry) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(industry);
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (miniCompany != null) {}
    for (int i = miniCompany.hashCode();; i = 0)
    {
      int k = alumniCount;
      if (industry != null) {
        j = industry.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AlumniCompany");
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
    label194:
    label288:
    label298:
    label306:
    label308:
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
        localByteBuffer.putInt(121573907);
        if (hasMiniCompany)
        {
          localByteBuffer.put((byte)1);
          if (miniCompany._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniCompany._cachedId);
            miniCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAlumniCount) {
              break label288;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(alumniCount);
            if (!hasIndustry) {
              break label298;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, industry);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label306;
          }
          if (str != null) {
            break label308;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          miniCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label194;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.AlumniCompany
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */