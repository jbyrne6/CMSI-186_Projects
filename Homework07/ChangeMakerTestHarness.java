public class ChangeMakerTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Euros(); // 1,2,5,10,20,50
        test_USA();
        test_Notebook();
        test_Notebook2();
        // Add more!
        // A few examples:
        //
        test_SwissFrancs(); // 5,10,20,50 (NO 1 CENT COIN!)
        test_SwissFrancs2();
        test_Keckels(); // 7,3,29,15,53 (Made-up currency with non-standard denominations)
        test_lozOotRupee();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void test_Euros() {
        int[] eurosDenominations = new int[] { 10, 50, 5, 1, 20, 2 };

        Tuple result = ChangeMaker.makeChangeWithDynamicProgramming(eurosDenominations, 147);
        try {
            displaySuccessIfTrue(0 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void test_USA() {
        int[] usaDenominations = new int[] { 25, 5, 1, 10 };

        Tuple result = ChangeMaker.makeChangeWithDynamicProgramming(usaDenominations, 99);
        try {
            displaySuccessIfTrue(3 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(4 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void test_Notebook() {
        int[] notebookDenominations = new int[] { 2, 3};

        Tuple result = ChangeMaker.makeChangeWithDynamicProgramming(notebookDenominations, 6);
        try {
            displaySuccessIfTrue(0 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

    }

    public static void test_Notebook2() {
        int[] notebook2Denominations = new int[] { 8, 3, 5};

        Tuple result = ChangeMaker.makeChangeWithDynamicProgramming(notebook2Denominations, 11);
        try {
            displaySuccessIfTrue(1 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

    }

    public static void test_SwissFrancs() {
        int[] swissfrancsDenominations = new int[] { 5, 10, 20, 50 };

        Tuple result = ChangeMaker.makeChangeWithDynamicProgramming(swissfrancsDenominations, 444);
        try {
            displaySuccessIfTrue(result == Tuple.IMPOSSIBLE);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void test_SwissFrancs2() {
        int[] swissfrancs2Denominations = new int[] { 5, 10, 20, 50 };

        Tuple result = ChangeMaker.makeChangeWithDynamicProgramming(swissfrancs2Denominations, 235);
        try {
            displaySuccessIfTrue(1 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(4 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void test_Keckels() {
        int[] test_Keckels = new int[] { 7, 3, 29, 15, 53 };

        Tuple result = ChangeMaker.makeChangeWithDynamicProgramming(test_Keckels, 100);
        try {
            displaySuccessIfTrue(0 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void test_lozOotRupee() {
        int[] test_lozOotRupee = new int[] { 1, 5, 20, 50, 200 };

        Tuple result = ChangeMaker.makeChangeWithDynamicProgramming(test_lozOotRupee, 500);
        try {
            displaySuccessIfTrue(0 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }
}
