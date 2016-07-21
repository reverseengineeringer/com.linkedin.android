package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.common.PhoneNumberBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class GuestContactBuilder
  implements FissileDataModelBuilder<GuestContact>, DataTemplateBuilder<GuestContact>
{
  public static final GuestContactBuilder INSTANCE = new GuestContactBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("firstName");
    JSON_KEY_STORE.put("lastName");
    JSON_KEY_STORE.put("handle");
    JSON_KEY_STORE.put("trackingId");
  }
  
  public static GuestContact build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    String str2 = null;
    Object localObject = null;
    String str1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("firstName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("lastName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("handle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = HandleBuilder.INSTANCE;
        localObject = HandleBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
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
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: handle when building com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact");
    }
    return new GuestContact(str3, str2, (GuestContact.Handle)localObject, str1, bool4, bool3, bool2, bool1);
  }
  
  public static GuestContact readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building GuestContact");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building GuestContact");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building GuestContact");
    }
    if (((ByteBuffer)localObject1).getInt() != 375858800)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building GuestContact");
    }
    localObject2 = null;
    String str = null;
    paramString = null;
    HandleBuilder localHandleBuilder = null;
    Object localObject3 = null;
    boolean bool3;
    boolean bool4;
    label250:
    label277:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label422;
      }
      bool4 = true;
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label428;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localHandleBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localHandleBuilder = HandleBuilder.INSTANCE;
          paramString = HandleBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label434;
          }
          bool1 = true;
        }
        label334:
        if (i == 1)
        {
          paramString = HandleBuilder.INSTANCE;
          paramString = HandleBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label440;
          }
          bool1 = true;
        }
      }
      label360:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label446;
      }
    }
    label422:
    label428:
    label434:
    label440:
    label446:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label452;
      }
      throw new IOException("Failed to find required field: handle when reading com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label250;
      bool2 = false;
      break label277;
      bool1 = false;
      break label334;
      bool1 = false;
      break label360;
    }
    label452:
    return new GuestContact((String)localObject2, str, paramString, paramFissionTransaction, bool3, bool4, bool1, bool2);
  }
  
  public static final class HandleBuilder
    implements FissileDataModelBuilder<GuestContact.Handle>, DataTemplateBuilder<GuestContact.Handle>
  {
    public static final HandleBuilder INSTANCE = new HandleBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("string");
      JSON_KEY_STORE.put("com.linkedin.common.PhoneNumber");
    }
    
    public static GuestContact.Handle build(DataReader paramDataReader)
      throws DataReaderException
    {
      String str = null;
      Object localObject = null;
      boolean bool1 = false;
      boolean bool2 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("string", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          str = paramDataReader.readString();
          bool1 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.common.PhoneNumber", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject = PhoneNumberBuilder.INSTANCE;
          localObject = PhoneNumberBuilder.build(paramDataReader);
          bool2 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int i = 0;
      if (bool1) {
        i = 1;
      }
      if ((bool2) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Handle");
      }
      return new GuestContact.Handle(str, (PhoneNumber)localObject, bool1, bool2);
    }
    
    public static GuestContact.Handle readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building GuestContact.Handle");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building GuestContact.Handle");
      }
      Object localObject1 = localObject2;
      if (((ByteBuffer)localObject2).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("Invalid header prefix. Can't read cached data when building GuestContact.Handle");
      }
      if (((ByteBuffer)localObject1).getInt() != 216059969)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("UID mismatch. Can't read cached data when building GuestContact.Handle");
      }
      localObject2 = null;
      paramString = null;
      PhoneNumberBuilder localPhoneNumberBuilder = null;
      boolean bool3;
      boolean bool1;
      if (((ByteBuffer)localObject1).get() == 1)
      {
        bool3 = true;
        if (bool3) {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
        }
        if (((ByteBuffer)localObject1).get() != 1) {
          break label376;
        }
        bool1 = true;
        label244:
        bool2 = bool1;
        if (bool1)
        {
          i = ((ByteBuffer)localObject1).get();
          paramString = localPhoneNumberBuilder;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
            localPhoneNumberBuilder = PhoneNumberBuilder.INSTANCE;
            paramString = PhoneNumberBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label382;
            }
            bool1 = true;
          }
          label297:
          bool2 = bool1;
          if (i == 1)
          {
            paramString = PhoneNumberBuilder.INSTANCE;
            paramString = PhoneNumberBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
            if (paramString == null) {
              break label388;
            }
          }
        }
      }
      label376:
      label382:
      label388:
      for (boolean bool2 = true;; bool2 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject1);
        }
        i = 0;
        if (bool3) {
          i = 1;
        }
        if ((!bool2) || (i == 0)) {
          break label394;
        }
        throw new IOException("Found more than 1 member when reading .Handle from fission.");
        bool3 = false;
        break;
        bool1 = false;
        break label244;
        bool1 = false;
        break label297;
      }
      label394:
      return new GuestContact.Handle((String)localObject2, paramString, bool3, bool2);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContactBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */