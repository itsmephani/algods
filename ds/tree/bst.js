class Node {
  constructor(data, left, right) {
    this.data = data;
    this.left = left;
    this.right = right;    
  }
}

class BST {
  constructor() {
    this.root = null;
  }

  add(data) {
    if (this.root == null) {
      this.root = new Node(data);
    } else {
      const addNode = (data, root) => {
        if (data < root.data) {
          if (!root.left){
            root.left = new Node(data);
          } else {
            addNode(data, root.left);
          }
    
          return;
        }
    
        if (data > root.data) {
          if (!root.right){
            root.right = new Node(data);
          } else {
            addNode(data, root.right);
          }
    
          return;
        }
      };

      addNode(data, this.root);
    }
  }
}


const bst = new BST();

bst.add(4);
bst.add(3);
bst.add(5);
// bst.add(1);
// bst.add(14);
// bst.add(13);
// bst.add(15);
// bst.add(11);

console.clear();
console.log(bst.root);
