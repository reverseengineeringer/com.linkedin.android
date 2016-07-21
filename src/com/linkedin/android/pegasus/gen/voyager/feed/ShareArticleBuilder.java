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

public final class ShareArticleBuilder
  implements FissileDataModelBuilder<ShareArticle>, DataTemplateBuilder<ShareArticle>
{
  public static final ShareArticleBuilder INSTANCE = new ShareArticleBuilder();
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
    JSON_KEY_STORE.put("resolvedUrl");
    JSON_KEY_STORE.put("text");
    JSON_KEY_STORE.put("attributedText");
    JSON_KEY_STORE.put("image");
    JSON_KEY_STORE.put("articleType");
    JSON_KEY_STORE.put("publisher");
    JSON_KEY_STORE.put("author");
    JSON_KEY_STORE.put("article");
  }
  
  public static ShareArticle build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject7 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    ArticleType localArticleType = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool13 = false;
    boolean bool12 = false;
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
        localObject7 = UrnCoercer.INSTANCE;
        localObject7 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("subtitle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("resolvedUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = AnnotatedTextBuilder.INSTANCE;
        localObject6 = AnnotatedTextBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("attributedText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = AttributedTextBuilder.INSTANCE;
        localObject5 = AttributedTextBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("image", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = ImageBuilder.INSTANCE;
        localObject4 = ImageBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("articleType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArticleType = (ArticleType)paramDataReader.readEnum(ArticleType.Builder.INSTANCE);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("publisher", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = CompanyActorBuilder.INSTANCE;
        localObject3 = CompanyActorBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("author", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = AuthorBuilder.INSTANCE;
        localObject2 = AuthorBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("article", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = FeedMiniArticleBuilder.INSTANCE;
        localObject1 = FeedMiniArticleBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool12) {
      throw new DataReaderException("Failed to find required field: title when building com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle");
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: url when building com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: articleType when building com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle");
    }
    return new ShareArticle((Urn)localObject7, str5, str4, str3, str2, str1, (AnnotatedText)localObject6, (AttributedText)localObject5, (Image)localObject4, localArticleType, (CompanyActor)localObject3, (ShareArticle.Author)localObject2, (FeedMiniArticle)localObject1, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static ShareArticle readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ShareArticle");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ShareArticle");
    }
    Object localObject6 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ShareArticle");
    }
    if (((ByteBuffer)localObject6).getInt() != -590692565)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject6);
      throw new IOException("UID mismatch. Can't read cached data when building ShareArticle");
    }
    Object localObject7 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    paramString = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder = null;
    localObject1 = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    Object localObject2 = null;
    ImageBuilder localImageBuilder = null;
    ArticleType localArticleType = null;
    Object localObject3 = null;
    CompanyActorBuilder localCompanyActorBuilder = null;
    Object localObject4 = null;
    AuthorBuilder localAuthorBuilder = null;
    Object localObject5 = null;
    FeedMiniArticleBuilder localFeedMiniArticleBuilder = null;
    boolean bool8;
    boolean bool9;
    label300:
    boolean bool10;
    label327:
    boolean bool11;
    label354:
    boolean bool12;
    label381:
    boolean bool13;
    label408:
    boolean bool2;
    label435:
    boolean bool1;
    label492:
    label518:
    boolean bool3;
    label530:
    label592:
    label621:
    boolean bool4;
    label633:
    label695:
    label724:
    boolean bool14;
    label736:
    boolean bool5;
    label766:
    label828:
    label857:
    boolean bool6;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool8 = true;
      if (bool8)
      {
        localObject7 = UrnCoercer.INSTANCE;
        localObject7 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject6));
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1096;
      }
      bool9 = true;
      if (bool9) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1102;
      }
      bool10 = true;
      if (bool10) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1108;
      }
      bool11 = true;
      if (bool11) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1114;
      }
      bool12 = true;
      if (bool12) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1120;
      }
      bool13 = true;
      if (bool13) {
        str5 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1126;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject6).get();
        paramString = localAnnotatedTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localAnnotatedTextBuilder = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label1132;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (paramString == null) {
            break label1138;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1144;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject1 = localAttributedTextBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label1150;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label1156;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1162;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject2 = localImageBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localImageBuilder = ImageBuilder.INSTANCE;
          localObject2 = ImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1168;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = ImageBuilder.INSTANCE;
          localObject2 = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1174;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1180;
      }
      bool14 = true;
      if (bool14) {
        localArticleType = ArticleType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject6));
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1186;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject3 = localCompanyActorBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localCompanyActorBuilder = CompanyActorBuilder.INSTANCE;
          localObject3 = CompanyActorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1192;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject3 = CompanyActorBuilder.INSTANCE;
          localObject3 = CompanyActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1198;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1204;
      }
      bool6 = true;
      label869:
      bool5 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject4 = localAuthorBuilder;
        bool5 = bool6;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localAuthorBuilder = AuthorBuilder.INSTANCE;
          localObject4 = AuthorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1210;
          }
          bool5 = true;
        }
        label931:
        if (i == 1)
        {
          localObject4 = AuthorBuilder.INSTANCE;
          localObject4 = AuthorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1216;
          }
          bool5 = true;
        }
      }
      label960:
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1222;
      }
      bool6 = true;
      label972:
      bool7 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject5 = localFeedMiniArticleBuilder;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localFeedMiniArticleBuilder = FeedMiniArticleBuilder.INSTANCE;
          localObject5 = FeedMiniArticleBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label1228;
          }
          bool6 = true;
        }
        label1030:
        bool7 = bool6;
        if (i == 1)
        {
          localObject5 = FeedMiniArticleBuilder.INSTANCE;
          localObject5 = FeedMiniArticleBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label1234;
          }
        }
      }
    }
    label1096:
    label1102:
    label1108:
    label1114:
    label1120:
    label1126:
    label1132:
    label1138:
    label1144:
    label1150:
    label1156:
    label1162:
    label1168:
    label1174:
    label1180:
    label1186:
    label1192:
    label1198:
    label1204:
    label1210:
    label1216:
    label1222:
    label1228:
    label1234:
    for (boolean bool7 = true;; bool7 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject6);
      }
      if (bool9) {
        break label1240;
      }
      throw new IOException("Failed to find required field: title when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle from fission.");
      bool8 = false;
      break;
      bool9 = false;
      break label300;
      bool10 = false;
      break label327;
      bool11 = false;
      break label354;
      bool12 = false;
      break label381;
      bool13 = false;
      break label408;
      bool2 = false;
      break label435;
      bool1 = false;
      break label492;
      bool1 = false;
      break label518;
      bool3 = false;
      break label530;
      bool2 = false;
      break label592;
      bool2 = false;
      break label621;
      bool4 = false;
      break label633;
      bool3 = false;
      break label695;
      bool3 = false;
      break label724;
      bool14 = false;
      break label736;
      bool5 = false;
      break label766;
      bool4 = false;
      break label828;
      bool4 = false;
      break label857;
      bool6 = false;
      break label869;
      bool5 = false;
      break label931;
      bool5 = false;
      break label960;
      bool6 = false;
      break label972;
      bool6 = false;
      break label1030;
    }
    label1240:
    if (!bool12) {
      throw new IOException("Failed to find required field: url when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle from fission.");
    }
    if (!bool14) {
      throw new IOException("Failed to find required field: articleType when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle from fission.");
    }
    return new ShareArticle((Urn)localObject7, str1, str2, str3, str4, str5, paramString, (AttributedText)localObject1, (Image)localObject2, localArticleType, (CompanyActor)localObject3, (ShareArticle.Author)localObject4, (FeedMiniArticle)localObject5, bool8, bool9, bool10, bool11, bool12, bool13, bool1, bool2, bool3, bool14, bool4, bool5, bool7);
  }
  
  public static final class AuthorBuilder
    implements FissileDataModelBuilder<ShareArticle.Author>, DataTemplateBuilder<ShareArticle.Author>
  {
    public static final AuthorBuilder INSTANCE = new AuthorBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.feed.ExternalAuthor");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.InfluencerActor");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.MemberActor");
    }
    
    public static ShareArticle.Author build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject3 = null;
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool3 = false;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ExternalAuthor", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = ExternalAuthorBuilder.INSTANCE;
          localObject3 = ExternalAuthorBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.InfluencerActor", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = InfluencerActorBuilder.INSTANCE;
          localObject2 = InfluencerActorBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.MemberActor", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = MemberActorBuilder.INSTANCE;
          localObject1 = MemberActorBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int i = 0;
      if (bool3) {
        i = 1;
      }
      int j = i;
      if (bool2)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Author");
        }
        j = 1;
      }
      if ((bool1) && (j != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Author");
      }
      return new ShareArticle.Author((ExternalAuthor)localObject3, (InfluencerActor)localObject2, (MemberActor)localObject1, bool3, bool2, bool1);
    }
    
    public static ShareArticle.Author readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building ShareArticle.Author");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building ShareArticle.Author");
      }
      Object localObject3 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building ShareArticle.Author");
      }
      if (((ByteBuffer)localObject3).getInt() != -1731124413)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
        throw new IOException("UID mismatch. Can't read cached data when building ShareArticle.Author");
      }
      paramString = null;
      ExternalAuthorBuilder localExternalAuthorBuilder = null;
      localObject1 = null;
      InfluencerActorBuilder localInfluencerActorBuilder = null;
      Object localObject2 = null;
      MemberActorBuilder localMemberActorBuilder = null;
      boolean bool2;
      boolean bool1;
      label283:
      label309:
      boolean bool3;
      if (((ByteBuffer)localObject3).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject3).get();
          paramString = localExternalAuthorBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
            localExternalAuthorBuilder = ExternalAuthorBuilder.INSTANCE;
            paramString = ExternalAuthorBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label568;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = ExternalAuthorBuilder.INSTANCE;
            paramString = ExternalAuthorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
            if (paramString == null) {
              break label574;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject3).get() != 1) {
          break label580;
        }
        bool3 = true;
        label321:
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject3).get();
          localObject1 = localInfluencerActorBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
            localInfluencerActorBuilder = InfluencerActorBuilder.INSTANCE;
            localObject1 = InfluencerActorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label586;
            }
            bool2 = true;
          }
          label383:
          if (i == 1)
          {
            localObject1 = InfluencerActorBuilder.INSTANCE;
            localObject1 = InfluencerActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label592;
            }
            bool2 = true;
          }
        }
        label412:
        if (((ByteBuffer)localObject3).get() != 1) {
          break label598;
        }
        bool3 = true;
        label424:
        bool4 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject3).get();
          localObject2 = localMemberActorBuilder;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
            localMemberActorBuilder = MemberActorBuilder.INSTANCE;
            localObject2 = MemberActorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label604;
            }
            bool3 = true;
          }
          label482:
          bool4 = bool3;
          if (i == 1)
          {
            localObject2 = MemberActorBuilder.INSTANCE;
            localObject2 = MemberActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label610;
            }
          }
        }
      }
      label568:
      label574:
      label580:
      label586:
      label592:
      label598:
      label604:
      label610:
      for (boolean bool4 = true;; bool4 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject3);
        }
        i = 0;
        if (bool1) {
          i = 1;
        }
        j = i;
        if (!bool2) {
          break label619;
        }
        if (i == 0) {
          break label616;
        }
        throw new IOException("Found more than 1 member when reading .Author from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label283;
        bool1 = false;
        break label309;
        bool3 = false;
        break label321;
        bool2 = false;
        break label383;
        bool2 = false;
        break label412;
        bool3 = false;
        break label424;
        bool3 = false;
        break label482;
      }
      label616:
      int j = 1;
      label619:
      if ((bool4) && (j != 0)) {
        throw new IOException("Found more than 1 member when reading .Author from fission.");
      }
      return new ShareArticle.Author(paramString, (InfluencerActor)localObject1, (MemberActor)localObject2, bool1, bool2, bool4);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareArticleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */