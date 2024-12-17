package Memory462084;
public class MemoryManagementDemo2 {
    static class Data {
        String info;

        Data(String info) {
            this.info = info;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Finalizing Data: " + info);
        }
    }

    public static void main(String[] args) {
        // Scenario 1: Using if-else to control object creation
        Data data1;
        int condition = 1;

        if (condition == 1) {
            data1 = new Data("Object 1 created");
            System.out.println(data1.info);
        } else {
            data1 = null;
        }

        // Scenario 2: Using a loop to create multiple objects
        for (int i = 0; i < 3; i++) {
            Data dataInLoop = new Data("Object in loop " + i);
            System.out.println(dataInLoop.info);
        }

        // Scenario 3: Using switch-case
        Data data2;
        int caseNum = 2;

        switch (caseNum) {
            case 1:
                data2 = new Data("Case 1 object");
                break;
            case 2:
                data2 = new Data("Case 2 object");
                break;
            default:
                data2 = null;
        }
        // Explicitly setting data2 to null to make it eligible for GC
        data2 = null;

        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}