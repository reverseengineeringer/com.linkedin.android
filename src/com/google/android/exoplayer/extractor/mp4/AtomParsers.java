package com.google.android.exoplayer.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.util.Ac3Util;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.CodecSpecificDataUtil;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class AtomParsers
{
  private static void parseAudioSampleEntry(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2, int paramInt3, long paramLong, StsdDataHolder paramStsdDataHolder, int paramInt4)
  {
    paramParsableByteArray.setPosition(paramInt2 + 8);
    paramParsableByteArray.skipBytes(16);
    int m = paramParsableByteArray.readUnsignedShort();
    int i1 = paramParsableByteArray.readUnsignedShort();
    paramParsableByteArray.skipBytes(4);
    Object localObject1 = data;
    int i = position;
    position = (i + 1);
    i = localObject1[i];
    localObject1 = data;
    int j = position;
    position = (j + 1);
    j = (i & 0xFF) << 8 | localObject1[j] & 0xFF;
    position += 2;
    localObject1 = null;
    Object localObject4;
    if (paramInt1 == Atom.TYPE_ac_3)
    {
      localObject1 = "audio/ac3";
      localObject4 = null;
      i = position;
      label132:
      if (i - paramInt2 >= paramInt3) {
        break label501;
      }
      paramParsableByteArray.setPosition(i);
      i3 = position;
      i2 = paramParsableByteArray.readInt();
      if (i2 <= 0) {
        break label336;
      }
      bool = true;
      label166:
      Assertions.checkArgument(bool, "childAtomSize should be positive");
      i4 = paramParsableByteArray.readInt();
      if ((paramInt1 != Atom.TYPE_mp4a) && (paramInt1 != Atom.TYPE_enca)) {
        break label401;
      }
      if (i4 != Atom.TYPE_esds) {
        break label342;
      }
      localObject2 = parseEsdsFromParent(paramParsableByteArray, i3);
      localObject1 = (String)first;
      localObject4 = (byte[])second;
      localObject2 = localObject1;
      n = m;
      k = j;
      localObject3 = localObject4;
      if ("audio/mp4a-latm".equals(localObject1))
      {
        localObject2 = CodecSpecificDataUtil.parseAacAudioSpecificConfig((byte[])localObject4);
        k = ((Integer)first).intValue();
        n = ((Integer)second).intValue();
        localObject3 = localObject4;
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      i += i2;
      localObject1 = localObject2;
      m = n;
      j = k;
      localObject4 = localObject3;
      break label132;
      if (paramInt1 != Atom.TYPE_ec_3) {
        break;
      }
      localObject1 = "audio/eac3";
      break;
      label336:
      bool = false;
      break label166;
      label342:
      localObject2 = localObject1;
      n = m;
      k = j;
      localObject3 = localObject4;
      if (i4 == Atom.TYPE_sinf)
      {
        trackEncryptionBoxes[paramInt4] = parseSinfFromParent(paramParsableByteArray, i3, i2);
        localObject2 = localObject1;
        n = m;
        k = j;
        localObject3 = localObject4;
      }
    }
    label401:
    if ((paramInt1 == Atom.TYPE_ac_3) && (i4 == Atom.TYPE_dac3))
    {
      paramParsableByteArray.setPosition(i3 + 8);
      mediaFormat = Ac3Util.parseAnnexFAc3Format(paramParsableByteArray);
    }
    label501:
    while (localObject1 == null)
    {
      int i3;
      int i4;
      do
      {
        do
        {
          int i2;
          boolean bool;
          return;
          localObject2 = localObject1;
          n = m;
          k = j;
          localObject3 = localObject4;
        } while (paramInt1 != Atom.TYPE_ec_3);
        Object localObject2 = localObject1;
        int n = m;
        int k = j;
        Object localObject3 = localObject4;
      } while (i4 != Atom.TYPE_dec3);
      paramParsableByteArray.setPosition(i3 + 8);
      mediaFormat = Ac3Util.parseAnnexFEAc3Format(paramParsableByteArray);
      return;
    }
    if (localObject4 == null) {}
    for (paramParsableByteArray = null;; paramParsableByteArray = Collections.singletonList(localObject4))
    {
      mediaFormat = MediaFormat.createAudioFormat((String)localObject1, i1, paramLong, m, j, paramParsableByteArray);
      return;
    }
  }
  
  private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    paramParsableByteArray.setPosition(paramInt + 8 + 4);
    paramParsableByteArray.skipBytes(1);
    for (paramInt = paramParsableByteArray.readUnsignedByte(); paramInt > 127; paramInt = paramParsableByteArray.readUnsignedByte()) {}
    paramParsableByteArray.skipBytes(2);
    paramInt = paramParsableByteArray.readUnsignedByte();
    if ((paramInt & 0x80) != 0) {
      paramParsableByteArray.skipBytes(2);
    }
    if ((paramInt & 0x40) != 0) {
      paramParsableByteArray.skipBytes(paramParsableByteArray.readUnsignedShort());
    }
    if ((paramInt & 0x20) != 0) {
      paramParsableByteArray.skipBytes(2);
    }
    paramParsableByteArray.skipBytes(1);
    for (paramInt = paramParsableByteArray.readUnsignedByte(); paramInt > 127; paramInt = paramParsableByteArray.readUnsignedByte()) {}
    String str;
    switch (paramParsableByteArray.readUnsignedByte())
    {
    default: 
      str = null;
    }
    for (;;)
    {
      paramParsableByteArray.skipBytes(12);
      paramParsableByteArray.skipBytes(1);
      int i = paramParsableByteArray.readUnsignedByte();
      for (paramInt = i & 0x7F; i > 127; paramInt = paramInt << 8 | i & 0x7F) {
        i = paramParsableByteArray.readUnsignedByte();
      }
      return Pair.create("audio/mpeg", null);
      str = "video/mp4v-es";
      continue;
      str = "video/avc";
      continue;
      str = "video/hevc";
      continue;
      str = "audio/mp4a-latm";
      continue;
      str = "audio/ac3";
      continue;
      str = "audio/eac3";
    }
    byte[] arrayOfByte = new byte[paramInt];
    paramParsableByteArray.readBytes(arrayOfByte, 0, paramInt);
    return Pair.create(str, arrayOfByte);
  }
  
  private static Pair<List<byte[]>, Integer> parseHvcCFromParent(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    paramParsableByteArray.setPosition(paramInt + 8 + 21);
    int m = paramParsableByteArray.readUnsignedByte();
    int n = paramParsableByteArray.readUnsignedByte();
    paramInt = 0;
    int k = position;
    int i = 0;
    int i1;
    int j;
    int i2;
    while (i < n)
    {
      paramParsableByteArray.skipBytes(1);
      i1 = paramParsableByteArray.readUnsignedShort();
      j = 0;
      while (j < i1)
      {
        i2 = paramParsableByteArray.readUnsignedShort();
        paramInt += i2 + 4;
        paramParsableByteArray.skipBytes(i2);
        j += 1;
      }
      i += 1;
    }
    paramParsableByteArray.setPosition(k);
    byte[] arrayOfByte = new byte[paramInt];
    k = 0;
    i = 0;
    while (i < n)
    {
      paramParsableByteArray.skipBytes(1);
      i1 = paramParsableByteArray.readUnsignedShort();
      j = 0;
      while (j < i1)
      {
        i2 = paramParsableByteArray.readUnsignedShort();
        System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, arrayOfByte, k, NalUnitUtil.NAL_START_CODE.length);
        k += NalUnitUtil.NAL_START_CODE.length;
        System.arraycopy(data, position, arrayOfByte, k, i2);
        k += i2;
        paramParsableByteArray.skipBytes(i2);
        j += 1;
      }
      i += 1;
    }
    if (paramInt == 0) {}
    for (paramParsableByteArray = null;; paramParsableByteArray = Collections.singletonList(arrayOfByte)) {
      return Pair.create(paramParsableByteArray, Integer.valueOf((m & 0x3) + 1));
    }
  }
  
  private static TrackEncryptionBox parseSinfFromParent(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + 8;
    Object localObject = null;
    if (i - paramInt1 < paramInt2)
    {
      paramParsableByteArray.setPosition(i);
      int k = paramParsableByteArray.readInt();
      int j = paramParsableByteArray.readInt();
      if (j == Atom.TYPE_frma) {
        paramParsableByteArray.readInt();
      }
      label79:
      do
      {
        for (;;)
        {
          i += k;
          break;
          if (j != Atom.TYPE_schm) {
            break label79;
          }
          paramParsableByteArray.skipBytes(4);
          paramParsableByteArray.readInt();
          paramParsableByteArray.readInt();
        }
      } while (j != Atom.TYPE_schi);
      j = i + 8;
      label93:
      int m;
      boolean bool;
      if (j - i < k)
      {
        paramParsableByteArray.setPosition(j);
        m = paramParsableByteArray.readInt();
        if (paramParsableByteArray.readInt() == Atom.TYPE_tenc)
        {
          paramParsableByteArray.skipBytes(4);
          j = paramParsableByteArray.readInt();
          if (j >> 8 == 1)
          {
            bool = true;
            label147:
            localObject = new byte[16];
            paramParsableByteArray.readBytes((byte[])localObject, 0, 16);
          }
        }
      }
      for (localObject = new TrackEncryptionBox(bool, j & 0xFF, (byte[])localObject);; localObject = null)
      {
        break;
        bool = false;
        break label147;
        j += m;
        break label93;
      }
    }
    return (TrackEncryptionBox)localObject;
  }
  
  public static TrackSampleTable parseStbl(Track paramTrack, Atom.ContainerAtom paramContainerAtom)
  {
    ParsableByteArray localParsableByteArray1 = getLeafAtomOfTypeTYPE_stszdata;
    Object localObject2 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_stco);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_co64);
    }
    ParsableByteArray localParsableByteArray2 = data;
    ParsableByteArray localParsableByteArray3 = getLeafAtomOfTypeTYPE_stscdata;
    ParsableByteArray localParsableByteArray4 = getLeafAtomOfTypeTYPE_sttsdata;
    localObject2 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_stss);
    if (localObject2 != null)
    {
      localObject2 = data;
      paramContainerAtom = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_ctts);
      if (paramContainerAtom == null) {
        break label180;
      }
    }
    int i17;
    int i18;
    long[] arrayOfLong1;
    int[] arrayOfInt1;
    long[] arrayOfLong2;
    int[] arrayOfInt2;
    label180:
    for (paramContainerAtom = data;; paramContainerAtom = null)
    {
      localParsableByteArray1.setPosition(12);
      i17 = localParsableByteArray1.readUnsignedIntToInt();
      i18 = localParsableByteArray1.readUnsignedIntToInt();
      arrayOfLong1 = new long[i18];
      arrayOfInt1 = new int[i18];
      arrayOfLong2 = new long[i18];
      arrayOfInt2 = new int[i18];
      if (i18 != 0) {
        break label185;
      }
      return new TrackSampleTable(arrayOfLong1, arrayOfInt1, arrayOfLong2, arrayOfInt2);
      localObject2 = null;
      break;
    }
    label185:
    localParsableByteArray2.setPosition(12);
    int i19 = localParsableByteArray2.readUnsignedIntToInt();
    localParsableByteArray3.setPosition(12);
    int i5 = localParsableByteArray3.readUnsignedIntToInt() - 1;
    if (localParsableByteArray3.readInt() == 1) {}
    for (int i = 1; i == 0; i = 0) {
      throw new IllegalStateException(String.valueOf("stsc first chunk must be 1"));
    }
    int i2 = localParsableByteArray3.readUnsignedIntToInt();
    localParsableByteArray3.skipBytes(4);
    int k = -1;
    if (i5 > 0) {
      k = localParsableByteArray3.readUnsignedIntToInt() - 1;
    }
    int i7 = 0;
    int i4 = i2;
    localParsableByteArray4.setPosition(12);
    int i11 = localParsableByteArray4.readUnsignedIntToInt() - 1;
    int i6 = localParsableByteArray4.readUnsignedIntToInt();
    int i12 = localParsableByteArray4.readUnsignedIntToInt();
    int m = 0;
    int j = 0;
    i = 0;
    if (paramContainerAtom != null)
    {
      paramContainerAtom.setPosition(12);
      j = paramContainerAtom.readUnsignedIntToInt() - 1;
      m = paramContainerAtom.readUnsignedIntToInt();
      i = paramContainerAtom.readInt();
    }
    int n = -1;
    int i1 = 0;
    if (localObject2 != null)
    {
      ((ParsableByteArray)localObject2).setPosition(12);
      i1 = ((ParsableByteArray)localObject2).readUnsignedIntToInt();
      n = ((ParsableByteArray)localObject2).readUnsignedIntToInt() - 1;
    }
    long l1;
    long l2;
    int i8;
    int i3;
    int i15;
    int i10;
    int i14;
    label444:
    label470:
    label496:
    long l3;
    int i9;
    int i13;
    label740:
    int i16;
    if (type == Atom.TYPE_stco)
    {
      l1 = localParsableByteArray2.readUnsignedInt();
      l2 = 0L;
      i8 = 0;
      i3 = i;
      i = i2;
      i2 = j;
      i15 = i1;
      j = i5;
      i1 = i4;
      i10 = m;
      m = i6;
      i14 = n;
      i4 = i8;
      if (i4 >= i18) {
        break label948;
      }
      arrayOfLong1[i4] = l1;
      if (i17 != 0) {
        break label908;
      }
      n = localParsableByteArray1.readUnsignedIntToInt();
      arrayOfInt1[i4] = n;
      arrayOfLong2[i4] = (i3 + l2);
      if (localObject2 != null) {
        break label915;
      }
      n = 1;
      arrayOfInt2[i4] = n;
      i6 = i14;
      i5 = i15;
      if (i4 == i14)
      {
        arrayOfInt2[i4] = 1;
        n = i15 - 1;
        i6 = i14;
        i5 = n;
        if (n > 0)
        {
          i6 = ((ParsableByteArray)localObject2).readUnsignedIntToInt() - 1;
          i5 = n;
        }
      }
      l3 = l2 + i12;
      n = m - 1;
      m = n;
      i9 = i11;
      i8 = i12;
      if (n == 0)
      {
        m = n;
        i9 = i11;
        i8 = i12;
        if (i11 > 0)
        {
          m = localParsableByteArray4.readUnsignedIntToInt();
          i8 = localParsableByteArray4.readUnsignedIntToInt();
          i9 = i11 - 1;
        }
      }
      n = i10;
      i12 = i2;
      i13 = i3;
      if (paramContainerAtom != null)
      {
        i10 -= 1;
        n = i10;
        i12 = i2;
        i13 = i3;
        if (i10 == 0)
        {
          n = i10;
          i12 = i2;
          i13 = i3;
          if (i2 > 0)
          {
            n = paramContainerAtom.readUnsignedIntToInt();
            i13 = paramContainerAtom.readInt();
            i12 = i2 - 1;
          }
        }
      }
      i2 = i1 - 1;
      if (i2 != 0) {
        break label931;
      }
      i10 = i7 + 1;
      if (i10 < i19)
      {
        if (type != Atom.TYPE_stco) {
          break label921;
        }
        l1 = localParsableByteArray2.readUnsignedInt();
      }
      i3 = k;
      i1 = j;
      if (i10 == k)
      {
        i7 = localParsableByteArray3.readUnsignedIntToInt();
        localParsableByteArray3.skipBytes(4);
        j -= 1;
        i3 = k;
        i1 = j;
        i = i7;
        if (j > 0)
        {
          i3 = localParsableByteArray3.readUnsignedIntToInt() - 1;
          i = i7;
          i1 = j;
        }
      }
      i7 = i10;
      k = i3;
      l2 = l1;
      j = i1;
      i16 = i;
      if (i10 < i19)
      {
        i2 = i;
        i16 = i;
        j = i1;
        l2 = l1;
        k = i3;
        i7 = i10;
      }
    }
    for (;;)
    {
      i4 += 1;
      i14 = i6;
      l1 = l2;
      i10 = n;
      i1 = i2;
      i15 = i5;
      i11 = i9;
      i2 = i12;
      i = i16;
      i12 = i8;
      i3 = i13;
      l2 = l3;
      break label444;
      l1 = localParsableByteArray2.readUnsignedLongToLong();
      break;
      label908:
      n = i17;
      break label470;
      label915:
      n = 0;
      break label496;
      label921:
      l1 = localParsableByteArray2.readUnsignedLongToLong();
      break label740;
      label931:
      l2 = l1 + arrayOfInt1[i4];
      i16 = i;
    }
    label948:
    Util.scaleLargeTimestampsInPlace$1c88337c(arrayOfLong2, timescale);
    if (i15 == 0)
    {
      bool = true;
      Assertions.checkArgument(bool);
      if (m != 0) {
        break label1044;
      }
      bool = true;
      label978:
      Assertions.checkArgument(bool);
      if (i1 != 0) {
        break label1050;
      }
      bool = true;
      label991:
      Assertions.checkArgument(bool);
      if (i11 != 0) {
        break label1056;
      }
      bool = true;
      label1004:
      Assertions.checkArgument(bool);
      if (i2 != 0) {
        break label1062;
      }
    }
    label1044:
    label1050:
    label1056:
    label1062:
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      return new TrackSampleTable(arrayOfLong1, arrayOfInt1, arrayOfLong2, arrayOfInt2);
      bool = false;
      break;
      bool = false;
      break label978;
      bool = false;
      break label991;
      bool = false;
      break label1004;
    }
  }
  
  public static Track parseTrak(Atom.ContainerAtom paramContainerAtom, Atom.LeafAtom paramLeafAtom)
  {
    Object localObject1 = paramContainerAtom.getContainerAtomOfType(Atom.TYPE_mdia);
    Object localObject2 = getLeafAtomOfTypeTYPE_hdlrdata;
    ((ParsableByteArray)localObject2).setPosition(16);
    int n = ((ParsableByteArray)localObject2).readInt();
    if ((n != Track.TYPE_AUDIO) && (n != Track.TYPE_VIDEO) && (n != Track.TYPE_TEXT) && (n != Track.TYPE_SUBTITLE)) {
      return null;
    }
    paramContainerAtom = getLeafAtomOfTypeTYPE_tkhddata;
    paramContainerAtom.setPosition(8);
    int i1 = Atom.parseFullAtomVersion(paramContainerAtom.readInt());
    int i;
    int i2;
    int m;
    int i3;
    label136:
    int j;
    label139:
    long l1;
    label181:
    label243:
    long l2;
    label268:
    label314:
    ParsableByteArray localParsableByteArray;
    StsdDataHolder localStsdDataHolder;
    label392:
    int i4;
    int i5;
    float f;
    int i6;
    label572:
    int i7;
    if (i1 == 0)
    {
      i = 8;
      paramContainerAtom.skipBytes(i);
      i2 = paramContainerAtom.readInt();
      paramContainerAtom.skipBytes(4);
      m = 1;
      i3 = position;
      if (i1 != 0) {
        break label653;
      }
      i = 4;
      j = 0;
      k = m;
      if (j < i)
      {
        if (data[(i3 + j)] == -1) {
          break label659;
        }
        k = 0;
      }
      if (k == 0) {
        break label668;
      }
      paramContainerAtom.skipBytes(i);
      l1 = -1L;
      paramContainerAtom = Pair.create(Integer.valueOf(i2), Long.valueOf(l1));
      m = ((Integer)first).intValue();
      l1 = ((Long)second).longValue();
      paramContainerAtom = data;
      paramContainerAtom.setPosition(8);
      if (Atom.parseFullAtomVersion(paramContainerAtom.readInt()) != 0) {
        break label691;
      }
      i = 8;
      paramContainerAtom.skipBytes(i);
      l2 = paramContainerAtom.readUnsignedInt();
      if (l1 != -1L) {
        break label697;
      }
      l1 = -1L;
      paramContainerAtom = ((Atom.ContainerAtom)localObject1).getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
      paramLeafAtom = getLeafAtomOfTypeTYPE_mdhddata;
      paramLeafAtom.setPosition(8);
      if (Atom.parseFullAtomVersion(paramLeafAtom.readInt()) != 0) {
        break label712;
      }
      i = 8;
      paramLeafAtom.skipBytes(i);
      l2 = paramLeafAtom.readUnsignedInt();
      localParsableByteArray = getLeafAtomOfTypeTYPE_stsddata;
      localParsableByteArray.setPosition(12);
      i1 = localParsableByteArray.readInt();
      localStsdDataHolder = new StsdDataHolder(i1);
      i = 0;
      if (i >= i1) {
        break label1254;
      }
      i2 = position;
      i3 = localParsableByteArray.readInt();
      if (i3 <= 0) {
        break label718;
      }
      bool = true;
      Assertions.checkArgument(bool, "childAtomSize should be positive");
      j = localParsableByteArray.readInt();
      if ((j != Atom.TYPE_avc1) && (j != Atom.TYPE_avc3) && (j != Atom.TYPE_encv) && (j != Atom.TYPE_mp4v) && (j != Atom.TYPE_hvc1) && (j != Atom.TYPE_hev1) && (j != Atom.TYPE_s263)) {
        break label1163;
      }
      localParsableByteArray.setPosition(i2 + 8);
      localParsableByteArray.skipBytes(24);
      i4 = localParsableByteArray.readUnsignedShort();
      i5 = localParsableByteArray.readUnsignedShort();
      f = 1.0F;
      localParsableByteArray.skipBytes(50);
      localObject1 = null;
      j = position;
      localObject2 = null;
      if (j - i2 >= i3) {
        break label1121;
      }
      localParsableByteArray.setPosition(j);
      k = position;
      i6 = localParsableByteArray.readInt();
      if ((i6 == 0) && (position - i2 == i3)) {
        break label1121;
      }
      if (i6 <= 0) {
        break label724;
      }
      bool = true;
      Assertions.checkArgument(bool, "childAtomSize should be positive");
      i7 = localParsableByteArray.readInt();
      if (i7 != Atom.TYPE_avcC) {
        break label875;
      }
      if (localObject2 != null) {
        break label730;
      }
    }
    label653:
    label659:
    label668:
    label691:
    label697:
    label712:
    label718:
    label724:
    label730:
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      paramContainerAtom = "video/avc";
      localParsableByteArray.setPosition(k + 8 + 4);
      i7 = (localParsableByteArray.readUnsignedByte() & 0x3) + 1;
      if (i7 != 3) {
        break label736;
      }
      throw new IllegalStateException();
      i = 16;
      break;
      i = 8;
      break label136;
      j += 1;
      break label139;
      if (i1 == 0)
      {
        l1 = paramContainerAtom.readUnsignedInt();
        break label181;
      }
      l1 = paramContainerAtom.readUnsignedLongToLong();
      break label181;
      i = 16;
      break label243;
      l1 = Util.scaleLargeTimestamp(l1, 1000000L, l2);
      break label268;
      i = 16;
      break label314;
      bool = false;
      break label392;
      bool = false;
      break label572;
    }
    label736:
    paramLeafAtom = new ArrayList();
    int i8 = localParsableByteArray.readUnsignedByte();
    int k = 0;
    while (k < (i8 & 0x1F))
    {
      paramLeafAtom.add(NalUnitUtil.parseChildNalUnit(localParsableByteArray));
      k += 1;
    }
    i8 = localParsableByteArray.readUnsignedByte();
    k = 0;
    while (k < i8)
    {
      paramLeafAtom.add(NalUnitUtil.parseChildNalUnit(localParsableByteArray));
      k += 1;
    }
    localObject1 = Pair.create(paramLeafAtom, Integer.valueOf(i7));
    paramLeafAtom = (List)first;
    nalUnitLengthFieldLength = ((Integer)second).intValue();
    for (;;)
    {
      j += i6;
      localObject2 = paramContainerAtom;
      localObject1 = paramLeafAtom;
      break;
      label875:
      if (i7 == Atom.TYPE_hvcC)
      {
        if (localObject2 == null) {}
        for (bool = true;; bool = false)
        {
          Assertions.checkState(bool);
          paramContainerAtom = "video/hevc";
          localObject1 = parseHvcCFromParent(localParsableByteArray, k);
          paramLeafAtom = (List)first;
          nalUnitLengthFieldLength = ((Integer)second).intValue();
          break;
        }
      }
      if (i7 == Atom.TYPE_d263)
      {
        if (localObject2 == null) {}
        for (bool = true;; bool = false)
        {
          Assertions.checkState(bool);
          paramContainerAtom = "video/3gpp";
          paramLeafAtom = (Atom.LeafAtom)localObject1;
          break;
        }
      }
      if (i7 == Atom.TYPE_esds)
      {
        if (localObject2 == null) {}
        for (bool = true;; bool = false)
        {
          Assertions.checkState(bool);
          paramLeafAtom = parseEsdsFromParent(localParsableByteArray, k);
          paramContainerAtom = (String)first;
          paramLeafAtom = Collections.singletonList(second);
          break;
        }
      }
      if (i7 == Atom.TYPE_sinf)
      {
        trackEncryptionBoxes[i] = parseSinfFromParent(localParsableByteArray, k, i6);
        paramContainerAtom = (Atom.ContainerAtom)localObject2;
        paramLeafAtom = (Atom.LeafAtom)localObject1;
      }
      else
      {
        paramContainerAtom = (Atom.ContainerAtom)localObject2;
        paramLeafAtom = (Atom.LeafAtom)localObject1;
        if (i7 == Atom.TYPE_pasp)
        {
          localParsableByteArray.setPosition(k + 8);
          k = localParsableByteArray.readUnsignedIntToInt();
          i7 = localParsableByteArray.readUnsignedIntToInt();
          f = k / i7;
          paramContainerAtom = (Atom.ContainerAtom)localObject2;
          paramLeafAtom = (Atom.LeafAtom)localObject1;
        }
      }
    }
    label1121:
    if (localObject2 != null) {
      mediaFormat = MediaFormat.createVideoFormat((String)localObject2, -1, l1, i4, i5, f, (List)localObject1);
    }
    for (;;)
    {
      localParsableByteArray.setPosition(i2 + i3);
      i += 1;
      break;
      label1163:
      if ((j == Atom.TYPE_mp4a) || (j == Atom.TYPE_enca) || (j == Atom.TYPE_ac_3)) {
        parseAudioSampleEntry(localParsableByteArray, j, i2, i3, l1, localStsdDataHolder, i);
      } else if (j == Atom.TYPE_TTML) {
        mediaFormat = MediaFormat.createTextFormat("application/ttml+xml", l1);
      } else if (j == Atom.TYPE_tx3g) {
        mediaFormat = MediaFormat.createTextFormat("application/x-quicktime-tx3g", l1);
      }
    }
    label1254:
    if (mediaFormat == null) {
      return null;
    }
    return new Track(m, n, l2, l1, mediaFormat, trackEncryptionBoxes, nalUnitLengthFieldLength);
  }
  
  private static final class StsdDataHolder
  {
    public MediaFormat mediaFormat;
    public int nalUnitLengthFieldLength;
    public final TrackEncryptionBox[] trackEncryptionBoxes;
    
    public StsdDataHolder(int paramInt)
    {
      trackEncryptionBoxes = new TrackEncryptionBox[paramInt];
      nalUnitLengthFieldLength = -1;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp4.AtomParsers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */