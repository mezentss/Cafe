abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

class Raf extends Beverage {
    public Raf() {
        description = "Раф";
    }
    public double cost() {
        return 250;
    }
}

class Latte extends Beverage {
    public Latte() {
        description = "Латте";
    }
    public double cost() {
        return 150;
    }
}

class Espresso extends Beverage {
    public Espresso() {
        description = "Эспрессо";
    }
    public double cost() {
        return 180;
    }
}

class Cappuccino extends Beverage {
    public Cappuccino() {
        description = "Каппучино";
    }
    public double cost() {
        return 155;
    }
}

//Декоратор
abstract class FlavoringDecorator extends Beverage {
    public abstract String getDescription();
}

class Whip extends FlavoringDecorator {
    Beverage beverage;
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Взбитые сливки";
    }
    public double cost() {
        return beverage.cost() + 50;
    }
}

class Milk extends FlavoringDecorator {
    Beverage beverage;
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Молоко";
    }
    public double cost() {
        return beverage.cost() + 40;
    }
}

class Soy extends FlavoringDecorator {
    Beverage beverage;
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Соя";
    }
    public double cost() {
        return beverage.cost() + 45;
    }
}

class Choco extends FlavoringDecorator {
    Beverage beverage;
    public Choco(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Шоколад";
    }
    public double cost() {
        return beverage.cost() + 50;
    }
}

public class Main {
    public static void main(String[] args) {
        Beverage raf = new Raf();
        System.out.println("Заказан напиток: " + raf.getDescription());
        System.out.println("Общая стоимость: " + raf.cost());

        Beverage cappuccino = new Cappuccino();
        cappuccino = new Milk(cappuccino);
        cappuccino = new Choco(cappuccino);
        System.out.println("Заказан напиток: " + cappuccino.getDescription());
        System.out.println("Общая стоимость: " + cappuccino.cost());
    }
}