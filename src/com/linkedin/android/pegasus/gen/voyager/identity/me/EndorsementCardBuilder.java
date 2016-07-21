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
import java.util.ArrayList;
import java.util.List;

public final class EndorsementCardBuilder
  implements FissileDataModelBuilder<EndorsementCard>, DataTemplateBuilder<EndorsementCard>
{
  public static final EndorsementCardBuilder INSTANCE = new EndorsementCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("publishedAt");
    JSON_KEY_STORE.put("endorser");
    JSON_KEY_STORE.put("endorsements");
    JSON_KEY_STORE.put("numEndorsements");
    JSON_KEY_STORE.put("insight");
    JSON_KEY_STORE.put("read");
    JSON_KEY_STORE.put("messageAvailable");
  }
  
  public static EndorsementCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l2 = 0L;
    Object localObject2 = null;
    ArrayList localArrayList = null;
    long l1 = 0L;
    Object localObject1 = null;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("publishedAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("endorser", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ActorMiniProfileBuilder.INSTANCE;
        localObject2 = ActorMiniProfileBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("endorsements", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            EndorsementBuilder localEndorsementBuilder = EndorsementBuilder.INSTANCE;
            localArrayList.add(EndorsementBuilder.build(paramDataReader));
          }
        }
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("numEndorsements", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("insight", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = InsightBuilder.INSTANCE;
        localObject1 = InsightBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("read", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool9 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("messageAvailable", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool8 = paramDataReader.readBoolean();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: publishedAt when building com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: endorser when building com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: endorsements when building com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: read when building com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard");
    }
    return new EndorsementCard(l2, (ActorMiniProfile)localObject2, localArrayList, l1, (Insight)localObject1, bool9, bool8, bool7, bool6, bool5, bool4, bool2, bool3, bool1);
  }
  
  public static EndorsementCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building EndorsementCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building EndorsementCard");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building EndorsementCard");
    }
    if (((ByteBuffer)localObject2).getInt() != -705884018)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building EndorsementCard");
    }
    long l1 = 0L;
    paramString = null;
    localObject1 = null;
    Object localObject3 = null;
    long l2 = 0L;
    Object localObject4 = null;
    InsightBuilder localInsightBuilder = null;
    boolean bool9 = false;
    boolean bool4 = false;
    boolean bool5;
    boolean bool2;
    label259:
    boolean bool1;
    label316:
    label342:
    boolean bool6;
    label354:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool5 = true;
      if (bool5) {
        l1 = ((ByteBuffer)localObject2).getLong();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label497;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = (String)localObject1;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localObject1 = ActorMiniProfileBuilder.INSTANCE;
          paramString = ActorMiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label503;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ActorMiniProfileBuilder.INSTANCE;
          paramString = ActorMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label509;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label515;
      }
      bool6 = true;
      if (!bool6) {
        break label533;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localArrayList = new ArrayList();
      label378:
      localObject3 = localArrayList;
      if (j <= 0) {
        break label533;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        localObject3 = EndorsementBuilder.INSTANCE;
        localObject1 = EndorsementBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label521;
        }
        i = 1;
      }
      label438:
      if (k == 1)
      {
        localObject1 = EndorsementBuilder.INSTANCE;
        localObject1 = EndorsementBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label527;
        }
      }
    }
    label497:
    label503:
    label509:
    label515:
    label521:
    label527:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(localObject1);
      }
      j -= 1;
      break label378;
      bool5 = false;
      break;
      bool2 = false;
      break label259;
      bool1 = false;
      break label316;
      bool1 = false;
      break label342;
      bool6 = false;
      break label354;
      i = 0;
      break label438;
    }
    label533:
    boolean bool7;
    boolean bool3;
    label569:
    label635:
    label664:
    boolean bool8;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool7 = true;
      if (bool7) {
        l2 = ((ByteBuffer)localObject2).getLong();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label759;
      }
      bool3 = true;
      localObject1 = localObject4;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localInsightBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localInsightBuilder = InsightBuilder.INSTANCE;
          localObject1 = InsightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label765;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = InsightBuilder.INSTANCE;
          localObject1 = InsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label771;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label777;
      }
      bool8 = true;
      label676:
      bool3 = bool9;
      if (bool8)
      {
        if (((ByteBuffer)localObject2).get() != 1) {
          break label783;
        }
        bool3 = true;
      }
      label697:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label789;
      }
      bool9 = true;
      label709:
      if (bool9) {
        if (((ByteBuffer)localObject2).get() != 1) {
          break label795;
        }
      }
    }
    label759:
    label765:
    label771:
    label777:
    label783:
    label789:
    label795:
    for (bool4 = true;; bool4 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool5) {
        break label801;
      }
      throw new IOException("Failed to find required field: publishedAt when reading com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard from fission.");
      bool7 = false;
      break;
      bool3 = false;
      break label569;
      bool2 = false;
      break label635;
      bool2 = false;
      break label664;
      bool8 = false;
      break label676;
      bool3 = false;
      break label697;
      bool9 = false;
      break label709;
    }
    label801:
    if (!bool1) {
      throw new IOException("Failed to find required field: endorser when reading com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: endorsements when reading com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard from fission.");
    }
    if (!bool8) {
      throw new IOException("Failed to find required field: read when reading com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard from fission.");
    }
    return new EndorsementCard(l1, paramString, (List)localObject3, l2, (Insight)localObject1, bool3, bool4, bool5, bool1, bool6, bool7, bool2, bool8, bool9);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */