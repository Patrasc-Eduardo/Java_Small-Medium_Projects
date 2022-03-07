package lab13.task4;

import java.util.EnumSet;

public abstract class LoggerBase {
    private EnumSet<LogLevel> levelSet;
    private LoggerBase nextInChain;

    public LoggerBase(EnumSet<LogLevel> levelSet) {
        this.levelSet = levelSet;
    }

    public EnumSet<LogLevel> getLevelSet() {
        return levelSet;
    }

    public void setLevelSet(EnumSet<LogLevel> levelSet) {
        this.levelSet = levelSet;
    }

    public LoggerBase getNextInChain() {
        return nextInChain;
    }

    public void setNextInChain(LoggerBase nextLog) {
        this.nextInChain = nextLog;
    }

    public abstract void writeMessage(String text);

    public abstract void message(String text, LogLevel lvl);
}
