package com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.HighlightsMiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class SameTitleInfoBuilder
  implements FissileDataModelBuilder<SameTitleInfo>, DataTemplateBuilder<SameTitleInfo>
{
  public static final SameTitleInfoBuilder INSTANCE = new SameTitleInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("endorsers");
    JSON_KEY_STORE.put("totalCount");
    JSON_KEY_STORE.put("title");
  }
  
  public static SameTitleInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    int i = 0;
    String str = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("endorsers", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            HighlightsMiniProfileBuilder localHighlightsMiniProfileBuilder = HighlightsMiniProfileBuilder.INSTANCE;
            localArrayList.add(HighlightsMiniProfileBuilder.build(paramDataReader));
          }
        }
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("totalCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: endorsers when building com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SameTitleInfo");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: totalCount when building com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SameTitleInfo");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: title when building com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SameTitleInfo");
    }
    return new SameTitleInfo(localArrayList, i, str, bool3, bool2, bool1);
  }
  
  public static SameTitleInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SameTitleInfo");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
          localObject = paramString;
          if (i != 0) {
            break;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            return null;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building SameTitleInfo");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building SameTitleInfo");
    }
    if (((ByteBuffer)localObject).getInt() != 396184806)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building SameTitleInfo");
    }
    paramString = null;
    int k = 0;
    localByteBuffer = null;
    boolean bool1;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (!bool1) {
        break label362;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject);
      localArrayList = new ArrayList();
      label241:
      paramString = localArrayList;
      if (j <= 0) {
        break label362;
      }
      paramString = null;
      i = 1;
      int m = ((ByteBuffer)localObject).get();
      if (m == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
        HighlightsMiniProfileBuilder localHighlightsMiniProfileBuilder = HighlightsMiniProfileBuilder.INSTANCE;
        paramString = HighlightsMiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label350;
        }
        i = 1;
      }
      label295:
      if (m == 1)
      {
        paramString = HighlightsMiniProfileBuilder.INSTANCE;
        paramString = HighlightsMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject, null, paramFissionTransaction);
        if (paramString == null) {
          break label356;
        }
      }
    }
    label350:
    label356:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label241;
      bool1 = false;
      break;
      i = 0;
      break label295;
    }
    label362:
    boolean bool2;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      i = k;
      if (bool2) {
        i = ((ByteBuffer)localObject).getInt();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label452;
      }
    }
    label452:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramFissionTransaction = localByteBuffer;
      if (bool3) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label458;
      }
      throw new IOException("Failed to find required field: endorsers when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SameTitleInfo from fission.");
      bool2 = false;
      break;
    }
    label458:
    if (!bool2) {
      throw new IOException("Failed to find required field: totalCount when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SameTitleInfo from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: title when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SameTitleInfo from fission.");
    }
    return new SameTitleInfo(paramString, i, paramFissionTransaction, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SameTitleInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */