public class SystemCompare
{
    // Voting
    public static SQ_States checkConsistency(double val1, double val2, double val3, double val4, double val5)
    {
        SQ_States ret = SQ_States.NO_ERROR;

        final int COUNT_ALL_CONSISTENT = 0;
        final int COUNT_ONE_INCONSISTENT = 4;

        int inconsistencies = 0;

        inconsistencies += val1 == val2 ? 0 : 1;
        inconsistencies += val1 == val3 ? 0 : 1;
        inconsistencies += val1 == val4 ? 0 : 1;
        inconsistencies += val1 == val5 ? 0 : 1;

        inconsistencies += val2 == val3 ? 0 : 1;
        inconsistencies += val2 == val4 ? 0 : 1;
        inconsistencies += val2 == val5 ? 0 : 1;

        inconsistencies += val3 == val4 ? 0 : 1;
        inconsistencies += val3 == val5 ? 0 : 1;

        inconsistencies += val4 == val5 ? 0 : 1;


        if (inconsistencies > COUNT_ALL_CONSISTENT)
        {
            if (inconsistencies == COUNT_ONE_INCONSISTENT)
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

    public enum SQ_States
    {
        NO_ERROR, ONE_ERROR, MULTIPLE_ERRORS;
    }
}