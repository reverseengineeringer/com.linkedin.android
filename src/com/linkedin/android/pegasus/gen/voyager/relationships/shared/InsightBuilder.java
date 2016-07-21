package com.linkedin.android.pegasus.gen.voyager.relationships.shared;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class InsightBuilder
  implements FissileDataModelBuilder<Insight>, DataTemplateBuilder<Insight>
{
  public static final InsightBuilder INSTANCE = new InsightBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("sharedInsight");
  }
  
  public static Insight build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("sharedInsight", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = SharedInsightBuilder.INSTANCE;
        localObject = SharedInsightBuilder.build(paramDataReader);
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool) {
      throw new DataReaderException("Failed to find required field: sharedInsight when building com.linkedin.android.pegasus.gen.voyager.relationships.shared.Insight");
    }
    return new Insight((Insight.SharedInsight)localObject, bool);
  }
  
  public static Insight readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Insight");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Insight");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Insight");
    }
    if (((ByteBuffer)localObject1).getInt() != -2117847196)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Insight");
    }
    paramString = null;
    localObject2 = null;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = (String)localObject2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localObject2 = SharedInsightBuilder.INSTANCE;
          paramString = SharedInsightBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label330;
          }
          bool1 = true;
        }
        label267:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = SharedInsightBuilder.INSTANCE;
          paramString = SharedInsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label336;
          }
        }
      }
    }
    label330:
    label336:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool2) {
        break label342;
      }
      throw new IOException("Failed to find required field: sharedInsight when reading com.linkedin.android.pegasus.gen.voyager.relationships.shared.Insight from fission.");
      bool1 = false;
      break;
      bool1 = false;
      break label267;
    }
    label342:
    return new Insight(paramString, bool2);
  }
  
  public static final class SharedInsightBuilder
    implements FissileDataModelBuilder<Insight.SharedInsight>, DataTemplateBuilder<Insight.SharedInsight>
  {
    public static final SharedInsightBuilder INSTANCE = new SharedInsightBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.relationships.shared.SharedCompanyInsight");
      JSON_KEY_STORE.put("com.linkedin.voyager.relationships.shared.SharedConnectionsInsight");
      JSON_KEY_STORE.put("com.linkedin.voyager.relationships.shared.SharedEducationInsight");
    }
    
    public static Insight.SharedInsight build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject3 = null;
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool3 = false;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.relationships.shared.SharedCompanyInsight", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = SharedCompanyInsightBuilder.INSTANCE;
          localObject3 = SharedCompanyInsightBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.relationships.shared.SharedConnectionsInsight", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = SharedConnectionsInsightBuilder.INSTANCE;
          localObject2 = SharedConnectionsInsightBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.relationships.shared.SharedEducationInsight", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = SharedEducationInsightBuilder.INSTANCE;
          localObject1 = SharedEducationInsightBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int i = 0;
      if (bool3) {
        i = 1;
      }
      int j = i;
      if (bool2)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .SharedInsight");
        }
        j = 1;
      }
      if ((bool1) && (j != 0)) {
        throw new DataReaderException("Found more than 1 member when building .SharedInsight");
      }
      return new Insight.SharedInsight((SharedCompanyInsight)localObject3, (SharedConnectionsInsight)localObject2, (SharedEducationInsight)localObject1, bool3, bool2, bool1);
    }
    
    public static Insight.SharedInsight readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building Insight.SharedInsight");
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
        do
        {
          do
          {
            localObject3 = paramString;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building Insight.SharedInsight");
      }
      Object localObject3 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building Insight.SharedInsight");
      }
      if (((ByteBuffer)localObject3).getInt() != -1820056029)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
        throw new IOException("UID mismatch. Can't read cached data when building Insight.SharedInsight");
      }
      paramString = null;
      SharedCompanyInsightBuilder localSharedCompanyInsightBuilder = null;
      localObject1 = null;
      SharedConnectionsInsightBuilder localSharedConnectionsInsightBuilder = null;
      Object localObject2 = null;
      SharedEducationInsightBuilder localSharedEducationInsightBuilder = null;
      boolean bool2;
      boolean bool1;
      label283:
      label309:
      boolean bool3;
      if (((ByteBuffer)localObject3).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject3).get();
          paramString = localSharedCompanyInsightBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
            localSharedCompanyInsightBuilder = SharedCompanyInsightBuilder.INSTANCE;
            paramString = SharedCompanyInsightBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label568;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = SharedCompanyInsightBuilder.INSTANCE;
            paramString = SharedCompanyInsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
            if (paramString == null) {
              break label574;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject3).get() != 1) {
          break label580;
        }
        bool3 = true;
        label321:
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject3).get();
          localObject1 = localSharedConnectionsInsightBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
            localSharedConnectionsInsightBuilder = SharedConnectionsInsightBuilder.INSTANCE;
            localObject1 = SharedConnectionsInsightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label586;
            }
            bool2 = true;
          }
          label383:
          if (i == 1)
          {
            localObject1 = SharedConnectionsInsightBuilder.INSTANCE;
            localObject1 = SharedConnectionsInsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label592;
            }
            bool2 = true;
          }
        }
        label412:
        if (((ByteBuffer)localObject3).get() != 1) {
          break label598;
        }
        bool3 = true;
        label424:
        bool4 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject3).get();
          localObject2 = localSharedEducationInsightBuilder;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
            localSharedEducationInsightBuilder = SharedEducationInsightBuilder.INSTANCE;
            localObject2 = SharedEducationInsightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label604;
            }
            bool3 = true;
          }
          label482:
          bool4 = bool3;
          if (i == 1)
          {
            localObject2 = SharedEducationInsightBuilder.INSTANCE;
            localObject2 = SharedEducationInsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label610;
            }
          }
        }
      }
      label568:
      label574:
      label580:
      label586:
      label592:
      label598:
      label604:
      label610:
      for (boolean bool4 = true;; bool4 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject3);
        }
        i = 0;
        if (bool1) {
          i = 1;
        }
        j = i;
        if (!bool2) {
          break label619;
        }
        if (i == 0) {
          break label616;
        }
        throw new IOException("Found more than 1 member when reading .SharedInsight from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label283;
        bool1 = false;
        break label309;
        bool3 = false;
        break label321;
        bool2 = false;
        break label383;
        bool2 = false;
        break label412;
        bool3 = false;
        break label424;
        bool3 = false;
        break label482;
      }
      label616:
      int j = 1;
      label619:
      if ((bool4) && (j != 0)) {
        throw new IOException("Found more than 1 member when reading .SharedInsight from fission.");
      }
      return new Insight.SharedInsight(paramString, (SharedConnectionsInsight)localObject1, (SharedEducationInsight)localObject2, bool1, bool2, bool4);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.InsightBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */