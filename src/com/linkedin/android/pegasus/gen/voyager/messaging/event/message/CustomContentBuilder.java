package com.linkedin.android.pegasus.gen.voyager.messaging.event.message;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareArticleBuilder;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContentBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CustomContentBuilder
  implements FissileDataModelBuilder<CustomContent>, DataTemplateBuilder<CustomContent>
{
  public static final CustomContentBuilder INSTANCE = new CustomContentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.messaging.event.message.ConversationNameUpdateContent");
    JSON_KEY_STORE.put("com.linkedin.voyager.messaging.event.message.InmailContent");
    JSON_KEY_STORE.put("com.linkedin.voyager.messaging.event.message.GroupContent");
    JSON_KEY_STORE.put("com.linkedin.voyager.messaging.event.message.spinmail.SpInmailContent");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.ShareArticle");
  }
  
  public static CustomContent build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.messaging.event.message.ConversationNameUpdateContent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = ConversationNameUpdateContentBuilder.INSTANCE;
        localObject5 = ConversationNameUpdateContentBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.messaging.event.message.InmailContent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = InmailContentBuilder.INSTANCE;
        localObject4 = InmailContentBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.messaging.event.message.GroupContent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = GroupContentBuilder.INSTANCE;
        localObject3 = GroupContentBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.messaging.event.message.spinmail.SpInmailContent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = SpInmailContentBuilder.INSTANCE;
        localObject2 = SpInmailContentBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ShareArticle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = ShareArticleBuilder.INSTANCE;
        localObject1 = ShareArticleBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int j = 0;
    if (bool5) {
      j = 1;
    }
    int i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building com.linkedin.android.pegasus.gen.voyager.messaging.event.message.CustomContent");
      }
      i = 1;
    }
    j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building com.linkedin.android.pegasus.gen.voyager.messaging.event.message.CustomContent");
      }
      j = 1;
    }
    i = j;
    if (bool2)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building com.linkedin.android.pegasus.gen.voyager.messaging.event.message.CustomContent");
      }
      i = 1;
    }
    if ((bool1) && (i != 0)) {
      throw new DataReaderException("Found more than 1 member when building com.linkedin.android.pegasus.gen.voyager.messaging.event.message.CustomContent");
    }
    return new CustomContent((ConversationNameUpdateContent)localObject5, (InmailContent)localObject4, (GroupContent)localObject3, (SpInmailContent)localObject2, (ShareArticle)localObject1, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static CustomContent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CustomContent");
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
          localObject5 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building CustomContent");
    }
    Object localObject5 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building CustomContent");
    }
    if (((ByteBuffer)localObject5).getInt() != 299450472)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject5);
      throw new IOException("UID mismatch. Can't read cached data when building CustomContent");
    }
    paramString = null;
    ConversationNameUpdateContentBuilder localConversationNameUpdateContentBuilder = null;
    localObject1 = null;
    InmailContentBuilder localInmailContentBuilder = null;
    Object localObject2 = null;
    GroupContentBuilder localGroupContentBuilder = null;
    Object localObject3 = null;
    SpInmailContentBuilder localSpInmailContentBuilder = null;
    Object localObject4 = null;
    ShareArticleBuilder localShareArticleBuilder = null;
    boolean bool2;
    boolean bool1;
    label295:
    label321:
    boolean bool3;
    label333:
    label395:
    label424:
    boolean bool4;
    label436:
    label498:
    label527:
    boolean bool5;
    if (((ByteBuffer)localObject5).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject5).get();
        paramString = localConversationNameUpdateContentBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localConversationNameUpdateContentBuilder = ConversationNameUpdateContentBuilder.INSTANCE;
          paramString = ConversationNameUpdateContentBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label786;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ConversationNameUpdateContentBuilder.INSTANCE;
          paramString = ConversationNameUpdateContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (paramString == null) {
            break label792;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label798;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject1 = localInmailContentBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localInmailContentBuilder = InmailContentBuilder.INSTANCE;
          localObject1 = InmailContentBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label804;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = InmailContentBuilder.INSTANCE;
          localObject1 = InmailContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label810;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label816;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject2 = localGroupContentBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localGroupContentBuilder = GroupContentBuilder.INSTANCE;
          localObject2 = GroupContentBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label822;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = GroupContentBuilder.INSTANCE;
          localObject2 = GroupContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label828;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label834;
      }
      bool5 = true;
      label539:
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject3 = localSpInmailContentBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localSpInmailContentBuilder = SpInmailContentBuilder.INSTANCE;
          localObject3 = SpInmailContentBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label840;
          }
          bool4 = true;
        }
        label601:
        if (i == 1)
        {
          localObject3 = SpInmailContentBuilder.INSTANCE;
          localObject3 = SpInmailContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label846;
          }
          bool4 = true;
        }
      }
      label630:
      if (((ByteBuffer)localObject5).get() != 1) {
        break label852;
      }
      bool5 = true;
      label642:
      bool6 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject4 = localShareArticleBuilder;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localShareArticleBuilder = ShareArticleBuilder.INSTANCE;
          localObject4 = ShareArticleBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label858;
          }
          bool5 = true;
        }
        label700:
        bool6 = bool5;
        if (i == 1)
        {
          localObject4 = ShareArticleBuilder.INSTANCE;
          localObject4 = ShareArticleBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label864;
          }
        }
      }
    }
    label786:
    label792:
    label798:
    label804:
    label810:
    label816:
    label822:
    label828:
    label834:
    label840:
    label846:
    label852:
    label858:
    label864:
    for (boolean bool6 = true;; bool6 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject5);
      }
      j = 0;
      if (bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        break label873;
      }
      if (j == 0) {
        break label870;
      }
      throw new IOException("Found more than 1 member when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.message.CustomContent from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label295;
      bool1 = false;
      break label321;
      bool3 = false;
      break label333;
      bool2 = false;
      break label395;
      bool2 = false;
      break label424;
      bool4 = false;
      break label436;
      bool3 = false;
      break label498;
      bool3 = false;
      break label527;
      bool5 = false;
      break label539;
      bool4 = false;
      break label601;
      bool4 = false;
      break label630;
      bool5 = false;
      break label642;
      bool5 = false;
      break label700;
    }
    label870:
    int i = 1;
    label873:
    int j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.message.CustomContent from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.message.CustomContent from fission.");
      }
      i = 1;
    }
    if ((bool6) && (i != 0)) {
      throw new IOException("Found more than 1 member when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.message.CustomContent from fission.");
    }
    return new CustomContent(paramString, (InmailContent)localObject1, (GroupContent)localObject2, (SpInmailContent)localObject3, (ShareArticle)localObject4, bool1, bool2, bool3, bool4, bool6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.CustomContentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */