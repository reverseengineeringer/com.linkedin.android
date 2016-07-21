package com.linkedin.android.pegasus.gen.voyager.growth.calendar;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CalendarEventAttendeeBuilder
  implements FissileDataModelBuilder<CalendarEventAttendee>, DataTemplateBuilder<CalendarEventAttendee>
{
  public static final CalendarEventAttendeeBuilder INSTANCE = new CalendarEventAttendeeBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("name");
    JSON_KEY_STORE.put("email");
    JSON_KEY_STORE.put("status");
  }
  
  public static CalendarEventAttendee build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    CalendarEventAttendeeStatus localCalendarEventAttendeeStatus = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("name", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("email", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("status", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localCalendarEventAttendeeStatus = (CalendarEventAttendeeStatus)paramDataReader.readEnum(CalendarEventAttendeeStatus.Builder.INSTANCE);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      localCalendarEventAttendeeStatus = CalendarEventAttendeeStatus.PENDING;
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: email when building com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarEventAttendee");
    }
    return new CalendarEventAttendee(str2, str1, localCalendarEventAttendeeStatus, bool3, bool2, bool1);
  }
  
  public static CalendarEventAttendee readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool3 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CalendarEventAttendee");
    }
    Object localObject2 = paramByteBuffer;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      int i = paramString.get();
      int j;
      do
      {
        do
        {
          localObject1 = paramString;
          if (i != 0) {
            break label170;
          }
          localObject1 = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject1 = paramFissionAdapter.readFromCache((String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break;
          }
          j = ((ByteBuffer)localObject1).get();
          paramString = (String)localObject1;
          i = j;
        } while (j == 1);
        paramString = (String)localObject1;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building CalendarEventAttendee");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building CalendarEventAttendee");
    }
    label170:
    if (((ByteBuffer)localObject1).getInt() != -1822729328)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building CalendarEventAttendee");
    }
    paramFissionTransaction = null;
    localObject2 = null;
    paramString = null;
    boolean bool1;
    boolean bool2;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label326;
      }
      bool2 = true;
      label243:
      if (bool2) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label332;
      }
    }
    for (;;)
    {
      if (bool3) {
        paramString = CalendarEventAttendeeStatus.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (!bool3) {
        paramString = CalendarEventAttendeeStatus.PENDING;
      }
      if (bool2) {
        break label338;
      }
      throw new IOException("Failed to find required field: email when reading com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarEventAttendee from fission.");
      bool1 = false;
      break;
      label326:
      bool2 = false;
      break label243;
      label332:
      bool3 = false;
    }
    label338:
    return new CalendarEventAttendee(paramFissionTransaction, (String)localObject2, paramString, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarEventAttendeeBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */