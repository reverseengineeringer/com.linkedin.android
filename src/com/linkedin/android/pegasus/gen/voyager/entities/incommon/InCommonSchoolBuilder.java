package com.linkedin.android.pegasus.gen.voyager.entities.incommon;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistanceBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchoolBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
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

public final class InCommonSchoolBuilder
  implements FissileDataModelBuilder<InCommonSchool>, DataTemplateBuilder<InCommonSchool>
{
  public static final InCommonSchoolBuilder INSTANCE = new InCommonSchoolBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniSchool");
    JSON_KEY_STORE.put("people");
    JSON_KEY_STORE.put("peopleWithDistance");
    JSON_KEY_STORE.put("total");
  }
  
  public static InCommonSchool build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("miniSchool", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = MiniSchoolBuilder.INSTANCE;
        localObject3 = MiniSchoolBuilder.build(paramDataReader);
        bool4 = true;
      }
      else
      {
        Object localObject4;
        if (paramDataReader.shouldReadField$11ca93e7("people", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject4 = MiniProfileBuilder.INSTANCE;
              ((List)localObject2).add(MiniProfileBuilder.build(paramDataReader));
            }
          }
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("peopleWithDistance", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject4 = MiniProfileWithDistanceBuilder.INSTANCE;
              ((List)localObject1).add(MiniProfileWithDistanceBuilder.build(paramDataReader));
            }
          }
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("total", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          i = paramDataReader.readInt();
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
    }
    if (!bool3) {
      localObject2 = Collections.emptyList();
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: miniSchool when building com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchool");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: total when building com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchool");
    }
    return new InCommonSchool((MiniSchool)localObject3, (List)localObject2, (List)localObject1, i, bool4, bool3, bool2, bool1);
  }
  
  public static InCommonSchool readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building InCommonSchool");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building InCommonSchool");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building InCommonSchool");
    }
    if (((ByteBuffer)localObject3).getInt() != -601848268)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building InCommonSchool");
    }
    paramString = null;
    Object localObject4 = null;
    localObject1 = null;
    Object localObject2 = null;
    int k = 0;
    boolean bool2;
    boolean bool1;
    label280:
    label306:
    label318:
    label342:
    int m;
    Object localObject5;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = (String)localObject4;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localObject4 = MiniSchoolBuilder.INSTANCE;
          paramString = MiniSchoolBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label461;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniSchoolBuilder.INSTANCE;
          paramString = MiniSchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label467;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label473;
      }
      bool2 = true;
      if (!bool2) {
        break label491;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localObject4 = new ArrayList();
      localObject1 = localObject4;
      if (j <= 0) {
        break label491;
      }
      localObject1 = null;
      i = 1;
      m = ((ByteBuffer)localObject3).get();
      if (m == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
        localObject5 = MiniProfileBuilder.INSTANCE;
        localObject1 = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label479;
        }
        i = 1;
      }
      label402:
      if (m == 1)
      {
        localObject1 = MiniProfileBuilder.INSTANCE;
        localObject1 = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label485;
        }
      }
    }
    label461:
    label467:
    label473:
    label479:
    label485:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject4).add(localObject1);
      }
      j -= 1;
      break label342;
      bool2 = false;
      break;
      bool1 = false;
      break label280;
      bool1 = false;
      break label306;
      bool2 = false;
      break label318;
      i = 0;
      break label402;
    }
    label491:
    boolean bool3;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool3 = true;
      if (!bool3) {
        break label658;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localObject4 = new ArrayList();
      label527:
      localObject2 = localObject4;
      if (j <= 0) {
        break label658;
      }
      localObject2 = null;
      i = 1;
      m = ((ByteBuffer)localObject3).get();
      if (m == 0)
      {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
        localObject5 = MiniProfileWithDistanceBuilder.INSTANCE;
        localObject2 = MiniProfileWithDistanceBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
        if (localObject2 == null) {
          break label646;
        }
        i = 1;
      }
      label587:
      if (m == 1)
      {
        localObject2 = MiniProfileWithDistanceBuilder.INSTANCE;
        localObject2 = MiniProfileWithDistanceBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (localObject2 == null) {
          break label652;
        }
      }
    }
    label646:
    label652:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject4).add(localObject2);
      }
      j -= 1;
      break label527;
      bool3 = false;
      break;
      i = 0;
      break label587;
    }
    label658:
    if (((ByteBuffer)localObject3).get() == 1) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      i = k;
      if (bool4) {
        i = ((ByteBuffer)localObject3).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (!bool2) {
        localObject1 = Collections.emptyList();
      }
      if (!bool3) {
        localObject2 = Collections.emptyList();
      }
      if (bool1) {
        break;
      }
      throw new IOException("Failed to find required field: miniSchool when reading com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchool from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: total when reading com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchool from fission.");
    }
    return new InCommonSchool(paramString, (List)localObject1, (List)localObject2, i, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchoolBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */