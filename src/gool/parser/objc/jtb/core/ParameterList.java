/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.core;

import gool.parser.objc.jtb.visitor.*;

public class ParameterList implements INode {

  public ParameterDeclaration f0;

  public NodeListOptional f1;

  private static final long serialVersionUID = 144L;

  public ParameterList(final ParameterDeclaration n0, final NodeListOptional n1) {
    f0 = n0;
    f1 = n1;
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }
}
