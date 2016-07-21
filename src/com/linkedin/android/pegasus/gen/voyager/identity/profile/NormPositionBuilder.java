package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.common.DateRangeBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class NormPositionBuilder
  implements FissileDataModelBuilder<NormPosition>, DataTemplateBuilder<NormPosition>
{
  public static final NormPositionBuilder INSTANCE = new NormPositionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("timePeriod");
    JSON_KEY_STORE.put("region");
    JSON_KEY_STORE.put("locationName");
    JSON_KEY_STORE.put("companyName");
    JSON_KEY_STORE.put("companyUrn");
  }
  
  public static NormPosition build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    String str4 = null;
    String str3 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    String str2 = null;
    String str1 = null;
    Object localObject1 = null;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("timePeriod", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = DateRangeBuilder.INSTANCE;
        localObject3 = DateRangeBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("region", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("locationName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("companyName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("companyUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UrnCoercer.INSTANCE;
        localObject1 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new NormPosition((Urn)localObject4, str4, str3, (DateRange)localObject3, (Urn)localObject2, str2, str1, (Urn)localObject1, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static NormPosition readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building NormPosition");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building NormPosition");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building NormPosition");
    }
    if (((ByteBuffer)localObject1).getInt() != 623544189)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building NormPosition");
    }
    localObject2 = null;
    String str1 = null;
    String str2 = null;
    paramString = null;
    DateRangeBuilder localDateRangeBuilder = null;
    Object localObject4 = null;
    String str3 = null;
    String str4 = null;
    Object localObject3 = null;
    boolean bool3;
    boolean bool4;
    label270:
    boolean bool5;
    label297:
    boolean bool2;
    label324:
    boolean bool1;
    label381:
    label407:
    label419:
    boolean bool6;
    label455:
    boolean bool7;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3)
      {
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label588;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label594;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label600;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localDateRangeBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localDateRangeBuilder = DateRangeBuilder.INSTANCE;
          paramString = DateRangeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label606;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = DateRangeBuilder.INSTANCE;
          paramString = DateRangeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label612;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label618;
      }
      bool2 = true;
      paramFissionTransaction = (FissionTransaction)localObject4;
      if (bool2)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label624;
      }
      bool6 = true;
      if (bool6) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label630;
      }
      bool7 = true;
      label482:
      if (bool7) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label636;
      }
    }
    label588:
    label594:
    label600:
    label606:
    label612:
    label618:
    label624:
    label630:
    label636:
    for (boolean bool8 = true;; bool8 = false)
    {
      if (bool8)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      return new NormPosition((Urn)localObject2, str1, str2, paramString, paramFissionTransaction, str3, str4, (Urn)localObject3, bool3, bool4, bool5, bool1, bool2, bool6, bool7, bool8);
      bool3 = false;
      break;
      bool4 = false;
      break label270;
      bool5 = false;
      break label297;
      bool2 = false;
      break label324;
      bool1 = false;
      break label381;
      bool1 = false;
      break label407;
      bool2 = false;
      break label419;
      bool6 = false;
      break label455;
      bool7 = false;
      break label482;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPositionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */