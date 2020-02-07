package dude.command;

import dude.component.IUserInterface;
import dude.component.TaskList;

public class ListCommand extends Command {

    /**
     * Displays all current tasks to user in insertion order.
     * Never throws CommandExecutionException.
     *
     * @param tasks the current TaskList before the command is executed. Can be modified by execute.
     * @param ui the IUserInterface to report results of successful commands.
     */
    @Override
    public void execute(TaskList tasks, IUserInterface ui) {
        if (tasks.taskCount() == 0) {
            ui.respond("You got nothing to do, dude. Ain't that awesome??");
            return;
        }

        ui.respond(() -> {
            ui.speak("These are your tasks, dude:");
            tasks.showFilteredTasks(task -> true)
                    .forEachOrdered(ui::speak);
        });
    }
}
