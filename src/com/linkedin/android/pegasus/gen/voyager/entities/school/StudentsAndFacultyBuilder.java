package com.linkedin.android.pegasus.gen.voyager.entities.school;

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

public final class StudentsAndFacultyBuilder
  implements FissileDataModelBuilder<StudentsAndFaculty>, DataTemplateBuilder<StudentsAndFaculty>
{
  public static final StudentsAndFacultyBuilder INSTANCE = new StudentsAndFacultyBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("numberOfStudentsAndAlumni");
    JSON_KEY_STORE.put("numberOfUndergradStudents");
    JSON_KEY_STORE.put("numberOfGradStudents");
    JSON_KEY_STORE.put("numberOfFaculty");
    JSON_KEY_STORE.put("totalPopulation");
    JSON_KEY_STORE.put("maleStudentPercentage");
    JSON_KEY_STORE.put("femaleStudentPercentage");
    JSON_KEY_STORE.put("admittedPercentage");
    JSON_KEY_STORE.put("graduationPercentage");
    JSON_KEY_STORE.put("studentFacultyRatio");
  }
  
  public static StudentsAndFaculty build(DataReader paramDataReader)
    throws DataReaderException
  {
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    float f5 = 0.0F;
    float f4 = 0.0F;
    float f3 = 0.0F;
    float f2 = 0.0F;
    float f1 = 0.0F;
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
      if (paramDataReader.shouldReadField$11ca93e7("numberOfStudentsAndAlumni", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        n = paramDataReader.readInt();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("numberOfUndergradStudents", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        m = paramDataReader.readInt();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("numberOfGradStudents", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        k = paramDataReader.readInt();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("numberOfFaculty", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("totalPopulation", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("maleStudentPercentage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        f5 = paramDataReader.readFloat();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("femaleStudentPercentage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        f4 = paramDataReader.readFloat();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("admittedPercentage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        f3 = paramDataReader.readFloat();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("graduationPercentage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        f2 = paramDataReader.readFloat();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("studentFacultyRatio", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        f1 = paramDataReader.readFloat();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new StudentsAndFaculty(n, m, k, j, i, f5, f4, f3, f2, f1, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static StudentsAndFaculty readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building StudentsAndFaculty");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building StudentsAndFaculty");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building StudentsAndFaculty");
    }
    if (((ByteBuffer)localObject2).getInt() != -983869189)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building StudentsAndFaculty");
    }
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    float f1 = 0.0F;
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f4 = 0.0F;
    float f5 = 0.0F;
    boolean bool1;
    boolean bool2;
    label263:
    boolean bool3;
    label287:
    boolean bool4;
    label311:
    boolean bool5;
    label335:
    boolean bool6;
    label359:
    boolean bool7;
    label383:
    boolean bool8;
    label407:
    boolean bool9;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        i = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label533;
      }
      bool2 = true;
      if (bool2) {
        j = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label539;
      }
      bool3 = true;
      if (bool3) {
        k = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label545;
      }
      bool4 = true;
      if (bool4) {
        m = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label551;
      }
      bool5 = true;
      if (bool5) {
        n = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label557;
      }
      bool6 = true;
      if (bool6) {
        f1 = ((ByteBuffer)localObject2).getFloat();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label563;
      }
      bool7 = true;
      if (bool7) {
        f2 = ((ByteBuffer)localObject2).getFloat();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label569;
      }
      bool8 = true;
      if (bool8) {
        f3 = ((ByteBuffer)localObject2).getFloat();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label575;
      }
      bool9 = true;
      label431:
      if (bool9) {
        f4 = ((ByteBuffer)localObject2).getFloat();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label581;
      }
    }
    label533:
    label539:
    label545:
    label551:
    label557:
    label563:
    label569:
    label575:
    label581:
    for (boolean bool10 = true;; bool10 = false)
    {
      if (bool10) {
        f5 = ((ByteBuffer)localObject2).getFloat();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      return new StudentsAndFaculty(i, j, k, m, n, f1, f2, f3, f4, f5, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10);
      bool1 = false;
      break;
      bool2 = false;
      break label263;
      bool3 = false;
      break label287;
      bool4 = false;
      break label311;
      bool5 = false;
      break label335;
      bool6 = false;
      break label359;
      bool7 = false;
      break label383;
      bool8 = false;
      break label407;
      bool9 = false;
      break label431;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.StudentsAndFacultyBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */