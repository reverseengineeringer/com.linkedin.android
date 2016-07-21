package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesJobRecommendationBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class JymbiiNotificationCardBuilder
  implements FissileDataModelBuilder<JymbiiNotificationCard>, DataTemplateBuilder<JymbiiNotificationCard>
{
  public static final JymbiiNotificationCardBuilder INSTANCE = new JymbiiNotificationCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("publishedAt");
    JSON_KEY_STORE.put("jobsCount");
    JSON_KEY_STORE.put("jobRecommendations");
    JSON_KEY_STORE.put("read");
  }
  
  public static JymbiiNotificationCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l2 = 0L;
    long l1 = 0L;
    ArrayList localArrayList = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("publishedAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("jobsCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("jobRecommendations", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            EntitiesJobRecommendationBuilder localEntitiesJobRecommendationBuilder = EntitiesJobRecommendationBuilder.INSTANCE;
            localArrayList.add(EntitiesJobRecommendationBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("read", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool5 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: publishedAt when building com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: jobsCount when building com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: jobRecommendations when building com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: read when building com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard");
    }
    return new JymbiiNotificationCard(l2, l1, localArrayList, bool5, bool4, bool3, bool1, bool2);
  }
  
  public static JymbiiNotificationCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building JymbiiNotificationCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building JymbiiNotificationCard");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building JymbiiNotificationCard");
    }
    if (((ByteBuffer)localObject1).getInt() != -163684268)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building JymbiiNotificationCard");
    }
    long l1 = 0L;
    long l2 = 0L;
    paramString = null;
    boolean bool1 = false;
    boolean bool2;
    boolean bool3;
    label244:
    boolean bool4;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      if (bool2) {
        l1 = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label401;
      }
      bool3 = true;
      if (bool3) {
        l2 = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label407;
      }
      bool4 = true;
      label268:
      if (!bool4) {
        break label425;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject2 = new ArrayList();
      label292:
      paramString = (String)localObject2;
      if (j <= 0) {
        break label425;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        EntitiesJobRecommendationBuilder localEntitiesJobRecommendationBuilder = EntitiesJobRecommendationBuilder.INSTANCE;
        paramString = EntitiesJobRecommendationBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label413;
        }
        i = 1;
      }
      label346:
      if (k == 1)
      {
        paramString = EntitiesJobRecommendationBuilder.INSTANCE;
        paramString = EntitiesJobRecommendationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label419;
        }
      }
    }
    label401:
    label407:
    label413:
    label419:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject2).add(paramString);
      }
      j -= 1;
      break label292;
      bool2 = false;
      break;
      bool3 = false;
      break label244;
      bool4 = false;
      break label268;
      i = 0;
      break label346;
    }
    label425:
    boolean bool5;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool5 = true;
      if (bool5) {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label487;
        }
      }
    }
    label487:
    for (bool1 = true;; bool1 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool2) {
        break label493;
      }
      throw new IOException("Failed to find required field: publishedAt when reading com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard from fission.");
      bool5 = false;
      break;
    }
    label493:
    if (!bool3) {
      throw new IOException("Failed to find required field: jobsCount when reading com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: jobRecommendations when reading com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: read when reading com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard from fission.");
    }
    return new JymbiiNotificationCard(l1, l2, paramString, bool1, bool2, bool3, bool4, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */