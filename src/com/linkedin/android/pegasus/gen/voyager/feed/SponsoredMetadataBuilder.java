package com.linkedin.android.pegasus.gen.voyager.feed;

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

public final class SponsoredMetadataBuilder
  implements FissileDataModelBuilder<SponsoredMetadata>, DataTemplateBuilder<SponsoredMetadata>
{
  public static final SponsoredMetadataBuilder INSTANCE = new SponsoredMetadataBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("tscpUrl");
    JSON_KEY_STORE.put("activityType");
    JSON_KEY_STORE.put("displayFormat");
    JSON_KEY_STORE.put("externalTracking");
    JSON_KEY_STORE.put("landingUrl");
  }
  
  public static SponsoredMetadata build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    SponsoredActivityType localSponsoredActivityType = null;
    String str2 = null;
    Object localObject = null;
    String str1 = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("tscpUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("activityType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSponsoredActivityType = (SponsoredActivityType)paramDataReader.readEnum(SponsoredActivityType.Builder.INSTANCE);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("displayFormat", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("externalTracking", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ExternalTrackingBuilder.INSTANCE;
        localObject = ExternalTrackingBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("landingUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: tscpUrl when building com.linkedin.android.pegasus.gen.voyager.feed.SponsoredMetadata");
    }
    return new SponsoredMetadata(str3, localSponsoredActivityType, str2, (ExternalTracking)localObject, str1, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static SponsoredMetadata readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SponsoredMetadata");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SponsoredMetadata");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SponsoredMetadata");
    }
    if (((ByteBuffer)localObject1).getInt() != -736678863)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SponsoredMetadata");
    }
    localObject2 = null;
    SponsoredActivityType localSponsoredActivityType = null;
    String str = null;
    paramString = null;
    ExternalTrackingBuilder localExternalTrackingBuilder = null;
    Object localObject3 = null;
    boolean bool3;
    boolean bool4;
    label253:
    boolean bool5;
    label283:
    label310:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label455;
      }
      bool4 = true;
      if (bool4) {
        localSponsoredActivityType = SponsoredActivityType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label461;
      }
      bool5 = true;
      if (bool5) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label467;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localExternalTrackingBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localExternalTrackingBuilder = ExternalTrackingBuilder.INSTANCE;
          paramString = ExternalTrackingBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label473;
          }
          bool1 = true;
        }
        label367:
        if (i == 1)
        {
          paramString = ExternalTrackingBuilder.INSTANCE;
          paramString = ExternalTrackingBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label479;
          }
          bool1 = true;
        }
      }
      label393:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label485;
      }
    }
    label455:
    label461:
    label467:
    label473:
    label479:
    label485:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label491;
      }
      throw new IOException("Failed to find required field: tscpUrl when reading com.linkedin.android.pegasus.gen.voyager.feed.SponsoredMetadata from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label253;
      bool5 = false;
      break label283;
      bool2 = false;
      break label310;
      bool1 = false;
      break label367;
      bool1 = false;
      break label393;
    }
    label491:
    return new SponsoredMetadata((String)localObject2, localSponsoredActivityType, str, paramString, paramFissionTransaction, bool3, bool4, bool5, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.SponsoredMetadataBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */