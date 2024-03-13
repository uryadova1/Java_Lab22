package ru.nsu.ccfit.uryadova.commands;
import ru.nsu.ccfit.uryadova.Base.BaseContext;


public interface Worker {
    void execute(BaseContext context, String[] args) throws Exception;
}
