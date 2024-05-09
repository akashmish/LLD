package com.flipmed.exception;

public class BookingNotfoundException extends RuntimeException{
    
    public BookingNotfoundException(){
        super();
    }

    public BookingNotfoundException(String id){
        super("This particualar booking is not avaulebk"+id);
    }
}
