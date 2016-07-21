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

public final class ViralUpdateBuilder
  implements FissileDataModelBuilder<ViralUpdate>, DataTemplateBuilder<ViralUpdate>
{
  public static final ViralUpdateBuilder INSTANCE = new ViralUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("actions");
    JSON_KEY_STORE.put("urn");
    JSON_KEY_STORE.put("actor");
    JSON_KEY_STORE.put("originalUpdate");
    JSON_KEY_STORE.put("insight");
    JSON_KEY_STORE.put("header");
    JSON_KEY_STORE.put("viralType");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("tracking");
  }
  
  public static ViralUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject1 = null;
    Object localObject7 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    String str2 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    String str1 = null;
    Object localObject2 = null;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("actions", JSON_KEY_STORE))
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
        localObject7 = UrnCoercer.INSTANCE;
        localObject7 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actor", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = SocialActorBuilder.INSTANCE;
        localObject6 = SocialActorBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("originalUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = UpdateBuilder.INSTANCE;
        localObject5 = UpdateBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("insight", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("header", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = AttributedTextBuilder.INSTANCE;
        localObject4 = AttributedTextBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("viralType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = ViralTypeBuilder.INSTANCE;
        localObject3 = ViralTypeBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("tracking", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = TrackingDataBuilder.INSTANCE;
        localObject2 = TrackingDataBuilder.build(paramDataReader);
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
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: actor when building com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: originalUpdate when building com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: viralType when building com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate");
    }
    return new ViralUpdate((List)localObject1, (Urn)localObject7, (SocialActor)localObject6, (Update)localObject5, str2, (AttributedText)localObject4, (ViralUpdate.ViralType)localObject3, str1, (TrackingData)localObject2, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static ViralUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ViralUpdate");
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
          localObject6 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ViralUpdate");
    }
    Object localObject6 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ViralUpdate");
    }
    if (((ByteBuffer)localObject6).getInt() != 1472920570)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject6);
      throw new IOException("UID mismatch. Can't read cached data when building ViralUpdate");
    }
    paramString = null;
    Object localObject7 = null;
    localObject1 = null;
    SocialActorBuilder localSocialActorBuilder = null;
    Object localObject2 = null;
    UpdateBuilder localUpdateBuilder = null;
    String str1 = null;
    Object localObject3 = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    Object localObject4 = null;
    ViralTypeBuilder localViralTypeBuilder = null;
    String str2 = null;
    Object localObject5 = null;
    TrackingDataBuilder localTrackingDataBuilder = null;
    boolean bool7;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool7 = true;
      if (!bool7) {
        break label395;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject6);
      localArrayList = new ArrayList();
      label274:
      paramString = localArrayList;
      if (j <= 0) {
        break label395;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject6).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject6);
        UpdateActionBuilder localUpdateActionBuilder = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label383;
        }
        i = 1;
      }
      label328:
      if (k == 1)
      {
        paramString = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
        if (paramString == null) {
          break label389;
        }
      }
    }
    label383:
    label389:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label274;
      bool7 = false;
      break;
      i = 0;
      break label328;
    }
    label395:
    boolean bool8;
    boolean bool2;
    label442:
    boolean bool1;
    label504:
    label533:
    boolean bool3;
    label545:
    label607:
    label636:
    boolean bool9;
    label648:
    boolean bool4;
    label675:
    label737:
    label766:
    boolean bool5;
    label778:
    label840:
    label869:
    boolean bool10;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool8 = true;
      if (bool8)
      {
        localObject7 = UrnCoercer.INSTANCE;
        localObject7 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject6));
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1041;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject1 = localSocialActorBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localSocialActorBuilder = SocialActorBuilder.INSTANCE;
          localObject1 = SocialActorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label1047;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          localObject1 = SocialActorBuilder.INSTANCE;
          localObject1 = SocialActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label1053;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1059;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject2 = localUpdateBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localUpdateBuilder = UpdateBuilder.INSTANCE;
          localObject2 = UpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1065;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject2 = UpdateBuilder.INSTANCE;
          localObject2 = UpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1071;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1077;
      }
      bool9 = true;
      if (bool9) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1083;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject3 = localAttributedTextBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          localObject3 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1089;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject3 = AttributedTextBuilder.INSTANCE;
          localObject3 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1095;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1101;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject4 = localViralTypeBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localViralTypeBuilder = ViralTypeBuilder.INSTANCE;
          localObject4 = ViralTypeBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1107;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject4 = ViralTypeBuilder.INSTANCE;
          localObject4 = ViralTypeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1113;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1119;
      }
      bool10 = true;
      label881:
      if (bool10) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1125;
      }
      bool5 = true;
      label908:
      bool6 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject5 = localTrackingDataBuilder;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localTrackingDataBuilder = TrackingDataBuilder.INSTANCE;
          localObject5 = TrackingDataBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label1131;
          }
          bool5 = true;
        }
        label966:
        bool6 = bool5;
        if (i == 1)
        {
          localObject5 = TrackingDataBuilder.INSTANCE;
          localObject5 = TrackingDataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label1137;
          }
        }
      }
    }
    label1041:
    label1047:
    label1053:
    label1059:
    label1065:
    label1071:
    label1077:
    label1083:
    label1089:
    label1095:
    label1101:
    label1107:
    label1113:
    label1119:
    label1125:
    label1131:
    label1137:
    for (boolean bool6 = true;; bool6 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject6);
      }
      if (!bool7) {
        paramString = Collections.emptyList();
      }
      if (bool1) {
        break label1143;
      }
      throw new IOException("Failed to find required field: actor when reading com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate from fission.");
      bool8 = false;
      break;
      bool2 = false;
      break label442;
      bool1 = false;
      break label504;
      bool1 = false;
      break label533;
      bool3 = false;
      break label545;
      bool2 = false;
      break label607;
      bool2 = false;
      break label636;
      bool9 = false;
      break label648;
      bool4 = false;
      break label675;
      bool3 = false;
      break label737;
      bool3 = false;
      break label766;
      bool5 = false;
      break label778;
      bool4 = false;
      break label840;
      bool4 = false;
      break label869;
      bool10 = false;
      break label881;
      bool5 = false;
      break label908;
      bool5 = false;
      break label966;
    }
    label1143:
    if (!bool2) {
      throw new IOException("Failed to find required field: originalUpdate when reading com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: viralType when reading com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate from fission.");
    }
    return new ViralUpdate(paramString, (Urn)localObject7, (SocialActor)localObject1, (Update)localObject2, str1, (AttributedText)localObject3, (ViralUpdate.ViralType)localObject4, str2, (TrackingData)localObject5, bool7, bool8, bool1, bool2, bool9, bool3, bool4, bool10, bool6);
  }
  
  public static final class ViralTypeBuilder
    implements FissileDataModelBuilder<ViralUpdate.ViralType>, DataTemplateBuilder<ViralUpdate.ViralType>
  {
    public static final ViralTypeBuilder INSTANCE = new ViralTypeBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.feed.ViralLikeType");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.ViralCommentType");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.ViralLikeOnCommentType");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.ViralCommentOnCommentType");
    }
    
    public static ViralUpdate.ViralType build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject4 = null;
      Object localObject3 = null;
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ViralLikeType", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = ViralLikeTypeBuilder.INSTANCE;
          localObject4 = ViralLikeTypeBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ViralCommentType", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = ViralCommentTypeBuilder.INSTANCE;
          localObject3 = ViralCommentTypeBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ViralLikeOnCommentType", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = ViralLikeOnCommentTypeBuilder.INSTANCE;
          localObject2 = ViralLikeOnCommentTypeBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ViralCommentOnCommentType", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = ViralCommentOnCommentTypeBuilder.INSTANCE;
          localObject1 = ViralCommentOnCommentTypeBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int j = 0;
      if (bool4) {
        j = 1;
      }
      int i = j;
      if (bool3)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .ViralType");
        }
        i = 1;
      }
      j = i;
      if (bool2)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .ViralType");
        }
        j = 1;
      }
      if ((bool1) && (j != 0)) {
        throw new DataReaderException("Found more than 1 member when building .ViralType");
      }
      return new ViralUpdate.ViralType((ViralLikeType)localObject4, (ViralCommentType)localObject3, (ViralLikeOnCommentType)localObject2, (ViralCommentOnCommentType)localObject1, bool4, bool3, bool2, bool1);
    }
    
    public static ViralUpdate.ViralType readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building ViralUpdate.ViralType");
      }
      Object localObject1 = paramByteBuffer;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building ViralUpdate.ViralType");
      }
      Object localObject4 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building ViralUpdate.ViralType");
      }
      if (((ByteBuffer)localObject4).getInt() != 1982842573)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
        throw new IOException("UID mismatch. Can't read cached data when building ViralUpdate.ViralType");
      }
      paramString = null;
      ViralLikeTypeBuilder localViralLikeTypeBuilder = null;
      localObject1 = null;
      ViralCommentTypeBuilder localViralCommentTypeBuilder = null;
      Object localObject2 = null;
      ViralLikeOnCommentTypeBuilder localViralLikeOnCommentTypeBuilder = null;
      Object localObject3 = null;
      ViralCommentOnCommentTypeBuilder localViralCommentOnCommentTypeBuilder = null;
      boolean bool2;
      boolean bool1;
      label289:
      label315:
      boolean bool3;
      label327:
      label389:
      label418:
      boolean bool4;
      if (((ByteBuffer)localObject4).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject4).get();
          paramString = localViralLikeTypeBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localViralLikeTypeBuilder = ViralLikeTypeBuilder.INSTANCE;
            paramString = ViralLikeTypeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label677;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = ViralLikeTypeBuilder.INSTANCE;
            paramString = ViralLikeTypeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (paramString == null) {
              break label683;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject4).get() != 1) {
          break label689;
        }
        bool3 = true;
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject1 = localViralCommentTypeBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localViralCommentTypeBuilder = ViralCommentTypeBuilder.INSTANCE;
            localObject1 = ViralCommentTypeBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label695;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = ViralCommentTypeBuilder.INSTANCE;
            localObject1 = ViralCommentTypeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label701;
            }
            bool2 = true;
          }
        }
        if (((ByteBuffer)localObject4).get() != 1) {
          break label707;
        }
        bool4 = true;
        label430:
        bool3 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject2 = localViralLikeOnCommentTypeBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localViralLikeOnCommentTypeBuilder = ViralLikeOnCommentTypeBuilder.INSTANCE;
            localObject2 = ViralLikeOnCommentTypeBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label713;
            }
            bool3 = true;
          }
          label492:
          if (i == 1)
          {
            localObject2 = ViralLikeOnCommentTypeBuilder.INSTANCE;
            localObject2 = ViralLikeOnCommentTypeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label719;
            }
            bool3 = true;
          }
        }
        label521:
        if (((ByteBuffer)localObject4).get() != 1) {
          break label725;
        }
        bool4 = true;
        label533:
        bool5 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject3 = localViralCommentOnCommentTypeBuilder;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localViralCommentOnCommentTypeBuilder = ViralCommentOnCommentTypeBuilder.INSTANCE;
            localObject3 = ViralCommentOnCommentTypeBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label731;
            }
            bool4 = true;
          }
          label591:
          bool5 = bool4;
          if (i == 1)
          {
            localObject3 = ViralCommentOnCommentTypeBuilder.INSTANCE;
            localObject3 = ViralCommentOnCommentTypeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject3 == null) {
              break label737;
            }
          }
        }
      }
      label677:
      label683:
      label689:
      label695:
      label701:
      label707:
      label713:
      label719:
      label725:
      label731:
      label737:
      for (boolean bool5 = true;; bool5 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject4);
        }
        j = 0;
        if (bool1) {
          j = 1;
        }
        i = j;
        if (!bool2) {
          break label746;
        }
        if (j == 0) {
          break label743;
        }
        throw new IOException("Found more than 1 member when reading .ViralType from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label289;
        bool1 = false;
        break label315;
        bool3 = false;
        break label327;
        bool2 = false;
        break label389;
        bool2 = false;
        break label418;
        bool4 = false;
        break label430;
        bool3 = false;
        break label492;
        bool3 = false;
        break label521;
        bool4 = false;
        break label533;
        bool4 = false;
        break label591;
      }
      label743:
      int i = 1;
      label746:
      int j = i;
      if (bool3)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .ViralType from fission.");
        }
        j = 1;
      }
      if ((bool5) && (j != 0)) {
        throw new IOException("Found more than 1 member when reading .ViralType from fission.");
      }
      return new ViralUpdate.ViralType(paramString, (ViralCommentType)localObject1, (ViralLikeOnCommentType)localObject2, (ViralCommentOnCommentType)localObject3, bool1, bool2, bool3, bool5);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */