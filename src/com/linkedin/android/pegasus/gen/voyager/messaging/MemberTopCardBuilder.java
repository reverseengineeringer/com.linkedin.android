package com.linkedin.android.pegasus.gen.voyager.messaging;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistanceBuilder;
import com.linkedin.android.pegasus.gen.voyager.messaging.shared.ContactInfo;
import com.linkedin.android.pegasus.gen.voyager.messaging.shared.ContactInfoBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MemberTopCardBuilder
  implements FissileDataModelBuilder<MemberTopCard>, DataTemplateBuilder<MemberTopCard>
{
  public static final MemberTopCardBuilder INSTANCE = new MemberTopCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("messagingMember");
    JSON_KEY_STORE.put("distance");
    JSON_KEY_STORE.put("contactInfo");
  }
  
  public static MemberTopCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("messagingMember", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = MessagingMemberBuilder.INSTANCE;
        localObject3 = MessagingMemberBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("distance", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MemberDistanceBuilder.INSTANCE;
        localObject2 = MemberDistanceBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contactInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = ContactInfoBuilder.INSTANCE;
        localObject1 = ContactInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: messagingMember when building com.linkedin.android.pegasus.gen.voyager.messaging.MemberTopCard");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: distance when building com.linkedin.android.pegasus.gen.voyager.messaging.MemberTopCard");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: contactInfo when building com.linkedin.android.pegasus.gen.voyager.messaging.MemberTopCard");
    }
    return new MemberTopCard((MessagingMember)localObject3, (MemberDistance)localObject2, (ContactInfo)localObject1, bool3, bool2, bool1);
  }
  
  public static MemberTopCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building MemberTopCard");
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
          localObject3 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building MemberTopCard");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building MemberTopCard");
    }
    if (((ByteBuffer)localObject3).getInt() != -1863635895)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building MemberTopCard");
    }
    paramString = null;
    MessagingMemberBuilder localMessagingMemberBuilder = null;
    localObject1 = null;
    MemberDistanceBuilder localMemberDistanceBuilder = null;
    Object localObject2 = null;
    ContactInfoBuilder localContactInfoBuilder = null;
    boolean bool2;
    boolean bool1;
    label283:
    label309:
    boolean bool3;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = localMessagingMemberBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localMessagingMemberBuilder = MessagingMemberBuilder.INSTANCE;
          paramString = MessagingMemberBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label548;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MessagingMemberBuilder.INSTANCE;
          paramString = MessagingMemberBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label554;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label560;
      }
      bool3 = true;
      label321:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localMemberDistanceBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localMemberDistanceBuilder = MemberDistanceBuilder.INSTANCE;
          localObject1 = MemberDistanceBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label566;
          }
          bool2 = true;
        }
        label383:
        if (i == 1)
        {
          localObject1 = MemberDistanceBuilder.INSTANCE;
          localObject1 = MemberDistanceBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label572;
          }
          bool2 = true;
        }
      }
      label412:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label578;
      }
      bool3 = true;
      label424:
      bool4 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localContactInfoBuilder;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localContactInfoBuilder = ContactInfoBuilder.INSTANCE;
          localObject2 = ContactInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label584;
          }
          bool3 = true;
        }
        label482:
        bool4 = bool3;
        if (i == 1)
        {
          localObject2 = ContactInfoBuilder.INSTANCE;
          localObject2 = ContactInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label590;
          }
        }
      }
    }
    label548:
    label554:
    label560:
    label566:
    label572:
    label578:
    label584:
    label590:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (bool1) {
        break label596;
      }
      throw new IOException("Failed to find required field: messagingMember when reading com.linkedin.android.pegasus.gen.voyager.messaging.MemberTopCard from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label283;
      bool1 = false;
      break label309;
      bool3 = false;
      break label321;
      bool2 = false;
      break label383;
      bool2 = false;
      break label412;
      bool3 = false;
      break label424;
      bool3 = false;
      break label482;
    }
    label596:
    if (!bool2) {
      throw new IOException("Failed to find required field: distance when reading com.linkedin.android.pegasus.gen.voyager.messaging.MemberTopCard from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: contactInfo when reading com.linkedin.android.pegasus.gen.voyager.messaging.MemberTopCard from fission.");
    }
    return new MemberTopCard(paramString, (MemberDistance)localObject1, (ContactInfo)localObject2, bool1, bool2, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.MemberTopCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */