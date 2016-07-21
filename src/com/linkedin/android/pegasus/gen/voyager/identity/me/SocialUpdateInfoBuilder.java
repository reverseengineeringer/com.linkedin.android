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
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCountsBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SocialUpdateInfoBuilder
  implements FissileDataModelBuilder<SocialUpdateInfo>, DataTemplateBuilder<SocialUpdateInfo>
{
  public static final SocialUpdateInfoBuilder INSTANCE = new SocialUpdateInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("type");
    JSON_KEY_STORE.put("image");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("text");
    JSON_KEY_STORE.put("totalSocialActivityCounts");
    JSON_KEY_STORE.put("entity");
  }
  
  public static SocialUpdateInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    SocialUpdateType localSocialUpdateType = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSocialUpdateType = (SocialUpdateType)paramDataReader.readEnum(SocialUpdateType.Builder.INSTANCE);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("image", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = ImageBuilder.INSTANCE;
        localObject5 = ImageBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = AttributedTextBuilder.INSTANCE;
        localObject4 = AttributedTextBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AttributedTextBuilder.INSTANCE;
        localObject3 = AttributedTextBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("totalSocialActivityCounts", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = SocialActivityCountsBuilder.INSTANCE;
        localObject2 = SocialActivityCountsBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entity", JSON_KEY_STORE))
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
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: type when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateInfo");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: entity when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateInfo");
    }
    return new SocialUpdateInfo(localSocialUpdateType, (Image)localObject5, (AttributedText)localObject4, (AttributedText)localObject3, (SocialActivityCounts)localObject2, (Urn)localObject1, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static SocialUpdateInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SocialUpdateInfo");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialUpdateInfo");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialUpdateInfo");
    }
    if (((ByteBuffer)localObject4).getInt() != -124834702)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building SocialUpdateInfo");
    }
    SocialUpdateType localSocialUpdateType = null;
    paramString = null;
    ImageBuilder localImageBuilder = null;
    localObject1 = null;
    AttributedTextBuilder localAttributedTextBuilder2 = null;
    Object localObject2 = null;
    AttributedTextBuilder localAttributedTextBuilder1 = null;
    Object localObject3 = null;
    SocialActivityCountsBuilder localSocialActivityCountsBuilder = null;
    Object localObject5 = null;
    boolean bool6;
    boolean bool2;
    label268:
    boolean bool1;
    label325:
    label351:
    boolean bool3;
    label363:
    label425:
    label454:
    boolean bool4;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool6 = true;
      if (bool6) {
        localSocialUpdateType = SocialUpdateType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4));
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label729;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject4).get();
        paramString = localImageBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localImageBuilder = ImageBuilder.INSTANCE;
          paramString = ImageBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label735;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ImageBuilder.INSTANCE;
          paramString = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (paramString == null) {
            break label741;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label747;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject1 = localAttributedTextBuilder2;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localAttributedTextBuilder2 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label753;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label759;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label765;
      }
      bool4 = true;
      label466:
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject2 = localAttributedTextBuilder1;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localAttributedTextBuilder1 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label771;
          }
          bool3 = true;
        }
        label528:
        if (i == 1)
        {
          localObject2 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label777;
          }
          bool3 = true;
        }
      }
      label557:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label783;
      }
      bool5 = true;
      label569:
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject3 = localSocialActivityCountsBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localSocialActivityCountsBuilder = SocialActivityCountsBuilder.INSTANCE;
          localObject3 = SocialActivityCountsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label789;
          }
          bool4 = true;
        }
        label631:
        if (i == 1)
        {
          localObject3 = SocialActivityCountsBuilder.INSTANCE;
          localObject3 = SocialActivityCountsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label795;
          }
          bool4 = true;
        }
      }
      label660:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label801;
      }
    }
    label729:
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
    for (boolean bool5 = true;; bool5 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject5;
      if (bool5)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject4));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (bool6) {
        break label807;
      }
      throw new IOException("Failed to find required field: type when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateInfo from fission.");
      bool6 = false;
      break;
      bool2 = false;
      break label268;
      bool1 = false;
      break label325;
      bool1 = false;
      break label351;
      bool3 = false;
      break label363;
      bool2 = false;
      break label425;
      bool2 = false;
      break label454;
      bool4 = false;
      break label466;
      bool3 = false;
      break label528;
      bool3 = false;
      break label557;
      bool5 = false;
      break label569;
      bool4 = false;
      break label631;
      bool4 = false;
      break label660;
    }
    label807:
    if (!bool5) {
      throw new IOException("Failed to find required field: entity when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateInfo from fission.");
    }
    return new SocialUpdateInfo(localSocialUpdateType, paramString, (AttributedText)localObject1, (AttributedText)localObject2, (SocialActivityCounts)localObject3, paramFissionTransaction, bool6, bool1, bool2, bool3, bool4, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */