package com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.ChannelBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class RecommendedChannelBuilder
  implements FissileDataModelBuilder<RecommendedChannel>, DataTemplateBuilder<RecommendedChannel>
{
  public static final RecommendedChannelBuilder INSTANCE = new RecommendedChannelBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("trackingId");
    JSON_KEY_STORE.put("objectUrn");
    JSON_KEY_STORE.put("channel");
    JSON_KEY_STORE.put("reason");
  }
  
  public static RecommendedChannel build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("objectUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("channel", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ChannelBuilder.INSTANCE;
        localObject2 = ChannelBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("reason", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = AnnotatedTextBuilder.INSTANCE;
        localObject1 = AnnotatedTextBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: channel when building com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedChannel");
    }
    return new RecommendedChannel(str, (Urn)localObject3, (Channel)localObject2, (AnnotatedText)localObject1, bool4, bool3, bool2, bool1);
  }
  
  public static RecommendedChannel readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building RecommendedChannel");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building RecommendedChannel");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building RecommendedChannel");
    }
    if (((ByteBuffer)localObject2).getInt() != -2062216166)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building RecommendedChannel");
    }
    String str = null;
    Object localObject3 = null;
    paramString = null;
    ChannelBuilder localChannelBuilder = null;
    localObject1 = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder = null;
    boolean bool4;
    boolean bool5;
    label253:
    boolean bool2;
    label288:
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label507;
      }
      bool5 = true;
      if (bool5)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label513;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localChannelBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localChannelBuilder = ChannelBuilder.INSTANCE;
          paramString = ChannelBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label519;
          }
          bool1 = true;
        }
        label345:
        if (i == 1)
        {
          paramString = ChannelBuilder.INSTANCE;
          paramString = ChannelBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label525;
          }
          bool1 = true;
        }
      }
      label371:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label531;
      }
      bool2 = true;
      label383:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localAnnotatedTextBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localAnnotatedTextBuilder = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label537;
          }
          bool2 = true;
        }
        label441:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label543;
          }
        }
      }
    }
    label507:
    label513:
    label519:
    label525:
    label531:
    label537:
    label543:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label549;
      }
      throw new IOException("Failed to find required field: channel when reading com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedChannel from fission.");
      bool4 = false;
      break;
      bool5 = false;
      break label253;
      bool2 = false;
      break label288;
      bool1 = false;
      break label345;
      bool1 = false;
      break label371;
      bool2 = false;
      break label383;
      bool2 = false;
      break label441;
    }
    label549:
    return new RecommendedChannel(str, (Urn)localObject3, paramString, (AnnotatedText)localObject1, bool4, bool5, bool1, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedChannelBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */