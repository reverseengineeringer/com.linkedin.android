package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedTextBuilder;
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

public final class CommentBuilder
  implements FissileDataModelBuilder<Comment>, DataTemplateBuilder<Comment>
{
  public static final CommentBuilder INSTANCE = new CommentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("urn");
    JSON_KEY_STORE.put("entityUrn");
    JSON_KEY_STORE.put("commenter");
    JSON_KEY_STORE.put("comment");
    JSON_KEY_STORE.put("createdTime");
    JSON_KEY_STORE.put("socialDetail");
    JSON_KEY_STORE.put("threadId");
    JSON_KEY_STORE.put("index");
    JSON_KEY_STORE.put("insight");
    JSON_KEY_STORE.put("canDelete");
    JSON_KEY_STORE.put("actions");
    JSON_KEY_STORE.put("parentCommentUrn");
  }
  
  public static Comment build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject8 = null;
    Object localObject7 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    long l = 0L;
    Object localObject4 = null;
    String str = null;
    int i = 0;
    Object localObject3 = null;
    boolean bool1 = false;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool13 = false;
    boolean bool12 = false;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("urn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject8 = UrnCoercer.INSTANCE;
        localObject8 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = UrnCoercer.INSTANCE;
        localObject7 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("commenter", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = SocialActorBuilder.INSTANCE;
        localObject6 = SocialActorBuilder.build(paramDataReader);
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("comment", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = AnnotatedTextBuilder.INSTANCE;
        localObject5 = AnnotatedTextBuilder.build(paramDataReader);
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("createdTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("socialDetail", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = SocialDetailBuilder.INSTANCE;
        localObject4 = SocialDetailBuilder.build(paramDataReader);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("threadId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("index", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("insight", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = InsightBuilder.INSTANCE;
        localObject3 = InsightBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("canDelete", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool1 = paramDataReader.readBoolean();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actions", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            CommentAction localCommentAction = (CommentAction)paramDataReader.readEnum(CommentAction.Builder.INSTANCE);
            if (localCommentAction != null) {
              ((List)localObject1).add(localCommentAction);
            }
          }
        }
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("parentCommentUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      bool1 = false;
    }
    if (!bool3) {
      localObject1 = Collections.emptyList();
    }
    if (!bool11) {
      throw new DataReaderException("Failed to find required field: commenter when building com.linkedin.android.pegasus.gen.voyager.feed.Comment");
    }
    if (!bool10) {
      throw new DataReaderException("Failed to find required field: comment when building com.linkedin.android.pegasus.gen.voyager.feed.Comment");
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: createdTime when building com.linkedin.android.pegasus.gen.voyager.feed.Comment");
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: threadId when building com.linkedin.android.pegasus.gen.voyager.feed.Comment");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: index when building com.linkedin.android.pegasus.gen.voyager.feed.Comment");
    }
    return new Comment((Urn)localObject8, (Urn)localObject7, (SocialActor)localObject6, (AnnotatedText)localObject5, l, (SocialDetail)localObject4, str, i, (Insight)localObject3, bool1, (List)localObject1, (Urn)localObject2, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool4, bool5, bool3, bool2);
  }
  
  public static Comment readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Comment");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Comment");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Comment");
    }
    if (((ByteBuffer)localObject4).getInt() != 1175712204)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building Comment");
    }
    Object localObject5 = null;
    Object localObject6 = null;
    paramString = null;
    SocialActorBuilder localSocialActorBuilder = null;
    localObject1 = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder = null;
    long l = 0L;
    Object localObject2 = null;
    SocialDetailBuilder localSocialDetailBuilder = null;
    String str = null;
    int i = 0;
    Object localObject3 = null;
    InsightBuilder localInsightBuilder = null;
    boolean bool12 = false;
    ArrayList localArrayList = null;
    Object localObject7 = null;
    boolean bool6;
    boolean bool7;
    label291:
    boolean bool2;
    label326:
    boolean bool1;
    label383:
    label409:
    boolean bool3;
    label421:
    label483:
    label512:
    boolean bool8;
    label524:
    boolean bool4;
    label548:
    label610:
    label639:
    boolean bool9;
    label651:
    boolean bool10;
    label678:
    boolean bool5;
    label702:
    label764:
    label793:
    boolean bool11;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool6 = true;
      if (bool6)
      {
        localObject5 = UrnCoercer.INSTANCE;
        localObject5 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject4));
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label907;
      }
      bool7 = true;
      if (bool7)
      {
        localObject6 = UrnCoercer.INSTANCE;
        localObject6 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject4));
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label913;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject4).get();
        paramString = localSocialActorBuilder;
        bool1 = bool2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localSocialActorBuilder = SocialActorBuilder.INSTANCE;
          paramString = SocialActorBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label919;
          }
          bool1 = true;
        }
        if (j == 1)
        {
          paramString = SocialActorBuilder.INSTANCE;
          paramString = SocialActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (paramString == null) {
            break label925;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label931;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        j = ((ByteBuffer)localObject4).get();
        localObject1 = localAnnotatedTextBuilder;
        bool2 = bool3;
        if (j == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localAnnotatedTextBuilder = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label937;
          }
          bool2 = true;
        }
        if (j == 1)
        {
          localObject1 = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label943;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label949;
      }
      bool8 = true;
      if (bool8) {
        l = ((ByteBuffer)localObject4).getLong();
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label955;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        j = ((ByteBuffer)localObject4).get();
        localObject2 = localSocialDetailBuilder;
        bool3 = bool4;
        if (j == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localSocialDetailBuilder = SocialDetailBuilder.INSTANCE;
          localObject2 = SocialDetailBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label961;
          }
          bool3 = true;
        }
        if (j == 1)
        {
          localObject2 = SocialDetailBuilder.INSTANCE;
          localObject2 = SocialDetailBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label967;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label973;
      }
      bool9 = true;
      if (bool9) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label979;
      }
      bool10 = true;
      if (bool10) {
        i = ((ByteBuffer)localObject4).getInt();
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label985;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        j = ((ByteBuffer)localObject4).get();
        localObject3 = localInsightBuilder;
        bool4 = bool5;
        if (j == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localInsightBuilder = InsightBuilder.INSTANCE;
          localObject3 = InsightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label991;
          }
          bool4 = true;
        }
        if (j == 1)
        {
          localObject3 = InsightBuilder.INSTANCE;
          localObject3 = InsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label997;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label1003;
      }
      bool11 = true;
      label805:
      bool5 = bool12;
      if (bool11)
      {
        if (((ByteBuffer)localObject4).get() != 1) {
          break label1009;
        }
        bool5 = true;
      }
      label826:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label1015;
      }
    }
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
    label997:
    label1003:
    label1009:
    label1015:
    for (bool12 = true;; bool12 = false)
    {
      paramFissionTransaction = localArrayList;
      if (!bool12) {
        break label1021;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4);
      localArrayList = new ArrayList();
      for (;;)
      {
        paramFissionTransaction = localArrayList;
        if (j <= 0) {
          break;
        }
        localArrayList.add(CommentAction.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4)));
        j -= 1;
      }
      bool6 = false;
      break;
      bool7 = false;
      break label291;
      bool2 = false;
      break label326;
      bool1 = false;
      break label383;
      bool1 = false;
      break label409;
      bool3 = false;
      break label421;
      bool2 = false;
      break label483;
      bool2 = false;
      break label512;
      bool8 = false;
      break label524;
      bool4 = false;
      break label548;
      bool3 = false;
      break label610;
      bool3 = false;
      break label639;
      bool9 = false;
      break label651;
      bool10 = false;
      break label678;
      bool5 = false;
      break label702;
      bool4 = false;
      break label764;
      bool4 = false;
      break label793;
      bool11 = false;
      break label805;
      bool5 = false;
      break label826;
    }
    label1021:
    if (((ByteBuffer)localObject4).get() == 1) {}
    for (boolean bool13 = true;; bool13 = false)
    {
      if (bool13)
      {
        localObject7 = UrnCoercer.INSTANCE;
        localObject7 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject4));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (!bool11) {
        bool5 = false;
      }
      if (!bool12) {
        paramFissionTransaction = Collections.emptyList();
      }
      if (bool1) {
        break;
      }
      throw new IOException("Failed to find required field: commenter when reading com.linkedin.android.pegasus.gen.voyager.feed.Comment from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: comment when reading com.linkedin.android.pegasus.gen.voyager.feed.Comment from fission.");
    }
    if (!bool8) {
      throw new IOException("Failed to find required field: createdTime when reading com.linkedin.android.pegasus.gen.voyager.feed.Comment from fission.");
    }
    if (!bool9) {
      throw new IOException("Failed to find required field: threadId when reading com.linkedin.android.pegasus.gen.voyager.feed.Comment from fission.");
    }
    if (!bool10) {
      throw new IOException("Failed to find required field: index when reading com.linkedin.android.pegasus.gen.voyager.feed.Comment from fission.");
    }
    return new Comment((Urn)localObject5, (Urn)localObject6, paramString, (AnnotatedText)localObject1, l, (SocialDetail)localObject2, str, i, (Insight)localObject3, bool5, paramFissionTransaction, (Urn)localObject7, bool6, bool7, bool1, bool2, bool8, bool3, bool9, bool10, bool4, bool11, bool12, bool13);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.CommentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */