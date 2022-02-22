package commands;

public class ExecuteCommand extends Command{
    @Override
    public int argumentsCount() {
        return 0;
    }

    public ExecuteCommand() {
        super("execute_script file_name", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    @Override
    public String toString() {
        return "execute_script";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }

}
