package com.linkedin.android.pegasus.gen.voyager.typeahead;

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

public final class TypeaheadHitBuilder
  implements FissileDataModelBuilder<TypeaheadHit>, DataTemplateBuilder<TypeaheadHit>
{
  public static final TypeaheadHitBuilder INSTANCE = new TypeaheadHitBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("text");
    JSON_KEY_STORE.put("subtext");
    JSON_KEY_STORE.put("hitInfo");
  }
  
  public static TypeaheadHit build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    String str = null;
    Object localObject1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = AnnotatedTextBuilder.INSTANCE;
        localObject2 = AnnotatedTextBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("subtext", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("hitInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = HitInfoBuilder.INSTANCE;
        localObject1 = HitInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: text when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit");
    }
    return new TypeaheadHit((AnnotatedText)localObject2, str, (TypeaheadHit.HitInfo)localObject1, bool3, bool2, bool1);
  }
  
  public static TypeaheadHit readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building TypeaheadHit");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building TypeaheadHit");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building TypeaheadHit");
    }
    if (((ByteBuffer)localObject2).getInt() != 1922300810)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building TypeaheadHit");
    }
    paramString = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder = null;
    String str = null;
    localObject1 = null;
    HitInfoBuilder localHitInfoBuilder = null;
    boolean bool2;
    boolean bool1;
    label280:
    label306:
    boolean bool4;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localAnnotatedTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localAnnotatedTextBuilder = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label469;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label475;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label481;
      }
      bool4 = true;
      label318:
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label487;
      }
      bool2 = true;
      label345:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localHitInfoBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localHitInfoBuilder = HitInfoBuilder.INSTANCE;
          localObject1 = HitInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label493;
          }
          bool2 = true;
        }
        label403:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = HitInfoBuilder.INSTANCE;
          localObject1 = HitInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label499;
          }
        }
      }
    }
    label469:
    label475:
    label481:
    label487:
    label493:
    label499:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label505;
      }
      throw new IOException("Failed to find required field: text when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label280;
      bool1 = false;
      break label306;
      bool4 = false;
      break label318;
      bool2 = false;
      break label345;
      bool2 = false;
      break label403;
    }
    label505:
    return new TypeaheadHit(paramString, str, (TypeaheadHit.HitInfo)localObject1, bool1, bool4, bool3);
  }
  
  public static final class HitInfoBuilder
    implements FissileDataModelBuilder<TypeaheadHit.HitInfo>, DataTemplateBuilder<TypeaheadHit.HitInfo>
  {
    public static final HitInfoBuilder INSTANCE = new HitInfoBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.typeahead.TypeaheadProfile");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadAutoComplete");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadCompany");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadSchool");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadTitle");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadFieldOfStudy");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadRegion");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadDegree");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadGroup");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadSiteFeature");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadShowcase");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadSkill");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadSuggestion");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadCountry");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadState");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadCity");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadPostalCode");
      JSON_KEY_STORE.put("com.linkedin.voyager.typeahead.TypeaheadIndustry");
    }
    
    public static TypeaheadHit.HitInfo build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject18 = null;
      Object localObject17 = null;
      Object localObject16 = null;
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
      boolean bool18 = false;
      boolean bool17 = false;
      boolean bool16 = false;
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
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadProfile", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject18 = TypeaheadProfileBuilder.INSTANCE;
          localObject18 = TypeaheadProfileBuilder.build(paramDataReader);
          bool18 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadAutoComplete", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject17 = TypeaheadAutoCompleteBuilder.INSTANCE;
          localObject17 = TypeaheadAutoCompleteBuilder.build(paramDataReader);
          bool17 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadCompany", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject16 = TypeaheadCompanyBuilder.INSTANCE;
          localObject16 = TypeaheadCompanyBuilder.build(paramDataReader);
          bool16 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadSchool", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject15 = TypeaheadSchoolBuilder.INSTANCE;
          localObject15 = TypeaheadSchoolBuilder.build(paramDataReader);
          bool15 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadTitle", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject14 = TypeaheadTitleBuilder.INSTANCE;
          localObject14 = TypeaheadTitleBuilder.build(paramDataReader);
          bool14 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadFieldOfStudy", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject13 = TypeaheadFieldOfStudyBuilder.INSTANCE;
          localObject13 = TypeaheadFieldOfStudyBuilder.build(paramDataReader);
          bool13 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadRegion", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject12 = TypeaheadRegionBuilder.INSTANCE;
          localObject12 = TypeaheadRegionBuilder.build(paramDataReader);
          bool12 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadDegree", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject11 = TypeaheadDegreeBuilder.INSTANCE;
          localObject11 = TypeaheadDegreeBuilder.build(paramDataReader);
          bool11 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadGroup", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject10 = TypeaheadGroupBuilder.INSTANCE;
          localObject10 = TypeaheadGroupBuilder.build(paramDataReader);
          bool10 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadSiteFeature", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject9 = TypeaheadSiteFeatureBuilder.INSTANCE;
          localObject9 = TypeaheadSiteFeatureBuilder.build(paramDataReader);
          bool9 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadShowcase", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject8 = TypeaheadShowcaseBuilder.INSTANCE;
          localObject8 = TypeaheadShowcaseBuilder.build(paramDataReader);
          bool8 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadSkill", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject7 = TypeaheadSkillBuilder.INSTANCE;
          localObject7 = TypeaheadSkillBuilder.build(paramDataReader);
          bool7 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadSuggestion", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject6 = TypeaheadSuggestionBuilder.INSTANCE;
          localObject6 = TypeaheadSuggestionBuilder.build(paramDataReader);
          bool6 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadCountry", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject5 = TypeaheadCountryBuilder.INSTANCE;
          localObject5 = TypeaheadCountryBuilder.build(paramDataReader);
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadState", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = TypeaheadStateBuilder.INSTANCE;
          localObject4 = TypeaheadStateBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadCity", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = TypeaheadCityBuilder.INSTANCE;
          localObject3 = TypeaheadCityBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadPostalCode", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = TypeaheadPostalCodeBuilder.INSTANCE;
          localObject2 = TypeaheadPostalCodeBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.typeahead.TypeaheadIndustry", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = TypeaheadIndustryBuilder.INSTANCE;
          localObject1 = TypeaheadIndustryBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int j = 0;
      if (bool18) {
        j = 1;
      }
      int i = j;
      if (bool17)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .HitInfo");
        }
        i = 1;
      }
      j = i;
      if (bool16)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .HitInfo");
        }
        j = 1;
      }
      i = j;
      if (bool15)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .HitInfo");
        }
        i = 1;
      }
      j = i;
      if (bool14)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .HitInfo");
        }
        j = 1;
      }
      i = j;
      if (bool13)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .HitInfo");
        }
        i = 1;
      }
      j = i;
      if (bool12)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .HitInfo");
        }
        j = 1;
      }
      i = j;
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
      return new TypeaheadHit.HitInfo((TypeaheadProfile)localObject18, (TypeaheadAutoComplete)localObject17, (TypeaheadCompany)localObject16, (TypeaheadSchool)localObject15, (TypeaheadTitle)localObject14, (TypeaheadFieldOfStudy)localObject13, (TypeaheadRegion)localObject12, (TypeaheadDegree)localObject11, (TypeaheadGroup)localObject10, (TypeaheadSiteFeature)localObject9, (TypeaheadShowcase)localObject8, (TypeaheadSkill)localObject7, (TypeaheadSuggestion)localObject6, (TypeaheadCountry)localObject5, (TypeaheadState)localObject4, (TypeaheadCity)localObject3, (TypeaheadPostalCode)localObject2, (TypeaheadIndustry)localObject1, bool18, bool17, bool16, bool15, bool14, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
    }
    
    public static TypeaheadHit.HitInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building TypeaheadHit.HitInfo");
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
            localObject18 = paramString;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building TypeaheadHit.HitInfo");
      }
      Object localObject18 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building TypeaheadHit.HitInfo");
      }
      if (((ByteBuffer)localObject18).getInt() != 588273137)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject18);
        throw new IOException("UID mismatch. Can't read cached data when building TypeaheadHit.HitInfo");
      }
      paramString = null;
      TypeaheadProfileBuilder localTypeaheadProfileBuilder = null;
      localObject1 = null;
      TypeaheadAutoCompleteBuilder localTypeaheadAutoCompleteBuilder = null;
      Object localObject2 = null;
      TypeaheadCompanyBuilder localTypeaheadCompanyBuilder = null;
      Object localObject3 = null;
      TypeaheadSchoolBuilder localTypeaheadSchoolBuilder = null;
      Object localObject4 = null;
      TypeaheadTitleBuilder localTypeaheadTitleBuilder = null;
      Object localObject5 = null;
      TypeaheadFieldOfStudyBuilder localTypeaheadFieldOfStudyBuilder = null;
      Object localObject6 = null;
      TypeaheadRegionBuilder localTypeaheadRegionBuilder = null;
      Object localObject7 = null;
      TypeaheadDegreeBuilder localTypeaheadDegreeBuilder = null;
      Object localObject8 = null;
      TypeaheadGroupBuilder localTypeaheadGroupBuilder = null;
      Object localObject9 = null;
      TypeaheadSiteFeatureBuilder localTypeaheadSiteFeatureBuilder = null;
      Object localObject10 = null;
      TypeaheadShowcaseBuilder localTypeaheadShowcaseBuilder = null;
      Object localObject11 = null;
      TypeaheadSkillBuilder localTypeaheadSkillBuilder = null;
      Object localObject12 = null;
      TypeaheadSuggestionBuilder localTypeaheadSuggestionBuilder = null;
      Object localObject13 = null;
      TypeaheadCountryBuilder localTypeaheadCountryBuilder = null;
      Object localObject14 = null;
      TypeaheadStateBuilder localTypeaheadStateBuilder = null;
      Object localObject15 = null;
      TypeaheadCityBuilder localTypeaheadCityBuilder = null;
      Object localObject16 = null;
      TypeaheadPostalCodeBuilder localTypeaheadPostalCodeBuilder = null;
      Object localObject17 = null;
      TypeaheadIndustryBuilder localTypeaheadIndustryBuilder = null;
      boolean bool2;
      boolean bool1;
      label377:
      label403:
      boolean bool3;
      label415:
      label477:
      label506:
      boolean bool4;
      label518:
      label580:
      label609:
      boolean bool5;
      label621:
      label683:
      label712:
      boolean bool6;
      label724:
      label786:
      label815:
      boolean bool7;
      label827:
      label889:
      label918:
      boolean bool8;
      label930:
      label992:
      label1021:
      boolean bool9;
      label1033:
      label1095:
      label1124:
      boolean bool10;
      label1136:
      label1198:
      label1227:
      boolean bool11;
      label1239:
      label1301:
      label1330:
      boolean bool12;
      label1342:
      label1404:
      label1433:
      boolean bool13;
      label1445:
      label1507:
      label1536:
      boolean bool14;
      label1548:
      label1610:
      label1639:
      boolean bool15;
      label1651:
      label1713:
      label1742:
      boolean bool16;
      label1754:
      label1816:
      label1845:
      boolean bool17;
      label1857:
      label1919:
      label1948:
      boolean bool18;
      if (((ByteBuffer)localObject18).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject18).get();
          paramString = localTypeaheadProfileBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadProfileBuilder = TypeaheadProfileBuilder.INSTANCE;
            paramString = TypeaheadProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label2208;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = TypeaheadProfileBuilder.INSTANCE;
            paramString = TypeaheadProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (paramString == null) {
              break label2214;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2220;
        }
        bool3 = true;
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject1 = localTypeaheadAutoCompleteBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadAutoCompleteBuilder = TypeaheadAutoCompleteBuilder.INSTANCE;
            localObject1 = TypeaheadAutoCompleteBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label2226;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = TypeaheadAutoCompleteBuilder.INSTANCE;
            localObject1 = TypeaheadAutoCompleteBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label2232;
            }
            bool2 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2238;
        }
        bool4 = true;
        bool3 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject2 = localTypeaheadCompanyBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadCompanyBuilder = TypeaheadCompanyBuilder.INSTANCE;
            localObject2 = TypeaheadCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label2244;
            }
            bool3 = true;
          }
          if (i == 1)
          {
            localObject2 = TypeaheadCompanyBuilder.INSTANCE;
            localObject2 = TypeaheadCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label2250;
            }
            bool3 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2256;
        }
        bool5 = true;
        bool4 = bool5;
        if (bool5)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject3 = localTypeaheadSchoolBuilder;
          bool4 = bool5;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadSchoolBuilder = TypeaheadSchoolBuilder.INSTANCE;
            localObject3 = TypeaheadSchoolBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label2262;
            }
            bool4 = true;
          }
          if (i == 1)
          {
            localObject3 = TypeaheadSchoolBuilder.INSTANCE;
            localObject3 = TypeaheadSchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject3 == null) {
              break label2268;
            }
            bool4 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2274;
        }
        bool6 = true;
        bool5 = bool6;
        if (bool6)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject4 = localTypeaheadTitleBuilder;
          bool5 = bool6;
          if (i == 0)
          {
            localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadTitleBuilder = TypeaheadTitleBuilder.INSTANCE;
            localObject4 = TypeaheadTitleBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
            if (localObject4 == null) {
              break label2280;
            }
            bool5 = true;
          }
          if (i == 1)
          {
            localObject4 = TypeaheadTitleBuilder.INSTANCE;
            localObject4 = TypeaheadTitleBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject4 == null) {
              break label2286;
            }
            bool5 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2292;
        }
        bool7 = true;
        bool6 = bool7;
        if (bool7)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject5 = localTypeaheadFieldOfStudyBuilder;
          bool6 = bool7;
          if (i == 0)
          {
            localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadFieldOfStudyBuilder = TypeaheadFieldOfStudyBuilder.INSTANCE;
            localObject5 = TypeaheadFieldOfStudyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
            if (localObject5 == null) {
              break label2298;
            }
            bool6 = true;
          }
          if (i == 1)
          {
            localObject5 = TypeaheadFieldOfStudyBuilder.INSTANCE;
            localObject5 = TypeaheadFieldOfStudyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject5 == null) {
              break label2304;
            }
            bool6 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2310;
        }
        bool8 = true;
        bool7 = bool8;
        if (bool8)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject6 = localTypeaheadRegionBuilder;
          bool7 = bool8;
          if (i == 0)
          {
            localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadRegionBuilder = TypeaheadRegionBuilder.INSTANCE;
            localObject6 = TypeaheadRegionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
            if (localObject6 == null) {
              break label2316;
            }
            bool7 = true;
          }
          if (i == 1)
          {
            localObject6 = TypeaheadRegionBuilder.INSTANCE;
            localObject6 = TypeaheadRegionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject6 == null) {
              break label2322;
            }
            bool7 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2328;
        }
        bool9 = true;
        bool8 = bool9;
        if (bool9)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject7 = localTypeaheadDegreeBuilder;
          bool8 = bool9;
          if (i == 0)
          {
            localObject7 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadDegreeBuilder = TypeaheadDegreeBuilder.INSTANCE;
            localObject7 = TypeaheadDegreeBuilder.readFromFission(paramFissionAdapter, null, (String)localObject7, paramFissionTransaction);
            if (localObject7 == null) {
              break label2334;
            }
            bool8 = true;
          }
          if (i == 1)
          {
            localObject7 = TypeaheadDegreeBuilder.INSTANCE;
            localObject7 = TypeaheadDegreeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject7 == null) {
              break label2340;
            }
            bool8 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2346;
        }
        bool10 = true;
        bool9 = bool10;
        if (bool10)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject8 = localTypeaheadGroupBuilder;
          bool9 = bool10;
          if (i == 0)
          {
            localObject8 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadGroupBuilder = TypeaheadGroupBuilder.INSTANCE;
            localObject8 = TypeaheadGroupBuilder.readFromFission(paramFissionAdapter, null, (String)localObject8, paramFissionTransaction);
            if (localObject8 == null) {
              break label2352;
            }
            bool9 = true;
          }
          if (i == 1)
          {
            localObject8 = TypeaheadGroupBuilder.INSTANCE;
            localObject8 = TypeaheadGroupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject8 == null) {
              break label2358;
            }
            bool9 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2364;
        }
        bool11 = true;
        bool10 = bool11;
        if (bool11)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject9 = localTypeaheadSiteFeatureBuilder;
          bool10 = bool11;
          if (i == 0)
          {
            localObject9 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadSiteFeatureBuilder = TypeaheadSiteFeatureBuilder.INSTANCE;
            localObject9 = TypeaheadSiteFeatureBuilder.readFromFission(paramFissionAdapter, null, (String)localObject9, paramFissionTransaction);
            if (localObject9 == null) {
              break label2370;
            }
            bool10 = true;
          }
          if (i == 1)
          {
            localObject9 = TypeaheadSiteFeatureBuilder.INSTANCE;
            localObject9 = TypeaheadSiteFeatureBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject9 == null) {
              break label2376;
            }
            bool10 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2382;
        }
        bool12 = true;
        bool11 = bool12;
        if (bool12)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject10 = localTypeaheadShowcaseBuilder;
          bool11 = bool12;
          if (i == 0)
          {
            localObject10 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadShowcaseBuilder = TypeaheadShowcaseBuilder.INSTANCE;
            localObject10 = TypeaheadShowcaseBuilder.readFromFission(paramFissionAdapter, null, (String)localObject10, paramFissionTransaction);
            if (localObject10 == null) {
              break label2388;
            }
            bool11 = true;
          }
          if (i == 1)
          {
            localObject10 = TypeaheadShowcaseBuilder.INSTANCE;
            localObject10 = TypeaheadShowcaseBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject10 == null) {
              break label2394;
            }
            bool11 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2400;
        }
        bool13 = true;
        bool12 = bool13;
        if (bool13)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject11 = localTypeaheadSkillBuilder;
          bool12 = bool13;
          if (i == 0)
          {
            localObject11 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadSkillBuilder = TypeaheadSkillBuilder.INSTANCE;
            localObject11 = TypeaheadSkillBuilder.readFromFission(paramFissionAdapter, null, (String)localObject11, paramFissionTransaction);
            if (localObject11 == null) {
              break label2406;
            }
            bool12 = true;
          }
          if (i == 1)
          {
            localObject11 = TypeaheadSkillBuilder.INSTANCE;
            localObject11 = TypeaheadSkillBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject11 == null) {
              break label2412;
            }
            bool12 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2418;
        }
        bool14 = true;
        bool13 = bool14;
        if (bool14)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject12 = localTypeaheadSuggestionBuilder;
          bool13 = bool14;
          if (i == 0)
          {
            localObject12 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadSuggestionBuilder = TypeaheadSuggestionBuilder.INSTANCE;
            localObject12 = TypeaheadSuggestionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject12, paramFissionTransaction);
            if (localObject12 == null) {
              break label2424;
            }
            bool13 = true;
          }
          if (i == 1)
          {
            localObject12 = TypeaheadSuggestionBuilder.INSTANCE;
            localObject12 = TypeaheadSuggestionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject12 == null) {
              break label2430;
            }
            bool13 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2436;
        }
        bool15 = true;
        bool14 = bool15;
        if (bool15)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject13 = localTypeaheadCountryBuilder;
          bool14 = bool15;
          if (i == 0)
          {
            localObject13 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadCountryBuilder = TypeaheadCountryBuilder.INSTANCE;
            localObject13 = TypeaheadCountryBuilder.readFromFission(paramFissionAdapter, null, (String)localObject13, paramFissionTransaction);
            if (localObject13 == null) {
              break label2442;
            }
            bool14 = true;
          }
          if (i == 1)
          {
            localObject13 = TypeaheadCountryBuilder.INSTANCE;
            localObject13 = TypeaheadCountryBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject13 == null) {
              break label2448;
            }
            bool14 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2454;
        }
        bool16 = true;
        bool15 = bool16;
        if (bool16)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject14 = localTypeaheadStateBuilder;
          bool15 = bool16;
          if (i == 0)
          {
            localObject14 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadStateBuilder = TypeaheadStateBuilder.INSTANCE;
            localObject14 = TypeaheadStateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject14, paramFissionTransaction);
            if (localObject14 == null) {
              break label2460;
            }
            bool15 = true;
          }
          if (i == 1)
          {
            localObject14 = TypeaheadStateBuilder.INSTANCE;
            localObject14 = TypeaheadStateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject14 == null) {
              break label2466;
            }
            bool15 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2472;
        }
        bool17 = true;
        bool16 = bool17;
        if (bool17)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject15 = localTypeaheadCityBuilder;
          bool16 = bool17;
          if (i == 0)
          {
            localObject15 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadCityBuilder = TypeaheadCityBuilder.INSTANCE;
            localObject15 = TypeaheadCityBuilder.readFromFission(paramFissionAdapter, null, (String)localObject15, paramFissionTransaction);
            if (localObject15 == null) {
              break label2478;
            }
            bool16 = true;
          }
          if (i == 1)
          {
            localObject15 = TypeaheadCityBuilder.INSTANCE;
            localObject15 = TypeaheadCityBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject15 == null) {
              break label2484;
            }
            bool16 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2490;
        }
        bool18 = true;
        label1960:
        bool17 = bool18;
        if (bool18)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject16 = localTypeaheadPostalCodeBuilder;
          bool17 = bool18;
          if (i == 0)
          {
            localObject16 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadPostalCodeBuilder = TypeaheadPostalCodeBuilder.INSTANCE;
            localObject16 = TypeaheadPostalCodeBuilder.readFromFission(paramFissionAdapter, null, (String)localObject16, paramFissionTransaction);
            if (localObject16 == null) {
              break label2496;
            }
            bool17 = true;
          }
          label2022:
          if (i == 1)
          {
            localObject16 = TypeaheadPostalCodeBuilder.INSTANCE;
            localObject16 = TypeaheadPostalCodeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject16 == null) {
              break label2502;
            }
            bool17 = true;
          }
        }
        label2051:
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2508;
        }
        bool18 = true;
        label2063:
        bool19 = bool18;
        if (bool18)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject17 = localTypeaheadIndustryBuilder;
          if (i == 0)
          {
            localObject17 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localTypeaheadIndustryBuilder = TypeaheadIndustryBuilder.INSTANCE;
            localObject17 = TypeaheadIndustryBuilder.readFromFission(paramFissionAdapter, null, (String)localObject17, paramFissionTransaction);
            if (localObject17 == null) {
              break label2514;
            }
            bool18 = true;
          }
          label2121:
          bool19 = bool18;
          if (i == 1)
          {
            localObject17 = TypeaheadIndustryBuilder.INSTANCE;
            localObject17 = TypeaheadIndustryBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject17 == null) {
              break label2520;
            }
          }
        }
      }
      label2208:
      label2214:
      label2220:
      label2226:
      label2232:
      label2238:
      label2244:
      label2250:
      label2256:
      label2262:
      label2268:
      label2274:
      label2280:
      label2286:
      label2292:
      label2298:
      label2304:
      label2310:
      label2316:
      label2322:
      label2328:
      label2334:
      label2340:
      label2346:
      label2352:
      label2358:
      label2364:
      label2370:
      label2376:
      label2382:
      label2388:
      label2394:
      label2400:
      label2406:
      label2412:
      label2418:
      label2424:
      label2430:
      label2436:
      label2442:
      label2448:
      label2454:
      label2460:
      label2466:
      label2472:
      label2478:
      label2484:
      label2490:
      label2496:
      label2502:
      label2508:
      label2514:
      label2520:
      for (boolean bool19 = true;; bool19 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject18);
        }
        j = 0;
        if (bool1) {
          j = 1;
        }
        i = j;
        if (!bool2) {
          break label2529;
        }
        if (j == 0) {
          break label2526;
        }
        throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label377;
        bool1 = false;
        break label403;
        bool3 = false;
        break label415;
        bool2 = false;
        break label477;
        bool2 = false;
        break label506;
        bool4 = false;
        break label518;
        bool3 = false;
        break label580;
        bool3 = false;
        break label609;
        bool5 = false;
        break label621;
        bool4 = false;
        break label683;
        bool4 = false;
        break label712;
        bool6 = false;
        break label724;
        bool5 = false;
        break label786;
        bool5 = false;
        break label815;
        bool7 = false;
        break label827;
        bool6 = false;
        break label889;
        bool6 = false;
        break label918;
        bool8 = false;
        break label930;
        bool7 = false;
        break label992;
        bool7 = false;
        break label1021;
        bool9 = false;
        break label1033;
        bool8 = false;
        break label1095;
        bool8 = false;
        break label1124;
        bool10 = false;
        break label1136;
        bool9 = false;
        break label1198;
        bool9 = false;
        break label1227;
        bool11 = false;
        break label1239;
        bool10 = false;
        break label1301;
        bool10 = false;
        break label1330;
        bool12 = false;
        break label1342;
        bool11 = false;
        break label1404;
        bool11 = false;
        break label1433;
        bool13 = false;
        break label1445;
        bool12 = false;
        break label1507;
        bool12 = false;
        break label1536;
        bool14 = false;
        break label1548;
        bool13 = false;
        break label1610;
        bool13 = false;
        break label1639;
        bool15 = false;
        break label1651;
        bool14 = false;
        break label1713;
        bool14 = false;
        break label1742;
        bool16 = false;
        break label1754;
        bool15 = false;
        break label1816;
        bool15 = false;
        break label1845;
        bool17 = false;
        break label1857;
        bool16 = false;
        break label1919;
        bool16 = false;
        break label1948;
        bool18 = false;
        break label1960;
        bool17 = false;
        break label2022;
        bool17 = false;
        break label2051;
        bool18 = false;
        break label2063;
        bool18 = false;
        break label2121;
      }
      label2526:
      int i = 1;
      label2529:
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
      i = j;
      if (bool12)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
        }
        i = 1;
      }
      j = i;
      if (bool13)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool14)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
        }
        i = 1;
      }
      j = i;
      if (bool15)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool16)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
        }
        i = 1;
      }
      j = i;
      if (bool17)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
        }
        j = 1;
      }
      if ((bool19) && (j != 0)) {
        throw new IOException("Found more than 1 member when reading .HitInfo from fission.");
      }
      return new TypeaheadHit.HitInfo(paramString, (TypeaheadAutoComplete)localObject1, (TypeaheadCompany)localObject2, (TypeaheadSchool)localObject3, (TypeaheadTitle)localObject4, (TypeaheadFieldOfStudy)localObject5, (TypeaheadRegion)localObject6, (TypeaheadDegree)localObject7, (TypeaheadGroup)localObject8, (TypeaheadSiteFeature)localObject9, (TypeaheadShowcase)localObject10, (TypeaheadSkill)localObject11, (TypeaheadSuggestion)localObject12, (TypeaheadCountry)localObject13, (TypeaheadState)localObject14, (TypeaheadCity)localObject15, (TypeaheadPostalCode)localObject16, (TypeaheadIndustry)localObject17, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool15, bool16, bool17, bool19);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHitBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */