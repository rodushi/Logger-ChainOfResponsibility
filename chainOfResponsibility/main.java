
package chainOfResponsibility;


public class main {
    private static abstructLogger getChainOfLoggers(){

      abstructLogger errorLogger = new ErrorLogger(abstructLogger.ERROR);
      abstructLogger fileLogger = new FileLogger(abstructLogger.DEBUG);
      abstructLogger consoleLogger = new ConsoleLogger(abstructLogger.INFO);

      errorLogger.setNextLogger(fileLogger);
      fileLogger.setNextLogger(consoleLogger);

      return errorLogger;	
   }

   public static void main(String[] args) {
      abstructLogger ChainOfLogger = getChainOfLoggers();

      ChainOfLogger.logMessage(abstructLogger.INFO, 
         "This is an information.");

      ChainOfLogger.logMessage(abstructLogger.DEBUG, 
         "This is an debug level information.");

      ChainOfLogger.logMessage(abstructLogger.ERROR, 
         "This is an error information.");
   }
}
