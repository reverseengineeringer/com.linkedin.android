package com.linkedin.android.pegasus.gen.voyager.premium.shared;

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

public final class ProfinderMiniRequestForProposalsBuilder
  implements FissileDataModelBuilder<ProfinderMiniRequestForProposals>, DataTemplateBuilder<ProfinderMiniRequestForProposals>
{
  public static final ProfinderMiniRequestForProposalsBuilder INSTANCE = new ProfinderMiniRequestForProposalsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("serviceCategoryName");
    JSON_KEY_STORE.put("totalNonActionedProposalCount");
  }
  
  public static ProfinderMiniRequestForProposals build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    int i = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("serviceCategoryName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("totalNonActionedProposalCount", JSON_KEY_STORE))
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
      throw new DataReaderException("Failed to find required field: serviceCategoryName when building com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderMiniRequestForProposals");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: totalNonActionedProposalCount when building com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderMiniRequestForProposals");
    }
    return new ProfinderMiniRequestForProposals(str, i, bool2, bool1);
  }
  
  public static ProfinderMiniRequestForProposals readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ProfinderMiniRequestForProposals");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
          localObject = paramString;
          if (i != 0) {
            break label170;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            break;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building ProfinderMiniRequestForProposals");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building ProfinderMiniRequestForProposals");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != -992310964)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building ProfinderMiniRequestForProposals");
    }
    paramString = null;
    int i = 0;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label283;
      }
    }
    for (;;)
    {
      if (bool2) {
        i = ((ByteBuffer)localObject).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label289;
      }
      throw new IOException("Failed to find required field: serviceCategoryName when reading com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderMiniRequestForProposals from fission.");
      bool1 = false;
      break;
      label283:
      bool2 = false;
    }
    label289:
    if (!bool2) {
      throw new IOException("Failed to find required field: totalNonActionedProposalCount when reading com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderMiniRequestForProposals from fission.");
    }
    return new ProfinderMiniRequestForProposals(paramString, i, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderMiniRequestForProposalsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */