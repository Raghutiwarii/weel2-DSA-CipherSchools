import java.io.*;

class Solution
{
static class newNode{
	public int key;
	public newNode right,left;
	public newNode(int k){
		this.key = k;
		this.right = this.left = null;
	}
};

static int getHeight(newNode root) {
	if (root == null) return 0;
	else if (root.left == null && root.right == null) return 1; 

	int lHeight = height(root.left); 
	int rHeight = height(root.right); 
	return 1 + Math.max(lHeight, rHeight);
}

static int getLength(newNode root){
	if(root == null)
		return 0;
	return 1 + getLength(root.left) + getLength(root.right);
}

static boolean isPerfect(newNode root){
	int length = getLength(root);
	int height = getHeight(root);
	return length + 1 == (int)Math.pow(2, height);
}
