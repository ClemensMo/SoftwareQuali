import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        String valuesString[] = getValues();
        double inputValues[] = convertToDouble(valuesString);

        ASystem s1 = new System1(inputValues.length, inputValues);
        ASystem s2 = new System2(inputValues.length, inputValues);
        //ASystem s3 = new System1(inputValues.length, inputValues);

        //runSystems(s1, s2, s3);
    }

    public static void runSystems(ASystem s1, ASystem s2, ASystem s3)
    {
        double rp1 = s1.getRP();
        double rp2 = s2.getRP();
        double rp3 = s3.getRP();
        double fp1 = s1.getFP();
        double fp2 = s2.getFP();
        double fp3 = s3.getFP();

        SQ_States state = checkConsistency(rp1, rp2, rp3);

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

            default:
                System.out.println("Wtf m8");
        }
    }

    public static String[] getValues() throws IOException
    {
        String fileLocation = "data.csv";
        BufferedReader readCSV = new BufferedReader(new FileReader(fileLocation));
        String[] values = readCSV.readLine().split(",");
        readCSV.close();
        return values;
    }

    public static double[] convertToDouble(String values[])
    {
        int i = 0;
        double doubleValues[] = new double[values.length];
        for (String str : values)
        {
            doubleValues[i] = Double.valueOf(str);
            i++;
        }
        return doubleValues;
    }

    // Voting
    public static SQ_States checkConsistency(double val1, double val2, double val3)
    {
        // TODO account for number precision problems?

        SQ_States ret = SQ_States.NO_ERROR;

        if (!(val1 == val2 && val1 == val3))
        {
            if (val1 == val2 || val1 == val3 || val2 == val3)
            {
                ret = SQ_States.ONE_ERROR;
            }
            else
            {
                ret = SQ_States.MULTIPLE_ERRORS;
            }
        }

        return ret;
    }
}

enum SQ_States
{
    NO_ERROR, ONE_ERROR, MULTIPLE_ERRORS;
}