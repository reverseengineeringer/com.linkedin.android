package com.linkedin.android.pegasus.gen.voyager.search.shared;

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

public final class SearchSpellingCorrectionBuilder
  implements FissileDataModelBuilder<SearchSpellingCorrection>, DataTemplateBuilder<SearchSpellingCorrection>
{
  public static final SearchSpellingCorrectionBuilder INSTANCE = new SearchSpellingCorrectionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("suggestion");
    JSON_KEY_STORE.put("spellingCorrectionType");
    JSON_KEY_STORE.put("originalSearchCount");
  }
  
  public static SearchSpellingCorrection build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    SpellingCorrectionType localSpellingCorrectionType = null;
    int i = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("suggestion", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("spellingCorrectionType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSpellingCorrectionType = (SpellingCorrectionType)paramDataReader.readEnum(SpellingCorrectionType.Builder.INSTANCE);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("originalSearchCount", JSON_KEY_STORE))
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
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: suggestion when building com.linkedin.android.pegasus.gen.voyager.search.shared.SearchSpellingCorrection");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: spellingCorrectionType when building com.linkedin.android.pegasus.gen.voyager.search.shared.SearchSpellingCorrection");
    }
    return new SearchSpellingCorrection(str, localSpellingCorrectionType, i, bool3, bool2, bool1);
  }
  
  public static SearchSpellingCorrection readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool3 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SearchSpellingCorrection");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchSpellingCorrection");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchSpellingCorrection");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != 626252773)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building SearchSpellingCorrection");
    }
    paramString = null;
    paramFissionTransaction = null;
    int i = 0;
    boolean bool1;
    boolean bool2;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label314;
      }
      bool2 = true;
      label243:
      if (bool2) {
        paramFissionTransaction = SpellingCorrectionType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label320;
      }
    }
    for (;;)
    {
      if (bool3) {
        i = ((ByteBuffer)localObject).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label326;
      }
      throw new IOException("Failed to find required field: suggestion when reading com.linkedin.android.pegasus.gen.voyager.search.shared.SearchSpellingCorrection from fission.");
      bool1 = false;
      break;
      label314:
      bool2 = false;
      break label243;
      label320:
      bool3 = false;
    }
    label326:
    if (!bool2) {
      throw new IOException("Failed to find required field: spellingCorrectionType when reading com.linkedin.android.pegasus.gen.voyager.search.shared.SearchSpellingCorrection from fission.");
    }
    return new SearchSpellingCorrection(paramString, paramFissionTransaction, i, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.shared.SearchSpellingCorrectionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */