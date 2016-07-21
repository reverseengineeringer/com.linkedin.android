package com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.common.Duration;
import com.linkedin.android.pegasus.gen.voyager.common.DurationBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class OverlapInfoBuilder
  implements FissileDataModelBuilder<OverlapInfo>, DataTemplateBuilder<OverlapInfo>
{
  public static final OverlapInfoBuilder INSTANCE = new OverlapInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("detail");
    JSON_KEY_STORE.put("overlapDetail");
    JSON_KEY_STORE.put("overlapType");
  }
  
  public static OverlapInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    OverlapType localOverlapType = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("detail", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = DetailBuilder.INSTANCE;
        localObject2 = DetailBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("overlapDetail", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = OverlapDetailBuilder.INSTANCE;
        localObject1 = OverlapDetailBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("overlapType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localOverlapType = (OverlapType)paramDataReader.readEnum(OverlapType.Builder.INSTANCE);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: detail when building com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.OverlapInfo");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: overlapDetail when building com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.OverlapInfo");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: overlapType when building com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.OverlapInfo");
    }
    return new OverlapInfo((OverlapInfo.Detail)localObject2, (OverlapInfo.OverlapDetail)localObject1, localOverlapType, bool3, bool2, bool1);
  }
  
  public static OverlapInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building OverlapInfo");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building OverlapInfo");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building OverlapInfo");
    }
    if (((ByteBuffer)localObject2).getInt() != -13678438)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building OverlapInfo");
    }
    paramString = null;
    DetailBuilder localDetailBuilder = null;
    localObject1 = null;
    OverlapDetailBuilder localOverlapDetailBuilder = null;
    Object localObject3 = null;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localDetailBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localDetailBuilder = DetailBuilder.INSTANCE;
          paramString = DetailBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label474;
          }
          bool1 = true;
        }
        label280:
        if (i == 1)
        {
          paramString = DetailBuilder.INSTANCE;
          paramString = DetailBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label480;
          }
          bool1 = true;
        }
      }
      label306:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label486;
      }
      bool3 = true;
      label318:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localOverlapDetailBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localOverlapDetailBuilder = OverlapDetailBuilder.INSTANCE;
          localObject1 = OverlapDetailBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label492;
          }
          bool2 = true;
        }
        label380:
        if (i == 1)
        {
          localObject1 = OverlapDetailBuilder.INSTANCE;
          localObject1 = OverlapDetailBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label498;
          }
          bool2 = true;
        }
      }
      label409:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label504;
      }
    }
    label474:
    label480:
    label486:
    label492:
    label498:
    label504:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool3) {
        paramFissionTransaction = OverlapType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label510;
      }
      throw new IOException("Failed to find required field: detail when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.OverlapInfo from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label280;
      bool1 = false;
      break label306;
      bool3 = false;
      break label318;
      bool2 = false;
      break label380;
      bool2 = false;
      break label409;
    }
    label510:
    if (!bool2) {
      throw new IOException("Failed to find required field: overlapDetail when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.OverlapInfo from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: overlapType when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.OverlapInfo from fission.");
    }
    return new OverlapInfo(paramString, (OverlapInfo.OverlapDetail)localObject1, paramFissionTransaction, bool1, bool2, bool3);
  }
  
  public static final class DetailBuilder
    implements FissileDataModelBuilder<OverlapInfo.Detail>, DataTemplateBuilder<OverlapInfo.Detail>
  {
    public static final DetailBuilder INSTANCE = new DetailBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.common.DateRange");
      JSON_KEY_STORE.put("com.linkedin.voyager.common.Duration");
    }
    
    public static OverlapInfo.Detail build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.common.DateRange", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = com.linkedin.android.pegasus.gen.common.DateRangeBuilder.INSTANCE;
          localObject2 = com.linkedin.android.pegasus.gen.common.DateRangeBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.common.Duration", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = DurationBuilder.INSTANCE;
          localObject1 = DurationBuilder.build(paramDataReader);
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
        throw new DataReaderException("Found more than 1 member when building .Detail");
      }
      return new OverlapInfo.Detail((com.linkedin.android.pegasus.gen.common.DateRange)localObject2, (Duration)localObject1, bool2, bool1);
    }
    
    public static OverlapInfo.Detail readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building OverlapInfo.Detail");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building OverlapInfo.Detail");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building OverlapInfo.Detail");
      }
      if (((ByteBuffer)localObject2).getInt() != -1551265394)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building OverlapInfo.Detail");
      }
      paramString = null;
      com.linkedin.android.pegasus.gen.common.DateRangeBuilder localDateRangeBuilder = null;
      localObject1 = null;
      DurationBuilder localDurationBuilder = null;
      boolean bool2;
      boolean bool1;
      if (((ByteBuffer)localObject2).get() == 1)
      {
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
            localDateRangeBuilder = com.linkedin.android.pegasus.gen.common.DateRangeBuilder.INSTANCE;
            paramString = com.linkedin.android.pegasus.gen.common.DateRangeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = com.linkedin.android.pegasus.gen.common.DateRangeBuilder.INSTANCE;
            paramString = com.linkedin.android.pegasus.gen.common.DateRangeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
          localObject1 = localDurationBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localDurationBuilder = DurationBuilder.INSTANCE;
            localObject1 = DurationBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = DurationBuilder.INSTANCE;
            localObject1 = DurationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
        throw new IOException("Found more than 1 member when reading .Detail from fission.");
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
      return new OverlapInfo.Detail(paramString, (Duration)localObject1, bool1, bool3);
    }
  }
  
  public static final class OverlapDetailBuilder
    implements FissileDataModelBuilder<OverlapInfo.OverlapDetail>, DataTemplateBuilder<OverlapInfo.OverlapDetail>
  {
    public static final OverlapDetailBuilder INSTANCE = new OverlapDetailBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.common.DateRange");
      JSON_KEY_STORE.put("com.linkedin.voyager.common.Duration");
    }
    
    public static OverlapInfo.OverlapDetail build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.common.DateRange", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = com.linkedin.android.pegasus.gen.voyager.common.DateRangeBuilder.INSTANCE;
          localObject2 = com.linkedin.android.pegasus.gen.voyager.common.DateRangeBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.common.Duration", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = DurationBuilder.INSTANCE;
          localObject1 = DurationBuilder.build(paramDataReader);
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
        throw new DataReaderException("Found more than 1 member when building .OverlapDetail");
      }
      return new OverlapInfo.OverlapDetail((com.linkedin.android.pegasus.gen.voyager.common.DateRange)localObject2, (Duration)localObject1, bool2, bool1);
    }
    
    public static OverlapInfo.OverlapDetail readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building OverlapInfo.OverlapDetail");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building OverlapInfo.OverlapDetail");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building OverlapInfo.OverlapDetail");
      }
      if (((ByteBuffer)localObject2).getInt() != -1661223226)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building OverlapInfo.OverlapDetail");
      }
      paramString = null;
      com.linkedin.android.pegasus.gen.voyager.common.DateRangeBuilder localDateRangeBuilder = null;
      localObject1 = null;
      DurationBuilder localDurationBuilder = null;
      boolean bool2;
      boolean bool1;
      if (((ByteBuffer)localObject2).get() == 1)
      {
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
            localDateRangeBuilder = com.linkedin.android.pegasus.gen.voyager.common.DateRangeBuilder.INSTANCE;
            paramString = com.linkedin.android.pegasus.gen.voyager.common.DateRangeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = com.linkedin.android.pegasus.gen.voyager.common.DateRangeBuilder.INSTANCE;
            paramString = com.linkedin.android.pegasus.gen.voyager.common.DateRangeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
          localObject1 = localDurationBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localDurationBuilder = DurationBuilder.INSTANCE;
            localObject1 = DurationBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = DurationBuilder.INSTANCE;
            localObject1 = DurationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
        throw new IOException("Found more than 1 member when reading .OverlapDetail from fission.");
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
      return new OverlapInfo.OverlapDetail(paramString, (Duration)localObject1, bool1, bool3);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.OverlapInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */