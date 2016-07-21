package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

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

public final class SimpleTaskInfoBuilder
  implements FissileDataModelBuilder<SimpleTaskInfo>, DataTemplateBuilder<SimpleTaskInfo>
{
  public static final SimpleTaskInfoBuilder INSTANCE = new SimpleTaskInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("simpleTaskType");
    JSON_KEY_STORE.put("taskName");
  }
  
  public static SimpleTaskInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    SimpleTaskTypes localSimpleTaskTypes = null;
    TaskNames localTaskNames = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("simpleTaskType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSimpleTaskTypes = (SimpleTaskTypes)paramDataReader.readEnum(SimpleTaskTypes.Builder.INSTANCE);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("taskName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localTaskNames = (TaskNames)paramDataReader.readEnum(TaskNames.Builder.INSTANCE);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: simpleTaskType when building com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SimpleTaskInfo");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: taskName when building com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SimpleTaskInfo");
    }
    return new SimpleTaskInfo(localSimpleTaskTypes, localTaskNames, bool2, bool1);
  }
  
  public static SimpleTaskInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SimpleTaskInfo");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
          localObject = paramString;
          if (i != 0) {
            break label170;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            break;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building SimpleTaskInfo");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building SimpleTaskInfo");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != 1421251770)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building SimpleTaskInfo");
    }
    paramString = null;
    paramFissionTransaction = null;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = SimpleTaskTypes.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label290;
      }
    }
    for (;;)
    {
      if (bool2) {
        paramFissionTransaction = TaskNames.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label296;
      }
      throw new IOException("Failed to find required field: simpleTaskType when reading com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SimpleTaskInfo from fission.");
      bool1 = false;
      break;
      label290:
      bool2 = false;
    }
    label296:
    if (!bool2) {
      throw new IOException("Failed to find required field: taskName when reading com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SimpleTaskInfo from fission.");
    }
    return new SimpleTaskInfo(paramString, paramFissionTransaction, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SimpleTaskInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */