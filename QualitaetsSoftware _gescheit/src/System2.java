public class System2 extends ASystem {


    public System2(int numberOfComponents, double[] lambdaI) {
        super(numberOfComponents, lambdaI);
    }

    public double getRP() {
        double result = 0;
        result = getFP();
        result = 1 - result;
        return result;
    }

    public double getFP(){
        double result = 1;
        double e = Math.E;
        for (int i = 0; i < numberOfComponents; i++){
            double Ri = Math.pow(e, (-lambdaI[i]*87600));
            result = result*(1-Ri);
        }
        return result;
    }
}