package com.linkedin.android.pegasus.gen.voyager.typeahead;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQuery;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQueryBuilder;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType.Builder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class TypeaheadSuggestionBuilder
  implements FissileDataModelBuilder<TypeaheadSuggestion>, DataTemplateBuilder<TypeaheadSuggestion>
{
  public static final TypeaheadSuggestionBuilder INSTANCE = new TypeaheadSuggestionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("type");
    JSON_KEY_STORE.put("query");
    JSON_KEY_STORE.put("suggestedEntities");
  }
  
  public static TypeaheadSuggestion build(DataReader paramDataReader)
    throws DataReaderException
  {
    SearchType localSearchType = null;
    Object localObject = null;
    ArrayList localArrayList = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchType = (SearchType)paramDataReader.readEnum(SearchType.Builder.INSTANCE);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("query", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = SearchQueryBuilder.INSTANCE;
        localObject = SearchQueryBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("suggestedEntities", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            SuggestedEntityBuilder localSuggestedEntityBuilder = SuggestedEntityBuilder.INSTANCE;
            localArrayList.add(SuggestedEntityBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: type when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSuggestion");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: query when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSuggestion");
    }
    return new TypeaheadSuggestion(localSearchType, (SearchQuery)localObject, localArrayList, bool3, bool2, bool1);
  }
  
  public static TypeaheadSuggestion readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building TypeaheadSuggestion");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building TypeaheadSuggestion");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building TypeaheadSuggestion");
    }
    if (((ByteBuffer)localObject2).getInt() != 535944511)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building TypeaheadSuggestion");
    }
    SearchType localSearchType = null;
    paramString = null;
    Object localObject3 = null;
    localObject1 = null;
    boolean bool3;
    boolean bool2;
    label250:
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localSearchType = SearchType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label488;
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
          localObject3 = SearchQueryBuilder.INSTANCE;
          paramString = SearchQueryBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label494;
          }
          bool1 = true;
        }
        label307:
        if (i == 1)
        {
          paramString = SearchQueryBuilder.INSTANCE;
          paramString = SearchQueryBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label500;
          }
          bool1 = true;
        }
      }
      label333:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label506;
      }
      bool2 = true;
      label345:
      if (!bool2) {
        break label524;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject3 = new ArrayList();
      label369:
      localObject1 = localObject3;
      if (j <= 0) {
        break label524;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        SuggestedEntityBuilder localSuggestedEntityBuilder = SuggestedEntityBuilder.INSTANCE;
        localObject1 = SuggestedEntityBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label512;
        }
        i = 1;
      }
      label429:
      if (k == 1)
      {
        localObject1 = SuggestedEntityBuilder.INSTANCE;
        localObject1 = SuggestedEntityBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label518;
        }
      }
    }
    label488:
    label494:
    label500:
    label506:
    label512:
    label518:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject3).add(localObject1);
      }
      j -= 1;
      break label369;
      bool3 = false;
      break;
      bool2 = false;
      break label250;
      bool1 = false;
      break label307;
      bool1 = false;
      break label333;
      bool2 = false;
      break label345;
      i = 0;
      break label429;
    }
    label524:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: type when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSuggestion from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: query when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSuggestion from fission.");
    }
    return new TypeaheadSuggestion(localSearchType, paramString, (List)localObject1, bool3, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSuggestionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */