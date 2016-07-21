package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

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

public final class OccupationHighlightBuilder
  implements FissileDataModelBuilder<OccupationHighlight>, DataTemplateBuilder<OccupationHighlight>
{
  public static final OccupationHighlightBuilder INSTANCE = new OccupationHighlightBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("numViews");
    JSON_KEY_STORE.put("viewerTitle");
  }
  
  public static OccupationHighlight build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    String str = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("numViews", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("viewerTitle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: numViews when building com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.OccupationHighlight");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: viewerTitle when building com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.OccupationHighlight");
    }
    return new OccupationHighlight(l, str, bool2, bool1);
  }
  
  public static OccupationHighlight readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building OccupationHighlight");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      int i = paramString.get();
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
      throw new IOException("Invalid header prefix. Can't read cached data when building OccupationHighlight");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building OccupationHighlight");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != -960217302)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building OccupationHighlight");
    }
    long l = 0L;
    paramString = null;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        l = ((ByteBuffer)localObject).getLong();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label283;
      }
    }
    for (;;)
    {
      if (bool2) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label289;
      }
      throw new IOException("Failed to find required field: numViews when reading com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.OccupationHighlight from fission.");
      bool1 = false;
      break;
      label283:
      bool2 = false;
    }
    label289:
    if (!bool2) {
      throw new IOException("Failed to find required field: viewerTitle when reading com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.OccupationHighlight from fission.");
    }
    return new OccupationHighlight(l, paramString, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.OccupationHighlightBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */