package lab13.task4;

import java.util.EnumSet;

public class FileLogger extends LoggerBase {
    public FileLogger(EnumSet<LogLevel> levelSet) {
        super(levelSet);
    }

    @Override
    public void writeMessage(String text) {
        System.out.println("[File] " + text);
    }

    @Override
    public void message(String text, LogLevel lvl) {
        if (this.getLevelSet().contains(lvl)) {
            writeMessage(text);
        }
    }
}
