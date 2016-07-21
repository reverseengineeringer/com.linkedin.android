package com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
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

public final class WvmpJobTitleInsightCardBuilder
  implements FissileDataModelBuilder<WvmpJobTitleInsightCard>, DataTemplateBuilder<WvmpJobTitleInsightCard>
{
  public static final WvmpJobTitleInsightCardBuilder INSTANCE = new WvmpJobTitleInsightCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("numViews");
    JSON_KEY_STORE.put("viewerTitle");
    JSON_KEY_STORE.put("insight");
    JSON_KEY_STORE.put("cards");
    JSON_KEY_STORE.put("wvmpMetadata");
  }
  
  public static WvmpJobTitleInsightCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    String str = null;
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
      else if (paramDataReader.shouldReadField$11ca93e7("viewerTitle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
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
      throw new DataReaderException("Failed to find required field: numViews when building com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpJobTitleInsightCard");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: viewerTitle when building com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpJobTitleInsightCard");
    }
    return new WvmpJobTitleInsightCard(l, str, (Insight)localObject3, (List)localObject1, (WvmpMetadata)localObject2, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static WvmpJobTitleInsightCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building WvmpJobTitleInsightCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpJobTitleInsightCard");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpJobTitleInsightCard");
    }
    if (((ByteBuffer)localObject3).getInt() != 1094987066)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building WvmpJobTitleInsightCard");
    }
    long l = 0L;
    String str = null;
    paramString = null;
    Object localObject4 = null;
    localObject1 = null;
    Object localObject2 = null;
    WvmpMetadataBuilder localWvmpMetadataBuilder = null;
    boolean bool4;
    boolean bool5;
    label253:
    boolean bool2;
    label280:
    boolean bool1;
    label337:
    label363:
    boolean bool6;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        l = ((ByteBuffer)localObject3).getLong();
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label518;
      }
      bool5 = true;
      if (bool5) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label524;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = (String)localObject4;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localObject4 = InsightBuilder.INSTANCE;
          paramString = InsightBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label530;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = InsightBuilder.INSTANCE;
          paramString = InsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label536;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label542;
      }
      bool6 = true;
      label375:
      if (!bool6) {
        break label560;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localObject4 = new ArrayList();
      label399:
      localObject1 = localObject4;
      if (j <= 0) {
        break label560;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject3).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
        CardBuilder localCardBuilder = CardBuilder.INSTANCE;
        localObject1 = CardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label548;
        }
        i = 1;
      }
      label459:
      if (k == 1)
      {
        localObject1 = CardBuilder.INSTANCE;
        localObject1 = CardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label554;
        }
      }
    }
    label518:
    label524:
    label530:
    label536:
    label542:
    label548:
    label554:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject4).add(localObject1);
      }
      j -= 1;
      break label399;
      bool4 = false;
      break;
      bool5 = false;
      break label253;
      bool2 = false;
      break label280;
      bool1 = false;
      break label337;
      bool1 = false;
      break label363;
      bool6 = false;
      break label375;
      i = 0;
      break label459;
    }
    label560:
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool2 = true;
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localWvmpMetadataBuilder;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localWvmpMetadataBuilder = WvmpMetadataBuilder.INSTANCE;
          localObject2 = WvmpMetadataBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label706;
          }
          bool2 = true;
        }
        label630:
        bool3 = bool2;
        if (i == 1)
        {
          localObject2 = WvmpMetadataBuilder.INSTANCE;
          localObject2 = WvmpMetadataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label712;
          }
        }
      }
    }
    label706:
    label712:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (!bool6) {
        localObject1 = Collections.emptyList();
      }
      if (bool4) {
        break label718;
      }
      throw new IOException("Failed to find required field: numViews when reading com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpJobTitleInsightCard from fission.");
      bool2 = false;
      break;
      bool2 = false;
      break label630;
    }
    label718:
    if (!bool5) {
      throw new IOException("Failed to find required field: viewerTitle when reading com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpJobTitleInsightCard from fission.");
    }
    return new WvmpJobTitleInsightCard(l, str, paramString, (List)localObject1, (WvmpMetadata)localObject2, bool4, bool5, bool1, bool6, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpJobTitleInsightCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */