package com.google.android.exoplayer;

import android.media.MediaCodec.CodecException;
import com.google.android.exoplayer.util.Util;

public final class MediaCodecTrackRenderer$DecoderInitializationException
  extends Exception
{
  public final String decoderName;
  public final String diagnosticInfo;
  
  public MediaCodecTrackRenderer$DecoderInitializationException(MediaFormat paramMediaFormat, Throwable paramThrowable, int paramInt)
  {
    super("Decoder init failed: [" + paramInt + "], " + paramMediaFormat, paramThrowable);
    decoderName = null;
    if (paramInt < 0) {}
    for (paramMediaFormat = "neg_";; paramMediaFormat = "")
    {
      diagnosticInfo = ("com.google.android.exoplayer.MediaCodecTrackRenderer_" + paramMediaFormat + Math.abs(paramInt));
      return;
    }
  }
  
  public MediaCodecTrackRenderer$DecoderInitializationException(MediaFormat paramMediaFormat, Throwable paramThrowable, String paramString)
  {
    super("Decoder init failed: " + paramString + ", " + paramMediaFormat, paramThrowable);
    decoderName = paramString;
    paramMediaFormat = (MediaFormat)localObject;
    if (Util.SDK_INT >= 21)
    {
      paramMediaFormat = (MediaFormat)localObject;
      if ((paramThrowable instanceof MediaCodec.CodecException)) {
        paramMediaFormat = ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
      }
    }
    diagnosticInfo = paramMediaFormat;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecTrackRenderer.DecoderInitializationException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */