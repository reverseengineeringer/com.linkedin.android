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
import com.linkedin.android.pegasus.gen.voyager.identity.me.ctaActions.CtaActionBuilder;
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

public final class PropCardBuilder
  implements FissileDataModelBuilder<PropCard>, DataTemplateBuilder<PropCard>
{
  public static final PropCardBuilder INSTANCE = new PropCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("propUrn");
    JSON_KEY_STORE.put("propType");
    JSON_KEY_STORE.put("actor");
    JSON_KEY_STORE.put("headline");
    JSON_KEY_STORE.put("publishedAt");
    JSON_KEY_STORE.put("read");
    JSON_KEY_STORE.put("insight");
    JSON_KEY_STORE.put("actions");
    JSON_KEY_STORE.put("socialActivityInfo");
  }
  
  public static PropCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject6 = null;
    PropType localPropType = null;
    Object localObject5 = null;
    Object localObject4 = null;
    long l = 0L;
    boolean bool10 = false;
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("propUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = UrnCoercer.INSTANCE;
        localObject6 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("propType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localPropType = (PropType)paramDataReader.readEnum(PropType.Builder.INSTANCE);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actor", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = ActorMiniProfileBuilder.INSTANCE;
        localObject5 = ActorMiniProfileBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("headline", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = AttributedTextBuilder.INSTANCE;
        localObject4 = AttributedTextBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("publishedAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("read", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool10 = paramDataReader.readBoolean();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("insight", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AttributedTextBuilder.INSTANCE;
        localObject3 = AttributedTextBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actions", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            CtaActionBuilder localCtaActionBuilder = CtaActionBuilder.INSTANCE;
            ((List)localObject1).add(CtaActionBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("socialActivityInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = SocialActivityCountsBuilder.INSTANCE;
        localObject2 = SocialActivityCountsBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: propUrn when building com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard");
    }
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: propType when building com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard");
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: actor when building com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: headline when building com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: publishedAt when building com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: read when building com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard");
    }
    return new PropCard((Urn)localObject6, localPropType, (ActorMiniProfile)localObject5, (AttributedText)localObject4, l, bool10, (AttributedText)localObject3, (List)localObject1, (SocialActivityCounts)localObject2, bool9, bool8, bool7, bool6, bool4, bool5, bool3, bool2, bool1);
  }
  
  public static PropCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PropCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PropCard");
    }
    Object localObject5 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building PropCard");
    }
    if (((ByteBuffer)localObject5).getInt() != -2130026980)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject5);
      throw new IOException("UID mismatch. Can't read cached data when building PropCard");
    }
    Object localObject6 = null;
    PropType localPropType = null;
    paramString = null;
    ActorMiniProfileBuilder localActorMiniProfileBuilder = null;
    localObject1 = null;
    Object localObject8 = null;
    long l = 0L;
    boolean bool6 = false;
    Object localObject2 = null;
    Object localObject7 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    SocialActivityCountsBuilder localSocialActivityCountsBuilder = null;
    boolean bool7;
    boolean bool8;
    label282:
    boolean bool2;
    label312:
    boolean bool1;
    label369:
    label395:
    boolean bool3;
    label407:
    label469:
    label498:
    boolean bool9;
    label510:
    boolean bool10;
    label534:
    label551:
    boolean bool4;
    label563:
    label625:
    label654:
    boolean bool11;
    if (((ByteBuffer)localObject5).get() == 1)
    {
      bool7 = true;
      if (bool7)
      {
        localObject6 = UrnCoercer.INSTANCE;
        localObject6 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject5));
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label809;
      }
      bool8 = true;
      if (bool8) {
        localPropType = PropType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject5));
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label815;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject5).get();
        paramString = localActorMiniProfileBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localActorMiniProfileBuilder = ActorMiniProfileBuilder.INSTANCE;
          paramString = ActorMiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label821;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ActorMiniProfileBuilder.INSTANCE;
          paramString = ActorMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (paramString == null) {
            break label827;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label833;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject1 = localObject8;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localObject8 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label839;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label845;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label851;
      }
      bool9 = true;
      if (bool9) {
        l = ((ByteBuffer)localObject5).getLong();
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label857;
      }
      bool10 = true;
      if (bool10)
      {
        if (((ByteBuffer)localObject5).get() != 1) {
          break label863;
        }
        bool6 = true;
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label869;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject2 = localObject7;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localObject7 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label875;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label881;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label887;
      }
      bool11 = true;
      label666:
      if (!bool11) {
        break label905;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject5);
      localObject7 = new ArrayList();
      label690:
      localObject3 = localObject7;
      if (j <= 0) {
        break label905;
      }
      localObject3 = null;
      i = 1;
      int k = ((ByteBuffer)localObject5).get();
      if (k == 0)
      {
        localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject5);
        localObject8 = CtaActionBuilder.INSTANCE;
        localObject3 = CtaActionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
        if (localObject3 == null) {
          break label893;
        }
        i = 1;
      }
      label750:
      if (k == 1)
      {
        localObject3 = CtaActionBuilder.INSTANCE;
        localObject3 = CtaActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
        if (localObject3 == null) {
          break label899;
        }
      }
    }
    label809:
    label815:
    label821:
    label827:
    label833:
    label839:
    label845:
    label851:
    label857:
    label863:
    label869:
    label875:
    label881:
    label887:
    label893:
    label899:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject7).add(localObject3);
      }
      j -= 1;
      break label690;
      bool7 = false;
      break;
      bool8 = false;
      break label282;
      bool2 = false;
      break label312;
      bool1 = false;
      break label369;
      bool1 = false;
      break label395;
      bool3 = false;
      break label407;
      bool2 = false;
      break label469;
      bool2 = false;
      break label498;
      bool9 = false;
      break label510;
      bool10 = false;
      break label534;
      bool6 = false;
      break label551;
      bool4 = false;
      break label563;
      bool3 = false;
      break label625;
      bool3 = false;
      break label654;
      bool11 = false;
      break label666;
      i = 0;
      break label750;
    }
    label905:
    if (((ByteBuffer)localObject5).get() == 1)
    {
      bool4 = true;
      bool5 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject4 = localSocialActivityCountsBuilder;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localSocialActivityCountsBuilder = SocialActivityCountsBuilder.INSTANCE;
          localObject4 = SocialActivityCountsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1051;
          }
          bool4 = true;
        }
        label975:
        bool5 = bool4;
        if (i == 1)
        {
          localObject4 = SocialActivityCountsBuilder.INSTANCE;
          localObject4 = SocialActivityCountsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1057;
          }
        }
      }
    }
    label1051:
    label1057:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject5);
      }
      if (!bool11) {
        localObject3 = Collections.emptyList();
      }
      if (bool7) {
        break label1063;
      }
      throw new IOException("Failed to find required field: propUrn when reading com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard from fission.");
      bool4 = false;
      break;
      bool4 = false;
      break label975;
    }
    label1063:
    if (!bool8) {
      throw new IOException("Failed to find required field: propType when reading com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: actor when reading com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: headline when reading com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard from fission.");
    }
    if (!bool9) {
      throw new IOException("Failed to find required field: publishedAt when reading com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard from fission.");
    }
    if (!bool10) {
      throw new IOException("Failed to find required field: read when reading com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard from fission.");
    }
    return new PropCard((Urn)localObject6, localPropType, paramString, (AttributedText)localObject1, l, bool6, (AttributedText)localObject2, (List)localObject3, (SocialActivityCounts)localObject4, bool7, bool8, bool1, bool2, bool9, bool10, bool3, bool11, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.PropCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */