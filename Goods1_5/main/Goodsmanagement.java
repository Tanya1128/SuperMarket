package javacode.Goods1_5.main;

import com.javacode.Goods1_5.Exception.DuplicateEntryException;
import com.javacode.Goods1_5.Exception.InvalidCredentialsException;
import com.javacode.Goods1_5.Exception.ObjectNotFoundException;
import javacode.Goods1_5.login.ManagersLogin;
import javacode.Goods1_5.login.UsersLogin;
import java.util.Scanner;

public class Goodsmanagement {
    public static void main(String[] args) {
        while (true) {
            System.out.println("---欢迎来到超市商品管理界面---");
            System.out.println("--------请输入登录指令:---------");
            System.out.println("--------管理员请按1--------");
            System.out.println("--------顾客请按2--------");
            System.out.println("--------退出请按3--------");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    try {
                        ManagersLogin._interface();
                    } catch (DuplicateEntryException e) {
                        //e.printStackTrace();
                        System.out.println(e);
                    } catch (ObjectNotFoundException e) {
                        //e.printStackTrace();
                        System.out.println(e);
                    } catch (InvalidCredentialsException e) {
                        //e.printStackTrace();
                        System.out.println(e);
                    }
                    break;
                case "2":
                    try {
                        UsersLogin._interface();
                    } catch (DuplicateEntryException e) {
                        //e.printStackTrace();
                        System.out.println(e);
                    } catch (ObjectNotFoundException e) {
                        //e.printStackTrace();
                        System.out.println(e);
                    } catch (InvalidCredentialsException e) {
                        //e.printStackTrace();
                        System.out.println(e);
                    }
                    break;
                case "3":
                default:
                    System.out.println("已退出，感谢您的使用！");
                    System.exit(0);
            }
        }
    }

}
