package com.linkedin.android.pegasus.gen.voyager.entities.shared;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class JobApplyingInfoBuilder
  implements FissileDataModelBuilder<JobApplyingInfo>, DataTemplateBuilder<JobApplyingInfo>
{
  public static final JobApplyingInfoBuilder INSTANCE = new JobApplyingInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("applied");
    JSON_KEY_STORE.put("appliedTime");
    JSON_KEY_STORE.put("appliedAt");
  }
  
  public static JobApplyingInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    boolean bool5 = false;
    long l2 = 0L;
    long l1 = 0L;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = UrnCoercer.INSTANCE;
        localObject = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("applied", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool5 = paramDataReader.readBoolean();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("appliedTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("appliedAt", JSON_KEY_STORE))
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
      throw new DataReaderException("Failed to find required field: applied when building com.linkedin.android.pegasus.gen.voyager.entities.shared.JobApplyingInfo");
    }
    return new JobApplyingInfo((Urn)localObject, bool5, l2, l1, bool3, bool4, bool2, bool1);
  }
  
  public static JobApplyingInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building JobApplyingInfo");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building JobApplyingInfo");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building JobApplyingInfo");
    }
    if (((ByteBuffer)localObject).getInt() != 1046571988)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building JobApplyingInfo");
    }
    paramString = null;
    boolean bool1 = false;
    long l1 = 0L;
    long l2 = 0L;
    boolean bool2;
    boolean bool3;
    label253:
    label270:
    boolean bool4;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      if (bool2)
      {
        paramString = UrnCoercer.INSTANCE;
        paramString = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label351;
      }
      bool3 = true;
      if (bool3)
      {
        if (((ByteBuffer)localObject).get() != 1) {
          break label357;
        }
        bool1 = true;
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label363;
      }
      bool4 = true;
      label282:
      if (bool4) {
        l1 = ((ByteBuffer)localObject).getLong();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label369;
      }
    }
    label351:
    label357:
    label363:
    label369:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (bool5) {
        l2 = ((ByteBuffer)localObject).getLong();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool3) {
        break label375;
      }
      throw new IOException("Failed to find required field: applied when reading com.linkedin.android.pegasus.gen.voyager.entities.shared.JobApplyingInfo from fission.");
      bool2 = false;
      break;
      bool3 = false;
      break label253;
      bool1 = false;
      break label270;
      bool4 = false;
      break label282;
    }
    label375:
    return new JobApplyingInfo(paramString, bool1, l1, l2, bool2, bool3, bool4, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.JobApplyingInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */