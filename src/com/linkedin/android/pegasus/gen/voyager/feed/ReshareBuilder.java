package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
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

public final class ReshareBuilder
  implements FissileDataModelBuilder<Reshare>, DataTemplateBuilder<Reshare>
{
  public static final ReshareBuilder INSTANCE = new ReshareBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("shareAudience");
    JSON_KEY_STORE.put("actions");
    JSON_KEY_STORE.put("urn");
    JSON_KEY_STORE.put("text");
    JSON_KEY_STORE.put("attributedText");
    JSON_KEY_STORE.put("originalUpdate");
    JSON_KEY_STORE.put("actor");
    JSON_KEY_STORE.put("createdTime");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("tracking");
    JSON_KEY_STORE.put("header");
    JSON_KEY_STORE.put("edited");
    JSON_KEY_STORE.put("shareUrn");
  }
  
  public static Reshare build(DataReader paramDataReader)
    throws DataReaderException
  {
    ShareAudience localShareAudience = null;
    Object localObject1 = null;
    Object localObject9 = null;
    Object localObject8 = null;
    Object localObject7 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    long l = 0L;
    String str = null;
    Object localObject4 = null;
    Object localObject3 = null;
    boolean bool14 = false;
    Object localObject2 = null;
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
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("shareAudience", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localShareAudience = (ShareAudience)paramDataReader.readEnum(ShareAudience.Builder.INSTANCE);
        bool13 = true;
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
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("urn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject9 = UrnCoercer.INSTANCE;
        localObject9 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject8 = AnnotatedTextBuilder.INSTANCE;
        localObject8 = AnnotatedTextBuilder.build(paramDataReader);
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("attributedText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = AttributedTextBuilder.INSTANCE;
        localObject7 = AttributedTextBuilder.build(paramDataReader);
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("originalUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = UpdateBuilder.INSTANCE;
        localObject6 = UpdateBuilder.build(paramDataReader);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actor", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = SocialActorBuilder.INSTANCE;
        localObject5 = SocialActorBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("createdTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("tracking", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = TrackingDataBuilder.INSTANCE;
        localObject4 = TrackingDataBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("header", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AttributedTextBuilder.INSTANCE;
        localObject3 = AttributedTextBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("edited", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool14 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("shareUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool12) {
      localObject1 = Collections.emptyList();
    }
    if (!bool13) {
      throw new DataReaderException("Failed to find required field: shareAudience when building com.linkedin.android.pegasus.gen.voyager.feed.Reshare");
    }
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: originalUpdate when building com.linkedin.android.pegasus.gen.voyager.feed.Reshare");
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: actor when building com.linkedin.android.pegasus.gen.voyager.feed.Reshare");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: createdTime when building com.linkedin.android.pegasus.gen.voyager.feed.Reshare");
    }
    return new Reshare(localShareAudience, (List)localObject1, (Urn)localObject9, (AnnotatedText)localObject8, (AttributedText)localObject7, (Update)localObject6, (SocialActor)localObject5, l, str, (TrackingData)localObject4, (AttributedText)localObject3, bool14, (Urn)localObject2, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool2, bool3, bool1);
  }
  
  public static Reshare readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Reshare");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Reshare");
    }
    Object localObject7 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Reshare");
    }
    if (((ByteBuffer)localObject7).getInt() != 1409261936)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject7);
      throw new IOException("UID mismatch. Can't read cached data when building Reshare");
    }
    ShareAudience localShareAudience = null;
    paramString = null;
    Object localObject8 = null;
    localObject1 = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder = null;
    Object localObject2 = null;
    AttributedTextBuilder localAttributedTextBuilder2 = null;
    Object localObject3 = null;
    UpdateBuilder localUpdateBuilder = null;
    Object localObject4 = null;
    SocialActorBuilder localSocialActorBuilder = null;
    long l = 0L;
    String str = null;
    Object localObject5 = null;
    TrackingDataBuilder localTrackingDataBuilder = null;
    Object localObject6 = null;
    AttributedTextBuilder localAttributedTextBuilder1 = null;
    boolean bool14 = false;
    Object localObject9 = null;
    boolean bool8;
    boolean bool9;
    label295:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject7).get() == 1)
    {
      bool8 = true;
      if (bool8) {
        localShareAudience = ShareAudience.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject7));
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label428;
      }
      bool9 = true;
      if (!bool9) {
        break label446;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject7);
      localArrayList = new ArrayList();
      label319:
      paramString = localArrayList;
      if (j <= 0) {
        break label446;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject7).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject7);
        UpdateActionBuilder localUpdateActionBuilder = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label434;
        }
        i = 1;
      }
      label373:
      if (k == 1)
      {
        paramString = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
        if (paramString == null) {
          break label440;
        }
      }
    }
    label428:
    label434:
    label440:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label319;
      bool8 = false;
      break;
      bool9 = false;
      break label295;
      i = 0;
      break label373;
    }
    label446:
    boolean bool10;
    boolean bool2;
    label493:
    boolean bool1;
    label555:
    label584:
    boolean bool3;
    label596:
    label658:
    label687:
    boolean bool4;
    label699:
    label761:
    label790:
    boolean bool5;
    label802:
    label864:
    label893:
    boolean bool11;
    label905:
    boolean bool12;
    label929:
    boolean bool6;
    label956:
    label1018:
    label1047:
    boolean bool7;
    label1059:
    label1121:
    label1150:
    boolean bool13;
    if (((ByteBuffer)localObject7).get() == 1)
    {
      bool10 = true;
      if (bool10)
      {
        localObject8 = UrnCoercer.INSTANCE;
        localObject8 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject7));
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1262;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject1 = localAnnotatedTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localAnnotatedTextBuilder = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label1268;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          localObject1 = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label1274;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1280;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject2 = localAttributedTextBuilder2;
        bool2 = bool3;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localAttributedTextBuilder2 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1286;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject2 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1292;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1298;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject3 = localUpdateBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localUpdateBuilder = UpdateBuilder.INSTANCE;
          localObject3 = UpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1304;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject3 = UpdateBuilder.INSTANCE;
          localObject3 = UpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1310;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1316;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject4 = localSocialActorBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localSocialActorBuilder = SocialActorBuilder.INSTANCE;
          localObject4 = SocialActorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1322;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject4 = SocialActorBuilder.INSTANCE;
          localObject4 = SocialActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1328;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1334;
      }
      bool11 = true;
      if (bool11) {
        l = ((ByteBuffer)localObject7).getLong();
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1340;
      }
      bool12 = true;
      if (bool12) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject7);
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1346;
      }
      bool6 = true;
      bool5 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject5 = localTrackingDataBuilder;
        bool5 = bool6;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localTrackingDataBuilder = TrackingDataBuilder.INSTANCE;
          localObject5 = TrackingDataBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label1352;
          }
          bool5 = true;
        }
        if (i == 1)
        {
          localObject5 = TrackingDataBuilder.INSTANCE;
          localObject5 = TrackingDataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label1358;
          }
          bool5 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1364;
      }
      bool7 = true;
      bool6 = bool7;
      if (bool7)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject6 = localAttributedTextBuilder1;
        bool6 = bool7;
        if (i == 0)
        {
          localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localAttributedTextBuilder1 = AttributedTextBuilder.INSTANCE;
          localObject6 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
          if (localObject6 == null) {
            break label1370;
          }
          bool6 = true;
        }
        if (i == 1)
        {
          localObject6 = AttributedTextBuilder.INSTANCE;
          localObject6 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject6 == null) {
            break label1376;
          }
          bool6 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1382;
      }
      bool13 = true;
      label1162:
      bool7 = bool14;
      if (bool13)
      {
        if (((ByteBuffer)localObject7).get() != 1) {
          break label1388;
        }
        bool7 = true;
      }
      label1183:
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1394;
      }
    }
    label1262:
    label1268:
    label1274:
    label1280:
    label1286:
    label1292:
    label1298:
    label1304:
    label1310:
    label1316:
    label1322:
    label1328:
    label1334:
    label1340:
    label1346:
    label1352:
    label1358:
    label1364:
    label1370:
    label1376:
    label1382:
    label1388:
    label1394:
    for (bool14 = true;; bool14 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject9;
      if (bool14)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject7));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject7);
      }
      if (!bool9) {
        paramString = Collections.emptyList();
      }
      if (bool8) {
        break label1400;
      }
      throw new IOException("Failed to find required field: shareAudience when reading com.linkedin.android.pegasus.gen.voyager.feed.Reshare from fission.");
      bool10 = false;
      break;
      bool2 = false;
      break label493;
      bool1 = false;
      break label555;
      bool1 = false;
      break label584;
      bool3 = false;
      break label596;
      bool2 = false;
      break label658;
      bool2 = false;
      break label687;
      bool4 = false;
      break label699;
      bool3 = false;
      break label761;
      bool3 = false;
      break label790;
      bool5 = false;
      break label802;
      bool4 = false;
      break label864;
      bool4 = false;
      break label893;
      bool11 = false;
      break label905;
      bool12 = false;
      break label929;
      bool6 = false;
      break label956;
      bool5 = false;
      break label1018;
      bool5 = false;
      break label1047;
      bool7 = false;
      break label1059;
      bool6 = false;
      break label1121;
      bool6 = false;
      break label1150;
      bool13 = false;
      break label1162;
      bool7 = false;
      break label1183;
    }
    label1400:
    if (!bool3) {
      throw new IOException("Failed to find required field: originalUpdate when reading com.linkedin.android.pegasus.gen.voyager.feed.Reshare from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: actor when reading com.linkedin.android.pegasus.gen.voyager.feed.Reshare from fission.");
    }
    if (!bool11) {
      throw new IOException("Failed to find required field: createdTime when reading com.linkedin.android.pegasus.gen.voyager.feed.Reshare from fission.");
    }
    return new Reshare(localShareAudience, paramString, (Urn)localObject8, (AnnotatedText)localObject1, (AttributedText)localObject2, (Update)localObject3, (SocialActor)localObject4, l, str, (TrackingData)localObject5, (AttributedText)localObject6, bool7, paramFissionTransaction, bool8, bool9, bool10, bool1, bool2, bool3, bool4, bool11, bool12, bool5, bool6, bool13, bool14);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ReshareBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */