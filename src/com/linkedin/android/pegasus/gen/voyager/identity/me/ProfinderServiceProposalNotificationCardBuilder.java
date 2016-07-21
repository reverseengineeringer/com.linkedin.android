package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderMiniRequestForProposals;
import com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderMiniRequestForProposalsBuilder;
import com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderNotificationType;
import com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderNotificationType.Builder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class ProfinderServiceProposalNotificationCardBuilder
  implements FissileDataModelBuilder<ProfinderServiceProposalNotificationCard>, DataTemplateBuilder<ProfinderServiceProposalNotificationCard>
{
  public static final ProfinderServiceProposalNotificationCardBuilder INSTANCE = new ProfinderServiceProposalNotificationCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("profinderNotificationType");
    JSON_KEY_STORE.put("profinderServiceProposalUrl");
    JSON_KEY_STORE.put("publishedAt");
    JSON_KEY_STORE.put("profinderMiniRequestForProposals");
    JSON_KEY_STORE.put("providerProfiles");
    JSON_KEY_STORE.put("read");
  }
  
  public static ProfinderServiceProposalNotificationCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    ProfinderNotificationType localProfinderNotificationType = null;
    String str = null;
    long l = 0L;
    Object localObject = null;
    ArrayList localArrayList = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("profinderNotificationType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localProfinderNotificationType = (ProfinderNotificationType)paramDataReader.readEnum(ProfinderNotificationType.Builder.INSTANCE);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("profinderServiceProposalUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("publishedAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("profinderMiniRequestForProposals", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ProfinderMiniRequestForProposalsBuilder.INSTANCE;
        localObject = ProfinderMiniRequestForProposalsBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("providerProfiles", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            ActorMiniProfileBuilder localActorMiniProfileBuilder = ActorMiniProfileBuilder.INSTANCE;
            localArrayList.add(ActorMiniProfileBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("read", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool7 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: profinderNotificationType when building com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: profinderServiceProposalUrl when building com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: publishedAt when building com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: profinderMiniRequestForProposals when building com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: providerProfiles when building com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: read when building com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard");
    }
    return new ProfinderServiceProposalNotificationCard(localProfinderNotificationType, str, l, (ProfinderMiniRequestForProposals)localObject, localArrayList, bool7, bool6, bool5, bool4, bool3, bool1, bool2);
  }
  
  public static ProfinderServiceProposalNotificationCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ProfinderServiceProposalNotificationCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ProfinderServiceProposalNotificationCard");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ProfinderServiceProposalNotificationCard");
    }
    if (((ByteBuffer)localObject2).getInt() != -364289497)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building ProfinderServiceProposalNotificationCard");
    }
    ProfinderNotificationType localProfinderNotificationType = null;
    String str = null;
    long l = 0L;
    paramString = null;
    Object localObject3 = null;
    localObject1 = null;
    boolean bool8 = false;
    boolean bool3;
    boolean bool4;
    label259:
    boolean bool5;
    label286:
    label310:
    boolean bool1;
    label367:
    label393:
    boolean bool6;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localProfinderNotificationType = ProfinderNotificationType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label548;
      }
      bool4 = true;
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label554;
      }
      bool5 = true;
      if (bool5) {
        l = ((ByteBuffer)localObject2).getLong();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label560;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = (String)localObject3;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localObject3 = ProfinderMiniRequestForProposalsBuilder.INSTANCE;
          paramString = ProfinderMiniRequestForProposalsBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label566;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ProfinderMiniRequestForProposalsBuilder.INSTANCE;
          paramString = ProfinderMiniRequestForProposalsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label572;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label578;
      }
      bool6 = true;
      label405:
      if (!bool6) {
        break label596;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject3 = new ArrayList();
      label429:
      localObject1 = localObject3;
      if (j <= 0) {
        break label596;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        ActorMiniProfileBuilder localActorMiniProfileBuilder = ActorMiniProfileBuilder.INSTANCE;
        localObject1 = ActorMiniProfileBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label584;
        }
        i = 1;
      }
      label489:
      if (k == 1)
      {
        localObject1 = ActorMiniProfileBuilder.INSTANCE;
        localObject1 = ActorMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label590;
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
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject3).add(localObject1);
      }
      j -= 1;
      break label429;
      bool3 = false;
      break;
      bool4 = false;
      break label259;
      bool5 = false;
      break label286;
      bool2 = false;
      break label310;
      bool1 = false;
      break label367;
      bool1 = false;
      break label393;
      bool6 = false;
      break label405;
      i = 0;
      break label489;
    }
    label596:
    boolean bool7;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool7 = true;
      bool2 = bool8;
      if (bool7) {
        if (((ByteBuffer)localObject2).get() != 1) {
          break label662;
        }
      }
    }
    label662:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool3) {
        break label668;
      }
      throw new IOException("Failed to find required field: profinderNotificationType when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard from fission.");
      bool7 = false;
      break;
    }
    label668:
    if (!bool4) {
      throw new IOException("Failed to find required field: profinderServiceProposalUrl when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: publishedAt when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: profinderMiniRequestForProposals when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: providerProfiles when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: read when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard from fission.");
    }
    return new ProfinderServiceProposalNotificationCard(localProfinderNotificationType, str, l, paramString, (List)localObject1, bool2, bool3, bool4, bool5, bool1, bool6, bool7);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */