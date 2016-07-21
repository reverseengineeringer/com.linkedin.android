package com.linkedin.android.pegasus.gen.voyager.entities.shared;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.ImageBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MiniGroupBuilder
  implements FissileDataModelBuilder<MiniGroup>, DataTemplateBuilder<MiniGroup>
{
  public static final MiniGroupBuilder INSTANCE = new MiniGroupBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("trackingId");
    JSON_KEY_STORE.put("objectUrn");
    JSON_KEY_STORE.put("entityUrn");
    JSON_KEY_STORE.put("groupName");
    JSON_KEY_STORE.put("groupDescription");
    JSON_KEY_STORE.put("logo");
    JSON_KEY_STORE.put("recentActivityCount");
  }
  
  public static MiniGroup build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    String str2 = null;
    String str1 = null;
    Object localObject1 = null;
    int i = 0;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("objectUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("groupName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("groupDescription", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("logo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = ImageBuilder.INSTANCE;
        localObject1 = ImageBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("recentActivityCount", JSON_KEY_STORE))
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
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: groupName when building com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup");
    }
    return new MiniGroup(str3, (Urn)localObject3, (Urn)localObject2, str2, str1, (Image)localObject1, i, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static MiniGroup readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building MiniGroup");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building MiniGroup");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building MiniGroup");
    }
    if (((ByteBuffer)localObject1).getInt() != -1426750681)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building MiniGroup");
    }
    localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    String str1 = null;
    String str2 = null;
    paramString = null;
    ImageBuilder localImageBuilder = null;
    int i = 0;
    boolean bool3;
    boolean bool4;
    label259:
    boolean bool5;
    label294:
    boolean bool6;
    label329:
    boolean bool7;
    label356:
    label383:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label523;
      }
      bool4 = true;
      if (bool4)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label529;
      }
      bool5 = true;
      if (bool5)
      {
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label535;
      }
      bool6 = true;
      if (bool6) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label541;
      }
      bool7 = true;
      if (bool7) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label547;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject1).get();
        paramString = localImageBuilder;
        bool1 = bool2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localImageBuilder = ImageBuilder.INSTANCE;
          paramString = ImageBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label553;
          }
          bool1 = true;
        }
        label440:
        if (j == 1)
        {
          paramString = ImageBuilder.INSTANCE;
          paramString = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label559;
          }
          bool1 = true;
        }
      }
      label466:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label565;
      }
    }
    label523:
    label529:
    label535:
    label541:
    label547:
    label553:
    label559:
    label565:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (bool2) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool5) {
        break label571;
      }
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label259;
      bool5 = false;
      break label294;
      bool6 = false;
      break label329;
      bool7 = false;
      break label356;
      bool2 = false;
      break label383;
      bool1 = false;
      break label440;
      bool1 = false;
      break label466;
    }
    label571:
    if (!bool6) {
      throw new IOException("Failed to find required field: groupName when reading com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup from fission.");
    }
    return new MiniGroup((String)localObject2, (Urn)localObject3, (Urn)localObject4, str1, str2, paramString, i, bool3, bool4, bool5, bool6, bool7, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroupBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */