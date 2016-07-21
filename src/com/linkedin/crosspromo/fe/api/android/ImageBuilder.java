package com.linkedin.crosspromo.fe.api.android;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.crosspromo.common.android.Locale;
import com.linkedin.crosspromo.common.android.LocaleBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ImageBuilder
  implements FissileDataModelBuilder<Image>, DataTemplateBuilder<Image>
{
  public static final ImageBuilder INSTANCE = new ImageBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("url");
    JSON_KEY_STORE.put("aspectRatio");
    JSON_KEY_STORE.put("locale");
  }
  
  public static Image build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    float f = 0.0F;
    Object localObject = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("aspectRatio", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        f = paramDataReader.readFloat();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("locale", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = LocaleBuilder.INSTANCE;
        localObject = LocaleBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: url when building com.linkedin.crosspromo.fe.api.android.Image");
    }
    return new Image(str, f, (Locale)localObject, bool3, bool2, bool1);
  }
  
  public static Image readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Image");
    }
    Object localObject2 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Image");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Image");
    }
    if (((ByteBuffer)localObject1).getInt() != 403486135)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Image");
    }
    localObject2 = null;
    float f = 0.0F;
    paramString = null;
    LocaleBuilder localLocaleBuilder = null;
    boolean bool3;
    boolean bool4;
    label247:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label387;
      }
      bool4 = true;
      if (bool4) {
        f = ((ByteBuffer)localObject1).getFloat();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label393;
      }
      bool1 = true;
      label271:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localLocaleBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localLocaleBuilder = LocaleBuilder.INSTANCE;
          paramString = LocaleBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label399;
          }
          bool1 = true;
        }
        label324:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = LocaleBuilder.INSTANCE;
          paramString = LocaleBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label405;
          }
        }
      }
    }
    label387:
    label393:
    label399:
    label405:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label411;
      }
      throw new IOException("Failed to find required field: url when reading com.linkedin.crosspromo.fe.api.android.Image from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label247;
      bool1 = false;
      break label271;
      bool1 = false;
      break label324;
    }
    label411:
    return new Image((String)localObject2, f, paramString, bool3, bool4, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.crosspromo.fe.api.android.ImageBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */