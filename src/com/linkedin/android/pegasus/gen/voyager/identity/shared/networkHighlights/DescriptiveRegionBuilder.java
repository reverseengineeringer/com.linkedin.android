package com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.common.EnrichedLocation;
import com.linkedin.android.pegasus.gen.voyager.common.EnrichedLocationBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.HighlightsMiniProfileBuilder;
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

public final class DescriptiveRegionBuilder
  implements FissileDataModelBuilder<DescriptiveRegion>, DataTemplateBuilder<DescriptiveRegion>
{
  public static final DescriptiveRegionBuilder INSTANCE = new DescriptiveRegionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("location");
    JSON_KEY_STORE.put("locationName");
    JSON_KEY_STORE.put("numConnections");
    JSON_KEY_STORE.put("connections");
  }
  
  public static DescriptiveRegion build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    String str = null;
    int i = 0;
    Object localObject1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("location", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = EnrichedLocationBuilder.INSTANCE;
        localObject2 = EnrichedLocationBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("locationName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("numConnections", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("connections", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            HighlightsMiniProfileBuilder localHighlightsMiniProfileBuilder = HighlightsMiniProfileBuilder.INSTANCE;
            ((List)localObject1).add(HighlightsMiniProfileBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      localObject1 = Collections.emptyList();
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: location when building com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveRegion");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: numConnections when building com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveRegion");
    }
    return new DescriptiveRegion((EnrichedLocation)localObject2, str, i, (List)localObject1, bool4, bool3, bool2, bool1);
  }
  
  public static DescriptiveRegion readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building DescriptiveRegion");
    }
    Object localObject1 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building DescriptiveRegion");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building DescriptiveRegion");
    }
    if (((ByteBuffer)localObject2).getInt() != 792136440)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building DescriptiveRegion");
    }
    paramString = null;
    Object localObject3 = null;
    String str = null;
    int j = 0;
    localObject1 = null;
    boolean bool2;
    boolean bool1;
    label280:
    label306:
    label318:
    boolean bool3;
    label345:
    boolean bool4;
    label369:
    int k;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = (String)localObject3;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localObject3 = EnrichedLocationBuilder.INSTANCE;
          paramString = EnrichedLocationBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label512;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = EnrichedLocationBuilder.INSTANCE;
          paramString = EnrichedLocationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label518;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label524;
      }
      bool2 = true;
      if (bool2) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label530;
      }
      bool3 = true;
      if (bool3) {
        j = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label536;
      }
      bool4 = true;
      if (!bool4) {
        break label554;
      }
      k = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject3 = new ArrayList();
      label393:
      localObject1 = localObject3;
      if (k <= 0) {
        break label554;
      }
      localObject1 = null;
      i = 1;
      int m = ((ByteBuffer)localObject2).get();
      if (m == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        HighlightsMiniProfileBuilder localHighlightsMiniProfileBuilder = HighlightsMiniProfileBuilder.INSTANCE;
        localObject1 = HighlightsMiniProfileBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label542;
        }
        i = 1;
      }
      label453:
      if (m == 1)
      {
        localObject1 = HighlightsMiniProfileBuilder.INSTANCE;
        localObject1 = HighlightsMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label548;
        }
      }
    }
    label512:
    label518:
    label524:
    label530:
    label536:
    label542:
    label548:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject3).add(localObject1);
      }
      k -= 1;
      break label393;
      bool2 = false;
      break;
      bool1 = false;
      break label280;
      bool1 = false;
      break label306;
      bool2 = false;
      break label318;
      bool3 = false;
      break label345;
      bool4 = false;
      break label369;
      i = 0;
      break label453;
    }
    label554:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool4) {
      localObject1 = Collections.emptyList();
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: location when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveRegion from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: numConnections when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveRegion from fission.");
    }
    return new DescriptiveRegion(paramString, str, j, (List)localObject1, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveRegionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */