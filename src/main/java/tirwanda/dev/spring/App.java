package tirwanda.dev.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tirwanda.dev.spring.service.AccountService;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("tirwanda.dev.spring");
        appContext.refresh();

        AccountService accountService = appContext.getBean("accountService", AccountService.class);
        System.out.println("Before money transfer");
        System.out.println("Account 1 balance: " + accountService.getAccount(1L).getBalance());
        System.out.println("Account 2 balance: " + accountService.getAccount(2L).getBalance());
        accountService.transferMoney(1L, 2L, new BigDecimal(10_000));
        System.out.println();
        System.out.println("After money transfer");
        System.out.println("Account 1 balance: " + accountService.getAccount(1L).getBalance());
        System.out.println("Account 2 balance: " + accountService.getAccount(2L).getBalance());
    }
}
