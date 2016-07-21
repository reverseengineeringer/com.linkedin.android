package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
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

public final class MentionedInNewsUpdateBuilder
  implements FissileDataModelBuilder<MentionedInNewsUpdate>, DataTemplateBuilder<MentionedInNewsUpdate>
{
  public static final MentionedInNewsUpdateBuilder INSTANCE = new MentionedInNewsUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("actions");
    JSON_KEY_STORE.put("mentionedActor");
    JSON_KEY_STORE.put("header");
    JSON_KEY_STORE.put("article");
  }
  
  public static MentionedInNewsUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("actions", JSON_KEY_STORE))
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
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("mentionedActor", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = MentionedActorBuilder.INSTANCE;
        localObject4 = MentionedActorBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("header", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AttributedTextBuilder.INSTANCE;
        localObject3 = AttributedTextBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("article", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ShareArticleBuilder.INSTANCE;
        localObject2 = ShareArticleBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      localObject1 = Collections.emptyList();
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: mentionedActor when building com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdate");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: header when building com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdate");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: article when building com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdate");
    }
    return new MentionedInNewsUpdate((List)localObject1, (MentionedInNewsUpdate.MentionedActor)localObject4, (AttributedText)localObject3, (ShareArticle)localObject2, bool4, bool3, bool2, bool1);
  }
  
  public static MentionedInNewsUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building MentionedInNewsUpdate");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building MentionedInNewsUpdate");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building MentionedInNewsUpdate");
    }
    if (((ByteBuffer)localObject4).getInt() != 1832416499)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building MentionedInNewsUpdate");
    }
    paramString = null;
    localObject1 = null;
    MentionedActorBuilder localMentionedActorBuilder = null;
    Object localObject2 = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    Object localObject3 = null;
    ShareArticleBuilder localShareArticleBuilder = null;
    boolean bool5;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool5 = true;
      if (!bool5) {
        break label374;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4);
      localArrayList = new ArrayList();
      label253:
      paramString = localArrayList;
      if (j <= 0) {
        break label374;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject4).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
        UpdateActionBuilder localUpdateActionBuilder = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label362;
        }
        i = 1;
      }
      label307:
      if (k == 1)
      {
        paramString = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
        if (paramString == null) {
          break label368;
        }
      }
    }
    label362:
    label368:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label253;
      bool5 = false;
      break;
      i = 0;
      break label307;
    }
    label374:
    boolean bool2;
    boolean bool1;
    label448:
    label477:
    boolean bool3;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject1 = localMentionedActorBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localMentionedActorBuilder = MentionedActorBuilder.INSTANCE;
          localObject1 = MentionedActorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label725;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          localObject1 = MentionedActorBuilder.INSTANCE;
          localObject1 = MentionedActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label731;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label737;
      }
      bool3 = true;
      label489:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject2 = localAttributedTextBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label743;
          }
          bool2 = true;
        }
        label551:
        if (i == 1)
        {
          localObject2 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label749;
          }
          bool2 = true;
        }
      }
      label580:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label755;
      }
      bool3 = true;
      label592:
      bool4 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject3 = localShareArticleBuilder;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localShareArticleBuilder = ShareArticleBuilder.INSTANCE;
          localObject3 = ShareArticleBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label761;
          }
          bool3 = true;
        }
        label650:
        bool4 = bool3;
        if (i == 1)
        {
          localObject3 = ShareArticleBuilder.INSTANCE;
          localObject3 = ShareArticleBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label767;
          }
        }
      }
    }
    label725:
    label731:
    label737:
    label743:
    label749:
    label755:
    label761:
    label767:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (!bool5) {
        paramString = Collections.emptyList();
      }
      if (bool1) {
        break label773;
      }
      throw new IOException("Failed to find required field: mentionedActor when reading com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdate from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label448;
      bool1 = false;
      break label477;
      bool3 = false;
      break label489;
      bool2 = false;
      break label551;
      bool2 = false;
      break label580;
      bool3 = false;
      break label592;
      bool3 = false;
      break label650;
    }
    label773:
    if (!bool2) {
      throw new IOException("Failed to find required field: header when reading com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdate from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: article when reading com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdate from fission.");
    }
    return new MentionedInNewsUpdate(paramString, (MentionedInNewsUpdate.MentionedActor)localObject1, (AttributedText)localObject2, (ShareArticle)localObject3, bool5, bool1, bool2, bool4);
  }
  
  public static final class MentionedActorBuilder
    implements FissileDataModelBuilder<MentionedInNewsUpdate.MentionedActor>, DataTemplateBuilder<MentionedInNewsUpdate.MentionedActor>
  {
    public static final MentionedActorBuilder INSTANCE = new MentionedActorBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.feed.CompanyActor");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.InfluencerActor");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.MemberActor");
    }
    
    public static MentionedInNewsUpdate.MentionedActor build(DataReader paramDataReader)
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
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.CompanyActor", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = CompanyActorBuilder.INSTANCE;
          localObject3 = CompanyActorBuilder.build(paramDataReader);
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
          throw new DataReaderException("Found more than 1 member when building .MentionedActor");
        }
        j = 1;
      }
      if ((bool1) && (j != 0)) {
        throw new DataReaderException("Found more than 1 member when building .MentionedActor");
      }
      return new MentionedInNewsUpdate.MentionedActor((CompanyActor)localObject3, (InfluencerActor)localObject2, (MemberActor)localObject1, bool3, bool2, bool1);
    }
    
    public static MentionedInNewsUpdate.MentionedActor readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building MentionedInNewsUpdate.MentionedActor");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building MentionedInNewsUpdate.MentionedActor");
      }
      Object localObject3 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building MentionedInNewsUpdate.MentionedActor");
      }
      if (((ByteBuffer)localObject3).getInt() != 589834161)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
        throw new IOException("UID mismatch. Can't read cached data when building MentionedInNewsUpdate.MentionedActor");
      }
      paramString = null;
      CompanyActorBuilder localCompanyActorBuilder = null;
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
          paramString = localCompanyActorBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
            localCompanyActorBuilder = CompanyActorBuilder.INSTANCE;
            paramString = CompanyActorBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label568;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = CompanyActorBuilder.INSTANCE;
            paramString = CompanyActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
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
        throw new IOException("Found more than 1 member when reading .MentionedActor from fission.");
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
        throw new IOException("Found more than 1 member when reading .MentionedActor from fission.");
      }
      return new MentionedInNewsUpdate.MentionedActor(paramString, (InfluencerActor)localObject1, (MemberActor)localObject2, bool1, bool2, bool4);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */