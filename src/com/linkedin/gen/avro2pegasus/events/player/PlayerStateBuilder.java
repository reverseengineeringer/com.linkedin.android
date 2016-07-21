package com.linkedin.gen.avro2pegasus.events.player;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PlayerStateBuilder
  implements DataTemplateBuilder<PlayerState>
{
  public static final PlayerStateBuilder INSTANCE = new PlayerStateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("mediaUrn");
    JSON_KEY_STORE.put("length");
    JSON_KEY_STORE.put("mediaViewTrackingId");
    JSON_KEY_STORE.put("volume");
    JSON_KEY_STORE.put("timeElapsed");
    JSON_KEY_STORE.put("isPlaying");
    JSON_KEY_STORE.put("ccVisible");
    JSON_KEY_STORE.put("fullScreen");
    JSON_KEY_STORE.put("downloaded");
    JSON_KEY_STORE.put("networkType");
    JSON_KEY_STORE.put("speed");
    JSON_KEY_STORE.put("casting");
    JSON_KEY_STORE.put("bitrate");
  }
  
  public static PlayerState build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    int m = 0;
    String str1 = null;
    int k = 0;
    int j = 0;
    boolean bool14 = false;
    PlayerFeatureFlag localPlayerFeatureFlag4 = null;
    PlayerFeatureFlag localPlayerFeatureFlag3 = null;
    PlayerFeatureFlag localPlayerFeatureFlag2 = null;
    NetworkState localNetworkState = null;
    float f = 0.0F;
    PlayerFeatureFlag localPlayerFeatureFlag1 = null;
    int i = 0;
    boolean bool13 = false;
    boolean bool12 = false;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool8 = false;
    boolean bool9 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("mediaUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("length", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        m = paramDataReader.readInt();
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("mediaViewTrackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("volume", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        k = paramDataReader.readInt();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("timeElapsed", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("isPlaying", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool14 = paramDataReader.readBoolean();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("ccVisible", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localPlayerFeatureFlag4 = (PlayerFeatureFlag)paramDataReader.readEnum(PlayerFeatureFlag.Builder.INSTANCE);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("fullScreen", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localPlayerFeatureFlag3 = (PlayerFeatureFlag)paramDataReader.readEnum(PlayerFeatureFlag.Builder.INSTANCE);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("downloaded", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localPlayerFeatureFlag2 = (PlayerFeatureFlag)paramDataReader.readEnum(PlayerFeatureFlag.Builder.INSTANCE);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("networkType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localNetworkState = (NetworkState)paramDataReader.readEnum(NetworkState.Builder.INSTANCE);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("speed", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        f = paramDataReader.readFloat();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("casting", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localPlayerFeatureFlag1 = (PlayerFeatureFlag)paramDataReader.readEnum(PlayerFeatureFlag.Builder.INSTANCE);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("bitrate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool7) {
      localPlayerFeatureFlag4 = PlayerFeatureFlag.NOT_MEASURED;
    }
    if (!bool6) {
      localPlayerFeatureFlag3 = PlayerFeatureFlag.NOT_MEASURED;
    }
    if (!bool5) {
      localPlayerFeatureFlag2 = PlayerFeatureFlag.NOT_MEASURED;
    }
    if (!bool4) {
      localNetworkState = NetworkState.UNKNOWN;
    }
    if (!bool2) {
      localPlayerFeatureFlag1 = PlayerFeatureFlag.NOT_MEASURED;
    }
    if (!bool13) {
      throw new DataReaderException("Failed to find required field: mediaUrn when building com.linkedin.gen.avro2pegasus.events.player.PlayerState");
    }
    if (!bool12) {
      throw new DataReaderException("Failed to find required field: length when building com.linkedin.gen.avro2pegasus.events.player.PlayerState");
    }
    if (!bool11) {
      throw new DataReaderException("Failed to find required field: mediaViewTrackingId when building com.linkedin.gen.avro2pegasus.events.player.PlayerState");
    }
    if (!bool10) {
      throw new DataReaderException("Failed to find required field: volume when building com.linkedin.gen.avro2pegasus.events.player.PlayerState");
    }
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: timeElapsed when building com.linkedin.gen.avro2pegasus.events.player.PlayerState");
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: isPlaying when building com.linkedin.gen.avro2pegasus.events.player.PlayerState");
    }
    return new PlayerState(str2, m, str1, k, j, bool14, localPlayerFeatureFlag4, localPlayerFeatureFlag3, localPlayerFeatureFlag2, localNetworkState, f, localPlayerFeatureFlag1, i, bool13, bool12, bool11, bool10, bool8, bool9, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.player.PlayerStateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */