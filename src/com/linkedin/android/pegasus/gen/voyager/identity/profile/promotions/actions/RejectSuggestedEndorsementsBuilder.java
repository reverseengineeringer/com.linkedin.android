package com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions;

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
import java.util.ArrayList;
import java.util.List;

public final class RejectSuggestedEndorsementsBuilder
  implements FissileDataModelBuilder<RejectSuggestedEndorsements>, DataTemplateBuilder<RejectSuggestedEndorsements>
{
  public static final RejectSuggestedEndorsementsBuilder INSTANCE = new RejectSuggestedEndorsementsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("signatures");
  }
  
  public static RejectSuggestedEndorsements build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("signatures", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            String str = paramDataReader.readString();
            if (str != null) {
              localArrayList.add(str);
            }
          }
        }
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool) {
      throw new DataReaderException("Failed to find required field: signatures when building com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions.RejectSuggestedEndorsements");
    }
    return new RejectSuggestedEndorsements(localArrayList, bool);
  }
  
  public static RejectSuggestedEndorsements readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building RejectSuggestedEndorsements");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building RejectSuggestedEndorsements");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building RejectSuggestedEndorsements");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != -1082933163)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building RejectSuggestedEndorsements");
    }
    paramString = null;
    if (((ByteBuffer)localObject).get() == 1) {}
    while (bool)
    {
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject);
      paramFissionTransaction = new ArrayList();
      for (;;)
      {
        paramString = paramFissionTransaction;
        if (i <= 0) {
          break;
        }
        paramFissionTransaction.add(paramFissionAdapter.readString((ByteBuffer)localObject));
        i -= 1;
      }
      bool = false;
    }
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
    }
    if (!bool) {
      throw new IOException("Failed to find required field: signatures when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions.RejectSuggestedEndorsements from fission.");
    }
    return new RejectSuggestedEndorsements(paramString, bool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions.RejectSuggestedEndorsementsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */