class Node {
    constructor(data){
        this.data=data;
        this.next=null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
    }
    addFront(val) {
        let new_node = new Node(val);
        if(!this.head) {
            this.head = new_node;
            return this;
        }
        new_node.next = this.head;

        this.head = new_node;
        return this;
    }

    removeFront() {

        if(this.head == null) {
            return null
        }
        var removeNode = this.head;
        this.head = removeNode.next;
        removeNode.next = null;
        return this;
}

    front() {
        if(this.head == null) {
            return null
        }
        else {
            return this.head.data;
            
        }
    }
}

let SLL1 = new LinkedList ();
SLL1.addFront(12);
console.log(SLL1);

SLL1.removeFront();
console.log(SLL1);

SLL1.addFront(4);
SLL1.front();
console.log(SLL1.front());
