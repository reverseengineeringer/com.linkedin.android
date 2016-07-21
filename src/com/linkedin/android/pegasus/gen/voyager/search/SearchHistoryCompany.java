package com.linkedin.android.pegasus.gen.voyager.search;

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
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchHistoryCompany
  implements FissileDataModel<SearchHistoryCompany>, RecordTemplate<SearchHistoryCompany>
{
  public static final SearchHistoryCompanyBuilder BUILDER = SearchHistoryCompanyBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn backendUrn;
  public final MiniCompany company;
  public final boolean hasBackendUrn;
  public final boolean hasCompany;
  
  SearchHistoryCompany(Urn paramUrn, MiniCompany paramMiniCompany, boolean paramBoolean1, boolean paramBoolean2)
  {
    backendUrn = paramUrn;
    company = paramMiniCompany;
    hasBackendUrn = paramBoolean1;
    hasCompany = paramBoolean2;
    _cachedId = null;
  }
  
  public final SearchHistoryCompany accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasBackendUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("backendUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(backendUrn));
    }
    Object localObject = null;
    boolean bool = false;
    if (hasCompany)
    {
      paramDataProcessor.startRecordField$505cff1c("company");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label125;
      }
      localObject = company.accept(paramDataProcessor);
      if (localObject == null) {
        break label142;
      }
    }
    label125:
    label142:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label184;
      }
      try
      {
        if (hasBackendUrn) {
          break label147;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryCompany", "backendUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (MiniCompany)paramDataProcessor.processDataTemplate(company);
      break;
    }
    label147:
    if (!hasCompany) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryCompany", "company");
    }
    return new SearchHistoryCompany(backendUrn, (MiniCompany)localObject, hasBackendUrn, bool);
    label184:
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
      paramObject = (SearchHistoryCompany)paramObject;
      if (backendUrn != null)
      {
        if (backendUrn.equals(backendUrn)) {}
      }
      else {
        while (backendUrn != null) {
          return false;
        }
      }
      if (company == null) {
        break;
      }
    } while (company.equals(company));
    for (;;)
    {
      return false;
      if (company == null) {
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
    if (hasBackendUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(backendUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasCompany)
    {
      i = j + 1;
      if (company._cachedId == null) {
        break label94;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(company._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label94:
      i += company.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (backendUrn != null) {}
    for (int i = backendUrn.hashCode();; i = 0)
    {
      if (company != null) {
        j = company.hashCode();
      }
      i = (i + 527) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchHistoryCompany");
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
    label247:
    label272:
    label280:
    label282:
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
        localByteBuffer.putInt(-1537635387);
        if (hasBackendUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
          if (!hasCompany) {
            break label272;
          }
          localByteBuffer.put((byte)1);
          if (company._cachedId == null) {
            break label247;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, company._cachedId);
          company.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label280;
          }
          if (str != null) {
            break label282;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          company.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    implements RecordTemplateBuilder<SearchHistoryCompany>
  {
    private Urn backendUrn = null;
    private MiniCompany company = null;
    private boolean hasBackendUrn = false;
    private boolean hasCompany = false;
    
    public final SearchHistoryCompany build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SearchHistoryCompany.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SearchHistoryCompany(backendUrn, company, hasBackendUrn, hasCompany);
        if (!hasBackendUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryCompany", "backendUrn");
        }
      } while (hasCompany);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryCompany", "company");
    }
    
    public final Builder setBackendUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasBackendUrn = false;
        backendUrn = null;
        return this;
      }
      hasBackendUrn = true;
      backendUrn = paramUrn;
      return this;
    }
    
    public final Builder setCompany(MiniCompany paramMiniCompany)
    {
      if (paramMiniCompany == null)
      {
        hasCompany = false;
        company = null;
        return this;
      }
      hasCompany = true;
      company = paramMiniCompany;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryCompany
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */