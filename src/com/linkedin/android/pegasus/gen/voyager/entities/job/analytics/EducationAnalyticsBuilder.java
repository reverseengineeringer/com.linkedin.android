package com.linkedin.android.pegasus.gen.voyager.entities.job.analytics;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EducationAnalyticsBuilder
  implements FissileDataModelBuilder<EducationAnalytics>, DataTemplateBuilder<EducationAnalytics>
{
  public static final EducationAnalyticsBuilder INSTANCE = new EducationAnalyticsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("fieldsOfStudy");
    JSON_KEY_STORE.put("degrees");
  }
  
  public static EducationAnalytics build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299())
    {
      Object localObject3;
      if (paramDataReader.shouldReadField$11ca93e7("fieldsOfStudy", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            localObject3 = FieldOfStudyBuilder.INSTANCE;
            ((List)localObject2).add(FieldOfStudyBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("degrees", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            localObject3 = DegreeCountBuilder.INSTANCE;
            ((List)localObject1).add(DegreeCountBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      localObject2 = Collections.emptyList();
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    return new EducationAnalytics((List)localObject2, (List)localObject1, bool1, bool2);
  }
  
  public static EducationAnalytics readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building EducationAnalytics");
    }
    Object localObject1 = paramByteBuffer;
    int j;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building EducationAnalytics");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building EducationAnalytics");
    }
    if (((ByteBuffer)localObject2).getInt() != -776277535)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building EducationAnalytics");
    }
    paramString = null;
    localObject1 = null;
    boolean bool1;
    ArrayList localArrayList;
    label238:
    int k;
    Object localObject3;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool1 = true;
      if (!bool1) {
        break label359;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localArrayList = new ArrayList();
      paramString = localArrayList;
      if (j <= 0) {
        break label359;
      }
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
        localObject3 = FieldOfStudyBuilder.INSTANCE;
        paramString = FieldOfStudyBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label347;
        }
        i = 1;
      }
      label292:
      if (k == 1)
      {
        paramString = FieldOfStudyBuilder.INSTANCE;
        paramString = FieldOfStudyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (paramString == null) {
          break label353;
        }
      }
    }
    label347:
    label353:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label238;
      bool1 = false;
      break;
      i = 0;
      break label292;
    }
    label359:
    boolean bool2;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      if (!bool2) {
        break label526;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localArrayList = new ArrayList();
      label395:
      localObject1 = localArrayList;
      if (j <= 0) {
        break label526;
      }
      localObject1 = null;
      i = 1;
      k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        localObject3 = DegreeCountBuilder.INSTANCE;
        localObject1 = DegreeCountBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label514;
        }
        i = 1;
      }
      label455:
      if (k == 1)
      {
        localObject1 = DegreeCountBuilder.INSTANCE;
        localObject1 = DegreeCountBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label520;
        }
      }
    }
    label514:
    label520:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(localObject1);
      }
      j -= 1;
      break label395;
      bool2 = false;
      break;
      i = 0;
      break label455;
    }
    label526:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool1) {
      paramString = Collections.emptyList();
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    return new EducationAnalytics(paramString, (List)localObject1, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.EducationAnalyticsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */