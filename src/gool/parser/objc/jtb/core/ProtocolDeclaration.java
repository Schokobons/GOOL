/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.core;

import gool.parser.objc.jtb.visitor.*;

public class ProtocolDeclaration implements INode {

  public NodeToken f0;

  public ProtocolList f1;

  public NodeOptional f2;

  public ProtocolInterfaceDeclaration f3;

  public NodeChoice f4;

  private static final long serialVersionUID = 144L;

  public ProtocolDeclaration(final NodeToken n0, final ProtocolList n1, final NodeOptional n2, final ProtocolInterfaceDeclaration n3, final NodeChoice n4) {
    f0 = n0;
    f1 = n1;
    f2 = n2;
    f3 = n3;
    f4 = n4;
  }

  public ProtocolDeclaration(final ProtocolList n0, final NodeOptional n1, final ProtocolInterfaceDeclaration n2, final NodeChoice n3) {
    f0 = new NodeToken("@protocol");
    f1 = n0;
    f2 = n1;
    f3 = n2;
    f4 = n3;
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }

  public <R> R accept(final IRetVisitor<R> vis) {
    return vis.visit(this);
  }

  public <A> void accept(final IVoidArguVisitor<A> vis, final A argu) {
    vis.visit(this, argu);
  }

  public void accept(final IVoidVisitor vis) {
    vis.visit(this);
  }

}