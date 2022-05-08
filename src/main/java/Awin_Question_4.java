public class Awin_Question_4 {
    public static void main(String[] args) {
        // Shel Duck type flies in high altitude
        Duck duck = new ShelDuck(); // output:  set fly behaviour: HighFlyBehaviour

        duck.eat();         // output: eating performed.
        duck.move();        // output: moving performed.
        duck.swim();        // output: swimming performed.
        duck.performFly();  // output: flying in high altitude performed

        // changing the behaviour during runtime
        duck.setFlyBehaviour(new NoFlyBehaviour()); // output: set fly behaviour: NoFlyBehaviour
        duck.performFly(); // output: flying not possible
    }
}

abstract class Animal {
    public void eat() {
        System.out.println("eating performed.");
    }

    public void move() {
        System.out.println("moving performed.");
    }
}

class Monkey extends Animal {
}

class Dolphin extends Animal implements SwimBehaviour {
    @Override
    public void swim() {
        SwimBehaviour.performSwim();
    }
}

class Bat extends Animal {
    FlyBehaviour flyBehaviour;

    public Bat() {
        setFlyBehaviour(new NightFlyBehaviour());
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void performedFly(){
        flyBehaviour.fly();
    }
}

class Penguin extends Animal implements SwimBehaviour {
    @Override
    public void swim() {
        SwimBehaviour.performSwim();
    }
}

abstract class Duck extends Animal implements SwimBehaviour {
    FlyBehaviour flyBehaviour;

    public Duck(FlyBehaviour flyBehaviour) {
        setFlyBehaviour(flyBehaviour);
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        System.out.println("set fly behaviour: " + flyBehaviour.getClass().getSimpleName());
        this.flyBehaviour = flyBehaviour;
    }

    @Override
    public void swim() {
        SwimBehaviour.performSwim();
    }

    public void performFly() {
        flyBehaviour.fly();
    }
}

class ShelDuck extends Duck {
    public ShelDuck() {
        super(new HighFlyBehaviour());
    }
}

interface SwimBehaviour {
    static void performSwim() {
        System.out.println("swimming performed.");
    }

    void swim();
}


interface FlyBehaviour {
    void fly();
}

class HighFlyBehaviour implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("flying in high altitude performed");
    }
}

class LowFlyBehaviour implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("flying in low altitude performed");
    }
}

class NoFlyBehaviour implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("flying not possible.");
    }
}


class NightFlyBehaviour implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("flying at night time performed");
    }
}