package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
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

public final class ParticipantChangeCreate
  implements FissileDataModel<ParticipantChangeCreate>, RecordTemplate<ParticipantChangeCreate>
{
  public static final ParticipantChangeCreateBuilder BUILDER = ParticipantChangeCreateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<String> addParticipants;
  public final boolean hasAddParticipants;
  public final boolean hasRemoveParticipants;
  public final boolean hasShowHistory;
  public final List<String> removeParticipants;
  public final boolean showHistory;
  
  ParticipantChangeCreate(List<String> paramList1, boolean paramBoolean1, List<String> paramList2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramList1 == null)
    {
      paramList1 = null;
      addParticipants = paramList1;
      showHistory = paramBoolean1;
      if (paramList2 != null) {
        break label73;
      }
    }
    label73:
    for (paramList1 = null;; paramList1 = Collections.unmodifiableList(paramList2))
    {
      removeParticipants = paramList1;
      hasAddParticipants = paramBoolean2;
      hasShowHistory = paramBoolean3;
      hasRemoveParticipants = paramBoolean4;
      _cachedId = null;
      return;
      paramList1 = Collections.unmodifiableList(paramList1);
      break;
    }
  }
  
  public final ParticipantChangeCreate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    int i;
    Object localObject3;
    if (hasAddParticipants)
    {
      paramDataProcessor.startRecordField$505cff1c("addParticipants");
      addParticipants.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject2 = addParticipants.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject3);
        if (localObject1 != null) {
          ((List)localObject1).add(localObject3);
        }
        i += 1;
      }
      paramDataProcessor.endArray();
      if (localObject1 == null) {
        break label311;
      }
      bool1 = true;
    }
    for (localObject2 = localObject1;; localObject2 = localObject1)
    {
      if (hasShowHistory)
      {
        paramDataProcessor.startRecordField$505cff1c("showHistory");
        paramDataProcessor.processBoolean(showHistory);
      }
      localObject1 = null;
      localObject3 = null;
      bool2 = false;
      if (!hasRemoveParticipants) {
        break label334;
      }
      paramDataProcessor.startRecordField$505cff1c("removeParticipants");
      removeParticipants.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = removeParticipants.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject1 != null) {
          ((List)localObject1).add(str);
        }
        i += 1;
      }
      label311:
      bool1 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label334:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label488;
      }
      try
      {
        if (addParticipants == null) {
          break;
        }
        paramDataProcessor = addParticipants.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((String)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ParticipantChangeCreate", "addParticipants");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (removeParticipants != null)
    {
      paramDataProcessor = removeParticipants.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ParticipantChangeCreate", "removeParticipants");
        }
      }
    }
    return new ParticipantChangeCreate((List)localObject2, showHistory, (List)localObject1, bool1, hasShowHistory, bool2);
    label488:
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
      paramObject = (ParticipantChangeCreate)paramObject;
      if (addParticipants != null)
      {
        if (addParticipants.equals(addParticipants)) {}
      }
      else {
        while (addParticipants != null) {
          return false;
        }
      }
      if (showHistory != showHistory) {
        return false;
      }
      if (removeParticipants == null) {
        break;
      }
    } while (removeParticipants.equals(removeParticipants));
    for (;;)
    {
      return false;
      if (removeParticipants == null) {
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
    Iterator localIterator;
    if (hasAddParticipants)
    {
      i += 2;
      localIterator = addParticipants.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
    }
    j += 1;
    i = j;
    if (hasShowHistory) {
      i = j + 1;
    }
    i += 1;
    j = i;
    if (hasRemoveParticipants)
    {
      i += 2;
      localIterator = removeParticipants.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
    }
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
    if (addParticipants != null)
    {
      i = addParticipants.hashCode();
      if (!showHistory) {
        break label85;
      }
    }
    label85:
    for (int j = 1;; j = 0)
    {
      if (removeParticipants != null) {
        k = removeParticipants.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ParticipantChangeCreate");
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
    label312:
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
        localByteBuffer.putInt(-1728487660);
        Iterator localIterator;
        if (hasAddParticipants)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, addParticipants.size());
          localIterator = addParticipants.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
        }
        localByteBuffer.put((byte)0);
        if (hasShowHistory)
        {
          localByteBuffer.put((byte)1);
          if (showHistory)
          {
            i = 1;
            localByteBuffer.put((byte)i);
          }
        }
        for (;;)
        {
          if (!hasRemoveParticipants) {
            break label312;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, removeParticipants.size());
          localIterator = removeParticipants.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
          i = 0;
          break;
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
    implements RecordTemplateBuilder<ParticipantChangeCreate>
  {
    public List<String> addParticipants = null;
    public boolean hasAddParticipants = false;
    public boolean hasRemoveParticipants = false;
    public boolean hasShowHistory = false;
    public List<String> removeParticipants = null;
    public boolean showHistory = false;
    
    private ParticipantChangeCreate build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ParticipantChangeCreate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (addParticipants != null)
      {
        paramFlavor = addParticipants.iterator();
        do
        {
          if (!paramFlavor.hasNext()) {
            break;
          }
        } while ((String)paramFlavor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ParticipantChangeCreate", "addParticipants");
        if (!hasShowHistory) {
          showHistory = false;
        }
      }
      if (removeParticipants != null)
      {
        paramFlavor = removeParticipants.iterator();
        while (paramFlavor.hasNext()) {
          if ((String)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ParticipantChangeCreate", "removeParticipants");
          }
        }
      }
      return new ParticipantChangeCreate(addParticipants, showHistory, removeParticipants, hasAddParticipants, hasShowHistory, hasRemoveParticipants);
    }
    
    public final ParticipantChangeCreate build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.ParticipantChangeCreate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */