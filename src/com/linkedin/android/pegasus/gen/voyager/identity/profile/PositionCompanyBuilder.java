package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
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

public final class PositionCompanyBuilder
  implements FissileDataModelBuilder<PositionCompany>, DataTemplateBuilder<PositionCompany>
{
  public static final PositionCompanyBuilder INSTANCE = new PositionCompanyBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniCompany");
    JSON_KEY_STORE.put("employeeCountRange");
    JSON_KEY_STORE.put("industries");
  }
  
  public static PositionCompany build(DataReader paramDataReader)
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
      if (paramDataReader.shouldReadField$11ca93e7("miniCompany", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = MiniCompanyBuilder.INSTANCE;
        localObject3 = MiniCompanyBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("employeeCountRange", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = EmployeeCountRangeBuilder.INSTANCE;
        localObject2 = EmployeeCountRangeBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("industries", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            String str = paramDataReader.readString();
            if (str != null) {
              ((List)localObject1).add(str);
            }
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      localObject1 = Collections.emptyList();
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: miniCompany when building com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompany");
    }
    return new PositionCompany((MiniCompany)localObject3, (EmployeeCountRange)localObject2, (List)localObject1, bool3, bool2, bool1);
  }
  
  public static PositionCompany readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PositionCompany");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PositionCompany");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building PositionCompany");
    }
    if (((ByteBuffer)localObject2).getInt() != -461902732)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building PositionCompany");
    }
    paramString = null;
    MiniCompanyBuilder localMiniCompanyBuilder = null;
    localObject1 = null;
    EmployeeCountRangeBuilder localEmployeeCountRangeBuilder = null;
    ArrayList localArrayList = null;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localMiniCompanyBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMiniCompanyBuilder = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label487;
          }
          bool1 = true;
        }
        label280:
        if (i == 1)
        {
          paramString = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label493;
          }
          bool1 = true;
        }
      }
      label306:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label499;
      }
      bool3 = true;
      label318:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localEmployeeCountRangeBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localEmployeeCountRangeBuilder = EmployeeCountRangeBuilder.INSTANCE;
          localObject1 = EmployeeCountRangeBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label505;
          }
          bool2 = true;
        }
        label380:
        if (i == 1)
        {
          localObject1 = EmployeeCountRangeBuilder.INSTANCE;
          localObject1 = EmployeeCountRangeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label511;
          }
          bool2 = true;
        }
      }
      label409:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label517;
      }
    }
    label487:
    label493:
    label499:
    label505:
    label511:
    label517:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramFissionTransaction = localArrayList;
      if (!bool3) {
        break label523;
      }
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localArrayList = new ArrayList();
      for (;;)
      {
        paramFissionTransaction = localArrayList;
        if (i <= 0) {
          break;
        }
        localArrayList.add(paramFissionAdapter.readString((ByteBuffer)localObject2));
        i -= 1;
      }
      bool2 = false;
      break;
      bool1 = false;
      break label280;
      bool1 = false;
      break label306;
      bool3 = false;
      break label318;
      bool2 = false;
      break label380;
      bool2 = false;
      break label409;
    }
    label523:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool3) {
      paramFissionTransaction = Collections.emptyList();
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: miniCompany when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompany from fission.");
    }
    return new PositionCompany(paramString, (EmployeeCountRange)localObject1, paramFissionTransaction, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompanyBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */