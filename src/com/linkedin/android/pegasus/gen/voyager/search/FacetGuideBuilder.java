package com.linkedin.android.pegasus.gen.voyager.search;

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

public final class FacetGuideBuilder
  implements FissileDataModelBuilder<FacetGuide>, DataTemplateBuilder<FacetGuide>
{
  public static final FacetGuideBuilder INSTANCE = new FacetGuideBuilder();
  private static final JsonKeyStore JSON_KEY_STORE = new HashStringKeyStore();
  
  public static FacetGuide build(DataReader paramDataReader)
    throws DataReaderException
  {
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {}
    return new FacetGuide();
  }
  
  public static FacetGuide readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building FacetGuide");
    }
    Object localObject1 = paramByteBuffer;
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
          localObject2 = paramString;
          if (i != 0) {
            break label167;
          }
          localObject1 = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject1 = paramFissionAdapter.readFromCache((String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break;
          }
          j = ((ByteBuffer)localObject1).get();
          paramString = (String)localObject1;
          i = j;
        } while (j == 1);
        paramString = (String)localObject1;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building FacetGuide");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building FacetGuide");
    }
    label167:
    if (((ByteBuffer)localObject2).getInt() != -387441540)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building FacetGuide");
    }
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    return new FacetGuide();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.FacetGuideBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */