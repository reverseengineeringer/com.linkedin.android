package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJobBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedConnectionsInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedConnectionsInfoBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchJobBuilder
  implements FissileDataModelBuilder<SearchJob>, DataTemplateBuilder<SearchJob>
{
  public static final SearchJobBuilder INSTANCE = new SearchJobBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("backendUrn");
    JSON_KEY_STORE.put("job");
    JSON_KEY_STORE.put("companyName");
    JSON_KEY_STORE.put("sharedConnectionsInfo");
  }
  
  public static SearchJob build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    String str1 = null;
    Object localObject1 = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("backendUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("job", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MiniJobBuilder.INSTANCE;
        localObject2 = MiniJobBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("companyName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("sharedConnectionsInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = SharedConnectionsInfoBuilder.INSTANCE;
        localObject1 = SharedConnectionsInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: id when building com.linkedin.android.pegasus.gen.voyager.search.SearchJob");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: backendUrn when building com.linkedin.android.pegasus.gen.voyager.search.SearchJob");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: job when building com.linkedin.android.pegasus.gen.voyager.search.SearchJob");
    }
    return new SearchJob(str2, (Urn)localObject3, (MiniJob)localObject2, str1, (SharedConnectionsInfo)localObject1, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static SearchJob readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SearchJob");
    }
    Object localObject1 = paramByteBuffer;
    int i;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      i = paramString.get();
      int j;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchJob");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchJob");
    }
    if (((ByteBuffer)localObject2).getInt() != -657004922)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building SearchJob");
    }
    String str1 = null;
    Object localObject3 = null;
    paramString = null;
    MiniJobBuilder localMiniJobBuilder = null;
    String str2 = null;
    localObject1 = null;
    SharedConnectionsInfoBuilder localSharedConnectionsInfoBuilder = null;
    boolean bool4;
    boolean bool5;
    label256:
    boolean bool2;
    label291:
    boolean bool1;
    label348:
    label374:
    boolean bool6;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label537;
      }
      bool5 = true;
      if (bool5)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label543;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localMiniJobBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMiniJobBuilder = MiniJobBuilder.INSTANCE;
          paramString = MiniJobBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label549;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniJobBuilder.INSTANCE;
          paramString = MiniJobBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label555;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label561;
      }
      bool6 = true;
      label386:
      if (bool6) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label567;
      }
      bool2 = true;
      label413:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localSharedConnectionsInfoBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localSharedConnectionsInfoBuilder = SharedConnectionsInfoBuilder.INSTANCE;
          localObject1 = SharedConnectionsInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label573;
          }
          bool2 = true;
        }
        label471:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = SharedConnectionsInfoBuilder.INSTANCE;
          localObject1 = SharedConnectionsInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label579;
          }
        }
      }
    }
    label537:
    label543:
    label549:
    label555:
    label561:
    label567:
    label573:
    label579:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool4) {
        break label585;
      }
      throw new IOException("Failed to find required field: id when reading com.linkedin.android.pegasus.gen.voyager.search.SearchJob from fission.");
      bool4 = false;
      break;
      bool5 = false;
      break label256;
      bool2 = false;
      break label291;
      bool1 = false;
      break label348;
      bool1 = false;
      break label374;
      bool6 = false;
      break label386;
      bool2 = false;
      break label413;
      bool2 = false;
      break label471;
    }
    label585:
    if (!bool5) {
      throw new IOException("Failed to find required field: backendUrn when reading com.linkedin.android.pegasus.gen.voyager.search.SearchJob from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: job when reading com.linkedin.android.pegasus.gen.voyager.search.SearchJob from fission.");
    }
    return new SearchJob(str1, (Urn)localObject3, paramString, str2, (SharedConnectionsInfo)localObject1, bool4, bool5, bool1, bool6, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchJobBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */