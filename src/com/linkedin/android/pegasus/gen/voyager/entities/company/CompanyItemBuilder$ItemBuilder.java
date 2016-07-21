package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.android.pegasus.gen.voyager.entities.common.DescriptionBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniJobsCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniJobsCollectionBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniProfilesCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniProfilesCollectionBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollectionBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompanyCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompanyCollectionBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPersonCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPersonCollectionBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchoolCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchoolCollectionBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CompanyItemBuilder$ItemBuilder
  implements FissileDataModelBuilder<CompanyItem.Item>, DataTemplateBuilder<CompanyItem.Item>
{
  public static final ItemBuilder INSTANCE = new ItemBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.entities.company.CompanyDetails");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.company.Showcases");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.company.SimilarCompanies");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.company.CareerAbout");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.company.CareerAbout2");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.company.CareerTitles");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.company.CareerEmployeeQuotes");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.company.CareerResources");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.common.Description");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.common.MiniJobsCollection");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.common.MiniProfilesCollection");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.common.UpdateCollection");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.incommon.InCommonCompanyCollection");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.incommon.InCommonPersonCollection");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.incommon.InCommonSchoolCollection");
  }
  
  public static CompanyItem.Item build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject15 = null;
    Object localObject14 = null;
    Object localObject13 = null;
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
    boolean bool15 = false;
    boolean bool14 = false;
    boolean bool13 = false;
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
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.company.CompanyDetails", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject15 = CompanyDetailsBuilder.INSTANCE;
        localObject15 = CompanyDetailsBuilder.build(paramDataReader);
        bool15 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.company.Showcases", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject14 = ShowcasesBuilder.INSTANCE;
        localObject14 = ShowcasesBuilder.build(paramDataReader);
        bool14 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.company.SimilarCompanies", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject13 = SimilarCompaniesBuilder.INSTANCE;
        localObject13 = SimilarCompaniesBuilder.build(paramDataReader);
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.company.CareerAbout", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject12 = CareerAboutBuilder.INSTANCE;
        localObject12 = CareerAboutBuilder.build(paramDataReader);
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.company.CareerAbout2", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject11 = CareerAbout2Builder.INSTANCE;
        localObject11 = CareerAbout2Builder.build(paramDataReader);
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.company.CareerTitles", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject10 = CareerTitlesBuilder.INSTANCE;
        localObject10 = CareerTitlesBuilder.build(paramDataReader);
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.company.CareerEmployeeQuotes", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject9 = CareerEmployeeQuotesBuilder.INSTANCE;
        localObject9 = CareerEmployeeQuotesBuilder.build(paramDataReader);
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.company.CareerResources", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject8 = CareerResourcesBuilder.INSTANCE;
        localObject8 = CareerResourcesBuilder.build(paramDataReader);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.common.Description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = DescriptionBuilder.INSTANCE;
        localObject7 = DescriptionBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.common.MiniJobsCollection", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = MiniJobsCollectionBuilder.INSTANCE;
        localObject6 = MiniJobsCollectionBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.common.MiniProfilesCollection", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = MiniProfilesCollectionBuilder.INSTANCE;
        localObject5 = MiniProfilesCollectionBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.common.UpdateCollection", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = UpdateCollectionBuilder.INSTANCE;
        localObject4 = UpdateCollectionBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.incommon.InCommonCompanyCollection", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = InCommonCompanyCollectionBuilder.INSTANCE;
        localObject3 = InCommonCompanyCollectionBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.incommon.InCommonPersonCollection", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = InCommonPersonCollectionBuilder.INSTANCE;
        localObject2 = InCommonPersonCollectionBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.incommon.InCommonSchoolCollection", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = InCommonSchoolCollectionBuilder.INSTANCE;
        localObject1 = InCommonSchoolCollectionBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int j = 0;
    if (bool15) {
      j = 1;
    }
    int i = j;
    if (bool14)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool13)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool12)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool11)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool10)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool9)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool8)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool7)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool6)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool5)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool2)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    if ((bool1) && (i != 0)) {
      throw new DataReaderException("Found more than 1 member when building .Item");
    }
    return new CompanyItem.Item((CompanyDetails)localObject15, (Showcases)localObject14, (SimilarCompanies)localObject13, (CareerAbout)localObject12, (CareerAbout2)localObject11, (CareerTitles)localObject10, (CareerEmployeeQuotes)localObject9, (CareerResources)localObject8, (Description)localObject7, (MiniJobsCollection)localObject6, (MiniProfilesCollection)localObject5, (UpdateCollection)localObject4, (InCommonCompanyCollection)localObject3, (InCommonPersonCollection)localObject2, (InCommonSchoolCollection)localObject1, bool15, bool14, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static CompanyItem.Item readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CompanyItem.Item");
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
          localObject15 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building CompanyItem.Item");
    }
    Object localObject15 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building CompanyItem.Item");
    }
    if (((ByteBuffer)localObject15).getInt() != 1208799589)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject15);
      throw new IOException("UID mismatch. Can't read cached data when building CompanyItem.Item");
    }
    paramString = null;
    CompanyDetailsBuilder localCompanyDetailsBuilder = null;
    localObject1 = null;
    ShowcasesBuilder localShowcasesBuilder = null;
    Object localObject2 = null;
    SimilarCompaniesBuilder localSimilarCompaniesBuilder = null;
    Object localObject3 = null;
    CareerAboutBuilder localCareerAboutBuilder = null;
    Object localObject4 = null;
    CareerAbout2Builder localCareerAbout2Builder = null;
    Object localObject5 = null;
    CareerTitlesBuilder localCareerTitlesBuilder = null;
    Object localObject6 = null;
    CareerEmployeeQuotesBuilder localCareerEmployeeQuotesBuilder = null;
    Object localObject7 = null;
    CareerResourcesBuilder localCareerResourcesBuilder = null;
    Object localObject8 = null;
    DescriptionBuilder localDescriptionBuilder = null;
    Object localObject9 = null;
    MiniJobsCollectionBuilder localMiniJobsCollectionBuilder = null;
    Object localObject10 = null;
    MiniProfilesCollectionBuilder localMiniProfilesCollectionBuilder = null;
    Object localObject11 = null;
    UpdateCollectionBuilder localUpdateCollectionBuilder = null;
    Object localObject12 = null;
    InCommonCompanyCollectionBuilder localInCommonCompanyCollectionBuilder = null;
    Object localObject13 = null;
    InCommonPersonCollectionBuilder localInCommonPersonCollectionBuilder = null;
    Object localObject14 = null;
    InCommonSchoolCollectionBuilder localInCommonSchoolCollectionBuilder = null;
    boolean bool2;
    boolean bool1;
    label355:
    label381:
    boolean bool3;
    label393:
    label455:
    label484:
    boolean bool4;
    label496:
    label558:
    label587:
    boolean bool5;
    label599:
    label661:
    label690:
    boolean bool6;
    label702:
    label764:
    label793:
    boolean bool7;
    label805:
    label867:
    label896:
    boolean bool8;
    label908:
    label970:
    label999:
    boolean bool9;
    label1011:
    label1073:
    label1102:
    boolean bool10;
    label1114:
    label1176:
    label1205:
    boolean bool11;
    label1217:
    label1279:
    label1308:
    boolean bool12;
    label1320:
    label1382:
    label1411:
    boolean bool13;
    label1423:
    label1485:
    label1514:
    boolean bool14;
    label1526:
    label1588:
    label1617:
    boolean bool15;
    if (((ByteBuffer)localObject15).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject15).get();
        paramString = localCompanyDetailsBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localCompanyDetailsBuilder = CompanyDetailsBuilder.INSTANCE;
          paramString = CompanyDetailsBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label1877;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = CompanyDetailsBuilder.INSTANCE;
          paramString = CompanyDetailsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (paramString == null) {
            break label1883;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject15).get() != 1) {
        break label1889;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject15).get();
        localObject1 = localShowcasesBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localShowcasesBuilder = ShowcasesBuilder.INSTANCE;
          localObject1 = ShowcasesBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label1895;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = ShowcasesBuilder.INSTANCE;
          localObject1 = ShowcasesBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label1901;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject15).get() != 1) {
        break label1907;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject15).get();
        localObject2 = localSimilarCompaniesBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localSimilarCompaniesBuilder = SimilarCompaniesBuilder.INSTANCE;
          localObject2 = SimilarCompaniesBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1913;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = SimilarCompaniesBuilder.INSTANCE;
          localObject2 = SimilarCompaniesBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1919;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject15).get() != 1) {
        break label1925;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject15).get();
        localObject3 = localCareerAboutBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localCareerAboutBuilder = CareerAboutBuilder.INSTANCE;
          localObject3 = CareerAboutBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1931;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject3 = CareerAboutBuilder.INSTANCE;
          localObject3 = CareerAboutBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1937;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject15).get() != 1) {
        break label1943;
      }
      bool6 = true;
      bool5 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject15).get();
        localObject4 = localCareerAbout2Builder;
        bool5 = bool6;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localCareerAbout2Builder = CareerAbout2Builder.INSTANCE;
          localObject4 = CareerAbout2Builder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1949;
          }
          bool5 = true;
        }
        if (i == 1)
        {
          localObject4 = CareerAbout2Builder.INSTANCE;
          localObject4 = CareerAbout2Builder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1955;
          }
          bool5 = true;
        }
      }
      if (((ByteBuffer)localObject15).get() != 1) {
        break label1961;
      }
      bool7 = true;
      bool6 = bool7;
      if (bool7)
      {
        i = ((ByteBuffer)localObject15).get();
        localObject5 = localCareerTitlesBuilder;
        bool6 = bool7;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localCareerTitlesBuilder = CareerTitlesBuilder.INSTANCE;
          localObject5 = CareerTitlesBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label1967;
          }
          bool6 = true;
        }
        if (i == 1)
        {
          localObject5 = CareerTitlesBuilder.INSTANCE;
          localObject5 = CareerTitlesBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label1973;
          }
          bool6 = true;
        }
      }
      if (((ByteBuffer)localObject15).get() != 1) {
        break label1979;
      }
      bool8 = true;
      bool7 = bool8;
      if (bool8)
      {
        i = ((ByteBuffer)localObject15).get();
        localObject6 = localCareerEmployeeQuotesBuilder;
        bool7 = bool8;
        if (i == 0)
        {
          localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localCareerEmployeeQuotesBuilder = CareerEmployeeQuotesBuilder.INSTANCE;
          localObject6 = CareerEmployeeQuotesBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
          if (localObject6 == null) {
            break label1985;
          }
          bool7 = true;
        }
        if (i == 1)
        {
          localObject6 = CareerEmployeeQuotesBuilder.INSTANCE;
          localObject6 = CareerEmployeeQuotesBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (localObject6 == null) {
            break label1991;
          }
          bool7 = true;
        }
      }
      if (((ByteBuffer)localObject15).get() != 1) {
        break label1997;
      }
      bool9 = true;
      bool8 = bool9;
      if (bool9)
      {
        i = ((ByteBuffer)localObject15).get();
        localObject7 = localCareerResourcesBuilder;
        bool8 = bool9;
        if (i == 0)
        {
          localObject7 = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localCareerResourcesBuilder = CareerResourcesBuilder.INSTANCE;
          localObject7 = CareerResourcesBuilder.readFromFission(paramFissionAdapter, null, (String)localObject7, paramFissionTransaction);
          if (localObject7 == null) {
            break label2003;
          }
          bool8 = true;
        }
        if (i == 1)
        {
          localObject7 = CareerResourcesBuilder.INSTANCE;
          localObject7 = CareerResourcesBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (localObject7 == null) {
            break label2009;
          }
          bool8 = true;
        }
      }
      if (((ByteBuffer)localObject15).get() != 1) {
        break label2015;
      }
      bool10 = true;
      bool9 = bool10;
      if (bool10)
      {
        i = ((ByteBuffer)localObject15).get();
        localObject8 = localDescriptionBuilder;
        bool9 = bool10;
        if (i == 0)
        {
          localObject8 = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localDescriptionBuilder = DescriptionBuilder.INSTANCE;
          localObject8 = DescriptionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject8, paramFissionTransaction);
          if (localObject8 == null) {
            break label2021;
          }
          bool9 = true;
        }
        if (i == 1)
        {
          localObject8 = DescriptionBuilder.INSTANCE;
          localObject8 = DescriptionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (localObject8 == null) {
            break label2027;
          }
          bool9 = true;
        }
      }
      if (((ByteBuffer)localObject15).get() != 1) {
        break label2033;
      }
      bool11 = true;
      bool10 = bool11;
      if (bool11)
      {
        i = ((ByteBuffer)localObject15).get();
        localObject9 = localMiniJobsCollectionBuilder;
        bool10 = bool11;
        if (i == 0)
        {
          localObject9 = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localMiniJobsCollectionBuilder = MiniJobsCollectionBuilder.INSTANCE;
          localObject9 = MiniJobsCollectionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject9, paramFissionTransaction);
          if (localObject9 == null) {
            break label2039;
          }
          bool10 = true;
        }
        if (i == 1)
        {
          localObject9 = MiniJobsCollectionBuilder.INSTANCE;
          localObject9 = MiniJobsCollectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (localObject9 == null) {
            break label2045;
          }
          bool10 = true;
        }
      }
      if (((ByteBuffer)localObject15).get() != 1) {
        break label2051;
      }
      bool12 = true;
      bool11 = bool12;
      if (bool12)
      {
        i = ((ByteBuffer)localObject15).get();
        localObject10 = localMiniProfilesCollectionBuilder;
        bool11 = bool12;
        if (i == 0)
        {
          localObject10 = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localMiniProfilesCollectionBuilder = MiniProfilesCollectionBuilder.INSTANCE;
          localObject10 = MiniProfilesCollectionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject10, paramFissionTransaction);
          if (localObject10 == null) {
            break label2057;
          }
          bool11 = true;
        }
        if (i == 1)
        {
          localObject10 = MiniProfilesCollectionBuilder.INSTANCE;
          localObject10 = MiniProfilesCollectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (localObject10 == null) {
            break label2063;
          }
          bool11 = true;
        }
      }
      if (((ByteBuffer)localObject15).get() != 1) {
        break label2069;
      }
      bool13 = true;
      bool12 = bool13;
      if (bool13)
      {
        i = ((ByteBuffer)localObject15).get();
        localObject11 = localUpdateCollectionBuilder;
        bool12 = bool13;
        if (i == 0)
        {
          localObject11 = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localUpdateCollectionBuilder = UpdateCollectionBuilder.INSTANCE;
          localObject11 = UpdateCollectionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject11, paramFissionTransaction);
          if (localObject11 == null) {
            break label2075;
          }
          bool12 = true;
        }
        if (i == 1)
        {
          localObject11 = UpdateCollectionBuilder.INSTANCE;
          localObject11 = UpdateCollectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (localObject11 == null) {
            break label2081;
          }
          bool12 = true;
        }
      }
      if (((ByteBuffer)localObject15).get() != 1) {
        break label2087;
      }
      bool14 = true;
      bool13 = bool14;
      if (bool14)
      {
        i = ((ByteBuffer)localObject15).get();
        localObject12 = localInCommonCompanyCollectionBuilder;
        bool13 = bool14;
        if (i == 0)
        {
          localObject12 = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localInCommonCompanyCollectionBuilder = InCommonCompanyCollectionBuilder.INSTANCE;
          localObject12 = InCommonCompanyCollectionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject12, paramFissionTransaction);
          if (localObject12 == null) {
            break label2093;
          }
          bool13 = true;
        }
        if (i == 1)
        {
          localObject12 = InCommonCompanyCollectionBuilder.INSTANCE;
          localObject12 = InCommonCompanyCollectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (localObject12 == null) {
            break label2099;
          }
          bool13 = true;
        }
      }
      if (((ByteBuffer)localObject15).get() != 1) {
        break label2105;
      }
      bool15 = true;
      label1629:
      bool14 = bool15;
      if (bool15)
      {
        i = ((ByteBuffer)localObject15).get();
        localObject13 = localInCommonPersonCollectionBuilder;
        bool14 = bool15;
        if (i == 0)
        {
          localObject13 = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localInCommonPersonCollectionBuilder = InCommonPersonCollectionBuilder.INSTANCE;
          localObject13 = InCommonPersonCollectionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject13, paramFissionTransaction);
          if (localObject13 == null) {
            break label2111;
          }
          bool14 = true;
        }
        label1691:
        if (i == 1)
        {
          localObject13 = InCommonPersonCollectionBuilder.INSTANCE;
          localObject13 = InCommonPersonCollectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (localObject13 == null) {
            break label2117;
          }
          bool14 = true;
        }
      }
      label1720:
      if (((ByteBuffer)localObject15).get() != 1) {
        break label2123;
      }
      bool15 = true;
      label1732:
      bool16 = bool15;
      if (bool15)
      {
        i = ((ByteBuffer)localObject15).get();
        localObject14 = localInCommonSchoolCollectionBuilder;
        if (i == 0)
        {
          localObject14 = paramFissionAdapter.readString((ByteBuffer)localObject15);
          localInCommonSchoolCollectionBuilder = InCommonSchoolCollectionBuilder.INSTANCE;
          localObject14 = InCommonSchoolCollectionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject14, paramFissionTransaction);
          if (localObject14 == null) {
            break label2129;
          }
          bool15 = true;
        }
        label1790:
        bool16 = bool15;
        if (i == 1)
        {
          localObject14 = InCommonSchoolCollectionBuilder.INSTANCE;
          localObject14 = InCommonSchoolCollectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject15, null, paramFissionTransaction);
          if (localObject14 == null) {
            break label2135;
          }
        }
      }
    }
    label1877:
    label1883:
    label1889:
    label1895:
    label1901:
    label1907:
    label1913:
    label1919:
    label1925:
    label1931:
    label1937:
    label1943:
    label1949:
    label1955:
    label1961:
    label1967:
    label1973:
    label1979:
    label1985:
    label1991:
    label1997:
    label2003:
    label2009:
    label2015:
    label2021:
    label2027:
    label2033:
    label2039:
    label2045:
    label2051:
    label2057:
    label2063:
    label2069:
    label2075:
    label2081:
    label2087:
    label2093:
    label2099:
    label2105:
    label2111:
    label2117:
    label2123:
    label2129:
    label2135:
    for (boolean bool16 = true;; bool16 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject15);
      }
      j = 0;
      if (bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        break label2144;
      }
      if (j == 0) {
        break label2141;
      }
      throw new IOException("Found more than 1 member when reading .Item from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label355;
      bool1 = false;
      break label381;
      bool3 = false;
      break label393;
      bool2 = false;
      break label455;
      bool2 = false;
      break label484;
      bool4 = false;
      break label496;
      bool3 = false;
      break label558;
      bool3 = false;
      break label587;
      bool5 = false;
      break label599;
      bool4 = false;
      break label661;
      bool4 = false;
      break label690;
      bool6 = false;
      break label702;
      bool5 = false;
      break label764;
      bool5 = false;
      break label793;
      bool7 = false;
      break label805;
      bool6 = false;
      break label867;
      bool6 = false;
      break label896;
      bool8 = false;
      break label908;
      bool7 = false;
      break label970;
      bool7 = false;
      break label999;
      bool9 = false;
      break label1011;
      bool8 = false;
      break label1073;
      bool8 = false;
      break label1102;
      bool10 = false;
      break label1114;
      bool9 = false;
      break label1176;
      bool9 = false;
      break label1205;
      bool11 = false;
      break label1217;
      bool10 = false;
      break label1279;
      bool10 = false;
      break label1308;
      bool12 = false;
      break label1320;
      bool11 = false;
      break label1382;
      bool11 = false;
      break label1411;
      bool13 = false;
      break label1423;
      bool12 = false;
      break label1485;
      bool12 = false;
      break label1514;
      bool14 = false;
      break label1526;
      bool13 = false;
      break label1588;
      bool13 = false;
      break label1617;
      bool15 = false;
      break label1629;
      bool14 = false;
      break label1691;
      bool14 = false;
      break label1720;
      bool15 = false;
      break label1732;
      bool15 = false;
      break label1790;
    }
    label2141:
    int i = 1;
    label2144:
    int j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool5)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool6)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool7)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool8)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool9)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool10)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool11)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool12)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool13)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool14)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    if ((bool16) && (i != 0)) {
      throw new IOException("Found more than 1 member when reading .Item from fission.");
    }
    return new CompanyItem.Item(paramString, (Showcases)localObject1, (SimilarCompanies)localObject2, (CareerAbout)localObject3, (CareerAbout2)localObject4, (CareerTitles)localObject5, (CareerEmployeeQuotes)localObject6, (CareerResources)localObject7, (Description)localObject8, (MiniJobsCollection)localObject9, (MiniProfilesCollection)localObject10, (UpdateCollection)localObject11, (InCommonCompanyCollection)localObject12, (InCommonPersonCollection)localObject13, (InCommonSchoolCollection)localObject14, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool16);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItemBuilder.ItemBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */