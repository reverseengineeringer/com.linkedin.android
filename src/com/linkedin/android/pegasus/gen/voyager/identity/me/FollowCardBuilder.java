package com.linkedin.android.pegasus.gen.voyager.identity.me;

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

public final class FollowCardBuilder
  implements FissileDataModelBuilder<FollowCard>, DataTemplateBuilder<FollowCard>
{
  public static final FollowCardBuilder INSTANCE = new FollowCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("publishedAt");
    JSON_KEY_STORE.put("follower");
    JSON_KEY_STORE.put("read");
    JSON_KEY_STORE.put("occupation");
  }
  
  public static FollowCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    Object localObject2 = null;
    boolean bool5 = false;
    Object localObject1 = null;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("publishedAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("follower", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ActorMiniProfileBuilder.INSTANCE;
        localObject2 = ActorMiniProfileBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("read", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool5 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("occupation", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = OccupationBuilder.INSTANCE;
        localObject1 = OccupationBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: publishedAt when building com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: follower when building com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: read when building com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard");
    }
    return new FollowCard(l, (ActorMiniProfile)localObject2, bool5, (Occupation)localObject1, bool4, bool2, bool3, bool1);
  }
  
  public static FollowCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building FollowCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building FollowCard");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building FollowCard");
    }
    if (((ByteBuffer)localObject2).getInt() != 2126636997)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building FollowCard");
    }
    long l = 0L;
    paramString = null;
    ActorMiniProfileBuilder localActorMiniProfileBuilder = null;
    boolean bool4 = false;
    localObject1 = null;
    OccupationBuilder localOccupationBuilder = null;
    boolean bool5;
    boolean bool2;
    label250:
    boolean bool1;
    label307:
    label333:
    boolean bool6;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool5 = true;
      if (bool5) {
        l = ((ByteBuffer)localObject2).getLong();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label498;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localActorMiniProfileBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localActorMiniProfileBuilder = ActorMiniProfileBuilder.INSTANCE;
          paramString = ActorMiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label504;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ActorMiniProfileBuilder.INSTANCE;
          paramString = ActorMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label510;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label516;
      }
      bool6 = true;
      label345:
      if (bool6)
      {
        if (((ByteBuffer)localObject2).get() != 1) {
          break label522;
        }
        bool4 = true;
      }
      label362:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label528;
      }
      bool2 = true;
      label374:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localOccupationBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localOccupationBuilder = OccupationBuilder.INSTANCE;
          localObject1 = OccupationBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label534;
          }
          bool2 = true;
        }
        label432:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = OccupationBuilder.INSTANCE;
          localObject1 = OccupationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label540;
          }
        }
      }
    }
    label498:
    label504:
    label510:
    label516:
    label522:
    label528:
    label534:
    label540:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool5) {
        break label546;
      }
      throw new IOException("Failed to find required field: publishedAt when reading com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard from fission.");
      bool5 = false;
      break;
      bool2 = false;
      break label250;
      bool1 = false;
      break label307;
      bool1 = false;
      break label333;
      bool6 = false;
      break label345;
      bool4 = false;
      break label362;
      bool2 = false;
      break label374;
      bool2 = false;
      break label432;
    }
    label546:
    if (!bool1) {
      throw new IOException("Failed to find required field: follower when reading com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: read when reading com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard from fission.");
    }
    return new FollowCard(l, paramString, bool4, (Occupation)localObject1, bool5, bool1, bool6, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */