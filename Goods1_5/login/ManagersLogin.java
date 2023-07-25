package javacode.Goods1_5.login;

import com.javacode.Goods1_5.Exception.DuplicateEntryException;
import com.javacode.Goods1_5.Exception.InvalidCredentialsException;
import com.javacode.Goods1_5.Exception.InvalidInputException;
import com.javacode.Goods1_5.Exception.ObjectNotFoundException;
import javacode.Goods1_5.Product.Goods;
import javacode.Goods1_5.main.Manager;

import java.util.*;

public class ManagersLogin extends Services {

    public static void _interface()throws ObjectNotFoundException, InvalidCredentialsException,DuplicateEntryException
    {
        List<javacode.Goods1_5.Product.Goods.Fruit> fruits = new ArrayList<>();
        List<javacode.Goods1_5.Product.Goods.Meat> meats=new ArrayList<>();
        List<javacode.Goods1_5.Product.Goods.Vegetable> vegetables=new ArrayList<>();
        Map<String, Manager> managerMap;
        managerMap=new HashMap<>();

        Manager manager0=new Manager("Tanya","6208better");
        managerMap.put("Tanya",manager0);
        Services sup=new ManagersLogin();
        List<Goods> goods= new ArrayList<>();

        fruits.add(new javacode.Goods1_5.Product.Goods.Fruit(1, "西瓜", 9, 999));
        vegetables.add(new javacode.Goods1_5.Product.Goods.Vegetable(2, "茄子", 6, 999));
        meats.add(new javacode.Goods1_5.Product.Goods.Meat(3, "牛肉", 45, 999));

        System.out.println("请输入超市管理员密钥：");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();

        if(a==Manager.PIN){
            System.out.println("识别成功，您已进入超市管理员登陆/注册界面");
        }
        else {
            System.out.println("识别失败，请重新登录");
            System.exit(0);
        }
        System.out.println("登录请按1，注册请按2");
        Scanner sc1=new Scanner(System.in);
        int b=sc1.nextInt();
        switch (b) {
            case 1:
                System.out.println("请输入管理员登录名：");
                Scanner sc2 = new Scanner(System.in);
                String c = sc2.nextLine();
                if(!managerMap.containsKey(c)){
                    throw new ObjectNotFoundException("该管理员不存在");
                }
                System.out.println("请输入该管理员登录密码");
                String d=sc2.nextLine();
                Manager x=managerMap.get(c);
                if(!(x.authenticate(d))){
                    throw new InvalidCredentialsException("密码错误，请重新输入");
                }
                else {
                    System.out.println("登录成功");
                }
                break;
            case 2:
                System.out.println("请输入管理员注册名：");
                Scanner sc3 = new Scanner(System.in);
                String e = sc3.nextLine();
                if(managerMap.containsKey(e)){
                    throw new DuplicateEntryException("该管理员已存在");
                }
                System.out.println("请设置密码");
                Scanner sc4 = new Scanner(System.in);
                String f = sc4.nextLine();
                Manager x1=new Manager(e,f);
                managerMap.put(e,x1);
                System.out.println("注册成功,正在进入超市界面");
                break;
        }
        while (true) {
            System.out.println("---欢迎来到超市管理员的商品管理界面---");
            show(fruits,meats,vegetables);
            System.out.println("--------请输入指令:---------");
            System.out.println("--------增加商品请按1--------");
            System.out.println("--------查询商品请按2--------");
            System.out.println("--------删除商品请按3--------");
            System.out.println("------更改商品信息请按4------");
            System.out.println("--------退出界面请按5--------");
            Scanner sc3 = new Scanner(System.in);
            String choice = sc3.nextLine();
            switch (choice) {
                case "1":
                    try {
                        sup.addMarketProducts(fruits,meats,vegetables);
                    } catch (InvalidInputException | DuplicateEntryException e) {
                        System.out.println(e);
                    }
                    break;
                case "2":
                    try {
                        sup.searchProducts(fruits,meats,vegetables);
                    } catch (InvalidInputException e) {
                        System.out.println(e);
                    }
                    break;
                case "3":
                    try {
                        sup.deleteProducts(fruits,meats,vegetables);
                    } catch (InvalidInputException e) {
                        System.out.println(e);
                    } catch (DuplicateEntryException e) {
                        System.out.println(e);
                    }
                    break;
                case "4":
                    try {
                        sup.changeProducts(fruits,meats,vegetables);
                    } catch (InvalidInputException e) {
                        System.out.println(e);
                    }
                    break;
                case "5":
                default:
                    System.out.println("已退出，感谢您的使用！");
                    System.exit(0);
            }
        }
    }

}

