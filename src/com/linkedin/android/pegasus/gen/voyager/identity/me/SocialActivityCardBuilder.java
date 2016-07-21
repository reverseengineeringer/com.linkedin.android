package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.ImageBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroupBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCountsBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SocialActivityCardBuilder
  implements FissileDataModelBuilder<SocialActivityCard>, DataTemplateBuilder<SocialActivityCard>
{
  public static final SocialActivityCardBuilder INSTANCE = new SocialActivityCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("publishedAt");
    JSON_KEY_STORE.put("entity");
    JSON_KEY_STORE.put("sharedEntity");
    JSON_KEY_STORE.put("headline");
    JSON_KEY_STORE.put("headlineV2");
    JSON_KEY_STORE.put("actor");
    JSON_KEY_STORE.put("totalSocialActivityCounts");
    JSON_KEY_STORE.put("comment");
    JSON_KEY_STORE.put("commentUrn");
    JSON_KEY_STORE.put("replyUrn");
    JSON_KEY_STORE.put("text");
    JSON_KEY_STORE.put("image");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("url");
    JSON_KEY_STORE.put("read");
    JSON_KEY_STORE.put("group");
    JSON_KEY_STORE.put("groupDiscussionUrl");
  }
  
  public static SocialActivityCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    Object localObject12 = null;
    Object localObject11 = null;
    Object localObject10 = null;
    Object localObject9 = null;
    Object localObject8 = null;
    Object localObject7 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    String str3 = null;
    String str2 = null;
    boolean bool18 = false;
    Object localObject1 = null;
    String str1 = null;
    boolean bool17 = false;
    boolean bool16 = false;
    boolean bool15 = false;
    boolean bool14 = false;
    boolean bool13 = false;
    boolean bool12 = false;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
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
        bool17 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entity", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject12 = UrnCoercer.INSTANCE;
        localObject12 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool16 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("sharedEntity", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject11 = UrnCoercer.INSTANCE;
        localObject11 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool15 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("headline", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject10 = AttributedTextBuilder.INSTANCE;
        localObject10 = AttributedTextBuilder.build(paramDataReader);
        bool14 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("headlineV2", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject9 = AttributedTextBuilder.INSTANCE;
        localObject9 = AttributedTextBuilder.build(paramDataReader);
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actor", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject8 = ActorMiniProfileBuilder.INSTANCE;
        localObject8 = ActorMiniProfileBuilder.build(paramDataReader);
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("totalSocialActivityCounts", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = SocialActivityCountsBuilder.INSTANCE;
        localObject7 = SocialActivityCountsBuilder.build(paramDataReader);
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("comment", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = AttributedTextBuilder.INSTANCE;
        localObject6 = AttributedTextBuilder.build(paramDataReader);
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("commentUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = UrnCoercer.INSTANCE;
        localObject5 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("replyUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AttributedTextBuilder.INSTANCE;
        localObject3 = AttributedTextBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("image", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ImageBuilder.INSTANCE;
        localObject2 = ImageBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("read", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool18 = paramDataReader.readBoolean();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("group", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = MiniGroupBuilder.INSTANCE;
        localObject1 = MiniGroupBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("groupDiscussionUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool17) {
      throw new DataReaderException("Failed to find required field: publishedAt when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard");
    }
    if (!bool16) {
      throw new DataReaderException("Failed to find required field: entity when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard");
    }
    if (!bool14) {
      throw new DataReaderException("Failed to find required field: headline when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard");
    }
    if (!bool12) {
      throw new DataReaderException("Failed to find required field: actor when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard");
    }
    if (!bool11) {
      throw new DataReaderException("Failed to find required field: totalSocialActivityCounts when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: read when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard");
    }
    return new SocialActivityCard(l, (Urn)localObject12, (Urn)localObject11, (AttributedText)localObject10, (AttributedText)localObject9, (ActorMiniProfile)localObject8, (SocialActivityCounts)localObject7, (AttributedText)localObject6, (Urn)localObject5, (Urn)localObject4, (AttributedText)localObject3, (Image)localObject2, str3, str2, bool18, (MiniGroup)localObject1, str1, bool17, bool16, bool15, bool14, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool3, bool4, bool2, bool1);
  }
  
  public static SocialActivityCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SocialActivityCard");
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
          localObject8 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialActivityCard");
    }
    Object localObject8 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialActivityCard");
    }
    if (((ByteBuffer)localObject8).getInt() != -320237211)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject8);
      throw new IOException("UID mismatch. Can't read cached data when building SocialActivityCard");
    }
    long l = 0L;
    Object localObject9 = null;
    Object localObject10 = null;
    paramString = null;
    AttributedTextBuilder localAttributedTextBuilder4 = null;
    localObject1 = null;
    AttributedTextBuilder localAttributedTextBuilder3 = null;
    Object localObject2 = null;
    ActorMiniProfileBuilder localActorMiniProfileBuilder = null;
    Object localObject3 = null;
    SocialActivityCountsBuilder localSocialActivityCountsBuilder = null;
    Object localObject4 = null;
    AttributedTextBuilder localAttributedTextBuilder2 = null;
    Object localObject11 = null;
    Object localObject12 = null;
    Object localObject5 = null;
    AttributedTextBuilder localAttributedTextBuilder1 = null;
    Object localObject6 = null;
    ImageBuilder localImageBuilder = null;
    String str1 = null;
    String str2 = null;
    boolean bool10 = false;
    Object localObject7 = null;
    MiniGroupBuilder localMiniGroupBuilder = null;
    Object localObject13 = null;
    boolean bool11;
    boolean bool12;
    label307:
    boolean bool13;
    label342:
    boolean bool2;
    label377:
    boolean bool1;
    label434:
    label460:
    boolean bool3;
    label472:
    label534:
    label563:
    boolean bool4;
    label575:
    label637:
    label666:
    boolean bool5;
    label678:
    label740:
    label769:
    boolean bool6;
    label781:
    label843:
    label872:
    boolean bool14;
    label884:
    boolean bool15;
    label919:
    boolean bool7;
    label954:
    label1016:
    label1045:
    boolean bool8;
    label1057:
    label1119:
    label1148:
    boolean bool16;
    label1160:
    boolean bool17;
    label1187:
    boolean bool18;
    if (((ByteBuffer)localObject8).get() == 1)
    {
      bool11 = true;
      if (bool11) {
        l = ((ByteBuffer)localObject8).getLong();
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1396;
      }
      bool12 = true;
      if (bool12)
      {
        localObject9 = UrnCoercer.INSTANCE;
        localObject9 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject8));
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1402;
      }
      bool13 = true;
      if (bool13)
      {
        localObject10 = UrnCoercer.INSTANCE;
        localObject10 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject8));
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1408;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject8).get();
        paramString = localAttributedTextBuilder4;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localAttributedTextBuilder4 = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label1414;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (paramString == null) {
            break label1420;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1426;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject1 = localAttributedTextBuilder3;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localAttributedTextBuilder3 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label1432;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label1438;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1444;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject2 = localActorMiniProfileBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localActorMiniProfileBuilder = ActorMiniProfileBuilder.INSTANCE;
          localObject2 = ActorMiniProfileBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1450;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = ActorMiniProfileBuilder.INSTANCE;
          localObject2 = ActorMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1456;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1462;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject3 = localSocialActivityCountsBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localSocialActivityCountsBuilder = SocialActivityCountsBuilder.INSTANCE;
          localObject3 = SocialActivityCountsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1468;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject3 = SocialActivityCountsBuilder.INSTANCE;
          localObject3 = SocialActivityCountsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1474;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1480;
      }
      bool6 = true;
      bool5 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject4 = localAttributedTextBuilder2;
        bool5 = bool6;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localAttributedTextBuilder2 = AttributedTextBuilder.INSTANCE;
          localObject4 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1486;
          }
          bool5 = true;
        }
        if (i == 1)
        {
          localObject4 = AttributedTextBuilder.INSTANCE;
          localObject4 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1492;
          }
          bool5 = true;
        }
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1498;
      }
      bool14 = true;
      if (bool14)
      {
        localObject11 = UrnCoercer.INSTANCE;
        localObject11 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject8));
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1504;
      }
      bool15 = true;
      if (bool15)
      {
        localObject12 = UrnCoercer.INSTANCE;
        localObject12 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject8));
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1510;
      }
      bool7 = true;
      bool6 = bool7;
      if (bool7)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject5 = localAttributedTextBuilder1;
        bool6 = bool7;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localAttributedTextBuilder1 = AttributedTextBuilder.INSTANCE;
          localObject5 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label1516;
          }
          bool6 = true;
        }
        if (i == 1)
        {
          localObject5 = AttributedTextBuilder.INSTANCE;
          localObject5 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label1522;
          }
          bool6 = true;
        }
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1528;
      }
      bool8 = true;
      bool7 = bool8;
      if (bool8)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject6 = localImageBuilder;
        bool7 = bool8;
        if (i == 0)
        {
          localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localImageBuilder = ImageBuilder.INSTANCE;
          localObject6 = ImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
          if (localObject6 == null) {
            break label1534;
          }
          bool7 = true;
        }
        if (i == 1)
        {
          localObject6 = ImageBuilder.INSTANCE;
          localObject6 = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject6 == null) {
            break label1540;
          }
          bool7 = true;
        }
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1546;
      }
      bool16 = true;
      if (bool16) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject8);
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1552;
      }
      bool17 = true;
      if (bool17) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject8);
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1558;
      }
      bool18 = true;
      label1214:
      if (bool18)
      {
        if (((ByteBuffer)localObject8).get() != 1) {
          break label1564;
        }
        bool10 = true;
      }
      label1231:
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1570;
      }
      bool9 = true;
      label1243:
      bool8 = bool9;
      if (bool9)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject7 = localMiniGroupBuilder;
        bool8 = bool9;
        if (i == 0)
        {
          localObject7 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localMiniGroupBuilder = MiniGroupBuilder.INSTANCE;
          localObject7 = MiniGroupBuilder.readFromFission(paramFissionAdapter, null, (String)localObject7, paramFissionTransaction);
          if (localObject7 == null) {
            break label1576;
          }
          bool8 = true;
        }
        label1305:
        if (i == 1)
        {
          localObject7 = MiniGroupBuilder.INSTANCE;
          localObject7 = MiniGroupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject7 == null) {
            break label1582;
          }
          bool8 = true;
        }
      }
      label1334:
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1588;
      }
    }
    label1396:
    label1402:
    label1408:
    label1414:
    label1420:
    label1426:
    label1432:
    label1438:
    label1444:
    label1450:
    label1456:
    label1462:
    label1468:
    label1474:
    label1480:
    label1486:
    label1492:
    label1498:
    label1504:
    label1510:
    label1516:
    label1522:
    label1528:
    label1534:
    label1540:
    label1546:
    label1552:
    label1558:
    label1564:
    label1570:
    label1576:
    label1582:
    label1588:
    for (boolean bool9 = true;; bool9 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject13;
      if (bool9) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject8);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject8);
      }
      if (bool11) {
        break label1594;
      }
      throw new IOException("Failed to find required field: publishedAt when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard from fission.");
      bool11 = false;
      break;
      bool12 = false;
      break label307;
      bool13 = false;
      break label342;
      bool2 = false;
      break label377;
      bool1 = false;
      break label434;
      bool1 = false;
      break label460;
      bool3 = false;
      break label472;
      bool2 = false;
      break label534;
      bool2 = false;
      break label563;
      bool4 = false;
      break label575;
      bool3 = false;
      break label637;
      bool3 = false;
      break label666;
      bool5 = false;
      break label678;
      bool4 = false;
      break label740;
      bool4 = false;
      break label769;
      bool6 = false;
      break label781;
      bool5 = false;
      break label843;
      bool5 = false;
      break label872;
      bool14 = false;
      break label884;
      bool15 = false;
      break label919;
      bool7 = false;
      break label954;
      bool6 = false;
      break label1016;
      bool6 = false;
      break label1045;
      bool8 = false;
      break label1057;
      bool7 = false;
      break label1119;
      bool7 = false;
      break label1148;
      bool16 = false;
      break label1160;
      bool17 = false;
      break label1187;
      bool18 = false;
      break label1214;
      bool10 = false;
      break label1231;
      bool9 = false;
      break label1243;
      bool8 = false;
      break label1305;
      bool8 = false;
      break label1334;
    }
    label1594:
    if (!bool12) {
      throw new IOException("Failed to find required field: entity when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: headline when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: actor when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: totalSocialActivityCounts when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard from fission.");
    }
    if (!bool18) {
      throw new IOException("Failed to find required field: read when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard from fission.");
    }
    return new SocialActivityCard(l, (Urn)localObject9, (Urn)localObject10, paramString, (AttributedText)localObject1, (ActorMiniProfile)localObject2, (SocialActivityCounts)localObject3, (AttributedText)localObject4, (Urn)localObject11, (Urn)localObject12, (AttributedText)localObject5, (Image)localObject6, str1, str2, bool10, (MiniGroup)localObject7, paramFissionTransaction, bool11, bool12, bool13, bool1, bool2, bool3, bool4, bool5, bool14, bool15, bool6, bool7, bool16, bool17, bool18, bool8, bool9);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */