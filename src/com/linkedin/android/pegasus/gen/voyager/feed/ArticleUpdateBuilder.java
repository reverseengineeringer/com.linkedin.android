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

public final class ArticleUpdateBuilder
  implements FissileDataModelBuilder<ArticleUpdate>, DataTemplateBuilder<ArticleUpdate>
{
  public static final ArticleUpdateBuilder INSTANCE = new ArticleUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("content");
    JSON_KEY_STORE.put("createdTime");
  }
  
  public static ArticleUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    long l = 0L;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("content", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ContentBuilder.INSTANCE;
        localObject = ContentBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("createdTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: content when building com.linkedin.android.pegasus.gen.voyager.feed.ArticleUpdate");
    }
    return new ArticleUpdate((ArticleUpdate.Content)localObject, l, bool2, bool1);
  }
  
  public static ArticleUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ArticleUpdate");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ArticleUpdate");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building ArticleUpdate");
    }
    if (((ByteBuffer)localObject1).getInt() != 2127459807)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building ArticleUpdate");
    }
    paramString = null;
    localObject2 = null;
    long l = 0L;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = (String)localObject2;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localObject2 = ContentBuilder.INSTANCE;
          paramString = ContentBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label357;
          }
          bool1 = true;
        }
        label274:
        if (i == 1)
        {
          paramString = ContentBuilder.INSTANCE;
          paramString = ContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label363;
          }
          bool1 = true;
        }
      }
      label300:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label369;
      }
    }
    label357:
    label363:
    label369:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (bool2) {
        l = ((ByteBuffer)localObject1).getLong();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label375;
      }
      throw new IOException("Failed to find required field: content when reading com.linkedin.android.pegasus.gen.voyager.feed.ArticleUpdate from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label274;
      bool1 = false;
      break label300;
    }
    label375:
    return new ArticleUpdate(paramString, l, bool1, bool2);
  }
  
  public static final class ContentBuilder
    implements FissileDataModelBuilder<ArticleUpdate.Content>, DataTemplateBuilder<ArticleUpdate.Content>
  {
    public static final ContentBuilder INSTANCE = new ContentBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.feed.ShareArticle");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.ShareVideo");
    }
    
    public static ArticleUpdate.Content build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ShareArticle", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = ShareArticleBuilder.INSTANCE;
          localObject2 = ShareArticleBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ShareVideo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = ShareVideoBuilder.INSTANCE;
          localObject1 = ShareVideoBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int i = 0;
      if (bool2) {
        i = 1;
      }
      if ((bool1) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Content");
      }
      return new ArticleUpdate.Content((ShareArticle)localObject2, (ShareVideo)localObject1, bool2, bool1);
    }
    
    public static ArticleUpdate.Content readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building ArticleUpdate.Content");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building ArticleUpdate.Content");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building ArticleUpdate.Content");
      }
      if (((ByteBuffer)localObject2).getInt() != 1901666140)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building ArticleUpdate.Content");
      }
      paramString = null;
      ShareArticleBuilder localShareArticleBuilder = null;
      localObject1 = null;
      ShareVideoBuilder localShareVideoBuilder = null;
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
          paramString = localShareArticleBuilder;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localShareArticleBuilder = ShareArticleBuilder.INSTANCE;
            paramString = ShareArticleBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = ShareArticleBuilder.INSTANCE;
            paramString = ShareArticleBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
          localObject1 = localShareVideoBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localShareVideoBuilder = ShareVideoBuilder.INSTANCE;
            localObject1 = ShareVideoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = ShareVideoBuilder.INSTANCE;
            localObject1 = ShareVideoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
        throw new IOException("Found more than 1 member when reading .Content from fission.");
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
      return new ArticleUpdate.Content(paramString, (ShareVideo)localObject1, bool1, bool3);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ArticleUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */