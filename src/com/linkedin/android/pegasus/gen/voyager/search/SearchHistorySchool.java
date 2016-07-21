package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchHistorySchool
  implements FissileDataModel<SearchHistorySchool>, RecordTemplate<SearchHistorySchool>
{
  public static final SearchHistorySchoolBuilder BUILDER = SearchHistorySchoolBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn backendUrn;
  public final boolean hasBackendUrn;
  public final boolean hasSchool;
  public final MiniSchool school;
  
  SearchHistorySchool(Urn paramUrn, MiniSchool paramMiniSchool, boolean paramBoolean1, boolean paramBoolean2)
  {
    backendUrn = paramUrn;
    school = paramMiniSchool;
    hasBackendUrn = paramBoolean1;
    hasSchool = paramBoolean2;
    _cachedId = null;
  }
  
  public final SearchHistorySchool accept(DataProcessor paramDataProcessor)
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
    if (hasSchool)
    {
      paramDataProcessor.startRecordField$505cff1c("school");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label125;
      }
      localObject = school.accept(paramDataProcessor);
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
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistorySchool", "backendUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (MiniSchool)paramDataProcessor.processDataTemplate(school);
      break;
    }
    label147:
    if (!hasSchool) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistorySchool", "school");
    }
    return new SearchHistorySchool(backendUrn, (MiniSchool)localObject, hasBackendUrn, bool);
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
      paramObject = (SearchHistorySchool)paramObject;
      if (backendUrn != null)
      {
        if (backendUrn.equals(backendUrn)) {}
      }
      else {
        while (backendUrn != null) {
          return false;
        }
      }
      if (school == null) {
        break;
      }
    } while (school.equals(school));
    for (;;)
    {
      return false;
      if (school == null) {
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
    if (hasSchool)
    {
      i = j + 1;
      if (school._cachedId == null) {
        break label94;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(school._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label94:
      i += school.getSerializedSize();
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
      if (school != null) {
        j = school.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchHistorySchool");
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
        localByteBuffer.putInt(803259229);
        if (hasBackendUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
          if (!hasSchool) {
            break label272;
          }
          localByteBuffer.put((byte)1);
          if (school._cachedId == null) {
            break label247;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, school._cachedId);
          school.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          school.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    implements RecordTemplateBuilder<SearchHistorySchool>
  {
    private Urn backendUrn = null;
    private boolean hasBackendUrn = false;
    private boolean hasSchool = false;
    private MiniSchool school = null;
    
    public final SearchHistorySchool build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SearchHistorySchool.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SearchHistorySchool(backendUrn, school, hasBackendUrn, hasSchool);
        if (!hasBackendUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistorySchool", "backendUrn");
        }
      } while (hasSchool);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistorySchool", "school");
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
    
    public final Builder setSchool(MiniSchool paramMiniSchool)
    {
      if (paramMiniSchool == null)
      {
        hasSchool = false;
        school = null;
        return this;
      }
      hasSchool = true;
      school = paramMiniSchool;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistorySchool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */