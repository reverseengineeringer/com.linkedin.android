package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfoBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompanyBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchCompanyBuilder
  implements FissileDataModelBuilder<SearchCompany>, DataTemplateBuilder<SearchCompany>
{
  public static final SearchCompanyBuilder INSTANCE = new SearchCompanyBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("backendUrn");
    JSON_KEY_STORE.put("company");
    JSON_KEY_STORE.put("location");
    JSON_KEY_STORE.put("industry");
    JSON_KEY_STORE.put("size");
    JSON_KEY_STORE.put("following");
  }
  
  public static SearchCompany build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    Object localObject1 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("backendUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("company", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MiniCompanyBuilder.INSTANCE;
        localObject2 = MiniCompanyBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("location", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("industry", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("size", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("following", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = FollowingInfoBuilder.INSTANCE;
        localObject1 = FollowingInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: id when building com.linkedin.android.pegasus.gen.voyager.search.SearchCompany");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: backendUrn when building com.linkedin.android.pegasus.gen.voyager.search.SearchCompany");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: company when building com.linkedin.android.pegasus.gen.voyager.search.SearchCompany");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: following when building com.linkedin.android.pegasus.gen.voyager.search.SearchCompany");
    }
    return new SearchCompany(str4, (Urn)localObject3, (MiniCompany)localObject2, str3, str2, str1, (FollowingInfo)localObject1, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static SearchCompany readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SearchCompany");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchCompany");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchCompany");
    }
    if (((ByteBuffer)localObject2).getInt() != 1913266021)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building SearchCompany");
    }
    String str1 = null;
    Object localObject3 = null;
    paramString = null;
    MiniCompanyBuilder localMiniCompanyBuilder = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    localObject1 = null;
    FollowingInfoBuilder localFollowingInfoBuilder = null;
    boolean bool4;
    boolean bool5;
    label262:
    boolean bool2;
    label297:
    boolean bool1;
    label354:
    label380:
    boolean bool6;
    label392:
    boolean bool7;
    label419:
    boolean bool8;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label597;
      }
      bool5 = true;
      if (bool5)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label603;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localMiniCompanyBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMiniCompanyBuilder = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label609;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label615;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label621;
      }
      bool6 = true;
      if (bool6) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label627;
      }
      bool7 = true;
      if (bool7) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label633;
      }
      bool8 = true;
      label446:
      if (bool8) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label639;
      }
      bool2 = true;
      label473:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localFollowingInfoBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localFollowingInfoBuilder = FollowingInfoBuilder.INSTANCE;
          localObject1 = FollowingInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label645;
          }
          bool2 = true;
        }
        label531:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = FollowingInfoBuilder.INSTANCE;
          localObject1 = FollowingInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label651;
          }
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
    label651:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool4) {
        break label657;
      }
      throw new IOException("Failed to find required field: id when reading com.linkedin.android.pegasus.gen.voyager.search.SearchCompany from fission.");
      bool4 = false;
      break;
      bool5 = false;
      break label262;
      bool2 = false;
      break label297;
      bool1 = false;
      break label354;
      bool1 = false;
      break label380;
      bool6 = false;
      break label392;
      bool7 = false;
      break label419;
      bool8 = false;
      break label446;
      bool2 = false;
      break label473;
      bool2 = false;
      break label531;
    }
    label657:
    if (!bool5) {
      throw new IOException("Failed to find required field: backendUrn when reading com.linkedin.android.pegasus.gen.voyager.search.SearchCompany from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: company when reading com.linkedin.android.pegasus.gen.voyager.search.SearchCompany from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: following when reading com.linkedin.android.pegasus.gen.voyager.search.SearchCompany from fission.");
    }
    return new SearchCompany(str1, (Urn)localObject3, paramString, str2, str3, str4, (FollowingInfo)localObject1, bool4, bool5, bool1, bool6, bool7, bool8, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchCompanyBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */