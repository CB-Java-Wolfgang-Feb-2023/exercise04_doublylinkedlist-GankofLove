public class DoublyLinkedListCustom implements MyListInterface {
    private Node head;
    private Node tail;
    private int size;


    /**
     * Fügt ein neues Element am Anfang der DoublyLinkedList hinzu.
     * Wenn die Liste leer ist, wird das neue Element sowohl als head
     * als auch als tail der Liste gesetzt. Ist die Liste nicht leer,
     * wird das neue Element vor dem aktuellen head eingefügt und zum neuen head.
     *
     * @param item Das hinzuzufügende Element.
     */
    @Override
    public void addFirst(int item) {   // Methode zum Hinzufügen eines Elements am Anfang der Liste
        Node newNode = new Node(item); // Erstellt einen neuen Knoten mit dem gegebenen Wert
        if (head == null) {            // Überprüft, ob die Liste leer ist
            head = tail = newNode;     // Setzt den neuen Knoten als Kopf und Schwanz der Liste, wenn leer
        } else {                       // Falls die Liste nicht leer ist
            newNode.setNext(head);     // Setzt den next-Zeiger des neuen Knotens auf den aktuellen Kopf
            head.setPrevious(newNode); // Setzt den prev-Zeiger des aktuellen Kopfes auf den neuen Knoten
            head = newNode;            // Aktualisiert den Kopf der Liste auf den neuen Knoten
        }
        size++;                        // Erhöht die Größe der Liste um eins
    }



    /**
     * Fügt ein neues Element am Ende der Liste hinzu. Unterscheidet sich von
     * `addFirst` dadurch, dass das Element hinter dem aktuellen tail
     * eingefügt und zum neuen tail wird.
     */
    @Override
    public void addLast(int item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Druckt die Elemente der DoublyLinkedList in der Reihenfolge vom head
     * zum tail in der Konsole. Jedes Element wird durch " -> " getrennt,
     * und am Ende wird "null" gedruckt, um das Ende der Liste anzugeben.
     */
    @Override
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getValue() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }


    /**
     * Druckt die Elemente der DoublyLinkedList in umgekehrter Reihenfolge, beginnend mit tail und endend bei head.
     * Jedes Element wird durch " <- " getrennt, und am Ende wird "null" gedruckt,
     * um den Beginn der Liste anzugeben.
     */
    @Override
    public void printListBackwards() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.getValue() + " <- ");
            current = current.getPrevious();
        }
        System.out.println("null");
    }


    /**
     * Fügt ein neues Element an einem gegebenen Index in die Liste ein.
     * Wenn der Index 0 ist, wird das Element am Anfang (head) eingefügt.
     * Wenn der Index dem Wert von 'size' entspricht, wird das Element am Ende (tail) hinzugefügt.
     * Bei ungültigem Index wird eine IllegalArgumentException geworfen.
     */
    @Override
    public void addAtIndex(int index, int item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index außerhalb des Bereichs");
        }
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }

        Node newNode = new Node(item);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        newNode.setPrevious(current);
        current.getNext().setPrevious(newNode);
        current.setNext(newNode);

        size++;
    }


    /**
     * Entfernt das erste Element (head) der Liste.
     * Wenn die Liste nach dem Entfernen nicht leer ist, wird der previous-Verweis des neuen head auf 'null' gesetzt.
     * Wenn nach dem Entfernen kein Element mehr vorhanden ist, wird auch tail auf 'null' gesetzt.
     * Gibt den entfernten Knoten zurück oder 'null', wenn die Liste bereits leer war.
     */
    @Override
    public Node removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node temp = head;
        head = head.getNext();
        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null;
        }

        size--;
        return temp;
    }


    /**
     * Entfernt das letzte Element (tail) der Liste.
     * Wenn die Liste nach dem Entfernen nicht leer ist, wird der next-Verweis des neuen tail auf 'null' gesetzt.
     * Wenn nach dem Entfernen kein Element mehr vorhanden ist, wird auch head auf 'null' gesetzt.
     * Gibt den entfernten Knoten zurück oder 'null', wenn die Liste bereits leer war.
     */
    @Override
    public Node removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node temp = tail;
        tail = tail.getPrevious();
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }

        size--;
        return temp;
    }


    /**
     * Entfernt das Element an einem bestimmten Index der Liste.
     * Falls der Index außerhalb des gültigen Bereichs liegt, wird eine Ausnahme ausgelöst.
     * Für spezielle Fälle, wie das Entfernen am Anfang oder Ende der Liste, werden die bereits definierten Methoden verwendet.
     * Für andere Indizes navigiert die Methode zur gewünschten Position und passt die next- und previous-Verweise der benachbarten Knoten an,
     * um den aktuellen Knoten zu überspringen.
     * Gibt den entfernten Knoten zurück.
     */
    @Override
    public Node removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index außerhalb des Bereichs");
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());

        size--;
        return current;
    }


    /**
     * Fügt ein Element an einer zufälligen Position in der Liste hinzu.
     * Der zufällige Index wird zwischen 0 und der aktuellen Größe der Liste (inklusive) generiert,
     * so dass das Element entweder am Anfang, irgendwo in der Mitte oder am Ende eingefügt werden kann.
     * Nutzt die Methode `addAtIndex`, um die tatsächliche Einfügeoperation durchzuführen.
     */
    @Override
    public void addElementAtRandomIndex(int value) {
        int randomIndex = (int) (Math.random() * (size + 1)); // size + 1, um am Ende hinzufügen zu können
        addAtIndex(randomIndex, value);
    }


    /**
     * Gibt den Wert des Elements an einem bestimmten Index in der Liste zurück.
     * Wenn der gegebene Index ungültig ist (kleiner als 0 oder größer gleich der Größe der Liste),
     * wird eine IllegalArgumentException geworfen.
     * Geht durch die Liste von `head` bis zum gewünschten Index und gibt dann den Wert dieses Knotens zurück.
     */
    @Override
    public int get(int index) throws IllegalArgumentException {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index außerhalb des Bereichs");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }


    /**
     * Entfernt doppelte Werte aus der Liste.
     * Für jeden Knoten, angefangen bei `head`, wird die gesamte Liste durchlaufen und überprüft,
     * ob es Knoten mit identischem Wert gibt.
     * Wird ein solcher doppelter Knoten gefunden, wird er aus der Liste entfernt und die Größe der Liste verringert.
     */
    @Override
    public void removeDuplicates() {
        Node current = head;
        while (current != null) {
            Node runner = current.getNext();
            while (runner != null) {
                if (runner.getValue() == current.getValue()) {
                    runner.getPrevious().setNext(runner.getNext());
                    if (runner.getNext() != null) {
                        runner.getNext().setPrevious(runner.getPrevious());
                    } else {
                        tail = runner.getPrevious();
                    }
                    size--;
                }
                runner = runner.getNext();
            }
            current = current.getNext();
        }
    }


    /**
     * Dreht die Reihenfolge der Knoten in der Liste um.
     * Die Methode vertauscht bei jedem Durchlauf die `previous`- und `next`-Verweise des aktuellen Knotens.
     * Das Ende der Liste (tail) wird zum Anfang (head) und umgekehrt.
     */
    @Override
    public void reverseList() {
        Node temp = null;
        Node current = head;
        tail = head;
        while (current != null) {
            temp = current.getPrevious();
            current.setPrevious(current.getNext());
            current.setNext(temp);
            head = current;
            current = current.getPrevious();
        }
    }


    /**
     * Erstellt und gibt eine tiefe Kopie der aktuellen Liste zurück.
     * Beim Durchlaufen der Original-Liste wird jeder Knotenwert
     * in der neuen Liste am tail eingefügt, wodurch die ursprüngliche Reihenfolge beibehalten wird.
     * Beachte: Die Kopie enthält neue Knoteninstanzen mit denselben Werten,
     * ist jedoch völlig unabhängig von der Original-Liste.
     */
    @Override
    public DoublyLinkedListCustom copyList() {
        DoublyLinkedListCustom newList = new DoublyLinkedListCustom();
        Node current = head;
        while (current != null) {
            newList.addLast(current.getValue());
            current = current.getNext();
        }
        return newList;
    }


    /**
     * Leert die Liste, indem sie die head- und tail-Referenzen auf null setzt und die Größe auf 0 zurücksetzt.
     * Dies ermöglicht es dem Java-Garbage-Collector, alle Knoten der Liste freizugeben, da keine Referenzen mehr auf sie zeigen.
     */
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }


    /**
     * Fügt einen neuen Knoten mit dem angegebenen Datenwert direkt nach einem Knoten mit dem angegebenen Schlüsselwert ein.
     * Wenn der Schlüsselwert in der Liste gefunden wird, wird der Datenwert nach diesem Knoten eingefügt und true zurückgegeben.
     * Wenn der Schlüsselwert nicht gefunden wird, werden keine Änderungen vorgenommen und false zurückgegeben.
     * Falls der Knoten mit dem Schlüsselwert der tail ist, wird der neue Knoten der neue tail.
     */
    @Override
    public boolean insertAfter(int key, int data) {     // Methode um ein Element nach einem gegebenen Schlüssel einzufügen
        Node current = head;                            // Startet mit dem Kopf der Liste
        while (current != null && current.getValue() != key) { // Durchläuft die Liste, um den Schlüssel zu finden
            current = current.getNext();                // Geht zum nächsten Knoten
        }

        if (current == null) {                          // Überprüft, ob das Ende der Liste erreicht wurde, ohne den Schlüssel zu finden
            return false;                               // Schlüssel wurde nicht gefunden
        }

        Node newNode = new Node(data);                  // Erstellt einen neuen Knoten mit dem gegebenen Datenwert
        newNode.setNext(current.getNext());             // Der next-Zeiger des neuen Knotens zeigt auf den Nachfolger des aktuellen Knotens
        newNode.setPrevious(current);                   // Der vorherige Zeiger des neuen Knotens zeigt auf den aktuellen Knoten

        if (current.getNext() != null) {                // Überprüft, ob der aktuelle Knoten nicht der letzte in der Liste ist
            current.getNext().setPrevious(newNode);     // Setzt den vorherigen Zeiger des Nachfolgers des aktuellen Knotens auf den neuen Knoten
        } else {
            tail = newNode;                             // wenn das aktuelle Element der tail war
        }
        current.setNext(newNode);                       // Setzt den nächsten Zeiger des aktuellen Knotens auf den neuen Knoten
        size++;                                         // Erhöht die Größe der Liste
        return true;                                    // Gibt true zurück, um den Erfolg der Operation anzuzeigen
    }


    /**
     * Löscht den ersten Knoten, der den angegebenen Schlüsselwert enthält, aus der Liste.
     * Wenn der Schlüsselwert in der Liste gefunden wird, wird der entsprechende Knoten gelöscht und zurückgegeben.
     * Wenn der Schlüsselwert nicht gefunden wird, werden keine Änderungen vorgenommen und null zurückgegeben.
     * Falls der zu löschende Knoten der head ist, wird der nächste Knoten der neue head.
     * Falls der zu löschende Knoten der tail ist, wird der vorherige Knoten der neue tail.
     */
    @Override
    public Node deleteKey(int key) {
        Node current = head;
        while (current != null && current.getValue() != key) {
            current = current.getNext();
        }

        if (current == null) {
            return null; // Schlüssel wurde nicht gefunden
        }

        if (current.getPrevious() != null) {
            current.getPrevious().setNext(current.getNext());
        } else {
            head = current.getNext(); // wenn das aktuelle Element der head war
        }

        if (current.getNext() != null) {
            current.getNext().setPrevious(current.getPrevious());
        } else {
            tail = current.getPrevious(); // wenn das aktuelle Element der tail war
        }

        size--;
        return current;
    }


    /**
     * Entfernt das erste Vorkommen des angegebenen Werts aus der Liste.
     *
     * @param val Der zu entfernende Wert.
     * @return {@code true}, wenn das Element erfolgreich entfernt wurde,
     *         {@code false}, wenn das Element nicht in der Liste gefunden wurde.
     */
    public boolean remove(int val) {
        Node current = head;
        while (current != null) {
            if (current.getValue() == val) {
                if (current.getPrevious() != null) {
                    current.getPrevious().setNext(current.getNext());
                } else {
                    head = current.getNext();
                }

                if (current.getNext() != null) {
                    current.getNext().setPrevious(current.getPrevious());
                } else {
                    tail = current.getPrevious();
                }

                size--;
                return true;  // Element gefunden und entfernt
            }
            current = current.getNext();
        }
        return false;  // Element nicht gefunden
    }

}



