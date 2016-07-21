package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchoolBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class NextSchoolBuilder
  implements FissileDataModelBuilder<NextSchool>, DataTemplateBuilder<NextSchool>
{
  public static final NextSchoolBuilder INSTANCE = new NextSchoolBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("miniSchool");
    JSON_KEY_STORE.put("location");
    JSON_KEY_STORE.put("studentsAndAlumniCount");
    JSON_KEY_STORE.put("objectUrn");
  }
  
  public static NextSchool build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    Object localObject3 = null;
    String str = null;
    Object localObject2 = null;
    Object localObject1 = null;
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
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("miniSchool", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = MiniSchoolBuilder.INSTANCE;
        localObject3 = MiniSchoolBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("location", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("studentsAndAlumniCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = StudentsAndAlumniCountBuilder.INSTANCE;
        localObject2 = StudentsAndAlumniCountBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("objectUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UrnCoercer.INSTANCE;
        localObject1 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: miniSchool when building com.linkedin.android.pegasus.gen.voyager.entities.school.NextSchool");
    }
    return new NextSchool((Urn)localObject4, (MiniSchool)localObject3, str, (StudentsAndAlumniCount)localObject2, (Urn)localObject1, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static NextSchool readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building NextSchool");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building NextSchool");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building NextSchool");
    }
    if (((ByteBuffer)localObject2).getInt() != -922643627)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building NextSchool");
    }
    Object localObject3 = null;
    paramString = null;
    MiniSchoolBuilder localMiniSchoolBuilder = null;
    String str = null;
    localObject1 = null;
    StudentsAndAlumniCountBuilder localStudentsAndAlumniCountBuilder = null;
    Object localObject4 = null;
    boolean bool4;
    boolean bool2;
    label264:
    boolean bool1;
    label321:
    label347:
    boolean bool5;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label546;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localMiniSchoolBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMiniSchoolBuilder = MiniSchoolBuilder.INSTANCE;
          paramString = MiniSchoolBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label552;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniSchoolBuilder.INSTANCE;
          paramString = MiniSchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label558;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label564;
      }
      bool5 = true;
      label359:
      if (bool5) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label570;
      }
      bool3 = true;
      label386:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localStudentsAndAlumniCountBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localStudentsAndAlumniCountBuilder = StudentsAndAlumniCountBuilder.INSTANCE;
          localObject1 = StudentsAndAlumniCountBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label576;
          }
          bool2 = true;
        }
        label448:
        if (i == 1)
        {
          localObject1 = StudentsAndAlumniCountBuilder.INSTANCE;
          localObject1 = StudentsAndAlumniCountBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label582;
          }
          bool2 = true;
        }
      }
      label477:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label588;
      }
    }
    label546:
    label552:
    label558:
    label564:
    label570:
    label576:
    label582:
    label588:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject4;
      if (bool3)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label594;
      }
      throw new IOException("Failed to find required field: miniSchool when reading com.linkedin.android.pegasus.gen.voyager.entities.school.NextSchool from fission.");
      bool4 = false;
      break;
      bool2 = false;
      break label264;
      bool1 = false;
      break label321;
      bool1 = false;
      break label347;
      bool5 = false;
      break label359;
      bool3 = false;
      break label386;
      bool2 = false;
      break label448;
      bool2 = false;
      break label477;
    }
    label594:
    return new NextSchool((Urn)localObject3, paramString, str, (StudentsAndAlumniCount)localObject1, paramFissionTransaction, bool4, bool1, bool5, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.NextSchoolBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */