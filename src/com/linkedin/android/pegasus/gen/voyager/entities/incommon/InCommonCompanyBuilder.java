package com.linkedin.android.pegasus.gen.voyager.entities.incommon;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfileBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompanyBuilder;
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

public final class InCommonCompanyBuilder
  implements FissileDataModelBuilder<InCommonCompany>, DataTemplateBuilder<InCommonCompany>
{
  public static final InCommonCompanyBuilder INSTANCE = new InCommonCompanyBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("member");
    JSON_KEY_STORE.put("companies");
    JSON_KEY_STORE.put("total");
  }
  
  public static InCommonCompany build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("member", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = EntitiesMiniProfileBuilder.INSTANCE;
        localObject2 = EntitiesMiniProfileBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("companies", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            MiniCompanyBuilder localMiniCompanyBuilder = MiniCompanyBuilder.INSTANCE;
            ((List)localObject1).add(MiniCompanyBuilder.build(paramDataReader));
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
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: member when building com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompany");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: total when building com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompany");
    }
    return new InCommonCompany((EntitiesMiniProfile)localObject2, (List)localObject1, i, bool3, bool2, bool1);
  }
  
  public static InCommonCompany readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building InCommonCompany");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building InCommonCompany");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building InCommonCompany");
    }
    if (((ByteBuffer)localObject2).getInt() != 863216665)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building InCommonCompany");
    }
    paramString = null;
    Object localObject3 = null;
    localObject1 = null;
    int k = 0;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = (String)localObject3;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localObject3 = EntitiesMiniProfileBuilder.INSTANCE;
          paramString = EntitiesMiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label458;
          }
          bool1 = true;
        }
        label277:
        if (i == 1)
        {
          paramString = EntitiesMiniProfileBuilder.INSTANCE;
          paramString = EntitiesMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label464;
          }
          bool1 = true;
        }
      }
      label303:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label470;
      }
      bool2 = true;
      label315:
      if (!bool2) {
        break label488;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject3 = new ArrayList();
      label339:
      localObject1 = localObject3;
      if (j <= 0) {
        break label488;
      }
      localObject1 = null;
      i = 1;
      int m = ((ByteBuffer)localObject2).get();
      if (m == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        MiniCompanyBuilder localMiniCompanyBuilder = MiniCompanyBuilder.INSTANCE;
        localObject1 = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label476;
        }
        i = 1;
      }
      label399:
      if (m == 1)
      {
        localObject1 = MiniCompanyBuilder.INSTANCE;
        localObject1 = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label482;
        }
      }
    }
    label458:
    label464:
    label470:
    label476:
    label482:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject3).add(localObject1);
      }
      j -= 1;
      break label339;
      bool2 = false;
      break;
      bool1 = false;
      break label277;
      bool1 = false;
      break label303;
      bool2 = false;
      break label315;
      i = 0;
      break label399;
    }
    label488:
    if (((ByteBuffer)localObject2).get() == 1) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      i = k;
      if (bool3) {
        i = ((ByteBuffer)localObject2).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (!bool2) {
        localObject1 = Collections.emptyList();
      }
      if (bool1) {
        break;
      }
      throw new IOException("Failed to find required field: member when reading com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompany from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: total when reading com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompany from fission.");
    }
    return new InCommonCompany(paramString, (List)localObject1, i, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompanyBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */