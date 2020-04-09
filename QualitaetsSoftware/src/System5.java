public class System5 extends ASystem {

    private double fp;

    public System5(int numberOfComponents, double[] lambdaI) {
        super(numberOfComponents, lambdaI);
        calcFP();
    }

    @Override
    public double getRP() {
        return this.fp;
    }

    @Override
    public double getFP() {
        return 1 - this.fp;
    }

    private void calcFP() {
        double e = Math.E;
        for (int i = 0; i < lambdaI.length; i++) {
            double rel = Math.pow(e, (-lambdaI[i]*87600));
            double diff = 1 - rel;
            fp  = fp * diff;
        }
    }
}
