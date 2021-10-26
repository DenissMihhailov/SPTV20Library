/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import entity.Author;
import entity.Book;
import entity.History;
import entity.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import tools.SaverToFiles;

/**
 *
 * @author Deniss
 */
public class App {
    private final List<Book> books= new ArrayList<>();
    private final List<User> readers= new ArrayList<>();
    private final List<History> histories = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Calendar c = new GregorianCalendar();
    public void run(){
        String repeat="yes";
        do{
            System.out.println("Выберите номер задачи:");
            System.out.println("0: Закрыть программу");
            System.out.println("1: Добавить пользователя");
            System.out.println("2: Добавить книгу");
            System.out.println("3: Выдать книгу");
            System.out.println("4: Вернуть книгу");
            System.out.println("5: Вывести список книг");
            System.out.println("6: Вывести список пользователей");
            System.out.println("7: Вывести список выданных книг");
            System.out.print("Выбор меню: ");
            int task= scanner.nextInt(); scanner.nextLine();
            switch (task) {
                case 0:
                    repeat="0";
                    break;
                case 1:
                    addReader();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    giveBook();
                    break;
                case 4:
                    bookReturn();
                    break;
                case 5:
                    listBook();
                    break;
                case 6:
                    listReaders();
                    break;
                case 7:
                    listGivenBooks();
                    break;
                default:
                    System.out.println("Выберите номер из списка!");
            }

        }while("yes".equals(repeat));
        System.out.println("ВЫХОД");
    }
//------------------------------------------------------------------------------    
private void addReader(){
    User reader = new User();
    System.out.print("Введите имя читателя: ");
    reader.setUserFirstName(scanner.nextLine());
    System.out.print("Введите фамилию читателя: ");
    reader.setUserLastName(scanner.nextLine());
    System.out.print("Введите номер читателя: ");
    reader.setUserTelefonNumber(scanner.nextLine());
readers.add(reader);
    System.out.println("Пользователь инициирован: "+reader.toString());   
}
//------------------------------------------------------------------------------
private void addBook(){    
Book book = new Book();
System.out.print("Введите название книги: ");
book.setBookName(scanner.nextLine());
System.out.print("Введите год издания книги: ");
book.setReleaseYear(scanner.nextInt()); scanner.nextLine();
System.out.print("Введите количество авторов книги:");
int countAuthors= (scanner.nextInt()); scanner.nextLine();
Author[] authors = new Author[countAuthors];
for (int i = 0; i < countAuthors; i++) {
    Author author= new Author();
    System.out.print("Введите имя "+(1+i)+" автора: ");
    author.setFirstName(scanner.nextLine());
    System.out.print("Введите фамилию автора: ");
    author.setLastName(scanner.nextLine()); 
    System.out.print("Введите год рождение автора: ");
    author.setBirthYear(scanner.nextInt()); scanner.nextLine();
    authors[i]=author;
}
book.setAuthors(authors);
books.add(book);
//SaverToFiles saverToFiles = new SaverToFiles();
//saverToFiles.saveBooks(books);

System.out.println("Книга добавлена:"+book.toString());
}
//------------------------------------------------------------------------------
private void listBook(){
System.out.println("Список книг: ");
int n=0;
for (int i = 0; i < books.size(); i++) {
    if(books.get(i)!=null){
        System.out.printf("%d. %s. %s. %d.%n",
        i+1,
        books.get(i).getBookName(),
        Arrays.toString(books.get(i).getAuthors()),
        books.get(i).getReleaseYear()
        );
        n++;
    }
}
if(n<1){
    System.out.println("Нет книг!");
}
}
//------------------------------------------------------------------------------
private void listReaders(){
System.out.println("Список пользователей: ");
int n=0; 
for (int i = 0; i < readers.size(); i++) {
    if(readers.get(i)!=null){
        System.out.printf("%d. %s %s - номер телефона: %s%n",
                i+1,
                readers.get(i).getUserFirstName(),
                readers.get(i).getUserLastName(),
                readers.get(i).getUserTelefonNumber()
                );   
    n++;
    }
}
if(n<1){
    System.out.println("Пользователей нет!");
} 
}
//------------------------------------------------------------------------------
private void giveBook(){
System.out.println("------ Выдать книгу ------");
listBook();
System.out.println("------ ------------ ------");
    System.out.print("Выберите нужную книгу:");
    int bookNum= scanner.nextInt();scanner.nextLine();

System.out.println("------ ------------ ------");
listReaders();
System.out.println("------ ------------ ------");
System.out.print("Выберите нужного пользователя:");
    int readerNum= scanner.nextInt();scanner.nextLine();

History history = new History();
history.setBook(books.get(bookNum - 1));
history.setReader(readers.get(readerNum - 1));
history.setGivenBook(c.getTime());
histories.add(history);
}
//------------------------------------------------------------------------------
private void listGivenBooks(){
System.out.println("Список выданных книг:");
int n=0;
for (int i = 0; i < histories.size(); i++) {
    if(histories.get(i)!=null){
        System.out.printf("%d. книгу %s читает %s %s%n",
                i+1,
                histories.get(i).getBook().getBookName(),
                histories.get(i).getReader().getUserFirstName(),
                histories.get(i).getReader().getUserLastName()
        );
        n++;
    } 
} 
if(n<1){
    System.out.println("Нет выданных книг!");
}
}
//------------------------------------------------------------------------------
private void bookReturn(){
System.out.println("------ Вернуть книгу ------");
listGivenBooks();
System.out.println("------ ------------ ------");
System.out.print("Выберите номер книги :");
int numberHistory= scanner.nextInt(); scanner.nextLine();
Calendar c= new GregorianCalendar();
histories.get(numberHistory-1).getReturnBook(c.getTime());
}
//------------------------------------------------------------------------------
}