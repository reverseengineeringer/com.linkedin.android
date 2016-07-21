package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Certification;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.CertificationBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PatentBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Publication;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PublicationBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.SkillBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class SuggestionBuilder
  implements FissileDataModelBuilder<Suggestion>, DataTemplateBuilder<Suggestion>
{
  public static final SuggestionBuilder INSTANCE = new SuggestionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("rawProfileElement");
    JSON_KEY_STORE.put("suggestedContent");
    JSON_KEY_STORE.put("sourceType");
    JSON_KEY_STORE.put("inferredMembers");
    JSON_KEY_STORE.put("flowTrackingId");
  }
  
  public static Suggestion build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    SuggestionSourceType localSuggestionSourceType = null;
    ArrayList localArrayList = null;
    String str = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("rawProfileElement", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("suggestedContent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = SuggestedContentBuilder.INSTANCE;
        localObject1 = SuggestedContentBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("sourceType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSuggestionSourceType = (SuggestionSourceType)paramDataReader.readEnum(SuggestionSourceType.Builder.INSTANCE);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("inferredMembers", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            Object localObject4 = UrnCoercer.INSTANCE;
            localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
            if (localObject4 != null) {
              localArrayList.add(localObject4);
            }
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("flowTrackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: rawProfileElement when building com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: suggestedContent when building com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: flowTrackingId when building com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion");
    }
    return new Suggestion((Urn)localObject3, (Urn)localObject2, (Suggestion.SuggestedContent)localObject1, localSuggestionSourceType, localArrayList, str, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Suggestion readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Suggestion");
    }
    Object localObject2 = paramByteBuffer;
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
          localObject1 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Suggestion");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Suggestion");
    }
    if (((ByteBuffer)localObject1).getInt() != -661026821)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Suggestion");
    }
    localObject2 = null;
    Object localObject3 = null;
    paramString = null;
    SuggestedContentBuilder localSuggestedContentBuilder = null;
    ArrayList localArrayList = null;
    Object localObject4 = null;
    String str = null;
    boolean bool3;
    boolean bool4;
    label264:
    boolean bool2;
    label299:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3)
      {
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label498;
      }
      bool4 = true;
      if (bool4)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label504;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localSuggestedContentBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localSuggestedContentBuilder = SuggestedContentBuilder.INSTANCE;
          paramString = SuggestedContentBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label510;
          }
          bool1 = true;
        }
        label356:
        if (i == 1)
        {
          paramString = SuggestedContentBuilder.INSTANCE;
          paramString = SuggestedContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label516;
          }
          bool1 = true;
        }
      }
      label382:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label522;
      }
      bool2 = true;
      label394:
      paramFissionTransaction = localArrayList;
      if (bool2) {
        paramFissionTransaction = SuggestionSourceType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label528;
      }
    }
    label498:
    label504:
    label510:
    label516:
    label522:
    label528:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (!bool5) {
        break label534;
      }
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      for (;;)
      {
        localObject4 = localArrayList;
        if (i <= 0) {
          break;
        }
        localObject4 = UrnCoercer.INSTANCE;
        localArrayList.add(UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1)));
        i -= 1;
      }
      bool3 = false;
      break;
      bool4 = false;
      break label264;
      bool2 = false;
      break label299;
      bool1 = false;
      break label356;
      bool1 = false;
      break label382;
      bool2 = false;
      break label394;
    }
    label534:
    if (((ByteBuffer)localObject1).get() == 1) {}
    for (boolean bool6 = true;; bool6 = false)
    {
      if (bool6) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool4) {
        break;
      }
      throw new IOException("Failed to find required field: rawProfileElement when reading com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: suggestedContent when reading com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: flowTrackingId when reading com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion from fission.");
    }
    return new Suggestion((Urn)localObject2, (Urn)localObject3, paramString, paramFissionTransaction, (List)localObject4, str, bool3, bool4, bool1, bool2, bool5, bool6);
  }
  
  public static final class SuggestedContentBuilder
    implements FissileDataModelBuilder<Suggestion.SuggestedContent>, DataTemplateBuilder<Suggestion.SuggestedContent>
  {
    public static final SuggestedContentBuilder INSTANCE = new SuggestedContentBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.profile.Skill");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.Certification");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.Patent");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.Publication");
    }
    
    public static Suggestion.SuggestedContent build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject4 = null;
      Object localObject3 = null;
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.Skill", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = SkillBuilder.INSTANCE;
          localObject4 = SkillBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.Certification", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = CertificationBuilder.INSTANCE;
          localObject3 = CertificationBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.Patent", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = PatentBuilder.INSTANCE;
          localObject2 = PatentBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.Publication", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = PublicationBuilder.INSTANCE;
          localObject1 = PublicationBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int j = 0;
      if (bool4) {
        j = 1;
      }
      int i = j;
      if (bool3)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .SuggestedContent");
        }
        i = 1;
      }
      j = i;
      if (bool2)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .SuggestedContent");
        }
        j = 1;
      }
      if ((bool1) && (j != 0)) {
        throw new DataReaderException("Found more than 1 member when building .SuggestedContent");
      }
      return new Suggestion.SuggestedContent((Skill)localObject4, (Certification)localObject3, (Patent)localObject2, (Publication)localObject1, bool4, bool3, bool2, bool1);
    }
    
    public static Suggestion.SuggestedContent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building Suggestion.SuggestedContent");
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
            localObject4 = paramString;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building Suggestion.SuggestedContent");
      }
      Object localObject4 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building Suggestion.SuggestedContent");
      }
      if (((ByteBuffer)localObject4).getInt() != 1978445395)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
        throw new IOException("UID mismatch. Can't read cached data when building Suggestion.SuggestedContent");
      }
      paramString = null;
      SkillBuilder localSkillBuilder = null;
      localObject1 = null;
      CertificationBuilder localCertificationBuilder = null;
      Object localObject2 = null;
      PatentBuilder localPatentBuilder = null;
      Object localObject3 = null;
      PublicationBuilder localPublicationBuilder = null;
      boolean bool2;
      boolean bool1;
      label289:
      label315:
      boolean bool3;
      label327:
      label389:
      label418:
      boolean bool4;
      if (((ByteBuffer)localObject4).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject4).get();
          paramString = localSkillBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localSkillBuilder = SkillBuilder.INSTANCE;
            paramString = SkillBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label677;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = SkillBuilder.INSTANCE;
            paramString = SkillBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (paramString == null) {
              break label683;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject4).get() != 1) {
          break label689;
        }
        bool3 = true;
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject1 = localCertificationBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localCertificationBuilder = CertificationBuilder.INSTANCE;
            localObject1 = CertificationBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label695;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = CertificationBuilder.INSTANCE;
            localObject1 = CertificationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label701;
            }
            bool2 = true;
          }
        }
        if (((ByteBuffer)localObject4).get() != 1) {
          break label707;
        }
        bool4 = true;
        label430:
        bool3 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject2 = localPatentBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localPatentBuilder = PatentBuilder.INSTANCE;
            localObject2 = PatentBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label713;
            }
            bool3 = true;
          }
          label492:
          if (i == 1)
          {
            localObject2 = PatentBuilder.INSTANCE;
            localObject2 = PatentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label719;
            }
            bool3 = true;
          }
        }
        label521:
        if (((ByteBuffer)localObject4).get() != 1) {
          break label725;
        }
        bool4 = true;
        label533:
        bool5 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject3 = localPublicationBuilder;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localPublicationBuilder = PublicationBuilder.INSTANCE;
            localObject3 = PublicationBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label731;
            }
            bool4 = true;
          }
          label591:
          bool5 = bool4;
          if (i == 1)
          {
            localObject3 = PublicationBuilder.INSTANCE;
            localObject3 = PublicationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject3 == null) {
              break label737;
            }
          }
        }
      }
      label677:
      label683:
      label689:
      label695:
      label701:
      label707:
      label713:
      label719:
      label725:
      label731:
      label737:
      for (boolean bool5 = true;; bool5 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject4);
        }
        j = 0;
        if (bool1) {
          j = 1;
        }
        i = j;
        if (!bool2) {
          break label746;
        }
        if (j == 0) {
          break label743;
        }
        throw new IOException("Found more than 1 member when reading .SuggestedContent from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label289;
        bool1 = false;
        break label315;
        bool3 = false;
        break label327;
        bool2 = false;
        break label389;
        bool2 = false;
        break label418;
        bool4 = false;
        break label430;
        bool3 = false;
        break label492;
        bool3 = false;
        break label521;
        bool4 = false;
        break label533;
        bool4 = false;
        break label591;
      }
      label743:
      int i = 1;
      label746:
      int j = i;
      if (bool3)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .SuggestedContent from fission.");
        }
        j = 1;
      }
      if ((bool5) && (j != 0)) {
        throw new IOException("Found more than 1 member when reading .SuggestedContent from fission.");
      }
      return new Suggestion.SuggestedContent(paramString, (Certification)localObject1, (Patent)localObject2, (Publication)localObject3, bool1, bool2, bool3, bool5);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SuggestionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */