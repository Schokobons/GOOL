/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.core;

import gool.parser.objc.jtb.visitor.*;

public class PropertyAttributesList implements INode {

  public PropertyAttribute f0;

  public NodeOptional f1;

  private static final long serialVersionUID = 144L;

  public PropertyAttributesList(final PropertyAttribute n0, final NodeOptional n1) {
    f0 = n0;
    f1 = n1;
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }
}
