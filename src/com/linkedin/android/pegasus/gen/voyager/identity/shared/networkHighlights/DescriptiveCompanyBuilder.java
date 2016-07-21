package com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompanyBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.HighlightsMiniProfileBuilder;
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

public final class DescriptiveCompanyBuilder
  implements FissileDataModelBuilder<DescriptiveCompany>, DataTemplateBuilder<DescriptiveCompany>
{
  public static final DescriptiveCompanyBuilder INSTANCE = new DescriptiveCompanyBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("company");
    JSON_KEY_STORE.put("numConnections");
    JSON_KEY_STORE.put("connections");
  }
  
  public static DescriptiveCompany build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    int i = 0;
    Object localObject1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("company", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MiniCompanyBuilder.INSTANCE;
        localObject2 = MiniCompanyBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("numConnections", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("connections", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            HighlightsMiniProfileBuilder localHighlightsMiniProfileBuilder = HighlightsMiniProfileBuilder.INSTANCE;
            ((List)localObject1).add(HighlightsMiniProfileBuilder.build(paramDataReader));
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
      throw new DataReaderException("Failed to find required field: company when building com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveCompany");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: numConnections when building com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveCompany");
    }
    return new DescriptiveCompany((MiniCompany)localObject2, i, (List)localObject1, bool3, bool2, bool1);
  }
  
  public static DescriptiveCompany readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building DescriptiveCompany");
    }
    Object localObject1 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building DescriptiveCompany");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building DescriptiveCompany");
    }
    if (((ByteBuffer)localObject2).getInt() != -1957801286)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building DescriptiveCompany");
    }
    paramString = null;
    Object localObject3 = null;
    int j = 0;
    localObject1 = null;
    boolean bool2;
    boolean bool1;
    label277:
    label303:
    label315:
    boolean bool3;
    label339:
    int k;
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
          localObject3 = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label482;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label488;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label494;
      }
      bool2 = true;
      if (bool2) {
        j = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label500;
      }
      bool3 = true;
      if (!bool3) {
        break label518;
      }
      k = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject3 = new ArrayList();
      label363:
      localObject1 = localObject3;
      if (k <= 0) {
        break label518;
      }
      localObject1 = null;
      i = 1;
      int m = ((ByteBuffer)localObject2).get();
      if (m == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        HighlightsMiniProfileBuilder localHighlightsMiniProfileBuilder = HighlightsMiniProfileBuilder.INSTANCE;
        localObject1 = HighlightsMiniProfileBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label506;
        }
        i = 1;
      }
      label423:
      if (m == 1)
      {
        localObject1 = HighlightsMiniProfileBuilder.INSTANCE;
        localObject1 = HighlightsMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label512;
        }
      }
    }
    label482:
    label488:
    label494:
    label500:
    label506:
    label512:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject3).add(localObject1);
      }
      k -= 1;
      break label363;
      bool2 = false;
      break;
      bool1 = false;
      break label277;
      bool1 = false;
      break label303;
      bool2 = false;
      break label315;
      bool3 = false;
      break label339;
      i = 0;
      break label423;
    }
    label518:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool3) {
      localObject1 = Collections.emptyList();
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: company when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveCompany from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: numConnections when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveCompany from fission.");
    }
    return new DescriptiveCompany(paramString, j, (List)localObject1, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveCompanyBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */