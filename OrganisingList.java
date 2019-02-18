/**
 * Name: Giovanni Joubert
 * Student Number: u18009035
 */

public class OrganisingList {

    public ListNode root = null;

    public OrganisingList() {

    }
    
    /**
     * Calculate the sum of keys recursively, starting with the given node
     * until the end of the list
     * @return The sum of keys from the current node to the last node in the list
     * NOTE: 'int' and not 'Integer' here because it cannot return 'null'
     */
    public static int sumRec(ListNode node) {
        if(node.next == null){
            return node.key;
        } else {
           
            return sumRec(node.next) + node.key;
        }
    }

    /**
     * Calculate and set the data for the given node.
     * @return The calculated data for the given node
     * NOTE: 'int' and not 'Integer' here because it cannot return 'null'
     */
    public static int dataRec(ListNode node) {
        if(node.next == null){
            node.data = node.key;
            return node.key;
       
        } else {
            node.data = (node.key * sumRec(node)) - dataRec(node.next);
            
            return (node.data);
        }
    }

    /**
     * Calculate the data field of all nodes in the list using the recursive functions.
     * DO NOT MODIFY!
     */
    public void calculateData() {
        if (root != null) {
            dataRec(root);
        }
    }

    /**
     * Retrieve the data for the node with the specified key and move the
     * accessed node to the front and recalculate data fields.
     * @return The data of the node before it has been moved to the front,
     * otherwise 'null' if the key does not exist.
     */
    public Integer getData(Integer key) {
        // Your code here...
        if(contains(key)){
            ListNode temp = root;
            ListNode theOne = null;
            int rThis = 0;
            while(temp != null){
                if(temp.next.key == key){
                    theOne = temp.next; //Save
                    rThis = theOne.data;
                    temp.next = temp.next.next; //move to front
                    theOne.next = root;
                    root = theOne;
                    break;
                }
                temp = temp.next;
            }

            calculateData();
            return rThis;
        } else {
            return null;
        }
    }

    /**
     * Delete the node with the given key.
     * calculateData() should be called after deletion.
     * If the key does not exist, do nothing.
     */
    public void delete(Integer key) {
        // Your code here...

        if(contains(key)){
            if(root.key == key){
                root = root.next;
            } else  //root node is the only node (and the deletion node)

            if(root.next == null){
                root = null;
            } else {

            ListNode temp = root;
            while(temp.next != null){
            if(temp.next.key == key){
                ListNode nodeNext = temp.next.next;
                temp.next = nodeNext;
                break; //already found
            }
            temp = temp.next;
        }
    }
            calculateData();
        } 
    }

    /**
     * Insert a new key into the linked list.
     * 
     * New nodes should be inserted to the back
     * Duplicate keys should not be added.
     */
    public void insert(Integer key) {
        // Your code here...

        if(contains(key)){
            //nothing if already exists
        }else{
            ListNode newNode = new ListNode(key);
            if(root == null){
                root = newNode;
            } else {
            ListNode temp = root;
           
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
            calculateData();
        }
    }

    /**
     * Check if a key is contained in the list
     * @return true if the key is in the list, otherwise false
     */
    public Boolean contains(Integer key) {
        // Your code here...
        ListNode temp = root;
        while(temp != null){
            if(temp.key == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    /**
     * Return a string representation of the Linked List.
     * DO NOT MODIFY!
     */
    public String toString() {
        if (root == null) {
            return "List is empty";
        }

        String result = "";
        for (ListNode node = root; node != null; node = node.next) {
            result = result.concat("[K: " + node.key + ", D: " + node.data + "]");

            if (node.next != null) {
                result = result.concat(" ");
            }
        }

        return result;
    }

    /**
     * Return a string representation of the linked list, showing only the keys of nodes.
     * DO NOT MODIFY!
     */
    public String toStringKeysOnly() {

        if (root == null) {
            return "List is empty";
        }

        String result = "";
        for (ListNode node = root; node != null; node = node.next) {
            result = result + node.key;

            if (node.next != null) {
                result = result.concat(", ");
            }
        }

        return result;
    }

    
}