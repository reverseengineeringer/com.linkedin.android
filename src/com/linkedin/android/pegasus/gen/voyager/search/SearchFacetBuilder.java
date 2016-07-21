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
import java.util.ArrayList;
import java.util.List;

public final class SearchFacetBuilder
  implements FissileDataModelBuilder<SearchFacet>, DataTemplateBuilder<SearchFacet>
{
  public static final SearchFacetBuilder INSTANCE = new SearchFacetBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("displayName");
    JSON_KEY_STORE.put("facetParameterName");
    JSON_KEY_STORE.put("facetType");
    JSON_KEY_STORE.put("facetTypeV2");
    JSON_KEY_STORE.put("facetValues");
  }
  
  public static SearchFacet build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    SearchFacetType localSearchFacetType = null;
    Object localObject = null;
    ArrayList localArrayList = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("displayName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("facetParameterName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("facetType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchFacetType = (SearchFacetType)paramDataReader.readEnum(SearchFacetType.Builder.INSTANCE);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("facetTypeV2", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = SearchFacetTypeV2Builder.INSTANCE;
        localObject = SearchFacetTypeV2Builder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("facetValues", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            SearchFacetValueBuilder localSearchFacetValueBuilder = SearchFacetValueBuilder.INSTANCE;
            localArrayList.add(SearchFacetValueBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: displayName when building com.linkedin.android.pegasus.gen.voyager.search.SearchFacet");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: facetParameterName when building com.linkedin.android.pegasus.gen.voyager.search.SearchFacet");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: facetValues when building com.linkedin.android.pegasus.gen.voyager.search.SearchFacet");
    }
    return new SearchFacet(str2, str1, localSearchFacetType, (SearchFacetTypeV2)localObject, localArrayList, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static SearchFacet readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SearchFacet");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchFacet");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchFacet");
    }
    if (((ByteBuffer)localObject2).getInt() != 541982206)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building SearchFacet");
    }
    String str1 = null;
    String str2 = null;
    SearchFacetType localSearchFacetType = null;
    paramString = null;
    Object localObject3 = null;
    localObject1 = null;
    boolean bool3;
    boolean bool4;
    label253:
    boolean bool5;
    label280:
    boolean bool2;
    label310:
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label548;
      }
      bool4 = true;
      if (bool4) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label554;
      }
      bool5 = true;
      if (bool5) {
        localSearchFacetType = SearchFacetType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label560;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = (String)localObject3;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localObject3 = SearchFacetTypeV2Builder.INSTANCE;
          paramString = SearchFacetTypeV2Builder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label566;
          }
          bool1 = true;
        }
        label367:
        if (i == 1)
        {
          paramString = SearchFacetTypeV2Builder.INSTANCE;
          paramString = SearchFacetTypeV2Builder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label572;
          }
          bool1 = true;
        }
      }
      label393:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label578;
      }
      bool2 = true;
      label405:
      if (!bool2) {
        break label596;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject3 = new ArrayList();
      label429:
      localObject1 = localObject3;
      if (j <= 0) {
        break label596;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        SearchFacetValueBuilder localSearchFacetValueBuilder = SearchFacetValueBuilder.INSTANCE;
        localObject1 = SearchFacetValueBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label584;
        }
        i = 1;
      }
      label489:
      if (k == 1)
      {
        localObject1 = SearchFacetValueBuilder.INSTANCE;
        localObject1 = SearchFacetValueBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label590;
        }
      }
    }
    label548:
    label554:
    label560:
    label566:
    label572:
    label578:
    label584:
    label590:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject3).add(localObject1);
      }
      j -= 1;
      break label429;
      bool3 = false;
      break;
      bool4 = false;
      break label253;
      bool5 = false;
      break label280;
      bool2 = false;
      break label310;
      bool1 = false;
      break label367;
      bool1 = false;
      break label393;
      bool2 = false;
      break label405;
      i = 0;
      break label489;
    }
    label596:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: displayName when reading com.linkedin.android.pegasus.gen.voyager.search.SearchFacet from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: facetParameterName when reading com.linkedin.android.pegasus.gen.voyager.search.SearchFacet from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: facetValues when reading com.linkedin.android.pegasus.gen.voyager.search.SearchFacet from fission.");
    }
    return new SearchFacet(str1, str2, localSearchFacetType, paramString, (List)localObject1, bool3, bool4, bool5, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchFacetBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */