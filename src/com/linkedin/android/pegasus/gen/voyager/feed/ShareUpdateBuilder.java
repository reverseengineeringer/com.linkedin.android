package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
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

public final class ShareUpdateBuilder
  implements FissileDataModelBuilder<ShareUpdate>, DataTemplateBuilder<ShareUpdate>
{
  public static final ShareUpdateBuilder INSTANCE = new ShareUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("content");
    JSON_KEY_STORE.put("shareAudience");
    JSON_KEY_STORE.put("actions");
    JSON_KEY_STORE.put("urn");
    JSON_KEY_STORE.put("actor");
    JSON_KEY_STORE.put("createdTime");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("tracking");
    JSON_KEY_STORE.put("header");
    JSON_KEY_STORE.put("edited");
    JSON_KEY_STORE.put("shareUrn");
  }
  
  public static ShareUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject7 = null;
    ShareAudience localShareAudience = null;
    Object localObject1 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    long l = 0L;
    String str = null;
    Object localObject4 = null;
    Object localObject3 = null;
    boolean bool12 = false;
    Object localObject2 = null;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("content", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = ShareUpdateContentBuilder.ContentBuilder.INSTANCE;
        localObject7 = ShareUpdateContentBuilder.ContentBuilder.build(paramDataReader);
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("shareAudience", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localShareAudience = (ShareAudience)paramDataReader.readEnum(ShareAudience.Builder.INSTANCE);
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actions", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            UpdateActionBuilder localUpdateActionBuilder = UpdateActionBuilder.INSTANCE;
            ((List)localObject1).add(UpdateActionBuilder.build(paramDataReader));
          }
        }
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("urn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = UrnCoercer.INSTANCE;
        localObject6 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actor", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = SocialActorBuilder.INSTANCE;
        localObject5 = SocialActorBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("createdTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("tracking", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = TrackingDataBuilder.INSTANCE;
        localObject4 = TrackingDataBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("header", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AttributedTextBuilder.INSTANCE;
        localObject3 = AttributedTextBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("edited", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool12 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("shareUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool9) {
      localObject1 = Collections.emptyList();
    }
    if (!bool11) {
      throw new DataReaderException("Failed to find required field: content when building com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate");
    }
    if (!bool10) {
      throw new DataReaderException("Failed to find required field: shareAudience when building com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate");
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: actor when building com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: createdTime when building com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate");
    }
    return new ShareUpdate((ShareUpdateContent.Content)localObject7, localShareAudience, (List)localObject1, (Urn)localObject6, (SocialActor)localObject5, l, str, (TrackingData)localObject4, (AttributedText)localObject3, bool12, (Urn)localObject2, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool2, bool3, bool1);
  }
  
  public static ShareUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ShareUpdate");
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
          localObject5 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ShareUpdate");
    }
    Object localObject5 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ShareUpdate");
    }
    if (((ByteBuffer)localObject5).getInt() != -659898025)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject5);
      throw new IOException("UID mismatch. Can't read cached data when building ShareUpdate");
    }
    paramString = null;
    Object localObject8 = null;
    ShareAudience localShareAudience = null;
    localObject1 = null;
    Object localObject6 = null;
    Object localObject2 = null;
    SocialActorBuilder localSocialActorBuilder = null;
    long l = 0L;
    String str = null;
    Object localObject3 = null;
    TrackingDataBuilder localTrackingDataBuilder = null;
    Object localObject4 = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    boolean bool12 = false;
    Object localObject7 = null;
    boolean bool2;
    boolean bool1;
    label310:
    label336:
    boolean bool6;
    label348:
    boolean bool7;
    if (((ByteBuffer)localObject5).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject5).get();
        paramString = (String)localObject8;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localObject8 = ShareUpdateContentBuilder.ContentBuilder.INSTANCE;
          paramString = ShareUpdateContentBuilder.ContentBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label521;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ShareUpdateContentBuilder.ContentBuilder.INSTANCE;
          paramString = ShareUpdateContentBuilder.ContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (paramString == null) {
            break label527;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label533;
      }
      bool6 = true;
      if (bool6) {
        localShareAudience = ShareAudience.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject5));
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label539;
      }
      bool7 = true;
      label378:
      if (!bool7) {
        break label557;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject5);
      localObject8 = new ArrayList();
      label402:
      localObject1 = localObject8;
      if (j <= 0) {
        break label557;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject5).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject5);
        UpdateActionBuilder localUpdateActionBuilder = UpdateActionBuilder.INSTANCE;
        localObject1 = UpdateActionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label545;
        }
        i = 1;
      }
      label462:
      if (k == 1)
      {
        localObject1 = UpdateActionBuilder.INSTANCE;
        localObject1 = UpdateActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label551;
        }
      }
    }
    label521:
    label527:
    label533:
    label539:
    label545:
    label551:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject8).add(localObject1);
      }
      j -= 1;
      break label402;
      bool2 = false;
      break;
      bool1 = false;
      break label310;
      bool1 = false;
      break label336;
      bool6 = false;
      break label348;
      bool7 = false;
      break label378;
      i = 0;
      break label462;
    }
    label557:
    boolean bool8;
    boolean bool3;
    label604:
    label666:
    label695:
    boolean bool9;
    label707:
    boolean bool10;
    label731:
    boolean bool4;
    label758:
    label820:
    label849:
    boolean bool5;
    label861:
    label923:
    label952:
    boolean bool11;
    if (((ByteBuffer)localObject5).get() == 1)
    {
      bool8 = true;
      if (bool8)
      {
        localObject6 = UrnCoercer.INSTANCE;
        localObject6 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject5));
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1064;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject2 = localSocialActorBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localSocialActorBuilder = SocialActorBuilder.INSTANCE;
          localObject2 = SocialActorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1070;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject2 = SocialActorBuilder.INSTANCE;
          localObject2 = SocialActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1076;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1082;
      }
      bool9 = true;
      if (bool9) {
        l = ((ByteBuffer)localObject5).getLong();
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1088;
      }
      bool10 = true;
      if (bool10) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject5);
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1094;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject3 = localTrackingDataBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localTrackingDataBuilder = TrackingDataBuilder.INSTANCE;
          localObject3 = TrackingDataBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1100;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject3 = TrackingDataBuilder.INSTANCE;
          localObject3 = TrackingDataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1106;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1112;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject4 = localAttributedTextBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          localObject4 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1118;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject4 = AttributedTextBuilder.INSTANCE;
          localObject4 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1124;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1130;
      }
      bool11 = true;
      label964:
      bool5 = bool12;
      if (bool11)
      {
        if (((ByteBuffer)localObject5).get() != 1) {
          break label1136;
        }
        bool5 = true;
      }
      label985:
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1142;
      }
    }
    label1064:
    label1070:
    label1076:
    label1082:
    label1088:
    label1094:
    label1100:
    label1106:
    label1112:
    label1118:
    label1124:
    label1130:
    label1136:
    label1142:
    for (bool12 = true;; bool12 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject7;
      if (bool12)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject5));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject5);
      }
      if (!bool7) {
        localObject1 = Collections.emptyList();
      }
      if (bool1) {
        break label1148;
      }
      throw new IOException("Failed to find required field: content when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate from fission.");
      bool8 = false;
      break;
      bool3 = false;
      break label604;
      bool2 = false;
      break label666;
      bool2 = false;
      break label695;
      bool9 = false;
      break label707;
      bool10 = false;
      break label731;
      bool4 = false;
      break label758;
      bool3 = false;
      break label820;
      bool3 = false;
      break label849;
      bool5 = false;
      break label861;
      bool4 = false;
      break label923;
      bool4 = false;
      break label952;
      bool11 = false;
      break label964;
      bool5 = false;
      break label985;
    }
    label1148:
    if (!bool6) {
      throw new IOException("Failed to find required field: shareAudience when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: actor when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate from fission.");
    }
    if (!bool9) {
      throw new IOException("Failed to find required field: createdTime when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate from fission.");
    }
    return new ShareUpdate(paramString, localShareAudience, (List)localObject1, (Urn)localObject6, (SocialActor)localObject2, l, str, (TrackingData)localObject3, (AttributedText)localObject4, bool5, paramFissionTransaction, bool1, bool6, bool7, bool8, bool2, bool9, bool10, bool3, bool4, bool11, bool12);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */