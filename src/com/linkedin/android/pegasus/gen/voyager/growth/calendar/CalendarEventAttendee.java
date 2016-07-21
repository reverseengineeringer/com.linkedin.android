package com.linkedin.android.pegasus.gen.voyager.growth.calendar;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CalendarEventAttendee
  implements FissileDataModel<CalendarEventAttendee>, RecordTemplate<CalendarEventAttendee>
{
  public static final CalendarEventAttendeeBuilder BUILDER = CalendarEventAttendeeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String email;
  public final boolean hasEmail;
  public final boolean hasName;
  public final boolean hasStatus;
  public final String name;
  public final CalendarEventAttendeeStatus status;
  
  CalendarEventAttendee(String paramString1, String paramString2, CalendarEventAttendeeStatus paramCalendarEventAttendeeStatus, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    name = paramString1;
    email = paramString2;
    status = paramCalendarEventAttendeeStatus;
    hasName = paramBoolean1;
    hasEmail = paramBoolean2;
    hasStatus = paramBoolean3;
    _cachedId = null;
  }
  
  public final CalendarEventAttendee accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasName)
    {
      paramDataProcessor.startRecordField$505cff1c("name");
      paramDataProcessor.processString(name);
    }
    if (hasEmail)
    {
      paramDataProcessor.startRecordField$505cff1c("email");
      paramDataProcessor.processString(email);
    }
    if (hasStatus)
    {
      paramDataProcessor.startRecordField$505cff1c("status");
      paramDataProcessor.processEnum(status);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasEmail) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarEventAttendee", "email");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new CalendarEventAttendee(name, email, status, hasName, hasEmail, hasStatus);
    }
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
      paramObject = (CalendarEventAttendee)paramObject;
      if (name != null)
      {
        if (name.equals(name)) {}
      }
      else {
        while (name != null) {
          return false;
        }
      }
      if (email != null)
      {
        if (email.equals(email)) {}
      }
      else {
        while (email != null) {
          return false;
        }
      }
      if (status == null) {
        break;
      }
    } while (status.equals(status));
    for (;;)
    {
      return false;
      if (status == null) {
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
    if (hasName) {
      i = PegasusBinaryUtils.getEncodedLength(name) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasEmail) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(email);
    }
    j = i + 1;
    i = j;
    if (hasStatus) {
      i = j + 2;
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
    if (name != null)
    {
      i = name.hashCode();
      if (email == null) {
        break label87;
      }
    }
    label87:
    for (int j = email.hashCode();; j = 0)
    {
      if (status != null) {
        k = status.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CalendarEventAttendee");
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
    label162:
    label234:
    label244:
    label252:
    label254:
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
        localByteBuffer.putInt(-1822729328);
        if (hasName)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasEmail) {
            break label234;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, email);
          if (!hasStatus) {
            break label244;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, status.ordinal());
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label252;
          }
          if (str != null) {
            break label254;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
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
    implements RecordTemplateBuilder<CalendarEventAttendee>
  {
    public String email = null;
    public boolean hasEmail = false;
    public boolean hasName = false;
    public boolean hasStatus = false;
    public String name = null;
    public CalendarEventAttendeeStatus status = null;
    
    public final CalendarEventAttendee build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (CalendarEventAttendee.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new CalendarEventAttendee(name, email, status, hasName, hasEmail, hasStatus);
        if (!hasStatus) {
          status = CalendarEventAttendeeStatus.PENDING;
        }
      } while (hasEmail);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarEventAttendee", "email");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarEventAttendee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */