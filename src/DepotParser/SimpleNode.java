package DepotParser;
/* Generated By:JJTree: Do not edit this line. SimpleNode.java Version 4.3 */

public
class SimpleNode implements Node {

  protected Node parent;
  protected Node[] children;
  protected int id;
  protected Object value;
  protected ObjCParser parser;
  protected String name;

  public void setName(String n) {
	  name = n;
  }
  
  public String getName() {
	  return name;
  }
  
  public SimpleNode(int i, String n) {
	  name = n;
	  id = i;
  }
  
  public SimpleNode(int i) {
	  name = "";
	  id = i;
  }

  public SimpleNode(ObjCParser p, int i, String n) {
    this(i, n);
    parser = p;
  }

  public void jjtOpen() {
  }

  public void jjtClose() {
  }

  public void jjtSetParent(Node n) { parent = n; }
  public Node jjtGetParent() { return parent; }

  public void jjtAddChild(Node n, int i) {
    if (children == null) {
      children = new Node[i + 1];
    } else if (i >= children.length) {
      Node c[] = new Node[i + 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = n;
  }

	public void jjtRemoveChild(int i) {
		Node c[] = new Node[children.length-1];
		for(int j = 0; j < i; j++)
			c[j] = children[j];
		for(int j = i+1; j < children.length; j++)
			c[j-1] = children[j];
	}

  public Node jjtGetChild(int i) {
    return children[i];
  }

  public int jjtGetNumChildren() {
    return (children == null) ? 0 : children.length;
  }

  public void jjtSetValue(Object value) { this.value = value; }
  public Object jjtGetValue() { return value; }

  /* You can override these two methods in subclasses of SimpleNode to
     customize the way the node appears when the tree is dumped.  If
     your output uses more than one line you should override
     toString(String), otherwise overriding toString() is probably all
     you need to do. */

  public String toString() { 
	  if(name == null ||name.length() == 0)
		  return ObjCParserTreeConstants.jjtNodeName[id];
	  return ObjCParserTreeConstants.jjtNodeName[id] + " et son nom est : " + name;
  }
  public String toString(String prefix) { return prefix + toString(); }

  /* Override this method if you want to customize how the node dumps
     out its children. */

  public void dump(String prefix) {
    System.out.println(toString(prefix));
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        SimpleNode n = (SimpleNode)children[i];
        if (n != null) {
          n.dump(prefix + " ");
        }
      }
    }
  }
}

/* JavaCC - OriginalChecksum=ebae18f199e9a3ac57cebec3aa29d92a (do not edit this line) */