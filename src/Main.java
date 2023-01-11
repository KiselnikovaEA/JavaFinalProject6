class Reader {
    private String fullName;
    private String libraryCardNumber;
    private String faculty;
    private String dateOfBirth;
    private String phoneNumber;

    @Override
    public String toString() {
        return "Reader{" +
                "ФИО='" + fullName + '\'' +
                ", читательский билет='" + libraryCardNumber + '\'' +
                ", факультет='" + faculty + '\'' +
                ", дата рождения='" + dateOfBirth + '\'' +
                ", номер телефона='" + phoneNumber + '\'' +
                '}';
    }

    public Reader(String fullName, String libraryCardNumber, String faculty, String dateOfBirth, String phoneNumber) {
        this.fullName = fullName;
        this.libraryCardNumber = libraryCardNumber;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public void takeBook(String book) {                             // 6.
        System.out.printf("%s берёт книгу: %s", fullName, book);
        System.out.println();
    }

    public void takeBook(int number) {
        System.out.printf("%s берёт книг: %d", fullName, number); // 8., 9.
        System.out.println();
    }

    public void takeBook(String... books) {                         // 10.
        System.out.printf("%s берёт книги: ", fullName);
        for (String book : books) {
            System.out.print(book + "; ");
        }
        System.out.println();
    }

    public void takeBook(Book... books) {                         // 11.
        System.out.printf("%s берёт книги: ", fullName);
        for (Book book : books) {
            System.out.print(book + "; ");
        }
        System.out.println();
    }

    public void returnBook(String book) {                             // 6.
        System.out.printf("%s возвращает книгу: %s", fullName, book);
        System.out.println();
    }

    public void returnBook(int number) {
        System.out.printf("%s возвращает книг: %d", fullName, number); // 12.
        System.out.println();
    }

    public void returnBook(String... books) {                         // 12.
        System.out.printf("%s возвращает книги: ", fullName);
        for (String book : books) {
            System.out.print(book + "; ");
        }
        System.out.println();
    }

    public void returnBook(Book... books) {                         // 12.
        System.out.printf("%s возвращает книги: ", fullName);
        for (Book book : books) {
            System.out.print(book + "; ");
        }
        System.out.println();
    }
}

class Book {
    String author;
    String bookName;

    public String toString() {
        return "\"" + bookName + "\", " + author;
    }

    public Book(String author, String bookName) {
        this.author = author;
        this.bookName = bookName;
    }
}


public class Main {
    public static void main(String[] args) {

        Reader r1 = new Reader("Иванов И. И.", "345654",
                "Прикладная информатика", "02.03.1994", "89099998877");
        System.out.println(r1);

        r1.takeBook(3);
        r1.takeBook("Приключения");

        r1.returnBook(3);
        r1.returnBook("Приключения");

        r1.takeBook("Приключения", "Словарь", "Энциклопедия");
        r1.returnBook("Приключения", "Словарь", "Энциклопедия");

        r1.takeBook(new Book("А.С. Пушкин", "Медный всадник"), new Book("Л.Н. Толстой", "Война и мир"));
        r1.returnBook(new Book("А.С. Пушкин", "Медный всадник"), new Book("Л.Н. Толстой", "Война и мир"));

        System.out.println();  // 7.

        String[] names = {"Семёнов К.И.", "Кисельников Я.А.", "Васильев И.И."};
        String[] libraryCardNumbers = {"00123", "87342", "08123"};
        String[] faculties = {"Гриффиндор", "Когтерван", "Слизнерин"};
        String[] datesOfBirth = {"21.04.1991", "18.09.1992", "22.07.1993"};
        String[] phoneNumbers = {"88005553535", "89003553535", "86052510525"};

        Reader[] readers = new Reader[3];
        for (int i = 0; i < readers.length; i++) {
            readers[i] = new Reader(names[i], libraryCardNumbers[i], faculties[i], datesOfBirth[i], phoneNumbers[i]);
        }

        for (Reader reader : readers) {
            System.out.println(reader);
        }
    }
}