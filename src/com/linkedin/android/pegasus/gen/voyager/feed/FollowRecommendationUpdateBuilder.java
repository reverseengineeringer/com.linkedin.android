package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedEntity;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedEntityBuilder;
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

public final class FollowRecommendationUpdateBuilder
  implements FissileDataModelBuilder<FollowRecommendationUpdate>, DataTemplateBuilder<FollowRecommendationUpdate>
{
  public static final FollowRecommendationUpdateBuilder INSTANCE = new FollowRecommendationUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("actions");
    JSON_KEY_STORE.put("recommendation");
    JSON_KEY_STORE.put("recommendationText");
  }
  
  public static FollowRecommendationUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("actions", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            UpdateActionBuilder localUpdateActionBuilder = UpdateActionBuilder.INSTANCE;
            ((List)localObject1).add(UpdateActionBuilder.build(paramDataReader));
          }
        }
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("recommendation", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = RecommendedEntityBuilder.INSTANCE;
        localObject3 = RecommendedEntityBuilder.build(paramDataReader);
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
      throw new DataReaderException("Failed to find required field: recommendation when building com.linkedin.android.pegasus.gen.voyager.feed.FollowRecommendationUpdate");
    }
    return new FollowRecommendationUpdate((List)localObject1, (RecommendedEntity)localObject3, (AttributedText)localObject2, bool3, bool2, bool1);
  }
  
  public static FollowRecommendationUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building FollowRecommendationUpdate");
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
          localObject3 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building FollowRecommendationUpdate");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building FollowRecommendationUpdate");
    }
    if (((ByteBuffer)localObject3).getInt() != -1680538663)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building FollowRecommendationUpdate");
    }
    paramString = null;
    localObject1 = null;
    RecommendedEntityBuilder localRecommendedEntityBuilder = null;
    Object localObject2 = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    boolean bool4;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool4 = true;
      if (!bool4) {
        break label368;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localArrayList = new ArrayList();
      label247:
      paramString = localArrayList;
      if (j <= 0) {
        break label368;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject3).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
        UpdateActionBuilder localUpdateActionBuilder = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label356;
        }
        i = 1;
      }
      label301:
      if (k == 1)
      {
        paramString = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (paramString == null) {
          break label362;
        }
      }
    }
    label356:
    label362:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label247;
      bool4 = false;
      break;
      i = 0;
      break label301;
    }
    label368:
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localRecommendedEntityBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localRecommendedEntityBuilder = RecommendedEntityBuilder.INSTANCE;
          localObject1 = RecommendedEntityBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label616;
          }
          bool1 = true;
        }
        label442:
        if (i == 1)
        {
          localObject1 = RecommendedEntityBuilder.INSTANCE;
          localObject1 = RecommendedEntityBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label622;
          }
          bool1 = true;
        }
      }
      label471:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label628;
      }
      bool2 = true;
      label483:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localAttributedTextBuilder;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label634;
          }
          bool2 = true;
        }
        label541:
        bool3 = bool2;
        if (i == 1)
        {
          localObject2 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label640;
          }
        }
      }
    }
    label616:
    label622:
    label628:
    label634:
    label640:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (!bool4) {
        paramString = Collections.emptyList();
      }
      if (bool1) {
        break label646;
      }
      throw new IOException("Failed to find required field: recommendation when reading com.linkedin.android.pegasus.gen.voyager.feed.FollowRecommendationUpdate from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label442;
      bool1 = false;
      break label471;
      bool2 = false;
      break label483;
      bool2 = false;
      break label541;
    }
    label646:
    return new FollowRecommendationUpdate(paramString, (RecommendedEntity)localObject1, (AttributedText)localObject2, bool4, bool1, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.FollowRecommendationUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */