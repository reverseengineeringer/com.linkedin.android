package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.common.LinkBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class CareerResourcesBuilder
  implements FissileDataModelBuilder<CareerResources>, DataTemplateBuilder<CareerResources>
{
  public static final CareerResourcesBuilder INSTANCE = new CareerResourcesBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("links");
    JSON_KEY_STORE.put("media");
  }
  
  public static CareerResources build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    Object localObject = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("links", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            LinkBuilder localLinkBuilder = LinkBuilder.INSTANCE;
            localArrayList.add(LinkBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("media", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = CareerRichMediaBuilder.INSTANCE;
        localObject = CareerRichMediaBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new CareerResources(localArrayList, (CareerRichMedia)localObject, bool2, bool1);
  }
  
  public static CareerResources readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CareerResources");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building CareerResources");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building CareerResources");
    }
    if (((ByteBuffer)localObject1).getInt() != -192600095)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building CareerResources");
    }
    localObject2 = null;
    Object localObject3 = null;
    CareerRichMediaBuilder localCareerRichMediaBuilder = null;
    boolean bool3;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (!bool3) {
        break label364;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label242:
      localObject2 = localArrayList;
      if (j <= 0) {
        break label364;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        localObject2 = LinkBuilder.INSTANCE;
        paramString = LinkBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label352;
        }
        i = 1;
      }
      label297:
      if (k == 1)
      {
        paramString = LinkBuilder.INSTANCE;
        paramString = LinkBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label358;
        }
      }
    }
    label352:
    label358:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label242;
      bool3 = false;
      break;
      i = 0;
      break label297;
    }
    label364:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      bool2 = bool1;
      paramString = (String)localObject3;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localCareerRichMediaBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localCareerRichMediaBuilder = CareerRichMediaBuilder.INSTANCE;
          paramString = CareerRichMediaBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label495;
          }
          bool1 = true;
        }
        label432:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = CareerRichMediaBuilder.INSTANCE;
          paramString = CareerRichMediaBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label501;
          }
        }
      }
    }
    label495:
    label501:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      return new CareerResources((List)localObject2, paramString, bool3, bool2);
      bool1 = false;
      break;
      bool1 = false;
      break label432;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CareerResourcesBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */