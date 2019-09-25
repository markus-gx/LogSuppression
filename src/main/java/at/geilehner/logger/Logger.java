package at.geilehner.logger;

import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import java.util.*;

public class Logger implements org.slf4j.Logger {
    private Object reference; //Class Reference for the logger
    private int maxMessage; //The maximum of messages which should be suppressed per suppressDelay
    private long suppressDelay; //The delay for suppression => 1000ms => max. 10 msg
    private String processId;
    private org.slf4j.Logger logger;
    private Map<String, List<LogMessage>> suppressMsgMap;
    private final String delimiter = "$#$";

    private Logger(LoggerBuilder builder){
        this.reference = builder.reference;
        this.maxMessage = builder.maxMessage;
        this.suppressDelay = builder.suppressDelay;
        this.processId = builder.processId;
        if(reference instanceof String){
            this.logger = LoggerFactory.getLogger((String)this.reference);
        }
        else if(reference instanceof Class){
            this.logger = LoggerFactory.getLogger((Class)this.reference);
        }
        this.suppressMsgMap = new HashMap<>();
    }

    public String getName() {
        return this.logger.getName();
    }

    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    public void trace(String msg) {
        log(new LogMessage(msg,LogType.TRACE,() -> this.logger.trace(msg)));
    }

    public void trace(String format, Object arg) {
        log(new LogMessage(format+"arg",LogType.TRACE,() -> this.logger.trace(format,arg)));
    }

    public void trace(String format, Object arg1, Object arg2) {
        log(new LogMessage(format+"arg12",LogType.TRACE,() -> this.logger.trace(format,arg1,arg2)));
    }

    public void trace(String format, Object... arguments) {
        log(new LogMessage(format+"args",LogType.TRACE,() -> this.logger.trace(format,arguments)));
    }

    public void trace(String msg, Throwable t) {
        log(new LogMessage(msg+"throwt",LogType.TRACE,() -> this.logger.trace(msg,t)));
    }

    public boolean isTraceEnabled(Marker marker) {
        return this.logger.isTraceEnabled(marker);
    }

    public void trace(Marker marker, String msg) {
        log(new LogMessage(msg+"marker",LogType.TRACE,() -> this.logger.trace(marker,msg)));
    }

    public void trace(Marker marker, String format, Object arg) {
        log(new LogMessage(format+"farg",LogType.TRACE,() -> this.logger.trace(marker,format,arg)));
    }

    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        log(new LogMessage(format+"faarg",LogType.TRACE,() -> this.logger.trace(marker,format,arg1,arg2)));
    }

    public void trace(Marker marker, String format, Object... argArray) {
        log(new LogMessage(format+"farrg",LogType.TRACE,() -> this.logger.trace(marker,format,argArray)));
    }

    public void trace(Marker marker, String msg, Throwable t) {
        log(new LogMessage(msg+"mmt",LogType.TRACE,() -> this.logger.trace(marker,msg,t)));
    }

    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    public void debug(String msg) {
        log(new LogMessage(msg,LogType.DEBUG,() -> this.logger.debug(msg)));
    }

    public void debug(String format, Object arg) {
        log(new LogMessage(format+"arg",LogType.DEBUG,() -> this.logger.debug(format,arg)));
    }

    public void debug(String format, Object arg1, Object arg2) {
        log(new LogMessage(format+"arg12",LogType.DEBUG,() -> this.logger.debug(format,arg1,arg2)));
    }

    public void debug(String format, Object... arguments) {
        log(new LogMessage(format+"args",LogType.DEBUG,() -> this.logger.debug(format,arguments)));
    }

    public void debug(String msg, Throwable t) {
        log(new LogMessage(msg+"throwt",LogType.DEBUG,() -> this.logger.debug(msg,t)));
    }

    public boolean isDebugEnabled(Marker marker) {
        return this.logger.isDebugEnabled(marker);
    }

    public void debug(Marker marker, String msg) {
        log(new LogMessage(msg+"marker",LogType.DEBUG,() -> this.logger.debug(marker,msg)));
    }

    public void debug(Marker marker, String format, Object arg) {
        log(new LogMessage(format+"farg",LogType.DEBUG,() -> this.logger.debug(marker,format,arg)));
    }

    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        log(new LogMessage(format+"faarg",LogType.DEBUG,() -> this.logger.debug(marker,format,arg1,arg2)));
    }

    public void debug(Marker marker, String format, Object... arguments) {
        log(new LogMessage(format+"farrg",LogType.DEBUG,() -> this.logger.debug(marker,format,arguments)));
    }

    public void debug(Marker marker, String msg, Throwable t) {
        log(new LogMessage(msg+"mmt",LogType.DEBUG,() -> this.logger.debug(marker,msg,t)));
    }

    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    public void info(String msg) {
        log(new LogMessage(msg,LogType.INFO, () -> this.logger.info(msg)));
    }

    public void info(String format, Object arg) {
        log(new LogMessage(format+"arg",LogType.INFO,() -> this.logger.info(format,arg)));
    }

    public void info(String format, Object arg1, Object arg2) {
        log(new LogMessage(format+"arg12",LogType.INFO,() -> this.logger.info(format,arg1,arg2)));
    }

    public void info(String format, Object... arguments) {
        log(new LogMessage(format+"args",LogType.INFO,() -> this.logger.info(format,arguments)));
    }

    public void info(String msg, Throwable t) {
        log(new LogMessage(msg+"throwt",LogType.INFO,() -> this.logger.info(msg,t)));
    }

    public boolean isInfoEnabled(Marker marker) {
        return this.logger.isInfoEnabled(marker);
    }

    public void info(Marker marker, String msg) {
        log(new LogMessage(msg+"marker",LogType.INFO,() -> this.logger.info(marker,msg)));
    }

    public void info(Marker marker, String format, Object arg) {
        log(new LogMessage(format+"farg",LogType.INFO,() -> this.logger.info(marker,format,arg)));
    }

    public void info(Marker marker, String format, Object arg1, Object arg2) {
        log(new LogMessage(format+"faarg",LogType.INFO,() -> this.logger.info(marker,format,arg1,arg2)));
    }

    public void info(Marker marker, String format, Object... arguments) {
        log(new LogMessage(format+"farrg",LogType.INFO,() -> this.logger.info(marker,format,arguments)));
    }

    public void info(Marker marker, String msg, Throwable t) {
        log(new LogMessage(msg+"mmt",LogType.INFO,() -> this.logger.info(marker,msg,t)));
    }

    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    public void warn(String msg) {
        log(new LogMessage(msg,LogType.WARN,() -> this.logger.warn(msg)));
    }

    public void warn(String format, Object arg) {
        log(new LogMessage(format+"arg",LogType.WARN,() -> this.logger.warn(format,arg)));
    }

    public void warn(String format, Object... arguments) {
        log(new LogMessage(format+"args",LogType.WARN,() -> this.logger.warn(format,arguments)));
    }

    public void warn(String format, Object arg1, Object arg2) {
        log(new LogMessage(format+"arg12",LogType.WARN,() -> this.logger.warn(format,arg1,arg2)));
    }

    public void warn(String msg, Throwable t) {
        log(new LogMessage(msg+"throwt",LogType.WARN,() -> this.logger.warn(msg,t)));
    }

    public boolean isWarnEnabled(Marker marker) {
        return this.logger.isWarnEnabled(marker);
    }

    public void warn(Marker marker, String msg) {
        log(new LogMessage(msg+"marker",LogType.WARN,() -> this.logger.warn(marker,msg)));
    }

    public void warn(Marker marker, String format, Object arg) {
        log(new LogMessage(format+"farg",LogType.WARN,() -> this.logger.warn(marker,format,arg)));
    }

    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        log(new LogMessage(format+"faarg",LogType.WARN,() -> this.logger.warn(marker,format,arg1,arg2)));
    }

    public void warn(Marker marker, String format, Object... arguments) {
        log(new LogMessage(format+"farrg",LogType.WARN,() -> this.logger.warn(marker,format,arguments)));
    }

    public void warn(Marker marker, String msg, Throwable t) {
        log(new LogMessage(msg+"mmt",LogType.WARN,() -> this.logger.warn(marker,msg,t)));
    }

    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    public void error(String msg) {
        log(new LogMessage(msg,LogType.ERROR,() -> this.logger.error(msg)));
    }

    public void error(String format, Object arg) {
        log(new LogMessage(format+"arg",LogType.ERROR,() -> this.logger.error(format,arg)));
    }

    public void error(String format, Object arg1, Object arg2) {
        log(new LogMessage(format+"arg12",LogType.ERROR,() -> this.logger.error(format,arg1,arg2)));
    }

    public void error(String format, Object... arguments) {
        log(new LogMessage(format+"args",LogType.ERROR,() -> this.logger.error(format,arguments)));
    }

    public void error(String msg, Throwable t) {
        log(new LogMessage(msg+"throwt",LogType.ERROR,() -> this.logger.error(msg,t)));
    }

    public boolean isErrorEnabled(Marker marker) {
        return this.logger.isErrorEnabled(marker);
    }

    public void error(Marker marker, String msg) {
        log(new LogMessage(msg+"marker",LogType.ERROR,() -> this.logger.error(marker,msg)));
    }

    public void error(Marker marker, String format, Object arg) {
        log(new LogMessage(format+"farg",LogType.ERROR,() -> this.logger.error(marker,format,arg)));
    }

    public void error(Marker marker, String format, Object arg1, Object arg2) {
        log(new LogMessage(format+"faarg",LogType.ERROR,() -> this.logger.error(marker,format,arg1,arg2)));
    }

    public void error(Marker marker, String format, Object... arguments) {
        log(new LogMessage(format+"farrg",LogType.ERROR,() -> this.logger.error(marker,format,arguments)));
    }

    public void error(Marker marker, String msg, Throwable t) {
        log(new LogMessage(msg+"mmt",LogType.ERROR,() -> this.logger.error(marker,msg,t)));
    }

    private void log(LogMessage logMessage){

        List<LogMessage> messages = this.suppressMsgMap.remove(logMessage.getMsg()+delimiter+logMessage.getLogType());
        if(messages == null || messages.isEmpty()){
            logMessage.log();
            messages = new ArrayList<>(Arrays.asList(logMessage));
            suppressMsgMap.put(logMessage.getMsg()+delimiter+logMessage.getLogType(),messages);
        }
        else{
            removeOldEntries(messages);
            if(messages.size() < this.maxMessage){
                messages.add(logMessage);
                logMessage.log();
            }
            suppressMsgMap.put(logMessage.getMsg()+delimiter+logMessage.getLogType(),messages);
        }
    }

    private void removeOldEntries(List<LogMessage> messages){
        messages.removeIf(message -> System.currentTimeMillis() - message.getTimestamp() > this.suppressDelay);
    }

    public static class LoggerBuilder{
        private Object reference = "Logger";
        private int maxMessage = 10; //The maximum of messages which should be suppressed per suppressDelay
        private long suppressDelay = 1000; //The delay for suppression => 1000ms => max. 10 msg
        private String processId;

        /***
         * Constructs the LoggerBuilder
         */
        public LoggerBuilder(){
        }


        /***
         * A reference for the logger, either class or a String. Default = "Logger"
         * @param reference
         * @return
         */
        public LoggerBuilder reference(Class reference){
            this.reference = reference;
            return this;
        }

        /***
         * A reference for the logger, either class or a String. Default ="Logger"
         * @param reference
         * @return
         */
        public LoggerBuilder reference(String reference){
            this.reference = reference;
            return this;
        }

        /**
         * The maximum of messages which should be suppressed wtihin a specific delay. Default = 10
         * @param max
         * @return
         */
        public LoggerBuilder maxMessagesPerDelay(int max){
            this.maxMessage = max;
            return this;
        }

        /***
         * The delay when a suppression should be deleted. Default = 1000ms
         * @param ms
         * @return
         */
        public LoggerBuilder suppressDelay(long ms){
            this.suppressDelay = ms;
            return this;
        }

        /***
         * To get the processID Default = null
         * @param id
         * @return
         */
        public LoggerBuilder processId(String id){
            this.processId = id;
            return this;
        }

        public Logger build(){
            return new Logger(this);
        }
    }

}
