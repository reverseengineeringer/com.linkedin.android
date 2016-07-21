package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.PositionHolder;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.MpegAudioHeader;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.io.EOFException;
import java.io.IOException;

public final class Mp3Extractor
  implements Extractor
{
  private static final int ID3_TAG = Util.getIntegerCodeForString("ID3");
  private static final int INFO_HEADER = Util.getIntegerCodeForString("Info");
  private static final int VBRI_HEADER = Util.getIntegerCodeForString("VBRI");
  private static final int XING_HEADER = Util.getIntegerCodeForString("Xing");
  private long basisTimeUs;
  private ExtractorOutput extractorOutput;
  private final BufferingInput inputBuffer = new BufferingInput();
  private int sampleBytesRemaining;
  private int samplesRead;
  private final ParsableByteArray scratch = new ParsableByteArray(4);
  private Seeker seeker;
  private final MpegAudioHeader synchronizedHeader = new MpegAudioHeader();
  private int synchronizedHeaderData;
  private TrackOutput trackOutput;
  
  private static long getPosition(ExtractorInput paramExtractorInput, BufferingInput paramBufferingInput)
  {
    return paramExtractorInput.getPosition() - (writePosition - readPosition);
  }
  
  private long synchronizeCatchingEndOfInput(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    for (;;)
    {
      try
      {
        long l1;
        int j;
        if (paramExtractorInput.getPosition() == 0L)
        {
          inputBuffer.reset();
          l1 = getPosition(paramExtractorInput, inputBuffer);
          l2 = l1;
          if (l1 == 0L)
          {
            inputBuffer.read$35bcd88(paramExtractorInput, scratch.data, 3);
            scratch.setPosition(0);
            if (scratch.readUnsignedInt24() == ID3_TAG)
            {
              paramExtractorInput.skipFully(3);
              paramExtractorInput.readFully(scratch.data, 0, 4);
              paramExtractorInput.skipFully((scratch.data[0] & 0x7F) << 21 | (scratch.data[1] & 0x7F) << 14 | (scratch.data[2] & 0x7F) << 7 | scratch.data[3] & 0x7F);
              inputBuffer.reset();
              l2 = getPosition(paramExtractorInput, inputBuffer);
            }
          }
          else
          {
            inputBuffer.mark();
            i = 0;
            j = 0;
            l1 = l2;
            if (l1 - l2 < 131072L) {
              continue;
            }
            throw new ParserException("Searched too many bytes while resynchronizing.");
          }
        }
        else
        {
          inputBuffer.returnToMark();
          continue;
        }
        inputBuffer.returnToMark();
        long l2 = l1;
        continue;
        if (!inputBuffer.readInternal$35bcd8c(paramExtractorInput, scratch.data, 4)) {
          return -1L;
        }
        scratch.setPosition(0);
        int k = scratch.readInt();
        int m;
        if ((i == 0) || ((0xFFFE0C00 & k) == (0xFFFE0C00 & i)))
        {
          m = MpegAudioHeader.getFrameSize(k);
          if (m != -1) {}
        }
        else
        {
          i = 0;
          inputBuffer.returnToMark();
          inputBuffer.skip(paramExtractorInput, 1);
          inputBuffer.mark();
          l1 += 1L;
          j = 0;
          continue;
        }
        if (j == 0)
        {
          MpegAudioHeader.populateHeader(k, synchronizedHeader);
          i = k;
          j += 1;
          if (j != 4)
          {
            inputBuffer.skip(paramExtractorInput, m - 4);
            continue;
          }
          inputBuffer.returnToMark();
          synchronizedHeaderData = i;
          l2 = l1;
          if (seeker == null)
          {
            l2 = paramExtractorInput.getLength();
            inputBuffer.mark();
            seeker = null;
            BufferingInput localBufferingInput = inputBuffer;
            i = synchronizedHeader.frameSize;
            if (!localBufferingInput.ensureLoaded(paramExtractorInput, i)) {
              throw new EOFException();
            }
            ParsableByteArray localParsableByteArray = new ParsableByteArray(buffer.data, writePosition);
            localParsableByteArray.setPosition(readPosition);
            readPosition = (i + readPosition);
            if ((synchronizedHeader.version & 0x1) == 1)
            {
              if (synchronizedHeader.channels == 1) {
                break label829;
              }
              i = 32;
              localParsableByteArray.setPosition(i + 4);
              i = localParsableByteArray.readInt();
              if ((i == XING_HEADER) || (i == INFO_HEADER))
              {
                seeker = XingSeeker.create(synchronizedHeader, localParsableByteArray, l1, l2);
                i = 1;
                if (i == 0) {
                  continue;
                }
                inputBuffer.mark();
                if (seeker == null)
                {
                  inputBuffer.read$35bcd88(paramExtractorInput, scratch.data, 4);
                  scratch.setPosition(0);
                  l2 = l1 + synchronizedHeader.frameSize;
                  MpegAudioHeader.populateHeader(scratch.readInt(), synchronizedHeader);
                  inputBuffer.returnToMark();
                  seeker = new ConstantBitrateSeeker(l2, synchronizedHeader.bitrate * 1000, paramExtractorInput.getLength());
                }
                extractorOutput.seekMap(seeker);
                trackOutput.format(MediaFormat.createAudioFormat(synchronizedHeader.mimeType, 4096, seeker.getDurationUs(), synchronizedHeader.channels, synchronizedHeader.sampleRate, null));
                return l1;
              }
            }
            else
            {
              if (synchronizedHeader.channels == 1) {
                break label835;
              }
              i = 17;
              continue;
            }
            localParsableByteArray.setPosition(36);
            if (localParsableByteArray.readInt() == VBRI_HEADER)
            {
              seeker = VbriSeeker.create(synchronizedHeader, localParsableByteArray, l1);
              i = 1;
              continue;
            }
            i = 0;
            continue;
            l2 = l1;
            continue;
          }
        }
        else
        {
          continue;
        }
        return l2;
      }
      catch (EOFException paramExtractorInput)
      {
        l2 = -1L;
      }
      label829:
      int i = 17;
      continue;
      label835:
      i = 9;
    }
  }
  
  public final void init(ExtractorOutput paramExtractorOutput)
  {
    extractorOutput = paramExtractorOutput;
    trackOutput = paramExtractorOutput.track(0);
    paramExtractorOutput.endTracks();
  }
  
  public final int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
    throws IOException, InterruptedException
  {
    int j = 0;
    int i;
    if ((synchronizedHeaderData == 0) && (synchronizeCatchingEndOfInput(paramExtractorInput) == -1L)) {
      i = -1;
    }
    long l1;
    long l2;
    do
    {
      return i;
      if (sampleBytesRemaining == 0)
      {
        inputBuffer.mark();
        if (!inputBuffer.readInternal$35bcd8c(paramExtractorInput, scratch.data, 4)) {
          l1 = -1L;
        }
        while (l1 == -1L)
        {
          return -1;
          inputBuffer.returnToMark();
          scratch.setPosition(0);
          i = scratch.readInt();
          if (((i & 0xFFFE0C00) == (synchronizedHeaderData & 0xFFFE0C00)) && (MpegAudioHeader.getFrameSize(i) != -1))
          {
            MpegAudioHeader.populateHeader(i, synchronizedHeader);
            l1 = 0L;
          }
          else
          {
            synchronizedHeaderData = 0;
            inputBuffer.skip(paramExtractorInput, 1);
            l1 = synchronizeCatchingEndOfInput(paramExtractorInput);
          }
        }
        if (basisTimeUs == -1L) {
          basisTimeUs = seeker.getTimeUs(getPosition(paramExtractorInput, inputBuffer));
        }
        sampleBytesRemaining = synchronizedHeader.frameSize;
      }
      l1 = basisTimeUs;
      l2 = samplesRead * 1000000L / synchronizedHeader.sampleRate;
      int k = sampleBytesRemaining;
      paramPositionHolder = inputBuffer;
      TrackOutput localTrackOutput = trackOutput;
      i = sampleBytesRemaining;
      if (i == 0) {
        i = 0;
      }
      for (;;)
      {
        sampleBytesRemaining = (k - i);
        if (sampleBytesRemaining <= 0) {
          break label371;
        }
        inputBuffer.mark();
        i = trackOutput.sampleData(paramExtractorInput, sampleBytesRemaining, true);
        if (i != -1) {
          break;
        }
        return -1;
        buffer.setPosition(readPosition);
        i = Math.min(writePosition - readPosition, i);
        localTrackOutput.sampleData(buffer, i);
        readPosition += i;
      }
      sampleBytesRemaining -= i;
      i = j;
    } while (sampleBytesRemaining > 0);
    label371:
    trackOutput.sampleMetadata(l1 + l2, 1, synchronizedHeader.frameSize, 0, null);
    samplesRead += synchronizedHeader.samplesPerFrame;
    sampleBytesRemaining = 0;
    return 0;
  }
  
  public final void seek()
  {
    synchronizedHeaderData = 0;
    samplesRead = 0;
    basisTimeUs = -1L;
    sampleBytesRemaining = 0;
    inputBuffer.reset();
  }
  
  public final boolean sniff(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    ParsableByteArray localParsableByteArray = new ParsableByteArray(4);
    int i = 0;
    paramExtractorInput.peekFully(data, 0, 3);
    int m;
    int j;
    int k;
    if (localParsableByteArray.readUnsignedInt24() == ID3_TAG)
    {
      paramExtractorInput.advancePeekPosition(3);
      paramExtractorInput.peekFully(data, 0, 4);
      i = (data[0] & 0x7F) << 21 | (data[1] & 0x7F) << 14 | (data[2] & 0x7F) << 7 | data[3] & 0x7F;
      paramExtractorInput.advancePeekPosition(i);
      i += 10;
      m = i;
      j = 0;
      k = 0;
    }
    for (;;)
    {
      if (m - i >= 4096)
      {
        return false;
        paramExtractorInput.resetPeekPosition();
        break;
      }
      paramExtractorInput.peekFully(data, 0, 4);
      localParsableByteArray.setPosition(0);
      int n = localParsableByteArray.readInt();
      int i1;
      if ((k == 0) || ((0xFFFE0C00 & n) == (0xFFFE0C00 & k)))
      {
        i1 = MpegAudioHeader.getFrameSize(n);
        if (i1 != -1) {}
      }
      else
      {
        j = 0;
        k = 0;
        paramExtractorInput.resetPeekPosition();
        m += 1;
        paramExtractorInput.advancePeekPosition(m);
        continue;
      }
      if (j == 0) {
        k = n;
      }
      j += 1;
      if (j == 4) {
        return true;
      }
      paramExtractorInput.advancePeekPosition(i1 - 4);
    }
  }
  
  static abstract interface Seeker
    extends SeekMap
  {
    public abstract long getDurationUs();
    
    public abstract long getTimeUs(long paramLong);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp3.Mp3Extractor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */