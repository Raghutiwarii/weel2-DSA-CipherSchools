
import java.util.ArrayDeque;
import java.util.Queue;

public class isFullBinaryTree
{

static class Node {
	int data;
	Node left, right;

	Node(int item)
	{
	data = item;
	left = right = null;
	}
}

static boolean isleafnode(Node root)
{
	return root.left == null && root.right == null;
}

static boolean isFullTree(Node root)
{

	if (root == null)
	return true;

	Queue<Node> q = new ArrayDeque<>();
	q.add(root);

	while (!q.isEmpty()) {

	root = q.peek();
	q.remove();

	if (root == null)
		return false;

	if (!isleafnode(root)) {
		q.add(root.left);
		q.add(root.right);
	}
	}

	return true;
}

// Driver Code
public static void main(String[] args)
{
	Node root = new Node(1);
	root.left = new Node(2);
	root.right = new Node(3);
	root.left.left = new Node(4);
	root.left.right = new Node(5);

	if (isFullTree(root))
	System.out.println("The Binary Tree is full");
	else
	System.out.println(
	"The Binary Tree is not full");
}
}

