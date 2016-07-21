package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.drm.DrmInitData.Mapped;
import com.google.android.exoplayer.extractor.ChunkIndex;
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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;

public final class FragmentedMp4Extractor
  implements Extractor
{
  private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
  private ParsableByteArray atomData;
  private final ParsableByteArray atomHeader = new ParsableByteArray(16);
  private int atomHeaderBytesRead;
  private long atomSize;
  private int atomType;
  private final Stack<Atom.ContainerAtom> containerAtoms = new Stack();
  private final ParsableByteArray encryptionSignalByte = new ParsableByteArray(1);
  private final byte[] extendedTypeScratch = new byte[16];
  private DefaultSampleValues extendsDefaults;
  private ExtractorOutput extractorOutput;
  private final TrackFragment fragmentRun = new TrackFragment();
  private boolean haveOutputSeekMap;
  private final ParsableByteArray nalLength = new ParsableByteArray(4);
  private final ParsableByteArray nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
  private int parserState;
  private int sampleBytesWritten;
  private int sampleCurrentNalBytesRemaining;
  private int sampleIndex;
  private int sampleSize;
  private Track track;
  private TrackOutput trackOutput;
  private final int workaroundFlags = 0;
  
  public FragmentedMp4Extractor()
  {
    this((byte)0);
  }
  
  private FragmentedMp4Extractor(byte paramByte)
  {
    enterReadingAtomHeaderState();
  }
  
  private void enterReadingAtomHeaderState()
  {
    parserState = 0;
    atomHeaderBytesRead = 0;
  }
  
  private void onMoovContainerAtomRead(Atom.ContainerAtom paramContainerAtom)
  {
    List localList = leafChildren;
    int k = localList.size();
    Object localObject2 = null;
    int j = 0;
    if (j < k)
    {
      Object localObject3 = (Atom.LeafAtom)localList.get(j);
      localObject1 = localObject2;
      int i;
      if (type == Atom.TYPE_pssh)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new DrmInitData.Mapped("video/mp4");
        }
        localObject3 = data.data;
        localObject2 = new ParsableByteArray((byte[])localObject3);
        if (limit >= 32) {
          break label140;
        }
        i = 0;
        label107:
        if (i != 0) {
          break label219;
        }
      }
      for (localObject2 = null;; localObject2 = new UUID(((ParsableByteArray)localObject2).readLong(), ((ParsableByteArray)localObject2).readLong()))
      {
        schemeData.put(localObject2, localObject3);
        j += 1;
        localObject2 = localObject1;
        break;
        label140:
        ((ParsableByteArray)localObject2).setPosition(0);
        if (((ParsableByteArray)localObject2).readInt() != ((ParsableByteArray)localObject2).bytesLeft() + 4)
        {
          i = 0;
          break label107;
        }
        if (((ParsableByteArray)localObject2).readInt() != Atom.TYPE_pssh)
        {
          i = 0;
          break label107;
        }
        ((ParsableByteArray)localObject2).setPosition(12);
        ((ParsableByteArray)localObject2).skipBytes(16);
        if (((ParsableByteArray)localObject2).readInt() != ((ParsableByteArray)localObject2).bytesLeft())
        {
          i = 0;
          break label107;
        }
        i = 1;
        break label107;
        label219:
        ((ParsableByteArray)localObject2).setPosition(12);
      }
    }
    if (localObject2 != null) {
      extractorOutput.drmInitData((DrmInitData)localObject2);
    }
    Object localObject1 = getContainerAtomOfTypeTYPE_mvexgetLeafAtomOfTypeTYPE_trexdata;
    ((ParsableByteArray)localObject1).setPosition(16);
    extendsDefaults = new DefaultSampleValues(((ParsableByteArray)localObject1).readUnsignedIntToInt() - 1, ((ParsableByteArray)localObject1).readUnsignedIntToInt(), ((ParsableByteArray)localObject1).readUnsignedIntToInt(), ((ParsableByteArray)localObject1).readInt());
    track = AtomParsers.parseTrak(paramContainerAtom.getContainerAtomOfType(Atom.TYPE_trak), paramContainerAtom.getLeafAtomOfType(Atom.TYPE_mvhd));
    if (track != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      trackOutput.format(track.mediaFormat);
      return;
    }
  }
  
  private static void parseSenc(ParsableByteArray paramParsableByteArray, int paramInt, TrackFragment paramTrackFragment)
  {
    paramParsableByteArray.setPosition(paramInt + 8);
    paramInt = Atom.parseFullAtomFlags(paramParsableByteArray.readInt());
    if ((paramInt & 0x1) != 0) {
      throw new IllegalStateException("Overriding TrackEncryptionBox parameters is unsupported");
    }
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = paramParsableByteArray.readUnsignedIntToInt();
      if (paramInt == length) {
        break;
      }
      throw new IllegalStateException("Length mismatch: " + paramInt + ", " + length);
    }
    Arrays.fill(sampleHasSubsampleEncryptionTable, 0, paramInt, bool);
    paramTrackFragment.initEncryptionData(paramParsableByteArray.bytesLeft());
    paramParsableByteArray.readBytes(sampleEncryptionData.data, 0, sampleEncryptionDataLength);
    sampleEncryptionData.setPosition(0);
    sampleEncryptionDataNeedsFill = false;
  }
  
  private static void parseTraf(Track paramTrack, DefaultSampleValues paramDefaultSampleValues, Atom.ContainerAtom paramContainerAtom, TrackFragment paramTrackFragment, int paramInt, byte[] paramArrayOfByte)
  {
    long l1;
    int m;
    int i;
    label78:
    int j;
    label93:
    int k;
    label108:
    label123:
    int i1;
    label206:
    label236:
    label248:
    int n;
    label260:
    label272:
    int i2;
    int[] arrayOfInt2;
    boolean[] arrayOfBoolean;
    label398:
    int i3;
    label401:
    int i4;
    label420:
    int i5;
    if (paramContainerAtom.getLeafAtomOfType(Atom.TYPE_tfdt) == null)
    {
      l1 = 0L;
      localObject = getLeafAtomOfTypeTYPE_tfhddata;
      ((ParsableByteArray)localObject).setPosition(8);
      m = Atom.parseFullAtomFlags(((ParsableByteArray)localObject).readInt());
      ((ParsableByteArray)localObject).skipBytes(4);
      if ((m & 0x1) != 0) {
        ((ParsableByteArray)localObject).skipBytes(8);
      }
      if ((m & 0x2) == 0) {
        break label589;
      }
      i = ((ParsableByteArray)localObject).readUnsignedIntToInt() - 1;
      if ((m & 0x8) == 0) {
        break label598;
      }
      j = ((ParsableByteArray)localObject).readUnsignedIntToInt();
      if ((m & 0x10) == 0) {
        break label607;
      }
      k = ((ParsableByteArray)localObject).readUnsignedIntToInt();
      if ((m & 0x20) == 0) {
        break label616;
      }
      m = ((ParsableByteArray)localObject).readUnsignedIntToInt();
      paramDefaultSampleValues = new DefaultSampleValues(i, j, k, m);
      sampleDescriptionIndex = sampleDescriptionIndex;
      localObject = getLeafAtomOfTypeTYPE_trundata;
      ((ParsableByteArray)localObject).setPosition(8);
      i1 = Atom.parseFullAtomFlags(((ParsableByteArray)localObject).readInt());
      int i6 = ((ParsableByteArray)localObject).readUnsignedIntToInt();
      if ((i1 & 0x1) != 0) {
        ((ParsableByteArray)localObject).skipBytes(4);
      }
      if ((i1 & 0x4) == 0) {
        break label625;
      }
      j = 1;
      i = flags;
      if (j != 0) {
        i = ((ParsableByteArray)localObject).readUnsignedIntToInt();
      }
      if ((i1 & 0x100) == 0) {
        break label631;
      }
      k = 1;
      if ((i1 & 0x200) == 0) {
        break label637;
      }
      m = 1;
      if ((i1 & 0x400) == 0) {
        break label643;
      }
      n = 1;
      if ((i1 & 0x800) == 0) {
        break label649;
      }
      i1 = 1;
      length = i6;
      if ((sampleSizeTable == null) || (sampleSizeTable.length < length))
      {
        i2 = i6 * 125 / 100;
        sampleSizeTable = new int[i2];
        sampleCompositionTimeOffsetTable = new int[i2];
        sampleDecodingTimeTable = new long[i2];
        sampleIsSyncFrameTable = new boolean[i2];
        sampleHasSubsampleEncryptionTable = new boolean[i2];
      }
      int[] arrayOfInt1 = sampleSizeTable;
      arrayOfInt2 = sampleCompositionTimeOffsetTable;
      long[] arrayOfLong = sampleDecodingTimeTable;
      arrayOfBoolean = sampleIsSyncFrameTable;
      long l2 = timescale;
      if ((type != Track.TYPE_VIDEO) || ((paramInt & 0x1) != 1)) {
        break label655;
      }
      i2 = 1;
      i3 = 0;
      if (i3 >= i6) {
        break label718;
      }
      if (k == 0) {
        break label661;
      }
      i4 = ((ParsableByteArray)localObject).readUnsignedIntToInt();
      if (m == 0) {
        break label670;
      }
      i5 = ((ParsableByteArray)localObject).readUnsignedIntToInt();
      label432:
      if ((i3 != 0) || (j == 0)) {
        break label679;
      }
      paramInt = i;
      label446:
      if (i1 == 0) {
        break label703;
      }
      arrayOfInt2[i3] = ((int)(((ParsableByteArray)localObject).readInt() * 1000 / l2));
      label470:
      arrayOfLong[i3] = (1000L * l1 / l2);
      arrayOfInt1[i3] = i5;
      if (((paramInt >> 16 & 0x1) != 0) || ((i2 != 0) && (i3 != 0))) {
        break label712;
      }
    }
    label589:
    label598:
    label607:
    label616:
    label625:
    label631:
    label637:
    label643:
    label649:
    label655:
    label661:
    label670:
    label679:
    label703:
    label712:
    for (boolean bool = true;; bool = false)
    {
      arrayOfBoolean[i3] = bool;
      l1 += i4;
      i3 += 1;
      break label401;
      localObject = getLeafAtomOfTypeTYPE_tfdtdata;
      ((ParsableByteArray)localObject).setPosition(8);
      if (Atom.parseFullAtomVersion(((ParsableByteArray)localObject).readInt()) == 1)
      {
        l1 = ((ParsableByteArray)localObject).readUnsignedLongToLong();
        break;
      }
      l1 = ((ParsableByteArray)localObject).readUnsignedInt();
      break;
      i = sampleDescriptionIndex;
      break label78;
      j = duration;
      break label93;
      k = size;
      break label108;
      m = flags;
      break label123;
      j = 0;
      break label206;
      k = 0;
      break label236;
      m = 0;
      break label248;
      n = 0;
      break label260;
      i1 = 0;
      break label272;
      i2 = 0;
      break label398;
      i4 = duration;
      break label420;
      i5 = size;
      break label432;
      if (n != 0)
      {
        paramInt = ((ParsableByteArray)localObject).readInt();
        break label446;
      }
      paramInt = flags;
      break label446;
      arrayOfInt2[i3] = 0;
      break label470;
    }
    label718:
    Object localObject = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_saiz);
    if (localObject != null)
    {
      paramTrack = sampleDescriptionEncryptionBoxes[sampleDescriptionIndex];
      paramDefaultSampleValues = data;
      k = initializationVectorSize;
      paramDefaultSampleValues.setPosition(8);
      if ((Atom.parseFullAtomFlags(paramDefaultSampleValues.readInt()) & 0x1) == 1) {
        paramDefaultSampleValues.skipBytes(8);
      }
      paramInt = paramDefaultSampleValues.readUnsignedByte();
      m = paramDefaultSampleValues.readUnsignedIntToInt();
      if (m != length) {
        throw new IllegalStateException("Length mismatch: " + m + ", " + length);
      }
      if (paramInt == 0)
      {
        paramTrack = sampleHasSubsampleEncryptionTable;
        paramInt = 0;
        i = 0;
        j = paramInt;
        if (i < m)
        {
          j = paramDefaultSampleValues.readUnsignedByte();
          if (j > k) {}
          for (bool = true;; bool = false)
          {
            paramTrack[i] = bool;
            i += 1;
            paramInt += j;
            break;
          }
        }
      }
      else
      {
        if (paramInt <= k) {
          break label1061;
        }
      }
    }
    label1061:
    for (bool = true;; bool = false)
    {
      Arrays.fill(sampleHasSubsampleEncryptionTable, 0, m, bool);
      j = paramInt * m + 0;
      paramTrackFragment.initEncryptionData(j);
      paramTrack = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_senc);
      if (paramTrack != null) {
        parseSenc(data, 0, paramTrackFragment);
      }
      i = leafChildren.size();
      paramInt = 0;
      while (paramInt < i)
      {
        paramTrack = (Atom.LeafAtom)leafChildren.get(paramInt);
        if (type == Atom.TYPE_uuid)
        {
          paramTrack = data;
          paramTrack.setPosition(8);
          paramTrack.readBytes(paramArrayOfByte, 0, 16);
          if (Arrays.equals(paramArrayOfByte, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
            parseSenc(paramTrack, 16, paramTrackFragment);
          }
        }
        paramInt += 1;
      }
    }
  }
  
  private boolean readSample(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    if (sampleIndex >= fragmentRun.length)
    {
      enterReadingAtomHeaderState();
      return false;
    }
    Object localObject;
    int j;
    if (parserState == 3)
    {
      sampleSize = fragmentRun.sampleSizeTable[sampleIndex];
      if (!fragmentRun.definesEncryptionData) {
        break label389;
      }
      localObject = fragmentRun.sampleEncryptionData;
      j = track.sampleDescriptionEncryptionBoxes[fragmentRun.sampleDescriptionIndex].initializationVectorSize;
      int m = fragmentRun.sampleHasSubsampleEncryptionTable[sampleIndex];
      byte[] arrayOfByte = encryptionSignalByte.data;
      if (m != 0)
      {
        i = 128;
        arrayOfByte[0] = ((byte)(i | j));
        encryptionSignalByte.setPosition(0);
        trackOutput.sampleData(encryptionSignalByte, 1);
        trackOutput.sampleData((ParsableByteArray)localObject, j);
        if (m != 0) {
          break label348;
        }
        i = j + 1;
        label165:
        sampleBytesWritten = i;
        sampleSize += sampleBytesWritten;
        label183:
        sampleCurrentNalBytesRemaining = 0;
        parserState = 4;
      }
    }
    else
    {
      if (track.nalUnitLengthFieldLength == -1) {
        break label439;
      }
      localObject = nalLength.data;
      localObject[0] = 0;
      localObject[1] = 0;
      localObject[2] = 0;
      i = track.nalUnitLengthFieldLength;
      j = 4 - track.nalUnitLengthFieldLength;
    }
    for (;;)
    {
      if (sampleBytesWritten >= sampleSize) {
        break label484;
      }
      if (sampleCurrentNalBytesRemaining == 0)
      {
        paramExtractorInput.readFully(nalLength.data, j, i);
        nalLength.setPosition(0);
        sampleCurrentNalBytesRemaining = nalLength.readUnsignedIntToInt();
        nalStartCode.setPosition(0);
        trackOutput.sampleData(nalStartCode, 4);
        sampleBytesWritten += 4;
        sampleSize += j;
        continue;
        i = 0;
        break;
        label348:
        i = ((ParsableByteArray)localObject).readUnsignedShort();
        ((ParsableByteArray)localObject).skipBytes(-2);
        i = i * 6 + 2;
        trackOutput.sampleData((ParsableByteArray)localObject, i);
        i += j + 1;
        break label165;
        label389:
        sampleBytesWritten = 0;
        break label183;
      }
      int k = trackOutput.sampleData(paramExtractorInput, sampleCurrentNalBytesRemaining, false);
      sampleBytesWritten += k;
      sampleCurrentNalBytesRemaining -= k;
    }
    label439:
    while (sampleBytesWritten < sampleSize)
    {
      i = trackOutput.sampleData(paramExtractorInput, sampleSize - sampleBytesWritten, false);
      sampleBytesWritten += i;
    }
    label484:
    paramExtractorInput = fragmentRun;
    int i = sampleIndex;
    long l1 = sampleDecodingTimeTable[i];
    long l2 = sampleCompositionTimeOffsetTable[i];
    if (fragmentRun.definesEncryptionData)
    {
      i = 2;
      if (fragmentRun.sampleIsSyncFrameTable[sampleIndex] == 0) {
        break label618;
      }
      j = 1;
      label540:
      if (!fragmentRun.definesEncryptionData) {
        break label623;
      }
    }
    label618:
    label623:
    for (paramExtractorInput = track.sampleDescriptionEncryptionBoxes[fragmentRun.sampleDescriptionIndex].keyId;; paramExtractorInput = null)
    {
      trackOutput.sampleMetadata((l1 + l2) * 1000L, i | j, sampleSize, 0, paramExtractorInput);
      sampleIndex += 1;
      parserState = 3;
      return true;
      i = 0;
      break;
      j = 0;
      break label540;
    }
  }
  
  public final void init(ExtractorOutput paramExtractorOutput)
  {
    extractorOutput = paramExtractorOutput;
    trackOutput = paramExtractorOutput.track(0);
    extractorOutput.endTracks();
  }
  
  public final int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
    throws IOException, InterruptedException
  {
    for (;;)
    {
      int i;
      label433:
      long l1;
      long l2;
      switch (parserState)
      {
      default: 
        if (readSample(paramExtractorInput)) {
          return 0;
        }
        break;
      case 0: 
        if (atomHeaderBytesRead == 0)
        {
          if (!paramExtractorInput.readFully(atomHeader.data, 0, 8, true))
          {
            i = 0;
            if (i == 0) {
              return -1;
            }
          }
          else
          {
            atomHeaderBytesRead = 8;
            atomHeader.setPosition(0);
            atomSize = atomHeader.readUnsignedInt();
            atomType = atomHeader.readInt();
          }
        }
        else
        {
          if (atomSize == 1L)
          {
            paramExtractorInput.readFully(atomHeader.data, 8, 8);
            atomHeaderBytesRead += 8;
            atomSize = atomHeader.readUnsignedLongToLong();
          }
          if (atomType == Atom.TYPE_mdat)
          {
            if (!haveOutputSeekMap)
            {
              extractorOutput.seekMap(SeekMap.UNSEEKABLE);
              haveOutputSeekMap = true;
            }
            if (fragmentRun.sampleEncryptionDataNeedsFill) {}
            for (parserState = 2;; parserState = 3)
            {
              i = 1;
              break;
            }
          }
          i = atomType;
          if ((i == Atom.TYPE_avc1) || (i == Atom.TYPE_avc3) || (i == Atom.TYPE_esds) || (i == Atom.TYPE_hdlr) || (i == Atom.TYPE_mdat) || (i == Atom.TYPE_mdhd) || (i == Atom.TYPE_moof) || (i == Atom.TYPE_moov) || (i == Atom.TYPE_mp4a) || (i == Atom.TYPE_mvhd) || (i == Atom.TYPE_sidx) || (i == Atom.TYPE_stsd) || (i == Atom.TYPE_tfdt) || (i == Atom.TYPE_tfhd) || (i == Atom.TYPE_tkhd) || (i == Atom.TYPE_traf) || (i == Atom.TYPE_trak) || (i == Atom.TYPE_trex) || (i == Atom.TYPE_trun) || (i == Atom.TYPE_mvex) || (i == Atom.TYPE_mdia) || (i == Atom.TYPE_minf) || (i == Atom.TYPE_stbl) || (i == Atom.TYPE_pssh) || (i == Atom.TYPE_saiz) || (i == Atom.TYPE_uuid) || (i == Atom.TYPE_senc) || (i == Atom.TYPE_pasp) || (i == Atom.TYPE_s263))
          {
            i = 1;
            if (i == 0) {
              break label665;
            }
            i = atomType;
            if ((i != Atom.TYPE_moov) && (i != Atom.TYPE_trak) && (i != Atom.TYPE_mdia) && (i != Atom.TYPE_minf) && (i != Atom.TYPE_stbl) && (i != Atom.TYPE_avcC) && (i != Atom.TYPE_moof) && (i != Atom.TYPE_traf) && (i != Atom.TYPE_mvex)) {
              break label567;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label572;
            }
            l1 = paramExtractorInput.getPosition();
            l2 = atomSize;
            containerAtoms.add(new Atom.ContainerAtom(atomType, l1 + l2 - 8L));
            enterReadingAtomHeaderState();
            i = 1;
            break;
            i = 0;
            break label433;
          }
          if (atomHeaderBytesRead == 8)
          {
            bool = true;
            Assertions.checkState(bool);
            if (atomSize > 2147483647L) {
              break label659;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            Assertions.checkState(bool);
            atomData = new ParsableByteArray((int)atomSize);
            System.arraycopy(atomHeader.data, 0, atomData.data, 0, 8);
            parserState = 1;
            break;
            bool = false;
            break label584;
          }
          if (atomSize <= 2147483647L) {}
          for (bool = true;; bool = false)
          {
            Assertions.checkState(bool);
            atomData = null;
            parserState = 1;
            break;
          }
        }
        break;
      case 1: 
        i = (int)atomSize - atomHeaderBytesRead;
        if (atomData != null)
        {
          paramExtractorInput.readFully(atomData.data, 8, i);
          paramPositionHolder = new Atom.LeafAtom(atomType, atomData);
          l2 = paramExtractorInput.getPosition();
          if (!containerAtoms.isEmpty())
          {
            ((Atom.ContainerAtom)containerAtoms.peek()).add(paramPositionHolder);
            l1 = paramExtractorInput.getPosition();
          }
        }
        for (;;)
        {
          if ((containerAtoms.isEmpty()) || (containerAtoms.peek()).endPosition != l1)) {
            break label1262;
          }
          paramPositionHolder = (Atom.ContainerAtom)containerAtoms.pop();
          Object localObject1;
          Object localObject2;
          Object localObject3;
          Object localObject4;
          if (type == Atom.TYPE_moov)
          {
            onMoovContainerAtomRead(paramPositionHolder);
            continue;
            if (type != Atom.TYPE_sidx) {
              break;
            }
            paramPositionHolder = data;
            paramPositionHolder.setPosition(8);
            i = Atom.parseFullAtomVersion(paramPositionHolder.readInt());
            paramPositionHolder.skipBytes(4);
            long l5 = paramPositionHolder.readUnsignedInt();
            int j;
            long l4;
            long l3;
            if (i == 0)
            {
              l1 = paramPositionHolder.readUnsignedInt();
              l2 = paramPositionHolder.readUnsignedInt() + l2;
              paramPositionHolder.skipBytes(2);
              j = paramPositionHolder.readUnsignedShort();
              localObject1 = new int[j];
              localObject2 = new long[j];
              localObject3 = new long[j];
              localObject4 = new long[j];
              l4 = Util.scaleLargeTimestamp(l1, 1000000L, l5);
              i = 0;
              l3 = l1;
              l1 = l2;
              l2 = l4;
            }
            for (;;)
            {
              if (i >= j) {
                break label1101;
              }
              int k = paramPositionHolder.readInt();
              if ((0x80000000 & k) != 0)
              {
                throw new IllegalStateException("Unhandled indirect reference");
                l1 = paramPositionHolder.readUnsignedLongToLong();
                l2 = paramPositionHolder.readUnsignedLongToLong() + l2;
                break;
              }
              l4 = paramPositionHolder.readUnsignedInt();
              localObject1[i] = (k & 0x7FFFFFFF);
              localObject2[i] = l1;
              localObject4[i] = l2;
              l3 += l4;
              l2 = Util.scaleLargeTimestamp(l3, 1000000L, l5);
              localObject3[i] = (l2 - localObject4[i]);
              paramPositionHolder.skipBytes(4);
              l1 += localObject1[i];
              i += 1;
            }
            paramPositionHolder = new ChunkIndex((int[])localObject1, (long[])localObject2, (long[])localObject3, (long[])localObject4);
            extractorOutput.seekMap(paramPositionHolder);
            haveOutputSeekMap = true;
            break;
            paramExtractorInput.skipFully(i);
            break;
          }
          if (type == Atom.TYPE_moof)
          {
            localObject1 = fragmentRun;
            length = 0;
            definesEncryptionData = false;
            sampleEncryptionDataNeedsFill = false;
            localObject1 = track;
            localObject2 = extendsDefaults;
            localObject3 = fragmentRun;
            i = workaroundFlags;
            localObject4 = extendedTypeScratch;
            parseTraf((Track)localObject1, (DefaultSampleValues)localObject2, paramPositionHolder.getContainerAtomOfType(Atom.TYPE_traf), (TrackFragment)localObject3, i, (byte[])localObject4);
            sampleIndex = 0;
          }
          else if (!containerAtoms.isEmpty())
          {
            ((Atom.ContainerAtom)containerAtoms.peek()).add(paramPositionHolder);
          }
        }
        enterReadingAtomHeaderState();
        break;
      case 2: 
        label567:
        label572:
        label584:
        label659:
        label665:
        label1101:
        label1262:
        paramPositionHolder = fragmentRun;
        paramExtractorInput.readFully(sampleEncryptionData.data, 0, sampleEncryptionDataLength);
        sampleEncryptionData.setPosition(0);
        sampleEncryptionDataNeedsFill = false;
        parserState = 3;
      }
    }
  }
  
  public final void seek()
  {
    containerAtoms.clear();
    enterReadingAtomHeaderState();
  }
  
  public final boolean sniff(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    return Sniffer.sniffFragmented(paramExtractorInput);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp4.FragmentedMp4Extractor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */