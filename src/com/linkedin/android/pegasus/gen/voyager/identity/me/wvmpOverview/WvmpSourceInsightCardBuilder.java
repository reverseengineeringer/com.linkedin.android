package com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
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

public final class WvmpSourceInsightCardBuilder
  implements FissileDataModelBuilder<WvmpSourceInsightCard>, DataTemplateBuilder<WvmpSourceInsightCard>
{
  public static final WvmpSourceInsightCardBuilder INSTANCE = new WvmpSourceInsightCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("numViews");
    JSON_KEY_STORE.put("referrer");
    JSON_KEY_STORE.put("insight");
    JSON_KEY_STORE.put("cards");
    JSON_KEY_STORE.put("wvmpMetadata");
  }
  
  public static WvmpSourceInsightCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
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
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("referrer", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = AttributedTextBuilder.INSTANCE;
        localObject4 = AttributedTextBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("insight", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = InsightBuilder.INSTANCE;
        localObject3 = InsightBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("cards", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            CardBuilder localCardBuilder = CardBuilder.INSTANCE;
            ((List)localObject1).add(CardBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("wvmpMetadata", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = WvmpMetadataBuilder.INSTANCE;
        localObject2 = WvmpMetadataBuilder.build(paramDataReader);
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
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: numViews when building com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSourceInsightCard");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: referrer when building com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSourceInsightCard");
    }
    return new WvmpSourceInsightCard(l, (AttributedText)localObject4, (Insight)localObject3, (List)localObject1, (WvmpMetadata)localObject2, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static WvmpSourceInsightCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building WvmpSourceInsightCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpSourceInsightCard");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpSourceInsightCard");
    }
    if (((ByteBuffer)localObject4).getInt() != -260957727)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building WvmpSourceInsightCard");
    }
    long l = 0L;
    paramString = null;
    Object localObject6 = null;
    localObject1 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    WvmpMetadataBuilder localWvmpMetadataBuilder = null;
    boolean bool5;
    boolean bool2;
    label256:
    boolean bool1;
    label313:
    label339:
    boolean bool3;
    label351:
    label413:
    label442:
    boolean bool6;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool5 = true;
      if (bool5) {
        l = ((ByteBuffer)localObject4).getLong();
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label597;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject4).get();
        paramString = (String)localObject6;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localObject6 = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label603;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (paramString == null) {
            break label609;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label615;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject1 = localObject5;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localObject5 = InsightBuilder.INSTANCE;
          localObject1 = InsightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label621;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = InsightBuilder.INSTANCE;
          localObject1 = InsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label627;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label633;
      }
      bool6 = true;
      label454:
      if (!bool6) {
        break label651;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4);
      localObject5 = new ArrayList();
      label478:
      localObject2 = localObject5;
      if (j <= 0) {
        break label651;
      }
      localObject2 = null;
      i = 1;
      int k = ((ByteBuffer)localObject4).get();
      if (k == 0)
      {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
        localObject6 = CardBuilder.INSTANCE;
        localObject2 = CardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
        if (localObject2 == null) {
          break label639;
        }
        i = 1;
      }
      label538:
      if (k == 1)
      {
        localObject2 = CardBuilder.INSTANCE;
        localObject2 = CardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
        if (localObject2 == null) {
          break label645;
        }
      }
    }
    label597:
    label603:
    label609:
    label615:
    label621:
    label627:
    label633:
    label639:
    label645:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject5).add(localObject2);
      }
      j -= 1;
      break label478;
      bool5 = false;
      break;
      bool2 = false;
      break label256;
      bool1 = false;
      break label313;
      bool1 = false;
      break label339;
      bool3 = false;
      break label351;
      bool2 = false;
      break label413;
      bool2 = false;
      break label442;
      bool6 = false;
      break label454;
      i = 0;
      break label538;
    }
    label651:
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool3 = true;
      bool4 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject3 = localWvmpMetadataBuilder;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localWvmpMetadataBuilder = WvmpMetadataBuilder.INSTANCE;
          localObject3 = WvmpMetadataBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label797;
          }
          bool3 = true;
        }
        label721:
        bool4 = bool3;
        if (i == 1)
        {
          localObject3 = WvmpMetadataBuilder.INSTANCE;
          localObject3 = WvmpMetadataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label803;
          }
        }
      }
    }
    label797:
    label803:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (!bool6) {
        localObject2 = Collections.emptyList();
      }
      if (bool5) {
        break label809;
      }
      throw new IOException("Failed to find required field: numViews when reading com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSourceInsightCard from fission.");
      bool3 = false;
      break;
      bool3 = false;
      break label721;
    }
    label809:
    if (!bool1) {
      throw new IOException("Failed to find required field: referrer when reading com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSourceInsightCard from fission.");
    }
    return new WvmpSourceInsightCard(l, paramString, (Insight)localObject1, (List)localObject2, (WvmpMetadata)localObject3, bool5, bool1, bool2, bool6, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSourceInsightCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */