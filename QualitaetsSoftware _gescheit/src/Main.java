import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        // String valuesString[] = getValues();
        double inputValues[] = getFloatValues();

        ASystem s1 = new System1(inputValues.length, inputValues);
        ASystem s2 = new System2(inputValues.length, inputValues);
        ASystem s3 = new System3(inputValues.length, inputValues);
        ASystem s4 = new System4(inputValues.length, inputValues);
        ASystem s5 = new System5(inputValues.length, inputValues);

        runSystems(s1, s2, s3, s4, s5);
    }

    public static void runSystems(ASystem s1, ASystem s2, ASystem s3, ASystem s4, ASystem s5)
    {
        double rp1 = s1.getRP();
        double rp2 = s2.getRP();
        double rp3 = s3.getRP();
        double rp4 = s4.getRP();
        double rp5 = s5.getRP();

        SystemCompare.SQ_States state = SystemCompare.checkConsistency(rp1, rp2, rp3, rp4, rp5);

        switch (state)
        {
            case NO_ERROR:
                System.out.println("No Error occured.");
                break;

            case ONE_ERROR:
                System.out.println("One Error occured.");
                break;

            case MULTIPLE_ERRORS:
                System.out.println("Multiple Errors occured.");
                break;
        }
    }

    // Sample data from csv file
    public static double[] getFloatValues()
    {
        double[] values = {0.00005, 0.000004, 0.00001, 0.000009, 0.00008};

        return values;
    }

    // Read sample data from csv file
    public static String[] getValues() throws IOException
    {
        String fileLocation = "data.csv";
        BufferedReader readCSV = new BufferedReader(new FileReader(fileLocation));
        String[] values = readCSV.readLine().split(",");
        readCSV.close();

        return values;
    }
}

