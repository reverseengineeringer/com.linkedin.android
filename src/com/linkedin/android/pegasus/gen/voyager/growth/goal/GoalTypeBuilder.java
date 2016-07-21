package com.linkedin.android.pegasus.gen.voyager.growth.goal;

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

public final class GoalTypeBuilder
  implements FissileDataModelBuilder<GoalType>, DataTemplateBuilder<GoalType>
{
  public static final GoalTypeBuilder INSTANCE = new GoalTypeBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("typeSymbol");
  }
  
  public static GoalType build(DataReader paramDataReader)
    throws DataReaderException
  {
    GoalTypeSymbol localGoalTypeSymbol = null;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("typeSymbol", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localGoalTypeSymbol = (GoalTypeSymbol)paramDataReader.readEnum(GoalTypeSymbol.Builder.INSTANCE);
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool) {
      throw new DataReaderException("Failed to find required field: typeSymbol when building com.linkedin.android.pegasus.gen.voyager.growth.goal.GoalType");
    }
    return new GoalType(localGoalTypeSymbol, bool);
  }
  
  public static GoalType readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building GoalType");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      int i = paramString.get();
      int j;
      do
      {
        do
        {
          localObject = paramString;
          if (i != 0) {
            break label170;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            break;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building GoalType");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building GoalType");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != 1355007162)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building GoalType");
    }
    paramString = null;
    if (((ByteBuffer)localObject).get() == 1) {}
    for (;;)
    {
      if (bool) {
        paramString = GoalTypeSymbol.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool) {
        break;
      }
      throw new IOException("Failed to find required field: typeSymbol when reading com.linkedin.android.pegasus.gen.voyager.growth.goal.GoalType from fission.");
      bool = false;
    }
    return new GoalType(paramString, bool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.goal.GoalTypeBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */