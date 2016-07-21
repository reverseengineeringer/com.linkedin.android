package com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavorBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompanyBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.CardBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Insight;
import com.linkedin.android.pegasus.gen.voyager.identity.me.InsightBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpMetadataBuilder;
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

public final class WvmpCompanyInsightCardBuilder
  implements FissileDataModelBuilder<WvmpCompanyInsightCard>, DataTemplateBuilder<WvmpCompanyInsightCard>
{
  public static final WvmpCompanyInsightCardBuilder INSTANCE = new WvmpCompanyInsightCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("numViews");
    JSON_KEY_STORE.put("insight");
    JSON_KEY_STORE.put("miniCompany");
    JSON_KEY_STORE.put("cards");
    JSON_KEY_STORE.put("wvmpMetadata");
    JSON_KEY_STORE.put("flavors");
  }
  
  public static WvmpCompanyInsightCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("numViews", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("insight", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = InsightBuilder.INSTANCE;
        localObject5 = InsightBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("miniCompany", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = MiniCompanyBuilder.INSTANCE;
        localObject4 = MiniCompanyBuilder.build(paramDataReader);
        bool4 = true;
      }
      else
      {
        Object localObject6;
        if (paramDataReader.shouldReadField$11ca93e7("cards", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject6 = CardBuilder.INSTANCE;
              ((List)localObject2).add(CardBuilder.build(paramDataReader));
            }
          }
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("wvmpMetadata", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = WvmpMetadataBuilder.INSTANCE;
          localObject3 = WvmpMetadataBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("flavors", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject6 = EntitiesFlavorBuilder.INSTANCE;
              ((List)localObject1).add(EntitiesFlavorBuilder.build(paramDataReader));
            }
          }
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
    }
    if (!bool3) {
      localObject2 = Collections.emptyList();
    }
    if (!bool1) {
      localObject1 = Collections.emptyList();
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: numViews when building com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCompanyInsightCard");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: miniCompany when building com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCompanyInsightCard");
    }
    return new WvmpCompanyInsightCard(l, (Insight)localObject5, (MiniCompany)localObject4, (List)localObject2, (WvmpMetadata)localObject3, (List)localObject1, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static WvmpCompanyInsightCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building WvmpCompanyInsightCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpCompanyInsightCard");
    }
    Object localObject5 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpCompanyInsightCard");
    }
    if (((ByteBuffer)localObject5).getInt() != 624413709)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject5);
      throw new IOException("UID mismatch. Can't read cached data when building WvmpCompanyInsightCard");
    }
    long l = 0L;
    paramString = null;
    Object localObject8 = null;
    localObject1 = null;
    Object localObject7 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    boolean bool5;
    boolean bool2;
    label259:
    boolean bool1;
    label316:
    label342:
    boolean bool3;
    label354:
    label416:
    label445:
    boolean bool6;
    label457:
    label481:
    int k;
    if (((ByteBuffer)localObject5).get() == 1)
    {
      bool5 = true;
      if (bool5) {
        l = ((ByteBuffer)localObject5).getLong();
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label600;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject5).get();
        paramString = (String)localObject8;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localObject8 = InsightBuilder.INSTANCE;
          paramString = InsightBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label606;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = InsightBuilder.INSTANCE;
          paramString = InsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (paramString == null) {
            break label612;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label618;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject1 = localObject7;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localObject7 = MiniCompanyBuilder.INSTANCE;
          localObject1 = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label624;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = MiniCompanyBuilder.INSTANCE;
          localObject1 = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label630;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label636;
      }
      bool6 = true;
      if (!bool6) {
        break label654;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject5);
      localObject7 = new ArrayList();
      localObject2 = localObject7;
      if (j <= 0) {
        break label654;
      }
      localObject2 = null;
      i = 1;
      k = ((ByteBuffer)localObject5).get();
      if (k == 0)
      {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject5);
        localObject8 = CardBuilder.INSTANCE;
        localObject2 = CardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
        if (localObject2 == null) {
          break label642;
        }
        i = 1;
      }
      label541:
      if (k == 1)
      {
        localObject2 = CardBuilder.INSTANCE;
        localObject2 = CardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
        if (localObject2 == null) {
          break label648;
        }
      }
    }
    label600:
    label606:
    label612:
    label618:
    label624:
    label630:
    label636:
    label642:
    label648:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject7).add(localObject2);
      }
      j -= 1;
      break label481;
      bool5 = false;
      break;
      bool2 = false;
      break label259;
      bool1 = false;
      break label316;
      bool1 = false;
      break label342;
      bool3 = false;
      break label354;
      bool2 = false;
      break label416;
      bool2 = false;
      break label445;
      bool6 = false;
      break label457;
      i = 0;
      break label541;
    }
    label654:
    boolean bool4;
    if (((ByteBuffer)localObject5).get() == 1)
    {
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject3 = localObject6;
        bool3 = bool4;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localObject6 = WvmpMetadataBuilder.INSTANCE;
          localObject3 = WvmpMetadataBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label912;
          }
          bool3 = true;
        }
        label728:
        if (i == 1)
        {
          localObject3 = WvmpMetadataBuilder.INSTANCE;
          localObject3 = WvmpMetadataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label918;
          }
          bool3 = true;
        }
      }
      label757:
      if (((ByteBuffer)localObject5).get() != 1) {
        break label924;
      }
      bool4 = true;
      label769:
      if (!bool4) {
        break label942;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject5);
      localObject6 = new ArrayList();
      label793:
      localObject4 = localObject6;
      if (j <= 0) {
        break label942;
      }
      localObject4 = null;
      i = 1;
      k = ((ByteBuffer)localObject5).get();
      if (k == 0)
      {
        localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject5);
        localObject7 = EntitiesFlavorBuilder.INSTANCE;
        localObject4 = EntitiesFlavorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
        if (localObject4 == null) {
          break label930;
        }
        i = 1;
      }
      label853:
      if (k == 1)
      {
        localObject4 = EntitiesFlavorBuilder.INSTANCE;
        localObject4 = EntitiesFlavorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
        if (localObject4 == null) {
          break label936;
        }
      }
    }
    label912:
    label918:
    label924:
    label930:
    label936:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject6).add(localObject4);
      }
      j -= 1;
      break label793;
      bool4 = false;
      break;
      bool3 = false;
      break label728;
      bool3 = false;
      break label757;
      bool4 = false;
      break label769;
      i = 0;
      break label853;
    }
    label942:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject5);
    }
    if (!bool6) {
      localObject2 = Collections.emptyList();
    }
    if (!bool4) {
      localObject4 = Collections.emptyList();
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: numViews when reading com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCompanyInsightCard from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: miniCompany when reading com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCompanyInsightCard from fission.");
    }
    return new WvmpCompanyInsightCard(l, paramString, (MiniCompany)localObject1, (List)localObject2, (WvmpMetadata)localObject3, (List)localObject4, bool5, bool1, bool2, bool6, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCompanyInsightCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */