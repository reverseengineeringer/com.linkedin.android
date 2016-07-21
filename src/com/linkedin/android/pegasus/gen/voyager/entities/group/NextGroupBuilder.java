package com.linkedin.android.pegasus.gen.voyager.entities.group;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroupBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class NextGroupBuilder
  implements FissileDataModelBuilder<NextGroup>, DataTemplateBuilder<NextGroup>
{
  public static final NextGroupBuilder INSTANCE = new NextGroupBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("miniGroup");
    JSON_KEY_STORE.put("recentPostAt");
    JSON_KEY_STORE.put("memberCount");
  }
  
  public static NextGroup build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    long l = 0L;
    int i = 0;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("miniGroup", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = MiniGroupBuilder.INSTANCE;
        localObject1 = MiniGroupBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("recentPostAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("memberCount", JSON_KEY_STORE))
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
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.entities.group.NextGroup");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: miniGroup when building com.linkedin.android.pegasus.gen.voyager.entities.group.NextGroup");
    }
    return new NextGroup((Urn)localObject2, (MiniGroup)localObject1, l, i, bool4, bool3, bool2, bool1);
  }
  
  public static NextGroup readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building NextGroup");
    }
    Object localObject2 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building NextGroup");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building NextGroup");
    }
    if (((ByteBuffer)localObject1).getInt() != -2120030935)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building NextGroup");
    }
    localObject2 = null;
    paramString = null;
    MiniGroupBuilder localMiniGroupBuilder = null;
    long l = 0L;
    int i = 0;
    boolean bool3;
    boolean bool2;
    label258:
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
        break label422;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject1).get();
        paramString = localMiniGroupBuilder;
        bool1 = bool2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localMiniGroupBuilder = MiniGroupBuilder.INSTANCE;
          paramString = MiniGroupBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label428;
          }
          bool1 = true;
        }
        label315:
        if (j == 1)
        {
          paramString = MiniGroupBuilder.INSTANCE;
          paramString = MiniGroupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label434;
          }
          bool1 = true;
        }
      }
      label341:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label440;
      }
      bool2 = true;
      label353:
      if (bool2) {
        l = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label446;
      }
    }
    label422:
    label428:
    label434:
    label440:
    label446:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (bool4) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label452;
      }
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.entities.group.NextGroup from fission.");
      bool3 = false;
      break;
      bool2 = false;
      break label258;
      bool1 = false;
      break label315;
      bool1 = false;
      break label341;
      bool2 = false;
      break label353;
    }
    label452:
    if (!bool1) {
      throw new IOException("Failed to find required field: miniGroup when reading com.linkedin.android.pegasus.gen.voyager.entities.group.NextGroup from fission.");
    }
    return new NextGroup((Urn)localObject2, paramString, l, i, bool3, bool1, bool2, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.group.NextGroupBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */