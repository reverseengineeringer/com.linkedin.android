package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.PositionHolder;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class Mp4Extractor
  implements Extractor, SeekMap
{
  private ParsableByteArray atomData;
  private final ParsableByteArray atomHeader = new ParsableByteArray(16);
  private int atomHeaderBytesRead;
  private long atomSize;
  private int atomType;
  private final Stack<Atom.ContainerAtom> containerAtoms = new Stack();
  private ExtractorOutput extractorOutput;
  private final ParsableByteArray nalLength = new ParsableByteArray(4);
  private final ParsableByteArray nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
  private int parserState;
  private int sampleBytesWritten;
  private int sampleCurrentNalBytesRemaining;
  private int sampleSize;
  private Mp4Track[] tracks;
  
  public Mp4Extractor()
  {
    enterReadingAtomHeaderState();
  }
  
  private void enterReadingAtomHeaderState()
  {
    parserState = 1;
    atomHeaderBytesRead = 0;
  }
  
  private int readSample(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
    throws IOException, InterruptedException
  {
    int j = -1;
    long l1 = Long.MAX_VALUE;
    int i = 0;
    int m;
    int k;
    while (i < tracks.length)
    {
      localMp4Track = tracks[i];
      m = sampleIndex;
      l2 = l1;
      k = j;
      if (m != sampleTable.sampleCount)
      {
        long l3 = sampleTable.offsets[m];
        l2 = l1;
        k = j;
        if (l3 < l1)
        {
          l2 = l3;
          k = i;
        }
      }
      i += 1;
      l1 = l2;
      j = k;
    }
    if (j == -1) {
      return -1;
    }
    Mp4Track localMp4Track = tracks[j];
    TrackOutput localTrackOutput = trackOutput;
    i = sampleIndex;
    l1 = sampleTable.offsets[i];
    long l2 = l1 - paramExtractorInput.getPosition() + sampleBytesWritten;
    if ((l2 < 0L) || (l2 >= 262144L))
    {
      position = l1;
      return 1;
    }
    paramExtractorInput.skipFully((int)l2);
    sampleSize = sampleTable.sizes[i];
    if (track.nalUnitLengthFieldLength != -1)
    {
      paramPositionHolder = nalLength.data;
      paramPositionHolder[0] = 0;
      paramPositionHolder[1] = 0;
      paramPositionHolder[2] = 0;
      j = track.nalUnitLengthFieldLength;
      k = 4 - track.nalUnitLengthFieldLength;
      while (sampleBytesWritten < sampleSize) {
        if (sampleCurrentNalBytesRemaining == 0)
        {
          paramExtractorInput.readFully(nalLength.data, k, j);
          nalLength.setPosition(0);
          sampleCurrentNalBytesRemaining = nalLength.readUnsignedIntToInt();
          nalStartCode.setPosition(0);
          localTrackOutput.sampleData(nalStartCode, 4);
          sampleBytesWritten += 4;
          sampleSize += k;
        }
        else
        {
          m = localTrackOutput.sampleData(paramExtractorInput, sampleCurrentNalBytesRemaining, false);
          sampleBytesWritten += m;
          sampleCurrentNalBytesRemaining -= m;
        }
      }
    }
    while (sampleBytesWritten < sampleSize)
    {
      j = localTrackOutput.sampleData(paramExtractorInput, sampleSize - sampleBytesWritten, false);
      sampleBytesWritten += j;
      sampleCurrentNalBytesRemaining -= j;
    }
    localTrackOutput.sampleMetadata(sampleTable.timestampsUs[i], sampleTable.flags[i], sampleSize, 0, null);
    sampleIndex += 1;
    sampleBytesWritten = 0;
    sampleCurrentNalBytesRemaining = 0;
    return 0;
  }
  
  public final long getPosition(long paramLong)
  {
    long l1 = Long.MAX_VALUE;
    int k = 0;
    if (k < tracks.length)
    {
      TrackSampleTable localTrackSampleTable = tracks[k].sampleTable;
      int i = Util.binarySearchFloor(timestampsUs, paramLong, true, false);
      label42:
      if (i >= 0) {
        if ((timestampsUs[i] <= paramLong) && ((flags[i] & 0x1) != 0))
        {
          label70:
          j = i;
          if (i == -1)
          {
            i = Util.binarySearchCeil$7476434d(timestampsUs, paramLong, true);
            label89:
            if (i >= timestampsUs.length) {
              break label204;
            }
            if ((timestampsUs[i] < paramLong) || ((flags[i] & 0x1) == 0)) {
              break label197;
            }
          }
        }
      }
      label197:
      label204:
      for (int j = i;; j = -1)
      {
        tracks[k].sampleIndex = j;
        long l3 = offsets[tracks[k].sampleIndex];
        long l2 = l1;
        if (l3 < l1) {
          l2 = l3;
        }
        k += 1;
        l1 = l2;
        break;
        i -= 1;
        break label42;
        i = -1;
        break label70;
        i += 1;
        break label89;
      }
    }
    return l1;
  }
  
  public final void init(ExtractorOutput paramExtractorOutput)
  {
    extractorOutput = paramExtractorOutput;
  }
  
  public final boolean isSeekable()
  {
    return true;
  }
  
  public final int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
    throws IOException, InterruptedException
  {
    do
    {
      for (;;)
      {
        switch (parserState)
        {
        default: 
          return readSample(paramExtractorInput, paramPositionHolder);
        case 0: 
          if (paramExtractorInput.getPosition() == 0L) {
            enterReadingAtomHeaderState();
          } else {
            parserState = 3;
          }
          break;
        }
      }
      if (atomHeaderBytesRead != 0) {
        break label136;
      }
      if (paramExtractorInput.readFully(atomHeader.data, 0, 8, true)) {
        break;
      }
      i = 0;
    } while (i != 0);
    return -1;
    atomHeaderBytesRead = 8;
    atomHeader.setPosition(0);
    atomSize = atomHeader.readUnsignedInt();
    atomType = atomHeader.readInt();
    label136:
    if (atomSize == 1L)
    {
      paramExtractorInput.readFully(atomHeader.data, 8, 8);
      atomHeaderBytesRead += 8;
      atomSize = atomHeader.readUnsignedLongToLong();
    }
    int i = atomType;
    if ((i == Atom.TYPE_moov) || (i == Atom.TYPE_trak) || (i == Atom.TYPE_mdia) || (i == Atom.TYPE_minf) || (i == Atom.TYPE_stbl))
    {
      i = 1;
      label226:
      if (i == 0) {
        break label292;
      }
      l1 = paramExtractorInput.getPosition();
      l2 = atomSize;
      long l3 = atomHeaderBytesRead;
      containerAtoms.add(new Atom.ContainerAtom(atomType, l1 + l2 - l3));
      enterReadingAtomHeaderState();
    }
    for (;;)
    {
      i = 1;
      break;
      i = 0;
      break label226;
      label292:
      i = atomType;
      if ((i == Atom.TYPE_mdhd) || (i == Atom.TYPE_mvhd) || (i == Atom.TYPE_hdlr) || (i == Atom.TYPE_vmhd) || (i == Atom.TYPE_smhd) || (i == Atom.TYPE_stsd) || (i == Atom.TYPE_avc1) || (i == Atom.TYPE_avcC) || (i == Atom.TYPE_mp4a) || (i == Atom.TYPE_esds) || (i == Atom.TYPE_stts) || (i == Atom.TYPE_stss) || (i == Atom.TYPE_ctts) || (i == Atom.TYPE_stsc) || (i == Atom.TYPE_stsz) || (i == Atom.TYPE_stco) || (i == Atom.TYPE_co64) || (i == Atom.TYPE_tkhd) || (i == Atom.TYPE_s263))
      {
        i = 1;
        label432:
        if (i == 0) {
          break label534;
        }
        if (atomHeaderBytesRead != 8) {
          break label522;
        }
        bool = true;
        label448:
        Assertions.checkState(bool);
        if (atomSize > 2147483647L) {
          break label528;
        }
      }
      label522:
      label528:
      for (boolean bool = true;; bool = false)
      {
        Assertions.checkState(bool);
        atomData = new ParsableByteArray((int)atomSize);
        System.arraycopy(atomHeader.data, 0, atomData.data, 0, 8);
        parserState = 2;
        break;
        i = 0;
        break label432;
        bool = false;
        break label448;
      }
      label534:
      atomData = null;
      parserState = 2;
    }
    long l1 = atomSize - atomHeaderBytesRead;
    long l2 = paramExtractorInput.getPosition();
    if (atomData != null)
    {
      paramExtractorInput.readFully(atomData.data, atomHeaderBytesRead, (int)l1);
      if (containerAtoms.isEmpty()) {
        break label984;
      }
      ((Atom.ContainerAtom)containerAtoms.peek()).add(new Atom.LeafAtom(atomType, atomData));
      i = 0;
    }
    for (;;)
    {
      label634:
      Atom.ContainerAtom localContainerAtom;
      if ((!containerAtoms.isEmpty()) && (containerAtoms.peek()).endPosition == l2 + l1))
      {
        localContainerAtom = (Atom.ContainerAtom)containerAtoms.pop();
        if (type == Atom.TYPE_moov)
        {
          ArrayList localArrayList = new ArrayList();
          i = 0;
          for (;;)
          {
            if (i < containerChildren.size())
            {
              Object localObject = (Atom.ContainerAtom)containerChildren.get(i);
              if (type == Atom.TYPE_trak)
              {
                Track localTrack = AtomParsers.parseTrak((Atom.ContainerAtom)localObject, localContainerAtom.getLeafAtomOfType(Atom.TYPE_mvhd));
                if (localTrack != null)
                {
                  localObject = AtomParsers.parseStbl(localTrack, ((Atom.ContainerAtom)localObject).getContainerAtomOfType(Atom.TYPE_mdia).getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl));
                  if (sampleCount != 0)
                  {
                    localObject = new Mp4Track(localTrack, (TrackSampleTable)localObject, extractorOutput.track(i));
                    trackOutput.format(mediaFormat);
                    localArrayList.add(localObject);
                  }
                }
              }
              i += 1;
              continue;
              if (l1 < 262144L)
              {
                paramExtractorInput.skipFully((int)l1);
                i = 0;
                break;
              }
              position = (l1 + paramExtractorInput.getPosition());
              i = 1;
              break;
            }
          }
          tracks = ((Mp4Track[])localArrayList.toArray(new Mp4Track[0]));
          extractorOutput.endTracks();
          extractorOutput.seekMap(this);
          containerAtoms.clear();
          parserState = 3;
          i = 0;
        }
      }
      while (i != 0)
      {
        return 1;
        if (containerAtoms.isEmpty()) {
          break label634;
        }
        ((Atom.ContainerAtom)containerAtoms.peek()).add(localContainerAtom);
        break label634;
        enterReadingAtomHeaderState();
      }
      label984:
      i = 0;
    }
  }
  
  public final void seek()
  {
    containerAtoms.clear();
    atomHeaderBytesRead = 0;
    sampleBytesWritten = 0;
    sampleCurrentNalBytesRemaining = 0;
    parserState = 0;
  }
  
  public final boolean sniff(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    return Sniffer.sniffUnfragmented(paramExtractorInput);
  }
  
  private static final class Mp4Track
  {
    public int sampleIndex;
    public final TrackSampleTable sampleTable;
    public final Track track;
    public final TrackOutput trackOutput;
    
    public Mp4Track(Track paramTrack, TrackSampleTable paramTrackSampleTable, TrackOutput paramTrackOutput)
    {
      track = paramTrack;
      sampleTable = paramTrackSampleTable;
      trackOutput = paramTrackOutput;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp4.Mp4Extractor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */