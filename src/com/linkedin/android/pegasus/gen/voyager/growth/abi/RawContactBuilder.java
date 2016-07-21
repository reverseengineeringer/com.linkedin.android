package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.DateBuilder;
import com.linkedin.android.pegasus.gen.common.IMBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RawContactBuilder
  implements FissileDataModelBuilder<RawContact>, DataTemplateBuilder<RawContact>
{
  public static final RawContactBuilder INSTANCE = new RawContactBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("fullName");
    JSON_KEY_STORE.put("firstName");
    JSON_KEY_STORE.put("lastName");
    JSON_KEY_STORE.put("middleName");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("emails");
    JSON_KEY_STORE.put("phoneNumbers");
    JSON_KEY_STORE.put("instantMessageHandles");
    JSON_KEY_STORE.put("addresses");
    JSON_KEY_STORE.put("bornOn");
    JSON_KEY_STORE.put("sites");
    JSON_KEY_STORE.put("bookmarked");
    JSON_KEY_STORE.put("notes");
  }
  
  public static RawContact build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject6 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    String str1 = null;
    boolean bool14 = false;
    boolean bool13 = false;
    boolean bool12 = false;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("fullName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str6 = paramDataReader.readString();
        bool14 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("firstName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("lastName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("middleName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool10 = true;
      }
      else
      {
        Object localObject7;
        if (paramDataReader.shouldReadField$11ca93e7("emails", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject5 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject7 = EmailBuilder.INSTANCE;
              ((List)localObject5).add(EmailBuilder.build(paramDataReader));
            }
          }
          bool9 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("phoneNumbers", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject7 = PhoneNumberBuilder.INSTANCE;
              ((List)localObject4).add(PhoneNumberBuilder.build(paramDataReader));
            }
          }
          bool8 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("instantMessageHandles", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject7 = IMBuilder.INSTANCE;
              ((List)localObject3).add(IMBuilder.build(paramDataReader));
            }
          }
          bool7 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("addresses", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject7 = AddressBuilder.INSTANCE;
              ((List)localObject2).add(AddressBuilder.build(paramDataReader));
            }
          }
          bool6 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("bornOn", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject6 = DateBuilder.INSTANCE;
          localObject6 = DateBuilder.build(paramDataReader);
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("sites", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject7 = SiteBuilder.INSTANCE;
              ((List)localObject1).add(SiteBuilder.build(paramDataReader));
            }
          }
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("bookmarked", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          bool1 = paramDataReader.readBoolean();
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("notes", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          str1 = paramDataReader.readString();
          bool2 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
    }
    if (!bool9) {
      localObject5 = Collections.emptyList();
    }
    if (!bool8) {
      localObject4 = Collections.emptyList();
    }
    if (!bool7) {
      localObject3 = Collections.emptyList();
    }
    if (!bool6) {
      localObject2 = Collections.emptyList();
    }
    if (!bool3) {
      localObject1 = Collections.emptyList();
    }
    if (!bool4) {
      bool1 = false;
    }
    return new RawContact(str6, str5, str4, str3, str2, (List)localObject5, (List)localObject4, (List)localObject3, (List)localObject2, (Date)localObject6, (List)localObject1, bool1, str1, bool14, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool3, bool4, bool2);
  }
  
  public static RawContact readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building RawContact");
    }
    Object localObject1 = paramByteBuffer;
    int j;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      i = paramString.get();
      do
      {
        do
        {
          localObject6 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building RawContact");
    }
    Object localObject6 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building RawContact");
    }
    if (((ByteBuffer)localObject6).getInt() != 747452472)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject6);
      throw new IOException("UID mismatch. Can't read cached data when building RawContact");
    }
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    paramString = null;
    localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject8 = null;
    Object localObject5 = null;
    boolean bool14 = false;
    Object localObject7 = null;
    boolean bool3;
    boolean bool4;
    label277:
    boolean bool5;
    label304:
    boolean bool6;
    label331:
    boolean bool7;
    label358:
    boolean bool8;
    label385:
    Object localObject9;
    label409:
    int k;
    Object localObject10;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label518;
      }
      bool4 = true;
      if (bool4) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label524;
      }
      bool5 = true;
      if (bool5) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label530;
      }
      bool6 = true;
      if (bool6) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label536;
      }
      bool7 = true;
      if (bool7) {
        str5 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label542;
      }
      bool8 = true;
      if (!bool8) {
        break label560;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject6);
      localObject9 = new ArrayList();
      paramString = (String)localObject9;
      if (j <= 0) {
        break label560;
      }
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject6).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject6);
        localObject10 = EmailBuilder.INSTANCE;
        paramString = EmailBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label548;
        }
        i = 1;
      }
      label463:
      if (k == 1)
      {
        paramString = EmailBuilder.INSTANCE;
        paramString = EmailBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
        if (paramString == null) {
          break label554;
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
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject9).add(paramString);
      }
      j -= 1;
      break label409;
      bool3 = false;
      break;
      bool4 = false;
      break label277;
      bool5 = false;
      break label304;
      bool6 = false;
      break label331;
      bool7 = false;
      break label358;
      bool8 = false;
      break label385;
      i = 0;
      break label463;
    }
    label560:
    boolean bool9;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool9 = true;
      if (!bool9) {
        break label727;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject6);
      localObject9 = new ArrayList();
      label596:
      localObject1 = localObject9;
      if (j <= 0) {
        break label727;
      }
      localObject1 = null;
      i = 1;
      k = ((ByteBuffer)localObject6).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject6);
        localObject10 = PhoneNumberBuilder.INSTANCE;
        localObject1 = PhoneNumberBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label715;
        }
        i = 1;
      }
      label656:
      if (k == 1)
      {
        localObject1 = PhoneNumberBuilder.INSTANCE;
        localObject1 = PhoneNumberBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label721;
        }
      }
    }
    label715:
    label721:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject9).add(localObject1);
      }
      j -= 1;
      break label596;
      bool9 = false;
      break;
      i = 0;
      break label656;
    }
    label727:
    boolean bool10;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool10 = true;
      if (!bool10) {
        break label894;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject6);
      localObject9 = new ArrayList();
      label763:
      localObject2 = localObject9;
      if (j <= 0) {
        break label894;
      }
      localObject2 = null;
      i = 1;
      k = ((ByteBuffer)localObject6).get();
      if (k == 0)
      {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject6);
        localObject10 = IMBuilder.INSTANCE;
        localObject2 = IMBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
        if (localObject2 == null) {
          break label882;
        }
        i = 1;
      }
      label823:
      if (k == 1)
      {
        localObject2 = IMBuilder.INSTANCE;
        localObject2 = IMBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
        if (localObject2 == null) {
          break label888;
        }
      }
    }
    label882:
    label888:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject9).add(localObject2);
      }
      j -= 1;
      break label763;
      bool10 = false;
      break;
      i = 0;
      break label823;
    }
    label894:
    boolean bool11;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool11 = true;
      if (!bool11) {
        break label1061;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject6);
      localObject9 = new ArrayList();
      label930:
      localObject3 = localObject9;
      if (j <= 0) {
        break label1061;
      }
      localObject3 = null;
      i = 1;
      k = ((ByteBuffer)localObject6).get();
      if (k == 0)
      {
        localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject6);
        localObject10 = AddressBuilder.INSTANCE;
        localObject3 = AddressBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
        if (localObject3 == null) {
          break label1049;
        }
        i = 1;
      }
      label990:
      if (k == 1)
      {
        localObject3 = AddressBuilder.INSTANCE;
        localObject3 = AddressBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
        if (localObject3 == null) {
          break label1055;
        }
      }
    }
    label1049:
    label1055:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject9).add(localObject3);
      }
      j -= 1;
      break label930;
      bool11 = false;
      break;
      i = 0;
      break label990;
    }
    label1061:
    boolean bool2;
    boolean bool1;
    label1135:
    label1164:
    boolean bool12;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject4 = localObject8;
        bool1 = bool2;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localObject8 = DateBuilder.INSTANCE;
          localObject4 = DateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1319;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          localObject4 = DateBuilder.INSTANCE;
          localObject4 = DateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1325;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1331;
      }
      bool12 = true;
      label1176:
      if (!bool12) {
        break label1349;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject6);
      localObject8 = new ArrayList();
      label1200:
      localObject5 = localObject8;
      if (j <= 0) {
        break label1349;
      }
      localObject5 = null;
      i = 1;
      k = ((ByteBuffer)localObject6).get();
      if (k == 0)
      {
        localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject6);
        localObject9 = SiteBuilder.INSTANCE;
        localObject5 = SiteBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
        if (localObject5 == null) {
          break label1337;
        }
        i = 1;
      }
      label1260:
      if (k == 1)
      {
        localObject5 = SiteBuilder.INSTANCE;
        localObject5 = SiteBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
        if (localObject5 == null) {
          break label1343;
        }
      }
    }
    label1319:
    label1325:
    label1331:
    label1337:
    label1343:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject8).add(localObject5);
      }
      j -= 1;
      break label1200;
      bool2 = false;
      break;
      bool1 = false;
      break label1135;
      bool1 = false;
      break label1164;
      bool12 = false;
      break label1176;
      i = 0;
      break label1260;
    }
    label1349:
    boolean bool13;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool13 = true;
      bool2 = bool14;
      if (bool13)
      {
        if (((ByteBuffer)localObject6).get() != 1) {
          break label1544;
        }
        bool2 = true;
      }
      label1382:
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1550;
      }
    }
    label1544:
    label1550:
    for (bool14 = true;; bool14 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject7;
      if (bool14) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject6);
      }
      if (!bool8) {
        paramString = Collections.emptyList();
      }
      if (!bool9) {
        localObject1 = Collections.emptyList();
      }
      if (!bool10) {
        localObject2 = Collections.emptyList();
      }
      if (!bool11) {
        localObject3 = Collections.emptyList();
      }
      if (!bool12) {
        localObject5 = Collections.emptyList();
      }
      if (!bool13) {
        bool2 = false;
      }
      return new RawContact(str1, str2, str3, str4, str5, paramString, (List)localObject1, (List)localObject2, (List)localObject3, (Date)localObject4, (List)localObject5, bool2, paramFissionTransaction, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool1, bool12, bool13, bool14);
      bool13 = false;
      break;
      bool2 = false;
      break label1382;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContactBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */