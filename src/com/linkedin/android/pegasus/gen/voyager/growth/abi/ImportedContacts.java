package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
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

public final class ImportedContacts
  implements FissileDataModel<ImportedContacts>, RecordTemplate<ImportedContacts>
{
  public static final ImportedContactsBuilder BUILDER = ImportedContactsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final List<GuestContact> guestContacts;
  public final boolean hasGuestContacts;
  public final boolean hasMemberContacts;
  public final boolean hasTrackingId;
  public final List<MemberContact> memberContacts;
  public final String trackingId;
  
  ImportedContacts(List<MemberContact> paramList, List<GuestContact> paramList1, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramList == null)
    {
      paramList = null;
      memberContacts = paramList;
      if (paramList1 != null) {
        break label73;
      }
    }
    label73:
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList1))
    {
      guestContacts = paramList;
      trackingId = paramString;
      hasMemberContacts = paramBoolean1;
      hasGuestContacts = paramBoolean2;
      hasTrackingId = paramBoolean3;
      _cachedId = null;
      return;
      paramList = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  private ImportedContacts accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    int i;
    if (hasMemberContacts)
    {
      paramDataProcessor.startRecordField$505cff1c("memberContacts");
      memberContacts.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = memberContacts.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (MemberContact)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((MemberContact)localObject2).accept(paramDataProcessor);; localObject2 = (MemberContact)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null) {
        bool1 = true;
      }
    }
    else
    {
      localObject2 = null;
      localObject3 = null;
      bool2 = false;
      if (!hasGuestContacts) {
        break label365;
      }
      paramDataProcessor.startRecordField$505cff1c("guestContacts");
      guestContacts.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = guestContacts.iterator();
      label257:
      if (!localIterator.hasNext()) {
        break label351;
      }
      localObject3 = (GuestContact)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label335;
      }
    }
    label335:
    for (Object localObject3 = ((GuestContact)localObject3).accept(paramDataProcessor);; localObject3 = (GuestContact)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject2 != null) && (localObject3 != null)) {
        ((List)localObject2).add(localObject3);
      }
      i += 1;
      break label257;
      bool1 = false;
      break;
    }
    label351:
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label365:
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        paramDataProcessor.processString(trackingId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label568;
      }
      if (!hasMemberContacts) {
        localObject1 = Collections.emptyList();
      }
      if (!hasGuestContacts) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (memberContacts == null) {
          break;
        }
        paramDataProcessor = memberContacts.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((MemberContact)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts", "memberContacts");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (guestContacts != null)
    {
      paramDataProcessor = guestContacts.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((GuestContact)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts", "guestContacts");
        }
      }
    }
    return new ImportedContacts((List)localObject1, (List)localObject2, trackingId, bool1, bool2, hasTrackingId);
    label568:
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
      paramObject = (ImportedContacts)paramObject;
      if (memberContacts != null)
      {
        if (memberContacts.equals(memberContacts)) {}
      }
      else {
        while (memberContacts != null) {
          return false;
        }
      }
      if (guestContacts != null)
      {
        if (guestContacts.equals(guestContacts)) {}
      }
      else {
        while (guestContacts != null) {
          return false;
        }
      }
      if (trackingId == null) {
        break;
      }
    } while (trackingId.equals(trackingId));
    for (;;)
    {
      return false;
      if (trackingId == null) {
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
    Object localObject;
    if (hasMemberContacts)
    {
      i += 2;
      localIterator = memberContacts.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (MemberContact)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((MemberContact)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasGuestContacts)
    {
      i += 2;
      localIterator = guestContacts.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (GuestContact)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((GuestContact)localObject).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasTrackingId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingId);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (memberContacts != null)
    {
      i = memberContacts.hashCode();
      if (guestContacts == null) {
        break label91;
      }
    }
    label91:
    for (int j = guestContacts.hashCode();; j = 0)
    {
      if (trackingId != null) {
        k = trackingId.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ImportedContacts");
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
    label453:
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
        localByteBuffer.putInt(2095324582);
        Iterator localIterator;
        Object localObject;
        if (hasMemberContacts)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, memberContacts.size());
          localIterator = memberContacts.iterator();
          while (localIterator.hasNext())
          {
            localObject = (MemberContact)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((MemberContact)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((MemberContact)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasGuestContacts)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, guestContacts.size());
          localIterator = guestContacts.iterator();
          while (localIterator.hasNext())
          {
            localObject = (GuestContact)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((GuestContact)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((GuestContact)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label453;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
    implements RecordTemplateBuilder<ImportedContacts>
  {
    public List<GuestContact> guestContacts = null;
    public boolean hasGuestContacts = false;
    public boolean hasMemberContacts = false;
    private boolean hasTrackingId = false;
    public List<MemberContact> memberContacts = null;
    private String trackingId = null;
    
    public final ImportedContacts build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ImportedContacts.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (memberContacts != null)
      {
        paramFlavor = memberContacts.iterator();
        do
        {
          if (!paramFlavor.hasNext()) {
            break;
          }
        } while ((MemberContact)paramFlavor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts", "memberContacts");
        if (!hasMemberContacts) {
          memberContacts = Collections.emptyList();
        }
        if (!hasGuestContacts) {
          guestContacts = Collections.emptyList();
        }
      }
      if (guestContacts != null)
      {
        paramFlavor = guestContacts.iterator();
        while (paramFlavor.hasNext()) {
          if ((GuestContact)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts", "guestContacts");
          }
        }
      }
      return new ImportedContacts(memberContacts, guestContacts, trackingId, hasMemberContacts, hasGuestContacts, hasTrackingId);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */