package commands;

public class SaveCommand extends Command {
    @Override
    public int argumentsCount() {
        return 0;
    }

    public SaveCommand() {
        super("save", "сохранить коллекцию в файл");
    }

    @Override
    public String toString() {
        return "save";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }

}
