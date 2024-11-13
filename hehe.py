class Calculator:
    

    def add(self, x, y):
        return x + y

    def subtract(self, x, y):
        return x - y

    def multiply(self, x, y):
        return x * y

    def divide(self, x, y):
        if y == 0:
            print("YOU CAN'T DIVIDE BY ZERO!")
            return None  
        else:
            return x / y

    def display_menu(self):
        print("SELECT OPERATION")
        print("1. ADD")
        print("2. SUBTRACTION")
        print("3. MULTIPLICATION")
        print("4. DIVISION")

    def get_choice(self):
        while True:
            choice1 = input("ENTER CHOICE (1|2|3|4): ")
            if choice1 in ('1', '2', '3', '4'):
                return choice1
            else:
                print("Invalid input. Please choose between 1, 2, 3, or 4.")

    def get_numbers(self):
        num1 = float(input("ENTER FIRST NUMBER: "))
        num2 = float(input("ENTER SECOND NUMBER: "))
        return num1, num2

    def run(self):
        while True:
            self.display_menu()
            choice1 = self.get_choice()
            num1, num2 = self.get_numbers()

            if choice1 == '1':
                result = self.add(num1, num2)
                print(f"The result of addition is: {result}")
            elif choice1 == '2':
                result = self.subtract(num1, num2)
                print(f"The result of subtraction is: {result}")
            elif choice1 == '3':
                result = self.multiply(num1, num2)
                print(f"The result of multiplication is: {result}")
            elif choice1 == '4':
                result = self.divide(num1, num2)
                if result is not None:
                    print(f"The result of division is: {result}")

            
            again = input("Do you want to perform another calculation? (1 for yes / 0 for no): ").lower()
            if again != '1':
                print("Exiting the calculator.")
                break


calc = Calculator()
calc.run()
