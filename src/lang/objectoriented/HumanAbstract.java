package lang.objectoriented;

abstract class HumanAbstract {

    abstract public void eat();

    abstract public void sleep();

    public static void main(String[] args) {

        HumanAbstract h = new HumanAbstract() {
            @Override
            public void eat() {
                System.out.println("抽象类的匿名子类,重写父类eat方法");
            }

            @Override
            public void sleep() {
                System.out.println("抽象类的匿名子类,重写父类sleep方法");
            }
        };
        h.eat();
        h.sleep();
    }
}
