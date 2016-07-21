package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.UpdateBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchHitBuilder$HitInfoBuilder
  implements FissileDataModelBuilder<SearchHit.HitInfo>, DataTemplateBuilder<SearchHit.HitInfo>
{
  public static final HitInfoBuilder INSTANCE = new HitInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.search.SearchProfile");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.SearchJob");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.SearchJobJserp");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.SearchCompany");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.SearchSchool");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.SearchGroup");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.SearchArticle");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.SecondaryResultContainer");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.FacetSuggestion");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.Paywall");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.Update");
    JSON_KEY_STORE.put("com.linkedin.voyager.search.BlurredHit");
  }
  
  public static SearchHit.HitInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject12 = null;
    Object localObject11 = null;
    Object localObject10 = null;
    Object localObject9 = null;
    Object localObject8 = null;
    Object localObject7 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool12 = false;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool9 = false;
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
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchProfile", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject12 = SearchProfileBuilder.INSTANCE;
        localObject12 = SearchProfileBuilder.build(paramDataReader);
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchJob", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject11 = SearchJobBuilder.INSTANCE;
        localObject11 = SearchJobBuilder.build(paramDataReader);
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchJobJserp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject10 = SearchJobJserpBuilder.INSTANCE;
        localObject10 = SearchJobJserpBuilder.build(paramDataReader);
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchCompany", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject9 = SearchCompanyBuilder.INSTANCE;
        localObject9 = SearchCompanyBuilder.build(paramDataReader);
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchSchool", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject8 = SearchSchoolBuilder.INSTANCE;
        localObject8 = SearchSchoolBuilder.build(paramDataReader);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchGroup", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = SearchGroupBuilder.INSTANCE;
        localObject7 = SearchGroupBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SearchArticle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = SearchArticleBuilder.INSTANCE;
        localObject6 = SearchArticleBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.SecondaryResultContainer", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = SecondaryResultContainerBuilder.INSTANCE;
        localObject5 = SecondaryResultContainerBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.FacetSuggestion", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = FacetSuggestionBuilder.INSTANCE;
        localObject4 = FacetSuggestionBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.Paywall", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = PaywallBuilder.INSTANCE;
        localObject3 = PaywallBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.Update", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UpdateBuilder.INSTANCE;
        localObject2 = UpdateBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.BlurredHit", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = BlurredHitBuilder.INSTANCE;
        localObject1 = BlurredHitBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int j = 0;
    if (bool12) {
      j = 1;
    }
    int i = j;
    if (bool11)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .HitInfo");
      }
      i = 1;
    }
    j = i;
    if (bool10)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .HitInfo");
      }
      j = 1;
    }
    i = j;
    if (bool9)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .HitInfo");
      }
      i = 1;
    }
    j = i;
    if (bool8)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .HitInfo");
      }
      j = 1;
    }
    i = j;
    if (bool7)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .HitInfo");
      }
      i = 1;
    }
    j = i;
    if (bool6)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .HitInfo");
      }
      j = 1;
    }
    i = j;
    if (bool5)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .HitInfo");
      }
      i = 1;
    }
    j = i;
    if (bool4)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .HitInfo");
      }
      j = 1;
    }
    i = j;
    if (bool3)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .HitInfo");
      }
      i = 1;
    }
    j = i;
    if (bool2)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .HitInfo");
      }
      j = 1;
    }
    if ((bool1) && (j != 0)) {
      throw new DataReaderException("Found more than 1 member when building .HitInfo");
    }
    return new SearchHit.HitInfo((SearchProfile)localObject12, (SearchJob)localObject11, (SearchJobJserp)localObject10, (SearchCompany)localObject9, (SearchSchool)localObject8, (SearchGroup)localObject7, (SearchArticle)localObject6, (SecondaryResultContainer)localObject5, (FacetSuggestion)localObject4, (Paywall)localObject3, (Update)localObject2, (BlurredHit)localObject1, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static SearchHit.HitInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SearchHit.HitInfo");
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
          localObject12 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchHit.HitInfo");
    }
    Object localObject12 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchHit.HitInfo");
    }
    if (((ByteBuffer)localObject12).getInt() != -525787340)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject12);
      throw new IOException("UID mismatch. Can't read cached data when building SearchHit.HitInfo");
    }
    paramString = null;
    SearchProfileBuilder localSearchProfileBuilder = null;
    localObject1 = null;
    SearchJobBuilder localSearchJobBuilder = null;
    Object localObject2 = null;
    SearchJobJserpBuilder localSearchJobJserpBuilder = null;
    Object localObject3 = null;
    SearchCompanyBuilder localSearchCompanyBuilder = null;
    Object localObject4 = null;
    SearchSchoolBuilder localSearchSchoolBuilder = null;
    Object localObject5 = null;
    SearchGroupBuilder localSearchGroupBuilder = null;
    Object localObject6 = null;
    SearchArticleBuilder localSearchArticleBuilder = null;
    Object localObject7 = null;
    SecondaryResultContainerBuilder localSecondaryResultContainerBuilder = null;
    Object localObject8 = null;
    FacetSuggestionBuilder localFacetSuggestionBuilder = null;
    Object localObject9 = null;
    PaywallBuilder localPaywallBuilder = null;
    Object localObject10 = null;
    UpdateBuilder localUpdateBuilder = null;
    Object localObject11 = null;
    BlurredHitBuilder localBlurredHitBuilder = null;
    boolean bool2;
    boolean bool1;
    label337:
    label363:
    boolean bool3;
    label375:
    label437:
    label466:
    boolean bool4;
    label478:
    label540:
    label569:
    boolean bool5;
    label581:
    label643:
    label672:
    boolean bool6;
    label684:
    label746:
    label775:
    boolean bool7;
    label787:
    label849:
    label878:
    boolean bool8;
    label890:
    label952:
    label981:
    boolean bool9;
    label993:
    label1055:
    label1084:
    boolean bool10;
    label1096:
    label1158:
    label1187:
    boolean bool11;
    label1199:
    label1261:
    label1290:
    boolean bool12;
    if (((ByteBuffer)localObject12).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject12).get();
        paramString = localSearchProfileBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject12);
          localSearchProfileBuilder = SearchProfileBuilder.INSTANCE;
          paramString = SearchProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label1550;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = SearchProfileBuilder.INSTANCE;
          paramString = SearchProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject12, null, paramFissionTransaction);
          if (paramString == null) {
            break label1556;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject12).get() != 1) {
        break label1562;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject12).get();
        localObject1 = localSearchJobBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject12);
          localSearchJobBuilder = SearchJobBuilder.INSTANCE;
          localObject1 = SearchJobBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label1568;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = SearchJobBuilder.INSTANCE;
          localObject1 = SearchJobBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject12, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label1574;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject12).get() != 1) {
        break label1580;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject12).get();
        localObject2 = localSearchJobJserpBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject12);
          localSearchJobJserpBuilder = SearchJobJserpBuilder.INSTANCE;
          localObject2 = SearchJobJserpBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1586;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = SearchJobJserpBuilder.INSTANCE;
          localObject2 = SearchJobJserpBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject12, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1592;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject12).get() != 1) {
        break label1598;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject12).get();
        localObject3 = localSearchCompanyBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject12);
          localSearchCompanyBuilder = SearchCompanyBuilder.INSTANCE;
          localObject3 = SearchCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1604;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject3 = SearchCompanyBuilder.INSTANCE;
          localObject3 = SearchCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject12, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1610;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject12).get() != 1) {
        break label1616;
      }
      bool6 = true;
      bool5 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject12).get();
        localObject4 = localSearchSchoolBuilder;
        bool5 = bool6;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject12);
          localSearchSchoolBuilder = SearchSchoolBuilder.INSTANCE;
          localObject4 = SearchSchoolBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1622;
          }
          bool5 = true;
        }
        if (i == 1)
        {
          localObject4 = SearchSchoolBuilder.INSTANCE;
          localObject4 = SearchSchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject12, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1628;
          }
          bool5 = true;
        }
      }
      if (((ByteBuffer)localObject12).get() != 1) {
        break label1634;
      }
      bool7 = true;
      bool6 = bool7;
      if (bool7)
      {
        i = ((ByteBuffer)localObject12).get();
        localObject5 = localSearchGroupBuilder;
        bool6 = bool7;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject12);
          localSearchGroupBuilder = SearchGroupBuilder.INSTANCE;
          localObject5 = SearchGroupBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label1640;
          }
          bool6 = true;
        }
        if (i == 1)
        {
          localObject5 = SearchGroupBuilder.INSTANCE;
          localObject5 = SearchGroupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject12, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label1646;
          }
          bool6 = true;
        }
      }
      if (((ByteBuffer)localObject12).get() != 1) {
        break label1652;
      }
      bool8 = true;
      bool7 = bool8;
      if (bool8)
      {
        i = ((ByteBuffer)localObject12).get();
        localObject6 = localSearchArticleBuilder;
        bool7 = bool8;
        if (i == 0)
        {
          localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject12);
          localSearchArticleBuilder = SearchArticleBuilder.INSTANCE;
          localObject6 = SearchArticleBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
          if (localObject6 == null) {
            break label1658;
          }
          bool7 = true;
        }
        if (i == 1)
        {
          localObject6 = SearchArticleBuilder.INSTANCE;
          localObject6 = SearchArticleBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject12, null, paramFissionTransaction);
          if (localObject6 == null) {
            break label1664;
          }
          bool7 = true;
        }
      }
      if (((ByteBuffer)localObject12).get() != 1) {
        break label1670;
      }
      bool9 = true;
      bool8 = bool9;
      if (bool9)
      {
        i = ((ByteBuffer)localObject12).get();
        localObject7 = localSecondaryResultContainerBuilder;
        bool8 = bool9;
        if (i == 0)
        {
          localObject7 = paramFissionAdapter.readString((ByteBuffer)localObject12);
          localSecondaryResultContainerBuilder = SecondaryResultContainerBuilder.INSTANCE;
          localObject7 = SecondaryResultContainerBuilder.readFromFission(paramFissionAdapter, null, (String)localObject7, paramFissionTransaction);
          if (localObject7 == null) {
            break label1676;
          }
          bool8 = true;
        }
        if (i == 1)
        {
          localObject7 = SecondaryResultContainerBuilder.INSTANCE;
          localObject7 = SecondaryResultContainerBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject12, null, paramFissionTransaction);
          if (localObject7 == null) {
            break label1682;
          }
          bool8 = true;
        }
      }
      if (((ByteBuffer)localObject12).get() != 1) {
        break label1688;
      }
      bool10 = true;
      bool9 = bool10;
      if (bool10)
      {
        i = ((ByteBuffer)localObject12).get();
        localObject8 = localFacetSuggestionBuilder;
        bool9 = bool10;
        if (i == 0)
        {
          localObject8 = paramFissionAdapter.readString((ByteBuffer)localObject12);
          localFacetSuggestionBuilder = FacetSuggestionBuilder.INSTANCE;
          localObject8 = FacetSuggestionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject8, paramFissionTransaction);
          if (localObject8 == null) {
            break label1694;
          }
          bool9 = true;
        }
        if (i == 1)
        {
          localObject8 = FacetSuggestionBuilder.INSTANCE;
          localObject8 = FacetSuggestionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject12, null, paramFissionTransaction);
          if (localObject8 == null) {
            break label1700;
          }
          bool9 = true;
        }
      }
      if (((ByteBuffer)localObject12).get() != 1) {
        break label1706;
      }
      bool11 = true;
      bool10 = bool11;
      if (bool11)
      {
        i = ((ByteBuffer)localObject12).get();
        localObject9 = localPaywallBuilder;
        bool10 = bool11;
        if (i == 0)
        {
          localObject9 = paramFissionAdapter.readString((ByteBuffer)localObject12);
          localPaywallBuilder = PaywallBuilder.INSTANCE;
          localObject9 = PaywallBuilder.readFromFission(paramFissionAdapter, null, (String)localObject9, paramFissionTransaction);
          if (localObject9 == null) {
            break label1712;
          }
          bool10 = true;
        }
        if (i == 1)
        {
          localObject9 = PaywallBuilder.INSTANCE;
          localObject9 = PaywallBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject12, null, paramFissionTransaction);
          if (localObject9 == null) {
            break label1718;
          }
          bool10 = true;
        }
      }
      if (((ByteBuffer)localObject12).get() != 1) {
        break label1724;
      }
      bool12 = true;
      label1302:
      bool11 = bool12;
      if (bool12)
      {
        i = ((ByteBuffer)localObject12).get();
        localObject10 = localUpdateBuilder;
        bool11 = bool12;
        if (i == 0)
        {
          localObject10 = paramFissionAdapter.readString((ByteBuffer)localObject12);
          localUpdateBuilder = UpdateBuilder.INSTANCE;
          localObject10 = UpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject10, paramFissionTransaction);
          if (localObject10 == null) {
            break label1730;
          }
          bool11 = true;
        }
        label1364:
        if (i == 1)
        {
          localObject10 = UpdateBuilder.INSTANCE;
          localObject10 = UpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject12, null, paramFissionTransaction);
          if (localObject10 == null) {
            break label1736;
          }
          bool11 = true;
        }
      }
      label1393:
      if (((ByteBuffer)localObject12).get() != 1) {
        break label1742;
      }
      bool12 = true;
      label1405:
      bool13 = bool12;
      if (bool12)
      {
        i = ((ByteBuffer)localObject12).get();
        localObject11 = localBlurredHitBuilder;
        if (i == 0)
        {
          localObject11 = paramFissionAdapter.readString((ByteBuffer)localObject12);
          localBlurredHitBuilder = BlurredHitBuilder.INSTANCE;
          localObject11 = BlurredHitBuilder.readFromFission(paramFissionAdapter, null, (String)localObject11, paramFissionTransaction);
          if (localObject11 == null) {
            break label1748;
          }
          bool12 = true;
        }
        label1463:
        bool13 = bool12;
        if (i == 1)
        {
          localObject11 = BlurredHitBuilder.INSTANCE;
          localObject11 = BlurredHitBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject12, null, paramFissionTransaction);
          if (localObject11 == null) {
            break label1754;
          }
        }
      }
    }
    label1550:
    label1556:
    label1562:
    label1568:
    label1574:
    label1580:
    label1586:
    label1592:
    label1598:
    label1604:
    label1610:
    label1616:
    label1622:
    label1628:
    label1634:
    label1640:
    label1646:
    label1652:
    label1658:
    label1664:
    label1670:
    label1676:
    label1682:
    label1688:
    label1694:
    label1700:
    label1706:
    label1712:
    label1718:
    label1724:
    label1730:
    label1736:
    label1742:
    label1748:
    label1754:
    for (boolean bool13 = true;; bool13 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject12);
      }
      j = 0;
      if (bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        break label1763;
      }
      if (j == 0) {
        break label1760;
      }
      throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label337;
      bool1 = false;
      break label363;
      bool3 = false;
      break label375;
      bool2 = false;
      break label437;
      bool2 = false;
      break label466;
      bool4 = false;
      break label478;
      bool3 = false;
      break label540;
      bool3 = false;
      break label569;
      bool5 = false;
      break label581;
      bool4 = false;
      break label643;
      bool4 = false;
      break label672;
      bool6 = false;
      break label684;
      bool5 = false;
      break label746;
      bool5 = false;
      break label775;
      bool7 = false;
      break label787;
      bool6 = false;
      break label849;
      bool6 = false;
      break label878;
      bool8 = false;
      break label890;
      bool7 = false;
      break label952;
      bool7 = false;
      break label981;
      bool9 = false;
      break label993;
      bool8 = false;
      break label1055;
      bool8 = false;
      break label1084;
      bool10 = false;
      break label1096;
      bool9 = false;
      break label1158;
      bool9 = false;
      break label1187;
      bool11 = false;
      break label1199;
      bool10 = false;
      break label1261;
      bool10 = false;
      break label1290;
      bool12 = false;
      break label1302;
      bool11 = false;
      break label1364;
      bool11 = false;
      break label1393;
      bool12 = false;
      break label1405;
      bool12 = false;
      break label1463;
    }
    label1760:
    int i = 1;
    label1763:
    int j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool5)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool6)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool7)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool8)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool9)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool10)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool11)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
      }
      j = 1;
    }
    if ((bool13) && (j != 0)) {
      throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
    }
    return new SearchHit.HitInfo(paramString, (SearchJob)localObject1, (SearchJobJserp)localObject2, (SearchCompany)localObject3, (SearchSchool)localObject4, (SearchGroup)localObject5, (SearchArticle)localObject6, (SecondaryResultContainer)localObject7, (FacetSuggestion)localObject8, (Paywall)localObject9, (Update)localObject10, (BlurredHit)localObject11, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool13);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHitBuilder.HitInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */