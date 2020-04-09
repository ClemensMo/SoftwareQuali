public class System3 extends ASystem{

    public System3(int numberOfComponents, double[] lambdaI) {
        super(numberOfComponents, lambdaI);
    }

    public double getRP(){
        double FP = this.getFP();
        double RP = 1 - FP;
        return RP;
    }

    public double getFP(){
        double interimResult=1;
        double euler = Math.E;
        for (int i = 0; i < lambdaI.length; i++) {
            double reliability = Math.pow(euler, (-lambdaI[i]*87600));
            double difference = 1 - reliability;
            interimResult  = interimResult * difference;
        }
        return interimResult;
    }
}