class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class SLL {
    constructor(data) {
        this.head = null;
    }
    addFront(val) {
        var new_node = new Node(val)
        if (!this.head) { 
            this.head = new_node;
            return this;
        }
        new_node.next = this.head;
        this.head = new_node;
        return this;
    }
    display() {
        var placeholder = this.head;
        var result = '';
        while (placeholder !== null) {
            if (placeholder.next === null) {
                result += placeholder.data;
                console.log(result);
            }
            result += placeholder.data + ',';
            placeholder = placeholder.next;
        }
    }
}

SLL1 = new SLL();
SLL1.addFront(76);
SLL1.addFront(2);
SLL1.display();
SLL1.addFront(11.41);
SLL1.display();