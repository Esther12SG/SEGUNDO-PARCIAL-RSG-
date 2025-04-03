// Aca Importamos la clase Scanner para que se puedan leer los datos del usuario
import java.util.Scanner;


// Esta Clase Node es un nodo de la lista enlazada
class Node {
    int data;    // Este Dato se guarda en el nodo
    Node next;   

    //Este es el Constructor que inicializa el nodo con un valor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

  
  //Esta Clase LinkedList representa la lista enlazada y sus operaciones
class LinkedList {
    Node head;

    // Se Agregara un nodo al final de la lista
    public void add(int data) {
        Node newNode = new Node(data);


         // Si la lista está vacía, el nuevo nodo será el primero
        if (head == null) {
            head = newNode;
        } else {
            // Esto recorre hasta el último nodo
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            // Enlaza el último nodo con el nuevo
            current.next = newNode;
        }
    }

    //Aca se Agrega un nodo al inicio de la lista
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Aca se inserta un nodo en una posición específica
    public void addMiddle(int data, int position) {
        Node newNode = new Node(data);

        // Si la posición es 0 o la lista está vacía, se agrega al inicio
        if (head == null || position <= 0) {
            addFirst(data);
            return;
        }

        Node current = head;
        int count = 0;

        //Aca se Recorre hasta la posición anterior a la que se solicita
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        //Aca, si se llegó a una posición que es válida, insertamos el nodo
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

     // Se Elimina el primer nodo que contenga el valor indicado
    public void remove(int data) {
        // Si la lista está vacía no se hace nada
        if (head == null) return;

        // Si el valor está en el primer nodo, lo eliminamos
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;

        //Aca se recorre la lista buscando el nodo anterior al que queremos eliminar
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        // Si se encuentra el nodo, saltamos el nodo a eliminar
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

     // Imprime toda la lista en formato: valor -> valor -> ... -> null
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Invierte el orden de los nodos de la lista
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next;

         // Se Recorre la lista y se va revirtiendo los enlaces
        while (current != null) {
            next = current.next;   // Guarda el siguiente
            current.next = prev;   // Revertimos el enlace
            prev = current;        // Avanza los punteros
            current = next;
        }

        head = prev;   // La nueva cabeza será el último nodo que procesamos
    }

    // Aca se verifica si un valor existe en la lista
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

// Esta clase es la principal que contiene el menú interactivo para poder probar la lista
public class PruebaLista {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int option;

 // Menú interactivo
        do {
            System.out.println("\n- Menú de Opcione Para Lista Enlazada -");
            System.out.println("1. Dato para Agregar al final");
            System.out.println("2. Dato para Agregar al inicio");
            System.out.println("3. Dato para Agregar en una posición");
            System.out.println("4. Eliminar un valor");
            System.out.println("5. Mostrar la lista");
            System.out.println("6. Invertir la lista");
            System.out.println("7. Buscar un valor dentro dentro de la lista");
            System.out.println("8. Salir");
            System.out.print("Elija la opción que desee: ");
            option = scanner.nextInt();

            int value, position;

            switch (option) {
                case 1:
                    System.out.print("Ingrese el valor para agregar al final: ");
                    value = scanner.nextInt();
                    list.add(value);
                    break;
                case 2:
                    System.out.print("Ingrese el valor para agregar al inicio: ");
                    value = scanner.nextInt();
                    list.addFirst(value);
                    break;
                case 3:
                    System.out.print("Ingrese el valor a agregar: ");
                    value = scanner.nextInt();
                    System.out.print("Ingrese la posición en la que se agregara: ");
                    position = scanner.nextInt();
                    list.addMiddle(value, position);
                    break;
                case 4:
                    System.out.print("Ingrese el valor para eliminar: ");
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
                    System.out.print("Ingrese el valor para buscar: ");
                    value = scanner.nextInt();
                    if (list.contains(value)) {
                        System.out.println("Este valor " + value + " si está en la lista.");
                    } else {
                        System.out.println("Este valor " + value + " no está en la lista.");
                    }
                    break;
                case 8:
                    System.out.println("¡Espero que regreses!");
                    break;
                default:
                    System.out.println("Esta opción no es válida. Intente de nuevo.");
            }
        } while (option != 8); // Se repite el menu hasta que el usuario quiera salir de el

        scanner.close();// Cerramos el scanner
    }
    }
