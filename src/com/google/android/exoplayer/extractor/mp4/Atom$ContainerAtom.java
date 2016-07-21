package com.google.android.exoplayer.extractor.mp4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class Atom$ContainerAtom
  extends Atom
{
  public final List<ContainerAtom> containerChildren;
  public final long endPosition;
  public final List<Atom.LeafAtom> leafChildren;
  
  public Atom$ContainerAtom(int paramInt, long paramLong)
  {
    super(paramInt);
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

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp4.Atom.ContainerAtom
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */