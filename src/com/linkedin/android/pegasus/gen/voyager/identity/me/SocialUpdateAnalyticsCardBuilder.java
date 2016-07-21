package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SocialUpdateAnalyticsCardBuilder
  implements FissileDataModelBuilder<SocialUpdateAnalyticsCard>, DataTemplateBuilder<SocialUpdateAnalyticsCard>
{
  public static final SocialUpdateAnalyticsCardBuilder INSTANCE = new SocialUpdateAnalyticsCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("publishedAt");
    JSON_KEY_STORE.put("read");
    JSON_KEY_STORE.put("headline");
    JSON_KEY_STORE.put("socialUpdateInfo");
    JSON_KEY_STORE.put("insight");
    JSON_KEY_STORE.put("objectUrn");
  }
  
  public static SocialUpdateAnalyticsCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    boolean bool7 = false;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("publishedAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("read", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool7 = paramDataReader.readBoolean();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("headline", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = AttributedTextBuilder.INSTANCE;
        localObject4 = AttributedTextBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("socialUpdateInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = SocialUpdateInfoBuilder.INSTANCE;
        localObject3 = SocialUpdateInfoBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("insight", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = InsightBuilder.INSTANCE;
        localObject2 = InsightBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("objectUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UrnCoercer.INSTANCE;
        localObject1 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: publishedAt when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: read when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: headline when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: socialUpdateInfo when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: objectUrn when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard");
    }
    return new SocialUpdateAnalyticsCard(l, bool7, (AttributedText)localObject4, (SocialUpdateInfo)localObject3, (Insight)localObject2, (Urn)localObject1, bool5, bool6, bool4, bool3, bool2, bool1);
  }
  
  public static SocialUpdateAnalyticsCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SocialUpdateAnalyticsCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialUpdateAnalyticsCard");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialUpdateAnalyticsCard");
    }
    if (((ByteBuffer)localObject3).getInt() != 2134859204)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building SocialUpdateAnalyticsCard");
    }
    long l = 0L;
    boolean bool5 = false;
    paramString = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    localObject1 = null;
    SocialUpdateInfoBuilder localSocialUpdateInfoBuilder = null;
    Object localObject2 = null;
    InsightBuilder localInsightBuilder = null;
    Object localObject4 = null;
    boolean bool6;
    boolean bool7;
    label259:
    label276:
    boolean bool2;
    label288:
    boolean bool1;
    label345:
    label371:
    boolean bool3;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool6 = true;
      if (bool6) {
        l = ((ByteBuffer)localObject3).getLong();
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label646;
      }
      bool7 = true;
      if (bool7)
      {
        if (((ByteBuffer)localObject3).get() != 1) {
          break label652;
        }
        bool5 = true;
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label658;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = localAttributedTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label664;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label670;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label676;
      }
      bool3 = true;
      label383:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localSocialUpdateInfoBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localSocialUpdateInfoBuilder = SocialUpdateInfoBuilder.INSTANCE;
          localObject1 = SocialUpdateInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label682;
          }
          bool2 = true;
        }
        label445:
        if (i == 1)
        {
          localObject1 = SocialUpdateInfoBuilder.INSTANCE;
          localObject1 = SocialUpdateInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label688;
          }
          bool2 = true;
        }
      }
      label474:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label694;
      }
      bool4 = true;
      label486:
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localInsightBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localInsightBuilder = InsightBuilder.INSTANCE;
          localObject2 = InsightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label700;
          }
          bool3 = true;
        }
        label548:
        if (i == 1)
        {
          localObject2 = InsightBuilder.INSTANCE;
          localObject2 = InsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label706;
          }
          bool3 = true;
        }
      }
      label577:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label712;
      }
    }
    label646:
    label652:
    label658:
    label664:
    label670:
    label676:
    label682:
    label688:
    label694:
    label700:
    label706:
    label712:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject4;
      if (bool4)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (bool6) {
        break label718;
      }
      throw new IOException("Failed to find required field: publishedAt when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard from fission.");
      bool6 = false;
      break;
      bool7 = false;
      break label259;
      bool5 = false;
      break label276;
      bool2 = false;
      break label288;
      bool1 = false;
      break label345;
      bool1 = false;
      break label371;
      bool3 = false;
      break label383;
      bool2 = false;
      break label445;
      bool2 = false;
      break label474;
      bool4 = false;
      break label486;
      bool3 = false;
      break label548;
      bool3 = false;
      break label577;
    }
    label718:
    if (!bool7) {
      throw new IOException("Failed to find required field: read when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: headline when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: socialUpdateInfo when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: objectUrn when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard from fission.");
    }
    return new SocialUpdateAnalyticsCard(l, bool5, paramString, (SocialUpdateInfo)localObject1, (Insight)localObject2, paramFissionTransaction, bool6, bool7, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */