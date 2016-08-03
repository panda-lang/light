package net.dzikoysk.lightmc;

public class LightInitializer implements Runnable {

    private final Light light;

    public LightInitializer(Light light) {
        this.light = light;
    }

    @Override
    public void run() {

    }

    public Light getLight() {
        return light;
    }

}
