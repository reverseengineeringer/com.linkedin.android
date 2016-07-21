package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.common.PhoneNumberBuilder;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.growth.socialProof.MemberSocialProofBuilder;
import com.linkedin.data.lite.BytesCoercer;
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

public final class GenericPromoUpdateBuilder
  implements FissileDataModelBuilder<GenericPromoUpdate>, DataTemplateBuilder<GenericPromoUpdate>
{
  public static final GenericPromoUpdateBuilder INSTANCE = new GenericPromoUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("mainText");
    JSON_KEY_STORE.put("type");
    JSON_KEY_STORE.put("formInputValue");
    JSON_KEY_STORE.put("actions");
    JSON_KEY_STORE.put("socialProofArray");
    JSON_KEY_STORE.put("legoTrackingId");
  }
  
  public static GenericPromoUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject5 = null;
    Object localObject4 = null;
    PromoType localPromoType = null;
    Object localObject3 = null;
    ArrayList localArrayList = null;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("header", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = AttributedTextBuilder.INSTANCE;
        localObject5 = AttributedTextBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("mainText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = AttributedTextBuilder.INSTANCE;
        localObject4 = AttributedTextBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localPromoType = (PromoType)paramDataReader.readEnum(PromoType.Builder.INSTANCE);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("formInputValue", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = FormInputValueBuilder.INSTANCE;
        localObject3 = FormInputValueBuilder.build(paramDataReader);
        bool4 = true;
      }
      else
      {
        Object localObject6;
        if (paramDataReader.shouldReadField$11ca93e7("actions", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayList = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject6 = PromoActionBuilder.INSTANCE;
              localArrayList.add(PromoActionBuilder.build(paramDataReader));
            }
          }
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("socialProofArray", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject6 = MemberSocialProofBuilder.INSTANCE;
              ((List)localObject1).add(MemberSocialProofBuilder.build(paramDataReader));
            }
          }
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("legoTrackingId", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = BytesCoercer.INSTANCE;
          localObject2 = BytesCoercer.coerceToCustomType(paramDataReader.readBytes());
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: header when building com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: type when building com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: actions when building com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: legoTrackingId when building com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate");
    }
    return new GenericPromoUpdate((AttributedText)localObject5, (AttributedText)localObject4, localPromoType, (GenericPromoUpdate.FormInputValue)localObject3, localArrayList, (List)localObject1, (String)localObject2, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static GenericPromoUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building GenericPromoUpdate");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building GenericPromoUpdate");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building GenericPromoUpdate");
    }
    if (((ByteBuffer)localObject4).getInt() != 194095927)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building GenericPromoUpdate");
    }
    paramString = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    localObject1 = null;
    Object localObject7 = null;
    PromoType localPromoType = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject5 = null;
    ArrayList localArrayList = null;
    Object localObject6 = null;
    boolean bool2;
    boolean bool1;
    label295:
    label321:
    boolean bool3;
    label333:
    label395:
    label424:
    boolean bool5;
    label436:
    boolean bool4;
    label466:
    label528:
    label557:
    label569:
    label593:
    int k;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject4).get();
        paramString = localAttributedTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label712;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (paramString == null) {
            break label718;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label724;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject1 = localObject7;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localObject7 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label730;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label736;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label742;
      }
      bool5 = true;
      if (bool5) {
        localPromoType = PromoType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4));
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label748;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject2 = localObject3;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localObject3 = FormInputValueBuilder.INSTANCE;
          localObject2 = FormInputValueBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label754;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = FormInputValueBuilder.INSTANCE;
          localObject2 = FormInputValueBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label760;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label766;
      }
      bool4 = true;
      if (!bool4) {
        break label784;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4);
      localObject7 = new ArrayList();
      localObject5 = localObject7;
      if (j <= 0) {
        break label784;
      }
      localObject3 = null;
      i = 1;
      k = ((ByteBuffer)localObject4).get();
      if (k == 0)
      {
        localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
        localObject5 = PromoActionBuilder.INSTANCE;
        localObject3 = PromoActionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
        if (localObject3 == null) {
          break label772;
        }
        i = 1;
      }
      label653:
      if (k == 1)
      {
        localObject3 = PromoActionBuilder.INSTANCE;
        localObject3 = PromoActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
        if (localObject3 == null) {
          break label778;
        }
      }
    }
    label712:
    label718:
    label724:
    label730:
    label736:
    label742:
    label748:
    label754:
    label760:
    label766:
    label772:
    label778:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject7).add(localObject3);
      }
      j -= 1;
      break label593;
      bool2 = false;
      break;
      bool1 = false;
      break label295;
      bool1 = false;
      break label321;
      bool3 = false;
      break label333;
      bool2 = false;
      break label395;
      bool2 = false;
      break label424;
      bool5 = false;
      break label436;
      bool4 = false;
      break label466;
      bool3 = false;
      break label528;
      bool3 = false;
      break label557;
      bool4 = false;
      break label569;
      i = 0;
      break label653;
    }
    label784:
    boolean bool6;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool6 = true;
      localObject3 = localArrayList;
      if (!bool6) {
        break label955;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4);
      localArrayList = new ArrayList();
      label824:
      localObject3 = localArrayList;
      if (j <= 0) {
        break label955;
      }
      localObject3 = null;
      i = 1;
      k = ((ByteBuffer)localObject4).get();
      if (k == 0)
      {
        localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
        localObject7 = MemberSocialProofBuilder.INSTANCE;
        localObject3 = MemberSocialProofBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
        if (localObject3 == null) {
          break label943;
        }
        i = 1;
      }
      label884:
      if (k == 1)
      {
        localObject3 = MemberSocialProofBuilder.INSTANCE;
        localObject3 = MemberSocialProofBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
        if (localObject3 == null) {
          break label949;
        }
      }
    }
    label943:
    label949:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(localObject3);
      }
      j -= 1;
      break label824;
      bool6 = false;
      break;
      i = 0;
      break label884;
    }
    label955:
    if (((ByteBuffer)localObject4).get() == 1) {}
    for (boolean bool7 = true;; bool7 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject6;
      if (bool7)
      {
        paramFissionTransaction = new byte[((ByteBuffer)localObject4).getInt()];
        ((ByteBuffer)localObject4).get(paramFissionTransaction);
        paramFissionTransaction = new String(paramFissionTransaction);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (!bool6) {
        localObject3 = Collections.emptyList();
      }
      if (bool1) {
        break;
      }
      throw new IOException("Failed to find required field: header when reading com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: type when reading com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: actions when reading com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: legoTrackingId when reading com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate from fission.");
    }
    return new GenericPromoUpdate(paramString, (AttributedText)localObject1, localPromoType, (GenericPromoUpdate.FormInputValue)localObject2, (List)localObject5, (List)localObject3, paramFissionTransaction, bool1, bool2, bool5, bool3, bool4, bool6, bool7);
  }
  
  public static final class FormInputValueBuilder
    implements FissileDataModelBuilder<GenericPromoUpdate.FormInputValue>, DataTemplateBuilder<GenericPromoUpdate.FormInputValue>
  {
    public static final FormInputValueBuilder INSTANCE = new FormInputValueBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("string");
      JSON_KEY_STORE.put("com.linkedin.common.PhoneNumber");
    }
    
    public static GenericPromoUpdate.FormInputValue build(DataReader paramDataReader)
      throws DataReaderException
    {
      String str = null;
      Object localObject = null;
      boolean bool1 = false;
      boolean bool2 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("string", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          str = paramDataReader.readString();
          bool1 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.common.PhoneNumber", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject = PhoneNumberBuilder.INSTANCE;
          localObject = PhoneNumberBuilder.build(paramDataReader);
          bool2 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int i = 0;
      if (bool1) {
        i = 1;
      }
      if ((bool2) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .FormInputValue");
      }
      return new GenericPromoUpdate.FormInputValue(str, (PhoneNumber)localObject, bool1, bool2);
    }
    
    public static GenericPromoUpdate.FormInputValue readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building GenericPromoUpdate.FormInputValue");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building GenericPromoUpdate.FormInputValue");
      }
      Object localObject1 = localObject2;
      if (((ByteBuffer)localObject2).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("Invalid header prefix. Can't read cached data when building GenericPromoUpdate.FormInputValue");
      }
      if (((ByteBuffer)localObject1).getInt() != 216059969)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("UID mismatch. Can't read cached data when building GenericPromoUpdate.FormInputValue");
      }
      localObject2 = null;
      paramString = null;
      PhoneNumberBuilder localPhoneNumberBuilder = null;
      boolean bool3;
      boolean bool1;
      if (((ByteBuffer)localObject1).get() == 1)
      {
        bool3 = true;
        if (bool3) {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
        }
        if (((ByteBuffer)localObject1).get() != 1) {
          break label376;
        }
        bool1 = true;
        label244:
        bool2 = bool1;
        if (bool1)
        {
          i = ((ByteBuffer)localObject1).get();
          paramString = localPhoneNumberBuilder;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
            localPhoneNumberBuilder = PhoneNumberBuilder.INSTANCE;
            paramString = PhoneNumberBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label382;
            }
            bool1 = true;
          }
          label297:
          bool2 = bool1;
          if (i == 1)
          {
            paramString = PhoneNumberBuilder.INSTANCE;
            paramString = PhoneNumberBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
            if (paramString == null) {
              break label388;
            }
          }
        }
      }
      label376:
      label382:
      label388:
      for (boolean bool2 = true;; bool2 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject1);
        }
        i = 0;
        if (bool3) {
          i = 1;
        }
        if ((!bool2) || (i == 0)) {
          break label394;
        }
        throw new IOException("Found more than 1 member when reading .FormInputValue from fission.");
        bool3 = false;
        break;
        bool1 = false;
        break label244;
        bool1 = false;
        break label297;
      }
      label394:
      return new GenericPromoUpdate.FormInputValue((String)localObject2, paramString, bool3, bool2);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */