package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
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

public final class SchoolFacetsBuilder
  implements FissileDataModelBuilder<SchoolFacets>, DataTemplateBuilder<SchoolFacets>
{
  public static final SchoolFacetsBuilder INSTANCE = new SchoolFacetsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("alumniJobFunctions");
    JSON_KEY_STORE.put("alumniLocations");
  }
  
  public static SchoolFacets build(DataReader paramDataReader)
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
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool3 = true;
      }
      else
      {
        Object localObject4;
        if (paramDataReader.shouldReadField$11ca93e7("alumniJobFunctions", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject4 = AlumniJobFunctionBuilder.INSTANCE;
              ((List)localObject2).add(AlumniJobFunctionBuilder.build(paramDataReader));
            }
          }
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("alumniLocations", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject4 = AlumniLocationBuilder.INSTANCE;
              ((List)localObject1).add(AlumniLocationBuilder.build(paramDataReader));
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
    if (!bool2) {
      localObject2 = Collections.emptyList();
    }
    if (!bool1) {
      localObject1 = Collections.emptyList();
    }
    return new SchoolFacets((Urn)localObject3, (List)localObject2, (List)localObject1, bool3, bool2, bool1);
  }
  
  public static SchoolFacets readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SchoolFacets");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SchoolFacets");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SchoolFacets");
    }
    if (((ByteBuffer)localObject2).getInt() != 2067235365)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building SchoolFacets");
    }
    Object localObject3 = null;
    paramString = null;
    localObject1 = null;
    boolean bool1;
    boolean bool2;
    label252:
    ArrayList localArrayList;
    label276:
    int k;
    Object localObject4;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool1 = true;
      if (bool1)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label385;
      }
      bool2 = true;
      if (!bool2) {
        break label403;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localArrayList = new ArrayList();
      paramString = localArrayList;
      if (j <= 0) {
        break label403;
      }
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
        localObject4 = AlumniJobFunctionBuilder.INSTANCE;
        paramString = AlumniJobFunctionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label391;
        }
        i = 1;
      }
      label330:
      if (k == 1)
      {
        paramString = AlumniJobFunctionBuilder.INSTANCE;
        paramString = AlumniJobFunctionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (paramString == null) {
          break label397;
        }
      }
    }
    label385:
    label391:
    label397:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label276;
      bool1 = false;
      break;
      bool2 = false;
      break label252;
      i = 0;
      break label330;
    }
    label403:
    boolean bool3;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool3 = true;
      if (!bool3) {
        break label570;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localArrayList = new ArrayList();
      label439:
      localObject1 = localArrayList;
      if (j <= 0) {
        break label570;
      }
      localObject1 = null;
      i = 1;
      k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        localObject4 = AlumniLocationBuilder.INSTANCE;
        localObject1 = AlumniLocationBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label558;
        }
        i = 1;
      }
      label499:
      if (k == 1)
      {
        localObject1 = AlumniLocationBuilder.INSTANCE;
        localObject1 = AlumniLocationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label564;
        }
      }
    }
    label558:
    label564:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(localObject1);
      }
      j -= 1;
      break label439;
      bool3 = false;
      break;
      i = 0;
      break label499;
    }
    label570:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool2) {
      paramString = Collections.emptyList();
    }
    if (!bool3) {
      localObject1 = Collections.emptyList();
    }
    return new SchoolFacets((Urn)localObject3, paramString, (List)localObject1, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolFacetsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */