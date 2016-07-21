package com.linkedin.android.pegasus.gen.voyager.feed.actions;

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

public final class IncorrectlyMentionedCompanyBuilder
  implements FissileDataModelBuilder<IncorrectlyMentionedCompany>, DataTemplateBuilder<IncorrectlyMentionedCompany>
{
  public static final IncorrectlyMentionedCompanyBuilder INSTANCE = new IncorrectlyMentionedCompanyBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("companyUrn");
    JSON_KEY_STORE.put("displayName");
    JSON_KEY_STORE.put("self");
  }
  
  public static IncorrectlyMentionedCompany build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    String str = null;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("companyUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = UrnCoercer.INSTANCE;
        localObject = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("displayName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("self", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool1 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      bool1 = false;
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: companyUrn when building com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedCompany");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: displayName when building com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedCompany");
    }
    return new IncorrectlyMentionedCompany((Urn)localObject, str, bool1, bool4, bool2, bool3);
  }
  
  public static IncorrectlyMentionedCompany readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building IncorrectlyMentionedCompany");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
          localObject = paramString;
          if (i != 0) {
            break;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            return null;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building IncorrectlyMentionedCompany");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building IncorrectlyMentionedCompany");
    }
    if (((ByteBuffer)localObject).getInt() != 2124689737)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building IncorrectlyMentionedCompany");
    }
    paramString = null;
    paramFissionTransaction = null;
    boolean bool1 = false;
    boolean bool2;
    boolean bool3;
    label249:
    boolean bool4;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      if (bool2)
      {
        paramString = UrnCoercer.INSTANCE;
        paramString = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label333;
      }
      bool3 = true;
      if (bool3) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label339;
      }
      bool4 = true;
      label275:
      if (bool4) {
        if (((ByteBuffer)localObject).get() != 1) {
          break label345;
        }
      }
    }
    label333:
    label339:
    label345:
    for (bool1 = true;; bool1 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (!bool4) {
        bool1 = false;
      }
      if (bool2) {
        break label351;
      }
      throw new IOException("Failed to find required field: companyUrn when reading com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedCompany from fission.");
      bool2 = false;
      break;
      bool3 = false;
      break label249;
      bool4 = false;
      break label275;
    }
    label351:
    if (!bool3) {
      throw new IOException("Failed to find required field: displayName when reading com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedCompany from fission.");
    }
    return new IncorrectlyMentionedCompany(paramString, paramFissionTransaction, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedCompanyBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */