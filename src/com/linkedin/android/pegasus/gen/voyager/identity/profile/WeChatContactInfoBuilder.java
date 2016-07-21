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

public final class WeChatContactInfoBuilder
  implements FissileDataModelBuilder<WeChatContactInfo>, DataTemplateBuilder<WeChatContactInfo>
{
  public static final WeChatContactInfoBuilder INSTANCE = new WeChatContactInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("name");
    JSON_KEY_STORE.put("weChatHandle");
    JSON_KEY_STORE.put("qr");
  }
  
  public static WeChatContactInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    String str2 = null;
    String str1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("name", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("weChatHandle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("qr", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: name when building com.linkedin.android.pegasus.gen.voyager.identity.profile.WeChatContactInfo");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: qr when building com.linkedin.android.pegasus.gen.voyager.identity.profile.WeChatContactInfo");
    }
    return new WeChatContactInfo(str3, str2, str1, bool3, bool2, bool1);
  }
  
  public static WeChatContactInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool3 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building WeChatContactInfo");
    }
    Object localObject2 = paramByteBuffer;
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
          localObject1 = paramString;
          if (i != 0) {
            break label170;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building WeChatContactInfo");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building WeChatContactInfo");
    }
    label170:
    if (((ByteBuffer)localObject1).getInt() != -1182339523)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building WeChatContactInfo");
    }
    paramString = null;
    paramFissionTransaction = null;
    localObject2 = null;
    boolean bool1;
    boolean bool2;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label314;
      }
      bool2 = true;
      label243:
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label320;
      }
    }
    for (;;)
    {
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label326;
      }
      throw new IOException("Failed to find required field: name when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.WeChatContactInfo from fission.");
      bool1 = false;
      break;
      label314:
      bool2 = false;
      break label243;
      label320:
      bool3 = false;
    }
    label326:
    if (!bool3) {
      throw new IOException("Failed to find required field: qr when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.WeChatContactInfo from fission.");
    }
    return new WeChatContactInfo(paramString, paramFissionTransaction, (String)localObject2, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.WeChatContactInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */