package com.linkedin.crosspromo.fe.api.android;

import android.support.v4.util.ArrayMap;
import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.crosspromo.common.android.RichTextBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class SubPromoBuilder
  implements FissileDataModelBuilder<SubPromo>, DataTemplateBuilder<SubPromo>
{
  public static final SubPromoBuilder INSTANCE = new SubPromoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("tType");
    JSON_KEY_STORE.put("actionUrl");
    JSON_KEY_STORE.put("storeUrl");
    JSON_KEY_STORE.put("images");
    JSON_KEY_STORE.put("texts");
    JSON_KEY_STORE.put("metricsMap");
    JSON_KEY_STORE.put("boltons");
  }
  
  public static SubPromo build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    String str2 = null;
    String str1 = null;
    ArrayMap localArrayMap3 = null;
    ArrayMap localArrayMap2 = null;
    ArrayMap localArrayMap1 = null;
    ArrayList localArrayList = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("tType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actionUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("storeUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool5 = true;
      }
      else
      {
        Object localObject1;
        Object localObject2;
        if (paramDataReader.shouldReadField$11ca93e7("images", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayMap3 = new ArrayMap();
          if (paramDataReader.isStartOfMap()) {
            while (paramDataReader.hasMoreMapElements$255f299())
            {
              localObject1 = paramDataReader.readMapKey();
              localObject2 = ImageBuilder.INSTANCE;
              localArrayMap3.put(localObject1, ImageBuilder.build(paramDataReader));
            }
          }
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("texts", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayMap2 = new ArrayMap();
          if (paramDataReader.isStartOfMap()) {
            while (paramDataReader.hasMoreMapElements$255f299())
            {
              localObject1 = paramDataReader.readMapKey();
              localObject2 = RichTextBuilder.INSTANCE;
              localArrayMap2.put(localObject1, RichTextBuilder.build(paramDataReader));
            }
          }
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("metricsMap", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayMap1 = new ArrayMap();
          if (paramDataReader.isStartOfMap()) {
            while (paramDataReader.hasMoreMapElements$255f299())
            {
              localObject1 = paramDataReader.readMapKey();
              localObject2 = MetricsInfoBuilder.INSTANCE;
              localArrayMap1.put(localObject1, MetricsInfoBuilder.build(paramDataReader));
            }
          }
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("boltons", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayList = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject1 = BoltonBuilder.INSTANCE;
              localArrayList.add(BoltonBuilder.build(paramDataReader));
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
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: tType when building com.linkedin.crosspromo.fe.api.android.SubPromo");
    }
    return new SubPromo(str3, str2, str1, localArrayMap3, localArrayMap2, localArrayMap1, localArrayList, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static SubPromo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SubPromo");
    }
    Object localObject2 = paramByteBuffer;
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
          localObject1 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SubPromo");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SubPromo");
    }
    if (((ByteBuffer)localObject1).getInt() != 1801204899)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SubPromo");
    }
    localObject2 = null;
    String str1 = null;
    String str2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    ArrayList localArrayList = null;
    boolean bool1;
    boolean bool2;
    label257:
    boolean bool3;
    label284:
    boolean bool4;
    label311:
    Object localObject6;
    label335:
    int k;
    Object localObject7;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label457;
      }
      bool2 = true;
      if (bool2) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label463;
      }
      bool3 = true;
      if (bool3) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label469;
      }
      bool4 = true;
      if (!bool4) {
        break label487;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject6 = new ArrayMap();
      localObject3 = localObject6;
      if (j <= 0) {
        break label487;
      }
      localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        localObject7 = ImageBuilder.INSTANCE;
        paramString = ImageBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label475;
        }
        i = 1;
      }
      label400:
      if (k == 1)
      {
        paramString = ImageBuilder.INSTANCE;
        paramString = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label481;
        }
      }
    }
    label457:
    label463:
    label469:
    label475:
    label481:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((Map)localObject6).put(localObject3, paramString);
      }
      j -= 1;
      break label335;
      bool1 = false;
      break;
      bool2 = false;
      break label257;
      bool3 = false;
      break label284;
      bool4 = false;
      break label311;
      i = 0;
      break label400;
    }
    label487:
    boolean bool5;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool5 = true;
      if (!bool5) {
        break label657;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject6 = new ArrayMap();
      label523:
      localObject4 = localObject6;
      if (j <= 0) {
        break label657;
      }
      localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        localObject7 = RichTextBuilder.INSTANCE;
        paramString = RichTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label645;
        }
        i = 1;
      }
      label588:
      if (k == 1)
      {
        paramString = RichTextBuilder.INSTANCE;
        paramString = RichTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label651;
        }
      }
    }
    label645:
    label651:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((Map)localObject6).put(localObject4, paramString);
      }
      j -= 1;
      break label523;
      bool5 = false;
      break;
      i = 0;
      break label588;
    }
    label657:
    boolean bool6;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool6 = true;
      if (!bool6) {
        break label827;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject6 = new ArrayMap();
      label693:
      localObject5 = localObject6;
      if (j <= 0) {
        break label827;
      }
      localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        localObject7 = MetricsInfoBuilder.INSTANCE;
        paramString = MetricsInfoBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label815;
        }
        i = 1;
      }
      label758:
      if (k == 1)
      {
        paramString = MetricsInfoBuilder.INSTANCE;
        paramString = MetricsInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label821;
        }
      }
    }
    label815:
    label821:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((Map)localObject6).put(localObject5, paramString);
      }
      j -= 1;
      break label693;
      bool6 = false;
      break;
      i = 0;
      break label758;
    }
    label827:
    boolean bool7;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool7 = true;
      paramString = localArrayList;
      if (!bool7) {
        break label987;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label866:
      paramString = localArrayList;
      if (j <= 0) {
        break label987;
      }
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        localObject6 = BoltonBuilder.INSTANCE;
        paramString = BoltonBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label975;
        }
        i = 1;
      }
      label920:
      if (k == 1)
      {
        paramString = BoltonBuilder.INSTANCE;
        paramString = BoltonBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label981;
        }
      }
    }
    label975:
    label981:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label866;
      bool7 = false;
      break;
      i = 0;
      break label920;
    }
    label987:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: tType when reading com.linkedin.crosspromo.fe.api.android.SubPromo from fission.");
    }
    return new SubPromo((String)localObject2, str1, str2, (Map)localObject3, (Map)localObject4, (Map)localObject5, paramString, bool1, bool2, bool3, bool4, bool5, bool6, bool7);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.crosspromo.fe.api.android.SubPromoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */