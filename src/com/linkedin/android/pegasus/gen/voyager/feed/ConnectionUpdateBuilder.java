package com.linkedin.android.pegasus.gen.voyager.feed;

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

public final class ConnectionUpdateBuilder
  implements FissileDataModelBuilder<ConnectionUpdate>, DataTemplateBuilder<ConnectionUpdate>
{
  public static final ConnectionUpdateBuilder INSTANCE = new ConnectionUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("actor");
    JSON_KEY_STORE.put("newConnection");
  }
  
  public static ConnectionUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("actor", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = SocialActorBuilder.INSTANCE;
        localObject2 = SocialActorBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("newConnection", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = PersonObjectBuilder.INSTANCE;
        localObject1 = PersonObjectBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: actor when building com.linkedin.android.pegasus.gen.voyager.feed.ConnectionUpdate");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: newConnection when building com.linkedin.android.pegasus.gen.voyager.feed.ConnectionUpdate");
    }
    return new ConnectionUpdate((SocialActor)localObject2, (PersonObject)localObject1, bool2, bool1);
  }
  
  public static ConnectionUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ConnectionUpdate");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ConnectionUpdate");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ConnectionUpdate");
    }
    if (((ByteBuffer)localObject2).getInt() != -317751672)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building ConnectionUpdate");
    }
    paramString = null;
    SocialActorBuilder localSocialActorBuilder = null;
    localObject1 = null;
    PersonObjectBuilder localPersonObjectBuilder = null;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localSocialActorBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localSocialActorBuilder = SocialActorBuilder.INSTANCE;
          paramString = SocialActorBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label439;
          }
          bool1 = true;
        }
        label277:
        if (i == 1)
        {
          paramString = SocialActorBuilder.INSTANCE;
          paramString = SocialActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label445;
          }
          bool1 = true;
        }
      }
      label303:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label451;
      }
      bool2 = true;
      label315:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localPersonObjectBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localPersonObjectBuilder = PersonObjectBuilder.INSTANCE;
          localObject1 = PersonObjectBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label457;
          }
          bool2 = true;
        }
        label373:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = PersonObjectBuilder.INSTANCE;
          localObject1 = PersonObjectBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label463;
          }
        }
      }
    }
    label439:
    label445:
    label451:
    label457:
    label463:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label469;
      }
      throw new IOException("Failed to find required field: actor when reading com.linkedin.android.pegasus.gen.voyager.feed.ConnectionUpdate from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label277;
      bool1 = false;
      break label303;
      bool2 = false;
      break label315;
      bool2 = false;
      break label373;
    }
    label469:
    if (!bool3) {
      throw new IOException("Failed to find required field: newConnection when reading com.linkedin.android.pegasus.gen.voyager.feed.ConnectionUpdate from fission.");
    }
    return new ConnectionUpdate(paramString, (PersonObject)localObject1, bool1, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ConnectionUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */