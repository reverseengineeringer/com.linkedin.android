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
import java.util.List;

public final class CalendarUploadTaskBuilder
  implements FissileDataModelBuilder<CalendarUploadTask>, DataTemplateBuilder<CalendarUploadTask>
{
  public static final CalendarUploadTaskBuilder INSTANCE = new CalendarUploadTaskBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("calenderUploadEvents");
    JSON_KEY_STORE.put("source");
    JSON_KEY_STORE.put("startTime");
    JSON_KEY_STORE.put("endTime");
  }
  
  public static CalendarUploadTask build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    CalendarSource localCalendarSource = null;
    long l2 = 0L;
    long l1 = 0L;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("calenderUploadEvents", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            CalendarUploadEventBuilder localCalendarUploadEventBuilder = CalendarUploadEventBuilder.INSTANCE;
            localArrayList.add(CalendarUploadEventBuilder.build(paramDataReader));
          }
        }
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("source", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localCalendarSource = (CalendarSource)paramDataReader.readEnum(CalendarSource.Builder.INSTANCE);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("startTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("endTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: calenderUploadEvents when building com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: startTime when building com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: endTime when building com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask");
    }
    return new CalendarUploadTask(localArrayList, localCalendarSource, l2, l1, bool4, bool3, bool2, bool1);
  }
  
  public static CalendarUploadTask readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CalendarUploadTask");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
          localObject = paramString;
          if (i != 0) {
            break;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            return null;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building CalendarUploadTask");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building CalendarUploadTask");
    }
    if (((ByteBuffer)localObject).getInt() != 1812626023)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building CalendarUploadTask");
    }
    paramString = null;
    localByteBuffer = null;
    long l1 = 0L;
    long l2 = 0L;
    boolean bool1;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (!bool1) {
        break label365;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject);
      localArrayList = new ArrayList();
      label244:
      paramString = localArrayList;
      if (j <= 0) {
        break label365;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
        CalendarUploadEventBuilder localCalendarUploadEventBuilder = CalendarUploadEventBuilder.INSTANCE;
        paramString = CalendarUploadEventBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label353;
        }
        i = 1;
      }
      label298:
      if (k == 1)
      {
        paramString = CalendarUploadEventBuilder.INSTANCE;
        paramString = CalendarUploadEventBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject, null, paramFissionTransaction);
        if (paramString == null) {
          break label359;
        }
      }
    }
    label353:
    label359:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label244;
      bool1 = false;
      break;
      i = 0;
      break label298;
    }
    label365:
    boolean bool2;
    boolean bool3;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      paramFissionTransaction = localByteBuffer;
      if (bool2) {
        paramFissionTransaction = CalendarSource.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label478;
      }
      bool3 = true;
      label409:
      if (bool3) {
        l1 = ((ByteBuffer)localObject).getLong();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label484;
      }
    }
    label478:
    label484:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (bool4) {
        l2 = ((ByteBuffer)localObject).getLong();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label490;
      }
      throw new IOException("Failed to find required field: calenderUploadEvents when reading com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask from fission.");
      bool2 = false;
      break;
      bool3 = false;
      break label409;
    }
    label490:
    if (!bool3) {
      throw new IOException("Failed to find required field: startTime when reading com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: endTime when reading com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask from fission.");
    }
    return new CalendarUploadTask(paramString, paramFissionTransaction, l1, l2, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTaskBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */