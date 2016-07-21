package com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.ImageBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ReconnectionBriefBuilder
  implements FissileDataModelBuilder<ReconnectionBrief>, DataTemplateBuilder<ReconnectionBrief>
{
  public static final ReconnectionBriefBuilder INSTANCE = new ReconnectionBriefBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("type");
    JSON_KEY_STORE.put("briefUrn");
    JSON_KEY_STORE.put("text");
    JSON_KEY_STORE.put("image");
    JSON_KEY_STORE.put("link");
    JSON_KEY_STORE.put("source");
  }
  
  public static ReconnectionBrief build(DataReader paramDataReader)
    throws DataReaderException
  {
    ReconnectionBriefType localReconnectionBriefType = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    String str = null;
    Object localObject1 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localReconnectionBriefType = (ReconnectionBriefType)paramDataReader.readEnum(ReconnectionBriefType.Builder.INSTANCE);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("briefUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AttributedTextBuilder.INSTANCE;
        localObject3 = AttributedTextBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("image", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ImageBuilder.INSTANCE;
        localObject2 = ImageBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("link", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("source", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = ReconnectionBriefSourceBuilder.INSTANCE;
        localObject1 = ReconnectionBriefSourceBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: type when building com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionBrief");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: text when building com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionBrief");
    }
    return new ReconnectionBrief(localReconnectionBriefType, (Urn)localObject4, (AttributedText)localObject3, (Image)localObject2, str, (ReconnectionBriefSource)localObject1, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static ReconnectionBrief readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ReconnectionBrief");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ReconnectionBrief");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ReconnectionBrief");
    }
    if (((ByteBuffer)localObject3).getInt() != 354289777)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building ReconnectionBrief");
    }
    ReconnectionBriefType localReconnectionBriefType = null;
    Object localObject4 = null;
    paramString = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    localObject1 = null;
    ImageBuilder localImageBuilder = null;
    String str = null;
    Object localObject2 = null;
    ReconnectionBriefSourceBuilder localReconnectionBriefSourceBuilder = null;
    boolean bool5;
    boolean bool6;
    label265:
    boolean bool2;
    label300:
    boolean bool1;
    label357:
    label383:
    boolean bool3;
    label395:
    label457:
    label486:
    boolean bool7;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool5 = true;
      if (bool5) {
        localReconnectionBriefType = ReconnectionBriefType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label649;
      }
      bool6 = true;
      if (bool6)
      {
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label655;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = localAttributedTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label661;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label667;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label673;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localImageBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localImageBuilder = ImageBuilder.INSTANCE;
          localObject1 = ImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label679;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = ImageBuilder.INSTANCE;
          localObject1 = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label685;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label691;
      }
      bool7 = true;
      label498:
      if (bool7) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label697;
      }
      bool3 = true;
      label525:
      bool4 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localReconnectionBriefSourceBuilder;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localReconnectionBriefSourceBuilder = ReconnectionBriefSourceBuilder.INSTANCE;
          localObject2 = ReconnectionBriefSourceBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label703;
          }
          bool3 = true;
        }
        label583:
        bool4 = bool3;
        if (i == 1)
        {
          localObject2 = ReconnectionBriefSourceBuilder.INSTANCE;
          localObject2 = ReconnectionBriefSourceBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label709;
          }
        }
      }
    }
    label649:
    label655:
    label661:
    label667:
    label673:
    label679:
    label685:
    label691:
    label697:
    label703:
    label709:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (bool5) {
        break label715;
      }
      throw new IOException("Failed to find required field: type when reading com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionBrief from fission.");
      bool5 = false;
      break;
      bool6 = false;
      break label265;
      bool2 = false;
      break label300;
      bool1 = false;
      break label357;
      bool1 = false;
      break label383;
      bool3 = false;
      break label395;
      bool2 = false;
      break label457;
      bool2 = false;
      break label486;
      bool7 = false;
      break label498;
      bool3 = false;
      break label525;
      bool3 = false;
      break label583;
    }
    label715:
    if (!bool1) {
      throw new IOException("Failed to find required field: text when reading com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionBrief from fission.");
    }
    return new ReconnectionBrief(localReconnectionBriefType, (Urn)localObject4, paramString, (Image)localObject1, str, (ReconnectionBriefSource)localObject2, bool5, bool6, bool1, bool2, bool7, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionBriefBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */