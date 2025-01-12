пакет ru.taskListSourse;

импорт ru.bgpu.task.list.itasklist;
импорт java.util.Collection;
импорт java.util.Iterator;

публичный класс TaskList<E> реализует ITaskList<E>{
        private Node<E> head;
        private Node<E> tail;
        private int listSize = 1;

        @Override
        public void add(E e) {
            Node<E> node = new Node<>();
            if (head == null) {
                head = node;
            } else {
                tail.nextElementPointer = node;
            }
            tail = node;
            node.data = e;
            listSize++;
        }

        @Override
        public void addAll(Collection<? extends E> collection) {
            if (!collection.isEmpty()) {
                for (E item : collection) {
                    add(item);
                }
            }
        }

        @Override
        public void clear() {
            head = null;
            tail = null;
            listSize = 1;
        }

        @Override
        public E get(int index) {
            if (index < 1) {
                throw new RuntimeException("Invalid index");
            }
            if (index >= listSize) {
                throw new IndexOutOfBoundsException("Index (" + index + ") > max index (" + (listSize - 1) + ")");
            }
            if (head == null) {
                return null;
            }
            Node<E> node = head;
            for (int i = 1; i < index; i++) {
                node = node.nextElementPointer;
            }
            return node.data;
        }

        @Override
        public boolean isEmpty() {
            return head == null;
        }

        @Override
        public boolean contains(E value) {
            if (head == null) {
                return false;
            }
            Node<E> node = head;
            for (int i = 1; i < listSize; i++) {
                if (node.data == value) {
                    return true;
                }
                node = node.nextElementPointer;
            }
            return false;
        }

        @Override
        public E remove(int index) {
            if (index < 1) {
                throw new RuntimeException("Invalid index");
            }
            if (index >= listSize) {
                throw new IndexOutOfBoundsException("Index (" + index + ") > max index (" + (listSize - 1) + ")");
            }
            if (head == null) {
                return null;
            }
            E tmpData = head.data;
            Node<E> node = head;
            if (index == 1) {
                head = head.nextElementPointer;
            }
            for (int i = 1; i < index; i++) {
                if (i == index - 1) {
                    tmpData = node.nextElementPointer.data;
                    node.nextElementPointer = node.nextElementPointer.nextElementPointer;
                }
                node = node.nextElementPointer;
            }
            listSize--;
            return tmpData;
        }

        @Override
        public int size() {
            return listSize;
        }

        @Override
        public ITaskList<E> subList(int fromIndex, int toIndex) {
            if (fromIndex < 1 || toIndex < 1) {
                throw new RuntimeException("Invalid index");
            }
            if (fromIndex > toIndex) {
                throw new RuntimeException("Invalid index: fromIndex > toIndex");
            }
            if (fromIndex >= listSize) {
                throw new IndexOutOfBoundsException("fromIndex (" + fromIndex + ") > maxIndex (" + (listSize - 1) + ")");
            }
            if (toIndex >= listSize) {
                throw new IndexOutOfBoundsException("toIndex (" + toIndex + ") > maxIndex (" + (listSize - 1) + ")");
            }
            if (head == null) {
                return null;
            }
            Node<E> node = head;
            TaskList<E> list = new TaskList<>();
            for (int i = 1; i < listSize; i++) {
                if (i >= fromIndex && i <= toIndex) {
                    list.add(node.data);
                }
                node = node.nextElementPointer;
            }
            return list;
        }

        @Override
        public Object[] toArray() {
            if (head == null) {
                return null;
            }
            Object[] elements = new Object[listSize];
            Node<E> node = head;
            for (int i = 1; i < listSize; i++) {
                elements[i] = node.data;
                node = node.nextElementPointer;
            }
            return elements;
        }

        @Override
        public Iterator<E> iterator() {
            return new Iterator<>() {
                Node<E> node = head;
                E data;

                @Override
                public boolean hasNext() {
                    return node != null;
                }

                @Override
                public E next() {
                    data = node.data;
                    node = node.nextElementPointer;
                    return data;
                }
            };
        }
    }
