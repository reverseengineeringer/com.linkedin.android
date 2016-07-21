package com.linkedin.android.pegasus.gen.voyager.identity.me.ctaActions;

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

public final class CtaActionBuilder
  implements FissileDataModelBuilder<CtaAction>, DataTemplateBuilder<CtaAction>
{
  public static final CtaActionBuilder INSTANCE = new CtaActionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("action");
  }
  
  public static CtaAction build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("action", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ActionBuilder.INSTANCE;
        localObject = ActionBuilder.build(paramDataReader);
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool) {
      throw new DataReaderException("Failed to find required field: action when building com.linkedin.android.pegasus.gen.voyager.identity.me.ctaActions.CtaAction");
    }
    return new CtaAction((CtaAction.Action)localObject, bool);
  }
  
  public static CtaAction readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CtaAction");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building CtaAction");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building CtaAction");
    }
    if (((ByteBuffer)localObject1).getInt() != 1079669506)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building CtaAction");
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
          localObject2 = ActionBuilder.INSTANCE;
          paramString = ActionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label330;
          }
          bool1 = true;
        }
        label267:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = ActionBuilder.INSTANCE;
          paramString = ActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label336;
          }
        }
      }
    }
    label330:
    label336:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool2) {
        break label342;
      }
      throw new IOException("Failed to find required field: action when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ctaActions.CtaAction from fission.");
      bool1 = false;
      break;
      bool1 = false;
      break label267;
    }
    label342:
    return new CtaAction(paramString, bool2);
  }
  
  public static final class ActionBuilder
    implements FissileDataModelBuilder<CtaAction.Action>, DataTemplateBuilder<CtaAction.Action>
  {
    public static final ActionBuilder INSTANCE = new ActionBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.me.ctaActions.MessageAction");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.ctaActions.LikeAction");
    }
    
    public static CtaAction.Action build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject1 = null;
      Object localObject2 = null;
      boolean bool1 = false;
      boolean bool2 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.ctaActions.MessageAction", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = MessageActionBuilder.INSTANCE;
          localObject1 = MessageActionBuilder.build(paramDataReader);
          bool1 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.ctaActions.LikeAction", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = LikeActionBuilder.INSTANCE;
          localObject2 = LikeActionBuilder.build(paramDataReader);
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
        throw new DataReaderException("Found more than 1 member when building .Action");
      }
      return new CtaAction.Action((MessageAction)localObject1, (LikeAction)localObject2, bool1, bool2);
    }
    
    public static CtaAction.Action readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building CtaAction.Action");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building CtaAction.Action");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building CtaAction.Action");
      }
      if (((ByteBuffer)localObject2).getInt() != 324469014)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building CtaAction.Action");
      }
      paramString = null;
      MessageActionBuilder localMessageActionBuilder = null;
      localObject1 = null;
      LikeActionBuilder localLikeActionBuilder = null;
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
          paramString = localMessageActionBuilder;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localMessageActionBuilder = MessageActionBuilder.INSTANCE;
            paramString = MessageActionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = MessageActionBuilder.INSTANCE;
            paramString = MessageActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
            if (paramString == null) {
              break label461;
            }
            bool1 = true;
          }
        }
        label303:
        if (((ByteBuffer)localObject2).get() != 1) {
          break label467;
        }
        bool2 = true;
        label315:
        bool3 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject2).get();
          localObject1 = localLikeActionBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localLikeActionBuilder = LikeActionBuilder.INSTANCE;
            localObject1 = LikeActionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = LikeActionBuilder.INSTANCE;
            localObject1 = LikeActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label479;
            }
          }
        }
      }
      label455:
      label461:
      label467:
      label473:
      label479:
      for (boolean bool3 = true;; bool3 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject2);
        }
        i = 0;
        if (bool1) {
          i = 1;
        }
        if ((!bool3) || (i == 0)) {
          break label485;
        }
        throw new IOException("Found more than 1 member when reading .Action from fission.");
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
      label485:
      return new CtaAction.Action(paramString, (LikeAction)localObject1, bool1, bool3);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ctaActions.CtaActionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */