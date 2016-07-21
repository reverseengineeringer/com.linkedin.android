package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
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

public final class PromptResponseUpdateBuilder
  implements FissileDataModelBuilder<PromptResponseUpdate>, DataTemplateBuilder<PromptResponseUpdate>
{
  public static final PromptResponseUpdateBuilder INSTANCE = new PromptResponseUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("shareAudience");
    JSON_KEY_STORE.put("actions");
    JSON_KEY_STORE.put("urn");
    JSON_KEY_STORE.put("createdAt");
    JSON_KEY_STORE.put("prompt");
    JSON_KEY_STORE.put("response");
  }
  
  public static PromptResponseUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    ShareAudience localShareAudience = null;
    Object localObject1 = null;
    Object localObject4 = null;
    long l = 0L;
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("shareAudience", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localShareAudience = (ShareAudience)paramDataReader.readEnum(ShareAudience.Builder.INSTANCE);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actions", JSON_KEY_STORE))
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
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("urn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("createdAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("prompt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = PromptBuilder.INSTANCE;
        localObject3 = PromptBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("response", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = PromptResponseBuilder.INSTANCE;
        localObject2 = PromptResponseBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      localObject1 = Collections.emptyList();
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: shareAudience when building com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: urn when building com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: createdAt when building com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: prompt when building com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: response when building com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate");
    }
    return new PromptResponseUpdate(localShareAudience, (List)localObject1, (Urn)localObject4, l, (Prompt)localObject3, (PromptResponse)localObject2, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static PromptResponseUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PromptResponseUpdate");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PromptResponseUpdate");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building PromptResponseUpdate");
    }
    if (((ByteBuffer)localObject3).getInt() != -2042725680)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building PromptResponseUpdate");
    }
    ShareAudience localShareAudience = null;
    paramString = null;
    Object localObject4 = null;
    long l = 0L;
    localObject1 = null;
    PromptBuilder localPromptBuilder = null;
    Object localObject2 = null;
    PromptResponseBuilder localPromptResponseBuilder = null;
    boolean bool4;
    boolean bool5;
    label262:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        localShareAudience = ShareAudience.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label395;
      }
      bool5 = true;
      if (!bool5) {
        break label413;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localArrayList = new ArrayList();
      label286:
      paramString = localArrayList;
      if (j <= 0) {
        break label413;
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
          break label401;
        }
        i = 1;
      }
      label340:
      if (k == 1)
      {
        paramString = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (paramString == null) {
          break label407;
        }
      }
    }
    label395:
    label401:
    label407:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label286;
      bool4 = false;
      break;
      bool5 = false;
      break label262;
      i = 0;
      break label340;
    }
    label413:
    boolean bool6;
    boolean bool7;
    label460:
    boolean bool2;
    label484:
    boolean bool1;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool6 = true;
      if (bool6)
      {
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label720;
      }
      bool7 = true;
      if (bool7) {
        l = ((ByteBuffer)localObject3).getLong();
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label726;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localPromptBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localPromptBuilder = PromptBuilder.INSTANCE;
          localObject1 = PromptBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label732;
          }
          bool1 = true;
        }
        label546:
        if (i == 1)
        {
          localObject1 = PromptBuilder.INSTANCE;
          localObject1 = PromptBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label738;
          }
          bool1 = true;
        }
      }
      label575:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label744;
      }
      bool2 = true;
      label587:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localPromptResponseBuilder;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localPromptResponseBuilder = PromptResponseBuilder.INSTANCE;
          localObject2 = PromptResponseBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label750;
          }
          bool2 = true;
        }
        label645:
        bool3 = bool2;
        if (i == 1)
        {
          localObject2 = PromptResponseBuilder.INSTANCE;
          localObject2 = PromptResponseBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label756;
          }
        }
      }
    }
    label720:
    label726:
    label732:
    label738:
    label744:
    label750:
    label756:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (!bool5) {
        paramString = Collections.emptyList();
      }
      if (bool4) {
        break label762;
      }
      throw new IOException("Failed to find required field: shareAudience when reading com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate from fission.");
      bool6 = false;
      break;
      bool7 = false;
      break label460;
      bool2 = false;
      break label484;
      bool1 = false;
      break label546;
      bool1 = false;
      break label575;
      bool2 = false;
      break label587;
      bool2 = false;
      break label645;
    }
    label762:
    if (!bool6) {
      throw new IOException("Failed to find required field: urn when reading com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: createdAt when reading com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: prompt when reading com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: response when reading com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate from fission.");
    }
    return new PromptResponseUpdate(localShareAudience, paramString, (Urn)localObject4, l, (Prompt)localObject1, (PromptResponse)localObject2, bool4, bool5, bool6, bool7, bool1, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */