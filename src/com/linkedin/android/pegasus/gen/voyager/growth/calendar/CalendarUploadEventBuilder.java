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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CalendarUploadEventBuilder
  implements FissileDataModelBuilder<CalendarUploadEvent>, DataTemplateBuilder<CalendarUploadEvent>
{
  public static final CalendarUploadEventBuilder INSTANCE = new CalendarUploadEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("externalId");
    JSON_KEY_STORE.put("source");
    JSON_KEY_STORE.put("startTime");
    JSON_KEY_STORE.put("endTime");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("location");
    JSON_KEY_STORE.put("fullDayEvent");
    JSON_KEY_STORE.put("recurring");
    JSON_KEY_STORE.put("attendees");
    JSON_KEY_STORE.put("status");
  }
  
  public static CalendarUploadEvent build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    CalendarSource localCalendarSource = null;
    long l2 = 0L;
    long l1 = 0L;
    String str2 = null;
    String str1 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject = null;
    CalendarEventAvailability localCalendarEventAvailability = null;
    boolean bool12 = false;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("externalId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("source", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localCalendarSource = (CalendarSource)paramDataReader.readEnum(CalendarSource.Builder.INSTANCE);
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("startTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("endTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("location", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("fullDayEvent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool2 = paramDataReader.readBoolean();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("recurring", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool1 = paramDataReader.readBoolean();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("attendees", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            CalendarEventAttendeeBuilder localCalendarEventAttendeeBuilder = CalendarEventAttendeeBuilder.INSTANCE;
            ((List)localObject).add(CalendarEventAttendeeBuilder.build(paramDataReader));
          }
        }
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("status", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localCalendarEventAvailability = (CalendarEventAvailability)paramDataReader.readEnum(CalendarEventAvailability.Builder.INSTANCE);
        bool3 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool7) {
      bool2 = false;
    }
    if (!bool5) {
      bool1 = false;
    }
    if (!bool4) {
      localObject = Collections.emptyList();
    }
    if (!bool3) {
      localCalendarEventAvailability = CalendarEventAvailability.NOT_SUPPORTED;
    }
    if (!bool12) {
      throw new DataReaderException("Failed to find required field: externalId when building com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent");
    }
    if (!bool11) {
      throw new DataReaderException("Failed to find required field: source when building com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent");
    }
    if (!bool10) {
      throw new DataReaderException("Failed to find required field: startTime when building com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent");
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: endTime when building com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent");
    }
    return new CalendarUploadEvent(str3, localCalendarSource, l2, l1, str2, str1, bool2, bool1, (List)localObject, localCalendarEventAvailability, bool12, bool11, bool10, bool9, bool8, bool6, bool7, bool5, bool4, bool3);
  }
  
  public static CalendarUploadEvent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CalendarUploadEvent");
    }
    Object localObject2 = paramByteBuffer;
    int j;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      i = paramString.get();
      do
      {
        do
        {
          localObject1 = paramString;
          if (i != 0) {
            break;
          }
          localObject1 = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject1 = paramFissionAdapter.readFromCache((String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            return null;
          }
          j = ((ByteBuffer)localObject1).get();
          paramString = (String)localObject1;
          i = j;
        } while (j == 1);
        paramString = (String)localObject1;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building CalendarUploadEvent");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building CalendarUploadEvent");
    }
    if (((ByteBuffer)localObject1).getInt() != 1166889098)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building CalendarUploadEvent");
    }
    localObject2 = null;
    CalendarSource localCalendarSource = null;
    long l1 = 0L;
    long l2 = 0L;
    String str1 = null;
    String str2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramString = null;
    Object localObject3 = null;
    boolean bool3;
    boolean bool4;
    label265:
    boolean bool5;
    label295:
    boolean bool6;
    label319:
    boolean bool7;
    label343:
    boolean bool8;
    label370:
    boolean bool9;
    label397:
    label414:
    boolean bool10;
    label426:
    label443:
    boolean bool11;
    label455:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label588;
      }
      bool4 = true;
      if (bool4) {
        localCalendarSource = CalendarSource.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label594;
      }
      bool5 = true;
      if (bool5) {
        l1 = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label600;
      }
      bool6 = true;
      if (bool6) {
        l2 = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label606;
      }
      bool7 = true;
      if (bool7) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label612;
      }
      bool8 = true;
      if (bool8) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label618;
      }
      bool9 = true;
      if (bool9)
      {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label624;
        }
        bool1 = true;
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label630;
      }
      bool10 = true;
      if (bool10)
      {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label636;
        }
        bool2 = true;
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label642;
      }
      bool11 = true;
      if (!bool11) {
        break label660;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label479:
      paramString = localArrayList;
      if (j <= 0) {
        break label660;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        CalendarEventAttendeeBuilder localCalendarEventAttendeeBuilder = CalendarEventAttendeeBuilder.INSTANCE;
        paramString = CalendarEventAttendeeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label648;
        }
        i = 1;
      }
      label533:
      if (k == 1)
      {
        paramString = CalendarEventAttendeeBuilder.INSTANCE;
        paramString = CalendarEventAttendeeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label654;
        }
      }
    }
    label588:
    label594:
    label600:
    label606:
    label612:
    label618:
    label624:
    label630:
    label636:
    label642:
    label648:
    label654:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label479;
      bool3 = false;
      break;
      bool4 = false;
      break label265;
      bool5 = false;
      break label295;
      bool6 = false;
      break label319;
      bool7 = false;
      break label343;
      bool8 = false;
      break label370;
      bool9 = false;
      break label397;
      bool1 = false;
      break label414;
      bool10 = false;
      break label426;
      bool2 = false;
      break label443;
      bool11 = false;
      break label455;
      i = 0;
      break label533;
    }
    label660:
    if (((ByteBuffer)localObject1).get() == 1) {}
    for (boolean bool12 = true;; bool12 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool12) {
        paramFissionTransaction = CalendarEventAvailability.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (!bool9) {
        bool1 = false;
      }
      if (!bool10) {
        bool2 = false;
      }
      if (!bool11) {
        paramString = Collections.emptyList();
      }
      if (!bool12) {
        paramFissionTransaction = CalendarEventAvailability.NOT_SUPPORTED;
      }
      if (bool3) {
        break;
      }
      throw new IOException("Failed to find required field: externalId when reading com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: source when reading com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: startTime when reading com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: endTime when reading com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent from fission.");
    }
    return new CalendarUploadEvent((String)localObject2, localCalendarSource, l1, l2, str1, str2, bool1, bool2, paramString, paramFissionTransaction, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */