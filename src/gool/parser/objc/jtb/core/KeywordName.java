/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.core;

import gool.parser.objc.jtb.visitor.*;

public class KeywordName implements INode {

  public NodeOptional f0;

  public NodeToken f1;

  private static final long serialVersionUID = 144L;

  public KeywordName(final NodeOptional n0, final NodeToken n1) {
    f0 = n0;
    f1 = n1;
  }

  public KeywordName(final NodeOptional n0) {
    f0 = n0;
    f1 = new NodeToken(":");
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }
}
