package com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.identity.me.CardBuilder;
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

public final class WvmpSummaryInsightCardBuilder
  implements FissileDataModelBuilder<WvmpSummaryInsightCard>, DataTemplateBuilder<WvmpSummaryInsightCard>
{
  public static final WvmpSummaryInsightCardBuilder INSTANCE = new WvmpSummaryInsightCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("numViews");
    JSON_KEY_STORE.put("numViewsChangeInPercentage");
    JSON_KEY_STORE.put("cards");
    JSON_KEY_STORE.put("timeFrame");
    JSON_KEY_STORE.put("wvmpMetadata");
  }
  
  public static WvmpSummaryInsightCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    int i = 0;
    Object localObject1 = null;
    TimeFrame localTimeFrame = null;
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
      else if (paramDataReader.shouldReadField$11ca93e7("numViewsChangeInPercentage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool4 = true;
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
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("timeFrame", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localTimeFrame = (TimeFrame)paramDataReader.readEnum(TimeFrame.Builder.INSTANCE);
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
    if (!bool3) {
      localObject1 = Collections.emptyList();
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: numViews when building com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSummaryInsightCard");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: timeFrame when building com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSummaryInsightCard");
    }
    return new WvmpSummaryInsightCard(l, i, (List)localObject1, localTimeFrame, (WvmpMetadata)localObject2, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static WvmpSummaryInsightCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building WvmpSummaryInsightCard");
    }
    Object localObject1 = paramByteBuffer;
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
          localObject2 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpSummaryInsightCard");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpSummaryInsightCard");
    }
    if (((ByteBuffer)localObject2).getInt() != 2033088297)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building WvmpSummaryInsightCard");
    }
    long l = 0L;
    int j = 0;
    paramString = null;
    TimeFrame localTimeFrame = null;
    localObject1 = null;
    WvmpMetadataBuilder localWvmpMetadataBuilder = null;
    boolean bool3;
    boolean bool4;
    label250:
    boolean bool5;
    label274:
    int k;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        l = ((ByteBuffer)localObject2).getLong();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label407;
      }
      bool4 = true;
      if (bool4) {
        j = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label413;
      }
      bool5 = true;
      if (!bool5) {
        break label431;
      }
      k = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localArrayList = new ArrayList();
      label298:
      paramString = localArrayList;
      if (k <= 0) {
        break label431;
      }
      paramString = null;
      i = 1;
      int m = ((ByteBuffer)localObject2).get();
      if (m == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
        CardBuilder localCardBuilder = CardBuilder.INSTANCE;
        paramString = CardBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label419;
        }
        i = 1;
      }
      label352:
      if (m == 1)
      {
        paramString = CardBuilder.INSTANCE;
        paramString = CardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (paramString == null) {
          break label425;
        }
      }
    }
    label407:
    label413:
    label419:
    label425:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      k -= 1;
      break label298;
      bool3 = false;
      break;
      bool4 = false;
      break label250;
      bool5 = false;
      break label274;
      i = 0;
      break label352;
    }
    label431:
    boolean bool6;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool6 = true;
      if (bool6) {
        localTimeFrame = TimeFrame.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label606;
      }
      bool1 = true;
      label473:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localWvmpMetadataBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localWvmpMetadataBuilder = WvmpMetadataBuilder.INSTANCE;
          localObject1 = WvmpMetadataBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label612;
          }
          bool1 = true;
        }
        label531:
        bool2 = bool1;
        if (i == 1)
        {
          localObject1 = WvmpMetadataBuilder.INSTANCE;
          localObject1 = WvmpMetadataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label618;
          }
        }
      }
    }
    label606:
    label612:
    label618:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (!bool5) {
        paramString = Collections.emptyList();
      }
      if (bool3) {
        break label624;
      }
      throw new IOException("Failed to find required field: numViews when reading com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSummaryInsightCard from fission.");
      bool6 = false;
      break;
      bool1 = false;
      break label473;
      bool1 = false;
      break label531;
    }
    label624:
    if (!bool6) {
      throw new IOException("Failed to find required field: timeFrame when reading com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSummaryInsightCard from fission.");
    }
    return new WvmpSummaryInsightCard(l, j, paramString, localTimeFrame, (WvmpMetadata)localObject1, bool3, bool4, bool5, bool6, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSummaryInsightCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */