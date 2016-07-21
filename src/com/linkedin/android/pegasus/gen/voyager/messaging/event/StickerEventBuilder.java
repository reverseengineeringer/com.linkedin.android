package com.linkedin.android.pegasus.gen.voyager.messaging.event;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.GroupContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.GroupContentBuilder;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.Sticker;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.StickerBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class StickerEventBuilder
  implements FissileDataModelBuilder<StickerEvent>, DataTemplateBuilder<StickerEvent>
{
  public static final StickerEventBuilder INSTANCE = new StickerEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("sticker");
    JSON_KEY_STORE.put("customContent");
  }
  
  public static StickerEvent build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("sticker", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = StickerBuilder.INSTANCE;
        localObject1 = StickerBuilder.build(paramDataReader);
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("customContent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = CustomContentBuilder.INSTANCE;
        localObject2 = CustomContentBuilder.build(paramDataReader);
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: sticker when building com.linkedin.android.pegasus.gen.voyager.messaging.event.StickerEvent");
    }
    return new StickerEvent((Sticker)localObject1, (StickerEvent.CustomContent)localObject2, bool1, bool2);
  }
  
  public static StickerEvent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building StickerEvent");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building StickerEvent");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building StickerEvent");
    }
    if (((ByteBuffer)localObject2).getInt() != -923724558)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building StickerEvent");
    }
    paramString = null;
    StickerBuilder localStickerBuilder = null;
    localObject1 = null;
    CustomContentBuilder localCustomContentBuilder = null;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        bool1 = bool2;
        paramString = localStickerBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localStickerBuilder = StickerBuilder.INSTANCE;
          paramString = StickerBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label439;
          }
          bool1 = true;
        }
        label277:
        if (i == 1)
        {
          paramString = StickerBuilder.INSTANCE;
          paramString = StickerBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label445;
          }
          bool1 = true;
        }
      }
      label303:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label451;
      }
      bool2 = true;
      label315:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localCustomContentBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localCustomContentBuilder = CustomContentBuilder.INSTANCE;
          localObject1 = CustomContentBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label457;
          }
          bool2 = true;
        }
        label373:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = CustomContentBuilder.INSTANCE;
          localObject1 = CustomContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label463;
          }
        }
      }
    }
    label439:
    label445:
    label451:
    label457:
    label463:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label469;
      }
      throw new IOException("Failed to find required field: sticker when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.StickerEvent from fission.");
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
    label469:
    return new StickerEvent(paramString, (StickerEvent.CustomContent)localObject1, bool1, bool3);
  }
  
  public static final class CustomContentBuilder
    implements FissileDataModelBuilder<StickerEvent.CustomContent>, DataTemplateBuilder<StickerEvent.CustomContent>
  {
    public static final CustomContentBuilder INSTANCE = new CustomContentBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.messaging.event.message.GroupContent");
    }
    
    public static StickerEvent.CustomContent build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject = null;
      boolean bool = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.messaging.event.message.GroupContent", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject = GroupContentBuilder.INSTANCE;
          localObject = GroupContentBuilder.build(paramDataReader);
          bool = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      return new StickerEvent.CustomContent((GroupContent)localObject, bool);
    }
    
    public static StickerEvent.CustomContent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building StickerEvent.CustomContent");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building StickerEvent.CustomContent");
      }
      Object localObject1 = localObject2;
      if (((ByteBuffer)localObject2).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("Invalid header prefix. Can't read cached data when building StickerEvent.CustomContent");
      }
      if (((ByteBuffer)localObject1).getInt() != 1244283374)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("UID mismatch. Can't read cached data when building StickerEvent.CustomContent");
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
            localObject2 = GroupContentBuilder.INSTANCE;
            paramString = GroupContentBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label326;
            }
            bool1 = true;
          }
          label267:
          bool2 = bool1;
          if (i == 1)
          {
            paramString = GroupContentBuilder.INSTANCE;
            paramString = GroupContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
            if (paramString == null) {
              break label332;
            }
          }
        }
      }
      label326:
      label332:
      for (boolean bool2 = true;; bool2 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject1);
        }
        return new StickerEvent.CustomContent(paramString, bool2);
        bool1 = false;
        break;
        bool1 = false;
        break label267;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.StickerEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */