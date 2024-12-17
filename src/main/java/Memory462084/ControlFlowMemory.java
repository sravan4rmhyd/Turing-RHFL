package Memory462084;
public class ControlFlowMemory {
      public static class Car {
          private String make;

          public Car(String make) {
              this.make = make;
          }

          @Override
          protected void finalize() throws Throwable {
              System.out.println("Finalizing " + make + " car.");
              super.finalize();
          }
      }

      public static void main(String[] args) {
          createCarsWithIfElse();
          createCarsWithSwitch();
          createCarsWithLoop();
      }

      /*
       * If-else statement: The objects created within the else blocks will be eligible for garbage collection 
       * once the corresponding control path ends.
       */
      private static void createCarsWithIfElse() {
          System.out.println("\nCreating cars with if-else:");
          int condition = 1;

          if (condition == 1) {
              Car car1 = new Car("Toyota");
          } else {
              Car car2 = new Car("Honda");
          }

          if (condition == 2) {
              Car car3 = new Car("BMW");
          } else {
              Car car4 = new Car("Mercedes");
          }
      }

      /* 
       * Switch statement: Similar to if-else, objects created within specific cases will be eligible 
       * for garbage collection when the control path exits that case.
       */
      private static void createCarsWithSwitch() {
          System.out.println("\nCreating cars with switch:");
          int choice = 2;

          switch (choice) {
              case 1:
                  Car car5 = new Car("Ford");
                  break;
              case 2:
                  Car car6 = new Car("Audi");
                  break;
              default:
                  Car car7 = new Car("Chevrolet");
          }
      }

      /*
       * Loop statement: Objects created inside the loop will be eligible for garbage collection 
       * after the loop ends and there are no more references to them.
       */
      private static void createCarsWithLoop() {
          System.out.println("\nCreating cars with loop:");
          for (int i = 0; i < 2; i++) {
              Car car8 = new Car("Nissan" + (i + 1));
          }
      }
  }