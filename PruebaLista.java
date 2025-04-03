import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addMiddle(int data, int position) {
        Node newNode = new Node(data);

        if (head == null || position <= 0) {
            addFirst(data);
            return;
        }

        Node current = head;
        int count = 0;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void remove(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

public class PruebaLista {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Menú de Opcione Para Lista Enlazada ---");
            System.out.println("1. Agregar al final");
            System.out.println("2. Agregar al inicio");
            System.out.println("3. Agregar en una posición");
            System.out.println("4. Eliminar un valor");
            System.out.println("5. Mostrar lista");
            System.out.println("6. Invertir lista");
            System.out.println("7. Buscar un valor");
            System.out.println("8. Salir");
            System.out.print("Elija una opción: ");
            option = scanner.nextInt();

            int value, position;

            switch (option) {
                case 1:
                    System.out.print("Ingrese el valor a agregar al final: ");
                    value = scanner.nextInt();
                    list.add(value);
                    break;
                case 2:
                    System.out.print("Ingrese el valor a agregar al inicio: ");
                    value = scanner.nextInt();
                    list.addFirst(value);
                    break;
                case 3:
                    System.out.print("Ingrese el valor a agregar: ");
                    value = scanner.nextInt();
                    System.out.print("Ingrese la posición: ");
                    position = scanner.nextInt();
                    list.addMiddle(value, position);
                    break;
                case 4:
                    System.out.print("Ingrese el valor a eliminar: ");
                    value = scanner.nextInt();
                    list.remove(value);
                    break;
                case 5:
                    System.out.println("Lista actual:");
                    list.printList();
                    break;
                case 6:
                    list.reverse();
                    System.out.println("Lista invertida.");
                    break;
                case 7:
                    System.out.print("Ingrese el valor a buscar: ");
                    value = scanner.nextInt();
                    if (list.contains(value)) {
                        System.out.println("El valor " + value + " SÍ está en la lista.");
                    } else {
                        System.out.println("El valor " + value + " NO está en la lista.");
                    }
                    break;
                case 8:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 8);

        scanner.close();
    }
}