# LogSuppression
Suppress logs of the same kind an log only a specific maximum of it. 
A small extension or encapsulation of the classic SL4J (https://www.slf4j.org) logger so that various loggings can be suppressed and no log "spam" occurs.

#How It Works
Instead of using `LoggerFactory.getLogger()` to receive your Logger you have to use `Logger.LoggerBuilder()` to receive a Logger implementing the SL4J Logger Interface. 
With this logger you can now use every method available in this interface (like the normal one), but now logs are now suppressed based on your configuration. 

#Configuration
Example (The following configuration means that every 5s (5000 ms) a maximum of 2 logs can be logged of any kind) 
```
Logger logger = new at.geilehner.logger.Logger.LoggerBuilder()
                .maxMessagesPerDelay(2)
                .suppressDelay(5000)
                .reference(ExampleTest.class).build();


*maxMessagesPerDelay(int max)* 
The maximum number of logs to be issued in a given period of time. Default value = 10. 

*suppressDelay(long ms)*
The period in which a maximum of X logs may be issued.

*reference*
The Reference or the name for the logger which is returned. Can be either of type Class or String. 


#Example And Output Example

```
Logger logger = new at.geilehner.logger.Logger.LoggerBuilder()
                .maxMessagesPerDelay(2)
                .suppressDelay(5000)
                .reference(ExampleTest.class).build();
//Example                
for(int i = 0; i < 100; i++){
    logger.info("test");
    logger.error("test");
    logger.warn("test");
    Thread.sleep(250);
}
```

As you can see in the output various loggs are removed / suppressed by the system. Only (max) two are logged of any kind.

```
50 [main] INFO ExampleTest - test
50 [main] ERROR ExampleTest - test
51 [main] WARN ExampleTest - test
303 [main] INFO ExampleTest - test
303 [main] ERROR ExampleTest - test
303 [main] WARN ExampleTest - test
5085 [main] INFO ExampleTest - test
5086 [main] ERROR ExampleTest - test
5086 [main] WARN ExampleTest - test
5336 [main] INFO ExampleTest - test
5336 [main] ERROR ExampleTest - test
5336 [main] WARN ExampleTest - test
10141 [main] INFO ExampleTest - test
10141 [main] ERROR ExampleTest - test
10141 [main] WARN ExampleTest - test
10393 [main] INFO ExampleTest - test
10394 [main] ERROR ExampleTest - test
10394 [main] WARN ExampleTest - test
```
