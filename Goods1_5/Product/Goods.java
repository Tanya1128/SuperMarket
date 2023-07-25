package javacode.Goods1_5.Product;

public abstract class Goods {
        //商品序号
        private int sid;
        //商品名字
        private String name;
        //商品价格
        private double price;
        //商品库存
        public int stock;

        public Goods(){
        }
        public Goods(int sid, String name, double price, int stock) {
            this.sid = sid;
            this.name = name;
            this.price = price;
            this.stock = stock;
        }

        public String getName() {
            return name;
        }
        public int getSid() {
            return sid;
        }
        public double getPrice() {
            return price;
        }
        public double getDiscount(){
            return 1;
        }

        //实现类：
        public static class Fruit extends Goods {
            public Fruit(){
            }
            public Fruit(int sid, String name, double price, int stock) {
                super(sid, name, price, stock);
            }

            @Override
            public double getDiscount() {
                return 0.7;
            }
        }

        public static class Vegetable extends Goods {
            public Vegetable(){
            }
            public Vegetable(int sid, String name, double price, int stock) {
                super(sid, name, price, stock);
            }

            @Override
            public double getDiscount() {
                return 0.8;
            }
        }

        public static class Meat extends Goods {
            public Meat(){
            }
            public Meat(int sid, String name, double price, int stock) {
                super(sid, name, price, stock);
            }

            @Override
            public double getDiscount() {
                return 0.75;
            }
        }
    }
