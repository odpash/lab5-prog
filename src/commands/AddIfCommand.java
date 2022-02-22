package commands;

import exceptions.WrongAmountOfArgumentsException;

import java.util.logging.Level;

public class AddIfCommand extends Command {
    @Override
    public int argumentsCount() {
        return 1;
    }

    public AddIfCommand() {
        super("add_if_max {element}", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
    }

    @Override
    public String toString() {
        return "add_if_max";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }


}
