package ru.nsu.ccfit.uryadova.Base;


public interface Worker {
    void execute(BaseContext context, String[] args) throws Exception;
}
