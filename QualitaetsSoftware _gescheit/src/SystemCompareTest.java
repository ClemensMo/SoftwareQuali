import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SystemCompareTest
{
    @Test
    public void consistentSystemsTest() {
        // assert statements
        assertEquals(SystemCompare.SQ_States.NO_ERROR, SystemCompare.checkConsistency(0, 0, 0, 0, 0), "All 0 must return no errors");
        assertEquals(SystemCompare.SQ_States.NO_ERROR, SystemCompare.checkConsistency(-1, -1, -1, -1, -1), "All -1 must return no errors");
        assertEquals(SystemCompare.SQ_States.NO_ERROR, SystemCompare.checkConsistency(0.4, 0.4, 0.4, 0.4, 0.4), "All 0.4 must return no errors");
    }

    @Test
    public void InconsistentSystemsTest() {
        // assert statements
        assertEquals(SystemCompare.SQ_States.MULTIPLE_ERRORS, SystemCompare.checkConsistency(0, 1, 3, 0, 0), "Inconsistencies must return errors");
        assertEquals(SystemCompare.SQ_States.MULTIPLE_ERRORS, SystemCompare.checkConsistency(-1, -1, 1, 1, 1), "Inconsistencies must return errors");
        assertEquals(SystemCompare.SQ_States.MULTIPLE_ERRORS, SystemCompare.checkConsistency(0.4, 0.3, 0.2, 0.1, 0.05), "Inconsistencies must return errors");
    }

    @Test
    public void Inconsistent4oo5Test() {
        // assert statements
        assertEquals(SystemCompare.SQ_States.ONE_ERROR, SystemCompare.checkConsistency(1, 0, 0, 0, 0), "4oo5 must return one error");
        assertEquals(SystemCompare.SQ_States.ONE_ERROR, SystemCompare.checkConsistency(1, 0, 1, 1, 1), "4oo5 must return one error");
        assertEquals(SystemCompare.SQ_States.ONE_ERROR, SystemCompare.checkConsistency(-1, -1, 0, -1, -1), "4oo5 must return one error");
        assertEquals(SystemCompare.SQ_States.ONE_ERROR, SystemCompare.checkConsistency(0.4, 0.4, 0.4, 0.6, 0.4), "4oo5 must return one error");
        assertEquals(SystemCompare.SQ_States.ONE_ERROR, SystemCompare.checkConsistency(0.4, 0.4, 0.4, 0.4, 0.4000001), "4oo5 must return one error");
    }
}