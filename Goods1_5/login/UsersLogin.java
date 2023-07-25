package javacode.Goods1_5.login;

import com.javacode.Goods1_5.Exception.DuplicateEntryException;
import com.javacode.Goods1_5.Exception.InvalidCredentialsException;
import com.javacode.Goods1_5.Exception.InvalidInputException;
import com.javacode.Goods1_5.Exception.ObjectNotFoundException;
import javacode.Goods1_5.Product.Goods;
import javacode.Goods1_5.main.User;

import java.util.*;

public class UsersLogin extends Services {
    public static double discount = 1.0;

    public static void _interface() throws DuplicateEntryException, ObjectNotFoundException, InvalidCredentialsException {
        //UsersLogin manager=new UsersLogin();
        //List<Goods> goods = new ArrayList<>();
        List<Goods.Fruit> fruits = new ArrayList<>();
        List<Goods.Meat> meats = new ArrayList<>();
        List<Goods.Vegetable> vegetables = new ArrayList<>();

        Map<String, User> users;
        users = new HashMap<>();
        Services sur = new UsersLogin();

//        goods.add(new Goods.Fruit(1, "西瓜", 9, 999));
//        goods.add(new Goods.Vegetable(2, "茄子", 6, 999));
//        goods.add(new Goods.Meat(3, "牛肉", 45, 999));

        fruits.add(new Goods.Fruit(1, "西瓜", 9, 999));
        vegetables.add(new Goods.Vegetable(2, "茄子", 6, 999));
        meats.add(new Goods.Meat(3, "牛肉", 45, 999));

        System.out.println("是否为会员");
        System.out.println("是请按1，不是请按2");
        Scanner sc0 = new Scanner(System.in);
        int x0 = sc0.nextInt();

        User T = new User();
        switch (x0) {
            case 1:
                System.out.println("请输入会员验证码：");
                Scanner sc = new Scanner(System.in);
                int x = sc.nextInt();

                if (x == 666) {
                    discount = 0.6;
                    System.out.println("会员验证成功，您拥有一切商品六折优惠");
                } else {
                    System.out.println("会员验证码错误，请重新输入");
                }
                break;
            case 2:
                System.out.println("顾客您好，正在进入登陆界面,请稍等");
                System.out.println("=======");
                break;
        }

        User newUser0 = new User("Tanya", "better6208");
        users.put("Tanya", newUser0);
        System.out.println("欢迎来到用户登录/注册界面");
        System.out.println("登录请按1，注册请按2");
        Scanner sc5 = new Scanner(System.in);
        int x5 = sc5.nextInt();

        //UsersLogin usersLogin=new UsersLogin();
        switch (x5) {
            case 1:
                System.out.println("请输入用户名：");
                Scanner sc1 = new Scanner(System.in);
                String b = sc1.nextLine();
                if (!users.containsKey(b)) {
                    throw new ObjectNotFoundException("该用户不存在");
                }

                System.out.println("请输入该用户登录密码");
                Scanner sc2 = new Scanner(System.in);
                String c = sc2.nextLine();
                User user = users.get(b);
                if (!user.authenticate(c)) {
                    throw new InvalidCredentialsException("密码错误,请重新输入");
                } else {
                    System.out.println("密码正确,登录成功");
                }
                break;
            case 2:
                System.out.println("请输入用户注册名：");
                Scanner sc3 = new Scanner(System.in);
                String d = sc3.nextLine();

                System.out.println("请设置密码");
                Scanner sc4 = new Scanner(System.in);
                String e = sc4.nextLine();

                if (users.containsKey(d)) {
                    throw new DuplicateEntryException("该用户名已存在");
                }
                User newUser1 = new User(d, e);
                users.put(d, newUser1);
                System.out.println("注册成功，正在进入超市界面");
                break;
        }

        while (true) {
            System.out.println("---欢迎来到超市商品界面---");
//            for (Goods good : goods) {
//                if (goods.size() == 0) {
//                    System.out.println("暂无商品信息");
//                    break;
//                } else {
//                    System.out.println("名字：" + good.getName() + "  序号:" + good.getSid() + "  价格" + good.getPrice() + "  折扣" + good.getDiscount() + "   库存" + good.stock);
//                }
//            }
            show(fruits, meats, vegetables);
            System.out.println("--------请输入指令:---------");
            System.out.println("--------查询商品信息请按1--------");
            System.out.println("--------购买商品请按2---------");
            System.out.println("--------退出界面请按3--------");
            Scanner sc3 = new Scanner(System.in);
            String choice = sc3.nextLine();
            switch (choice) {
                case "1":
                    try {
                        sur.searchProducts(fruits, meats, vegetables);
                    } catch (InvalidInputException e) {
                        //e.printStackTrace();
                        System.out.println(e);
                    }
                    break;
                case "2":
                    try {
                        sur.calculateTotal(fruits, meats, vegetables);
                    } catch (InvalidInputException e) {
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
