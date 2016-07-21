package com.linkedin.android.pegasus.gen.voyager.entities.company;

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

public final class CareerAboutBuilder
  implements FissileDataModelBuilder<CareerAbout>, DataTemplateBuilder<CareerAbout>
{
  public static final CareerAboutBuilder INSTANCE = new CareerAboutBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("title");
    JSON_KEY_STORE.put("text");
    JSON_KEY_STORE.put("image");
    JSON_KEY_STORE.put("careersTitle");
    JSON_KEY_STORE.put("careersSubtitle");
  }
  
  public static CareerAbout build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str4 = null;
    String str3 = null;
    Object localObject = null;
    String str2 = null;
    String str1 = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("image", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = CareerImageBuilder.INSTANCE;
        localObject = CareerImageBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("careersTitle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("careersSubtitle", JSON_KEY_STORE))
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
    return new CareerAbout(str4, str3, (CareerImage)localObject, str2, str1, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static CareerAbout readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CareerAbout");
    }
    Object localObject2 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building CareerAbout");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building CareerAbout");
    }
    if (((ByteBuffer)localObject1).getInt() != 554198736)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building CareerAbout");
    }
    localObject2 = null;
    String str1 = null;
    paramString = null;
    CareerImageBuilder localCareerImageBuilder = null;
    Object localObject3 = null;
    String str2 = null;
    boolean bool3;
    boolean bool4;
    label253:
    boolean bool2;
    label280:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label463;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label469;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localCareerImageBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localCareerImageBuilder = CareerImageBuilder.INSTANCE;
          paramString = CareerImageBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label475;
          }
          bool1 = true;
        }
        label337:
        if (i == 1)
        {
          paramString = CareerImageBuilder.INSTANCE;
          paramString = CareerImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label481;
          }
          bool1 = true;
        }
      }
      label363:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label487;
      }
      bool2 = true;
      label375:
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label493;
      }
    }
    label463:
    label469:
    label475:
    label481:
    label487:
    label493:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      return new CareerAbout((String)localObject2, str1, paramString, paramFissionTransaction, str2, bool3, bool4, bool1, bool2, bool5);
      bool3 = false;
      break;
      bool4 = false;
      break label253;
      bool2 = false;
      break label280;
      bool1 = false;
      break label337;
      bool1 = false;
      break label363;
      bool2 = false;
      break label375;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CareerAboutBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */