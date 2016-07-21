package com.linkedin.android.pegasus.gen.voyager.publishing;

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

public final class FirstPartyArticleBuilder
  implements FissileDataModelBuilder<FirstPartyArticle>, DataTemplateBuilder<FirstPartyArticle>
{
  public static final FirstPartyArticleBuilder INSTANCE = new FirstPartyArticleBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("linkedInArticleUrn");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("authors");
    JSON_KEY_STORE.put("state");
    JSON_KEY_STORE.put("permalink");
    JSON_KEY_STORE.put("coverMedia");
    JSON_KEY_STORE.put("contentHtml");
    JSON_KEY_STORE.put("publishedAt");
    JSON_KEY_STORE.put("contentTags");
  }
  
  public static FirstPartyArticle build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    Object localObject3 = null;
    String str3 = null;
    ArrayList localArrayList = null;
    ArticleState localArticleState = null;
    String str1 = null;
    Object localObject2 = null;
    String str2 = null;
    long l = 0L;
    Object localObject1 = null;
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
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("linkedInArticleUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool8 = true;
      }
      else
      {
        Object localObject5;
        if (paramDataReader.shouldReadField$11ca93e7("authors", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayList = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject5 = FirstPartyAuthorBuilder.INSTANCE;
              localArrayList.add(FirstPartyAuthorBuilder.build(paramDataReader));
            }
          }
          bool7 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("state", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArticleState = (ArticleState)paramDataReader.readEnum(ArticleState.Builder.INSTANCE);
          bool6 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("permalink", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          str1 = paramDataReader.readString();
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("coverMedia", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = CoverMediaBuilder.INSTANCE;
          localObject2 = CoverMediaBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("contentHtml", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          str2 = paramDataReader.readString();
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("publishedAt", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          l = paramDataReader.readLong();
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("contentTags", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject5 = ContentTagBuilder.INSTANCE;
              ((List)localObject1).add(ContentTagBuilder.build(paramDataReader));
            }
          }
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
    }
    if (!bool5) {
      str1 = "";
    }
    if (!bool1) {
      localObject1 = Collections.emptyList();
    }
    if (!bool10) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle");
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: linkedInArticleUrn when building com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle");
    }
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: title when building com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle");
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: authors when building com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: state when building com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle");
    }
    return new FirstPartyArticle((Urn)localObject4, (Urn)localObject3, str3, localArrayList, localArticleState, str1, (CoverMedia)localObject2, str2, l, (List)localObject1, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static FirstPartyArticle readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building FirstPartyArticle");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building FirstPartyArticle");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building FirstPartyArticle");
    }
    if (((ByteBuffer)localObject3).getInt() != -1586383506)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building FirstPartyArticle");
    }
    Urn localUrn1 = null;
    Urn localUrn2 = null;
    String str1 = null;
    Object localObject4 = null;
    ArticleState localArticleState = null;
    ContentTagBuilder localContentTagBuilder = null;
    localObject1 = null;
    Object localObject5 = null;
    String str2 = null;
    long l = 0L;
    Object localObject2 = null;
    boolean bool3;
    boolean bool4;
    label276:
    boolean bool5;
    label310:
    boolean bool6;
    label337:
    ArrayList localArrayList;
    label361:
    int k;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool3 = true;
      if (bool3)
      {
        paramString = UrnCoercer.INSTANCE;
        localUrn1 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label471;
      }
      bool4 = true;
      if (bool4)
      {
        paramString = UrnCoercer.INSTANCE;
        localUrn2 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label477;
      }
      bool5 = true;
      if (bool5) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label483;
      }
      bool6 = true;
      if (!bool6) {
        break label501;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localArrayList = new ArrayList();
      localObject4 = localArrayList;
      if (j <= 0) {
        break label501;
      }
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject3).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
        localObject4 = FirstPartyAuthorBuilder.INSTANCE;
        paramString = FirstPartyAuthorBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label489;
        }
        i = 1;
      }
      label416:
      if (k == 1)
      {
        paramString = FirstPartyAuthorBuilder.INSTANCE;
        paramString = FirstPartyAuthorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (paramString == null) {
          break label495;
        }
      }
    }
    label471:
    label477:
    label483:
    label489:
    label495:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label361;
      bool3 = false;
      break;
      bool4 = false;
      break label276;
      bool5 = false;
      break label310;
      bool6 = false;
      break label337;
      i = 0;
      break label416;
    }
    label501:
    boolean bool7;
    boolean bool8;
    label543:
    boolean bool2;
    label572:
    boolean bool1;
    label634:
    label663:
    label675:
    boolean bool9;
    label702:
    boolean bool10;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool7 = true;
      if (bool7) {
        localArticleState = ArticleState.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label869;
      }
      bool8 = true;
      paramString = localContentTagBuilder;
      if (bool8) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label875;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localObject5;
        bool1 = bool2;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localObject5 = CoverMediaBuilder.INSTANCE;
          localObject1 = CoverMediaBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label881;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          localObject1 = CoverMediaBuilder.INSTANCE;
          localObject1 = CoverMediaBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label887;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label893;
      }
      bool2 = true;
      if (bool2) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label899;
      }
      bool9 = true;
      if (bool9) {
        l = ((ByteBuffer)localObject3).getLong();
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label905;
      }
      bool10 = true;
      label726:
      if (!bool10) {
        break label923;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localObject5 = new ArrayList();
      label750:
      localObject2 = localObject5;
      if (j <= 0) {
        break label923;
      }
      localObject2 = null;
      i = 1;
      k = ((ByteBuffer)localObject3).get();
      if (k == 0)
      {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
        localContentTagBuilder = ContentTagBuilder.INSTANCE;
        localObject2 = ContentTagBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
        if (localObject2 == null) {
          break label911;
        }
        i = 1;
      }
      label810:
      if (k == 1)
      {
        localObject2 = ContentTagBuilder.INSTANCE;
        localObject2 = ContentTagBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (localObject2 == null) {
          break label917;
        }
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
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject5).add(localObject2);
      }
      j -= 1;
      break label750;
      bool7 = false;
      break;
      bool8 = false;
      break label543;
      bool2 = false;
      break label572;
      bool1 = false;
      break label634;
      bool1 = false;
      break label663;
      bool2 = false;
      break label675;
      bool9 = false;
      break label702;
      bool10 = false;
      break label726;
      i = 0;
      break label810;
    }
    label923:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
    }
    if (!bool8) {
      paramString = "";
    }
    if (!bool10) {
      localObject2 = Collections.emptyList();
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: linkedInArticleUrn when reading com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: title when reading com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: authors when reading com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: state when reading com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle from fission.");
    }
    return new FirstPartyArticle(localUrn1, localUrn2, str1, (List)localObject4, localArticleState, paramString, (CoverMedia)localObject1, str2, l, (List)localObject2, bool3, bool4, bool5, bool6, bool7, bool8, bool1, bool2, bool9, bool10);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */