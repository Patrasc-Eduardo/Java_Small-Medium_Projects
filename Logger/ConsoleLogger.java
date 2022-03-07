package lab13.task4;

import java.util.EnumSet;

public class ConsoleLogger extends LoggerBase {
    public ConsoleLogger(EnumSet<LogLevel> levelSet) {
        super(levelSet);
    }

    @Override
    public void writeMessage(String text) {
        System.out.println("[Console] " + text);
    }

    @Override
    public void message(String text, LogLevel lvl) {
        writeMessage(text);
        getNextInChain().message(text, lvl);
    }
}
