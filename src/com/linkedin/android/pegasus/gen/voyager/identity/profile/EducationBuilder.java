package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.common.DateRangeBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchoolBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EducationBuilder
  implements FissileDataModelBuilder<Education>, DataTemplateBuilder<Education>
{
  public static final EducationBuilder INSTANCE = new EducationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("schoolUrn");
    JSON_KEY_STORE.put("schoolName");
    JSON_KEY_STORE.put("timePeriod");
    JSON_KEY_STORE.put("degreeName");
    JSON_KEY_STORE.put("degreeUrn");
    JSON_KEY_STORE.put("fieldOfStudy");
    JSON_KEY_STORE.put("fieldOfStudyUrn");
    JSON_KEY_STORE.put("activities");
    JSON_KEY_STORE.put("grade");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("honors");
    JSON_KEY_STORE.put("courses");
    JSON_KEY_STORE.put("school");
    JSON_KEY_STORE.put("testScores");
    JSON_KEY_STORE.put("projects");
    JSON_KEY_STORE.put("recommendations");
  }
  
  public static Education build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject11 = null;
    Object localObject10 = null;
    String str6 = null;
    Object localObject9 = null;
    String str5 = null;
    Object localObject8 = null;
    String str4 = null;
    Object localObject7 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject6 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
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
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject11 = UrnCoercer.INSTANCE;
        localObject11 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool17 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("schoolUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject10 = UrnCoercer.INSTANCE;
        localObject10 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool16 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("schoolName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str6 = paramDataReader.readString();
        bool15 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("timePeriod", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject9 = DateRangeBuilder.INSTANCE;
        localObject9 = DateRangeBuilder.build(paramDataReader);
        bool14 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("degreeName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("degreeUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject8 = UrnCoercer.INSTANCE;
        localObject8 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("fieldOfStudy", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("fieldOfStudyUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = UrnCoercer.INSTANCE;
        localObject7 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("activities", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("grade", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool7 = true;
      }
      else
      {
        Object localObject12;
        if (paramDataReader.shouldReadField$11ca93e7("honors", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject5 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject12 = UrnCoercer.INSTANCE;
              localObject12 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
              if (localObject12 != null) {
                ((List)localObject5).add(localObject12);
              }
            }
          }
          bool6 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("courses", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject12 = UrnCoercer.INSTANCE;
              localObject12 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
              if (localObject12 != null) {
                ((List)localObject4).add(localObject12);
              }
            }
          }
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("school", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject6 = MiniSchoolBuilder.INSTANCE;
          localObject6 = MiniSchoolBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("testScores", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject12 = UrnCoercer.INSTANCE;
              localObject12 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
              if (localObject12 != null) {
                ((List)localObject3).add(localObject12);
              }
            }
          }
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("projects", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject12 = UrnCoercer.INSTANCE;
              localObject12 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
              if (localObject12 != null) {
                ((List)localObject2).add(localObject12);
              }
            }
          }
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("recommendations", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject12 = UrnCoercer.INSTANCE;
              localObject12 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
              if (localObject12 != null) {
                ((List)localObject1).add(localObject12);
              }
            }
          }
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
    }
    if (!bool6) {
      localObject5 = Collections.emptyList();
    }
    if (!bool5) {
      localObject4 = Collections.emptyList();
    }
    if (!bool3) {
      localObject3 = Collections.emptyList();
    }
    if (!bool2) {
      localObject2 = Collections.emptyList();
    }
    if (!bool1) {
      localObject1 = Collections.emptyList();
    }
    return new Education((Urn)localObject11, (Urn)localObject10, str6, (DateRange)localObject9, str5, (Urn)localObject8, str4, (Urn)localObject7, str3, str2, str1, (List)localObject5, (List)localObject4, (MiniSchool)localObject6, (List)localObject3, (List)localObject2, (List)localObject1, bool17, bool16, bool15, bool14, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Education readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Education");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Education");
    }
    Object localObject8 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Education");
    }
    if (((ByteBuffer)localObject8).getInt() != 1566654455)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject8);
      throw new IOException("UID mismatch. Can't read cached data when building Education");
    }
    Object localObject6 = null;
    Object localObject7 = null;
    String str1 = null;
    paramString = null;
    Object localObject11 = null;
    String str2 = null;
    Object localObject9 = null;
    String str3 = null;
    Object localObject10 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    MiniSchoolBuilder localMiniSchoolBuilder = null;
    ArrayList localArrayList = null;
    Object localObject4 = null;
    Object localObject5 = null;
    boolean bool4;
    boolean bool5;
    label300:
    boolean bool6;
    label335:
    boolean bool2;
    label362:
    boolean bool1;
    label419:
    label445:
    boolean bool7;
    label457:
    boolean bool8;
    label484:
    boolean bool9;
    label519:
    boolean bool10;
    label546:
    boolean bool11;
    label581:
    boolean bool12;
    label608:
    boolean bool13;
    if (((ByteBuffer)localObject8).get() == 1)
    {
      bool4 = true;
      if (bool4)
      {
        localObject6 = UrnCoercer.INSTANCE;
        localObject6 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject8));
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label734;
      }
      bool5 = true;
      if (bool5)
      {
        localObject7 = UrnCoercer.INSTANCE;
        localObject7 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject8));
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label740;
      }
      bool6 = true;
      if (bool6) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject8);
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label746;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject8).get();
        paramString = (String)localObject11;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localObject11 = DateRangeBuilder.INSTANCE;
          paramString = DateRangeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label752;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = DateRangeBuilder.INSTANCE;
          paramString = DateRangeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (paramString == null) {
            break label758;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label764;
      }
      bool7 = true;
      if (bool7) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject8);
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label770;
      }
      bool8 = true;
      if (bool8)
      {
        localObject9 = UrnCoercer.INSTANCE;
        localObject9 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject8));
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label776;
      }
      bool9 = true;
      if (bool9) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject8);
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label782;
      }
      bool10 = true;
      if (bool10)
      {
        localObject10 = UrnCoercer.INSTANCE;
        localObject10 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject8));
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label788;
      }
      bool11 = true;
      if (bool11) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject8);
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label794;
      }
      bool12 = true;
      if (bool12) {
        str5 = paramFissionAdapter.readString((ByteBuffer)localObject8);
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label800;
      }
      bool13 = true;
      label635:
      if (bool13) {
        str6 = paramFissionAdapter.readString((ByteBuffer)localObject8);
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label806;
      }
    }
    label734:
    label740:
    label746:
    label752:
    label758:
    label764:
    label770:
    label776:
    label782:
    label788:
    label794:
    label800:
    label806:
    for (boolean bool14 = true;; bool14 = false)
    {
      if (!bool14) {
        break label812;
      }
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject8);
      localObject11 = new ArrayList();
      for (;;)
      {
        localObject1 = localObject11;
        if (i <= 0) {
          break;
        }
        localObject1 = UrnCoercer.INSTANCE;
        ((List)localObject11).add(UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject8)));
        i -= 1;
      }
      bool4 = false;
      break;
      bool5 = false;
      break label300;
      bool6 = false;
      break label335;
      bool2 = false;
      break label362;
      bool1 = false;
      break label419;
      bool1 = false;
      break label445;
      bool7 = false;
      break label457;
      bool8 = false;
      break label484;
      bool9 = false;
      break label519;
      bool10 = false;
      break label546;
      bool11 = false;
      break label581;
      bool12 = false;
      break label608;
      bool13 = false;
      break label635;
    }
    label812:
    if (((ByteBuffer)localObject8).get() == 1) {}
    for (boolean bool15 = true; bool15; bool15 = false)
    {
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject8);
      localObject11 = new ArrayList();
      for (;;)
      {
        localObject2 = localObject11;
        if (i <= 0) {
          break;
        }
        localObject2 = UrnCoercer.INSTANCE;
        ((List)localObject11).add(UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject8)));
        i -= 1;
      }
    }
    if (((ByteBuffer)localObject8).get() == 1)
    {
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject3 = localMiniSchoolBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localMiniSchoolBuilder = MiniSchoolBuilder.INSTANCE;
          localObject3 = MiniSchoolBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1084;
          }
          bool2 = true;
        }
        label970:
        if (i == 1)
        {
          localObject3 = MiniSchoolBuilder.INSTANCE;
          localObject3 = MiniSchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1090;
          }
          bool2 = true;
        }
      }
      label999:
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1096;
      }
    }
    label1084:
    label1090:
    label1096:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramFissionTransaction = localArrayList;
      if (!bool3) {
        break label1102;
      }
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject8);
      localArrayList = new ArrayList();
      for (;;)
      {
        paramFissionTransaction = localArrayList;
        if (i <= 0) {
          break;
        }
        paramFissionTransaction = UrnCoercer.INSTANCE;
        localArrayList.add(UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject8)));
        i -= 1;
      }
      bool3 = false;
      break;
      bool2 = false;
      break label970;
      bool2 = false;
      break label999;
    }
    label1102:
    if (((ByteBuffer)localObject8).get() == 1) {}
    for (boolean bool16 = true; bool16; bool16 = false)
    {
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject8);
      localArrayList = new ArrayList();
      for (;;)
      {
        localObject4 = localArrayList;
        if (i <= 0) {
          break;
        }
        localObject4 = UrnCoercer.INSTANCE;
        localArrayList.add(UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject8)));
        i -= 1;
      }
    }
    if (((ByteBuffer)localObject8).get() == 1) {}
    for (boolean bool17 = true; bool17; bool17 = false)
    {
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject8);
      localArrayList = new ArrayList();
      for (;;)
      {
        localObject5 = localArrayList;
        if (i <= 0) {
          break;
        }
        localObject5 = UrnCoercer.INSTANCE;
        localArrayList.add(UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject8)));
        i -= 1;
      }
    }
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject8);
    }
    if (!bool14) {
      localObject1 = Collections.emptyList();
    }
    if (!bool15) {
      localObject2 = Collections.emptyList();
    }
    if (!bool3) {
      paramFissionTransaction = Collections.emptyList();
    }
    if (!bool16) {
      localObject4 = Collections.emptyList();
    }
    if (!bool17) {
      localObject5 = Collections.emptyList();
    }
    return new Education((Urn)localObject6, (Urn)localObject7, str1, paramString, str2, (Urn)localObject9, str3, (Urn)localObject10, str4, str5, str6, (List)localObject1, (List)localObject2, (MiniSchool)localObject3, paramFissionTransaction, (List)localObject4, (List)localObject5, bool4, bool5, bool6, bool1, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool15, bool2, bool3, bool16, bool17);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.EducationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */