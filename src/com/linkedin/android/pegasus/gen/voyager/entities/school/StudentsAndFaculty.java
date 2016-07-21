package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class StudentsAndFaculty
  implements FissileDataModel<StudentsAndFaculty>, RecordTemplate<StudentsAndFaculty>
{
  public static final StudentsAndFacultyBuilder BUILDER = StudentsAndFacultyBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final float admittedPercentage;
  public final float femaleStudentPercentage;
  public final float graduationPercentage;
  public final boolean hasAdmittedPercentage;
  public final boolean hasFemaleStudentPercentage;
  public final boolean hasGraduationPercentage;
  public final boolean hasMaleStudentPercentage;
  public final boolean hasNumberOfFaculty;
  public final boolean hasNumberOfGradStudents;
  public final boolean hasNumberOfStudentsAndAlumni;
  public final boolean hasNumberOfUndergradStudents;
  public final boolean hasStudentFacultyRatio;
  public final boolean hasTotalPopulation;
  public final float maleStudentPercentage;
  public final int numberOfFaculty;
  public final int numberOfGradStudents;
  public final int numberOfStudentsAndAlumni;
  public final int numberOfUndergradStudents;
  public final float studentFacultyRatio;
  public final int totalPopulation;
  
  StudentsAndFaculty(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    numberOfStudentsAndAlumni = paramInt1;
    numberOfUndergradStudents = paramInt2;
    numberOfGradStudents = paramInt3;
    numberOfFaculty = paramInt4;
    totalPopulation = paramInt5;
    maleStudentPercentage = paramFloat1;
    femaleStudentPercentage = paramFloat2;
    admittedPercentage = paramFloat3;
    graduationPercentage = paramFloat4;
    studentFacultyRatio = paramFloat5;
    hasNumberOfStudentsAndAlumni = paramBoolean1;
    hasNumberOfUndergradStudents = paramBoolean2;
    hasNumberOfGradStudents = paramBoolean3;
    hasNumberOfFaculty = paramBoolean4;
    hasTotalPopulation = paramBoolean5;
    hasMaleStudentPercentage = paramBoolean6;
    hasFemaleStudentPercentage = paramBoolean7;
    hasAdmittedPercentage = paramBoolean8;
    hasGraduationPercentage = paramBoolean9;
    hasStudentFacultyRatio = paramBoolean10;
    _cachedId = null;
  }
  
  public final StudentsAndFaculty accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasNumberOfStudentsAndAlumni)
    {
      paramDataProcessor.startRecordField$505cff1c("numberOfStudentsAndAlumni");
      paramDataProcessor.processInt(numberOfStudentsAndAlumni);
    }
    if (hasNumberOfUndergradStudents)
    {
      paramDataProcessor.startRecordField$505cff1c("numberOfUndergradStudents");
      paramDataProcessor.processInt(numberOfUndergradStudents);
    }
    if (hasNumberOfGradStudents)
    {
      paramDataProcessor.startRecordField$505cff1c("numberOfGradStudents");
      paramDataProcessor.processInt(numberOfGradStudents);
    }
    if (hasNumberOfFaculty)
    {
      paramDataProcessor.startRecordField$505cff1c("numberOfFaculty");
      paramDataProcessor.processInt(numberOfFaculty);
    }
    if (hasTotalPopulation)
    {
      paramDataProcessor.startRecordField$505cff1c("totalPopulation");
      paramDataProcessor.processInt(totalPopulation);
    }
    if (hasMaleStudentPercentage)
    {
      paramDataProcessor.startRecordField$505cff1c("maleStudentPercentage");
      paramDataProcessor.processFloat(maleStudentPercentage);
    }
    if (hasFemaleStudentPercentage)
    {
      paramDataProcessor.startRecordField$505cff1c("femaleStudentPercentage");
      paramDataProcessor.processFloat(femaleStudentPercentage);
    }
    if (hasAdmittedPercentage)
    {
      paramDataProcessor.startRecordField$505cff1c("admittedPercentage");
      paramDataProcessor.processFloat(admittedPercentage);
    }
    if (hasGraduationPercentage)
    {
      paramDataProcessor.startRecordField$505cff1c("graduationPercentage");
      paramDataProcessor.processFloat(graduationPercentage);
    }
    if (hasStudentFacultyRatio)
    {
      paramDataProcessor.startRecordField$505cff1c("studentFacultyRatio");
      paramDataProcessor.processFloat(studentFacultyRatio);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new StudentsAndFaculty(numberOfStudentsAndAlumni, numberOfUndergradStudents, numberOfGradStudents, numberOfFaculty, totalPopulation, maleStudentPercentage, femaleStudentPercentage, admittedPercentage, graduationPercentage, studentFacultyRatio, hasNumberOfStudentsAndAlumni, hasNumberOfUndergradStudents, hasNumberOfGradStudents, hasNumberOfFaculty, hasTotalPopulation, hasMaleStudentPercentage, hasFemaleStudentPercentage, hasAdmittedPercentage, hasGraduationPercentage, hasStudentFacultyRatio);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (StudentsAndFaculty)paramObject;
      if (numberOfStudentsAndAlumni != numberOfStudentsAndAlumni) {
        return false;
      }
      if (numberOfUndergradStudents != numberOfUndergradStudents) {
        return false;
      }
      if (numberOfGradStudents != numberOfGradStudents) {
        return false;
      }
      if (numberOfFaculty != numberOfFaculty) {
        return false;
      }
      if (totalPopulation != totalPopulation) {
        return false;
      }
      if (maleStudentPercentage != maleStudentPercentage) {
        return false;
      }
      if (femaleStudentPercentage != femaleStudentPercentage) {
        return false;
      }
      if (admittedPercentage != admittedPercentage) {
        return false;
      }
      if (graduationPercentage != graduationPercentage) {
        return false;
      }
    } while (studentFacultyRatio == studentFacultyRatio);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasNumberOfStudentsAndAlumni) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasNumberOfUndergradStudents) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasNumberOfGradStudents) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasNumberOfFaculty) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasTotalPopulation) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasMaleStudentPercentage) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasFemaleStudentPercentage) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasAdmittedPercentage) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasGraduationPercentage) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasStudentFacultyRatio) {
      i = j + 4;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i1 = numberOfStudentsAndAlumni;
    int i2 = numberOfUndergradStudents;
    int i3 = numberOfGradStudents;
    int i4 = numberOfFaculty;
    int i5 = totalPopulation;
    int i;
    int j;
    label79:
    int k;
    if (maleStudentPercentage != 0.0F)
    {
      i = Float.floatToIntBits(maleStudentPercentage);
      if (femaleStudentPercentage == 0.0F) {
        break label202;
      }
      j = Float.floatToIntBits(femaleStudentPercentage);
      if (admittedPercentage == 0.0F) {
        break label207;
      }
      k = Float.floatToIntBits(admittedPercentage);
      label96:
      if (graduationPercentage == 0.0F) {
        break label212;
      }
    }
    label202:
    label207:
    label212:
    for (int m = Float.floatToIntBits(graduationPercentage);; m = 0)
    {
      if (studentFacultyRatio != 0.0F) {
        n = Float.floatToIntBits(studentFacultyRatio);
      }
      i = (m + (k + (j + (i + (((((i1 + 527) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label79;
      k = 0;
      break label96;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building StudentsAndFaculty");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label158:
    label182:
    label206:
    label230:
    label254:
    label278:
    label302:
    label326:
    label393:
    label403:
    label413:
    label423:
    label433:
    label443:
    label453:
    label463:
    label473:
    label481:
    label483:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-983869189);
        if (hasNumberOfStudentsAndAlumni)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numberOfStudentsAndAlumni);
          if (!hasNumberOfUndergradStudents) {
            break label393;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numberOfUndergradStudents);
          if (!hasNumberOfGradStudents) {
            break label403;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numberOfGradStudents);
          if (!hasNumberOfFaculty) {
            break label413;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numberOfFaculty);
          if (!hasTotalPopulation) {
            break label423;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(totalPopulation);
          if (!hasMaleStudentPercentage) {
            break label433;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putFloat(maleStudentPercentage);
          if (!hasFemaleStudentPercentage) {
            break label443;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putFloat(femaleStudentPercentage);
          if (!hasAdmittedPercentage) {
            break label453;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putFloat(admittedPercentage);
          if (!hasGraduationPercentage) {
            break label463;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putFloat(graduationPercentage);
          if (!hasStudentFacultyRatio) {
            break label473;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putFloat(studentFacultyRatio);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label481;
          }
          if (str != null) {
            break label483;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label158;
          localByteBuffer.put((byte)0);
          break label182;
          localByteBuffer.put((byte)0);
          break label206;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)0);
          break label254;
          localByteBuffer.put((byte)0);
          break label278;
          localByteBuffer.put((byte)0);
          break label302;
          localByteBuffer.put((byte)0);
          break label326;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.StudentsAndFaculty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */