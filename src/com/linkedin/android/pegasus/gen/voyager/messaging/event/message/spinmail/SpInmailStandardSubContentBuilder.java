package com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail;

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

public final class SpInmailStandardSubContentBuilder
  implements FissileDataModelBuilder<SpInmailStandardSubContent>, DataTemplateBuilder<SpInmailStandardSubContent>
{
  public static final SpInmailStandardSubContentBuilder INSTANCE = new SpInmailStandardSubContentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("actionText");
    JSON_KEY_STORE.put("action");
    JSON_KEY_STORE.put("actionTracking");
    JSON_KEY_STORE.put("adUnit");
  }
  
  public static SpInmailStandardSubContent build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    String str2 = null;
    String str1 = null;
    Object localObject = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("actionText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("action", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actionTracking", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("adUnit", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = SpInmailAdUnitBuilder.INSTANCE;
        localObject = SpInmailAdUnitBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: actionText when building com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailStandardSubContent");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: action when building com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailStandardSubContent");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: actionTracking when building com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailStandardSubContent");
    }
    return new SpInmailStandardSubContent(str3, str2, str1, (SpInmailAdUnit)localObject, bool4, bool3, bool2, bool1);
  }
  
  public static SpInmailStandardSubContent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SpInmailStandardSubContent");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SpInmailStandardSubContent");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SpInmailStandardSubContent");
    }
    if (((ByteBuffer)localObject1).getInt() != 440064875)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SpInmailStandardSubContent");
    }
    localObject2 = null;
    String str1 = null;
    String str2 = null;
    paramString = null;
    SpInmailAdUnitBuilder localSpInmailAdUnitBuilder = null;
    boolean bool3;
    boolean bool4;
    label250:
    boolean bool5;
    label277:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label420;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label426;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label432;
      }
      bool1 = true;
      label304:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localSpInmailAdUnitBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localSpInmailAdUnitBuilder = SpInmailAdUnitBuilder.INSTANCE;
          paramString = SpInmailAdUnitBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label438;
          }
          bool1 = true;
        }
        label357:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = SpInmailAdUnitBuilder.INSTANCE;
          paramString = SpInmailAdUnitBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label444;
          }
        }
      }
    }
    label420:
    label426:
    label432:
    label438:
    label444:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label450;
      }
      throw new IOException("Failed to find required field: actionText when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailStandardSubContent from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label250;
      bool5 = false;
      break label277;
      bool1 = false;
      break label304;
      bool1 = false;
      break label357;
    }
    label450:
    if (!bool4) {
      throw new IOException("Failed to find required field: action when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailStandardSubContent from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: actionTracking when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailStandardSubContent from fission.");
    }
    return new SpInmailStandardSubContent((String)localObject2, str1, str2, paramString, bool3, bool4, bool5, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailStandardSubContentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */