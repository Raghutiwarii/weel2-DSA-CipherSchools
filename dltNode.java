import java.util.LinkedList;
import java.util.Queue;

class dltNode {
	static class Node {
		int data;
		Node left, right;

		public Node(int key) { this.data = key; }
	}

	static void inorder(Node root)
	{
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	static Node deletion(Node root, int key)
	{
		if (root == null)
			return null;

		if (root.left == null && root.right == null) {
			return root.data == key ? root : null;
		}

		Node keyNode = null, temp = null, last = null;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			temp = q.poll();

			if (temp.data == key)
				keyNode = temp;

			if (temp.left != null) {
				last = temp; // storing the parent node
				q.offer(temp.left);
			}

			if (temp.right != null) {
				last = temp; // storing the parent node
				q.offer(temp.right);
			}
		}

		if (keyNode != null) {
			keyNode.data
				= temp.data; // replacing key_node's data to
					

			if (last.right == temp) {
				last.right = null;
			}
			else {
				last.left = null;
			}
		}

		return root;
	}

	public static void main(String args[])
	{
		Node root = new Node(9);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(7);
		root.right = new Node(8);

		System.out.print(
			"Inorder traversal before deletion : ");
		inorder(root);
		System.out.println();

		int key = 7;
		root = deletion(root, key);

		System.out.print(
			"Inorder traversal after deletion : ");
		inorder(root);
		System.out.println();
	}
}
