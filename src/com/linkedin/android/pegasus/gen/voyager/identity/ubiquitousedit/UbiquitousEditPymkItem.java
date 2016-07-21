package com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class UbiquitousEditPymkItem
  implements FissileDataModel<UbiquitousEditPymkItem>, RecordTemplate<UbiquitousEditPymkItem>
{
  public static final UbiquitousEditPymkItemBuilder BUILDER = UbiquitousEditPymkItemBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean boosted;
  public final boolean hasBoosted;
  public final boolean hasPymk;
  public final PeopleYouMayKnow pymk;
  
  UbiquitousEditPymkItem(PeopleYouMayKnow paramPeopleYouMayKnow, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    pymk = paramPeopleYouMayKnow;
    boosted = paramBoolean1;
    hasPymk = paramBoolean2;
    hasBoosted = paramBoolean3;
    _cachedId = null;
  }
  
  public final UbiquitousEditPymkItem accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    PeopleYouMayKnow localPeopleYouMayKnow = null;
    boolean bool = false;
    if (hasPymk)
    {
      paramDataProcessor.startRecordField$505cff1c("pymk");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label118;
      }
      localPeopleYouMayKnow = pymk.accept(paramDataProcessor);
      if (localPeopleYouMayKnow == null) {
        break label135;
      }
    }
    label118:
    label135:
    for (bool = true;; bool = false)
    {
      if (hasBoosted)
      {
        paramDataProcessor.startRecordField$505cff1c("boosted");
        paramDataProcessor.processBoolean(boosted);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label177;
      }
      try
      {
        if (hasPymk) {
          break label140;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditPymkItem", "pymk");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localPeopleYouMayKnow = (PeopleYouMayKnow)paramDataProcessor.processDataTemplate(pymk);
      break;
    }
    label140:
    if (!hasBoosted) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditPymkItem", "boosted");
    }
    return new UbiquitousEditPymkItem(localPeopleYouMayKnow, boosted, bool, hasBoosted);
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
      paramObject = (UbiquitousEditPymkItem)paramObject;
      if (pymk != null)
      {
        if (pymk.equals(pymk)) {}
      }
      else {
        while (pymk != null) {
          return false;
        }
      }
    } while (boosted == boosted);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasPymk) {
      if (pymk._cachedId == null) {
        break label75;
      }
    }
    label75:
    for (i = PegasusBinaryUtils.getEncodedLength(pymk._cachedId) + 9;; i = pymk.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasBoosted) {
        i = j + 1;
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
    if (pymk != null) {}
    for (int i = pymk.hashCode();; i = 0)
    {
      if (boosted) {
        j = 1;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building UbiquitousEditPymkItem");
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
    label271:
    label277:
    label285:
    label287:
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
        localByteBuffer.putInt(-1598845678);
        if (hasPymk)
        {
          localByteBuffer.put((byte)1);
          if (pymk._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, pymk._cachedId);
            pymk.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasBoosted) {
              break label277;
            }
            localByteBuffer.put((byte)1);
            if (!boosted) {
              break label271;
            }
            i = 1;
            localByteBuffer.put((byte)i);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label285;
          }
          if (str != null) {
            break label287;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          pymk.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          i = 0;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditPymkItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */