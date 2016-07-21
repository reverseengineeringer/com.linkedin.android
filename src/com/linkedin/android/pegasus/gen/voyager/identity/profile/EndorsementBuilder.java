package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class EndorsementBuilder
  implements FissileDataModelBuilder<Endorsement>, DataTemplateBuilder<Endorsement>
{
  public static final EndorsementBuilder INSTANCE = new EndorsementBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("endorser");
    JSON_KEY_STORE.put("status");
  }
  
  public static Endorsement build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    EndorsementStatusType localEndorsementStatusType = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("endorser", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = EndorserMiniProfileBuilder.INSTANCE;
        localObject1 = EndorserMiniProfileBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("status", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localEndorsementStatusType = (EndorsementStatusType)paramDataReader.readEnum(EndorsementStatusType.Builder.INSTANCE);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: endorser when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: status when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement");
    }
    return new Endorsement((Urn)localObject2, (EndorserMiniProfile)localObject1, localEndorsementStatusType, bool3, bool2, bool1);
  }
  
  public static Endorsement readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Endorsement");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Endorsement");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Endorsement");
    }
    if (((ByteBuffer)localObject1).getInt() != -174325374)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Endorsement");
    }
    localObject2 = null;
    paramString = null;
    EndorserMiniProfileBuilder localEndorserMiniProfileBuilder = null;
    Object localObject3 = null;
    boolean bool3;
    label255:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3)
      {
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label403;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localEndorserMiniProfileBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localEndorserMiniProfileBuilder = EndorserMiniProfileBuilder.INSTANCE;
          paramString = EndorserMiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label409;
          }
          bool1 = true;
        }
        label312:
        if (i == 1)
        {
          paramString = EndorserMiniProfileBuilder.INSTANCE;
          paramString = EndorserMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label415;
          }
          bool1 = true;
        }
      }
      label338:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label421;
      }
    }
    label403:
    label409:
    label415:
    label421:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool2) {
        paramFissionTransaction = EndorsementStatusType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label427;
      }
      throw new IOException("Failed to find required field: endorser when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement from fission.");
      bool3 = false;
      break;
      bool2 = false;
      break label255;
      bool1 = false;
      break label312;
      bool1 = false;
      break label338;
    }
    label427:
    if (!bool2) {
      throw new IOException("Failed to find required field: status when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement from fission.");
    }
    return new Endorsement((Urn)localObject2, paramString, paramFissionTransaction, bool3, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsementBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */