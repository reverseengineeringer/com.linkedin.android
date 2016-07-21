package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCountsBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class JobUpdateActivityCardBuilder
  implements FissileDataModelBuilder<JobUpdateActivityCard>, DataTemplateBuilder<JobUpdateActivityCard>
{
  public static final JobUpdateActivityCardBuilder INSTANCE = new JobUpdateActivityCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("publishedAt");
    JSON_KEY_STORE.put("entity");
    JSON_KEY_STORE.put("headline");
    JSON_KEY_STORE.put("headlineV2");
    JSON_KEY_STORE.put("text");
    JSON_KEY_STORE.put("comment");
    JSON_KEY_STORE.put("commentUrn");
    JSON_KEY_STORE.put("actor");
    JSON_KEY_STORE.put("totalSocialActivityCounts");
    JSON_KEY_STORE.put("read");
  }
  
  public static JobUpdateActivityCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    Object localObject8 = null;
    Object localObject7 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("publishedAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entity", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject8 = UrnCoercer.INSTANCE;
        localObject8 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("headline", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = AttributedTextBuilder.INSTANCE;
        localObject7 = AttributedTextBuilder.build(paramDataReader);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("headlineV2", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = AttributedTextBuilder.INSTANCE;
        localObject6 = AttributedTextBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = AttributedTextBuilder.INSTANCE;
        localObject5 = AttributedTextBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("comment", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = AttributedTextBuilder.INSTANCE;
        localObject4 = AttributedTextBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("commentUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actor", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ActorMiniProfileBuilder.INSTANCE;
        localObject2 = ActorMiniProfileBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("totalSocialActivityCounts", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = SocialActivityCountsBuilder.INSTANCE;
        localObject1 = SocialActivityCountsBuilder.build(paramDataReader);
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("read", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool11 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool10) {
      throw new DataReaderException("Failed to find required field: publishedAt when building com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard");
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: entity when building com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard");
    }
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: headline when building com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: text when building com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: actor when building com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: totalSocialActivityCounts when building com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: read when building com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard");
    }
    return new JobUpdateActivityCard(l, (Urn)localObject8, (AttributedText)localObject7, (AttributedText)localObject6, (AttributedText)localObject5, (AttributedText)localObject4, (Urn)localObject3, (ActorMiniProfile)localObject2, (SocialActivityCounts)localObject1, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool1, bool2);
  }
  
  public static JobUpdateActivityCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building JobUpdateActivityCard");
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
          localObject6 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building JobUpdateActivityCard");
    }
    Object localObject6 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building JobUpdateActivityCard");
    }
    if (((ByteBuffer)localObject6).getInt() != 126638937)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject6);
      throw new IOException("UID mismatch. Can't read cached data when building JobUpdateActivityCard");
    }
    long l = 0L;
    Object localObject7 = null;
    paramString = null;
    AttributedTextBuilder localAttributedTextBuilder4 = null;
    localObject1 = null;
    AttributedTextBuilder localAttributedTextBuilder3 = null;
    Object localObject2 = null;
    AttributedTextBuilder localAttributedTextBuilder2 = null;
    Object localObject3 = null;
    AttributedTextBuilder localAttributedTextBuilder1 = null;
    Object localObject8 = null;
    Object localObject4 = null;
    ActorMiniProfileBuilder localActorMiniProfileBuilder = null;
    Object localObject5 = null;
    SocialActivityCountsBuilder localSocialActivityCountsBuilder = null;
    boolean bool12 = false;
    boolean bool8;
    boolean bool9;
    label280:
    boolean bool2;
    label315:
    boolean bool1;
    label372:
    label398:
    boolean bool3;
    label410:
    label472:
    label501:
    boolean bool4;
    label513:
    label575:
    label604:
    boolean bool5;
    label616:
    label678:
    label707:
    boolean bool10;
    label719:
    boolean bool6;
    label754:
    label816:
    label845:
    label857:
    label919:
    label948:
    boolean bool11;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool8 = true;
      if (bool8) {
        l = ((ByteBuffer)localObject6).getLong();
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1014;
      }
      bool9 = true;
      if (bool9)
      {
        localObject7 = UrnCoercer.INSTANCE;
        localObject7 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject6));
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1020;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject6).get();
        paramString = localAttributedTextBuilder4;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localAttributedTextBuilder4 = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label1026;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (paramString == null) {
            break label1032;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1038;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject1 = localAttributedTextBuilder3;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localAttributedTextBuilder3 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label1044;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label1050;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1056;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject2 = localAttributedTextBuilder2;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localAttributedTextBuilder2 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1062;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1068;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1074;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject3 = localAttributedTextBuilder1;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localAttributedTextBuilder1 = AttributedTextBuilder.INSTANCE;
          localObject3 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1080;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject3 = AttributedTextBuilder.INSTANCE;
          localObject3 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1086;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1092;
      }
      bool10 = true;
      if (bool10)
      {
        localObject8 = UrnCoercer.INSTANCE;
        localObject8 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject6));
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1098;
      }
      bool6 = true;
      bool5 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject4 = localActorMiniProfileBuilder;
        bool5 = bool6;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localActorMiniProfileBuilder = ActorMiniProfileBuilder.INSTANCE;
          localObject4 = ActorMiniProfileBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1104;
          }
          bool5 = true;
        }
        if (i == 1)
        {
          localObject4 = ActorMiniProfileBuilder.INSTANCE;
          localObject4 = ActorMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1110;
          }
          bool5 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1116;
      }
      bool7 = true;
      bool6 = bool7;
      if (bool7)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject5 = localSocialActivityCountsBuilder;
        bool6 = bool7;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localSocialActivityCountsBuilder = SocialActivityCountsBuilder.INSTANCE;
          localObject5 = SocialActivityCountsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label1122;
          }
          bool6 = true;
        }
        if (i == 1)
        {
          localObject5 = SocialActivityCountsBuilder.INSTANCE;
          localObject5 = SocialActivityCountsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label1128;
          }
          bool6 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1134;
      }
      bool11 = true;
      label960:
      bool7 = bool12;
      if (bool11) {
        if (((ByteBuffer)localObject6).get() != 1) {
          break label1140;
        }
      }
    }
    label1014:
    label1020:
    label1026:
    label1032:
    label1038:
    label1044:
    label1050:
    label1056:
    label1062:
    label1068:
    label1074:
    label1080:
    label1086:
    label1092:
    label1098:
    label1104:
    label1110:
    label1116:
    label1122:
    label1128:
    label1134:
    label1140:
    for (boolean bool7 = true;; bool7 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject6);
      }
      if (bool8) {
        break label1146;
      }
      throw new IOException("Failed to find required field: publishedAt when reading com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard from fission.");
      bool8 = false;
      break;
      bool9 = false;
      break label280;
      bool2 = false;
      break label315;
      bool1 = false;
      break label372;
      bool1 = false;
      break label398;
      bool3 = false;
      break label410;
      bool2 = false;
      break label472;
      bool2 = false;
      break label501;
      bool4 = false;
      break label513;
      bool3 = false;
      break label575;
      bool3 = false;
      break label604;
      bool5 = false;
      break label616;
      bool4 = false;
      break label678;
      bool4 = false;
      break label707;
      bool10 = false;
      break label719;
      bool6 = false;
      break label754;
      bool5 = false;
      break label816;
      bool5 = false;
      break label845;
      bool7 = false;
      break label857;
      bool6 = false;
      break label919;
      bool6 = false;
      break label948;
      bool11 = false;
      break label960;
    }
    label1146:
    if (!bool9) {
      throw new IOException("Failed to find required field: entity when reading com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: headline when reading com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: text when reading com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: actor when reading com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: totalSocialActivityCounts when reading com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard from fission.");
    }
    if (!bool11) {
      throw new IOException("Failed to find required field: read when reading com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard from fission.");
    }
    return new JobUpdateActivityCard(l, (Urn)localObject7, paramString, (AttributedText)localObject1, (AttributedText)localObject2, (AttributedText)localObject3, (Urn)localObject8, (ActorMiniProfile)localObject4, (SocialActivityCounts)localObject5, bool7, bool8, bool9, bool1, bool2, bool3, bool4, bool10, bool5, bool6, bool11);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */