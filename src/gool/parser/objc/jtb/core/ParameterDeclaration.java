/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.core;

import gool.parser.objc.jtb.visitor.*;

public class ParameterDeclaration implements INode {

  public DeclarationSpecifiers f0;

  public NodeChoice f1;

  private static final long serialVersionUID = 144L;

  public ParameterDeclaration(final DeclarationSpecifiers n0, final NodeChoice n1) {
    f0 = n0;
    f1 = n1;
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }
}
