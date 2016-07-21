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

public final class SearchHistoryBuilder
  implements FissileDataModelBuilder<SearchHistory>, DataTemplateBuilder<SearchHistory>
{
  public static final SearchHistoryBuilder INSTANCE = new SearchHistoryBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("displayText");
    JSON_KEY_STORE.put("subtext");
    JSON_KEY_STORE.put("searchType");
    JSON_KEY_STORE.put("historyInfo");
  }
  
  public static final class HistoryInfoBuilder
    implements FissileDataModelBuilder<SearchHistory.HistoryInfo>, DataTemplateBuilder<SearchHistory.HistoryInfo>
  {
    public static final HistoryInfoBuilder INSTANCE = new HistoryInfoBuilder();
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
      JSON_KEY_STORE.put("com.linkedin.voyager.search.SearchQuery");
      JSON_KEY_STORE.put("com.linkedin.voyager.search.EntityAwareSearchQuery");
      JSON_KEY_STORE.put("com.linkedin.voyager.search.SearchHistoryTrendingResultContainer");
    }
    
    public static SearchHistory.HistoryInfo build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject8 = null;
      Object localObject7 = null;
      Object localObject6 = null;
      Object localObject5 = null;
      Object localObject4 = null;
      Object localObject3 = null;
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool8 = false;
      boolean bool7 = false;
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
          localObject8 = SearchHistoryProfileBuilder.INSTANCE;
          localObject8 = SearchHistoryProfileBuilder.build(paramDataReader);
          bool8 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchHistoryJob", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject7 = SearchHistoryJobBuilder.INSTANCE;
          localObject7 = SearchHistoryJobBuilder.build(paramDataReader);
          bool7 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchHistoryCompany", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject6 = SearchHistoryCompanyBuilder.INSTANCE;
          localObject6 = SearchHistoryCompanyBuilder.build(paramDataReader);
          bool6 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchHistoryGroup", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject5 = SearchHistoryGroupBuilder.INSTANCE;
          localObject5 = SearchHistoryGroupBuilder.build(paramDataReader);
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchHistorySchool", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = SearchHistorySchoolBuilder.INSTANCE;
          localObject4 = SearchHistorySchoolBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchQuery", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = SearchQueryBuilder.INSTANCE;
          localObject3 = SearchQueryBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.EntityAwareSearchQuery", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = EntityAwareSearchQueryBuilder.INSTANCE;
          localObject2 = EntityAwareSearchQueryBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchHistoryTrendingResultContainer", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = SearchHistoryTrendingResultContainerBuilder.INSTANCE;
          localObject1 = SearchHistoryTrendingResultContainerBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int j = 0;
      if (bool8) {
        j = 1;
      }
      int i = j;
      if (bool7)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .HistoryInfo");
        }
        i = 1;
      }
      j = i;
      if (bool6)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .HistoryInfo");
        }
        j = 1;
      }
      i = j;
      if (bool5)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .HistoryInfo");
        }
        i = 1;
      }
      j = i;
      if (bool4)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .HistoryInfo");
        }
        j = 1;
      }
      i = j;
      if (bool3)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .HistoryInfo");
        }
        i = 1;
      }
      j = i;
      if (bool2)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .HistoryInfo");
        }
        j = 1;
      }
      if ((bool1) && (j != 0)) {
        throw new DataReaderException("Found more than 1 member when building .HistoryInfo");
      }
      return new SearchHistory.HistoryInfo((SearchHistoryProfile)localObject8, (SearchHistoryJob)localObject7, (SearchHistoryCompany)localObject6, (SearchHistoryGroup)localObject5, (SearchHistorySchool)localObject4, (SearchQuery)localObject3, (EntityAwareSearchQuery)localObject2, (SearchHistoryTrendingResultContainer)localObject1, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
    }
    
    public static SearchHistory.HistoryInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building SearchHistory.HistoryInfo");
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
            localObject8 = paramString;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building SearchHistory.HistoryInfo");
      }
      Object localObject8 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building SearchHistory.HistoryInfo");
      }
      if (((ByteBuffer)localObject8).getInt() != 1922954092)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject8);
        throw new IOException("UID mismatch. Can't read cached data when building SearchHistory.HistoryInfo");
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
      SearchQueryBuilder localSearchQueryBuilder = null;
      Object localObject6 = null;
      EntityAwareSearchQueryBuilder localEntityAwareSearchQueryBuilder = null;
      Object localObject7 = null;
      SearchHistoryTrendingResultContainerBuilder localSearchHistoryTrendingResultContainerBuilder = null;
      boolean bool2;
      boolean bool1;
      label313:
      label339:
      boolean bool3;
      label351:
      label413:
      label442:
      boolean bool4;
      label454:
      label516:
      label545:
      boolean bool5;
      label557:
      label619:
      label648:
      boolean bool6;
      label660:
      label722:
      label751:
      boolean bool7;
      label763:
      label825:
      label854:
      boolean bool8;
      if (((ByteBuffer)localObject8).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject8).get();
          paramString = localSearchHistoryProfileBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject8);
            localSearchHistoryProfileBuilder = SearchHistoryProfileBuilder.INSTANCE;
            paramString = SearchHistoryProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label1113;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = SearchHistoryProfileBuilder.INSTANCE;
            paramString = SearchHistoryProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
            if (paramString == null) {
              break label1119;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject8).get() != 1) {
          break label1125;
        }
        bool3 = true;
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject8).get();
          localObject1 = localSearchHistoryJobBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject8);
            localSearchHistoryJobBuilder = SearchHistoryJobBuilder.INSTANCE;
            localObject1 = SearchHistoryJobBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label1131;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = SearchHistoryJobBuilder.INSTANCE;
            localObject1 = SearchHistoryJobBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label1137;
            }
            bool2 = true;
          }
        }
        if (((ByteBuffer)localObject8).get() != 1) {
          break label1143;
        }
        bool4 = true;
        bool3 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject8).get();
          localObject2 = localSearchHistoryCompanyBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject8);
            localSearchHistoryCompanyBuilder = SearchHistoryCompanyBuilder.INSTANCE;
            localObject2 = SearchHistoryCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label1149;
            }
            bool3 = true;
          }
          if (i == 1)
          {
            localObject2 = SearchHistoryCompanyBuilder.INSTANCE;
            localObject2 = SearchHistoryCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label1155;
            }
            bool3 = true;
          }
        }
        if (((ByteBuffer)localObject8).get() != 1) {
          break label1161;
        }
        bool5 = true;
        bool4 = bool5;
        if (bool5)
        {
          i = ((ByteBuffer)localObject8).get();
          localObject3 = localSearchHistoryGroupBuilder;
          bool4 = bool5;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject8);
            localSearchHistoryGroupBuilder = SearchHistoryGroupBuilder.INSTANCE;
            localObject3 = SearchHistoryGroupBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label1167;
            }
            bool4 = true;
          }
          if (i == 1)
          {
            localObject3 = SearchHistoryGroupBuilder.INSTANCE;
            localObject3 = SearchHistoryGroupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
            if (localObject3 == null) {
              break label1173;
            }
            bool4 = true;
          }
        }
        if (((ByteBuffer)localObject8).get() != 1) {
          break label1179;
        }
        bool6 = true;
        bool5 = bool6;
        if (bool6)
        {
          i = ((ByteBuffer)localObject8).get();
          localObject4 = localSearchHistorySchoolBuilder;
          bool5 = bool6;
          if (i == 0)
          {
            localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject8);
            localSearchHistorySchoolBuilder = SearchHistorySchoolBuilder.INSTANCE;
            localObject4 = SearchHistorySchoolBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
            if (localObject4 == null) {
              break label1185;
            }
            bool5 = true;
          }
          if (i == 1)
          {
            localObject4 = SearchHistorySchoolBuilder.INSTANCE;
            localObject4 = SearchHistorySchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
            if (localObject4 == null) {
              break label1191;
            }
            bool5 = true;
          }
        }
        if (((ByteBuffer)localObject8).get() != 1) {
          break label1197;
        }
        bool7 = true;
        bool6 = bool7;
        if (bool7)
        {
          i = ((ByteBuffer)localObject8).get();
          localObject5 = localSearchQueryBuilder;
          bool6 = bool7;
          if (i == 0)
          {
            localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject8);
            localSearchQueryBuilder = SearchQueryBuilder.INSTANCE;
            localObject5 = SearchQueryBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
            if (localObject5 == null) {
              break label1203;
            }
            bool6 = true;
          }
          if (i == 1)
          {
            localObject5 = SearchQueryBuilder.INSTANCE;
            localObject5 = SearchQueryBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
            if (localObject5 == null) {
              break label1209;
            }
            bool6 = true;
          }
        }
        if (((ByteBuffer)localObject8).get() != 1) {
          break label1215;
        }
        bool8 = true;
        label866:
        bool7 = bool8;
        if (bool8)
        {
          i = ((ByteBuffer)localObject8).get();
          localObject6 = localEntityAwareSearchQueryBuilder;
          bool7 = bool8;
          if (i == 0)
          {
            localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject8);
            localEntityAwareSearchQueryBuilder = EntityAwareSearchQueryBuilder.INSTANCE;
            localObject6 = EntityAwareSearchQueryBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
            if (localObject6 == null) {
              break label1221;
            }
            bool7 = true;
          }
          label928:
          if (i == 1)
          {
            localObject6 = EntityAwareSearchQueryBuilder.INSTANCE;
            localObject6 = EntityAwareSearchQueryBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
            if (localObject6 == null) {
              break label1227;
            }
            bool7 = true;
          }
        }
        label957:
        if (((ByteBuffer)localObject8).get() != 1) {
          break label1233;
        }
        bool8 = true;
        label969:
        bool9 = bool8;
        if (bool8)
        {
          i = ((ByteBuffer)localObject8).get();
          localObject7 = localSearchHistoryTrendingResultContainerBuilder;
          if (i == 0)
          {
            localObject7 = paramFissionAdapter.readString((ByteBuffer)localObject8);
            localSearchHistoryTrendingResultContainerBuilder = SearchHistoryTrendingResultContainerBuilder.INSTANCE;
            localObject7 = SearchHistoryTrendingResultContainerBuilder.readFromFission(paramFissionAdapter, null, (String)localObject7, paramFissionTransaction);
            if (localObject7 == null) {
              break label1239;
            }
            bool8 = true;
          }
          label1027:
          bool9 = bool8;
          if (i == 1)
          {
            localObject7 = SearchHistoryTrendingResultContainerBuilder.INSTANCE;
            localObject7 = SearchHistoryTrendingResultContainerBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
            if (localObject7 == null) {
              break label1245;
            }
          }
        }
      }
      label1113:
      label1119:
      label1125:
      label1131:
      label1137:
      label1143:
      label1149:
      label1155:
      label1161:
      label1167:
      label1173:
      label1179:
      label1185:
      label1191:
      label1197:
      label1203:
      label1209:
      label1215:
      label1221:
      label1227:
      label1233:
      label1239:
      label1245:
      for (boolean bool9 = true;; bool9 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject8);
        }
        j = 0;
        if (bool1) {
          j = 1;
        }
        i = j;
        if (!bool2) {
          break label1254;
        }
        if (j == 0) {
          break label1251;
        }
        throw new IOException("Found more than 1 member when reading .HistoryInfo from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label313;
        bool1 = false;
        break label339;
        bool3 = false;
        break label351;
        bool2 = false;
        break label413;
        bool2 = false;
        break label442;
        bool4 = false;
        break label454;
        bool3 = false;
        break label516;
        bool3 = false;
        break label545;
        bool5 = false;
        break label557;
        bool4 = false;
        break label619;
        bool4 = false;
        break label648;
        bool6 = false;
        break label660;
        bool5 = false;
        break label722;
        bool5 = false;
        break label751;
        bool7 = false;
        break label763;
        bool6 = false;
        break label825;
        bool6 = false;
        break label854;
        bool8 = false;
        break label866;
        bool7 = false;
        break label928;
        bool7 = false;
        break label957;
        bool8 = false;
        break label969;
        bool8 = false;
        break label1027;
      }
      label1251:
      int i = 1;
      label1254:
      int j = i;
      if (bool3)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .HistoryInfo from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool4)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .HistoryInfo from fission.");
        }
        i = 1;
      }
      j = i;
      if (bool5)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .HistoryInfo from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool6)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .HistoryInfo from fission.");
        }
        i = 1;
      }
      j = i;
      if (bool7)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .HistoryInfo from fission.");
        }
        j = 1;
      }
      if ((bool9) && (j != 0)) {
        throw new IOException("Found more than 1 member when reading .HistoryInfo from fission.");
      }
      return new SearchHistory.HistoryInfo(paramString, (SearchHistoryJob)localObject1, (SearchHistoryCompany)localObject2, (SearchHistoryGroup)localObject3, (SearchHistorySchool)localObject4, (SearchQuery)localObject5, (EntityAwareSearchQuery)localObject6, (SearchHistoryTrendingResultContainer)localObject7, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool9);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */