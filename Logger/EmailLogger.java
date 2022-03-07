package lab13.task4;

import java.util.EnumSet;

public class EmailLogger extends LoggerBase {
    public EmailLogger(EnumSet<LogLevel> levelSet) {
        super(levelSet);
    }

    @Override
    public void writeMessage(String text) {
        System.out.println("[Email] " + text);
    }

    @Override
    public void message(String text, LogLevel lvl) {
        if (this.getLevelSet().contains(lvl)) {
            writeMessage(text);
        } else {
            this.getNextInChain().message(text, lvl);
        }
    }
}
