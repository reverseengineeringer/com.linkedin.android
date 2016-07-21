package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.ImageBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedTextBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class DiscussionWithArticleBuilder
  implements FissileDataModelBuilder<DiscussionWithArticle>, DataTemplateBuilder<DiscussionWithArticle>
{
  public static final DiscussionWithArticleBuilder INSTANCE = new DiscussionWithArticleBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("title");
    JSON_KEY_STORE.put("body");
    JSON_KEY_STORE.put("contentId");
    JSON_KEY_STORE.put("contentUrl");
    JSON_KEY_STORE.put("contentTitle");
    JSON_KEY_STORE.put("contentSource");
    JSON_KEY_STORE.put("contentDescription");
    JSON_KEY_STORE.put("contentImage");
    JSON_KEY_STORE.put("contentUrn");
  }
  
  public static DiscussionWithArticle build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str6 = null;
    Object localObject3 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str6 = paramDataReader.readString();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("body", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AnnotatedTextBuilder.INSTANCE;
        localObject3 = AnnotatedTextBuilder.build(paramDataReader);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contentId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contentUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contentTitle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contentSource", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contentDescription", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contentImage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ImageBuilder.INSTANCE;
        localObject2 = ImageBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contentUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UrnCoercer.INSTANCE;
        localObject1 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: title when building com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle");
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: contentId when building com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: contentUrl when building com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: contentTitle when building com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: contentSource when building com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle");
    }
    return new DiscussionWithArticle(str6, (AnnotatedText)localObject3, str5, str4, str3, str2, str1, (Image)localObject2, (Urn)localObject1, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static DiscussionWithArticle readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building DiscussionWithArticle");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building DiscussionWithArticle");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building DiscussionWithArticle");
    }
    if (((ByteBuffer)localObject2).getInt() != -1659766364)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building DiscussionWithArticle");
    }
    String str1 = null;
    paramString = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    localObject1 = null;
    ImageBuilder localImageBuilder = null;
    Object localObject3 = null;
    boolean bool4;
    boolean bool2;
    label268:
    boolean bool1;
    label325:
    label351:
    boolean bool5;
    label363:
    boolean bool6;
    label390:
    boolean bool7;
    label417:
    boolean bool8;
    label444:
    boolean bool9;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label658;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localAnnotatedTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localAnnotatedTextBuilder = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label664;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label670;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label676;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label682;
      }
      bool6 = true;
      if (bool6) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label688;
      }
      bool7 = true;
      if (bool7) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label694;
      }
      bool8 = true;
      if (bool8) {
        str5 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label700;
      }
      bool9 = true;
      label471:
      if (bool9) {
        str6 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label706;
      }
      bool3 = true;
      label498:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localImageBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localImageBuilder = ImageBuilder.INSTANCE;
          localObject1 = ImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label712;
          }
          bool2 = true;
        }
        label560:
        if (i == 1)
        {
          localObject1 = ImageBuilder.INSTANCE;
          localObject1 = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label718;
          }
          bool2 = true;
        }
      }
      label589:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label724;
      }
    }
    label658:
    label664:
    label670:
    label676:
    label682:
    label688:
    label694:
    label700:
    label706:
    label712:
    label718:
    label724:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool3)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool4) {
        break label730;
      }
      throw new IOException("Failed to find required field: title when reading com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle from fission.");
      bool4 = false;
      break;
      bool2 = false;
      break label268;
      bool1 = false;
      break label325;
      bool1 = false;
      break label351;
      bool5 = false;
      break label363;
      bool6 = false;
      break label390;
      bool7 = false;
      break label417;
      bool8 = false;
      break label444;
      bool9 = false;
      break label471;
      bool3 = false;
      break label498;
      bool2 = false;
      break label560;
      bool2 = false;
      break label589;
    }
    label730:
    if (!bool5) {
      throw new IOException("Failed to find required field: contentId when reading com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: contentUrl when reading com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: contentTitle when reading com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle from fission.");
    }
    if (!bool8) {
      throw new IOException("Failed to find required field: contentSource when reading com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle from fission.");
    }
    return new DiscussionWithArticle(str1, paramString, str2, str3, str4, str5, str6, (Image)localObject1, paramFissionTransaction, bool4, bool1, bool5, bool6, bool7, bool8, bool9, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */