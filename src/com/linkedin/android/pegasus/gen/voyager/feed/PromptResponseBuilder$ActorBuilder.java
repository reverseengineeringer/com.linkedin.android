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

public final class PromptResponseBuilder$ActorBuilder
  implements FissileDataModelBuilder<PromptResponse.Actor>, DataTemplateBuilder<PromptResponse.Actor>
{
  public static final ActorBuilder INSTANCE = new ActorBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.feed.MemberActor");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.InfluencerActor");
  }
  
  public static PromptResponse.Actor build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.MemberActor", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = MemberActorBuilder.INSTANCE;
        localObject1 = MemberActorBuilder.build(paramDataReader);
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.InfluencerActor", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = InfluencerActorBuilder.INSTANCE;
        localObject2 = InfluencerActorBuilder.build(paramDataReader);
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int i = 0;
    if (bool1) {
      i = 1;
    }
    if ((bool2) && (i != 0)) {
      throw new DataReaderException("Found more than 1 member when building .Actor");
    }
    return new PromptResponse.Actor((MemberActor)localObject1, (InfluencerActor)localObject2, bool1, bool2);
  }
  
  public static PromptResponse.Actor readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PromptResponse.Actor");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PromptResponse.Actor");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building PromptResponse.Actor");
    }
    if (((ByteBuffer)localObject2).getInt() != -646861655)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building PromptResponse.Actor");
    }
    paramString = null;
    MemberActorBuilder localMemberActorBuilder = null;
    localObject1 = null;
    InfluencerActorBuilder localInfluencerActorBuilder = null;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        bool1 = bool2;
        paramString = localMemberActorBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMemberActorBuilder = MemberActorBuilder.INSTANCE;
          paramString = MemberActorBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label455;
          }
          bool1 = true;
        }
        label277:
        if (i == 1)
        {
          paramString = MemberActorBuilder.INSTANCE;
          paramString = MemberActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label461;
          }
          bool1 = true;
        }
      }
      label303:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label467;
      }
      bool2 = true;
      label315:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localInfluencerActorBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localInfluencerActorBuilder = InfluencerActorBuilder.INSTANCE;
          localObject1 = InfluencerActorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label473;
          }
          bool2 = true;
        }
        label373:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = InfluencerActorBuilder.INSTANCE;
          localObject1 = InfluencerActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label479;
          }
        }
      }
    }
    label455:
    label461:
    label467:
    label473:
    label479:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      i = 0;
      if (bool1) {
        i = 1;
      }
      if ((!bool3) || (i == 0)) {
        break label485;
      }
      throw new IOException("Found more than 1 member when reading .Actor from fission.");
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
    label485:
    return new PromptResponse.Actor(paramString, (InfluencerActor)localObject1, bool1, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseBuilder.ActorBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */