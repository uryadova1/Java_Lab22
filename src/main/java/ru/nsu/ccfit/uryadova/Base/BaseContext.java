package ru.nsu.ccfit.uryadova.Base;

import java.util.HashMap;
import java.util.Stack;
import java.io.IOException;
import java.io.File;

//здесь стек и дефайны, изо всех других классов инфа сваливается сюда

public class BaseContext {
    private final Stack<Double> stack;
    private final HashMap<String, Double> defines;
    private String filename;

    public BaseContext() {
        stack = new Stack<>();
        defines = new HashMap<>();
    }

    public BaseContext(String filename) throws IOException {
        this.filename = filename;
        stack = new Stack<>();
        defines = new HashMap<>();
    }

    public String getFileName() {
        return this.filename;
    }

    public void push(double num) {
        stack.push(num);
    }

    public void push(String arg) {
        if (defines.containsKey(arg)) {
            stack.push(defines.get(arg));
        }
    }

    public void pop() {
        stack.pop();
    }

    public double popReturn() {
        return stack.pop();
    }

    public void define(String arg, double num) {
        defines.put(arg, num);
    }

    public Double peek() {
        return stack.peek();
    }

    public double getDefine(String name){
        return defines.get(name);
    }
    public boolean containsArg(String name) {
        return defines.containsKey(name);
    }
}
