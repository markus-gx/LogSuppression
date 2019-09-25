package at.geilehner.logger;

import org.slf4j.Marker;

import java.util.Objects;

class LogMessage implements Comparable<LogMessage> {
    private String msg;
    private long timestamp;
    private LogCallback logCallback;
    private LogType logType;

    public LogMessage(String msg, LogType logType, LogCallback logCallback) {
        this.msg = msg;
        this.logType = logType;
        this.logCallback = logCallback;
        this.timestamp = System.currentTimeMillis();
    }

    public void log(){
        logCallback.log();
    }

    public String getMsg() {
        return msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public LogCallback getLogCallback() {
        return logCallback;
    }

    public LogType getLogType() {
        return logType;
    }

    @Override
    public int compareTo(LogMessage o) {
        return Long.compare(timestamp,o.timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogMessage that = (LogMessage) o;
        return Objects.equals(msg, that.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg);
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "msg='" + msg + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
