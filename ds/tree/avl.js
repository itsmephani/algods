class Node {
  constructor(data, parent, left, right) {
    this.data = data;
    this.parent = parent;
    this.left = left;
    this.right = right;
    this.rightHeight = 0;
    this.leftHeight = 0;
  }

  getBalance() {
    return this.rightHeight - this.leftHeight;
  }
}

class AVL {
  constructor() {
    this.root = null;
  }

  add(data) {
    if (this.root == null) {
      this.root = new Node(data);
    } else {
      const addNode = (data, root) => {
        if (data < root.data) {
          root.leftHeight++;
          if (!root.left) {
            root.left = new Node(data, root);
            this.checkBalance(root.left);
          } else {
            addNode(data, root.left);
          }
    
          return;
        }
    
        if (data > root.data) {
          root.rightHeight++;
          if (!root.right){
            root.right = new Node(data, root);
            this.checkBalance(root.right);
          } else {
            addNode(data, root.right);
          }
    
          return;
        }
      };

      addNode(data, this.root);
    }
  }

  checkBalance(node) {
    console.log(node.getBalance());
    if ( Math.abs(node.getBalance()) > 1) {
      this.rebalance(node);
    }

    if (!node.parent) return;

    this.checkBalance(node.parent);
  }

  rebalance(node) {
    if (node.getBalance() < -1) {
      if (node.left.getBalance() <= -1) {
        return this.rightRotate(node);
      } else {
        return this.leftRightRotate(node);
      }
    }

    if (node.getBalance() > 1) {
      if (node.left.getBalance() >= 1) {
        return this.rightRotate(node);
      } else {
        return this.leftRightRotate(node);
      }
    }
  }

  rightRotate(node) {
    console.log('right rotate');
    const data = node.data;
    node.data = node.left.data;
    node.left.data = data;
    node.right = node.left;    
    node.left.left.parent = node;
    node.left = node.left.left;
  }

  leftRotate(node) {
    console.log('left rotate');
    console.log(node);
  }

  rightLeftRotate(node) {
    console.log('right left rotate');
    console.log(node);
  }

  leftRightRotate(node) {
    console.log('left right rotate');
    const data = node.left.data;
    node.left.data = node.left.right.data;
    node.left.left = node.left.right;
    node.left.right = undefined;
    node.left.left.data = data;

    this.rightRotate(node);
  }
}

console.clear();
const avl = new AVL();

// Right rotate.
// avl.add(4);
// avl.add(3);
// avl.add(1);

// left right rotate
avl.add(20);
avl.add(10);
avl.add(15);

console.log(avl.root);
