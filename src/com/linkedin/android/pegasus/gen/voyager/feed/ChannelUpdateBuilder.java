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

public final class ChannelUpdateBuilder
  implements FissileDataModelBuilder<ChannelUpdate>, DataTemplateBuilder<ChannelUpdate>
{
  public static final ChannelUpdateBuilder INSTANCE = new ChannelUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("content");
    JSON_KEY_STORE.put("actions");
    JSON_KEY_STORE.put("urn");
    JSON_KEY_STORE.put("actor");
    JSON_KEY_STORE.put("header");
    JSON_KEY_STORE.put("contentPool");
    JSON_KEY_STORE.put("articleUpdate");
    JSON_KEY_STORE.put("createdTime");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("tracking");
  }
  
  public static ChannelUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject8 = null;
    Object localObject1 = null;
    Object localObject7 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    long l = 0L;
    String str = null;
    Object localObject2 = null;
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
      if (paramDataReader.shouldReadField$11ca93e7("content", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject8 = ShareUpdateContentBuilder.ContentBuilder.INSTANCE;
        localObject8 = ShareUpdateContentBuilder.ContentBuilder.build(paramDataReader);
        bool10 = true;
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
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("urn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = UrnCoercer.INSTANCE;
        localObject7 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actor", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = ChannelActorBuilder.INSTANCE;
        localObject6 = ChannelActorBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("header", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = AnnotatedTextBuilder.INSTANCE;
        localObject5 = AnnotatedTextBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contentPool", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = AnnotatedTextBuilder.INSTANCE;
        localObject4 = AnnotatedTextBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("articleUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UpdateBuilder.INSTANCE;
        localObject3 = UpdateBuilder.build(paramDataReader);
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
        str = paramDataReader.readString();
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
    if (!bool9) {
      localObject1 = Collections.emptyList();
    }
    if (!bool10) {
      throw new DataReaderException("Failed to find required field: content when building com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdate");
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: actor when building com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdate");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: header when building com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdate");
    }
    return new ChannelUpdate((ShareUpdateContent.Content)localObject8, (List)localObject1, (Urn)localObject7, (ChannelActor)localObject6, (AnnotatedText)localObject5, (AnnotatedText)localObject4, (Update)localObject3, l, str, (TrackingData)localObject2, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static ChannelUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ChannelUpdate");
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
          localObject7 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ChannelUpdate");
    }
    Object localObject7 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ChannelUpdate");
    }
    if (((ByteBuffer)localObject7).getInt() != -341439366)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject7);
      throw new IOException("UID mismatch. Can't read cached data when building ChannelUpdate");
    }
    paramString = null;
    Object localObject9 = null;
    localObject1 = null;
    Object localObject8 = null;
    Object localObject2 = null;
    ChannelActorBuilder localChannelActorBuilder = null;
    Object localObject3 = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder2 = null;
    Object localObject4 = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder1 = null;
    Object localObject5 = null;
    UpdateBuilder localUpdateBuilder = null;
    long l = 0L;
    String str = null;
    Object localObject6 = null;
    TrackingDataBuilder localTrackingDataBuilder = null;
    boolean bool2;
    boolean bool1;
    label313:
    label339:
    boolean bool8;
    if (((ByteBuffer)localObject7).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject7).get();
        paramString = (String)localObject9;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localObject9 = ShareUpdateContentBuilder.ContentBuilder.INSTANCE;
          paramString = ShareUpdateContentBuilder.ContentBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label494;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ShareUpdateContentBuilder.ContentBuilder.INSTANCE;
          paramString = ShareUpdateContentBuilder.ContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (paramString == null) {
            break label500;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label506;
      }
      bool8 = true;
      label351:
      if (!bool8) {
        break label524;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject7);
      localObject9 = new ArrayList();
      label375:
      localObject1 = localObject9;
      if (j <= 0) {
        break label524;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject7).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject7);
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
        localObject1 = UpdateActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
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
        ((List)localObject9).add(localObject1);
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
    boolean bool3;
    label571:
    label633:
    label662:
    boolean bool4;
    label674:
    label736:
    label765:
    boolean bool5;
    label777:
    label839:
    label868:
    boolean bool6;
    label880:
    label942:
    label971:
    boolean bool10;
    label983:
    boolean bool11;
    if (((ByteBuffer)localObject7).get() == 1)
    {
      bool9 = true;
      if (bool9)
      {
        localObject8 = UrnCoercer.INSTANCE;
        localObject8 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject7));
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1168;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject2 = localChannelActorBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localChannelActorBuilder = ChannelActorBuilder.INSTANCE;
          localObject2 = ChannelActorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1174;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject2 = ChannelActorBuilder.INSTANCE;
          localObject2 = ChannelActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1180;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1186;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject3 = localAnnotatedTextBuilder2;
        bool3 = bool4;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localAnnotatedTextBuilder2 = AnnotatedTextBuilder.INSTANCE;
          localObject3 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1192;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject3 = AnnotatedTextBuilder.INSTANCE;
          localObject3 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1198;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1204;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject4 = localAnnotatedTextBuilder1;
        bool4 = bool5;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localAnnotatedTextBuilder1 = AnnotatedTextBuilder.INSTANCE;
          localObject4 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1210;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject4 = AnnotatedTextBuilder.INSTANCE;
          localObject4 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1216;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1222;
      }
      bool6 = true;
      bool5 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject5 = localUpdateBuilder;
        bool5 = bool6;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localUpdateBuilder = UpdateBuilder.INSTANCE;
          localObject5 = UpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label1228;
          }
          bool5 = true;
        }
        if (i == 1)
        {
          localObject5 = UpdateBuilder.INSTANCE;
          localObject5 = UpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label1234;
          }
          bool5 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1240;
      }
      bool10 = true;
      if (bool10) {
        l = ((ByteBuffer)localObject7).getLong();
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1246;
      }
      bool11 = true;
      label1007:
      if (bool11) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject7);
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1252;
      }
      bool6 = true;
      label1034:
      bool7 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject6 = localTrackingDataBuilder;
        if (i == 0)
        {
          localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localTrackingDataBuilder = TrackingDataBuilder.INSTANCE;
          localObject6 = TrackingDataBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
          if (localObject6 == null) {
            break label1258;
          }
          bool6 = true;
        }
        label1092:
        bool7 = bool6;
        if (i == 1)
        {
          localObject6 = TrackingDataBuilder.INSTANCE;
          localObject6 = TrackingDataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject6 == null) {
            break label1264;
          }
        }
      }
    }
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
    label1240:
    label1246:
    label1252:
    label1258:
    label1264:
    for (boolean bool7 = true;; bool7 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject7);
      }
      if (!bool8) {
        localObject1 = Collections.emptyList();
      }
      if (bool1) {
        break label1270;
      }
      throw new IOException("Failed to find required field: content when reading com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdate from fission.");
      bool9 = false;
      break;
      bool3 = false;
      break label571;
      bool2 = false;
      break label633;
      bool2 = false;
      break label662;
      bool4 = false;
      break label674;
      bool3 = false;
      break label736;
      bool3 = false;
      break label765;
      bool5 = false;
      break label777;
      bool4 = false;
      break label839;
      bool4 = false;
      break label868;
      bool6 = false;
      break label880;
      bool5 = false;
      break label942;
      bool5 = false;
      break label971;
      bool10 = false;
      break label983;
      bool11 = false;
      break label1007;
      bool6 = false;
      break label1034;
      bool6 = false;
      break label1092;
    }
    label1270:
    if (!bool2) {
      throw new IOException("Failed to find required field: actor when reading com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdate from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: header when reading com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdate from fission.");
    }
    return new ChannelUpdate(paramString, (List)localObject1, (Urn)localObject8, (ChannelActor)localObject2, (AnnotatedText)localObject3, (AnnotatedText)localObject4, (Update)localObject5, l, str, (TrackingData)localObject6, bool1, bool8, bool9, bool2, bool3, bool4, bool5, bool10, bool11, bool7);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */