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
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Deniss
 */
public class App {
    public void run(){
        //System.out.println("Hello");
        Book book= new Book();
        book.setBookName("Voina i mir"); 
        book.setReleaseYear(2010);
        Author[] authors = new Author[1];
        Author author = new Author();
        author.setFirstName("Lev");
        author.setLastName("Tolstoy");
        author.setBirthYear(1828);
        authors[0]= author;
        book.setAuthors(authors);
        User user = new User();
        user.setUserFirstName("Mihhail");
        user.setUserLastName("Kostenkov");
        user.setUserTelefonNumber("+37258166749");
        
        System.out.printf("Создана книга: %s, автор: %s %s, год издания: %d%n",
                            book.getBookName(),
                            book.getAuthors()[0].getFirstName(),
                            book.getAuthors()[0].getLastName(),
                            book.getReleaseYear()
        );
        System.out.printf("Создан пользователь: %s %s с телефоном: %s%n",
                user.getUserFirstName(),
                user.getUserLastName(),
                user.getUserTelefonNumber()
                );
        History history = new History();
        history.setBook(book);
        history.setReader(user);
        Calendar c= new GregorianCalendar();
        history.setGivenBook(c.getTime());
        System.out.printf("Читатель %s %s взял книгу \"%s\", %s%n",
                history.getReader().getUserFirstName(),
                history.getReader().getUserLastName(),
                history.getBook().getBookName(),
                history.getGivenBook()
                );
        c = new GregorianCalendar();
        history.setReturnBook(c.getTime());
        System.out.printf("Читатель %s %s взял книгу \"%s\", %s%n",
                history.getReader().getUserFirstName(),
                history.getReader().getUserLastName(),
                history.getBook().getBookName(),
                history.getReturnBook()
        );
    }
    
    
}
