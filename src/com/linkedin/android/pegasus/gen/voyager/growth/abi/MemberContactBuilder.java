package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.common.PhoneNumberBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MemberContactBuilder
  implements FissileDataModelBuilder<MemberContact>, DataTemplateBuilder<MemberContact>
{
  public static final MemberContactBuilder INSTANCE = new MemberContactBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniProfile");
    JSON_KEY_STORE.put("handle");
    JSON_KEY_STORE.put("trackingId");
  }
  
  public static MemberContact build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    String str = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("miniProfile", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MiniProfileBuilder.INSTANCE;
        localObject2 = MiniProfileBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("handle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = HandleBuilder.INSTANCE;
        localObject1 = HandleBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
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
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: miniProfile when building com.linkedin.android.pegasus.gen.voyager.growth.abi.MemberContact");
    }
    return new MemberContact((MiniProfile)localObject2, (MemberContact.Handle)localObject1, str, bool3, bool2, bool1);
  }
  
  public static MemberContact readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building MemberContact");
    }
    Object localObject1 = paramByteBuffer;
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
          localObject2 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building MemberContact");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building MemberContact");
    }
    if (((ByteBuffer)localObject2).getInt() != -852983735)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building MemberContact");
    }
    paramString = null;
    MiniProfileBuilder localMiniProfileBuilder = null;
    localObject1 = null;
    HandleBuilder localHandleBuilder = null;
    Object localObject3 = null;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localMiniProfileBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMiniProfileBuilder = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label471;
          }
          bool1 = true;
        }
        label280:
        if (i == 1)
        {
          paramString = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label477;
          }
          bool1 = true;
        }
      }
      label306:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label483;
      }
      bool3 = true;
      label318:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localHandleBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localHandleBuilder = HandleBuilder.INSTANCE;
          localObject1 = HandleBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label489;
          }
          bool2 = true;
        }
        label380:
        if (i == 1)
        {
          localObject1 = HandleBuilder.INSTANCE;
          localObject1 = HandleBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label495;
          }
          bool2 = true;
        }
      }
      label409:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label501;
      }
    }
    label471:
    label477:
    label483:
    label489:
    label495:
    label501:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool3) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label507;
      }
      throw new IOException("Failed to find required field: miniProfile when reading com.linkedin.android.pegasus.gen.voyager.growth.abi.MemberContact from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label280;
      bool1 = false;
      break label306;
      bool3 = false;
      break label318;
      bool2 = false;
      break label380;
      bool2 = false;
      break label409;
    }
    label507:
    return new MemberContact(paramString, (MemberContact.Handle)localObject1, paramFissionTransaction, bool1, bool2, bool3);
  }
  
  public static final class HandleBuilder
    implements FissileDataModelBuilder<MemberContact.Handle>, DataTemplateBuilder<MemberContact.Handle>
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
    
    public static MemberContact.Handle build(DataReader paramDataReader)
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
      return new MemberContact.Handle(str, (PhoneNumber)localObject, bool1, bool2);
    }
    
    public static MemberContact.Handle readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building MemberContact.Handle");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building MemberContact.Handle");
      }
      Object localObject1 = localObject2;
      if (((ByteBuffer)localObject2).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("Invalid header prefix. Can't read cached data when building MemberContact.Handle");
      }
      if (((ByteBuffer)localObject1).getInt() != 216059969)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("UID mismatch. Can't read cached data when building MemberContact.Handle");
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
      return new MemberContact.Handle((String)localObject2, paramString, bool3, bool2);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.MemberContactBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */