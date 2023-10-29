# DoublyLinkedList - Therorie

Eine doppelt verkettete Liste ist eine Datenstruktur, in der jedes Element auf das nächste und das vorherige Element in der Liste verweist. Dies unterscheidet sich von einer einfach verketteten Liste, bei der jedes Element nur auf das nächste Element verweist.

### Vorteile

- ermöglicht einen bidierektionalen Durchlauf der Liste. Dh: von vorne nach hinten und von hinten nach vorne
- Einfügen und Löschen von Elementen ist effizienter als bei einer einfach verketteten Liste

### Nachteile

- benötigt mehr Speicherplatz als eine einfach verkettete Liste, da jedes Element auf das vorherige Element verweist (2 Pointer ansatt 1 Pointer bei LinkedList)

---

## Bestandteile einer DoublyLinkedList

Eine DoublyLinkedList besteht aus 2 Teilen:
-  Liste selbst
- Knoten

### Konten (Node)

In Datenstrukturen wie verketteten Listen bezieht sich ein "Knoten" auf ein Element oder einen Datensatz innerhalb der Liste. In einer doppelt verketteten Liste hat jeder Knoten im Wesentlichen drei Hauptkomponenten:

- **Daten** <br>
Dies ist der tatsächliche Wert oder das tatsächliche Objekt, das im Knoten gespeichert ist. Dies kann ein einfacher Datentyp (z. B. ein int oder char) oder ein komplexerer Datentyp (z. B. ein benutzerdefiniertes Objekt) sein.


- **Nächster Zeiger** <br>
  Dies ist ein Zeiger (oder Verweis) auf den nächsten Knoten in der Liste. Bei dem letzten Knoten der Liste zeigt dieser Zeiger auf null, was das Ende der Liste anzeigt.


- **Vorheriger Zeiger (Head und Tail)** <br>
    Dies ist ein Zeiger (oder Verweis) auf den vorherigen Knoten in der Liste. Bei dem ersten Knoten der Liste zeigt dieser Zeiger auf null, was den Anfang der Liste anzeigt.


  Beispiel:
```java
private static class Node<T> {
    T data;           // Daten des Knotens
    Node<T> next;     // Zeiger auf den nächsten Knoten
    Node<T> prev;     // Zeiger auf den vorherigen Knoten

    public Node(T data) {
        this.data = data;
    }
}
```

- **Klasse `Node<T>`**: Eine innere, statische Klasse für eine doppelt verkettete Liste mit einem generischen Datentyp `T`.
    - `data`: Speichert den Wert des Knotens
    - `next`: Verweist auf den nächsten Knoten in der Liste
    - `prev`: Verweist auf den vorherigen Knoten in der Liste
    - **Konstruktor**: Nimmt einen Wert vom Typ `T` an und initialisiert das `data`-Attrib

# Über die  Übung; Über das Projekt

- **MyListInterface:**
  Dies ist ein Interface, das die Signatur aller notwendigen Methoden definiert, die in der Liste implementiert werden sollen. Dazu gehören Methoden zum Hinzufügen, Entfernen, Abrufen von Elementen, Überprüfen der Größe der Liste und viele andere.


- **Node:**
  Eine Hilfsklasse, die die Struktur eines Knotens in der doppelt verketteten Liste darstellt. Jeder Knoten hat einen Datenwert und zwei Verweise - einen auf den vorherigen Knoten und einen auf den nächsten.


- **DoublyLinkedListCustom:**
  Diese Klasse implementiert das `MyListInterface` und enthält die eigentliche Logik der doppelt verketteten Liste. Hier werden alle Methoden wie das Hinzufügen eines Elements am Anfang, am Ende, an einem bestimmten Index, das Entfernen eines Elements und andere nützliche Funktionen implementiert.


- **Main:**
  Eine Main Klasse (Treiberklasse), in der die `DoublyLinkedListCustom` Klasse getestet wird, um sicherzustellen, dass alle Methoden wie erwartet funktionieren.
