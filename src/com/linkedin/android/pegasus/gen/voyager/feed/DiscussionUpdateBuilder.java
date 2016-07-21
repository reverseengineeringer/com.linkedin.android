package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroupBuilder;
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

public final class DiscussionUpdateBuilder
  implements FissileDataModelBuilder<DiscussionUpdate>, DataTemplateBuilder<DiscussionUpdate>
{
  public static final DiscussionUpdateBuilder INSTANCE = new DiscussionUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("content");
    JSON_KEY_STORE.put("actions");
    JSON_KEY_STORE.put("id");
    JSON_KEY_STORE.put("urn");
    JSON_KEY_STORE.put("discussionSource");
    JSON_KEY_STORE.put("actor");
    JSON_KEY_STORE.put("miniGroup");
    JSON_KEY_STORE.put("featured");
    JSON_KEY_STORE.put("active");
    JSON_KEY_STORE.put("createdTime");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("tracking");
  }
  
  public static DiscussionUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject6 = null;
    Object localObject1 = null;
    String str2 = null;
    Object localObject5 = null;
    DiscussionSource localDiscussionSource = null;
    Object localObject4 = null;
    Object localObject3 = null;
    boolean bool14 = false;
    boolean bool13 = false;
    long l = 0L;
    String str1 = null;
    Object localObject2 = null;
    boolean bool12 = false;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("content", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = DiscussionUpdateContentBuilder.ContentBuilder.INSTANCE;
        localObject6 = DiscussionUpdateContentBuilder.ContentBuilder.build(paramDataReader);
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actions", JSON_KEY_STORE))
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
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("urn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = UrnCoercer.INSTANCE;
        localObject5 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("discussionSource", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localDiscussionSource = (DiscussionSource)paramDataReader.readEnum(DiscussionSource.Builder.INSTANCE);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actor", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = SocialActorBuilder.INSTANCE;
        localObject4 = SocialActorBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("miniGroup", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = MiniGroupBuilder.INSTANCE;
        localObject3 = MiniGroupBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("featured", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool14 = paramDataReader.readBoolean();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("active", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool13 = paramDataReader.readBoolean();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("createdTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("tracking", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = TrackingDataBuilder.INSTANCE;
        localObject2 = TrackingDataBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool11) {
      localObject1 = Collections.emptyList();
    }
    if (!bool12) {
      throw new DataReaderException("Failed to find required field: content when building com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate");
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: actor when building com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: miniGroup when building com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: createdTime when building com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate");
    }
    return new DiscussionUpdate((DiscussionUpdateContent.Content)localObject6, (List)localObject1, str2, (Urn)localObject5, localDiscussionSource, (SocialActor)localObject4, (MiniGroup)localObject3, bool14, bool13, l, str1, (TrackingData)localObject2, bool12, bool11, bool10, bool9, bool8, bool7, bool5, bool6, bool4, bool3, bool2, bool1);
  }
  
  public static DiscussionUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building DiscussionUpdate");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building DiscussionUpdate");
    }
    Object localObject5 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building DiscussionUpdate");
    }
    if (((ByteBuffer)localObject5).getInt() != -767731381)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject5);
      throw new IOException("UID mismatch. Can't read cached data when building DiscussionUpdate");
    }
    paramString = null;
    Object localObject7 = null;
    localObject1 = null;
    String str1 = null;
    Object localObject6 = null;
    DiscussionSource localDiscussionSource = null;
    Object localObject2 = null;
    SocialActorBuilder localSocialActorBuilder = null;
    Object localObject3 = null;
    MiniGroupBuilder localMiniGroupBuilder = null;
    boolean bool6 = false;
    boolean bool7 = false;
    long l = 0L;
    String str2 = null;
    Object localObject4 = null;
    TrackingDataBuilder localTrackingDataBuilder = null;
    boolean bool2;
    boolean bool1;
    label313:
    label339:
    boolean bool8;
    if (((ByteBuffer)localObject5).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject5).get();
        paramString = (String)localObject7;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localObject7 = DiscussionUpdateContentBuilder.ContentBuilder.INSTANCE;
          paramString = DiscussionUpdateContentBuilder.ContentBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label494;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = DiscussionUpdateContentBuilder.ContentBuilder.INSTANCE;
          paramString = DiscussionUpdateContentBuilder.ContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (paramString == null) {
            break label500;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label506;
      }
      bool8 = true;
      label351:
      if (!bool8) {
        break label524;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject5);
      localObject7 = new ArrayList();
      label375:
      localObject1 = localObject7;
      if (j <= 0) {
        break label524;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject5).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject5);
        UpdateActionBuilder localUpdateActionBuilder = UpdateActionBuilder.INSTANCE;
        localObject1 = UpdateActionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label512;
        }
        i = 1;
      }
      label435:
      if (k == 1)
      {
        localObject1 = UpdateActionBuilder.INSTANCE;
        localObject1 = UpdateActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label518;
        }
      }
    }
    label494:
    label500:
    label506:
    label512:
    label518:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject7).add(localObject1);
      }
      j -= 1;
      break label375;
      bool2 = false;
      break;
      bool1 = false;
      break label313;
      bool1 = false;
      break label339;
      bool8 = false;
      break label351;
      i = 0;
      break label435;
    }
    label524:
    boolean bool9;
    boolean bool10;
    label563:
    boolean bool11;
    label598:
    boolean bool3;
    label628:
    label690:
    label719:
    boolean bool4;
    label731:
    label793:
    label822:
    boolean bool12;
    label834:
    label851:
    boolean bool13;
    label863:
    label880:
    boolean bool14;
    label892:
    boolean bool15;
    if (((ByteBuffer)localObject5).get() == 1)
    {
      bool9 = true;
      if (bool9) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject5);
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1077;
      }
      bool10 = true;
      if (bool10)
      {
        localObject6 = UrnCoercer.INSTANCE;
        localObject6 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject5));
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1083;
      }
      bool11 = true;
      if (bool11) {
        localDiscussionSource = DiscussionSource.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject5));
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1089;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject2 = localSocialActorBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localSocialActorBuilder = SocialActorBuilder.INSTANCE;
          localObject2 = SocialActorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1095;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject2 = SocialActorBuilder.INSTANCE;
          localObject2 = SocialActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1101;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1107;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject3 = localMiniGroupBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localMiniGroupBuilder = MiniGroupBuilder.INSTANCE;
          localObject3 = MiniGroupBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1113;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject3 = MiniGroupBuilder.INSTANCE;
          localObject3 = MiniGroupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1119;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1125;
      }
      bool12 = true;
      if (bool12)
      {
        if (((ByteBuffer)localObject5).get() != 1) {
          break label1131;
        }
        bool6 = true;
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1137;
      }
      bool13 = true;
      if (bool13)
      {
        if (((ByteBuffer)localObject5).get() != 1) {
          break label1143;
        }
        bool7 = true;
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1149;
      }
      bool14 = true;
      if (bool14) {
        l = ((ByteBuffer)localObject5).getLong();
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1155;
      }
      bool15 = true;
      label916:
      if (bool15) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject5);
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1161;
      }
      bool4 = true;
      label943:
      bool5 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject4 = localTrackingDataBuilder;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localTrackingDataBuilder = TrackingDataBuilder.INSTANCE;
          localObject4 = TrackingDataBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1167;
          }
          bool4 = true;
        }
        label1001:
        bool5 = bool4;
        if (i == 1)
        {
          localObject4 = TrackingDataBuilder.INSTANCE;
          localObject4 = TrackingDataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1173;
          }
        }
      }
    }
    label1077:
    label1083:
    label1089:
    label1095:
    label1101:
    label1107:
    label1113:
    label1119:
    label1125:
    label1131:
    label1137:
    label1143:
    label1149:
    label1155:
    label1161:
    label1167:
    label1173:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject5);
      }
      if (!bool8) {
        localObject1 = Collections.emptyList();
      }
      if (bool1) {
        break label1179;
      }
      throw new IOException("Failed to find required field: content when reading com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate from fission.");
      bool9 = false;
      break;
      bool10 = false;
      break label563;
      bool11 = false;
      break label598;
      bool3 = false;
      break label628;
      bool2 = false;
      break label690;
      bool2 = false;
      break label719;
      bool4 = false;
      break label731;
      bool3 = false;
      break label793;
      bool3 = false;
      break label822;
      bool12 = false;
      break label834;
      bool6 = false;
      break label851;
      bool13 = false;
      break label863;
      bool7 = false;
      break label880;
      bool14 = false;
      break label892;
      bool15 = false;
      break label916;
      bool4 = false;
      break label943;
      bool4 = false;
      break label1001;
    }
    label1179:
    if (!bool2) {
      throw new IOException("Failed to find required field: actor when reading com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: miniGroup when reading com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate from fission.");
    }
    if (!bool14) {
      throw new IOException("Failed to find required field: createdTime when reading com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate from fission.");
    }
    return new DiscussionUpdate(paramString, (List)localObject1, str1, (Urn)localObject6, localDiscussionSource, (SocialActor)localObject2, (MiniGroup)localObject3, bool6, bool7, l, str2, (TrackingData)localObject4, bool1, bool8, bool9, bool10, bool11, bool2, bool3, bool12, bool13, bool14, bool15, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */