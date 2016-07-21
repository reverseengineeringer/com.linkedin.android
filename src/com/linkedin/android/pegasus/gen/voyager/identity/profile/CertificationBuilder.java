package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.common.DateRangeBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompanyBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CertificationBuilder
  implements FissileDataModelBuilder<Certification>, DataTemplateBuilder<Certification>
{
  public static final CertificationBuilder INSTANCE = new CertificationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("name");
    JSON_KEY_STORE.put("licenseNumber");
    JSON_KEY_STORE.put("url");
    JSON_KEY_STORE.put("displaySource");
    JSON_KEY_STORE.put("timePeriod");
    JSON_KEY_STORE.put("authority");
    JSON_KEY_STORE.put("companyUrn");
    JSON_KEY_STORE.put("company");
  }
  
  public static Certification build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    Object localObject3 = null;
    String str1 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool9 = false;
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
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("name", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("licenseNumber", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("displaySource", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("timePeriod", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = DateRangeBuilder.INSTANCE;
        localObject3 = DateRangeBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("authority", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("companyUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("company", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = MiniCompanyBuilder.INSTANCE;
        localObject1 = MiniCompanyBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: name when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Certification");
    }
    return new Certification((Urn)localObject4, str5, str4, str3, str2, (DateRange)localObject3, str1, (Urn)localObject2, (MiniCompany)localObject1, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Certification readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Certification");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Certification");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Certification");
    }
    if (((ByteBuffer)localObject2).getInt() != -1008821172)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building Certification");
    }
    Object localObject3 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    paramString = null;
    DateRangeBuilder localDateRangeBuilder = null;
    String str5 = null;
    Object localObject4 = null;
    localObject1 = null;
    MiniCompanyBuilder localMiniCompanyBuilder = null;
    boolean bool4;
    boolean bool5;
    label276:
    boolean bool6;
    label303:
    boolean bool7;
    label330:
    boolean bool8;
    label357:
    boolean bool2;
    label384:
    boolean bool1;
    label441:
    label467:
    boolean bool9;
    label479:
    boolean bool10;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label665;
      }
      bool5 = true;
      if (bool5) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label671;
      }
      bool6 = true;
      if (bool6) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label677;
      }
      bool7 = true;
      if (bool7) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label683;
      }
      bool8 = true;
      if (bool8) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label689;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localDateRangeBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localDateRangeBuilder = DateRangeBuilder.INSTANCE;
          paramString = DateRangeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label695;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = DateRangeBuilder.INSTANCE;
          paramString = DateRangeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label701;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label707;
      }
      bool9 = true;
      if (bool9) {
        str5 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label713;
      }
      bool10 = true;
      label506:
      if (bool10)
      {
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label719;
      }
      bool2 = true;
      label541:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localMiniCompanyBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMiniCompanyBuilder = MiniCompanyBuilder.INSTANCE;
          localObject1 = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label725;
          }
          bool2 = true;
        }
        label599:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = MiniCompanyBuilder.INSTANCE;
          localObject1 = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label731;
          }
        }
      }
    }
    label665:
    label671:
    label677:
    label683:
    label689:
    label695:
    label701:
    label707:
    label713:
    label719:
    label725:
    label731:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool5) {
        break label737;
      }
      throw new IOException("Failed to find required field: name when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Certification from fission.");
      bool4 = false;
      break;
      bool5 = false;
      break label276;
      bool6 = false;
      break label303;
      bool7 = false;
      break label330;
      bool8 = false;
      break label357;
      bool2 = false;
      break label384;
      bool1 = false;
      break label441;
      bool1 = false;
      break label467;
      bool9 = false;
      break label479;
      bool10 = false;
      break label506;
      bool2 = false;
      break label541;
      bool2 = false;
      break label599;
    }
    label737:
    return new Certification((Urn)localObject3, str1, str2, str3, str4, paramString, str5, (Urn)localObject4, (MiniCompany)localObject1, bool4, bool5, bool6, bool7, bool8, bool1, bool9, bool10, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.CertificationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */