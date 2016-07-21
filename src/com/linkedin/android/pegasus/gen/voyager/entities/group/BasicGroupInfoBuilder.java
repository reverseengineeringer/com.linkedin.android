package com.linkedin.android.pegasus.gen.voyager.entities.group;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroupBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class BasicGroupInfoBuilder
  implements FissileDataModelBuilder<BasicGroupInfo>, DataTemplateBuilder<BasicGroupInfo>
{
  public static final BasicGroupInfoBuilder INSTANCE = new BasicGroupInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniGroup");
    JSON_KEY_STORE.put("memberCount");
  }
  
  public static BasicGroupInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    int i = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("miniGroup", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = MiniGroupBuilder.INSTANCE;
        localObject = MiniGroupBuilder.build(paramDataReader);
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("memberCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: miniGroup when building com.linkedin.android.pegasus.gen.voyager.entities.group.BasicGroupInfo");
    }
    return new BasicGroupInfo((MiniGroup)localObject, i, bool1, bool2);
  }
  
  public static BasicGroupInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building BasicGroupInfo");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building BasicGroupInfo");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building BasicGroupInfo");
    }
    if (((ByteBuffer)localObject1).getInt() != -842627211)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building BasicGroupInfo");
    }
    paramString = null;
    localObject2 = null;
    int i = 0;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject1).get();
        bool1 = bool2;
        paramString = (String)localObject2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localObject2 = MiniGroupBuilder.INSTANCE;
          paramString = MiniGroupBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label357;
          }
          bool1 = true;
        }
        label274:
        if (j == 1)
        {
          paramString = MiniGroupBuilder.INSTANCE;
          paramString = MiniGroupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label363;
          }
          bool1 = true;
        }
      }
      label300:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label369;
      }
    }
    label357:
    label363:
    label369:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (bool2) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label375;
      }
      throw new IOException("Failed to find required field: miniGroup when reading com.linkedin.android.pegasus.gen.voyager.entities.group.BasicGroupInfo from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label274;
      bool1 = false;
      break label300;
    }
    label375:
    return new BasicGroupInfo(paramString, i, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.group.BasicGroupInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */