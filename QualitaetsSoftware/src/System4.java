public class System4 extends ASystem {
    public System4(int numberOfComponents, double[] lambdaI) {
        super(numberOfComponents, lambdaI);
    }

    public double getRP() {
        double score = 0;
        score = getFP();
        score = 1 - score;
        return score;
    }


    public double getFP() {
        double score = 1;
        for (int i = 0; i < numberOfComponents; i++){
            double Ri = Math.pow(Math.E, (-lambdaI[i]*87600));
            score = score*(1-Ri);
        }
        return score;
    }
}
