package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class EmployeeQuote
  implements FissileDataModel<EmployeeQuote>, RecordTemplate<EmployeeQuote>
{
  public static final EmployeeQuoteBuilder BUILDER = EmployeeQuoteBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasMember;
  public final boolean hasQuote;
  public final EntitiesMiniProfile member;
  public final String quote;
  
  EmployeeQuote(EntitiesMiniProfile paramEntitiesMiniProfile, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    member = paramEntitiesMiniProfile;
    quote = paramString;
    hasMember = paramBoolean1;
    hasQuote = paramBoolean2;
    _cachedId = null;
  }
  
  public final EmployeeQuote accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    EntitiesMiniProfile localEntitiesMiniProfile = null;
    boolean bool = false;
    if (hasMember)
    {
      paramDataProcessor.startRecordField$505cff1c("member");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label118;
      }
      localEntitiesMiniProfile = member.accept(paramDataProcessor);
      if (localEntitiesMiniProfile == null) {
        break label135;
      }
    }
    label118:
    label135:
    for (bool = true;; bool = false)
    {
      if (hasQuote)
      {
        paramDataProcessor.startRecordField$505cff1c("quote");
        paramDataProcessor.processString(quote);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label177;
      }
      try
      {
        if (hasMember) {
          break label140;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.EmployeeQuote", "member");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localEntitiesMiniProfile = (EntitiesMiniProfile)paramDataProcessor.processDataTemplate(member);
      break;
    }
    label140:
    if (!hasQuote) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.EmployeeQuote", "quote");
    }
    return new EmployeeQuote(localEntitiesMiniProfile, quote, bool, hasQuote);
    label177:
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
      paramObject = (EmployeeQuote)paramObject;
      if (member != null)
      {
        if (member.equals(member)) {}
      }
      else {
        while (member != null) {
          return false;
        }
      }
      if (quote == null) {
        break;
      }
    } while (quote.equals(quote));
    for (;;)
    {
      return false;
      if (quote == null) {
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
    if (hasMember) {
      if (member._cachedId == null) {
        break label83;
      }
    }
    label83:
    for (i = PegasusBinaryUtils.getEncodedLength(member._cachedId) + 9;; i = member.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasQuote) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(quote);
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
    if (member != null) {}
    for (int i = member.hashCode();; i = 0)
    {
      if (quote != null) {
        j = quote.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EmployeeQuote");
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
    label264:
    label272:
    label274:
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
        localByteBuffer.putInt(1906026603);
        if (hasMember)
        {
          localByteBuffer.put((byte)1);
          if (member._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, member._cachedId);
            member.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasQuote) {
              break label264;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, quote);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label272;
          }
          if (str != null) {
            break label274;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          member.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.EmployeeQuote
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */