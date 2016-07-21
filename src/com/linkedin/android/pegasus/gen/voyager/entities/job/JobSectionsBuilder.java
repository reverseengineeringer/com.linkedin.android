package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Section;
import com.linkedin.android.pegasus.gen.voyager.entities.common.SectionBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class JobSectionsBuilder
  implements FissileDataModelBuilder<JobSections>, DataTemplateBuilder<JobSections>
{
  public static final JobSectionsBuilder INSTANCE = new JobSectionsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("highlights");
    JSON_KEY_STORE.put("details");
    JSON_KEY_STORE.put("insights");
  }
  
  public static JobSections build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("highlights", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = SectionBuilder.INSTANCE;
        localObject3 = SectionBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("details", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = SectionBuilder.INSTANCE;
        localObject2 = SectionBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("insights", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = SectionBuilder.INSTANCE;
        localObject1 = SectionBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new JobSections((Section)localObject3, (Section)localObject2, (Section)localObject1, bool3, bool2, bool1);
  }
  
  public static JobSections readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building JobSections");
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
          localObject3 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building JobSections");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building JobSections");
    }
    if (((ByteBuffer)localObject3).getInt() != -1455318527)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building JobSections");
    }
    paramString = null;
    SectionBuilder localSectionBuilder3 = null;
    localObject1 = null;
    SectionBuilder localSectionBuilder2 = null;
    Object localObject2 = null;
    SectionBuilder localSectionBuilder1 = null;
    boolean bool2;
    boolean bool1;
    label283:
    label309:
    boolean bool3;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = localSectionBuilder3;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localSectionBuilder3 = SectionBuilder.INSTANCE;
          paramString = SectionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label552;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = SectionBuilder.INSTANCE;
          paramString = SectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label558;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label564;
      }
      bool3 = true;
      label321:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localSectionBuilder2;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localSectionBuilder2 = SectionBuilder.INSTANCE;
          localObject1 = SectionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label570;
          }
          bool2 = true;
        }
        label383:
        if (i == 1)
        {
          localObject1 = SectionBuilder.INSTANCE;
          localObject1 = SectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label576;
          }
          bool2 = true;
        }
      }
      label412:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label582;
      }
      bool3 = true;
      label424:
      bool4 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localSectionBuilder1;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localSectionBuilder1 = SectionBuilder.INSTANCE;
          localObject2 = SectionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label588;
          }
          bool3 = true;
        }
        label482:
        bool4 = bool3;
        if (i == 1)
        {
          localObject2 = SectionBuilder.INSTANCE;
          localObject2 = SectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label594;
          }
        }
      }
    }
    label552:
    label558:
    label564:
    label570:
    label576:
    label582:
    label588:
    label594:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      return new JobSections(paramString, (Section)localObject1, (Section)localObject2, bool1, bool2, bool4);
      bool2 = false;
      break;
      bool1 = false;
      break label283;
      bool1 = false;
      break label309;
      bool3 = false;
      break label321;
      bool2 = false;
      break label383;
      bool2 = false;
      break label412;
      bool3 = false;
      break label424;
      bool3 = false;
      break label482;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.JobSectionsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */