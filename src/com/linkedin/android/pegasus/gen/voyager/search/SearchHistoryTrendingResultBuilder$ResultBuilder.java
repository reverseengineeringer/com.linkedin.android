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

public final class SearchHistoryTrendingResultBuilder$ResultBuilder
  implements FissileDataModelBuilder<SearchHistoryTrendingResult.Result>, DataTemplateBuilder<SearchHistoryTrendingResult.Result>
{
  public static final ResultBuilder INSTANCE = new ResultBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.search.SearchHistoryProfile");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.SearchHistoryJob");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.SearchHistoryCompany");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.SearchHistoryGroup");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.SearchHistorySchool");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.SearchHistoryArticle");
  }
  
  public static SearchHistoryTrendingResult.Result build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchHistoryProfile", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = SearchHistoryProfileBuilder.INSTANCE;
        localObject6 = SearchHistoryProfileBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchHistoryJob", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = SearchHistoryJobBuilder.INSTANCE;
        localObject5 = SearchHistoryJobBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchHistoryCompany", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = SearchHistoryCompanyBuilder.INSTANCE;
        localObject4 = SearchHistoryCompanyBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchHistoryGroup", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = SearchHistoryGroupBuilder.INSTANCE;
        localObject3 = SearchHistoryGroupBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchHistorySchool", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = SearchHistorySchoolBuilder.INSTANCE;
        localObject2 = SearchHistorySchoolBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchHistoryArticle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = SearchHistoryArticleBuilder.INSTANCE;
        localObject1 = SearchHistoryArticleBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int j = 0;
    if (bool6) {
      j = 1;
    }
    int i = j;
    if (bool5)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Result");
      }
      i = 1;
    }
    j = i;
    if (bool4)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Result");
      }
      j = 1;
    }
    i = j;
    if (bool3)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Result");
      }
      i = 1;
    }
    j = i;
    if (bool2)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Result");
      }
      j = 1;
    }
    if ((bool1) && (j != 0)) {
      throw new DataReaderException("Found more than 1 member when building .Result");
    }
    return new SearchHistoryTrendingResult.Result((SearchHistoryProfile)localObject6, (SearchHistoryJob)localObject5, (SearchHistoryCompany)localObject4, (SearchHistoryGroup)localObject3, (SearchHistorySchool)localObject2, (SearchHistoryArticle)localObject1, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static SearchHistoryTrendingResult.Result readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SearchHistoryTrendingResult.Result");
    }
    Object localObject1 = paramByteBuffer;
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
          localObject6 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchHistoryTrendingResult.Result");
    }
    Object localObject6 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchHistoryTrendingResult.Result");
    }
    if (((ByteBuffer)localObject6).getInt() != 996519568)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject6);
      throw new IOException("UID mismatch. Can't read cached data when building SearchHistoryTrendingResult.Result");
    }
    paramString = null;
    SearchHistoryProfileBuilder localSearchHistoryProfileBuilder = null;
    localObject1 = null;
    SearchHistoryJobBuilder localSearchHistoryJobBuilder = null;
    Object localObject2 = null;
    SearchHistoryCompanyBuilder localSearchHistoryCompanyBuilder = null;
    Object localObject3 = null;
    SearchHistoryGroupBuilder localSearchHistoryGroupBuilder = null;
    Object localObject4 = null;
    SearchHistorySchoolBuilder localSearchHistorySchoolBuilder = null;
    Object localObject5 = null;
    SearchHistoryArticleBuilder localSearchHistoryArticleBuilder = null;
    boolean bool2;
    boolean bool1;
    label301:
    label327:
    boolean bool3;
    label339:
    label401:
    label430:
    boolean bool4;
    label442:
    label504:
    label533:
    boolean bool5;
    label545:
    label607:
    label636:
    boolean bool6;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject6).get();
        paramString = localSearchHistoryProfileBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localSearchHistoryProfileBuilder = SearchHistoryProfileBuilder.INSTANCE;
          paramString = SearchHistoryProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label895;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = SearchHistoryProfileBuilder.INSTANCE;
          paramString = SearchHistoryProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (paramString == null) {
            break label901;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label907;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject1 = localSearchHistoryJobBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localSearchHistoryJobBuilder = SearchHistoryJobBuilder.INSTANCE;
          localObject1 = SearchHistoryJobBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label913;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = SearchHistoryJobBuilder.INSTANCE;
          localObject1 = SearchHistoryJobBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label919;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label925;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject2 = localSearchHistoryCompanyBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localSearchHistoryCompanyBuilder = SearchHistoryCompanyBuilder.INSTANCE;
          localObject2 = SearchHistoryCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label931;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = SearchHistoryCompanyBuilder.INSTANCE;
          localObject2 = SearchHistoryCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label937;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label943;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject3 = localSearchHistoryGroupBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localSearchHistoryGroupBuilder = SearchHistoryGroupBuilder.INSTANCE;
          localObject3 = SearchHistoryGroupBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label949;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject3 = SearchHistoryGroupBuilder.INSTANCE;
          localObject3 = SearchHistoryGroupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label955;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label961;
      }
      bool6 = true;
      label648:
      bool5 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject4 = localSearchHistorySchoolBuilder;
        bool5 = bool6;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localSearchHistorySchoolBuilder = SearchHistorySchoolBuilder.INSTANCE;
          localObject4 = SearchHistorySchoolBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label967;
          }
          bool5 = true;
        }
        label710:
        if (i == 1)
        {
          localObject4 = SearchHistorySchoolBuilder.INSTANCE;
          localObject4 = SearchHistorySchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label973;
          }
          bool5 = true;
        }
      }
      label739:
      if (((ByteBuffer)localObject6).get() != 1) {
        break label979;
      }
      bool6 = true;
      label751:
      bool7 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject5 = localSearchHistoryArticleBuilder;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localSearchHistoryArticleBuilder = SearchHistoryArticleBuilder.INSTANCE;
          localObject5 = SearchHistoryArticleBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label985;
          }
          bool6 = true;
        }
        label809:
        bool7 = bool6;
        if (i == 1)
        {
          localObject5 = SearchHistoryArticleBuilder.INSTANCE;
          localObject5 = SearchHistoryArticleBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label991;
          }
        }
      }
    }
    label895:
    label901:
    label907:
    label913:
    label919:
    label925:
    label931:
    label937:
    label943:
    label949:
    label955:
    label961:
    label967:
    label973:
    label979:
    label985:
    label991:
    for (boolean bool7 = true;; bool7 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject6);
      }
      j = 0;
      if (bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        break label1000;
      }
      if (j == 0) {
        break label997;
      }
      throw new IOException("Found more than 1 member when reading .Result from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label301;
      bool1 = false;
      break label327;
      bool3 = false;
      break label339;
      bool2 = false;
      break label401;
      bool2 = false;
      break label430;
      bool4 = false;
      break label442;
      bool3 = false;
      break label504;
      bool3 = false;
      break label533;
      bool5 = false;
      break label545;
      bool4 = false;
      break label607;
      bool4 = false;
      break label636;
      bool6 = false;
      break label648;
      bool5 = false;
      break label710;
      bool5 = false;
      break label739;
      bool6 = false;
      break label751;
      bool6 = false;
      break label809;
    }
    label997:
    int i = 1;
    label1000:
    int j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Result from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Result from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool5)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Result from fission.");
      }
      j = 1;
    }
    if ((bool7) && (j != 0)) {
      throw new IOException("Found more than 1 member when reading .Result from fission.");
    }
    return new SearchHistoryTrendingResult.Result(paramString, (SearchHistoryJob)localObject1, (SearchHistoryCompany)localObject2, (SearchHistoryGroup)localObject3, (SearchHistorySchool)localObject4, (SearchHistoryArticle)localObject5, bool1, bool2, bool3, bool4, bool5, bool7);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryTrendingResultBuilder.ResultBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */