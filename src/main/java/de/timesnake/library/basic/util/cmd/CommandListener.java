package de.timesnake.library.basic.util.cmd;

import java.util.List;

public interface CommandListener<Sender extends de.timesnake.library.basic.util.cmd.Sender, Argument extends de.timesnake.library.basic.util.cmd.Argument> {

    void onCommand(Sender sender, ExCommand<Sender, Argument> cmd, Arguments<Argument> args);

    List<String> getTabCompletion(ExCommand<Sender, Argument> cmd, Arguments<Argument> args);

}
