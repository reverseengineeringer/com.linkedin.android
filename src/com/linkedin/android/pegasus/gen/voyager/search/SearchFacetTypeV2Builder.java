package com.linkedin.android.pegasus.gen.voyager.search;

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

public final class SearchFacetTypeV2Builder
  implements FissileDataModelBuilder<SearchFacetTypeV2>, DataTemplateBuilder<SearchFacetTypeV2>
{
  public static final SearchFacetTypeV2Builder INSTANCE = new SearchFacetTypeV2Builder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.search.JobSearchFacetType");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.PeopleSearchFacetType");
  }
  
  public static SearchFacetTypeV2 build(DataReader paramDataReader)
    throws DataReaderException
  {
    JobSearchFacetType localJobSearchFacetType = null;
    PeopleSearchFacetType localPeopleSearchFacetType = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.JobSearchFacetType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localJobSearchFacetType = (JobSearchFacetType)paramDataReader.readEnum(JobSearchFacetType.Builder.INSTANCE);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.PeopleSearchFacetType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localPeopleSearchFacetType = (PeopleSearchFacetType)paramDataReader.readEnum(PeopleSearchFacetType.Builder.INSTANCE);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int i = 0;
    if (bool2) {
      i = 1;
    }
    if ((bool1) && (i != 0)) {
      throw new DataReaderException("Found more than 1 member when building com.linkedin.android.pegasus.gen.voyager.search.SearchFacetTypeV2");
    }
    return new SearchFacetTypeV2(localJobSearchFacetType, localPeopleSearchFacetType, bool2, bool1);
  }
  
  public static SearchFacetTypeV2 readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SearchFacetTypeV2");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
          localObject = paramString;
          if (i != 0) {
            break label170;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            break;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchFacetTypeV2");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchFacetTypeV2");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != 1759935903)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building SearchFacetTypeV2");
    }
    paramString = null;
    paramFissionTransaction = null;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = JobSearchFacetType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label306;
      }
    }
    for (;;)
    {
      if (bool2) {
        paramFissionTransaction = PeopleSearchFacetType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      i = 0;
      if (bool1) {
        i = 1;
      }
      if ((!bool2) || (i == 0)) {
        break label312;
      }
      throw new IOException("Found more than 1 member when reading com.linkedin.android.pegasus.gen.voyager.search.SearchFacetTypeV2 from fission.");
      bool1 = false;
      break;
      label306:
      bool2 = false;
    }
    label312:
    return new SearchFacetTypeV2(paramString, paramFissionTransaction, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchFacetTypeV2Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */