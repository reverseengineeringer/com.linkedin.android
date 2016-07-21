package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCountsBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SocialDetailBuilder
  implements FissileDataModelBuilder<SocialDetail>, DataTemplateBuilder<SocialDetail>
{
  public static final SocialDetailBuilder INSTANCE = new SocialDetailBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("urn");
    JSON_KEY_STORE.put("entityUrn");
    JSON_KEY_STORE.put("totalSocialActivityCounts");
    JSON_KEY_STORE.put("totalShares");
    JSON_KEY_STORE.put("liked");
    JSON_KEY_STORE.put("likes");
    JSON_KEY_STORE.put("comments");
    JSON_KEY_STORE.put("threadId");
  }
  
  public static SocialDetail build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    int i = 0;
    boolean bool1 = false;
    Object localObject2 = null;
    Object localObject1 = null;
    String str = null;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("urn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = UrnCoercer.INSTANCE;
        localObject5 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("totalSocialActivityCounts", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = SocialActivityCountsBuilder.INSTANCE;
        localObject3 = SocialActivityCountsBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("totalShares", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("liked", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool1 = paramDataReader.readBoolean();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("likes", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = LikesBuilder.INSTANCE;
        localObject2 = LikesBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("comments", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = CommentsBuilder.INSTANCE;
        localObject1 = CommentsBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("threadId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      i = 0;
    }
    if (!bool6) {
      bool1 = false;
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: totalSocialActivityCounts when building com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: likes when building com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: comments when building com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail");
    }
    return new SocialDetail((Urn)localObject5, (Urn)localObject4, (SocialActivityCounts)localObject3, i, bool1, (Likes)localObject2, (Comments)localObject1, str, bool9, bool8, bool7, bool5, bool6, bool4, bool3, bool2);
  }
  
  public static SocialDetail readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SocialDetail");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialDetail");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialDetail");
    }
    if (((ByteBuffer)localObject3).getInt() != 1363310372)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building SocialDetail");
    }
    Object localObject4 = null;
    Object localObject5 = null;
    paramString = null;
    SocialActivityCountsBuilder localSocialActivityCountsBuilder = null;
    int i = 0;
    boolean bool3 = false;
    localObject1 = null;
    LikesBuilder localLikesBuilder = null;
    Object localObject2 = null;
    CommentsBuilder localCommentsBuilder = null;
    Object localObject6 = null;
    boolean bool6;
    boolean bool7;
    label276:
    boolean bool2;
    label311:
    boolean bool1;
    label368:
    label394:
    boolean bool8;
    label406:
    boolean bool9;
    label430:
    label451:
    boolean bool4;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool6 = true;
      if (bool6)
      {
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label735;
      }
      bool7 = true;
      if (bool7)
      {
        localObject5 = UrnCoercer.INSTANCE;
        localObject5 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label741;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject3).get();
        paramString = localSocialActivityCountsBuilder;
        bool1 = bool2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localSocialActivityCountsBuilder = SocialActivityCountsBuilder.INSTANCE;
          paramString = SocialActivityCountsBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label747;
          }
          bool1 = true;
        }
        if (j == 1)
        {
          paramString = SocialActivityCountsBuilder.INSTANCE;
          paramString = SocialActivityCountsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label753;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label759;
      }
      bool8 = true;
      if (bool8) {
        i = ((ByteBuffer)localObject3).getInt();
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label765;
      }
      bool9 = true;
      bool2 = bool3;
      if (bool9)
      {
        if (((ByteBuffer)localObject3).get() != 1) {
          break label771;
        }
        bool2 = true;
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label777;
      }
      bool4 = true;
      label463:
      bool3 = bool4;
      if (bool4)
      {
        j = ((ByteBuffer)localObject3).get();
        localObject1 = localLikesBuilder;
        bool3 = bool4;
        if (j == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localLikesBuilder = LikesBuilder.INSTANCE;
          localObject1 = LikesBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label783;
          }
          bool3 = true;
        }
        label525:
        if (j == 1)
        {
          localObject1 = LikesBuilder.INSTANCE;
          localObject1 = LikesBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label789;
          }
          bool3 = true;
        }
      }
      label554:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label795;
      }
      bool5 = true;
      label566:
      bool4 = bool5;
      if (bool5)
      {
        j = ((ByteBuffer)localObject3).get();
        localObject2 = localCommentsBuilder;
        bool4 = bool5;
        if (j == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localCommentsBuilder = CommentsBuilder.INSTANCE;
          localObject2 = CommentsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label801;
          }
          bool4 = true;
        }
        label628:
        if (j == 1)
        {
          localObject2 = CommentsBuilder.INSTANCE;
          localObject2 = CommentsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label807;
          }
          bool4 = true;
        }
      }
      label657:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label813;
      }
    }
    label735:
    label741:
    label747:
    label753:
    label759:
    label765:
    label771:
    label777:
    label783:
    label789:
    label795:
    label801:
    label807:
    label813:
    for (boolean bool5 = true;; bool5 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject6;
      if (bool5) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (!bool8) {
        i = 0;
      }
      if (!bool9) {
        bool2 = false;
      }
      if (bool1) {
        break label819;
      }
      throw new IOException("Failed to find required field: totalSocialActivityCounts when reading com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail from fission.");
      bool6 = false;
      break;
      bool7 = false;
      break label276;
      bool2 = false;
      break label311;
      bool1 = false;
      break label368;
      bool1 = false;
      break label394;
      bool8 = false;
      break label406;
      bool9 = false;
      break label430;
      bool2 = false;
      break label451;
      bool4 = false;
      break label463;
      bool3 = false;
      break label525;
      bool3 = false;
      break label554;
      bool5 = false;
      break label566;
      bool4 = false;
      break label628;
      bool4 = false;
      break label657;
    }
    label819:
    if (!bool3) {
      throw new IOException("Failed to find required field: likes when reading com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: comments when reading com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail from fission.");
    }
    return new SocialDetail((Urn)localObject4, (Urn)localObject5, paramString, i, bool2, (Likes)localObject1, (Comments)localObject2, paramFissionTransaction, bool6, bool7, bool1, bool8, bool9, bool3, bool4, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.SocialDetailBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */