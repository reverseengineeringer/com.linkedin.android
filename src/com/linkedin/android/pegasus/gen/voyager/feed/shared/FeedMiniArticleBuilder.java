package com.linkedin.android.pegasus.gen.voyager.feed.shared;

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

public final class FeedMiniArticleBuilder
  implements FissileDataModelBuilder<FeedMiniArticle>, DataTemplateBuilder<FeedMiniArticle>
{
  public static final FeedMiniArticleBuilder INSTANCE = new FeedMiniArticleBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("article");
    JSON_KEY_STORE.put("saved");
  }
  
  public static FeedMiniArticle build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("article", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = MiniArticleBuilder.INSTANCE;
        localObject1 = MiniArticleBuilder.build(paramDataReader);
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("saved", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool4 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticle");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: article when building com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticle");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: saved when building com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticle");
    }
    return new FeedMiniArticle((Urn)localObject2, (MiniArticle)localObject1, bool4, bool3, bool1, bool2);
  }
  
  public static FeedMiniArticle readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building FeedMiniArticle");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building FeedMiniArticle");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building FeedMiniArticle");
    }
    if (((ByteBuffer)localObject1).getInt() != -2127154423)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building FeedMiniArticle");
    }
    localObject2 = null;
    paramString = null;
    MiniArticleBuilder localMiniArticleBuilder = null;
    boolean bool5 = false;
    boolean bool3;
    label255:
    boolean bool1;
    label312:
    label338:
    boolean bool4;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3)
      {
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label404;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localMiniArticleBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localMiniArticleBuilder = MiniArticleBuilder.INSTANCE;
          paramString = MiniArticleBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label410;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniArticleBuilder.INSTANCE;
          paramString = MiniArticleBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label416;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label422;
      }
      bool4 = true;
      label350:
      bool2 = bool5;
      if (bool4) {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label428;
        }
      }
    }
    label404:
    label410:
    label416:
    label422:
    label428:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label434;
      }
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticle from fission.");
      bool3 = false;
      break;
      bool2 = false;
      break label255;
      bool1 = false;
      break label312;
      bool1 = false;
      break label338;
      bool4 = false;
      break label350;
    }
    label434:
    if (!bool1) {
      throw new IOException("Failed to find required field: article when reading com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticle from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: saved when reading com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticle from fission.");
    }
    return new FeedMiniArticle((Urn)localObject2, paramString, bool2, bool3, bool1, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */