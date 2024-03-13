package ru.nsu.ccfit.uryadova.MyExeptions;

public class NonExistingCommand extends RuntimeException{
    public NonExistingCommand (String message){
        super(message);
    }
}
