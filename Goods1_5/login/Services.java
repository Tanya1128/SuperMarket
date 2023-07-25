package javacode.Goods1_5.login;

import com.javacode.Goods1_5.Exception.DuplicateEntryException;
import com.javacode.Goods1_5.Exception.InvalidInputException;
import javacode.Goods1_5.Product.Goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Services implements javacode.Goods1_5.login.Sur {
    List<Goods> goods = new ArrayList<>();
//    List<Goods.Fruit> fruits0 = new ArrayList<>();
//    List<Goods.Meat> meats0=new ArrayList<>();
//    List<Goods.Vegetable> vegetables0=new ArrayList<>();

    public void addMarketProducts(List<Goods.Fruit> fruits, List<Goods.Meat> meats, List<Goods.Vegetable> vegetables) throws InvalidInputException, DuplicateEntryException {
//        fruits0=fruits;
//        meats0=meats;
//        vegetables0=vegetables;

//        fruits=fruits0;
//        meats=meats0;
//        vegetables=vegetables0;

        Scanner sc = new Scanner(System.in);
        System.out.println("添加前的商品信息为：");
        show(fruits, meats, vegetables);
        System.out.println("请输入要添加的商品类型：1:水果  2:蔬菜  3:肉类");
        int a = sc.nextInt();
        System.out.println("请输入要添加的商品的名字：");
        Scanner sc1 = new Scanner(System.in);
        String b = sc1.nextLine();
        System.out.println("请输入要添加的商品的序号：");
        int c = sc.nextInt();
        System.out.println("请输入要添加的商品的价格：");
        int d = sc.nextInt();
        System.out.println("请输入要添加的商品的库存：");
        int e = sc.nextInt();

        if (a < 0 || b.isEmpty() || c <= 0 || d <= 0 || e <= 0) {
            throw new InvalidInputException("输入的商品数据不合法");
        }

        for (Goods good : goods) {
            if (good.getName().equals(b)) {
                throw new DuplicateEntryException("该商品已存在");
            }
        }

        goods.add(new Goods.Fruit(c, b, d, e));
        if (a == 1) {
            fruits.add(new Goods.Fruit(c, b, d, e));
            System.out.println("添加成功,添加后的水果商品信息为:");
            for (Goods.Fruit fruit : fruits) {
                System.out.println("名字： " + fruit.getName() + "  序号:" + fruit.getSid() + "  价格" + fruit.getPrice() + "  折扣" + fruit.getDiscount());
            }
        } else if (a == 2) {
            vegetables.add(new Goods.Vegetable(c, b, d, e));
            System.out.println("添加成功,添加后的蔬菜商品信息为");
            for (Goods.Vegetable vegetable : vegetables) {
                System.out.println("名字:  " + vegetable.getName() + "  序号:" + vegetable.getSid() + "  价格" + vegetable.getPrice() + "  折扣" + vegetable.getDiscount());
            }

        } else if (a == 3) {
            meats.add(new Goods.Meat(c, b, d, e));
            System.out.println("添加成功,添加后的肉类商品信息为");
            for (Goods.Meat meat : meats) {
                System.out.println("名字：" + meat.getName() + "  序号:" + meat.getSid() + "  价格" + meat.getPrice() + "  折扣" + meat.getDiscount());
            }
        }
    }

    /*@Override
    public void addStockProducts(Goods good) {
        goods.add(good);
    }*/
    @Override
    public void deleteProducts(List<Goods.Fruit> fruits, List<Goods.Meat> meats, List<Goods.Vegetable> vegetables) throws InvalidInputException, DuplicateEntryException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的商品类型：1:水果  2:蔬菜  3:肉类");
        int a = sc.nextInt();

        System.out.println("请输入要删除的商品名称：");
        String b = sc.nextLine();

        if (a < 0 || b.isEmpty()) {
            throw new InvalidInputException("输入的数据不合法");
        }

        for (Goods good : goods) {
            if (good.getName().equals(b)) {
                throw new DuplicateEntryException("该商品已存在");
            }
        }
        int flag = 0;
        if (a == 1) {
            for (int i = 0; i < fruits.size(); i++) {
                if (fruits.get(i).getName().equals(a)) ;
                {
                    fruits.remove(fruits.get(i));
                    goods.remove(fruits.get(i));
                    System.out.println("删除成功");
                    flag = 1;
                    break;
                }
            }
        } else if (a == 2) {
            for (int i = 0; i < vegetables.size(); i++) {
                if (vegetables.get(i).getName().equals(a)) ;
                {
                    vegetables.remove(vegetables.get(i));
                    System.out.println("删除成功");
                    flag = 1;
                    break;
                }
            }

        } else if (a == 3) {
            for (int i = 0; i < meats.size(); i++) {
                if (meats.get(i).getName().equals(a)) ;
                {
                    meats.remove(meats.get(i));
                    System.out.println("删除成功");
                    flag = 1;
                    break;
                }
            }
        }

        System.out.print("删除后");
        show(fruits, meats, vegetables);
        if (flag == 0) {
            System.out.println("找不到该商品，请确认输入无误后再输入");
        }
    }

    public void changeProducts(List<Goods.Fruit> fruits, List<Goods.Meat> meats, List<Goods.Vegetable> vegetables) throws InvalidInputException {
        Scanner sc = new Scanner(System.in);
        show(fruits, meats, vegetables);
        System.out.println("请输入要更改的商品类型：1:水果  2:蔬菜  3:肉类");
        int a = sc.nextInt();
        System.out.println("请输入要更改的商品名称：");
        Scanner sc1 = new Scanner(System.in);
        String b = sc1.nextLine();
        System.out.println("请输入更改后的商品序号：");
        int c = sc.nextInt();
        System.out.println("请输入更改后的商品价格：");
        int d = sc.nextInt();
        System.out.println("请输入要更改后的商品库存：");
        int e = sc.nextInt();

        if (a < 0 || b.isEmpty() || c <= 0 || d <= 0 || e <= 0) {
            throw new InvalidInputException("输入的数据不合法");
        }
        if (goods.size() == 0) {
            System.out.println("暂无商品信息");
        }

        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).getName().equals(a)) {
                goods.set(i, new Goods.Fruit(c, b, d, e));
                break;
            }
        }
        if (a == 1) {
            for (int i = 0; i < fruits.size(); i++) {
                if (fruits.get(i).getName().equals(a)) ;
                {
                    fruits.set(i, new Goods.Fruit(c, b, d, e));
                    System.out.println("更改成功");
                    break;
                }
            }
        } else if (a == 2) {
            for (int i = 0; i < vegetables.size(); i++) {
                if (vegetables.get(i).getName().equals(a)) ;
                {
                    vegetables.set(i, new Goods.Vegetable(c, b, d, e));
                    System.out.println("更改成功");
                    break;
                }
            }
        } else if (a == 3) {
            for (int i = 0; i < meats.size(); i++) {
                if (meats.get(i).getName().equals(a)) ;
                {
                    meats.set(i, new Goods.Meat(c, b, d, e));
                    System.out.println("更改成功");
                    break;
                }
            }
        } else {
            System.out.println("商品类型输入错误");

        }
        show(fruits, meats, vegetables);
    }

    public void searchProducts(List<Goods.Fruit> fruits,List<Goods.Meat> meats,List<Goods.Vegetable> vegetables) throws InvalidInputException{
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的商品类型：1:水果  2:蔬菜  3:肉类");
        int a = sc.nextInt();
        System.out.println("请输入要查询的商品名称：");
        Scanner sc0=new Scanner(System.in);
        String b = sc0.nextLine();

        if(a<=0){
            throw new InvalidInputException("输入的数据不合法");
        }
        int flag = 0;
        if (a == 1) {
            for (int i = 0; i < fruits.size(); i++) {
                if (fruits.get(i).getName().equals(b)) ;
                {
                    System.out.println("查询成功，该商品的信息为：");
                    System.out.println("名称：" + fruits.get(i).getName() + "  序号:" + fruits.get(i).getSid() + "  价格:" + fruits.get(i).getPrice() + "  折扣:" + fruits.get(i).getDiscount() + "   库存:" + fruits.get(i).stock);
                    flag = 1;
                    break;
                }
            }
        } else if (a == 2) {
            for (int i = 0; i < vegetables.size(); i++) {
                if (vegetables.get(i).getName().equals(b)) ;
                {
                    System.out.println("查询成功，该商品的信息为：");
                    System.out.println("名称：" + vegetables.get(i).getName() + "  序号:" + vegetables.get(i).getSid() + "  价格:" + vegetables.get(i).getPrice() + "  折扣:" + vegetables.get(i).getDiscount() + "   库存:" + vegetables.get(i).stock);
                    flag = 1;
                    break;
                }
            }
        } else if (a == 3) {
            for (int i = 0; i < meats.size(); i++) {
                if (meats.get(i).getName().equals(b)) ;
                {
                    System.out.println("查询成功，该商品的信息为：");
                    System.out.println("名称：" + meats.get(i).getName() + "  序号:" + meats.get(i).getSid() + "  价格:" + meats.get(i).getPrice() + "  折扣:" + meats.get(i).getDiscount() + "   库存:" + meats.get(i).stock);
                    flag = 1;
                    break;
                }
            }
        } else {
            System.out.println("商品类型输入错误");

        }
        if (flag == 0) {
            System.out.println("找不到该商品，请确认输入无误后再输入");
        }
    }

    public void calculateTotal(List<Goods.Fruit> fruits,List<Goods.Meat> meats,List<Goods.Vegetable> vegetables) throws InvalidInputException {
        boolean x = true;
        double Spend = 0;
        int flag = 0;
            while (x) {
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入要购买的商品类型：1:水果区  2:蔬菜区  3:肉类区");
                int a = sc.nextInt();
                if (a<=0) {
                    throw new InvalidInputException("输入的数据不合法");
                }
                System.out.println("请输入要购买的商品名字：");
                Scanner sc0=new Scanner(System.in);
                String b = sc0.nextLine();
                if (a == 1) {
                    for (int i = 0; i < fruits.size(); i++) {
                        if (fruits.get(i).getName().equals(b)) ;
                        {
                            System.out.println("该商品的信息为：");
                            System.out.println("名称：" + fruits.get(i).getName() + "  序号:" + fruits.get(i).getSid() + "  价格:" + fruits.get(i).getPrice() + "  折扣:" + fruits.get(i).getDiscount() + "   库存:" + fruits.get(i).stock);
                            System.out.println("请输入要购买的数量：");
                            Scanner sc1 = new Scanner(System.in);
                            int num = sc1.nextInt();
                            if (num <= 0) {
                                throw new InvalidInputException("输入的数据不合法");
                            }
                            System.out.print("购买成功，您目前所购买的的总金额为：");
                            Spend = Spend + fruits.get(i).getPrice() * num;
                            System.out.println(Spend);
                            flag = 1;
                        }
                    }
                } else if (a == 2) {
                    for (int i = 0; i < vegetables.size(); i++) {
                        if (vegetables.get(i).getName().equals(b)) ;
                        {
                            System.out.println("该商品的信息为：");
                            System.out.println("名称：" + vegetables.get(i).getName() + "  序号:" + vegetables.get(i).getSid() + "  价格:" + vegetables.get(i).getPrice() + "  折扣:" + vegetables.get(i).getDiscount() + "   库存:" + vegetables.get(i).stock);
                            System.out.println("请输入要购买的数量：");
                            Scanner sc1 = new Scanner(System.in);
                            int num = sc1.nextInt();
                            if (num <= 0) {
                                throw new InvalidInputException("输入的数据不合法");
                            }
                            System.out.print("购买成功，您目前所购买的的总金额为：");
                            Spend = Spend + vegetables.get(i).getPrice() * num;
                            System.out.println(Spend);
                            flag = 1;
                        }
                    }
                } else if (a == 3) {
                    for (int i = 0; i < meats.size(); i++) {
                        if (meats.get(i).getName().equals(b)) ;
                        {
                            System.out.println("该商品的信息为：");
                            System.out.println("名称：" + meats.get(i).getName() + "  序号:" + meats.get(i).getSid() + "  价格:" + meats.get(i).getPrice() + "  折扣:" + meats.get(i).getDiscount() + "   库存:" + meats.get(i).stock);
                            System.out.println("请输入要购买的数量：");
                            Scanner sc1 = new Scanner(System.in);
                            int num = sc1.nextInt();
                            if (num <= 0) {
                                throw new InvalidInputException("输入的数据不合法");
                            }
                            System.out.print("购买成功，您目前所购买的的总金额为：");
                            Spend = Spend + meats.get(i).getPrice() * num;
                            System.out.println(Spend);
                            flag = 1;
                        }
                    }
                }
                if (flag == 0) {
                    System.out.println("找不到该商品，请确认输入无误后再输入");
                    x = true;
                } else {
                    System.out.println("购买成功，继续购买请按1，退出请按2");
                    Scanner sc2 = new Scanner(System.in);
                    int c = sc2.nextInt();
                    if (c == 1) {
                        continue;
                    } else {
                        break;
                    }
                }

            }
            System.out.println("您所购买的商品总金额大约为:" + Spend);
    }

    public static void show(List<Goods.Fruit> fruits,List<Goods.Meat> meats,List<Goods.Vegetable> vegetables) {
        System.out.println("该超市的水果信息如下：");
        for (Goods.Fruit fruit : fruits) {
            if (fruits.size() == 0) {
                System.out.println("暂无商品信息");
                break;
            } else {
                System.out.println("名字：" + fruit.getName() + "  序号:" + fruit.getSid() + "  价格" + fruit.getPrice() + "  折扣" + fruit.getDiscount() + "   库存" + fruit.stock);
            }
        }
        System.out.println();

        System.out.println("该超市的肉类信息如下：");
        for (Goods.Meat meat : meats) {
            if (fruits.size() == 0) {
                System.out.println("暂无商品信息");
                break;
            } else {
                System.out.println("名字：" + meat.getName() + "  序号:" + meat.getSid() + "  价格" + meat.getPrice() + "  折扣" + meat.getDiscount() + "   库存" + meat.stock);
            }
        }
        System.out.println();

        System.out.println("该超市的蔬菜信息如下：");
        for (Goods.Vegetable vegetable : vegetables) {
            if (vegetables.size() == 0) {
                System.out.println("暂无商品信息");
                break;
            } else {
                System.out.println("名字：" + vegetable.getName() + "  序号:" + vegetable.getSid() + "  价格" + vegetable.getPrice() + "  折扣" + vegetable.getDiscount() + "   库存" + vegetable.stock);
            }
        }
        System.out.println();
    }
}
