package com.linkedin.android.pegasus.gen.voyager.growth.lego;

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

public final class WidgetContentBuilder
  implements FissileDataModelBuilder<WidgetContent>, DataTemplateBuilder<WidgetContent>
{
  public static final WidgetContentBuilder INSTANCE = new WidgetContentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("widgetId");
    JSON_KEY_STORE.put("trackingToken");
    JSON_KEY_STORE.put("prefetchable");
  }
  
  public static WidgetContent build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("widgetId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingToken", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("prefetchable", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool4 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: widgetId when building com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: trackingToken when building com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: prefetchable when building com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent");
    }
    return new WidgetContent(str2, str1, bool4, bool3, bool1, bool2);
  }
  
  public static WidgetContent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building WidgetContent");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building WidgetContent");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building WidgetContent");
    }
    if (((ByteBuffer)localObject).getInt() != 336873126)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building WidgetContent");
    }
    paramString = null;
    paramFissionTransaction = null;
    boolean bool1 = false;
    boolean bool2;
    boolean bool3;
    label242:
    boolean bool4;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      if (bool2) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label318;
      }
      bool3 = true;
      if (bool3) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label324;
      }
      bool4 = true;
      label268:
      if (bool4) {
        if (((ByteBuffer)localObject).get() != 1) {
          break label330;
        }
      }
    }
    label318:
    label324:
    label330:
    for (bool1 = true;; bool1 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool2) {
        break label336;
      }
      throw new IOException("Failed to find required field: widgetId when reading com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent from fission.");
      bool2 = false;
      break;
      bool3 = false;
      break label242;
      bool4 = false;
      break label268;
    }
    label336:
    if (!bool3) {
      throw new IOException("Failed to find required field: trackingToken when reading com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: prefetchable when reading com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent from fission.");
    }
    return new WidgetContent(paramString, paramFissionTransaction, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */