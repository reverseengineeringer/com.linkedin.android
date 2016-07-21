package com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.SuggestedEndorsementReasonExpert;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.SuggestedEndorsementReasonExpertBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.SuggestedEndorsementReasonStandard;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.SuggestedEndorsementReasonStandardBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SuggestedEndorsementPromptBuilder
  implements FissileDataModelBuilder<SuggestedEndorsementPrompt>, DataTemplateBuilder<SuggestedEndorsementPrompt>
{
  public static final SuggestedEndorsementPromptBuilder INSTANCE = new SuggestedEndorsementPromptBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("skillName");
    JSON_KEY_STORE.put("reason");
  }
  
  public static SuggestedEndorsementPrompt build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("skillName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("reason", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ReasonBuilder.INSTANCE;
        localObject = ReasonBuilder.build(paramDataReader);
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: skillName when building com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.SuggestedEndorsementPrompt");
    }
    return new SuggestedEndorsementPrompt(str, (SuggestedEndorsementPrompt.Reason)localObject, bool1, bool2);
  }
  
  public static SuggestedEndorsementPrompt readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SuggestedEndorsementPrompt");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SuggestedEndorsementPrompt");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SuggestedEndorsementPrompt");
    }
    if (((ByteBuffer)localObject1).getInt() != -1410720351)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SuggestedEndorsementPrompt");
    }
    localObject2 = null;
    paramString = null;
    ReasonBuilder localReasonBuilder = null;
    boolean bool3;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label360;
      }
      bool1 = true;
      label244:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localReasonBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localReasonBuilder = ReasonBuilder.INSTANCE;
          paramString = ReasonBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label366;
          }
          bool1 = true;
        }
        label297:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = ReasonBuilder.INSTANCE;
          paramString = ReasonBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label372;
          }
        }
      }
    }
    label360:
    label366:
    label372:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label378;
      }
      throw new IOException("Failed to find required field: skillName when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.SuggestedEndorsementPrompt from fission.");
      bool3 = false;
      break;
      bool1 = false;
      break label244;
      bool1 = false;
      break label297;
    }
    label378:
    return new SuggestedEndorsementPrompt((String)localObject2, paramString, bool3, bool2);
  }
  
  public static final class ReasonBuilder
    implements FissileDataModelBuilder<SuggestedEndorsementPrompt.Reason>, DataTemplateBuilder<SuggestedEndorsementPrompt.Reason>
  {
    public static final ReasonBuilder INSTANCE = new ReasonBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.profile.SuggestedEndorsementReasonExpert");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.SuggestedEndorsementReasonStandard");
    }
    
    public static SuggestedEndorsementPrompt.Reason build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.SuggestedEndorsementReasonExpert", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = SuggestedEndorsementReasonExpertBuilder.INSTANCE;
          localObject2 = SuggestedEndorsementReasonExpertBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.SuggestedEndorsementReasonStandard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = SuggestedEndorsementReasonStandardBuilder.INSTANCE;
          localObject1 = SuggestedEndorsementReasonStandardBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int i = 0;
      if (bool2) {
        i = 1;
      }
      if ((bool1) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Reason");
      }
      return new SuggestedEndorsementPrompt.Reason((SuggestedEndorsementReasonExpert)localObject2, (SuggestedEndorsementReasonStandard)localObject1, bool2, bool1);
    }
    
    public static SuggestedEndorsementPrompt.Reason readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building SuggestedEndorsementPrompt.Reason");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building SuggestedEndorsementPrompt.Reason");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building SuggestedEndorsementPrompt.Reason");
      }
      if (((ByteBuffer)localObject2).getInt() != -2025818847)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building SuggestedEndorsementPrompt.Reason");
      }
      paramString = null;
      SuggestedEndorsementReasonExpertBuilder localSuggestedEndorsementReasonExpertBuilder = null;
      localObject1 = null;
      SuggestedEndorsementReasonStandardBuilder localSuggestedEndorsementReasonStandardBuilder = null;
      boolean bool2;
      boolean bool1;
      if (((ByteBuffer)localObject2).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject2).get();
          bool1 = bool2;
          paramString = localSuggestedEndorsementReasonExpertBuilder;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localSuggestedEndorsementReasonExpertBuilder = SuggestedEndorsementReasonExpertBuilder.INSTANCE;
            paramString = SuggestedEndorsementReasonExpertBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = SuggestedEndorsementReasonExpertBuilder.INSTANCE;
            paramString = SuggestedEndorsementReasonExpertBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
            if (paramString == null) {
              break label461;
            }
            bool1 = true;
          }
        }
        label303:
        if (((ByteBuffer)localObject2).get() != 1) {
          break label467;
        }
        bool2 = true;
        label315:
        bool3 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject2).get();
          localObject1 = localSuggestedEndorsementReasonStandardBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localSuggestedEndorsementReasonStandardBuilder = SuggestedEndorsementReasonStandardBuilder.INSTANCE;
            localObject1 = SuggestedEndorsementReasonStandardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = SuggestedEndorsementReasonStandardBuilder.INSTANCE;
            localObject1 = SuggestedEndorsementReasonStandardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label479;
            }
          }
        }
      }
      label455:
      label461:
      label467:
      label473:
      label479:
      for (boolean bool3 = true;; bool3 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject2);
        }
        i = 0;
        if (bool1) {
          i = 1;
        }
        if ((!bool3) || (i == 0)) {
          break label485;
        }
        throw new IOException("Found more than 1 member when reading .Reason from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label277;
        bool1 = false;
        break label303;
        bool2 = false;
        break label315;
        bool2 = false;
        break label373;
      }
      label485:
      return new SuggestedEndorsementPrompt.Reason(paramString, (SuggestedEndorsementReasonStandard)localObject1, bool1, bool3);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.SuggestedEndorsementPromptBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */