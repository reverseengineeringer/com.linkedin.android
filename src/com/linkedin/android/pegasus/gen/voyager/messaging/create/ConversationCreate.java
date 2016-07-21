package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.EventSubtype;
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

public final class ConversationCreate
  implements FissileDataModel<ConversationCreate>, RecordTemplate<ConversationCreate>
{
  public static final ConversationCreateBuilder BUILDER = ConversationCreateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final EventCreate eventCreate;
  public final boolean hasEventCreate;
  public final boolean hasName;
  public final boolean hasRecipients;
  public final boolean hasSubject;
  public final boolean hasSubtype;
  public final String name;
  public final List<String> recipients;
  public final String subject;
  public final EventSubtype subtype;
  
  ConversationCreate(List<String> paramList, String paramString1, EventCreate paramEventCreate, EventSubtype paramEventSubtype, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      recipients = paramList;
      subject = paramString1;
      eventCreate = paramEventCreate;
      subtype = paramEventSubtype;
      name = paramString2;
      hasRecipients = paramBoolean1;
      hasSubject = paramBoolean2;
      hasEventCreate = paramBoolean3;
      hasSubtype = paramBoolean4;
      hasName = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  private ConversationCreate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    if (hasRecipients)
    {
      paramDataProcessor.startRecordField$505cff1c("recipients");
      recipients.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localObject2 = recipients.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject1 != null) {
          ((List)localObject1).add(str);
        }
        i += 1;
      }
      paramDataProcessor.endArray();
      if (localObject1 != null)
      {
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasSubject)
      {
        paramDataProcessor.startRecordField$505cff1c("subject");
        paramDataProcessor.processString(subject);
      }
      localObject1 = null;
      bool2 = false;
      if (hasEventCreate)
      {
        paramDataProcessor.startRecordField$505cff1c("eventCreate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label328;
        }
        localObject1 = eventCreate.accept(paramDataProcessor);
        label217:
        if (localObject1 == null) {
          break label346;
        }
      }
    }
    label328:
    label346:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasSubtype)
      {
        paramDataProcessor.startRecordField$505cff1c("subtype");
        paramDataProcessor.processEnum(subtype);
      }
      if (hasName)
      {
        paramDataProcessor.startRecordField$505cff1c("name");
        paramDataProcessor.processString(name);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label460;
      }
      try
      {
        if (hasRecipients) {
          break label352;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ConversationCreate", "recipients");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      localObject2 = localObject1;
      break;
      localObject1 = (EventCreate)paramDataProcessor.processDataTemplate(eventCreate);
      break label217;
    }
    label352:
    if (!hasEventCreate) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ConversationCreate", "eventCreate");
    }
    if (recipients != null)
    {
      paramDataProcessor = recipients.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ConversationCreate", "recipients");
        }
      }
    }
    return new ConversationCreate((List)localObject2, subject, (EventCreate)localObject1, subtype, name, bool1, hasSubject, bool2, hasSubtype, hasName);
    label460:
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
      paramObject = (ConversationCreate)paramObject;
      if (recipients != null)
      {
        if (recipients.equals(recipients)) {}
      }
      else {
        while (recipients != null) {
          return false;
        }
      }
      if (subject != null)
      {
        if (subject.equals(subject)) {}
      }
      else {
        while (subject != null) {
          return false;
        }
      }
      if (eventCreate != null)
      {
        if (eventCreate.equals(eventCreate)) {}
      }
      else {
        while (eventCreate != null) {
          return false;
        }
      }
      if (subtype != null)
      {
        if (subtype.equals(subtype)) {}
      }
      else {
        while (subtype != null) {
          return false;
        }
      }
      if (name == null) {
        break;
      }
    } while (name.equals(name));
    for (;;)
    {
      return false;
      if (name == null) {
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
    if (hasRecipients)
    {
      i += 2;
      Iterator localIterator = recipients.iterator();
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
    if (hasSubject) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(subject);
    }
    j = i + 1;
    i = j;
    if (hasEventCreate)
    {
      i = j + 1;
      if (eventCreate._cachedId == null) {
        break label190;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(eventCreate._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasSubtype) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(name);
      }
      __sizeOfObject = i;
      return i;
      label190:
      i += eventCreate.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label47:
    int k;
    if (recipients != null)
    {
      i = recipients.hashCode();
      if (subject == null) {
        break label134;
      }
      j = subject.hashCode();
      if (eventCreate == null) {
        break label139;
      }
      k = eventCreate.hashCode();
      label62:
      if (subtype == null) {
        break label144;
      }
    }
    label134:
    label139:
    label144:
    for (int m = subtype.hashCode();; m = 0)
    {
      if (name != null) {
        n = name.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label47;
      k = 0;
      break label62;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ConversationCreate");
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
    label276:
    label305:
    label374:
    label399:
    label409:
    label419:
    label427:
    label429:
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
        localByteBuffer.putInt(1113857765);
        if (hasRecipients)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, recipients.size());
          Iterator localIterator = recipients.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
        }
        localByteBuffer.put((byte)0);
        if (hasSubject)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, subject);
          if (!hasEventCreate) {
            break label399;
          }
          localByteBuffer.put((byte)1);
          if (eventCreate._cachedId == null) {
            break label374;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, eventCreate._cachedId);
          eventCreate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSubtype) {
            break label409;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, subtype.ordinal());
          if (!hasName) {
            break label419;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label427;
          }
          if (str != null) {
            break label429;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          eventCreate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label276;
          localByteBuffer.put((byte)0);
          break label276;
          localByteBuffer.put((byte)0);
          break label305;
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
    implements RecordTemplateBuilder<ConversationCreate>
  {
    public EventCreate eventCreate = null;
    public boolean hasEventCreate = false;
    public boolean hasName = false;
    public boolean hasRecipients = false;
    public boolean hasSubject = false;
    public boolean hasSubtype = false;
    public String name = null;
    public List<String> recipients = null;
    public String subject = null;
    public EventSubtype subtype = null;
    
    private ConversationCreate build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ConversationCreate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (recipients != null)
      {
        paramFlavor = recipients.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((String)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ConversationCreate", "recipients");
              if (!hasSubtype) {
                subtype = EventSubtype.MEMBER_TO_MEMBER;
              }
              if (!hasRecipients) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ConversationCreate", "recipients");
              }
              if (hasEventCreate) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ConversationCreate", "eventCreate");
            }
          }
        }
      }
      return new ConversationCreate(recipients, subject, eventCreate, subtype, name, hasRecipients, hasSubject, hasEventCreate, hasSubtype, hasName);
    }
    
    public final ConversationCreate build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.ConversationCreate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */