package com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.HighlightsMiniProfileBuilder;
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

public final class SharedConnectionsInfoBuilder
  implements FissileDataModelBuilder<SharedConnectionsInfo>, DataTemplateBuilder<SharedConnectionsInfo>
{
  public static final SharedConnectionsInfoBuilder INSTANCE = new SharedConnectionsInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("sharedConnections");
    JSON_KEY_STORE.put("totalCount");
  }
  
  public static SharedConnectionsInfo build(DataReader paramDataReader)
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
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("sharedConnections", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            HighlightsMiniProfileBuilder localHighlightsMiniProfileBuilder = HighlightsMiniProfileBuilder.INSTANCE;
            ((List)localObject1).add(HighlightsMiniProfileBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("totalCount", JSON_KEY_STORE))
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
      throw new DataReaderException("Failed to find required field: totalCount when building com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedConnectionsInfo");
    }
    return new SharedConnectionsInfo((Urn)localObject2, (List)localObject1, i, bool3, bool2, bool1);
  }
  
  public static SharedConnectionsInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SharedConnectionsInfo");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SharedConnectionsInfo");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SharedConnectionsInfo");
    }
    if (((ByteBuffer)localObject1).getInt() != 1859413630)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SharedConnectionsInfo");
    }
    localObject2 = null;
    paramString = null;
    int k = 0;
    boolean bool1;
    boolean bool2;
    label252:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1)
      {
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label385;
      }
      bool2 = true;
      if (!bool2) {
        break label403;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label276:
      paramString = localArrayList;
      if (j <= 0) {
        break label403;
      }
      paramString = null;
      i = 1;
      int m = ((ByteBuffer)localObject1).get();
      if (m == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        HighlightsMiniProfileBuilder localHighlightsMiniProfileBuilder = HighlightsMiniProfileBuilder.INSTANCE;
        paramString = HighlightsMiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label391;
        }
        i = 1;
      }
      label330:
      if (m == 1)
      {
        paramString = HighlightsMiniProfileBuilder.INSTANCE;
        paramString = HighlightsMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label397;
        }
      }
    }
    label385:
    label391:
    label397:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label276;
      bool1 = false;
      break;
      bool2 = false;
      break label252;
      i = 0;
      break label330;
    }
    label403:
    if (((ByteBuffer)localObject1).get() == 1) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      i = k;
      if (bool3) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (!bool2) {
        paramString = Collections.emptyList();
      }
      if (bool3) {
        break;
      }
      throw new IOException("Failed to find required field: totalCount when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedConnectionsInfo from fission.");
    }
    return new SharedConnectionsInfo((Urn)localObject2, paramString, i, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedConnectionsInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */