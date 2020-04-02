public abstract class ASystem
{
    protected int numberOfComponents;
    protected double[] lambdaI;

    public ASystem(int numberOfComponents, double[] lambdaI)
    {
        this.numberOfComponents = numberOfComponents;
        this.lambdaI = lambdaI.clone();
    }

    public abstract double getRP();
    public abstract double getFP();
}
