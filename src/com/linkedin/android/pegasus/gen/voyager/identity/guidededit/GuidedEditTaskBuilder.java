package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

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

public final class GuidedEditTaskBuilder
  implements FissileDataModelBuilder<GuidedEditTask>, DataTemplateBuilder<GuidedEditTask>
{
  public static final GuidedEditTaskBuilder INSTANCE = new GuidedEditTaskBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("legoTrackingId");
    JSON_KEY_STORE.put("required");
    JSON_KEY_STORE.put("counted");
    JSON_KEY_STORE.put("taskName");
    JSON_KEY_STORE.put("taskInfo");
  }
  
  public static GuidedEditTask build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    boolean bool7 = false;
    boolean bool6 = false;
    TaskNames localTaskNames = null;
    Object localObject = null;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("legoTrackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("required", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool7 = paramDataReader.readBoolean();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("counted", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool6 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("taskName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localTaskNames = (TaskNames)paramDataReader.readEnum(TaskNames.Builder.INSTANCE);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("taskInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = TaskInfoBuilder.INSTANCE;
        localObject = TaskInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: legoTrackingId when building com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: required when building com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: counted when building com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: taskInfo when building com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask");
    }
    return new GuidedEditTask(str, bool7, bool6, localTaskNames, (GuidedEditTask.TaskInfo)localObject, bool4, bool5, bool3, bool2, bool1);
  }
  
  public static GuidedEditTask readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building GuidedEditTask");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building GuidedEditTask");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building GuidedEditTask");
    }
    if (((ByteBuffer)localObject1).getInt() != -1004849691)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building GuidedEditTask");
    }
    localObject2 = null;
    boolean bool3 = false;
    boolean bool4 = false;
    TaskNames localTaskNames = null;
    paramString = null;
    TaskInfoBuilder localTaskInfoBuilder = null;
    boolean bool5;
    boolean bool6;
    label253:
    label270:
    boolean bool7;
    label282:
    label299:
    boolean bool8;
    label311:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool5 = true;
      if (bool5) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label457;
      }
      bool6 = true;
      if (bool6)
      {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label463;
        }
        bool3 = true;
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label469;
      }
      bool7 = true;
      if (bool7)
      {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label475;
        }
        bool4 = true;
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label481;
      }
      bool8 = true;
      if (bool8) {
        localTaskNames = TaskNames.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label487;
      }
      bool1 = true;
      label341:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localTaskInfoBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localTaskInfoBuilder = TaskInfoBuilder.INSTANCE;
          paramString = TaskInfoBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label493;
          }
          bool1 = true;
        }
        label394:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = TaskInfoBuilder.INSTANCE;
          paramString = TaskInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label499;
          }
        }
      }
    }
    label457:
    label463:
    label469:
    label475:
    label481:
    label487:
    label493:
    label499:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool5) {
        break label505;
      }
      throw new IOException("Failed to find required field: legoTrackingId when reading com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask from fission.");
      bool5 = false;
      break;
      bool6 = false;
      break label253;
      bool3 = false;
      break label270;
      bool7 = false;
      break label282;
      bool4 = false;
      break label299;
      bool8 = false;
      break label311;
      bool1 = false;
      break label341;
      bool1 = false;
      break label394;
    }
    label505:
    if (!bool6) {
      throw new IOException("Failed to find required field: required when reading com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: counted when reading com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: taskInfo when reading com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask from fission.");
    }
    return new GuidedEditTask((String)localObject2, bool3, bool4, localTaskNames, paramString, bool5, bool6, bool7, bool8, bool2);
  }
  
  public static final class TaskInfoBuilder
    implements FissileDataModelBuilder<GuidedEditTask.TaskInfo>, DataTemplateBuilder<GuidedEditTask.TaskInfo>
  {
    public static final TaskInfoBuilder INSTANCE = new TaskInfoBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.guidededit.ProfileEditTaskInfo");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.guidededit.SimpleTaskInfo");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.guidededit.CustomTaskInfo");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.guidededit.SuggestedEditTaskInfo");
    }
    
    public static GuidedEditTask.TaskInfo build(DataReader paramDataReader)
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
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.guidededit.ProfileEditTaskInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = ProfileEditTaskInfoBuilder.INSTANCE;
          localObject4 = ProfileEditTaskInfoBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.guidededit.SimpleTaskInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = SimpleTaskInfoBuilder.INSTANCE;
          localObject3 = SimpleTaskInfoBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.guidededit.CustomTaskInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = CustomTaskInfoBuilder.INSTANCE;
          localObject2 = CustomTaskInfoBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.guidededit.SuggestedEditTaskInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = SuggestedEditTaskInfoBuilder.INSTANCE;
          localObject1 = SuggestedEditTaskInfoBuilder.build(paramDataReader);
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
          throw new DataReaderException("Found more than 1 member when building .TaskInfo");
        }
        i = 1;
      }
      j = i;
      if (bool2)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .TaskInfo");
        }
        j = 1;
      }
      if ((bool1) && (j != 0)) {
        throw new DataReaderException("Found more than 1 member when building .TaskInfo");
      }
      return new GuidedEditTask.TaskInfo((ProfileEditTaskInfo)localObject4, (SimpleTaskInfo)localObject3, (CustomTaskInfo)localObject2, (SuggestedEditTaskInfo)localObject1, bool4, bool3, bool2, bool1);
    }
    
    public static GuidedEditTask.TaskInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building GuidedEditTask.TaskInfo");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building GuidedEditTask.TaskInfo");
      }
      Object localObject4 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building GuidedEditTask.TaskInfo");
      }
      if (((ByteBuffer)localObject4).getInt() != -1755834724)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
        throw new IOException("UID mismatch. Can't read cached data when building GuidedEditTask.TaskInfo");
      }
      paramString = null;
      ProfileEditTaskInfoBuilder localProfileEditTaskInfoBuilder = null;
      localObject1 = null;
      SimpleTaskInfoBuilder localSimpleTaskInfoBuilder = null;
      Object localObject2 = null;
      CustomTaskInfoBuilder localCustomTaskInfoBuilder = null;
      Object localObject3 = null;
      SuggestedEditTaskInfoBuilder localSuggestedEditTaskInfoBuilder = null;
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
          paramString = localProfileEditTaskInfoBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localProfileEditTaskInfoBuilder = ProfileEditTaskInfoBuilder.INSTANCE;
            paramString = ProfileEditTaskInfoBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label677;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = ProfileEditTaskInfoBuilder.INSTANCE;
            paramString = ProfileEditTaskInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
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
          localObject1 = localSimpleTaskInfoBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localSimpleTaskInfoBuilder = SimpleTaskInfoBuilder.INSTANCE;
            localObject1 = SimpleTaskInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label695;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = SimpleTaskInfoBuilder.INSTANCE;
            localObject1 = SimpleTaskInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
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
          localObject2 = localCustomTaskInfoBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localCustomTaskInfoBuilder = CustomTaskInfoBuilder.INSTANCE;
            localObject2 = CustomTaskInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label713;
            }
            bool3 = true;
          }
          label492:
          if (i == 1)
          {
            localObject2 = CustomTaskInfoBuilder.INSTANCE;
            localObject2 = CustomTaskInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
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
          localObject3 = localSuggestedEditTaskInfoBuilder;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localSuggestedEditTaskInfoBuilder = SuggestedEditTaskInfoBuilder.INSTANCE;
            localObject3 = SuggestedEditTaskInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label731;
            }
            bool4 = true;
          }
          label591:
          bool5 = bool4;
          if (i == 1)
          {
            localObject3 = SuggestedEditTaskInfoBuilder.INSTANCE;
            localObject3 = SuggestedEditTaskInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
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
        throw new IOException("Found more than 1 member when reading .TaskInfo from fission.");
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
          throw new IOException("Found more than 1 member when reading .TaskInfo from fission.");
        }
        j = 1;
      }
      if ((bool5) && (j != 0)) {
        throw new IOException("Found more than 1 member when reading .TaskInfo from fission.");
      }
      return new GuidedEditTask.TaskInfo(paramString, (SimpleTaskInfo)localObject1, (CustomTaskInfo)localObject2, (SuggestedEditTaskInfo)localObject3, bool1, bool2, bool3, bool5);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTaskBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */