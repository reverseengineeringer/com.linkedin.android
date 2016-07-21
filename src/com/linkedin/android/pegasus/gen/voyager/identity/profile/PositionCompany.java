package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class PositionCompany
  implements FissileDataModel<PositionCompany>, RecordTemplate<PositionCompany>
{
  public static final PositionCompanyBuilder BUILDER = PositionCompanyBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final EmployeeCountRange employeeCountRange;
  public final boolean hasEmployeeCountRange;
  public final boolean hasIndustries;
  public final boolean hasMiniCompany;
  public final List<String> industries;
  public final MiniCompany miniCompany;
  
  PositionCompany(MiniCompany paramMiniCompany, EmployeeCountRange paramEmployeeCountRange, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    miniCompany = paramMiniCompany;
    employeeCountRange = paramEmployeeCountRange;
    if (paramList == null) {}
    for (paramMiniCompany = null;; paramMiniCompany = Collections.unmodifiableList(paramList))
    {
      industries = paramMiniCompany;
      hasMiniCompany = paramBoolean1;
      hasEmployeeCountRange = paramBoolean2;
      hasIndustries = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final PositionCompany accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    boolean bool2;
    if (hasMiniCompany)
    {
      paramDataProcessor.startRecordField$505cff1c("miniCompany");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniCompany.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label260;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasEmployeeCountRange)
      {
        paramDataProcessor.startRecordField$505cff1c("employeeCountRange");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label269;
        }
        localObject1 = employeeCountRange.accept(paramDataProcessor);
        label96:
        if (localObject1 == null) {
          break label287;
        }
        bool2 = true;
      }
    }
    for (Object localObject3 = localObject1;; localObject3 = localObject1)
    {
      localObject1 = null;
      Iterator localIterator = null;
      bool3 = false;
      if (!hasIndustries) {
        break label311;
      }
      paramDataProcessor.startRecordField$505cff1c("industries");
      industries.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localIterator;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localIterator = industries.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject1 != null) {
          ((List)localObject1).add(str);
        }
        i += 1;
      }
      localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompany);
      break;
      label260:
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      label269:
      localObject1 = (EmployeeCountRange)paramDataProcessor.processDataTemplate(employeeCountRange);
      break label96;
      label287:
      bool2 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      label311:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label442;
      }
      if (!hasIndustries) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasMiniCompany) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompany", "miniCompany");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (industries != null)
    {
      paramDataProcessor = industries.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompany", "industries");
        }
      }
    }
    return new PositionCompany((MiniCompany)localObject2, (EmployeeCountRange)localObject3, (List)localObject1, bool1, bool2, bool3);
    label442:
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
      paramObject = (PositionCompany)paramObject;
      if (miniCompany != null)
      {
        if (miniCompany.equals(miniCompany)) {}
      }
      else {
        while (miniCompany != null) {
          return false;
        }
      }
      if (employeeCountRange != null)
      {
        if (employeeCountRange.equals(employeeCountRange)) {}
      }
      else {
        while (employeeCountRange != null) {
          return false;
        }
      }
      if (industries == null) {
        break;
      }
    } while (industries.equals(industries));
    for (;;)
    {
      return false;
      if (industries == null) {
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
    int j;
    if (hasMiniCompany)
    {
      if (miniCompany._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(miniCompany._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasEmployeeCountRange)
      {
        i = j + 1;
        if (employeeCountRange._cachedId == null) {
          break label165;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(employeeCountRange._cachedId);
      }
    }
    for (;;)
    {
      i += 1;
      j = i;
      if (!hasIndustries) {
        break label178;
      }
      i += 2;
      Iterator localIterator = industries.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
      i = miniCompany.getSerializedSize() + 7;
      break;
      label165:
      i += employeeCountRange.getSerializedSize();
    }
    label178:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (miniCompany != null)
    {
      i = miniCompany.hashCode();
      if (employeeCountRange == null) {
        break label89;
      }
    }
    label89:
    for (int j = employeeCountRange.hashCode();; j = 0)
    {
      if (industries != null) {
        k = industries.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PositionCompany");
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
    label338:
    label363:
    label373:
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
        localByteBuffer.putInt(-461902732);
        if (hasMiniCompany)
        {
          localByteBuffer.put((byte)1);
          if (miniCompany._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniCompany._cachedId);
            miniCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasEmployeeCountRange) {
              break label363;
            }
            localByteBuffer.put((byte)1);
            if (employeeCountRange._cachedId == null) {
              break label338;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, employeeCountRange._cachedId);
            employeeCountRange.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (!hasIndustries) {
            break label373;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, industries.size());
          Iterator localIterator = industries.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
          localByteBuffer.put((byte)1);
          miniCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          employeeCountRange.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
          localByteBuffer.put((byte)0);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<PositionCompany>
  {
    private EmployeeCountRange employeeCountRange = null;
    private boolean hasEmployeeCountRange = false;
    private boolean hasIndustries = false;
    public boolean hasMiniCompany = false;
    private List<String> industries = null;
    public MiniCompany miniCompany = null;
    
    public final PositionCompany build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PositionCompany.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (industries != null)
      {
        paramFlavor = industries.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((String)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompany", "industries");
              if (!hasIndustries) {
                industries = Collections.emptyList();
              }
              if (hasMiniCompany) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompany", "miniCompany");
            }
          }
        }
      }
      return new PositionCompany(miniCompany, employeeCountRange, industries, hasMiniCompany, hasEmployeeCountRange, hasIndustries);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompany
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */