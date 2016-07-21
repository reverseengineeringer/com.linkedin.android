package com.linkedin.android.pegasus.gen.voyager.premium;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class PremiumProductBuilder
  implements FissileDataModelBuilder<PremiumProduct>, DataTemplateBuilder<PremiumProduct>
{
  public static final PremiumProductBuilder INSTANCE = new PremiumProductBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("productName");
    JSON_KEY_STORE.put("productDesc");
    JSON_KEY_STORE.put("productFamily");
    JSON_KEY_STORE.put("productCode");
    JSON_KEY_STORE.put("productId");
    JSON_KEY_STORE.put("highlightedFeatures");
    JSON_KEY_STORE.put("allFeatures");
    JSON_KEY_STORE.put("actions");
    JSON_KEY_STORE.put("faqs");
    JSON_KEY_STORE.put("promotion");
  }
  
  public static PremiumProduct build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str5 = null;
    String str4 = null;
    String str3 = null;
    PremiumProductFamily localPremiumProductFamily = null;
    String str2 = null;
    String str1 = null;
    ArrayList localArrayList4 = null;
    ArrayList localArrayList3 = null;
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = null;
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
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("header", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("productName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("productDesc", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("productFamily", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localPremiumProductFamily = (PremiumProductFamily)paramDataReader.readEnum(PremiumProductFamily.Builder.INSTANCE);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("productCode", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("productId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool6 = true;
      }
      else
      {
        Object localObject2;
        if (paramDataReader.shouldReadField$11ca93e7("highlightedFeatures", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayList4 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject2 = PremiumFeatureBuilder.INSTANCE;
              localArrayList4.add(PremiumFeatureBuilder.build(paramDataReader));
            }
          }
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("allFeatures", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayList3 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject2 = PremiumFeatureBuilder.INSTANCE;
              localArrayList3.add(PremiumFeatureBuilder.build(paramDataReader));
            }
          }
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("actions", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayList2 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject2 = PremiumActionBuilder.INSTANCE;
              localArrayList2.add(PremiumActionBuilder.build(paramDataReader));
            }
          }
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("faqs", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayList1 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject2 = PremiumFAQBuilder.INSTANCE;
              localArrayList1.add(PremiumFAQBuilder.build(paramDataReader));
            }
          }
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("promotion", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = PremiumPromotionBuilder.INSTANCE;
          localObject1 = PremiumPromotionBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
    }
    if (!bool11) {
      throw new DataReaderException("Failed to find required field: header when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct");
    }
    if (!bool10) {
      throw new DataReaderException("Failed to find required field: productName when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct");
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: productDesc when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct");
    }
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: productFamily when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct");
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: productCode when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: productId when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: highlightedFeatures when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: allFeatures when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: actions when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: faqs when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct");
    }
    return new PremiumProduct(str5, str4, str3, localPremiumProductFamily, str2, str1, localArrayList4, localArrayList3, localArrayList2, localArrayList1, (PremiumPromotion)localObject1, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static PremiumProduct readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PremiumProduct");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PremiumProduct");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building PremiumProduct");
    }
    if (((ByteBuffer)localObject1).getInt() != 1644383868)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building PremiumProduct");
    }
    localObject2 = null;
    String str1 = null;
    String str2 = null;
    PremiumProductFamily localPremiumProductFamily = null;
    String str3 = null;
    String str4 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    PremiumPromotionBuilder localPremiumPromotionBuilder = null;
    boolean bool3;
    boolean bool4;
    label272:
    boolean bool5;
    label299:
    boolean bool6;
    label326:
    boolean bool7;
    label356:
    boolean bool8;
    label383:
    boolean bool9;
    label410:
    ArrayList localArrayList;
    label434:
    int k;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label544;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label550;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label556;
      }
      bool6 = true;
      if (bool6) {
        localPremiumProductFamily = PremiumProductFamily.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label562;
      }
      bool7 = true;
      if (bool7) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label568;
      }
      bool8 = true;
      if (bool8) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label574;
      }
      bool9 = true;
      if (!bool9) {
        break label592;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      localObject3 = localArrayList;
      if (j <= 0) {
        break label592;
      }
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        localObject3 = PremiumFeatureBuilder.INSTANCE;
        paramString = PremiumFeatureBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label580;
        }
        i = 1;
      }
      label489:
      if (k == 1)
      {
        paramString = PremiumFeatureBuilder.INSTANCE;
        paramString = PremiumFeatureBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label586;
        }
      }
    }
    label544:
    label550:
    label556:
    label562:
    label568:
    label574:
    label580:
    label586:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label434;
      bool3 = false;
      break;
      bool4 = false;
      break label272;
      bool5 = false;
      break label299;
      bool6 = false;
      break label326;
      bool7 = false;
      break label356;
      bool8 = false;
      break label383;
      bool9 = false;
      break label410;
      i = 0;
      break label489;
    }
    label592:
    boolean bool10;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool10 = true;
      if (!bool10) {
        break label750;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label628:
      localObject4 = localArrayList;
      if (j <= 0) {
        break label750;
      }
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        localObject4 = PremiumFeatureBuilder.INSTANCE;
        paramString = PremiumFeatureBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label738;
        }
        i = 1;
      }
      label683:
      if (k == 1)
      {
        paramString = PremiumFeatureBuilder.INSTANCE;
        paramString = PremiumFeatureBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label744;
        }
      }
    }
    label738:
    label744:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label628;
      bool10 = false;
      break;
      i = 0;
      break label683;
    }
    label750:
    boolean bool11;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool11 = true;
      if (!bool11) {
        break label908;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label786:
      localObject5 = localArrayList;
      if (j <= 0) {
        break label908;
      }
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        localObject5 = PremiumActionBuilder.INSTANCE;
        paramString = PremiumActionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label896;
        }
        i = 1;
      }
      label841:
      if (k == 1)
      {
        paramString = PremiumActionBuilder.INSTANCE;
        paramString = PremiumActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label902;
        }
      }
    }
    label896:
    label902:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label786;
      bool11 = false;
      break;
      i = 0;
      break label841;
    }
    label908:
    boolean bool12;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool12 = true;
      if (!bool12) {
        break label1066;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label944:
      localObject6 = localArrayList;
      if (j <= 0) {
        break label1066;
      }
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        localObject6 = PremiumFAQBuilder.INSTANCE;
        paramString = PremiumFAQBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label1054;
        }
        i = 1;
      }
      label999:
      if (k == 1)
      {
        paramString = PremiumFAQBuilder.INSTANCE;
        paramString = PremiumFAQBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label1060;
        }
      }
    }
    label1054:
    label1060:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label944;
      bool12 = false;
      break;
      i = 0;
      break label999;
    }
    label1066:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      paramString = (String)localObject7;
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localPremiumPromotionBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localPremiumPromotionBuilder = PremiumPromotionBuilder.INSTANCE;
          paramString = PremiumPromotionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label1197;
          }
          bool1 = true;
        }
        label1134:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = PremiumPromotionBuilder.INSTANCE;
          paramString = PremiumPromotionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label1203;
          }
        }
      }
    }
    label1197:
    label1203:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label1209;
      }
      throw new IOException("Failed to find required field: header when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct from fission.");
      bool1 = false;
      break;
      bool1 = false;
      break label1134;
    }
    label1209:
    if (!bool4) {
      throw new IOException("Failed to find required field: productName when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: productDesc when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: productFamily when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: productCode when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct from fission.");
    }
    if (!bool8) {
      throw new IOException("Failed to find required field: productId when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct from fission.");
    }
    if (!bool9) {
      throw new IOException("Failed to find required field: highlightedFeatures when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct from fission.");
    }
    if (!bool10) {
      throw new IOException("Failed to find required field: allFeatures when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct from fission.");
    }
    if (!bool11) {
      throw new IOException("Failed to find required field: actions when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct from fission.");
    }
    if (!bool12) {
      throw new IOException("Failed to find required field: faqs when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct from fission.");
    }
    return new PremiumProduct((String)localObject2, str1, str2, localPremiumProductFamily, str3, str4, (List)localObject3, (List)localObject4, (List)localObject5, (List)localObject6, paramString, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PremiumProductBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */