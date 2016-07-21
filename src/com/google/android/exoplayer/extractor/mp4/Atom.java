package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Atom
{
  public static final int TYPE_TTML;
  public static final int TYPE_ac_3;
  public static final int TYPE_avc1;
  public static final int TYPE_avc3;
  public static final int TYPE_avcC;
  public static final int TYPE_co64 = Util.getIntegerCodeForString("co64");
  public static final int TYPE_ctts;
  public static final int TYPE_d263;
  public static final int TYPE_dac3;
  public static final int TYPE_dec3;
  public static final int TYPE_ec_3;
  public static final int TYPE_enca;
  public static final int TYPE_encv;
  public static final int TYPE_esds;
  public static final int TYPE_frma;
  public static final int TYPE_ftyp = Util.getIntegerCodeForString("ftyp");
  public static final int TYPE_hdlr;
  public static final int TYPE_hev1;
  public static final int TYPE_hvc1;
  public static final int TYPE_hvcC;
  public static final int TYPE_mdat;
  public static final int TYPE_mdhd;
  public static final int TYPE_mdia;
  public static final int TYPE_minf;
  public static final int TYPE_moof;
  public static final int TYPE_moov;
  public static final int TYPE_mp4a;
  public static final int TYPE_mp4v;
  public static final int TYPE_mvex;
  public static final int TYPE_mvhd;
  public static final int TYPE_pasp;
  public static final int TYPE_pssh;
  public static final int TYPE_s263;
  public static final int TYPE_saiz;
  public static final int TYPE_schi;
  public static final int TYPE_schm;
  public static final int TYPE_senc;
  public static final int TYPE_sidx;
  public static final int TYPE_sinf;
  public static final int TYPE_smhd;
  public static final int TYPE_stbl;
  public static final int TYPE_stco;
  public static final int TYPE_stsc;
  public static final int TYPE_stsd;
  public static final int TYPE_stss;
  public static final int TYPE_stsz;
  public static final int TYPE_stts;
  public static final int TYPE_tenc;
  public static final int TYPE_tfdt;
  public static final int TYPE_tfhd;
  public static final int TYPE_tkhd;
  public static final int TYPE_traf;
  public static final int TYPE_trak;
  public static final int TYPE_trex;
  public static final int TYPE_trun;
  public static final int TYPE_tx3g = Util.getIntegerCodeForString("tx3g");
  public static final int TYPE_uuid;
  public static final int TYPE_vmhd;
  public final int type;
  
  static
  {
    TYPE_avc1 = Util.getIntegerCodeForString("avc1");
    TYPE_avc3 = Util.getIntegerCodeForString("avc3");
    TYPE_hvc1 = Util.getIntegerCodeForString("hvc1");
    TYPE_hev1 = Util.getIntegerCodeForString("hev1");
    TYPE_s263 = Util.getIntegerCodeForString("s263");
    TYPE_d263 = Util.getIntegerCodeForString("d263");
    TYPE_mdat = Util.getIntegerCodeForString("mdat");
    TYPE_mp4a = Util.getIntegerCodeForString("mp4a");
    TYPE_ac_3 = Util.getIntegerCodeForString("ac-3");
    TYPE_dac3 = Util.getIntegerCodeForString("dac3");
    TYPE_ec_3 = Util.getIntegerCodeForString("ec-3");
    TYPE_dec3 = Util.getIntegerCodeForString("dec3");
    TYPE_tfdt = Util.getIntegerCodeForString("tfdt");
    TYPE_tfhd = Util.getIntegerCodeForString("tfhd");
    TYPE_trex = Util.getIntegerCodeForString("trex");
    TYPE_trun = Util.getIntegerCodeForString("trun");
    TYPE_sidx = Util.getIntegerCodeForString("sidx");
    TYPE_moov = Util.getIntegerCodeForString("moov");
    TYPE_mvhd = Util.getIntegerCodeForString("mvhd");
    TYPE_trak = Util.getIntegerCodeForString("trak");
    TYPE_mdia = Util.getIntegerCodeForString("mdia");
    TYPE_minf = Util.getIntegerCodeForString("minf");
    TYPE_stbl = Util.getIntegerCodeForString("stbl");
    TYPE_avcC = Util.getIntegerCodeForString("avcC");
    TYPE_hvcC = Util.getIntegerCodeForString("hvcC");
    TYPE_esds = Util.getIntegerCodeForString("esds");
    TYPE_moof = Util.getIntegerCodeForString("moof");
    TYPE_traf = Util.getIntegerCodeForString("traf");
    TYPE_mvex = Util.getIntegerCodeForString("mvex");
    TYPE_tkhd = Util.getIntegerCodeForString("tkhd");
    TYPE_mdhd = Util.getIntegerCodeForString("mdhd");
    TYPE_hdlr = Util.getIntegerCodeForString("hdlr");
    TYPE_stsd = Util.getIntegerCodeForString("stsd");
    TYPE_pssh = Util.getIntegerCodeForString("pssh");
    TYPE_sinf = Util.getIntegerCodeForString("sinf");
    TYPE_schm = Util.getIntegerCodeForString("schm");
    TYPE_schi = Util.getIntegerCodeForString("schi");
    TYPE_tenc = Util.getIntegerCodeForString("tenc");
    TYPE_encv = Util.getIntegerCodeForString("encv");
    TYPE_enca = Util.getIntegerCodeForString("enca");
    TYPE_frma = Util.getIntegerCodeForString("frma");
    TYPE_saiz = Util.getIntegerCodeForString("saiz");
    TYPE_uuid = Util.getIntegerCodeForString("uuid");
    TYPE_senc = Util.getIntegerCodeForString("senc");
    TYPE_pasp = Util.getIntegerCodeForString("pasp");
    TYPE_TTML = Util.getIntegerCodeForString("TTML");
    TYPE_vmhd = Util.getIntegerCodeForString("vmhd");
    TYPE_smhd = Util.getIntegerCodeForString("smhd");
    TYPE_mp4v = Util.getIntegerCodeForString("mp4v");
    TYPE_stts = Util.getIntegerCodeForString("stts");
    TYPE_stss = Util.getIntegerCodeForString("stss");
    TYPE_ctts = Util.getIntegerCodeForString("ctts");
    TYPE_stsc = Util.getIntegerCodeForString("stsc");
    TYPE_stsz = Util.getIntegerCodeForString("stsz");
    TYPE_stco = Util.getIntegerCodeForString("stco");
  }
  
  public Atom(int paramInt)
  {
    type = paramInt;
  }
  
  public static String getAtomTypeString(int paramInt)
  {
    return (char)(paramInt >> 24) + (char)(paramInt >> 16 & 0xFF) + (char)(paramInt >> 8 & 0xFF) + (char)(paramInt & 0xFF);
  }
  
  public static int parseFullAtomFlags(int paramInt)
  {
    return 0xFFFFFF & paramInt;
  }
  
  public static int parseFullAtomVersion(int paramInt)
  {
    return paramInt >> 24 & 0xFF;
  }
  
  public String toString()
  {
    return getAtomTypeString(type);
  }
  
  static final class ContainerAtom
    extends Atom
  {
    public final List<ContainerAtom> containerChildren;
    public final long endPosition;
    public final List<Atom.LeafAtom> leafChildren;
    
    public ContainerAtom(int paramInt, long paramLong)
    {
      super();
      endPosition = paramLong;
      leafChildren = new ArrayList();
      containerChildren = new ArrayList();
    }
    
    public final void add(ContainerAtom paramContainerAtom)
    {
      containerChildren.add(paramContainerAtom);
    }
    
    public final void add(Atom.LeafAtom paramLeafAtom)
    {
      leafChildren.add(paramLeafAtom);
    }
    
    public final ContainerAtom getContainerAtomOfType(int paramInt)
    {
      int j = containerChildren.size();
      int i = 0;
      while (i < j)
      {
        ContainerAtom localContainerAtom = (ContainerAtom)containerChildren.get(i);
        if (type == paramInt) {
          return localContainerAtom;
        }
        i += 1;
      }
      return null;
    }
    
    public final Atom.LeafAtom getLeafAtomOfType(int paramInt)
    {
      int j = leafChildren.size();
      int i = 0;
      while (i < j)
      {
        Atom.LeafAtom localLeafAtom = (Atom.LeafAtom)leafChildren.get(i);
        if (type == paramInt) {
          return localLeafAtom;
        }
        i += 1;
      }
      return null;
    }
    
    public final String toString()
    {
      return getAtomTypeString(type) + " leaves: " + Arrays.toString(leafChildren.toArray(new Atom.LeafAtom[0])) + " containers: " + Arrays.toString(containerChildren.toArray(new ContainerAtom[0]));
    }
  }
  
  static final class LeafAtom
    extends Atom
  {
    public final ParsableByteArray data;
    
    public LeafAtom(int paramInt, ParsableByteArray paramParsableByteArray)
    {
      super();
      data = paramParsableByteArray;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp4.Atom
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */