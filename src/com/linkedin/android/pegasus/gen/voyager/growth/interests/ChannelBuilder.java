package com.linkedin.android.pegasus.gen.voyager.growth.interests;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfoBuilder;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.ImageBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ChannelBuilder
  implements FissileDataModelBuilder<Channel>, DataTemplateBuilder<Channel>
{
  public static final ChannelBuilder INSTANCE = new ChannelBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("urn");
    JSON_KEY_STORE.put("entityUrn");
    JSON_KEY_STORE.put("name");
    JSON_KEY_STORE.put("logo");
    JSON_KEY_STORE.put("backgroundImage");
    JSON_KEY_STORE.put("followingInfo");
  }
  
  public static Channel build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    String str1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("urn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = UrnCoercer.INSTANCE;
        localObject5 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("name", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("logo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = ImageBuilder.INSTANCE;
        localObject3 = ImageBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("backgroundImage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ImageBuilder.INSTANCE;
        localObject2 = ImageBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("followingInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = FollowingInfoBuilder.INSTANCE;
        localObject1 = FollowingInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: id when building com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: urn when building com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: name when building com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: followingInfo when building com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel");
    }
    return new Channel(str2, (Urn)localObject5, (Urn)localObject4, str1, (Image)localObject3, (Image)localObject2, (FollowingInfo)localObject1, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Channel readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Channel");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Channel");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Channel");
    }
    if (((ByteBuffer)localObject3).getInt() != 888517622)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building Channel");
    }
    String str1 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    String str2 = null;
    paramString = null;
    ImageBuilder localImageBuilder2 = null;
    localObject1 = null;
    ImageBuilder localImageBuilder1 = null;
    Object localObject2 = null;
    FollowingInfoBuilder localFollowingInfoBuilder = null;
    boolean bool5;
    boolean bool6;
    label265:
    boolean bool7;
    label300:
    boolean bool8;
    label335:
    boolean bool2;
    label362:
    boolean bool1;
    label419:
    label445:
    boolean bool3;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool5 = true;
      if (bool5) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label684;
      }
      bool6 = true;
      if (bool6)
      {
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label690;
      }
      bool7 = true;
      if (bool7)
      {
        localObject5 = UrnCoercer.INSTANCE;
        localObject5 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label696;
      }
      bool8 = true;
      if (bool8) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label702;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = localImageBuilder2;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localImageBuilder2 = ImageBuilder.INSTANCE;
          paramString = ImageBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label708;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ImageBuilder.INSTANCE;
          paramString = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label714;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label720;
      }
      bool3 = true;
      label457:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localImageBuilder1;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localImageBuilder1 = ImageBuilder.INSTANCE;
          localObject1 = ImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label726;
          }
          bool2 = true;
        }
        label519:
        if (i == 1)
        {
          localObject1 = ImageBuilder.INSTANCE;
          localObject1 = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label732;
          }
          bool2 = true;
        }
      }
      label548:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label738;
      }
      bool3 = true;
      label560:
      bool4 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localFollowingInfoBuilder;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localFollowingInfoBuilder = FollowingInfoBuilder.INSTANCE;
          localObject2 = FollowingInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label744;
          }
          bool3 = true;
        }
        label618:
        bool4 = bool3;
        if (i == 1)
        {
          localObject2 = FollowingInfoBuilder.INSTANCE;
          localObject2 = FollowingInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label750;
          }
        }
      }
    }
    label684:
    label690:
    label696:
    label702:
    label708:
    label714:
    label720:
    label726:
    label732:
    label738:
    label744:
    label750:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (bool5) {
        break label756;
      }
      throw new IOException("Failed to find required field: id when reading com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel from fission.");
      bool5 = false;
      break;
      bool6 = false;
      break label265;
      bool7 = false;
      break label300;
      bool8 = false;
      break label335;
      bool2 = false;
      break label362;
      bool1 = false;
      break label419;
      bool1 = false;
      break label445;
      bool3 = false;
      break label457;
      bool2 = false;
      break label519;
      bool2 = false;
      break label548;
      bool3 = false;
      break label560;
      bool3 = false;
      break label618;
    }
    label756:
    if (!bool6) {
      throw new IOException("Failed to find required field: urn when reading com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel from fission.");
    }
    if (!bool8) {
      throw new IOException("Failed to find required field: name when reading com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: followingInfo when reading com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel from fission.");
    }
    return new Channel(str1, (Urn)localObject4, (Urn)localObject5, str2, paramString, (Image)localObject1, (FollowingInfo)localObject2, bool5, bool6, bool7, bool8, bool1, bool2, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.interests.ChannelBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */