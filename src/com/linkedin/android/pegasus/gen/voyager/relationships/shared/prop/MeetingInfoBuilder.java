package com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class MeetingInfoBuilder
  implements FissileDataModelBuilder<MeetingInfo>, DataTemplateBuilder<MeetingInfo>
{
  public static final MeetingInfoBuilder INSTANCE = new MeetingInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("meetingId");
    JSON_KEY_STORE.put("attendees");
  }
  
  public static MeetingInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    ArrayList localArrayList = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("meetingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("attendees", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            MiniProfileBuilder localMiniProfileBuilder = MiniProfileBuilder.INSTANCE;
            localArrayList.add(MiniProfileBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: meetingId when building com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.MeetingInfo");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: attendees when building com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.MeetingInfo");
    }
    return new MeetingInfo(str, localArrayList, bool1, bool2);
  }
  
  public static MeetingInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building MeetingInfo");
    }
    Object localObject2 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building MeetingInfo");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building MeetingInfo");
    }
    if (((ByteBuffer)localObject1).getInt() != 1762836870)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building MeetingInfo");
    }
    localObject2 = null;
    paramString = null;
    boolean bool1;
    boolean bool2;
    label241:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label374;
      }
      bool2 = true;
      if (!bool2) {
        break label392;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label265:
      paramString = localArrayList;
      if (j <= 0) {
        break label392;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        MiniProfileBuilder localMiniProfileBuilder = MiniProfileBuilder.INSTANCE;
        paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label380;
        }
        i = 1;
      }
      label319:
      if (k == 1)
      {
        paramString = MiniProfileBuilder.INSTANCE;
        paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label386;
        }
      }
    }
    label374:
    label380:
    label386:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label265;
      bool1 = false;
      break;
      bool2 = false;
      break label241;
      i = 0;
      break label319;
    }
    label392:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: meetingId when reading com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.MeetingInfo from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: attendees when reading com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.MeetingInfo from fission.");
    }
    return new MeetingInfo((String)localObject2, paramString, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.MeetingInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */