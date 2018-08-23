package org.java2.lesson3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class PhoneBook {

    LinkedList<Contact> book = new LinkedList<>();
    PhoneBook(){
        fillPhoneBook();
    }

    private void fillPhoneBook(){
        for (int i = 0; i < 30; i++){
            book.add(new Contact("Contact #" + i, ("880055535" + (i < 10 ? ("0" + i) : i)), "contact#" + i + "@somemail.ru"));
        }
    }

    public void emailSearch(String key){
        Iterator<Contact> iterator = book.iterator();
        while (iterator.hasNext()){
            iterator.next().getInfo();
        }
    }
    public void phoneSearch(String key){
        for (Contact buffer : this.book){
            if(buffer.getSurname().equalsIgnoreCase(key)) System.out.println(buffer.getPhone());
        }
    }
}
