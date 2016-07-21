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

public final class CareerAbout2Builder
  implements FissileDataModelBuilder<CareerAbout2>, DataTemplateBuilder<CareerAbout2>
{
  public static final CareerAbout2Builder INSTANCE = new CareerAbout2Builder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("links");
    JSON_KEY_STORE.put("media");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("text");
  }
  
  public static CareerAbout2 build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    Object localObject = null;
    String str2 = null;
    String str1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
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
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("media", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = CareerRichMediaBuilder.INSTANCE;
        localObject = CareerRichMediaBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new CareerAbout2(localArrayList, (CareerRichMedia)localObject, str2, str1, bool4, bool3, bool2, bool1);
  }
  
  public static CareerAbout2 readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CareerAbout2");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building CareerAbout2");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building CareerAbout2");
    }
    if (((ByteBuffer)localObject1).getInt() != -869447873)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building CareerAbout2");
    }
    localObject2 = null;
    Object localObject4 = null;
    CareerRichMediaBuilder localCareerRichMediaBuilder = null;
    Object localObject3 = null;
    String str = null;
    boolean bool3;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (!bool3) {
        break label370;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label248:
      localObject2 = localArrayList;
      if (j <= 0) {
        break label370;
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
          break label358;
        }
        i = 1;
      }
      label303:
      if (k == 1)
      {
        paramString = LinkBuilder.INSTANCE;
        paramString = LinkBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label364;
        }
      }
    }
    label358:
    label364:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label248;
      bool3 = false;
      break;
      i = 0;
      break label303;
    }
    label370:
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      paramString = (String)localObject4;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localCareerRichMediaBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localCareerRichMediaBuilder = CareerRichMediaBuilder.INSTANCE;
          paramString = CareerRichMediaBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label564;
          }
          bool1 = true;
        }
        label442:
        if (i == 1)
        {
          paramString = CareerRichMediaBuilder.INSTANCE;
          paramString = CareerRichMediaBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label570;
          }
          bool1 = true;
        }
      }
      label468:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label576;
      }
      bool2 = true;
      label480:
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label582;
      }
    }
    label564:
    label570:
    label576:
    label582:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      return new CareerAbout2((List)localObject2, paramString, paramFissionTransaction, str, bool3, bool1, bool2, bool4);
      bool2 = false;
      break;
      bool1 = false;
      break label442;
      bool1 = false;
      break label468;
      bool2 = false;
      break label480;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CareerAbout2Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */