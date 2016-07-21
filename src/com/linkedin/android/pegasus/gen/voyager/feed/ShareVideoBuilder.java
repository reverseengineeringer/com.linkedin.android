package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.ImageBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticle;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticleBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ShareVideoBuilder
  implements FissileDataModelBuilder<ShareVideo>, DataTemplateBuilder<ShareVideo>
{
  public static final ShareVideoBuilder INSTANCE = new ShareVideoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("urn");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("subtitle");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("url");
    JSON_KEY_STORE.put("text");
    JSON_KEY_STORE.put("attributedText");
    JSON_KEY_STORE.put("image");
    JSON_KEY_STORE.put("article");
    JSON_KEY_STORE.put("duration");
    JSON_KEY_STORE.put("numViews");
  }
  
  public static ShareVideo build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    long l = 0L;
    int i = 0;
    boolean bool11 = false;
    boolean bool10 = false;
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
      if (paramDataReader.shouldReadField$11ca93e7("urn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = UrnCoercer.INSTANCE;
        localObject5 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("subtitle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = AnnotatedTextBuilder.INSTANCE;
        localObject4 = AnnotatedTextBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("attributedText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AttributedTextBuilder.INSTANCE;
        localObject3 = AttributedTextBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("image", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ImageBuilder.INSTANCE;
        localObject2 = ImageBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("article", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = FeedMiniArticleBuilder.INSTANCE;
        localObject1 = FeedMiniArticleBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("duration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("numViews", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool10) {
      throw new DataReaderException("Failed to find required field: title when building com.linkedin.android.pegasus.gen.voyager.feed.ShareVideo");
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: url when building com.linkedin.android.pegasus.gen.voyager.feed.ShareVideo");
    }
    return new ShareVideo((Urn)localObject5, str4, str3, str2, str1, (AnnotatedText)localObject4, (AttributedText)localObject3, (Image)localObject2, (FeedMiniArticle)localObject1, l, i, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static ShareVideo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ShareVideo");
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
          localObject4 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ShareVideo");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ShareVideo");
    }
    if (((ByteBuffer)localObject4).getInt() != -1024219790)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building ShareVideo");
    }
    Object localObject5 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    paramString = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder = null;
    localObject1 = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    Object localObject2 = null;
    ImageBuilder localImageBuilder = null;
    Object localObject3 = null;
    FeedMiniArticleBuilder localFeedMiniArticleBuilder = null;
    long l = 0L;
    int i = 0;
    boolean bool6;
    boolean bool7;
    label288:
    boolean bool8;
    label315:
    boolean bool9;
    label342:
    boolean bool10;
    label369:
    boolean bool2;
    label396:
    boolean bool1;
    label453:
    label479:
    boolean bool3;
    label491:
    label553:
    label582:
    boolean bool4;
    label594:
    label656:
    label685:
    boolean bool5;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool6 = true;
      if (bool6)
      {
        localObject5 = UrnCoercer.INSTANCE;
        localObject5 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject4));
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label869;
      }
      bool7 = true;
      if (bool7) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label875;
      }
      bool8 = true;
      if (bool8) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label881;
      }
      bool9 = true;
      if (bool9) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label887;
      }
      bool10 = true;
      if (bool10) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label893;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject4).get();
        paramString = localAnnotatedTextBuilder;
        bool1 = bool2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localAnnotatedTextBuilder = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label899;
          }
          bool1 = true;
        }
        if (j == 1)
        {
          paramString = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (paramString == null) {
            break label905;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label911;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        j = ((ByteBuffer)localObject4).get();
        localObject1 = localAttributedTextBuilder;
        bool2 = bool3;
        if (j == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label917;
          }
          bool2 = true;
        }
        if (j == 1)
        {
          localObject1 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label923;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label929;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        j = ((ByteBuffer)localObject4).get();
        localObject2 = localImageBuilder;
        bool3 = bool4;
        if (j == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localImageBuilder = ImageBuilder.INSTANCE;
          localObject2 = ImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label935;
          }
          bool3 = true;
        }
        if (j == 1)
        {
          localObject2 = ImageBuilder.INSTANCE;
          localObject2 = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label941;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label947;
      }
      bool5 = true;
      label697:
      bool4 = bool5;
      if (bool5)
      {
        j = ((ByteBuffer)localObject4).get();
        localObject3 = localFeedMiniArticleBuilder;
        bool4 = bool5;
        if (j == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localFeedMiniArticleBuilder = FeedMiniArticleBuilder.INSTANCE;
          localObject3 = FeedMiniArticleBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label953;
          }
          bool4 = true;
        }
        label759:
        if (j == 1)
        {
          localObject3 = FeedMiniArticleBuilder.INSTANCE;
          localObject3 = FeedMiniArticleBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label959;
          }
          bool4 = true;
        }
      }
      label788:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label965;
      }
      bool5 = true;
      label800:
      if (bool5) {
        l = ((ByteBuffer)localObject4).getLong();
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label971;
      }
    }
    label869:
    label875:
    label881:
    label887:
    label893:
    label899:
    label905:
    label911:
    label917:
    label923:
    label929:
    label935:
    label941:
    label947:
    label953:
    label959:
    label965:
    label971:
    for (boolean bool11 = true;; bool11 = false)
    {
      if (bool11) {
        i = ((ByteBuffer)localObject4).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (bool7) {
        break label977;
      }
      throw new IOException("Failed to find required field: title when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareVideo from fission.");
      bool6 = false;
      break;
      bool7 = false;
      break label288;
      bool8 = false;
      break label315;
      bool9 = false;
      break label342;
      bool10 = false;
      break label369;
      bool2 = false;
      break label396;
      bool1 = false;
      break label453;
      bool1 = false;
      break label479;
      bool3 = false;
      break label491;
      bool2 = false;
      break label553;
      bool2 = false;
      break label582;
      bool4 = false;
      break label594;
      bool3 = false;
      break label656;
      bool3 = false;
      break label685;
      bool5 = false;
      break label697;
      bool4 = false;
      break label759;
      bool4 = false;
      break label788;
      bool5 = false;
      break label800;
    }
    label977:
    if (!bool10) {
      throw new IOException("Failed to find required field: url when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareVideo from fission.");
    }
    return new ShareVideo((Urn)localObject5, str1, str2, str3, str4, paramString, (AttributedText)localObject1, (Image)localObject2, (FeedMiniArticle)localObject3, l, i, bool6, bool7, bool8, bool9, bool10, bool1, bool2, bool3, bool4, bool5, bool11);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareVideoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */