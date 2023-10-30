/**
 * Класс Container представляет собой контейнер, который позволяет хранить произвольное количество объектов.
 * Контейнер реализован на основе односвязного списка и предоставляет методы для добавления в конец,начало, по индексу,
 * извлечения и удаления элементов из начала,конца и по индексу.
 *
 * @param <Object> тип элементов, которые будут храниться в контейнере.
 */
public class Container<Object> {
    private Node<Object> head;
    private int size;

    /**
     * Создает новый пустой контейнер.
     */
    public Container() {
        head = null;
        size = 0;
    }

    /**
     * Метод AddAtBeginning добавляет элемент в начало списка.
     *
     * @param data элемент,который добавляется в начало списка.
     */
    public void AddAtBeginning(Object data) {
        Node<Object> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Метод AddAtEnd добавляет элемент в конец списка.
     *
     * @param data элемент,который добавляется в конец списка.
     */
    public void AddAtEnd(Object data) {
        Node<Object> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<Object> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Метод AddAtIndex добавляет элемент в список по указанному индексу.
     *
     * @param data  элемент для добавления.
     * @param index индекс, по которому нужно добавить элемент.
     * @throws IndexOutOfBoundsException создается для указания того,что индекс находится вне допустимых границ.
     */
    public void AddAtIndex(Object data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (index == 0) {
            AddAtBeginning(data);
        } else if (index == size) {
            AddAtEnd(data);
        } else {
            Node<Object> newNode = new Node<>(data);
            Node<Object> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    /**
     * Метод Get используется для получения элемента по индексу.
     *
     * @param index индекс элемента.
     * @return элемент, находящийся по указанному индексу.
     * @throws IndexOutOfBoundsException создается для указания того,что индекс находится вне допустимых границ.
     */
    public Object Get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<Object> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Метод RemoveAtBeggining удаляет элемент из начала списка.
     *
     * @return возвращает удаленный элемент.
     * @throws IllegalStateException этот метод вызывается в случае, если контейнер пуст.
     */
    public Object RemoveAtBeginning() {
        if (head == null) {
            throw new IllegalStateException("Container is empty");
        }
        Object data = head.data;
        head = head.next;
        size--;
        return data;
    }

    /**
     * Метод RemoveAtIndex удаляет элемент из списка по указанному индексу.
     *
     * @param index индекс элемента для удаления.
     * @return возвращает удаленный элемент.
     * @throws IndexOutOfBoundsException создается для указания того,что индекс находится вне допустимых границ.
     */
    public Object RemoveAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (index == 0) {
            RemoveAtBeginning();
            return RemoveAtBeginning();
        }
        Node<Object> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Object data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }

    /**
     * Метод RemoveAtEnd удаляет элемент с конца списка.
     *
     * @return возвращает удаленный элемент.
     * @throws IllegalStateException вызывается в случае, если список пуст.
     */
    public Object RemoveAtEnd() {
        if (head == null) {
            throw new IllegalStateException("Container is empty");
        }
        if (size == 1) {
            Object data = head.data;
            head = null;
            size--;
            return data;
        }
        Node<Object> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        Object data = current.next.data;
        current.next = null;
        size--;
        return data;
    }

    /**
     * Метод GetSize возвращает текущий размер контейнера.
     *
     * @return размер контейнера.
     */
    public int GetSize() {
        return size;
    }

    /**
     * Внутренний класс Node представляет собой узел связанного списка.
     *
     * @param <E> тип данных, хранимых в узле.
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
}