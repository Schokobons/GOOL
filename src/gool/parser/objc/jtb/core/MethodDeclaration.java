/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.core;

import gool.parser.objc.jtb.visitor.*;

public class MethodDeclaration implements INode {

  public NodeChoice f0;

  private static final long serialVersionUID = 144L;

  public MethodDeclaration(final NodeChoice n0) {
    f0 = n0;
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }
}
