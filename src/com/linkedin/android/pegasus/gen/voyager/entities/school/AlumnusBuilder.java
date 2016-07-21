package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.DateBuilder;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.common.DateRangeBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class AlumnusBuilder
  implements FissileDataModelBuilder<Alumnus>, DataTemplateBuilder<Alumnus>
{
  public static final AlumnusBuilder INSTANCE = new AlumnusBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniProfile");
    JSON_KEY_STORE.put("degreeLevel");
    JSON_KEY_STORE.put("fieldOfStudy");
    JSON_KEY_STORE.put("startDate");
    JSON_KEY_STORE.put("endDate");
    JSON_KEY_STORE.put("timePeriod");
    JSON_KEY_STORE.put("objectUrn");
  }
  
  public static Alumnus build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject5 = null;
    String str2 = null;
    String str1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("miniProfile", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = MiniProfileBuilder.INSTANCE;
        localObject5 = MiniProfileBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("degreeLevel", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("fieldOfStudy", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("startDate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = DateBuilder.INSTANCE;
        localObject4 = DateBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("endDate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = DateBuilder.INSTANCE;
        localObject3 = DateBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("timePeriod", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = DateRangeBuilder.INSTANCE;
        localObject2 = DateRangeBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("objectUrn", JSON_KEY_STORE))
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
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: miniProfile when building com.linkedin.android.pegasus.gen.voyager.entities.school.Alumnus");
    }
    return new Alumnus((MiniProfile)localObject5, str2, str1, (Date)localObject4, (Date)localObject3, (DateRange)localObject2, (Urn)localObject1, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Alumnus readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Alumnus");
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
          localObject4 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Alumnus");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Alumnus");
    }
    if (((ByteBuffer)localObject4).getInt() != -1727495902)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building Alumnus");
    }
    paramString = null;
    MiniProfileBuilder localMiniProfileBuilder = null;
    String str1 = null;
    String str2 = null;
    localObject1 = null;
    DateBuilder localDateBuilder2 = null;
    Object localObject2 = null;
    DateBuilder localDateBuilder1 = null;
    Object localObject3 = null;
    DateRangeBuilder localDateRangeBuilder = null;
    Object localObject5 = null;
    boolean bool2;
    boolean bool1;
    label298:
    label324:
    boolean bool6;
    label336:
    boolean bool7;
    label363:
    boolean bool3;
    label390:
    label452:
    label481:
    boolean bool4;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject4).get();
        paramString = localMiniProfileBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localMiniProfileBuilder = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label756;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (paramString == null) {
            break label762;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label768;
      }
      bool6 = true;
      if (bool6) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label774;
      }
      bool7 = true;
      if (bool7) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label780;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject1 = localDateBuilder2;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localDateBuilder2 = DateBuilder.INSTANCE;
          localObject1 = DateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label786;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = DateBuilder.INSTANCE;
          localObject1 = DateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label792;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label798;
      }
      bool4 = true;
      label493:
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject2 = localDateBuilder1;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localDateBuilder1 = DateBuilder.INSTANCE;
          localObject2 = DateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label804;
          }
          bool3 = true;
        }
        label555:
        if (i == 1)
        {
          localObject2 = DateBuilder.INSTANCE;
          localObject2 = DateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label810;
          }
          bool3 = true;
        }
      }
      label584:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label816;
      }
      bool5 = true;
      label596:
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject3 = localDateRangeBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localDateRangeBuilder = DateRangeBuilder.INSTANCE;
          localObject3 = DateRangeBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label822;
          }
          bool4 = true;
        }
        label658:
        if (i == 1)
        {
          localObject3 = DateRangeBuilder.INSTANCE;
          localObject3 = DateRangeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label828;
          }
          bool4 = true;
        }
      }
      label687:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label834;
      }
    }
    label756:
    label762:
    label768:
    label774:
    label780:
    label786:
    label792:
    label798:
    label804:
    label810:
    label816:
    label822:
    label828:
    label834:
    for (boolean bool5 = true;; bool5 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject5;
      if (bool5)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject4));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (bool1) {
        break label840;
      }
      throw new IOException("Failed to find required field: miniProfile when reading com.linkedin.android.pegasus.gen.voyager.entities.school.Alumnus from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label298;
      bool1 = false;
      break label324;
      bool6 = false;
      break label336;
      bool7 = false;
      break label363;
      bool3 = false;
      break label390;
      bool2 = false;
      break label452;
      bool2 = false;
      break label481;
      bool4 = false;
      break label493;
      bool3 = false;
      break label555;
      bool3 = false;
      break label584;
      bool5 = false;
      break label596;
      bool4 = false;
      break label658;
      bool4 = false;
      break label687;
    }
    label840:
    return new Alumnus(paramString, str1, str2, (Date)localObject1, (Date)localObject2, (DateRange)localObject3, paramFissionTransaction, bool1, bool6, bool7, bool2, bool3, bool4, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.AlumnusBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */