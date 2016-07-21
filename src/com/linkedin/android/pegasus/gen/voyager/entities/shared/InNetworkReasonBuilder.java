package com.linkedin.android.pegasus.gen.voyager.entities.shared;

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

public final class InNetworkReasonBuilder
  implements FissileDataModelBuilder<InNetworkReason>, DataTemplateBuilder<InNetworkReason>
{
  public static final InNetworkReasonBuilder INSTANCE = new InNetworkReasonBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("totalNumberOfConnections");
    JSON_KEY_STORE.put("topConnections");
  }
  
  public static InNetworkReason build(DataReader paramDataReader)
    throws DataReaderException
  {
    int i = 0;
    ArrayList localArrayList = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("totalNumberOfConnections", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("topConnections", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            EntitiesMiniProfileBuilder localEntitiesMiniProfileBuilder = EntitiesMiniProfileBuilder.INSTANCE;
            localArrayList.add(EntitiesMiniProfileBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: totalNumberOfConnections when building com.linkedin.android.pegasus.gen.voyager.entities.shared.InNetworkReason");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: topConnections when building com.linkedin.android.pegasus.gen.voyager.entities.shared.InNetworkReason");
    }
    return new InNetworkReason(i, localArrayList, bool1, bool2);
  }
  
  public static InNetworkReason readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building InNetworkReason");
    }
    Object localObject2 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building InNetworkReason");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building InNetworkReason");
    }
    if (((ByteBuffer)localObject1).getInt() != 1090454533)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building InNetworkReason");
    }
    int j = 0;
    paramString = null;
    boolean bool1;
    boolean bool2;
    label238:
    int k;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        j = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label371;
      }
      bool2 = true;
      if (!bool2) {
        break label389;
      }
      k = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject2 = new ArrayList();
      label262:
      paramString = (String)localObject2;
      if (k <= 0) {
        break label389;
      }
      paramString = null;
      i = 1;
      int m = ((ByteBuffer)localObject1).get();
      if (m == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        EntitiesMiniProfileBuilder localEntitiesMiniProfileBuilder = EntitiesMiniProfileBuilder.INSTANCE;
        paramString = EntitiesMiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label377;
        }
        i = 1;
      }
      label316:
      if (m == 1)
      {
        paramString = EntitiesMiniProfileBuilder.INSTANCE;
        paramString = EntitiesMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label383;
        }
      }
    }
    label371:
    label377:
    label383:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject2).add(paramString);
      }
      k -= 1;
      break label262;
      bool1 = false;
      break;
      bool2 = false;
      break label238;
      i = 0;
      break label316;
    }
    label389:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: totalNumberOfConnections when reading com.linkedin.android.pegasus.gen.voyager.entities.shared.InNetworkReason from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: topConnections when reading com.linkedin.android.pegasus.gen.voyager.entities.shared.InNetworkReason from fission.");
    }
    return new InNetworkReason(j, paramString, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.InNetworkReasonBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */