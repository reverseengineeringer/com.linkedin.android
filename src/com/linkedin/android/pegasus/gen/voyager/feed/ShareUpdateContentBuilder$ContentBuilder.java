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

public final class ShareUpdateContentBuilder$ContentBuilder
  implements FissileDataModelBuilder<ShareUpdateContent.Content>, DataTemplateBuilder<ShareUpdateContent.Content>
{
  public static final ContentBuilder INSTANCE = new ContentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.feed.ShareText");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.ShareArticle");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.ShareDocument");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.ShareImage");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.ShareJob");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.ShareVideo");
  }
  
  public static ShareUpdateContent.Content build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ShareText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = ShareTextBuilder.INSTANCE;
        localObject6 = ShareTextBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ShareArticle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = ShareArticleBuilder.INSTANCE;
        localObject5 = ShareArticleBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ShareDocument", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = ShareDocumentBuilder.INSTANCE;
        localObject4 = ShareDocumentBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ShareImage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = ShareImageBuilder.INSTANCE;
        localObject3 = ShareImageBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ShareJob", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ShareJobBuilder.INSTANCE;
        localObject2 = ShareJobBuilder.build(paramDataReader);
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
    int j = 0;
    if (bool6) {
      j = 1;
    }
    int i = j;
    if (bool5)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Content");
      }
      i = 1;
    }
    j = i;
    if (bool4)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Content");
      }
      j = 1;
    }
    i = j;
    if (bool3)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Content");
      }
      i = 1;
    }
    j = i;
    if (bool2)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Content");
      }
      j = 1;
    }
    if ((bool1) && (j != 0)) {
      throw new DataReaderException("Found more than 1 member when building .Content");
    }
    return new ShareUpdateContent.Content((ShareText)localObject6, (ShareArticle)localObject5, (ShareDocument)localObject4, (ShareImage)localObject3, (ShareJob)localObject2, (ShareVideo)localObject1, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static ShareUpdateContent.Content readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ShareUpdateContent.Content");
    }
    Object localObject1 = paramByteBuffer;
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
          localObject6 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ShareUpdateContent.Content");
    }
    Object localObject6 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ShareUpdateContent.Content");
    }
    if (((ByteBuffer)localObject6).getInt() != 1773021846)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject6);
      throw new IOException("UID mismatch. Can't read cached data when building ShareUpdateContent.Content");
    }
    paramString = null;
    ShareTextBuilder localShareTextBuilder = null;
    localObject1 = null;
    ShareArticleBuilder localShareArticleBuilder = null;
    Object localObject2 = null;
    ShareDocumentBuilder localShareDocumentBuilder = null;
    Object localObject3 = null;
    ShareImageBuilder localShareImageBuilder = null;
    Object localObject4 = null;
    ShareJobBuilder localShareJobBuilder = null;
    Object localObject5 = null;
    ShareVideoBuilder localShareVideoBuilder = null;
    boolean bool2;
    boolean bool1;
    label301:
    label327:
    boolean bool3;
    label339:
    label401:
    label430:
    boolean bool4;
    label442:
    label504:
    label533:
    boolean bool5;
    label545:
    label607:
    label636:
    boolean bool6;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject6).get();
        paramString = localShareTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localShareTextBuilder = ShareTextBuilder.INSTANCE;
          paramString = ShareTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label895;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ShareTextBuilder.INSTANCE;
          paramString = ShareTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (paramString == null) {
            break label901;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label907;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject1 = localShareArticleBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localShareArticleBuilder = ShareArticleBuilder.INSTANCE;
          localObject1 = ShareArticleBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label913;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = ShareArticleBuilder.INSTANCE;
          localObject1 = ShareArticleBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label919;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label925;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject2 = localShareDocumentBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localShareDocumentBuilder = ShareDocumentBuilder.INSTANCE;
          localObject2 = ShareDocumentBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label931;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = ShareDocumentBuilder.INSTANCE;
          localObject2 = ShareDocumentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label937;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label943;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject3 = localShareImageBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localShareImageBuilder = ShareImageBuilder.INSTANCE;
          localObject3 = ShareImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label949;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject3 = ShareImageBuilder.INSTANCE;
          localObject3 = ShareImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label955;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label961;
      }
      bool6 = true;
      label648:
      bool5 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject4 = localShareJobBuilder;
        bool5 = bool6;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localShareJobBuilder = ShareJobBuilder.INSTANCE;
          localObject4 = ShareJobBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label967;
          }
          bool5 = true;
        }
        label710:
        if (i == 1)
        {
          localObject4 = ShareJobBuilder.INSTANCE;
          localObject4 = ShareJobBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label973;
          }
          bool5 = true;
        }
      }
      label739:
      if (((ByteBuffer)localObject6).get() != 1) {
        break label979;
      }
      bool6 = true;
      label751:
      bool7 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject5 = localShareVideoBuilder;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localShareVideoBuilder = ShareVideoBuilder.INSTANCE;
          localObject5 = ShareVideoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label985;
          }
          bool6 = true;
        }
        label809:
        bool7 = bool6;
        if (i == 1)
        {
          localObject5 = ShareVideoBuilder.INSTANCE;
          localObject5 = ShareVideoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label991;
          }
        }
      }
    }
    label895:
    label901:
    label907:
    label913:
    label919:
    label925:
    label931:
    label937:
    label943:
    label949:
    label955:
    label961:
    label967:
    label973:
    label979:
    label985:
    label991:
    for (boolean bool7 = true;; bool7 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject6);
      }
      j = 0;
      if (bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        break label1000;
      }
      if (j == 0) {
        break label997;
      }
      throw new IOException("Found more than 1 member when reading .Content from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label301;
      bool1 = false;
      break label327;
      bool3 = false;
      break label339;
      bool2 = false;
      break label401;
      bool2 = false;
      break label430;
      bool4 = false;
      break label442;
      bool3 = false;
      break label504;
      bool3 = false;
      break label533;
      bool5 = false;
      break label545;
      bool4 = false;
      break label607;
      bool4 = false;
      break label636;
      bool6 = false;
      break label648;
      bool5 = false;
      break label710;
      bool5 = false;
      break label739;
      bool6 = false;
      break label751;
      bool6 = false;
      break label809;
    }
    label997:
    int i = 1;
    label1000:
    int j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Content from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Content from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool5)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Content from fission.");
      }
      j = 1;
    }
    if ((bool7) && (j != 0)) {
      throw new IOException("Found more than 1 member when reading .Content from fission.");
    }
    return new ShareUpdateContent.Content(paramString, (ShareArticle)localObject1, (ShareDocument)localObject2, (ShareImage)localObject3, (ShareJob)localObject4, (ShareVideo)localObject5, bool1, bool2, bool3, bool4, bool5, bool7);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdateContentBuilder.ContentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */