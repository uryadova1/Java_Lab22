package ru.nsu.ccfit.uryadova.MyExeptions;

public class CommandArgsAmountException extends RuntimeException{
    public CommandArgsAmountException(String message){
        super(message);
    }
}
