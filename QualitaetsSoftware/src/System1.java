import static java.lang.Math.exp;

public class System1 extends ASystem{
    public System1(int numberOfComponents, double[] lambdaI) {
        super(numberOfComponents, lambdaI);
    }

    public double getRP(){
        double FP=this.getFP();
        return 1-FP;
    }

    public double getFP(){
        double res=1;
        for (int i = 0; i < lambdaI.length; i++) {
            double help = 1- exp(-lambdaI[i]*87600);
            res=res*help;
        }
        return res;
    }
}