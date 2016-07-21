package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SuggestionBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SuggestedEditCardBuilder
  implements FissileDataModelBuilder<SuggestedEditCard>, DataTemplateBuilder<SuggestedEditCard>
{
  public static final SuggestedEditCardBuilder INSTANCE = new SuggestedEditCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("publishedAt");
    JSON_KEY_STORE.put("read");
    JSON_KEY_STORE.put("suggestion");
  }
  
  public static SuggestedEditCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    boolean bool4 = false;
    Object localObject = null;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("publishedAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("read", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool4 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("suggestion", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = SuggestionBuilder.INSTANCE;
        localObject = SuggestionBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: publishedAt when building com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: read when building com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: suggestion when building com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard");
    }
    return new SuggestedEditCard(l, bool4, (Suggestion)localObject, bool2, bool3, bool1);
  }
  
  public static SuggestedEditCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SuggestedEditCard");
    }
    Object localObject2 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SuggestedEditCard");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SuggestedEditCard");
    }
    if (((ByteBuffer)localObject1).getInt() != -1638878889)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SuggestedEditCard");
    }
    long l = 0L;
    boolean bool3 = false;
    paramString = null;
    localObject2 = null;
    boolean bool4;
    boolean bool5;
    label244:
    label261:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        l = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label389;
      }
      bool5 = true;
      if (bool5)
      {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label395;
        }
        bool3 = true;
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label401;
      }
      bool1 = true;
      label273:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = (String)localObject2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localObject2 = SuggestionBuilder.INSTANCE;
          paramString = SuggestionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label407;
          }
          bool1 = true;
        }
        label326:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = SuggestionBuilder.INSTANCE;
          paramString = SuggestionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label413;
          }
        }
      }
    }
    label389:
    label395:
    label401:
    label407:
    label413:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool4) {
        break label419;
      }
      throw new IOException("Failed to find required field: publishedAt when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard from fission.");
      bool4 = false;
      break;
      bool5 = false;
      break label244;
      bool3 = false;
      break label261;
      bool1 = false;
      break label273;
      bool1 = false;
      break label326;
    }
    label419:
    if (!bool5) {
      throw new IOException("Failed to find required field: read when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: suggestion when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard from fission.");
    }
    return new SuggestedEditCard(l, bool3, paramString, bool4, bool5, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */