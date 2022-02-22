package commands;

import FileManagment.sources.Csv;
import FileManagment.sources.possibleFile;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public abstract class Command {
    public Logger logger;

    public abstract int argumentsCount();

    public Command(String command, String description, Logger logger) {
        this.logger = logger;
    }

    public Command(String command, String description) {
    }

    public static List<Command> activeCommands() {
        AddCommand addCommand = new AddCommand();
        AddIfCommand addIfCommand = new AddIfCommand();
        ClearCommand clearCommand = new ClearCommand();
        CountByGenreCommand countByGenreCommand = new CountByGenreCommand();
        ExecuteCommand executeCommand = new ExecuteCommand();
        ExitCommand exitCommand = new ExitCommand();
        FilterContainsCommand filterContainsCommand = new FilterContainsCommand();
        FilterStartsCommand filterStartsCommand = new FilterStartsCommand();
        HelpCommand helpCommand = new HelpCommand();
        HistoryCommand historyCommand = new HistoryCommand();
        InfoCommand infoCommand = new InfoCommand();
        RemoveCommand removeCommand = new RemoveCommand();
        RemoveGreaterCommand removeGreaterCommand = new RemoveGreaterCommand();
        SaveCommand saveCommand = new SaveCommand();
        ShowCommand showCommand = new ShowCommand();
        UpdateCommand updateCommand = new UpdateCommand();
        return Arrays.asList(addCommand, addIfCommand, clearCommand, countByGenreCommand,
                executeCommand, exitCommand, filterContainsCommand, filterStartsCommand, helpCommand, historyCommand,
                infoCommand, removeCommand, removeGreaterCommand, saveCommand, showCommand, updateCommand);
    }

    public abstract String toString();

    public abstract Boolean run(String param);
}
