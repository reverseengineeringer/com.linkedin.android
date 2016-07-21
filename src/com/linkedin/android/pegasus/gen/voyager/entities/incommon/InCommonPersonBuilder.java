package com.linkedin.android.pegasus.gen.voyager.entities.incommon;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistance;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistanceBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
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

public final class InCommonPersonBuilder
  implements FissileDataModelBuilder<InCommonPerson>, DataTemplateBuilder<InCommonPerson>
{
  public static final InCommonPersonBuilder INSTANCE = new InCommonPersonBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("member");
    JSON_KEY_STORE.put("people");
    JSON_KEY_STORE.put("total");
  }
  
  public static InCommonPerson build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("member", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MiniProfileWithDistanceBuilder.INSTANCE;
        localObject2 = MiniProfileWithDistanceBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("people", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            MiniProfileBuilder localMiniProfileBuilder = MiniProfileBuilder.INSTANCE;
            ((List)localObject1).add(MiniProfileBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("total", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: total when building com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson");
    }
    return new InCommonPerson((MiniProfileWithDistance)localObject2, (List)localObject1, i, bool3, bool2, bool1);
  }
  
  public static InCommonPerson readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building InCommonPerson");
    }
    Object localObject1 = paramByteBuffer;
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
          localObject2 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building InCommonPerson");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building InCommonPerson");
    }
    if (((ByteBuffer)localObject2).getInt() != -667758660)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building InCommonPerson");
    }
    paramString = null;
    Object localObject3 = null;
    localObject1 = null;
    int k = 0;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = (String)localObject3;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localObject3 = MiniProfileWithDistanceBuilder.INSTANCE;
          paramString = MiniProfileWithDistanceBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label458;
          }
          bool1 = true;
        }
        label277:
        if (i == 1)
        {
          paramString = MiniProfileWithDistanceBuilder.INSTANCE;
          paramString = MiniProfileWithDistanceBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label464;
          }
          bool1 = true;
        }
      }
      label303:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label470;
      }
      bool2 = true;
      label315:
      if (!bool2) {
        break label488;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject3 = new ArrayList();
      label339:
      localObject1 = localObject3;
      if (j <= 0) {
        break label488;
      }
      localObject1 = null;
      i = 1;
      int m = ((ByteBuffer)localObject2).get();
      if (m == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        MiniProfileBuilder localMiniProfileBuilder = MiniProfileBuilder.INSTANCE;
        localObject1 = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label476;
        }
        i = 1;
      }
      label399:
      if (m == 1)
      {
        localObject1 = MiniProfileBuilder.INSTANCE;
        localObject1 = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label482;
        }
      }
    }
    label458:
    label464:
    label470:
    label476:
    label482:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject3).add(localObject1);
      }
      j -= 1;
      break label339;
      bool2 = false;
      break;
      bool1 = false;
      break label277;
      bool1 = false;
      break label303;
      bool2 = false;
      break label315;
      i = 0;
      break label399;
    }
    label488:
    if (((ByteBuffer)localObject2).get() == 1) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      i = k;
      if (bool3) {
        i = ((ByteBuffer)localObject2).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (!bool2) {
        localObject1 = Collections.emptyList();
      }
      if (bool3) {
        break;
      }
      throw new IOException("Failed to find required field: total when reading com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson from fission.");
    }
    return new InCommonPerson(paramString, (List)localObject1, i, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPersonBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */