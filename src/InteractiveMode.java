import commands.Command;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class InteractiveMode {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<Command> activeCommands = Command.activeCommands();
        while (true) {
            String input = scanner.nextLine();
            String[] commands = input.split(" ");
            boolean isPossibleCommand = false;
            for (Command command: activeCommands) {
                if (Objects.equals(command.toString(), commands[0])) {
                    isPossibleCommand = true;
                    if (command.argumentsCount() == commands.length) {
                        System.out.println("YES");
                    } else {
                        System.out.println("ERROR");
                    }
                }
            }
            System.out.println(isPossibleCommand);


        }
    }
}
