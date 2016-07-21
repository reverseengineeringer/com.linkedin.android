package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

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

public final class CompanyHighlight
  implements FissileDataModel<CompanyHighlight>, RecordTemplate<CompanyHighlight>
{
  public static final CompanyHighlightBuilder BUILDER = CompanyHighlightBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasMiniCompany;
  public final boolean hasNumViews;
  public final MiniCompany miniCompany;
  public final long numViews;
  
  CompanyHighlight(long paramLong, MiniCompany paramMiniCompany, boolean paramBoolean1, boolean paramBoolean2)
  {
    numViews = paramLong;
    miniCompany = paramMiniCompany;
    hasNumViews = paramBoolean1;
    hasMiniCompany = paramBoolean2;
    _cachedId = null;
  }
  
  public final CompanyHighlight accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasNumViews)
    {
      paramDataProcessor.startRecordField$505cff1c("numViews");
      paramDataProcessor.processLong(numViews);
    }
    MiniCompany localMiniCompany = null;
    boolean bool = false;
    if (hasMiniCompany)
    {
      paramDataProcessor.startRecordField$505cff1c("miniCompany");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label118;
      }
      localMiniCompany = miniCompany.accept(paramDataProcessor);
      if (localMiniCompany == null) {
        break label135;
      }
    }
    label118:
    label135:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label177;
      }
      try
      {
        if (hasNumViews) {
          break label140;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.CompanyHighlight", "numViews");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localMiniCompany = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompany);
      break;
    }
    label140:
    if (!hasMiniCompany) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.CompanyHighlight", "miniCompany");
    }
    return new CompanyHighlight(numViews, localMiniCompany, hasNumViews, bool);
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
      paramObject = (CompanyHighlight)paramObject;
      if (numViews != numViews) {
        return false;
      }
      if (miniCompany == null) {
        break;
      }
    } while (miniCompany.equals(miniCompany));
    for (;;)
    {
      return false;
      if (miniCompany == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasNumViews) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasMiniCompany)
    {
      i = j + 1;
      if (miniCompany._cachedId == null) {
        break label83;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniCompany._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label83:
      i += miniCompany.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int j = (int)(numViews ^ numViews >>> 32);
    if (miniCompany != null) {}
    for (int i = miniCompany.hashCode();; i = 0)
    {
      i = (j + 527) * 31 + i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CompanyHighlight");
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
    label237:
    label262:
    label270:
    label272:
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
        localByteBuffer.putInt(1473917493);
        if (hasNumViews)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numViews);
          if (!hasMiniCompany) {
            break label262;
          }
          localByteBuffer.put((byte)1);
          if (miniCompany._cachedId == null) {
            break label237;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniCompany._cachedId);
          miniCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label270;
          }
          if (str != null) {
            break label272;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          miniCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.CompanyHighlight
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */