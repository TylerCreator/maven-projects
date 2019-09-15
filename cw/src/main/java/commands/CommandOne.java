package commands;

import org.hibernate.Session;

public class CommandOne implements Command, CommandFactory{
    private Session session;
    private String arg1;
    
    @Override
    public void execute() {

        System.out.println("Execute first command with " + arg1);
    }

    public CommandOne(Session session, String agr1) {
        this.session = session;
        this.arg1 = agr1;
    }

    public CommandOne() {        
    }    
    
    @Override
    public Command makeCommand(Session session, String[] arguments) {
        return new CommandOne(session, arguments[0]);
    }

    @Override
    public String getDescription() {
        return "Enter command argument...";
    }

    @Override
    public String[] getArgsTempl() {
        String[] args = {""};
        return args;
    }
    
}
