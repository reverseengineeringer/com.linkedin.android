package com.linkedin.android.pegasus.gen.voyager.entities.job.analytics;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSkill;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSkillBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class TopSkillBuilder
  implements FissileDataModelBuilder<TopSkill>, DataTemplateBuilder<TopSkill>
{
  public static final TopSkillBuilder INSTANCE = new TopSkillBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniSkill");
    JSON_KEY_STORE.put("count");
    JSON_KEY_STORE.put("sharedSkill");
  }
  
  public static TopSkill build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    long l = 0L;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("miniSkill", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = MiniSkillBuilder.INSTANCE;
        localObject = MiniSkillBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("count", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("sharedSkill", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool4 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: miniSkill when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkill");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: count when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkill");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: sharedSkill when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkill");
    }
    return new TopSkill((MiniSkill)localObject, l, bool4, bool3, bool1, bool2);
  }
  
  public static TopSkill readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building TopSkill");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building TopSkill");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building TopSkill");
    }
    if (((ByteBuffer)localObject1).getInt() != -1223433540)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building TopSkill");
    }
    paramString = null;
    localObject2 = null;
    long l = 0L;
    boolean bool5 = false;
    boolean bool1;
    label277:
    label303:
    boolean bool3;
    label315:
    boolean bool4;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = (String)localObject2;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localObject2 = MiniSkillBuilder.INSTANCE;
          paramString = MiniSkillBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label393;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniSkillBuilder.INSTANCE;
          paramString = MiniSkillBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label399;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label405;
      }
      bool3 = true;
      if (bool3) {
        l = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label411;
      }
      bool4 = true;
      label339:
      bool2 = bool5;
      if (bool4) {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label417;
        }
      }
    }
    label393:
    label399:
    label405:
    label411:
    label417:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label423;
      }
      throw new IOException("Failed to find required field: miniSkill when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkill from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label277;
      bool1 = false;
      break label303;
      bool3 = false;
      break label315;
      bool4 = false;
      break label339;
    }
    label423:
    if (!bool3) {
      throw new IOException("Failed to find required field: count when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkill from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: sharedSkill when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkill from fission.");
    }
    return new TopSkill(paramString, l, bool2, bool1, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkillBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */