package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
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

public final class MiniProfileUrns
  implements FissileDataModel<MiniProfileUrns>, RecordTemplate<MiniProfileUrns>
{
  public static final MiniProfileUrnsBuilder BUILDER = MiniProfileUrnsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasMiniProfileUrns;
  public final List<Urn> miniProfileUrns;
  
  MiniProfileUrns(List<Urn> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      miniProfileUrns = paramList;
      hasMiniProfileUrns = paramBoolean;
      _cachedId = null;
      return;
    }
  }
  
  private MiniProfileUrns accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    Iterator localIterator = null;
    boolean bool = false;
    if (hasMiniProfileUrns)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfileUrns");
      miniProfileUrns.size();
      paramDataProcessor.startArray$13462e();
      localObject = localIterator;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      localIterator = miniProfileUrns.iterator();
      while (localIterator.hasNext())
      {
        Urn localUrn = (Urn)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(localUrn));
        if (localObject != null) {
          ((List)localObject).add(localUrn);
        }
        i += 1;
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label247;
      }
    }
    label247:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label263;
      }
      if (!hasMiniProfileUrns) {
        localObject = Collections.emptyList();
      }
      try
      {
        if (miniProfileUrns == null) {
          break;
        }
        paramDataProcessor = miniProfileUrns.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((Urn)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.MiniProfileUrns", "miniProfileUrns");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    return new MiniProfileUrns((List)localObject, bool);
    label263:
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
      paramObject = (MiniProfileUrns)paramObject;
      if (miniProfileUrns == null) {
        break;
      }
    } while (miniProfileUrns.equals(miniProfileUrns));
    for (;;)
    {
      return false;
      if (miniProfileUrns == null) {
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
    int j = i;
    if (hasMiniProfileUrns)
    {
      i += 2;
      Iterator localIterator = miniProfileUrns.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        Urn localUrn = (Urn)localIterator.next();
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(localUrn));
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (miniProfileUrns != null) {}
    for (int i = miniProfileUrns.hashCode();; i = 0)
    {
      i += 527;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MiniProfileUrns");
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
        localByteBuffer.putInt(-1609525603);
        if (hasMiniProfileUrns)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, miniProfileUrns.size());
          Iterator localIterator = miniProfileUrns.iterator();
          while (localIterator.hasNext())
          {
            Urn localUrn = (Urn)localIterator.next();
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(localUrn));
          }
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
    implements RecordTemplateBuilder<MiniProfileUrns>
  {
    public boolean hasMiniProfileUrns = false;
    public List<Urn> miniProfileUrns = null;
    
    public final MiniProfileUrns build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (MiniProfileUrns.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (miniProfileUrns != null)
      {
        paramFlavor = miniProfileUrns.iterator();
        do
        {
          if (!paramFlavor.hasNext()) {
            break;
          }
        } while ((Urn)paramFlavor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.MiniProfileUrns", "miniProfileUrns");
        if (!hasMiniProfileUrns) {
          miniProfileUrns = Collections.emptyList();
        }
      }
      return new MiniProfileUrns(miniProfileUrns, hasMiniProfileUrns);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.MiniProfileUrns
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */