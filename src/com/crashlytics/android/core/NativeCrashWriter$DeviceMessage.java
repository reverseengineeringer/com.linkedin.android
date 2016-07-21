package com.crashlytics.android.core;

import java.io.IOException;

final class NativeCrashWriter$DeviceMessage
  extends NativeCrashWriter.ProtobufMessage
{
  private final float batteryLevel;
  private final int batteryVelocity;
  private final long diskUsed;
  private final int orientation;
  private final boolean proximityOn;
  private final long ramUsed;
  
  public NativeCrashWriter$DeviceMessage(float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong1, long paramLong2)
  {
    super(5, new NativeCrashWriter.ProtobufMessage[0]);
    batteryLevel = paramFloat;
    batteryVelocity = paramInt1;
    proximityOn = paramBoolean;
    orientation = paramInt2;
    ramUsed = paramLong1;
    diskUsed = paramLong2;
  }
  
  public final int getPropertiesSize()
  {
    return CodedOutputStream.computeFloatSize$255e745() + 0 + CodedOutputStream.computeSInt32Size$255f288(batteryVelocity) + CodedOutputStream.computeBoolSize$2563259(3) + CodedOutputStream.computeUInt32Size(4, orientation) + CodedOutputStream.computeUInt64Size(5, ramUsed) + CodedOutputStream.computeUInt64Size(6, diskUsed);
  }
  
  public final void writeProperties(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    paramCodedOutputStream.writeFloat$255e752(batteryLevel);
    paramCodedOutputStream.writeSInt32$255f295(batteryVelocity);
    paramCodedOutputStream.writeBool(3, proximityOn);
    paramCodedOutputStream.writeUInt32(4, orientation);
    paramCodedOutputStream.writeUInt64(5, ramUsed);
    paramCodedOutputStream.writeUInt64(6, diskUsed);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.NativeCrashWriter.DeviceMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */