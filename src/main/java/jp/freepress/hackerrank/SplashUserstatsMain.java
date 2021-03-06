package jp.freepress.hackerrank;

import java.util.logging.Logger;

import jp.freepress.hackerrank.splash.AbstractSplashMain;
import jp.freepress.hackerrank.splash.JsonUserStat;
import jp.freepress.hackerrank.splash.UserstatsMainArgs;


/**
 * <p>
 * <code>hackerrank.com</code> user status main class.
 * </p>
 * 
 * @author Hiroshi Yamamoto
 * @since 2012/07/05
 */
public class SplashUserstatsMain extends AbstractSplashMain {

  public static void main(String[] args) {

    UserstatsMainArgs mainArgs = UserstatsMainArgs.parseMainArgs(args);

    SplashUserstatsMain main = new SplashUserstatsMain();

    Logger log = createLogger(SplashUserstatsMain.class);

    log.info("UserStats");
    log.info("=========");
    log.info("Id: " + main.getProcessId());

    // LOGIN
    log.info("Logging in...");
    if (!main.doLogin(mainArgs.username, mainArgs.password)) {
      log.info("Login failed for { username: \""
          + (mainArgs.username == null ? "" : mainArgs.username)
          + "\"}. use -U option or --help for more help.");
      return;
    }
    log.info("Login success.");


    // USERSTATS
    JsonUserStat stat = main.splash.userstats();
    String statStr = JsonUserStat.Util.toSimpleLineString(stat);
    System.out.println(statStr);

    // LOGOUT
    // NOTE: Logging out causes ALL OTHER SESSION TO EXPIRE.
    // log.info("Logging out...");
    // main.doLogout();
    // log.info("Logout success. bye.");
  }

  public SplashUserstatsMain() {
    super(true);
  }

}
