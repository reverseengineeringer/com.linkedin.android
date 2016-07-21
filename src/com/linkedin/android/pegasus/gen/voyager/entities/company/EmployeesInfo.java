package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class EmployeesInfo
  implements FissileDataModel<EmployeesInfo>, RecordTemplate<EmployeesInfo>
{
  public static final EmployeesInfoBuilder BUILDER = EmployeesInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasMiniCompany;
  public final boolean hasNumberOfEmployees;
  public final MiniCompany miniCompany;
  public final int numberOfEmployees;
  
  EmployeesInfo(Urn paramUrn, MiniCompany paramMiniCompany, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    entityUrn = paramUrn;
    miniCompany = paramMiniCompany;
    numberOfEmployees = paramInt;
    hasEntityUrn = paramBoolean1;
    hasMiniCompany = paramBoolean2;
    hasNumberOfEmployees = paramBoolean3;
    paramMiniCompany = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  private EmployeesInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject = null;
    boolean bool = false;
    if (hasMiniCompany)
    {
      paramDataProcessor.startRecordField$505cff1c("miniCompany");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label150;
      }
      localObject = miniCompany.accept(paramDataProcessor);
      if (localObject == null) {
        break label167;
      }
    }
    label150:
    label167:
    for (bool = true;; bool = false)
    {
      if (hasNumberOfEmployees)
      {
        paramDataProcessor.startRecordField$505cff1c("numberOfEmployees");
        paramDataProcessor.processInt(numberOfEmployees);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label236;
      }
      try
      {
        if (hasEntityUrn) {
          break label172;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.EmployeesInfo", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompany);
      break;
    }
    label172:
    if (!hasMiniCompany) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.EmployeesInfo", "miniCompany");
    }
    if (!hasNumberOfEmployees) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.EmployeesInfo", "numberOfEmployees");
    }
    return new EmployeesInfo(entityUrn, (MiniCompany)localObject, numberOfEmployees, hasEntityUrn, bool, hasNumberOfEmployees);
    label236:
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
      paramObject = (EmployeesInfo)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (miniCompany != null)
      {
        if (miniCompany.equals(miniCompany)) {}
      }
      else {
        while (miniCompany != null) {
          return false;
        }
      }
    } while (numberOfEmployees == numberOfEmployees);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasMiniCompany)
    {
      i = j + 1;
      if (miniCompany._cachedId == null) {
        break label111;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniCompany._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasNumberOfEmployees) {
        i = j + 4;
      }
      __sizeOfObject = i;
      return i;
      label111:
      i += miniCompany.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (entityUrn != null) {}
    for (int i = entityUrn.hashCode();; i = 0)
    {
      if (miniCompany != null) {
        j = miniCompany.hashCode();
      }
      i = ((i + 527) * 31 + j) * 31 + numberOfEmployees;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EmployeesInfo");
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
    label204:
    label271:
    label296:
    label306:
    label314:
    label316:
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
        localByteBuffer.putInt(-817058592);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasMiniCompany) {
            break label296;
          }
          localByteBuffer.put((byte)1);
          if (miniCompany._cachedId == null) {
            break label271;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniCompany._cachedId);
          miniCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasNumberOfEmployees) {
            break label306;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numberOfEmployees);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label314;
          }
          if (str != null) {
            break label316;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          miniCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label204;
          localByteBuffer.put((byte)0);
          break label204;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.EmployeesInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */