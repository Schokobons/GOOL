/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.core;

import gool.parser.objc.jtb.visitor.*;

public class TypedefName implements INode {

  public ObjCIDENT f0;

  private static final long serialVersionUID = 144L;

  public TypedefName(final ObjCIDENT n0) {
    f0 = n0;
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }
}
