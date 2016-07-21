package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedTextBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class FacetSuggestionBuilder
  implements FissileDataModelBuilder<FacetSuggestion>, DataTemplateBuilder<FacetSuggestion>
{
  public static final FacetSuggestionBuilder INSTANCE = new FacetSuggestionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("facetParameterName");
    JSON_KEY_STORE.put("facetType");
    JSON_KEY_STORE.put("facetTypeV2");
    JSON_KEY_STORE.put("suggestedText");
    JSON_KEY_STORE.put("suggestedValues");
  }
  
  public static FacetSuggestion build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    SearchFacetType localSearchFacetType = null;
    Object localObject2 = null;
    Object localObject1 = null;
    ArrayList localArrayList = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("facetParameterName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("facetType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchFacetType = (SearchFacetType)paramDataReader.readEnum(SearchFacetType.Builder.INSTANCE);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("facetTypeV2", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = SearchFacetTypeV2Builder.INSTANCE;
        localObject2 = SearchFacetTypeV2Builder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("suggestedText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = AnnotatedTextBuilder.INSTANCE;
        localObject1 = AnnotatedTextBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("suggestedValues", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            FacetValueBuilder localFacetValueBuilder = FacetValueBuilder.INSTANCE;
            localArrayList.add(FacetValueBuilder.build(paramDataReader));
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
      throw new DataReaderException("Failed to find required field: facetParameterName when building com.linkedin.android.pegasus.gen.voyager.search.FacetSuggestion");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: suggestedText when building com.linkedin.android.pegasus.gen.voyager.search.FacetSuggestion");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: suggestedValues when building com.linkedin.android.pegasus.gen.voyager.search.FacetSuggestion");
    }
    return new FacetSuggestion(str, localSearchFacetType, (SearchFacetTypeV2)localObject2, (AnnotatedText)localObject1, localArrayList, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static FacetSuggestion readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building FacetSuggestion");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building FacetSuggestion");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building FacetSuggestion");
    }
    if (((ByteBuffer)localObject3).getInt() != -1161593615)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building FacetSuggestion");
    }
    String str = null;
    SearchFacetType localSearchFacetType = null;
    paramString = null;
    Object localObject5 = null;
    localObject1 = null;
    Object localObject4 = null;
    Object localObject2 = null;
    boolean bool4;
    boolean bool5;
    label256:
    boolean bool2;
    label286:
    boolean bool1;
    label343:
    label369:
    boolean bool3;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label627;
      }
      bool5 = true;
      if (bool5) {
        localSearchFacetType = SearchFacetType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label633;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = (String)localObject5;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localObject5 = SearchFacetTypeV2Builder.INSTANCE;
          paramString = SearchFacetTypeV2Builder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label639;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = SearchFacetTypeV2Builder.INSTANCE;
          paramString = SearchFacetTypeV2Builder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label645;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label651;
      }
      bool3 = true;
      label381:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localObject4;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localObject4 = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label657;
          }
          bool2 = true;
        }
        label443:
        if (i == 1)
        {
          localObject1 = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label663;
          }
          bool2 = true;
        }
      }
      label472:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label669;
      }
      bool3 = true;
      label484:
      if (!bool3) {
        break label687;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localObject4 = new ArrayList();
      label508:
      localObject2 = localObject4;
      if (j <= 0) {
        break label687;
      }
      localObject2 = null;
      i = 1;
      int k = ((ByteBuffer)localObject3).get();
      if (k == 0)
      {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
        localObject5 = FacetValueBuilder.INSTANCE;
        localObject2 = FacetValueBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
        if (localObject2 == null) {
          break label675;
        }
        i = 1;
      }
      label568:
      if (k == 1)
      {
        localObject2 = FacetValueBuilder.INSTANCE;
        localObject2 = FacetValueBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (localObject2 == null) {
          break label681;
        }
      }
    }
    label627:
    label633:
    label639:
    label645:
    label651:
    label657:
    label663:
    label669:
    label675:
    label681:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject4).add(localObject2);
      }
      j -= 1;
      break label508;
      bool4 = false;
      break;
      bool5 = false;
      break label256;
      bool2 = false;
      break label286;
      bool1 = false;
      break label343;
      bool1 = false;
      break label369;
      bool3 = false;
      break label381;
      bool2 = false;
      break label443;
      bool2 = false;
      break label472;
      bool3 = false;
      break label484;
      i = 0;
      break label568;
    }
    label687:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: facetParameterName when reading com.linkedin.android.pegasus.gen.voyager.search.FacetSuggestion from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: suggestedText when reading com.linkedin.android.pegasus.gen.voyager.search.FacetSuggestion from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: suggestedValues when reading com.linkedin.android.pegasus.gen.voyager.search.FacetSuggestion from fission.");
    }
    return new FacetSuggestion(str, localSearchFacetType, paramString, (AnnotatedText)localObject1, (List)localObject2, bool4, bool5, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.FacetSuggestionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */