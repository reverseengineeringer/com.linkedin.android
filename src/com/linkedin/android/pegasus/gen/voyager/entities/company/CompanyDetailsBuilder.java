package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.DateBuilder;
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

public final class CompanyDetailsBuilder
  implements FissileDataModelBuilder<CompanyDetails>, DataTemplateBuilder<CompanyDetails>
{
  public static final CompanyDetailsBuilder INSTANCE = new CompanyDetailsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("industries");
    JSON_KEY_STORE.put("websiteUrl");
    JSON_KEY_STORE.put("employeeCountRange");
    JSON_KEY_STORE.put("companyType");
    JSON_KEY_STORE.put("specialties");
    JSON_KEY_STORE.put("headquarters");
    JSON_KEY_STORE.put("foundedDate");
    JSON_KEY_STORE.put("foundedOn");
  }
  
  public static CompanyDetails build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    Object localObject1 = null;
    String str1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299())
    {
      String str5;
      if (paramDataReader.shouldReadField$11ca93e7("industries", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            str5 = paramDataReader.readString();
            if (str5 != null) {
              ((List)localObject2).add(str5);
            }
          }
        }
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("websiteUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("employeeCountRange", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("companyType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("specialties", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            str5 = paramDataReader.readString();
            if (str5 != null) {
              ((List)localObject1).add(str5);
            }
          }
        }
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("headquarters", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("foundedDate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = DateBuilder.INSTANCE;
        localObject4 = DateBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("foundedOn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = DateBuilder.INSTANCE;
        localObject3 = DateBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool8) {
      localObject2 = Collections.emptyList();
    }
    if (!bool4) {
      localObject1 = Collections.emptyList();
    }
    return new CompanyDetails((List)localObject2, str4, str3, str2, (List)localObject1, str1, (Date)localObject4, (Date)localObject3, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static CompanyDetails readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CompanyDetails");
    }
    Object localObject1 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building CompanyDetails");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building CompanyDetails");
    }
    if (((ByteBuffer)localObject4).getInt() != 350410276)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building CompanyDetails");
    }
    paramString = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    localObject1 = null;
    String str4 = null;
    Object localObject2 = null;
    DateBuilder localDateBuilder2 = null;
    Object localObject3 = null;
    DateBuilder localDateBuilder1 = null;
    if (((ByteBuffer)localObject4).get() == 1) {}
    ArrayList localArrayList;
    for (boolean bool4 = true; bool4; bool4 = false)
    {
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4);
      localArrayList = new ArrayList();
      for (;;)
      {
        paramString = localArrayList;
        if (i <= 0) {
          break;
        }
        localArrayList.add(paramFissionAdapter.readString((ByteBuffer)localObject4));
        i -= 1;
      }
    }
    boolean bool5;
    boolean bool6;
    label340:
    boolean bool7;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool5 = true;
      if (bool5) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label458;
      }
      bool6 = true;
      if (bool6) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label464;
      }
      bool7 = true;
      label367:
      if (bool7) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label470;
      }
    }
    label458:
    label464:
    label470:
    for (boolean bool8 = true;; bool8 = false)
    {
      if (!bool8) {
        break label476;
      }
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4);
      localArrayList = new ArrayList();
      for (;;)
      {
        localObject1 = localArrayList;
        if (i <= 0) {
          break;
        }
        localArrayList.add(paramFissionAdapter.readString((ByteBuffer)localObject4));
        i -= 1;
      }
      bool5 = false;
      break;
      bool6 = false;
      break label340;
      bool7 = false;
      break label367;
    }
    label476:
    boolean bool9;
    boolean bool2;
    label515:
    boolean bool1;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool9 = true;
      if (bool9) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label785;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject2 = localDateBuilder2;
        bool1 = bool2;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localDateBuilder2 = DateBuilder.INSTANCE;
          localObject2 = DateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label791;
          }
          bool1 = true;
        }
        label577:
        if (i == 1)
        {
          localObject2 = DateBuilder.INSTANCE;
          localObject2 = DateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label797;
          }
          bool1 = true;
        }
      }
      label606:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label803;
      }
      bool2 = true;
      label618:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject3 = localDateBuilder1;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localDateBuilder1 = DateBuilder.INSTANCE;
          localObject3 = DateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label809;
          }
          bool2 = true;
        }
        label676:
        bool3 = bool2;
        if (i == 1)
        {
          localObject3 = DateBuilder.INSTANCE;
          localObject3 = DateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label815;
          }
        }
      }
    }
    label785:
    label791:
    label797:
    label803:
    label809:
    label815:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (!bool4) {
        paramString = Collections.emptyList();
      }
      if (!bool8) {
        localObject1 = Collections.emptyList();
      }
      return new CompanyDetails(paramString, str1, str2, str3, (List)localObject1, str4, (Date)localObject2, (Date)localObject3, bool4, bool5, bool6, bool7, bool8, bool9, bool1, bool3);
      bool9 = false;
      break;
      bool2 = false;
      break label515;
      bool1 = false;
      break label577;
      bool1 = false;
      break label606;
      bool2 = false;
      break label618;
      bool2 = false;
      break label676;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyDetailsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */