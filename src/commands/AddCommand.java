package commands;

import exceptions.WrongAmountOfArgumentsException;

import java.util.logging.Level;

public class AddCommand extends Command {
    public AddCommand() {
        super("add {element}", "добавить новый элемент в коллекцию");
    }

    @Override
    public int argumentsCount() {
        return 1;
    }

    @Override
    public String toString() {
        return "add";
    }

    @Override
    public Boolean run(String param) {
       return null;
    }

}
