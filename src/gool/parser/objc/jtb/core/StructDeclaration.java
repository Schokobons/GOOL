/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.core;

import gool.parser.objc.jtb.visitor.*;

public class StructDeclaration implements INode {

  public SpecifierQualifierList f0;

  public NodeChoice f1;

  public NodeToken f2;

  private static final long serialVersionUID = 144L;

  public StructDeclaration(final SpecifierQualifierList n0, final NodeChoice n1, final NodeToken n2) {
    f0 = n0;
    f1 = n1;
    f2 = n2;
  }

  public StructDeclaration(final SpecifierQualifierList n0, final NodeChoice n1) {
    f0 = n0;
    f1 = n1;
    f2 = new NodeToken(";");
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }
}
