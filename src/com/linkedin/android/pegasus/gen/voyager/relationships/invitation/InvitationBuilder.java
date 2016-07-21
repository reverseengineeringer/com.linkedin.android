package com.linkedin.android.pegasus.gen.voyager.relationships.invitation;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class InvitationBuilder
  implements FissileDataModelBuilder<Invitation>, DataTemplateBuilder<Invitation>
{
  public static final InvitationBuilder INSTANCE = new InvitationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("toMemberId");
    JSON_KEY_STORE.put("message");
    JSON_KEY_STORE.put("entityUrn");
    JSON_KEY_STORE.put("sharedSecret");
    JSON_KEY_STORE.put("fromMemberId");
    JSON_KEY_STORE.put("fromMember");
    JSON_KEY_STORE.put("toMember");
    JSON_KEY_STORE.put("invitee");
    JSON_KEY_STORE.put("sentTime");
    JSON_KEY_STORE.put("invitationType");
    JSON_KEY_STORE.put("customMessage");
    JSON_KEY_STORE.put("mailboxItemId");
  }
  
  public static Invitation build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str5 = null;
    String str4 = null;
    Object localObject4 = null;
    String str3 = null;
    String str2 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    long l = 0L;
    InvitationType localInvitationType = null;
    boolean bool13 = false;
    String str1 = null;
    boolean bool12 = false;
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
      if (paramDataReader.shouldReadField$11ca93e7("toMemberId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("message", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("sharedSecret", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("fromMemberId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("fromMember", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = MiniProfileBuilder.INSTANCE;
        localObject3 = MiniProfileBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("toMember", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MiniProfileBuilder.INSTANCE;
        localObject2 = MiniProfileBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("invitee", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = InviteeBuilder.INSTANCE;
        localObject1 = InviteeBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("sentTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("invitationType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localInvitationType = (InvitationType)paramDataReader.readEnum(InvitationType.Builder.INSTANCE);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("customMessage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool13 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("mailboxItemId", JSON_KEY_STORE))
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
    if (!bool12) {
      throw new DataReaderException("Failed to find required field: toMemberId when building com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation");
    }
    if (!bool10) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation");
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: sharedSecret when building com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: customMessage when building com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation");
    }
    return new Invitation(str5, str4, (Urn)localObject4, str3, str2, (MiniProfile)localObject3, (MiniProfile)localObject2, (Invitation.Invitee)localObject1, l, localInvitationType, bool13, str1, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool2, bool3, bool1);
  }
  
  public static Invitation readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Invitation");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Invitation");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Invitation");
    }
    if (((ByteBuffer)localObject3).getInt() != 1351128300)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building Invitation");
    }
    String str1 = null;
    String str2 = null;
    Object localObject4 = null;
    String str3 = null;
    String str4 = null;
    paramString = null;
    MiniProfileBuilder localMiniProfileBuilder2 = null;
    localObject1 = null;
    MiniProfileBuilder localMiniProfileBuilder1 = null;
    Object localObject2 = null;
    InviteeBuilder localInviteeBuilder = null;
    long l = 0L;
    Object localObject5 = null;
    boolean bool13 = false;
    String str5 = null;
    boolean bool5;
    boolean bool6;
    label280:
    boolean bool7;
    label307:
    boolean bool8;
    label342:
    boolean bool9;
    label369:
    boolean bool2;
    label396:
    boolean bool1;
    label453:
    label479:
    boolean bool3;
    label491:
    label553:
    label582:
    boolean bool4;
    label594:
    label656:
    label685:
    boolean bool10;
    label697:
    boolean bool11;
    label721:
    boolean bool12;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool5 = true;
      if (bool5) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label834;
      }
      bool6 = true;
      if (bool6) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label840;
      }
      bool7 = true;
      if (bool7)
      {
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label846;
      }
      bool8 = true;
      if (bool8) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label852;
      }
      bool9 = true;
      if (bool9) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label858;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = localMiniProfileBuilder2;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localMiniProfileBuilder2 = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label864;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label870;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label876;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localMiniProfileBuilder1;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localMiniProfileBuilder1 = MiniProfileBuilder.INSTANCE;
          localObject1 = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label882;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = MiniProfileBuilder.INSTANCE;
          localObject1 = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label888;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label894;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localInviteeBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localInviteeBuilder = InviteeBuilder.INSTANCE;
          localObject2 = InviteeBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label900;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = InviteeBuilder.INSTANCE;
          localObject2 = InviteeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label906;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label912;
      }
      bool10 = true;
      if (bool10) {
        l = ((ByteBuffer)localObject3).getLong();
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label918;
      }
      bool11 = true;
      paramFissionTransaction = (FissionTransaction)localObject5;
      if (bool11) {
        paramFissionTransaction = InvitationType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label924;
      }
      bool12 = true;
      label753:
      bool4 = bool13;
      if (bool12)
      {
        if (((ByteBuffer)localObject3).get() != 1) {
          break label930;
        }
        bool4 = true;
      }
      label774:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label936;
      }
    }
    label834:
    label840:
    label846:
    label852:
    label858:
    label864:
    label870:
    label876:
    label882:
    label888:
    label894:
    label900:
    label906:
    label912:
    label918:
    label924:
    label930:
    label936:
    for (bool13 = true;; bool13 = false)
    {
      if (bool13) {
        str5 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (bool5) {
        break label942;
      }
      throw new IOException("Failed to find required field: toMemberId when reading com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation from fission.");
      bool5 = false;
      break;
      bool6 = false;
      break label280;
      bool7 = false;
      break label307;
      bool8 = false;
      break label342;
      bool9 = false;
      break label369;
      bool2 = false;
      break label396;
      bool1 = false;
      break label453;
      bool1 = false;
      break label479;
      bool3 = false;
      break label491;
      bool2 = false;
      break label553;
      bool2 = false;
      break label582;
      bool4 = false;
      break label594;
      bool3 = false;
      break label656;
      bool3 = false;
      break label685;
      bool10 = false;
      break label697;
      bool11 = false;
      break label721;
      bool12 = false;
      break label753;
      bool4 = false;
      break label774;
    }
    label942:
    if (!bool7) {
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation from fission.");
    }
    if (!bool8) {
      throw new IOException("Failed to find required field: sharedSecret when reading com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation from fission.");
    }
    if (!bool12) {
      throw new IOException("Failed to find required field: customMessage when reading com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation from fission.");
    }
    return new Invitation(str1, str2, (Urn)localObject4, str3, str4, paramString, (MiniProfile)localObject1, (Invitation.Invitee)localObject2, l, paramFissionTransaction, bool4, str5, bool5, bool6, bool7, bool8, bool9, bool1, bool2, bool3, bool10, bool11, bool12, bool13);
  }
  
  public static final class InviteeBuilder
    implements FissileDataModelBuilder<Invitation.Invitee>, DataTemplateBuilder<Invitation.Invitee>
  {
    public static final InviteeBuilder INSTANCE = new InviteeBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.relationships.invitation.ProfileInvitee");
      JSON_KEY_STORE.put("com.linkedin.voyager.relationships.invitation.EmailInvitee");
      JSON_KEY_STORE.put("com.linkedin.voyager.relationships.invitation.PhoneInvitee");
    }
    
    public static Invitation.Invitee build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject3 = null;
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool3 = false;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.relationships.invitation.ProfileInvitee", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = ProfileInviteeBuilder.INSTANCE;
          localObject3 = ProfileInviteeBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.relationships.invitation.EmailInvitee", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = EmailInviteeBuilder.INSTANCE;
          localObject2 = EmailInviteeBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.relationships.invitation.PhoneInvitee", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = PhoneInviteeBuilder.INSTANCE;
          localObject1 = PhoneInviteeBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int i = 0;
      if (bool3) {
        i = 1;
      }
      int j = i;
      if (bool2)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Invitee");
        }
        j = 1;
      }
      if ((bool1) && (j != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Invitee");
      }
      return new Invitation.Invitee((ProfileInvitee)localObject3, (EmailInvitee)localObject2, (PhoneInvitee)localObject1, bool3, bool2, bool1);
    }
    
    public static Invitation.Invitee readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building Invitation.Invitee");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building Invitation.Invitee");
      }
      Object localObject3 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building Invitation.Invitee");
      }
      if (((ByteBuffer)localObject3).getInt() != 998487244)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
        throw new IOException("UID mismatch. Can't read cached data when building Invitation.Invitee");
      }
      paramString = null;
      ProfileInviteeBuilder localProfileInviteeBuilder = null;
      localObject1 = null;
      EmailInviteeBuilder localEmailInviteeBuilder = null;
      Object localObject2 = null;
      PhoneInviteeBuilder localPhoneInviteeBuilder = null;
      boolean bool2;
      boolean bool1;
      label283:
      label309:
      boolean bool3;
      if (((ByteBuffer)localObject3).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject3).get();
          paramString = localProfileInviteeBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
            localProfileInviteeBuilder = ProfileInviteeBuilder.INSTANCE;
            paramString = ProfileInviteeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label568;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = ProfileInviteeBuilder.INSTANCE;
            paramString = ProfileInviteeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
            if (paramString == null) {
              break label574;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject3).get() != 1) {
          break label580;
        }
        bool3 = true;
        label321:
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject3).get();
          localObject1 = localEmailInviteeBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
            localEmailInviteeBuilder = EmailInviteeBuilder.INSTANCE;
            localObject1 = EmailInviteeBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label586;
            }
            bool2 = true;
          }
          label383:
          if (i == 1)
          {
            localObject1 = EmailInviteeBuilder.INSTANCE;
            localObject1 = EmailInviteeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label592;
            }
            bool2 = true;
          }
        }
        label412:
        if (((ByteBuffer)localObject3).get() != 1) {
          break label598;
        }
        bool3 = true;
        label424:
        bool4 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject3).get();
          localObject2 = localPhoneInviteeBuilder;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
            localPhoneInviteeBuilder = PhoneInviteeBuilder.INSTANCE;
            localObject2 = PhoneInviteeBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label604;
            }
            bool3 = true;
          }
          label482:
          bool4 = bool3;
          if (i == 1)
          {
            localObject2 = PhoneInviteeBuilder.INSTANCE;
            localObject2 = PhoneInviteeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label610;
            }
          }
        }
      }
      label568:
      label574:
      label580:
      label586:
      label592:
      label598:
      label604:
      label610:
      for (boolean bool4 = true;; bool4 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject3);
        }
        i = 0;
        if (bool1) {
          i = 1;
        }
        j = i;
        if (!bool2) {
          break label619;
        }
        if (i == 0) {
          break label616;
        }
        throw new IOException("Found more than 1 member when reading .Invitee from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label283;
        bool1 = false;
        break label309;
        bool3 = false;
        break label321;
        bool2 = false;
        break label383;
        bool2 = false;
        break label412;
        bool3 = false;
        break label424;
        bool3 = false;
        break label482;
      }
      label616:
      int j = 1;
      label619:
      if ((bool4) && (j != 0)) {
        throw new IOException("Found more than 1 member when reading .Invitee from fission.");
      }
      return new Invitation.Invitee(paramString, (EmailInvitee)localObject1, (PhoneInvitee)localObject2, bool1, bool2, bool4);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */