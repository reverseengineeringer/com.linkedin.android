package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.DateBuilder;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class PatentBuilder
  implements FissileDataModelBuilder<Patent>, DataTemplateBuilder<Patent>
{
  public static final PatentBuilder INSTANCE = new PatentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("number");
    JSON_KEY_STORE.put("applicationNumber");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("issuer");
    JSON_KEY_STORE.put("url");
    JSON_KEY_STORE.put("pending");
    JSON_KEY_STORE.put("filingDate");
    JSON_KEY_STORE.put("issueDate");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("localizedIssuerCountryName");
    JSON_KEY_STORE.put("inventors");
  }
  
  public static Patent build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    boolean bool13 = false;
    Object localObject2 = null;
    Object localObject1 = null;
    String str2 = null;
    String str1 = null;
    ArrayList localArrayList = null;
    boolean bool12 = false;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("number", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str7 = paramDataReader.readString();
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("applicationNumber", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str6 = paramDataReader.readString();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("issuer", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("pending", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool13 = paramDataReader.readBoolean();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("filingDate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = DateBuilder.INSTANCE;
        localObject2 = DateBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("issueDate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = DateBuilder.INSTANCE;
        localObject1 = DateBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("localizedIssuerCountryName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("inventors", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            ContributorBuilder localContributorBuilder = ContributorBuilder.INSTANCE;
            localArrayList.add(ContributorBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: title when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent");
    }
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: issuer when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent");
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: pending when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: inventors when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent");
    }
    return new Patent((Urn)localObject3, str7, str6, str5, str4, str3, bool13, (Date)localObject2, (Date)localObject1, str2, str1, localArrayList, bool12, bool11, bool10, bool9, bool8, bool6, bool7, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Patent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Patent");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Patent");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Patent");
    }
    if (((ByteBuffer)localObject3).getInt() != -56719798)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building Patent");
    }
    Object localObject4 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    boolean bool4 = false;
    paramString = null;
    Object localObject6 = null;
    localObject1 = null;
    Object localObject5 = null;
    String str6 = null;
    String str7 = null;
    Object localObject2 = null;
    boolean bool5;
    boolean bool6;
    label285:
    boolean bool7;
    label312:
    boolean bool8;
    label339:
    boolean bool9;
    label366:
    boolean bool10;
    label393:
    boolean bool11;
    label420:
    label437:
    boolean bool2;
    label449:
    boolean bool1;
    label506:
    label532:
    boolean bool3;
    label544:
    label606:
    label635:
    label647:
    boolean bool12;
    label674:
    boolean bool13;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool5 = true;
      if (bool5)
      {
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label844;
      }
      bool6 = true;
      if (bool6) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label850;
      }
      bool7 = true;
      if (bool7) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label856;
      }
      bool8 = true;
      if (bool8) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label862;
      }
      bool9 = true;
      if (bool9) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label868;
      }
      bool10 = true;
      if (bool10) {
        str5 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label874;
      }
      bool11 = true;
      if (bool11)
      {
        if (((ByteBuffer)localObject3).get() != 1) {
          break label880;
        }
        bool4 = true;
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label886;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = (String)localObject6;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localObject6 = DateBuilder.INSTANCE;
          paramString = DateBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label892;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = DateBuilder.INSTANCE;
          paramString = DateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label898;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label904;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localObject5;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localObject5 = DateBuilder.INSTANCE;
          localObject1 = DateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label910;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = DateBuilder.INSTANCE;
          localObject1 = DateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label916;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label922;
      }
      bool3 = true;
      if (bool3) {
        str6 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label928;
      }
      bool12 = true;
      if (bool12) {
        str7 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label934;
      }
      bool13 = true;
      label701:
      if (!bool13) {
        break label952;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localObject5 = new ArrayList();
      label725:
      localObject2 = localObject5;
      if (j <= 0) {
        break label952;
      }
      localObject2 = null;
      i = 1;
      int k = ((ByteBuffer)localObject3).get();
      if (k == 0)
      {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
        localObject6 = ContributorBuilder.INSTANCE;
        localObject2 = ContributorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
        if (localObject2 == null) {
          break label940;
        }
        i = 1;
      }
      label785:
      if (k == 1)
      {
        localObject2 = ContributorBuilder.INSTANCE;
        localObject2 = ContributorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (localObject2 == null) {
          break label946;
        }
      }
    }
    label844:
    label850:
    label856:
    label862:
    label868:
    label874:
    label880:
    label886:
    label892:
    label898:
    label904:
    label910:
    label916:
    label922:
    label928:
    label934:
    label940:
    label946:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject5).add(localObject2);
      }
      j -= 1;
      break label725;
      bool5 = false;
      break;
      bool6 = false;
      break label285;
      bool7 = false;
      break label312;
      bool8 = false;
      break label339;
      bool9 = false;
      break label366;
      bool10 = false;
      break label393;
      bool11 = false;
      break label420;
      bool4 = false;
      break label437;
      bool2 = false;
      break label449;
      bool1 = false;
      break label506;
      bool1 = false;
      break label532;
      bool3 = false;
      break label544;
      bool2 = false;
      break label606;
      bool2 = false;
      break label635;
      bool3 = false;
      break label647;
      bool12 = false;
      break label674;
      bool13 = false;
      break label701;
      i = 0;
      break label785;
    }
    label952:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
    }
    if (!bool8) {
      throw new IOException("Failed to find required field: title when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent from fission.");
    }
    if (!bool9) {
      throw new IOException("Failed to find required field: issuer when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent from fission.");
    }
    if (!bool11) {
      throw new IOException("Failed to find required field: pending when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent from fission.");
    }
    if (!bool13) {
      throw new IOException("Failed to find required field: inventors when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent from fission.");
    }
    return new Patent((Urn)localObject4, str1, str2, str3, str4, str5, bool4, paramString, (Date)localObject1, str6, str7, (List)localObject2, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool1, bool2, bool3, bool12, bool13);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.PatentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */