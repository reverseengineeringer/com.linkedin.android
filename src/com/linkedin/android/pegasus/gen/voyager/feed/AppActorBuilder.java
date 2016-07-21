package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.ImageBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class AppActorBuilder
  implements FissileDataModelBuilder<AppActor>, DataTemplateBuilder<AppActor>
{
  public static final AppActorBuilder INSTANCE = new AppActorBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("appId");
    JSON_KEY_STORE.put("appName");
    JSON_KEY_STORE.put("subtitle");
    JSON_KEY_STORE.put("appIcon");
    JSON_KEY_STORE.put("deeplink");
    JSON_KEY_STORE.put("storeUrl");
    JSON_KEY_STORE.put("showActionButton");
  }
  
  public static AppActor build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str5 = null;
    String str4 = null;
    String str3 = null;
    Object localObject = null;
    String str2 = null;
    String str1 = null;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("appId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("appName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("subtitle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("appIcon", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ImageBuilder.INSTANCE;
        localObject = ImageBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("deeplink", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("storeUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("showActionButton", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool8 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: appId when building com.linkedin.android.pegasus.gen.voyager.feed.AppActor");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: appName when building com.linkedin.android.pegasus.gen.voyager.feed.AppActor");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: subtitle when building com.linkedin.android.pegasus.gen.voyager.feed.AppActor");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: appIcon when building com.linkedin.android.pegasus.gen.voyager.feed.AppActor");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: deeplink when building com.linkedin.android.pegasus.gen.voyager.feed.AppActor");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: storeUrl when building com.linkedin.android.pegasus.gen.voyager.feed.AppActor");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: showActionButton when building com.linkedin.android.pegasus.gen.voyager.feed.AppActor");
    }
    return new AppActor(str5, str4, str3, (Image)localObject, str2, str1, bool8, bool7, bool6, bool5, bool4, bool3, bool1, bool2);
  }
  
  public static AppActor readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building AppActor");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building AppActor");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building AppActor");
    }
    if (((ByteBuffer)localObject1).getInt() != 1429191708)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building AppActor");
    }
    localObject2 = null;
    String str1 = null;
    String str2 = null;
    paramString = null;
    ImageBuilder localImageBuilder = null;
    Object localObject3 = null;
    String str3 = null;
    boolean bool9 = false;
    boolean bool3;
    boolean bool4;
    label259:
    boolean bool5;
    label286:
    label313:
    boolean bool1;
    label370:
    label396:
    boolean bool6;
    label408:
    boolean bool7;
    label437:
    boolean bool8;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label518;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label524;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label530;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localImageBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localImageBuilder = ImageBuilder.INSTANCE;
          paramString = ImageBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label536;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ImageBuilder.INSTANCE;
          paramString = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label542;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label548;
      }
      bool6 = true;
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool6) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label554;
      }
      bool7 = true;
      if (bool7) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label560;
      }
      bool8 = true;
      label464:
      bool2 = bool9;
      if (bool8) {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label566;
        }
      }
    }
    label518:
    label524:
    label530:
    label536:
    label542:
    label548:
    label554:
    label560:
    label566:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label572;
      }
      throw new IOException("Failed to find required field: appId when reading com.linkedin.android.pegasus.gen.voyager.feed.AppActor from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label259;
      bool5 = false;
      break label286;
      bool2 = false;
      break label313;
      bool1 = false;
      break label370;
      bool1 = false;
      break label396;
      bool6 = false;
      break label408;
      bool7 = false;
      break label437;
      bool8 = false;
      break label464;
    }
    label572:
    if (!bool4) {
      throw new IOException("Failed to find required field: appName when reading com.linkedin.android.pegasus.gen.voyager.feed.AppActor from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: subtitle when reading com.linkedin.android.pegasus.gen.voyager.feed.AppActor from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: appIcon when reading com.linkedin.android.pegasus.gen.voyager.feed.AppActor from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: deeplink when reading com.linkedin.android.pegasus.gen.voyager.feed.AppActor from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: storeUrl when reading com.linkedin.android.pegasus.gen.voyager.feed.AppActor from fission.");
    }
    if (!bool8) {
      throw new IOException("Failed to find required field: showActionButton when reading com.linkedin.android.pegasus.gen.voyager.feed.AppActor from fission.");
    }
    return new AppActor((String)localObject2, str1, str2, paramString, paramFissionTransaction, str3, bool2, bool3, bool4, bool5, bool1, bool6, bool7, bool8);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.AppActorBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */