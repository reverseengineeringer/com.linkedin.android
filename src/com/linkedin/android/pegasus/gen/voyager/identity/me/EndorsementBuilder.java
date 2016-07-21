package com.linkedin.android.pegasus.gen.voyager.identity.me;

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
    localHashStringKeyStore.put("endorsementUrn");
    JSON_KEY_STORE.put("skill");
    JSON_KEY_STORE.put("status");
  }
  
  public static Endorsement build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    String str = null;
    EndorsementStatus localEndorsementStatus = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("endorsementUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = UrnCoercer.INSTANCE;
        localObject = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("skill", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("status", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localEndorsementStatus = (EndorsementStatus)paramDataReader.readEnum(EndorsementStatus.Builder.INSTANCE);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: endorsementUrn when building com.linkedin.android.pegasus.gen.voyager.identity.me.Endorsement");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: skill when building com.linkedin.android.pegasus.gen.voyager.identity.me.Endorsement");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: status when building com.linkedin.android.pegasus.gen.voyager.identity.me.Endorsement");
    }
    return new Endorsement((Urn)localObject, str, localEndorsementStatus, bool3, bool2, bool1);
  }
  
  public static Endorsement readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool3 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Endorsement");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Endorsement");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Endorsement");
    }
    label170:
    if (((ByteBuffer)localObject1).getInt() != -1981289077)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Endorsement");
    }
    paramString = null;
    paramFissionTransaction = null;
    localObject2 = null;
    boolean bool1;
    boolean bool2;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1)
      {
        paramString = UrnCoercer.INSTANCE;
        paramString = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label324;
      }
      bool2 = true;
      label250:
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label330;
      }
    }
    for (;;)
    {
      if (bool3) {
        localObject2 = EndorsementStatus.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label336;
      }
      throw new IOException("Failed to find required field: endorsementUrn when reading com.linkedin.android.pegasus.gen.voyager.identity.me.Endorsement from fission.");
      bool1 = false;
      break;
      label324:
      bool2 = false;
      break label250;
      label330:
      bool3 = false;
    }
    label336:
    if (!bool2) {
      throw new IOException("Failed to find required field: skill when reading com.linkedin.android.pegasus.gen.voyager.identity.me.Endorsement from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: status when reading com.linkedin.android.pegasus.gen.voyager.identity.me.Endorsement from fission.");
    }
    return new Endorsement(paramString, paramFissionTransaction, (EndorsementStatus)localObject2, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */