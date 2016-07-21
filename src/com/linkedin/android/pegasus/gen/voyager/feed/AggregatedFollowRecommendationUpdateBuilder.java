package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
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

public final class AggregatedFollowRecommendationUpdateBuilder
  implements FissileDataModelBuilder<AggregatedFollowRecommendationUpdate>, DataTemplateBuilder<AggregatedFollowRecommendationUpdate>
{
  public static final AggregatedFollowRecommendationUpdateBuilder INSTANCE = new AggregatedFollowRecommendationUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("actions");
    JSON_KEY_STORE.put("followRecommendationUpdates");
    JSON_KEY_STORE.put("recommendationText");
  }
  
  public static AggregatedFollowRecommendationUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject1 = null;
    ArrayList localArrayList = null;
    Object localObject2 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299())
    {
      Object localObject3;
      if (paramDataReader.shouldReadField$11ca93e7("actions", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            localObject3 = UpdateActionBuilder.INSTANCE;
            ((List)localObject1).add(UpdateActionBuilder.build(paramDataReader));
          }
        }
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("followRecommendationUpdates", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            localObject3 = UpdateBuilder.INSTANCE;
            localArrayList.add(UpdateBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("recommendationText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = AttributedTextBuilder.INSTANCE;
        localObject2 = AttributedTextBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      localObject1 = Collections.emptyList();
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: followRecommendationUpdates when building com.linkedin.android.pegasus.gen.voyager.feed.AggregatedFollowRecommendationUpdate");
    }
    return new AggregatedFollowRecommendationUpdate((List)localObject1, localArrayList, (AttributedText)localObject2, bool3, bool2, bool1);
  }
  
  public static AggregatedFollowRecommendationUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building AggregatedFollowRecommendationUpdate");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building AggregatedFollowRecommendationUpdate");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building AggregatedFollowRecommendationUpdate");
    }
    if (((ByteBuffer)localObject2).getInt() != -909066812)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building AggregatedFollowRecommendationUpdate");
    }
    paramString = null;
    Object localObject3 = null;
    Object localObject4 = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    boolean bool3;
    label244:
    int k;
    Object localObject5;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool3 = true;
      if (!bool3) {
        break label365;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject1 = new ArrayList();
      paramString = (String)localObject1;
      if (j <= 0) {
        break label365;
      }
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
        localObject5 = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label353;
        }
        i = 1;
      }
      label298:
      if (k == 1)
      {
        paramString = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (paramString == null) {
          break label359;
        }
      }
    }
    label353:
    label359:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject1).add(paramString);
      }
      j -= 1;
      break label244;
      bool3 = false;
      break;
      i = 0;
      break label298;
    }
    label365:
    boolean bool4;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (!bool4) {
        break label532;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject5 = new ArrayList();
      label401:
      localObject3 = localObject5;
      if (j <= 0) {
        break label532;
      }
      localObject1 = null;
      i = 1;
      k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        localObject3 = UpdateBuilder.INSTANCE;
        localObject1 = UpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label520;
        }
        i = 1;
      }
      label461:
      if (k == 1)
      {
        localObject1 = UpdateBuilder.INSTANCE;
        localObject1 = UpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label526;
        }
      }
    }
    label520:
    label526:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject5).add(localObject1);
      }
      j -= 1;
      break label401;
      bool4 = false;
      break;
      i = 0;
      break label461;
    }
    label532:
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool1 = true;
      localObject1 = localObject4;
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localAttributedTextBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label681;
          }
          bool1 = true;
        }
        label606:
        bool2 = bool1;
        if (i == 1)
        {
          localObject1 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label687;
          }
        }
      }
    }
    label681:
    label687:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (!bool3) {
        paramString = Collections.emptyList();
      }
      if (bool4) {
        break label693;
      }
      throw new IOException("Failed to find required field: followRecommendationUpdates when reading com.linkedin.android.pegasus.gen.voyager.feed.AggregatedFollowRecommendationUpdate from fission.");
      bool1 = false;
      break;
      bool1 = false;
      break label606;
    }
    label693:
    return new AggregatedFollowRecommendationUpdate(paramString, (List)localObject3, (AttributedText)localObject1, bool3, bool4, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.AggregatedFollowRecommendationUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */