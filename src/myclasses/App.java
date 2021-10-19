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
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Deniss
 */
public class App {
    private final Book[] books= new Book[10];
    public void run(){
        String repeat="yes";
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Выберите номер задачи:");
            System.out.println("0: Закрыть программу");
            System.out.println("1: Добавить пользователя");
            System.out.println("2: Добавить книгу");
            System.out.println("3: Выдать книгу");
            System.out.print("Выбор меню: ");
            int task= scanner.nextInt(); scanner.nextLine();
            switch (task) {
                case 0:
                    repeat="0";
                    break;
                case 1:
                    User reader = new User();
                    System.out.print("Введите имя читателя: ");
                    reader.setUserFirstName(scanner.nextLine());
                    System.out.print("Введите фамилию читателя: ");
                    reader.setUserLastName(scanner.nextLine());
                    System.out.print("Введите номер читателя: ");
                    reader.setUserTelefonNumber(scanner.nextLine());
                    System.out.println("Пользователь инициирован: "+reader.toString());
                    break;
                case 2:
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
                    for (int i = 0; i < books.length; i++) {
                        if(books[i]==null);
                        books[i]=book;
                        break; 
                    }
                    System.out.println("Книга добавлена:"+book.toString());
                    break;
                case 3:
                    System.out.println("------ Выдать книгу ------");
                    System.out.println("Список книг: ");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i]!=null){
                            System.out.printf("%d. %s. %s. %d.%n",
                            i+1,
                            books[i].getBookName(),
                            Arrays.toString(books[i].getAuthors()),
                            books[i].getReleaseYear()
                              
                            );
                            
                        }
                    }
                    System.out.println("------ ------------ ------");
                    break;
                default:
                    System.out.println("Выберите номер из списка!");
            }
        }while("yes".equals(repeat));
        System.out.println("ВЫХОД");
    }
    
    
}
