package net.greet.models;

public class Greeting {
    private String message;
    private boolean showPrompt;

    public Greeting(String msg, boolean showPrompt){
        this.message = msg;
        this.showPrompt = showPrompt;
    }

    public String getMessage(){
        return this.message;
    }
    public boolean showPrompt(){
        return this.showPrompt;
    }
}
