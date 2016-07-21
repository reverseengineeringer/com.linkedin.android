package com.linkedin.android.pegasus.gen.voyager.messaging.event;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.common.FileBuilder;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.CustomContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.CustomContentBuilder;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.ShareContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.ShareContentBuilder;
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

public final class MessageEventBuilder
  implements FissileDataModelBuilder<MessageEvent>, DataTemplateBuilder<MessageEvent>
{
  public static final MessageEventBuilder INSTANCE = new MessageEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("body");
    JSON_KEY_STORE.put("subject");
    JSON_KEY_STORE.put("attachments");
    JSON_KEY_STORE.put("customContent");
    JSON_KEY_STORE.put("shareContent");
    JSON_KEY_STORE.put("attributedBody");
  }
  
  public static MessageEvent build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("body", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("subject", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("attachments", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            FileBuilder localFileBuilder = FileBuilder.INSTANCE;
            ((List)localObject1).add(FileBuilder.build(paramDataReader));
          }
        }
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("customContent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = CustomContentBuilder.INSTANCE;
        localObject4 = CustomContentBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("shareContent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = ShareContentBuilder.INSTANCE;
        localObject3 = ShareContentBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("attributedBody", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = AttributedTextBuilder.INSTANCE;
        localObject2 = AttributedTextBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      localObject1 = Collections.emptyList();
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: body when building com.linkedin.android.pegasus.gen.voyager.messaging.event.MessageEvent");
    }
    return new MessageEvent(str2, str1, (List)localObject1, (CustomContent)localObject4, (ShareContent)localObject3, (AttributedText)localObject2, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static MessageEvent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building MessageEvent");
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
          localObject4 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building MessageEvent");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building MessageEvent");
    }
    if (((ByteBuffer)localObject4).getInt() != 67982659)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building MessageEvent");
    }
    String str1 = null;
    String str2 = null;
    paramString = null;
    localObject1 = null;
    CustomContentBuilder localCustomContentBuilder = null;
    Object localObject2 = null;
    ShareContentBuilder localShareContentBuilder = null;
    Object localObject3 = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    boolean bool5;
    boolean bool6;
    label262:
    boolean bool7;
    label289:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool5 = true;
      if (bool5) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label422;
      }
      bool6 = true;
      if (bool6) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label428;
      }
      bool7 = true;
      if (!bool7) {
        break label446;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4);
      localArrayList = new ArrayList();
      label313:
      paramString = localArrayList;
      if (j <= 0) {
        break label446;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject4).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
        FileBuilder localFileBuilder = FileBuilder.INSTANCE;
        paramString = FileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label434;
        }
        i = 1;
      }
      label367:
      if (k == 1)
      {
        paramString = FileBuilder.INSTANCE;
        paramString = FileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
        if (paramString == null) {
          break label440;
        }
      }
    }
    label422:
    label428:
    label434:
    label440:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label313;
      bool5 = false;
      break;
      bool6 = false;
      break label262;
      bool7 = false;
      break label289;
      i = 0;
      break label367;
    }
    label446:
    boolean bool2;
    boolean bool1;
    label520:
    label549:
    boolean bool3;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject1 = localCustomContentBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localCustomContentBuilder = CustomContentBuilder.INSTANCE;
          localObject1 = CustomContentBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label797;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          localObject1 = CustomContentBuilder.INSTANCE;
          localObject1 = CustomContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label803;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label809;
      }
      bool3 = true;
      label561:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject2 = localShareContentBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localShareContentBuilder = ShareContentBuilder.INSTANCE;
          localObject2 = ShareContentBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label815;
          }
          bool2 = true;
        }
        label623:
        if (i == 1)
        {
          localObject2 = ShareContentBuilder.INSTANCE;
          localObject2 = ShareContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label821;
          }
          bool2 = true;
        }
      }
      label652:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label827;
      }
      bool3 = true;
      label664:
      bool4 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject3 = localAttributedTextBuilder;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          localObject3 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label833;
          }
          bool3 = true;
        }
        label722:
        bool4 = bool3;
        if (i == 1)
        {
          localObject3 = AttributedTextBuilder.INSTANCE;
          localObject3 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label839;
          }
        }
      }
    }
    label797:
    label803:
    label809:
    label815:
    label821:
    label827:
    label833:
    label839:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (!bool7) {
        paramString = Collections.emptyList();
      }
      if (bool5) {
        break label845;
      }
      throw new IOException("Failed to find required field: body when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.MessageEvent from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label520;
      bool1 = false;
      break label549;
      bool3 = false;
      break label561;
      bool2 = false;
      break label623;
      bool2 = false;
      break label652;
      bool3 = false;
      break label664;
      bool3 = false;
      break label722;
    }
    label845:
    return new MessageEvent(str1, str2, paramString, (CustomContent)localObject1, (ShareContent)localObject2, (AttributedText)localObject3, bool5, bool6, bool7, bool1, bool2, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.MessageEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */