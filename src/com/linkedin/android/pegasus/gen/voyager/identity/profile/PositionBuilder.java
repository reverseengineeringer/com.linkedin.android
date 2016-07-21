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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PositionBuilder
  implements FissileDataModelBuilder<Position>, DataTemplateBuilder<Position>
{
  public static final PositionBuilder INSTANCE = new PositionBuilder();
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
    JSON_KEY_STORE.put("company");
    JSON_KEY_STORE.put("projects");
    JSON_KEY_STORE.put("organizations");
    JSON_KEY_STORE.put("honors");
    JSON_KEY_STORE.put("courses");
    JSON_KEY_STORE.put("recommendations");
  }
  
  public static Position build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject10 = null;
    String str4 = null;
    String str3 = null;
    Object localObject9 = null;
    Object localObject8 = null;
    String str2 = null;
    String str1 = null;
    Object localObject7 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
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
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject10 = UrnCoercer.INSTANCE;
        localObject10 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool14 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("timePeriod", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject9 = DateRangeBuilder.INSTANCE;
        localObject9 = DateRangeBuilder.build(paramDataReader);
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("region", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject8 = UrnCoercer.INSTANCE;
        localObject8 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("locationName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("companyName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("companyUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = UrnCoercer.INSTANCE;
        localObject7 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("company", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = PositionCompanyBuilder.INSTANCE;
        localObject6 = PositionCompanyBuilder.build(paramDataReader);
        bool6 = true;
      }
      else
      {
        Object localObject11;
        if (paramDataReader.shouldReadField$11ca93e7("projects", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject5 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject11 = UrnCoercer.INSTANCE;
              localObject11 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
              if (localObject11 != null) {
                ((List)localObject5).add(localObject11);
              }
            }
          }
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("organizations", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject11 = UrnCoercer.INSTANCE;
              localObject11 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
              if (localObject11 != null) {
                ((List)localObject4).add(localObject11);
              }
            }
          }
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("honors", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject11 = UrnCoercer.INSTANCE;
              localObject11 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
              if (localObject11 != null) {
                ((List)localObject3).add(localObject11);
              }
            }
          }
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("courses", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject11 = UrnCoercer.INSTANCE;
              localObject11 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
              if (localObject11 != null) {
                ((List)localObject2).add(localObject11);
              }
            }
          }
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("recommendations", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject11 = UrnCoercer.INSTANCE;
              localObject11 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
              if (localObject11 != null) {
                ((List)localObject1).add(localObject11);
              }
            }
          }
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
    }
    if (!bool5) {
      localObject5 = Collections.emptyList();
    }
    if (!bool4) {
      localObject4 = Collections.emptyList();
    }
    if (!bool3) {
      localObject3 = Collections.emptyList();
    }
    if (!bool2) {
      localObject2 = Collections.emptyList();
    }
    if (!bool1) {
      localObject1 = Collections.emptyList();
    }
    return new Position((Urn)localObject10, str4, str3, (DateRange)localObject9, (Urn)localObject8, str2, str1, (Urn)localObject7, (PositionCompany)localObject6, (List)localObject5, (List)localObject4, (List)localObject3, (List)localObject2, (List)localObject1, bool14, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Position readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Position");
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
          localObject7 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Position");
    }
    Object localObject7 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Position");
    }
    if (((ByteBuffer)localObject7).getInt() != -521777773)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject7);
      throw new IOException("UID mismatch. Can't read cached data when building Position");
    }
    Object localObject6 = null;
    String str1 = null;
    String str2 = null;
    paramString = null;
    DateRangeBuilder localDateRangeBuilder = null;
    Object localObject8 = null;
    String str3 = null;
    String str4 = null;
    Object localObject9 = null;
    localObject1 = null;
    PositionCompanyBuilder localPositionCompanyBuilder = null;
    ArrayList localArrayList = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    boolean bool4;
    boolean bool5;
    label291:
    boolean bool6;
    label318:
    boolean bool2;
    label345:
    boolean bool1;
    label402:
    label428:
    boolean bool7;
    label440:
    boolean bool8;
    label475:
    boolean bool9;
    label502:
    boolean bool10;
    if (((ByteBuffer)localObject7).get() == 1)
    {
      bool4 = true;
      if (bool4)
      {
        localObject6 = UrnCoercer.INSTANCE;
        localObject6 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject7));
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label740;
      }
      bool5 = true;
      if (bool5) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject7);
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label746;
      }
      bool6 = true;
      if (bool6) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject7);
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label752;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject7).get();
        paramString = localDateRangeBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localDateRangeBuilder = DateRangeBuilder.INSTANCE;
          paramString = DateRangeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label758;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = DateRangeBuilder.INSTANCE;
          paramString = DateRangeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (paramString == null) {
            break label764;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label770;
      }
      bool7 = true;
      if (bool7)
      {
        localObject8 = UrnCoercer.INSTANCE;
        localObject8 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject7));
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label776;
      }
      bool8 = true;
      if (bool8) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject7);
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label782;
      }
      bool9 = true;
      if (bool9) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject7);
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label788;
      }
      bool10 = true;
      label529:
      if (bool10)
      {
        localObject9 = UrnCoercer.INSTANCE;
        localObject9 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject7));
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label794;
      }
      bool3 = true;
      label564:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject1 = localPositionCompanyBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localPositionCompanyBuilder = PositionCompanyBuilder.INSTANCE;
          localObject1 = PositionCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label800;
          }
          bool2 = true;
        }
        label626:
        if (i == 1)
        {
          localObject1 = PositionCompanyBuilder.INSTANCE;
          localObject1 = PositionCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label806;
          }
          bool2 = true;
        }
      }
      label655:
      if (((ByteBuffer)localObject7).get() != 1) {
        break label812;
      }
    }
    label740:
    label746:
    label752:
    label758:
    label764:
    label770:
    label776:
    label782:
    label788:
    label794:
    label800:
    label806:
    label812:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramFissionTransaction = localArrayList;
      if (!bool3) {
        break label818;
      }
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject7);
      localArrayList = new ArrayList();
      for (;;)
      {
        paramFissionTransaction = localArrayList;
        if (i <= 0) {
          break;
        }
        paramFissionTransaction = UrnCoercer.INSTANCE;
        localArrayList.add(UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject7)));
        i -= 1;
      }
      bool4 = false;
      break;
      bool5 = false;
      break label291;
      bool6 = false;
      break label318;
      bool2 = false;
      break label345;
      bool1 = false;
      break label402;
      bool1 = false;
      break label428;
      bool7 = false;
      break label440;
      bool8 = false;
      break label475;
      bool9 = false;
      break label502;
      bool10 = false;
      break label529;
      bool3 = false;
      break label564;
      bool2 = false;
      break label626;
      bool2 = false;
      break label655;
    }
    label818:
    if (((ByteBuffer)localObject7).get() == 1) {}
    for (boolean bool11 = true; bool11; bool11 = false)
    {
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject7);
      localArrayList = new ArrayList();
      for (;;)
      {
        localObject2 = localArrayList;
        if (i <= 0) {
          break;
        }
        localObject2 = UrnCoercer.INSTANCE;
        localArrayList.add(UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject7)));
        i -= 1;
      }
    }
    if (((ByteBuffer)localObject7).get() == 1) {}
    for (boolean bool12 = true; bool12; bool12 = false)
    {
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject7);
      localArrayList = new ArrayList();
      for (;;)
      {
        localObject3 = localArrayList;
        if (i <= 0) {
          break;
        }
        localObject3 = UrnCoercer.INSTANCE;
        localArrayList.add(UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject7)));
        i -= 1;
      }
    }
    if (((ByteBuffer)localObject7).get() == 1) {}
    for (boolean bool13 = true; bool13; bool13 = false)
    {
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject7);
      localArrayList = new ArrayList();
      for (;;)
      {
        localObject4 = localArrayList;
        if (i <= 0) {
          break;
        }
        localObject4 = UrnCoercer.INSTANCE;
        localArrayList.add(UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject7)));
        i -= 1;
      }
    }
    if (((ByteBuffer)localObject7).get() == 1) {}
    for (boolean bool14 = true; bool14; bool14 = false)
    {
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject7);
      localArrayList = new ArrayList();
      for (;;)
      {
        localObject5 = localArrayList;
        if (i <= 0) {
          break;
        }
        localObject5 = UrnCoercer.INSTANCE;
        localArrayList.add(UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject7)));
        i -= 1;
      }
    }
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject7);
    }
    if (!bool3) {
      paramFissionTransaction = Collections.emptyList();
    }
    if (!bool11) {
      localObject2 = Collections.emptyList();
    }
    if (!bool12) {
      localObject3 = Collections.emptyList();
    }
    if (!bool13) {
      localObject4 = Collections.emptyList();
    }
    if (!bool14) {
      localObject5 = Collections.emptyList();
    }
    return new Position((Urn)localObject6, str1, str2, paramString, (Urn)localObject8, str3, str4, (Urn)localObject9, (PositionCompany)localObject1, paramFissionTransaction, (List)localObject2, (List)localObject3, (List)localObject4, (List)localObject5, bool4, bool5, bool6, bool1, bool7, bool8, bool9, bool10, bool2, bool3, bool11, bool12, bool13, bool14);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */