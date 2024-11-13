#OOP : CONVERT EXISTING CALCULATOR INTO CLASS BASE CALCULATOR
#create a class name calculator
class calculator:
    def __init__(self, a, b):
        self.a = a
        self.b = b
    
    def addition(self):
        print(self.a+self.b)
    def subtraction(self):
        print(self.a-self.b)
    def multiplication(self):
        print(self.a*self.b)
    def division(self):
        print(self.a/self.b)

a = int(input("Enter first number: ")) #take inputs from user and create an object
b = int(input("Enter second number: ")) #a and b from the attribute of
obj = calculator(a, b)

choice = 1
while choice !=0:
  print ("1: ADD")
  print ("2: SUB")
  print ("3: MUL")
  print ("4: DIV")
  print ("5: QUIT")
  choice = int(input("Enter your choice: "))
  if choice ==1:
    print(obj.addition())
  elif choice ==2:
    print(obj.subtraction())
  elif choice ==3:
    print(obj.multiplication())
  elif choice ==4:
    print(obj.division())
  elif choice ==5:
    print("PROGRAM END")
    choice = 0
  else:
    print("invalid choice")
