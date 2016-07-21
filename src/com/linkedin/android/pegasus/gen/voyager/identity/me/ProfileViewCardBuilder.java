package com.linkedin.android.pegasus.gen.voyager.identity.me;

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

public final class ProfileViewCardBuilder
  implements FissileDataModelBuilder<ProfileViewCard>, DataTemplateBuilder<ProfileViewCard>
{
  public static final ProfileViewCardBuilder INSTANCE = new ProfileViewCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("publishedAt");
    JSON_KEY_STORE.put("viewer");
    JSON_KEY_STORE.put("insight");
    JSON_KEY_STORE.put("read");
    JSON_KEY_STORE.put("headline");
    JSON_KEY_STORE.put("profileViewCta");
  }
  
  public static ProfileViewCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    Object localObject4 = null;
    Object localObject3 = null;
    boolean bool7 = false;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("publishedAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("viewer", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = ProfileViewerBuilder.INSTANCE;
        localObject4 = ProfileViewerBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("insight", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = InsightBuilder.INSTANCE;
        localObject3 = InsightBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("read", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool7 = paramDataReader.readBoolean();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("headline", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = AttributedTextBuilder.INSTANCE;
        localObject2 = AttributedTextBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("profileViewCta", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = AttributedTextBuilder.INSTANCE;
        localObject1 = AttributedTextBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: publishedAt when building com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: viewer when building com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: read when building com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard");
    }
    return new ProfileViewCard(l, (ProfileViewer)localObject4, (Insight)localObject3, bool7, (AttributedText)localObject2, (AttributedText)localObject1, bool6, bool5, bool3, bool4, bool2, bool1);
  }
  
  public static ProfileViewCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ProfileViewCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ProfileViewCard");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ProfileViewCard");
    }
    if (((ByteBuffer)localObject4).getInt() != 1920002853)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building ProfileViewCard");
    }
    long l = 0L;
    paramString = null;
    ProfileViewerBuilder localProfileViewerBuilder = null;
    localObject1 = null;
    InsightBuilder localInsightBuilder = null;
    boolean bool6 = false;
    Object localObject2 = null;
    AttributedTextBuilder localAttributedTextBuilder2 = null;
    Object localObject3 = null;
    AttributedTextBuilder localAttributedTextBuilder1 = null;
    boolean bool7;
    boolean bool2;
    label262:
    boolean bool1;
    label319:
    label345:
    boolean bool3;
    label357:
    label419:
    label448:
    boolean bool8;
    label460:
    label477:
    boolean bool4;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool7 = true;
      if (bool7) {
        l = ((ByteBuffer)localObject4).getLong();
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label716;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject4).get();
        paramString = localProfileViewerBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localProfileViewerBuilder = ProfileViewerBuilder.INSTANCE;
          paramString = ProfileViewerBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label722;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ProfileViewerBuilder.INSTANCE;
          paramString = ProfileViewerBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (paramString == null) {
            break label728;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label734;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject1 = localInsightBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localInsightBuilder = InsightBuilder.INSTANCE;
          localObject1 = InsightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label740;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = InsightBuilder.INSTANCE;
          localObject1 = InsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label746;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label752;
      }
      bool8 = true;
      if (bool8)
      {
        if (((ByteBuffer)localObject4).get() != 1) {
          break label758;
        }
        bool6 = true;
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label764;
      }
      bool4 = true;
      label489:
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject2 = localAttributedTextBuilder2;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localAttributedTextBuilder2 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label770;
          }
          bool3 = true;
        }
        label551:
        if (i == 1)
        {
          localObject2 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label776;
          }
          bool3 = true;
        }
      }
      label580:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label782;
      }
      bool4 = true;
      label592:
      bool5 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject3 = localAttributedTextBuilder1;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localAttributedTextBuilder1 = AttributedTextBuilder.INSTANCE;
          localObject3 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label788;
          }
          bool4 = true;
        }
        label650:
        bool5 = bool4;
        if (i == 1)
        {
          localObject3 = AttributedTextBuilder.INSTANCE;
          localObject3 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label794;
          }
        }
      }
    }
    label716:
    label722:
    label728:
    label734:
    label740:
    label746:
    label752:
    label758:
    label764:
    label770:
    label776:
    label782:
    label788:
    label794:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (bool7) {
        break label800;
      }
      throw new IOException("Failed to find required field: publishedAt when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard from fission.");
      bool7 = false;
      break;
      bool2 = false;
      break label262;
      bool1 = false;
      break label319;
      bool1 = false;
      break label345;
      bool3 = false;
      break label357;
      bool2 = false;
      break label419;
      bool2 = false;
      break label448;
      bool8 = false;
      break label460;
      bool6 = false;
      break label477;
      bool4 = false;
      break label489;
      bool3 = false;
      break label551;
      bool3 = false;
      break label580;
      bool4 = false;
      break label592;
      bool4 = false;
      break label650;
    }
    label800:
    if (!bool1) {
      throw new IOException("Failed to find required field: viewer when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard from fission.");
    }
    if (!bool8) {
      throw new IOException("Failed to find required field: read when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard from fission.");
    }
    return new ProfileViewCard(l, paramString, (Insight)localObject1, bool6, (AttributedText)localObject2, (AttributedText)localObject3, bool7, bool1, bool2, bool8, bool3, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */