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
import java.util.List;

public final class ProjectBuilder
  implements FissileDataModelBuilder<Project>, DataTemplateBuilder<Project>
{
  public static final ProjectBuilder INSTANCE = new ProjectBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("url");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("occupation");
    JSON_KEY_STORE.put("timePeriod");
    JSON_KEY_STORE.put("members");
  }
  
  public static Project build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    ArrayList localArrayList = null;
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
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("occupation", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("timePeriod", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = DateRangeBuilder.INSTANCE;
        localObject1 = DateRangeBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("members", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            ContributorBuilder localContributorBuilder = ContributorBuilder.INSTANCE;
            localArrayList.add(ContributorBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: title when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Project");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: members when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Project");
    }
    return new Project((Urn)localObject3, str3, str2, str1, (Urn)localObject2, (DateRange)localObject1, localArrayList, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Project readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Project");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Project");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Project");
    }
    if (((ByteBuffer)localObject2).getInt() != 218661136)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building Project");
    }
    Object localObject3 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    Object localObject4 = null;
    paramString = null;
    Object localObject5 = null;
    localObject1 = null;
    boolean bool3;
    boolean bool4;
    label267:
    boolean bool5;
    label294:
    boolean bool6;
    label321:
    boolean bool7;
    label348:
    boolean bool2;
    label383:
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool3 = true;
      if (bool3)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label621;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label627;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label633;
      }
      bool6 = true;
      if (bool6) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label639;
      }
      bool7 = true;
      if (bool7)
      {
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label645;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = (String)localObject5;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localObject5 = DateRangeBuilder.INSTANCE;
          paramString = DateRangeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label651;
          }
          bool1 = true;
        }
        label440:
        if (i == 1)
        {
          paramString = DateRangeBuilder.INSTANCE;
          paramString = DateRangeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label657;
          }
          bool1 = true;
        }
      }
      label466:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label663;
      }
      bool2 = true;
      label478:
      if (!bool2) {
        break label681;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject5 = new ArrayList();
      label502:
      localObject1 = localObject5;
      if (j <= 0) {
        break label681;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        ContributorBuilder localContributorBuilder = ContributorBuilder.INSTANCE;
        localObject1 = ContributorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label669;
        }
        i = 1;
      }
      label562:
      if (k == 1)
      {
        localObject1 = ContributorBuilder.INSTANCE;
        localObject1 = ContributorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label675;
        }
      }
    }
    label621:
    label627:
    label633:
    label639:
    label645:
    label651:
    label657:
    label663:
    label669:
    label675:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject5).add(localObject1);
      }
      j -= 1;
      break label502;
      bool3 = false;
      break;
      bool4 = false;
      break label267;
      bool5 = false;
      break label294;
      bool6 = false;
      break label321;
      bool7 = false;
      break label348;
      bool2 = false;
      break label383;
      bool1 = false;
      break label440;
      bool1 = false;
      break label466;
      bool2 = false;
      break label478;
      i = 0;
      break label562;
    }
    label681:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: title when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Project from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: members when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Project from fission.");
    }
    return new Project((Urn)localObject3, str1, str2, str3, (Urn)localObject4, paramString, (List)localObject1, bool3, bool4, bool5, bool6, bool7, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProjectBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */