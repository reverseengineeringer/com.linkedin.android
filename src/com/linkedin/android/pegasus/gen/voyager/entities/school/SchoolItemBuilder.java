package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.android.pegasus.gen.voyager.entities.common.DescriptionBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfoBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniProfilesCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniProfilesCollectionBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SchoolItemBuilder
  implements FissileDataModelBuilder<SchoolItem>, DataTemplateBuilder<SchoolItem>
{
  public static final SchoolItemBuilder INSTANCE = new SchoolItemBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("itemInfo");
    JSON_KEY_STORE.put("item");
  }
  
  public static SchoolItem build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("itemInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = ItemInfoBuilder.INSTANCE;
        localObject1 = ItemInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("item", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ItemBuilder.INSTANCE;
        localObject2 = ItemBuilder.build(paramDataReader);
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: itemInfo when building com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItem");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: item when building com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItem");
    }
    return new SchoolItem((ItemInfo)localObject1, (SchoolItem.Item)localObject2, bool1, bool2);
  }
  
  public static SchoolItem readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SchoolItem");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SchoolItem");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SchoolItem");
    }
    if (((ByteBuffer)localObject2).getInt() != -1749924402)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building SchoolItem");
    }
    paramString = null;
    ItemInfoBuilder localItemInfoBuilder = null;
    localObject1 = null;
    ItemBuilder localItemBuilder = null;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        bool1 = bool2;
        paramString = localItemInfoBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localItemInfoBuilder = ItemInfoBuilder.INSTANCE;
          paramString = ItemInfoBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label439;
          }
          bool1 = true;
        }
        label277:
        if (i == 1)
        {
          paramString = ItemInfoBuilder.INSTANCE;
          paramString = ItemInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label445;
          }
          bool1 = true;
        }
      }
      label303:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label451;
      }
      bool2 = true;
      label315:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localItemBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localItemBuilder = ItemBuilder.INSTANCE;
          localObject1 = ItemBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label457;
          }
          bool2 = true;
        }
        label373:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = ItemBuilder.INSTANCE;
          localObject1 = ItemBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label463;
          }
        }
      }
    }
    label439:
    label445:
    label451:
    label457:
    label463:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label469;
      }
      throw new IOException("Failed to find required field: itemInfo when reading com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItem from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label277;
      bool1 = false;
      break label303;
      bool2 = false;
      break label315;
      bool2 = false;
      break label373;
    }
    label469:
    if (!bool3) {
      throw new IOException("Failed to find required field: item when reading com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItem from fission.");
    }
    return new SchoolItem(paramString, (SchoolItem.Item)localObject1, bool1, bool3);
  }
  
  public static final class ItemBuilder
    implements FissileDataModelBuilder<SchoolItem.Item>, DataTemplateBuilder<SchoolItem.Item>
  {
    public static final ItemBuilder INSTANCE = new ItemBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.entities.school.NextSchoolsCollection");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.school.SchoolDetails");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.school.NotableAlumni");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.school.SchoolRankings");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.school.SchoolFacets");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.school.FinancialInformation");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.school.StudentsAndFaculty");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.school.AlumniCompaniesCollection");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.common.Description");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.common.MiniProfilesCollection");
    }
    
    public static SchoolItem.Item build(DataReader paramDataReader)
      throws DataReaderException
    {
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
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.school.NextSchoolsCollection", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject10 = NextSchoolsCollectionBuilder.INSTANCE;
          localObject10 = NextSchoolsCollectionBuilder.build(paramDataReader);
          bool10 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.school.SchoolDetails", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject9 = SchoolDetailsBuilder.INSTANCE;
          localObject9 = SchoolDetailsBuilder.build(paramDataReader);
          bool9 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.school.NotableAlumni", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject8 = NotableAlumniBuilder.INSTANCE;
          localObject8 = NotableAlumniBuilder.build(paramDataReader);
          bool8 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.school.SchoolRankings", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject7 = SchoolRankingsBuilder.INSTANCE;
          localObject7 = SchoolRankingsBuilder.build(paramDataReader);
          bool7 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.school.SchoolFacets", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject6 = SchoolFacetsBuilder.INSTANCE;
          localObject6 = SchoolFacetsBuilder.build(paramDataReader);
          bool6 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.school.FinancialInformation", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject5 = FinancialInformationBuilder.INSTANCE;
          localObject5 = FinancialInformationBuilder.build(paramDataReader);
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.school.StudentsAndFaculty", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = StudentsAndFacultyBuilder.INSTANCE;
          localObject4 = StudentsAndFacultyBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.school.AlumniCompaniesCollection", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = AlumniCompaniesCollectionBuilder.INSTANCE;
          localObject3 = AlumniCompaniesCollectionBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.common.Description", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = DescriptionBuilder.INSTANCE;
          localObject2 = DescriptionBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.common.MiniProfilesCollection", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = MiniProfilesCollectionBuilder.INSTANCE;
          localObject1 = MiniProfilesCollectionBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int j = 0;
      if (bool10) {
        j = 1;
      }
      int i = j;
      if (bool9)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Item");
        }
        i = 1;
      }
      j = i;
      if (bool8)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Item");
        }
        j = 1;
      }
      i = j;
      if (bool7)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Item");
        }
        i = 1;
      }
      j = i;
      if (bool6)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Item");
        }
        j = 1;
      }
      i = j;
      if (bool5)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Item");
        }
        i = 1;
      }
      j = i;
      if (bool4)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Item");
        }
        j = 1;
      }
      i = j;
      if (bool3)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Item");
        }
        i = 1;
      }
      j = i;
      if (bool2)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Item");
        }
        j = 1;
      }
      if ((bool1) && (j != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      return new SchoolItem.Item((NextSchoolsCollection)localObject10, (SchoolDetails)localObject9, (NotableAlumni)localObject8, (SchoolRankings)localObject7, (SchoolFacets)localObject6, (FinancialInformation)localObject5, (StudentsAndFaculty)localObject4, (AlumniCompaniesCollection)localObject3, (Description)localObject2, (MiniProfilesCollection)localObject1, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
    }
    
    public static SchoolItem.Item readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building SchoolItem.Item");
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
            localObject10 = paramString;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building SchoolItem.Item");
      }
      Object localObject10 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building SchoolItem.Item");
      }
      if (((ByteBuffer)localObject10).getInt() != 649662592)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject10);
        throw new IOException("UID mismatch. Can't read cached data when building SchoolItem.Item");
      }
      paramString = null;
      NextSchoolsCollectionBuilder localNextSchoolsCollectionBuilder = null;
      localObject1 = null;
      SchoolDetailsBuilder localSchoolDetailsBuilder = null;
      Object localObject2 = null;
      NotableAlumniBuilder localNotableAlumniBuilder = null;
      Object localObject3 = null;
      SchoolRankingsBuilder localSchoolRankingsBuilder = null;
      Object localObject4 = null;
      SchoolFacetsBuilder localSchoolFacetsBuilder = null;
      Object localObject5 = null;
      FinancialInformationBuilder localFinancialInformationBuilder = null;
      Object localObject6 = null;
      StudentsAndFacultyBuilder localStudentsAndFacultyBuilder = null;
      Object localObject7 = null;
      AlumniCompaniesCollectionBuilder localAlumniCompaniesCollectionBuilder = null;
      Object localObject8 = null;
      DescriptionBuilder localDescriptionBuilder = null;
      Object localObject9 = null;
      MiniProfilesCollectionBuilder localMiniProfilesCollectionBuilder = null;
      boolean bool2;
      boolean bool1;
      label325:
      label351:
      boolean bool3;
      label363:
      label425:
      label454:
      boolean bool4;
      label466:
      label528:
      label557:
      boolean bool5;
      label569:
      label631:
      label660:
      boolean bool6;
      label672:
      label734:
      label763:
      boolean bool7;
      label775:
      label837:
      label866:
      boolean bool8;
      label878:
      label940:
      label969:
      boolean bool9;
      label981:
      label1043:
      label1072:
      boolean bool10;
      if (((ByteBuffer)localObject10).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject10).get();
          paramString = localNextSchoolsCollectionBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject10);
            localNextSchoolsCollectionBuilder = NextSchoolsCollectionBuilder.INSTANCE;
            paramString = NextSchoolsCollectionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label1331;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = NextSchoolsCollectionBuilder.INSTANCE;
            paramString = NextSchoolsCollectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject10, null, paramFissionTransaction);
            if (paramString == null) {
              break label1337;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject10).get() != 1) {
          break label1343;
        }
        bool3 = true;
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject10).get();
          localObject1 = localSchoolDetailsBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject10);
            localSchoolDetailsBuilder = SchoolDetailsBuilder.INSTANCE;
            localObject1 = SchoolDetailsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label1349;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = SchoolDetailsBuilder.INSTANCE;
            localObject1 = SchoolDetailsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject10, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label1355;
            }
            bool2 = true;
          }
        }
        if (((ByteBuffer)localObject10).get() != 1) {
          break label1361;
        }
        bool4 = true;
        bool3 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject10).get();
          localObject2 = localNotableAlumniBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject10);
            localNotableAlumniBuilder = NotableAlumniBuilder.INSTANCE;
            localObject2 = NotableAlumniBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label1367;
            }
            bool3 = true;
          }
          if (i == 1)
          {
            localObject2 = NotableAlumniBuilder.INSTANCE;
            localObject2 = NotableAlumniBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject10, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label1373;
            }
            bool3 = true;
          }
        }
        if (((ByteBuffer)localObject10).get() != 1) {
          break label1379;
        }
        bool5 = true;
        bool4 = bool5;
        if (bool5)
        {
          i = ((ByteBuffer)localObject10).get();
          localObject3 = localSchoolRankingsBuilder;
          bool4 = bool5;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject10);
            localSchoolRankingsBuilder = SchoolRankingsBuilder.INSTANCE;
            localObject3 = SchoolRankingsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label1385;
            }
            bool4 = true;
          }
          if (i == 1)
          {
            localObject3 = SchoolRankingsBuilder.INSTANCE;
            localObject3 = SchoolRankingsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject10, null, paramFissionTransaction);
            if (localObject3 == null) {
              break label1391;
            }
            bool4 = true;
          }
        }
        if (((ByteBuffer)localObject10).get() != 1) {
          break label1397;
        }
        bool6 = true;
        bool5 = bool6;
        if (bool6)
        {
          i = ((ByteBuffer)localObject10).get();
          localObject4 = localSchoolFacetsBuilder;
          bool5 = bool6;
          if (i == 0)
          {
            localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject10);
            localSchoolFacetsBuilder = SchoolFacetsBuilder.INSTANCE;
            localObject4 = SchoolFacetsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
            if (localObject4 == null) {
              break label1403;
            }
            bool5 = true;
          }
          if (i == 1)
          {
            localObject4 = SchoolFacetsBuilder.INSTANCE;
            localObject4 = SchoolFacetsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject10, null, paramFissionTransaction);
            if (localObject4 == null) {
              break label1409;
            }
            bool5 = true;
          }
        }
        if (((ByteBuffer)localObject10).get() != 1) {
          break label1415;
        }
        bool7 = true;
        bool6 = bool7;
        if (bool7)
        {
          i = ((ByteBuffer)localObject10).get();
          localObject5 = localFinancialInformationBuilder;
          bool6 = bool7;
          if (i == 0)
          {
            localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject10);
            localFinancialInformationBuilder = FinancialInformationBuilder.INSTANCE;
            localObject5 = FinancialInformationBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
            if (localObject5 == null) {
              break label1421;
            }
            bool6 = true;
          }
          if (i == 1)
          {
            localObject5 = FinancialInformationBuilder.INSTANCE;
            localObject5 = FinancialInformationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject10, null, paramFissionTransaction);
            if (localObject5 == null) {
              break label1427;
            }
            bool6 = true;
          }
        }
        if (((ByteBuffer)localObject10).get() != 1) {
          break label1433;
        }
        bool8 = true;
        bool7 = bool8;
        if (bool8)
        {
          i = ((ByteBuffer)localObject10).get();
          localObject6 = localStudentsAndFacultyBuilder;
          bool7 = bool8;
          if (i == 0)
          {
            localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject10);
            localStudentsAndFacultyBuilder = StudentsAndFacultyBuilder.INSTANCE;
            localObject6 = StudentsAndFacultyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
            if (localObject6 == null) {
              break label1439;
            }
            bool7 = true;
          }
          if (i == 1)
          {
            localObject6 = StudentsAndFacultyBuilder.INSTANCE;
            localObject6 = StudentsAndFacultyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject10, null, paramFissionTransaction);
            if (localObject6 == null) {
              break label1445;
            }
            bool7 = true;
          }
        }
        if (((ByteBuffer)localObject10).get() != 1) {
          break label1451;
        }
        bool9 = true;
        bool8 = bool9;
        if (bool9)
        {
          i = ((ByteBuffer)localObject10).get();
          localObject7 = localAlumniCompaniesCollectionBuilder;
          bool8 = bool9;
          if (i == 0)
          {
            localObject7 = paramFissionAdapter.readString((ByteBuffer)localObject10);
            localAlumniCompaniesCollectionBuilder = AlumniCompaniesCollectionBuilder.INSTANCE;
            localObject7 = AlumniCompaniesCollectionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject7, paramFissionTransaction);
            if (localObject7 == null) {
              break label1457;
            }
            bool8 = true;
          }
          if (i == 1)
          {
            localObject7 = AlumniCompaniesCollectionBuilder.INSTANCE;
            localObject7 = AlumniCompaniesCollectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject10, null, paramFissionTransaction);
            if (localObject7 == null) {
              break label1463;
            }
            bool8 = true;
          }
        }
        if (((ByteBuffer)localObject10).get() != 1) {
          break label1469;
        }
        bool10 = true;
        label1084:
        bool9 = bool10;
        if (bool10)
        {
          i = ((ByteBuffer)localObject10).get();
          localObject8 = localDescriptionBuilder;
          bool9 = bool10;
          if (i == 0)
          {
            localObject8 = paramFissionAdapter.readString((ByteBuffer)localObject10);
            localDescriptionBuilder = DescriptionBuilder.INSTANCE;
            localObject8 = DescriptionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject8, paramFissionTransaction);
            if (localObject8 == null) {
              break label1475;
            }
            bool9 = true;
          }
          label1146:
          if (i == 1)
          {
            localObject8 = DescriptionBuilder.INSTANCE;
            localObject8 = DescriptionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject10, null, paramFissionTransaction);
            if (localObject8 == null) {
              break label1481;
            }
            bool9 = true;
          }
        }
        label1175:
        if (((ByteBuffer)localObject10).get() != 1) {
          break label1487;
        }
        bool10 = true;
        label1187:
        bool11 = bool10;
        if (bool10)
        {
          i = ((ByteBuffer)localObject10).get();
          localObject9 = localMiniProfilesCollectionBuilder;
          if (i == 0)
          {
            localObject9 = paramFissionAdapter.readString((ByteBuffer)localObject10);
            localMiniProfilesCollectionBuilder = MiniProfilesCollectionBuilder.INSTANCE;
            localObject9 = MiniProfilesCollectionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject9, paramFissionTransaction);
            if (localObject9 == null) {
              break label1493;
            }
            bool10 = true;
          }
          label1245:
          bool11 = bool10;
          if (i == 1)
          {
            localObject9 = MiniProfilesCollectionBuilder.INSTANCE;
            localObject9 = MiniProfilesCollectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject10, null, paramFissionTransaction);
            if (localObject9 == null) {
              break label1499;
            }
          }
        }
      }
      label1331:
      label1337:
      label1343:
      label1349:
      label1355:
      label1361:
      label1367:
      label1373:
      label1379:
      label1385:
      label1391:
      label1397:
      label1403:
      label1409:
      label1415:
      label1421:
      label1427:
      label1433:
      label1439:
      label1445:
      label1451:
      label1457:
      label1463:
      label1469:
      label1475:
      label1481:
      label1487:
      label1493:
      label1499:
      for (boolean bool11 = true;; bool11 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject10);
        }
        j = 0;
        if (bool1) {
          j = 1;
        }
        i = j;
        if (!bool2) {
          break label1508;
        }
        if (j == 0) {
          break label1505;
        }
        throw new IOException("Found more than 1 member when reading .Item from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label325;
        bool1 = false;
        break label351;
        bool3 = false;
        break label363;
        bool2 = false;
        break label425;
        bool2 = false;
        break label454;
        bool4 = false;
        break label466;
        bool3 = false;
        break label528;
        bool3 = false;
        break label557;
        bool5 = false;
        break label569;
        bool4 = false;
        break label631;
        bool4 = false;
        break label660;
        bool6 = false;
        break label672;
        bool5 = false;
        break label734;
        bool5 = false;
        break label763;
        bool7 = false;
        break label775;
        bool6 = false;
        break label837;
        bool6 = false;
        break label866;
        bool8 = false;
        break label878;
        bool7 = false;
        break label940;
        bool7 = false;
        break label969;
        bool9 = false;
        break label981;
        bool8 = false;
        break label1043;
        bool8 = false;
        break label1072;
        bool10 = false;
        break label1084;
        bool9 = false;
        break label1146;
        bool9 = false;
        break label1175;
        bool10 = false;
        break label1187;
        bool10 = false;
        break label1245;
      }
      label1505:
      int i = 1;
      label1508:
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
      if ((bool11) && (j != 0)) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      return new SchoolItem.Item(paramString, (SchoolDetails)localObject1, (NotableAlumni)localObject2, (SchoolRankings)localObject3, (SchoolFacets)localObject4, (FinancialInformation)localObject5, (StudentsAndFaculty)localObject6, (AlumniCompaniesCollection)localObject7, (Description)localObject8, (MiniProfilesCollection)localObject9, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool11);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItemBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */