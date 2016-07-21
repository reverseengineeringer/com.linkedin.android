package com.linkedin.android.pegasus.gen.voyager.identity.profile;

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

public final class PictureBuilder
  implements FissileDataModelBuilder<Picture>, DataTemplateBuilder<Picture>
{
  public static final PictureBuilder INSTANCE = new PictureBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("croppedImage");
    JSON_KEY_STORE.put("masterImage");
    JSON_KEY_STORE.put("cropInfo");
  }
  
  public static Picture build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    Object localObject = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("croppedImage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("masterImage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("cropInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ImageCropInfoBuilder.INSTANCE;
        localObject = ImageCropInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: croppedImage when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: masterImage when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: cropInfo when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture");
    }
    return new Picture(str2, str1, (ImageCropInfo)localObject, bool3, bool2, bool1);
  }
  
  public static Picture readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Picture");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Picture");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Picture");
    }
    if (((ByteBuffer)localObject1).getInt() != -156864988)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Picture");
    }
    localObject2 = null;
    String str = null;
    paramString = null;
    ImageCropInfoBuilder localImageCropInfoBuilder = null;
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
        break label390;
      }
      bool4 = true;
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label396;
      }
      bool1 = true;
      label274:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localImageCropInfoBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localImageCropInfoBuilder = ImageCropInfoBuilder.INSTANCE;
          paramString = ImageCropInfoBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label402;
          }
          bool1 = true;
        }
        label327:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = ImageCropInfoBuilder.INSTANCE;
          paramString = ImageCropInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label408;
          }
        }
      }
    }
    label390:
    label396:
    label402:
    label408:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label414;
      }
      throw new IOException("Failed to find required field: croppedImage when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label247;
      bool1 = false;
      break label274;
      bool1 = false;
      break label327;
    }
    label414:
    if (!bool4) {
      throw new IOException("Failed to find required field: masterImage when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: cropInfo when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture from fission.");
    }
    return new Picture((String)localObject2, str, paramString, bool3, bool4, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.PictureBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */