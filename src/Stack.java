import org.w3c.dom.Node;

public class Stack {

    static class Node<T> {
        private T item;
        private Node<T> node;

        public Node(T item, Node<T> node) {
            this.item = item;
            this.node = node;
        }

        public T getItem() {
            return item;
        }

        public Node<T> getNextNode() {
            return node;
        }
    }
    static class NodeManager<T> {
        private Node<T> top;

        public NodeManager() {
            this.top = null;
        }

        public void push(T item) {
            Node<T> node = new Node<>(item, top);
            top = node;
        }

        public void pop() {
            top = top.getNextNode();
        }

        public void peek() {
            System.out.println(top.getItem());
        }
    }

    public static void main(String[] args) {
        NodeManager<Integer> stack = new NodeManager<>();
        stack.push(5);
        stack.push(10);
        stack.pop();
        stack.peek();
    }
}
